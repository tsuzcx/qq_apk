package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.e;

public final class l$b
  extends c
{
  private final long zUb = 259200000L;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32954);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969069);
      ((View)localObject).setTag(new l.a().fc((View)localObject));
    }
    AppMethodBeat.o(32954);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32955);
    l.a locala = (l.a)parama;
    this.zzP = parama1;
    ((j)parama1.ay(j.class)).bh(parambi);
    parama = null;
    String str = parambi.field_content;
    paramString = str;
    if (parama1.dJG())
    {
      int i = parambi.field_content.indexOf(':');
      paramString = str;
      if (i != -1) {
        paramString = parambi.field_content.substring(i + 1);
      }
    }
    if (paramString != null) {
      parama = j.b.ab(paramString, parambi.field_reserved);
    }
    f localf;
    if (parama != null)
    {
      localf = com.tencent.mm.pluginsdk.model.app.g.em(parama.appId, parama.bDc);
      if (localf != null) {
        b(parama1, parama, parambi);
      }
      if ((localf != null) && (localf.field_appName != null) && (localf.field_appName.trim().length() > 0)) {
        break label454;
      }
      paramString = parama.appName;
      if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.g.dF(paramString))) {
        break label480;
      }
      locala.mCZ.setText(com.tencent.mm.pluginsdk.model.app.g.b(parama1.zJz.getContext(), localf, paramString));
      locala.mCZ.setVisibility(0);
      if ((localf == null) || (!localf.vY())) {
        break label464;
      }
      a(parama1, locala.mCZ, parambi, parama, localf.field_packageName, parambi.field_msgSvrId);
      label257:
      a(parama1, locala.mCZ, parama.appId);
      label270:
      if ((parama.dGR != null) && (parama.dGR.length() != 0)) {
        break label493;
      }
      locala.zRY.setVisibility(8);
      label297:
      switch (parama.type)
      {
      default: 
        label320:
        if (!parama1.dJG()) {
          if (com.tencent.mm.pluginsdk.model.app.g.j(localf))
          {
            locala.zUa.setVisibility(0);
            locala.zRY.setVisibility(8);
            c(parama1, locala.zUa, az.a(parama, parambi));
          }
        }
        break;
      }
    }
    for (;;)
    {
      locala.jYu.setTag(new az(parambi, parama1.dJG(), paramInt, null, '\000'));
      locala.jYu.setOnClickListener(d(parama1));
      if (this.kFs)
      {
        locala.jYu.setOnLongClickListener(c(parama1));
        locala.jYu.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
      }
      AppMethodBeat.o(32955);
      return;
      label454:
      paramString = localf.field_appName;
      break;
      label464:
      a(parama1, locala.mCZ, parama.appId);
      break label257;
      label480:
      locala.mCZ.setVisibility(8);
      break label270;
      label493:
      locala.zRY.setVisibility(0);
      b(parama1, locala.zRY, az.auv(parama.dGR));
      break label297;
      locala.mZY.setVisibility(0);
      com.tencent.mm.pluginsdk.model.app.b localb = al.aUJ().alo(parama.cmN);
      str = parambi.field_imgPath;
      paramString = Boolean.FALSE;
      if (localb != null)
      {
        str = localb.field_fileFullPath;
        paramString = Boolean.TRUE;
      }
      if (o.ahC().a(locala.mZY, str, paramString.booleanValue(), com.tencent.mm.cb.a.getDensity(parama1.zJz.getContext()), parama.fgP, parama.fgO, locala.nef, 2130838223, 1, null)) {
        break label320;
      }
      if (this.kFs) {
        locala.mZY.setImageResource(2131231092);
      }
      for (;;)
      {
        locala.mZY.post(new l.b.1(this, locala));
        break;
        locala.mZY.setImageBitmap(BitmapFactory.decodeResource(parama1.zJz.getMMResources(), 2130838223));
      }
      locala.zUa.setVisibility(8);
      continue;
      locala.zUa.setVisibility(8);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(32956);
    if ((paramView == null) || (parambi == null))
    {
      AppMethodBeat.o(32956);
      return true;
    }
    int k = ((az)paramView.getTag()).position;
    com.tencent.mm.pluginsdk.model.app.l.alu(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    if (com.tencent.mm.pluginsdk.model.app.g.k(com.tencent.mm.pluginsdk.model.app.g.ca(j.b.mY(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend)).appId, false))) {
      paramContextMenu.add(k, 111, 0, this.zzP.zJz.getMMResources().getString(2131302650));
    }
    if (d.ahR("favorite")) {
      paramContextMenu.add(k, 116, 0, this.zzP.zJz.getMMResources().getString(2131302102));
    }
    Object localObject = new dr();
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
        break label415;
      }
      j = paramView.getWidth();
      i = paramView.getHeight();
      paramView.getLocationInWindow(arrayOfInt);
    }
    for (;;)
    {
      paramView = new Intent();
      paramView.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
      ((MenuItem)localObject).setIntent(paramView);
      if (bh.o(parambi)) {
        paramContextMenu.clear();
      }
      if (!this.zzP.dJH()) {
        paramContextMenu.add(k, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
      }
      AppMethodBeat.o(32956);
      return true;
      label415:
      i = 0;
      j = 0;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, final bi parambi)
  {
    Object localObject2 = null;
    AppMethodBeat.i(32957);
    Object localObject1 = parambi.field_content;
    if (localObject1 != null) {}
    for (localObject1 = j.b.mY((String)localObject1);; localObject1 = null)
    {
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(32957);
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
        if (!parambi.dyc()) {
          if ((System.currentTimeMillis() - parambi.field_createTime <= 259200000L) || ((!bo.isNullOrNil(paramMenuItem)) && (e.cN(paramMenuItem)))) {
            break label234;
          }
        }
        label234:
        for (int i = 1; i != 0; i = 0)
        {
          ab.i("MicroMsg.ChattingItemAppMsgFromImg", "img is expired or clean!!!");
          com.tencent.mm.ui.base.h.a(parama.zJz.getContext(), parama.zJz.getContext().getString(2131300727), parama.zJz.getContext().getString(2131297087), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(32957);
          return false;
        }
        new ak().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(32953);
            com.tencent.mm.pluginsdk.model.app.l.a(parambi, null);
            AppMethodBeat.o(32953);
          }
        });
        localObject1 = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
        ((Intent)localObject1).putExtra("Retr_File_Name", paramMenuItem);
        ((Intent)localObject1).putExtra("Retr_Msg_content", bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend));
        ((Intent)localObject1).putExtra("Retr_Msg_Type", 16);
        ((Intent)localObject1).putExtra("Retr_Msg_Id", parambi.field_msgId);
        parama.startActivity((Intent)localObject1);
        AppMethodBeat.o(32957);
        return false;
      }
      l.a(parama, paramMenuItem, parambi);
      AppMethodBeat.o(32957);
      return false;
    }
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 268435505);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32958);
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.ii(parama.zJz.getContext());
      AppMethodBeat.o(32958);
      return true;
    }
    Object localObject1 = null;
    Object localObject2 = bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend);
    if (localObject2 != null) {
      localObject1 = j.b.mY((String)localObject2);
    }
    if (localObject1 == null)
    {
      ab.e("MicroMsg.ChattingItemAppMsgFromImg", "content is null");
      AppMethodBeat.o(32958);
      return true;
    }
    localObject2 = new int[2];
    int j;
    int i;
    if (paramView != null)
    {
      paramView.getLocationInWindow((int[])localObject2);
      j = paramView.getWidth();
      i = paramView.getHeight();
    }
    for (;;)
    {
      paramView = com.tencent.mm.pluginsdk.model.app.g.ca(((j.b)localObject1).appId, true);
      if ((paramView != null) && (paramView.vY())) {
        a(parama, (j.b)localObject1, d(parama, parambi), paramView, parambi.field_msgSvrId, parama.getTalkerUserName());
      }
      if ((((j.b)localObject1).cmN != null) && (((j.b)localObject1).cmN.length() > 0))
      {
        paramView = al.aUJ().alo(((j.b)localObject1).cmN);
        if ((paramView == null) || (!paramView.bEL())) {
          if (parambi.field_isSend == 0)
          {
            l1 = parambi.field_msgId;
            paramView = new Intent();
            paramView.setClassName(this.zzP.zJz.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            paramView.putExtra("app_msg_id", l1);
            this.zzP.startActivity(paramView);
          }
        }
      }
      while ((((j.b)localObject1).url == null) || (((j.b)localObject1).url.length() <= 0))
      {
        for (;;)
        {
          AppMethodBeat.o(32958);
          return true;
          paramView = paramView.field_fileFullPath;
          if (!e.cN(paramView))
          {
            ab.i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(parambi.field_msgId), Long.valueOf(parambi.field_msgSvrId) });
            paramView = new Intent();
            paramView.setClassName(parama.zJz.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
            paramView.putExtra("clean_view_type", 1);
            parama.startActivity(paramView);
            AppMethodBeat.o(32958);
            return true;
          }
          if ((paramView != null) && (!paramView.equals("")) && (e.cN(paramView))) {
            break;
          }
          ab.d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
        }
        long l1 = parambi.field_msgId;
        long l2 = parambi.field_msgSvrId;
        parama = parambi.field_talker;
        ab.i("MicroMsg.ChattingItemAppMsgFromImg", "[ImageGalleryUI] enter");
        paramView = new Intent(this.zzP.zJz.getContext(), ImageGalleryUI.class);
        paramView.putExtra("img_gallery_msg_id", l1);
        paramView.putExtra("img_gallery_talker", parama);
        paramView.putExtra("img_gallery_left", localObject2[0]);
        paramView.putExtra("img_gallery_top", localObject2[1]);
        paramView.putExtra("img_gallery_width", j);
        paramView.putExtra("img_gallery_height", i);
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
      }
      localObject2 = p.H(((j.b)localObject1).url, "message");
      PackageInfo localPackageInfo = getPackageInfo(parama.zJz.getContext(), ((j.b)localObject1).appId);
      if (localPackageInfo == null)
      {
        paramView = null;
        label694:
        if (localPackageInfo != null) {
          break label741;
        }
      }
      label741:
      for (i = 0;; i = localPackageInfo.versionCode)
      {
        a(parama, (String)localObject2, (String)localObject2, paramView, i, ((j.b)localObject1).appId, false, parambi.field_msgId, parambi.field_msgSvrId, parambi);
        break;
        paramView = localPackageInfo.versionName;
        break label694;
      }
      i = 0;
      j = 0;
    }
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.b
 * JD-Core Version:    0.7.0.1
 */