package com.tencent.mm.storage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ConfigFileStorageProxyMMKV
{
  private final long VfM;
  private final long VfN;
  boolean VfO;
  private String VfP;
  MultiProcessMMKV cQO;
  private String fileName;
  
  public ConfigFileStorageProxyMMKV(String paramString)
  {
    AppMethodBeat.i(133240);
    this.VfM = 600L;
    this.VfN = 2L;
    if (paramString == null)
    {
      AppMethodBeat.o(133240);
      return;
    }
    boolean bool1 = TextUtils.equals(com.tencent.mm.plugin.expt.h.d.dgX().a("clicfg_app_brand_storage_to_mmkv_switch", "1", false, false), "1");
    if (!bool1) {
      asC(26);
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
      this.VfO = bool1;
      if (this.VfO) {
        break label224;
      }
      AppMethodBeat.o(133240);
      return;
      i = 0;
      break;
      localObject = new q(paramString).getName();
      if ((!TextUtils.equals((CharSequence)localObject, "MM_stepcounter.cfg")) && (!TextUtils.equals((CharSequence)localObject, "PUSH_stepcounter.cfg"))) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "selectFile name is %s, returnVal is %b", new Object[] { localObject, Boolean.valueOf(bool1) });
        break;
      }
    }
    label224:
    Object localObject = new q(paramString);
    String str = ((q)localObject).bOF();
    if (!TextUtils.equals(str, paramString)) {
      Log.w("MicroMsg.ConfigFileStorageProxyMMKV", "path is [%s], canonicalpath is [%s]", new Object[] { paramString, str });
    }
    if (!((q)localObject).ifE())
    {
      asC(43);
      a(str, false, 0L, 0L, 0L, null, null, null, 43, true);
    }
    this.VfP = str;
    this.cQO = MultiProcessMMKV.getSingleMMKV(this.VfP);
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
      if (!TextUtils.isEmpty(this.VfP))
      {
        str = this.VfP;
        localObject1 = new q(str);
        bool = ((q)localObject1).ifE();
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
        l = ((q)localObject1).lastModified() / 1000L;
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
  
  private boolean cg(Map<Integer, Object> paramMap)
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
        if ((this.cQO != null) && (paramMap.size() != this.cQO.count()))
        {
          Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "compareV2 size mmkv:%d, cfg:%d", new Object[] { Long.valueOf(this.cQO.count()), Integer.valueOf(paramMap.size()) });
          if ((paramMap.containsKey(Integer.valueOf(100001))) && (!this.cQO.containsKey(Integer.toString(100001))))
          {
            Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "compareV2 mmkv not contain md time key");
            asC(21);
            di(21, null);
            if (this.cQO.count() != 0L)
            {
              asC(22);
              di(22, null);
            }
          }
          if (this.cQO.count() != 0L)
          {
            asC(25);
            di(25, null);
          }
        }
        l2 = ahV(100001);
        Object localObject = paramMap.get(Integer.valueOf(100001));
        if (!(localObject instanceof Long)) {
          break label848;
        }
        l1 = ((Long)localObject).longValue();
        if (l2 == l1)
        {
          bool1 = true;
          Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "compareV2 time compare result is [%b], mmkvTime is [%s], size:%d, storageTime is [%s], size:[%d]", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l2), Long.valueOf(this.cQO.count()), Long.valueOf(l1), Integer.valueOf(paramMap.size()) });
          if (l2 != l1) {
            break label633;
          }
          if (l2 != 0L) {
            continue;
          }
          if (this.cQO != null)
          {
            l1 = this.cQO.count();
            Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "mmkv has no data, mmkv:%d, cfg:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramMap.size()) });
            ci(paramMap);
            bool1 = bool2;
            localObject = ChannelUtil.formatVersion(MMApplicationContext.getContext(), com.tencent.mm.protocal.d.RAD, true);
            paramMap.put(Integer.valueOf(100003), localObject);
            i(100003, localObject);
            if (!this.cQO.containsKey(Integer.toString(100001)))
            {
              l1 = System.currentTimeMillis() / 1000L;
              paramMap.put(Integer.valueOf(100001), Long.valueOf(l1));
              i(100001, Long.valueOf(l1));
              asC(30);
              di(30, null);
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
        l3 = 2L + new q(this.VfP).lastModified() / 1000L;
        if (l3 < l2) {
          break label612;
        }
        if (l3 - l2 >= 600L)
        {
          ci(paramMap);
          asC(2);
          c(2, l3, l1, l2);
          l1 = System.currentTimeMillis() / 1000L;
          paramMap.put(Integer.valueOf(100001), Long.valueOf(l1));
          i(100001, Long.valueOf(l1));
          bool1 = bool2;
          continue;
        }
        bool1 = bool2;
      }
      finally {}
      if (ch(paramMap))
      {
        asC(3);
        c(3, l3, l1, l2);
        ci(paramMap);
        continue;
        label612:
        asC(1);
        c(1, l3, l1, l2);
        bool1 = bool2;
        continue;
        label633:
        l3 = 2L + new q(this.VfP).lastModified() / 1000L;
        if (l1 < l2)
        {
          if (l3 >= l2)
          {
            if (l3 - l2 >= 600L)
            {
              if (ch(paramMap))
              {
                asC(13);
                c(13, l3, l1, l2);
              }
              for (;;)
              {
                ci(paramMap);
                bool1 = false;
                break;
                asC(14);
                c(14, l3, l1, l2);
              }
            }
            asC(15);
            c(15, l3, l1, l2);
            cj(paramMap);
            bool1 = true;
          }
          else
          {
            asC(12);
            c(12, l3, l1, l2);
            cj(paramMap);
            bool1 = true;
          }
        }
        else
        {
          ci(paramMap);
          if ((l2 == 0L) && (l1 > 0L)) {
            asC(7);
          }
          for (;;)
          {
            c(11, l3, l1, l2);
            bool1 = false;
            break;
            asC(11);
          }
          label848:
          l1 = 0L;
        }
      }
    }
  }
  
  private static boolean ch(Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(133245);
    String str = ChannelUtil.formatVersion(MMApplicationContext.getContext(), com.tencent.mm.protocal.d.RAD, true);
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
  
  private void ci(Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(133246);
    if ((paramMap == null) || (this.cQO == null))
    {
      AppMethodBeat.o(133246);
      return;
    }
    this.cQO.clear();
    Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "storageCoverMMKV storage size:[%d]", new Object[] { Integer.valueOf(paramMap.size()) });
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      i(((Integer)localEntry.getKey()).intValue(), localEntry.getValue());
    }
    AppMethodBeat.o(133246);
  }
  
  private String getFileName()
  {
    AppMethodBeat.i(133241);
    if (TextUtils.isEmpty(this.VfP))
    {
      AppMethodBeat.o(133241);
      return "";
    }
    if (TextUtils.isEmpty(this.fileName)) {
      this.fileName = new q(this.VfP).getName();
    }
    String str = this.fileName;
    AppMethodBeat.o(133241);
    return str;
  }
  
  public final long ahV(int paramInt)
  {
    AppMethodBeat.i(204766);
    Object localObject = b(paramInt, Long.valueOf(0L));
    if ((localObject instanceof Long))
    {
      long l = ((Long)localObject).longValue();
      AppMethodBeat.o(204766);
      return l;
    }
    AppMethodBeat.o(204766);
    return 0L;
  }
  
  public final void asC(int paramInt)
  {
    AppMethodBeat.i(133248);
    try
    {
      Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "compareV2 reportData, case is [%s], filename:[%s]", new Object[] { Integer.valueOf(paramInt), getFileName() });
      Log.printInfoStack("MicroMsg.ConfigFileStorageProxyMMKV", "reportIDKeyData stack", new Object[0]);
      f.Iyx.idkeyStat(1041L, paramInt, 1L, false);
      AppMethodBeat.o(133248);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", localThrowable, "reportIDKeyData error", new Object[0]);
      AppMethodBeat.o(133248);
    }
  }
  
  public final Object b(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(133254);
    if (this.cQO == null)
    {
      Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "get mmkv is null ,return default val");
      asC(31);
      di(31, null);
      AppMethodBeat.o(133254);
      return paramObject;
    }
    MMKVTypeObject localMMKVTypeObject = (MMKVTypeObject)this.cQO.decodeParcelable(String.valueOf(paramInt), MMKVTypeObject.class);
    if (localMMKVTypeObject != null)
    {
      paramObject = localMMKVTypeObject.object;
      AppMethodBeat.o(133254);
      return paramObject;
    }
    Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "get mmkv value is null，get value fail");
    asC(32);
    di(32, null);
    AppMethodBeat.o(133254);
    return paramObject;
  }
  
  /* Error */
  public final boolean ce(Map<Integer, Object> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 378
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +15 -> 24
    //   12: iconst_0
    //   13: istore_2
    //   14: ldc_w 378
    //   17: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_2
    //   23: ireturn
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial 380	com/tencent/mm/storage/ConfigFileStorageProxyMMKV:cg	(Ljava/util/Map;)Z
    //   29: istore_2
    //   30: ldc_w 378
    //   33: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void cf(Map<Integer, Object> paramMap)
  {
    try
    {
      AppMethodBeat.i(133243);
      long l = System.currentTimeMillis() / 1000L;
      paramMap.put(Integer.valueOf(100001), Long.valueOf(l));
      i(100001, Long.valueOf(l));
      if ((this.cQO != null) && (paramMap.size() != this.cQO.count()))
      {
        asC(24);
        di(24, null);
      }
      AppMethodBeat.o(133243);
      return;
    }
    finally {}
  }
  
  public final void cj(Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(133247);
    if ((this.cQO == null) || (paramMap == null))
    {
      AppMethodBeat.o(133247);
      return;
    }
    Log.i("MicroMsg.ConfigFileStorageProxyMMKV", "mmKVCoverStorage storage size:[%d]", new Object[] { Integer.valueOf(paramMap.size()) });
    paramMap.clear();
    String[] arrayOfString = this.cQO.allKeys();
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
          localObject = (MMKVTypeObject)this.cQO.decodeParcelable((String)localObject, MMKVTypeObject.class);
          if (localObject != null)
          {
            paramMap.put(Integer.valueOf(k), ((MMKVTypeObject)localObject).object);
          }
          else
          {
            Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "get mmkv value is null，get value fail");
            asC(32);
            di(32, null);
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
  
  public final void di(int paramInt, String paramString)
  {
    AppMethodBeat.i(133249);
    a(null, false, 0L, 0L, 0L, paramString, null, null, paramInt, true);
    AppMethodBeat.o(133249);
  }
  
  public final void i(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(133253);
    if (this.cQO == null)
    {
      AppMethodBeat.o(133253);
      return;
    }
    String str1 = String.valueOf(paramInt);
    MMKVTypeObject localMMKVTypeObject;
    Object localObject2;
    String str2;
    Object localObject3;
    if (paramObject != null)
    {
      localObject1 = paramObject.getClass().getSimpleName();
      localMMKVTypeObject = new MMKVTypeObject((String)localObject1, paramObject);
      boolean bool = this.cQO.encode(str1, localMMKVTypeObject);
      localObject2 = b(paramInt, null);
      if (!bool)
      {
        asC(18);
        di(18, str1);
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
        asC(23);
        di(23, null);
      }
      if ((MMKVTypeObject)this.cQO.decodeParcelable(str1, MMKVTypeObject.class) == null)
      {
        Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "get mmkv value again, value is null");
        asC(33);
        di(33, str1);
      }
      if ((paramObject != null) && (!paramObject.equals(localObject2)))
      {
        asC(20);
        di(20, str1);
        Log.e("MicroMsg.ConfigFileStorageProxyMMKV", "set get data not equal, type:%s", new Object[] { localMMKVTypeObject.type });
      }
      AppMethodBeat.o(133253);
      return;
      localObject1 = "null";
      break;
    }
  }
  
  public final void i(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(133251);
    a(null, false, 0L, 0L, 0L, paramString1, paramString2, paramString3, paramInt, false);
    AppMethodBeat.o(133251);
  }
  
  public static class MMKVTypeObject
    implements Parcelable
  {
    public static final Parcelable.Creator<MMKVTypeObject> CREATOR;
    Object object;
    String type;
    
    static
    {
      AppMethodBeat.i(133239);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(133239);
    }
    
    protected MMKVTypeObject(Parcel paramParcel)
    {
      AppMethodBeat.i(133236);
      try
      {
        this.type = paramParcel.readString();
        return;
      }
      catch (RuntimeException paramParcel)
      {
        try
        {
          if ((!TextUtils.equals(this.type, HashMap.class.getSimpleName())) && (!TextUtils.equals(this.type, HashSet.class.getSimpleName()))) {
            TextUtils.equals(this.type, LinkedHashMap.class.getSimpleName());
          }
          paramParcel = paramParcel.readValue(null);
          if ((paramParcel instanceof ConfigFileStorageProxyMMKV.a))
          {
            this.object = ((ConfigFileStorageProxyMMKV.a)paramParcel).obj;
            AppMethodBeat.o(133236);
            return;
          }
          this.object = paramParcel;
          AppMethodBeat.o(133236);
          return;
        }
        catch (Exception paramParcel)
        {
          f.Iyx.idkeyStat(1041L, 44L, 1L, true);
          Log.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", paramParcel, "MMKVTypeObject readValue error", new Object[0]);
          AppMethodBeat.o(133236);
        }
        paramParcel = paramParcel;
        Log.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", paramParcel, "", new Object[0]);
        AppMethodBeat.o(133236);
        return;
      }
    }
    
    public MMKVTypeObject(String paramString, Object paramObject)
    {
      AppMethodBeat.i(133235);
      this.type = paramString;
      if ((paramObject instanceof LinkedHashMap))
      {
        this.object = new ConfigFileStorageProxyMMKV.a(paramObject);
        AppMethodBeat.o(133235);
        return;
      }
      this.object = paramObject;
      AppMethodBeat.o(133235);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(133238);
      StringBuilder localStringBuilder = new StringBuilder("type = ").append(this.type).append(" object = ");
      if (this.object != null) {}
      for (String str = this.object.toString();; str = "")
      {
        str = str;
        AppMethodBeat.o(133238);
        return str;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(133237);
      try
      {
        paramParcel.writeString(this.type);
        paramParcel.writeValue(this.object);
        AppMethodBeat.o(133237);
        return;
      }
      catch (RuntimeException paramParcel)
      {
        Log.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", paramParcel, "", new Object[0]);
        AppMethodBeat.o(133237);
      }
    }
  }
  
  public static final class a
    implements Serializable
  {
    public Object obj;
    
    public a(Object paramObject)
    {
      this.obj = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.ConfigFileStorageProxyMMKV
 * JD-Core Version:    0.7.0.1
 */