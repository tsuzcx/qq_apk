package com.tencent.mm.ui.chatting.c;

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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.c.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.pluginsdk.model.l.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.chatting.c.b.an;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.c.a.a(eYT=an.class)
public class az
  extends a
  implements an
{
  private long Gzm;
  private SparseBooleanArray Gzn;
  
  public az()
  {
    AppMethodBeat.i(35756);
    this.Gzm = -1L;
    this.Gzn = new SparseBooleanArray();
    AppMethodBeat.o(35756);
  }
  
  private void aO(final ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(35762);
    ad.v("MicroMsg.ChattingUI.VideoComponent", "send video path: %s", new Object[] { paramArrayList.toString() });
    paramArrayList = new l(this.cOd.GzJ.getContext(), paramArrayList, null, this.cOd.getTalkerUserName(), 2, new l.a()
    {
      public final void evo()
      {
        AppMethodBeat.i(35752);
        az.this.cOd.dismissDialog();
        AppMethodBeat.o(35752);
      }
    });
    com.tencent.mm.ui.chatting.d.a locala = this.cOd;
    Activity localActivity = this.cOd.GzJ.getContext();
    this.cOd.GzJ.getMMResources().getString(2131755906);
    locala.b(localActivity, this.cOd.GzJ.getMMResources().getString(2131755936), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(35753);
        paramArrayList.evi();
        AppMethodBeat.o(35753);
      }
    });
    com.tencent.mm.sdk.g.b.c(paramArrayList, "ChattingUI_importMultiVideo");
    AppMethodBeat.o(35762);
  }
  
  private void ax(Intent paramIntent)
  {
    AppMethodBeat.i(35764);
    final com.tencent.mm.modelvideo.c localc = new com.tencent.mm.modelvideo.c();
    localc.a(this.cOd.GzJ.getContext(), paramIntent, new c.a()
    {
      public final void c(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(35755);
        if (paramAnonymousInt1 == -50002) {
          Toast.makeText(az.this.cOd.GzJ.getContext(), az.this.cOd.GzJ.getContext().getString(2131764675), 0).show();
        }
        for (;;)
        {
          az.this.cOd.dismissDialog();
          AppMethodBeat.o(35755);
          return;
          if (paramAnonymousInt1 < 0)
          {
            Toast.makeText(az.this.cOd.GzJ.getContext(), az.this.cOd.GzJ.getContext().getString(2131764674), 0).show();
          }
          else
          {
            com.tencent.mm.modelvideo.u.c(paramAnonymousString1, paramAnonymousInt2, az.this.cOd.getTalkerUserName(), paramAnonymousString2);
            com.tencent.mm.modelvideo.u.zX(paramAnonymousString1);
          }
        }
      }
    });
    paramIntent = this.cOd;
    Activity localActivity = this.cOd.GzJ.getContext();
    this.cOd.GzJ.getMMResources().getString(2131755906);
    paramIntent.b(localActivity, this.cOd.GzJ.getMMResources().getString(2131755936), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        localc.hxK = null;
      }
    });
    AppMethodBeat.o(35764);
  }
  
  private void bL(bl parambl)
  {
    AppMethodBeat.i(35759);
    com.tencent.mm.model.az.arV();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.cOd.GzJ.getContext(), this.cOd.GzJ.getContentView());
      AppMethodBeat.o(35759);
      return;
    }
    Object localObject1;
    if (parambl.cjN())
    {
      localObject1 = new Intent(this.cOd.GzJ.getContext(), MsgRetransmitUI.class);
      ((Intent)localObject1).putExtra("Retr_Msg_Id", parambl.field_msgId);
      ((Intent)localObject1).putExtra("Retr_Msg_content", parambl.field_content);
      ((Intent)localObject1).putExtra("Retr_From", "chattingui");
      ad.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + parambl.getType());
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 1);
      parambl = this.cOd.GzJ;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(parambl, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parambl.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(parambl, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35759);
      return;
    }
    s locals = com.tencent.mm.modelvideo.u.Ae(parambl.field_imgPath);
    if (locals != null)
    {
      Object localObject2 = locals.aCS();
      localObject1 = localObject2;
      if (!com.tencent.mm.vfs.i.eK((String)localObject2))
      {
        o.aCI();
        localObject1 = com.tencent.mm.modelvideo.t.zQ(parambl.field_imgPath);
      }
      if (parambl.eMl())
      {
        ad.i("MicroMsg.ChattingUI.VideoComponent", "video is clean!!!");
        com.tencent.mm.ui.base.h.d(this.cOd.GzJ.getContext(), this.cOd.GzJ.getContext().getString(2131764667), this.cOd.GzJ.getContext().getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(35759);
        return;
      }
      if (j.e(parambl, (String)localObject1))
      {
        ad.i("MicroMsg.ChattingUI.VideoComponent", "video is expired");
        gb(locals.getFileName(), 3);
        ad.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
        localObject2 = new Intent(this.cOd.GzJ.getContext(), ImageGalleryUI.class);
        ((Intent)localObject2).putExtra("img_gallery_msg_id", parambl.field_msgId);
        ((Intent)localObject2).putExtra("img_gallery_msg_svr_id", parambl.field_msgSvrId);
        ((Intent)localObject2).putExtra("img_gallery_talker", parambl.field_talker);
        ((Intent)localObject2).putExtra("img_gallery_chatroom_name", parambl.field_talker);
        ((Intent)localObject2).putExtra("img_gallery_enter_video_opcode", com.tencent.mm.modelvideo.u.f(parambl.field_msgId, 1));
        j.a(this.cOd, parambl, (Intent)localObject2);
        localObject1 = this.cOd.GzJ;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.cOd.GzJ.overridePendingTransition(0, 0);
        if (locals.aCV())
        {
          ad.i("MicroMsg.ChattingUI.VideoComponent", "start complete online video");
          com.tencent.mm.modelvideo.u.Al(parambl.field_imgPath);
          AppMethodBeat.o(35759);
          return;
        }
        ad.i("MicroMsg.ChattingUI.VideoComponent", "start complete offline video");
        com.tencent.mm.modelvideo.u.zZ(parambl.field_imgPath);
        AppMethodBeat.o(35759);
        return;
      }
      if ((parambl.cjM()) || (parambl.cjO()))
      {
        localObject1 = new Intent(this.cOd.GzJ.getContext(), MsgRetransmitUI.class);
        ((Intent)localObject1).putExtra("Retr_length", locals.gOY);
        ((Intent)localObject1).putExtra("Retr_File_Name", parambl.field_imgPath);
        ((Intent)localObject1).putExtra("Retr_video_isexport", locals.hAl);
        ((Intent)localObject1).putExtra("Retr_Msg_Id", parambl.field_msgId);
        ((Intent)localObject1).putExtra("Retr_From", "chattingui");
        ad.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + parambl.getType());
        if (parambl.cjO()) {
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 11);
        }
        for (;;)
        {
          parambl = this.cOd.GzJ;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(parambl, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parambl.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(parambl, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(35759);
          return;
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 1);
        }
      }
      ad.w("MicroMsg.ChattingUI.VideoComponent", "retranmist video unknow status.");
      AppMethodBeat.o(35759);
      return;
    }
    ad.e("MicroMsg.ChattingUI.VideoComponent", "retransmit video but videoInfo is null!");
    AppMethodBeat.o(35759);
  }
  
  private void bo(Intent paramIntent)
  {
    AppMethodBeat.i(35765);
    ad.i("MicroMsg.ChattingUI.VideoComponent", "sendVideoFromCustomRecord");
    if (paramIntent == null)
    {
      ad.e("MicroMsg.ChattingUI.VideoComponent", "data == null");
      AppMethodBeat.o(35765);
      return;
    }
    Object localObject = paramIntent.getStringExtra("VideoRecorder_ToUser");
    String str = paramIntent.getStringExtra("VideoRecorder_FileName");
    int i = paramIntent.getIntExtra("VideoRecorder_VideoLength", 0);
    ad.e("MicroMsg.ChattingUI.VideoComponent", "fileName " + str + " length " + i + " user " + (String)localObject);
    if ((bt.isNullOrNil((String)localObject)) || (bt.isNullOrNil(str)) || (i < 0))
    {
      AppMethodBeat.o(35765);
      return;
    }
    if ((((String)localObject).equals("medianote")) && ((com.tencent.mm.model.u.aqK() & 0x4000) == 0))
    {
      paramIntent = new s();
      paramIntent.fileName = str;
      paramIntent.gOY = i;
      paramIntent.dtV = ((String)localObject);
      paramIntent.hAb = ((String)g.afB().afk().get(2, ""));
      paramIntent.createTime = bt.aGK();
      paramIntent.hAg = bt.aGK();
      paramIntent.hAd = i;
      paramIntent.hyM = i;
      o.aCI();
      i = com.tencent.mm.modelvideo.t.zS(com.tencent.mm.modelvideo.t.zQ(str));
      if (i <= 0)
      {
        ad.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
        AppMethodBeat.o(35765);
        return;
      }
      paramIntent.gTY = i;
      o.aCI();
      localObject = com.tencent.mm.modelvideo.t.zR(str);
      i = com.tencent.mm.modelvideo.t.zS((String)localObject);
      if (i <= 0)
      {
        ad.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + i);
        AppMethodBeat.o(35765);
        return;
      }
      paramIntent.hAf = i;
      ad.d("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + paramIntent.hAf + " videosize:" + paramIntent.gTY);
      paramIntent.status = 199;
      localObject = new bl();
      ((bl)localObject).nY(paramIntent.getUser());
      ((bl)localObject).setType(43);
      ((bl)localObject).jV(1);
      ((bl)localObject).nZ(str);
      ((bl)localObject).setStatus(2);
      ((bl)localObject).kY(bi.uj(paramIntent.getUser()));
      paramIntent.hAi = ((int)bi.u((bl)localObject));
      o.aCI().b(paramIntent);
      AppMethodBeat.o(35765);
      return;
    }
    com.tencent.mm.modelvideo.u.c(str, i, (String)localObject, null);
    com.tencent.mm.modelvideo.u.zX(str);
    this.cOd.wc(true);
    AppMethodBeat.o(35765);
  }
  
  private void gb(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(35757);
    com.tencent.mm.model.az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35749);
        com.tencent.mm.modelvideo.u.ap(paramString, paramInt);
        AppMethodBeat.o(35749);
      }
    });
    AppMethodBeat.o(35757);
  }
  
  public final boolean a(final MenuItem paramMenuItem, final bl parambl)
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
        paramMenuItem = o.aCI().zO(parambl.field_imgPath);
        if (paramMenuItem != null) {
          if (paramMenuItem.status == 199)
          {
            o.aCI();
            parambl = com.tencent.mm.modelvideo.t.zQ(parambl.field_imgPath);
            if (paramMenuItem != null)
            {
              i = 0;
              if (w.pF(paramMenuItem.getUser())) {
                i = com.tencent.mm.model.q.rY(paramMenuItem.getUser());
              }
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(106L, 215L, 1L, false);
              com.tencent.mm.plugin.report.service.h.vKh.f(12084, new Object[] { Integer.valueOf(paramMenuItem.gTY), Integer.valueOf(paramMenuItem.gOY * 1000), Integer.valueOf(0), Integer.valueOf(2), paramMenuItem.getUser(), Integer.valueOf(i), s.zM(paramMenuItem.aCT()), Long.valueOf(paramMenuItem.createTime) });
            }
            paramMenuItem = com.tencent.mm.modelvideo.u.Af(parambl);
            if (bt.isNullOrNil(paramMenuItem)) {
              Toast.makeText(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131764682), 1).show();
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(35758);
          return true;
          Toast.makeText(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131764683, new Object[] { paramMenuItem }), 1).show();
          com.tencent.mm.pluginsdk.ui.tools.q.k(paramMenuItem, this.cOd.GzJ.getContext());
          continue;
          gb(paramMenuItem.getFileName(), 6);
          ad.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
          paramMenuItem = new Intent(this.cOd.GzJ.getContext(), ImageGalleryUI.class);
          paramMenuItem.putExtra("img_gallery_msg_id", parambl.field_msgId);
          paramMenuItem.putExtra("img_gallery_msg_svr_id", parambl.field_msgSvrId);
          paramMenuItem.putExtra("img_gallery_talker", parambl.field_talker);
          paramMenuItem.putExtra("img_gallery_chatroom_name", parambl.field_talker);
          paramMenuItem.putExtra("img_gallery_enter_video_opcode", com.tencent.mm.modelvideo.u.f(parambl.field_msgId, 2));
          j.a(this.cOd, parambl, paramMenuItem);
          parambl = this.cOd.GzJ;
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parambl, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickSaveVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parambl.startActivity((Intent)paramMenuItem.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(parambl, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickSaveVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.cOd.GzJ.overridePendingTransition(0, 0);
          continue;
          ad.e("MicroMsg.ChattingUI.VideoComponent", "save video but videoInfo is null!");
        }
        paramMenuItem = bk.C(parambl);
        if ((bt.isNullOrNil(paramMenuItem)) || (parambl.field_isSend == 1))
        {
          bL(parambl);
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
          com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35750);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
              paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
              paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
              d.b(az.this.cOd.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
              com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
              AppMethodBeat.o(35750);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35751);
              az.a(az.this, parambl);
              com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
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
      ad.e("MicroMsg.ChattingUI.VideoComponent", "[LONGCLICK_MENU_MUTE_PLAY] intent is null!");
    }
    for (;;)
    {
      ad.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] LONGCLICK_MENU_MUTE_PLAY");
      localIntent = new Intent(this.cOd.GzJ.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", parambl.field_msgId);
      localIntent.putExtra("img_gallery_msg_svr_id", parambl.field_msgSvrId);
      localIntent.putExtra("img_gallery_talker", parambl.field_talker);
      localIntent.putExtra("img_gallery_chatroom_name", parambl.field_talker);
      localIntent.putExtra("img_gallery_left", paramMenuItem[0]);
      localIntent.putExtra("img_gallery_top", paramMenuItem[1]);
      localIntent.putExtra("img_gallery_width", j);
      localIntent.putExtra("img_gallery_height", i);
      localIntent.putExtra("img_gallery_enter_video_opcode", com.tencent.mm.modelvideo.u.f(parambl.field_msgId, 3));
      j.a(this.cOd, parambl, localIntent);
      paramMenuItem = this.cOd.GzJ;
      parambl = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, parambl.adn(), "com/tencent/mm/ui/chatting/component/VideoComponent", "dealWithLongClick", "(Landroid/view/MenuItem;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramMenuItem.startActivity((Intent)parambl.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, "com/tencent/mm/ui/chatting/component/VideoComponent", "dealWithLongClick", "(Landroid/view/MenuItem;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.cOd.GzJ.overridePendingTransition(0, 0);
      AppMethodBeat.o(35758);
      return true;
      j = localIntent.getIntExtra("img_gallery_width", 0);
      i = localIntent.getIntExtra("img_gallery_height", 0);
      paramMenuItem[0] = localIntent.getIntExtra("img_gallery_left", 0);
      paramMenuItem[1] = localIntent.getIntExtra("img_gallery_top", 0);
    }
  }
  
  public final void aw(final Intent paramIntent)
  {
    AppMethodBeat.i(35763);
    ad.d("MicroMsg.ChattingUI.VideoComponent", "sendVideo");
    if (!ae.cJ(this.cOd.GzJ.getContext()))
    {
      com.tencent.mm.ui.base.h.a(this.cOd.GzJ.getContext(), 2131764676, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35754);
          az.a(az.this, paramIntent);
          AppMethodBeat.o(35754);
        }
      }, null);
      AppMethodBeat.o(35763);
      return;
    }
    ax(paramIntent);
    AppMethodBeat.o(35763);
  }
  
  public final void bn(Intent paramIntent)
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
      if (!ae.cJ(this.cOd.GzJ.getContext()))
      {
        aO(paramIntent);
        AppMethodBeat.o(35761);
        return;
      }
      aO(paramIntent);
      AppMethodBeat.o(35761);
      return;
    }
    ad.e("MicroMsg.ChattingUI.VideoComponent", "send video list is null or nil");
    AppMethodBeat.o(35761);
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(35767);
    ad.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingResume]");
    com.tencent.mm.ui.chatting.c.b.i locali = (com.tencent.mm.ui.chatting.c.b.i)this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class);
    o.aCI().a(locali.eWn(), com.tencent.mm.model.az.afE().EUN.getLooper());
    AppMethodBeat.o(35767);
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35768);
    ad.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingPause]");
    com.tencent.mm.ui.chatting.c.b.i locali = (com.tencent.mm.ui.chatting.c.b.i)this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class);
    o.aCI().a(locali.eWn());
    AppMethodBeat.o(35768);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35769);
    com.tencent.mm.plugin.sight.decode.a.b.aoS();
    this.Gzn.clear();
    AppMethodBeat.o(35769);
  }
  
  public final boolean g(bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(35760);
    boolean bool;
    if (parambl.cjM())
    {
      o.aCI();
      bool = paramBoolean;
      if (!com.tencent.mm.vfs.i.eK(com.tencent.mm.modelvideo.t.zQ(parambl.field_imgPath))) {
        bool = false;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35760);
      return bool;
      bool = paramBoolean;
      if (parambl.cjO())
      {
        o.aCI();
        bool = paramBoolean;
        if (!com.tencent.mm.vfs.i.eK(com.tencent.mm.modelvideo.t.zQ(parambl.field_imgPath))) {
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
      aw(paramIntent);
      AppMethodBeat.o(35766);
      return;
      aw(paramIntent);
      AppMethodBeat.o(35766);
      return;
      bo(paramIntent);
      AppMethodBeat.o(35766);
      return;
      if (paramIntent != null)
      {
        if (paramIntent.getBooleanExtra("from_record", false))
        {
          bo(paramIntent);
          AppMethodBeat.o(35766);
          return;
        }
        aw(paramIntent);
      }
      AppMethodBeat.o(35766);
      return;
      if (paramIntent == null)
      {
        ad.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == data");
        AppMethodBeat.o(35766);
        return;
      }
      paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
      if (paramIntent == null)
      {
        ad.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == captureResult");
        AppMethodBeat.o(35766);
        return;
      }
      if (!paramIntent.tAP)
      {
        ad.i("MicroMsg.ChattingUI.VideoComponent", "video path %s thumb path %s", new Object[] { paramIntent.tAR, paramIntent.tAS });
        o.aCI();
        String str = com.tencent.mm.modelvideo.t.zQ(paramIntent.tAT);
        if (!paramIntent.tAR.equals(str))
        {
          ad.i("MicroMsg.ChattingUI.VideoComponent", "filepath not videopath and move it %s %s", new Object[] { paramIntent.tAR, str });
          com.tencent.mm.vfs.i.lD(paramIntent.tAR, str);
        }
        str = paramIntent.tAT;
        paramInt1 = paramIntent.tAV;
        Object localObject = this.cOd.getTalkerUserName();
        boj localboj = paramIntent.tAW;
        s locals = new s();
        locals.fileName = str;
        locals.gOY = paramInt1;
        locals.dtV = ((String)localObject);
        locals.hAb = ((String)g.afB().afk().get(2, ""));
        locals.createTime = bt.aGK();
        locals.hAg = bt.aGK();
        locals.hAr = localboj;
        locals.hAl = 0;
        locals.hAo = 1;
        o.aCI();
        paramInt1 = com.tencent.mm.modelvideo.t.zS(com.tencent.mm.modelvideo.t.zQ(str));
        boolean bool;
        if (paramInt1 <= 0)
        {
          ad.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
          bool = false;
        }
        while (bool)
        {
          com.tencent.mm.modelvideo.u.zX(paramIntent.tAT);
          AppMethodBeat.o(35766);
          return;
          locals.gTY = paramInt1;
          o.aCI();
          localObject = com.tencent.mm.modelvideo.t.zR(str);
          paramInt1 = com.tencent.mm.modelvideo.t.zS((String)localObject);
          if (paramInt1 <= 0)
          {
            ad.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + paramInt1);
            bool = false;
          }
          else
          {
            locals.hAf = paramInt1;
            ad.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str + " thumbsize:" + locals.hAf + " videosize:" + locals.gTY);
            locals.status = 102;
            localObject = new bl();
            ((bl)localObject).nY(locals.getUser());
            ((bl)localObject).setType(43);
            ((bl)localObject).jV(1);
            ((bl)localObject).nZ(str);
            ((bl)localObject).setStatus(1);
            ((bl)localObject).kY(bi.uj(locals.getUser()));
            locals.hAi = ((int)bi.u((bl)localObject));
            bool = o.aCI().b(locals);
          }
        }
        ad.e("MicroMsg.ChattingUI.VideoComponent", "prepareMMSightRecord failed");
        AppMethodBeat.o(35766);
        return;
      }
      ((af)this.cOd.be(af.class)).a(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.az
 * JD-Core Version:    0.7.0.1
 */