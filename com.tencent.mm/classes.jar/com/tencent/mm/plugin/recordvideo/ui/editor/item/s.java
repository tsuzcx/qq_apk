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
import com.tencent.mm.protocal.protobuf.amh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "font", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "createBitmap", "Landroid/graphics/Bitmap;", "item", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "initScale", "", "sx", "", "sy", "reshowText", "setText", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends b
{
  private r NZu;
  private final String TAG;
  private String mAD;
  
  public s(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76171);
    this.TAG = "MicroMsg.TextItemView";
    setTextSize(getResources().getDimension(b.c.editor_text_item_text_size));
    this.mAD = "";
    AppMethodBeat.o(76171);
  }
  
  private Bitmap c(r paramr)
  {
    AppMethodBeat.i(280298);
    kotlin.g.b.s.u(paramr, "item");
    setSourceDataType(d.NYd);
    Object localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    localObject = new PhotoEditText((Context)localObject);
    int k = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
    int m = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
    ((PhotoEditText)localObject).setPadding(k, m, k, m);
    ((PhotoEditText)localObject).setTextColor(paramr.textColor);
    ((PhotoEditText)localObject).setTextBackground(paramr.NZt);
    ((PhotoEditText)localObject).setTextSize(0, getTextSize());
    ((PhotoEditText)localObject).setText((CharSequence)String.valueOf(paramr.bba));
    ((PhotoEditText)localObject).setSingleLine(false);
    int i;
    label169:
    int j;
    if (((CharSequence)paramr.mAD).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label427;
      }
      if (!y.ZC(paramr.mAD)) {
        break label416;
      }
      ((PhotoEditText)localObject).setTypeface(Typeface.createFromFile(paramr.mAD));
      if ((paramr.NZt == 0) && (paramr.textColor != -16777216)) {
        com.tencent.mm.ae.d.h((TextView)localObject);
      }
      paramr = e.NDU;
      i = e.gGL().width();
      if (i > 0) {
        ((PhotoEditText)localObject).setMaxWidth(i);
      }
      ((PhotoEditText)localObject).measure(0, 0);
      if (((PhotoEditText)localObject).getMeasuredWidth() > 0)
      {
        i = ((PhotoEditText)localObject).getMeasuredWidth();
        paramr = e.NDU;
        if (i <= e.gGL().width()) {
          break label441;
        }
      }
      paramr = e.NDU;
      i = e.gGL().width();
      label260:
      if (((PhotoEditText)localObject).getMeasuredHeight() > 0)
      {
        j = ((PhotoEditText)localObject).getMeasuredHeight();
        paramr = e.NDU;
        if (j <= e.gGL().height()) {
          break label450;
        }
      }
      paramr = e.NDU;
      j = e.gGL().height();
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
      kotlin.g.b.s.s(paramr, "bitmap");
      AppMethodBeat.o(280298);
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
  
  public final void aM(float paramFloat1, float paramFloat2)
  {
    int j = 1;
    AppMethodBeat.i(76167);
    if (paramFloat1 == 0.0F)
    {
      i = 1;
      if (i == 0) {
        if (paramFloat2 != 0.0F) {
          break label58;
        }
      }
    }
    label58:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        getTouchTracker().matrix.setScale(paramFloat1, paramFloat2);
      }
      AppMethodBeat.o(76167);
      return;
      i = 0;
      break;
    }
  }
  
  public final void b(r paramr)
  {
    AppMethodBeat.i(280341);
    kotlin.g.b.s.u(paramr, "item");
    setText(paramr);
    setViewMatrix(paramr.matrix);
    getTouchTracker().matrix.set(paramr.matrix);
    setSourceDataType(d.NYd);
    AppMethodBeat.o(280341);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c d(r paramr)
  {
    AppMethodBeat.i(280355);
    kotlin.g.b.s.u(paramr, "item");
    com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c localc = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(c(paramr), paramr.matrix);
    amh localamh = new amh();
    localamh.start = paramr.NXR.NZL.getTime();
    localamh.axI = paramr.NXR.NZM.getTime();
    localc.NZv = localamh;
    AppMethodBeat.o(280355);
    return localc;
  }
  
  public final a dEP()
  {
    AppMethodBeat.i(280350);
    a locala = super.dEP();
    r localr = this.NZu;
    if (localr != null)
    {
      if (locala != null)
      {
        com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d locald = localr.NXR;
        kotlin.g.b.s.u(locald, "range");
        locala.NXR.bb(locald.NZL.getTime(), locald.NZM.getTime());
      }
      if (locala != null) {
        locala.objectId = localr.objectId;
      }
      if ((locala instanceof r)) {
        ((r)locala).setFont(getFont());
      }
    }
    AppMethodBeat.o(280350);
    return locala;
  }
  
  public final a getEditorData()
  {
    return (a)this.NZu;
  }
  
  public final String getFont()
  {
    return this.mAD;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    return com.tencent.mm.plugin.recordvideo.ui.editor.view.b.OaE;
  }
  
  public final void setFont(String paramString)
  {
    AppMethodBeat.i(280317);
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.mAD = paramString;
    AppMethodBeat.o(280317);
  }
  
  public final void setText(r paramr)
  {
    AppMethodBeat.i(280330);
    kotlin.g.b.s.u(paramr, "item");
    this.NZu = paramr;
    Bitmap localBitmap = c(paramr);
    setText(paramr.bba);
    setSourceDataType(d.NYd);
    setColor(paramr.textColor);
    setTextBg(paramr.NZt);
    this.mAD = paramr.mAD;
    if (getBitmap() == null) {
      getTouchTracker().matrix.postTranslate(-getWidth() / 2.0F, -((getDisplayRect().top + getDisplayRect().bottom) / 2 - (getValidRect().top + getValidRect().bottom) / 2.0F + getHeight() / 2.0F));
    }
    paramr = getBitmap();
    if (paramr != null) {
      getTouchTracker().matrix.preTranslate(paramr.getWidth() / 2.0F, paramr.getHeight() / 2.0F);
    }
    setBitmap(localBitmap);
    postInvalidate();
    AppMethodBeat.o(280330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.s
 * JD-Core Version:    0.7.0.1
 */