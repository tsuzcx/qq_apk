package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

public final class ar
  extends c
{
  private f onSceneEndCallback;
  private ar.a zYh;
  private a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33403);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969132);
      ((View)localObject).setTag(new bg().fs((View)localObject));
    }
    AppMethodBeat.o(33403);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33404);
    bg localbg = (bg)parama;
    this.zzP = parama1;
    Object localObject2 = al.dlL().nx(parambi.field_msgId);
    Object localObject1 = parambi.field_content;
    paramString = null;
    parama = paramString;
    if (localObject2 != null)
    {
      parama = paramString;
      if (localObject1 != null) {
        parama = j.b.ab((String)localObject1, parambi.field_reserved);
      }
    }
    if (parama != null) {
      localbg.gpM.setText(parama.description);
    }
    ab.d("MicroMsg.ChattingItemVoiceRemindSys", "content sys " + parambi.field_content);
    paramString = com.tencent.mm.plugin.subapp.c.e.adQ((String)localObject1);
    if ((paramString != null) && (paramString.sXo != null) && (paramString.sXo.length() > 0) && (paramString.sXp > 0) && (this.onSceneEndCallback == null) && (parama != null) && (bo.isNullOrNil(parambi.field_imgPath)))
    {
      localObject1 = com.tencent.mm.plugin.subapp.c.k.ve(r.Zn());
      localObject2 = com.tencent.mm.plugin.subapp.c.h.bE((String)localObject1, false);
      parambi.kk((String)localObject1);
      aw.aaz();
      com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
      parama = l.a((String)localObject2, parambi.field_msgId, parama.sdkVer, parama.appId, paramString.sXo, paramString.sXp, parama.type, parama.fgA);
      if (parama != null)
      {
        paramString = aw.Rc();
        localObject1 = new ar.1(this, parambi, parama, paramInt);
        this.onSceneEndCallback = ((f)localObject1);
        paramString.a(221, (f)localObject1);
        parama = new com.tencent.mm.plugin.record.b.e(parama);
        parama.cfO();
        aw.Rc().a(parama, 0);
      }
    }
    localbg.gpM.setTag(new az(parambi, parama1.dJG(), paramInt, null, '\000'));
    parama = localbg.gpM;
    if (this.zYh == null) {
      this.zYh = new ar.a(this, this.zzP);
    }
    parama.setOnClickListener(this.zYh);
    aw.aaz();
    if (com.tencent.mm.model.c.isSDCardAvailable()) {
      localbg.gpM.setOnLongClickListener(c(parama1));
    }
    AppMethodBeat.o(33404);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33405);
    int i = ((az)paramView.getTag()).position;
    if (!this.zzP.dJH()) {
      paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
    }
    AppMethodBeat.o(33405);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    AppMethodBeat.i(33406);
    paramMenuItem.getItemId();
    AppMethodBeat.o(33406);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048191;
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return true;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ar
 * JD-Core Version:    0.7.0.1
 */