package com.tencent.mm.plugin.selectrecord.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class RecordSelectTipsBar
  extends LinearLayout
{
  private LinearLayout CXl;
  private TextView CXm;
  private LinearLayout CXn;
  private TextView CXo;
  private TextView CXp;
  private TextView CXq;
  private boolean CXr;
  private a CXs;
  private FrameLayout gUY;
  
  public RecordSelectTipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(187947);
    this.CXr = false;
    this.CXs = null;
    initView();
    AppMethodBeat.o(187947);
  }
  
  public RecordSelectTipsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(187948);
    this.CXr = false;
    this.CXs = null;
    initView();
    AppMethodBeat.o(187948);
  }
  
  private void initView()
  {
    AppMethodBeat.i(187949);
    View localView = inflate(getContext(), 2131496068, this);
    this.gUY = ((FrameLayout)localView.findViewById(2131307166));
    this.CXl = ((LinearLayout)localView.findViewById(2131302304));
    this.CXm = ((TextView)localView.findViewById(2131302699));
    this.CXn = ((LinearLayout)localView.findViewById(2131308388));
    this.CXo = ((TextView)localView.findViewById(2131306736));
    this.CXp = ((TextView)localView.findViewById(2131304541));
    this.CXq = ((TextView)localView.findViewById(2131306735));
    this.CXq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187944);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/selectrecord/ui/RecordSelectTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.recordSelect.RecordSelectTipsBar", "clear all select record");
        if (RecordSelectTipsBar.a(RecordSelectTipsBar.this) != null)
        {
          paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.eSu();
          paramAnonymousView.CWR += 1;
          RecordSelectTipsBar.a(RecordSelectTipsBar.this).eSC();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/selectrecord/ui/RecordSelectTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187944);
      }
    });
    AppMethodBeat.o(187949);
  }
  
  public final void Xl(final int paramInt)
  {
    AppMethodBeat.i(187950);
    h.RTc.aV(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187946);
        RecordSelectTipsBar.b(RecordSelectTipsBar.this).setVisibility(8);
        RecordSelectTipsBar.c(RecordSelectTipsBar.this).setVisibility(0);
        RecordSelectTipsBar.e(RecordSelectTipsBar.this).setText(MMApplicationContext.getContext().getString(2131765155, new Object[] { Integer.toString(paramInt) }));
        if (paramInt > 0)
        {
          RecordSelectTipsBar.f(RecordSelectTipsBar.this).setTextColor(MMApplicationContext.getContext().getResources().getColor(2131100166));
          if (paramInt < 99) {
            break label176;
          }
          RecordSelectTipsBar.d(RecordSelectTipsBar.this).setVisibility(0);
          RecordSelectTipsBar.a(RecordSelectTipsBar.this, true);
        }
        for (;;)
        {
          if (RecordSelectTipsBar.a(RecordSelectTipsBar.this) != null) {
            RecordSelectTipsBar.a(RecordSelectTipsBar.this).uo(RecordSelectTipsBar.g(RecordSelectTipsBar.this));
          }
          AppMethodBeat.o(187946);
          return;
          RecordSelectTipsBar.f(RecordSelectTipsBar.this).setTextColor(MMApplicationContext.getContext().getResources().getColor(2131100594));
          break;
          label176:
          RecordSelectTipsBar.d(RecordSelectTipsBar.this).setVisibility(8);
          RecordSelectTipsBar.a(RecordSelectTipsBar.this, false);
        }
      }
    });
    AppMethodBeat.o(187950);
  }
  
  public void setIRecordSelectCallback(a parama)
  {
    this.CXs = parama;
  }
  
  public static abstract interface a
  {
    public abstract void eSC();
    
    public abstract void uo(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar
 * JD-Core Version:    0.7.0.1
 */