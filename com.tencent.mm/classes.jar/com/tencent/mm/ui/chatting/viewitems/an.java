package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.ai;
import com.tencent.mm.ui.chatting.c.b.h;

public final class an
{
  public static final class b
    extends c
  {
    private an.c zXz;
    private com.tencent.mm.ui.chatting.d.a zzP;
    
    private an.c dLw()
    {
      AppMethodBeat.i(33340);
      if (this.zXz == null) {
        this.zXz = new an.c(this.zzP);
      }
      an.c localc = this.zXz;
      AppMethodBeat.o(33340);
      return localc;
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(33341);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new w(paramLayoutInflater, 2130969124);
        ((View)localObject).setTag(new an.d().A((View)localObject, false));
      }
      AppMethodBeat.o(33341);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
    {
      AppMethodBeat.i(33342);
      this.zzP = parama1;
      parama = (an.d)parama;
      an.d.a(parama, parambi, false, paramInt, parama1, dLw(), c(parama1));
      if (dLr())
      {
        paramString = u.vr(parambi.field_imgPath);
        if ((paramString != null) && (paramString.status == 199) && (a((h)parama1.ay(h.class), parambi.field_msgId)))
        {
          if (parama.zSm != null)
          {
            parama.zSm.setVisibility(0);
            AppMethodBeat.o(33342);
          }
        }
        else if (parama.zSm != null) {
          parama.zSm.setVisibility(8);
        }
      }
      AppMethodBeat.o(33342);
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
    {
      AppMethodBeat.i(33343);
      aw.aaz();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        if (paramView == null)
        {
          AppMethodBeat.o(33343);
          return false;
        }
        int i = ((az)paramView.getTag()).position;
        s locals = o.alE().vd(parambi.field_imgPath);
        Object localObject = paramContextMenu.add(i, 130, 0, paramView.getContext().getString(2131298237));
        int j = paramView.getWidth();
        int k = paramView.getHeight();
        int[] arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        Intent localIntent = new Intent();
        localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
        ((MenuItem)localObject).setIntent(localIntent);
        if (locals != null)
        {
          j = locals.status;
          if ((104 != j) && (103 != j) && (105 != j) && (106 != j)) {
            paramContextMenu.add(i, 107, 0, paramView.getContext().getString(2131302650));
          }
        }
        if ((locals != null) && ((locals.status == 199) || (locals.status == 199)))
        {
          if (d.ahR("favorite")) {
            paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131302102));
          }
          localObject = new dr();
          ((dr)localObject).crt.cpO = parambi.field_msgId;
          com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
          if (((dr)localObject).cru.cqS) {
            paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131298238));
          }
          if ((!parambi.dvV()) && ((parambi.byj()) || (parambi.byk())) && (a(parambi, this.zzP)) && ((locals.status == 199) || (locals.status == 199) || (parambi.dGV == 1)) && (auk(parambi.field_talker))) {
            paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131298244));
          }
          if ((f.aeQ()) && (!this.zzP.dJH())) {
            paramContextMenu.add(i, 114, 0, paramView.getContext().getString(2131298228));
          }
        }
        if (!this.zzP.dJH()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131298233));
        }
      }
      AppMethodBeat.o(33343);
      return true;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
    {
      AppMethodBeat.i(33344);
      ((ai)parama.ay(ai.class)).a(paramMenuItem, parambi);
      AppMethodBeat.o(33344);
      return false;
    }
    
    public final boolean aK(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 43);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
    {
      AppMethodBeat.i(33345);
      dLw().onClick(paramView);
      AppMethodBeat.o(33345);
      return true;
    }
    
    public final boolean dLp()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an
 * JD-Core Version:    0.7.0.1
 */