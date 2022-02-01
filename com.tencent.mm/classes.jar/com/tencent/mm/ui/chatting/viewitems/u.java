package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.v.n;

public final class u
{
  private static com.tencent.mm.loader.b.e LGf;
  private static String TAG;
  
  static
  {
    AppMethodBeat.i(255035);
    TAG = "Finder.ChattingItemAppMsgFinderPoi";
    e.a locala = new e.a();
    locala.nqd = true;
    locala.nqc = true;
    LGf = locala.blI();
    AppMethodBeat.o(255035);
  }
  
  static final class a
    extends c.a
  {
    public TextView VPY;
    public TextView finderDesc;
    public ImageView finderIcon;
    public ImageView tickIV;
    
    public final a X(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(255651);
      super.create(paramView);
      this.VPY = ((TextView)paramView.findViewById(R.h.fyS));
      this.finderIcon = ((ImageView)paramView.findViewById(R.h.fyP));
      this.finderDesc = ((TextView)paramView.findViewById(R.h.fyO));
      this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
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
        AppMethodBeat.o(255651);
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
      AppMethodBeat.i(255649);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.gfJ);
        ((View)localObject).setTag(new u.a().X((View)localObject, false));
      }
      AppMethodBeat.o(255649);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255659);
      this.aeiK = parama1;
      paramString = (u.a)parama;
      parama = paramcc.field_content;
      if (parama != null) {}
      for (parama = k.b.aP(parama, paramcc.field_reserved);; parama = null)
      {
        if (parama != null)
        {
          parama = u.s(parama);
          if (parama != null)
          {
            Object localObject = parama.poiName;
            paramString.VPY.setText(p.b(parama1.aezO.getContext(), (CharSequence)localObject));
            paramString.finderDesc.setText(parama.AXm);
            if (Util.isNullOrNil(parama.XOv)) {
              break label211;
            }
            localObject = com.tencent.mm.loader.e.noo;
            com.tencent.mm.loader.e.blh().a(parama.XOv, paramString.finderIcon, u.jxr());
          }
        }
        for (;;)
        {
          if (paramString.clickArea != null)
          {
            paramString.clickArea.setOnClickListener(d(parama1));
            paramString.clickArea.setOnLongClickListener(c(parama1));
            paramString.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
            parama = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
            paramString.clickArea.setTag(parama);
          }
          AppMethodBeat.o(255659);
          return;
          label211:
          paramString.finderIcon.setImageResource(R.k.icons_outlined_location);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255673);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(255673);
        return false;
      }
      u.b(parama.aezO.getContext(), paramcc);
      AppMethodBeat.o(255673);
      return true;
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255667);
      int i = ((bz)paramView.getTag()).position;
      if ((paramcc != null) && (com.tencent.mm.br.c.blq("favorite"))) {
        params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      AppMethodBeat.o(255667);
      return true;
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255677);
      String str = paramcc.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aP(str, paramcc.field_reserved);
      }
      paramView = u.s(paramView);
      if (paramView != null) {
        u.a(parama.aezO.getContext(), paramcc, paramView);
      }
      AppMethodBeat.o(255677);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 1057030193);
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
      AppMethodBeat.i(255653);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.ggJ);
        ((View)localObject).setTag(new u.a().X((View)localObject, true));
      }
      AppMethodBeat.o(255653);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(255663);
      this.aeiK = parama1;
      paramString = (u.a)parama;
      parama = paramcc.field_content;
      if (parama != null) {}
      for (parama = k.b.aP(parama, paramcc.field_reserved);; parama = null)
      {
        if (parama != null)
        {
          parama = u.s(parama);
          if (parama != null)
          {
            Object localObject = parama.poiName;
            paramString.VPY.setText(p.b(parama1.aezO.getContext(), (CharSequence)localObject));
            paramString.finderDesc.setText(parama.AXm);
            if (Util.isNullOrNil(parama.XOv)) {
              break label292;
            }
            localObject = com.tencent.mm.loader.e.noo;
            com.tencent.mm.loader.e.blh().a(parama.XOv, paramString.finderIcon, u.jxr());
          }
          if (paramString.clickArea != null)
          {
            paramString.clickArea.setOnClickListener(d(parama1));
            paramString.clickArea.setOnLongClickListener(c(parama1));
            paramString.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
            parama = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
            paramString.clickArea.setTag(parama);
          }
        }
        if (jxj())
        {
          b(paramString, false);
          if ((paramcc.field_status == 2) && (b((m)parama1.cm(m.class), paramcc.field_msgId))) {
            if (paramString.tickIV != null) {
              paramString.tickIV.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          a(paramInt, paramString, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
          AppMethodBeat.o(255663);
          return;
          label292:
          paramString.finderIcon.setImageResource(R.k.icons_outlined_location);
          break;
          if (paramString.tickIV != null)
          {
            paramString.tickIV.setVisibility(8);
            continue;
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
      AppMethodBeat.i(255678);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(255678);
        return false;
      }
      u.b(parama.aezO.getContext(), paramcc);
      AppMethodBeat.o(255678);
      return true;
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255676);
      int i = ((bz)paramView.getTag()).position;
      if (paramcc != null)
      {
        params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        com.tencent.mm.br.c.blq("favorite");
        if (((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)) && (!au.Hh(this.aeiK.getTalkerUserName()))) {
          params.a(i, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
        }
      }
      AppMethodBeat.o(255676);
      return true;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255671);
      if (paramcc.fxR())
      {
        n.bx(paramcc);
        br.iu(paramcc.field_msgId);
        parama.jpK();
      }
      AppMethodBeat.o(255671);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255680);
      String str = paramcc.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aP(str, paramcc.field_reserved);
      }
      paramView = u.s(paramView);
      if (paramView != null) {
        u.a(parama.aezO.getContext(), paramcc, paramView);
      }
      AppMethodBeat.o(255680);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 1057030193);
    }
    
    public final boolean fXn()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u
 * JD-Core Version:    0.7.0.1
 */