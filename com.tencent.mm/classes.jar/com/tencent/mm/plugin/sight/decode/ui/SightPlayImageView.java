package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.a.b.g;
import com.tencent.mm.plugin.sight.decode.a.b.i;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

public class SightPlayImageView
  extends QPictureView
  implements com.tencent.mm.plugin.sight.decode.a.a
{
  public e.a lxA;
  public b qTR;
  private int qTT;
  private int qTU;
  private int qTV;
  private int qTW;
  public boolean qTX;
  private boolean qTY;
  public boolean qTZ;
  int qUa;
  
  public SightPlayImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public SightPlayImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightPlayImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(70256);
    this.qTX = true;
    this.qTY = false;
    this.qTZ = false;
    this.qUa = 0;
    this.qTR = new SightPlayImageView.a(this);
    ab.i("MicroMsg.SightPlayImageView", "mController %s", new Object[] { bo.dtY().toString() });
    AppMethodBeat.o(70256);
  }
  
  public final void T(Bitmap paramBitmap)
  {
    AppMethodBeat.i(70259);
    super.setImageBitmap(paramBitmap);
    AppMethodBeat.o(70259);
  }
  
  public final void bl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70261);
    this.qTR.bl(paramString, paramBoolean);
    AppMethodBeat.o(70261);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(70260);
    this.qTR.clear();
    AppMethodBeat.o(70260);
  }
  
  public final void cmx()
  {
    AppMethodBeat.i(70267);
    setImageBitmap(null);
    setImageResource(2130839821);
    AppMethodBeat.o(70267);
  }
  
  public final boolean cmy()
  {
    AppMethodBeat.i(70262);
    boolean bool = this.qTR.cmB();
    AppMethodBeat.o(70262);
    return bool;
  }
  
  public void ft(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70271);
    this.qTX = false;
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    this.qTT = paramInt1;
    this.qTU = (this.qTT * paramInt2 / paramInt1);
    localLayoutParams.width = this.qTT;
    localLayoutParams.height = this.qTU;
    setLayoutParams(localLayoutParams);
    postInvalidate();
    AppMethodBeat.o(70271);
  }
  
  public b getController()
  {
    return this.qTR;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(70275);
    if (this.qTR == null)
    {
      AppMethodBeat.o(70275);
      return 0;
    }
    int i = (int)this.qTR.cmE();
    AppMethodBeat.o(70275);
    return i;
  }
  
  public Object getTagObject()
  {
    AppMethodBeat.i(70269);
    Object localObject = getTag();
    AppMethodBeat.o(70269);
    return localObject;
  }
  
  public Context getUIContext()
  {
    AppMethodBeat.i(70270);
    Context localContext = getContext();
    AppMethodBeat.o(70270);
    return localContext;
  }
  
  public String getVideoPath()
  {
    return this.qTR.bHM;
  }
  
  public final void kS(boolean paramBoolean)
  {
    AppMethodBeat.i(70274);
    b localb = this.qTR;
    ab.i("MicroMsg.SightPlayController", "configure: need sound %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (localb.qST == null)
      {
        localb.qST = new b.i(localb, (byte)0);
        AppMethodBeat.o(70274);
      }
    }
    else
    {
      if (localb.qST != null)
      {
        localb.qST.type = 0;
        o.j(localb.qST, 0L);
      }
      localb.qST = null;
    }
    AppMethodBeat.o(70274);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(70264);
    ab.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", new Object[] { Integer.valueOf(hashCode()) });
    super.onAttachedToWindow();
    com.tencent.mm.sdk.b.a.ymk.c(this.qTR.cmD());
    AppMethodBeat.o(70264);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(70263);
    super.onDetachedFromWindow();
    ab.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", new Object[] { Integer.valueOf(hashCode()) });
    this.qTR.clear();
    com.tencent.mm.sdk.b.a.ymk.d(this.qTR.cmD());
    AppMethodBeat.o(70263);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(70276);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(70276);
  }
  
  public void setCanPlay(boolean paramBoolean)
  {
    this.qTR.qSZ = paramBoolean;
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(70265);
    this.qTX = false;
    this.qTT = paramInt;
    if ((this.qTV > 0) && (this.qTW > 0))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      this.qTU = (this.qTT * this.qTW / this.qTV);
      if ((localLayoutParams.width != this.qTT) || (localLayoutParams.height != this.qTU))
      {
        localLayoutParams.width = this.qTT;
        localLayoutParams.height = this.qTU;
        setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(70265);
  }
  
  public void setForceRecordState(boolean paramBoolean) {}
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(70257);
    super.setImageBitmap(paramBitmap);
    if (this.qTZ)
    {
      AppMethodBeat.o(70257);
      return;
    }
    int i;
    int j;
    if (paramBitmap == null) {
      if (this.qTU == 0)
      {
        i = 240;
        if (paramBitmap != null) {
          break label141;
        }
        if (this.qTT != 0) {
          break label132;
        }
        j = 320;
      }
    }
    for (;;)
    {
      paramBitmap = getLayoutParams();
      if (paramBitmap.height != (int)(this.qTT * i / j))
      {
        paramBitmap.width = this.qTT;
        float f = this.qTT;
        paramBitmap.height = ((int)(i * f / j));
        setLayoutParams(paramBitmap);
      }
      AppMethodBeat.o(70257);
      return;
      i = this.qTU;
      break;
      i = paramBitmap.getHeight();
      break;
      label132:
      j = this.qTT;
      continue;
      label141:
      j = paramBitmap.getWidth();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(70258);
    super.setImageDrawable(paramDrawable);
    if (this.qTZ)
    {
      AppMethodBeat.o(70258);
      return;
    }
    int i;
    int j;
    if (paramDrawable == null) {
      if (this.qTU == 0)
      {
        i = 240;
        if (paramDrawable != null) {
          break label161;
        }
        if (this.qTT != 0) {
          break label152;
        }
        j = 320;
      }
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        paramDrawable = getLayoutParams();
        if ((paramDrawable.height != (int)(this.qTT * i / j)) && (this.qUa == 0))
        {
          paramDrawable.width = this.qTT;
          float f = this.qTT;
          paramDrawable.height = ((int)(i * f / j));
          setLayoutParams(paramDrawable);
        }
      }
      AppMethodBeat.o(70258);
      return;
      i = this.qTU;
      break;
      i = paramDrawable.getIntrinsicHeight();
      break;
      label152:
      j = this.qTT;
      continue;
      label161:
      j = paramDrawable.getIntrinsicWidth();
    }
  }
  
  public void setIsWhatsNew(boolean paramBoolean)
  {
    this.qTR.qTc = paramBoolean;
  }
  
  public void setLoopImp(boolean paramBoolean)
  {
    if (this.qTR != null) {
      this.qTR.fVw = paramBoolean;
    }
  }
  
  public void setMaskID(int paramInt) {}
  
  public void setOnCompletionListener(b.e parame)
  {
    this.qTR.qTk = parame;
  }
  
  public void setOnDecodeDurationListener(b.f paramf)
  {
    this.qTR.qTl = paramf;
  }
  
  public void setOnSightCompletionAction(b.g paramg)
  {
    this.qTR.qTm = paramg;
  }
  
  public void setPosition(int paramInt)
  {
    this.qTR.position = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.qUa = paramInt;
  }
  
  public void setSightInfoView(TextView paramTextView)
  {
    AppMethodBeat.i(70273);
    this.qTR.setSightInfoView(paramTextView);
    AppMethodBeat.o(70273);
  }
  
  public void setTagObject(Object paramObject)
  {
    AppMethodBeat.i(70268);
    setTag(paramObject);
    AppMethodBeat.o(70268);
  }
  
  public void setThumbBgView(View paramView)
  {
    AppMethodBeat.i(70272);
    this.qTR.setThumbBgView(paramView);
    AppMethodBeat.o(70272);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(70266);
    setImageBitmap(paramBitmap);
    AppMethodBeat.o(70266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView
 * JD-Core Version:    0.7.0.1
 */