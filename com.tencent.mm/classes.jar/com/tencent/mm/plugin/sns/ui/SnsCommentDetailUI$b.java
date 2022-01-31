package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.b;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.d.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.c.a;
import java.util.LinkedList;

final class SnsCommentDetailUI$b
  extends BaseAdapter
{
  Activity activity;
  String crk;
  public LinkedList<cds> rPQ;
  LinkedList<cds> rPR;
  
  public SnsCommentDetailUI$b(LinkedList<cds> paramLinkedList1, LinkedList<cds> paramLinkedList2, Activity paramActivity, String paramString)
  {
    this.rPQ = paramLinkedList2;
    this.rPR = paramActivity;
    this.activity = paramString;
    Object localObject;
    this.crk = localObject;
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(38831);
    if (this.rPR.size() > 0)
    {
      if (this.rPQ == null) {}
      for (;;)
      {
        AppMethodBeat.o(38831);
        return i + 1;
        i = this.rPQ.size();
      }
    }
    if (this.rPQ == null)
    {
      AppMethodBeat.o(38831);
      return 0;
    }
    i = this.rPQ.size();
    AppMethodBeat.o(38831);
    return i;
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
    AppMethodBeat.i(38832);
    int i = paramInt;
    if (this.rPR.size() > 0)
    {
      if (paramInt == 0)
      {
        paramView = SnsCommentDetailUI.H(this.rPu);
        AppMethodBeat.o(38832);
        return paramView;
      }
      i = paramInt - 1;
    }
    cds localcds = (cds)this.rPQ.get(i);
    View localView;
    if ((paramView == null) || (!(paramView.getTag() instanceof SnsCommentDetailUI.b.a)))
    {
      localView = w.hM(this.activity).inflate(2130970818, null);
      localView.setOnTouchListener(SnsCommentDetailUI.I(this.rPu));
      paramViewGroup = new SnsCommentDetailUI.b.a(this);
      paramViewGroup.egq = ((ImageView)localView.findViewById(2131827959));
      paramViewGroup.egq.setOnClickListener(SnsCommentDetailUI.J(this.rPu));
      paramViewGroup.pAN = ((TextView)localView.findViewById(2131827961));
      paramViewGroup.pAN.setOnTouchListener(new aa());
      paramViewGroup.pAN.setOnClickListener(new SnsCommentDetailUI.b.2(this));
      paramViewGroup.timeTv = ((TextView)localView.findViewById(2131827960));
      paramViewGroup.gMp = ((TextView)localView.findViewById(2131827962));
      paramViewGroup.gMp.setOnTouchListener(new aa());
      paramViewGroup.rPT = ((SnsTranslateResultView)localView.findViewById(2131827943));
      paramViewGroup.rPT.setVisibility(8);
      if (SnsCommentDetailUI.C(this.rPu) != 10) {
        break label1282;
      }
      localView.findViewById(2131827956).setBackgroundResource(2130838907);
    }
    label325:
    label1105:
    label1234:
    for (;;)
    {
      paramViewGroup.rPU = localcds;
      paramViewGroup.userName = localcds.Username;
      ((SnsAvatarImageView)paramViewGroup.egq).dw(localcds.Username, 3);
      ((SnsAvatarImageView)paramViewGroup.egq).setWeakContext(this.activity);
      label482:
      long l;
      if (SnsCommentDetailUI.C(this.rPu) == 10)
      {
        paramInt = 3;
        SnsCommentDetailUI.C(this.rPu);
        g.RM();
        paramView = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru(paramViewGroup.userName);
        if ((i != 0) || (!this.rPR.isEmpty())) {
          break label1116;
        }
        if (SnsCommentDetailUI.C(this.rPu) != 10) {
          break label1105;
        }
        localView.setBackgroundResource(2130838908);
        if (i != 0) {
          break label1150;
        }
        localView.findViewById(2131827958).setVisibility(0);
        localView.findViewById(2131827957).setVisibility(8);
        if (SnsCommentDetailUI.C(this.rPu) == 10) {
          ((ImageView)localView.findViewById(2131827958)).setImageResource(2131231370);
        }
        a.b.u(paramViewGroup.egq, localcds.Username);
        paramViewGroup.egq.setTag(localcds.Username);
        if (paramView == null) {
          break label1175;
        }
        paramView = paramView.Of();
        Object localObject = h.abu(SnsCommentDetailUI.o(this.rPu));
        if (localObject != null)
        {
          paramViewGroup.gMp.setText(localcds.ntu + " ");
          localObject = d.a(this.rPu, localcds, SnsCommentDetailUI.K(this.rPu), ((n)localObject).field_type, ((n)localObject).field_userName, 2);
          paramViewGroup.pAN.setText(paramView, TextView.BufferType.SPANNABLE);
          com.tencent.mm.pluginsdk.ui.d.j.k(paramViewGroup.pAN, paramInt);
          k localk = new k(paramViewGroup.pAN.getText());
          ab.i("MicroMsg.SnsCommentDetailUI", "test %s,%s", new Object[] { localcds.Username, paramView });
          localk.a(new o(localcds.Username, SnsCommentDetailUI.K(this.rPu), paramInt), paramView, 0);
          paramViewGroup.pAN.setText(localk, TextView.BufferType.SPANNABLE);
          paramViewGroup.timeTv.setText(ax.m(this.activity, localcds.CreateTime * 1000L));
          paramViewGroup.gMp.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
          paramViewGroup.gMp.setVisibility(0);
          SnsCommentDetailUI.L(this.rPu).c(localView, SnsCommentDetailUI.B(this.rPu).sjE, SnsCommentDetailUI.B(this.rPu).sjr);
          SnsCommentDetailUI.L(this.rPu).c(paramViewGroup.gMp, SnsCommentDetailUI.B(this.rPu).sjE, SnsCommentDetailUI.B(this.rPu).sjr);
          if (localcds.xNY == 0) {
            break label1201;
          }
          l = localcds.xNY;
          localObject = aq.gm(SnsCommentDetailUI.o(this.rPu), String.valueOf(l));
          if ((aq.dn((String)localObject, 4)) && (paramViewGroup.rPT != null))
          {
            localObject = aq.aaD((String)localObject);
            if (localObject == null) {
              break label1234;
            }
            paramViewGroup.rPT.setVisibility(0);
            if (!((aq.b)localObject).fon) {
              break label1223;
            }
            if (((aq.b)localObject).frX) {
              break label1211;
            }
            paramViewGroup.rPT.a((aq.b)localObject, 2, ((aq.b)localObject).result, ((aq.b)localObject).fwM, ((aq.b)localObject).riA);
          }
          label891:
          localView.setClickable(true);
          ab.d("MicroMsg.SnsCommentDetailUI", "position " + localcds.Username + " self " + SnsCommentDetailUI.M(this.rPu) + " commentid " + localcds.xNY + " snsid " + SnsCommentDetailUI.o(this.rPu));
          if (!SnsCommentDetailUI.M(this.rPu).equals(localcds.Username)) {
            break label1246;
          }
        }
      }
      label1116:
      label1246:
      for (paramViewGroup.info = localcds;; paramViewGroup.info = new Object[] { Integer.valueOf(i), localcds, localcds.Username, paramView })
      {
        paramView = new l(SnsCommentDetailUI.k(this.rPu), SnsCommentDetailUI.o(this.rPu), localcds, localcds.Username, localcds.ntu, paramViewGroup.gMp, 2);
        paramView.tag = paramViewGroup;
        localView.setTag(paramView);
        paramViewGroup.gMp.setTag(paramView);
        localView.setOnClickListener(SnsCommentDetailUI.N(this.rPu));
        paramViewGroup.gMp.setOnClickListener(SnsCommentDetailUI.N(this.rPu));
        AppMethodBeat.o(38832);
        return localView;
        paramViewGroup = (SnsCommentDetailUI.b.a)paramView.getTag();
        localView = paramView;
        break;
        paramInt = 2;
        break label325;
        localView.setBackgroundResource(2130840385);
        break label394;
        if (SnsCommentDetailUI.C(this.rPu) == 10)
        {
          localView.setBackgroundResource(2130840390);
          break label394;
        }
        localView.setBackgroundResource(2130840389);
        break label394;
        label1150:
        localView.findViewById(2131827958).setVisibility(4);
        localView.findViewById(2131827957).setVisibility(0);
        break label449;
        if (localcds.Nickname != null)
        {
          paramView = localcds.Nickname;
          break label482;
        }
        paramView = localcds.Username;
        break label482;
        l = localcds.xOa;
        break label797;
        paramViewGroup.rPT.setVisibility(8);
        break label891;
        paramViewGroup.rPT.Fc(2);
        break label891;
        paramViewGroup.rPT.setVisibility(8);
        break label891;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.b
 * JD-Core Version:    0.7.0.1
 */