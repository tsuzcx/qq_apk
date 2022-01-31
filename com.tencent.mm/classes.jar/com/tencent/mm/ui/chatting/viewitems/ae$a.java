package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.at.e;
import com.tencent.mm.at.o;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.j;

public final class ae$a
  extends c
{
  private ae.c zWk;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public static void a(Context paramContext, c.a parama, bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(33234);
    if (true != paramBoolean)
    {
      AppMethodBeat.o(33234);
      return;
    }
    if ((parama instanceof ae.d))
    {
      parama = (ae.d)parama;
      o.ahC().a(parama.zTT, parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(paramContext), parambi.dGS, parambi.dGT, parama.zUt, 2130838226, 1, null);
    }
    AppMethodBeat.o(33234);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33229);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969084);
      ((View)localObject).setTag(new ae.d().A((View)localObject, true));
    }
    AppMethodBeat.o(33229);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33230);
    this.zzP = parama1;
    ((j)parama1.ay(j.class)).bg(parambi);
    ae.d locald = (ae.d)parama;
    boolean bool = o.ahC().a(locald.zTT, parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama1.zJz.getContext()), parambi.dGS, parambi.dGT, locald.zUt, 2130838223, 1, null);
    locald.zWn.setVisibility(0);
    locald.pNd.setVisibility(8);
    if ((!bool) && (!this.kFs)) {
      locald.zTT.setImageBitmap(BitmapFactory.decodeResource(parama1.zJz.getMMResources(), 2130838223));
    }
    parama = null;
    if (parama1.dJG()) {
      parama = parambi.field_talker;
    }
    locald.jYu.setTag(new az(parambi, parama1.dJG(), paramInt, paramString, parama));
    parama = locald.jYu;
    if (this.zWk == null) {
      this.zWk = new ae.c(this.zzP, this);
    }
    parama.setOnClickListener(this.zWk);
    locald.jYu.setOnLongClickListener(c(parama1));
    locald.jYu.setOnTouchListener(((h)parama1.ay(h.class)).dHi());
    ae.a(parambi, parama1, locald);
    AppMethodBeat.o(33230);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33232);
    aw.aaz();
    int k;
    Object localObject1;
    Object localObject2;
    int j;
    int i;
    if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null) && (parambi != null))
    {
      k = ((az)paramView.getTag()).position;
      localObject1 = null;
      if (parambi.field_msgId > 0L) {
        localObject1 = o.ahC().gT(parambi.field_msgId);
      }
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((e)localObject1).fDL > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (parambi.field_msgSvrId > 0L) {
          localObject2 = o.ahC().gS(parambi.field_msgSvrId);
        }
      }
      paramContextMenu.add(k, 110, 0, paramView.getContext().getString(2131302650));
      if ((f.aeP()) && (!this.zzP.dJH())) {
        paramContextMenu.add(k, 114, 0, paramView.getContext().getString(2131298228));
      }
      if (d.ahR("favorite")) {
        paramContextMenu.add(k, 116, 0, paramView.getContext().getString(2131302102));
      }
      localObject1 = new dr();
      ((dr)localObject1).crt.cpO = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
      if ((((dr)localObject1).cru.cqS) || (com.tencent.mm.pluginsdk.model.app.g.ag(this.zzP.zJz.getContext(), parambi.getType()))) {
        paramContextMenu.add(k, 129, 0, paramView.getContext().getString(2131298238));
      }
      if ((localObject2 != null) && (((e)localObject2).status != -1))
      {
        localObject1 = paramContextMenu.add(k, 131, 0, paramView.getContext().getString(2131298194));
        localObject2 = new int[2];
        if (paramView == null) {
          break label452;
        }
        j = paramView.getWidth();
        i = paramView.getHeight();
        paramView.getLocationInWindow((int[])localObject2);
      }
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", localObject2[0]).putExtra("img_gallery_top", localObject2[1]);
      ((MenuItem)localObject1).setIntent(localIntent);
      if (bh.o(parambi)) {
        paramContextMenu.clear();
      }
      if (!this.zzP.dJH()) {
        paramContextMenu.add(k, 100, 0, paramView.getContext().getString(2131298231));
      }
      AppMethodBeat.o(33232);
      return true;
      label452:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33233);
    if (100 == paramMenuItem.getItemId()) {
      ae.b(parambi, parama);
    }
    for (;;)
    {
      AppMethodBeat.o(33233);
      return false;
      if (131 == paramMenuItem.getItemId()) {
        ae.b(parama, paramMenuItem, parambi);
      } else {
        ((aa)parama.ay(aa.class)).a(paramMenuItem, parambi);
      }
    }
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 39) || (paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 33));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    return false;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(33231);
    boolean bool = parama.dJG();
    AppMethodBeat.o(33231);
    return bool;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.a
 * JD-Core Version:    0.7.0.1
 */