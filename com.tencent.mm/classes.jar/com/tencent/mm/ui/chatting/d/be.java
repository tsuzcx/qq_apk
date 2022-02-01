package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.c.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.model.l.a;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ak;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.d.a.a(fJv=as.class)
public class be
  extends a
  implements as
{
  private long Kjj;
  private SparseBooleanArray Kjk;
  
  public be()
  {
    AppMethodBeat.i(35756);
    this.Kjj = -1L;
    this.Kjk = new SparseBooleanArray();
    AppMethodBeat.o(35756);
  }
  
  private void aE(Intent paramIntent)
  {
    AppMethodBeat.i(35764);
    final com.tencent.mm.modelvideo.c localc = new com.tencent.mm.modelvideo.c();
    localc.a(this.cXJ.Kkd.getContext(), paramIntent, this.cXJ.getTalkerUserName(), new c.a()
    {
      public final void c(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(35755);
        if (paramAnonymousInt1 == -50002) {
          Toast.makeText(be.this.cXJ.Kkd.getContext(), be.this.cXJ.Kkd.getContext().getString(2131764675), 0).show();
        }
        for (;;)
        {
          be.this.cXJ.dismissDialog();
          AppMethodBeat.o(35755);
          return;
          if (paramAnonymousInt1 < 0)
          {
            Toast.makeText(be.this.cXJ.Kkd.getContext(), be.this.cXJ.Kkd.getContext().getString(2131764674), 0).show();
          }
          else
          {
            u.c(paramAnonymousString1, paramAnonymousInt2, be.this.cXJ.getTalkerUserName(), paramAnonymousString2);
            u.HT(paramAnonymousString1);
          }
        }
      }
    });
    paramIntent = this.cXJ;
    Activity localActivity = this.cXJ.Kkd.getContext();
    this.cXJ.Kkd.getMMResources().getString(2131755906);
    paramIntent.b(localActivity, this.cXJ.Kkd.getMMResources().getString(2131755936), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        localc.iuB = null;
      }
    });
    AppMethodBeat.o(35764);
  }
  
  private void aY(final ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(35762);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ChattingUI.VideoComponent", "send video path: %s", new Object[] { paramArrayList.toString() });
    paramArrayList = new com.tencent.mm.pluginsdk.model.l(this.cXJ.Kkd.getContext(), paramArrayList, null, this.cXJ.getTalkerUserName(), 2, new l.a()
    {
      public final void fdq()
      {
        AppMethodBeat.i(35752);
        be.this.cXJ.dismissDialog();
        AppMethodBeat.o(35752);
      }
    });
    com.tencent.mm.ui.chatting.e.a locala = this.cXJ;
    Activity localActivity = this.cXJ.Kkd.getContext();
    this.cXJ.Kkd.getMMResources().getString(2131755906);
    locala.b(localActivity, this.cXJ.Kkd.getMMResources().getString(2131755936), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(35753);
        paramArrayList.fdk();
        AppMethodBeat.o(35753);
      }
    });
    com.tencent.mm.sdk.g.b.c(paramArrayList, "ChattingUI_importMultiVideo");
    AppMethodBeat.o(35762);
  }
  
  private void bU(bv parambv)
  {
    AppMethodBeat.i(35759);
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getContentView());
      AppMethodBeat.o(35759);
      return;
    }
    Object localObject1;
    if (parambv.cyH())
    {
      localObject1 = new Intent(this.cXJ.Kkd.getContext(), MsgRetransmitUI.class);
      ((Intent)localObject1).putExtra("Retr_Msg_Id", parambv.field_msgId);
      ((Intent)localObject1).putExtra("Retr_Msg_content", parambv.field_content);
      ((Intent)localObject1).putExtra("Retr_From", "chattingui");
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + parambv.getType());
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 1);
      parambv = this.cXJ.Kkd;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(parambv, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parambv.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(parambv, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35759);
      return;
    }
    s locals = u.Ia(parambv.field_imgPath);
    if (locals != null)
    {
      Object localObject2 = locals.aNs();
      localObject1 = localObject2;
      if (!com.tencent.mm.vfs.o.fB((String)localObject2))
      {
        com.tencent.mm.modelvideo.o.aNh();
        localObject1 = com.tencent.mm.modelvideo.t.HJ(parambv.field_imgPath);
      }
      if (parambv.fvU())
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.VideoComponent", "video is clean!!!");
        h.d(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getContext().getString(2131764667), this.cXJ.Kkd.getContext().getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(35759);
        return;
      }
      if (l.f(parambv, (String)localObject1))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.VideoComponent", "video is expired");
        gL(locals.getFileName(), 3);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
        localObject2 = new Intent(this.cXJ.Kkd.getContext(), ImageGalleryUI.class);
        ((Intent)localObject2).putExtra("img_gallery_msg_id", parambv.field_msgId);
        ((Intent)localObject2).putExtra("img_gallery_msg_svr_id", parambv.field_msgSvrId);
        ((Intent)localObject2).putExtra("img_gallery_talker", parambv.field_talker);
        ((Intent)localObject2).putExtra("img_gallery_chatroom_name", parambv.field_talker);
        ((Intent)localObject2).putExtra("img_gallery_enter_video_opcode", u.f(parambv.field_msgId, 1));
        l.a(this.cXJ, parambv, (Intent)localObject2);
        localObject1 = this.cXJ.Kkd;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.cXJ.Kkd.overridePendingTransition(0, 0);
        if (locals.aNv())
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.VideoComponent", "start complete online video");
          u.Ih(parambv.field_imgPath);
          AppMethodBeat.o(35759);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.VideoComponent", "start complete offline video");
        u.HV(parambv.field_imgPath);
        AppMethodBeat.o(35759);
        return;
      }
      if ((parambv.cyG()) || (parambv.cyI()))
      {
        localObject1 = new Intent(this.cXJ.Kkd.getContext(), MsgRetransmitUI.class);
        ((Intent)localObject1).putExtra("Retr_length", locals.hKI);
        ((Intent)localObject1).putExtra("Retr_File_Name", parambv.field_imgPath);
        ((Intent)localObject1).putExtra("Retr_video_isexport", locals.ixc);
        ((Intent)localObject1).putExtra("Retr_Msg_Id", parambv.field_msgId);
        ((Intent)localObject1).putExtra("Retr_From", "chattingui");
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + parambv.getType());
        if (parambv.cyI()) {
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 11);
        }
        for (;;)
        {
          parambv = this.cXJ.Kkd;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(parambv, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parambv.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(parambv, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(35759);
          return;
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 1);
        }
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingUI.VideoComponent", "retranmist video unknow status.");
      AppMethodBeat.o(35759);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingUI.VideoComponent", "retransmit video but videoInfo is null!");
    AppMethodBeat.o(35759);
  }
  
  private void bv(Intent paramIntent)
  {
    AppMethodBeat.i(35765);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.VideoComponent", "sendVideoFromCustomRecord");
    if (paramIntent == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingUI.VideoComponent", "data == null");
      AppMethodBeat.o(35765);
      return;
    }
    Object localObject = paramIntent.getStringExtra("VideoRecorder_ToUser");
    String str = paramIntent.getStringExtra("VideoRecorder_FileName");
    int i = paramIntent.getIntExtra("VideoRecorder_VideoLength", 0);
    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingUI.VideoComponent", "fileName " + str + " length " + i + " user " + (String)localObject);
    if ((bu.isNullOrNil((String)localObject)) || (bu.isNullOrNil(str)) || (i < 0))
    {
      AppMethodBeat.o(35765);
      return;
    }
    if ((((String)localObject).equals("medianote")) && ((v.aAG() & 0x4000) == 0))
    {
      paramIntent = new s();
      paramIntent.fileName = str;
      paramIntent.hKI = i;
      paramIntent.dED = ((String)localObject);
      paramIntent.iwS = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(2, ""));
      paramIntent.createTime = bu.aRi();
      paramIntent.iwX = bu.aRi();
      paramIntent.iwU = i;
      paramIntent.ivD = i;
      com.tencent.mm.modelvideo.o.aNh();
      i = com.tencent.mm.modelvideo.t.HL(com.tencent.mm.modelvideo.t.HJ(str));
      if (i <= 0)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
        AppMethodBeat.o(35765);
        return;
      }
      paramIntent.hPI = i;
      com.tencent.mm.modelvideo.o.aNh();
      localObject = com.tencent.mm.modelvideo.t.HK(str);
      i = com.tencent.mm.modelvideo.t.HL((String)localObject);
      if (i <= 0)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + i);
        AppMethodBeat.o(35765);
        return;
      }
      paramIntent.iwW = i;
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + paramIntent.iwW + " videosize:" + paramIntent.hPI);
      paramIntent.status = 199;
      localObject = new bv();
      ((bv)localObject).ui(paramIntent.getUser());
      ((bv)localObject).setType(43);
      ((bv)localObject).kt(1);
      ((bv)localObject).uj(str);
      ((bv)localObject).setStatus(2);
      ((bv)localObject).qN(bl.BQ(paramIntent.getUser()));
      paramIntent.iwZ = ((int)bl.v((bv)localObject));
      com.tencent.mm.modelvideo.o.aNh().b(paramIntent);
      AppMethodBeat.o(35765);
      return;
    }
    u.c(str, i, (String)localObject, null);
    u.HT(str);
    this.cXJ.xY(true);
    AppMethodBeat.o(35765);
  }
  
  private void gL(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(35757);
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35749);
        u.aw(paramString, paramInt);
        AppMethodBeat.o(35749);
      }
    });
    AppMethodBeat.o(35757);
  }
  
  public final boolean a(final MenuItem paramMenuItem, final bv parambv)
  {
    AppMethodBeat.i(35758);
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 106: 
    case 107: 
      for (;;)
      {
        AppMethodBeat.o(35758);
        return false;
        paramMenuItem = com.tencent.mm.modelvideo.o.aNh().HD(parambv.field_imgPath);
        if (paramMenuItem != null) {
          if (paramMenuItem.status == 199)
          {
            com.tencent.mm.modelvideo.o.aNh();
            parambv = com.tencent.mm.modelvideo.t.HJ(parambv.field_imgPath);
            if (paramMenuItem != null)
            {
              i = 0;
              if (x.wb(paramMenuItem.getUser())) {
                i = r.zC(paramMenuItem.getUser());
              }
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, 215L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yxI.f(12084, new Object[] { Integer.valueOf(paramMenuItem.hPI), Integer.valueOf(paramMenuItem.hKI * 1000), Integer.valueOf(0), Integer.valueOf(2), paramMenuItem.getUser(), Integer.valueOf(i), s.HA(paramMenuItem.aNt()), Long.valueOf(paramMenuItem.createTime) });
            }
            paramMenuItem = u.Ib(parambv);
            if (bu.isNullOrNil(paramMenuItem)) {
              Toast.makeText(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131764682), 1).show();
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(35758);
          return true;
          Toast.makeText(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131764683, new Object[] { com.tencent.mm.sdk.f.b.aSY(paramMenuItem) }), 1).show();
          q.k(paramMenuItem, this.cXJ.Kkd.getContext());
          continue;
          gL(paramMenuItem.getFileName(), 6);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
          paramMenuItem = new Intent(this.cXJ.Kkd.getContext(), ImageGalleryUI.class);
          paramMenuItem.putExtra("img_gallery_msg_id", parambv.field_msgId);
          paramMenuItem.putExtra("img_gallery_msg_svr_id", parambv.field_msgSvrId);
          paramMenuItem.putExtra("img_gallery_talker", parambv.field_talker);
          paramMenuItem.putExtra("img_gallery_chatroom_name", parambv.field_talker);
          paramMenuItem.putExtra("img_gallery_enter_video_opcode", u.f(parambv.field_msgId, 2));
          l.a(this.cXJ, parambv, paramMenuItem);
          parambv = this.cXJ.Kkd;
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parambv, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickSaveVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parambv.startActivity((Intent)paramMenuItem.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(parambv, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickSaveVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.cXJ.Kkd.overridePendingTransition(0, 0);
          continue;
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingUI.VideoComponent", "save video but videoInfo is null!");
        }
        paramMenuItem = bn.E(parambv);
        if ((bu.isNullOrNil(paramMenuItem)) || (parambv.field_isSend == 1))
        {
          bU(parambv);
        }
        else
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
          h.a(this.cXJ.Kkd.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35750);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
              paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
              paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
              d.b(be.this.cXJ.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
              com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
              AppMethodBeat.o(35750);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35751);
              be.a(be.this, parambv);
              com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
              AppMethodBeat.o(35751);
            }
          });
        }
      }
    }
    Intent localIntent = paramMenuItem.getIntent();
    int j = 0;
    int i = 0;
    paramMenuItem = new int[2];
    if (localIntent == null) {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingUI.VideoComponent", "[LONGCLICK_MENU_MUTE_PLAY] intent is null!");
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] LONGCLICK_MENU_MUTE_PLAY");
      localIntent = new Intent(this.cXJ.Kkd.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", parambv.field_msgId);
      localIntent.putExtra("img_gallery_msg_svr_id", parambv.field_msgSvrId);
      localIntent.putExtra("img_gallery_talker", parambv.field_talker);
      localIntent.putExtra("img_gallery_chatroom_name", parambv.field_talker);
      localIntent.putExtra("img_gallery_left", paramMenuItem[0]);
      localIntent.putExtra("img_gallery_top", paramMenuItem[1]);
      localIntent.putExtra("img_gallery_width", j);
      localIntent.putExtra("img_gallery_height", i);
      localIntent.putExtra("img_gallery_enter_video_opcode", u.f(parambv.field_msgId, 3));
      l.a(this.cXJ, parambv, localIntent);
      paramMenuItem = this.cXJ.Kkd;
      parambv = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, parambv.ahE(), "com/tencent/mm/ui/chatting/component/VideoComponent", "dealWithLongClick", "(Landroid/view/MenuItem;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramMenuItem.startActivity((Intent)parambv.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, "com/tencent/mm/ui/chatting/component/VideoComponent", "dealWithLongClick", "(Landroid/view/MenuItem;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.cXJ.Kkd.overridePendingTransition(0, 0);
      AppMethodBeat.o(35758);
      return true;
      j = localIntent.getIntExtra("img_gallery_width", 0);
      i = localIntent.getIntExtra("img_gallery_height", 0);
      paramMenuItem[0] = localIntent.getIntExtra("img_gallery_left", 0);
      paramMenuItem[1] = localIntent.getIntExtra("img_gallery_top", 0);
    }
  }
  
  public final void aD(final Intent paramIntent)
  {
    AppMethodBeat.i(35763);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingUI.VideoComponent", "sendVideo");
    if (!com.tencent.mm.network.ae.cR(this.cXJ.Kkd.getContext()))
    {
      h.a(this.cXJ.Kkd.getContext(), 2131764676, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35754);
          be.a(be.this, paramIntent);
          AppMethodBeat.o(35754);
        }
      }, null);
      AppMethodBeat.o(35763);
      return;
    }
    aE(paramIntent);
    AppMethodBeat.o(35763);
  }
  
  public final void bu(Intent paramIntent)
  {
    AppMethodBeat.i(35761);
    if (paramIntent == null)
    {
      AppMethodBeat.o(35761);
      return;
    }
    paramIntent = paramIntent.getStringArrayListExtra("key_select_video_list");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      if (!com.tencent.mm.network.ae.cR(this.cXJ.Kkd.getContext()))
      {
        aY(paramIntent);
        AppMethodBeat.o(35761);
        return;
      }
      aY(paramIntent);
      AppMethodBeat.o(35761);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingUI.VideoComponent", "send video list is null or nil");
    AppMethodBeat.o(35761);
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(35767);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingResume]");
    k localk = (k)this.cXJ.bh(k.class);
    com.tencent.mm.modelvideo.o.aNh().a(localk.fGu(), bc.ajU().IxZ.getLooper());
    AppMethodBeat.o(35767);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35768);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingPause]");
    k localk = (k)this.cXJ.bh(k.class);
    com.tencent.mm.modelvideo.o.aNh().a(localk.fGu());
    AppMethodBeat.o(35768);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35769);
    com.tencent.mm.plugin.sight.decode.a.b.ayL();
    this.Kjk.clear();
    AppMethodBeat.o(35769);
  }
  
  public final boolean g(bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(35760);
    boolean bool;
    if (parambv.cyG())
    {
      com.tencent.mm.modelvideo.o.aNh();
      bool = paramBoolean;
      if (!com.tencent.mm.vfs.o.fB(com.tencent.mm.modelvideo.t.HJ(parambv.field_imgPath))) {
        bool = false;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35760);
      return bool;
      bool = paramBoolean;
      if (parambv.cyI())
      {
        com.tencent.mm.modelvideo.o.aNh();
        bool = paramBoolean;
        if (!com.tencent.mm.vfs.o.fB(com.tencent.mm.modelvideo.t.HJ(parambv.field_imgPath))) {
          bool = false;
        }
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35766);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35766);
      return;
      aD(paramIntent);
      AppMethodBeat.o(35766);
      return;
      aD(paramIntent);
      AppMethodBeat.o(35766);
      return;
      bv(paramIntent);
      AppMethodBeat.o(35766);
      return;
      if (paramIntent != null)
      {
        if (paramIntent.getBooleanExtra("from_record", false))
        {
          bv(paramIntent);
          AppMethodBeat.o(35766);
          return;
        }
        aD(paramIntent);
      }
      AppMethodBeat.o(35766);
      return;
      if (paramIntent == null)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == data");
        AppMethodBeat.o(35766);
        return;
      }
      paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
      if (paramIntent == null)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == captureResult");
        AppMethodBeat.o(35766);
        return;
      }
      if (!paramIntent.vYw)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.VideoComponent", "video path %s thumb path %s", new Object[] { paramIntent.vYy, paramIntent.vYz });
        com.tencent.mm.modelvideo.o.aNh();
        String str = com.tencent.mm.modelvideo.t.HJ(paramIntent.vYA);
        if (!paramIntent.vYy.equals(str))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingUI.VideoComponent", "filepath not videopath and move it %s %s", new Object[] { paramIntent.vYy, str });
          com.tencent.mm.vfs.o.mG(paramIntent.vYy, str);
        }
        str = paramIntent.vYA;
        paramInt1 = paramIntent.vYC;
        Object localObject = this.cXJ.getTalkerUserName();
        byg localbyg = paramIntent.vYD;
        s locals = new s();
        locals.fileName = str;
        locals.hKI = paramInt1;
        locals.dED = ((String)localObject);
        locals.iwS = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(2, ""));
        locals.createTime = bu.aRi();
        locals.iwX = bu.aRi();
        locals.ixi = localbyg;
        locals.ixc = 0;
        locals.ixf = 1;
        com.tencent.mm.modelvideo.o.aNh();
        paramInt1 = com.tencent.mm.modelvideo.t.HL(com.tencent.mm.modelvideo.t.HJ(str));
        boolean bool;
        if (paramInt1 <= 0)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
          bool = false;
        }
        while (bool)
        {
          u.HT(paramIntent.vYA);
          AppMethodBeat.o(35766);
          return;
          locals.hPI = paramInt1;
          com.tencent.mm.modelvideo.o.aNh();
          localObject = com.tencent.mm.modelvideo.t.HK(str);
          paramInt1 = com.tencent.mm.modelvideo.t.HL((String)localObject);
          if (paramInt1 <= 0)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + paramInt1);
            bool = false;
          }
          else
          {
            locals.iwW = paramInt1;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str + " thumbsize:" + locals.iwW + " videosize:" + locals.hPI);
            locals.status = 102;
            localObject = new bv();
            ((bv)localObject).ui(locals.getUser());
            ((bv)localObject).setType(43);
            ((bv)localObject).kt(1);
            ((bv)localObject).uj(str);
            ((bv)localObject).setStatus(1);
            ((bv)localObject).qN(bl.BQ(locals.getUser()));
            locals.iwZ = ((int)bl.v((bv)localObject));
            bool = com.tencent.mm.modelvideo.o.aNh().b(locals);
          }
        }
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingUI.VideoComponent", "prepareMMSightRecord failed");
        AppMethodBeat.o(35766);
        return;
      }
      ((ak)this.cXJ.bh(ak.class)).a(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.be
 * JD-Core Version:    0.7.0.1
 */