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
  private static Comparator<Scope> GB = new Comparator() {};
  public static e Gp = f.hU();
  private String GA;
  private String Gq;
  private String Gr;
  private String Gs;
  private String Gt;
  private Uri Gu;
  private String Gv;
  private long Gw;
  private String Gx;
  List<Scope> Gy;
  private String Gz;
  final int versionCode;
  
  GoogleSignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, String paramString5, long paramLong, String paramString6, List<Scope> paramList, String paramString7, String paramString8)
  {
    this.versionCode = paramInt;
    this.Gq = paramString1;
    this.Gr = paramString2;
    this.Gs = paramString3;
    this.Gt = paramString4;
    this.Gu = paramUri;
    this.Gv = paramString5;
    this.Gw = paramLong;
    this.Gx = paramString6;
    this.Gy = paramList;
    this.Gz = paramString7;
    this.GA = paramString8;
  }
  
  private JSONObject fV()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.Gq != null) {
        localJSONObject.put("id", this.Gq);
      }
      if (this.Gr != null) {
        localJSONObject.put("tokenId", this.Gr);
      }
      if (this.Gs != null) {
        localJSONObject.put("email", this.Gs);
      }
      if (this.Gt != null) {
        localJSONObject.put("displayName", this.Gt);
      }
      if (this.Gz != null) {
        localJSONObject.put("givenName", this.Gz);
      }
      if (this.GA != null) {
        localJSONObject.put("familyName", this.GA);
      }
      if (this.Gu != null) {
        localJSONObject.put("photoUrl", this.Gu.toString());
      }
      if (this.Gv != null) {
        localJSONObject.put("serverAuthCode", this.Gv);
      }
      localJSONObject.put("expirationTime", this.Gw);
      localJSONObject.put("obfuscatedIdentifier", this.Gx);
      JSONArray localJSONArray = new JSONArray();
      Collections.sort(this.Gy, GB);
      Iterator localIterator = this.Gy.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Scope)localIterator.next()).gE());
      }
      localJSONException.put("grantedScopes", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    return localJSONException;
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
      localObject = Long.valueOf(Gp.currentTimeMillis() / 1000L);
    }
    for (;;)
    {
      paramString = new GoogleSignInAccount(3, str1, str2, str3, str4, paramString, null, ((Long)localObject).longValue(), d.l(str7), new ArrayList((Collection)d.u(localHashSet)), str5, str6);
      paramString.Gv = localJSONObject.optString("serverAuthCode", null);
      return paramString;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GoogleSignInAccount)) {
      return false;
    }
    return ((GoogleSignInAccount)paramObject).fV().toString().equals(fV().toString());
  }
  
  public final String fN()
  {
    return this.Gr;
  }
  
  public final String fO()
  {
    return this.Gs;
  }
  
  public final String fP()
  {
    return this.Gz;
  }
  
  public final String fQ()
  {
    return this.GA;
  }
  
  public final Uri fR()
  {
    return this.Gu;
  }
  
  public final String fS()
  {
    return this.Gv;
  }
  
  public final long fT()
  {
    return this.Gw;
  }
  
  public final String fU()
  {
    return this.Gx;
  }
  
  public final String getDisplayName()
  {
    return this.Gt;
  }
  
  public final String getId()
  {
    return this.Gq;
  }
  
  public int hashCode()
  {
    return fV().toString().hashCode();
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