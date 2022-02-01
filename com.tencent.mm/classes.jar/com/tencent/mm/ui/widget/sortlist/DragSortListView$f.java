package com.tencent.mm.ui.widget.sortlist;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ap;
import java.io.File;
import java.io.IOException;

final class DragSortListView$f
{
  File Iej;
  int Lfa;
  int Lfb;
  boolean Lfc;
  StringBuilder mBuilder;
  
  DragSortListView$f(DragSortListView paramDragSortListView)
  {
    AppMethodBeat.i(159774);
    this.mBuilder = new StringBuilder();
    this.Lfa = 0;
    this.Lfb = 0;
    this.Lfc = false;
    this.Iej = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
    if (!this.Iej.exists()) {
      try
      {
        if (!this.Iej.createNewFile()) {
          ap.e("mobeta", "creat file fail!! file already exist", new Object[0]);
        }
        ap.d("mobeta", "file created", new Object[0]);
        AppMethodBeat.o(159774);
        return;
      }
      catch (IOException paramDragSortListView)
      {
        ap.w("mobeta", "Could not create dslv_state.txt", new Object[0]);
        ap.d("mobeta", paramDragSortListView.getMessage(), new Object[0]);
      }
    }
    AppMethodBeat.o(159774);
  }
  
  /* Error */
  public final void flush()
  {
    // Byte code:
    //   0: ldc 97
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 45	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:Lfc	Z
    //   9: ifne +9 -> 18
    //   12: ldc 97
    //   14: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: return
    //   18: aload_0
    //   19: getfield 43	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:Lfb	I
    //   22: ifne +190 -> 212
    //   25: iconst_0
    //   26: istore_1
    //   27: new 99	java/io/BufferedWriter
    //   30: dup
    //   31: new 101	java/io/OutputStreamWriter
    //   34: dup
    //   35: new 103	java/io/FileOutputStream
    //   38: dup
    //   39: aload_0
    //   40: getfield 60	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:Iej	Ljava/io/File;
    //   43: iload_1
    //   44: invokespecial 106	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   47: ldc 108
    //   49: invokespecial 111	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   52: invokespecial 114	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   55: astore_2
    //   56: aload_2
    //   57: aload_0
    //   58: getfield 39	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:mBuilder	Ljava/lang/StringBuilder;
    //   61: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokevirtual 123	java/io/Writer:write	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: getfield 39	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:mBuilder	Ljava/lang/StringBuilder;
    //   71: iconst_0
    //   72: aload_0
    //   73: getfield 39	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:mBuilder	Ljava/lang/StringBuilder;
    //   76: invokevirtual 127	java/lang/StringBuilder:length	()I
    //   79: invokevirtual 131	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_2
    //   84: invokevirtual 133	java/io/Writer:flush	()V
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 43	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:Lfb	I
    //   92: iconst_1
    //   93: iadd
    //   94: putfield 43	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:Lfb	I
    //   97: aload_2
    //   98: invokevirtual 136	java/io/Writer:close	()V
    //   101: ldc 97
    //   103: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: return
    //   107: astore_2
    //   108: ldc 138
    //   110: aload_2
    //   111: ldc 140
    //   113: iconst_0
    //   114: anewarray 4	java/lang/Object
    //   117: invokestatic 144	com/tencent/mm/ui/ap:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: ldc 97
    //   122: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: return
    //   126: astore_2
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_2
    //   130: ifnull +7 -> 137
    //   133: aload_2
    //   134: invokevirtual 136	java/io/Writer:close	()V
    //   137: ldc 97
    //   139: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: return
    //   143: astore_2
    //   144: ldc 138
    //   146: aload_2
    //   147: ldc 140
    //   149: iconst_0
    //   150: anewarray 4	java/lang/Object
    //   153: invokestatic 144	com/tencent/mm/ui/ap:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: ldc 97
    //   158: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: return
    //   162: astore_2
    //   163: aconst_null
    //   164: astore_3
    //   165: aload_3
    //   166: ifnull +7 -> 173
    //   169: aload_3
    //   170: invokevirtual 136	java/io/Writer:close	()V
    //   173: ldc 97
    //   175: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aload_2
    //   179: athrow
    //   180: astore_3
    //   181: ldc 138
    //   183: aload_3
    //   184: ldc 140
    //   186: iconst_0
    //   187: anewarray 4	java/lang/Object
    //   190: invokestatic 144	com/tencent/mm/ui/ap:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: goto -20 -> 173
    //   196: astore_3
    //   197: aload_2
    //   198: astore 4
    //   200: aload_3
    //   201: astore_2
    //   202: aload 4
    //   204: astore_3
    //   205: goto -40 -> 165
    //   208: astore_3
    //   209: goto -80 -> 129
    //   212: iconst_1
    //   213: istore_1
    //   214: goto -187 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	f
    //   26	188	1	bool	boolean
    //   55	43	2	localBufferedWriter	java.io.BufferedWriter
    //   107	4	2	localIOException1	IOException
    //   126	1	2	localIOException2	IOException
    //   128	6	2	localObject1	Object
    //   143	4	2	localIOException3	IOException
    //   162	36	2	localObject2	Object
    //   201	1	2	localObject3	Object
    //   164	6	3	localObject4	Object
    //   180	4	3	localIOException4	IOException
    //   196	5	3	localObject5	Object
    //   204	1	3	localObject6	Object
    //   208	1	3	localIOException5	IOException
    //   198	5	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   97	101	107	java/io/IOException
    //   18	25	126	java/io/IOException
    //   27	56	126	java/io/IOException
    //   133	137	143	java/io/IOException
    //   18	25	162	finally
    //   27	56	162	finally
    //   169	173	180	java/io/IOException
    //   56	97	196	finally
    //   56	97	208	java/io/IOException
  }
  
  public final void stopTracking()
  {
    AppMethodBeat.i(159776);
    if (this.Lfc)
    {
      this.mBuilder.append("</DSLVStates>\n");
      flush();
      this.Lfc = false;
    }
    AppMethodBeat.o(159776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.f
 * JD-Core Version:    0.7.0.1
 */