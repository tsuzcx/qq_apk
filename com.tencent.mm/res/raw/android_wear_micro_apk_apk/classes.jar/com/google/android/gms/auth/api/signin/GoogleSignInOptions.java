package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.b;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInOptions
  extends zza
  implements e, ReflectedParcelable
{
  public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new c();
  private static Comparator<Scope> GB = new Comparator() {};
  public static final Scope GC = new Scope("profile");
  public static final Scope GD = new Scope("email");
  public static final Scope GE = new Scope("openid");
  public static final Scope GF = new Scope("https://www.googleapis.com/auth/games");
  public static final GoogleSignInOptions GG = new a().gf().gg().gh();
  public static final GoogleSignInOptions GH = new a().a(GF, new Scope[0]).gh();
  private final ArrayList<Scope> GI;
  private Account GJ;
  private boolean GK;
  private final boolean GL;
  private final boolean GM;
  private String GN;
  private String GO;
  private ArrayList<zzg> GP;
  private Map<Integer, zzg> GQ;
  final int versionCode;
  
  GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, ArrayList<zzg> paramArrayList1)
  {
    this(paramInt, paramArrayList, paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString1, paramString2, i(paramArrayList1));
  }
  
  private GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, Map<Integer, zzg> paramMap)
  {
    this.versionCode = paramInt;
    this.GI = paramArrayList;
    this.GJ = paramAccount;
    this.GK = paramBoolean1;
    this.GL = paramBoolean2;
    this.GM = paramBoolean3;
    this.GN = paramString1;
    this.GO = paramString2;
    this.GP = new ArrayList(paramMap.values());
    this.GQ = paramMap;
  }
  
  public static GoogleSignInOptions h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    HashSet localHashSet = new HashSet();
    paramString = localJSONObject.getJSONArray("scopes");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      localHashSet.add(new Scope(paramString.getString(i)));
      i += 1;
    }
    paramString = localJSONObject.optString("accountName", null);
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = new Account(paramString, "com.google");; paramString = null) {
      return new GoogleSignInOptions(3, new ArrayList(localHashSet), paramString, localJSONObject.getBoolean("idTokenRequested"), localJSONObject.getBoolean("serverAuthRequested"), localJSONObject.getBoolean("forceCodeForRefreshToken"), localJSONObject.optString("serverClientId", null), localJSONObject.optString("hostedDomain", null), new HashMap());
    }
  }
  
  private static Map<Integer, zzg> i(List<zzg> paramList)
  {
    HashMap localHashMap = new HashMap();
    if (paramList == null) {
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      zzg localzzg = (zzg)paramList.next();
      localHashMap.put(Integer.valueOf(localzzg.getType()), localzzg);
    }
    return localHashMap;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramObject = (GoogleSignInOptions)paramObject;
        if ((this.GP.size() > 0) || (paramObject.GP.size() > 0) || (this.GI.size() != paramObject.fW().size()) || (!this.GI.containsAll(paramObject.fW()))) {
          continue;
        }
        if (this.GJ == null)
        {
          if (paramObject.GJ != null) {
            continue;
          }
          label76:
          if (!TextUtils.isEmpty(this.GN)) {
            break label148;
          }
          if (!TextUtils.isEmpty(paramObject.GN)) {
            continue;
          }
        }
        while ((this.GM == paramObject.GM) && (this.GK == paramObject.GK) && (this.GL == paramObject.GL))
        {
          return true;
          if (!this.GJ.equals(paramObject.GJ)) {
            break;
          }
          break label76;
          label148:
          boolean bool = this.GN.equals(paramObject.GN);
          if (!bool) {
            break;
          }
        }
        return false;
      }
      catch (ClassCastException paramObject) {}
    }
  }
  
  public final ArrayList<Scope> fW()
  {
    return new ArrayList(this.GI);
  }
  
  public final Account fX()
  {
    return this.GJ;
  }
  
  public final boolean fY()
  {
    return this.GK;
  }
  
  public final boolean fZ()
  {
    return this.GL;
  }
  
  public final boolean ga()
  {
    return this.GM;
  }
  
  public final String gb()
  {
    return this.GN;
  }
  
  public final String gd()
  {
    return this.GO;
  }
  
  public final ArrayList<zzg> ge()
  {
    return this.GP;
  }
  
  public int hashCode()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.GI.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Scope)localIterator.next()).gE());
    }
    Collections.sort(localArrayList);
    return new b().r(localArrayList).r(this.GJ).r(this.GN).u(this.GM).u(this.GK).u(this.GL).gi();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInOptions
 * JD-Core Version:    0.7.0.1
 */