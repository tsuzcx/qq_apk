package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.i;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.view.NinePatchCropImageView;
import java.util.List;

public final class ac
{
  static final class a
    extends c.a
  {
    public ImageIndicatorView KDi;
    public ImageView Xgn;
    public View detailLayout;
    public ImageView finderAvatar;
    public TextView finderDesc;
    public ImageView finderIcon;
    public TextView finderNickname;
    public TextView finderText;
    public ImageView finderThumb;
    public ImageView tickIV;
    public int width;
    
    public final a U(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(272660);
      super.create(paramView);
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(R.h.chatting_click_area);
      Object localObject = paramView.getContext();
      this.width = ((int)((((Context)localObject).getResources().getDisplayMetrics().widthPixels - ((Context)localObject).getResources().getDimension(R.f.Edge_1_5_A)) / 2.0F));
      localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = this.width;
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.finderAvatar = ((ImageView)paramView.findViewById(R.h.dxY));
      this.finderNickname = ((TextView)paramView.findViewById(R.h.dye));
      this.finderThumb = ((ImageView)paramView.findViewById(R.h.dyi));
      this.finderDesc = ((TextView)paramView.findViewById(R.h.dxZ));
      this.finderText = ((TextView)paramView.findViewById(R.h.dyh));
      this.finderIcon = ((ImageView)paramView.findViewById(R.h.dya));
      this.Xgn = ((ImageView)paramView.findViewById(R.h.dyd));
      this.KDi = ((ImageIndicatorView)paramView.findViewById(R.h.dyc));
      this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      this.detailLayout = paramView.findViewById(R.h.dwR);
      int i;
      if (!((ak)h.ag(ak.class)).showFinderEntry())
      {
        i = 1;
        if (i == 0)
        {
          this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
          this.maskView = paramView.findViewById(R.h.dyD);
        }
        if (!paramBoolean) {
          break label369;
        }
        this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
        this.tickIV = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
        if ((this.finderThumb instanceof NinePatchCropImageView)) {
          ((NinePatchCropImageView)this.finderThumb).setNinePatchId(R.g.chatto_finder_image_bg);
        }
      }
      for (;;)
      {
        this.finderIcon.setImageDrawable(au.o(this.finderIcon.getContext(), R.k.icons_outlined_finder_icon, com.tencent.mm.ci.a.w(this.finderIcon.getContext(), R.e.Orange)));
        AppMethodBeat.o(272660);
        return this;
        i = 0;
        break;
        label369:
        if ((this.finderThumb instanceof NinePatchCropImageView)) {
          ((NinePatchCropImageView)this.finderThumb).setNinePatchId(R.g.chatfrom_finder_image_bg);
        }
      }
    }
    
    public final View getMainContainerView()
    {
      return this.detailLayout;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(277649);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Integer)com.tencent.mm.plugin.finder.storage.d.dXV().aSr()).intValue() != 0) {
          break label79;
        }
      }
      label79:
      for (int i = R.i.ecP;; i = R.i.ecQ)
      {
        localObject = new aq(paramLayoutInflater, i);
        ((View)localObject).setTag(new ac.a().U((View)localObject, false));
        AppMethodBeat.o(277649);
        return localObject;
      }
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(277652);
      this.WBq = parama1;
      paramString = (ac.a)parama;
      paramString.detailLayout.animate().cancel();
      paramString.detailLayout.setTag(Long.valueOf(System.currentTimeMillis()));
      parama = paramca.field_content;
      if (parama != null) {}
      for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
      {
        Object localObject;
        if (parama != null)
        {
          parama = (i)parama.ar(i.class);
          if (parama != null)
          {
            localObject = t.ztT;
            localObject = t.dJh();
            x localx = new x(parama.mbk.avatar, u.Alz);
            ImageView localImageView = paramString.finderAvatar;
            t localt = t.ztT;
            ((com.tencent.mm.loader.d)localObject).a(localx, localImageView, t.a(t.a.zua));
            paramString.finderNickname.setText(l.c(parama1.WQv.getContext(), parama.mbk.nickname));
            ar.a(paramString.finderNickname.getPaint(), 0.8F);
            localObject = parama.mbk.mediaList;
            if (!((List)localObject).isEmpty())
            {
              if (Util.isNullOrNil(((cww)((List)localObject).get(0)).coverUrl)) {
                break label420;
              }
              ((ak)h.ag(ak.class)).loadImage(((cww)((List)localObject).get(0)).coverUrl, paramString.finderThumb);
              ac.a(paramString, (List)localObject);
            }
            if (Util.isNullOrNil(parama.mbk.desc)) {
              break label455;
            }
            paramString.finderDesc.setText(l.c(parama1.WQv.getContext(), parama.mbk.desc));
            paramString.finderDesc.setVisibility(0);
          }
        }
        for (;;)
        {
          paramString.finderThumb.setVisibility(0);
          paramString.finderText.setVisibility(8);
          paramString.Xgn.setVisibility(0);
          paramString.KDi.setVisibility(8);
          paramString.clickArea.setOnClickListener(d(parama1));
          paramString.clickArea.setOnLongClickListener(c(parama1));
          paramString.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
          parama = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
          paramString.clickArea.setTag(parama);
          AppMethodBeat.o(277652);
          return;
          label420:
          ((ak)h.ag(ak.class)).loadImage(((cww)((List)localObject).get(0)).thumbUrl, paramString.finderThumb);
          break;
          label455:
          paramString.finderDesc.setVisibility(8);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(277656);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(277656);
        return false;
      }
      ac.c(parama.WQv.getContext(), paramca);
      AppMethodBeat.o(277656);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(277654);
      int j = ((by)paramView.getTag()).position;
      if (!((ak)h.ag(ak.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((paramca != null) && (com.tencent.mm.by.c.blP("favorite")) && (i == 0)) {
          paramo.a(j, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        AppMethodBeat.o(277654);
        return true;
      }
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 1023410225);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(277658);
      Object localObject2 = paramca.field_content;
      Object localObject1 = null;
      if (localObject2 != null) {
        localObject1 = k.b.aG((String)localObject2, paramca.field_reserved);
      }
      if (localObject1 != null)
      {
        localObject1 = (i)((k.b)localObject1).ar(i.class);
        if (localObject1 != null)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("feed_object_id", com.tencent.mm.ae.d.Nb(((i)localObject1).mbk.objectId));
          ((Intent)localObject2).putExtra("feed_object_nonceId", ((i)localObject1).mbk.objectNonceId);
          ((Intent)localObject2).putExtra("business_type", 1);
          ((Intent)localObject2).putExtra("finder_user_name", ((i)localObject1).mbk.username);
          if (!ab.Lj(paramca.field_talker)) {
            break label285;
          }
          ((Intent)localObject2).putExtra("report_scene", 2);
          ((Intent)localObject2).putExtra("key_finder_teen_mode_scene", 2);
        }
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("key_finder_teen_mode_check", true);
        ((Intent)localObject2).putExtra("key_finder_teen_mode_user_name", ((i)localObject1).mbk.nickname);
        ((Intent)localObject2).putExtra("key_finder_teen_mode_user_id", ((i)localObject1).mbk.username);
        ((Intent)localObject2).putExtra("from_user", paramca.field_talker);
        aj localaj = aj.AGc;
        ((Intent)localObject2).putExtra("key_from_user_name", aj.aG(paramca));
        localaj = aj.AGc;
        ((Intent)localObject2).putExtra("key_to_user_name", aj.aH(paramca));
        ((Intent)localObject2).putExtra("tab_type", 6);
        ac.a(paramView, parama, (i)localObject1, (Intent)localObject2, false, ab.Lj(paramca.field_talker));
        AppMethodBeat.o(277658);
        return false;
        label285:
        ((Intent)localObject2).putExtra("report_scene", 1);
        ((Intent)localObject2).putExtra("key_finder_teen_mode_scene", 1);
      }
    }
    
    public final boolean hTD()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(290441);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Integer)com.tencent.mm.plugin.finder.storage.d.dXV().aSr()).intValue() != 0) {
          break label79;
        }
      }
      label79:
      for (int i = R.i.edP;; i = R.i.edQ)
      {
        localObject = new aq(paramLayoutInflater, i);
        ((View)localObject).setTag(new ac.a().U((View)localObject, true));
        AppMethodBeat.o(290441);
        return localObject;
      }
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(290442);
      this.WBq = parama1;
      paramString = (ac.a)parama;
      paramString.detailLayout.animate().cancel();
      paramString.detailLayout.setTag(Long.valueOf(System.currentTimeMillis()));
      parama = paramca.field_content;
      if (parama != null) {}
      for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
      {
        Object localObject;
        if (parama != null)
        {
          parama = (i)parama.ar(i.class);
          if (parama != null)
          {
            localObject = t.ztT;
            localObject = t.dJh();
            x localx = new x(parama.mbk.avatar, u.Alz);
            ImageView localImageView = paramString.finderAvatar;
            t localt = t.ztT;
            ((com.tencent.mm.loader.d)localObject).a(localx, localImageView, t.a(t.a.zua));
            paramString.finderNickname.setText(l.c(parama1.WQv.getContext(), parama.mbk.nickname));
            ar.a(paramString.finderNickname.getPaint(), 0.8F);
            localObject = parama.mbk.mediaList;
            if (!((List)localObject).isEmpty())
            {
              if (!Util.isNullOrNil(((cww)((List)localObject).get(0)).coverUrl))
              {
                ((ak)h.ag(ak.class)).loadImage(((cww)((List)localObject).get(0)).coverUrl, paramString.finderThumb);
                ac.a(paramString, (List)localObject);
              }
            }
            else
            {
              if (Util.isNullOrNil(parama.mbk.desc)) {
                break label548;
              }
              paramString.finderDesc.setText(l.c(parama1.WQv.getContext(), parama.mbk.desc));
              paramString.finderDesc.setVisibility(0);
              label301:
              paramString.finderThumb.setVisibility(0);
              paramString.finderText.setVisibility(8);
              paramString.Xgn.setVisibility(0);
              paramString.KDi.setVisibility(8);
            }
          }
          else
          {
            paramString.clickArea.setOnClickListener(d(parama1));
            paramString.clickArea.setOnLongClickListener(c(parama1));
            paramString.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
            parama = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
            paramString.clickArea.setTag(parama);
          }
        }
        else
        {
          if (!hTG()) {
            break label582;
          }
          if (paramString.uploadingPB != null) {
            paramString.uploadingPB.setVisibility(8);
          }
          if ((paramca.field_status != 2) || (!b((k)parama1.bC(k.class), paramca.field_msgId))) {
            break label561;
          }
          if (paramString.tickIV != null) {
            paramString.tickIV.setVisibility(0);
          }
        }
        for (;;)
        {
          a(paramInt, paramString, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
          AppMethodBeat.o(290442);
          return;
          ((ak)h.ag(ak.class)).loadImage(((cww)((List)localObject).get(0)).thumbUrl, paramString.finderThumb);
          break;
          label548:
          paramString.finderDesc.setVisibility(8);
          break label301;
          label561:
          if (paramString.tickIV != null)
          {
            paramString.tickIV.setVisibility(8);
            continue;
            label582:
            if (paramString.uploadingPB != null) {
              paramString.uploadingPB.setVisibility(8);
            }
            if (paramString.tickIV != null) {
              paramString.tickIV.setVisibility(8);
            }
            if (paramca.field_status < 2) {
              bool = true;
            }
            b(paramString, bool);
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(290446);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(290446);
        return false;
      }
      ac.c(parama.WQv.getContext(), paramca);
      AppMethodBeat.o(290446);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(290445);
      int j = ((by)paramView.getTag()).position;
      if (!((ak)h.ag(ak.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((paramca != null) && (i == 0))
        {
          paramo.a(j, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
          com.tencent.mm.by.c.blP("favorite");
          if (((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker)) && (!as.OS(this.WBq.getTalkerUserName()))) {
            paramo.a(j, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
          }
        }
        AppMethodBeat.o(290445);
        return true;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(290444);
      if (paramca.erk())
      {
        m.bh(paramca);
        bq.Gk(paramca.field_msgId);
        parama.Gi(true);
      }
      AppMethodBeat.o(290444);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 1023410225);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(290447);
      Object localObject2 = paramca.field_content;
      Object localObject1 = null;
      if (localObject2 != null) {
        localObject1 = k.b.aG((String)localObject2, paramca.field_reserved);
      }
      if (localObject1 != null)
      {
        localObject1 = (i)((k.b)localObject1).ar(i.class);
        if (localObject1 != null)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("feed_object_id", com.tencent.mm.ae.d.Nb(((i)localObject1).mbk.objectId));
          ((Intent)localObject2).putExtra("feed_object_nonceId", ((i)localObject1).mbk.objectNonceId);
          ((Intent)localObject2).putExtra("business_type", 1);
          ((Intent)localObject2).putExtra("finder_user_name", ((i)localObject1).mbk.username);
          if (!ab.Lj(paramca.field_talker)) {
            break label285;
          }
          ((Intent)localObject2).putExtra("report_scene", 2);
          ((Intent)localObject2).putExtra("key_finder_teen_mode_scene", 2);
        }
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("key_finder_teen_mode_check", true);
        ((Intent)localObject2).putExtra("key_finder_teen_mode_user_name", ((i)localObject1).mbk.nickname);
        ((Intent)localObject2).putExtra("key_finder_teen_mode_user_id", ((i)localObject1).mbk.username);
        ((Intent)localObject2).putExtra("from_user", paramca.field_talker);
        aj localaj = aj.AGc;
        ((Intent)localObject2).putExtra("key_from_user_name", aj.aG(paramca));
        localaj = aj.AGc;
        ((Intent)localObject2).putExtra("key_to_user_name", aj.aH(paramca));
        ((Intent)localObject2).putExtra("tab_type", 6);
        ac.a(paramView, parama, (i)localObject1, (Intent)localObject2, true, ab.Lj(paramca.field_talker));
        AppMethodBeat.o(290447);
        return false;
        label285:
        ((Intent)localObject2).putExtra("report_scene", 1);
        ((Intent)localObject2).putExtra("key_finder_teen_mode_scene", 1);
      }
    }
    
    public final boolean hTD()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac
 * JD-Core Version:    0.7.0.1
 */