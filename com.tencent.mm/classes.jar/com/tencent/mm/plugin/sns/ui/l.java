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
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.k.e.a;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.span.q.a;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class l
  implements q.a
{
  private ab Ept = null;
  
  public l(ab paramab)
  {
    this.Ept = paramab;
  }
  
  public final void b(View paramView, Object paramObject)
  {
    AppMethodBeat.i(97845);
    if (this.Ept.ffr() != null) {
      this.Ept.ffr().fcl();
    }
    if (this.Ept.ffs() != null) {
      this.Ept.ffs().fcl();
    }
    if (this.Ept.fft() != null) {
      this.Ept.fft().ffL();
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
    if (this.Ept.ffu() != null)
    {
      this.Ept.ffu().fka();
      this.Ept.ffu().onr = true;
      localObject1 = this.Ept.ffu();
      if ((((bu)localObject1).DQx) || (!(paramView instanceof SnsCommentPreloadTextView)))
      {
        AppMethodBeat.o(97845);
        return;
      }
      localObject2 = (SnsCommentPreloadTextView)paramView;
      if (((bu)localObject1).DQu != null)
      {
        if ((((bu)localObject1).DQu.getTag() instanceof bu.a))
        {
          ((bu)localObject1).fw(((bu.a)((bu)localObject1).DQu.getTag()).Atk);
          AppMethodBeat.o(97845);
          return;
        }
        ((bu)localObject1).fka();
        AppMethodBeat.o(97845);
        return;
      }
      if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof m)))
      {
        AppMethodBeat.o(97845);
        return;
      }
      paramObject = (m)paramView.getTag();
      if ((Util.isNullOrNil(paramObject.DIu.MYY)) || (paramObject.DIu.MYY.get(0) == null) || (Util.isNullOrNil(((dzu)paramObject.DIu.MYY.get(0)).Md5)))
      {
        Log.w("MicroMsg.AdNotLikeHelper", "skip show emoji dialog. md5 is null");
        AppMethodBeat.o(97845);
        return;
      }
      ((bu)localObject1).DQu = new AbsoluteLayout(((bu)localObject1).mContext);
      ((bu)localObject1).DQu.setId(2131296543);
      ((bu)localObject1).DQu.setOnClickListener(new bu.1((bu)localObject1));
      ((bu)localObject1).DQt.addView(((bu)localObject1).DQu);
      n = at.fromDPToPix(((bu)localObject1).mContext, 28);
      m = at.fromDPToPix(((bu)localObject1).mContext, 2);
      i2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(((bu)localObject1).mContext, 160.0F);
      i1 = BackwardSupportUtil.BitmapFactory.fromDPToPix(((bu)localObject1).mContext, 160.0F);
      i = au.az(((bu)localObject1).mContext).y;
      i3 = au.az(((bu)localObject1).mContext).x;
      localView = aa.jQ(((bu)localObject1).mContext).inflate(2131496432, null);
      localView.setOnClickListener(((bu)localObject1).DQs.FaX);
      localView.setTag(paramObject);
      localObject3 = bj.gCJ().OpN.blk(((dzu)paramObject.DIu.MYY.get(0)).Md5);
      if (localObject3 == null)
      {
        Log.w("MicroMsg.AdNotLikeHelper", "skip show emoji dialog. emojiInfo is null");
        AppMethodBeat.o(97845);
        return;
      }
      ((EmojiStatusView)localView.findViewById(2131308114)).setEmojiInfo((EmojiInfo)localObject3);
      localObject3 = new int[2];
      i = h.im(((bu)localObject1).mContext);
      paramView.getLocationInWindow((int[])localObject3);
      Log.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + localObject3[0] + "  " + localObject3[1] + " height: " + i);
      if (((bu)localObject1).onr)
      {
        i = a.fromDPToPix(((bu)localObject1).mContext, 2);
        ((bu)localObject1).CHZ = 0;
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
      if (localObject3[1] >= au.getStatusBarHeight(((bu)localObject1).mContext) + i1 + au.eu(((bu)localObject1).mContext)) {
        break label974;
      }
      k = Math.max(Math.min(k, i3 - i2 - m), m);
      j = localObject3[1] - ((bu)localObject1).CHZ - i + j + n + m;
    }
    for (int i = k;; i = k)
    {
      ((bu)localObject1).CHZ = ao.jJ(((bu)localObject1).mContext);
      localObject2 = new AbsoluteLayout.LayoutParams(-2, -2, i, j);
      localObject3 = new bu.a((bu)localObject1, localView);
      ((bu)localObject1).DQu.setTag(localObject3);
      ((bu)localObject1).DQu.addView(localView, (ViewGroup.LayoutParams)localObject2);
      localView.setVisibility(8);
      ((bu)localObject1).DQx = true;
      new MMHandler().post(new bu.2((bu)localObject1, paramView, localView));
      paramView = e.DUQ;
      long l = y.aOa(paramObject.Epv);
      paramObject = String.valueOf(paramObject.DIu.MYT);
      localObject1 = r.Jb(l);
      paramView = (e.a)paramView.DVd.get(localObject1);
      if ((paramView != null) && (!paramView.DVO.contains(paramObject))) {
        paramView.DVO.add(paramObject);
      }
      AppMethodBeat.o(97845);
      return;
      label947:
      k = localObject3[0] + paramView.getMeasuredWidth() - n / 2 - i2 / 2;
      j = 0;
      break;
      label974:
      k = Math.max(Math.min(k, i3 - i2 - m), m);
      j = localObject3[1] - ((bu)localObject1).CHZ - i + j - i1 - m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.l
 * JD-Core Version:    0.7.0.1
 */