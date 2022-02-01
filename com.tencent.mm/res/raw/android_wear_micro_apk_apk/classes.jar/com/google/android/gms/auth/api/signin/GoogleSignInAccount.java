package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new b();
  public static e Ie = f.ic();
  private static Comparator<Scope> Iq = new Comparator() {};
  private String If;
  private String Ig;
  private String Ih;
  private String Ii;
  private Uri Ij;
  private String Ik;
  private long Il;
  private String Im;
  List<Scope> In;
  private String Io;
  private String Ip;
  final int versionCode;
  
  GoogleSignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, String paramString5, long paramLong, String paramString6, List<Scope> paramList, String paramString7, String paramString8)
  {
    this.versionCode = paramInt;
    this.If = paramString1;
    this.Ig = paramString2;
    this.Ih = paramString3;
    this.Ii = paramString4;
    this.Ij = paramUri;
    this.Ik = paramString5;
    this.Il = paramLong;
    this.Im = paramString6;
    this.In = paramList;
    this.Io = paramString7;
    this.Ip = paramString8;
  }
  
  public static GoogleSignInAccount g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    paramString = null;
    Object localObject = localJSONObject.optString("photoUrl", null);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = Uri.parse((String)localObject);
    }
    long l = Long.parseLong(localJSONObject.getString("expirationTime"));
    HashSet localHashSet = new HashSet();
    localObject = localJSONObject.getJSONArray("grantedScopes");
    int j = ((JSONArray)localObject).length();
    int i = 0;
    while (i < j)
    {
      localHashSet.add(new Scope(((JSONArray)localObject).getString(i)));
      i += 1;
    }
    String str1 = localJSONObject.optString("id");
    String str2 = localJSONObject.optString("tokenId", null);
    String str3 = localJSONObject.optString("email", null);
    String str4 = localJSONObject.optString("displayName", null);
    String str5 = localJSONObject.optString("givenName", null);
    String str6 = localJSONObject.optString("familyName", null);
    localObject = Long.valueOf(l);
    String str7 = localJSONObject.getString("obfuscatedIdentifier");
    if (localObject == null) {
      localObject = Long.valueOf(Ie.currentTimeMillis() / 1000L);
    }
    for (;;)
    {
      paramString = new GoogleSignInAccount(3, str1, str2, str3, str4, paramString, null, ((Long)localObject).longValue(), d.l(str7), new ArrayList((Collection)d.D(localHashSet)), str5, str6);
      paramString.Ik = localJSONObject.optString("serverAuthCode", null);
      return paramString;
    }
  }
  
  private JSONObject gg()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.If != null) {
        localJSONObject.put("id", this.If);
      }
      if (this.Ig != null) {
        localJSONObject.put("tokenId", this.Ig);
      }
      if (this.Ih != null) {
        localJSONObject.put("email", this.Ih);
      }
      if (this.Ii != null) {
        localJSONObject.put("displayName", this.Ii);
      }
      if (this.Io != null) {
        localJSONObject.put("givenName", this.Io);
      }
      if (this.Ip != null) {
        localJSONObject.put("familyName", this.Ip);
      }
      if (this.Ij != null) {
        localJSONObject.put("photoUrl", this.Ij.toString());
      }
      if (this.Ik != null) {
        localJSONObject.put("serverAuthCode", this.Ik);
      }
      localJSONObject.put("expirationTime", this.Il);
      localJSONObject.put("obfuscatedIdentifier", this.Im);
      JSONArray localJSONArray = new JSONArray();
      Collections.sort(this.In, Iq);
      Iterator localIterator = this.In.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Scope)localIterator.next()).gO());
      }
      localJSONException.put("grantedScopes", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    return localJSONException;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GoogleSignInAccount)) {
      return false;
    }
    return ((GoogleSignInAccount)paramObject).gg().toString().equals(gg().toString());
  }
  
  public final String fX()
  {
    return this.Ig;
  }
  
  public final String fY()
  {
    return this.Ih;
  }
  
  public final String fZ()
  {
    return this.Io;
  }
  
  public final String ga()
  {
    return this.Ip;
  }
  
  public final Uri gb()
  {
    return this.Ij;
  }
  
  public final String gd()
  {
    return this.Ik;
  }
  
  public final long ge()
  {
    return this.Il;
  }
  
  public final String getDisplayName()
  {
    return this.Ii;
  }
  
  public final String getId()
  {
    return this.If;
  }
  
  public final String gf()
  {
    return this.Im;
  }
  
  public int hashCode()
  {
    return gg().toString().hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInAccount
 * JD-Core Version:    0.7.0.1
 */