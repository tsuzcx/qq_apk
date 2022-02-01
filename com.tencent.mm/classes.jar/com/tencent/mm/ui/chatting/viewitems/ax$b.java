package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.c.b.an;
import com.tencent.mm.ui.chatting.c.b.i;

public final class ax$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  private ax.c IpI;
  
  private ax.c fqI()
  {
    AppMethodBeat.i(37442);
    if (this.IpI == null) {
      this.IpI = new ax.c(this.HNS);
    }
    ax.c localc = this.IpI;
    AppMethodBeat.o(37442);
    return localc;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37443);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493503);
      ((View)localObject).setTag(new ax.d().z((View)localObject, false));
    }
    AppMethodBeat.o(37443);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37444);
    this.HNS = parama1;
    parama = (ax.d)parama;
    ax.d.a(parama, parambo, false, paramInt, parama1, fqI(), c(parama1));
    if (fqw())
    {
      paramString = u.Ej(parambo.field_imgPath);
      if ((paramString != null) && (paramString.status == 199) && (a((i)parama1.bf(i.class), parambo.field_msgId)))
      {
        if (parama.Ijf != null)
        {
          parama.Ijf.setVisibility(0);
          AppMethodBeat.o(37444);
        }
      }
      else if (parama.Ijf != null) {
        parama.Ijf.setVisibility(8);
      }
    }
    AppMethodBeat.o(37444);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37445);
    az.ayM();
    int i;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (paramView == null)
      {
        AppMethodBeat.o(37445);
        return false;
      }
      i = ((bj)paramView.getTag()).position;
      s locals = o.aJy().DT(parambo.field_imgPath);
      Object localObject = paramContextMenu.add(i, 130, 0, paramView.getContext().getString(2131757227));
      int j = paramView.getWidth();
      int k = paramView.getHeight();
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      Intent localIntent = new Intent();
      localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
      ((MenuItem)localObject).setIntent(localIntent);
      if (locals == null) {
        break label501;
      }
      j = locals.status;
      if ((104 != j) && (103 != j) && (105 != j) && (106 != j)) {
        paramContextMenu.add(i, 107, 0, paramView.getContext().getString(2131762559));
      }
      if ((locals == null) || ((locals.status != 199) && (locals.status != 199))) {
        break label532;
      }
      if (d.aCT("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
      }
      localObject = new com.tencent.mm.g.a.dy();
      ((com.tencent.mm.g.a.dy)localObject).ddK.msgId = parambo.field_msgId;
      com.tencent.mm.sdk.b.a.GpY.l((b)localObject);
      if (((com.tencent.mm.g.a.dy)localObject).ddL.ddj) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
      }
      if ((!parambo.eZj()) && ((parambo.crt()) || (parambo.crv())) && (b(parambo, this.HNS)) && ((locals.status == 199) || (locals.status == 199) || (parambo.eSf == 1)) && (aQE(parambo.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
      }
      if ((f.aCy()) && (!this.HNS.foR())) {
        paramContextMenu.add(i, 114, 0, paramView.getContext().getString(2131757217));
      }
    }
    for (;;)
    {
      if (!this.HNS.foR()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757222));
      }
      AppMethodBeat.o(37445);
      return true;
      label501:
      if (!parambo.cru()) {
        break;
      }
      paramContextMenu.add(i, 107, 0, paramView.getContext().getString(2131762559));
      break;
      label532:
      if ((parambo.cru()) && (d.aCT("favorite"))) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37446);
    ((an)parama.bf(an.class)).a(paramMenuItem, parambo);
    AppMethodBeat.o(37446);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37447);
    fqI().onClick(paramView);
    AppMethodBeat.o(37447);
    return true;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 43) || (paramInt == 486539313));
  }
  
  public final boolean fqu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax.b
 * JD-Core Version:    0.7.0.1
 */