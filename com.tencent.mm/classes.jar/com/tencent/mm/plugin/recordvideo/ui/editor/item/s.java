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
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.PhotoEditText;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "font", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "createBitmap", "Landroid/graphics/Bitmap;", "item", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "initScale", "", "sx", "", "sy", "reshowText", "setText", "plugin-recordvideo_release"})
public final class s
  extends b
{
  private String IbE;
  private r IcY;
  private final String TAG;
  
  public s(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76171);
    this.TAG = "MicroMsg.TextItemView";
    setTextSize(getResources().getDimension(b.c.editor_text_item_text_size));
    this.IbE = "";
    AppMethodBeat.o(76171);
  }
  
  private Bitmap c(r paramr)
  {
    AppMethodBeat.i(216487);
    p.k(paramr, "item");
    setSourceDataType(d.IbG);
    Object localObject = getContext();
    p.j(localObject, "context");
    localObject = new PhotoEditText((Context)localObject);
    int k = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
    int m = com.tencent.mm.ci.a.fromDPToPix(getContext(), 8);
    ((PhotoEditText)localObject).setPadding(k, m, k, m);
    ((PhotoEditText)localObject).setTextColor(paramr.textColor);
    ((PhotoEditText)localObject).setTextBackground(paramr.IcW);
    ((PhotoEditText)localObject).setTextSize(0, getTextSize());
    ((PhotoEditText)localObject).setText((CharSequence)String.valueOf(paramr.LV));
    ((PhotoEditText)localObject).setSingleLine(false);
    int i;
    label169:
    int j;
    if (((CharSequence)paramr.IbE).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label427;
      }
      if (!u.agG(paramr.IbE)) {
        break label416;
      }
      ((PhotoEditText)localObject).setTypeface(Typeface.createFromFile(paramr.IbE));
      if ((paramr.IcW == 0) && (paramr.textColor != -16777216)) {
        com.tencent.mm.ae.d.g((TextView)localObject);
      }
      paramr = e.HGz;
      i = e.fuV().width();
      if (i > 0) {
        ((PhotoEditText)localObject).setMaxWidth(i);
      }
      ((PhotoEditText)localObject).measure(0, 0);
      if (((PhotoEditText)localObject).getMeasuredWidth() > 0)
      {
        i = ((PhotoEditText)localObject).getMeasuredWidth();
        paramr = e.HGz;
        if (i <= e.fuV().width()) {
          break label441;
        }
      }
      paramr = e.HGz;
      i = e.fuV().width();
      label260:
      if (((PhotoEditText)localObject).getMeasuredHeight() > 0)
      {
        j = ((PhotoEditText)localObject).getMeasuredHeight();
        paramr = e.HGz;
        if (j <= e.fuV().height()) {
          break label450;
        }
      }
      paramr = e.HGz;
      j = e.fuV().height();
      label299:
      if ((i > 0) && (j > 0)) {
        break label459;
      }
      Log.w(this.TAG, "create bitmap size error: " + i + ", " + j);
    }
    label416:
    label427:
    label441:
    label450:
    label459:
    for (paramr = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);; paramr = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas(paramr);
      ((PhotoEditText)localObject).draw(localCanvas);
      localCanvas.save();
      localCanvas.translate(k, m);
      ((PhotoEditText)localObject).getLayout().draw(localCanvas);
      localCanvas.restore();
      p.j(paramr, "bitmap");
      AppMethodBeat.o(216487);
      return paramr;
      i = 0;
      break;
      ((PhotoEditText)localObject).setTypeface(Typeface.DEFAULT);
      break label169;
      ((PhotoEditText)localObject).setTypeface(((PhotoEditText)localObject).getTypeface(), 1);
      break label169;
      i = ((PhotoEditText)localObject).getMeasuredWidth();
      break label260;
      j = ((PhotoEditText)localObject).getMeasuredHeight();
      break label299;
    }
  }
  
  public final void ah(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(76167);
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F)) {
      getTouchTracker().aHZ.setScale(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(76167);
  }
  
  public final void b(r paramr)
  {
    AppMethodBeat.i(216485);
    p.k(paramr, "item");
    setText(paramr);
    setViewMatrix(paramr.aHZ);
    getTouchTracker().aHZ.set(paramr.aHZ);
    setSourceDataType(d.IbG);
    AppMethodBeat.o(216485);
  }
  
  public final a cYy()
  {
    AppMethodBeat.i(216490);
    a locala = super.cYy();
    r localr = this.IcY;
    if (localr != null)
    {
      Object localObject;
      if (locala != null)
      {
        localObject = localr.Ibr;
        p.k(localObject, "range");
        locala.Ibr.ar(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject).Ido.getTime(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject).Idp.getTime());
      }
      if (locala != null) {
        locala.objectId = localr.objectId;
      }
      if ((locala instanceof r))
      {
        localr = (r)locala;
        localObject = this.IbE;
        p.k(localObject, "<set-?>");
        localr.IbE = ((String)localObject);
      }
    }
    AppMethodBeat.o(216490);
    return locala;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c d(r paramr)
  {
    AppMethodBeat.i(216492);
    p.k(paramr, "item");
    com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c localc = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(c(paramr), paramr.aHZ);
    ajc localajc = new ajc();
    localajc.start = paramr.Ibr.Ido.getTime();
    localajc.aYz = paramr.Ibr.Idp.getTime();
    localc.IcZ = localajc;
    AppMethodBeat.o(216492);
    return localc;
  }
  
  public final a getEditorData()
  {
    return (a)this.IcY;
  }
  
  public final String getFont()
  {
    return this.IbE;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    return com.tencent.mm.plugin.recordvideo.ui.editor.view.b.Ieo;
  }
  
  public final void setFont(String paramString)
  {
    AppMethodBeat.i(216480);
    p.k(paramString, "<set-?>");
    this.IbE = paramString;
    AppMethodBeat.o(216480);
  }
  
  public final void setText(r paramr)
  {
    AppMethodBeat.i(216482);
    p.k(paramr, "item");
    this.IcY = paramr;
    Bitmap localBitmap = c(paramr);
    setText(paramr.LV);
    setSourceDataType(d.IbG);
    setColor(paramr.textColor);
    setTextBg(paramr.IcW);
    this.IbE = paramr.IbE;
    if (getBitmap() == null) {
      getTouchTracker().aHZ.postTranslate(-getWidth() / 2.0F, -((getDisplayRect().top + getDisplayRect().bottom) / 2 - (getValidRect().top + getValidRect().bottom) / 2.0F + getHeight() / 2.0F));
    }
    paramr = getBitmap();
    if (paramr != null) {
      getTouchTracker().aHZ.preTranslate(paramr.getWidth() / 2.0F, paramr.getHeight() / 2.0F);
    }
    setBitmap(localBitmap);
    postInvalidate();
    AppMethodBeat.o(216482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.s
 * JD-Core Version:    0.7.0.1
 */