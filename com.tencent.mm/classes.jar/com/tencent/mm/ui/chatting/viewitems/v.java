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
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.n;

public final class v
{
  private static com.tencent.mm.loader.c.e FKT;
  private static String TAG;
  
  static
  {
    AppMethodBeat.i(278249);
    TAG = "Finder.ChattingItemAppMsgFinderPoi";
    e.a locala = new e.a();
    locala.kOp = true;
    locala.kOo = true;
    FKT = locala.aRT();
    AppMethodBeat.o(278249);
  }
  
  static final class a
    extends c.a
  {
    public TextView OZK;
    public TextView finderDesc;
    public ImageView finderIcon;
    public ImageView tickIV;
    
    public final a R(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(228014);
      super.create(paramView);
      this.OZK = ((TextView)paramView.findViewById(R.h.dyj));
      this.finderIcon = ((ImageView)paramView.findViewById(R.h.dyg));
      this.finderDesc = ((TextView)paramView.findViewById(R.h.dyf));
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
        AppMethodBeat.o(228014);
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
      AppMethodBeat.i(271866);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.ecV);
        ((View)localObject).setTag(new v.a().R((View)localObject, false));
      }
      AppMethodBeat.o(271866);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(271867);
      this.WBq = parama1;
      paramString = (v.a)parama;
      parama = paramca.field_content;
      if (parama != null) {}
      for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
      {
        if (parama != null)
        {
          parama = v.r(parama);
          if (parama != null)
          {
            Object localObject = parama.poiName;
            paramString.OZK.setText(l.c(parama1.WQv.getContext(), (CharSequence)localObject));
            paramString.finderDesc.setText(parama.xzN);
            if (Util.isNullOrNil(parama.QSw)) {
              break label211;
            }
            localObject = com.tencent.mm.loader.e.kMy;
            com.tencent.mm.loader.e.aRs().a(parama.QSw, paramString.finderIcon, v.hTN());
          }
        }
        for (;;)
        {
          if (paramString.clickArea != null)
          {
            paramString.clickArea.setOnClickListener(d(parama1));
            paramString.clickArea.setOnLongClickListener(c(parama1));
            paramString.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
            parama = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
            paramString.clickArea.setTag(parama);
          }
          AppMethodBeat.o(271867);
          return;
          label211:
          paramString.finderIcon.setImageResource(R.k.icons_outlined_location);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(271869);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(271869);
        return false;
      }
      v.b(parama.WQv.getContext(), paramca);
      AppMethodBeat.o(271869);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(271868);
      int i = ((by)paramView.getTag()).position;
      if ((paramca != null) && (com.tencent.mm.by.c.blP("favorite"))) {
        paramo.a(i, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      AppMethodBeat.o(271868);
      return true;
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 1057030193);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(271870);
      String str = paramca.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aG(str, paramca.field_reserved);
      }
      paramView = v.r(paramView);
      if (paramView != null) {
        v.a(parama.WQv.getContext(), paramca, paramView);
      }
      AppMethodBeat.o(271870);
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
      AppMethodBeat.i(271500);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new aq(paramLayoutInflater, R.i.edV);
        ((View)localObject).setTag(new v.a().R((View)localObject, true));
      }
      AppMethodBeat.o(271500);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(271501);
      this.WBq = parama1;
      paramString = (v.a)parama;
      parama = paramca.field_content;
      if (parama != null) {}
      for (parama = k.b.aG(parama, paramca.field_reserved);; parama = null)
      {
        if (parama != null)
        {
          parama = v.r(parama);
          if (parama != null)
          {
            Object localObject = parama.poiName;
            paramString.OZK.setText(l.c(parama1.WQv.getContext(), (CharSequence)localObject));
            paramString.finderDesc.setText(parama.xzN);
            if (Util.isNullOrNil(parama.QSw)) {
              break label292;
            }
            localObject = com.tencent.mm.loader.e.kMy;
            com.tencent.mm.loader.e.aRs().a(parama.QSw, paramString.finderIcon, v.hTN());
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
          AppMethodBeat.o(271501);
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
      AppMethodBeat.i(271505);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(271505);
        return false;
      }
      v.b(parama.WQv.getContext(), paramca);
      AppMethodBeat.o(271505);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(271504);
      int i = ((by)paramView.getTag()).position;
      if (paramca != null)
      {
        paramo.a(i, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        com.tencent.mm.by.c.blP("favorite");
        if (((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker)) && (!as.OS(this.WBq.getTalkerUserName()))) {
          paramo.a(i, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
        }
      }
      AppMethodBeat.o(271504);
      return true;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(271503);
      if (paramca.erk())
      {
        m.bh(paramca);
        bq.Gk(paramca.field_msgId);
        parama.Gi(true);
      }
      AppMethodBeat.o(271503);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 1057030193);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(271507);
      String str = paramca.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aG(str, paramca.field_reserved);
      }
      paramView = v.r(paramView);
      if (paramView != null) {
        v.a(parama.WQv.getContext(), paramca, paramView);
      }
      AppMethodBeat.o(271507);
      return false;
    }
    
    public final boolean hTD()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v
 * JD-Core Version:    0.7.0.1
 */