package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class SnsMsgUI$a
  extends com.tencent.mm.ui.p<com.tencent.mm.plugin.sns.storage.j>
{
  int eke;
  protected MMSlideDelView.g jSb;
  protected MMSlideDelView.c jSc;
  protected MMSlideDelView.d jSe;
  int kxm;
  private Set<MMSlideDelView> nTX;
  protected MMSlideDelView.f rSY;
  
  public SnsMsgUI$a(SnsMsgUI paramSnsMsgUI, Context paramContext, com.tencent.mm.plugin.sns.storage.j paramj)
  {
    super(paramContext, paramj);
    AppMethodBeat.i(39090);
    this.nTX = new HashSet();
    this.jSe = new SnsMsgUI.a.1(this);
    this.kxm = 10;
    this.eke = this.kxm;
    AppMethodBeat.o(39090);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(39094);
    if ((ag.cpk().bbZ() > 0) && (!SnsMsgUI.p(this.rSU))) {
      setCursor(ag.cpk().css());
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(39094);
      return;
      this.eke = ag.cpk().cst();
      setCursor(ag.cpk().Ew(this.kxm));
    }
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(39092);
    bKb();
    Ku();
    AppMethodBeat.o(39092);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    try
    {
      AppMethodBeat.i(39093);
      super.a(paramString, paramm);
      AppMethodBeat.o(39093);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b(MMSlideDelView.f paramf)
  {
    this.rSY = paramf;
  }
  
  public final boolean bem()
  {
    return this.kxm >= this.eke;
  }
  
  public final int ben()
  {
    AppMethodBeat.i(39095);
    if (bem())
    {
      if (SnsMsgUI.h(this.rSU).getParent() != null) {
        SnsMsgUI.c(this.rSU).removeFooterView(SnsMsgUI.h(this.rSU));
      }
      AppMethodBeat.o(39095);
      return 0;
    }
    this.kxm += 10;
    if (this.kxm <= this.eke)
    {
      AppMethodBeat.o(39095);
      return 10;
    }
    this.kxm = this.eke;
    int i = this.eke;
    AppMethodBeat.o(39095);
    return i % 10;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(39091);
    long l = ((com.tencent.mm.plugin.sns.storage.j)getItem(paramInt)).field_snsID;
    AppMethodBeat.o(39091);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39096);
    com.tencent.mm.plugin.sns.storage.j localj = (com.tencent.mm.plugin.sns.storage.j)getItem(paramInt);
    Object localObject1;
    SnsMsgUI.a.a locala;
    if (localj != null)
    {
      if (!SnsMsgUI.q(this.rSU).containsKey(Integer.valueOf(localj.rCZ))) {
        SnsMsgUI.q(this.rSU).put(Integer.valueOf(localj.rCZ), localj.csq());
      }
    }
    else
    {
      if ((paramView != null) && ((paramView.getTag() instanceof SnsMsgUI.a.a))) {
        break label1171;
      }
      localObject1 = (MMSlideDelView)w.hM(this.context).inflate(2130968837, null);
      paramView = w.hM(this.context).inflate(2130970846, null);
      locala = new SnsMsgUI.a.a(this);
      locala.rTa = ((SnsAvatarImageView)paramView.findViewById(2131828029));
      locala.rTa.setWeakContext(this.context);
      locala.pAN = ((TextView)paramView.findViewById(2131828030));
      locala.rTd = ((TextView)paramView.findViewById(2131828032));
      locala.rTc = ((ImageView)paramView.findViewById(2131828031));
      locala.timeTv = ((TextView)paramView.findViewById(2131828033));
      locala.rTe = ((MMImageView)paramView.findViewById(2131828036));
      locala.rTb = ((TextView)paramView.findViewById(2131828038));
      locala.rTe.setOnClickListener(SnsMsgUI.r(this.rSU));
      locala.jSj = ((MMSlideDelView)localObject1).findViewById(2131821742);
      locala.jSk = ((TextView)((MMSlideDelView)localObject1).findViewById(2131821102));
      locala.rTf = ((ImageView)paramView.findViewById(2131828037));
      ((MMSlideDelView)localObject1).setView(paramView);
      ((MMSlideDelView)localObject1).setPerformItemClickListener(this.jSb);
      ((MMSlideDelView)localObject1).setGetViewPositionCallback(this.jSc);
      ((MMSlideDelView)localObject1).setItemStatusCallBack(this.jSe);
      ((MMSlideDelView)localObject1).setEnable(false);
      ((View)localObject1).setTag(locala);
      label339:
      locala.rTe.setTag(null);
      locala.cIo = localj.field_snsID;
      locala.jSj.setTag(Integer.valueOf(localj.rCZ));
      locala.jSj.setOnClickListener(new SnsMsgUI.a.2(this));
    }
    Object localObject2;
    label453:
    Object localObject3;
    for (;;)
    {
      try
      {
        localObject2 = (cdm)new cdm().parseFrom(localj.field_curActionBuf);
      }
      catch (Exception paramView)
      {
        label539:
        label804:
        label844:
        label1101:
        ab.printErrStackTrace("MicroMsg.SnsMsgUI", paramView, "", new Object[0]);
        label925:
        label1062:
        label1086:
        continue;
        label1171:
        label1186:
        ab.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
        continue;
        if (bo.isNullOrNil(((cdm)localObject2).xNV)) {
          continue;
        }
        paramView = ((cdm)localObject2).xNV;
        continue;
        paramView = ((cdm)localObject2).xCG;
        continue;
        locala.pAN.setTextColor(this.rSU.getResources().getColor(2131690489));
        continue;
      }
      try
      {
        paramViewGroup = ((cdm)new cdm().parseFrom(localj.field_refActionBuf)).xCG;
      }
      catch (Exception paramView)
      {
        paramView = "";
      }
    }
    try
    {
      if ((!bo.isNullOrNil(paramViewGroup)) && (!paramViewGroup.equals(ag.coK()))) {
        break label1186;
      }
      paramViewGroup = "";
      if (bo.isNullOrNil(((cdm)localObject2).xCG)) {
        break label1271;
      }
      a.b.c(locala.rTa, ((cdm)localObject2).xCG);
      paramView = ((cdm)localObject2).xCG;
      locala.rTa.dw(paramView, 6);
      if (bo.isEqual(SnsMsgUI.t(this.rSU), paramView)) {
        break label1242;
      }
      localObject3 = locala.rTa;
      com.tencent.mm.kernel.g.RM();
      ((SnsAvatarImageView)localObject3).setShowStoryHint(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).hasNewStory(paramView));
      locala.rTa.setOnClickListener(new SnsMsgUI.a.3(this, paramView));
      paramView = SnsMsgUI.s(this.rSU).arw(((cdm)localObject2).xCG);
      if (paramView == null) {
        break label1282;
      }
      paramView = paramView.Of();
      locala.pAN.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.rSU, paramView, locala.pAN.getTextSize()));
      paramView = ag.cpf().lZ(localj.field_snsID);
      if ((paramView == null) || (paramView.field_type != 21)) {
        break label1311;
      }
      locala.pAN.setTextColor(this.rSU.getResources().getColor(2131690497));
      paramView = ((cdm)localObject2).xCG;
      localObject3 = locala.pAN;
      j = ((cdm)localObject2).niK;
      switch (localj.field_type)
      {
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        label1242:
        label1271:
        label2687:
        paramView = paramViewGroup;
        label1282:
        label1311:
        label2672:
        continue;
        label2792:
        label3181:
        i = 1;
        label3017:
        label3170:
        label3175:
        break;
        break label925;
        i = 1;
        break;
        i = 0;
        break;
        i = 0;
        break;
        i = 0;
        break;
        switch (j)
        {
        }
        continue;
        i = 0;
        break label804;
        break label844;
        i = 2131230829;
        continue;
        i = 2131230809;
        continue;
        i = 2131230826;
        continue;
        i = 2131230829;
        continue;
        i = 2131230807;
        continue;
        i = 2130837708;
        continue;
        i = 2130837708;
        continue;
        paramInt = 8;
      }
    }
    if ((i == 0) || (SnsMsgUI.t(this.rSU).equals(paramView)))
    {
      ((TextView)localObject3).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      localObject3 = locala.rTd;
      if ((localj.field_commentflag & 0x1) <= 0) {
        break label3299;
      }
      i = 1;
      if (i != 0)
      {
        ((TextView)localObject3).setText(2131303902);
        ((TextView)localObject3).setBackgroundColor(this.rSU.getResources().getColor(2131689909));
        ((TextView)localObject3).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        locala.timeTv.setText(ax.l(this.rSU, ((cdm)localObject2).CreateTime * 1000L));
        paramView = null;
        if ((((cdm)localObject2).jKs != 7) && (((cdm)localObject2).jKs != 8) && (((cdm)localObject2).jKs != 16)) {
          break label2672;
        }
        paramViewGroup = ag.cpi().lQ(localj.field_snsID);
        if (paramViewGroup == null) {
          break label3199;
        }
        paramView = paramViewGroup.csn();
        break label3199;
        locala.rTe.setVisibility(8);
        locala.rTb.setVisibility(8);
        locala.rTf.setVisibility(8);
        locala.rTe.setImageBitmap(null);
        ag.cpc().dE(locala.rTe);
        if (paramView == null) {
          break label3017;
        }
        paramViewGroup = paramView.csh().xTS.wOa;
        if (paramView.field_type != 2) {
          break label2687;
        }
        locala.rTe.setTag(null);
        locala.rTb.setVisibility(0);
        paramView = com.tencent.mm.pluginsdk.ui.d.j.b(this.rSU, paramView.csh().xTP, locala.rTb.getTextSize());
        locala.rTb.setText(paramView);
        if ((locala.rTe.getVisibility() != 0) && (locala.rTf.getVisibility() != 0)) {
          break label3170;
        }
        paramInt = 1;
        paramView = ((View)localObject1).findViewById(2131828035);
        if (paramInt == 0) {
          break label3175;
        }
        paramInt = 0;
        paramView.setVisibility(paramInt);
        paramView = ((View)localObject1).findViewById(2131828034);
        if (localj.field_isSilence != 1) {
          break label3181;
        }
      }
      for (paramInt = 0;; paramInt = 8)
      {
        for (;;)
        {
          Object localObject4;
          for (;;)
          {
            paramView.setVisibility(paramInt);
            AppMethodBeat.o(39096);
            return localObject1;
            ((com.tencent.mm.plugin.sns.storage.j)SnsMsgUI.q(this.rSU).get(Integer.valueOf(localj.rCZ))).field_isSilence = localj.field_isSilence;
            break;
            locala = (SnsMsgUI.a.a)paramView.getTag();
            localObject1 = paramView;
            break label339;
            localObject3 = SnsMsgUI.s(this.rSU).arw(paramViewGroup);
            paramView = paramViewGroup;
            if (localObject3 != null)
            {
              paramView = paramViewGroup;
              if (!bo.isNullOrNil(((com.tencent.mm.n.a)localObject3).Of())) {
                paramView = ((com.tencent.mm.n.a)localObject3).Of();
              }
            }
            paramViewGroup = paramView;
            break label453;
            paramViewGroup = paramView;
            break label453;
            locala.rTa.setShowStoryHint(false);
            break label539;
            paramView = com.tencent.mm.cb.a.k(this.context, 2130839934);
            for (;;)
            {
              ((TextView)localObject3).setCompoundDrawablesWithIntrinsicBounds(null, null, paramView, null);
              break;
              paramView = com.tencent.mm.cb.a.k(this.context, 2130839935);
              continue;
              paramView = com.tencent.mm.cb.a.k(this.context, 2130839933);
              continue;
              paramView = com.tencent.mm.cb.a.k(this.context, 2130839931);
              continue;
              paramView = com.tencent.mm.cb.a.k(this.context, 2130839932);
            }
            ((TextView)localObject3).setTextColor(this.rSU.getResources().getColor(2131689763));
            ((TextView)localObject3).setBackgroundDrawable(null);
            ((TextView)localObject3).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            ((TextView)localObject3).setText("");
            ((TextView)localObject3).setCompoundDrawablePadding(0);
            com.tencent.mm.plugin.sns.storage.e locale;
            switch (((cdm)localObject2).jKs)
            {
            case 1: 
            case 5: 
              paramViewGroup = ag.cpf().lZ(localj.field_snsID);
              if ((paramViewGroup != null) && (paramViewGroup.field_type == 7))
              {
                ((TextView)localObject3).setText(this.rSU.getString(2131303874));
                break;
              }
              paramView = com.tencent.mm.cb.a.k(this.context, 2131231365);
              if ((paramViewGroup != null) && (paramViewGroup.field_type == 21)) {
                paramView.setColorFilter(this.rSU.getResources().getColor(2131690501), PorterDuff.Mode.SRC_ATOP);
              }
              for (;;)
              {
                paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
                paramViewGroup = new SpannableString(" ");
                paramViewGroup.setSpan(new ImageSpan(paramView), 0, 1, 18);
                ((TextView)localObject3).setText(paramViewGroup);
                ((TextView)localObject3).setContentDescription(this.rSU.getContext().getString(2131303818));
                break;
                paramView.clearColorFilter();
              }
            case 2: 
            case 3: 
              localObject4 = ((cdm)localObject2).ntu;
              paramView = "";
              locale = ag.cpi().lQ(localj.field_snsID);
              if (d.fS(((cdm)localObject2).xOc, 1)) {
                if (locale != null)
                {
                  com.tencent.mm.kernel.g.RM();
                  paramView = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru(locale.field_userName);
                  paramView = this.context.getString(2131303906, new Object[] { paramView.Of() });
                }
              }
              for (;;)
              {
                paramView = paramView + (String)localObject4 + " ";
                ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.rSU, paramView, ((TextView)localObject3).getTextSize()));
                break;
                if (!bo.isNullOrNil(paramViewGroup)) {
                  paramView = this.context.getString(2131303907, new Object[] { paramViewGroup });
                }
              }
            case 7: 
              ((TextView)localObject3).setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.cb.a.k(this.context, 2131231365), null, null, null);
              ((TextView)localObject3).setContentDescription(this.rSU.getContext().getString(2131303818));
              break;
            case 8: 
              paramView = "";
              localObject4 = bo.nullAsNil(((cdm)localObject2).ntu);
              locale = ag.cpi().lQ(localj.field_snsID);
              if (d.fS(((cdm)localObject2).xOc, 1)) {
                if (locale != null)
                {
                  com.tencent.mm.kernel.g.RM();
                  paramView = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().aru(locale.field_userName);
                  paramView = this.context.getString(2131303906, new Object[] { paramView.Of() });
                }
              }
              for (;;)
              {
                paramView = paramView + (String)localObject4 + " ";
                ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.rSU, paramView, ((TextView)localObject3).getTextSize()));
                break;
                if (!bo.isNullOrNil(paramViewGroup)) {
                  paramView = this.context.getString(2131303907, new Object[] { paramViewGroup });
                }
              }
            case 4: 
              ((TextView)localObject3).setText(this.rSU.getString(2131304023));
              break;
            case 16: 
              paramView = "" + "[" + this.rSU.getString(2131303745) + "]";
              paramView = paramView + " " + bo.nullAsNil(((cdm)localObject2).ntu);
              ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.rSU, paramView, ((TextView)localObject3).getTextSize()));
              break;
            case 14: 
              paramView = new aur();
              ab.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + ((cdm)localObject2).xOb);
              try
              {
                paramView.parseFrom(aa.a(((cdm)localObject2).xOb));
                ab.i("MicroMsg.SnsMsgUI", "hbbuffer  " + paramView.cNd);
                paramViewGroup = SnsMsgUI.s(this.rSU).arw(((cdm)localObject2).xCG);
                ((TextView)localObject3).setText(this.rSU.getString(2131301177, new Object[] { paramViewGroup.Of(), bo.E(paramView.cNd / 100.0D) }));
              }
              catch (Exception paramViewGroup)
              {
                for (;;)
                {
                  ab.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + paramViewGroup.getMessage());
                }
              }
            }
          }
          paramView = new aur();
          ab.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + ((cdm)localObject2).xOb);
          try
          {
            paramView.parseFrom(aa.a(((cdm)localObject2).xOb));
            ab.i("MicroMsg.SnsMsgUI", "hbbuffer  " + paramView.cNd);
            SnsMsgUI.s(this.rSU).arw(((cdm)localObject2).xCG);
            paramViewGroup = null;
            if (paramView.cNd == 0L)
            {
              SnsMsgUI.b(this.rSU, true);
              paramView = new SpannableString(this.rSU.getString(2131301180));
              if (paramViewGroup != null)
              {
                paramViewGroup.setBounds(0, 0, paramViewGroup.getIntrinsicWidth(), paramViewGroup.getIntrinsicHeight());
                localObject4 = new com.tencent.mm.ui.widget.a(paramViewGroup);
                ((com.tencent.mm.ui.widget.a)localObject4).ACa = ((int)((paramViewGroup.getIntrinsicHeight() - ((TextView)localObject3).getTextSize() + com.tencent.mm.cb.a.fromDPToPix(this.rSU, 2)) / 2.0F));
                paramView.setSpan(localObject4, 0, 1, 33);
              }
              ((TextView)localObject3).setText(paramView);
            }
          }
          catch (Exception paramViewGroup)
          {
            for (;;)
            {
              ab.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + paramViewGroup.getMessage());
              continue;
              SnsMsgUI.b(this.rSU, false);
              paramView = new SpannableString(" " + this.rSU.getString(2131301179, new Object[] { bo.E(paramView.cNd / 100.0D) }));
              paramViewGroup = this.rSU.getResources().getDrawable(2130837676);
            }
          }
        }
        paramView = ag.cpf().lZ(localj.field_snsID);
        break label925;
        i = 0;
        if (paramViewGroup.size() > 0)
        {
          j = paramView.field_type;
          localObject2 = locala.rTe;
          i = -1;
        }
        switch (j)
        {
        case 2: 
          ag.cpc().a((bcs)paramViewGroup.get(0), locala.rTe, i, this.rSU.hashCode(), az.yNS);
          if ((paramView.field_type == 15) || ((paramView.field_type == 27) && (paramViewGroup.size() > 0) && (((bcs)paramViewGroup.get(0)).jKs == 6)))
          {
            locala.rTf.setVisibility(0);
            paramView = new com.tencent.mm.plugin.sns.storage.j();
            ag.cpk().get(localj.systemRowid, paramView);
            locala.rTe.setTag(paramView);
          }
        case 8: 
          for (i = 1;; i = 1)
          {
            paramView = locala.rTe;
            if (i == 0) {
              break label3364;
            }
            paramInt = 0;
            paramView.setVisibility(paramInt);
            break;
            ((MMImageView)localObject2).setImageDrawable(null);
            break label2792;
            ((MMImageView)localObject2).setImageDrawable(null);
            break label2792;
            paramViewGroup = new ao();
            paramViewGroup.ctV = paramView.csH();
            paramViewGroup.index = 0;
            paramView = new ArrayList();
            paramView.add(locala.rTe);
            paramViewGroup.rQS = paramView;
            paramViewGroup.position = paramInt;
            locala.rTe.setTag(paramViewGroup);
          }
          if ((((cdm)localObject2).jKs == 7) || (((cdm)localObject2).jKs == 8)) {
            break label1062;
          }
          if (((cdm)localObject2).jKs == 16)
          {
            if (!com.tencent.mm.plugin.sns.model.m.ly(localj.field_snsID)) {
              break label1062;
            }
            if (((cdm)localObject2).wpo != null) {
              ab.i("MicroMsg.SnsMsgUI", "atFriend detail, aid %d", new Object[] { Integer.valueOf(((cdm)localObject2).wpo.xGU) });
            }
            paramView = new com.tencent.mm.plugin.sns.model.m(localj.field_snsID, ((cdm)localObject2).wpo);
            com.tencent.mm.kernel.g.RM();
            com.tencent.mm.kernel.g.RK().eHt.a(paramView, 0);
            break label1062;
          }
          if (!q.lB(localj.field_snsID)) {
            break label1062;
          }
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RK().eHt.a(new q(localj.field_snsID), 0);
          break label1062;
          paramInt = 0;
          break label1086;
          paramInt = 8;
          break label1101;
        }
      }
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.jSc = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.jSb = paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.a
 * JD-Core Version:    0.7.0.1
 */