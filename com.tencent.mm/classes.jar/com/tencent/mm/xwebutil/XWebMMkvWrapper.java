package com.tencent.mm.xwebutil;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.xweb.ISharedPreferenceProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class XWebMMkvWrapper
  implements SharedPreferences, SharedPreferences.Editor
{
  MultiProcessMMKV mSp;
  
  public XWebMMkvWrapper(MultiProcessMMKV paramMultiProcessMMKV)
  {
    this.mSp = paramMultiProcessMMKV;
  }
  
  public static SharedPreferences getMMKV(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(220768);
    paramContext = b.ZaS.F(paramString, paramInt, paramBoolean);
    AppMethodBeat.o(220768);
    return paramContext;
  }
  
  public void apply()
  {
    AppMethodBeat.i(152941);
    this.mSp.apply();
    AppMethodBeat.o(152941);
  }
  
  public SharedPreferences.Editor clear()
  {
    AppMethodBeat.i(152939);
    SharedPreferences.Editor localEditor = this.mSp.clear();
    AppMethodBeat.o(152939);
    return localEditor;
  }
  
  public boolean commit()
  {
    AppMethodBeat.i(152940);
    boolean bool = this.mSp.commit();
    AppMethodBeat.o(152940);
    return bool;
  }
  
  public boolean contains(String paramString)
  {
    AppMethodBeat.i(152928);
    boolean bool = this.mSp.contains(paramString);
    AppMethodBeat.o(152928);
    return bool;
  }
  
  public SharedPreferences.Editor edit()
  {
    AppMethodBeat.i(152929);
    SharedPreferences.Editor localEditor = this.mSp.edit();
    AppMethodBeat.o(152929);
    return localEditor;
  }
  
  public Map<String, ?> getAll()
  {
    AppMethodBeat.i(152921);
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = this.mSp.allKeys();
    if (arrayOfString == null)
    {
      AppMethodBeat.o(152921);
      return localHashMap;
    }
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localHashMap.put(arrayOfString[i], "");
      i += 1;
    }
    AppMethodBeat.o(152921);
    return localHashMap;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(152927);
    paramBoolean = this.mSp.getBoolean(paramString, paramBoolean);
    AppMethodBeat.o(152927);
    return paramBoolean;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(152926);
    paramFloat = this.mSp.getFloat(paramString, paramFloat);
    AppMethodBeat.o(152926);
    return paramFloat;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(152924);
    paramInt = this.mSp.getInt(paramString, paramInt);
    AppMethodBeat.o(152924);
    return paramInt;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(152925);
    paramLong = this.mSp.getLong(paramString, paramLong);
    AppMethodBeat.o(152925);
    return paramLong;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152922);
    paramString1 = this.mSp.getString(paramString1, paramString2);
    AppMethodBeat.o(152922);
    return paramString1;
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(152923);
    paramString = this.mSp.getStringSet(paramString, paramSet);
    AppMethodBeat.o(152923);
    return paramString;
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(152937);
    paramString = this.mSp.putBoolean(paramString, paramBoolean);
    AppMethodBeat.o(152937);
    return paramString;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(152936);
    paramString = this.mSp.putFloat(paramString, paramFloat);
    AppMethodBeat.o(152936);
    return paramString;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(152934);
    paramString = this.mSp.putInt(paramString, paramInt);
    AppMethodBeat.o(152934);
    return paramString;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(152935);
    paramString = this.mSp.putLong(paramString, paramLong);
    AppMethodBeat.o(152935);
    return paramString;
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152932);
    paramString1 = this.mSp.putString(paramString1, paramString2);
    AppMethodBeat.o(152932);
    return paramString1;
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(152933);
    paramString = this.mSp.putStringSet(paramString, paramSet);
    AppMethodBeat.o(152933);
    return paramString;
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    AppMethodBeat.i(152930);
    this.mSp.registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
    AppMethodBeat.o(152930);
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    AppMethodBeat.i(152938);
    paramString = this.mSp.remove(paramString);
    AppMethodBeat.o(152938);
    return paramString;
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    AppMethodBeat.i(152931);
    this.mSp.unregisterOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
    AppMethodBeat.o(152931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.xwebutil.XWebMMkvWrapper
 * JD-Core Version:    0.7.0.1
 */