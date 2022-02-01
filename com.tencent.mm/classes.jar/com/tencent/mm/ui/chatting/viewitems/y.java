package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.api.o;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class y
{
  public static final class b
    extends c
  {
    private final long aeQI = 259200000L;
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(36970);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.gfO);
        ((View)localObject).setTag(new y.a().lB((View)localObject));
      }
      AppMethodBeat.o(36970);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(36971);
      y.a locala = (y.a)parama;
      this.aeiK = parama1;
      ((o)parama1.cm(o.class)).cP(paramcc);
      parama = null;
      String str = paramcc.field_content;
      paramString = str;
      if (parama1.juG())
      {
        int i = paramcc.field_content.indexOf(':');
        paramString = str;
        if (i != -1) {
          paramString = paramcc.field_content.substring(i + 1);
        }
      }
      if (paramString != null) {
        parama = k.b.aP(paramString, paramcc.field_reserved);
      }
      g localg;
      if (parama != null)
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.is(parama.appId, parama.appVersion);
        if (localg != null) {
          b(parama1, parama, paramcc);
        }
        if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
          break label454;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.iA(paramString))) {
          break label480;
        }
        locala.Aoo.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama1.aezO.getContext(), localg, paramString));
        locala.Aoo.setVisibility(0);
        if ((localg == null) || (!localg.aqJ())) {
          break label464;
        }
        a(parama1, locala.Aoo, paramcc, parama, localg.field_packageName, paramcc.field_msgSvrId);
        label257:
        a(parama1, locala.Aoo, parama.appId);
        label270:
        if ((parama.kLg != null) && (parama.kLg.length() != 0)) {
          break label493;
        }
        locala.aeNs.setVisibility(8);
        label297:
        switch (parama.type)
        {
        default: 
          label320:
          if (!parama1.juG()) {
            if (com.tencent.mm.pluginsdk.model.app.h.k(localg))
            {
              locala.aeQH.setVisibility(0);
              locala.aeNs.setVisibility(8);
              c(parama1, locala.aeQH, bz.a(parama, paramcc));
            }
          }
          break;
        }
      }
      for (;;)
      {
        locala.clickArea.setTag(new bz(paramcc, parama1.juG(), paramInt, null, '\000'));
        locala.clickArea.setOnClickListener(d(parama1));
        if (this.wQm)
        {
          locala.clickArea.setOnLongClickListener(c(parama1));
          locala.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
        }
        AppMethodBeat.o(36971);
        return;
        label454:
        paramString = localg.field_appName;
        break;
        label464:
        a(parama1, locala.Aoo, parama.appId);
        break label257;
        label480:
        locala.Aoo.setVisibility(8);
        break label270;
        label493:
        locala.aeNs.setVisibility(0);
        b(parama1, locala.aeNs, bz.bBE(parama.kLg));
        break label297;
        locala.HLM.setVisibility(0);
        com.tencent.mm.pluginsdk.model.app.c localc = as.cWJ().bpI(parama.hzM);
        str = paramcc.field_imgPath;
        paramString = Boolean.FALSE;
        if (localc != null)
        {
          str = localc.field_fileFullPath;
          paramString = Boolean.TRUE;
        }
        if (r.bKa().a(locala.HLM, str, paramString.booleanValue(), com.tencent.mm.cd.a.getDensity(parama1.aezO.getContext()), parama.nRu, parama.nRt, R.g.chat_img_template, locala.HLN, R.g.chat_img_default_bg, 1, null)) {
          break label320;
        }
        if (this.wQm) {
          locala.HLM.setImageResource(R.k.chatfrom_bg_pic);
        }
        for (;;)
        {
          locala.HLM.post(new y.b.1(this, locala));
          break;
          locala.HLM.setImageBitmap(BitmapFactory.decodeResource(parama1.aezO.getMMResources(), R.g.chat_img_default_bg));
        }
        locala.aeQH.setVisibility(8);
        continue;
        locala.aeQH.setVisibility(8);
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, final cc paramcc)
    {
      AppMethodBeat.i(36973);
      String str = paramcc.field_content;
      Object localObject = null;
      if (str != null) {
        localObject = k.b.Hf(str);
      }
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36973);
        return false;
      case 111: 
        str = null;
        paramMenuItem = str;
        if (localObject != null)
        {
          paramMenuItem = str;
          if (((k.b)localObject).hzM != null)
          {
            paramMenuItem = str;
            if (((k.b)localObject).hzM.length() > 0)
            {
              localObject = as.cWJ().bpI(((k.b)localObject).hzM);
              paramMenuItem = str;
              if (localObject != null) {
                paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath;
              }
            }
          }
        }
        if (!paramcc.isClean()) {
          if ((System.currentTimeMillis() - paramcc.getCreateTime() <= 259200000L) || ((!Util.isNullOrNil(paramMenuItem)) && (com.tencent.mm.vfs.y.ZC(paramMenuItem)))) {
            break label237;
          }
        }
        label237:
        for (int i = 1; i != 0; i = 0)
        {
          Log.i("MicroMsg.ChattingItemAppMsgFromImg", "img is expired or clean!!!");
          k.d(parama.aezO.getContext(), parama.aezO.getContext().getString(R.l.gJE), parama.aezO.getContext().getString(R.l.app_tip), new y.b.2(this));
          AppMethodBeat.o(36973);
          return false;
        }
        new MMHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36967);
            n.a(paramcc, null);
            AppMethodBeat.o(36967);
          }
        });
        localObject = bt.X(paramcc);
        if (Util.isNullOrNil((String)localObject))
        {
          localObject = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject).putExtra("Retr_File_Name", paramMenuItem);
          ((Intent)localObject).putExtra("Retr_Msg_content", br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
          ((Intent)localObject).putExtra("Retr_Msg_Type", 16);
          ((Intent)localObject).putExtra("Retr_Msg_Id", paramcc.field_msgId);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          AppMethodBeat.o(36973);
          return false;
          com.tencent.mm.plugin.report.service.h.OAn.b(17509, new Object[] { Integer.valueOf(3), localObject });
          k.a(parama.aezO.getContext(), R.l.gUu, R.l.gUv, R.l.app_view_detail, R.l.gzo, true, new y.b.4(this, (String)localObject, parama), new y.b.5(this, parama, paramMenuItem, paramcc, (String)localObject));
        }
      }
      y.a(parama, paramMenuItem, paramcc);
      AppMethodBeat.o(36973);
      return false;
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255799);
      if ((paramView == null) || (paramcc == null))
      {
        AppMethodBeat.o(255799);
        return true;
      }
      int k = ((bz)paramView.getTag()).position;
      n.bpT(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend));
      if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.s(k.b.Hf(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend)).appId, false, false))) && (!bt.Q(paramcc))) {
        params.a(k, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (com.tencent.mm.br.c.blq("favorite")) {
        params.a(k, 116, this.aeiK.aezO.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      int[] arrayOfInt;
      int j;
      int i;
      if (paramcc.field_status != 5)
      {
        paramContextMenuInfo = params.a(k, 131, paramView.getContext().getString(R.l.chatting_image_long_click_photo_edit), R.k.icons_filled_pencil);
        arrayOfInt = new int[2];
        if (paramView == null) {
          break label424;
        }
        j = paramView.getWidth();
        i = paramView.getHeight();
        paramView.getLocationInWindow(arrayOfInt);
      }
      for (;;)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
        paramContextMenuInfo.setIntent(localIntent);
        paramContextMenuInfo = new ex();
        paramContextMenuInfo.hFc.msgId = paramcc.field_msgId;
        paramContextMenuInfo.publish();
        boolean bool = com.tencent.mm.pluginsdk.model.app.h.x(this.aeiK.aezO.getContext(), 2L);
        if ((paramContextMenuInfo.hFd.hEn) || (bool)) {
          params.a(k, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
        }
        if (bt.F(paramcc)) {
          params.clear();
        }
        if (!this.aeiK.juH()) {
          params.a(k, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
        }
        AppMethodBeat.o(255799);
        return true;
        label424:
        i = 0;
        j = 0;
      }
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(36974);
      bh.bCz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        aa.j(parama.aezO.getContext(), parama.aezO.getContentView());
        AppMethodBeat.o(36974);
        return true;
      }
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
      Object localObject1 = null;
      Object localObject2 = br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend);
      if (localObject2 != null) {
        localObject1 = k.b.Hf((String)localObject2);
      }
      if (localObject1 == null)
      {
        Log.e("MicroMsg.ChattingItemAppMsgFromImg", "content is null");
        AppMethodBeat.o(36974);
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
        paramView = com.tencent.mm.pluginsdk.model.app.h.s(((k.b)localObject1).appId, true, false);
        if ((paramView != null) && (paramView.aqJ())) {
          a(parama, (k.b)localObject1, d(parama, paramcc), paramView, paramcc.field_msgSvrId, parama.getTalkerUserName());
        }
        if ((((k.b)localObject1).hzM != null) && (((k.b)localObject1).hzM.length() > 0))
        {
          paramView = as.cWJ().bpI(((k.b)localObject1).hzM);
          if ((paramView == null) || (!paramView.efT())) {
            if (paramcc.field_isSend == 0)
            {
              l1 = paramcc.field_msgId;
              parama = new Intent();
              parama.setClassName(this.aeiK.aezO.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              parama.putExtra("app_msg_id", l1);
              paramView = this.aeiK;
              parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
              com.tencent.mm.hellhoundlib.a.a.b(paramView, parama.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "doGetMsgImg", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramView.startActivity((Intent)parama.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "doGetMsgImg", "(J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
        }
        while ((((k.b)localObject1).url == null) || (((k.b)localObject1).url.length() <= 0))
        {
          for (;;)
          {
            AppMethodBeat.o(36974);
            return true;
            paramView = paramView.field_fileFullPath;
            if (!com.tencent.mm.vfs.y.ZC(paramView))
            {
              Log.i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(paramcc.field_msgId), Long.valueOf(paramcc.field_msgSvrId) });
              paramView = new Intent();
              paramView.setClassName(parama.aezO.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
              paramView.putExtra("clean_view_type", 1);
              paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
              com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              parama.startActivity((Intent)paramView.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(36974);
              return true;
            }
            if ((paramView != null) && (!paramView.equals("")) && (com.tencent.mm.vfs.y.ZC(paramView))) {
              break;
            }
            Log.d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
          }
          long l1 = paramcc.field_msgId;
          long l2 = paramcc.field_msgSvrId;
          parama = paramcc.field_talker;
          Log.i("MicroMsg.ChattingItemAppMsgFromImg", "[ImageGalleryUI] enter");
          paramView = new Intent(this.aeiK.aezO.getContext(), ImageGalleryUI.class);
          paramView.putExtra("img_gallery_msg_id", l1);
          paramView.putExtra("img_gallery_talker", parama);
          paramView.putExtra("img_gallery_left", localObject2[0]);
          paramView.putExtra("img_gallery_top", localObject2[1]);
          paramView.putExtra("img_gallery_width", j);
          paramView.putExtra("img_gallery_height", i);
          parama = this.aeiK.getTalkerUserName();
          paramcc = a(this.aeiK, paramcc);
          localObject1 = new Bundle();
          if (this.aeiK.juG()) {
            i = 2;
          }
          for (;;)
          {
            ((Bundle)localObject1).putInt("stat_scene", i);
            ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
            ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
            ((Bundle)localObject1).putString("stat_send_msg_user", paramcc);
            paramView.putExtra("_stat_obj", (Bundle)localObject1);
            parama = this.aeiK;
            paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
            com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramView.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgFromImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            if (ab.IS(parama)) {
              i = 7;
            } else {
              i = 1;
            }
          }
        }
        localObject2 = u.ab(((k.b)localObject1).url, "message");
        PackageInfo localPackageInfo = getPackageInfo(parama.aezO.getContext(), ((k.b)localObject1).appId);
        if (localPackageInfo == null)
        {
          paramView = null;
          label925:
          if (localPackageInfo != null) {
            break label972;
          }
        }
        label972:
        for (i = 0;; i = localPackageInfo.versionCode)
        {
          a(parama, (String)localObject2, (String)localObject2, paramView, i, ((k.b)localObject1).appId, false, paramcc.field_msgId, paramcc.field_msgSvrId, paramcc);
          break;
          paramView = localPackageInfo.versionName;
          break label925;
        }
        i = 0;
        j = 0;
      }
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 268435505);
    }
    
    public final boolean fXn()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements v.n
  {
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(36976);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.ggO);
        ((View)localObject).setTag(new y.a().lB((View)localObject));
      }
      AppMethodBeat.o(36976);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(36977);
      y.a locala = (y.a)parama;
      this.aeiK = parama1;
      ((o)parama1.cm(o.class)).cP(paramcc);
      parama = null;
      String str = paramcc.field_content;
      if (str != null) {
        parama = k.b.aP(str, paramcc.field_reserved);
      }
      Object localObject;
      label198:
      label211:
      label232:
      int i;
      if (parama != null)
      {
        localObject = com.tencent.mm.pluginsdk.model.app.h.is(parama.appId, parama.appVersion);
        if ((localObject == null) || (((g)localObject).field_appName == null) || (((g)localObject).field_appName.trim().length() <= 0))
        {
          paramString = parama.appName;
          if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.iA(paramString))) {
            break label428;
          }
          locala.Aoo.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama1.aezO.getContext(), (g)localObject, paramString));
          locala.Aoo.setVisibility(0);
          if ((localObject == null) || (!((g)localObject).aqJ())) {
            break label412;
          }
          a(parama1, locala.Aoo, paramcc, parama, ((g)localObject).field_packageName, paramcc.field_msgSvrId);
          a(parama1, locala.Aoo, parama.appId);
        }
      }
      else
      {
        switch (parama.type)
        {
        default: 
          locala.clickArea.setTag(new bz(paramcc, parama1.juG(), paramInt, null, '\000'));
          locala.clickArea.setOnClickListener(d(parama1));
          if (this.wQm)
          {
            locala.clickArea.setOnLongClickListener(c(parama1));
            locala.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
          }
          i = n.bpT(str);
          if ((i == -1) || (i >= 100) || (parama.nRd <= 0) || (paramcc.field_status == 5))
          {
            locala.AkF.setVisibility(8);
            locala.HLM.setAlpha(255);
            locala.HLM.setBackgroundDrawable(null);
          }
          break;
        }
      }
      for (;;)
      {
        a(paramInt, locala, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
        AppMethodBeat.o(36977);
        return;
        paramString = ((g)localObject).field_appName;
        break;
        label412:
        a(parama1, locala.Aoo, parama.appId);
        break label198;
        label428:
        locala.Aoo.setVisibility(8);
        break label211;
        locala.HLM.setVisibility(0);
        com.tencent.mm.pluginsdk.model.app.c localc = as.cWJ().bpI(parama.hzM);
        localObject = paramcc.field_imgPath;
        paramString = Boolean.FALSE;
        if (localc != null)
        {
          localObject = localc.field_fileFullPath;
          paramString = Boolean.TRUE;
        }
        if (r.bKa().a(locala.HLM, (String)localObject, paramString.booleanValue(), com.tencent.mm.cd.a.getDensity(parama1.aezO.getContext()), parama.thumbWidth, parama.thumbHeight, R.g.chat_img_template, locala.HLN, R.g.chat_img_default_bg, 0, null)) {
          break label232;
        }
        if (this.wQm) {
          locala.HLM.setImageResource(R.k.chatfrom_bg_pic);
        }
        for (;;)
        {
          locala.HLM.post(new y.c.1(this, locala));
          break;
          locala.HLM.setImageBitmap(BitmapFactory.decodeResource(parama1.aezO.getMMResources(), R.g.chat_img_default_bg));
        }
        locala.AkF.setVisibility(0);
        locala.aeQG.setText(i + "%");
        locala.HLM.setAlpha(64);
        locala.HLM.setBackgroundResource(R.g.fpa);
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      Object localObject2 = null;
      AppMethodBeat.i(36979);
      Object localObject1 = paramcc.field_content;
      if (localObject1 != null) {}
      for (localObject1 = k.b.Hf((String)localObject1);; localObject1 = null)
      {
        switch (paramMenuItem.getItemId())
        {
        default: 
          AppMethodBeat.o(36979);
          return false;
        case 111: 
          paramMenuItem = localObject2;
          if (localObject1 != null)
          {
            paramMenuItem = localObject2;
            if (((k.b)localObject1).hzM != null)
            {
              paramMenuItem = localObject2;
              if (((k.b)localObject1).hzM.length() > 0)
              {
                localObject1 = as.cWJ().bpI(((k.b)localObject1).hzM);
                paramMenuItem = localObject2;
                if (localObject1 != null) {
                  paramMenuItem = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
                }
              }
            }
          }
          localObject1 = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject1).putExtra("Retr_Msg_content", paramcc.field_content);
          ((Intent)localObject1).putExtra("Retr_File_Name", paramMenuItem);
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 16);
          ((Intent)localObject1).putExtra("Retr_Msg_Id", paramcc.field_msgId);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36979);
          return false;
        }
        y.a(parama, paramMenuItem, paramcc);
        AppMethodBeat.o(36979);
        return false;
      }
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255781);
      if (paramView == null)
      {
        Log.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] v is null");
        AppMethodBeat.o(255781);
        return false;
      }
      paramContextMenuInfo = (bz)paramView.getTag();
      if (paramContextMenuInfo == null)
      {
        Log.e("MicroMsg.ChattingItemAppMsgToImg", "[onCreateContextMenu] tag is null");
        AppMethodBeat.o(255781);
        return false;
      }
      int k = paramContextMenuInfo.position;
      paramContextMenuInfo = k.b.Hf(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend));
      if ((paramContextMenuInfo != null) && (com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.s(paramContextMenuInfo.appId, false, false))) && (!bt.Q(paramcc))) {
        params.a(k, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (com.tencent.mm.br.c.blq("favorite")) {
        params.a(k, 116, this.aeiK.aezO.getMMResources().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      int[] arrayOfInt;
      int j;
      int i;
      if (paramcc.field_status != 5)
      {
        paramContextMenuInfo = params.a(k, 131, paramView.getContext().getString(R.l.chatting_image_long_click_photo_edit), R.k.icons_filled_pencil);
        arrayOfInt = new int[2];
        if (paramView == null) {
          break label500;
        }
        j = paramView.getWidth();
        i = paramView.getHeight();
        paramView.getLocationInWindow(arrayOfInt);
      }
      for (;;)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
        paramContextMenuInfo.setIntent(localIntent);
        paramContextMenuInfo = new ex();
        paramContextMenuInfo.hFc.msgId = paramcc.field_msgId;
        paramContextMenuInfo.publish();
        boolean bool = com.tencent.mm.pluginsdk.model.app.h.x(this.aeiK.aezO.getContext(), 2L);
        if ((paramContextMenuInfo.hFd.hEn) || (bool)) {
          params.a(k, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
        }
        if ((!paramcc.iYe()) && (paramcc.jbK()) && ((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker))) {
          params.a(k, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
        }
        if (!this.aeiK.juH()) {
          params.a(k, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
        }
        AppMethodBeat.o(255781);
        return true;
        label500:
        i = 0;
        j = 0;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255792);
      if (paramcc.fxR())
      {
        n.bx(paramcc);
        br.iu(paramcc.field_msgId);
        parama.jpK();
        AppMethodBeat.o(255792);
        return;
      }
      AppMethodBeat.o(255792);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(36980);
      bh.bCz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        aa.j(parama.aezO.getContext(), parama.aezO.getContentView());
        AppMethodBeat.o(36980);
        return true;
      }
      if (paramView == null)
      {
        AppMethodBeat.o(36980);
        return true;
      }
      paramView.getTag();
      Object localObject1 = null;
      Object localObject2 = paramcc.field_content;
      if (localObject2 != null) {
        localObject1 = k.b.Hf((String)localObject2);
      }
      if (localObject1 == null)
      {
        Log.e("MicroMsg.ChattingItemAppMsgToImg", "content is null");
        AppMethodBeat.o(36980);
        return true;
      }
      localObject2 = new int[2];
      paramView.getLocationInWindow((int[])localObject2);
      int i = paramView.getWidth();
      int j = paramView.getHeight();
      paramView = com.tencent.mm.pluginsdk.model.app.h.s(((k.b)localObject1).appId, false, false);
      if (paramView != null) {
        a(parama, (k.b)localObject1, z.bAM(), paramView, paramcc.field_msgSvrId, parama.getTalkerUserName());
      }
      label597:
      PackageInfo localPackageInfo;
      if ((((k.b)localObject1).hzM != null) && (((k.b)localObject1).hzM.length() > 0))
      {
        paramView = as.cWJ().bpI(((k.b)localObject1).hzM);
        if (paramView != null)
        {
          bh.bCz();
          if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            aa.j(parama.aezO.getContext(), parama.aezO.getContentView());
          }
          for (;;)
          {
            AppMethodBeat.o(36980);
            return true;
            if (paramcc.field_isSend == 1)
            {
              paramView = paramView.field_fileFullPath;
              if (!com.tencent.mm.vfs.y.ZC(paramView)) {
                break label597;
              }
              if ((paramView != null) && (!paramView.equals("")) && (com.tencent.mm.vfs.y.ZC(paramView))) {
                break;
              }
              Log.d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
            }
          }
          long l1 = paramcc.field_msgId;
          long l2 = paramcc.field_msgSvrId;
          parama = paramcc.field_talker;
          Log.i("MicroMsg.ChattingItemAppMsgToImg", "[ImageGalleryUI] enter");
          paramView = new Intent(this.aeiK.aezO.getContext(), ImageGalleryUI.class);
          paramView.putExtra("img_gallery_msg_id", l1);
          paramView.putExtra("img_gallery_talker", parama);
          paramView.putExtra("img_gallery_left", localObject2[0]);
          paramView.putExtra("img_gallery_top", localObject2[1]);
          paramView.putExtra("img_gallery_width", i);
          paramView.putExtra("img_gallery_height", j);
          parama = this.aeiK.getTalkerUserName();
          paramcc = a(this.aeiK, paramcc);
          localObject1 = new Bundle();
          if (this.aeiK.juG()) {
            i = 2;
          }
          for (;;)
          {
            ((Bundle)localObject1).putInt("stat_scene", i);
            ((Bundle)localObject1).putString("stat_msg_id", "msg_" + Long.toString(l2));
            ((Bundle)localObject1).putString("stat_chat_talker_username", parama);
            ((Bundle)localObject1).putString("stat_send_msg_user", paramcc);
            paramView.putExtra("_stat_obj", (Bundle)localObject1);
            parama = this.aeiK;
            paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
            com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramView.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "showImg", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            if (ab.IS(parama)) {
              i = 7;
            } else {
              i = 1;
            }
          }
          Log.i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramView, Long.valueOf(paramcc.field_msgId), Long.valueOf(paramcc.field_msgSvrId) });
          paramView = new Intent();
          paramView.setClassName(parama.aezO.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
          paramView.putExtra("clean_view_type", 1);
          paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgImg$ChattingItemAppMsgToImg", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36980);
          return true;
        }
      }
      else if ((((k.b)localObject1).url != null) && (((k.b)localObject1).url.length() > 0))
      {
        localObject2 = u.ab(((k.b)localObject1).url, "message");
        localPackageInfo = getPackageInfo(parama.aezO.getContext(), ((k.b)localObject1).appId);
        if (localPackageInfo != null) {
          break label845;
        }
        paramView = null;
        if (localPackageInfo != null) {
          break label854;
        }
      }
      label845:
      label854:
      for (i = 0;; i = localPackageInfo.versionCode)
      {
        a(parama, (String)localObject2, (String)localObject2, paramView, i, ((k.b)localObject1).appId, false, paramcc.field_msgId, paramcc.field_msgSvrId, paramcc);
        AppMethodBeat.o(36980);
        return false;
        paramView = localPackageInfo.versionName;
        break;
      }
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 268435505);
    }
    
    public final boolean fXn()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y
 * JD-Core Version:    0.7.0.1
 */