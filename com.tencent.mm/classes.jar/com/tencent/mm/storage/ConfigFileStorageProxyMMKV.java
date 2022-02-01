package com.tencent.mm.storage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ConfigFileStorageProxyMMKV
{
  private final long acHb;
  private final long acHc;
  boolean acHd;
  private String acHe;
  MultiProcessMMKV eMf;
  private String fileName;
  
  public ConfigFileStorageProxyMMKV(String paramString)
  {
    AppMethodBeat.i(133240);
    this.acHb = 600L;
    this.acHc = 2L;
    if (paramString == null)
    {
      AppMethodBeat.o(133240);
      return;
    }
    boolean bool1 = TextUtils.equals(com.tencent.mm.plugin.expt.e.d.dNI().a("clicfg_app_brand_storage_to_mmkv_switch", "1", false, false), "1");
    if (!bool1) {
      ayR(26);
    }
    boolean bool2 = MultiProcessMMKV.getMMKV("MMKVForStorageProxy_COMMAND_TAG").getBoolean("MMKVForStorageProxy_COMMAND_KEY", false);
    Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "proxySwitch commandSwitch is [%b], xSwitch is [%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    int i;
    if ((bool1) || (bool2))
    {
      i = 1;
      if (i == 0) {
        break label219;
      }
      if (!TextUtils.isEmpty(paramString)) {
        break label153;
      }
      bool1 = false;
      if (!bool1) {
        break label219;
      }
    }
    label153:
    label219:
    for (bool1 = true;; bool1 = false)
    {
      this.acHd = bool1;
      if (this.acHd) {
        break label224;
      }
      AppMethodBeat.o(133240);
      return;
      i = 0;
      break;
      localObject = new u(paramString).getName();
      if ((!TextUtils.equals((CharSequence)localObject, "MM_stepcounter.cfg")) && (!TextUtils.equals((CharSequence)localObject, "PUSH_stepcounter.cfg"))) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "selectFile name is %s, returnVal is %b", new Object[] { localObject, Boolean.valueOf(bool1) });
        break;
      }
    }
    label224:
    Object localObject = new u(paramString);
    String str = ah.v(((u)localObject).jKT());
    if (!TextUtils.equals(str, paramString)) {
      Log.w("MicroMsg.ConfigFileStorageProxyMMKV", "path is [%s], canonicalpath is [%s]", new Object[] { paramString, str });
    }
    if (!((u)localObject).jKS())
    {
      ayR(43);
      a(str, false, 0L, 0L, 0L, null, null, null, 43, true);
    }
    this.acHe = str;
    this.eMf = MultiProcessMMKV.getSingleMMKV(this.acHe);
    AppMethodBeat.o(133240);
  }
  
  private void a(String paramString1, boolean paramBoolean1, long paramLong1, long paramLong2, long paramLong3, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(133252);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str = paramString1;
    boolean bool = paramBoolean1;
    if (TextUtils.isEmpty(paramString1))
    {
      localObject1 = localObject2;
      str = paramString1;
      bool = paramBoolean1;
      if (!TextUtils.isEmpty(this.acHe))
      {
        str = this.acHe;
        localObject1 = new u(str);
        bool = ((u)localObject1).jKS();
      }
    }
    paramString1 = str;
    if (TextUtils.isEmpty(str)) {
      paramString1 = "null";
    }
    long l = paramLong1;
    if (paramLong1 == 0L)
    {
      l = paramLong1;
      if (localObject1 != null) {
        l = ((u)localObject1).lastModified() / 1000L;
      }
    }
    str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "null";
    }
    paramString3 = paramString4;
    if (paramString4 == null) {
      paramString3 = "null";
    }
    try
    {
      Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "reportKVData [%s]", new Object[] { String.format("%s,%s,%d,%d,%d,%s,%s,%s,%d,%s,%s", new Object[] { paramString1, String.valueOf(bool), Long.valueOf(l), Long.valueOf(paramLong2), Long.valueOf(paramLong3), str, paramString2, paramString3, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2), MMApplicationContext.getProcessName() }) });
      AppMethodBeat.o(133252);
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", paramString1, "reportKVData error", new Object[0]);
      AppMethodBeat.o(133252);
    }
  }
  
  private void c(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(133250);
    a(null, false, paramLong1, paramLong2, paramLong3, null, null, null, paramInt, false);
    AppMethodBeat.o(133250);
  }
  
  private boolean cE(Map<Integer, Object> paramMap)
  {
    boolean bool2 = false;
    for (;;)
    {
      long l2;
      long l1;
      boolean bool1;
      long l3;
      try
      {
        AppMethodBeat.i(133244);
        if ((this.eMf != null) && (paramMap.size() != this.eMf.count()))
        {
          Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "compareV2 size mmkv:%d, cfg:%d", new Object[] { Long.valueOf(this.eMf.count()), Integer.valueOf(paramMap.size()) });
          if ((paramMap.containsKey(Integer.valueOf(100001))) && (!this.eMf.containsKey(Integer.toString(100001))))
          {
            Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "compareV2 mmkv not contain md time key");
            ayR(21);
            ea(21, null);
            if (this.eMf.count() != 0L)
            {
              ayR(22);
              ea(22, null);
            }
          }
          if (this.eMf.count() != 0L)
          {
            ayR(25);
            ea(25, null);
          }
        }
        l2 = amW(100001);
        Object localObject = paramMap.get(Integer.valueOf(100001));
        if (!(localObject instanceof Long)) {
          break label848;
        }
        l1 = ((Long)localObject).longValue();
        if (l2 == l1)
        {
          bool1 = true;
          Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "compareV2 time compare result is [%b], mmkvTime is [%s], size:%d, storageTime is [%s], size:[%d]", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l2), Long.valueOf(this.eMf.count()), Long.valueOf(l1), Integer.valueOf(paramMap.size()) });
          if (l2 != l1) {
            break label633;
          }
          if (l2 != 0L) {
            continue;
          }
          if (this.eMf != null)
          {
            l1 = this.eMf.count();
            Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "mmkv has no data, mmkv:%d, cfg:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramMap.size()) });
            cG(paramMap);
            bool1 = bool2;
            localObject = ChannelUtil.formatVersion(MMApplicationContext.getContext(), com.tencent.mm.protocal.d.Yxh, true);
            paramMap.put(Integer.valueOf(100003), localObject);
            B(100003, localObject);
            if (!this.eMf.containsKey(Integer.toString(100001)))
            {
              l1 = System.currentTimeMillis() / 1000L;
              paramMap.put(Integer.valueOf(100001), Long.valueOf(l1));
              B(100001, Long.valueOf(l1));
              ayR(30);
              ea(30, null);
            }
            AppMethodBeat.o(133244);
            return bool1;
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        l1 = 0L;
        continue;
        l3 = 2L + new u(this.acHe).lastModified() / 1000L;
        if (l3 < l2) {
          break label612;
        }
        if (l3 - l2 >= 600L)
        {
          cG(paramMap);
          ayR(2);
          c(2, l3, l1, l2);
          l1 = System.currentTimeMillis() / 1000L;
          paramMap.put(Integer.valueOf(100001), Long.valueOf(l1));
          B(100001, Long.valueOf(l1));
          bool1 = bool2;
          continue;
        }
        bool1 = bool2;
      }
      finally {}
      if (cF(paramMap))
      {
        ayR(3);
        c(3, l3, l1, l2);
        cG(paramMap);
        continue;
        label612:
        ayR(1);
        c(1, l3, l1, l2);
        bool1 = bool2;
        continue;
        label633:
        l3 = 2L + new u(this.acHe).lastModified() / 1000L;
        if (l1 < l2)
        {
          if (l3 >= l2)
          {
            if (l3 - l2 >= 600L)
            {
              if (cF(paramMap))
              {
                ayR(13);
                c(13, l3, l1, l2);
              }
              for (;;)
              {
                cG(paramMap);
                bool1 = false;
                break;
                ayR(14);
                c(14, l3, l1, l2);
              }
            }
            ayR(15);
            c(15, l3, l1, l2);
            cH(paramMap);
            bool1 = true;
          }
          else
          {
            ayR(12);
            c(12, l3, l1, l2);
            cH(paramMap);
            bool1 = true;
          }
        }
        else
        {
          cG(paramMap);
          if ((l2 == 0L) && (l1 > 0L)) {
            ayR(7);
          }
          for (;;)
          {
            c(11, l3, l1, l2);
            bool1 = false;
            break;
            ayR(11);
          }
          label848:
          l1 = 0L;
        }
      }
    }
  }
  
  private static boolean cF(Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(133245);
    String str = ChannelUtil.formatVersion(MMApplicationContext.getContext(), com.tencent.mm.protocal.d.Yxh, true);
    paramMap = paramMap.get(Integer.valueOf(100003));
    if ((paramMap instanceof String)) {}
    for (paramMap = (String)paramMap;; paramMap = "0")
    {
      if (TextUtils.equals(paramMap, "0"))
      {
        AppMethodBeat.o(133245);
        return false;
      }
      if (!TextUtils.equals(str, paramMap))
      {
        AppMethodBeat.o(133245);
        return true;
      }
      AppMethodBeat.o(133245);
      return false;
    }
  }
  
  private void cG(Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(133246);
    if ((paramMap == null) || (this.eMf == null))
    {
      AppMethodBeat.o(133246);
      return;
    }
    this.eMf.clear();
    Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "storageCoverMMKV storage size:[%d]", new Object[] { Integer.valueOf(paramMap.size()) });
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      B(((Integer)localEntry.getKey()).intValue(), localEntry.getValue());
    }
    AppMethodBeat.o(133246);
  }
  
  private String getFileName()
  {
    AppMethodBeat.i(133241);
    if (TextUtils.isEmpty(this.acHe))
    {
      AppMethodBeat.o(133241);
      return "";
    }
    if (TextUtils.isEmpty(this.fileName)) {
      this.fileName = new u(this.acHe).getName();
    }
    String str = this.fileName;
    AppMethodBeat.o(133241);
    return str;
  }
  
  public final void B(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(133253);
    if (this.eMf == null)
    {
      AppMethodBeat.o(133253);
      return;
    }
    String str1 = String.valueOf(paramInt);
    ConfigFileStorageProxyMMKV.MMKVTypeObject localMMKVTypeObject;
    Object localObject2;
    String str2;
    Object localObject3;
    if (paramObject != null)
    {
      localObject1 = paramObject.getClass().getSimpleName();
      localMMKVTypeObject = new ConfigFileStorageProxyMMKV.MMKVTypeObject((String)localObject1, paramObject);
      boolean bool = this.eMf.encode(str1, localMMKVTypeObject);
      localObject2 = d(paramInt, null);
      if (!bool)
      {
        ayR(18);
        ea(18, str1);
        Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "write data fail");
      }
      if (localObject2 == null)
      {
        str2 = localMMKVTypeObject.type;
        localObject3 = localMMKVTypeObject.object;
        if (paramObject == null) {
          break label284;
        }
      }
    }
    label284:
    for (Object localObject1 = paramObject;; localObject1 = "null")
    {
      Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "innerObject set get data null, type:[%s], obj:[%s], key:[%s], value:[%s]", new Object[] { str2, localObject3, str1, localObject1 });
      Log.printInfoStack("MicroMsg.ConfigFileStorageProxyMMKV", "innerObject stack", new Object[0]);
      if (paramObject != null)
      {
        ayR(23);
        ea(23, null);
      }
      if ((ConfigFileStorageProxyMMKV.MMKVTypeObject)this.eMf.decodeParcelable(str1, ConfigFileStorageProxyMMKV.MMKVTypeObject.class) == null)
      {
        Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "get mmkv value again, value is null");
        ayR(33);
        ea(33, str1);
      }
      if ((paramObject != null) && (!paramObject.equals(localObject2)))
      {
        ayR(20);
        ea(20, str1);
        Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "set get data not equal, type:%s", new Object[] { localMMKVTypeObject.type });
      }
      AppMethodBeat.o(133253);
      return;
      localObject1 = "null";
      break;
    }
  }
  
  public final long amW(int paramInt)
  {
    AppMethodBeat.i(248511);
    Object localObject = d(paramInt, Long.valueOf(0L));
    if ((localObject instanceof Long))
    {
      long l = ((Long)localObject).longValue();
      AppMethodBeat.o(248511);
      return l;
    }
    AppMethodBeat.o(248511);
    return 0L;
  }
  
  public final void ayR(int paramInt)
  {
    AppMethodBeat.i(133248);
    try
    {
      Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "compareV2 reportData, case is [%s], filename:[%s]", new Object[] { Integer.valueOf(paramInt), getFileName() });
      Log.printInfoStack("MicroMsg.ConfigFileStorageProxyMMKV", "reportIDKeyData stack", new Object[0]);
      f.Ozc.idkeyStat(1041L, paramInt, 1L, false);
      AppMethodBeat.o(133248);
      return;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", localThrowable, "reportIDKeyData error", new Object[0]);
      AppMethodBeat.o(133248);
    }
  }
  
  /* Error */
  public final boolean cC(Map<Integer, Object> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 408
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +15 -> 24
    //   12: iconst_0
    //   13: istore_2
    //   14: ldc_w 408
    //   17: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_2
    //   23: ireturn
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial 410	com/tencent/mm/storage/ConfigFileStorageProxyMMKV:cE	(Ljava/util/Map;)Z
    //   29: istore_2
    //   30: ldc_w 408
    //   33: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: goto -16 -> 20
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	ConfigFileStorageProxyMMKV
    //   0	44	1	paramMap	Map<Integer, Object>
    //   13	17	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	39	finally
    //   14	20	39	finally
    //   24	36	39	finally
  }
  
  public final void cD(Map<Integer, Object> paramMap)
  {
    try
    {
      AppMethodBeat.i(133243);
      long l = System.currentTimeMillis() / 1000L;
      paramMap.put(Integer.valueOf(100001), Long.valueOf(l));
      B(100001, Long.valueOf(l));
      if ((this.eMf != null) && (paramMap.size() != this.eMf.count()))
      {
        ayR(24);
        ea(24, null);
      }
      AppMethodBeat.o(133243);
      return;
    }
    finally {}
  }
  
  public final void cH(Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(133247);
    if ((this.eMf == null) || (paramMap == null))
    {
      AppMethodBeat.o(133247);
      return;
    }
    Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "mmKVCoverStorage storage size:[%d]", new Object[] { Integer.valueOf(paramMap.size()) });
    paramMap.clear();
    String[] arrayOfString = this.eMf.allKeys();
    if ((arrayOfString == null) || (arrayOfString.length == 0))
    {
      AppMethodBeat.o(133247);
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = arrayOfString[i];
        try
        {
          int k = Util.safeParseInt((String)localObject);
          localObject = (ConfigFileStorageProxyMMKV.MMKVTypeObject)this.eMf.decodeParcelable((String)localObject, ConfigFileStorageProxyMMKV.MMKVTypeObject.class);
          if (localObject != null)
          {
            paramMap.put(Integer.valueOf(k), ((ConfigFileStorageProxyMMKV.MMKVTypeObject)localObject).object);
          }
          else
          {
            Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "get mmkv value is null，get value fail");
            ayR(32);
            ea(32, null);
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          Log.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", localNumberFormatException, "NumberFormatException", new Object[0]);
        }
      }
      else
      {
        AppMethodBeat.o(133247);
        return;
      }
      i += 1;
    }
  }
  
  public final Object d(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(133254);
    if (this.eMf == null)
    {
      Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "get mmkv is null ,return default val");
      ayR(31);
      ea(31, null);
      AppMethodBeat.o(133254);
      return paramObject;
    }
    ConfigFileStorageProxyMMKV.MMKVTypeObject localMMKVTypeObject = (ConfigFileStorageProxyMMKV.MMKVTypeObject)this.eMf.decodeParcelable(String.valueOf(paramInt), ConfigFileStorageProxyMMKV.MMKVTypeObject.class);
    if (localMMKVTypeObject != null)
    {
      paramObject = localMMKVTypeObject.object;
      AppMethodBeat.o(133254);
      return paramObject;
    }
    Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "get mmkv value is null，get value fail");
    ayR(32);
    ea(32, null);
    AppMethodBeat.o(133254);
    return paramObject;
  }
  
  public final void ea(int paramInt, String paramString)
  {
    AppMethodBeat.i(133249);
    a(null, false, 0L, 0L, 0L, paramString, null, null, paramInt, true);
    AppMethodBeat.o(133249);
  }
  
  public final void i(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(133251);
    a(null, false, 0L, 0L, 0L, paramString1, paramString2, paramString3, paramInt, false);
    AppMethodBeat.o(133251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.ConfigFileStorageProxyMMKV
 * JD-Core Version:    0.7.0.1
 */