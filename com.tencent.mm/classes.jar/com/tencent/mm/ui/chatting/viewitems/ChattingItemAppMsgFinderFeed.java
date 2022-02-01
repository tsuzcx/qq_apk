package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.ContextMenu.ContextMenuInfo;
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
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.report.l;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.bq;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.view.NinePatchCropImageView;
import com.tencent.mm.view.e.b;
import java.util.List;

public final class ChattingItemAppMsgFinderFeed
{
  static final class a
    extends c.a
  {
    public ImageIndicatorView RcP;
    public ImageView aeQe;
    ImageView aeQf;
    LinearLayout bottomMask;
    public View detailLayout;
    public ImageView finderAvatar;
    public TextView finderDesc;
    public ImageView finderIcon;
    public TextView finderNickname;
    public TextView finderText;
    public ImageView finderThumb;
    public ImageView tickIV;
    public int width;
    
    public final a V(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(163338);
      super.create(paramView);
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(R.h.chatting_click_area);
      Object localObject = paramView.getContext();
      Point localPoint = bf.bf((Context)localObject);
      int i = Math.min(localPoint.x, localPoint.y);
      float f = ((Context)localObject).getResources().getDimension(R.f.Edge_1_5_A);
      this.width = ((int)((i - f) / 2.0F));
      Log.i("ChattingItemAppMsgFinderFeed", "real widthPixels:" + i + " ,dp:" + f + " , width:" + this.width);
      localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = this.width;
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.finderAvatar = ((ImageView)paramView.findViewById(R.h.fyI));
      this.finderNickname = ((TextView)paramView.findViewById(R.h.fyN));
      this.finderThumb = ((ImageView)paramView.findViewById(R.h.fyR));
      this.finderDesc = ((TextView)paramView.findViewById(R.h.fyK));
      this.finderText = ((TextView)paramView.findViewById(R.h.fyQ));
      this.finderIcon = ((ImageView)paramView.findViewById(R.h.chatting_item_finder_icon));
      this.aeQe = ((ImageView)paramView.findViewById(R.h.fyM));
      this.RcP = ((ImageIndicatorView)paramView.findViewById(R.h.chatting_item_finder_image_indicator));
      this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
      this.detailLayout = paramView.findViewById(R.h.fxi);
      this.aeQf = ((ImageView)paramView.findViewById(R.h.fyH));
      this.bottomMask = ((LinearLayout)paramView.findViewById(R.h.desc_layout));
      if (!((cn)h.az(cn.class)).showFinderEntry())
      {
        i = 1;
        if (i == 0)
        {
          this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
          this.maskView = paramView.findViewById(R.h.fzn);
        }
        this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
        if (!paramBoolean) {
          break label481;
        }
        this.tickIV = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
        if ((this.finderThumb instanceof NinePatchCropImageView)) {
          ((NinePatchCropImageView)this.finderThumb).setNinePatchId(R.g.chatto_finder_image_bg);
        }
      }
      for (;;)
      {
        paramView = this.RcP;
        i = R.e.White;
        paramView.RVk = R.e.BW_100_Alpha_0_3;
        paramView.ymh = i;
        this.finderIcon.setImageDrawable(bb.m(this.finderIcon.getContext(), R.k.icons_outlined_finder_icon, com.tencent.mm.cd.a.w(this.finderIcon.getContext(), R.e.Orange)));
        AppMethodBeat.o(163338);
        return this;
        i = 0;
        break;
        label481:
        if (this.uploadingPB != null) {
          this.uploadingPB.setVisibility(8);
        }
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
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
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
        localObject = new ap(paramLayoutInflater, R.i.gfF);
        ((View)localObject).setTag(new ChattingItemAppMsgFinderFeed.a().V((View)localObject, false));
      }
      AppMethodBeat.o(163339);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc, final String paramString)
    {
      AppMethodBeat.i(163340);
      this.aeiK = parama1;
      ChattingItemAppMsgFinderFeed.a locala = (ChattingItemAppMsgFinderFeed.a)parama;
      locala.detailLayout.animate().cancel();
      locala.detailLayout.setTag(Long.valueOf(System.currentTimeMillis()));
      Object localObject1 = paramcc.field_content;
      parama = null;
      if (localObject1 != null) {
        parama = com.tencent.mm.message.k.b.aP((String)localObject1, paramcc.field_reserved);
      }
      if (parama != null)
      {
        parama = (com.tencent.mm.plugin.findersdk.a.f)parama.aK(com.tencent.mm.plugin.findersdk.a.f.class);
        if (parama != null)
        {
          com.tencent.mm.view.f.a(locala.convertView, new e.b()
          {
            public final void a(View paramAnonymousView, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(254941);
              if (paramAnonymousBoolean)
              {
                paramAnonymousView = (bq)h.ax(bq.class);
                Object localObject = k.aeZF;
                localObject = ((bn)k.nq(parama1.aezO.getContext()).cq(bn.class)).fou();
                paramAnonymousView.a(com.tencent.mm.ae.d.FK(parama.oUc.objectId), parama.oUc.objectNonceId, 4, (bui)localObject, null, false, null);
                paramAnonymousView = paramString;
                paramAnonymousBoolean = au.bwE(paramcc.field_talker);
                if (!paramAnonymousBoolean) {
                  break label178;
                }
                paramAnonymousView = paramAnonymousView + "-" + paramcc.field_talker;
              }
              label178:
              for (;;)
              {
                if (paramAnonymousBoolean) {}
                for (int i = 2;; i = 1)
                {
                  l.Fpv.E(i, paramAnonymousView, parama.oUc.objectId);
                  AppMethodBeat.o(254941);
                  return;
                }
              }
            }
            
            public final long fq(View paramAnonymousView)
            {
              AppMethodBeat.i(254944);
              long l1 = paramcc.field_msgId;
              long l2 = paramAnonymousView.hashCode();
              AppMethodBeat.o(254944);
              return l1 + l2;
            }
          });
          paramString = com.tencent.mm.plugin.finder.loader.p.ExI;
          paramString = com.tencent.mm.plugin.finder.loader.p.eCp();
          localObject1 = new com.tencent.mm.plugin.finder.loader.s(parama.bCr(), v.FKZ);
          Object localObject2 = locala.finderAvatar;
          com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          paramString.a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExP));
          paramString = locala.finderNickname;
          localObject1 = parama1.aezO.getContext();
          localObject2 = av.GiL;
          paramString.setText(com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject1, av.aBN(parama.getNickname())));
          av.GiL.a(locala.aeQf, locala.finderNickname, parama.oUc, (int)locala.aeQf.getResources().getDimension(R.f.finder_2_25_A));
          aw.a(locala.finderNickname.getPaint(), 0.8F);
          paramString = parama.oUc.mediaList;
          if (!paramString.isEmpty())
          {
            localObject2 = (bvj)paramString.get(0);
            localObject1 = ((bvj)localObject2).HaI;
            localObject2 = ((bvj)localObject2).thumbUrl;
            ((cn)h.az(cn.class)).loadImage((String)localObject2, locala.finderThumb);
            if (!Util.isNullOrNil((String)localObject1)) {
              ((cn)h.az(cn.class)).loadImage((String)localObject1, null);
            }
            ChattingItemAppMsgFinderFeed.a(locala, paramString);
          }
          if (parama.oUc.GfT != 1) {
            break label531;
          }
          locala.finderDesc.setVisibility(8);
          locala.finderThumb.setVisibility(8);
          locala.finderText.setText(com.tencent.mm.pluginsdk.ui.span.p.b(parama1.aezO.getContext(), parama.oUc.desc));
          locala.finderText.setVisibility(0);
        }
      }
      for (;;)
      {
        if (locala.bottomMask != null) {
          ((cn)h.az(cn.class)).getFinderUtilApi().e(locala.bottomMask, R.g.fnO, R.g.fnN);
        }
        locala.clickArea.setOnClickListener(d(parama1));
        locala.clickArea.setOnLongClickListener(c(parama1));
        locala.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
        parama = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
        locala.clickArea.setTag(parama);
        AppMethodBeat.o(163340);
        return;
        label531:
        if (!Util.isNullOrNil(parama.oUc.desc))
        {
          locala.finderDesc.setText(com.tencent.mm.pluginsdk.ui.span.p.b(parama1.aezO.getContext(), parama.oUc.desc));
          locala.finderDesc.setVisibility(0);
        }
        for (;;)
        {
          locala.finderThumb.setVisibility(0);
          locala.finderText.setVisibility(8);
          if ((parama.oUc.GfT != 4) && (parama.oUc.GfT != 6)) {
            break label655;
          }
          locala.aeQe.setVisibility(0);
          locala.RcP.setVisibility(8);
          break;
          locala.finderDesc.setVisibility(8);
        }
        label655:
        if (parama.oUc.GfT == 2)
        {
          locala.aeQe.setVisibility(8);
          locala.RcP.setVisibility(0);
          locala.RcP.RVj = paramString.size();
        }
        else
        {
          locala.aeQe.setVisibility(8);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(163342);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163342);
        return false;
      }
      if (!WeChatBrands.Business.Entries.SessionChannels.checkAvailable(parama.aezO.getContext()))
      {
        AppMethodBeat.o(163342);
        return true;
      }
      ChattingItemAppMsgFinderFeed.c(parama.aezO.getContext(), paramcc);
      AppMethodBeat.o(163342);
      return true;
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255675);
      int j = ((bz)paramView.getTag()).position;
      if (!((cn)h.az(cn.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((paramcc != null) && (com.tencent.mm.br.c.blq("favorite")) && (i == 0))
        {
          params.a(j, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
          params.a(j, 116, this.aeiK.aezO.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
        }
        AppMethodBeat.o(255675);
        return true;
      }
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(163343);
      if (!WeChatBrands.Business.Entries.SessionChannels.checkAvailable(paramView.getContext()))
      {
        AppMethodBeat.o(163343);
        return true;
      }
      Object localObject2 = paramcc.field_content;
      Object localObject1 = null;
      if (localObject2 != null) {
        localObject1 = com.tencent.mm.message.k.b.aP((String)localObject2, paramcc.field_reserved);
      }
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.plugin.findersdk.a.f)((com.tencent.mm.message.k.b)localObject1).aK(com.tencent.mm.plugin.findersdk.a.f.class);
        if (localObject1 != null)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("feed_object_id", com.tencent.mm.ae.d.FK(((com.tencent.mm.plugin.findersdk.a.f)localObject1).oUc.objectId));
          ((Intent)localObject2).putExtra("feed_object_nonceId", ((com.tencent.mm.plugin.findersdk.a.f)localObject1).oUc.objectNonceId);
          ((Intent)localObject2).putExtra("business_type", 0);
          ((Intent)localObject2).putExtra("finder_user_name", ((com.tencent.mm.plugin.findersdk.a.f)localObject1).oUc.username);
          if (!au.bwE(paramcc.field_talker)) {
            break label252;
          }
          ((Intent)localObject2).putExtra("report_scene", 2);
        }
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("from_user", paramcc.field_talker);
        av localav = av.GiL;
        ((Intent)localObject2).putExtra("key_from_user_name", av.aU(paramcc));
        localav = av.GiL;
        ((Intent)localObject2).putExtra("key_to_user_name", av.aV(paramcc));
        ((Intent)localObject2).putExtra("tab_type", 6);
        ChattingItemAppMsgFinderFeed.a(paramView, parama, (com.tencent.mm.plugin.findersdk.a.f)localObject1, (Intent)localObject2, false, au.bwE(paramcc.field_talker));
        AppMethodBeat.o(163343);
        return false;
        label252:
        ((Intent)localObject2).putExtra("report_scene", 1);
      }
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 754974769);
    }
    
    public final boolean fXn()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements v.n
  {
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
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
        localObject = new ap(paramLayoutInflater, R.i.ggF);
        ((View)localObject).setTag(new ChattingItemAppMsgFinderFeed.a().V((View)localObject, true));
      }
      AppMethodBeat.o(163344);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc, final String paramString)
    {
      AppMethodBeat.i(163345);
      this.aeiK = parama1;
      ChattingItemAppMsgFinderFeed.a locala = (ChattingItemAppMsgFinderFeed.a)parama;
      locala.detailLayout.animate().cancel();
      locala.detailLayout.setTag(Long.valueOf(System.currentTimeMillis()));
      Object localObject1 = paramcc.field_content;
      parama = null;
      if (localObject1 != null) {
        parama = com.tencent.mm.message.k.b.aP((String)localObject1, paramcc.field_reserved);
      }
      if (parama != null)
      {
        parama = (com.tencent.mm.plugin.findersdk.a.f)parama.aK(com.tencent.mm.plugin.findersdk.a.f.class);
        com.tencent.mm.view.f.a(locala.convertView, new e.b()
        {
          public final void a(View paramAnonymousView, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(255218);
            if (paramAnonymousBoolean)
            {
              paramAnonymousView = (bq)h.ax(bq.class);
              Object localObject = k.aeZF;
              localObject = ((bn)k.nq(parama1.aezO.getContext()).cq(bn.class)).fou();
              paramAnonymousView.a(com.tencent.mm.ae.d.FK(parama.oUc.objectId), parama.oUc.objectNonceId, 4, (bui)localObject, null, false, null);
              paramAnonymousView = paramString;
              paramAnonymousBoolean = au.bwE(paramcc.field_talker);
              if (!paramAnonymousBoolean) {
                break label178;
              }
              paramAnonymousView = paramAnonymousView + "-" + paramcc.field_talker;
            }
            label178:
            for (;;)
            {
              if (paramAnonymousBoolean) {}
              for (int i = 2;; i = 1)
              {
                l.Fpv.E(i, paramAnonymousView, parama.oUc.objectId);
                AppMethodBeat.o(255218);
                return;
              }
            }
          }
          
          public final long fq(View paramAnonymousView)
          {
            AppMethodBeat.i(255219);
            long l1 = paramcc.field_msgId;
            long l2 = paramAnonymousView.hashCode();
            AppMethodBeat.o(255219);
            return l1 + l2;
          }
        });
        if (parama != null)
        {
          paramString = com.tencent.mm.plugin.finder.loader.p.ExI;
          paramString = com.tencent.mm.plugin.finder.loader.p.eCp();
          localObject1 = new com.tencent.mm.plugin.finder.loader.s(parama.bCr(), v.FKZ);
          Object localObject2 = locala.finderAvatar;
          com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          paramString.a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExP));
          paramString = locala.finderNickname;
          localObject1 = parama1.aezO.getContext();
          localObject2 = av.GiL;
          paramString.setText(com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject1, av.aBN(parama.getNickname())));
          aw.a(locala.finderNickname.getPaint(), 0.8F);
          av.GiL.a(locala.aeQf, locala.finderNickname, parama.oUc, (int)locala.aeQf.getResources().getDimension(R.f.finder_2_25_A));
          paramString = parama.oUc.mediaList;
          if (!paramString.isEmpty())
          {
            localObject2 = (bvj)paramString.get(0);
            localObject1 = ((bvj)localObject2).HaI;
            localObject2 = ((bvj)localObject2).thumbUrl;
            ((cn)h.az(cn.class)).loadImage((String)localObject2, locala.finderThumb);
            if (!Util.isNullOrNil((String)localObject1)) {
              ((cn)h.az(cn.class)).loadImage((String)localObject1, null);
            }
            ChattingItemAppMsgFinderFeed.a(locala, paramString);
          }
          if (parama.oUc.GfT != 1) {
            break label621;
          }
          locala.finderDesc.setVisibility(8);
          locala.finderThumb.setVisibility(8);
          locala.finderText.setText(com.tencent.mm.pluginsdk.ui.span.p.b(parama1.aezO.getContext(), parama.oUc.desc));
          locala.finderText.setVisibility(0);
          if (locala.bottomMask != null) {
            ((cn)h.az(cn.class)).getFinderUtilApi().e(locala.bottomMask, R.g.fnO, R.g.fnN);
          }
        }
        locala.clickArea.setOnClickListener(d(parama1));
        locala.clickArea.setOnLongClickListener(c(parama1));
        locala.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
        parama = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
        locala.clickArea.setTag(parama);
      }
      else
      {
        if (!jxj()) {
          break label827;
        }
        if (locala.uploadingPB != null) {
          locala.uploadingPB.setVisibility(8);
        }
        if ((paramcc.field_status != 2) || (!b((m)parama1.cm(m.class), paramcc.field_msgId))) {
          break label806;
        }
        if (locala.tickIV != null) {
          locala.tickIV.setVisibility(0);
        }
      }
      for (;;)
      {
        a(paramInt, locala, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
        AppMethodBeat.o(163345);
        return;
        label621:
        if (!Util.isNullOrNil(parama.oUc.desc))
        {
          locala.finderDesc.setText(com.tencent.mm.pluginsdk.ui.span.p.b(parama1.aezO.getContext(), parama.oUc.desc));
          locala.finderDesc.setVisibility(0);
        }
        for (;;)
        {
          locala.finderThumb.setVisibility(0);
          locala.finderText.setVisibility(8);
          if ((parama.oUc.GfT != 4) && (parama.oUc.GfT != 6)) {
            break label745;
          }
          locala.aeQe.setVisibility(0);
          locala.RcP.setVisibility(8);
          break;
          locala.finderDesc.setVisibility(8);
        }
        label745:
        if (parama.oUc.GfT == 2)
        {
          locala.aeQe.setVisibility(8);
          locala.RcP.setVisibility(0);
          locala.RcP.RVj = paramString.size();
          break;
        }
        locala.aeQe.setVisibility(8);
        break;
        label806:
        if (locala.tickIV != null) {
          locala.tickIV.setVisibility(8);
        }
      }
      label827:
      if (locala.tickIV != null) {
        locala.tickIV.setVisibility(8);
      }
      if (paramcc.field_status < 2) {}
      for (boolean bool = true;; bool = false)
      {
        b(locala, bool);
        break;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(163348);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163348);
        return false;
      }
      ChattingItemAppMsgFinderFeed.c(parama.aezO.getContext(), paramcc);
      AppMethodBeat.o(163348);
      return true;
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255674);
      int j = ((bz)paramView.getTag()).position;
      if (!((cn)h.az(cn.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((paramcc != null) && (i == 0))
        {
          params.a(j, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
          if (com.tencent.mm.br.c.blq("favorite")) {
            params.a(j, 116, this.aeiK.aezO.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
          }
          if (((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)) && (!au.Hh(this.aeiK.getTalkerUserName()))) {
            params.a(j, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
          }
        }
        AppMethodBeat.o(255674);
        return true;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255664);
      if (paramcc.fxR())
      {
        n.bx(paramcc);
        br.iu(paramcc.field_msgId);
        parama.jpK();
      }
      AppMethodBeat.o(255664);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(163349);
      Object localObject2 = paramcc.field_content;
      Object localObject1 = null;
      if (localObject2 != null) {
        localObject1 = com.tencent.mm.message.k.b.aP((String)localObject2, paramcc.field_reserved);
      }
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.plugin.findersdk.a.f)((com.tencent.mm.message.k.b)localObject1).aK(com.tencent.mm.plugin.findersdk.a.f.class);
        if (localObject1 != null)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("feed_object_id", com.tencent.mm.ae.d.FK(((com.tencent.mm.plugin.findersdk.a.f)localObject1).oUc.objectId));
          ((Intent)localObject2).putExtra("feed_object_nonceId", ((com.tencent.mm.plugin.findersdk.a.f)localObject1).oUc.objectNonceId);
          ((Intent)localObject2).putExtra("business_type", 0);
          ((Intent)localObject2).putExtra("finder_user_name", ((com.tencent.mm.plugin.findersdk.a.f)localObject1).oUc.username);
          if (!au.bwE(paramcc.field_talker)) {
            break label231;
          }
          ((Intent)localObject2).putExtra("report_scene", 2);
        }
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("from_user", paramcc.field_talker);
        av localav = av.GiL;
        ((Intent)localObject2).putExtra("key_from_user_name", av.aU(paramcc));
        localav = av.GiL;
        ((Intent)localObject2).putExtra("key_to_user_name", av.aV(paramcc));
        ((Intent)localObject2).putExtra("tab_type", 6);
        ChattingItemAppMsgFinderFeed.a(paramView, parama, (com.tencent.mm.plugin.findersdk.a.f)localObject1, (Intent)localObject2, true, au.bwE(paramcc.field_talker));
        AppMethodBeat.o(163349);
        return false;
        label231:
        ((Intent)localObject2).putExtra("report_scene", 1);
      }
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 754974769);
    }
    
    public final boolean fXn()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemAppMsgFinderFeed
 * JD-Core Version:    0.7.0.1
 */