package com.tencent.mm.storage;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j.b;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import junit.framework.Assert;

public final class ar
{
  public static String Vgb;
  public static final String Vgc;
  public static final String Vgd;
  public static final String Vge;
  private static HashMap<String, Long> Vgf;
  
  static
  {
    AppMethodBeat.i(133287);
    Vgb = b.aSD();
    Vgc = MMApplicationContext.getContext().getFilesDir() + "/xlog";
    Vgd = MMApplicationContext.getContext().getFilesDir() + "/liteapp";
    Vge = WeChatHosts.domainString(j.b.host_login_weixin_qq_com);
    HashMap localHashMap = new HashMap();
    Vgf = localHashMap;
    localHashMap.put("@all.android", Long.valueOf(1L));
    Vgf.put("@chatroom", Long.valueOf(2L));
    Vgf.put("@im.chatroom", Long.valueOf(4L));
    Vgf.put("@chatroom_exclusive", Long.valueOf(8L));
    Vgf.put("@talkroom", Long.valueOf(16L));
    Vgf.put("@lbsroom", Long.valueOf(32L));
    Vgf.put("@groupcard", Long.valueOf(64L));
    Vgf.put("@micromsg.qq.com", Long.valueOf(128L));
    Vgf.put("@t.qq.com", Long.valueOf(256L));
    Vgf.put("@t.sina.com", Long.valueOf(512L));
    Vgf.put("@qqim", Long.valueOf(1024L));
    Vgf.put("@bottle", Long.valueOf(2048L));
    Vgf.put("@qr", Long.valueOf(4096L));
    Vgf.put("@fb", Long.valueOf(8192L));
    Vgf.put("@google", Long.valueOf(16384L));
    Vgf.put("@app", Long.valueOf(32768L));
    Vgf.put("@openim", Long.valueOf(65536L));
    Vgf.put("@finder", Long.valueOf(131072L));
    Vgf.put("@findermsgstranger", Long.valueOf(262144L));
    Vgf.put("@findermsg", Long.valueOf(524288L));
    Vgf.put("@gamelife", Long.valueOf(1048576L));
    Vgf.put("@gamelifesess", Long.valueOf(2097152L));
    Vgf.put("@gamelifehistory", Long.valueOf(4194304L));
    Vgf.put("@ad", Long.valueOf(8388608L));
    Vgf.put("@stranger", Long.valueOf(16777216L));
    if (CrashReportFactory.hasDebuger()) {
      Assert.assertTrue(hxU());
    }
    AppMethodBeat.o(133287);
  }
  
  public static boolean bvD(String paramString)
  {
    AppMethodBeat.i(212095);
    if ((paramString != null) && (paramString.endsWith("findermsg")))
    {
      AppMethodBeat.o(212095);
      return true;
    }
    AppMethodBeat.o(212095);
    return false;
  }
  
  public static boolean bvE(String paramString)
  {
    AppMethodBeat.i(212097);
    if ((paramString != null) && (paramString.endsWith("gamelifesess")))
    {
      AppMethodBeat.o(212097);
      return true;
    }
    AppMethodBeat.o(212097);
    return false;
  }
  
