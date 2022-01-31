package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;

public final class i$a
  implements View.OnClickListener
{
  private String elx;
  private BaseTimeLineItem.BaseViewHolder rEU;
  private CharSequence rFJ = "";
  private cds reJ;
  
  public i$a(i parami, cds paramcds, String paramString, CharSequence paramCharSequence, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    this.elx = paramString;
    this.reJ = paramcds;
    this.rEU = paramBaseViewHolder;
    this.rFJ = paramCharSequence;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38187);
    if (!v.abQ(this.rEU.czw))
    {
      AppMethodBeat.o(38187);
      return;
    }
    this.rEU.she = paramView;
    if ((this.reJ == null) || (this.reJ.Username == null) || (!this.reJ.Username.equals(this.rFD.dZZ)))
    {
      new n();
      localObject1 = this.rFD.rkX.EE(this.rEU.position);
      if (((n)localObject1).coN())
      {
        AppMethodBeat.o(38187);
        return;
      }
      if (!m.k((n)localObject1))
      {
        com.tencent.mm.plugin.sns.lucky.ui.a.f(this.rEU.shk.getContext(), this.rEU.shk.EJ(0));
        AppMethodBeat.o(38187);
        return;
      }
      localObject2 = b.lV(742);
      localObject3 = ak.q((n)localObject1);
      localObject4 = ((b)localObject2).uv(com.tencent.mm.plugin.sns.data.i.j((n)localObject1)).lY(((n)localObject1).field_type).de(((n)localObject1).Ex(32)).uv(((n)localObject1).csP());
      if (this.reJ.xNY == 0)
      {
        paramView = this.reJ.xOa;
        paramView = ((b)localObject4).uv(paramView).uv(this.reJ.Username);
        if (localObject3 != null) {
          break label538;
        }
        i = 0;
        label249:
        paramView = paramView.lY(i);
        if (localObject3 != null) {
          break label547;
        }
      }
      label538:
      label547:
      for (int i = 0;; i = ((SnsObject)localObject3).CommentCount)
      {
        paramView.lY(i);
        ((b)localObject2).ake();
        paramView = this.rFD;
        localObject2 = this.rEU;
        localObject3 = i.c(this.rFD).getString(2131303938) + this.elx;
        localObject4 = this.reJ;
        String str = ((BaseTimeLineItem.BaseViewHolder)localObject2).czw + (String)localObject3;
        paramView.rFs = str;
        ab.i("MicroMsg.BaseTimeLine", "[performCommentClick] onCommentClick:  commentkey " + paramView.rFs + " " + ((BaseTimeLineItem.BaseViewHolder)localObject2).czw + " position:" + ((BaseTimeLineItem.BaseViewHolder)localObject2).position);
        paramView.rFo.setTag(localObject1);
        paramView.ctq();
        paramView.rFo.setVisibility(0);
        paramView.rFo.rQa = i.du(str, 0);
        paramView.rFo.setCommentHint((String)localObject3 + paramView.context.getString(2131303772));
        paramView.rFo.setCommentInfo((cds)localObject4);
        paramView.rFo.h(i.rFu, str);
        paramView.rFo.lD(false);
        paramView.c((BaseTimeLineItem.BaseViewHolder)localObject2);
        AppMethodBeat.o(38187);
        return;
        paramView = this.reJ.xNY;
        break;
        i = ((SnsObject)localObject3).LikeCount;
        break label249;
      }
    }
    if (this.rFD.rFp.scT)
    {
      this.rFD.ctr();
      this.rFD.rFp.scT = false;
    }
    Object localObject2 = new com.tencent.mm.ui.widget.c.a(i.c(this.rFD));
    Object localObject3 = new i.a.1(this);
    Object localObject4 = new i.a.2(this);
    Object localObject1 = new int[2];
    if ((paramView.getTag(2131820681) instanceof int[])) {
      localObject1 = (int[])paramView.getTag(2131820681);
    }
    ((com.tencent.mm.ui.widget.c.a)localObject2).a(paramView, (View.OnCreateContextMenuListener)localObject3, (n.d)localObject4, localObject1[0], localObject1[1]);
    AppMethodBeat.o(38187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.a
 * JD-Core Version:    0.7.0.1
 */