package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.uj.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.k;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class aa$b
  extends c
  implements com.tencent.mm.modelappbrand.h, s.n
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  private ab joq;
  
  public aa$b()
  {
    AppMethodBeat.i(37091);
    this.joq = new ac(this);
    AppMethodBeat.o(37091);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(37097);
    Object localObject = paramView.getTag();
    if (!(localObject instanceof aa.d))
    {
      AppMethodBeat.o(37097);
      return;
    }
    ad.i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
    paramView = (aa.d)localObject;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      paramView.lIL.ffc();
      paramView.lIL.setVisibility(4);
      paramView.GMD.setVisibility(4);
      paramView.nMg.setVisibility(0);
      paramView.nMg.setImageResource(2131689648);
      AppMethodBeat.o(37097);
      return;
    case 0: 
      paramView.lIL.setVisibility(0);
      paramView.lIL.ffb();
      paramView.GMD.setVisibility(4);
      paramView.nMg.setVisibility(4);
      AppMethodBeat.o(37097);
      return;
    case 1: 
      paramView.lIL.ffc();
      paramView.lIL.setVisibility(4);
      paramView.GMD.setVisibility(4);
      paramView.nMg.setVisibility(0);
      paramView.nMg.setImageResource(2131690080);
      AppMethodBeat.o(37097);
      return;
    }
    paramView.lIL.ffc();
    paramView.lIL.setVisibility(4);
    paramView.GMD.setVisibility(0);
    paramView.nMg.setVisibility(4);
    AppMethodBeat.o(37097);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37092);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new af(paramLayoutInflater, 2131493493);
      paramLayoutInflater = new aa.d().F((View)localObject, false);
      paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).cq(((View)localObject).getContext());
      paramLayoutInflater.GMD = paramView;
      paramLayoutInflater.GMC.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37092);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37098);
    if (parambl.cxB())
    {
      com.tencent.mm.pluginsdk.model.app.m.aB(parambl);
      com.tencent.mm.model.bi.lW(parambl.field_msgId);
      parama.wc(true);
      AppMethodBeat.o(37098);
      return;
    }
    AppMethodBeat.o(37098);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37093);
    aa.d locald = (aa.d)parama;
    this.Gob = parama1;
    parama = (k)parama1.be(k.class);
    parama.bC(parambl);
    paramString = parambl.field_content;
    parama.bA(parambl);
    if (paramString != null) {}
    for (parama = k.b.ar(paramString, parambl.field_reserved);; parama = null)
    {
      bi localbi = new bi(parambl, parama1.eZb(), paramInt, null, '\000');
      Object localObject;
      if (parama != null)
      {
        locald.GIS.setVisibility(8);
        locald.GIR.setVisibility(8);
        locald.GIO.setVisibility(8);
        locald.GJp.setVisibility(8);
        localObject = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).FW(parama.gJE);
        if (localObject == null) {
          break label715;
        }
        paramString = ((WxaAttributes)localObject).field_nickname;
        if (localObject == null) {
          break label724;
        }
        localObject = ((WxaAttributes)localObject).field_smallHeadURL;
        label170:
        locald.GJp.setVisibility(0);
        locald.GMB.setVisibility(8);
        locald.GJt.setText(parama.title);
        locald.GMB.setText(parama.description);
        locald.GJn.setText(paramString);
        switch (parama.gJQ)
        {
        default: 
          locald.GJo.setText(2131755401);
          label259:
          o.ayJ().a((String)localObject, locald.GJm, aa.d.frV);
          if (faG())
          {
            paramString = (i)parama1.be(i.class);
            if ((parambl.field_status == 2) && (a(paramString, parambl.field_msgId)))
            {
              if (locald.GJi != null) {
                locald.GJi.setVisibility(0);
              }
              label332:
              if (locald.uPp != null) {
                locald.uPp.setVisibility(8);
              }
              label350:
              paramString = (com.tencent.mm.ai.a)parama.ao(com.tencent.mm.ai.a.class);
              localObject = new Bundle();
              ((Bundle)localObject).putString("app_id", parama.gJF);
              ((Bundle)localObject).putString("msg_id", parambl.field_msgId);
              if (paramString == null) {
                break label821;
              }
              paramString = paramString.gFn;
              label421:
              ((Bundle)localObject).putString("cache_key", paramString);
              ((Bundle)localObject).putString("msg_title", parama.title);
              ((Bundle)localObject).putString("msg_path", parama.gJD);
              ((Bundle)localObject).putInt("msg_pkg_type", parama.gJQ);
              ((Bundle)localObject).putInt("pkg_version", parama.aAS);
              ((Bundle)localObject).putInt("widget_type", 0);
              if (!parama1.eZb()) {
                break label827;
              }
            }
          }
          break;
        }
      }
      label821:
      label827:
      for (int i = 1008;; i = 1007)
      {
        ((Bundle)localObject).putInt("scene", i);
        ((Bundle)localObject).putInt("view_init_width", aa.d.GMz);
        ((Bundle)localObject).putInt("view_init_height", aa.d.GMA);
        locald.GMD.setTag(locald);
        ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).a(com.tencent.mm.plugin.appbrand.aa.m.cF(parama1), locald.GMD, (Bundle)localObject, this.joq);
        ((q)com.tencent.mm.kernel.g.ab(q.class)).Ew(parama.gJE);
        locald.naN.setTag(localbi);
        locald.naN.setOnClickListener(d(parama1));
        localObject = y.arz().E(com.tencent.mm.plugin.appbrand.aa.m.cF(parama1), true);
        paramString = (aa.c)((y.b)localObject).get("listener", null);
        parama = paramString;
        if (paramString == null)
        {
          parama = new aa.c();
          ((y.b)localObject).m("listener", parama);
        }
        parama.n(parama1);
        if (this.nMt) {
          locald.naN.setOnLongClickListener(c(parama1));
        }
        a(paramInt, locald, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
        AppMethodBeat.o(37093);
        return;
        label715:
        paramString = parama.dxA;
        break;
        label724:
        localObject = parama.gJS;
        break label170;
        locald.GJo.setText(2131755657);
        break label259;
        locald.GJo.setText(2131755656);
        break label259;
        if (locald.GJi == null) {
          break label332;
        }
        locald.GJi.setVisibility(8);
        break label332;
        if (locald.uPp == null) {
          break label350;
        }
        locald.uPp.setVisibility(0);
        if (parambl.field_status < 2) {
          break label350;
        }
        locald.uPp.setVisibility(8);
        break label350;
        paramString = null;
        break label421;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37094);
    int i = ((bi)paramView.getTag()).position;
    if (parambl.field_content == null)
    {
      AppMethodBeat.o(37094);
      return true;
    }
    k.b localb = k.b.rx(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
    if (localb == null)
    {
      AppMethodBeat.o(37094);
      return true;
    }
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.j(localb.appId, false, false))) && (!j.aS(parambl))) {
      paramContextMenu.add(i, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
    }
    if (((parambl.field_status == 2) || (parambl.eOX == 1)) && (b(parambl, this.Gob)) && (aKZ(parambl.field_talker))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
    }
    dx localdx = new dx();
    localdx.dgp.msgId = parambl.field_msgId;
    com.tencent.mm.sdk.b.a.ESL.l(localdx);
    if ((localdx.dgq.dfO) || (e.b.a(this.Gob.GzJ.getContext(), localb))) {
      paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
    }
    if (!this.Gob.eZc()) {
      paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
    }
    paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atL();
    if ((paramView.atR()) || (paramView.nz(localb.gJQ)))
    {
      paramContextMenu.add(i, 133, 0, this.Gob.GzJ.getMMResources().getString(2131757231));
      paramContextMenu.add(i, 132, 0, this.Gob.GzJ.getMMResources().getString(2131757230));
    }
    AppMethodBeat.o(37094);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37095);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37095);
      return false;
    case 111: 
      e.b.a(parama, parambl, b(parama, parambl));
      AppMethodBeat.o(37095);
      return false;
    case 103: 
      paramMenuItem = parambl.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37095);
        return false;
      }
      paramMenuItem = k.b.rx(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(37095);
        return false;
        parama = new je();
        parama.dnm.dnn = paramMenuItem.dnn;
        parama.dnm.ded = parambl.field_msgId;
        parama.dnm.dno = parambl.field_talker;
        com.tencent.mm.sdk.b.a.ESL.l(parama);
      }
    case 133: 
      Object localObject = parambl.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = k.b.rx((String)localObject);
      }
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37095);
        return false;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.gJF);
      ((Bundle)localObject).putString("msg_id", parambl.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.gJQ);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.gJI);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atL().d(parama.GzJ.getContext(), (Bundle)localObject);
      AppMethodBeat.o(37095);
      return false;
    }
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atL().cr(parama.GzJ.getContext());
    AppMethodBeat.o(37095);
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37096);
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(parambl.field_talker);
    paramView.getTag();
    paramView = parambl.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(37096);
      return false;
    }
    paramView = k.b.rx(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(37096);
      return false;
    }
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.j(paramView.appId, true, false);
    if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId))) {
      a(parama, paramView, u.aqG(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, parambl.field_msgSvrId, parama.getTalkerUserName());
    }
    localObject1 = new uj();
    ((uj)localObject1).dzH.appId = paramView.gJF;
    ((uj)localObject1).dzH.userName = paramView.gJE;
    ((uj)localObject1).dzH.dzJ = paramView.gJD;
    ((uj)localObject1).dzH.dzK = paramView.gJQ;
    ((uj)localObject1).dzH.dzM = paramView.gJH;
    ((uj)localObject1).dzH.aAS = paramView.gJR;
    Object localObject2 = ((uj)localObject1).dzH;
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramView.gJQ != 0)
    {
      bool = true;
      ((uj.a)localObject2).dzN = bool;
      localObject2 = paramView.gJJ;
      if (!parama.eZb()) {
        break label354;
      }
      ((uj)localObject1).dzH.scene = 1008;
      localStringBuilder = new StringBuilder(parama.getTalkerUserName());
      localStringBuilder.append(":");
      localStringBuilder.append(b(parama, parambl));
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject2);
    }
    for (((uj)localObject1).dzH.dbt = localStringBuilder.toString();; ((uj)localObject1).dzH.dbt = parambl.toString())
    {
      ((uj)localObject1).dzH.dzP.cff = parama.getTalkerUserName();
      ((uj)localObject1).dzH.dzP.cfh = paramView.gJK;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(37096);
      return true;
      bool = false;
      break;
      label354:
      ((uj)localObject1).dzH.scene = 1007;
      parambl = new StringBuilder(b(parama, parambl));
      parambl.append(":");
      parambl.append((String)localObject2);
    }
  }
  
  public final boolean faE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.b
 * JD-Core Version:    0.7.0.1
 */