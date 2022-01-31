package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.e;
import com.tencent.mm.at.n;
import com.tencent.mm.at.n.d;
import com.tencent.mm.at.o;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.s.n;
import java.util.concurrent.ConcurrentHashMap;

public final class ae$b
  extends c
  implements s.n
{
  private ae.c zWk;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public static void a(c.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33239);
    if (paramInt2 > 0) {
      if (paramInt1 >= paramInt2) {
        paramInt1 = 100;
      }
    }
    for (;;)
    {
      parama = (ae.d)parama;
      if ((paramInt1 < 100) || (parama.zWm.getVisibility() == 0)) {
        break;
      }
      AppMethodBeat.o(33239);
      return;
      paramInt1 = (int)(paramInt1 * 100L / paramInt2);
      continue;
      paramInt1 = 0;
    }
    parama.zWm.setText(paramInt1 + "%");
    if (dLr()) {
      parama.pNd.setVisibility(8);
    }
    for (;;)
    {
      parama.zWm.setVisibility(0);
      parama.zWn.setVisibility(0);
      AppMethodBeat.o(33239);
      return;
      parama.pNd.setVisibility(0);
    }
  }
  
  public static void a(c.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(33240);
    if ((paramBoolean == true) && ((parama instanceof ae.d)))
    {
      parama = (ae.d)parama;
      parama.pNd.setVisibility(4);
      parama.zWm.setVisibility(4);
      parama.zWn.setVisibility(4);
    }
    AppMethodBeat.o(33240);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33235);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969121);
      ((View)localObject).setTag(new ae.d().A((View)localObject, false));
    }
    AppMethodBeat.o(33235);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33241);
    parambi.dye();
    aw.aaz();
    com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
    ((aa)parama.ay(aa.class)).bc(parambi);
    AppMethodBeat.o(33241);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33236);
    this.zzP = parama1;
    paramString = (ae.d)parama;
    parama = n.ahs();
    long l = parambi.field_msgId;
    boolean bool2 = parama.fGc.containsKey(Long.valueOf(l));
    Object localObject1 = o.ahC().w(parambi);
    int i;
    int j;
    boolean bool1;
    Object localObject2;
    Object localObject3;
    label168:
    int k;
    if ((localObject1 != null) && (!bool2)) {
      if (n.ahs().gV(((e)localObject1).fDL))
      {
        parama = n.ahs().gW(((e)localObject1).fDL);
        i = (int)parama.czn;
        j = (int)parama.offset;
        if (i == 0)
        {
          bool1 = true;
          localObject2 = o.ahC();
          localObject3 = paramString.zTT;
          String str = parambi.field_imgPath;
          float f = com.tencent.mm.cb.a.getDensity(parama1.zJz.getContext());
          i = parambi.dGS;
          j = parambi.dGT;
          ImageView localImageView = paramString.zUt;
          if (!bool1) {
            break label624;
          }
          parama = null;
          if ((!((com.tencent.mm.at.g)localObject2).a((ImageView)localObject3, str, f, i, j, localImageView, 2130838223, 0, parama)) || (!this.kFs)) {
            paramString.zTT.setImageDrawable(com.tencent.mm.cb.a.k(parama1.zJz.getContext(), 2130838223));
          }
          if ((localObject1 == null) && (!bool2)) {
            break label874;
          }
          if ((!bool1) && (parambi.field_status != 5)) {
            break label633;
          }
          k = 1;
          label246:
          if (!bool2) {
            break label639;
          }
          paramString.zWm.setText("0%");
          parama = paramString.pNd;
          if (k == 0) {
            break label856;
          }
          i = 8;
          label277:
          parama.setVisibility(i);
          parama = paramString.zWm;
          if (k == 0) {
            break label862;
          }
          i = 8;
          label298:
          parama.setVisibility(i);
          parama = paramString.zWn;
          if (k == 0) {
            break label868;
          }
          i = 8;
          label319:
          parama.setVisibility(i);
          label325:
          paramString.jYu.setTag(new az(parambi, parama1.dJG(), paramInt, parambi.field_talker, '\000'));
          parama = paramString.jYu;
          if (this.zWk == null) {
            this.zWk = new ae.c(this.zzP, this);
          }
          parama.setOnClickListener(this.zWk);
          paramString.jYu.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
          paramString.jYu.setOnLongClickListener(c(parama1));
          paramString.zTT.setContentDescription(parama1.zJz.getMMResources().getString(2131298197));
          if (dLr())
          {
            paramString.pNd.setVisibility(8);
            ab.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", new Object[] { Long.valueOf(parambi.field_msgId), Integer.valueOf(parambi.field_status) });
            if (dLr())
            {
              if ((parambi.field_status != 2) || (!a((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class), parambi.field_msgId))) {
                break label907;
              }
              if (paramString.zSm != null) {
                paramString.zSm.setVisibility(0);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      a(paramInt, paramString, parambi, parama1.dJD(), parama1.dJG(), parama1, this);
      ae.a(parambi, parama1, paramString);
      AppMethodBeat.o(33236);
      return;
      if ((j == i) && (i != 0))
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      bool1 = com.tencent.mm.at.f.b((e)localObject1);
      break;
      bool1 = false;
      break;
      label624:
      parama = paramString.zWn;
      break label168;
      label633:
      k = 0;
      break label246;
      label639:
      parama = paramString.zWm;
      localObject2 = new StringBuilder();
      if (localObject1 != null)
      {
        j = ((e)localObject1).fsd;
        i = ((e)localObject1).offset;
        if (n.ahs().gV(((e)localObject1).fDL))
        {
          localObject3 = n.ahs().gW(((e)localObject1).fDL);
          j = (int)((n.d)localObject3).czn;
          i = (int)((n.d)localObject3).offset;
        }
        if (((e)localObject1).ahh())
        {
          localObject3 = o.ahC().lv(((e)localObject1).fDW);
          if (n.ahs().gV(((e)localObject1).fDW))
          {
            localObject1 = n.ahs().gW(((e)localObject1).fDW);
            j = (int)((n.d)localObject1).czn;
            i = (int)((n.d)localObject1).offset;
          }
        }
        else
        {
          label782:
          if (j <= 0) {
            break label850;
          }
          if (i < j) {
            break label837;
          }
          i = 100;
        }
      }
      for (;;)
      {
        parama.setText(i + "%");
        break;
        j = ((e)localObject3).fsd;
        i = ((e)localObject3).offset;
        break label782;
        label837:
        i = i * 100 / j;
        continue;
        label850:
        i = 0;
      }
      label856:
      i = 0;
      break label277;
      label862:
      i = 0;
      break label298;
      label868:
      i = 0;
      break label319;
      label874:
      paramString.zWn.setVisibility(8);
      paramString.pNd.setVisibility(8);
      paramString.zWm.setVisibility(8);
      break label325;
      label907:
      if (paramString.zSm != null) {
        paramString.zSm.setVisibility(8);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33237);
    aw.aaz();
    int k;
    Object localObject2;
    Object localObject1;
    int j;
    int i;
    if ((com.tencent.mm.model.c.isSDCardAvailable()) && (paramView != null))
    {
      k = ((az)paramView.getTag()).position;
      localObject2 = null;
      if (parambi.field_msgId > 0L) {
        localObject2 = o.ahC().gT(parambi.field_msgId);
      }
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((e)localObject2).fDL > 0L) {}
      }
      else
      {
        localObject1 = localObject2;
        if (parambi.field_msgSvrId > 0L) {
          localObject1 = o.ahC().gS(parambi.field_msgSvrId);
        }
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((e)localObject1).ahh())
        {
          localObject2 = localObject1;
          if (((e)localObject1).fsd == 0) {
            localObject2 = o.ahC().lv(((e)localObject1).fDW);
          }
        }
      }
      paramContextMenu.add(k, 110, 0, paramView.getContext().getString(2131302650));
      if (parambi.field_status == 5) {
        paramContextMenu.add(k, 103, 0, paramView.getContext().getString(2131298295));
      }
      if ((com.tencent.mm.aj.f.aeP()) && (!this.zzP.dJH())) {
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
      if (((e)localObject2).status != -1)
      {
        localObject1 = paramContextMenu.add(k, 131, 0, paramView.getContext().getString(2131298194));
        localObject2 = new int[2];
        if (paramView == null) {
          break label595;
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
      if ((!parambi.dvV()) && (parambi.dvX()) && ((parambi.field_status == 2) || (parambi.dGV == 1)) && (a(parambi, this.zzP)) && (auk(parambi.field_talker)) && (!ad.na(this.zzP.getTalkerUserName()))) {
        paramContextMenu.add(k, 123, 0, paramView.getContext().getString(2131298244));
      }
      if (!this.zzP.dJH()) {
        paramContextMenu.add(k, 100, 0, paramView.getContext().getString(2131298231));
      }
      AppMethodBeat.o(33237);
      return true;
      label595:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33238);
    if (100 == paramMenuItem.getItemId()) {
      ae.b(parambi, parama);
    }
    for (;;)
    {
      AppMethodBeat.o(33238);
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
    return (paramBoolean) && ((paramInt == 3) || (paramInt == 23) || (paramInt == 13) || (paramInt == 39) || (paramInt == 33));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean dLp()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.b
 * JD-Core Version:    0.7.0.1
 */