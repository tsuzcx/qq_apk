package com.tencent.mm.plugin.sight.decode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.a.b.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.MMTextureView;

@TargetApi(14)
public class SightPlayTextureView
  extends MMTextureView
  implements com.tencent.mm.plugin.sight.decode.a.a
{
  private Surface mSurface;
  private b qTR;
  private int qTT;
  private boolean qTY;
  private int qUe;
  private int videoHeight;
  private int videoWidth;
  
  public SightPlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightPlayTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(24980);
    this.qTY = false;
    setOpaque(false);
    this.qTR = new SightPlayTextureView.b(this);
    setSurfaceTextureListener(new SightPlayTextureView.1(this));
    AppMethodBeat.o(24980);
  }
  
  private void z(double paramDouble)
  {
    AppMethodBeat.i(24987);
    final ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams.height != (int)(this.qTT * paramDouble))
    {
      localLayoutParams.width = this.qTT;
      localLayoutParams.height = ((int)(this.qTT * paramDouble));
      if ((this.qTY) && (localLayoutParams.height < com.tencent.mm.cb.a.fromDPToPix(getContext(), 50))) {
        localLayoutParams.height = com.tencent.mm.cb.a.fromDPToPix(getContext(), 50);
      }
      ab.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
      if (al.isMainThread())
      {
        setLayoutParams(localLayoutParams);
        AppMethodBeat.o(24987);
        return;
      }
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24974);
          SightPlayTextureView.this.setLayoutParams(localLayoutParams);
          AppMethodBeat.o(24974);
        }
      });
    }
    AppMethodBeat.o(24987);
  }
  
  public final void bl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(24982);
    this.qTR.bl(paramString, paramBoolean);
    AppMethodBeat.o(24982);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(24981);
    this.qTR.clear();
    AppMethodBeat.o(24981);
  }
  
  public final void cmx()
  {
    AppMethodBeat.i(24989);
    Bitmap localBitmap1 = b.b(getContext(), 2130839821, this.qTT, 320, 240);
    Bitmap localBitmap2 = b.b(getContext(), this.qUe, this.qTT, 320, 240);
    SightVideoJNI.drawSurfaceThumb(this.mSurface, localBitmap1, localBitmap2);
    AppMethodBeat.o(24989);
  }
  
  public final boolean cmy()
  {
    AppMethodBeat.i(24983);
    boolean bool = this.qTR.cmB();
    AppMethodBeat.o(24983);
    return bool;
  }
  
  public final void ft(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24993);
    final ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    this.qTT = paramInt1;
    localLayoutParams.width = this.qTT;
    localLayoutParams.height = (this.qTT * paramInt2 / paramInt1);
    ab.i("MicroMsg.SightPlayTextureView", "params width %d height %d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
    if (al.isMainThread())
    {
      setLayoutParams(localLayoutParams);
      AppMethodBeat.o(24993);
      return;
    }
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24975);
        SightPlayTextureView.this.setLayoutParams(localLayoutParams);
        AppMethodBeat.o(24975);
      }
    });
    AppMethodBeat.o(24993);
  }
  
  public Object getTagObject()
  {
    AppMethodBeat.i(24991);
    Object localObject = getTag();
    AppMethodBeat.o(24991);
    return localObject;
  }
  
  public Context getUIContext()
  {
    AppMethodBeat.i(24992);
    Context localContext = getContext();
    AppMethodBeat.o(24992);
    return localContext;
  }
  
  public String getVideoPath()
  {
    return this.qTR.bHM;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(24985);
    ab.d("MicroMsg.SightPlayTextureView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    com.tencent.mm.sdk.b.a.ymk.c(this.qTR.cmD());
    AppMethodBeat.o(24985);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(24984);
    super.onDetachedFromWindow();
    ab.i("MicroMsg.SightPlayTextureView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.qTR.clear();
    com.tencent.mm.sdk.b.a.ymk.d(this.qTR.cmD());
    AppMethodBeat.o(24984);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.qTR.qSZ = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(24986);
    this.qTT = paramInt;
    z(0.75D);
    AppMethodBeat.o(24986);
  }
  
  public void setForceRecordState(boolean paramBoolean) {}
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.qTR.qTc = paramBoolean;
  }
  
  public void setMaskID(int paramInt)
  {
    this.qUe = paramInt;
  }
  
  public void setOnCompletionListener(b.e parame)
  {
    this.qTR.qTk = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    this.qTR.qTl = paramf;
  }
  
  public void setOnSightCompletionAction(b.g paramg) {}
  
  public void setPosition(int paramInt)
  {
    this.qTR.position = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(24995);
    this.qTR.setSightInfoView(paramTextView);
    AppMethodBeat.o(24995);
  }
  
  public void setTagObject(Object paramObject)
  {
    AppMethodBeat.i(24990);
    setTag(paramObject);
    AppMethodBeat.o(24990);
  }
  
  public void setThumbBgView(View paramView)
  {
    AppMethodBeat.i(24994);
    this.qTR.setThumbBgView(paramView);
    AppMethodBeat.o(24994);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(24988);
    boolean bool1;
    boolean bool2;
    if (paramBitmap == null)
    {
      bool1 = true;
      if (this.mSurface != null) {
        break label184;
      }
      bool2 = true;
      label21:
      ab.d("MicroMsg.SightPlayTextureView", "thumb is null? %B, surface is null? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (paramBitmap == null) {
        break label205;
      }
      ab.d("MicroMsg.SightPlayTextureView", "thumb size [%d, %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
      if (this.qTY) {
        if (paramBitmap.getWidth() < paramBitmap.getHeight()) {
          break label189;
        }
      }
    }
    label184:
    label189:
    for (this.qTT = com.tencent.mm.cb.a.fromDPToPix(getContext(), 150);; this.qTT = com.tencent.mm.cb.a.fromDPToPix(getContext(), 85))
    {
      Bitmap localBitmap = b.b(getContext(), this.qUe, this.qTT, paramBitmap.getWidth(), paramBitmap.getHeight());
      z(paramBitmap.getHeight() / paramBitmap.getWidth());
      this.qTR.qSJ = localBitmap;
      this.qTR.R(paramBitmap);
      AppMethodBeat.o(24988);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label21;
    }
    label205:
    this.qTR.R(null);
    AppMethodBeat.o(24988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView
 * JD-Core Version:    0.7.0.1
 */