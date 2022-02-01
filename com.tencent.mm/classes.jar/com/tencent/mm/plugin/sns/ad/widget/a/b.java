package com.tencent.mm.plugin.sns.ad.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import java.util.ArrayList;

public abstract class b
{
  protected a Qhg;
  protected int Qhh;
  protected int Qhi;
  protected ArrayList<Rect> Qhj = new ArrayList();
  protected Context mContext;
  
  public b(Context paramContext, a parama)
  {
    this.mContext = paramContext;
    this.Qhg = parama;
    if (this.Qhh == 0) {
      this.Qhh = a.fromDPToPix(this.mContext, 180);
    }
    if (this.Qhi == 0) {
      this.Qhi = a.fromDPToPix(this.mContext, 220);
    }
  }
  
  protected static Rect a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 /= 2;
    paramRect.left = (paramInt1 - paramInt3);
    paramRect.right = (paramInt1 + paramInt3);
    paramRect.top = (paramInt2 - paramInt3);
    paramRect.bottom = (paramInt3 + paramInt2);
    return paramRect;
  }
  
  protected abstract void B(Rect paramRect);
  
  public void clear()
  {
    try
    {
      this.Qhj.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected abstract Rect hdf();
  
  /* Error */
  protected final void hdg()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 66	com/tencent/mm/plugin/sns/ad/widget/a/b:clear	()V
    //   6: aload_0
    //   7: getfield 31	com/tencent/mm/plugin/sns/ad/widget/a/b:Qhg	Lcom/tencent/mm/plugin/sns/ad/widget/a/b$a;
    //   10: getfield 69	com/tencent/mm/plugin/sns/ad/widget/a/b$a:Qhn	I
    //   13: istore_2
    //   14: iconst_0
    //   15: istore_1
    //   16: iload_1
    //   17: iload_2
    //   18: if_icmpge +22 -> 40
    //   21: aload_0
    //   22: getfield 27	com/tencent/mm/plugin/sns/ad/widget/a/b:Qhj	Ljava/util/ArrayList;
    //   25: aload_0
    //   26: invokevirtual 71	com/tencent/mm/plugin/sns/ad/widget/a/b:hdf	()Landroid/graphics/Rect;
    //   29: invokevirtual 75	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   32: pop
    //   33: iload_1
    //   34: iconst_1
    //   35: iadd
    //   36: istore_1
    //   37: goto -21 -> 16
    //   40: aload_0
    //   41: getfield 27	com/tencent/mm/plugin/sns/ad/widget/a/b:Qhj	Ljava/util/ArrayList;
    //   44: invokevirtual 79	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   47: astore_3
    //   48: aload_3
    //   49: invokeinterface 85 1 0
    //   54: ifeq +44 -> 98
    //   57: aload_0
    //   58: aload_3
    //   59: invokeinterface 89 1 0
    //   64: checkcast 45	android/graphics/Rect
    //   67: invokevirtual 91	com/tencent/mm/plugin/sns/ad/widget/a/b:B	(Landroid/graphics/Rect;)V
    //   70: goto -22 -> 48
    //   73: astore_3
    //   74: ldc 93
    //   76: new 95	java/lang/StringBuilder
    //   79: dup
    //   80: ldc 97
    //   82: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   85: aload_3
    //   86: invokestatic 106	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   89: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 120	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: astore_3
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_3
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	b
    //   15	22	1	i	int
    //   13	6	2	j	int
    //   47	12	3	localIterator	java.util.Iterator
    //   73	13	3	localThrowable	java.lang.Throwable
    //   101	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	73	finally
    //   21	33	73	finally
    //   40	48	73	finally
    //   48	70	73	finally
    //   74	98	101	finally
  }
  
  public static final class a
  {
    public Bitmap Qhk;
    public int Qhl;
    public int Qhm;
    public int Qhn;
    public int duration;
    public int maxSize;
    public int oQY;
    
    public final String toString()
    {
      AppMethodBeat.i(310138);
      String str = "SceneParams{bmp=" + this.Qhk + ", minSize=" + this.oQY + ", maxSize=" + this.maxSize + ", duration=" + this.duration + ", sceneWidth=" + this.Qhl + ", sceneHeight=" + this.Qhm + ", spriteNum=" + this.Qhn + '}';
      AppMethodBeat.o(310138);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.a.b
 * JD-Core Version:    0.7.0.1
 */