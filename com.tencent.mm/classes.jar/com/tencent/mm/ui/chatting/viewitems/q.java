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
import com.tencent.mm.loader.b.e;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.a;
import com.tencent.mm.plugin.finder.view.adapter.b;
import com.tencent.mm.plugin.finder.view.adapter.b.c;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.v.n;
import java.util.LinkedList;
import java.util.List;

public final class q
{
  private static e LGf;
  private static String TAG;
  
  static
  {
    AppMethodBeat.i(255005);
    TAG = "Finder.ChattingItemAppMsgFinderAlbum";
    e.a locala = new e.a();
    locala.nqd = true;
    locala.nqc = true;
    LGf = locala.blI();
    AppMethodBeat.o(255005);
  }
  
  static final class a
    extends c.a
  {
    public TextView VPY;
    public FinderFeedAlbumView aePX;
    public ImageView tickIV;
    
    public final a T(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(255020);
      super.create(paramView);
      this.VPY = ((TextView)paramView.findViewById(R.h.fyS));
      this.aePX = ((FinderFeedAlbumView)paramView.findViewById(R.h.feedAlbumView));
      this.aePX.setItemViewWidth(com.tencent.mm.cd.a.fromDPToPix(paramView.getContext(), 98));
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
        AppMethodBeat.o(255020);
        return this;
      }
    }
    
    public final View getMainContainerView()
    {
      return this.aePX;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(255011);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.gfD);
        ((View)localObject).setTag(new q.a().T((View)localObject, false));
      }
      AppMethodBeat.o(255011);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc, String paramString)
    {
      AppMethodBeat.i(255019);
      this.aeiK = parama1;
      paramString = (q.a)parama;
      parama = paramcc.field_content;
      if (parama != null) {}
      for (parama = k.b.aP(parama, paramcc.field_reserved);; parama = null)
      {
        if (parama != null)
        {
          parama = q.r(parama);
          if (parama != null)
          {
            paramString.VPY.setText(p.b(parama1.aezO.getContext(), parama.title));
            Object localObject = new LinkedList();
            int i = 0;
            while ((i < parama.aacP.size()) && (i < 4))
            {
              dji localdji = new dji();
              localdji.url = ((String)parama.aacP.get(i));
              localdji.url_token = ((String)parama.aacQ.get(i));
              localdji.thumb_url_token = localdji.url_token;
              localdji.thumbUrl = localdji.url;
              ((List)localObject).add(localdji);
              i += 1;
            }
            localObject = new b((List)localObject, false);
            paramString.aePX.setAdapter((FinderFeedAlbumView.a)localObject);
            ((b)localObject).GGb = new b.c()
            {
              public final void h(int paramAnonymousInt, View paramAnonymousView)
              {
                AppMethodBeat.i(255072);
                q.a(paramAnonymousView.getContext(), paramcc, parama);
                AppMethodBeat.o(255072);
              }
            };
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
        AppMethodBeat.o(255019);
        return;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255031);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(255031);
        return false;
      }
      q.b(parama.aezO.getContext(), paramcc);
      AppMethodBeat.o(255031);
      return true;
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255026);
      int j = ((bz)paramView.getTag()).position;
      if (!((cn)h.az(cn.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((paramcc != null) && (com.tencent.mm.br.c.blq("favorite")) && (i == 0)) {
          params.a(j, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        AppMethodBeat.o(255026);
        return true;
      }
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255038);
      String str = paramcc.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aP(str, paramcc.field_reserved);
      }
      paramView = q.r(paramView);
      if (paramView != null) {
        q.a(parama.aezO.getContext(), paramcc, paramView);
      }
      AppMethodBeat.o(255038);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 956301361);
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
      AppMethodBeat.i(255024);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.ggD);
        ((View)localObject).setTag(new q.a().T((View)localObject, true));
      }
      AppMethodBeat.o(255024);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc, String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(255036);
      this.aeiK = parama1;
      paramString = (q.a)parama;
      parama = paramcc.field_content;
      if (parama != null) {}
      for (parama = k.b.aP(parama, paramcc.field_reserved);; parama = null)
      {
        if (parama != null)
        {
          parama = q.r(parama);
          if (parama != null)
          {
            paramString.VPY.setText(p.b(parama1.aezO.getContext(), parama.title));
            Object localObject = new LinkedList();
            int i = 0;
            while ((i < parama.aacP.size()) && (i < 4))
            {
              dji localdji = new dji();
              localdji.url = ((String)parama.aacP.get(i));
              localdji.url_token = ((String)parama.aacQ.get(i));
              localdji.thumb_url_token = localdji.url_token;
              localdji.thumbUrl = localdji.url;
              ((List)localObject).add(localdji);
              i += 1;
            }
            localObject = new b((List)localObject, false);
            paramString.aePX.setAdapter((FinderFeedAlbumView.a)localObject);
            ((b)localObject).GGb = new b.c()
            {
              public final void h(int paramAnonymousInt, View paramAnonymousView)
              {
                AppMethodBeat.i(255402);
                q.a(paramAnonymousView.getContext(), paramcc, parama);
                AppMethodBeat.o(255402);
              }
            };
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
          AppMethodBeat.o(255036);
          return;
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
      AppMethodBeat.i(255049);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(255049);
        return false;
      }
      q.b(parama.aezO.getContext(), paramcc);
      AppMethodBeat.o(255049);
      return true;
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255045);
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
        AppMethodBeat.o(255045);
        return true;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255040);
      if (paramcc.fxR())
      {
        n.bx(paramcc);
        br.iu(paramcc.field_msgId);
        parama.jpK();
      }
      AppMethodBeat.o(255040);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255054);
      String str = paramcc.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aP(str, paramcc.field_reserved);
      }
      paramView = q.r(paramView);
      if (paramView != null) {
        q.a(parama.aezO.getContext(), paramcc, paramView);
      }
      AppMethodBeat.o(255054);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 956301361);
    }
    
    public final boolean fXn()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q
 * JD-Core Version:    0.7.0.1
 */