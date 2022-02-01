package com.unionpay.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public class UPUtils
{
  public static String a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207325);
    paramContext = b(paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0).getString(paramString, ""), ("00000000" + "23456789abcdef12123456786789abcd").substring(0, 32));
    if (paramContext == null)
    {
      AppMethodBeat.o(207325);
      return "";
    }
    if (!paramContext.endsWith("00000000"))
    {
      AppMethodBeat.o(207325);
      return "";
    }
    paramContext = paramContext.substring(0, paramContext.length() - "00000000".length());
    AppMethodBeat.o(207325);
    return paramContext;
  }
  
  public static String a(String paramString)
  {
    AppMethodBeat.i(207356);
    try
    {
      paramString = paramString.getBytes();
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.reset();
      localMessageDigest.update(paramString);
      paramString = a.a(localMessageDigest.digest());
      AppMethodBeat.o(207356);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(207356);
    }
    return null;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207341);
    try
    {
      paramString1 = paramString1.getBytes("utf-8");
      paramString1 = a.a(d.d(1, a.a(paramString2), paramString1));
      AppMethodBeat.o(207341);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(207341);
    }
    return "";
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207304);
    String str = ("00000000" + "23456789abcdef12123456786789abcd").substring(0, 32);
    str = a(paramString1 + "00000000", str);
    paramString1 = str;
    if (str == null) {
      paramString1 = "";
    }
    paramContext = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
    paramContext.putString(paramString2, paramString1);
    paramContext.commit();
    AppMethodBeat.o(207304);
  }
  
  private static String b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207348);
    try
    {
      paramString1 = new String(d.d(0, a.a(paramString2), a.a(paramString1)), "utf-8").trim();
      AppMethodBeat.o(207348);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(207348);
    }
    return "";
  }
  
  public static void b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(207331);
    paramContext = paramContext.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
    paramContext.remove(paramString);
    paramContext.commit();
    AppMethodBeat.o(207331);
  }
  
  public static native String forConfig(int paramInt, String paramString);
  
  public static native String forUrl(int paramInt);
  
  public static native String forWap(int paramInt, String paramString);
  
  public static native String getIssuer(int paramInt);
  
  public static native String getSubject(int paramInt);
  
  public static native String getTalkingDataIdForAssist(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.unionpay.utils.UPUtils
 * JD-Core Version:    0.7.0.1
 */