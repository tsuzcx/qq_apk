package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.i;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.n;
import java.util.List;

public final class z$c
  extends c
  implements t.n
{
  private a PhN;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(233740);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493584);
      ((View)localObject).setTag(new z.a().Q((View)localObject, true));
    }
    AppMethodBeat.o(233740);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(233741);
    this.PhN = parama1;
    paramString = (z.a)parama;
    paramString.detailLayout.animate().cancel();
    paramString.detailLayout.setTag(Long.valueOf(System.currentTimeMillis()));
    parama = paramca.field_content;
    if (parama != null) {}
    for (parama = k.b.aD(parama, paramca.field_reserved);; parama = null)
    {
      Object localObject;
      if (parama != null)
      {
        parama = (i)parama.as(i.class);
        if (parama != null)
        {
          localObject = com.tencent.mm.plugin.finder.loader.m.uJa;
          localObject = com.tencent.mm.plugin.finder.loader.m.dka();
          p localp = new p(parama.jlh.uNR, x.vEo);
          ImageView localImageView = paramString.finderAvatar;
          com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
          ((com.tencent.mm.loader.d)localObject).a(localp, localImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJh));
          paramString.finderNickname.setText(l.c(parama1.Pwc.getContext(), parama.jlh.nickname));
          ao.a(paramString.finderNickname.getPaint(), 0.8F);
          localObject = parama.jlh.mediaList;
          if (!((List)localObject).isEmpty())
          {
            if (!Util.isNullOrNil(((cok)((List)localObject).get(0)).coverUrl))
            {
              ((aj)g.ah(aj.class)).loadImage(((cok)((List)localObject).get(0)).coverUrl, paramString.finderThumb);
              z.a(paramString, (List)localObject);
            }
          }
          else
          {
            if (Util.isNullOrNil(parama.jlh.desc)) {
              break label548;
            }
            paramString.finderDesc.setText(l.c(parama1.Pwc.getContext(), parama.jlh.desc));
            paramString.finderDesc.setVisibility(0);
            label301:
            paramString.finderThumb.setVisibility(0);
            paramString.finderText.setVisibility(8);
            paramString.PKw.setVisibility(0);
            paramString.EpV.setVisibility(8);
          }
        }
        else
        {
          paramString.clickArea.setOnClickListener(d(parama1));
          paramString.clickArea.setOnLongClickListener(c(parama1));
          paramString.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
          parama = new bq(paramca, this.PhN.gRM(), paramInt, null, '\000');
          paramString.clickArea.setTag(parama);
        }
      }
      else
      {
        if (!gTW()) {
          break label582;
        }
        if (paramString.uploadingPB != null) {
          paramString.uploadingPB.setVisibility(8);
        }
        if ((paramca.field_status != 2) || (!b((k)parama1.bh(k.class), paramca.field_msgId))) {
          break label561;
        }
        if (paramString.tickIV != null) {
          paramString.tickIV.setVisibility(0);
        }
      }
      for (;;)
      {
        a(paramInt, paramString, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
        AppMethodBeat.o(233741);
        return;
        ((aj)g.ah(aj.class)).loadImage(((cok)((List)localObject).get(0)).thumbUrl, paramString.finderThumb);
        break;
        label548:
        paramString.finderDesc.setVisibility(8);
        break label301;
        label561:
        if (paramString.tickIV != null)
        {
          paramString.tickIV.setVisibility(8);
          continue;
          label582:
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
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(233744);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(233744);
      return false;
    }
    z.c(parama.Pwc.getContext(), paramca);
    AppMethodBeat.o(233744);
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233743);
    int j = ((bq)paramView.getTag()).position;
    if (!((aj)g.ah(aj.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if ((paramca != null) && (i == 0))
      {
        paramm.a(j, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
        com.tencent.mm.br.c.aZU("favorite");
        if (((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker)) && (!as.HF(this.PhN.getTalkerUserName()))) {
          paramm.a(j, 123, paramView.getContext().getString(2131757446), 2131690650);
        }
      }
      AppMethodBeat.o(233743);
      return true;
    }
  }
  
  public final void b(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(233742);
    if (paramca.dOQ())
    {
      com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
      bp.Ad(paramca.field_msgId);
      parama.BN(true);
    }
    AppMethodBeat.o(233742);
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 1023410225);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(233745);
    Object localObject2 = paramca.field_content;
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = k.b.aD((String)localObject2, paramca.field_reserved);
    }
    if (localObject1 != null)
    {
      localObject1 = (i)((k.b)localObject1).as(i.class);
      if (localObject1 != null)
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("feed_object_id", com.tencent.mm.ac.d.Ga(((i)localObject1).jlh.objectId));
        ((Intent)localObject2).putExtra("feed_object_nonceId", ((i)localObject1).jlh.objectNonceId);
        ((Intent)localObject2).putExtra("business_type", 1);
        ((Intent)localObject2).putExtra("finder_user_name", ((i)localObject1).jlh.username);
        if (!ab.Eq(paramca.field_talker)) {
          break label285;
        }
        ((Intent)localObject2).putExtra("report_scene", 2);
        ((Intent)localObject2).putExtra("key_finder_teen_mode_scene", 2);
      }
    }
    for (;;)
    {
      ((Intent)localObject2).putExtra("key_finder_teen_mode_check", true);
      ((Intent)localObject2).putExtra("key_finder_teen_mode_user_name", ((i)localObject1).jlh.nickname);
      ((Intent)localObject2).putExtra("key_finder_teen_mode_user_id", ((i)localObject1).jlh.username);
      ((Intent)localObject2).putExtra("from_user", paramca.field_talker);
      y localy = y.vXH;
      ((Intent)localObject2).putExtra("key_from_user_name", y.aw(paramca));
      localy = y.vXH;
      ((Intent)localObject2).putExtra("key_to_user_name", y.ax(paramca));
      ((Intent)localObject2).putExtra("tab_type", 6);
      z.a(paramView, parama, (i)localObject1, (Intent)localObject2, true, ab.Eq(paramca.field_talker));
      AppMethodBeat.o(233745);
      return false;
      label285:
      ((Intent)localObject2).putExtra("report_scene", 1);
      ((Intent)localObject2).putExtra("key_finder_teen_mode_scene", 1);
    }
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.c
 * JD-Core Version:    0.7.0.1
 */