package com.tencent.mm.ui;

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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public class LiveBizSessionTipsBar
  extends LinearLayout
{
  private RelativeLayout adCP;
  private com.tencent.mm.ui.chatting.d.a adCQ;
  public Context context;
  public String hAw;
  private TextView mll;
  
  public LiveBizSessionTipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(250422);
    this.hAw = null;
    this.context = paramContext;
    initView();
    AppMethodBeat.o(250422);
  }
  
  public LiveBizSessionTipsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(250415);
    this.hAw = null;
    this.context = paramContext;
    initView();
    AppMethodBeat.o(250415);
  }
  
  private void initView()
  {
    AppMethodBeat.i(250428);
    inflate(getContext(), R.i.live_biz_session_tipsbar, this);
    this.adCP = ((RelativeLayout)findViewById(R.h.biz_live_tipsbar_layout));
    this.mll = ((TextView)findViewById(R.h.biz_live_tipsbar_title));
    this.mll.setText(MMApplicationContext.getContext().getString(R.l.biz_time_line_finder_live_title));
    AppMethodBeat.o(250428);
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(250444);
    this.adCQ = parama;
    this.hAw = parama.getTalkerUserName();
    final int i = this.adCQ.aezO.getIntExtra("specific_chat_from_scene", 0);
    parama = c.XPt;
    parama = c.bpi(this.hAw);
    c localc = c.XPt;
    int j = c.bpj(this.hAw);
    int k = ad.getSessionId();
    h.OAn.b(23044, new Object[] { Integer.valueOf(1), this.hAw, Integer.valueOf(i), Integer.valueOf(k), parama, Integer.valueOf(j), Integer.valueOf(0), "" });
    this.adCP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(249046);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/LiveBizSessionTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        if (LiveBizSessionTipsBar.a(LiveBizSessionTipsBar.this) != null) {
          LiveBizSessionTipsBar.this.hAw = LiveBizSessionTipsBar.a(LiveBizSessionTipsBar.this).getTalkerUserName();
        }
        paramAnonymousView = c.XPt;
        paramAnonymousView = c.bpi(LiveBizSessionTipsBar.this.hAw);
        localObject = c.XPt;
        int i = c.bpj(LiveBizSessionTipsBar.this.hAw);
        int j = ad.getSessionId();
        h.OAn.b(23044, new Object[] { Integer.valueOf(2), LiveBizSessionTipsBar.this.hAw, Integer.valueOf(i), Integer.valueOf(j), paramAnonymousView, Integer.valueOf(i), Integer.valueOf(0), "" });
        c.XPt.a(LiveBizSessionTipsBar.a(LiveBizSessionTipsBar.this).aezO.getContext(), LiveBizSessionTipsBar.this.hAw, paramAnonymousView, 4, i, null);
        paramAnonymousView = c.XPt;
        c.b(LiveBizSessionTipsBar.this.hAw, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveBizSessionTipsBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(249046);
      }
    });
    AppMethodBeat.o(250444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.LiveBizSessionTipsBar
 * JD-Core Version:    0.7.0.1
 */