package com.tencent.mm.pluginsdk.ui.websearch;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

@TargetApi(16)
public class WebSearchVoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private View.OnLongClickListener asI;
  private View nbZ;
  private boolean ncc;
  private long nce;
  private View.OnTouchListener ncf;
  private k vSz;
  
  public WebSearchVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(28229);
    this.ncc = false;
    this.asI = new WebSearchVoiceInputLayoutImpl.1(this);
    this.ncf = new WebSearchVoiceInputLayoutImpl.2(this);
    init(paramContext);
    AppMethodBeat.o(28229);
  }
  
  public WebSearchVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28228);
    this.ncc = false;
    this.asI = new WebSearchVoiceInputLayoutImpl.1(this);
    this.ncf = new WebSearchVoiceInputLayoutImpl.2(this);
    init(paramContext);
    AppMethodBeat.o(28228);
  }
  
  private void bDA()
  {
    AppMethodBeat.i(28232);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28223);
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).dnp();
        AppMethodBeat.o(28223);
      }
    });
    bDI();
    AppMethodBeat.o(28232);
  }
  
  private static boolean bDC()
  {
    AppMethodBeat.i(28233);
    int i = aw.Rc().adt();
    if ((i == 4) || (i == 6))
    {
      AppMethodBeat.o(28233);
      return true;
    }
    AppMethodBeat.o(28233);
    return false;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(28230);
    this.nbZ = inflate(paramContext, 2130971088, this).findViewById(2131824403);
    this.nbZ.setLayerType(1, null);
    this.vSz = new k(paramContext);
    this.nbZ.setBackground(this.vSz);
    this.nbZ.setEnabled(true);
    this.nbZ.setOnTouchListener(this.ncf);
    this.nbZ.setOnLongClickListener(this.asI);
    reset(true);
    if (isInEditMode())
    {
      AppMethodBeat.o(28230);
      return;
    }
    if (!bDC()) {
      bDA();
    }
    AppMethodBeat.o(28230);
  }
  
  private static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(28238);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      al.d(paramRunnable);
      AppMethodBeat.o(28238);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(28238);
  }
  
  public final void B(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(28231);
    ab.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.currentState), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.currentState == 1)
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        if (!bDC())
        {
          bDA();
          AppMethodBeat.o(28231);
          return;
        }
        bDF();
        AppMethodBeat.o(28231);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        this.vSz.bDo();
        AppMethodBeat.o(28231);
      }
    }
    else if (this.currentState == 2)
    {
      if (!paramBoolean2)
      {
        bDG();
        AppMethodBeat.o(28231);
        return;
      }
      this.vSz.bDo();
      amT();
      if (this.vSx != null)
      {
        this.vSx.bDz();
        AppMethodBeat.o(28231);
      }
    }
    else
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        amT();
        AppMethodBeat.o(28231);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2)) {
        this.vSz.bDo();
      }
    }
    AppMethodBeat.o(28231);
  }
  
  public final void bDD()
  {
    AppMethodBeat.i(28234);
    runOnUiThread(new WebSearchVoiceInputLayoutImpl.4(this));
    AppMethodBeat.o(28234);
  }
  
  public final void ef(boolean paramBoolean)
  {
    AppMethodBeat.i(28235);
    runOnUiThread(new WebSearchVoiceInputLayoutImpl.5(this));
    AppMethodBeat.o(28235);
  }
  
  public final void onReset()
  {
    AppMethodBeat.i(28236);
    runOnUiThread(new WebSearchVoiceInputLayoutImpl.6(this));
    AppMethodBeat.o(28236);
  }
  
  public final void wF(int paramInt)
  {
    AppMethodBeat.i(28237);
    runOnUiThread(new WebSearchVoiceInputLayoutImpl.7(this, paramInt));
    AppMethodBeat.o(28237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl
 * JD-Core Version:    0.7.0.1
 */