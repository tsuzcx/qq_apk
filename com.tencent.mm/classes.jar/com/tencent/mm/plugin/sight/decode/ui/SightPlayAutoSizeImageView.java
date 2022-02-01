package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.a.b.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

public class SightPlayAutoSizeImageView
  extends ImageView
  implements com.tencent.mm.plugin.sight.decode.a.a
{
  private b ySq;
  
  public SightPlayAutoSizeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightPlayAutoSizeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28627);
    this.ySq = new a(this);
    AppMethodBeat.o(28627);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(28628);
    this.ySq.clear();
    AppMethodBeat.o(28628);
  }
  
  public final void dQa()
  {
    AppMethodBeat.i(28634);
    setImageBitmap(null);
    setImageResource(2131233476);
    AppMethodBeat.o(28634);
  }
  
  public final void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(169763);
    this.ySq.bH(paramString, paramBoolean);
    AppMethodBeat.o(169763);
  }
  
  public Object getTagObject()
  {
    AppMethodBeat.i(28636);
    Object localObject = getTag();
    AppMethodBeat.o(28636);
    return localObject;
  }
  
  public Context getUIContext()
  {
    AppMethodBeat.i(28637);
    Context localContext = getContext();
    AppMethodBeat.o(28637);
    return localContext;
  }
  
  public String getVideoPath()
  {
    return this.ySq.cuO;
  }
  
  public final void hw(int paramInt1, int paramInt2) {}
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(28632);
    ad.d("MicroMsg.SightPlayAutoSizeImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    com.tencent.mm.sdk.b.a.IbL.c(this.ySq.dQf());
    AppMethodBeat.o(28632);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(28631);
    super.onDetachedFromWindow();
    ad.i("MicroMsg.SightPlayAutoSizeImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.ySq.clear();
    com.tencent.mm.sdk.b.a.IbL.d(this.ySq.dQf());
    AppMethodBeat.o(28631);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.ySq.yRL = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt) {}
  
  public void setForceRecordState(boolean paramBoolean)
  {
    this.ySq.yRW = paramBoolean;
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.ySq.yRQ = paramBoolean;
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(b.e parame)
  {
    this.ySq.yRY = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    AppMethodBeat.i(193351);
    this.ySq.setOnDecodeDurationListener(paramf);
    AppMethodBeat.o(193351);
  }
  
  public void setOnSightCompletionAction(b.g paramg) {}
  
  public void setPosition(int paramInt)
  {
    this.ySq.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(28639);
    this.ySq.setSightInfoView(paramTextView);
    AppMethodBeat.o(28639);
  }
  
  public void setTagObject(Object paramObject)
  {
    AppMethodBeat.i(28635);
    setTag(paramObject);
    AppMethodBeat.o(28635);
  }
  
  public void setThumbBgView(View paramView)
  {
    AppMethodBeat.i(28638);
    this.ySq.setThumbBgView(paramView);
    AppMethodBeat.o(28638);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(28633);
    setImageBitmap(paramBitmap);
    AppMethodBeat.o(28633);
  }
  
  static final class a
    extends b
  {
    private WeakReference<SightPlayAutoSizeImageView> ySr;
    
    public a(SightPlayAutoSizeImageView paramSightPlayAutoSizeImageView)
    {
      super(paramSightPlayAutoSizeImageView);
      AppMethodBeat.i(28625);
      this.ySr = new WeakReference(paramSightPlayAutoSizeImageView);
      AppMethodBeat.o(28625);
    }
    
    public final void ah(Bitmap paramBitmap)
    {
      AppMethodBeat.i(28626);
      SightPlayAutoSizeImageView localSightPlayAutoSizeImageView = (SightPlayAutoSizeImageView)this.ySr.get();
      if (localSightPlayAutoSizeImageView == null)
      {
        ad.e("MicroMsg.SightPlayAutoSizeImageView", "onGetFrameBmp, imageView is null, do clear");
        clear();
        AppMethodBeat.o(28626);
        return;
      }
      localSightPlayAutoSizeImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localSightPlayAutoSizeImageView.setImageBitmap(paramBitmap);
      AppMethodBeat.o(28626);
    }
    
    public final int dQb()
    {
      return 2130772136;
    }
    
    public final void eb(int paramInt1, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayAutoSizeImageView
 * JD-Core Version:    0.7.0.1
 */