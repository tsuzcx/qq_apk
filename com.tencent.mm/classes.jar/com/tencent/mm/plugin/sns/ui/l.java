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
import com.tencent.mm.cd.a;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.k.f.a;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.cuu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.y;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l
  implements p.a
{
  private z xlN = null;
  
  public l(z paramz)
  {
    this.xlN = paramz;
  }
  
  public final void b(View paramView, Object paramObject)
  {
    AppMethodBeat.i(97845);
    if (this.xlN.dyL() != null) {
      this.xlN.dyL().duJ();
    }
    if (this.xlN.dyM() != null) {
      this.xlN.dyM().duJ();
    }
    if (this.xlN.dyN() != null) {
      this.xlN.dyN().dzb();
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
    if (this.xlN.dyO() != null)
    {
      this.xlN.dyO().dDa();
      this.xlN.dyO().lUw = true;
      localObject1 = this.xlN.dyO();
      if ((((bo)localObject1).wMD) || (!(paramView instanceof SnsCommentPreloadTextView)))
      {
        AppMethodBeat.o(97845);
        return;
      }
      localObject2 = (SnsCommentPreloadTextView)paramView;
      if (((bo)localObject1).wMA != null)
      {
        if ((((bo)localObject1).wMA.getTag() instanceof bo.a))
        {
          ((bo)localObject1).eG(((bo.a)((bo)localObject1).wMA.getTag()).wwV);
          AppMethodBeat.o(97845);
          return;
        }
        ((bo)localObject1).dDa();
        AppMethodBeat.o(97845);
        return;
      }
      if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof m)))
      {
        AppMethodBeat.o(97845);
        return;
      }
      paramObject = (m)paramView.getTag();
      if ((bt.gL(paramObject.wFh.Emf)) || (paramObject.wFh.Emf.get(0) == null) || (bt.isNullOrNil(((cuu)paramObject.wFh.Emf.get(0)).Md5)))
      {
        ad.w("MicroMsg.AdNotLikeHelper", "skip show emoji dialog. md5 is null");
        AppMethodBeat.o(97845);
        return;
      }
      ((bo)localObject1).wMA = new AbsoluteLayout(((bo)localObject1).mContext);
      ((bo)localObject1).wMA.setId(2131296470);
      ((bo)localObject1).wMA.setOnClickListener(new bo.1((bo)localObject1));
      ((bo)localObject1).wMz.addView(((bo)localObject1).wMA);
      n = ao.fromDPToPix(((bo)localObject1).mContext, 28);
      m = ao.fromDPToPix(((bo)localObject1).mContext, 2);
      i2 = BackwardSupportUtil.b.g(((bo)localObject1).mContext, 160.0F);
      i1 = BackwardSupportUtil.b.g(((bo)localObject1).mContext, 160.0F);
      i = com.tencent.mm.ui.ap.cf(((bo)localObject1).mContext).y;
      i3 = com.tencent.mm.ui.ap.cf(((bo)localObject1).mContext).x;
      localView = y.js(((bo)localObject1).mContext).inflate(2131495544, null);
      localView.setOnClickListener(((bo)localObject1).wMy.xTX);
      localView.setTag(paramObject);
      localObject3 = aw.eLx().FyY.aJx(((cuu)paramObject.wFh.Emf.get(0)).Md5);
      if (localObject3 == null)
      {
        ad.w("MicroMsg.AdNotLikeHelper", "skip show emoji dialog. emojiInfo is null");
        AppMethodBeat.o(97845);
        return;
      }
      ((EmojiStatusView)localView.findViewById(2131304974)).setEmojiInfo((EmojiInfo)localObject3);
      localObject3 = new int[2];
      i = g.gW(((bo)localObject1).mContext);
      paramView.getLocationInWindow((int[])localObject3);
      ad.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + localObject3[0] + "  " + localObject3[1] + " height: " + i);
      if (((bo)localObject1).lUw)
      {
        i = a.fromDPToPix(((bo)localObject1).mContext, 2);
        ((bo)localObject1).wxW = 0;
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
      if (localObject3[1] >= com.tencent.mm.ui.ap.iX(((bo)localObject1).mContext) + i1 + com.tencent.mm.ui.ap.dL(((bo)localObject1).mContext)) {
        break label974;
      }
      k = Math.max(Math.min(k, i3 - i2 - m), m);
      j = localObject3[1] - ((bo)localObject1).wxW - i + j + n + m;
    }
    for (int i = k;; i = k)
    {
      ((bo)localObject1).wxW = ai.jl(((bo)localObject1).mContext);
      localObject2 = new AbsoluteLayout.LayoutParams(-2, -2, i, j);
      localObject3 = new bo.a((bo)localObject1, localView);
      ((bo)localObject1).wMA.setTag(localObject3);
      ((bo)localObject1).wMA.addView(localView, (ViewGroup.LayoutParams)localObject2);
      localView.setVisibility(8);
      ((bo)localObject1).wMD = true;
      new com.tencent.mm.sdk.platformtools.ap().post(new bo.2((bo)localObject1, paramView, localView));
      paramView = com.tencent.mm.plugin.sns.k.f.wQY;
      long l = x.anz(paramObject.xlP);
      paramObject = String.valueOf(paramObject.wFh.Ema);
      localObject1 = q.st(l);
      paramView = (f.a)paramView.wRj.get(localObject1);
      if ((paramView != null) && (!paramView.wRJ.contains(paramObject))) {
        paramView.wRJ.add(paramObject);
      }
      AppMethodBeat.o(97845);
      return;
      label947:
      k = localObject3[0] + paramView.getMeasuredWidth() - n / 2 - i2 / 2;
      j = 0;
      break;
      label974:
      k = Math.max(Math.min(k, i3 - i2 - m), m);
      j = localObject3[1] - ((bo)localObject1).wxW - i + j - i1 - m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.l
 * JD-Core Version:    0.7.0.1
 */