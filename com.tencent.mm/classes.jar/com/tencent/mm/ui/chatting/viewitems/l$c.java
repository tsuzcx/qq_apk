package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.o;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.e;

public final class l$c
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32960);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969107);
      ((View)localObject).setTag(new l.a().fc((View)localObject));
    }
    AppMethodBeat.o(32960);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32965);
    if (parambi.bCn())
    {
      com.tencent.mm.pluginsdk.model.app.l.al(parambi);
      bf.gw(parambi.field_msgId);
      parama.qT(true);
      AppMethodBeat.o(32965);
      return;
    }
    AppMethodBeat.o(32965);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32961);
    l.a locala = (l.a)parama;
    this.zzP = parama1;
    ((j)parama1.ay(j.class)).bh(parambi);
    parama = null;
    String str = parambi.field_content;
    if (str != null) {
      parama = j.b.ab(str, parambi.field_reserved);
    }
    Object localObject;
    label198:
    label211:
    label232:
    int i;
    if (parama != null)
    {
      localObject = com.tencent.mm.pluginsdk.model.app.g.em(parama.appId, parama.bDc);
      if ((localObject == null) || (((f)localObject).field_appName == null) || (((f)localObject).field_appName.trim().length() <= 0))
      {
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.g.dF(paramString))) {
          break label428;
        }
        locala.mCZ.setText(com.tencent.mm.pluginsdk.model.app.g.b(parama1.zJz.getContext(), (f)localObject, paramString));
        locala.mCZ.setVisibility(0);
        if ((localObject == null) || (!((f)localObject).vY())) {
          break label412;
        }
        a(parama1, locala.mCZ, parambi, parama, ((f)localObject).field_packageName, parambi.field_msgSvrId);
        a(parama1, locala.mCZ, parama.appId);
      }
    }
    else
    {
      switch (parama.type)
      {
      default: 
        locala.jYu.setTag(new az(parambi, parama1.dJG(), paramInt, null, '\000'));
        locala.jYu.setOnClickListener(d(parama1));
        if (this.kFs)
        {
          locala.jYu.setOnLongClickListener(c(parama1));
          locala.jYu.setOnTouchListener(((h)parama1.ay(h.class)).dHi());
        }
        i = com.tencent.mm.pluginsdk.model.app.l.alu(str);
        if ((i == -1) || (i >= 100) || (parama.fgw <= 0) || (parambi.field_status == 5))
        {
          locala.mzQ.setVisibility(8);
          locala.mZY.setAlpha(255);
          locala.mZY.setBackgroundDrawable(null);
        }
        break;
      }
    }
    for (;;)
    {
      a(paramInt, locala, parambi, parama1.dJD(), parama1.dJG(), parama1, this);
      AppMethodBeat.o(32961);
      return;
      paramString = ((f)localObject).field_appName;
      break;
      label412:
      a(parama1, locala.mCZ, parama.appId);
      break label198;
      label428:
      locala.mCZ.setVisibility(8);
      break label211;
      locala.mZY.setVisibility(0);
      com.tencent.mm.pluginsdk.model.app.b localb = al.aUJ().alo(parama.cmN);
      localObject = parambi.field_imgPath;
      paramString = Boolean.FALSE;
      if (localb != null)
      {
        localObject = localb.field_fileFullPath;
        paramString = Boolean.TRUE;
      }
      if (o.ahC().a(locala.mZY, (String)localObject, paramString.booleanValue(), com.tencent.mm.cb.a.getDensity(parama1.zJz.getContext()), parama.fgR, parama.fgQ, locala.nef, 2130838223, 0, null)) {
        break label232;
      }
      if (this.kFs) {
        locala.mZY.setImageResource(2131231092);
      }
      for (;;)
      {
        locala.mZY.post(new l.c.1(this, locala));
        break;
        locala.mZY.setImageBitmap(BitmapFactory.decodeResource(parama1.zJz.getMMResources(), 2130838223));
      }
      locala.mzQ.setVisibility(0);
      locala.zTZ.setText(i + "%");
      locala.mZY.setAlpha(64);
      locala.mZY.setBackgroundResource(2130840239);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(32962);
    if (paramView == null)
    {
      ab.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] v is null");
      AppMethodBeat.o(32962);
      return false;
    }
    Object localObject = (az)paramView.getTag();
    if (localObject == null)
    {
      ab.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] tag is null");
      AppMethodBeat.o(32962);
      return false;
    }
    int k = ((az)localObject).position;
    localObject = j.b.mY(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    if ((localObject != null) && (com.tencent.mm.pluginsdk.model.app.g.k(com.tencent.mm.pluginsdk.model.app.g.ca(((j.b)localObject).appId, false)))) {
      paramContextMenu.add(k, 111, 0, this.zzP.zJz.getMMResources().getString(2131302650));
    }
    if (d.ahR("favorite")) {
      paramContextMenu.add(k, 116, 0, this.zzP.zJz.getMMResources().getString(2131302102));
    }
    localObject = new dr();
    ((dr)localObject).crt.cpO = parambi.field_msgId;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    boolean bool = com.tencent.mm.pluginsdk.model.app.g.o(this.zzP.zJz.getContext(), 2L);
    if ((((dr)localObject).cru.cqS) || (bool)) {
      paramContextMenu.add(k, 129, 0, paramView.getContext().getString(2131298238));
    }
    int[] arrayOfInt;
    int j;
    int i;
    if (parambi.field_status != 5)
    {
      localObject = paramContextMenu.add(k, 131, 0, paramView.getContext().getString(2131298194));
      arrayOfInt = new int[2];
      if (paramView == null) {
        break label496;
      }
      j = paramView.getWidth();
      i = paramView.getHeight();
      paramView.getLocationInWindow(arrayOfInt);
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
      ((MenuItem)localObject).setIntent(localIntent);
      if ((!parambi.dvV()) && (parambi.dxV()) && ((parambi.field_status == 2) || (parambi.dGV == 1)) && (a(parambi, this.zzP)) && (auk(parambi.field_talker))) {
        paramContextMenu.add(k, 123, 0, paramView.getContext().getString(2131298244));
      }
      if (!this.zzP.dJH()) {
        paramContextMenu.add(k, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
      }
      AppMethodBeat.o(32962);
      return true;
      label496:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    Object localObject2 = null;
    AppMethodBeat.i(32963);
    Object localObject1 = parambi.field_content;
    if (localObject1 != null) {}
    for (localObject1 = j.b.mY((String)localObject1);; localObject1 = null)
    {
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(32963);
        return false;
      case 111: 
        paramMenuItem = localObject2;
        if (localObject1 != null)
        {
          paramMenuItem = localObject2;
          if (((j.b)localObject1).cmN != null)
          {
            paramMenuItem = localObject2;
            if (((j.b)localObject1).cmN.length() > 0)
            {
              localObject1 = al.aUJ().alo(((j.b)localObject1).cmN);
              paramMenuItem = localObject2;
              if (localObject1 != null) {
                paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath;
              }
            }
          }
        }
        localObject1 = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
        ((Intent)localObject1).putExtra("Retr_Msg_content", parambi.field_content);
        ((Intent)localObject1).putExtra("Retr_File_Name", paramMenuItem);
        ((Intent)localObject1).putExtra("Retr_Msg_Type", 16);
        ((Intent)localObject1).putExtra("Retr_Msg_Id", parambi.field_msgId);
        parama.startActivity((Intent)localObject1);
        AppMethodBeat.o(32963);
        return false;
      }
      l.a(parama, paramMenuItem, parambi);
      AppMethodBeat.o(32963);
      return false;
    }
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 268435505);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32964);
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.ii(parama.zJz.getContext());
      AppMethodBeat.o(32964);
      return true;
    }
    if (paramView == null)
    {
      AppMethodBeat.o(32964);
      return true;
    }
    paramView.getTag();
    Object localObject1 = null;
    Object localObject2 = parambi.field_content;
    if (localObject2 != null) {
      localObject1 = j.b.mY((String)localObject2);
    }
    if (localObject1 == null)
    {
      ab.e("MicroMsg.ChattingItemAppMsgToImg", "content is null");
      AppMethodBeat.o(32964);
      return true;
    }
    localObject2 = new int[2];
    paramView.getLocationInWindow((int[])localObject2);
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    paramView = com.tencent.mm.pluginsdk.model.app.g.ca(((j.b)localObject1).appId, false);
    if (paramView != null) {
      a(parama, (j.b)localObject1, r.Zn(), paramView, parambi.field_msgSvrId, parama.getTalkerUserName());
    }
    label513:
    PackageInfo localPackageInfo;
    if ((((j.b)localObject1).cmN != null) && (((j.b)localObject1).cmN.length() > 0))
    {
      paramView = al.aUJ().alo(((j.b)localObject1).cmN);
      if (paramView != null)
      {
        aw.aaz();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
          com.tencent.mm.ui.base.t.ii(parama.zJz.getContext());
        }
        for (;;)
        {
          AppMethodBeat.o(32964);
          return true;
          if (parambi.field_isSend == 1)
          {
            paramView = paramView.field_fileFullPath;
            if (!e.cN(paramView)) {
              break label513;
            }
            if ((paramView != null) && (!paramView.equals("")) && (e.cN(paramView))) {
              break;
            }
            ab.d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
          }
        }
        long l1 = parambi.field_msgId;
        long l2 = parambi.field_msgSvrId;
        parama = parambi.field_talker;
        ab.i("MicroMsg.ChattingItemAppMsgToImg", "[ImageGalleryUI] enter");
        paramView = new Intent(this.zzP.zJz.getContext(), ImageGalleryUI.class);
        paramView.putExtra("img_gallery_msg_id", l1);
        paramView.putExtra("img_gallery_talker", parama);
        paramView.putExtra("img_gallery_left", localObject2[0]);
        paramView.putExtra("img_gallery_top", localObject2[1]);
        paramView.putExtra("img_gallery_width", i);
        paramView.putExtra("img_gallery_height", j);
        parama = this.zzP.getTalkerUserName();
        parambi = b(this.zzP, parambi);
        localObject1 = new Bundle();
        if (this.zzP.dJG()) {
          i = 2;
        }
        for (;;)
        {
          ((Bundle)localObject1).putInt("stat_scene", i);
          ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
          ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
          ((Bundle)localObject1).putString("stat_send_msg_user", parambi);
          paramView.putExtra("_stat_obj", (Bundle)localObject1);
          this.zzP.startActivity(paramView);
          break;
          if (com.tencent.mm.model.t.nU(parama)) {
            i = 7;
          } else {
            i = 1;
          }
        }
        ab.i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(parambi.field_msgId), Long.valueOf(parambi.field_msgSvrId) });
        paramView = new Intent();
        paramView.setClassName(parama.zJz.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
        paramView.putExtra("clean_view_type", 1);
        parama.startActivity(paramView);
        AppMethodBeat.o(32964);
        return true;
      }
    }
    else if ((((j.b)localObject1).url != null) && (((j.b)localObject1).url.length() > 0))
    {
      localObject2 = p.H(((j.b)localObject1).url, "message");
      localPackageInfo = getPackageInfo(parama.zJz.getContext(), ((j.b)localObject1).appId);
      if (localPackageInfo != null) {
        break label694;
      }
      paramView = null;
      if (localPackageInfo != null) {
        break label703;
      }
    }
    label694:
    label703:
    for (i = 0;; i = localPackageInfo.versionCode)
    {
      a(parama, (String)localObject2, (String)localObject2, paramView, i, ((j.b)localObject1).appId, false, parambi.field_msgId, parambi.field_msgSvrId, parambi);
      AppMethodBeat.o(32964);
      return false;
      paramView = localPackageInfo.versionName;
      break;
    }
  }
  
  public final boolean dLp()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.c
 * JD-Core Version:    0.7.0.1
 */