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
import com.tencent.mm.plugin.findersdk.a.i;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.v.n;

public final class v
{
  private static com.tencent.mm.loader.b.e LGf;
  private static String TAG;
  
  static
  {
    AppMethodBeat.i(163379);
    TAG = "Finder.ChattingItemAppMsgFinderTopic";
    e.a locala = new e.a();
    locala.nqd = true;
    locala.nqc = true;
    LGf = locala.blI();
    AppMethodBeat.o(163379);
  }
  
  private static bvn t(k.b paramb)
  {
    AppMethodBeat.i(255015);
    paramb = (i)paramb.aK(i.class);
    if (paramb != null)
    {
      paramb = paramb.oTZ;
      AppMethodBeat.o(255015);
      return paramb;
    }
    AppMethodBeat.o(255015);
    return null;
  }
  
  static final class a
    extends c.a
  {
    public TextView VPY;
    public TextView finderDesc;
    public ImageView finderIcon;
    public ImageView tickIV;
    
    public final a Y(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(163364);
      super.create(paramView);
      this.VPY = ((TextView)paramView.findViewById(R.h.fyS));
      this.finderIcon = ((ImageView)paramView.findViewById(R.h.fyU));
      this.finderDesc = ((TextView)paramView.findViewById(R.h.fyT));
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
        AppMethodBeat.o(163364);
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
      AppMethodBeat.i(163365);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.gfL);
        ((View)localObject).setTag(new v.a().Y((View)localObject, false));
      }
      AppMethodBeat.o(163365);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(163366);
      this.aeiK = parama1;
      paramString = (v.a)parama;
      parama = paramcc.field_content;
      if (parama != null) {}
      for (parama = k.b.aP(parama, paramcc.field_reserved);; parama = null)
      {
        bvn localbvn;
        if (parama != null)
        {
          localbvn = v.q(parama);
          if (localbvn != null) {
            if (localbvn.Auy != 1) {
              break label228;
            }
          }
        }
        label228:
        for (parama = MMApplicationContext.getContext().getString(R.l.finder_topic_card_prefix, new Object[] { localbvn.topic });; parama = localbvn.topic)
        {
          paramString.VPY.setText(p.b(parama1.aezO.getContext(), parama));
          parama = com.tencent.mm.loader.e.noo;
          com.tencent.mm.loader.e.blh().a(localbvn.iconUrl, paramString.finderIcon, v.jxr());
          paramString.finderDesc.setText(localbvn.desc);
          if (paramString.clickArea != null)
          {
            paramString.clickArea.setOnClickListener(d(parama1));
            paramString.clickArea.setOnLongClickListener(c(parama1));
            paramString.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
            parama = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
            paramString.clickArea.setTag(parama);
          }
          AppMethodBeat.o(163366);
          return;
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(163368);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163368);
        return false;
      }
      v.b(parama.aezO.getContext(), paramcc);
      AppMethodBeat.o(163368);
      return true;
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255161);
      int j = ((bz)paramView.getTag()).position;
      if (!((cn)h.az(cn.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((paramcc != null) && (com.tencent.mm.br.c.blq("favorite")) && (i == 0)) {
          params.a(j, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        AppMethodBeat.o(255161);
        return true;
      }
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(163369);
      String str = paramcc.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aP(str, paramcc.field_reserved);
      }
      paramView = v.q(paramView);
      if (paramView != null) {
        v.a(parama.aezO.getContext(), paramcc, paramView);
      }
      AppMethodBeat.o(163369);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 838860849) || (paramInt == 1006633009));
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
      AppMethodBeat.i(163370);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.ggL);
        ((View)localObject).setTag(new v.a().Y((View)localObject, true));
      }
      AppMethodBeat.o(163370);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(163371);
      this.aeiK = parama1;
      paramString = (v.a)parama;
      Object localObject = paramcc.field_content;
      parama = null;
      if (localObject != null) {
        parama = k.b.aP((String)localObject, paramcc.field_reserved);
      }
      if (parama != null)
      {
        localObject = v.q(parama);
        if (localObject != null)
        {
          if (((bvn)localObject).Auy != 1) {
            break label314;
          }
          parama = MMApplicationContext.getContext().getString(R.l.finder_topic_card_prefix, new Object[] { ((bvn)localObject).topic });
          paramString.VPY.setText(p.b(parama1.aezO.getContext(), parama));
          parama = com.tencent.mm.loader.e.noo;
          com.tencent.mm.loader.e.blh().a(((bvn)localObject).iconUrl, paramString.finderIcon, v.jxr());
          paramString.finderDesc.setText(((bvn)localObject).desc);
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
        AppMethodBeat.o(163371);
        return;
        label314:
        parama = ((bvn)localObject).topic;
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
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(163374);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163374);
        return false;
      }
      v.b(parama.aezO.getContext(), paramcc);
      AppMethodBeat.o(163374);
      return true;
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255170);
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
        AppMethodBeat.o(255170);
        return true;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255168);
      if (paramcc.fxR())
      {
        n.bx(paramcc);
        br.iu(paramcc.field_msgId);
        parama.jpK();
      }
      AppMethodBeat.o(255168);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(163375);
      String str = paramcc.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aP(str, paramcc.field_reserved);
      }
      paramView = v.q(paramView);
      if (paramView != null) {
        v.a(parama.aezO.getContext(), paramcc, paramView);
      }
      AppMethodBeat.o(163375);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 838860849) || (paramInt == 1006633009));
    }
    
    public final boolean fXn()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v
 * JD-Core Version:    0.7.0.1
 */