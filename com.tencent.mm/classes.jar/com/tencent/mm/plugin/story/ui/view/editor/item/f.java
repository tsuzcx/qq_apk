package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.f.b.j;
import a.l;
import a.l.m;
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
import com.tencent.mm.ab.b;
import com.tencent.mm.media.editor.a.i;
import com.tencent.mm.media.editor.c.c;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.al;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/editor/item/PositionItemView;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DEFAULT_BG_COLOR", "", "DEFAULT_TEXT_COLOR", "MARGIN", "TAG", "", "latitude", "", "getLatitude", "()F", "setLatitude", "(F)V", "longitude", "getLongitude", "setLongitude", "originMatrix", "Landroid/graphics/Matrix;", "reportPositionString", "Ljava/lang/StringBuffer;", "getReportPositionString", "()Ljava/lang/StringBuffer;", "setReportPositionString", "(Ljava/lang/StringBuffer;)V", "validRect", "Landroid/graphics/Rect;", "createPositionBitmap", "Landroid/graphics/Bitmap;", "cityName", "poiName", "createReportString", "", "city", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowPosition", "matrix", "setLocation", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "setValidArea", "heightPercent", "plugin-story_release"})
public final class f
  extends a
{
  private final int MARGIN;
  private final String TAG;
  private float cAH;
  private float cyV;
  private final int jrt;
  private final Matrix sRa;
  private Rect sRc;
  private final int sRn;
  private StringBuffer sRo;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(110692);
    this.TAG = "MicroMsg.PositionItemView";
    this.sRn = -1;
    this.jrt = -1;
    this.MARGIN = al.fromDPToPix(paramContext, 32);
    this.sRc = new Rect();
    this.sRa = new Matrix();
    this.sRo = new StringBuffer();
    AppMethodBeat.o(110692);
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(151289);
    j.q(paramRect, "validRect");
    super.a(paramRect, paramFloat);
    this.sRc = paramRect;
    AppMethodBeat.o(151289);
  }
  
  public final void a(String paramString1, String paramString2, Matrix paramMatrix)
  {
    AppMethodBeat.i(110688);
    j.q(paramString1, "cityName");
    j.q(paramString2, "poiName");
    j.q(paramMatrix, "matrix");
    gS(paramString1, paramString2);
    setViewMatrix(paramMatrix);
    setSourceDataType(com.tencent.mm.media.editor.a.e.eSE);
    AppMethodBeat.o(110688);
  }
  
  public final Bitmap gS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110689);
    j.q(paramString1, "cityName");
    j.q(paramString2, "poiName");
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject1 = LayoutInflater.from(getContext()).inflate(2130970943, (ViewGroup)localRelativeLayout, true);
    Object localObject3 = (TextView)((View)localObject1).findViewById(2131828351);
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131828353);
    ImageView localImageView1 = (ImageView)((View)localObject1).findViewById(2131828350);
    ImageView localImageView2 = (ImageView)((View)localObject1).findViewById(2131828352);
    j.p(localObject3, "cityText");
    b.e((TextView)localObject3);
    j.p(localObject2, "poiText");
    b.e((TextView)localObject2);
    ((TextView)localObject3).setText((CharSequence)paramString1);
    ((TextView)localObject2).setText((CharSequence)paramString2);
    localImageView1.setImageDrawable(aj.g(getContext(), 2131231458, -1));
    if (TextUtils.isEmpty((CharSequence)m.trim((CharSequence)paramString2).toString()))
    {
      ((TextView)localObject3).setTextSize(0, com.tencent.mm.plugin.appbrand.t.e.c(getContext(), 20.0F));
      j.p(localImageView2, "splitIcon");
      localImageView2.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
    }
    if (TextUtils.isEmpty((CharSequence)m.trim((CharSequence)paramString1).toString()))
    {
      ((TextView)localObject2).setTextSize(0, com.tencent.mm.plugin.appbrand.t.e.c(getContext(), 20.0F));
      ((TextView)localObject3).setVisibility(8);
      j.p(localImageView2, "splitIcon");
      localImageView2.setVisibility(8);
    }
    int i = this.MARGIN;
    localObject3 = k.sCp;
    if (i >= k.cCr().left)
    {
      localObject3 = k.sCp;
      i = k.cCr().width();
      j = this.MARGIN;
      localObject3 = k.sCp;
      i -= (j - k.cCr().left) * 2;
      ((TextView)localObject2).setMaxWidth(i);
      ((View)localObject1).measure(0, 0);
      j.p(localObject1, "parent");
      ((View)localObject1).layout(0, 0, ((View)localObject1).getMeasuredWidth(), ((View)localObject1).getMeasuredHeight());
      ab.i(this.TAG, "cityName : " + paramString1 + ", poiName : " + paramString2 + " parent.measuredWidth:" + ((View)localObject1).getMeasuredWidth() + " , parent.measuredHeight:" + ((View)localObject1).getMeasuredHeight());
      if (((View)localObject1).getMeasuredWidth() > 0)
      {
        i = ((View)localObject1).getMeasuredWidth();
        localObject2 = k.sCp;
        if (i <= k.cCr().width()) {
          break label607;
        }
      }
      localObject2 = k.sCp;
      i = k.cCr().width();
      label465:
      if (((View)localObject1).getMeasuredHeight() > 0)
      {
        j = ((View)localObject1).getMeasuredHeight();
        localObject2 = k.sCp;
        if (j <= k.cCr().height()) {
          break label616;
        }
      }
      localObject1 = k.sCp;
    }
    label607:
    label616:
    for (int j = k.cCr().height();; j = ((View)localObject1).getMeasuredHeight())
    {
      localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localRelativeLayout.draw(new Canvas((Bitmap)localObject1));
      setColor(this.sRn);
      setTextBg(this.jrt);
      setSourceDataType(com.tencent.mm.media.editor.a.e.eSE);
      setLocation(new i(paramString1, paramString2));
      setBitmap((Bitmap)localObject1);
      j.p(localObject1, "bitmap");
      AppMethodBeat.o(110689);
      return localObject1;
      localObject3 = k.sCp;
      i = k.cCr().width();
      break;
      i = ((View)localObject1).getMeasuredWidth();
      break label465;
    }
  }
  
  public final float getLatitude()
  {
    return this.cyV;
  }
  
  public final float getLongitude()
  {
    return this.cAH;
  }
  
  public final StringBuffer getReportPositionString()
  {
    return this.sRo;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(151290);
    j.q(paramMotionEvent, "event");
    this.sRa.set(getTouchTracker().asO);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    getTouchTracker().asO.set(this.sRa);
    AppMethodBeat.o(151290);
    return bool;
  }
  
  public final void setLatitude(float paramFloat)
  {
    this.cyV = paramFloat;
  }
  
  public final void setLocation(chj paramchj)
  {
    AppMethodBeat.i(110690);
    j.q(paramchj, "location");
    String str1 = paramchj.gwR;
    j.p(str1, "location.City");
    String str2 = paramchj.eSM;
    j.p(str2, "location.poiName");
    gS(str1, str2);
    str1 = paramchj.gwR;
    j.p(str1, "location.City");
    str2 = paramchj.eSM;
    j.p(str2, "location.poiName");
    this.sRo.setLength(0);
    if (!TextUtils.isEmpty((CharSequence)str1)) {
      this.sRo.append(m.h(str1, ",", " ", true));
    }
    int i;
    float f2;
    float f3;
    if (!TextUtils.isEmpty((CharSequence)str2))
    {
      if (((CharSequence)this.sRo).length() > 0)
      {
        i = 1;
        if (i != 0) {
          this.sRo.append("|");
        }
        this.sRo.append(m.h(str2, ",", " ", true));
      }
    }
    else
    {
      this.cAH = paramchj.wDh;
      this.cyV = paramchj.wDi;
      paramchj = getBitmap();
      if (paramchj == null) {
        break label309;
      }
      f2 = this.sRc.height() - al.fromDPToPix(getContext(), 128) - getNavigateBarHeight();
      f3 = paramchj.getHeight();
      i = this.MARGIN;
      paramchj = k.sCp;
      if (i < k.cCr().left) {
        break label294;
      }
    }
    for (float f1 = this.MARGIN;; f1 = k.cCr().left)
    {
      getTouchTracker().asO.setTranslate(f1, f2 - f3);
      AppMethodBeat.o(110690);
      return;
      i = 0;
      break;
      label294:
      paramchj = k.sCp;
    }
    label309:
    AppMethodBeat.o(110690);
  }
  
  public final void setLongitude(float paramFloat)
  {
    this.cAH = paramFloat;
  }
  
  public final void setReportPositionString(StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(110691);
    j.q(paramStringBuffer, "<set-?>");
    this.sRo = paramStringBuffer;
    AppMethodBeat.o(110691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.item.f
 * JD-Core Version:    0.7.0.1
 */