  public static long bvF(String paramString)
  {
    AppMethodBeat.i(212100);
    String str = "";
    if ((paramString == null) || (paramString.length() <= 0)) {
      Log.e("MicroMsg.ConstantsStorage", "calculateReverseUserName failed");
    }
    for (;;)
    {
      Log.d("MicroMsg.ConstantsStorage", "calculateUserNameFlag key:%s, username:%s", new Object[] { str, paramString });
      if (!Vgf.containsKey(str)) {
        break;
      }
      long l = ((Long)Vgf.get(str)).longValue();
      AppMethodBeat.o(212100);
      return l;
      if (paramString.contains("@")) {
        str = paramString.substring(paramString.indexOf("@"));
      }
    }
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(212100);
      return 33554432L;
    }
    AppMethodBeat.o(212100);
    return 0L;
  }
  
  private static final String bvG(String paramString)
  {
    AppMethodBeat.i(133286);
    String[] arrayOfString = paramString.split("_");
    if ((arrayOfString == null) || (arrayOfString.length < 4))
    {
      if (arrayOfString == null) {}
      for (i = -1;; i = arrayOfString.length)
      {
        Log.e("MicroMsg.ConstantsStorage", "BusinessInfoKey parse failed: key:%s split by '_'  fileds len too short : %d , at least 4", new Object[] { paramString, Integer.valueOf(i) });
        AppMethodBeat.o(133286);
        return null;
      }
    }
    int i = 0;
    while (i < arrayOfString.length)
    {
      if ((arrayOfString[i] == null) || (arrayOfString[i].length() <= 0))
      {
        Log.e("MicroMsg.ConstantsStorage", "BusinessInfoKey parse failed: name:%s , [%s] too short ( <1 ) ", new Object[] { paramString, arrayOfString[i] });
        AppMethodBeat.o(133286);
        return null;
      }
      i += 1;
    }
    int j = arrayOfString.length - 1;
    String str2 = arrayOfString[j];
    i = j;
    String str1 = str2;
    if (str2.equals("SYNC"))
    {
      i = j - 1;
      str1 = arrayOfString[i];
    }
    if (i < 3)
    {
      if (arrayOfString == null) {
        i = -1;
      }
      Log.e("MicroMsg.ConstantsStorage", "BusinessInfoKey parse failed: name:%s split by '_'  fileds len too short : %d , at least 3", new Object[] { paramString, Integer.valueOf(i) });
    }
    if ((!str1.equals("INT")) && (!str1.equals("LONG")) && (!str1.equals("STRING")) && (!str1.equals("BOOLEAN")) && (!str1.equals("FLOAT")) && (!str1.equals("DOUBLE")))
    {
      Log.e("MicroMsg.ConstantsStorage", "BusinessInfoKey parse failed: name[%s], invalid type:%s ", new Object[] { paramString, str1 });
      AppMethodBeat.o(133286);
      return null;
    }
    paramString = paramString.substring(0, paramString.lastIndexOf(str1) - 1);
    AppMethodBeat.o(133286);
    return paramString;
  }
  
  private static final boolean hxU()
  {
    AppMethodBeat.i(133284);
    Field[] arrayOfField = ar.class.getDeclaredFields();
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfField.length) {
        break label233;
      }
      Field localField = arrayOfField[i];
      if ((Modifier.isStatic(localField.getModifiers())) && ((localField.getName().startsWith("USERINFO_")) || (localField.getName().startsWith("NEW_BANDAGE_")) || (localField.getName().startsWith("DYNAMIC_CONFIG_"))) && (localField.getType().toString().equals("int"))) {}
      try
      {
        int j = localField.getInt(null);
        if (localSparseArray.get(j, null) != null)
        {
          Log.e("MicroMsg.ConstantsStorage", "%s and %s has same value(0x%05X)!!!", new Object[] { localSparseArray.get(j), localField.getName(), Integer.valueOf(j) });
          AppMethodBeat.o(133284);
          return false;
        }
        localSparseArray.put(j, localField.getName());
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          Log.e("MicroMsg.ConstantsStorage", "exception:%s", new Object[] { Util.stackTraceToString(localIllegalArgumentException) });
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          Log.e("MicroMsg.ConstantsStorage", "exception:%s", new Object[] { Util.stackTraceToString(localIllegalAccessException) });
        }
      }
      i += 1;
    }
    label233:
    if (localSparseArray.size() > 515)
    {
      Log.e("MicroMsg.ConstantsStorage", "constants values size(%d) is over the limit(%d)!!!", new Object[] { Integer.valueOf(localSparseArray.size()), Integer.valueOf(515) });
      AppMethodBeat.o(133284);
      return false;
    }
    Log.i("MicroMsg.ConstantsStorage", "checkDuplicateUserInfo values size: %d", new Object[] { Integer.valueOf(localSparseArray.size()) });
    boolean bool = hxV();
    AppMethodBeat.o(133284);
    return bool;
  }
  
  private static final boolean hxV()
  {
    AppMethodBeat.i(133285);
    ArrayList localArrayList = new ArrayList(ar.a.values().length);
    ar.a[] arrayOfa = ar.a.values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfa[i];
      if ((localObject == null) || (((ar.a)localObject).name() == null))
      {
        Log.e("MicroMsg.ConstantsStorage", "BusinessInfoKey check error: info is null!!!");
        AppMethodBeat.o(133285);
        return false;
      }
      localObject = bvG(((ar.a)localObject).name());
      if (Util.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(133285);
        return false;
      }
      if (localArrayList.contains(localObject))
      {
        Log.e("MicroMsg.ConstantsStorage", "BusinessInfoKey check error: redefinition of [%s] which already defined!", new Object[] { localObject });
        AppMethodBeat.o(133285);
        return false;
      }
      localArrayList.add(localObject);
      i += 1;
    }
    AppMethodBeat.o(133285);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.ar
 * JD-Core Version:    0.7.0.1
 */