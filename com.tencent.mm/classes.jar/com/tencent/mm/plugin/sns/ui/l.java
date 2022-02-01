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
import com.tencent.mm.plugin.sns.j.e;
import com.tencent.mm.plugin.sns.j.e.a;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dft;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.z;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l
  implements p.a
{
  private aa zPQ = null;
  
  public l(aa paramaa)
  {
    this.zPQ = paramaa;
  }
  
  public final void b(View paramView, Object paramObject)
  {
    AppMethodBeat.i(97845);
    if (this.zPQ.dZx() != null) {
      this.zPQ.dZx().dVw();
    }
    if (this.zPQ.dZy() != null) {
      this.zPQ.dZy().dVw();
    }
    if (this.zPQ.dZz() != null) {
      this.zPQ.dZz().dZN();
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
    if (this.zPQ.dZA() != null)
    {
      this.zPQ.dZA().edR();
      this.zPQ.dZA().mXd = true;
      localObject1 = this.zPQ.dZA();
      if ((((br)localObject1).zpi) || (!(paramView instanceof SnsCommentPreloadTextView)))
      {
        AppMethodBeat.o(97845);
        return;
      }
      localObject2 = (SnsCommentPreloadTextView)paramView;
      if (((br)localObject1).zpf != null)
      {
        if ((((br)localObject1).zpf.getTag() instanceof br.a))
        {
          ((br)localObject1).fi(((br.a)((br)localObject1).zpf.getTag()).yXL);
          AppMethodBeat.o(97845);
          return;
        }
        ((br)localObject1).edR();
        AppMethodBeat.o(97845);
        return;
      }
      if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof m)))
      {
        AppMethodBeat.o(97845);
        return;
      }
      paramObject = (m)paramView.getTag();
      if ((bt.hj(paramObject.zhw.HtM)) || (paramObject.zhw.HtM.get(0) == null) || (bt.isNullOrNil(((dft)paramObject.zhw.HtM.get(0)).Md5)))
      {
        ad.w("MicroMsg.AdNotLikeHelper", "skip show emoji dialog. md5 is null");
        AppMethodBeat.o(97845);
        return;
      }
      ((br)localObject1).zpf = new AbsoluteLayout(((br)localObject1).mContext);
      ((br)localObject1).zpf.setId(2131296470);
      ((br)localObject1).zpf.setOnClickListener(new br.1((br)localObject1));
      ((br)localObject1).zpe.addView(((br)localObject1).zpf);
      n = aq.fromDPToPix(((br)localObject1).mContext, 28);
      m = aq.fromDPToPix(((br)localObject1).mContext, 2);
      i2 = BackwardSupportUtil.b.g(((br)localObject1).mContext, 160.0F);
      i1 = BackwardSupportUtil.b.g(((br)localObject1).mContext, 160.0F);
      i = ar.ci(((br)localObject1).mContext).y;
      i3 = ar.ci(((br)localObject1).mContext).x;
      localView = z.jO(((br)localObject1).mContext).inflate(2131495544, null);
      localView.setOnClickListener(((br)localObject1).zpd.AyW);
      localView.setTag(paramObject);
      localObject3 = bd.frc().ILn.aUK(((dft)paramObject.zhw.HtM.get(0)).Md5);
      if (localObject3 == null)
      {
        ad.w("MicroMsg.AdNotLikeHelper", "skip show emoji dialog. emojiInfo is null");
        AppMethodBeat.o(97845);
        return;
      }
      ((EmojiStatusView)localView.findViewById(2131304974)).setEmojiInfo((EmojiInfo)localObject3);
      localObject3 = new int[2];
      i = h.hm(((br)localObject1).mContext);
      paramView.getLocationInWindow((int[])localObject3);
      ad.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + localObject3[0] + "  " + localObject3[1] + " height: " + i);
      if (((br)localObject1).mXd)
      {
        i = a.fromDPToPix(((br)localObject1).mContext, 2);
        ((br)localObject1).yYM = 0;
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
      if (localObject3[1] >= ar.jG(((br)localObject1).mContext) + i1 + ar.dT(((br)localObject1).mContext)) {
        break label974;
      }
      k = Math.max(Math.min(k, i3 - i2 - m), m);
      j = localObject3[1] - ((br)localObject1).yYM - i + j + n + m;
    }
    for (int i = k;; i = k)
    {
      ((br)localObject1).yYM = al.jH(((br)localObject1).mContext);
      localObject2 = new AbsoluteLayout.LayoutParams(-2, -2, i, j);
      localObject3 = new br.a((br)localObject1, localView);
      ((br)localObject1).zpf.setTag(localObject3);
      ((br)localObject1).zpf.addView(localView, (ViewGroup.LayoutParams)localObject2);
      localView.setVisibility(8);
      ((br)localObject1).zpi = true;
      new ap().post(new br.2((br)localObject1, paramView, localView));
      paramView = e.ztz;
      long l = x.axN(paramObject.zPS);
      paramObject = String.valueOf(paramObject.zhw.HtH);
      localObject1 = q.zw(l);
      paramView = (e.a)paramView.ztK.get(localObject1);
      if ((paramView != null) && (!paramView.zup.contains(paramObject))) {
        paramView.zup.add(paramObject);
      }
      AppMethodBeat.o(97845);
      return;
      label947:
      k = localObject3[0] + paramView.getMeasuredWidth() - n / 2 - i2 / 2;
      j = 0;
      break;
      label974:
      k = Math.max(Math.min(k, i3 - i2 - m), m);
      j = localObject3[1] - ((br)localObject1).yYM - i + j - i1 - m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.l
 * JD-Core Version:    0.7.0.1
 */