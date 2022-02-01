package com.tencent.mm.plugin.sns.ui;

import android.graphics.Point;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.j.f.a;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l
  implements p.a
{
  private z yyF = null;
  
  public l(z paramz)
  {
    this.yyF = paramz;
  }
  
  public final void b(View paramView, Object paramObject)
  {
    AppMethodBeat.i(97845);
    if (this.yyF.dNi() != null) {
      this.yyF.dNi().dJj();
    }
    if (this.yyF.dNj() != null) {
      this.yyF.dNj().dJj();
    }
    if (this.yyF.dNk() != null) {
      this.yyF.dNk().dNy();
    }
    Object localObject1;
    Object localObject2;
    int n;
    int m;
    int i2;
    int i1;
    int i3;
    View localView;
    Object localObject3;
    int k;
    int j;
    if (this.yyF.dNl() != null)
    {
      this.yyF.dNl().dRx();
      this.yyF.dNl().mwy = true;
      localObject1 = this.yyF.dNl();
      if ((((bo)localObject1).xZj) || (!(paramView instanceof SnsCommentPreloadTextView)))
      {
        AppMethodBeat.o(97845);
        return;
      }
      localObject2 = (SnsCommentPreloadTextView)paramView;
      if (((bo)localObject1).xZg != null)
      {
        if ((((bo)localObject1).xZg.getTag() instanceof bo.a))
        {
          ((bo)localObject1).eT(((bo.a)((bo)localObject1).xZg.getTag()).xIw);
          AppMethodBeat.o(97845);
          return;
        }
        ((bo)localObject1).dRx();
        AppMethodBeat.o(97845);
        return;
      }
      if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof m)))
      {
        AppMethodBeat.o(97845);
        return;
      }
      paramObject = (m)paramView.getTag();
      if ((bs.gY(paramObject.xRC.FJe)) || (paramObject.xRC.FJe.get(0) == null) || (bs.isNullOrNil(((dag)paramObject.xRC.FJe.get(0)).Md5)))
      {
        ac.w("MicroMsg.AdNotLikeHelper", "skip show emoji dialog. md5 is null");
        AppMethodBeat.o(97845);
        return;
      }
      ((bo)localObject1).xZg = new AbsoluteLayout(((bo)localObject1).mContext);
      ((bo)localObject1).xZg.setId(2131296470);
      ((bo)localObject1).xZg.setOnClickListener(new bo.1((bo)localObject1));
      ((bo)localObject1).xZf.addView(((bo)localObject1).xZg);
      n = com.tencent.mm.ui.ao.fromDPToPix(((bo)localObject1).mContext, 28);
      m = com.tencent.mm.ui.ao.fromDPToPix(((bo)localObject1).mContext, 2);
      i2 = BackwardSupportUtil.b.g(((bo)localObject1).mContext, 160.0F);
      i1 = BackwardSupportUtil.b.g(((bo)localObject1).mContext, 160.0F);
      i = ap.cl(((bo)localObject1).mContext).y;
      i3 = ap.cl(((bo)localObject1).mContext).x;
      localView = com.tencent.mm.ui.z.jD(((bo)localObject1).mContext).inflate(2131495544, null);
      localView.setOnClickListener(((bo)localObject1).xZe.zgT);
      localView.setTag(paramObject);
      localObject3 = az.faZ().GXZ.aOT(((dag)paramObject.xRC.FJe.get(0)).Md5);
      if (localObject3 == null)
      {
        ac.w("MicroMsg.AdNotLikeHelper", "skip show emoji dialog. emojiInfo is null");
        AppMethodBeat.o(97845);
        return;
      }
      ((EmojiStatusView)localView.findViewById(2131304974)).setEmojiInfo((EmojiInfo)localObject3);
      localObject3 = new int[2];
      i = g.hh(((bo)localObject1).mContext);
      paramView.getLocationInWindow((int[])localObject3);
      ac.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + localObject3[0] + "  " + localObject3[1] + " height: " + i);
      if (((bo)localObject1).mwy)
      {
        i = a.fromDPToPix(((bo)localObject1).mContext, 2);
        ((bo)localObject1).xJx = 0;
      }
      if (((SnsCommentPreloadTextView)localObject2).getLineCount() <= 1) {
        break label947;
      }
      k = (int)((SnsCommentPreloadTextView)localObject2).getTvLayout().getLineWidth(((SnsCommentPreloadTextView)localObject2).getLineCount() - 1);
      int i4 = localObject3[0];
      int i5 = n / 2;
      int i6 = i2 / 2;
      j = ((SnsCommentPreloadTextView)localObject2).getHeight() - n;
      k = k + i4 - i5 - i6;
      if (localObject3[1] >= ap.ji(((bo)localObject1).mContext) + i1 + ap.dT(((bo)localObject1).mContext)) {
        break label974;
      }
      k = Math.max(Math.min(k, i3 - i2 - m), m);
      j = localObject3[1] - ((bo)localObject1).xJx - i + j + n + m;
    }
    for (int i = k;; i = k)
    {
      ((bo)localObject1).xJx = com.tencent.mm.ui.aj.jw(((bo)localObject1).mContext);
      localObject2 = new AbsoluteLayout.LayoutParams(-2, -2, i, j);
      localObject3 = new bo.a((bo)localObject1, localView);
      ((bo)localObject1).xZg.setTag(localObject3);
      ((bo)localObject1).xZg.addView(localView, (ViewGroup.LayoutParams)localObject2);
      localView.setVisibility(8);
      ((bo)localObject1).xZj = true;
      new com.tencent.mm.sdk.platformtools.ao().post(new bo.2((bo)localObject1, paramView, localView));
      paramView = com.tencent.mm.plugin.sns.j.f.ydE;
      long l = x.asL(paramObject.yyH);
      paramObject = String.valueOf(paramObject.xRC.FIZ);
      localObject1 = q.wW(l);
      paramView = (f.a)paramView.ydP.get(localObject1);
      if ((paramView != null) && (!paramView.yep.contains(paramObject))) {
        paramView.yep.add(paramObject);
      }
      AppMethodBeat.o(97845);
      return;
      label947:
      k = localObject3[0] + paramView.getMeasuredWidth() - n / 2 - i2 / 2;
      j = 0;
      break;
      label974:
      k = Math.max(Math.min(k, i3 - i2 - m), m);
      j = localObject3[1] - ((bo)localObject1).xJx - i + j - i1 - m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.l
 * JD-Core Version:    0.7.0.1
 */