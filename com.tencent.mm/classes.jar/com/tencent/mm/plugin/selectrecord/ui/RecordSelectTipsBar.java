package com.tencent.mm.plugin.selectrecord.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.selectrecord.b.a;
import com.tencent.mm.plugin.selectrecord.b.b;
import com.tencent.mm.plugin.selectrecord.b.c;
import com.tencent.mm.plugin.selectrecord.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public class RecordSelectTipsBar
  extends LinearLayout
{
  private LinearLayout PmO;
  private TextView PmP;
  private LinearLayout PmQ;
  private TextView PmR;
  private TextView PmS;
  private TextView PmT;
  private boolean PmU;
  private a PmV;
  private FrameLayout mfE;
  
  public RecordSelectTipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(266679);
    this.PmU = false;
    this.PmV = null;
    initView();
    AppMethodBeat.o(266679);
  }
  
  public RecordSelectTipsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(266685);
    this.PmU = false;
    this.PmV = null;
    initView();
    AppMethodBeat.o(266685);
  }
  
  private void initView()
  {
    AppMethodBeat.i(266691);
    View localView = inflate(getContext(), b.c.record_select_header_bar, this);
    this.mfE = ((FrameLayout)localView.findViewById(b.b.root_ll));
    this.PmO = ((LinearLayout)localView.findViewById(b.b.header_root));
    this.PmP = ((TextView)localView.findViewById(b.b.introduce_content));
    this.PmQ = ((LinearLayout)localView.findViewById(b.b.statistics_content));
    this.PmR = ((TextView)localView.findViewById(b.b.record_select_content_statistic));
    this.PmS = ((TextView)localView.findViewById(b.b.max_limit_tip_content));
    this.PmT = ((TextView)localView.findViewById(b.b.record_select_clear_content));
    this.PmT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(266700);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/selectrecord/ui/RecordSelectTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.recordSelect.RecordSelectTipsBar", "clear all select record");
        if (RecordSelectTipsBar.a(RecordSelectTipsBar.this) != null)
        {
          paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.gUF();
          paramAnonymousView.Pmm += 1;
          RecordSelectTipsBar.a(RecordSelectTipsBar.this).gUN();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/selectrecord/ui/RecordSelectTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(266700);
      }
    });
    AppMethodBeat.o(266691);
  }
  
  public final void aiP(final int paramInt)
  {
    AppMethodBeat.i(266745);
    h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(266697);
        RecordSelectTipsBar.b(RecordSelectTipsBar.this).setVisibility(8);
        RecordSelectTipsBar.c(RecordSelectTipsBar.this).setVisibility(0);
        RecordSelectTipsBar.e(RecordSelectTipsBar.this).setText(MMApplicationContext.getContext().getString(b.d.select_record_bar_msg_tips, new Object[] { Integer.toString(paramInt) }));
        if (paramInt > 0)
        {
          RecordSelectTipsBar.f(RecordSelectTipsBar.this).setTextColor(MMApplicationContext.getContext().getResources().getColor(b.a.chat_to_link));
          if (paramInt < 99) {
            break label179;
          }
          RecordSelectTipsBar.d(RecordSelectTipsBar.this).setVisibility(0);
          RecordSelectTipsBar.a(RecordSelectTipsBar.this, true);
        }
        for (;;)
        {
          if (RecordSelectTipsBar.a(RecordSelectTipsBar.this) != null) {
            RecordSelectTipsBar.a(RecordSelectTipsBar.this).CD(RecordSelectTipsBar.g(RecordSelectTipsBar.this));
          }
          AppMethodBeat.o(266697);
          return;
          RecordSelectTipsBar.f(RecordSelectTipsBar.this).setTextColor(MMApplicationContext.getContext().getResources().getColor(b.a.hint_text_color));
          break;
          label179:
          RecordSelectTipsBar.d(RecordSelectTipsBar.this).setVisibility(8);
          RecordSelectTipsBar.a(RecordSelectTipsBar.this, false);
        }
      }
    });
    AppMethodBeat.o(266745);
  }
  
  public void setIRecordSelectCallback(a parama)
  {
    this.PmV = parama;
  }
  
  public static abstract interface a
  {
    public abstract void CD(boolean paramBoolean);
    
    public abstract void gUN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar
 * JD-Core Version:    0.7.0.1
 */