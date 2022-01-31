package com.tencent.mm.ui.widget.sortlist;

import android.os.Environment;
import com.tencent.mm.ui.ao;
import java.io.File;
import java.io.IOException;

final class DragSortListView$f
{
  File fDw = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
  StringBuilder mBuilder = new StringBuilder();
  int wrN = 0;
  int wrO = 0;
  boolean wrP = false;
  
  DragSortListView$f(DragSortListView paramDragSortListView)
  {
    if (!this.fDw.exists()) {}
    try
    {
      if (!this.fDw.createNewFile()) {
        ao.v("creat file fail!! file already exist", new Object[0]);
      }
      ao.s("file created", new Object[0]);
      return;
    }
    catch (IOException paramDragSortListView)
    {
      ao.u("Could not create dslv_state.txt", new Object[0]);
      ao.s(paramDragSortListView.getMessage(), new Object[0]);
    }
  }
  
  /* Error */
  public final void flush()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:wrP	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 36	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:wrO	I
    //   12: ifne +159 -> 171
    //   15: iconst_0
    //   16: istore_1
    //   17: new 86	java/io/BufferedWriter
    //   20: dup
    //   21: new 88	java/io/OutputStreamWriter
    //   24: dup
    //   25: new 90	java/io/FileOutputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield 53	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:fDw	Ljava/io/File;
    //   33: iload_1
    //   34: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   37: ldc 95
    //   39: invokespecial 98	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   42: invokespecial 101	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   45: astore_2
    //   46: aload_2
    //   47: aload_0
    //   48: getfield 32	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:mBuilder	Ljava/lang/StringBuilder;
    //   51: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokevirtual 110	java/io/Writer:write	(Ljava/lang/String;)V
    //   57: aload_0
    //   58: getfield 32	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:mBuilder	Ljava/lang/StringBuilder;
    //   61: iconst_0
    //   62: aload_0
    //   63: getfield 32	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:mBuilder	Ljava/lang/StringBuilder;
    //   66: invokevirtual 114	java/lang/StringBuilder:length	()I
    //   69: invokevirtual 118	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_2
    //   74: invokevirtual 120	java/io/Writer:flush	()V
    //   77: aload_0
    //   78: aload_0
    //   79: getfield 36	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:wrO	I
    //   82: iconst_1
    //   83: iadd
    //   84: putfield 36	com/tencent/mm/ui/widget/sortlist/DragSortListView$f:wrO	I
    //   87: aload_2
    //   88: invokevirtual 123	java/io/Writer:close	()V
    //   91: return
    //   92: astore_2
    //   93: aload_2
    //   94: ldc 125
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 129	com/tencent/mm/ui/ao:a	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: return
    //   104: astore_2
    //   105: aconst_null
    //   106: astore_2
    //   107: aload_2
    //   108: ifnull -101 -> 7
    //   111: aload_2
    //   112: invokevirtual 123	java/io/Writer:close	()V
    //   115: return
    //   116: astore_2
    //   117: aload_2
    //   118: ldc 125
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 129	com/tencent/mm/ui/ao:a	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: return
    //   128: astore_2
    //   129: aconst_null
    //   130: astore_3
    //   131: aload_3
    //   132: ifnull +7 -> 139
    //   135: aload_3
    //   136: invokevirtual 123	java/io/Writer:close	()V
    //   139: aload_2
    //   140: athrow
    //   141: astore_3
    //   142: aload_3
    //   143: ldc 125
    //   145: iconst_0
    //   146: anewarray 4	java/lang/Object
    //   149: invokestatic 129	com/tencent/mm/ui/ao:a	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: goto -13 -> 139
    //   155: astore_3
    //   156: aload_2
    //   157: astore 4
    //   159: aload_3
    //   160: astore_2
    //   161: aload 4
    //   163: astore_3
    //   164: goto -33 -> 131
    //   167: astore_3
    //   168: goto -61 -> 107
    //   171: iconst_1
    //   172: istore_1
    //   173: goto -156 -> 17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	f
    //   16	157	1	bool	boolean
    //   45	43	2	localBufferedWriter	java.io.BufferedWriter
    //   92	2	2	localIOException1	IOException
    //   104	1	2	localIOException2	IOException
    //   106	6	2	localObject1	Object
    //   116	2	2	localIOException3	IOException
    //   128	29	2	localObject2	Object
    //   160	1	2	localObject3	Object
    //   130	6	3	localObject4	Object
    //   141	2	3	localIOException4	IOException
    //   155	5	3	localObject5	Object
    //   163	1	3	localObject6	Object
    //   167	1	3	localIOException5	IOException
    //   157	5	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   87	91	92	java/io/IOException
    //   8	15	104	java/io/IOException
    //   17	46	104	java/io/IOException
    //   111	115	116	java/io/IOException
    //   8	15	128	finally
    //   17	46	128	finally
    //   135	139	141	java/io/IOException
    //   46	87	155	finally
    //   46	87	167	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.f
 * JD-Core Version:    0.7.0.1
 */