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
import com.tencent.mm.cb.a;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.e;
import com.tencent.mm.plugin.sns.j.e.a;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.z;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l
  implements p.a
{
  private aa AgX = null;
  
  public l(aa paramaa)
  {
    this.AgX = paramaa;
  }
  
  public final void b(View paramView, Object paramObject)
  {
    AppMethodBeat.i(97845);
    if (this.AgX.edc() != null) {
      this.AgX.edc().dYX();
    }
    if (this.AgX.edd() != null) {
      this.AgX.edd().dYX();
    }
    if (this.AgX.ede() != null) {
      this.AgX.ede().edt();
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
    if (this.AgX.edf() != null)
    {
      this.AgX.edf().ehy();
      this.AgX.edf().ncj = true;
      localObject1 = this.AgX.edf();
      if ((((br)localObject1).zGx) || (!(paramView instanceof SnsCommentPreloadTextView)))
      {
        AppMethodBeat.o(97845);
        return;
      }
      localObject2 = (SnsCommentPreloadTextView)paramView;
      if (((br)localObject1).zGu != null)
      {
        if ((((br)localObject1).zGu.getTag() instanceof br.a))
        {
          ((br)localObject1).fh(((br.a)((br)localObject1).zGu.getTag()).zom);
          AppMethodBeat.o(97845);
          return;
        }
        ((br)localObject1).ehy();
        AppMethodBeat.o(97845);
        return;
      }
      if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof m)))
      {
        AppMethodBeat.o(97845);
        return;
      }
      paramObject = (m)paramView.getTag();
      if ((bu.ht(paramObject.zyl.HNp)) || (paramObject.zyl.HNp.get(0) == null) || (bu.isNullOrNil(((dgn)paramObject.zyl.HNp.get(0)).Md5)))
      {
        ae.w("MicroMsg.AdNotLikeHelper", "skip show emoji dialog. md5 is null");
        AppMethodBeat.o(97845);
        return;
      }
      ((br)localObject1).zGu = new AbsoluteLayout(((br)localObject1).mContext);
      ((br)localObject1).zGu.setId(2131296470);
      ((br)localObject1).zGu.setOnClickListener(new br.1((br)localObject1));
      ((br)localObject1).zGt.addView(((br)localObject1).zGu);
      n = com.tencent.mm.ui.aq.fromDPToPix(((br)localObject1).mContext, 28);
      m = com.tencent.mm.ui.aq.fromDPToPix(((br)localObject1).mContext, 2);
      i2 = BackwardSupportUtil.b.h(((br)localObject1).mContext, 160.0F);
      i1 = BackwardSupportUtil.b.h(((br)localObject1).mContext, 160.0F);
      i = ar.ck(((br)localObject1).mContext).y;
      i3 = ar.ck(((br)localObject1).mContext).x;
      localView = z.jV(((br)localObject1).mContext).inflate(2131495544, null);
      localView.setOnClickListener(((br)localObject1).zGs.AQs);
      localView.setTag(paramObject);
      localObject3 = be.fvc().JfU.aWl(((dgn)paramObject.zyl.HNp.get(0)).Md5);
      if (localObject3 == null)
      {
        ae.w("MicroMsg.AdNotLikeHelper", "skip show emoji dialog. emojiInfo is null");
        AppMethodBeat.o(97845);
        return;
      }
      ((EmojiStatusView)localView.findViewById(2131304974)).setEmojiInfo((EmojiInfo)localObject3);
      localObject3 = new int[2];
      i = h.hs(((br)localObject1).mContext);
      paramView.getLocationInWindow((int[])localObject3);
      ae.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + localObject3[0] + "  " + localObject3[1] + " height: " + i);
      if (((br)localObject1).ncj)
      {
        i = a.fromDPToPix(((br)localObject1).mContext, 2);
        ((br)localObject1).zpn = 0;
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
      if (localObject3[1] >= ar.jN(((br)localObject1).mContext) + i1 + ar.dX(((br)localObject1).mContext)) {
        break label974;
      }
      k = Math.max(Math.min(k, i3 - i2 - m), m);
      j = localObject3[1] - ((br)localObject1).zpn - i + j + n + m;
    }
    for (int i = k;; i = k)
    {
      ((br)localObject1).zpn = al.jO(((br)localObject1).mContext);
      localObject2 = new AbsoluteLayout.LayoutParams(-2, -2, i, j);
      localObject3 = new br.a((br)localObject1, localView);
      ((br)localObject1).zGu.setTag(localObject3);
      ((br)localObject1).zGu.addView(localView, (ViewGroup.LayoutParams)localObject2);
      localView.setVisibility(8);
      ((br)localObject1).zGx = true;
      new com.tencent.mm.sdk.platformtools.aq().post(new br.2((br)localObject1, paramView, localView));
      paramView = e.zKO;
      long l = x.aze(paramObject.AgZ);
      paramObject = String.valueOf(paramObject.zyl.HNk);
      localObject1 = r.zV(l);
      paramView = (e.a)paramView.zLb.get(localObject1);
      if ((paramView != null) && (!paramView.zLG.contains(paramObject))) {
        paramView.zLG.add(paramObject);
      }
      AppMethodBeat.o(97845);
      return;
      label947:
      k = localObject3[0] + paramView.getMeasuredWidth() - n / 2 - i2 / 2;
      j = 0;
      break;
      label974:
      k = Math.max(Math.min(k, i3 - i2 - m), m);
      j = localObject3[1] - ((br)localObject1).zpn - i + j - i1 - m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.l
 * JD-Core Version:    0.7.0.1
 */