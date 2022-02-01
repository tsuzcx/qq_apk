package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.b.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public class LiveBizSessionTipsBar
  extends LinearLayout
{
  private RelativeLayout VYu;
  private com.tencent.mm.ui.chatting.e.a VYv;
  public Context context;
  public String fvZ;
  private TextView jMg;
  
  public LiveBizSessionTipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(270515);
    this.fvZ = null;
    this.context = paramContext;
    initView();
    AppMethodBeat.o(270515);
  }
  
  @TargetApi(11)
  public LiveBizSessionTipsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(270514);
    this.fvZ = null;
    this.context = paramContext;
    initView();
    AppMethodBeat.o(270514);
  }
  
  private void initView()
  {
    AppMethodBeat.i(270518);
    inflate(getContext(), R.i.live_biz_session_tipsbar, this);
    this.VYu = ((RelativeLayout)findViewById(R.h.biz_live_tipsbar_layout));
    this.jMg = ((TextView)findViewById(R.h.biz_live_tipsbar_title));
    this.jMg.setText(MMApplicationContext.getContext().getString(R.l.biz_time_line_finder_live_title));
    AppMethodBeat.o(270518);
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(270516);
    this.VYv = parama;
    this.fvZ = parama.getTalkerUserName();
    final int i = this.VYv.WQv.getIntExtra("specific_chat_from_scene", 0);
    parama = com.tencent.mm.pluginsdk.model.b.QTJ;
    parama = com.tencent.mm.pluginsdk.model.b.bpq(this.fvZ);
    com.tencent.mm.pluginsdk.model.b localb = com.tencent.mm.pluginsdk.model.b.QTJ;
    int j = com.tencent.mm.pluginsdk.model.b.bpr(this.fvZ);
    int k = ab.getSessionId();
    h.IzE.a(23044, new Object[] { Integer.valueOf(1), this.fvZ, Integer.valueOf(i), Integer.valueOf(k), parama, Integer.valueOf(j), Integer.valueOf(0), "" });
    this.VYu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(276799);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LiveBizSessionTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = com.tencent.mm.pluginsdk.model.b.QTJ;
        paramAnonymousView = com.tencent.mm.pluginsdk.model.b.bpq(LiveBizSessionTipsBar.this.fvZ);
        localObject = com.tencent.mm.pluginsdk.model.b.QTJ;
        int i = com.tencent.mm.pluginsdk.model.b.bpr(LiveBizSessionTipsBar.this.fvZ);
        int j = ab.getSessionId();
        h.IzE.a(23044, new Object[] { Integer.valueOf(2), LiveBizSessionTipsBar.this.fvZ, Integer.valueOf(i), Integer.valueOf(j), paramAnonymousView, Integer.valueOf(i), Integer.valueOf(0), "" });
        localObject = b.b.QUa;
        j = b.b.hgC();
        com.tencent.mm.pluginsdk.model.b.QTJ.b(LiveBizSessionTipsBar.a(LiveBizSessionTipsBar.this).WQv.getContext(), LiveBizSessionTipsBar.this.fvZ, paramAnonymousView, j, i);
        paramAnonymousView = com.tencent.mm.pluginsdk.model.b.QTJ;
        com.tencent.mm.pluginsdk.model.b.a(LiveBizSessionTipsBar.this.fvZ, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveBizSessionTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(276799);
      }
    });
    AppMethodBeat.o(270516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.LiveBizSessionTipsBar
 * JD-Core Version:    0.7.0.1
 */