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
import com.tencent.mm.ah.p;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.b;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.m;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.aoz;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class SnsMsgUI$a
  extends r<com.tencent.mm.plugin.sns.storage.j>
{
  int dsw = this.iwi;
  protected MMSlideDelView.g hZd;
  protected MMSlideDelView.c hZe;
  protected MMSlideDelView.d hZg = new SnsMsgUI.a.1(this);
  int iwi = 10;
  private Set<MMSlideDelView> lwK = new HashSet();
  protected MMSlideDelView.f pau;
  
  public SnsMsgUI$a(SnsMsgUI paramSnsMsgUI, Context paramContext, com.tencent.mm.plugin.sns.storage.j paramj)
  {
    super(paramContext, paramj);
  }
  
  public final void a(String paramString, l paraml)
  {
    try
    {
      super.a(paramString, paraml);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean aCc()
  {
    return this.iwi >= this.dsw;
  }
  
  public final int aCd()
  {
    if (aCc())
    {
      if (SnsMsgUI.h(this.paq).getParent() != null) {
        SnsMsgUI.c(this.paq).removeFooterView(SnsMsgUI.h(this.paq));
      }
      return 0;
    }
    this.iwi += 10;
    if (this.iwi <= this.dsw) {
      return 10;
    }
    this.iwi = this.dsw;
    return this.dsw % 10;
  }
  
  public final void b(MMSlideDelView.f paramf)
  {
    this.pau = paramf;
  }
  
  public final long getItemId(int paramInt)
  {
    return ((com.tencent.mm.plugin.sns.storage.j)getItem(paramInt)).field_snsID;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.tencent.mm.plugin.sns.storage.j localj = (com.tencent.mm.plugin.sns.storage.j)getItem(paramInt);
    Object localObject1;
    SnsMsgUI.a.a locala;
    if ((paramView == null) || (!(paramView.getTag() instanceof SnsMsgUI.a.a)))
    {
      localObject1 = (MMSlideDelView)com.tencent.mm.ui.y.gt(this.context).inflate(i.g.base_slide_del_view, null);
      paramView = com.tencent.mm.ui.y.gt(this.context).inflate(i.g.sns_msg_item, null);
      locala = new SnsMsgUI.a.a(this);
      locala.paw = ((ImageView)paramView.findViewById(i.f.sns_msg_avatar_iv));
      locala.mYa = ((TextView)paramView.findViewById(i.f.sns_msg_nick_tv));
      locala.paz = ((TextView)paramView.findViewById(i.f.sns_msg_content_tv));
      locala.pay = ((ImageView)paramView.findViewById(i.f.sns_msg_lucky_icon));
      locala.igx = ((TextView)paramView.findViewById(i.f.sns_msg_time_tv));
      locala.paA = ((MMImageView)paramView.findViewById(i.f.sns_msg_iv));
      locala.pax = ((TextView)paramView.findViewById(i.f.sns_msg_tv));
      locala.paA.setOnClickListener(SnsMsgUI.q(this.paq));
      locala.hZl = ((MMSlideDelView)localObject1).findViewById(i.f.slide_del_del_view);
      locala.hZm = ((TextView)((MMSlideDelView)localObject1).findViewById(i.f.slide_del_view_del_word));
      locala.paB = ((ImageView)paramView.findViewById(i.f.sns_sight_icon));
      ((MMSlideDelView)localObject1).setView(paramView);
      ((MMSlideDelView)localObject1).setPerformItemClickListener(this.hZd);
      ((MMSlideDelView)localObject1).setGetViewPositionCallback(this.hZe);
      ((MMSlideDelView)localObject1).setItemStatusCallBack(this.hZg);
      ((MMSlideDelView)localObject1).setEnable(false);
      ((View)localObject1).setTag(locala);
      locala.paA.setTag(null);
      locala.eAA = localj.field_snsID;
      locala.hZl.setTag(Integer.valueOf(localj.oLo));
      locala.hZl.setOnClickListener(new SnsMsgUI.a.2(this));
    }
    Object localObject2;
    label392:
    label439:
    Object localObject3;
    for (;;)
    {
      try
      {
        localObject2 = (bsx)new bsx().aH(localj.field_curActionBuf);
      }
      catch (Exception paramView)
      {
        long l;
        label695:
        label735:
        label992:
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.SnsMsgUI", paramView, "", new Object[0]);
        label816:
        label953:
        label977:
        continue;
        label1040:
        if (bk.bl(((bsx)localObject2).tJr)) {
          continue;
        }
        paramView = ((bsx)localObject2).tJr;
        continue;
        paramView = ((bsx)localObject2).tAY;
        continue;
        locala.mYa.setTextColor(this.paq.getResources().getColor(i.c.sns_link_color));
        continue;
      }
      try
      {
        paramViewGroup = ((bsx)new bsx().aH(localj.field_refActionBuf)).tAY;
      }
      catch (Exception paramView)
      {
        paramView = "";
      }
    }
    try
    {
      if ((!bk.bl(paramViewGroup)) && (!paramViewGroup.equals(af.bDl()))) {
        break label1040;
      }
      paramViewGroup = "";
      if (bk.bl(((bsx)localObject2).tAY)) {
        break label1096;
      }
      a.b.a(locala.paw, ((bsx)localObject2).tAY);
      paramView = ((bsx)localObject2).tAY;
      locala.paw.setOnClickListener(new SnsMsgUI.a.3(this, paramView));
      paramView = SnsMsgUI.r(this.paq).abl(((bsx)localObject2).tAY);
      if (paramView == null) {
        break label1124;
      }
      paramView = paramView.Bq();
      locala.mYa.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.paq, paramView, locala.mYa.getTextSize()));
      paramView = af.bDF().gt(localj.field_snsID);
      if ((paramView == null) || (paramView.field_type != 21)) {
        break label1153;
      }
      locala.mYa.setTextColor(this.paq.getResources().getColor(i.c.sns_lucky_item_gold));
      paramView = ((bsx)localObject2).tAY;
      localObject3 = locala.mYa;
      j = ((bsx)localObject2).swS;
      switch (localj.field_type)
      {
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        label1096:
        label1124:
        paramView = paramViewGroup;
        label1153:
        label2516:
        label2531:
        label3044:
        continue;
        label2641:
        label2914:
        i = 1;
        label3033:
        label3038:
        break;
        break label816;
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
        break label695;
        break label735;
        continue;
        paramInt = 8;
      }
    }
    if ((i == 0) || (SnsMsgUI.s(this.paq).equals(paramView)))
    {
      ((TextView)localObject3).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      localObject3 = locala.paz;
      l = localj.field_snsID;
      if ((localj.field_commentflag & 0x1) <= 0) {
        break label3159;
      }
      i = 1;
      if (i != 0)
      {
        ((TextView)localObject3).setText(i.j.sns_msg_has_del);
        ((TextView)localObject3).setBackgroundColor(this.paq.getResources().getColor(i.c.comment_msg_del));
        ((TextView)localObject3).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        locala.igx.setText(ay.k(this.paq, ((bsx)localObject2).mPL * 1000L));
        paramView = null;
        if ((((bsx)localObject2).hQR != 7) && (((bsx)localObject2).hQR != 8) && (((bsx)localObject2).hQR != 16)) {
          break label2516;
        }
        paramViewGroup = af.bDI().gk(localj.field_snsID);
        if (paramViewGroup == null) {
          break label3062;
        }
        paramView = paramViewGroup.bGl();
        break label3062;
        locala.paA.setVisibility(8);
        locala.pax.setVisibility(8);
        locala.paB.setVisibility(8);
        locala.paA.setImageBitmap(null);
        af.bDC().cO(locala.paA);
        if (paramView == null) {
          break label2914;
        }
        paramViewGroup = paramView.bGe().tNr.sPJ;
        if (paramView.field_type != 2) {
          break label2531;
        }
        locala.paA.setTag(null);
        locala.pax.setVisibility(0);
        paramView = com.tencent.mm.pluginsdk.ui.d.j.a(this.paq, paramView.bGe().tNo, locala.pax.getTextSize());
        locala.pax.setText(paramView);
        if ((locala.paA.getVisibility() != 0) && (locala.paB.getVisibility() != 0)) {
          break label3033;
        }
        paramInt = 1;
        paramView = ((View)localObject1).findViewById(i.f.sns_msg_media_parent);
        if (paramInt == 0) {
          break label3038;
        }
        paramInt = 0;
        paramView.setVisibility(paramInt);
        paramView = ((View)localObject1).findViewById(i.f.sns_silence_icon);
        if (localj.field_isSilence != 1) {
          break label3044;
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
            return localObject1;
            locala = (SnsMsgUI.a.a)paramView.getTag();
            localObject1 = paramView;
            break;
            localObject3 = SnsMsgUI.r(this.paq).abl(paramViewGroup);
            paramView = paramViewGroup;
            if (localObject3 != null)
            {
              paramView = paramViewGroup;
              if (!bk.bl(((com.tencent.mm.n.a)localObject3).Bq())) {
                paramView = ((com.tencent.mm.n.a)localObject3).Bq();
              }
            }
            paramViewGroup = paramView;
            break label392;
            paramViewGroup = paramView;
            break label392;
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
            break label439;
            paramView = com.tencent.mm.cb.a.g(this.context, i.e.personactivity_notice_stranger_searchicon);
            for (;;)
            {
              ((TextView)localObject3).setCompoundDrawablesWithIntrinsicBounds(null, null, paramView, null);
              break;
              paramView = com.tencent.mm.cb.a.g(this.context, i.e.personactivity_notice_stranger_shakeicon);
              continue;
              paramView = com.tencent.mm.cb.a.g(this.context, i.e.personactivity_notice_stranger_nearicon);
              continue;
              paramView = com.tencent.mm.cb.a.g(this.context, i.e.personactivity_notice_stranger_bottleicon);
              continue;
              paramView = com.tencent.mm.cb.a.g(this.context, i.e.personactivity_notice_stranger_codeicon);
            }
            ((TextView)localObject3).setTextColor(this.paq.getResources().getColor(i.c.black));
            ((TextView)localObject3).setBackgroundDrawable(null);
            ((TextView)localObject3).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            ((TextView)localObject3).setText("");
            ((TextView)localObject3).setCompoundDrawablePadding(0);
            e locale;
            switch (((bsx)localObject2).hQR)
            {
            case 1: 
            case 5: 
              paramViewGroup = af.bDF().gt(localj.field_snsID);
              if ((paramViewGroup != null) && (paramViewGroup.field_type == 7))
              {
                ((TextView)localObject3).setText(this.paq.getString(i.j.sns_like_background));
                break;
              }
              paramView = com.tencent.mm.cb.a.g(this.context, i.i.friendactivity_likeicon);
              if ((paramViewGroup != null) && (paramViewGroup.field_type == 21)) {
                paramView.setColorFilter(this.paq.getResources().getColor(i.c.sns_lucky_msg_color), PorterDuff.Mode.SRC_ATOP);
              }
              for (;;)
              {
                paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
                paramViewGroup = new SpannableString(" ");
                paramViewGroup.setSpan(new ImageSpan(paramView), 0, 1, 18);
                ((TextView)localObject3).setText(paramViewGroup);
                ((TextView)localObject3).setContentDescription(this.paq.mController.uMN.getString(i.j.sns_friend_like));
                break;
                paramView.clearColorFilter();
              }
            case 2: 
            case 3: 
              localObject4 = ((bsx)localObject2).kVs;
              paramView = "";
              locale = af.bDI().gk(localj.field_snsID);
              if (((bsx)localObject2).tJz == 1) {
                if (locale != null)
                {
                  com.tencent.mm.kernel.g.DQ();
                  paramView = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abj(locale.field_userName);
                  paramView = this.context.getString(i.j.sns_msgui_at, new Object[] { paramView.Bq() });
                }
              }
              for (;;)
              {
                paramView = paramView + (String)localObject4 + " ";
                ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.paq, paramView, ((TextView)localObject3).getTextSize()));
                break;
                if (!bk.bl(paramViewGroup)) {
                  paramView = this.context.getString(i.j.sns_msgui_reply, new Object[] { paramViewGroup });
                }
              }
            case 7: 
              ((TextView)localObject3).setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.cb.a.g(this.context, i.i.friendactivity_likeicon), null, null, null);
              ((TextView)localObject3).setContentDescription(this.paq.mController.uMN.getString(i.j.sns_friend_like));
              break;
            case 8: 
              paramView = "";
              localObject4 = bk.pm(((bsx)localObject2).kVs);
              locale = af.bDI().gk(localj.field_snsID);
              if (((bsx)localObject2).tJz == 1) {
                if (locale != null)
                {
                  com.tencent.mm.kernel.g.DQ();
                  paramView = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abj(locale.field_userName);
                  paramView = this.context.getString(i.j.sns_msgui_at, new Object[] { paramView.Bq() });
                }
              }
              for (;;)
              {
                paramView = paramView + (String)localObject4 + " ";
                ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.paq, paramView, ((TextView)localObject3).getTextSize()));
                break;
                if (!bk.bl(paramViewGroup)) {
                  paramView = this.context.getString(i.j.sns_msgui_reply, new Object[] { paramViewGroup });
                }
              }
            case 4: 
              ((TextView)localObject3).setText(this.paq.getString(i.j.sns_timeline_ui_with_you));
              break;
            case 16: 
              paramView = "" + "[" + this.paq.getString(i.j.sns_ad_comment_at_tip) + "]";
              paramView = paramView + " " + bk.pm(((bsx)localObject2).kVs);
              ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.paq, paramView, ((TextView)localObject3).getTextSize()));
              break;
            case 14: 
              paramView = new aoz();
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + ((bsx)localObject2).tJy);
              try
              {
                paramView.aH(aa.a(((bsx)localObject2).tJy));
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsMsgUI", "hbbuffer  " + paramView.ceq);
                paramViewGroup = SnsMsgUI.r(this.paq).abl(((bsx)localObject2).tAY);
                ((TextView)localObject3).setText(this.paq.getString(i.j.luck_grab_sns_action_msg, new Object[] { paramViewGroup.Bq(), bk.A(paramView.ceq / 100.0D) }));
              }
              catch (Exception paramViewGroup)
              {
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + paramViewGroup.getMessage());
                }
              }
            }
          }
          paramViewGroup = new aoz();
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + ((bsx)localObject2).tJy);
          try
          {
            paramViewGroup.aH(aa.a(((bsx)localObject2).tJy));
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsMsgUI", "hbbuffer  " + paramViewGroup.ceq);
            SnsMsgUI.r(this.paq).abl(((bsx)localObject2).tAY);
            paramView = null;
            if (paramViewGroup.ceq == 0L)
            {
              SnsMsgUI.b(this.paq, true);
              paramViewGroup = new SpannableString(this.paq.getString(i.j.luck_sns_action_prize_msg));
              if (paramView != null)
              {
                paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
                localObject4 = new com.tencent.mm.ui.widget.a(paramView);
                ((com.tencent.mm.ui.widget.a)localObject4).wjc = ((int)((paramView.getIntrinsicHeight() - ((TextView)localObject3).getTextSize() + com.tencent.mm.cb.a.fromDPToPix(this.paq, 2)) / 2.0F));
                paramViewGroup.setSpan(localObject4, 0, 1, 33);
              }
              ((TextView)localObject3).setText(paramViewGroup);
            }
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + paramView.getMessage());
              continue;
              SnsMsgUI.b(this.paq, false);
              paramViewGroup = new SpannableString(" " + this.paq.getString(i.j.luck_sns_action_msg, new Object[] { bk.A(paramViewGroup.ceq / 100.0D) }));
              paramView = this.paq.getResources().getDrawable(i.e.album_push_lucky_money_icon_drawable);
            }
          }
        }
        paramView = af.bDF().gt(localj.field_snsID);
        break label816;
        i = 0;
        if (paramViewGroup.size() > 0)
        {
          j = paramView.field_type;
          localObject2 = locala.paA;
          i = -1;
        }
        switch (j)
        {
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
          i = i.i.app_attach_file_icon_webpage;
          af.bDC().a((awd)paramViewGroup.get(0), locala.paA, i, this.paq.hashCode(), az.uBI);
          if ((paramView.field_type == 15) || ((paramView.field_type == 27) && (paramViewGroup.size() > 0) && (((awd)paramViewGroup.get(0)).hQR == 6)))
          {
            locala.paB.setVisibility(0);
            paramView = new com.tencent.mm.plugin.sns.storage.j();
            af.bDK().b(localj.ujK, paramView);
            locala.paA.setTag(paramView);
          }
        case 4: 
        case 5: 
        case 15: 
        case 3: 
        case 6: 
        case 1: 
        case 7: 
        case 2: 
        case 8: 
          for (i = 1;; i = 1)
          {
            paramView = locala.paA;
            if (i == 0) {
              break label3171;
            }
            paramInt = 0;
            paramView.setVisibility(paramInt);
            break;
            i = i.i.app_attach_file_icon_music;
            break label2641;
            i = i.i.app_attach_file_icon_video;
            break label2641;
            i = i.i.app_attach_file_icon_webpage;
            break label2641;
            i = i.i.app_attach_file_icon_location;
            break label2641;
            i = i.e.app_attach_file_icon_pic;
            break label2641;
            i = i.e.app_attach_file_icon_pic;
            break label2641;
            ((MMImageView)localObject2).setImageDrawable(null);
            break label2641;
            ((MMImageView)localObject2).setImageDrawable(null);
            break label2641;
            paramViewGroup = new ao();
            paramViewGroup.bMB = paramView.bGE();
            paramViewGroup.index = 0;
            paramView = new ArrayList();
            paramView.add(locala.paA);
            paramViewGroup.oYz = paramView;
            paramViewGroup.position = paramInt;
            locala.paA.setTag(paramViewGroup);
          }
          if ((((bsx)localObject2).hQR == 7) || (((bsx)localObject2).hQR == 8)) {
            break label953;
          }
          if (((bsx)localObject2).hQR == 16)
          {
            if (!m.fT(localj.field_snsID)) {
              break label953;
            }
            paramView = new m(localj.field_snsID, ((bsx)localObject2).swb);
            com.tencent.mm.kernel.g.DQ();
            com.tencent.mm.kernel.g.DO().dJT.a(paramView, 0);
            break label953;
          }
          if (!q.fW(localj.field_snsID)) {
            break label953;
          }
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DO().dJT.a(new q(localj.field_snsID), 0);
          break label953;
          paramInt = 0;
          break label977;
          paramInt = 8;
          break label992;
        }
      }
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.hZe = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.hZd = paramg;
  }
  
  public final void yc()
  {
    if ((af.bDK().aAo() > 0) && (!SnsMsgUI.p(this.paq))) {
      setCursor(af.bDK().bGp());
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.dsw = af.bDK().bGq();
      k localk = af.bDK();
      int i = this.iwi;
      String str = k.bGo() + " where isSend = 0 order by createTime desc LIMIT " + i;
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.SnsCommentStorage", "getCursor sql:" + str);
      setCursor(localk.dXo.a(str, null, 0));
    }
  }
  
  protected final void yd()
  {
    bcS();
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.a
 * JD-Core Version:    0.7.0.1
 */