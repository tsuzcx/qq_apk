package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView.a;
import com.tencent.mm.plugin.finder.view.adapter.b;
import com.tencent.mm.plugin.finder.view.adapter.b.c;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.n;
import java.util.LinkedList;
import java.util.List;

public final class q
{
  private static e FKT;
  private static String TAG;
  
  static
  {
    AppMethodBeat.i(280540);
    TAG = "Finder.ChattingItemAppMsgFinderAlbum";
    e.a locala = new e.a();
    locala.kOp = true;
    locala.kOo = true;
    FKT = locala.aRT();
    AppMethodBeat.o(280540);
  }
  
  static final class a
    extends c.a
  {
    public TextView OZK;
    public FinderFeedAlbumView Xgg;
    public ImageView tickIV;
    
    public final a N(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(196925);
      super.create(paramView);
      this.OZK = ((TextView)paramView.findViewById(R.h.dyj));
      this.Xgg = ((FinderFeedAlbumView)paramView.findViewById(R.h.feedAlbumView));
      this.Xgg.setItemViewWidth(com.tencent.mm.ci.a.fromDPToPix(paramView.getContext(), 98));
      this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      if (!((ak)h.ag(ak.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
          this.maskView = paramView.findViewById(R.h.dyD);
        }
        if (paramBoolean)
        {
          this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
          this.tickIV = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
        }
        AppMethodBeat.o(196925);
        return this;
      }
    }
    
    public final View getMainContainerView()
    {
      return this.Xgg;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(290696);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.ecN);
        ((View)localObject).setTag(new q.a().N((View)localObject, false));
      }
      AppMethodBeat.o(290696);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, String paramString)
    {
      AppMethodBeat.i(290698);
      this.WBq = parama1;
      paramString = (q.a)parama;
      parama = paramca.field_content;
      if (parama != null) {}
      for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
      {
        if (parama != null)
        {
          parama = q.q(parama);
          if (parama != null)
          {
            paramString.OZK.setText(l.c(parama1.WQv.getContext(), parama.title));
            Object localObject = new LinkedList();
            int i = 0;
            while ((i < parama.STk.size()) && (i < 4))
            {
              csg localcsg = new csg();
              localcsg.url = ((String)parama.STk.get(i));
              localcsg.url_token = ((String)parama.STl.get(i));
              localcsg.thumb_url_token = localcsg.url_token;
              localcsg.thumbUrl = localcsg.url;
              ((List)localObject).add(localcsg);
              i += 1;
            }
            localObject = new b((List)localObject, false);
            paramString.Xgg.setAdapter((FinderFeedAlbumView.a)localObject);
            ((b)localObject).Bdm = new b.c()
            {
              public final void f(int paramAnonymousInt, View paramAnonymousView)
              {
                AppMethodBeat.i(220183);
                q.a(paramAnonymousView.getContext(), paramca, parama);
                AppMethodBeat.o(220183);
              }
            };
          }
          if (paramString.clickArea != null)
          {
            paramString.clickArea.setOnClickListener(d(parama1));
            paramString.clickArea.setOnLongClickListener(c(parama1));
            paramString.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
            parama = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
            paramString.clickArea.setTag(parama);
          }
        }
        AppMethodBeat.o(290698);
        return;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(290700);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(290700);
        return false;
      }
      q.b(parama.WQv.getContext(), paramca);
      AppMethodBeat.o(290700);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(290699);
      int j = ((by)paramView.getTag()).position;
      if (!((ak)h.ag(ak.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((paramca != null) && (com.tencent.mm.by.c.blP("favorite")) && (i == 0)) {
          paramo.a(j, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        AppMethodBeat.o(290699);
        return true;
      }
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 956301361);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(290701);
      String str = paramca.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aG(str, paramca.field_reserved);
      }
      paramView = q.q(paramView);
      if (paramView != null) {
        q.a(parama.WQv.getContext(), paramca, paramView);
      }
      AppMethodBeat.o(290701);
      return false;
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
      AppMethodBeat.i(281022);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.edN);
        ((View)localObject).setTag(new q.a().N((View)localObject, true));
      }
      AppMethodBeat.o(281022);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(281023);
      this.WBq = parama1;
      paramString = (q.a)parama;
      parama = paramca.field_content;
      if (parama != null) {}
      for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
      {
        if (parama != null)
        {
          parama = q.q(parama);
          if (parama != null)
          {
            paramString.OZK.setText(l.c(parama1.WQv.getContext(), parama.title));
            Object localObject = new LinkedList();
            int i = 0;
            while ((i < parama.STk.size()) && (i < 4))
            {
              csg localcsg = new csg();
              localcsg.url = ((String)parama.STk.get(i));
              localcsg.url_token = ((String)parama.STl.get(i));
              localcsg.thumb_url_token = localcsg.url_token;
              localcsg.thumbUrl = localcsg.url;
              ((List)localObject).add(localcsg);
              i += 1;
            }
            localObject = new b((List)localObject, false);
            paramString.Xgg.setAdapter((FinderFeedAlbumView.a)localObject);
            ((b)localObject).Bdm = new b.c()
            {
              public final void f(int paramAnonymousInt, View paramAnonymousView)
              {
                AppMethodBeat.i(277946);
                q.a(paramAnonymousView.getContext(), paramca, parama);
                AppMethodBeat.o(277946);
              }
            };
          }
          if (paramString.clickArea != null)
          {
            paramString.clickArea.setOnClickListener(d(parama1));
            paramString.clickArea.setOnLongClickListener(c(parama1));
            paramString.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
            parama = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
            paramString.clickArea.setTag(parama);
          }
        }
        if (hTG())
        {
          b(paramString, false);
          if ((paramca.field_status == 2) && (b((k)parama1.bC(k.class), paramca.field_msgId))) {
            if (paramString.tickIV != null) {
              paramString.tickIV.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          a(paramInt, paramString, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
          AppMethodBeat.o(281023);
          return;
          if (paramString.tickIV != null)
          {
            paramString.tickIV.setVisibility(8);
            continue;
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
      AppMethodBeat.i(281026);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(281026);
        return false;
      }
      q.b(parama.WQv.getContext(), paramca);
      AppMethodBeat.o(281026);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(281025);
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
        AppMethodBeat.o(281025);
        return true;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(281024);
      if (paramca.erk())
      {
        m.bh(paramca);
        bq.Gk(paramca.field_msgId);
        parama.Gi(true);
      }
      AppMethodBeat.o(281024);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 956301361);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(281027);
      String str = paramca.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aG(str, paramca.field_reserved);
      }
      paramView = q.q(paramView);
      if (paramView != null) {
        q.a(parama.WQv.getContext(), paramca, paramView);
      }
      AppMethodBeat.o(281027);
      return false;
    }
    
    public final boolean hTD()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q
 * JD-Core Version:    0.7.0.1
 */