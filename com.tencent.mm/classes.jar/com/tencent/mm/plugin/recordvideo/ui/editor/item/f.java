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
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.l;
import d.n.n;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PositionItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DEFAULT_BG_COLOR", "", "DEFAULT_TEXT_COLOR", "MARGIN", "TAG", "", "originMatrix", "Landroid/graphics/Matrix;", "createPositionBitmap", "Landroid/graphics/Bitmap;", "cityName", "poiName", "longitude", "", "latitude", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditItemType;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowPosition", "", "matrix", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "setValidArea", "validRect", "Landroid/graphics/Rect;", "plugin-recordvideo_release"})
public final class f
  extends a
{
  private final int MARGIN;
  private final String TAG;
  private final int mhk;
  private final Matrix vtt;
  private final int vtx;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76166);
    this.TAG = "MicroMsg.PositionItemView";
    this.vtx = -1;
    this.mhk = -1;
    this.MARGIN = ao.fromDPToPix(paramContext, 32);
    this.vtt = new Matrix();
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
    com.tencent.mm.ad.c.e((TextView)localObject3);
    k.g(localObject2, "poiText");
    com.tencent.mm.ad.c.e((TextView)localObject2);
    ((TextView)localObject3).setText((CharSequence)paramString1);
    ((TextView)localObject2).setText((CharSequence)paramString2);
    localImageView1.setImageDrawable(am.i(getContext(), 2131690422, -1));
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
    int i = this.MARGIN;
    localObject3 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    if (i >= com.tencent.mm.plugin.recordvideo.background.f.dgJ().left)
    {
      localObject3 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      i = com.tencent.mm.plugin.recordvideo.background.f.dgJ().width();
      j = this.MARGIN;
      localObject3 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      i -= (j - com.tencent.mm.plugin.recordvideo.background.f.dgJ().left) * 2;
      ((TextView)localObject2).setMaxWidth(i);
      ((View)localObject1).measure(0, 0);
      k.g(localObject1, "parent");
      ((View)localObject1).layout(0, 0, ((View)localObject1).getMeasuredWidth(), ((View)localObject1).getMeasuredHeight());
      ad.i(this.TAG, "cityName : " + paramString1 + ", poiName : " + paramString2 + " parent.measuredWidth:" + ((View)localObject1).getMeasuredWidth() + " , parent.measuredHeight:" + ((View)localObject1).getMeasuredHeight());
      if (((View)localObject1).getMeasuredWidth() > 0)
      {
        i = ((View)localObject1).getMeasuredWidth();
        localObject2 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
        if (i <= com.tencent.mm.plugin.recordvideo.background.f.dgJ().width()) {
          break label616;
        }
      }
      localObject2 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      i = com.tencent.mm.plugin.recordvideo.background.f.dgJ().width();
      label469:
      if (((View)localObject1).getMeasuredHeight() > 0)
      {
        j = ((View)localObject1).getMeasuredHeight();
        localObject2 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
        if (j <= com.tencent.mm.plugin.recordvideo.background.f.dgJ().height()) {
          break label626;
        }
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    }
    label616:
    label626:
    for (int j = com.tencent.mm.plugin.recordvideo.background.f.dgJ().height();; j = ((View)localObject1).getMeasuredHeight())
    {
      localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localRelativeLayout.draw(new Canvas((Bitmap)localObject1));
      setColor(this.vtx);
      setTextBg(this.mhk);
      setSourceDataType(e.goI);
      setLocation(new i(paramString1, paramString2, paramFloat1, paramFloat2));
      setBitmap((Bitmap)localObject1);
      k.g(localObject1, "bitmap");
      AppMethodBeat.o(76164);
      return localObject1;
      localObject3 = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      i = com.tencent.mm.plugin.recordvideo.background.f.dgJ().width();
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
    setSourceDataType(e.goI);
    AppMethodBeat.o(76163);
  }
  
  public final b getType()
  {
    return b.vsM;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76162);
    k.h(paramMotionEvent, "event");
    this.vtt.set(getTouchTracker().dY);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    getTouchTracker().dY.set(this.vtt);
    AppMethodBeat.o(76162);
    return bool;
  }
  
  public final void setLocation(chx paramchx)
  {
    AppMethodBeat.i(76165);
    k.h(paramchx, "location");
    String str1 = paramchx.ijO;
    k.g(str1, "location.City");
    String str2 = paramchx.goQ;
    k.g(str2, "location.poiName");
    a(str1, str2, paramchx.COI, paramchx.COJ);
    paramchx = getBitmap();
    if (paramchx != null)
    {
      float f2 = getValidRect().height() - ao.fromDPToPix(getContext(), 128) - ap.eb(getContext());
      float f3 = paramchx.getHeight();
      int i = this.MARGIN;
      paramchx = com.tencent.mm.plugin.recordvideo.background.f.vdH;
      if (i >= com.tencent.mm.plugin.recordvideo.background.f.dgJ().left) {}
      for (float f1 = this.MARGIN;; f1 = com.tencent.mm.plugin.recordvideo.background.f.dgJ().left)
      {
        getTouchTracker().dY.setTranslate(f1, f2 - f3);
        AppMethodBeat.o(76165);
        return;
        paramchx = com.tencent.mm.plugin.recordvideo.background.f.vdH;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.f
 * JD-Core Version:    0.7.0.1
 */