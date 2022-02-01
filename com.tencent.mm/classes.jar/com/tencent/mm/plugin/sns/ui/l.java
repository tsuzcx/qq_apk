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
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.statistics.j.a;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.span.u.a;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.protocal.protobuf.feb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l
  implements u.a
{
  private ae Rck = null;
  
  public l(ae paramae)
  {
    this.Rck = paramae;
  }
  
  public final void onClick(View paramView, Object paramObject)
  {
    AppMethodBeat.i(97845);
    if (this.Rck.hlE() != null) {
      this.Rck.hlE().hib();
    }
    if (this.Rck.hlF() != null) {
      this.Rck.hlF().hib();
    }
    if (this.Rck.hlG() != null) {
      this.Rck.hlG().hmb();
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
    if (this.Rck.hlH() != null)
    {
      this.Rck.hlH().hqH();
      this.Rck.hlH().Flq = true;
      localObject1 = this.Rck.hlH();
      if ((((by)localObject1).QBk) || (!(paramView instanceof SnsCommentPreloadTextView)))
      {
        AppMethodBeat.o(97845);
        return;
      }
      localObject2 = (SnsCommentPreloadTextView)paramView;
      if (((by)localObject1).QBh != null)
      {
        if ((((by)localObject1).QBh.getTag() instanceof by.a))
        {
          ((by)localObject1).jH(((by.a)((by)localObject1).QBh.getTag()).MdP);
          AppMethodBeat.o(97845);
          return;
        }
        ((by)localObject1).hqH();
        AppMethodBeat.o(97845);
        return;
      }
      if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof m)))
      {
        AppMethodBeat.o(97845);
        return;
      }
      paramObject = (m)paramView.getTag();
      if ((Util.isNullOrNil(paramObject.Qsv.abDm)) || (paramObject.Qsv.abDm.get(0) == null) || (Util.isNullOrNil(((feb)paramObject.Qsv.abDm.get(0)).Md5)))
      {
        Log.w("MicroMsg.AdNotLikeHelper", "skip show emoji dialog. md5 is null");
        AppMethodBeat.o(97845);
        return;
      }
      ((by)localObject1).QBh = new AbsoluteLayout(((by)localObject1).mContext);
      ((by)localObject1).QBh.setId(b.f.address);
      ((by)localObject1).QBh.setOnClickListener(new by.1((by)localObject1));
      ((by)localObject1).QBg.addView(((by)localObject1).QBh);
      n = bd.fromDPToPix(((by)localObject1).mContext, 28);
      m = bd.fromDPToPix(((by)localObject1).mContext, 2);
      i2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(((by)localObject1).mContext, 160.0F);
      i1 = BackwardSupportUtil.BitmapFactory.fromDPToPix(((by)localObject1).mContext, 160.0F);
      i = bf.bf(((by)localObject1).mContext).y;
      i3 = bf.bf(((by)localObject1).mContext).x;
      localView = af.mU(((by)localObject1).mContext).inflate(b.g.sns_emoji_info_content, null);
      localView.setOnClickListener(((by)localObject1).QBf.RQA);
      localView.setTag(paramObject);
      localObject3 = bl.jba().adju.bza(((feb)paramObject.Qsv.abDm.get(0)).Md5);
      if (localObject3 == null)
      {
        Log.w("MicroMsg.AdNotLikeHelper", "skip show emoji dialog. emojiInfo is null");
        AppMethodBeat.o(97845);
        return;
      }
      ((EmojiStatusView)localView.findViewById(b.f.sns_emoji_info_view)).setEmojiInfo((EmojiInfo)localObject3);
      localObject3 = new int[2];
      i = h.lm(((by)localObject1).mContext);
      paramView.getLocationInWindow((int[])localObject3);
      Log.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + localObject3[0] + "  " + localObject3[1] + " height: " + i);
      if (((by)localObject1).Flq)
      {
        i = a.fromDPToPix(((by)localObject1).mContext, 2);
        ((by)localObject1).vpn = 0;
      }
      if (((SnsCommentPreloadTextView)localObject2).getLineCount() <= 1) {
        break label950;
      }
      k = (int)((SnsCommentPreloadTextView)localObject2).getTvLayout().getLineWidth(((SnsCommentPreloadTextView)localObject2).getLineCount() - 1);
      int i4 = localObject3[0];
      int i5 = n / 2;
      int i6 = i2 / 2;
      j = ((SnsCommentPreloadTextView)localObject2).getHeight() - n;
      k = k + i4 - i5 - i6;
      if (localObject3[1] >= bf.getStatusBarHeight(((by)localObject1).mContext) + i1 + bf.fs(((by)localObject1).mContext)) {
        break label977;
      }
      k = Math.max(Math.min(k, i3 - i2 - m), m);
      j = localObject3[1] - ((by)localObject1).vpn - i + j + n + m;
    }
    for (int i = k;; i = k)
    {
      ((by)localObject1).vpn = aw.mL(((by)localObject1).mContext);
      localObject2 = new AbsoluteLayout.LayoutParams(-2, -2, i, j);
      localObject3 = new by.a((by)localObject1, localView);
      ((by)localObject1).QBh.setTag(localObject3);
      ((by)localObject1).QBh.addView(localView, (ViewGroup.LayoutParams)localObject2);
      localView.setVisibility(8);
      ((by)localObject1).QBk = true;
      new MMHandler().post(new by.2((by)localObject1, paramView, localView));
      paramView = j.QFS;
      long l = ai.aXe(paramObject.Rcm);
      paramObject = String.valueOf(paramObject.Qsv.abDh);
      localObject1 = t.uA(l);
      paramView = (j.a)paramView.QGg.get(localObject1);
      if ((paramView != null) && (!paramView.QGV.contains(paramObject))) {
        paramView.QGV.add(paramObject);
      }
      AppMethodBeat.o(97845);
      return;
      label950:
      k = localObject3[0] + paramView.getMeasuredWidth() - n / 2 - i2 / 2;
      j = 0;
      break;
      label977:
      k = Math.max(Math.min(k, i3 - i2 - m), m);
      j = localObject3[1] - ((by)localObject1).vpn - i + j - i1 - m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.l
 * JD-Core Version:    0.7.0.1
 */