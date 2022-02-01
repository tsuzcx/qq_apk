package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.v.n;

public final class p
{
  private static com.tencent.mm.loader.b.e LGf;
  private static String TAG;
  
  static
  {
    AppMethodBeat.i(254946);
    TAG = "Finder.ChattingItemAppMsgFinderTopic";
    e.a locala = new e.a();
    locala.nqd = true;
    locala.nqc = true;
    LGf = locala.blI();
    AppMethodBeat.o(254946);
  }
  
  static final class a
    extends c.a
  {
    public TextView VPY;
    public TextView aePW;
    public TextView finderDesc;
    public ImageView finderIcon;
    public ImageView tickIV;
    
    public final a S(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(255524);
      super.create(paramView);
      this.VPY = ((TextView)paramView.findViewById(R.h.fyS));
      this.finderIcon = ((ImageView)paramView.findViewById(R.h.fyU));
      this.finderDesc = ((TextView)paramView.findViewById(R.h.fyT));
      this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
      this.aePW = ((TextView)paramView.findViewById(R.h.fyL));
      if (!((cn)h.az(cn.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
          this.maskView = paramView.findViewById(R.h.fzn);
        }
        if (paramBoolean)
        {
          this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
          this.tickIV = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
        }
        AppMethodBeat.o(255524);
        return this;
      }
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(255503);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.gfL);
        ((View)localObject).setTag(new p.a().S((View)localObject, false));
      }
      AppMethodBeat.o(255503);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255514);
      this.aeiK = parama1;
      p.a locala = (p.a)parama;
      parama = paramcc.field_content;
      if (parama != null) {}
      for (parama = k.b.aP(parama, paramcc.field_reserved);; parama = null)
      {
        bvn localbvn;
        if (parama != null)
        {
          localbvn = p.q(parama);
          if ((localbvn != null) && (localbvn.aade != null))
          {
            if (localbvn.Auy != 7) {
              break label276;
            }
            parama = av.GiL;
            paramString = av.a(localbvn.aade);
            parama = MMApplicationContext.getContext().getText(R.l.finder_campaign_share_tail_text).toString();
            if (!TextUtils.isEmpty(localbvn.aade.svG)) {
              parama = localbvn.aade.svG;
            }
            locala.aePW.setText(parama);
            parama = paramString;
            locala.VPY.setText(com.tencent.mm.pluginsdk.ui.span.p.b(parama1.aezO.getContext(), parama));
            if (!Util.isNullOrNil(localbvn.iconUrl)) {
              break label285;
            }
            locala.finderIcon.setVisibility(4);
          }
        }
        for (;;)
        {
          locala.finderDesc.setText(localbvn.desc);
          if (locala.clickArea != null)
          {
            locala.clickArea.setOnClickListener(d(parama1));
            locala.clickArea.setOnLongClickListener(c(parama1));
            locala.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
            parama = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
            locala.clickArea.setTag(parama);
          }
          AppMethodBeat.o(255514);
          return;
          label276:
          parama = localbvn.topic;
          break;
          label285:
          locala.finderIcon.setVisibility(0);
          parama = com.tencent.mm.loader.e.noo;
          com.tencent.mm.loader.e.blh().a(localbvn.iconUrl, locala.finderIcon, p.jxr());
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255523);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(255523);
        return false;
      }
      p.b(parama.aezO.getContext(), paramcc);
      AppMethodBeat.o(255523);
      return true;
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255518);
      int j = ((bz)paramView.getTag()).position;
      if (!((cn)h.az(cn.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((paramcc != null) && (com.tencent.mm.br.c.blq("favorite")) && (i == 0)) {
          params.a(j, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        AppMethodBeat.o(255518);
        return true;
      }
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255528);
      String str = paramcc.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aP(str, paramcc.field_reserved);
      }
      paramView = p.q(paramView);
      if (paramView != null) {
        p.a(parama.aezO.getContext(), paramcc, paramView);
      }
      AppMethodBeat.o(255528);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 1023475761) || (paramInt == 1023541297));
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
      AppMethodBeat.i(255512);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.ggL);
        ((View)localObject).setTag(new p.a().S((View)localObject, true));
      }
      AppMethodBeat.o(255512);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(255522);
      this.aeiK = parama1;
      p.a locala = (p.a)parama;
      parama = paramcc.field_content;
      if (parama != null) {}
      for (parama = k.b.aP(parama, paramcc.field_reserved);; parama = null)
      {
        bvn localbvn;
        if (parama != null)
        {
          localbvn = p.q(parama);
          if ((localbvn != null) && (localbvn.aade != null))
          {
            if (localbvn.Auy != 7) {
              break label357;
            }
            parama = av.GiL;
            paramString = av.a(localbvn.aade);
            parama = MMApplicationContext.getContext().getText(R.l.finder_campaign_share_tail_text).toString();
            if (!Util.isNullOrNil(localbvn.aade.svG)) {
              parama = localbvn.aade.svG;
            }
            locala.aePW.setText(parama);
            parama = paramString;
            locala.VPY.setText(com.tencent.mm.pluginsdk.ui.span.p.b(parama1.aezO.getContext(), parama));
            if (!Util.isNullOrNil(localbvn.iconUrl)) {
              break label366;
            }
            locala.finderIcon.setVisibility(4);
            label175:
            locala.finderDesc.setText(localbvn.desc);
          }
          if (locala.clickArea != null)
          {
            locala.clickArea.setOnClickListener(d(parama1));
            locala.clickArea.setOnLongClickListener(c(parama1));
            locala.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
            parama = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
            locala.clickArea.setTag(parama);
          }
        }
        if (jxj())
        {
          b(locala, false);
          if ((paramcc.field_status == 2) && (b((m)parama1.cm(m.class), paramcc.field_msgId))) {
            if (locala.tickIV != null) {
              locala.tickIV.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          a(paramInt, locala, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
          AppMethodBeat.o(255522);
          return;
          label357:
          parama = localbvn.topic;
          break;
          label366:
          locala.finderIcon.setVisibility(0);
          parama = com.tencent.mm.loader.e.noo;
          com.tencent.mm.loader.e.blh().a(localbvn.iconUrl, locala.finderIcon, p.jxr());
          break label175;
          if (locala.tickIV != null)
          {
            locala.tickIV.setVisibility(8);
            continue;
            if (locala.tickIV != null) {
              locala.tickIV.setVisibility(8);
            }
            if (paramcc.field_status < 2) {
              bool = true;
            }
            b(locala, bool);
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255536);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(255536);
        return false;
      }
      p.b(parama.aezO.getContext(), paramcc);
      AppMethodBeat.o(255536);
      return true;
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255531);
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
        AppMethodBeat.o(255531);
        return true;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255526);
      if (paramcc.fxR())
      {
        n.bx(paramcc);
        br.iu(paramcc.field_msgId);
        parama.jpK();
      }
      AppMethodBeat.o(255526);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255542);
      String str = paramcc.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aP(str, paramcc.field_reserved);
      }
      paramView = p.q(paramView);
      if (paramView != null) {
        p.a(parama.aezO.getContext(), paramcc, paramView);
      }
      AppMethodBeat.o(255542);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 1023475761) || (paramInt == 1023541297));
    }
    
    public final boolean fXn()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p
 * JD-Core Version:    0.7.0.1
 */