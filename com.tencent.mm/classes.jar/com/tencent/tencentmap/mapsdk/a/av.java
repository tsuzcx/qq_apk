package com.tencent.tencentmap.mapsdk.a;

import com.qq.sim.Millis100TimeProvider;
import com.qq.tac2.jdt.share.AsyncClientRuntimeInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class av
  implements au
{
  private static final AsyncClientRuntimeInfo q = new AsyncClientRuntimeInfo() {};
  public static final short version = 1;
  private ax a;
  aq b;
  bj c;
  hs d = null;
  az e;
  long f = 0L;
  ConcurrentHashMap<String, AtomicInteger> g = new ConcurrentHashMap();
  private String h = "ServantProxy";
  private kv i;
  private int j = 10000;
  private int k = 20;
  private int l = 2;
  private int m = 60000;
  private int n = 5;
  private float o = 0.5F;
  private int p = 30;
  
  private boolean a(String paramString)
  {
    if (!this.g.containsKey(paramString)) {
      this.g.putIfAbsent(paramString, new AtomicInteger());
    }
    int i1 = ((AtomicInteger)this.g.get(paramString)).incrementAndGet();
    return (i1 == 1) || ((i1 % this.j == 0) && (i1 < this.j * this.k));
  }
  
  private byte[] a(ar paramar, np paramnp, String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramar.l = this;
    if (a(paramString)) {
      paramar.g();
    }
    paramar.h();
    paramar.i();
    paramar.j();
    if (paramBoolean2)
    {
      this.b.f.a(paramar);
      return new byte[0];
    }
    a(paramar);
    if (!paramBoolean1) {
      return new byte[0];
    }
    try
    {
      paramar = paramar.e().b();
      if (!paramBoolean1) {
        break label271;
      }
      paramar = (ju)paramar;
      if (paramar.e != 0) {
        throw new br(this.b.c() + "#" + paramString, bo.a(paramar.e));
      }
    }
    catch (InterruptedException paramar)
    {
      throw new br(" thread is InterruptedExceptioned ");
    }
    catch (CancellationException paramar)
    {
      throw new br(" thread is CancellationException ");
    }
    catch (bo paramar)
    {
      bc.a("sendMsg throw TafException " + paramar);
      throw new br(this.b.c() + "#" + paramString, paramar);
    }
    catch (Exception paramar)
    {
      bc.a("sendMsg throw Exception " + paramar);
      throw new br(this.b.c() + " ", paramar);
    }
    return paramar.f;
    label271:
    return new byte[0];
  }
  
  private byte[] a(aw paramaw, String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramaw != null) {
      paramaw._data = ay.a.a();
    }
    if (paramBoolean2) {}
    for (at localat = this.c.a(taf_async_timeout(), paramBoolean2);; localat = this.c.a(taf_sync_timeout(), paramBoolean2)) {
      return a(new ar(this.b.c(), paramString, paramArrayOfByte, this.b.a(), paramMap1, paramMap2, localat, paramaw, paramBoolean1), paramaw, paramString, paramArrayOfByte, paramMap1, paramMap2, paramBoolean1, paramBoolean2);
    }
  }
  
  /* Error */
  void a(ar paramar)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 214	com/tencent/tencentmap/mapsdk/a/av:c	Lcom/tencent/tencentmap/mapsdk/a/bj;
    //   6: invokevirtual 239	com/tencent/tencentmap/mapsdk/a/bj:a	()V
    //   9: getstatic 245	com/qq/sim/Millis100TimeProvider:INSTANCE	Lcom/qq/sim/Millis100TimeProvider;
    //   12: invokevirtual 249	com/qq/sim/Millis100TimeProvider:currentTimeMillis	()J
    //   15: aload_1
    //   16: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   19: invokevirtual 251	com/tencent/tencentmap/mapsdk/a/at:i	()J
    //   22: lsub
    //   23: lstore_3
    //   24: lload_3
    //   25: aload_1
    //   26: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   29: getfield 253	com/tencent/tencentmap/mapsdk/a/at:e	J
    //   32: lcmp
    //   33: ifle +210 -> 243
    //   36: aload_0
    //   37: getfield 214	com/tencent/tencentmap/mapsdk/a/av:c	Lcom/tencent/tencentmap/mapsdk/a/bj;
    //   40: invokevirtual 255	com/tencent/tencentmap/mapsdk/a/bj:e	()Ljava/lang/String;
    //   43: aload_1
    //   44: invokevirtual 258	com/tencent/tencentmap/mapsdk/a/ar:d	()Lcom/tencent/tencentmap/mapsdk/a/it;
    //   47: getfield 262	com/tencent/tencentmap/mapsdk/a/it:e	Ljava/lang/String;
    //   50: aload_1
    //   51: invokevirtual 258	com/tencent/tencentmap/mapsdk/a/ar:d	()Lcom/tencent/tencentmap/mapsdk/a/it;
    //   54: getfield 264	com/tencent/tencentmap/mapsdk/a/it:f	Ljava/lang/String;
    //   57: ldc_w 266
    //   60: ldc_w 268
    //   63: iconst_0
    //   64: iconst_0
    //   65: aload_0
    //   66: getfield 125	com/tencent/tencentmap/mapsdk/a/av:b	Lcom/tencent/tencentmap/mapsdk/a/aq;
    //   69: invokevirtual 270	com/tencent/tencentmap/mapsdk/a/aq:f	()Ljava/lang/String;
    //   72: aload_0
    //   73: getfield 125	com/tencent/tencentmap/mapsdk/a/av:b	Lcom/tencent/tencentmap/mapsdk/a/aq;
    //   76: invokevirtual 272	com/tencent/tencentmap/mapsdk/a/aq:g	()Ljava/lang/String;
    //   79: aload_0
    //   80: getfield 125	com/tencent/tencentmap/mapsdk/a/av:b	Lcom/tencent/tencentmap/mapsdk/a/aq;
    //   83: invokevirtual 274	com/tencent/tencentmap/mapsdk/a/aq:h	()Ljava/lang/String;
    //   86: ldc_w 266
    //   89: invokestatic 279	com/tencent/tencentmap/mapsdk/a/cb:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/tencentmap/mapsdk/a/lu;
    //   92: astore 5
    //   94: invokestatic 284	com/tencent/tencentmap/mapsdk/a/ap:a	()Lcom/tencent/tencentmap/mapsdk/a/ap;
    //   97: aload_0
    //   98: getfield 214	com/tencent/tencentmap/mapsdk/a/av:c	Lcom/tencent/tencentmap/mapsdk/a/bj;
    //   101: invokevirtual 287	com/tencent/tencentmap/mapsdk/a/bj:c	()Lcom/tencent/tencentmap/mapsdk/a/av;
    //   104: invokevirtual 290	com/tencent/tencentmap/mapsdk/a/ap:a	(Lcom/tencent/tencentmap/mapsdk/a/av;)Lcom/tencent/tencentmap/mapsdk/a/ao;
    //   107: aload 5
    //   109: lload_3
    //   110: l2i
    //   111: invokevirtual 295	com/tencent/tencentmap/mapsdk/a/ao:a	(Lcom/tencent/tencentmap/mapsdk/a/lu;I)V
    //   114: new 152	java/lang/StringBuilder
    //   117: dup
    //   118: ldc_w 297
    //   121: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   124: aload_1
    //   125: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   128: invokevirtual 299	com/tencent/tencentmap/mapsdk/a/at:h	()I
    //   131: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: ldc_w 304
    //   137: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: lload_3
    //   141: invokevirtual 307	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   144: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 188	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;)V
    //   150: aload_1
    //   151: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   154: new 309	com/tencent/tencentmap/mapsdk/a/bn
    //   157: dup
    //   158: new 152	java/lang/StringBuilder
    //   161: dup
    //   162: ldc_w 311
    //   165: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   168: aload_1
    //   169: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   172: invokevirtual 299	com/tencent/tencentmap/mapsdk/a/at:h	()I
    //   175: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: ldc_w 313
    //   181: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokespecial 314	com/tencent/tencentmap/mapsdk/a/bn:<init>	(Ljava/lang/String;)V
    //   190: invokevirtual 317	com/tencent/tencentmap/mapsdk/a/at:a	(Lcom/tencent/tencentmap/mapsdk/a/bo;)V
    //   193: aload_1
    //   194: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   197: invokevirtual 320	com/tencent/tencentmap/mapsdk/a/at:g	()Z
    //   200: ifeq +38 -> 238
    //   203: bipush 249
    //   205: aload_1
    //   206: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   209: invokevirtual 299	com/tencent/tencentmap/mapsdk/a/at:h	()I
    //   212: invokestatic 325	com/tencent/tencentmap/mapsdk/a/be:a	(II)Lcom/tencent/tencentmap/mapsdk/a/be;
    //   215: astore 5
    //   217: aload 5
    //   219: aload_1
    //   220: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   223: invokevirtual 328	com/tencent/tencentmap/mapsdk/a/be:a	(Lcom/tencent/tencentmap/mapsdk/a/at;)V
    //   226: aload_0
    //   227: getfield 125	com/tencent/tencentmap/mapsdk/a/av:b	Lcom/tencent/tencentmap/mapsdk/a/aq;
    //   230: invokevirtual 331	com/tencent/tencentmap/mapsdk/a/aq:e	()Lcom/tencent/tencentmap/mapsdk/a/bd;
    //   233: aload 5
    //   235: invokevirtual 334	com/tencent/tencentmap/mapsdk/a/bd:a	(Lcom/tencent/tencentmap/mapsdk/a/be;)V
    //   238: aload_0
    //   239: invokevirtual 337	com/tencent/tencentmap/mapsdk/a/av:taf_del_hash	()V
    //   242: return
    //   243: aload_0
    //   244: getfield 214	com/tencent/tencentmap/mapsdk/a/av:c	Lcom/tencent/tencentmap/mapsdk/a/bj;
    //   247: aload_1
    //   248: invokevirtual 338	com/tencent/tencentmap/mapsdk/a/bj:a	(Lcom/tencent/tencentmap/mapsdk/a/ar;)V
    //   251: goto -13 -> 238
    //   254: astore 5
    //   256: getstatic 343	com/tencent/tencentmap/mapsdk/a/ba:a	Lcom/tencent/tencentmap/mapsdk/a/ba;
    //   259: aload_0
    //   260: invokevirtual 346	com/tencent/tencentmap/mapsdk/a/ba:b	(Lcom/tencent/tencentmap/mapsdk/a/av;)V
    //   263: aload_0
    //   264: getfield 214	com/tencent/tencentmap/mapsdk/a/av:c	Lcom/tencent/tencentmap/mapsdk/a/bj;
    //   267: aload_1
    //   268: invokevirtual 348	com/tencent/tencentmap/mapsdk/a/bj:b	(Lcom/tencent/tencentmap/mapsdk/a/ar;)V
    //   271: goto -33 -> 238
    //   274: astore 5
    //   276: iload_2
    //   277: ifeq +48 -> 325
    //   280: aload_1
    //   281: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   284: invokevirtual 320	com/tencent/tencentmap/mapsdk/a/at:g	()Z
    //   287: ifeq +38 -> 325
    //   290: bipush 248
    //   292: aload_1
    //   293: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   296: invokevirtual 299	com/tencent/tencentmap/mapsdk/a/at:h	()I
    //   299: invokestatic 325	com/tencent/tencentmap/mapsdk/a/be:a	(II)Lcom/tencent/tencentmap/mapsdk/a/be;
    //   302: astore 6
    //   304: aload 6
    //   306: aload_1
    //   307: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   310: invokevirtual 328	com/tencent/tencentmap/mapsdk/a/be:a	(Lcom/tencent/tencentmap/mapsdk/a/at;)V
    //   313: aload_0
    //   314: getfield 125	com/tencent/tencentmap/mapsdk/a/av:b	Lcom/tencent/tencentmap/mapsdk/a/aq;
    //   317: invokevirtual 331	com/tencent/tencentmap/mapsdk/a/aq:e	()Lcom/tencent/tencentmap/mapsdk/a/bd;
    //   320: aload 6
    //   322: invokevirtual 334	com/tencent/tencentmap/mapsdk/a/bd:a	(Lcom/tencent/tencentmap/mapsdk/a/be;)V
    //   325: aload 5
    //   327: athrow
    //   328: astore 5
    //   330: new 152	java/lang/StringBuilder
    //   333: dup
    //   334: ldc_w 350
    //   337: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   340: aload 5
    //   342: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: aload 5
    //   350: invokestatic 353	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   353: aload_1
    //   354: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   357: aload 5
    //   359: invokevirtual 317	com/tencent/tencentmap/mapsdk/a/at:a	(Lcom/tencent/tencentmap/mapsdk/a/bo;)V
    //   362: aload_1
    //   363: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   366: invokevirtual 320	com/tencent/tencentmap/mapsdk/a/at:g	()Z
    //   369: ifeq -131 -> 238
    //   372: bipush 248
    //   374: aload_1
    //   375: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   378: invokevirtual 299	com/tencent/tencentmap/mapsdk/a/at:h	()I
    //   381: invokestatic 325	com/tencent/tencentmap/mapsdk/a/be:a	(II)Lcom/tencent/tencentmap/mapsdk/a/be;
    //   384: astore 5
    //   386: aload 5
    //   388: aload_1
    //   389: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   392: invokevirtual 328	com/tencent/tencentmap/mapsdk/a/be:a	(Lcom/tencent/tencentmap/mapsdk/a/at;)V
    //   395: aload_0
    //   396: getfield 125	com/tencent/tencentmap/mapsdk/a/av:b	Lcom/tencent/tencentmap/mapsdk/a/aq;
    //   399: invokevirtual 331	com/tencent/tencentmap/mapsdk/a/aq:e	()Lcom/tencent/tencentmap/mapsdk/a/bd;
    //   402: aload 5
    //   404: invokevirtual 334	com/tencent/tencentmap/mapsdk/a/bd:a	(Lcom/tencent/tencentmap/mapsdk/a/be;)V
    //   407: goto -169 -> 238
    //   410: astore 5
    //   412: aload_1
    //   413: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   416: new 106	com/tencent/tencentmap/mapsdk/a/bo
    //   419: dup
    //   420: aload 5
    //   422: invokevirtual 354	java/lang/Exception:toString	()Ljava/lang/String;
    //   425: aload 5
    //   427: invokespecial 356	com/tencent/tencentmap/mapsdk/a/bo:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   430: invokevirtual 317	com/tencent/tencentmap/mapsdk/a/at:a	(Lcom/tencent/tencentmap/mapsdk/a/bo;)V
    //   433: new 152	java/lang/StringBuilder
    //   436: dup
    //   437: ldc_w 358
    //   440: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   443: aload 5
    //   445: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: aload 5
    //   453: invokestatic 353	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   456: aload_1
    //   457: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   460: invokevirtual 320	com/tencent/tencentmap/mapsdk/a/at:g	()Z
    //   463: ifeq -225 -> 238
    //   466: bipush 248
    //   468: aload_1
    //   469: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   472: invokevirtual 299	com/tencent/tencentmap/mapsdk/a/at:h	()I
    //   475: invokestatic 325	com/tencent/tencentmap/mapsdk/a/be:a	(II)Lcom/tencent/tencentmap/mapsdk/a/be;
    //   478: astore 5
    //   480: aload 5
    //   482: aload_1
    //   483: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   486: invokevirtual 328	com/tencent/tencentmap/mapsdk/a/be:a	(Lcom/tencent/tencentmap/mapsdk/a/at;)V
    //   489: aload_0
    //   490: getfield 125	com/tencent/tencentmap/mapsdk/a/av:b	Lcom/tencent/tencentmap/mapsdk/a/aq;
    //   493: invokevirtual 331	com/tencent/tencentmap/mapsdk/a/aq:e	()Lcom/tencent/tencentmap/mapsdk/a/bd;
    //   496: aload 5
    //   498: invokevirtual 334	com/tencent/tencentmap/mapsdk/a/bd:a	(Lcom/tencent/tencentmap/mapsdk/a/be;)V
    //   501: goto -263 -> 238
    //   504: astore 5
    //   506: aload_1
    //   507: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   510: new 106	com/tencent/tencentmap/mapsdk/a/bo
    //   513: dup
    //   514: aload 5
    //   516: invokevirtual 359	java/lang/Throwable:toString	()Ljava/lang/String;
    //   519: aload 5
    //   521: invokespecial 356	com/tencent/tencentmap/mapsdk/a/bo:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   524: invokevirtual 317	com/tencent/tencentmap/mapsdk/a/at:a	(Lcom/tencent/tencentmap/mapsdk/a/bo;)V
    //   527: new 152	java/lang/StringBuilder
    //   530: dup
    //   531: ldc_w 361
    //   534: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   537: aload 5
    //   539: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   542: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: aload 5
    //   547: invokestatic 353	com/tencent/tencentmap/mapsdk/a/bc:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   550: aload_1
    //   551: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   554: invokevirtual 320	com/tencent/tencentmap/mapsdk/a/at:g	()Z
    //   557: ifeq -319 -> 238
    //   560: bipush 248
    //   562: aload_1
    //   563: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   566: invokevirtual 299	com/tencent/tencentmap/mapsdk/a/at:h	()I
    //   569: invokestatic 325	com/tencent/tencentmap/mapsdk/a/be:a	(II)Lcom/tencent/tencentmap/mapsdk/a/be;
    //   572: astore 5
    //   574: aload 5
    //   576: aload_1
    //   577: invokevirtual 139	com/tencent/tencentmap/mapsdk/a/ar:e	()Lcom/tencent/tencentmap/mapsdk/a/at;
    //   580: invokevirtual 328	com/tencent/tencentmap/mapsdk/a/be:a	(Lcom/tencent/tencentmap/mapsdk/a/at;)V
    //   583: aload_0
    //   584: getfield 125	com/tencent/tencentmap/mapsdk/a/av:b	Lcom/tencent/tencentmap/mapsdk/a/aq;
    //   587: invokevirtual 331	com/tencent/tencentmap/mapsdk/a/aq:e	()Lcom/tencent/tencentmap/mapsdk/a/bd;
    //   590: aload 5
    //   592: invokevirtual 334	com/tencent/tencentmap/mapsdk/a/bd:a	(Lcom/tencent/tencentmap/mapsdk/a/be;)V
    //   595: goto -357 -> 238
    //   598: astore 5
    //   600: iconst_1
    //   601: istore_2
    //   602: goto -326 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	605	0	this	av
    //   0	605	1	paramar	ar
    //   1	601	2	i1	int
    //   23	118	3	l1	long
    //   92	142	5	localObject1	Object
    //   254	1	5	localbs	bs
    //   274	52	5	localObject2	Object
    //   328	30	5	localbo	bo
    //   384	19	5	localbe1	be
    //   410	42	5	localException	Exception
    //   478	19	5	localbe2	be
    //   504	42	5	localThrowable	java.lang.Throwable
    //   572	19	5	localbe3	be
    //   598	1	5	localObject3	Object
    //   302	19	6	localbe4	be
    // Exception table:
    //   from	to	target	type
    //   243	251	254	com/tencent/tencentmap/mapsdk/a/bs
    //   243	251	274	finally
    //   256	271	274	finally
    //   330	353	274	finally
    //   243	251	328	com/tencent/tencentmap/mapsdk/a/bo
    //   243	251	410	java/lang/Exception
    //   243	251	504	java/lang/Throwable
    //   353	362	598	finally
    //   412	456	598	finally
    //   506	550	598	finally
  }
  
  public final void a(aw paramaw, String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    if (paramaw == null)
    {
      a(paramaw, paramString, paramArrayOfByte, paramMap1, paramMap2, false, true);
      return;
    }
    a(paramaw, paramString, paramArrayOfByte, paramMap1, paramMap2, true, true);
  }
  
  void b()
  {
    this.f = Millis100TimeProvider.INSTANCE.currentTimeMillis();
  }
  
  @Deprecated
  protected void b(int paramInt)
  {
    this.c.a(paramInt);
  }
  
  boolean c()
  {
    return (this.d != null) && (Millis100TimeProvider.INSTANCE.currentTimeMillis() - this.f > 2000L);
  }
  
  public ar createPingPackage(aw paramaw)
  {
    at localat = this.c.a(taf_async_timeout(), true);
    String str = this.b.c();
    int i1 = this.b.a();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    return new ar(str, "taf_ping", new byte[0], i1, localHashMap1, localHashMap2, localat, paramaw, true);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((this == null) && (paramObject == null)) || ((paramObject != null) && ((paramObject instanceof av)) && (((av)paramObject).b.equals(this.b)));
  }
  
  public List<bg> getAliveServices()
  {
    return this.e.a();
  }
  
  public int getID()
  {
    return this.b.hashCode();
  }
  
  public List<bg> getInAliveServices()
  {
    return this.e.b();
  }
  
  public int getMaxSampleCount()
  {
    return this.k;
  }
  
  public int getSampleRate()
  {
    return this.j;
  }
  
  public kv getStatPrxPr()
  {
    return this.i;
  }
  
  public ConcurrentLinkedQueue<mm> getStatSampleMsg()
  {
    return this.c.o;
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public void setMaxSampleCount(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setSampleRate(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setStatPrxPr(kv paramkv)
  {
    this.i = paramkv;
  }
  
  public ax taf_Router()
  {
    return this.a;
  }
  
  public int taf_ServiceConnNum()
  {
    return this.b.g;
  }
  
  public void taf_ServiceConnNum(int paramInt)
  {
    this.b.g = paramInt;
    b(paramInt);
  }
  
  public int taf_async_timeout()
  {
    return this.b.c;
  }
  
  public void taf_async_timeout(int paramInt)
  {
    this.b.c = paramInt;
  }
  
  public void taf_check_timeout(int paramInt1, int paramInt2, int paramInt3, float paramFloat, int paramInt4)
  {
    this.l = paramInt1;
    this.m = paramInt2;
    this.n = paramInt3;
    this.o = paramFloat;
    this.p = paramInt4;
  }
  
  public void taf_del_hash()
  {
    ay.a.a().a = -1;
  }
  
  public void taf_del_router()
  {
    this.a = null;
  }
  
  public int taf_frequence_fail_invoke()
  {
    return this.n;
  }
  
  public void taf_frequence_fail_invoke(int paramInt)
  {
    this.n = paramInt;
  }
  
  public int taf_hash()
  {
    return ay.a.a().a;
  }
  
  public av taf_hash(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = -paramInt;
    }
    ay.a.a().a = i1;
    return this;
  }
  
  public long taf_idleStatusInteval()
  {
    return this.b.l;
  }
  
  public void taf_idleStatusInteval(long paramLong)
  {
    if (paramLong > 30000L)
    {
      this.b.l = paramLong;
      return;
    }
    throw new IllegalArgumentException("idleStatusInteval must Greater than 30000");
  }
  
  public void taf_init(aq paramaq, bj parambj, CopyOnWriteArrayList<Integer> paramCopyOnWriteArrayList, hs paramhs)
  {
    this.b = paramaq;
    this.e = new az(paramaq.c());
    this.c = parambj;
    this.c.a(this);
    this.c.a(paramCopyOnWriteArrayList);
    this.d = paramhs;
    ba.a.a(this);
  }
  
  public byte[] taf_invoke(String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    return a(null, paramString, paramArrayOfByte, paramMap, new HashMap(), true, false);
  }
  
  public byte[] taf_invoke(String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    return a(null, paramString, paramArrayOfByte, paramMap1, paramMap2, true, false);
  }
  
  public int taf_min_timeout_invoke()
  {
    return this.l;
  }
  
  public void taf_min_timeout_invoke(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void taf_pointStatInterv(List<Integer> paramList)
  {
    this.c.a(paramList);
  }
  
  public String taf_proxyName()
  {
    return this.h;
  }
  
  public void taf_proxyName(String paramString)
  {
    this.h = paramString;
  }
  
  public int taf_readBufferSize()
  {
    return this.b.i;
  }
  
  public void taf_readBufferSize(int paramInt)
  {
    if (paramInt > 0)
    {
      this.b.i = paramInt;
      return;
    }
    throw new IllegalArgumentException("readBufferSize must Greater than zero");
  }
  
  public long taf_referNodeInterv()
  {
    return ba.a();
  }
  
  public void taf_referNodeInterv(int paramInt) {}
  
  public int taf_refreshEndPInterval()
  {
    return this.b.b;
  }
  
  public void taf_refreshEndPInterval(int paramInt)
  {
    this.b.b = paramInt;
  }
  
  public void taf_set_router(ax paramax)
  {
    this.a = paramax;
  }
  
  public int taf_sync_timeout()
  {
    return this.b.d;
  }
  
  public void taf_sync_timeout(int paramInt)
  {
    this.b.d = paramInt;
  }
  
  public bb taf_tAdapterSelector()
  {
    return this.c.d();
  }
  
  public void taf_tAdapterSelector(bb parambb)
  {
    this.c.a(parambb);
  }
  
  public int taf_timeout_interval()
  {
    return this.m;
  }
  
  public void taf_timeout_interval(int paramInt)
  {
    this.m = paramInt;
  }
  
  public float taf_timeout_radio()
  {
    return this.o;
  }
  
  public void taf_timeout_radio(float paramFloat)
  {
    this.o = paramFloat;
  }
  
  public int taf_try_time_interval()
  {
    return this.p;
  }
  
  public void taf_try_time_interval(int paramInt)
  {
    this.p = paramInt;
  }
  
  public int taf_writeBufferSize()
  {
    return this.b.j;
  }
  
  public void taf_writeBufferSize(int paramInt)
  {
    if (paramInt > 0)
    {
      this.b.j = paramInt;
      return;
    }
    throw new IllegalArgumentException("writeBuffer must Greater than zero");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.av
 * JD-Core Version:    0.7.0.1
 */