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
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DEFAULT_BG_COLOR", "", "DEFAULT_TEXT_COLOR", "MARGIN", "TAG", "", "locationItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "originMatrix", "Landroid/graphics/Matrix;", "createPositionBitmap", "Landroid/graphics/Bitmap;", "item", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowPosition", "", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setValidArea", "validRect", "Landroid/graphics/Rect;", "plugin-recordvideo_release"})
public final class q
  extends b
{
  private final Matrix IcI;
  private final int IcU;
  private l IcV;
  private final String TAG;
  private final int YY;
  private final int rBc;
  
  public q(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76166);
    this.TAG = "MicroMsg.PositionItemView";
    this.IcU = -1;
    this.rBc = -1;
    this.YY = aw.fromDPToPix(paramContext, 32);
    this.IcI = new Matrix();
    AppMethodBeat.o(76166);
  }
  
  private final Bitmap b(l paraml)
  {
    AppMethodBeat.i(217927);
    this.IcV = paraml;
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject1 = LayoutInflater.from(getContext()).inflate(b.f.story_edit_position, (ViewGroup)localRelativeLayout, true);
    Object localObject3 = (TextView)((View)localObject1).findViewById(b.e.city_name);
    Object localObject2 = (TextView)((View)localObject1).findViewById(b.e.poi_name);
    Object localObject4 = (ImageView)((View)localObject1).findViewById(b.e.story_poi_item_location_icon);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(b.e.story_poi_item_location_split_icon);
    p.j(localObject3, "cityText");
    com.tencent.mm.ae.d.g((TextView)localObject3);
    p.j(localObject2, "poiText");
    com.tencent.mm.ae.d.g((TextView)localObject2);
    ((TextView)localObject3).setText((CharSequence)paraml.Icv);
    ((TextView)localObject2).setText((CharSequence)paraml.poiName);
    ((ImageView)localObject4).setImageDrawable(au.o(getContext(), b.g.icons_filled_location, -1));
    localObject4 = paraml.poiName;
    if (localObject4 == null)
    {
      paraml = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(217927);
      throw paraml;
    }
    if (TextUtils.isEmpty((CharSequence)n.bb((CharSequence)localObject4).toString()))
    {
      ((TextView)localObject3).setTextSize(0, aw.fromDPToPix(getContext(), 20));
      p.j(localImageView, "splitIcon");
      localImageView.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
    }
    localObject4 = paraml.Icv;
    if (localObject4 == null)
    {
      paraml = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(217927);
      throw paraml;
    }
    if (TextUtils.isEmpty((CharSequence)n.bb((CharSequence)localObject4).toString()))
    {
      ((TextView)localObject2).setTextSize(0, aw.fromDPToPix(getContext(), 20));
      ((TextView)localObject3).setVisibility(8);
      p.j(localImageView, "splitIcon");
      localImageView.setVisibility(8);
    }
    int i = this.YY;
    localObject3 = e.HGz;
    if (i >= e.fuV().left)
    {
      localObject3 = e.HGz;
      i = e.fuV().width();
      j = this.YY;
      localObject3 = e.HGz;
      i -= (j - e.fuV().left) * 2;
      ((TextView)localObject2).setMaxWidth(i);
      ((View)localObject1).measure(0, 0);
      p.j(localObject1, "parent");
      ((View)localObject1).layout(0, 0, ((View)localObject1).getMeasuredWidth(), ((View)localObject1).getMeasuredHeight());
      Log.i(this.TAG, paraml + " parent.measuredWidth:" + ((View)localObject1).getMeasuredWidth() + " , parent.measuredHeight:" + ((View)localObject1).getMeasuredHeight());
      if (((View)localObject1).getMeasuredWidth() > 0)
      {
        i = ((View)localObject1).getMeasuredWidth();
        localObject2 = e.HGz;
        if (i <= e.fuV().width()) {
          break label642;
        }
      }
      localObject2 = e.HGz;
      i = e.fuV().width();
      label512:
      if (((View)localObject1).getMeasuredHeight() > 0)
      {
        j = ((View)localObject1).getMeasuredHeight();
        localObject2 = e.HGz;
        if (j <= e.fuV().height()) {
          break label651;
        }
      }
      localObject1 = e.HGz;
    }
    label642:
    label651:
    for (int j = e.fuV().height();; j = ((View)localObject1).getMeasuredHeight())
    {
      localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localRelativeLayout.draw(new Canvas((Bitmap)localObject1));
      setColor(this.IcU);
      setTextBg(this.rBc);
      setSourceDataType(d.IbI);
      setLocation(paraml);
      setBitmap((Bitmap)localObject1);
      p.j(localObject1, "bitmap");
      AppMethodBeat.o(217927);
      return localObject1;
      localObject3 = e.HGz;
      i = e.fuV().width();
      break;
      i = ((View)localObject1).getMeasuredWidth();
      break label512;
    }
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(217921);
    p.k(paraml, "item");
    b(paraml);
    setViewMatrix(paraml.aHZ);
    getTouchTracker().aHZ.set(paraml.aHZ);
    setSourceDataType(d.IbI);
    AppMethodBeat.o(217921);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c c(l paraml)
  {
    AppMethodBeat.i(217932);
    p.k(paraml, "item");
    paraml = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(b(paraml), paraml.aHZ);
    AppMethodBeat.o(217932);
    return paraml;
  }
  
  public final a getEditorData()
  {
    return (a)this.IcV;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    return com.tencent.mm.plugin.recordvideo.ui.editor.view.b.Ieq;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76162);
    p.k(paramMotionEvent, "event");
    this.IcI.set(getTouchTracker().aHZ);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    getTouchTracker().aHZ.set(this.IcI);
    AppMethodBeat.o(76162);
    return bool;
  }
  
  public final void setLocation(duy paramduy)
  {
    AppMethodBeat.i(76165);
    p.k(paramduy, "location");
    String str1 = paramduy.mVA;
    p.j(str1, "location.City");
    String str2 = paramduy.poiName;
    p.j(str2, "location.poiName");
    b(new l(str1, str2, paramduy.ScO, paramduy.ScP));
    paramduy = getBitmap();
    if (paramduy != null)
    {
      float f2 = getValidRect().height() - aw.fromDPToPix(getContext(), 128) - ax.aB(getContext());
      float f3 = paramduy.getHeight();
      int i = this.YY;
      paramduy = e.HGz;
      if (i >= e.fuV().left) {}
      for (float f1 = this.YY;; f1 = e.fuV().left)
      {
        getTouchTracker().aHZ.setTranslate(f1, f2 - f3);
        AppMethodBeat.o(76165);
        return;
        paramduy = e.HGz;
      }
    }
    AppMethodBeat.o(76165);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76161);
    p.k(paramRect, "validRect");
    getValidRect().set(paramRect);
    AppMethodBeat.o(76161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.q
 * JD-Core Version:    0.7.0.1
 */