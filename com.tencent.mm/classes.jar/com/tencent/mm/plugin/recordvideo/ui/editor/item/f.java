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
import com.tencent.mm.media.editor.a.e;
import com.tencent.mm.media.editor.a.i;
import com.tencent.mm.plugin.recordvideo.background.g;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.l;
import d.n.n;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DEFAULT_BG_COLOR", "", "DEFAULT_TEXT_COLOR", "MARGIN", "TAG", "", "originMatrix", "Landroid/graphics/Matrix;", "createPositionBitmap", "Landroid/graphics/Bitmap;", "cityName", "poiName", "longitude", "", "latitude", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditItemType;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowPosition", "", "matrix", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setValidArea", "validRect", "Landroid/graphics/Rect;", "plugin-recordvideo_release"})
public final class f
  extends a
{
  private final String TAG;
  private final int anr;
  private final int mJl;
  private final Matrix wDt;
  private final int wDx;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76166);
    this.TAG = "MicroMsg.PositionItemView";
    this.wDx = -1;
    this.mJl = -1;
    this.anr = ao.fromDPToPix(paramContext, 32);
    this.wDt = new Matrix();
    AppMethodBeat.o(76166);
  }
  
  public final Bitmap a(String paramString1, String paramString2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(76164);
    k.h(paramString1, "cityName");
    k.h(paramString2, "poiName");
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject1 = LayoutInflater.from(getContext()).inflate(2131495681, (ViewGroup)localRelativeLayout, true);
    Object localObject3 = (TextView)((View)localObject1).findViewById(2131298338);
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131303336);
    ImageView localImageView1 = (ImageView)((View)localObject1).findViewById(2131305483);
    ImageView localImageView2 = (ImageView)((View)localObject1).findViewById(2131305484);
    k.g(localObject3, "cityText");
    com.tencent.mm.ac.c.e((TextView)localObject3);
    k.g(localObject2, "poiText");
    com.tencent.mm.ac.c.e((TextView)localObject2);
    ((TextView)localObject3).setText((CharSequence)paramString1);
    ((TextView)localObject2).setText((CharSequence)paramString2);
    localImageView1.setImageDrawable(am.k(getContext(), 2131690422, -1));
    if (TextUtils.isEmpty((CharSequence)n.trim((CharSequence)paramString2).toString()))
    {
      ((TextView)localObject3).setTextSize(0, ao.fromDPToPix(getContext(), 20));
      k.g(localImageView2, "splitIcon");
      localImageView2.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
    }
    if (TextUtils.isEmpty((CharSequence)n.trim((CharSequence)paramString1).toString()))
    {
      ((TextView)localObject2).setTextSize(0, ao.fromDPToPix(getContext(), 20));
      ((TextView)localObject3).setVisibility(8);
      k.g(localImageView2, "splitIcon");
      localImageView2.setVisibility(8);
    }
    int i = this.anr;
    localObject3 = g.wmx;
    if (i >= g.dur().left)
    {
      localObject3 = g.wmx;
      i = g.dur().width();
      j = this.anr;
      localObject3 = g.wmx;
      i -= (j - g.dur().left) * 2;
      ((TextView)localObject2).setMaxWidth(i);
      ((View)localObject1).measure(0, 0);
      k.g(localObject1, "parent");
      ((View)localObject1).layout(0, 0, ((View)localObject1).getMeasuredWidth(), ((View)localObject1).getMeasuredHeight());
      ac.i(this.TAG, "cityName : " + paramString1 + ", poiName : " + paramString2 + " parent.measuredWidth:" + ((View)localObject1).getMeasuredWidth() + " , parent.measuredHeight:" + ((View)localObject1).getMeasuredHeight());
      if (((View)localObject1).getMeasuredWidth() > 0)
      {
        i = ((View)localObject1).getMeasuredWidth();
        localObject2 = g.wmx;
        if (i <= g.dur().width()) {
          break label616;
        }
      }
      localObject2 = g.wmx;
      i = g.dur().width();
      label469:
      if (((View)localObject1).getMeasuredHeight() > 0)
      {
        j = ((View)localObject1).getMeasuredHeight();
        localObject2 = g.wmx;
        if (j <= g.dur().height()) {
          break label626;
        }
      }
      localObject1 = g.wmx;
    }
    label616:
    label626:
    for (int j = g.dur().height();; j = ((View)localObject1).getMeasuredHeight())
    {
      localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localRelativeLayout.draw(new Canvas((Bitmap)localObject1));
      setColor(this.wDx);
      setTextBg(this.mJl);
      setSourceDataType(e.gPq);
      setLocation(new i(paramString1, paramString2, paramFloat1, paramFloat2));
      setBitmap((Bitmap)localObject1);
      k.g(localObject1, "bitmap");
      AppMethodBeat.o(76164);
      return localObject1;
      localObject3 = g.wmx;
      i = g.dur().width();
      break;
      i = ((View)localObject1).getMeasuredWidth();
      break label469;
    }
  }
  
  public final void a(String paramString1, String paramString2, float paramFloat1, float paramFloat2, Matrix paramMatrix)
  {
    AppMethodBeat.i(76163);
    k.h(paramString1, "cityName");
    k.h(paramString2, "poiName");
    k.h(paramMatrix, "matrix");
    a(paramString1, paramString2, paramFloat1, paramFloat2);
    setViewMatrix(paramMatrix);
    setSourceDataType(e.gPq);
    AppMethodBeat.o(76163);
  }
  
  public final b getType()
  {
    return b.wCM;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76162);
    k.h(paramMotionEvent, "event");
    this.wDt.set(getTouchTracker().eY);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    getTouchTracker().eY.set(this.wDt);
    AppMethodBeat.o(76162);
    return bool;
  }
  
  public final void setLocation(cna paramcna)
  {
    AppMethodBeat.i(76165);
    k.h(paramcna, "location");
    String str1 = paramcna.iJV;
    k.g(str1, "location.City");
    String str2 = paramcna.gPy;
    k.g(str2, "location.poiName");
    a(str1, str2, paramcna.Eht, paramcna.Ehu);
    paramcna = getBitmap();
    if (paramcna != null)
    {
      float f2 = getValidRect().height() - ao.fromDPToPix(getContext(), 128) - ap.ej(getContext());
      float f3 = paramcna.getHeight();
      int i = this.anr;
      paramcna = g.wmx;
      if (i >= g.dur().left) {}
      for (float f1 = this.anr;; f1 = g.dur().left)
      {
        getTouchTracker().eY.setTranslate(f1, f2 - f3);
        AppMethodBeat.o(76165);
        return;
        paramcna = g.wmx;
      }
    }
    AppMethodBeat.o(76165);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76161);
    k.h(paramRect, "validRect");
    getValidRect().set(paramRect);
    AppMethodBeat.o(76161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.f
 * JD-Core Version:    0.7.0.1
 */