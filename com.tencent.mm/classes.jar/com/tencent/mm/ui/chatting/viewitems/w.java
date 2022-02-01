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
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.n;

public final class w
{
  private static com.tencent.mm.loader.c.e FKT;
  private static String TAG;
  
  static
  {
    AppMethodBeat.i(163379);
    TAG = "Finder.ChattingItemAppMsgFinderTopic";
    e.a locala = new e.a();
    locala.kOp = true;
    locala.kOo = true;
    FKT = locala.aRT();
    AppMethodBeat.o(163379);
  }
  
  private static bjg s(k.b paramb)
  {
    AppMethodBeat.i(287955);
    paramb = (com.tencent.mm.plugin.findersdk.a.h)paramb.ar(com.tencent.mm.plugin.findersdk.a.h.class);
    if (paramb != null)
    {
      paramb = paramb.mbf;
      AppMethodBeat.o(287955);
      return paramb;
    }
    AppMethodBeat.o(287955);
    return null;
  }
  
  static final class a
    extends c.a
  {
    public TextView OZK;
    public TextView finderDesc;
    public ImageView finderIcon;
    public ImageView tickIV;
    
    public final a S(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(163364);
      super.create(paramView);
      this.OZK = ((TextView)paramView.findViewById(R.h.dyj));
      this.finderIcon = ((ImageView)paramView.findViewById(R.h.dyl));
      this.finderDesc = ((TextView)paramView.findViewById(R.h.dyk));
      this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      if (!((ak)com.tencent.mm.kernel.h.ag(ak.class)).showFinderEntry()) {}
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
        AppMethodBeat.o(163364);
        return this;
      }
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    
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
        localObject = new aq(paramLayoutInflater, R.i.ecW);
        ((View)localObject).setTag(new w.a().S((View)localObject, false));
      }
      AppMethodBeat.o(163365);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(163366);
      this.WBq = parama1;
      paramString = (w.a)parama;
      parama = paramca.field_content;
      if (parama != null) {}
      for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
      {
        bjg localbjg;
        if (parama != null)
        {
          localbjg = w.p(parama);
          if (localbjg != null) {
            if (localbjg.wXA != 1) {
              break label228;
            }
          }
        }
        label228:
        for (parama = MMApplicationContext.getContext().getString(R.l.finder_topic_card_prefix, new Object[] { localbjg.topic });; parama = localbjg.topic)
        {
          paramString.OZK.setText(l.c(parama1.WQv.getContext(), parama));
          parama = com.tencent.mm.loader.e.kMy;
          com.tencent.mm.loader.e.aRs().a(localbjg.iconUrl, paramString.finderIcon, w.hTN());
          paramString.finderDesc.setText(localbjg.desc);
          if (paramString.clickArea != null)
          {
            paramString.clickArea.setOnClickListener(d(parama1));
            paramString.clickArea.setOnLongClickListener(c(parama1));
            paramString.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
            parama = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
            paramString.clickArea.setTag(parama);
          }
          AppMethodBeat.o(163366);
          return;
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(163368);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163368);
        return false;
      }
      w.b(parama.WQv.getContext(), paramca);
      AppMethodBeat.o(163368);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(210578);
      int j = ((by)paramView.getTag()).position;
      if (!((ak)com.tencent.mm.kernel.h.ag(ak.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((paramca != null) && (com.tencent.mm.by.c.blP("favorite")) && (i == 0)) {
          paramo.a(j, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        AppMethodBeat.o(210578);
        return true;
      }
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 838860849) || (paramInt == 1006633009));
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(163369);
      String str = paramca.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aG(str, paramca.field_reserved);
      }
      paramView = w.p(paramView);
      if (paramView != null) {
        w.a(parama.WQv.getContext(), paramca, paramView);
      }
      AppMethodBeat.o(163369);
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
      AppMethodBeat.i(163370);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.edW);
        ((View)localObject).setTag(new w.a().S((View)localObject, true));
      }
      AppMethodBeat.o(163370);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(163371);
      this.WBq = parama1;
      paramString = (w.a)parama;
      Object localObject = paramca.field_content;
      parama = null;
      if (localObject != null) {
        parama = k.b.aG((String)localObject, paramca.field_reserved);
      }
      if (parama != null)
      {
        localObject = w.p(parama);
        if (localObject != null)
        {
          if (((bjg)localObject).wXA != 1) {
            break label314;
          }
          parama = MMApplicationContext.getContext().getString(R.l.finder_topic_card_prefix, new Object[] { ((bjg)localObject).topic });
          paramString.OZK.setText(l.c(parama1.WQv.getContext(), parama));
          parama = com.tencent.mm.loader.e.kMy;
          com.tencent.mm.loader.e.aRs().a(((bjg)localObject).iconUrl, paramString.finderIcon, w.hTN());
          paramString.finderDesc.setText(((bjg)localObject).desc);
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
        AppMethodBeat.o(163371);
        return;
        label314:
        parama = ((bjg)localObject).topic;
        break;
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
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(163374);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(163374);
        return false;
      }
      w.b(parama.WQv.getContext(), paramca);
      AppMethodBeat.o(163374);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(274278);
      int j = ((by)paramView.getTag()).position;
      if (!((ak)com.tencent.mm.kernel.h.ag(ak.class)).showFinderEntry()) {}
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
        AppMethodBeat.o(274278);
        return true;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(274277);
      if (paramca.erk())
      {
        m.bh(paramca);
        bq.Gk(paramca.field_msgId);
        parama.Gi(true);
      }
      AppMethodBeat.o(274277);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 838860849) || (paramInt == 1006633009));
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(163375);
      String str = paramca.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aG(str, paramca.field_reserved);
      }
      paramView = w.p(paramView);
      if (paramView != null) {
        w.a(parama.WQv.getContext(), paramca, paramView);
      }
      AppMethodBeat.o(163375);
      return false;
    }
    
    public final boolean hTD()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.w
 * JD-Core Version:    0.7.0.1
 */