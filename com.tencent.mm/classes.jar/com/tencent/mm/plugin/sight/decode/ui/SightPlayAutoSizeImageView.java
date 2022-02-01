package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.g;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.d;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.e;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.f;
import com.tencent.mm.plugin.sight.decode.model.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public class SightPlayAutoSizeImageView
  extends ImageView
  implements a
{
  private SightPlayController PGy;
  
  public SightPlayAutoSizeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightPlayAutoSizeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28627);
    this.PGy = new a(this);
    AppMethodBeat.o(28627);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(28628);
    this.PGy.clear();
    AppMethodBeat.o(28628);
  }
  
  public final void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(169763);
    this.PGy.cM(paramString, paramBoolean);
    AppMethodBeat.o(169763);
  }
  
  public final void gYs()
  {
    AppMethodBeat.i(28634);
    setImageBitmap(null);
    setImageResource(R.g.nosdcard_chatting_bg);
    AppMethodBeat.o(28634);
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
    return this.PGy.eDC;
  }
  
  public final void ld(int paramInt1, int paramInt2) {}
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(28632);
    Log.d("MicroMsg.SightPlayAutoSizeImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    this.PGy.gYx().alive();
    AppMethodBeat.o(28632);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(28631);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.SightPlayAutoSizeImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.PGy.clear();
    this.PGy.gYx().dead();
    AppMethodBeat.o(28631);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.PGy.PFT = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt) {}
  
  public void setForceRecordState(boolean paramBoolean)
  {
    this.PGy.PGe = paramBoolean;
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.PGy.PFY = paramBoolean;
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(SightPlayController.d paramd)
  {
    this.PGy.PGg = paramd;
  }
  
  public void setOnDecodeDurationListener(SightPlayController.e parame)
  {
    AppMethodBeat.i(291969);
    this.PGy.setOnDecodeDurationListener(parame);
    AppMethodBeat.o(291969);
  }
  
  public void setOnSightCompletionAction(SightPlayController.f paramf) {}
  
  public void setPosition(int paramInt)
  {
    this.PGy.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(28639);
    this.PGy.setSightInfoView(paramTextView);
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
    this.PGy.setThumbBgView(paramView);
    AppMethodBeat.o(28638);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(28633);
    setImageBitmap(paramBitmap);
    AppMethodBeat.o(28633);
  }
  
  static final class a
    extends SightPlayController
  {
    private WeakReference<SightPlayAutoSizeImageView> PGz;
    
    public a(SightPlayAutoSizeImageView paramSightPlayAutoSizeImageView)
    {
      super(paramSightPlayAutoSizeImageView);
      AppMethodBeat.i(28625);
      this.PGz = new WeakReference(paramSightPlayAutoSizeImageView);
      AppMethodBeat.o(28625);
    }
    
    public final void aF(Bitmap paramBitmap)
    {
      AppMethodBeat.i(28626);
      SightPlayAutoSizeImageView localSightPlayAutoSizeImageView = (SightPlayAutoSizeImageView)this.PGz.get();
      if (localSightPlayAutoSizeImageView == null)
      {
        Log.e("MicroMsg.SightPlayAutoSizeImageView", "onGetFrameBmp, imageView is null, do clear");
        clear();
        AppMethodBeat.o(28626);
        return;
      }
      localSightPlayAutoSizeImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localSightPlayAutoSizeImageView.setImageBitmap(paramBitmap);
      AppMethodBeat.o(28626);
    }
    
    public final void fG(int paramInt1, int paramInt2) {}
    
    public final int gYt()
    {
      return R.a.sight_loop;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayAutoSizeImageView
 * JD-Core Version:    0.7.0.1
 */