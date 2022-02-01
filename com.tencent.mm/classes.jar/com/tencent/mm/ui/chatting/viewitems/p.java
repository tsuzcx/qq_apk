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
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.n;

public final class p
{
  private static com.tencent.mm.loader.c.e FKT;
  private static String TAG;
  
  static
  {
    AppMethodBeat.i(289052);
    TAG = "Finder.ChattingItemAppMsgFinderTopic";
    e.a locala = new e.a();
    locala.kOp = true;
    locala.kOo = true;
    FKT = locala.aRT();
    AppMethodBeat.o(289052);
  }
  
  static final class a
    extends c.a
  {
    public TextView OZK;
    public TextView Xgf;
    public TextView finderDesc;
    public ImageView finderIcon;
    public ImageView tickIV;
    
    public final a M(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(269005);
      super.create(paramView);
      this.OZK = ((TextView)paramView.findViewById(R.h.dyj));
      this.finderIcon = ((ImageView)paramView.findViewById(R.h.dyl));
      this.finderDesc = ((TextView)paramView.findViewById(R.h.dyk));
      this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      this.Xgf = ((TextView)paramView.findViewById(R.h.dyb));
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
        AppMethodBeat.o(269005);
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
      AppMethodBeat.i(207058);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.ecW);
        ((View)localObject).setTag(new p.a().M((View)localObject, false));
      }
      AppMethodBeat.o(207058);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(207061);
      this.WBq = parama1;
      paramString = (p.a)parama;
      parama = paramca.field_content;
      if (parama != null) {}
      for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
      {
        bjg localbjg;
        if (parama != null)
        {
          localbjg = p.p(parama);
          if ((localbjg != null) && (localbjg.STw != null))
          {
            if (localbjg.wXA != 7) {
              break label265;
            }
            parama = MMApplicationContext.getContext().getString(R.l.finder_activity_share_conversation_wording, new Object[] { localbjg.STw.SCS, localbjg.STw.SCR });
            paramString.Xgf.setText(MMApplicationContext.getContext().getText(R.l.finder_campaign_share_tail_text));
            paramString.OZK.setText(l.c(parama1.WQv.getContext(), parama));
            if (!Util.isNullOrNil(localbjg.iconUrl)) {
              break label274;
            }
            paramString.finderIcon.setVisibility(4);
          }
        }
        for (;;)
        {
          paramString.finderDesc.setText(localbjg.desc);
          if (paramString.clickArea != null)
          {
            paramString.clickArea.setOnClickListener(d(parama1));
            paramString.clickArea.setOnLongClickListener(c(parama1));
            paramString.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
            parama = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
            paramString.clickArea.setTag(parama);
          }
          AppMethodBeat.o(207061);
          return;
          label265:
          parama = localbjg.topic;
          break;
          label274:
          paramString.finderIcon.setVisibility(0);
          parama = com.tencent.mm.loader.e.kMy;
          com.tencent.mm.loader.e.aRs().a(localbjg.iconUrl, paramString.finderIcon, p.hTN());
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(207066);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(207066);
        return false;
      }
      p.b(parama.WQv.getContext(), paramca);
      AppMethodBeat.o(207066);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(207063);
      int j = ((by)paramView.getTag()).position;
      if (!((ak)h.ag(ak.class)).showFinderEntry()) {}
      for (int i = 1;; i = 0)
      {
        if ((paramca != null) && (com.tencent.mm.by.c.blP("favorite")) && (i == 0)) {
          paramo.a(j, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        AppMethodBeat.o(207063);
        return true;
      }
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 1023475761) || (paramInt == 1023541297));
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(207067);
      String str = paramca.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aG(str, paramca.field_reserved);
      }
      paramView = p.p(paramView);
      if (paramView != null) {
        p.a(parama.WQv.getContext(), paramca, paramView);
      }
      AppMethodBeat.o(207067);
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
      AppMethodBeat.i(247453);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.edW);
        ((View)localObject).setTag(new p.a().M((View)localObject, true));
      }
      AppMethodBeat.o(247453);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(247454);
      this.WBq = parama1;
      paramString = (p.a)parama;
      Object localObject = paramca.field_content;
      parama = null;
      if (localObject != null) {
        parama = k.b.aG((String)localObject, paramca.field_reserved);
      }
      if (parama != null)
      {
        localObject = p.p(parama);
        if ((localObject != null) && (((bjg)localObject).STw != null))
        {
          if (((bjg)localObject).wXA != 7) {
            break label351;
          }
          parama = MMApplicationContext.getContext().getString(R.l.finder_activity_share_conversation_wording, new Object[] { ((bjg)localObject).STw.SCS, ((bjg)localObject).STw.SCR });
          paramString.Xgf.setText(MMApplicationContext.getContext().getText(R.l.finder_campaign_share_tail_text));
          paramString.OZK.setText(l.c(parama1.WQv.getContext(), parama));
          if (!Util.isNullOrNil(((bjg)localObject).iconUrl)) {
            break label360;
          }
          paramString.finderIcon.setVisibility(4);
          label169:
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
        AppMethodBeat.o(247454);
        return;
        label351:
        parama = ((bjg)localObject).topic;
        break;
        label360:
        paramString.finderIcon.setVisibility(0);
        parama = com.tencent.mm.loader.e.kMy;
        com.tencent.mm.loader.e.aRs().a(((bjg)localObject).iconUrl, paramString.finderIcon, p.hTN());
        break label169;
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
      AppMethodBeat.i(247460);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(247460);
        return false;
      }
      p.b(parama.WQv.getContext(), paramca);
      AppMethodBeat.o(247460);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(247458);
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
        AppMethodBeat.o(247458);
        return true;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(247456);
      if (paramca.erk())
      {
        m.bh(paramca);
        bq.Gk(paramca.field_msgId);
        parama.Gi(true);
      }
      AppMethodBeat.o(247456);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 1023475761) || (paramInt == 1023541297));
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(247461);
      String str = paramca.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aG(str, paramca.field_reserved);
      }
      paramView = p.p(paramView);
      if (paramView != null) {
        p.a(parama.WQv.getContext(), paramca, paramView);
      }
      AppMethodBeat.o(247461);
      return false;
    }
    
    public final boolean hTD()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p
 * JD-Core Version:    0.7.0.1
 */