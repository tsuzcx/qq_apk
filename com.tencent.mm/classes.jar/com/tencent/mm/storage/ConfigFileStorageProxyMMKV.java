package com.tencent.mm.storage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.e.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.vfs.q;
import com.tencent.mmkv.MMKV;
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
  private final long Ffs;
  private final long Fft;
  boolean Ffu;
  private String Ffv;
  ax ctt;
  private String fileName;
  
  public ConfigFileStorageProxyMMKV(String paramString)
  {
    AppMethodBeat.i(133240);
    this.Ffs = 600L;
    this.Fft = 2L;
    if (paramString == null)
    {
      AppMethodBeat.o(133240);
      return;
    }
    boolean bool1 = TextUtils.equals(b.ceD().b("clicfg_app_brand_storage_to_mmkv_switch", "1", false, false), "1");
    if (!bool1) {
      Ww(26);
    }
    boolean bool2 = ax.aFC("MMKVForStorageProxy_COMMAND_TAG").getBoolean("MMKVForStorageProxy_COMMAND_KEY", false);
    ad.i("MicroMsg.ConfigFileStorageProxyMMKV", "proxySwitch commandSwitch is [%b], xSwitch is [%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
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
      this.Ffu = bool1;
      if (this.Ffu) {
        break label224;
      }
      AppMethodBeat.o(133240);
      return;
      i = 0;
      break;
      localObject = new com.tencent.mm.vfs.e(paramString).getName();
      if ((!TextUtils.equals((CharSequence)localObject, "MM_stepcounter.cfg")) && (!TextUtils.equals((CharSequence)localObject, "PUSH_stepcounter.cfg"))) {}
      for (bool1 = true;; bool1 = false)
      {
        ad.i("MicroMsg.ConfigFileStorageProxyMMKV", "selectFile name is %s, returnVal is %b", new Object[] { localObject, Boolean.valueOf(bool1) });
        break;
      }
    }
    label224:
    Object localObject = new com.tencent.mm.vfs.e(paramString);
    String str = q.B(((com.tencent.mm.vfs.e)localObject).fhU());
    if (!TextUtils.equals(str, paramString)) {
      ad.w("MicroMsg.ConfigFileStorageProxyMMKV", "path is [%s], canonicalpath is [%s]", new Object[] { paramString, str });
    }
    if (!((com.tencent.mm.vfs.e)localObject).exists())
    {
      Ww(43);
      a(str, false, 0L, 0L, 0L, null, null, null, 43, true);
    }
    this.Ffv = str;
    this.ctt = ax.aFD(this.Ffv);
    AppMethodBeat.o(133240);
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(133250);
    a(null, false, paramLong1, paramLong2, paramLong3, null, null, null, paramInt, false);
    AppMethodBeat.o(133250);
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
      if (!TextUtils.isEmpty(this.Ffv))
      {
        str = this.Ffv;
        localObject1 = new com.tencent.mm.vfs.e(str);
        bool = ((com.tencent.mm.vfs.e)localObject1).exists();
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
        l = ((com.tencent.mm.vfs.e)localObject1).lastModified() / 1000L;
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
      ad.i("MicroMsg.ConfigFileStorageProxyMMKV", "reportKVData [%s]", new Object[] { String.format("%s,%s,%d,%d,%d,%s,%s,%s,%d,%s,%s", new Object[] { paramString1, String.valueOf(bool), Long.valueOf(l), Long.valueOf(paramLong2), Long.valueOf(paramLong3), str, paramString2, paramString3, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2), aj.getProcessName() }) });
      AppMethodBeat.o(133252);
      return;
    }
    catch (Exception paramString1)
    {
      ad.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", paramString1, "reportKVData error", new Object[0]);
      AppMethodBeat.o(133252);
    }
  }
  
  private boolean bE(Map<Integer, Object> paramMap)
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
        if ((this.ctt != null) && (paramMap.size() != this.ctt.EVG.count()))
        {
          ad.i("MicroMsg.ConfigFileStorageProxyMMKV", "compareV2 size mmkv:%d, cfg:%d", new Object[] { Long.valueOf(this.ctt.EVG.count()), Integer.valueOf(paramMap.size()) });
          if ((paramMap.containsKey(Integer.valueOf(100001))) && (!this.ctt.containsKey(Integer.toString(100001))))
          {
            ad.e("MicroMsg.ConfigFileStorageProxyMMKV", "compareV2 mmkv not contain md time key");
            Ww(21);
            cE(21, null);
            if (this.ctt.EVG.count() != 0L)
            {
              Ww(22);
              cE(22, null);
            }
          }
          if (this.ctt.EVG.count() != 0L)
          {
            Ww(25);
            cE(25, null);
          }
        }
        l2 = getLong(100001, 0L);
        Object localObject = paramMap.get(Integer.valueOf(100001));
        if (!(localObject instanceof Long)) {
          break label867;
        }
        l1 = ((Long)localObject).longValue();
        if (l2 == l1)
        {
          bool1 = true;
          ad.i("MicroMsg.ConfigFileStorageProxyMMKV", "compareV2 time compare result is [%b], mmkvTime is [%s], size:%d, storageTime is [%s], size:[%d]", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l2), Long.valueOf(this.ctt.EVG.count()), Long.valueOf(l1), Integer.valueOf(paramMap.size()) });
          if (l2 != l1) {
            break label652;
          }
          if (l2 != 0L) {
            continue;
          }
          if (this.ctt != null)
          {
            l1 = this.ctt.EVG.count();
            ad.i("MicroMsg.ConfigFileStorageProxyMMKV", "mmkv has no data, mmkv:%d, cfg:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramMap.size()) });
            bG(paramMap);
            bool1 = bool2;
            localObject = i.c(aj.getContext(), d.CpK, true);
            paramMap.put(Integer.valueOf(100003), localObject);
            set(100003, localObject);
            if (!this.ctt.containsKey(Integer.toString(100001)))
            {
              l1 = System.currentTimeMillis() / 1000L;
              paramMap.put(Integer.valueOf(100001), Long.valueOf(l1));
              set(100001, Long.valueOf(l1));
              Ww(30);
              cE(30, null);
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
        l3 = 2L + new com.tencent.mm.vfs.e(this.Ffv).lastModified() / 1000L;
        if (l3 < l2) {
          break label631;
        }
        if (l3 - l2 >= 600L)
        {
          bG(paramMap);
          Ww(2);
          a(2, l3, l1, l2);
          l1 = System.currentTimeMillis() / 1000L;
          paramMap.put(Integer.valueOf(100001), Long.valueOf(l1));
          set(100001, Long.valueOf(l1));
          bool1 = bool2;
          continue;
        }
        bool1 = bool2;
      }
      finally {}
      if (bF(paramMap))
      {
        Ww(3);
        a(3, l3, l1, l2);
        bG(paramMap);
        continue;
        label631:
        Ww(1);
        a(1, l3, l1, l2);
        bool1 = bool2;
        continue;
        label652:
        l3 = 2L + new com.tencent.mm.vfs.e(this.Ffv).lastModified() / 1000L;
        if (l1 < l2)
        {
          if (l3 >= l2)
          {
            if (l3 - l2 >= 600L)
            {
              if (bF(paramMap))
              {
                Ww(13);
                a(13, l3, l1, l2);
              }
              for (;;)
              {
                bG(paramMap);
                bool1 = false;
                break;
                Ww(14);
                a(14, l3, l1, l2);
              }
            }
            Ww(15);
            a(15, l3, l1, l2);
            bH(paramMap);
            bool1 = true;
          }
          else
          {
            Ww(12);
            a(12, l3, l1, l2);
            bH(paramMap);
            bool1 = true;
          }
        }
        else
        {
          bG(paramMap);
          if ((l2 == 0L) && (l1 > 0L)) {
            Ww(7);
          }
          for (;;)
          {
            a(11, l3, l1, l2);
            bool1 = false;
            break;
            Ww(11);
          }
          label867:
          l1 = 0L;
        }
      }
    }
  }
  
  private static boolean bF(Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(133245);
    String str = i.c(aj.getContext(), d.CpK, true);
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
  
  private void bG(Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(133246);
    if ((paramMap == null) || (this.ctt == null))
    {
      AppMethodBeat.o(133246);
      return;
    }
    this.ctt.clear();
    ad.i("MicroMsg.ConfigFileStorageProxyMMKV", "storageCoverMMKV storage size:[%d]", new Object[] { Integer.valueOf(paramMap.size()) });
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      set(((Integer)localEntry.getKey()).intValue(), localEntry.getValue());
    }
    AppMethodBeat.o(133246);
  }
  
  private String getFileName()
  {
    AppMethodBeat.i(133241);
    if (TextUtils.isEmpty(this.Ffv))
    {
      AppMethodBeat.o(133241);
      return "";
    }
    if (TextUtils.isEmpty(this.fileName)) {
      this.fileName = new com.tencent.mm.vfs.e(this.Ffv).getName();
    }
    String str = this.fileName;
    AppMethodBeat.o(133241);
    return str;
  }
  
  public final void Ww(int paramInt)
  {
    AppMethodBeat.i(133248);
    try
    {
      ad.e("MicroMsg.ConfigFileStorageProxyMMKV", "compareV2 reportData, case is [%s], filename:[%s]", new Object[] { Integer.valueOf(paramInt), getFileName() });
      ad.m("MicroMsg.ConfigFileStorageProxyMMKV", "reportIDKeyData stack", new Object[0]);
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1041L, paramInt, 1L, false);
      AppMethodBeat.o(133248);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", localThrowable, "reportIDKeyData error", new Object[0]);
      AppMethodBeat.o(133248);
    }
  }
  
  /* Error */
  public final boolean bC(Map<Integer, Object> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 372
    //   5: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +15 -> 24
    //   12: iconst_0
    //   13: istore_2
    //   14: ldc_w 372
    //   17: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_2
    //   23: ireturn
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial 374	com/tencent/mm/storage/ConfigFileStorageProxyMMKV:bE	(Ljava/util/Map;)Z
    //   29: istore_2
    //   30: ldc_w 372
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
  
  public final void bD(Map<Integer, Object> paramMap)
  {
    try
    {
      AppMethodBeat.i(133243);
      long l = System.currentTimeMillis() / 1000L;
      paramMap.put(Integer.valueOf(100001), Long.valueOf(l));
      set(100001, Long.valueOf(l));
      if ((this.ctt != null) && (paramMap.size() != this.ctt.EVG.count()))
      {
        Ww(24);
        cE(24, null);
      }
      AppMethodBeat.o(133243);
      return;
    }
    finally {}
  }
  
  public final void bH(Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(133247);
    if ((this.ctt == null) || (paramMap == null))
    {
      AppMethodBeat.o(133247);
      return;
    }
    ad.i("MicroMsg.ConfigFileStorageProxyMMKV", "mmKVCoverStorage storage size:[%d]", new Object[] { Integer.valueOf(paramMap.size()) });
    paramMap.clear();
    String[] arrayOfString = this.ctt.allKeys();
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
          int k = bt.aGh((String)localObject);
          localObject = (MMKVTypeObject)this.ctt.decodeParcelable((String)localObject, MMKVTypeObject.class);
          if (localObject != null)
          {
            paramMap.put(Integer.valueOf(k), ((MMKVTypeObject)localObject).object);
          }
          else
          {
            ad.e("MicroMsg.ConfigFileStorageProxyMMKV", "get mmkv value is null，get value fail");
            Ww(32);
            cE(32, null);
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          ad.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", localNumberFormatException, "NumberFormatException", new Object[0]);
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
  
  public final void cE(int paramInt, String paramString)
  {
    AppMethodBeat.i(133249);
    a(null, false, 0L, 0L, 0L, paramString, null, null, paramInt, true);
    AppMethodBeat.o(133249);
  }
  
  public final Object get(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(133254);
    if (this.ctt == null)
    {
      ad.e("MicroMsg.ConfigFileStorageProxyMMKV", "get mmkv is null ,return default val");
      Ww(31);
      cE(31, null);
      AppMethodBeat.o(133254);
      return paramObject;
    }
    MMKVTypeObject localMMKVTypeObject = (MMKVTypeObject)this.ctt.decodeParcelable(String.valueOf(paramInt), MMKVTypeObject.class);
    if (localMMKVTypeObject != null)
    {
      paramObject = localMMKVTypeObject.object;
      AppMethodBeat.o(133254);
      return paramObject;
    }
    ad.e("MicroMsg.ConfigFileStorageProxyMMKV", "get mmkv value is null，get value fail");
    Ww(32);
    cE(32, null);
    AppMethodBeat.o(133254);
    return paramObject;
  }
  
  public final long getLong(int paramInt, long paramLong)
  {
    AppMethodBeat.i(133255);
    Object localObject = get(paramInt, Long.valueOf(paramLong));
    if ((localObject instanceof Long))
    {
      paramLong = ((Long)localObject).longValue();
      AppMethodBeat.o(133255);
      return paramLong;
    }
    AppMethodBeat.o(133255);
    return paramLong;
  }
  
  public final void h(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(133251);
    a(null, false, 0L, 0L, 0L, paramString1, paramString2, paramString3, paramInt, false);
    AppMethodBeat.o(133251);
  }
  
  public final void set(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(133253);
    if (this.ctt == null)
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
      boolean bool = this.ctt.encode(str1, localMMKVTypeObject);
      localObject2 = get(paramInt, null);
      if (!bool)
      {
        Ww(18);
        cE(18, str1);
        ad.e("MicroMsg.ConfigFileStorageProxyMMKV", "write data fail");
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
      ad.e("MicroMsg.ConfigFileStorageProxyMMKV", "innerObject set get data null, type:[%s], obj:[%s], key:[%s], value:[%s]", new Object[] { str2, localObject3, str1, localObject1 });
      ad.m("MicroMsg.ConfigFileStorageProxyMMKV", "innerObject stack", new Object[0]);
      if (paramObject != null)
      {
        Ww(23);
        cE(23, null);
      }
      if ((MMKVTypeObject)this.ctt.decodeParcelable(str1, MMKVTypeObject.class) == null)
      {
        ad.e("MicroMsg.ConfigFileStorageProxyMMKV", "get mmkv value again, value is null");
        Ww(33);
        cE(33, str1);
      }
      if ((paramObject != null) && (!paramObject.equals(localObject2)))
      {
        Ww(20);
        cE(20, str1);
        ad.e("MicroMsg.ConfigFileStorageProxyMMKV", "set get data not equal, type:%s", new Object[] { localMMKVTypeObject.type });
      }
      AppMethodBeat.o(133253);
      return;
      localObject1 = "null";
      break;
    }
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
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(1041L, 44L, 1L, true);
          ad.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", paramParcel, "MMKVTypeObject readValue error", new Object[0]);
          AppMethodBeat.o(133236);
        }
        paramParcel = paramParcel;
        ad.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", paramParcel, "", new Object[0]);
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
        ad.printErrStackTrace("MicroMsg.ConfigFileStorageProxyMMKV", paramParcel, "", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.ConfigFileStorageProxyMMKV
 * JD-Core Version:    0.7.0.1
 */