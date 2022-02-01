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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public class RecordSelectTipsBar
  extends LinearLayout
{
  private FrameLayout tiH;
  private LinearLayout yCs;
  private TextView yCt;
  private LinearLayout yCu;
  private TextView yCv;
  private TextView yCw;
  private TextView yCx;
  private boolean yCy;
  private a yCz;
  
  public RecordSelectTipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(207418);
    this.yCy = false;
    this.yCz = null;
    initView();
    AppMethodBeat.o(207418);
  }
  
  public RecordSelectTipsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(207419);
    this.yCy = false;
    this.yCz = null;
    initView();
    AppMethodBeat.o(207419);
  }
  
  private void initView()
  {
    AppMethodBeat.i(207420);
    View localView = inflate(getContext(), 2131496486, this);
    this.tiH = ((FrameLayout)localView.findViewById(2131307946));
    this.yCs = ((LinearLayout)localView.findViewById(2131308325));
    this.yCt = ((TextView)localView.findViewById(2131308332));
    this.yCu = ((LinearLayout)localView.findViewById(2131308433));
    this.yCv = ((TextView)localView.findViewById(2131308395));
    this.yCw = ((TextView)localView.findViewById(2131308353));
    this.yCx = ((TextView)localView.findViewById(2131308394));
    this.yCx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207415);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/selectrecord/ui/RecordSelectTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.recordSelect.RecordSelectTipsBar", "clear all select record");
        if (RecordSelectTipsBar.a(RecordSelectTipsBar.this) != null)
        {
          paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.dNa();
          paramAnonymousView.yCa += 1;
          RecordSelectTipsBar.a(RecordSelectTipsBar.this).dNf();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/selectrecord/ui/RecordSelectTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(207415);
      }
    });
    AppMethodBeat.o(207420);
  }
  
  public final void OZ(final int paramInt)
  {
    AppMethodBeat.i(207421);
    h.LTJ.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207417);
        RecordSelectTipsBar.b(RecordSelectTipsBar.this).setVisibility(8);
        RecordSelectTipsBar.c(RecordSelectTipsBar.this).setVisibility(0);
        RecordSelectTipsBar.e(RecordSelectTipsBar.this).setText(aj.getContext().getString(2131767154, new Object[] { Integer.toString(paramInt) }));
        if (paramInt > 0)
        {
          RecordSelectTipsBar.f(RecordSelectTipsBar.this).setTextColor(aj.getContext().getResources().getColor(2131100134));
          if (paramInt < 99) {
            break label176;
          }
          RecordSelectTipsBar.d(RecordSelectTipsBar.this).setVisibility(0);
          RecordSelectTipsBar.a(RecordSelectTipsBar.this, true);
        }
        for (;;)
        {
          if (RecordSelectTipsBar.a(RecordSelectTipsBar.this) != null) {
            RecordSelectTipsBar.a(RecordSelectTipsBar.this).qM(RecordSelectTipsBar.g(RecordSelectTipsBar.this));
          }
          AppMethodBeat.o(207417);
          return;
          RecordSelectTipsBar.f(RecordSelectTipsBar.this).setTextColor(aj.getContext().getResources().getColor(2131100490));
          break;
          label176:
          RecordSelectTipsBar.d(RecordSelectTipsBar.this).setVisibility(8);
          RecordSelectTipsBar.a(RecordSelectTipsBar.this, false);
        }
      }
    });
    AppMethodBeat.o(207421);
  }
  
  public void setIRecordSelectCallback(a parama)
  {
    this.yCz = parama;
  }
  
  public static abstract interface a
  {
    public abstract void dNf();
    
    public abstract void qM(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar
 * JD-Core Version:    0.7.0.1
 */