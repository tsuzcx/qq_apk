package com.tencent.mm.pluginsdk.ui.chat;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.plugin.transvoice.a.a.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.blur.BlurView;

final class ChatFooter$11
  implements View.OnTouchListener
{
  ChatFooter$11(ChatFooter paramChatFooter) {}
  
  public final boolean onTouch(View arg1, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(155418);
    if (??? != ChatFooter.u(this.vXU))
    {
      AppMethodBeat.o(155418);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      AppMethodBeat.o(155418);
      return false;
    case 0: 
      ab.i("RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", new Object[] { Integer.valueOf(ChatFooter.doO()) });
      ??? = com.tencent.mm.cj.a.yTb;
      com.tencent.mm.cj.a.pX(false);
      ChatFooter.v(this.vXU).iWt = System.currentTimeMillis();
      ChatFooter.v(this.vXU).tpl = ((int)paramMotionEvent.getRawX());
      ChatFooter.v(this.vXU).tpm = ((int)paramMotionEvent.getRawY());
      ??? = this.vXU;
      if (-1 != com.tencent.mm.plugin.transvoice.ui.b.tqA) {
        if (1 == com.tencent.mm.plugin.transvoice.ui.b.tqA)
        {
          bool = true;
          label160:
          ???.vWr = bool;
          label166:
          if ((ChatFooter.w(this.vXU)) && (ChatFooter.x(this.vXU) != null))
          {
            ChatFooter.y(this.vXU);
            if (ChatFooter.z(this.vXU) != null) {
              ChatFooter.z(this.vXU).getBlurController().destroy();
            }
            if (ChatFooter.A(this.vXU) != null) {
              ChatFooter.A(this.vXU).getBlurController().destroy();
            }
          }
          ab.i("RcdBtnEvent", "trans voice opener: %s, blur mode opener: %s.", new Object[] { Boolean.valueOf(ChatFooter.B(this.vXU)), ChatFooter.C(this.vXU) });
          if (!ChatFooter.B(this.vXU)) {
            break label721;
          }
          ChatFooter.v(this.vXU).tpy = 1;
          ChatFooter.a(this.vXU, null);
          long l = System.nanoTime();
          ??? = ChatFooter.D(this.vXU);
          ???.tph = new h(String.valueOf(l & 0xFFFFFFFF));
          ???.gbw = new com.tencent.mm.audio.e.c(16000, 23900);
          if (!???.gbw.eN(com.tencent.mm.plugin.transvoice.a.a.cKW()))
          {
            ab.e("MicroMsg.CutShortSentence", "init speex writer failed");
            ???.gbw.Fb();
            ???.gbw = null;
            com.tencent.mm.plugin.transvoice.a.a.error(1);
          }
        }
      }
      break;
    }
    label2326:
    for (;;)
    {
      for (;;)
      {
        int i;
        try
        {
          ???.gbF = new com.tencent.mm.modelvoiceaddr.a.c(false, false);
          ???.gbF.gcn = ???.gbG;
          com.tencent.mm.sdk.b.a.ymk.c(???.tpg);
          if ((this.vXU.getContext() instanceof Activity)) {
            ((Activity)this.vXU.getContext()).getWindow().addFlags(128);
          }
          if ((ChatFooter.E(this.vXU)) || (ChatFooter.F(this.vXU))) {
            break;
          }
          ChatFooter.c(this.vXU, true);
          ChatFooter.u(this.vXU).setBackgroundDrawable(com.tencent.mm.cb.a.k(this.vXU.getContext(), 2130840130));
          ChatFooter.u(this.vXU).setText(2131298128);
          if (ChatFooter.i(this.vXU) != null) {
            ChatFooter.i(this.vXU).bPi();
          }
          ChatFooter.u(this.vXU).setContentDescription(this.vXU.getContext().getString(2131298103));
          break;
          bool = false;
          break label160;
          if (af.dDl())
          {
            bool = false;
            ???.vWr = bool;
            break label166;
          }
          if (ah.getContext().getResources().getConfiguration().orientation == 2)
          {
            i = 1;
            if (i == 0) {}
          }
          else
          {
            i = 0;
            continue;
          }
          paramMotionEvent = aa.gP(ah.getContext());
          if ((!paramMotionEvent.equals("zh_CN")) && (!paramMotionEvent.equals("zh_HK")) && (!paramMotionEvent.equals("zh_TW")) && (!paramMotionEvent.equals("en"))) {
            continue;
          }
          if ((f.IS_FLAVOR_RED) || (f.DEBUG))
          {
            bool = true;
            continue;
          }
          if (1 != g.Nq().getInt("NewVoiceInputOpenSwitch", 0)) {
            break label2326;
          }
          bool = true;
          continue;
          label721:
          ChatFooter.v(this.vXU).tpy = 0;
        }
        catch (Throwable paramMotionEvent)
        {
          ab.printErrStackTrace("MicroMsg.CutShortSentence", paramMotionEvent, "init VoiceDetectAPI failed", new Object[0]);
          com.tencent.mm.plugin.transvoice.a.a.error(3);
          continue;
        }
        if ((ChatFooter.x(this.vXU) == null) || (!ChatFooter.x(this.vXU).isShowing()))
        {
          if (ChatFooter.x(this.vXU) == null) {}
          for (;;)
          {
            ab.e("MicroMsg.ChatFooter", "hint window status err, window is null: %s.", new Object[] { Boolean.valueOf(bool) });
            break;
            bool = false;
          }
        }
        ab.d("RcdBtnEvent", "ACTION_MOVE, enableTrans2Txt: %s.", new Object[] { Boolean.valueOf(ChatFooter.B(this.vXU)) });
        if (ChatFooter.B(this.vXU))
        {
          if ((ChatFooter.G(this.vXU) == null) || (ChatFooter.H(this.vXU) == null)) {
            ab.e("RcdBtnEvent", "[arthurdan.initRcdBtn] Notice!!! voice2txtRealHintArea is %s, voice2txtOpeLayout is %s.", new Object[] { ChatFooter.G(this.vXU), ChatFooter.H(this.vXU) });
          }
          if ((paramMotionEvent.getX() > 0.0F) && (paramMotionEvent.getY() > -ChatFooter.I(this.vXU) / 3) && (paramMotionEvent.getX() < ChatFooter.u(this.vXU).getWidth()))
          {
            if (ChatFooter.J(this.vXU) == ChatFooter.i.vYt) {
              break;
            }
            ab.i("MicroMsg.ChatFooter", "active MODE_HINT_1.");
            ChatFooter.a(this.vXU, ChatFooter.i.vYt);
            if (!ChatFooter.K(this.vXU)) {
              break;
            }
            ChatFooter.L(this.vXU).animate().cancel();
            ChatFooter.M(this.vXU).animate().cancel();
            if (ChatFooter.g.vYl == ChatFooter.C(this.vXU))
            {
              ChatFooter.z(this.vXU).setAlpha(0.5F);
              ChatFooter.z(this.vXU).animate().alpha(1.0F).setDuration(300L).start();
              ChatFooter.z(this.vXU).Pd(this.vXU.getResources().getColor(2131690619)).x(ChatFooter.b(this.vXU).getWindow().getDecorView().getBackground()).qQ(true);
            }
            ChatFooter.s(this.vXU).getContentView().animate().alpha(0.0F).setDuration(200L).start();
            ChatFooter.N(this.vXU).setVisibility(0);
            ChatFooter.O(this.vXU).setVisibility(8);
            ChatFooter.H(this.vXU).setVisibility(8);
            ChatFooter.a(this.vXU, ChatFooter.h.vYo);
            ChatFooter.P(this.vXU);
            break;
          }
          if (ChatFooter.J(this.vXU) != ChatFooter.i.vYu)
          {
            ab.i("MicroMsg.ChatFooter", "active MODE_HINT_2.");
            ChatFooter.a(this.vXU, ChatFooter.i.vYu);
            if (!ChatFooter.K(this.vXU)) {
              ChatFooter.Q(this.vXU);
            }
            if (paramMotionEvent.getRawX() > ChatFooter.doP()) {
              ChatFooter.a(this.vXU, ChatFooter.h.vYp);
            }
            for (;;)
            {
              if (ChatFooter.g.vYl == ChatFooter.C(this.vXU)) {
                ChatFooter.z(this.vXU).Pd(0).x(null).qQ(false);
              }
              ChatFooter.s(this.vXU).getContentView().animate().alpha(1.0F).setDuration(200L).start();
              ChatFooter.N(this.vXU).setVisibility(8);
              ChatFooter.O(this.vXU).setVisibility(0);
              ChatFooter.H(this.vXU).setVisibility(0);
              ChatFooter.L(this.vXU).setVisibility(0);
              ChatFooter.M(this.vXU).setVisibility(0);
              ChatFooter.L(this.vXU).setAlpha(0.0F);
              ChatFooter.M(this.vXU).setAlpha(0.0F);
              ChatFooter.L(this.vXU).animate().translationX(ChatFooter.T(this.vXU)).translationY(ChatFooter.S(this.vXU)).scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(150L).withEndAction(ChatFooter.R(this.vXU)).start();
              ChatFooter.M(this.vXU).animate().translationX(ChatFooter.T(this.vXU)).translationY(ChatFooter.S(this.vXU)).scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(150L).start();
              break;
              ChatFooter.a(this.vXU, ChatFooter.h.vYq);
            }
          }
          if (!ChatFooter.U(this.vXU)) {
            break;
          }
          if ((paramMotionEvent.getRawX() > ChatFooter.doP()) && (ChatFooter.h.vYp != ChatFooter.V(this.vXU)))
          {
            ab.i("MicroMsg.ChatFooter", "active MODE_TRANS.");
            ChatFooter.a(this.vXU, ChatFooter.h.vYp);
            ChatFooter.O(this.vXU).setText(this.vXU.getResources().getText(2131306251));
            ChatFooter.W(this.vXU);
            ChatFooter.X(this.vXU);
            break;
          }
          if ((paramMotionEvent.getRawX() > ChatFooter.doP()) || (ChatFooter.h.vYq == ChatFooter.V(this.vXU))) {
            break;
          }
          ab.i("MicroMsg.ChatFooter", "active MODE_CANCEL.");
          ChatFooter.a(this.vXU, ChatFooter.h.vYq);
          ChatFooter.O(this.vXU).setText(this.vXU.getResources().getText(2131306248));
          ChatFooter.Y(this.vXU);
          ChatFooter.Z(this.vXU);
          break;
        }
        if ((ChatFooter.aa(this.vXU) == null) || (ChatFooter.ab(this.vXU) == null)) {
          ab.e("MicroMsg.ChatFooter", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", new Object[] { ChatFooter.aa(this.vXU), ChatFooter.ab(this.vXU) });
        }
        if ((paramMotionEvent.getX() > 0.0F) && (paramMotionEvent.getY() > -ChatFooter.I(this.vXU) / 2) && (paramMotionEvent.getX() < ChatFooter.u(this.vXU).getWidth()))
        {
          if (ChatFooter.aa(this.vXU) != null) {
            ChatFooter.aa(this.vXU).setVisibility(0);
          }
          if (ChatFooter.ab(this.vXU) == null) {
            break;
          }
          ChatFooter.u(this.vXU).setText(2131298128);
          ChatFooter.ab(this.vXU).setVisibility(8);
          break;
        }
        ab.i("MicroMsg.ChatFooter", "show cancel Tips, ACTION_MOVE (x:%f y:%f) rcdHintPopUpMarginTop:%d voiceRcdBtn.getWidth():%d voiceRcdBtn.getHeight():%d", new Object[] { Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Integer.valueOf(ChatFooter.I(this.vXU)), Integer.valueOf(ChatFooter.u(this.vXU).getWidth()), Integer.valueOf(ChatFooter.u(this.vXU).getHeight()) });
        if (ChatFooter.aa(this.vXU) != null) {
          ChatFooter.aa(this.vXU).setVisibility(8);
        }
        if (ChatFooter.ab(this.vXU) == null) {
          break;
        }
        ChatFooter.u(this.vXU).setTextSize(0, com.tencent.mm.cb.a.ap(this.vXU.getContext(), 2131427809) * com.tencent.mm.cb.a.gr(this.vXU.getContext()));
        ChatFooter.u(this.vXU).setText(2131298112);
        ChatFooter.ab(this.vXU).setVisibility(0);
        break;
        synchronized (ChatFooter.D(this.vXU))
        {
          for (;;)
          {
            com.tencent.mm.sdk.b.a.ymk.d(???.tpg);
            if (???.gbw != null)
            {
              ???.gbw.Fb();
              ???.gbw = null;
            }
            com.tencent.mm.modelvoiceaddr.a.c localc = ???.gbF;
            if (localc != null) {}
            try
            {
              ???.gbF.release();
              ???.gbF = null;
              if (???.tph != null)
              {
                i = com.tencent.mm.a.e.cM(com.tencent.mm.plugin.transvoice.a.a.cKW());
                ???.tph.mt(i);
                if (???.tpi != null) {
                  ???.tpi.b(???.tph);
                }
                ???.tph = null;
              }
              if ((this.vXU.getContext() instanceof Activity)) {
                ((Activity)this.vXU.getContext()).getWindow().clearFlags(128);
              }
              ChatFooter.v(this.vXU).tpn = System.currentTimeMillis();
              ChatFooter.v(this.vXU).tpo = ((int)paramMotionEvent.getRawX());
              ChatFooter.v(this.vXU).tpp = ((int)paramMotionEvent.getRawY());
              ab.i("RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.doO()) });
              ChatFooter.ac(this.vXU);
              ab.i("RcdBtnEvent", "outer on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.doQ()) });
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ab.printErrStackTrace("MicroMsg.CutShortSentence", localException, "mVoiceSilentDetectAPI.release error", new Object[0]);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.11
 * JD-Core Version:    0.7.0.1
 */