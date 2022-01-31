package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.plugin.sns.ui.widget.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

final class SnsCommentDetailUI$b
  extends BaseAdapter
{
  Activity activity;
  String bJQ;
  public LinkedList<btd> oXs;
  LinkedList<btd> oXt;
  
  public SnsCommentDetailUI$b(LinkedList<btd> paramLinkedList1, LinkedList<btd> paramLinkedList2, Activity paramActivity, String paramString)
  {
    this.oXs = paramLinkedList2;
    this.oXt = paramActivity;
    this.activity = paramString;
    Object localObject;
    this.bJQ = localObject;
  }
  
  public final int getCount()
  {
    int j = 0;
    int i = 0;
    if (this.oXt.size() > 0) {
      if (this.oXs == null) {
        i += 1;
      }
    }
    do
    {
      return i;
      i = this.oXs.size();
      break;
      i = j;
    } while (this.oXs == null);
    return this.oXs.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = paramInt;
    Object localObject2;
    if (this.oXt.size() > 0)
    {
      if (paramInt == 0)
      {
        localObject2 = SnsCommentDetailUI.H(this.oWW);
        return localObject2;
      }
      i = paramInt - 1;
    }
    btd localbtd = (btd)this.oXs.get(i);
    if ((paramView == null) || (!(paramView.getTag() instanceof SnsCommentDetailUI.b.a)))
    {
      paramView = com.tencent.mm.ui.y.gt(this.activity).inflate(i.g.sns_comment_detail_item, null);
      paramView.setOnTouchListener(SnsCommentDetailUI.I(this.oWW));
      paramViewGroup = new SnsCommentDetailUI.b.a(this);
      paramViewGroup.doU = ((ImageView)paramView.findViewById(i.f.album_comment_avatar_iv));
      paramViewGroup.doU.setOnClickListener(SnsCommentDetailUI.J(this.oWW));
      paramViewGroup.mYa = ((TextView)paramView.findViewById(i.f.album_comment_nick_tv));
      paramViewGroup.mYa.setOnTouchListener(new aa());
      paramViewGroup.mYa.setOnClickListener(new SnsCommentDetailUI.b.2(this));
      paramViewGroup.igx = ((TextView)paramView.findViewById(i.f.album_comment_time_tv));
      paramViewGroup.fuN = ((TextView)paramView.findViewById(i.f.album_comment_content_tv));
      paramViewGroup.fuN.setOnTouchListener(new aa());
      paramViewGroup.oXv = ((SnsTranslateResultView)paramView.findViewById(i.f.sns_translate_result_view));
      paramViewGroup.oXv.setVisibility(8);
      if (SnsCommentDetailUI.C(this.oWW) != 10) {
        break label1240;
      }
      paramView.findViewById(i.f.comment_view_parent).setBackgroundResource(i.e.friendactivity_comment_detail_list_golden);
    }
    label287:
    label449:
    label1105:
    label1240:
    for (;;)
    {
      paramViewGroup.oXw = localbtd;
      paramViewGroup.userName = localbtd.sxM;
      Object localObject1;
      label357:
      long l;
      if (SnsCommentDetailUI.C(this.oWW) == 10)
      {
        paramInt = 3;
        SnsCommentDetailUI.C(this.oWW);
        g.DQ();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abj(paramViewGroup.userName);
        if ((i != 0) || (!this.oXt.isEmpty())) {
          break label1073;
        }
        if (SnsCommentDetailUI.C(this.oWW) != 10) {
          break label1063;
        }
        paramView.setBackgroundResource(i.e.friendactivity_comment_detail_list_golden_arror);
        if (i != 0) {
          break label1105;
        }
        paramView.findViewById(i.f.sns_comment_left_icon).setVisibility(0);
        paramView.findViewById(i.f.sns_comment_line).setVisibility(8);
        if (SnsCommentDetailUI.C(this.oWW) == 10) {
          ((ImageView)paramView.findViewById(i.f.sns_comment_left_icon)).setImageResource(i.i.friendactivity_writeicon_golden);
        }
        a.b.p(paramViewGroup.doU, localbtd.sxM);
        paramViewGroup.doU.setTag(localbtd.sxM);
        if (localObject1 == null) {
          break label1130;
        }
        localObject1 = ((ad)localObject1).Bq();
        Object localObject3 = h.OA(SnsCommentDetailUI.o(this.oWW));
        localObject2 = paramView;
        if (localObject3 == null) {
          break;
        }
        paramViewGroup.fuN.setText(localbtd.kVs + " ");
        localObject2 = c.a(this.oWW, localbtd, SnsCommentDetailUI.K(this.oWW), ((n)localObject3).field_type, ((n)localObject3).field_userName, 2);
        paramViewGroup.mYa.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        com.tencent.mm.pluginsdk.ui.d.j.h(paramViewGroup.mYa, paramInt);
        localObject3 = new k(paramViewGroup.mYa.getText());
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCommentDetailUI", "test %s,%s", new Object[] { localbtd.sxM, localObject1 });
        ((k)localObject3).a(new o(localbtd.sxM, SnsCommentDetailUI.K(this.oWW), paramInt), (CharSequence)localObject1, 0);
        paramViewGroup.mYa.setText((CharSequence)localObject3, TextView.BufferType.SPANNABLE);
        paramViewGroup.igx.setText(ay.l(this.activity, localbtd.mPL * 1000L));
        paramViewGroup.fuN.setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
        paramViewGroup.fuN.setVisibility(0);
        SnsCommentDetailUI.L(this.oWW).c(paramView, SnsCommentDetailUI.B(this.oWW).poM, SnsCommentDetailUI.B(this.oWW).poz);
        SnsCommentDetailUI.L(this.oWW).c(paramViewGroup.fuN, SnsCommentDetailUI.B(this.oWW).poM, SnsCommentDetailUI.B(this.oWW).poz);
        if (localbtd.tJu == 0) {
          break label1158;
        }
        l = localbtd.tJu;
        localObject2 = ap.eK(SnsCommentDetailUI.o(this.oWW), String.valueOf(l));
        if ((ap.cr((String)localObject2, 4)) && (paramViewGroup.oXv != null))
        {
          localObject2 = ap.NJ((String)localObject2);
          if (localObject2 == null) {
            break label1191;
          }
          paramViewGroup.oXv.setVisibility(0);
          if (!((ap.b)localObject2).dYj) {
            break label1180;
          }
          if (((ap.b)localObject2).ebE) {
            break label1168;
          }
          paramViewGroup.oXv.a((ap.b)localObject2, 2, ((ap.b)localObject2).result, ((ap.b)localObject2).egI, ((ap.b)localObject2).otI);
        }
        label864:
        paramView.setClickable(true);
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsCommentDetailUI", "position " + localbtd.sxM + " self " + SnsCommentDetailUI.M(this.oWW) + " commentid " + localbtd.tJu + " snsid " + SnsCommentDetailUI.o(this.oWW));
        if (!SnsCommentDetailUI.M(this.oWW).equals(localbtd.sxM)) {
          break label1203;
        }
      }
      for (paramViewGroup.aQK = localbtd;; paramViewGroup.aQK = new Object[] { Integer.valueOf(i), localbtd, localbtd.sxM, localObject1 })
      {
        localObject1 = new l(SnsCommentDetailUI.o(this.oWW), localbtd, localbtd.sxM, localbtd.kVs, paramViewGroup.fuN, 2);
        ((l)localObject1).tag = paramViewGroup;
        paramView.setTag(localObject1);
        paramViewGroup.fuN.setTag(localObject1);
        paramView.setOnClickListener(SnsCommentDetailUI.N(this.oWW));
        paramViewGroup.fuN.setOnClickListener(SnsCommentDetailUI.N(this.oWW));
        return paramView;
        paramViewGroup = (SnsCommentDetailUI.b.a)paramView.getTag();
        break;
        paramInt = 2;
        break label287;
        paramView.setBackgroundResource(i.e.sns_comment_detail_headitem_bg);
        break label357;
        if (SnsCommentDetailUI.C(this.oWW) == 10)
        {
          paramView.setBackgroundResource(i.e.sns_comment_detail_item_bg_golden);
          break label357;
        }
        paramView.setBackgroundResource(i.e.sns_comment_detail_item_bg);
        break label357;
        paramView.findViewById(i.f.sns_comment_left_icon).setVisibility(4);
        paramView.findViewById(i.f.sns_comment_line).setVisibility(0);
        break label413;
        label1130:
        if (localbtd.tqh != null)
        {
          localObject1 = localbtd.tqh;
          break label449;
        }
        localObject1 = localbtd.sxM;
        break label449;
        l = localbtd.tJx;
        break label770;
        paramViewGroup.oXv.setVisibility(8);
        break label864;
        paramViewGroup.oXv.yV(2);
        break label864;
        paramViewGroup.oXv.setVisibility(8);
        break label864;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.b
 * JD-Core Version:    0.7.0.1
 */