package com.tencent.mm.plugin.secdata.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/secdata/model/SecReportDataInfoStorage;", "", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getDb", "()Lcom/tencent/mm/storagebase/SqliteDB;", "cleanExpireData", "", "delete", "", "id", "getById", "Lcom/tencent/mm/plugin/secdata/model/SecReportDataInfo;", "insert", "", "info", "replace", "Companion", "plugin-sec-data_release"})
public final class d
{
  private static final String[] CWl;
  public static final a CWm;
  public final String TAG;
  public final h iFy;
  
  static
  {
    AppMethodBeat.i(219182);
    CWm = new a((byte)0);
    b.a locala = b.CWj;
    CWl = new String[] { MAutoStorage.getCreateSQLs(b.access$getInfo$cp(), "SecReportDataInfo"), "CREATE INDEX IF NOT EXISTS SecReportDataInfo_indexData ON SecReportDataInfo (indexData)" };
    AppMethodBeat.o(219182);
  }
  
  public d(h paramh)
  {
    AppMethodBeat.i(219181);
    this.iFy = paramh;
    this.TAG = "MicroMsg.SecData.SecReportDataInfoStorage";
    AppMethodBeat.o(219181);
  }
  
  public final long a(b paramb)
  {
    AppMethodBeat.i(219178);
    p.h(paramb, "info");
    long l = this.iFy.insert("SecReportDataInfo", "id", paramb.convertTo());
    Log.i(this.TAG, "insert id:" + paramb.field_id + " info:" + paramb + " result:" + l);
    AppMethodBeat.o(219178);
    return l;
  }
  
  /* Error */
  public final b aMZ(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 153
    //   4: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 107
    //   10: invokestatic 92	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 97	com/tencent/mm/plugin/secdata/a/d:iFy	Lcom/tencent/mm/storagebase/h;
    //   17: ldc 155
    //   19: iconst_1
    //   20: anewarray 64	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: aload_1
    //   26: aastore
    //   27: invokevirtual 159	com/tencent/mm/storagebase/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore 5
    //   32: aload 5
    //   34: checkcast 161	java/io/Closeable
    //   37: astore 4
    //   39: aload 5
    //   41: invokeinterface 167 1 0
    //   46: ifeq +95 -> 141
    //   49: new 58	com/tencent/mm/plugin/secdata/a/b
    //   52: dup
    //   53: invokespecial 168	com/tencent/mm/plugin/secdata/a/b:<init>	()V
    //   56: astore_2
    //   57: aload_2
    //   58: aload 5
    //   60: invokevirtual 172	com/tencent/mm/plugin/secdata/a/b:convertFrom	(Landroid/database/Cursor;)V
    //   63: getstatic 178	kotlin/x:SXb	Lkotlin/x;
    //   66: astore 5
    //   68: aload 4
    //   70: aconst_null
    //   71: invokestatic 183	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   74: aload_0
    //   75: getfield 101	com/tencent/mm/plugin/secdata/a/d:TAG	Ljava/lang/String;
    //   78: new 118	java/lang/StringBuilder
    //   81: dup
    //   82: ldc 185
    //   84: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   87: aload_1
    //   88: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc 132
    //   93: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_2
    //   97: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: ldc 153
    //   108: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_2
    //   112: areturn
    //   113: astore_2
    //   114: ldc 153
    //   116: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aload_2
    //   120: athrow
    //   121: astore_1
    //   122: aload 4
    //   124: aload_2
    //   125: invokestatic 183	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   128: ldc 153
    //   130: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_1
    //   134: athrow
    //   135: astore_1
    //   136: aload_3
    //   137: astore_2
    //   138: goto -16 -> 122
    //   141: aconst_null
    //   142: astore_2
    //   143: goto -80 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	d
    //   0	146	1	paramString	String
    //   56	56	2	localb	b
    //   113	12	2	localThrowable	java.lang.Throwable
    //   137	6	2	localObject1	Object
    //   1	136	3	localObject2	Object
    //   37	86	4	localCloseable	java.io.Closeable
    //   30	37	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   39	63	113	java/lang/Throwable
    //   63	68	113	java/lang/Throwable
    //   114	121	121	finally
    //   39	63	135	finally
    //   63	68	135	finally
  }
  
  public final int aNa(String paramString)
  {
    AppMethodBeat.i(219180);
    p.h(paramString, "id");
    int i = this.iFy.delete("SecReportDataInfo", "id = ?", new String[] { paramString });
    Log.i(this.TAG, "replace id:" + paramString + " result:" + i);
    AppMethodBeat.o(219180);
    return i;
  }
  
  public final long b(b paramb)
  {
    AppMethodBeat.i(219179);
    p.h(paramb, "info");
    long l = this.iFy.replace("SecReportDataInfo", "id", paramb.convertTo());
    Log.i(this.TAG, "replace id:" + paramb.field_id + " info:" + paramb + " result:" + l);
    AppMethodBeat.o(219179);
    return l;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/secdata/model/SecReportDataInfoStorage$Companion;", "", "()V", "CREATE_SQLS", "", "", "kotlin.jvm.PlatformType", "getCREATE_SQLS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "plugin-sec-data_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.a.d
 * JD-Core Version:    0.7.0.1
 */