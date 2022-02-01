package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
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
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.view.NinePatchCropImageView;
import com.tencent.mm.view.e.b;
import java.util.List;

public final class s
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
    
    public final a P(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(163338);
      super.create(paramView);
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(R.h.chatting_click_area);
      Object localObject = paramView.getContext();
      Point localPoint = ax.au((Context)localObject);
      int i = Math.min(localPoint.x, localPoint.y);
      float f = ((Context)localObject).getResources().getDimension(R.f.Edge_1_5_A);
      this.width = ((int)((i - f) / 2.0F));
      Log.i("ChattingItemAppMsgFinderFeed", "real widthPixels:" + i + " ,dp:" + f + " , width:" + this.width);
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
      if (!((ak)h.ag(ak.class)).showFinderEntry())
      {
        i = 1;
        if (i == 0)
        {
          this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
          this.maskView = paramView.findViewById(R.h.dyD);
        }
        this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
        if (!paramBoolean) {
          break label462;
        }
        this.tickIV = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
        if ((this.finderThumb instanceof NinePatchCropImageView)) {
          ((NinePatchCropImageView)this.finderThumb).setNinePatchId(R.g.chatto_finder_image_bg);
        }
        label384:
        paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Integer)com.tencent.mm.plugin.finder.storage.d.dXV().aSr()).intValue() != 0) {
          break label504;
        }
        this.KDi.kg(R.e.White, R.e.BW_100_Alpha_0_3);
      }
      for (;;)
      {
        this.finderIcon.setImageDrawable(au.o(this.finderIcon.getContext(), R.k.icons_outlined_finder_icon, com.tencent.mm.ci.a.w(this.finderIcon.getContext(), R.e.Orange)));
        AppMethodBeat.o(163338);
        return this;
        i = 0;
        break;
        label462:
        if (this.uploadingPB != null) {
          this.uploadingPB.setVisibility(8);
        }
        if (!(this.finderThumb instanceof NinePatchCropImageView)) {
          break label384;
        }
        ((NinePatchCropImageView)this.finderThumb).setNinePatchId(R.g.chatfrom_finder_image_bg);
        break label384;
        label504:
        this.KDi.kg(R.e.Orange_100, R.e.BW_90);
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
      AppMethodBeat.i(163339);
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
        ((View)localObject).setTag(new s.a().P((View)localObject, false));
        AppMethodBeat.o(163339);
        return localObject;
      }
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, final String paramString)
    {
      AppMethodBeat.i(163340);
      this.WBq = parama1;
      s.a locala = (s.a)parama;
      locala.detailLayout.animate().cancel();
      locala.detailLayout.setTag(Long.valueOf(System.currentTimeMillis()));
      parama = paramca.field_content;
      if (parama != null) {}
      for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
      {
        if (parama != null)
        {
          parama = (com.tencent.mm.plugin.findersdk.a.f)parama.ar(com.tencent.mm.plugin.findersdk.a.f.class);
          if (parama != null)
          {
            com.tencent.mm.view.f.a(locala.convertView, new e.b()
            {
              public final long er(View paramAnonymousView)
              {
                AppMethodBeat.i(288843);
                long l1 = paramca.field_msgId;
                long l2 = paramAnonymousView.hashCode();
                AppMethodBeat.o(288843);
                return l1 + l2;
              }
              
              public final void p(View paramAnonymousView, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(288842);
                if (paramAnonymousBoolean)
                {
                  paramAnonymousView = paramString;
                  paramAnonymousBoolean = ab.Lj(paramca.field_talker);
                  if (!paramAnonymousBoolean) {
                    break label94;
                  }
                  paramAnonymousView = paramAnonymousView + "-" + paramca.field_talker;
                }
                label94:
                for (;;)
                {
                  if (paramAnonymousBoolean) {}
                  for (int i = 2;; i = 1)
                  {
                    com.tencent.mm.plugin.finder.report.f.zUP.y(i, paramAnonymousView, parama.mbi.objectId);
                    AppMethodBeat.o(288842);
                    return;
                  }
                }
              }
            });
            paramString = t.ztT;
            paramString = t.dJh();
            Object localObject1 = new x(parama.mbi.avatar, u.Alz);
            Object localObject2 = locala.finderAvatar;
            t localt = t.ztT;
            paramString.a(localObject1, (ImageView)localObject2, t.a(t.a.zua));
            locala.finderNickname.setText(l.c(parama1.WQv.getContext(), parama.mbi.nickname));
            ar.a(locala.finderNickname.getPaint(), 0.8F);
            paramString = parama.mbi.mediaList;
            if (!paramString.isEmpty())
            {
              localObject2 = (bjc)paramString.get(0);
              localObject1 = ((bjc)localObject2).STn;
              localObject2 = ((bjc)localObject2).thumbUrl;
              ((ak)h.ag(ak.class)).loadImage((String)localObject2, locala.finderThumb);
              if (!Util.isNullOrNil((String)localObject1)) {
                ((ak)h.ag(ak.class)).loadImage((String)localObject1, null);
              }
              s.a(locala, paramString);
            }
            if (parama.mbi.ACQ != 1) {
              break label440;
            }
            locala.finderDesc.setVisibility(8);
            locala.finderThumb.setVisibility(8);
            locala.finderText.setText(l.c(parama1.WQv.getContext(), parama.mbi.desc));
            locala.finderText.setVisibility(0);
          }
        }
        for (;;)
        {
          locala.clickArea.setOnClickListener(d(parama1));
          locala.clickArea.setOnLongClickListener(c(parama1));
          locala.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
          parama = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
          locala.clickArea.setTag(parama);
          AppMethodBeat.o(163340);
          return;
          label440:
          if (!Util.isNullOrNil(parama.mbi.desc))
          {
            locala.finderDesc.setText(l.c(parama1.WQv.getContext(), parama.mbi.desc));
            locala.finderDesc.setVisibility(0);
          }
          for (;;)
          {
            locala.finderThumb.setVisibility(0);
            locala.finderText.setVisibility(8);
            if ((parama.mbi.ACQ != 4) && (parama.mbi.ACQ != 6)) {
              break label564;
            }
            locala.Xgn.setVisibility(0);
            locala.KDi.setVisibility(8);
            break;
            locala.finderDesc.setVisibility(8);
          }
          label564:
          if (parama.mbi.ACQ == 2)
          {
            locala.Xgn.setVisibility(8);
            locala.KDi.setVisibility(0);
            locala.KDi.Lsg = paramString.size();
          }
          else
          {
            locala.Xgn.setVisibility(8);
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(163342);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163342);
        return false;
      }
      if (!WeChatBrands.Business.Entries.SessionChannels.checkAvailable(parama.WQv.getContext()))
      {
        AppMethodBeat.o(163342);
        return true;
      }
      s.c(parama.WQv.getContext(), paramca);
      AppMethodBeat.o(163342);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(278312);
      int j = ((by)paramView.getTag()).position;
      if (!((ak)h.ag(ak.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((paramca != null) && (com.tencent.mm.by.c.blP("favorite")) && (i == 0))
        {
          paramo.a(j, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
          paramo.a(j, 116, this.WBq.WQv.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
        }
        AppMethodBeat.o(278312);
        return true;
      }
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 754974769);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(163343);
      if (!WeChatBrands.Business.Entries.SessionChannels.checkAvailable(paramView.getContext()))
      {
        AppMethodBeat.o(163343);
        return true;
      }
      Object localObject2 = paramca.field_content;
      Object localObject1 = null;
      if (localObject2 != null) {
        localObject1 = k.b.aG((String)localObject2, paramca.field_reserved);
      }
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.plugin.findersdk.a.f)((k.b)localObject1).ar(com.tencent.mm.plugin.findersdk.a.f.class);
        if (localObject1 != null)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("feed_object_id", com.tencent.mm.ae.d.Nb(((com.tencent.mm.plugin.findersdk.a.f)localObject1).mbi.objectId));
          ((Intent)localObject2).putExtra("feed_object_nonceId", ((com.tencent.mm.plugin.findersdk.a.f)localObject1).mbi.objectNonceId);
          ((Intent)localObject2).putExtra("business_type", 0);
          ((Intent)localObject2).putExtra("finder_user_name", ((com.tencent.mm.plugin.findersdk.a.f)localObject1).mbi.username);
          if (!ab.Lj(paramca.field_talker)) {
            break label252;
          }
          ((Intent)localObject2).putExtra("report_scene", 2);
        }
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("from_user", paramca.field_talker);
        aj localaj = aj.AGc;
        ((Intent)localObject2).putExtra("key_from_user_name", aj.aG(paramca));
        localaj = aj.AGc;
        ((Intent)localObject2).putExtra("key_to_user_name", aj.aH(paramca));
        ((Intent)localObject2).putExtra("tab_type", 6);
        s.a(paramView, parama, (com.tencent.mm.plugin.findersdk.a.f)localObject1, (Intent)localObject2, false, ab.Lj(paramca.field_talker));
        AppMethodBeat.o(163343);
        return false;
        label252:
        ((Intent)localObject2).putExtra("report_scene", 1);
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
      AppMethodBeat.i(163344);
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
        ((View)localObject).setTag(new s.a().P((View)localObject, true));
        AppMethodBeat.o(163344);
        return localObject;
      }
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, final String paramString)
    {
      AppMethodBeat.i(163345);
      this.WBq = parama1;
      s.a locala = (s.a)parama;
      locala.detailLayout.animate().cancel();
      locala.detailLayout.setTag(Long.valueOf(System.currentTimeMillis()));
      Object localObject1 = paramca.field_content;
      parama = null;
      if (localObject1 != null) {
        parama = k.b.aG((String)localObject1, paramca.field_reserved);
      }
      if (parama != null)
      {
        parama = (com.tencent.mm.plugin.findersdk.a.f)parama.ar(com.tencent.mm.plugin.findersdk.a.f.class);
        com.tencent.mm.view.f.a(locala.convertView, new e.b()
        {
          public final long er(View paramAnonymousView)
          {
            AppMethodBeat.i(280211);
            long l1 = paramca.field_msgId;
            long l2 = paramAnonymousView.hashCode();
            AppMethodBeat.o(280211);
            return l1 + l2;
          }
          
          public final void p(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(280210);
            if (paramAnonymousBoolean)
            {
              paramAnonymousView = paramString;
              paramAnonymousBoolean = ab.Lj(paramca.field_talker);
              if (!paramAnonymousBoolean) {
                break label94;
              }
              paramAnonymousView = paramAnonymousView + "-" + paramca.field_talker;
            }
            label94:
            for (;;)
            {
              if (paramAnonymousBoolean) {}
              for (int i = 2;; i = 1)
              {
                com.tencent.mm.plugin.finder.report.f.zUP.y(i, paramAnonymousView, parama.mbi.objectId);
                AppMethodBeat.o(280210);
                return;
              }
            }
          }
        });
        if (parama != null)
        {
          paramString = t.ztT;
          paramString = t.dJh();
          localObject1 = new x(parama.mbi.avatar, u.Alz);
          Object localObject2 = locala.finderAvatar;
          t localt = t.ztT;
          paramString.a(localObject1, (ImageView)localObject2, t.a(t.a.zua));
          locala.finderNickname.setText(l.c(parama1.WQv.getContext(), parama.mbi.nickname));
          ar.a(locala.finderNickname.getPaint(), 0.8F);
          paramString = parama.mbi.mediaList;
          if (!paramString.isEmpty())
          {
            localObject2 = (bjc)paramString.get(0);
            localObject1 = ((bjc)localObject2).STn;
            localObject2 = ((bjc)localObject2).thumbUrl;
            ((ak)h.ag(ak.class)).loadImage((String)localObject2, locala.finderThumb);
            if (!Util.isNullOrNil((String)localObject1)) {
              ((ak)h.ag(ak.class)).loadImage((String)localObject1, null);
            }
            s.a(locala, paramString);
          }
          if (parama.mbi.ACQ == 1)
          {
            locala.finderDesc.setVisibility(8);
            locala.finderThumb.setVisibility(8);
            locala.finderText.setText(l.c(parama1.WQv.getContext(), parama.mbi.desc));
            locala.finderText.setVisibility(0);
          }
        }
        else
        {
          locala.clickArea.setOnClickListener(d(parama1));
          locala.clickArea.setOnLongClickListener(c(parama1));
          locala.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
          parama = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
          locala.clickArea.setTag(parama);
        }
      }
      else
      {
        if (!hTG()) {
          break label741;
        }
        if (locala.uploadingPB != null) {
          locala.uploadingPB.setVisibility(8);
        }
        if ((paramca.field_status != 2) || (!b((k)parama1.bC(k.class), paramca.field_msgId))) {
          break label720;
        }
        if (locala.tickIV != null) {
          locala.tickIV.setVisibility(0);
        }
      }
      for (;;)
      {
        a(paramInt, locala, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
        AppMethodBeat.o(163345);
        return;
        if (!Util.isNullOrNil(parama.mbi.desc))
        {
          locala.finderDesc.setText(l.c(parama1.WQv.getContext(), parama.mbi.desc));
          locala.finderDesc.setVisibility(0);
        }
        for (;;)
        {
          locala.finderThumb.setVisibility(0);
          locala.finderText.setVisibility(8);
          if ((parama.mbi.ACQ != 4) && (parama.mbi.ACQ != 6)) {
            break label659;
          }
          locala.Xgn.setVisibility(0);
          locala.KDi.setVisibility(8);
          break;
          locala.finderDesc.setVisibility(8);
        }
        label659:
        if (parama.mbi.ACQ == 2)
        {
          locala.Xgn.setVisibility(8);
          locala.KDi.setVisibility(0);
          locala.KDi.Lsg = paramString.size();
          break;
        }
        locala.Xgn.setVisibility(8);
        break;
        label720:
        if (locala.tickIV != null) {
          locala.tickIV.setVisibility(8);
        }
      }
      label741:
      if (locala.tickIV != null) {
        locala.tickIV.setVisibility(8);
      }
      if (paramca.field_status < 2) {}
      for (boolean bool = true;; bool = false)
      {
        b(locala, bool);
        break;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(163348);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163348);
        return false;
      }
      s.c(parama.WQv.getContext(), paramca);
      AppMethodBeat.o(163348);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(284794);
      int j = ((by)paramView.getTag()).position;
      if (!((ak)h.ag(ak.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((paramca != null) && (i == 0))
        {
          paramo.a(j, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
          if (com.tencent.mm.by.c.blP("favorite")) {
            paramo.a(j, 116, this.WBq.WQv.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
          }
          if (((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker)) && (!as.OS(this.WBq.getTalkerUserName()))) {
            paramo.a(j, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
          }
        }
        AppMethodBeat.o(284794);
        return true;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(284791);
      if (paramca.erk())
      {
        m.bh(paramca);
        bq.Gk(paramca.field_msgId);
        parama.Gi(true);
      }
      AppMethodBeat.o(284791);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 754974769);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(163349);
      Object localObject2 = paramca.field_content;
      Object localObject1 = null;
      if (localObject2 != null) {
        localObject1 = k.b.aG((String)localObject2, paramca.field_reserved);
      }
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.plugin.findersdk.a.f)((k.b)localObject1).ar(com.tencent.mm.plugin.findersdk.a.f.class);
        if (localObject1 != null)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("feed_object_id", com.tencent.mm.ae.d.Nb(((com.tencent.mm.plugin.findersdk.a.f)localObject1).mbi.objectId));
          ((Intent)localObject2).putExtra("feed_object_nonceId", ((com.tencent.mm.plugin.findersdk.a.f)localObject1).mbi.objectNonceId);
          ((Intent)localObject2).putExtra("business_type", 0);
          ((Intent)localObject2).putExtra("finder_user_name", ((com.tencent.mm.plugin.findersdk.a.f)localObject1).mbi.username);
          if (!ab.Lj(paramca.field_talker)) {
            break label231;
          }
          ((Intent)localObject2).putExtra("report_scene", 2);
        }
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("from_user", paramca.field_talker);
        aj localaj = aj.AGc;
        ((Intent)localObject2).putExtra("key_from_user_name", aj.aG(paramca));
        localaj = aj.AGc;
        ((Intent)localObject2).putExtra("key_to_user_name", aj.aH(paramca));
        ((Intent)localObject2).putExtra("tab_type", 6);
        s.a(paramView, parama, (com.tencent.mm.plugin.findersdk.a.f)localObject1, (Intent)localObject2, true, ab.Lj(paramca.field_talker));
        AppMethodBeat.o(163349);
        return false;
        label231:
        ((Intent)localObject2).putExtra("report_scene", 1);
      }
    }
    
    public final boolean hTD()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.s
 * JD-Core Version:    0.7.0.1
 */