package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
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
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.bq;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.a.j;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.view.NinePatchCropImageView;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.f;
import java.util.List;

public final class ChattingItemAppMsgMegaVideo
{
  static final class a
    extends c.a
  {
    public ImageIndicatorView RcP;
    public ImageView aeQe;
    public View detailLayout;
    public ImageView finderAvatar;
    public TextView finderDesc;
    public ImageView finderIcon;
    public TextView finderNickname;
    public TextView finderText;
    public ImageView finderThumb;
    public ImageView tickIV;
    public int width;
    
    public final a aa(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(255689);
      super.create(paramView);
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(R.h.chatting_click_area);
      Object localObject = paramView.getContext();
      this.width = ((int)((((Context)localObject).getResources().getDisplayMetrics().widthPixels - ((Context)localObject).getResources().getDimension(R.f.Edge_1_5_A)) / 2.0F));
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
      int i;
      if (!((cn)h.az(cn.class)).showFinderEntry())
      {
        i = 1;
        if (i == 0)
        {
          this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
          this.maskView = paramView.findViewById(R.h.fzn);
        }
        if (!paramBoolean) {
          break label369;
        }
        this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
        this.tickIV = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
        if ((this.finderThumb instanceof NinePatchCropImageView)) {
          ((NinePatchCropImageView)this.finderThumb).setNinePatchId(R.g.chatto_finder_image_bg);
        }
      }
      for (;;)
      {
        this.finderIcon.setImageDrawable(bb.m(this.finderIcon.getContext(), R.k.icons_outlined_finder_icon, com.tencent.mm.cd.a.w(this.finderIcon.getContext(), R.e.Orange)));
        AppMethodBeat.o(255689);
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
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(255696);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.gfF);
        ((View)localObject).setTag(new ChattingItemAppMsgMegaVideo.a().aa((View)localObject, false));
      }
      AppMethodBeat.o(255696);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255707);
      this.aeiK = parama1;
      paramString = (ChattingItemAppMsgMegaVideo.a)parama;
      paramString.detailLayout.animate().cancel();
      paramString.detailLayout.setTag(Long.valueOf(System.currentTimeMillis()));
      parama = paramcc.field_content;
      if (parama != null) {}
      for (parama = com.tencent.mm.message.k.b.aP(parama, paramcc.field_reserved);; parama = null)
      {
        Object localObject;
        if (parama != null)
        {
          parama = (j)parama.aK(j.class);
          if (parama != null)
          {
            f.a(paramString.convertView, new e.b()
            {
              public final void a(View paramAnonymousView, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(255013);
                if (paramAnonymousBoolean)
                {
                  paramAnonymousView = (bq)h.ax(bq.class);
                  Object localObject = k.aeZF;
                  localObject = ((bn)k.nq(parama1.aezO.getContext()).cq(bn.class)).fou();
                  paramAnonymousView.a(com.tencent.mm.ae.d.FK(parama.oUe.objectId), parama.oUe.objectNonceId, 4, (bui)localObject, null, true, parama.oUe.username);
                }
                AppMethodBeat.o(255013);
              }
            });
            localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
            localObject = com.tencent.mm.plugin.finder.loader.p.eCp();
            com.tencent.mm.plugin.finder.loader.s locals = new com.tencent.mm.plugin.finder.loader.s(parama.oUe.avatar, v.FKZ);
            ImageView localImageView = paramString.finderAvatar;
            com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
            ((com.tencent.mm.loader.d)localObject).a(locals, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExP));
            paramString.finderNickname.setText(com.tencent.mm.pluginsdk.ui.span.p.b(parama1.aezO.getContext(), parama.oUe.nickname));
            aw.a(paramString.finderNickname.getPaint(), 0.8F);
            localObject = parama.oUe.mediaList;
            if (!((List)localObject).isEmpty())
            {
              if (Util.isNullOrNil(((dob)((List)localObject).get(0)).coverUrl)) {
                break label438;
              }
              ((cn)h.az(cn.class)).loadImage(((dob)((List)localObject).get(0)).coverUrl, paramString.finderThumb);
              ChattingItemAppMsgMegaVideo.a(paramString, (List)localObject);
            }
            if (Util.isNullOrNil(parama.oUe.desc)) {
              break label473;
            }
            paramString.finderDesc.setText(com.tencent.mm.pluginsdk.ui.span.p.b(parama1.aezO.getContext(), parama.oUe.desc));
            paramString.finderDesc.setVisibility(0);
          }
        }
        for (;;)
        {
          paramString.finderThumb.setVisibility(0);
          paramString.finderText.setVisibility(8);
          paramString.aeQe.setVisibility(0);
          paramString.RcP.setVisibility(8);
          paramString.clickArea.setOnClickListener(d(parama1));
          paramString.clickArea.setOnLongClickListener(c(parama1));
          paramString.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
          parama = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
          paramString.clickArea.setTag(parama);
          AppMethodBeat.o(255707);
          return;
          label438:
          ((cn)h.az(cn.class)).loadImage(((dob)((List)localObject).get(0)).thumbUrl, paramString.finderThumb);
          break;
          label473:
          paramString.finderDesc.setVisibility(8);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255714);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(255714);
        return false;
      }
      ChattingItemAppMsgMegaVideo.e(parama.aezO.getContext(), paramcc);
      AppMethodBeat.o(255714);
      return true;
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255709);
      int j = ((bz)paramView.getTag()).position;
      if (!((cn)h.az(cn.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((paramcc != null) && (com.tencent.mm.br.c.blq("favorite")) && (i == 0)) {
          params.a(j, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        AppMethodBeat.o(255709);
        return true;
      }
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255719);
      Object localObject2 = paramcc.field_content;
      Object localObject1 = null;
      if (localObject2 != null) {
        localObject1 = com.tencent.mm.message.k.b.aP((String)localObject2, paramcc.field_reserved);
      }
      if (localObject1 != null)
      {
        localObject1 = (j)((com.tencent.mm.message.k.b)localObject1).aK(j.class);
        if (localObject1 != null)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("feed_object_id", com.tencent.mm.ae.d.FK(((j)localObject1).oUe.objectId));
          ((Intent)localObject2).putExtra("feed_object_nonceId", ((j)localObject1).oUe.objectNonceId);
          ((Intent)localObject2).putExtra("business_type", 1);
          ((Intent)localObject2).putExtra("finder_user_name", ((j)localObject1).oUe.username);
          if (!au.bwE(paramcc.field_talker)) {
            break label285;
          }
          ((Intent)localObject2).putExtra("report_scene", 2);
          ((Intent)localObject2).putExtra("key_finder_teen_mode_scene", 2);
        }
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("key_finder_teen_mode_check", true);
        ((Intent)localObject2).putExtra("key_finder_teen_mode_user_name", ((j)localObject1).oUe.nickname);
        ((Intent)localObject2).putExtra("key_finder_teen_mode_user_id", ((j)localObject1).oUe.username);
        ((Intent)localObject2).putExtra("from_user", paramcc.field_talker);
        av localav = av.GiL;
        ((Intent)localObject2).putExtra("key_from_user_name", av.aU(paramcc));
        localav = av.GiL;
        ((Intent)localObject2).putExtra("key_to_user_name", av.aV(paramcc));
        ((Intent)localObject2).putExtra("tab_type", 6);
        ChattingItemAppMsgMegaVideo.a(paramView, parama, (j)localObject1, (Intent)localObject2, false, au.bwE(paramcc.field_talker));
        AppMethodBeat.o(255719);
        return false;
        label285:
        ((Intent)localObject2).putExtra("report_scene", 1);
        ((Intent)localObject2).putExtra("key_finder_teen_mode_scene", 1);
      }
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 1023410225);
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
      AppMethodBeat.i(255718);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.ggF);
        ((View)localObject).setTag(new ChattingItemAppMsgMegaVideo.a().aa((View)localObject, true));
      }
      AppMethodBeat.o(255718);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(255725);
      this.aeiK = parama1;
      paramString = (ChattingItemAppMsgMegaVideo.a)parama;
      paramString.detailLayout.animate().cancel();
      paramString.detailLayout.setTag(Long.valueOf(System.currentTimeMillis()));
      parama = paramcc.field_content;
      if (parama != null) {}
      for (parama = com.tencent.mm.message.k.b.aP(parama, paramcc.field_reserved);; parama = null)
      {
        Object localObject;
        if (parama != null)
        {
          parama = (j)parama.aK(j.class);
          if (parama != null)
          {
            f.a(paramString.convertView, new e.b()
            {
              public final void a(View paramAnonymousView, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(255352);
                if (paramAnonymousBoolean)
                {
                  paramAnonymousView = (bq)h.ax(bq.class);
                  Object localObject = k.aeZF;
                  localObject = ((bn)k.nq(parama1.aezO.getContext()).cq(bn.class)).fou();
                  paramAnonymousView.a(com.tencent.mm.ae.d.FK(parama.oUe.objectId), parama.oUe.objectNonceId, 4, (bui)localObject, null, true, parama.oUe.username);
                }
                AppMethodBeat.o(255352);
              }
            });
            localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
            localObject = com.tencent.mm.plugin.finder.loader.p.eCp();
            com.tencent.mm.plugin.finder.loader.s locals = new com.tencent.mm.plugin.finder.loader.s(parama.oUe.avatar, v.FKZ);
            ImageView localImageView = paramString.finderAvatar;
            com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
            ((com.tencent.mm.loader.d)localObject).a(locals, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExP));
            paramString.finderNickname.setText(com.tencent.mm.pluginsdk.ui.span.p.b(parama1.aezO.getContext(), parama.oUe.nickname));
            aw.a(paramString.finderNickname.getPaint(), 0.8F);
            localObject = parama.oUe.mediaList;
            if (!((List)localObject).isEmpty())
            {
              if (!Util.isNullOrNil(((dob)((List)localObject).get(0)).coverUrl))
              {
                ((cn)h.az(cn.class)).loadImage(((dob)((List)localObject).get(0)).coverUrl, paramString.finderThumb);
                ChattingItemAppMsgMegaVideo.a(paramString, (List)localObject);
              }
            }
            else
            {
              if (Util.isNullOrNil(parama.oUe.desc)) {
                break label566;
              }
              paramString.finderDesc.setText(com.tencent.mm.pluginsdk.ui.span.p.b(parama1.aezO.getContext(), parama.oUe.desc));
              paramString.finderDesc.setVisibility(0);
              label319:
              paramString.finderThumb.setVisibility(0);
              paramString.finderText.setVisibility(8);
              paramString.aeQe.setVisibility(0);
              paramString.RcP.setVisibility(8);
            }
          }
          else
          {
            paramString.clickArea.setOnClickListener(d(parama1));
            paramString.clickArea.setOnLongClickListener(c(parama1));
            paramString.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
            parama = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
            paramString.clickArea.setTag(parama);
          }
        }
        else
        {
          if (!jxj()) {
            break label600;
          }
          if (paramString.uploadingPB != null) {
            paramString.uploadingPB.setVisibility(8);
          }
          if ((paramcc.field_status != 2) || (!b((m)parama1.cm(m.class), paramcc.field_msgId))) {
            break label579;
          }
          if (paramString.tickIV != null) {
            paramString.tickIV.setVisibility(0);
          }
        }
        for (;;)
        {
          a(paramInt, paramString, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
          AppMethodBeat.o(255725);
          return;
          ((cn)h.az(cn.class)).loadImage(((dob)((List)localObject).get(0)).thumbUrl, paramString.finderThumb);
          break;
          label566:
          paramString.finderDesc.setVisibility(8);
          break label319;
          label579:
          if (paramString.tickIV != null)
          {
            paramString.tickIV.setVisibility(8);
            continue;
            label600:
            if (paramString.uploadingPB != null) {
              paramString.uploadingPB.setVisibility(8);
            }
            if (paramString.tickIV != null) {
              paramString.tickIV.setVisibility(8);
            }
            if (paramcc.field_status < 2) {
              bool = true;
            }
            b(paramString, bool);
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255743);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(255743);
        return false;
      }
      ChattingItemAppMsgMegaVideo.e(parama.aezO.getContext(), paramcc);
      AppMethodBeat.o(255743);
      return true;
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255739);
      int j = ((bz)paramView.getTag()).position;
      if (!((cn)h.az(cn.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((paramcc != null) && (i == 0))
        {
          params.a(j, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
          com.tencent.mm.br.c.blq("favorite");
          if (((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)) && (!au.Hh(this.aeiK.getTalkerUserName()))) {
            params.a(j, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
          }
        }
        AppMethodBeat.o(255739);
        return true;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255731);
      if (paramcc.fxR())
      {
        n.bx(paramcc);
        br.iu(paramcc.field_msgId);
        parama.jpK();
      }
      AppMethodBeat.o(255731);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255750);
      Object localObject2 = paramcc.field_content;
      Object localObject1 = null;
      if (localObject2 != null) {
        localObject1 = com.tencent.mm.message.k.b.aP((String)localObject2, paramcc.field_reserved);
      }
      if (localObject1 != null)
      {
        localObject1 = (j)((com.tencent.mm.message.k.b)localObject1).aK(j.class);
        if (localObject1 != null)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("feed_object_id", com.tencent.mm.ae.d.FK(((j)localObject1).oUe.objectId));
          ((Intent)localObject2).putExtra("feed_object_nonceId", ((j)localObject1).oUe.objectNonceId);
          ((Intent)localObject2).putExtra("business_type", 1);
          ((Intent)localObject2).putExtra("finder_user_name", ((j)localObject1).oUe.username);
          if (!au.bwE(paramcc.field_talker)) {
            break label285;
          }
          ((Intent)localObject2).putExtra("report_scene", 2);
          ((Intent)localObject2).putExtra("key_finder_teen_mode_scene", 2);
        }
      }
      for (;;)
      {
        ((Intent)localObject2).putExtra("key_finder_teen_mode_check", true);
        ((Intent)localObject2).putExtra("key_finder_teen_mode_user_name", ((j)localObject1).oUe.nickname);
        ((Intent)localObject2).putExtra("key_finder_teen_mode_user_id", ((j)localObject1).oUe.username);
        ((Intent)localObject2).putExtra("from_user", paramcc.field_talker);
        av localav = av.GiL;
        ((Intent)localObject2).putExtra("key_from_user_name", av.aU(paramcc));
        localav = av.GiL;
        ((Intent)localObject2).putExtra("key_to_user_name", av.aV(paramcc));
        ((Intent)localObject2).putExtra("tab_type", 6);
        ChattingItemAppMsgMegaVideo.a(paramView, parama, (j)localObject1, (Intent)localObject2, true, au.bwE(paramcc.field_talker));
        AppMethodBeat.o(255750);
        return false;
        label285:
        ((Intent)localObject2).putExtra("report_scene", 1);
        ((Intent)localObject2).putExtra("key_finder_teen_mode_scene", 1);
      }
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 1023410225);
    }
    
    public final boolean fXn()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemAppMsgMegaVideo
 * JD-Core Version:    0.7.0.1
 */