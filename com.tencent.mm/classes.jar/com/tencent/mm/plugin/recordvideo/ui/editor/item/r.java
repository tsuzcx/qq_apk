package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.PhotoEditText;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "font", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "createBitmap", "Landroid/graphics/Bitmap;", "item", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "initScale", "", "sx", "", "sy", "reshowText", "setText", "plugin-recordvideo_release"})
public final class r
  extends b
{
  private final String TAG;
  private String ydG;
  private q yfi;
  
  public r(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76171);
    this.TAG = "MicroMsg.TextItemView";
    setTextSize(getResources().getDimension(2131166195));
    this.ydG = "";
    AppMethodBeat.o(76171);
  }
  
  public final void aa(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(76167);
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F)) {
      getTouchTracker().gR.setScale(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(76167);
  }
  
  public final void b(q paramq)
  {
    AppMethodBeat.i(207000);
    p.h(paramq, "item");
    setText(paramq);
    setViewMatrix(paramq.gR);
    getTouchTracker().gR.set(paramq.gR);
    setSourceDataType(d.ydI);
    AppMethodBeat.o(207000);
  }
  
  public final Bitmap c(q paramq)
  {
    AppMethodBeat.i(207001);
    p.h(paramq, "item");
    setSourceDataType(d.ydI);
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = new PhotoEditText((Context)localObject);
    int k = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
    int m = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    ((PhotoEditText)localObject).setPadding(k, m, k, m);
    ((PhotoEditText)localObject).setTextColor(paramq.textColor);
    ((PhotoEditText)localObject).setTextBackground(paramq.yfg);
    ((PhotoEditText)localObject).setTextSize(0, getTextSize());
    ((PhotoEditText)localObject).setText(paramq.text);
    ((PhotoEditText)localObject).setSingleLine(false);
    int i;
    label163:
    label254:
    int j;
    if (((CharSequence)paramq.ydG).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label422;
      }
      if (!o.fB(paramq.ydG)) {
        break label411;
      }
      ((PhotoEditText)localObject).setTypeface(Typeface.createFromFile(paramq.ydG));
      if ((paramq.yfg == 0) && (paramq.textColor != -16777216)) {
        com.tencent.mm.ac.c.e((TextView)localObject);
      }
      paramq = e.xKl;
      i = e.dIe().width();
      if (i > 0) {
        ((PhotoEditText)localObject).setMaxWidth(i);
      }
      ((PhotoEditText)localObject).measure(0, 0);
      if (((PhotoEditText)localObject).getMeasuredWidth() > 0)
      {
        i = ((PhotoEditText)localObject).getMeasuredWidth();
        paramq = e.xKl;
        if (i <= e.dIe().width()) {
          break label436;
        }
      }
      paramq = e.xKl;
      i = e.dIe().width();
      if (((PhotoEditText)localObject).getMeasuredHeight() > 0)
      {
        j = ((PhotoEditText)localObject).getMeasuredHeight();
        paramq = e.xKl;
        if (j <= e.dIe().height()) {
          break label445;
        }
      }
      paramq = e.xKl;
      j = e.dIe().height();
      label293:
      if ((i > 0) && (j > 0)) {
        break label454;
      }
      ae.w(this.TAG, "create bitmap size error: " + i + ", " + j);
    }
    label411:
    label422:
    label436:
    label445:
    label454:
    for (paramq = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);; paramq = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas(paramq);
      ((PhotoEditText)localObject).draw(localCanvas);
      localCanvas.save();
      localCanvas.translate(k, m);
      ((PhotoEditText)localObject).getLayout().draw(localCanvas);
      localCanvas.restore();
      p.g(paramq, "bitmap");
      AppMethodBeat.o(207001);
      return paramq;
      i = 0;
      break;
      ((PhotoEditText)localObject).setTypeface(Typeface.DEFAULT);
      break label163;
      ((PhotoEditText)localObject).setTypeface(((PhotoEditText)localObject).getTypeface(), 1);
      break label163;
      i = ((PhotoEditText)localObject).getMeasuredWidth();
      break label254;
      j = ((PhotoEditText)localObject).getMeasuredHeight();
      break label293;
    }
  }
  
  public final a clM()
  {
    AppMethodBeat.i(207002);
    a locala = super.clM();
    q localq = this.yfi;
    if (localq != null)
    {
      Object localObject;
      if (locala != null)
      {
        localObject = localq.ydt;
        p.h(localObject, "range");
        locala.ydt.ae(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject).yfy.getTime(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject).yfz.getTime());
      }
      if (locala != null) {
        locala.objectId = localq.objectId;
      }
      if ((locala instanceof q))
      {
        localq = (q)locala;
        localObject = this.ydG;
        p.h(localObject, "<set-?>");
        localq.ydG = ((String)localObject);
      }
    }
    AppMethodBeat.o(207002);
    return locala;
  }
  
  public final a getEditorData()
  {
    return (a)this.yfi;
  }
  
  public final String getFont()
  {
    return this.ydG;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    return com.tencent.mm.plugin.recordvideo.ui.editor.view.b.ygB;
  }
  
  public final void setFont(String paramString)
  {
    AppMethodBeat.i(206998);
    p.h(paramString, "<set-?>");
    this.ydG = paramString;
    AppMethodBeat.o(206998);
  }
  
  public final void setText(q paramq)
  {
    AppMethodBeat.i(206999);
    p.h(paramq, "item");
    this.yfi = paramq;
    Bitmap localBitmap = c(paramq);
    setText(paramq.text);
    setSourceDataType(d.ydI);
    setColor(paramq.textColor);
    setTextBg(paramq.yfg);
    this.ydG = paramq.ydG;
    if (getBitmap() == null) {
      getTouchTracker().gR.postTranslate(-getWidth() / 2.0F, -((getDisplayRect().top + getDisplayRect().bottom) / 2 - (getValidRect().top + getValidRect().bottom) / 2.0F + getHeight() / 2.0F));
    }
    paramq = getBitmap();
    if (paramq != null) {
      getTouchTracker().gR.preTranslate(paramq.getWidth() / 2.0F, paramq.getHeight() / 2.0F);
    }
    setBitmap(localBitmap);
    postInvalidate();
    AppMethodBeat.o(206999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.r
 * JD-Core Version:    0.7.0.1
 */