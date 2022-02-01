package com.tencent.mm.plugin.recordvideo.background;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "cleanExpiredTask", "", "deleteByTaskId", "taskId", "", "droptable", "", "getByTaskId", "getLastDataIfNoMix", "limitTime", "", "updateByTaskId", "editorData", "Companion", "plugin-recordvideo_release"})
public final class f
  extends j<e>
{
  private static final String[] SQL_CREATE;
  static final String TABLE = "VideoEditInfo";
  private static final String TAG = "MicroMsg.VideoEditDataStorage";
  public static final f.a wmu;
  final com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(75188);
    wmu = new f.a((byte)0);
    TAG = "MicroMsg.VideoEditDataStorage";
    Object localObject = e.wmq;
    localObject = e.dul();
    e.a locala = e.wmq;
    SQL_CREATE = new String[] { j.getCreateSQLs((c.a)localObject, e.dum()) };
    localObject = e.wmq;
    TABLE = e.dum();
    AppMethodBeat.o(75188);
  }
  
  public f(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, (c.a)localObject1, (String)localObject2, e.dun());
    AppMethodBeat.i(75187);
    this.db = parame;
    AppMethodBeat.o(75187);
  }
  
  public final int a(String paramString, e parame)
  {
    AppMethodBeat.i(75184);
    k.h(paramString, "taskId");
    k.h(parame, "editorData");
    parame = parame.convertTo();
    parame.remove("rowid");
    int i = this.db.update(TABLE, parame, "taskId=?", new String[] { String.valueOf(paramString) });
    AppMethodBeat.o(75184);
    return i;
  }
  
  /* Error */
  public final e aqx(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 144
    //   4: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 114
    //   10: invokestatic 99	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 150	d/g/b/z:KUT	Ld/g/b/z;
    //   16: astore_3
    //   17: ldc 152
    //   19: iconst_3
    //   20: anewarray 154	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: getstatic 87	com/tencent/mm/plugin/recordvideo/background/f:TABLE	Ljava/lang/String;
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: ldc 114
    //   33: aastore
    //   34: dup
    //   35: iconst_2
    //   36: aload_1
    //   37: aastore
    //   38: iconst_3
    //   39: invokestatic 160	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   42: invokestatic 164	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   45: astore_1
    //   46: aload_1
    //   47: ldc 166
    //   49: invokestatic 169	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   52: aload_0
    //   53: aload_1
    //   54: iconst_0
    //   55: anewarray 75	java/lang/String
    //   58: invokevirtual 173	com/tencent/mm/plugin/recordvideo/background/f:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +59 -> 122
    //   66: aload_1
    //   67: checkcast 175	java/io/Closeable
    //   70: astore_3
    //   71: aload_3
    //   72: checkcast 177	android/database/Cursor
    //   75: astore_1
    //   76: aload_1
    //   77: invokeinterface 181 1 0
    //   82: ifeq +31 -> 113
    //   85: new 65	com/tencent/mm/plugin/recordvideo/background/e
    //   88: dup
    //   89: invokespecial 183	com/tencent/mm/plugin/recordvideo/background/e:<init>	()V
    //   92: astore 4
    //   94: aload 4
    //   96: aload_1
    //   97: invokevirtual 187	com/tencent/mm/plugin/recordvideo/background/e:convertFrom	(Landroid/database/Cursor;)V
    //   100: aload_3
    //   101: aconst_null
    //   102: invokestatic 192	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   105: ldc 144
    //   107: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload 4
    //   112: areturn
    //   113: getstatic 198	d/y:KTp	Ld/y;
    //   116: astore_1
    //   117: aload_3
    //   118: aconst_null
    //   119: invokestatic 192	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   122: ldc 144
    //   124: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_2
    //   130: ldc 144
    //   132: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_2
    //   136: athrow
    //   137: astore_1
    //   138: aload_3
    //   139: aload_2
    //   140: invokestatic 192	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   143: ldc 144
    //   145: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aload_1
    //   149: athrow
    //   150: astore_1
    //   151: goto -13 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	f
    //   0	154	1	paramString	String
    //   1	1	2	localObject1	Object
    //   129	11	2	localThrowable	java.lang.Throwable
    //   16	123	3	localObject2	Object
    //   92	19	4	locale	e
    // Exception table:
    //   from	to	target	type
    //   71	100	129	java/lang/Throwable
    //   113	117	129	java/lang/Throwable
    //   130	137	137	finally
    //   71	100	150	finally
    //   113	117	150	finally
  }
  
  public final void duq()
  {
    AppMethodBeat.i(75186);
    int i = this.db.delete(TABLE, null, null);
    ac.i(TAG, "dropTable ".concat(String.valueOf(i)));
    AppMethodBeat.o(75186);
  }
  
  /* Error */
  public final e ww(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 221
    //   5: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 150	d/g/b/z:KUT	Ld/g/b/z;
    //   11: astore 4
    //   13: getstatic 87	com/tencent/mm/plugin/recordvideo/background/f:TABLE	Ljava/lang/String;
    //   16: astore 4
    //   18: getstatic 227	com/tencent/mm/plugin/recordvideo/background/e$b:wmt	Lcom/tencent/mm/plugin/recordvideo/background/e$b;
    //   21: astore 6
    //   23: invokestatic 231	com/tencent/mm/plugin/recordvideo/background/e$b:bsf	()I
    //   26: istore_3
    //   27: getstatic 227	com/tencent/mm/plugin/recordvideo/background/e$b:wmt	Lcom/tencent/mm/plugin/recordvideo/background/e$b;
    //   30: astore 6
    //   32: ldc 233
    //   34: bipush 8
    //   36: anewarray 154	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload 4
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: ldc 235
    //   48: aastore
    //   49: dup
    //   50: iconst_2
    //   51: iload_3
    //   52: invokestatic 240	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: dup
    //   57: iconst_3
    //   58: invokestatic 243	com/tencent/mm/plugin/recordvideo/background/e$b:dup	()I
    //   61: invokestatic 240	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   64: aastore
    //   65: dup
    //   66: iconst_4
    //   67: ldc 245
    //   69: aastore
    //   70: dup
    //   71: iconst_5
    //   72: lload_1
    //   73: invokestatic 250	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: aastore
    //   77: dup
    //   78: bipush 6
    //   80: ldc 252
    //   82: aastore
    //   83: dup
    //   84: bipush 7
    //   86: ldc 245
    //   88: aastore
    //   89: bipush 8
    //   91: invokestatic 160	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   94: invokestatic 164	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   97: astore 4
    //   99: aload 4
    //   101: ldc 166
    //   103: invokestatic 169	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   106: aload_0
    //   107: aload 4
    //   109: iconst_0
    //   110: anewarray 75	java/lang/String
    //   113: invokevirtual 173	com/tencent/mm/plugin/recordvideo/background/f:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   116: astore 4
    //   118: aload 4
    //   120: ifnull +68 -> 188
    //   123: aload 4
    //   125: checkcast 175	java/io/Closeable
    //   128: astore 6
    //   130: aload 6
    //   132: checkcast 177	android/database/Cursor
    //   135: astore 4
    //   137: aload 4
    //   139: invokeinterface 181 1 0
    //   144: ifeq +33 -> 177
    //   147: new 65	com/tencent/mm/plugin/recordvideo/background/e
    //   150: dup
    //   151: invokespecial 183	com/tencent/mm/plugin/recordvideo/background/e:<init>	()V
    //   154: astore 7
    //   156: aload 7
    //   158: aload 4
    //   160: invokevirtual 187	com/tencent/mm/plugin/recordvideo/background/e:convertFrom	(Landroid/database/Cursor;)V
    //   163: aload 6
    //   165: aconst_null
    //   166: invokestatic 192	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   169: ldc 221
    //   171: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload 7
    //   176: areturn
    //   177: getstatic 198	d/y:KTp	Ld/y;
    //   180: astore 4
    //   182: aload 6
    //   184: aconst_null
    //   185: invokestatic 192	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   188: ldc 221
    //   190: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aconst_null
    //   194: areturn
    //   195: astore 5
    //   197: ldc 221
    //   199: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload 5
    //   204: athrow
    //   205: astore 4
    //   207: aload 6
    //   209: aload 5
    //   211: invokestatic 192	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   214: ldc 221
    //   216: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload 4
    //   221: athrow
    //   222: astore 4
    //   224: goto -17 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	f
    //   0	227	1	paramLong	long
    //   26	26	3	i	int
    //   11	170	4	localObject1	Object
    //   205	15	4	localObject2	Object
    //   222	1	4	localObject3	Object
    //   1	1	5	localObject4	Object
    //   195	15	5	localThrowable	java.lang.Throwable
    //   21	187	6	localObject5	Object
    //   154	21	7	locale	e
    // Exception table:
    //   from	to	target	type
    //   130	163	195	java/lang/Throwable
    //   177	182	195	java/lang/Throwable
    //   197	205	205	finally
    //   130	163	222	finally
    //   177	182	222	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.f
 * JD-Core Version:    0.7.0.1
 */