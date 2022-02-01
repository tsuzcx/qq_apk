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
import com.tencent.mm.plugin.recordvideo.ui.editor.c.c;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DEFAULT_BG_COLOR", "", "DEFAULT_TEXT_COLOR", "MARGIN", "TAG", "", "locationItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "originMatrix", "Landroid/graphics/Matrix;", "createPositionBitmap", "Landroid/graphics/Bitmap;", "item", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowPosition", "", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setValidArea", "validRect", "Landroid/graphics/Rect;", "plugin-recordvideo_release"})
public final class p
  extends b
{
  private final Matrix CfS;
  private final int Cge;
  private k Cgf;
  private final String TAG;
  private final int apv;
  private final int oyw;
  
  public p(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76166);
    this.TAG = "MicroMsg.PositionItemView";
    this.Cge = -1;
    this.oyw = -1;
    this.apv = at.fromDPToPix(paramContext, 32);
    this.CfS = new Matrix();
    AppMethodBeat.o(76166);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(237825);
    kotlin.g.b.p.h(paramk, "item");
    b(paramk);
    setViewMatrix(paramk.gT);
    getTouchTracker().gT.set(paramk.gT);
    setSourceDataType(d.CeM);
    AppMethodBeat.o(237825);
  }
  
  public final Bitmap b(k paramk)
  {
    AppMethodBeat.i(237826);
    this.Cgf = paramk;
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject1 = LayoutInflater.from(getContext()).inflate(2131496586, (ViewGroup)localRelativeLayout, true);
    Object localObject3 = (TextView)((View)localObject1).findViewById(2131298732);
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131306013);
    Object localObject4 = (ImageView)((View)localObject1).findViewById(2131308689);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131308690);
    kotlin.g.b.p.g(localObject3, "cityText");
    com.tencent.mm.ac.d.f((TextView)localObject3);
    kotlin.g.b.p.g(localObject2, "poiText");
    com.tencent.mm.ac.d.f((TextView)localObject2);
    ((TextView)localObject3).setText((CharSequence)paramk.Cfy);
    ((TextView)localObject2).setText((CharSequence)paramk.kHV);
    ((ImageView)localObject4).setImageDrawable(ar.m(getContext(), 2131690589, -1));
    localObject4 = paramk.kHV;
    if (localObject4 == null)
    {
      paramk = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(237826);
      throw paramk;
    }
    if (TextUtils.isEmpty((CharSequence)n.trim((CharSequence)localObject4).toString()))
    {
      ((TextView)localObject3).setTextSize(0, at.fromDPToPix(getContext(), 20));
      kotlin.g.b.p.g(localImageView, "splitIcon");
      localImageView.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
    }
    localObject4 = paramk.Cfy;
    if (localObject4 == null)
    {
      paramk = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(237826);
      throw paramk;
    }
    if (TextUtils.isEmpty((CharSequence)n.trim((CharSequence)localObject4).toString()))
    {
      ((TextView)localObject2).setTextSize(0, at.fromDPToPix(getContext(), 20));
      ((TextView)localObject3).setVisibility(8);
      kotlin.g.b.p.g(localImageView, "splitIcon");
      localImageView.setVisibility(8);
    }
    int i = this.apv;
    localObject3 = e.BKp;
    if (i >= e.eIR().left)
    {
      localObject3 = e.BKp;
      i = e.eIR().width();
      j = this.apv;
      localObject3 = e.BKp;
      i -= (j - e.eIR().left) * 2;
      ((TextView)localObject2).setMaxWidth(i);
      ((View)localObject1).measure(0, 0);
      kotlin.g.b.p.g(localObject1, "parent");
      ((View)localObject1).layout(0, 0, ((View)localObject1).getMeasuredWidth(), ((View)localObject1).getMeasuredHeight());
      Log.i(this.TAG, paramk + " parent.measuredWidth:" + ((View)localObject1).getMeasuredWidth() + " , parent.measuredHeight:" + ((View)localObject1).getMeasuredHeight());
      if (((View)localObject1).getMeasuredWidth() > 0)
      {
        i = ((View)localObject1).getMeasuredWidth();
        localObject2 = e.BKp;
        if (i <= e.eIR().width()) {
          break label637;
        }
      }
      localObject2 = e.BKp;
      i = e.eIR().width();
      label507:
      if (((View)localObject1).getMeasuredHeight() > 0)
      {
        j = ((View)localObject1).getMeasuredHeight();
        localObject2 = e.BKp;
        if (j <= e.eIR().height()) {
          break label646;
        }
      }
      localObject1 = e.BKp;
    }
    label646:
    for (int j = e.eIR().height();; j = ((View)localObject1).getMeasuredHeight())
    {
      localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localRelativeLayout.draw(new Canvas((Bitmap)localObject1));
      setColor(this.Cge);
      setTextBg(this.oyw);
      setSourceDataType(d.CeM);
      setLocation(paramk);
      setBitmap((Bitmap)localObject1);
      kotlin.g.b.p.g(localObject1, "bitmap");
      AppMethodBeat.o(237826);
      return localObject1;
      localObject3 = e.BKp;
      i = e.eIR().width();
      break;
      label637:
      i = ((View)localObject1).getMeasuredWidth();
      break label507;
    }
  }
  
  public final a getEditorData()
  {
    return (a)this.Cgf;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    return com.tencent.mm.plugin.recordvideo.ui.editor.view.b.ChA;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76162);
    kotlin.g.b.p.h(paramMotionEvent, "event");
    this.CfS.set(getTouchTracker().gT);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    getTouchTracker().gT.set(this.CfS);
    AppMethodBeat.o(76162);
    return bool;
  }
  
  public final void setLocation(dlg paramdlg)
  {
    AppMethodBeat.i(76165);
    kotlin.g.b.p.h(paramdlg, "location");
    String str1 = paramdlg.kea;
    kotlin.g.b.p.g(str1, "location.City");
    String str2 = paramdlg.kHV;
    kotlin.g.b.p.g(str2, "location.poiName");
    b(new k(str1, str2, paramdlg.LbC, paramdlg.LbD));
    paramdlg = getBitmap();
    if (paramdlg != null)
    {
      float f2 = getValidRect().height() - at.fromDPToPix(getContext(), 128) - au.aD(getContext());
      float f3 = paramdlg.getHeight();
      int i = this.apv;
      paramdlg = e.BKp;
      if (i >= e.eIR().left) {}
      for (float f1 = this.apv;; f1 = e.eIR().left)
      {
        getTouchTracker().gT.setTranslate(f1, f2 - f3);
        AppMethodBeat.o(76165);
        return;
        paramdlg = e.BKp;
      }
    }
    AppMethodBeat.o(76165);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76161);
    kotlin.g.b.p.h(paramRect, "validRect");
    getValidRect().set(paramRect);
    AppMethodBeat.o(76161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.p
 * JD-Core Version:    0.7.0.1
 */