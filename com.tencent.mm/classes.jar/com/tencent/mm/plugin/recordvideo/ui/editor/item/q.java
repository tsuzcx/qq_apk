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
import com.tencent.mm.protocal.protobuf.enw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DEFAULT_BG_COLOR", "", "DEFAULT_TEXT_COLOR", "MARGIN", "TAG", "", "locationItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "originMatrix", "Landroid/graphics/Matrix;", "createPositionBitmap", "Landroid/graphics/Bitmap;", "item", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowPosition", "", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setValidArea", "validRect", "Landroid/graphics/Rect;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends b
{
  private final Matrix NZe;
  private final int NZq;
  private l NZr;
  private final String TAG;
  private final int bGt;
  private final int uMt;
  
  public q(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76166);
    this.TAG = "MicroMsg.PositionItemView";
    this.NZq = -1;
    this.uMt = -1;
    this.bGt = bd.fromDPToPix(paramContext, 32);
    this.NZe = new Matrix();
    AppMethodBeat.o(76166);
  }
  
  private final Bitmap b(l paraml)
  {
    AppMethodBeat.i(280308);
    this.NZr = paraml;
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject1 = LayoutInflater.from(getContext()).inflate(b.f.story_edit_position, (ViewGroup)localRelativeLayout, true);
    Object localObject3 = (TextView)((View)localObject1).findViewById(b.e.city_name);
    Object localObject2 = (TextView)((View)localObject1).findViewById(b.e.poi_name);
    Object localObject4 = (ImageView)((View)localObject1).findViewById(b.e.story_poi_item_location_icon);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(b.e.story_poi_item_location_split_icon);
    s.s(localObject3, "cityText");
    com.tencent.mm.ae.d.h((TextView)localObject3);
    s.s(localObject2, "poiText");
    com.tencent.mm.ae.d.h((TextView)localObject2);
    ((TextView)localObject3).setText((CharSequence)paraml.NYS);
    ((TextView)localObject2).setText((CharSequence)paraml.poiName);
    ((ImageView)localObject4).setImageDrawable(bb.m(getContext(), b.g.icons_filled_location, -1));
    localObject4 = paraml.poiName;
    if (localObject4 == null)
    {
      paraml = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(280308);
      throw paraml;
    }
    if (TextUtils.isEmpty((CharSequence)n.bq((CharSequence)localObject4).toString()))
    {
      ((TextView)localObject3).setTextSize(0, bd.fromDPToPix(getContext(), 20));
      localImageView.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
    }
    localObject4 = paraml.NYS;
    if (localObject4 == null)
    {
      paraml = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(280308);
      throw paraml;
    }
    if (TextUtils.isEmpty((CharSequence)n.bq((CharSequence)localObject4).toString()))
    {
      ((TextView)localObject2).setTextSize(0, bd.fromDPToPix(getContext(), 20));
      ((TextView)localObject3).setVisibility(8);
      localImageView.setVisibility(8);
    }
    int i = this.bGt;
    localObject3 = e.NDU;
    if (i >= e.gGL().left)
    {
      localObject3 = e.NDU;
      i = e.gGL().width();
      j = this.bGt;
      localObject3 = e.NDU;
      i -= (j - e.gGL().left) * 2;
      ((TextView)localObject2).setMaxWidth(i);
      ((View)localObject1).measure(0, 0);
      ((View)localObject1).layout(0, 0, ((View)localObject1).getMeasuredWidth(), ((View)localObject1).getMeasuredHeight());
      Log.i(this.TAG, paraml + " parent.measuredWidth:" + ((View)localObject1).getMeasuredWidth() + " , parent.measuredHeight:" + ((View)localObject1).getMeasuredHeight());
      if (((View)localObject1).getMeasuredWidth() > 0)
      {
        i = ((View)localObject1).getMeasuredWidth();
        localObject2 = e.NDU;
        if (i <= e.gGL().width()) {
          break label621;
        }
      }
      localObject2 = e.NDU;
      i = e.gGL().width();
      label491:
      if (((View)localObject1).getMeasuredHeight() > 0)
      {
        j = ((View)localObject1).getMeasuredHeight();
        localObject2 = e.NDU;
        if (j <= e.gGL().height()) {
          break label630;
        }
      }
      localObject1 = e.NDU;
    }
    label621:
    label630:
    for (int j = e.gGL().height();; j = ((View)localObject1).getMeasuredHeight())
    {
      localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localRelativeLayout.draw(new Canvas((Bitmap)localObject1));
      setColor(this.NZq);
      setTextBg(this.uMt);
      setSourceDataType(d.NYf);
      setLocation(paraml);
      setBitmap((Bitmap)localObject1);
      s.s(localObject1, "bitmap");
      AppMethodBeat.o(280308);
      return localObject1;
      localObject3 = e.NDU;
      i = e.gGL().width();
      break;
      i = ((View)localObject1).getMeasuredWidth();
      break label491;
    }
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(280357);
    s.u(paraml, "item");
    b(paraml);
    setViewMatrix(paraml.matrix);
    getTouchTracker().matrix.set(paraml.matrix);
    setSourceDataType(d.NYf);
    AppMethodBeat.o(280357);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c c(l paraml)
  {
    AppMethodBeat.i(280391);
    s.u(paraml, "item");
    paraml = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(b(paraml), paraml.matrix);
    AppMethodBeat.o(280391);
    return paraml;
  }
  
  public final a getEditorData()
  {
    return (a)this.NZr;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    return com.tencent.mm.plugin.recordvideo.ui.editor.view.b.OaG;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76162);
    s.u(paramMotionEvent, "event");
    this.NZe.set(getTouchTracker().matrix);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    getTouchTracker().matrix.set(this.NZe);
    AppMethodBeat.o(76162);
    return bool;
  }
  
  public final void setLocation(enw paramenw)
  {
    AppMethodBeat.i(76165);
    s.u(paramenw, "location");
    String str1 = paramenw.pSh;
    s.s(str1, "location.City");
    String str2 = paramenw.poiName;
    s.s(str2, "location.poiName");
    b(new l(str1, str2, paramenw.ZaG, paramenw.ZaH));
    paramenw = getBitmap();
    float f2;
    float f3;
    if (paramenw != null)
    {
      f2 = getValidRect().height() - bd.fromDPToPix(getContext(), 128) - bf.bk(getContext());
      f3 = paramenw.getHeight();
      int i = this.bGt;
      paramenw = e.NDU;
      if (i < e.gGL().left) {
        break label158;
      }
    }
    for (float f1 = this.bGt;; f1 = e.gGL().left)
    {
      getTouchTracker().matrix.setTranslate(f1, f2 - f3);
      AppMethodBeat.o(76165);
      return;
      label158:
      paramenw = e.NDU;
    }
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76161);
    s.u(paramRect, "validRect");
    getValidRect().set(paramRect);
    AppMethodBeat.o(76161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.q
 * JD-Core Version:    0.7.0.1
 */