package com.tencent.mm.plugin.selectrecord.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public class RecordSelectTipsBar
  extends LinearLayout
{
  private FrameLayout ttz;
  private TextView ySA;
  private boolean ySB;
  private a ySC;
  private LinearLayout ySv;
  private TextView ySw;
  private LinearLayout ySx;
  private TextView ySy;
  private TextView ySz;
  
  public RecordSelectTipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(194025);
    this.ySB = false;
    this.ySC = null;
    initView();
    AppMethodBeat.o(194025);
  }
  
  public RecordSelectTipsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194026);
    this.ySB = false;
    this.ySC = null;
    initView();
    AppMethodBeat.o(194026);
  }
  
  private void initView()
  {
    AppMethodBeat.i(194027);
    View localView = inflate(getContext(), 2131496486, this);
    this.ttz = ((FrameLayout)localView.findViewById(2131307946));
    this.ySv = ((LinearLayout)localView.findViewById(2131308325));
    this.ySw = ((TextView)localView.findViewById(2131308332));
    this.ySx = ((LinearLayout)localView.findViewById(2131308433));
    this.ySy = ((TextView)localView.findViewById(2131308395));
    this.ySz = ((TextView)localView.findViewById(2131308353));
    this.ySA = ((TextView)localView.findViewById(2131308394));
    this.ySA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(194022);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/selectrecord/ui/RecordSelectTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.recordSelect.RecordSelectTipsBar", "clear all select record");
        if (RecordSelectTipsBar.a(RecordSelectTipsBar.this) != null)
        {
          paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.dQt();
          paramAnonymousView.ySb += 1;
          RecordSelectTipsBar.a(RecordSelectTipsBar.this).dQB();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/selectrecord/ui/RecordSelectTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(194022);
      }
    });
    AppMethodBeat.o(194027);
  }
  
  public final void PH(final int paramInt)
  {
    AppMethodBeat.i(194028);
    h.MqF.aM(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194024);
        RecordSelectTipsBar.b(RecordSelectTipsBar.this).setVisibility(8);
        RecordSelectTipsBar.c(RecordSelectTipsBar.this).setVisibility(0);
        RecordSelectTipsBar.e(RecordSelectTipsBar.this).setText(ak.getContext().getString(2131767154, new Object[] { Integer.toString(paramInt) }));
        if (paramInt > 0)
        {
          RecordSelectTipsBar.f(RecordSelectTipsBar.this).setTextColor(ak.getContext().getResources().getColor(2131100134));
          if (paramInt < 99) {
            break label176;
          }
          RecordSelectTipsBar.d(RecordSelectTipsBar.this).setVisibility(0);
          RecordSelectTipsBar.a(RecordSelectTipsBar.this, true);
        }
        for (;;)
        {
          if (RecordSelectTipsBar.a(RecordSelectTipsBar.this) != null) {
            RecordSelectTipsBar.a(RecordSelectTipsBar.this).qT(RecordSelectTipsBar.g(RecordSelectTipsBar.this));
          }
          AppMethodBeat.o(194024);
          return;
          RecordSelectTipsBar.f(RecordSelectTipsBar.this).setTextColor(ak.getContext().getResources().getColor(2131100490));
          break;
          label176:
          RecordSelectTipsBar.d(RecordSelectTipsBar.this).setVisibility(8);
          RecordSelectTipsBar.a(RecordSelectTipsBar.this, false);
        }
      }
    });
    AppMethodBeat.o(194028);
  }
  
  public void setIRecordSelectCallback(a parama)
  {
    this.ySC = parama;
  }
  
  public static abstract interface a
  {
    public abstract void dQB();
    
    public abstract void qT(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar
 * JD-Core Version:    0.7.0.1
 */