package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class p
  extends j
{
  private l JKN;
  public NoteVoiceView JLj;
  private LinearLayout kmg;
  public LinearLayout qOU;
  public LinearLayout qOV;
  public ImageView qOX;
  private TextView qOY;
  private TextView qOZ;
  private final MMHandler qPb;
  
  public p(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30887);
    this.qPb = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(30886);
        if (p.a(p.this).qPO)
        {
          p.b(p.this).removeMessages(4096);
          AppMethodBeat.o(30886);
          return;
        }
        paramAnonymousMessage = " " + com.tencent.mm.bl.a.J(MMApplicationContext.getContext(), p.a(p.this).qPQ).toString();
        p.c(p.this).setText(paramAnonymousMessage);
        sendEmptyMessageDelayed(4096, 500L);
        AppMethodBeat.o(30886);
      }
    };
    this.kmg = ((LinearLayout)paramView.findViewById(2131305530));
    this.qOU = ((LinearLayout)paramView.findViewById(2131305532));
    this.qOV = ((LinearLayout)paramView.findViewById(2131305531));
    this.qOX = ((ImageView)paramView.findViewById(2131305533));
    this.qOY = ((TextView)paramView.findViewById(2131305535));
    this.qOZ = ((TextView)paramView.findViewById(2131305536));
    this.JLj = ((NoteVoiceView)paramView.findViewById(2131305512));
    this.JLj.setVoiceHelper(com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.gkl());
    this.kmg.setVisibility(0);
    this.qOU.setVisibility(8);
    this.qOV.setVisibility(0);
    this.dKU.setVisibility(8);
    this.qOs.setVisibility(8);
    this.kmg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30885);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((p.a(p.this) != null) && (p.a(p.this).qPX.booleanValue())) {
          p.a(p.this).qPY = Boolean.TRUE;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteVoiceItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30885);
      }
    });
    AppMethodBeat.o(30887);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30888);
    this.JKN = ((l)paramc);
    if (this.JKN.qPO)
    {
      this.kmg.setBackgroundResource(0);
      this.qOV.setVisibility(0);
      this.qOU.setVisibility(8);
      this.kmg.setPadding(0, 0, 0, 0);
      if (!paramc.qPH) {
        break label591;
      }
    }
    label306:
    label319:
    label591:
    for (int i = 1;; i = 0)
    {
      Object localObject1 = this.JLj;
      Object localObject2 = this.JKN.dUs;
      int j = this.JKN.dLt;
      int k = this.JKN.dLu;
      ((NoteVoiceView)localObject1).path = Util.nullAs((String)localObject2, "");
      ((NoteVoiceView)localObject1).dLt = j;
      ((NoteVoiceView)localObject1).duration = k;
      if (i != 0)
      {
        ((NoteVoiceView)localObject1).maskView.setVisibility(0);
        if (!((NoteVoiceView)localObject1).path.equals(((NoteVoiceView)localObject1).JLo.path)) {
          break label319;
        }
        if (!((NoteVoiceView)localObject1).JLo.cEF()) {
          break label229;
        }
        Log.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
        localObject2 = ((NoteVoiceView)localObject1).JLp;
        ((NoteVoiceView)localObject1).JLo.ZY();
        ((NoteVoiceView.a)localObject2).lp(true);
      }
      for (;;)
      {
        super.a(paramc, paramInt1, paramInt2);
        AppMethodBeat.o(30888);
        return;
        ((NoteVoiceView)localObject1).maskView.setVisibility(8);
        break;
        label229:
        localObject2 = ((NoteVoiceView)localObject1).JLo;
        if (((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject2).qUl == null) {
          Log.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
        }
        for (boolean bool = false;; bool = ((com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a)localObject2).qUl.YY())
        {
          if (!bool) {
            break label306;
          }
          Log.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
          localObject2 = ((NoteVoiceView)localObject1).JLp;
          ((NoteVoiceView)localObject1).JLo.ZY();
          ((NoteVoiceView.a)localObject2).lp(false);
          break;
        }
        ((NoteVoiceView)localObject1).JLp.FD(k);
        continue;
        ((NoteVoiceView)localObject1).JLp.FD(k);
        continue;
        this.kmg.setBackgroundResource(2131235760);
        this.kmg.setPadding(26, 7, 0, 7);
        this.qOV.setVisibility(8);
        this.qOU.setVisibility(0);
        localObject1 = this.qOX;
        if (((ImageView)localObject1).getAnimation() != null) {
          ((ImageView)localObject1).startAnimation(((ImageView)localObject1).getAnimation());
        }
        for (;;)
        {
          if (!this.JKN.qPX.booleanValue()) {
            break label529;
          }
          this.qPb.sendEmptyMessage(4096);
          this.qOY.setText(2131759365);
          localObject1 = " " + com.tencent.mm.bl.a.J(MMApplicationContext.getContext(), this.JKN.qPQ).toString();
          this.qOZ.setText((CharSequence)localObject1);
          break;
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((Animation)localObject2).setDuration(500L);
          ((Animation)localObject2).setInterpolator(new LinearInterpolator());
          ((Animation)localObject2).setRepeatCount(-1);
          ((Animation)localObject2).setRepeatMode(2);
          ((ImageView)localObject1).startAnimation((Animation)localObject2);
        }
        this.qOY.setText(2131759364);
        localObject1 = " " + com.tencent.mm.bl.a.J(MMApplicationContext.getContext(), (int)com.tencent.mm.bl.a.AO(this.JKN.dLu)).toString();
        this.qOZ.setText((CharSequence)localObject1);
      }
    }
  }
  
  public final int cCY()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.p
 * JD-Core Version:    0.7.0.1
 */