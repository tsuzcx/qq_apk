package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import d.l;
import d.n.n;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DEFAULT_BG_COLOR", "", "DEFAULT_TEXT_COLOR", "MARGIN", "TAG", "", "locationItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "originMatrix", "Landroid/graphics/Matrix;", "createPositionBitmap", "Landroid/graphics/Bitmap;", "item", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowPosition", "", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setValidArea", "validRect", "Landroid/graphics/Rect;", "plugin-recordvideo_release"})
public final class p
  extends b
{
  private final String TAG;
  private final int api;
  private final int noP;
  private final Matrix yeQ;
  private final int yfe;
  private k yff;
  
  public p(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76166);
    this.TAG = "MicroMsg.PositionItemView";
    this.yfe = -1;
    this.noP = -1;
    this.api = aq.fromDPToPix(paramContext, 32);
    this.yeQ = new Matrix();
    AppMethodBeat.o(76166);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(206984);
    d.g.b.p.h(paramk, "item");
    b(paramk);
    setViewMatrix(paramk.gR);
    getTouchTracker().gR.set(paramk.gR);
    setSourceDataType(d.ydK);
    AppMethodBeat.o(206984);
  }
  
  public final Bitmap b(k paramk)
  {
    AppMethodBeat.i(206985);
    this.yff = paramk;
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject1 = LayoutInflater.from(getContext()).inflate(2131495681, (ViewGroup)localRelativeLayout, true);
    Object localObject3 = (TextView)((View)localObject1).findViewById(2131298338);
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131303336);
    Object localObject4 = (ImageView)((View)localObject1).findViewById(2131305483);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131305484);
    d.g.b.p.g(localObject3, "cityText");
    com.tencent.mm.ac.c.e((TextView)localObject3);
    d.g.b.p.g(localObject2, "poiText");
    com.tencent.mm.ac.c.e((TextView)localObject2);
    ((TextView)localObject3).setText((CharSequence)paramk.yew);
    ((TextView)localObject2).setText((CharSequence)paramk.jGd);
    ((ImageView)localObject4).setImageDrawable(ao.k(getContext(), 2131690422, -1));
    localObject4 = paramk.jGd;
    if (localObject4 == null)
    {
      paramk = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(206985);
      throw paramk;
    }
    if (TextUtils.isEmpty((CharSequence)n.trim((CharSequence)localObject4).toString()))
    {
      ((TextView)localObject3).setTextSize(0, aq.fromDPToPix(getContext(), 20));
      d.g.b.p.g(localImageView, "splitIcon");
      localImageView.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
    }
    localObject4 = paramk.yew;
    if (localObject4 == null)
    {
      paramk = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(206985);
      throw paramk;
    }
    if (TextUtils.isEmpty((CharSequence)n.trim((CharSequence)localObject4).toString()))
    {
      ((TextView)localObject2).setTextSize(0, aq.fromDPToPix(getContext(), 20));
      ((TextView)localObject3).setVisibility(8);
      d.g.b.p.g(localImageView, "splitIcon");
      localImageView.setVisibility(8);
    }
    int i = this.api;
    localObject3 = e.xKl;
    if (i >= e.dIe().left)
    {
      localObject3 = e.xKl;
      i = e.dIe().width();
      j = this.api;
      localObject3 = e.xKl;
      i -= (j - e.dIe().left) * 2;
      ((TextView)localObject2).setMaxWidth(i);
      ((View)localObject1).measure(0, 0);
      d.g.b.p.g(localObject1, "parent");
      ((View)localObject1).layout(0, 0, ((View)localObject1).getMeasuredWidth(), ((View)localObject1).getMeasuredHeight());
      ae.i(this.TAG, paramk + " parent.measuredWidth:" + ((View)localObject1).getMeasuredWidth() + " , parent.measuredHeight:" + ((View)localObject1).getMeasuredHeight());
      if (((View)localObject1).getMeasuredWidth() > 0)
      {
        i = ((View)localObject1).getMeasuredWidth();
        localObject2 = e.xKl;
        if (i <= e.dIe().width()) {
          break label637;
        }
      }
      localObject2 = e.xKl;
      i = e.dIe().width();
      label507:
      if (((View)localObject1).getMeasuredHeight() > 0)
      {
        j = ((View)localObject1).getMeasuredHeight();
        localObject2 = e.xKl;
        if (j <= e.dIe().height()) {
          break label646;
        }
      }
      localObject1 = e.xKl;
    }
    label646:
    for (int j = e.dIe().height();; j = ((View)localObject1).getMeasuredHeight())
    {
      localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localRelativeLayout.draw(new Canvas((Bitmap)localObject1));
      setColor(this.yfe);
      setTextBg(this.noP);
      setSourceDataType(d.ydK);
      setLocation(paramk);
      setBitmap((Bitmap)localObject1);
      d.g.b.p.g(localObject1, "bitmap");
      AppMethodBeat.o(206985);
      return localObject1;
      localObject3 = e.xKl;
      i = e.dIe().width();
      break;
      label637:
      i = ((View)localObject1).getMeasuredWidth();
      break label507;
    }
  }
  
  public final a getEditorData()
  {
    return (a)this.yff;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    return com.tencent.mm.plugin.recordvideo.ui.editor.view.b.ygD;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76162);
    d.g.b.p.h(paramMotionEvent, "event");
    this.yeQ.set(getTouchTracker().gR);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    getTouchTracker().gR.set(this.yeQ);
    AppMethodBeat.o(76162);
    return bool;
  }
  
  public final void setLocation(csx paramcsx)
  {
    AppMethodBeat.i(76165);
    d.g.b.p.h(paramcsx, "location");
    String str1 = paramcsx.jfX;
    d.g.b.p.g(str1, "location.City");
    String str2 = paramcsx.jGd;
    d.g.b.p.g(str2, "location.poiName");
    b(new k(str1, str2, paramcsx.GgZ, paramcsx.Gha));
    paramcsx = getBitmap();
    if (paramcsx != null)
    {
      float f2 = getValidRect().height() - aq.fromDPToPix(getContext(), 128) - ar.en(getContext());
      float f3 = paramcsx.getHeight();
      int i = this.api;
      paramcsx = e.xKl;
      if (i >= e.dIe().left) {}
      for (float f1 = this.api;; f1 = e.dIe().left)
      {
        getTouchTracker().gR.setTranslate(f1, f2 - f3);
        AppMethodBeat.o(76165);
        return;
        paramcsx = e.xKl;
      }
    }
    AppMethodBeat.o(76165);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76161);
    d.g.b.p.h(paramRect, "validRect");
    getValidRect().set(paramRect);
    AppMethodBeat.o(76161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.p
 * JD-Core Version:    0.7.0.1
 */