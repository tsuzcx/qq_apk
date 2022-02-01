package com.tencent.mm.ui.mmfb.sdk;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;

public class CustomTabLoginMethodHandler
  extends WebLoginMethodHandler
{
  public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR;
  public static boolean afyD;
  private String afyE;
  private String afyF;
  private String afyG;
  
  static
  {
    AppMethodBeat.i(250200);
    afyD = false;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(250200);
  }
  
  CustomTabLoginMethodHandler(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(250190);
    this.afyG = "";
    this.afyF = paramParcel.readString();
    AppMethodBeat.o(250190);
  }
  
  public CustomTabLoginMethodHandler(LoginClient paramLoginClient)
  {
    super(paramLoginClient);
    AppMethodBeat.i(250177);
    this.afyG = "";
    this.afyF = new BigInteger(100, new Random()).toString(32);
    afyD = false;
    this.afyG = "fb290293790992170://authorize";
    AppMethodBeat.o(250177);
  }
  
  private static LoginClient.Request a(Collection<String> paramCollection, String[] paramArrayOfString)
  {
    AppMethodBeat.i(250183);
    paramCollection.clear();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramCollection.add(paramArrayOfString[i]);
      i += 1;
    }
    paramCollection = new LoginClient.Request(k.afzu, Collections.unmodifiableSet(new HashSet(paramCollection)), d.afyK, "rerequest", "290293790992170", UUID.randomUUID().toString());
    paramCollection.afzR = AccessToken.jBM();
    AppMethodBeat.o(250183);
    return paramCollection;
  }
  
  public static Uri f(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(250195);
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("https");
    localBuilder.authority(paramString1);
    localBuilder.path(paramString2);
    if (paramBundle != null)
    {
      paramString1 = paramBundle.keySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        Object localObject = paramBundle.get(paramString2);
        if ((localObject instanceof String)) {
          localBuilder.appendQueryParameter(paramString2, (String)localObject);
        }
      }
    }
    paramString1 = localBuilder.build();
    AppMethodBeat.o(250195);
    return paramString1;
  }
  
  public static Map<String, String> v(Parcel paramParcel)
  {
    AppMethodBeat.i(250186);
    int j = paramParcel.readInt();
    if (j < 0)
    {
      AppMethodBeat.o(250186);
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < j)
    {
      localHashMap.put(paramParcel.readString(), paramParcel.readString());
      i += 1;
    }
    AppMethodBeat.o(250186);
    return localHashMap;
  }
  
  public final int a(Activity paramActivity, String[] paramArrayOfString)
  {
    int j = 0;
    AppMethodBeat.i(250219);
    Object localObject1 = new ArrayList();
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      ((Collection)localObject1).add(paramArrayOfString[i]);
      i += 1;
    }
    localObject1 = a((Collection)localObject1, paramArrayOfString);
    Object localObject2 = new Bundle();
    paramArrayOfString = ((LoginClient.Request)localObject1).afyp;
    if (paramArrayOfString != null)
    {
      i = j;
      if (paramArrayOfString.size() != 0) {}
    }
    else
    {
      i = 1;
    }
    if (i == 0)
    {
      paramArrayOfString = TextUtils.join(",", ((LoginClient.Request)localObject1).afyp);
      ((Bundle)localObject2).putString("scope", paramArrayOfString);
      if (this.afAd == null) {
        this.afAd = new HashMap();
      }
      Map localMap = this.afAd;
      if (paramArrayOfString == null)
      {
        paramArrayOfString = null;
        localMap.put("scope", paramArrayOfString);
      }
    }
    else
    {
      ((Bundle)localObject2).putString("default_audience", "friends");
      ((Bundle)localObject2).putString("state", new JSONObject().toString());
      ((Bundle)localObject2).putString("cbt", String.valueOf(System.currentTimeMillis()));
      ((Bundle)localObject2).putString("ies", "0");
      paramArrayOfString = a((Bundle)localObject2, (LoginClient.Request)localObject1);
      localObject1 = new Intent();
      ((Intent)localObject1).setClassName(paramActivity, "com.tencent.mm.plugin.account.ui.CustomTabMainActivity");
      ((Intent)localObject1).putExtra(f.afyQ, "oauth");
      ((Intent)localObject1).putExtra(f.afyR, paramArrayOfString);
      localObject2 = f.afyS;
      if (this.afyE == null) {
        break label336;
      }
    }
    for (paramArrayOfString = this.afyE;; paramArrayOfString = this.afyE)
    {
      ((Intent)localObject1).putExtra((String)localObject2, paramArrayOfString);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(101, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject1).aYi(), "com/tencent/mm/ui/mmfb/sdk/CustomTabLoginMethodHandler", "tryAuthorize", "(Landroid/app/Activity;[Ljava/lang/String;)I", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(250219);
      return 1;
      paramArrayOfString = paramArrayOfString.toString();
      break;
      label336:
      this.afyE = c.jBP();
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected final String jBN()
  {
    return this.afyG;
  }
  
  protected final String jBO()
  {
    return "chrome_custom_tab";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(250233);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.afyF);
    AppMethodBeat.o(250233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.mmfb.sdk.CustomTabLoginMethodHandler
 * JD-Core Version:    0.7.0.1
 */