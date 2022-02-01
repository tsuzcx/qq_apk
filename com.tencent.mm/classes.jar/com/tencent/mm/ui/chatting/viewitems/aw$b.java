package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.c.b.an;
import com.tencent.mm.ui.chatting.c.b.i;

public final class aw$b
  extends c
{
  private aw.c GPG;
  private com.tencent.mm.ui.chatting.d.a Gob;
  
  private aw.c faS()
  {
    AppMethodBeat.i(37442);
    if (this.GPG == null) {
      this.GPG = new aw.c(this.Gob);
    }
    aw.c localc = this.GPG;
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
      localObject = new af(paramLayoutInflater, 2131493503);
      ((View)localObject).setTag(new aw.d().z((View)localObject, false));
    }
    AppMethodBeat.o(37443);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37444);
    this.Gob = parama1;
    parama = (aw.d)parama;
    aw.d.a(parama, parambl, false, paramInt, parama1, faS(), c(parama1));
    if (faG())
    {
      paramString = u.Ae(parambl.field_imgPath);
      if ((paramString != null) && (paramString.status == 199) && (a((i)parama1.be(i.class), parambl.field_msgId)))
      {
        if (parama.GJi != null)
        {
          parama.GJi.setVisibility(0);
          AppMethodBeat.o(37444);
        }
      }
      else if (parama.GJi != null) {
        parama.GJi.setVisibility(8);
      }
    }
    AppMethodBeat.o(37444);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37445);
    az.arV();
    int i;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (paramView == null)
      {
        AppMethodBeat.o(37445);
        return false;
      }
      i = ((bi)paramView.getTag()).position;
      s locals = o.aCI().zO(parambl.field_imgPath);
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
      if (d.axB("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
      }
      localObject = new dx();
      ((dx)localObject).dgp.msgId = parambl.field_msgId;
      com.tencent.mm.sdk.b.a.ESL.l((b)localObject);
      if (((dx)localObject).dgq.dfO) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
      }
      if ((!parambl.eJL()) && ((parambl.cjM()) || (parambl.cjO())) && (b(parambl, this.Gob)) && ((locals.status == 199) || (locals.status == 199) || (parambl.eOX == 1)) && (aKZ(parambl.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
      }
      if ((f.avG()) && (!this.Gob.eZc())) {
        paramContextMenu.add(i, 114, 0, paramView.getContext().getString(2131757217));
      }
    }
    for (;;)
    {
      if (!this.Gob.eZc()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131757222));
      }
      AppMethodBeat.o(37445);
      return true;
      label501:
      if (!parambl.cjN()) {
        break;
      }
      paramContextMenu.add(i, 107, 0, paramView.getContext().getString(2131762559));
      break;
      label532:
      if ((parambl.cjN()) && (d.axB("favorite"))) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37446);
    ((an)parama.be(an.class)).a(paramMenuItem, parambl);
    AppMethodBeat.o(37446);
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 43) || (paramInt == 486539313));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37447);
    faS().onClick(paramView);
    AppMethodBeat.o(37447);
    return true;
  }
  
  public final boolean faE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw.b
 * JD-Core Version:    0.7.0.1
 */