package com.tencent.mm.storage;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j.b;
import com.tencent.mm.loader.i.b;
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

public final class at
{
  public static String acHq;
  public static final String acHr;
  public static final String acHs;
  public static final String acHt;
  private static HashMap<String, Long> acHu;
  
  static
  {
    AppMethodBeat.i(133287);
    acHq = b.bmr();
    acHr = MMApplicationContext.getContext().getFilesDir() + "/xlog";
    acHs = MMApplicationContext.getContext().getFilesDir() + "/liteapp";
    acHt = WeChatHosts.domainString(j.b.host_login_weixin_qq_com);
    HashMap localHashMap = new HashMap();
    acHu = localHashMap;
    localHashMap.put("@all.android", Long.valueOf(1L));
    acHu.put("@chatroom", Long.valueOf(2L));
    acHu.put("@im.chatroom", Long.valueOf(4L));
    acHu.put("@chatroom_exclusive", Long.valueOf(8L));
    acHu.put("@talkroom", Long.valueOf(16L));
    acHu.put("@lbsroom", Long.valueOf(32L));
    acHu.put("@groupcard", Long.valueOf(64L));
    acHu.put("@micromsg.qq.com", Long.valueOf(128L));
    acHu.put("@t.qq.com", Long.valueOf(256L));
    acHu.put("@t.sina.com", Long.valueOf(512L));
    acHu.put("@qqim", Long.valueOf(1024L));
    acHu.put("@bottle", Long.valueOf(2048L));
    acHu.put("@qr", Long.valueOf(4096L));
    acHu.put("@fb", Long.valueOf(8192L));
    acHu.put("@google", Long.valueOf(16384L));
    acHu.put("@app", Long.valueOf(32768L));
    acHu.put("@openim", Long.valueOf(65536L));
    acHu.put("@finder", Long.valueOf(131072L));
    acHu.put("@findermsgstranger", Long.valueOf(262144L));
    acHu.put("@findermsg", Long.valueOf(524288L));
    acHu.put("@gamelife", Long.valueOf(1048576L));
    acHu.put("@gamelifesess", Long.valueOf(2097152L));
    acHu.put("@gamelifehistory", Long.valueOf(4194304L));
    acHu.put("@ad", Long.valueOf(8388608L));
    acHu.put("@stranger", Long.valueOf(16777216L));
    if (CrashReportFactory.hasDebuger()) {
      Assert.assertTrue(iZz());
    }
    AppMethodBeat.o(133287);
  }
  
  public static boolean bvN(String paramString)
  {
    AppMethodBeat.i(248538);
    if ((paramString != null) && (paramString.endsWith("findermsg")))
    {
      AppMethodBeat.o(248538);
      return true;
    }
    AppMethodBeat.o(248538);
    return false;
  }
  
  public static boolean bvO(String paramString)
  {
    AppMethodBeat.i(248544);
    if ((paramString != null) && (paramString.endsWith("statussquaremsg")))
    {
      AppMethodBeat.o(248544);
      return true;
    }
    AppMethodBeat.o(248544);
    return false;
  }
  
  public static boolean bvP(String paramString)
  {
    AppMethodBeat.i(248548);
    if ((paramString != null) && (paramString.endsWith("gamelifesess")))
    {
      AppMethodBeat.o(248548);
      return true;
    }
    AppMethodBeat.o(248548);
    return false;
  }
  
  public static long bvQ(String paramString)
  {
    AppMethodBeat.i(248556);
    String str = "";
    if ((paramString == null) || (paramString.length() <= 0)) {
      Log.e("MicroMsg.ConstantsStorage", "calculateReverseUserName failed");
    }
    for (;;)
    {
      Log.d("MicroMsg.ConstantsStorage", "calculateUserNameFlag key:%s, username:%s", new Object[] { str, paramString });
      if (!acHu.containsKey(str)) {
        break;
      }
      long l = ((Long)acHu.get(str)).longValue();
      AppMethodBeat.o(248556);
      return l;
      if (paramString.contains("@")) {
        str = paramString.substring(paramString.indexOf("@"));
      }
    }
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(248556);
      return 33554432L;
    }
    AppMethodBeat.o(248556);
    return 0L;
  }
  
  private static final String bvR(String paramString)
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
  
  private static final boolean iZA()
  {
    AppMethodBeat.i(133285);
    ArrayList localArrayList = new ArrayList(at.a.values().length);
    at.a[] arrayOfa = at.a.values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfa[i];
      if ((localObject == null) || (((at.a)localObject).name() == null))
      {
        Log.e("MicroMsg.ConstantsStorage", "BusinessInfoKey check error: info is null!!!");
        AppMethodBeat.o(133285);
        return false;
      }
      localObject = bvR(((at.a)localObject).name());
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
  
  private static final boolean iZz()
  {
    AppMethodBeat.i(133284);
    Field[] arrayOfField = at.class.getDeclaredFields();
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
    if (localSparseArray.size() > 516)
    {
      Log.e("MicroMsg.ConstantsStorage", "constants values size(%d) is over the limit(%d)!!!", new Object[] { Integer.valueOf(localSparseArray.size()), Integer.valueOf(516) });
      AppMethodBeat.o(133284);
      return false;
    }
    Log.i("MicroMsg.ConstantsStorage", "checkDuplicateUserInfo values size: %d", new Object[] { Integer.valueOf(localSparseArray.size()) });
    boolean bool = iZA();
    AppMethodBeat.o(133284);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.at
 * JD-Core Version:    0.7.0.1
 */