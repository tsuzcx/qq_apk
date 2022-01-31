package com.tencent.mm.pluginsdk.ui.websearch;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

@TargetApi(16)
public class WebSearchVoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private View.OnLongClickListener aqp = new WebSearchVoiceInputLayoutImpl.1(this);
  private View kFk;
  private boolean kFn = false;
  private long kFo;
  private View.OnTouchListener kFq = new WebSearchVoiceInputLayoutImpl.2(this);
  private l sbs;
  
  public WebSearchVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public WebSearchVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void cmE()
  {
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).cmz();
      }
    });
    cmD();
  }
  
  private static boolean cmF()
  {
    int i = au.Dk().KG();
    return (i == 4) || (i == 6);
  }
  
  private void init(Context paramContext)
  {
    this.kFk = inflate(paramContext, R.i.voice_input_layout, this).findViewById(R.h.voice_search_start_btn);
    this.kFk.setLayerType(1, null);
    this.sbs = new l(paramContext);
    this.kFk.setBackground(this.sbs);
    this.kFk.setEnabled(true);
    this.kFk.setOnTouchListener(this.kFq);
    this.kFk.setOnLongClickListener(this.aqp);
    reset(true);
    if (isInEditMode()) {}
    while (cmF()) {
      return;
    }
    cmE();
  }
  
  private static void runOnUiThread(Runnable paramRunnable)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      ai.d(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  protected final void aWS()
  {
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        WebSearchVoiceInputLayoutImpl.b(WebSearchVoiceInputLayoutImpl.this).lQ(this.kFt);
      }
    });
  }
  
  protected final void db(boolean paramBoolean)
  {
    runOnUiThread(new WebSearchVoiceInputLayoutImpl.5(this));
  }
  
  protected final void onReset()
  {
    runOnUiThread(new WebSearchVoiceInputLayoutImpl.6(this));
  }
  
  protected final void rH(int paramInt)
  {
    runOnUiThread(new WebSearchVoiceInputLayoutImpl.7(this, paramInt));
  }
  
  public final void y(boolean paramBoolean1, boolean paramBoolean2)
  {
    y.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.kFU), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.kFU == 1) {
      if ((!paramBoolean1) && (!paramBoolean2)) {
        if (!cmF()) {
          cmE();
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          aWV();
          return;
        } while ((!paramBoolean1) || (paramBoolean2));
        this.sbs.aWU();
        return;
        if (this.kFU != 2) {
          break;
        }
        if (!paramBoolean2)
        {
          aWW();
          return;
        }
        this.sbs.aWU();
        TG();
      } while (this.sbq == null);
      this.sbq.aWR();
      return;
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        TG();
        return;
      }
    } while ((!paramBoolean1) || (paramBoolean2));
    this.sbs.aWU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl
 * JD-Core Version:    0.7.0.1
 */