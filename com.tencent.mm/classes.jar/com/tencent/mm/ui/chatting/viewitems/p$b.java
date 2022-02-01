package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import java.util.List;

public final class p$b
  extends c
{
  private a PhN;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(163339);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493533);
      ((View)localObject).setTag(new p.a().L((View)localObject, false));
    }
    AppMethodBeat.o(163339);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(163340);
    this.PhN = parama1;
    paramString = (p.a)parama;
    paramString.detailLayout.animate().cancel();
    paramString.detailLayout.setTag(Long.valueOf(System.currentTimeMillis()));
    parama = paramca.field_content;
    if (parama != null) {}
    for (parama = k.b.aD(parama, paramca.field_reserved);; parama = null)
    {
      Object localObject;
      if (parama != null)
      {
        parama = (f)parama.as(f.class);
        if (parama != null)
        {
          localObject = com.tencent.mm.plugin.finder.loader.m.uJa;
          localObject = com.tencent.mm.plugin.finder.loader.m.dka();
          com.tencent.mm.plugin.finder.loader.p localp = new com.tencent.mm.plugin.finder.loader.p(parama.jlg.uNR, x.vEo);
          ImageView localImageView = paramString.finderAvatar;
          com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
          ((com.tencent.mm.loader.d)localObject).a(localp, localImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJh));
          paramString.finderNickname.setText(l.c(parama1.Pwc.getContext(), parama.jlg.nickname));
          ao.a(paramString.finderNickname.getPaint(), 0.8F);
          localObject = parama.jlg.mediaList;
          if (!((List)localObject).isEmpty())
          {
            ((aj)g.ah(aj.class)).loadImage(((bch)((List)localObject).get(0)).thumbUrl, paramString.finderThumb);
            p.a(paramString, (List)localObject);
          }
          if (parama.jlg.vXJ != 1) {
            break label380;
          }
          paramString.finderDesc.setVisibility(8);
          paramString.finderThumb.setVisibility(8);
          paramString.finderText.setText(l.c(parama1.Pwc.getContext(), parama.jlg.desc));
          paramString.finderText.setVisibility(0);
        }
      }
      for (;;)
      {
        paramString.clickArea.setOnClickListener(d(parama1));
        paramString.clickArea.setOnLongClickListener(c(parama1));
        paramString.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
        parama = new bq(paramca, this.PhN.gRM(), paramInt, null, '\000');
        paramString.clickArea.setTag(parama);
        AppMethodBeat.o(163340);
        return;
        label380:
        if (!Util.isNullOrNil(parama.jlg.desc))
        {
          paramString.finderDesc.setText(l.c(parama1.Pwc.getContext(), parama.jlg.desc));
          paramString.finderDesc.setVisibility(0);
        }
        for (;;)
        {
          paramString.finderThumb.setVisibility(0);
          paramString.finderText.setVisibility(8);
          if ((parama.jlg.vXJ != 4) && (parama.jlg.vXJ != 6)) {
            break label504;
          }
          paramString.PKw.setVisibility(0);
          paramString.EpV.setVisibility(8);
          break;
          paramString.finderDesc.setVisibility(8);
        }
        label504:
        if (parama.jlg.vXJ == 2)
        {
          paramString.PKw.setVisibility(8);
          paramString.EpV.setVisibility(0);
          paramString.EpV.FdA = ((List)localObject).size();
        }
        else
        {
          paramString.PKw.setVisibility(8);
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(163342);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(163342);
      return false;
    }
    if (!WeChatBrands.Business.Entries.SessionChannels.checkAvailable(parama.Pwc.getContext()))
    {
      AppMethodBeat.o(163342);
      return true;
    }
    p.c(parama.Pwc.getContext(), paramca);
    AppMethodBeat.o(163342);
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233666);
    int j = ((bq)paramView.getTag()).position;
    if (!((aj)g.ah(aj.class)).showFinderEntry()) {}
    for (int i = 1;; i = 0)
    {
      if ((paramca != null) && (com.tencent.mm.br.c.aZU("favorite")) && (i == 0))
      {
        paramm.a(j, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
        paramm.a(j, 116, this.PhN.Pwc.getMMResources().getString(2131763947), 2131690551);
      }
      AppMethodBeat.o(233666);
      return true;
    }
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 754974769);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(163343);
    if (!WeChatBrands.Business.Entries.SessionChannels.checkAvailable(paramView.getContext()))
    {
      AppMethodBeat.o(163343);
      return true;
    }
    Object localObject2 = paramca.field_content;
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = k.b.aD((String)localObject2, paramca.field_reserved);
    }
    if (localObject1 != null)
    {
      localObject1 = (f)((k.b)localObject1).as(f.class);
      if (localObject1 != null)
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("feed_object_id", com.tencent.mm.ac.d.Ga(((f)localObject1).jlg.objectId));
        ((Intent)localObject2).putExtra("feed_object_nonceId", ((f)localObject1).jlg.objectNonceId);
        ((Intent)localObject2).putExtra("business_type", 0);
        ((Intent)localObject2).putExtra("finder_user_name", ((f)localObject1).jlg.username);
        if (!ab.Eq(paramca.field_talker)) {
          break label252;
        }
        ((Intent)localObject2).putExtra("report_scene", 2);
      }
    }
    for (;;)
    {
      ((Intent)localObject2).putExtra("from_user", paramca.field_talker);
      y localy = y.vXH;
      ((Intent)localObject2).putExtra("key_from_user_name", y.aw(paramca));
      localy = y.vXH;
      ((Intent)localObject2).putExtra("key_to_user_name", y.ax(paramca));
      ((Intent)localObject2).putExtra("tab_type", 6);
      p.a(paramView, parama, (f)localObject1, (Intent)localObject2, false, ab.Eq(paramca.field_talker));
      AppMethodBeat.o(163343);
      return false;
      label252:
      ((Intent)localObject2).putExtra("report_scene", 1);
    }
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p.b
 * JD-Core Version:    0.7.0.1
 */