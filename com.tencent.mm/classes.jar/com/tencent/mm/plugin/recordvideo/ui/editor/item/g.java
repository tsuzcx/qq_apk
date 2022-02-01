package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.c.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.f;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.h;
import com.tencent.mm.protocal.protobuf.ctg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/FinderLyricsItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentTime", "", "lastLrcTime", "getLastLrcTime", "()J", "musicDuration", "getMusicDuration", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "fillAlpha", "", "fillWaveAlpha", "appearTime", "getLyricsEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorItem;", "item", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "nextIndex", "onDraw", "canvas", "Landroid/graphics/Canvas;", "renderLyrics", "lyricsItem", "showAtTime", "", "currentMs", "Companion", "plugin-recordvideo_release"})
public final class g
  extends n
{
  public static final a Icu;
  private long lwE;
  
  static
  {
    AppMethodBeat.i(224732);
    Icu = new a((byte)0);
    AppMethodBeat.o(224732);
  }
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  private final long getLastLrcTime()
  {
    AppMethodBeat.i(224688);
    if (getMusicDuration() > 0L)
    {
      l1 = getMusicDuration();
      AppMethodBeat.o(224688);
      return l1;
    }
    long l1 = ((ctg)j.lq((List)getLyricsList())).startTime;
    long l2 = getLAST_INTERVAL();
    AppMethodBeat.o(224688);
    return l1 + l2;
  }
  
  private final long getMusicDuration()
  {
    AppMethodBeat.i(224686);
    m localm = getLyricsItem();
    if (localm != null)
    {
      long l = localm.Icy;
      AppMethodBeat.o(224686);
      return l;
    }
    AppMethodBeat.o(224686);
    return 0L;
  }
  
  public final boolean PA(long paramLong)
  {
    AppMethodBeat.i(224693);
    for (this.lwE = paramLong; this.lwE > getLastLrcTime(); this.lwE -= getLastLrcTime()) {}
    boolean bool = super.PA(paramLong);
    AppMethodBeat.o(224693);
    return bool;
  }
  
  protected final void PC(long paramLong)
  {
    AppMethodBeat.i(224706);
    long l1;
    long l2;
    if (getWaveAlpha() < 255)
    {
      l1 = getTRANS_TIME();
      l2 = this.lwE - paramLong;
      if (0L <= l2) {
        break label62;
      }
    }
    label62:
    while (l1 < l2)
    {
      if (this.lwE - paramLong > getTRANS_TIME()) {
        setWaveAlpha(255);
      }
      AppMethodBeat.o(224706);
      return;
    }
    setWaveAlpha((int)(255.0F * (float)(this.lwE - paramLong) / (float)getTRANS_TIME()));
    AppMethodBeat.o(224706);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(224690);
    p.k(paramm, "lyricsItem");
    setLyricsItem(paramm);
    gS((List)paramm.Icx);
    AppMethodBeat.o(224690);
  }
  
  public final h b(m paramm)
  {
    AppMethodBeat.i(224730);
    p.k(paramm, "item");
    gS((List)paramm.Icx);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (Iterable)getLyricsList();
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.iBO();
      }
      localObject2 = (ctg)localObject2;
      Object localObject3 = getBitmapList().get(i);
      p.j(localObject3, "bitmapList[index]");
      localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g((ctg)localObject2, (Bitmap)localObject3));
      i += 1;
    }
    paramm = (h)new f((List)localArrayList, paramm.aHZ, getMusicDuration());
    AppMethodBeat.o(224730);
    return paramm;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(224728);
    if (getBitmapList().isEmpty())
    {
      AppMethodBeat.o(224728);
      return null;
    }
    paramMatrix = new ArrayList();
    Object localObject1 = (Iterable)getLyricsList();
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.iBO();
      }
      localObject2 = (ctg)localObject2;
      if (i < getBitmapList().size())
      {
        Object localObject3 = getBitmapList().get(i);
        p.j(localObject3, "bitmapList[index]");
        paramMatrix.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g((ctg)localObject2, (Bitmap)localObject3));
      }
      i += 1;
    }
    localObject1 = new Matrix();
    ((Matrix)localObject1).postConcat(getTouchTracker().aHZ);
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new f((List)paramMatrix, (Matrix)localObject1, getMusicDuration());
    AppMethodBeat.o(224728);
    return paramMatrix;
  }
  
  protected final void fyL()
  {
    AppMethodBeat.i(224700);
    if (getCurIndex() < getLyricsList().size())
    {
      long l2 = ((ctg)getLyricsList().get(getCurIndex())).startTime;
      ctg localctg = (ctg)j.M((List)getLyricsList(), getCurIndex() + 1);
      long l1;
      long l3;
      long l4;
      if (localctg != null)
      {
        l1 = localctg.startTime;
        l3 = getTRANS_TIME();
        l4 = this.lwE - l2;
        if (0L <= l4) {
          break label160;
        }
        label90:
        l3 = getTRANS_TIME();
        l4 = l1 - this.lwE;
        if (0L <= l4) {
          break label195;
        }
      }
      for (;;)
      {
        if ((this.lwE - l2 > getTRANS_TIME()) && (l1 - this.lwE > getTRANS_TIME()))
        {
          setAlpha(255);
          AppMethodBeat.o(224700);
          return;
          l1 = getLastLrcTime();
          break;
          label160:
          if (l3 < l4) {
            break label90;
          }
          setAlpha((int)((float)(this.lwE - l2) * 255.0F / (float)getTRANS_TIME()));
          AppMethodBeat.o(224700);
          return;
          label195:
          if (l3 >= l4)
          {
            setAlpha((int)((float)(l1 - this.lwE) / (float)getTRANS_TIME() * 255.0F));
            AppMethodBeat.o(224700);
            return;
          }
        }
      }
      setAlpha(0);
    }
    AppMethodBeat.o(224700);
  }
  
  protected final void fyM()
  {
    AppMethodBeat.i(224714);
    if (getLyricsList().isEmpty())
    {
      AppMethodBeat.o(224714);
      return;
    }
    Object localObject = (List)getLyricsList();
    localObject = ((List)localObject).listIterator(((List)localObject).size());
    if (((ListIterator)localObject).hasPrevious())
    {
      ctg localctg = (ctg)((ListIterator)localObject).previous();
      if (this.lwE >= localctg.startTime)
      {
        i = 1;
        label75:
        if (i == 0) {
          break label104;
        }
      }
    }
    for (int i = ((ListIterator)localObject).nextIndex();; i = -1)
    {
      setCurIndex(Math.max(0, i));
      AppMethodBeat.o(224714);
      return;
      i = 0;
      break label75;
      label104:
      break;
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(224718);
    p.k(paramCanvas, "canvas");
    paramCanvas.save();
    if (getViewMatrix() != null)
    {
      paramCanvas.setMatrix(getViewMatrix());
      if (isActivated()) {
        getFrameDrawable().draw(paramCanvas);
      }
      fyM();
      x(paramCanvas);
      if (((Collection)getBitmapList()).isEmpty()) {
        break label170;
      }
    }
    label170:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (getCurIndex() < getBitmapList().size()))
      {
        fyL();
        getPaint().setAlpha(getAlpha());
        paramCanvas.drawBitmap((Bitmap)getBitmapList().get(getCurIndex()), 0.0F, getLYRICS_VERTICAL_OFFSET(), getPaint());
      }
      paramCanvas.restore();
      if (getNeedInvalidate()) {
        invalidate();
      }
      AppMethodBeat.o(224718);
      return;
      paramCanvas.setMatrix(getTouchTracker().aHZ);
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/FinderLyricsItemView$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.g
 * JD-Core Version:    0.7.0.1
 */