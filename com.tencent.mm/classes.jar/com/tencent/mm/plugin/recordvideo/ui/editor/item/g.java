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
import com.tencent.mm.protocal.protobuf.dki;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/FinderLyricsItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentTime", "", "lastLrcTime", "getLastLrcTime", "()J", "musicDuration", "getMusicDuration", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "fillAlpha", "", "fillWaveAlpha", "appearTime", "getLyricsEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorItem;", "item", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "nextIndex", "onDraw", "canvas", "Landroid/graphics/Canvas;", "renderLyrics", "lyricsItem", "showAtTime", "", "currentMs", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends n
{
  public static final g.a NYQ;
  private long ood;
  
  static
  {
    AppMethodBeat.i(280384);
    NYQ = new g.a((byte)0);
    AppMethodBeat.o(280384);
  }
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  private final long getLastLrcTime()
  {
    AppMethodBeat.i(280377);
    if (getMusicDuration() > 0L)
    {
      l1 = getMusicDuration();
      AppMethodBeat.o(280377);
      return l1;
    }
    long l1 = ((dki)p.oM((List)getLyricsList())).startTime;
    long l2 = getLAST_INTERVAL();
    AppMethodBeat.o(280377);
    return l1 + l2;
  }
  
  private final long getMusicDuration()
  {
    AppMethodBeat.i(280367);
    m localm = getLyricsItem();
    if (localm == null)
    {
      AppMethodBeat.o(280367);
      return 0L;
    }
    long l = localm.NYV;
    AppMethodBeat.o(280367);
    return l;
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(280389);
    s.u(paramm, "lyricsItem");
    setLyricsItem(paramm);
    jS((List)paramm.NYU);
    AppMethodBeat.o(280389);
  }
  
  public final h b(m paramm)
  {
    AppMethodBeat.i(280435);
    s.u(paramm, "item");
    jS((List)paramm.NYU);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (Iterable)getLyricsList();
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (dki)localObject2;
      Object localObject3 = getBitmapList().get(i);
      s.s(localObject3, "bitmapList[index]");
      localArrayList.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g((dki)localObject2, (Bitmap)localObject3));
      i += 1;
    }
    paramm = (h)new f((List)localArrayList, paramm.matrix, getMusicDuration());
    AppMethodBeat.o(280435);
    return paramm;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a e(Matrix paramMatrix)
  {
    AppMethodBeat.i(280431);
    if (getBitmapList().isEmpty())
    {
      AppMethodBeat.o(280431);
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
        p.kkW();
      }
      localObject2 = (dki)localObject2;
      if (i < getBitmapList().size())
      {
        Object localObject3 = getBitmapList().get(i);
        s.s(localObject3, "bitmapList[index]");
        paramMatrix.add(new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g((dki)localObject2, (Bitmap)localObject3));
      }
      i += 1;
    }
    localObject1 = new Matrix();
    ((Matrix)localObject1).postConcat(getTouchTracker().matrix);
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new f((List)paramMatrix, (Matrix)localObject1, getMusicDuration());
    AppMethodBeat.o(280431);
    return paramMatrix;
  }
  
  protected final void gKx()
  {
    AppMethodBeat.i(280405);
    if (getCurIndex() < getLyricsList().size())
    {
      long l2 = ((dki)getLyricsList().get(getCurIndex())).startTime;
      Object localObject = (dki)p.ae((List)getLyricsList(), getCurIndex() + 1);
      long l1;
      label77:
      int i;
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          break label154;
        }
        l1 = getLastLrcTime();
        l3 = getTRANS_TIME();
        l4 = this.ood - l2;
        if (0L > l4) {
          break label168;
        }
        if (l4 > l3) {
          break label163;
        }
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label173;
        }
        setAlpha((int)(255.0F * (float)(this.ood - l2) / (float)getTRANS_TIME()));
        AppMethodBeat.o(280405);
        return;
        localObject = Long.valueOf(((dki)localObject).startTime);
        break;
        label154:
        l1 = ((Long)localObject).longValue();
        break label77;
        label163:
        i = 0;
        continue;
        label168:
        i = 0;
      }
      label173:
      long l3 = getTRANS_TIME();
      long l4 = l1 - this.ood;
      if (0L <= l4) {
        if (l4 <= l3) {
          i = 1;
        }
      }
      while (i != 0)
      {
        setAlpha((int)((float)(l1 - this.ood) / (float)getTRANS_TIME() * 255.0F));
        AppMethodBeat.o(280405);
        return;
        i = 0;
        continue;
        i = 0;
      }
      if ((this.ood - l2 > getTRANS_TIME()) && (l1 - this.ood > getTRANS_TIME()))
      {
        setAlpha(255);
        AppMethodBeat.o(280405);
        return;
      }
      setAlpha(0);
    }
    AppMethodBeat.o(280405);
  }
  
  protected final void gKy()
  {
    AppMethodBeat.i(280417);
    if (getLyricsList().isEmpty())
    {
      AppMethodBeat.o(280417);
      return;
    }
    Object localObject = (List)getLyricsList();
    localObject = ((List)localObject).listIterator(((List)localObject).size());
    if (((ListIterator)localObject).hasPrevious())
    {
      dki localdki = (dki)((ListIterator)localObject).previous();
      if (this.ood >= localdki.startTime)
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
      AppMethodBeat.o(280417);
      return;
      i = 0;
      break label75;
      label104:
      break;
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(280422);
    s.u(paramCanvas, "canvas");
    paramCanvas.save();
    if (getViewMatrix() != null)
    {
      paramCanvas.setMatrix(getViewMatrix());
      if (isActivated()) {
        getFrameDrawable().draw(paramCanvas);
      }
      gKy();
      s(paramCanvas);
      if (((Collection)getBitmapList()).isEmpty()) {
        break label170;
      }
    }
    label170:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (getCurIndex() < getBitmapList().size()))
      {
        gKx();
        getPaint().setAlpha(getAlpha());
        paramCanvas.drawBitmap((Bitmap)getBitmapList().get(getCurIndex()), 0.0F, getLYRICS_VERTICAL_OFFSET(), getPaint());
      }
      paramCanvas.restore();
      if (getNeedInvalidate()) {
        invalidate();
      }
      AppMethodBeat.o(280422);
      return;
      paramCanvas.setMatrix(getTouchTracker().matrix);
      break;
    }
  }
  
  public final boolean tA(long paramLong)
  {
    AppMethodBeat.i(280395);
    for (this.ood = paramLong; this.ood > getLastLrcTime(); this.ood -= getLastLrcTime()) {}
    boolean bool = super.tA(paramLong);
    AppMethodBeat.o(280395);
    return bool;
  }
  
  protected final void tC(long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(280412);
    if (getWaveAlpha() < 255)
    {
      long l1 = getTRANS_TIME();
      long l2 = this.ood - paramLong;
      int i = j;
      if (0L <= l2)
      {
        i = j;
        if (l2 <= l1) {
          i = 1;
        }
      }
      if (i != 0)
      {
        setWaveAlpha((int)(255.0F * (float)(this.ood - paramLong) / (float)getTRANS_TIME()));
        AppMethodBeat.o(280412);
        return;
      }
      if (this.ood - paramLong > getTRANS_TIME()) {
        setWaveAlpha(255);
      }
    }
    AppMethodBeat.o(280412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.g
 * JD-Core Version:    0.7.0.1
 */