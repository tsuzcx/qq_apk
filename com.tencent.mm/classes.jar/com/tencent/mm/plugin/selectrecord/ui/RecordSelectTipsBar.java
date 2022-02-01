package com.tencent.mm.plugin.selectrecord.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.selectrecord.b.a;
import com.tencent.mm.plugin.selectrecord.b.b;
import com.tencent.mm.plugin.selectrecord.b.c;
import com.tencent.mm.plugin.selectrecord.b.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class RecordSelectTipsBar
  extends LinearLayout
{
  private LinearLayout JcR;
  private TextView JcS;
  private LinearLayout JcT;
  private TextView JcU;
  private TextView JcV;
  private TextView JcW;
  private boolean JcX;
  private RecordSelectTipsBar.a JcY;
  private FrameLayout jFQ;
  
  public RecordSelectTipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(255283);
    this.JcX = false;
    this.JcY = null;
    initView();
    AppMethodBeat.o(255283);
  }
  
  public RecordSelectTipsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(255284);
    this.JcX = false;
    this.JcY = null;
    initView();
    AppMethodBeat.o(255284);
  }
  
  private void initView()
  {
    AppMethodBeat.i(255285);
    View localView = inflate(getContext(), b.c.record_select_header_bar, this);
    this.jFQ = ((FrameLayout)localView.findViewById(b.b.root_ll));
    this.JcR = ((LinearLayout)localView.findViewById(b.b.header_root));
    this.JcS = ((TextView)localView.findViewById(b.b.introduce_content));
    this.JcT = ((LinearLayout)localView.findViewById(b.b.statistics_content));
    this.JcU = ((TextView)localView.findViewById(b.b.record_select_content_statistic));
    this.JcV = ((TextView)localView.findViewById(b.b.max_limit_tip_content));
    this.JcW = ((TextView)localView.findViewById(b.b.record_select_clear_content));
    this.JcW.setOnClickListener(new RecordSelectTipsBar.1(this));
    AppMethodBeat.o(255285);
  }
  
  public final void aek(final int paramInt)
  {
    AppMethodBeat.i(255286);
    h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(255150);
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
            RecordSelectTipsBar.a(RecordSelectTipsBar.this).xM(RecordSelectTipsBar.g(RecordSelectTipsBar.this));
          }
          AppMethodBeat.o(255150);
          return;
          RecordSelectTipsBar.f(RecordSelectTipsBar.this).setTextColor(MMApplicationContext.getContext().getResources().getColor(b.a.hint_text_color));
          break;
          label179:
          RecordSelectTipsBar.d(RecordSelectTipsBar.this).setVisibility(8);
          RecordSelectTipsBar.a(RecordSelectTipsBar.this, false);
        }
      }
    });
    AppMethodBeat.o(255286);
  }
  
  public void setIRecordSelectCallback(RecordSelectTipsBar.a parama)
  {
    this.JcY = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.ui.RecordSelectTipsBar
 * JD-Core Version:    0.7.0.1
 */