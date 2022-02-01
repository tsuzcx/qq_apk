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
  private static Comparator<Scope> Iq = new Comparator() {};
  public static final Scope Ir = new Scope("profile");
  public static final Scope Is = new Scope("email");
  public static final Scope It = new Scope("openid");
  public static final Scope Iu = new Scope("https://www.googleapis.com/auth/games");
  public static final GoogleSignInOptions Iv = new a().gp().gq().gr();
  public static final GoogleSignInOptions Iw = new a().a(Iu, new Scope[0]).gr();
  private final boolean IA;
  private final boolean IB;
  private String IC;
  private String ID;
  private ArrayList<zzg> IE;
  private Map<Integer, zzg> IF;
  private final ArrayList<Scope> Ix;
  private Account Iy;
  private boolean Iz;
  final int versionCode;
  
  GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, ArrayList<zzg> paramArrayList1)
  {
    this(paramInt, paramArrayList, paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString1, paramString2, i(paramArrayList1));
  }
  
  private GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, Map<Integer, zzg> paramMap)
  {
    this.versionCode = paramInt;
    this.Ix = paramArrayList;
    this.Iy = paramAccount;
    this.Iz = paramBoolean1;
    this.IA = paramBoolean2;
    this.IB = paramBoolean3;
    this.IC = paramString1;
    this.ID = paramString2;
    this.IE = new ArrayList(paramMap.values());
    this.IF = paramMap;
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
        if ((this.IE.size() > 0) || (paramObject.IE.size() > 0) || (this.Ix.size() != paramObject.gh().size()) || (!this.Ix.containsAll(paramObject.gh()))) {
          continue;
        }
        if (this.Iy == null)
        {
          if (paramObject.Iy != null) {
            continue;
          }
          label76:
          if (!TextUtils.isEmpty(this.IC)) {
            break label148;
          }
          if (!TextUtils.isEmpty(paramObject.IC)) {
            continue;
          }
        }
        while ((this.IB == paramObject.IB) && (this.Iz == paramObject.Iz) && (this.IA == paramObject.IA))
        {
          return true;
          if (!this.Iy.equals(paramObject.Iy)) {
            break;
          }
          break label76;
          label148:
          boolean bool = this.IC.equals(paramObject.IC);
          if (!bool) {
            break;
          }
        }
        return false;
      }
      catch (ClassCastException paramObject) {}
    }
  }
  
  public final ArrayList<Scope> gh()
  {
    return new ArrayList(this.Ix);
  }
  
  public final Account gi()
  {
    return this.Iy;
  }
  
  public final boolean gj()
  {
    return this.Iz;
  }
  
  public final boolean gk()
  {
    return this.IA;
  }
  
  public final boolean gl()
  {
    return this.IB;
  }
  
  public final String gm()
  {
    return this.IC;
  }
  
  public final String gn()
  {
    return this.ID;
  }
  
  public final ArrayList<zzg> go()
  {
    return this.IE;
  }
  
  public int hashCode()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Ix.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Scope)localIterator.next()).gO());
    }
    Collections.sort(localArrayList);
    return new b().A(localArrayList).A(this.Iy).A(this.IC).x(this.IB).x(this.Iz).x(this.IA).gs();
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