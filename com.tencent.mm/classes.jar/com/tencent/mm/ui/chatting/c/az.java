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
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.c.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.pluginsdk.model.l.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.chatting.c.b.an;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.c.a.a(foJ=an.class)
public class az
  extends a
  implements an
{
  private long HZh;
  private SparseBooleanArray HZi;
  
  public az()
  {
    AppMethodBeat.i(35756);
    this.HZh = -1L;
    this.HZi = new SparseBooleanArray();
    AppMethodBeat.o(35756);
  }
  
  private void ay(Intent paramIntent)
  {
    AppMethodBeat.i(35764);
    final com.tencent.mm.modelvideo.c localc = new com.tencent.mm.modelvideo.c();
    localc.a(this.cLy.HZF.getContext(), paramIntent, new c.a()
    {
      public final void c(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(35755);
        if (paramAnonymousInt1 == -50002) {
          Toast.makeText(az.this.cLy.HZF.getContext(), az.this.cLy.HZF.getContext().getString(2131764675), 0).show();
        }
        for (;;)
        {
          az.this.cLy.dismissDialog();
          AppMethodBeat.o(35755);
          return;
          if (paramAnonymousInt1 < 0)
          {
            Toast.makeText(az.this.cLy.HZF.getContext(), az.this.cLy.HZF.getContext().getString(2131764674), 0).show();
          }
          else
          {
            com.tencent.mm.modelvideo.u.c(paramAnonymousString1, paramAnonymousInt2, az.this.cLy.getTalkerUserName(), paramAnonymousString2);
            com.tencent.mm.modelvideo.u.Ec(paramAnonymousString1);
          }
        }
      }
    });
    paramIntent = this.cLy;
    Activity localActivity = this.cLy.HZF.getContext();
    this.cLy.HZF.getMMResources().getString(2131755906);
    paramIntent.b(localActivity, this.cLy.HZF.getMMResources().getString(2131755936), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        localc.hYl = null;
      }
    });
    AppMethodBeat.o(35764);
  }
  
  private void bO(bo parambo)
  {
    AppMethodBeat.i(35759);
    com.tencent.mm.model.az.ayM();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.cLy.HZF.getContext(), this.cLy.HZF.getContentView());
      AppMethodBeat.o(35759);
      return;
    }
    Object localObject1;
    if (parambo.cru())
    {
      localObject1 = new Intent(this.cLy.HZF.getContext(), MsgRetransmitUI.class);
      ((Intent)localObject1).putExtra("Retr_Msg_Id", parambo.field_msgId);
      ((Intent)localObject1).putExtra("Retr_Msg_content", parambo.field_content);
      ((Intent)localObject1).putExtra("Retr_From", "chattingui");
      ac.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + parambo.getType());
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 1);
      parambo = this.cLy.HZF;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(parambo, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parambo.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(parambo, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35759);
      return;
    }
    s locals = com.tencent.mm.modelvideo.u.Ej(parambo.field_imgPath);
    if (locals != null)
    {
      Object localObject2 = locals.aJJ();
      localObject1 = localObject2;
      if (!com.tencent.mm.vfs.i.eA((String)localObject2))
      {
        o.aJy();
        localObject1 = com.tencent.mm.modelvideo.t.DV(parambo.field_imgPath);
      }
      if (parambo.fbQ())
      {
        ac.i("MicroMsg.ChattingUI.VideoComponent", "video is clean!!!");
        com.tencent.mm.ui.base.h.d(this.cLy.HZF.getContext(), this.cLy.HZF.getContext().getString(2131764667), this.cLy.HZF.getContext().getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(35759);
        return;
      }
      if (j.e(parambo, (String)localObject1))
      {
        ac.i("MicroMsg.ChattingUI.VideoComponent", "video is expired");
        gf(locals.getFileName(), 3);
        ac.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
        localObject2 = new Intent(this.cLy.HZF.getContext(), ImageGalleryUI.class);
        ((Intent)localObject2).putExtra("img_gallery_msg_id", parambo.field_msgId);
        ((Intent)localObject2).putExtra("img_gallery_msg_svr_id", parambo.field_msgSvrId);
        ((Intent)localObject2).putExtra("img_gallery_talker", parambo.field_talker);
        ((Intent)localObject2).putExtra("img_gallery_chatroom_name", parambo.field_talker);
        ((Intent)localObject2).putExtra("img_gallery_enter_video_opcode", com.tencent.mm.modelvideo.u.f(parambo.field_msgId, 1));
        j.a(this.cLy, parambo, (Intent)localObject2);
        localObject1 = this.cLy.HZF;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.cLy.HZF.overridePendingTransition(0, 0);
        if (locals.aJM())
        {
          ac.i("MicroMsg.ChattingUI.VideoComponent", "start complete online video");
          com.tencent.mm.modelvideo.u.Eq(parambo.field_imgPath);
          AppMethodBeat.o(35759);
          return;
        }
        ac.i("MicroMsg.ChattingUI.VideoComponent", "start complete offline video");
        com.tencent.mm.modelvideo.u.Ee(parambo.field_imgPath);
        AppMethodBeat.o(35759);
        return;
      }
      if ((parambo.crt()) || (parambo.crv()))
      {
        localObject1 = new Intent(this.cLy.HZF.getContext(), MsgRetransmitUI.class);
        ((Intent)localObject1).putExtra("Retr_length", locals.hpy);
        ((Intent)localObject1).putExtra("Retr_File_Name", parambo.field_imgPath);
        ((Intent)localObject1).putExtra("Retr_video_isexport", locals.iaM);
        ((Intent)localObject1).putExtra("Retr_Msg_Id", parambo.field_msgId);
        ((Intent)localObject1).putExtra("Retr_From", "chattingui");
        ac.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + parambo.getType());
        if (parambo.crv()) {
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 11);
        }
        for (;;)
        {
          parambo = this.cLy.HZF;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(parambo, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parambo.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(parambo, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(35759);
          return;
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 1);
        }
      }
      ac.w("MicroMsg.ChattingUI.VideoComponent", "retranmist video unknow status.");
      AppMethodBeat.o(35759);
      return;
    }
    ac.e("MicroMsg.ChattingUI.VideoComponent", "retransmit video but videoInfo is null!");
    AppMethodBeat.o(35759);
  }
  
  private void ba(final ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(35762);
    ac.v("MicroMsg.ChattingUI.VideoComponent", "send video path: %s", new Object[] { paramArrayList.toString() });
    paramArrayList = new l(this.cLy.HZF.getContext(), paramArrayList, null, this.cLy.getTalkerUserName(), 2, new l.a()
    {
      public final void eKI()
      {
        AppMethodBeat.i(35752);
        az.this.cLy.dismissDialog();
        AppMethodBeat.o(35752);
      }
    });
    com.tencent.mm.ui.chatting.d.a locala = this.cLy;
    Activity localActivity = this.cLy.HZF.getContext();
    this.cLy.HZF.getMMResources().getString(2131755906);
    locala.b(localActivity, this.cLy.HZF.getMMResources().getString(2131755936), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(35753);
        paramArrayList.eKC();
        AppMethodBeat.o(35753);
      }
    });
    com.tencent.mm.sdk.g.b.c(paramArrayList, "ChattingUI_importMultiVideo");
    AppMethodBeat.o(35762);
  }
  
  private void bp(Intent paramIntent)
  {
    AppMethodBeat.i(35765);
    ac.i("MicroMsg.ChattingUI.VideoComponent", "sendVideoFromCustomRecord");
    if (paramIntent == null)
    {
      ac.e("MicroMsg.ChattingUI.VideoComponent", "data == null");
      AppMethodBeat.o(35765);
      return;
    }
    Object localObject = paramIntent.getStringExtra("VideoRecorder_ToUser");
    String str = paramIntent.getStringExtra("VideoRecorder_FileName");
    int i = paramIntent.getIntExtra("VideoRecorder_VideoLength", 0);
    ac.e("MicroMsg.ChattingUI.VideoComponent", "fileName " + str + " length " + i + " user " + (String)localObject);
    if ((bs.isNullOrNil((String)localObject)) || (bs.isNullOrNil(str)) || (i < 0))
    {
      AppMethodBeat.o(35765);
      return;
    }
    if ((((String)localObject).equals("medianote")) && ((com.tencent.mm.model.u.axA() & 0x4000) == 0))
    {
      paramIntent = new s();
      paramIntent.fileName = str;
      paramIntent.hpy = i;
      paramIntent.drG = ((String)localObject);
      paramIntent.iaC = ((String)g.agR().agA().get(2, ""));
      paramIntent.createTime = bs.aNx();
      paramIntent.iaH = bs.aNx();
      paramIntent.iaE = i;
      paramIntent.hZn = i;
      o.aJy();
      i = com.tencent.mm.modelvideo.t.DX(com.tencent.mm.modelvideo.t.DV(str));
      if (i <= 0)
      {
        ac.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
        AppMethodBeat.o(35765);
        return;
      }
      paramIntent.hux = i;
      o.aJy();
      localObject = com.tencent.mm.modelvideo.t.DW(str);
      i = com.tencent.mm.modelvideo.t.DX((String)localObject);
      if (i <= 0)
      {
        ac.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + i);
        AppMethodBeat.o(35765);
        return;
      }
      paramIntent.iaG = i;
      ac.d("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + paramIntent.iaG + " videosize:" + paramIntent.hux);
      paramIntent.status = 199;
      localObject = new bo();
      ((bo)localObject).re(paramIntent.getUser());
      ((bo)localObject).setType(43);
      ((bo)localObject).jT(1);
      ((bo)localObject).rf(str);
      ((bo)localObject).setStatus(2);
      ((bo)localObject).oA(bi.yp(paramIntent.getUser()));
      paramIntent.iaJ = ((int)bi.u((bo)localObject));
      o.aJy().b(paramIntent);
      AppMethodBeat.o(35765);
      return;
    }
    com.tencent.mm.modelvideo.u.c(str, i, (String)localObject, null);
    com.tencent.mm.modelvideo.u.Ec(str);
    this.cLy.xg(true);
    AppMethodBeat.o(35765);
  }
  
  private void gf(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(35757);
    com.tencent.mm.model.az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35749);
        com.tencent.mm.modelvideo.u.at(paramString, paramInt);
        AppMethodBeat.o(35749);
      }
    });
    AppMethodBeat.o(35757);
  }
  
  public final boolean a(final MenuItem paramMenuItem, final bo parambo)
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
        paramMenuItem = o.aJy().DT(parambo.field_imgPath);
        if (paramMenuItem != null) {
          if (paramMenuItem.status == 199)
          {
            o.aJy();
            parambo = com.tencent.mm.modelvideo.t.DV(parambo.field_imgPath);
            if (paramMenuItem != null)
            {
              i = 0;
              if (w.sQ(paramMenuItem.getUser())) {
                i = com.tencent.mm.model.q.wb(paramMenuItem.getUser());
              }
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(106L, 215L, 1L, false);
              com.tencent.mm.plugin.report.service.h.wUl.f(12084, new Object[] { Integer.valueOf(paramMenuItem.hux), Integer.valueOf(paramMenuItem.hpy * 1000), Integer.valueOf(0), Integer.valueOf(2), paramMenuItem.getUser(), Integer.valueOf(i), s.DR(paramMenuItem.aJK()), Long.valueOf(paramMenuItem.createTime) });
            }
            paramMenuItem = com.tencent.mm.modelvideo.u.Ek(parambo);
            if (bs.isNullOrNil(paramMenuItem)) {
              Toast.makeText(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131764682), 1).show();
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(35758);
          return true;
          Toast.makeText(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131764683, new Object[] { com.tencent.mm.sdk.f.b.aLU(paramMenuItem) }), 1).show();
          com.tencent.mm.pluginsdk.ui.tools.q.k(paramMenuItem, this.cLy.HZF.getContext());
          continue;
          gf(paramMenuItem.getFileName(), 6);
          ac.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
          paramMenuItem = new Intent(this.cLy.HZF.getContext(), ImageGalleryUI.class);
          paramMenuItem.putExtra("img_gallery_msg_id", parambo.field_msgId);
          paramMenuItem.putExtra("img_gallery_msg_svr_id", parambo.field_msgSvrId);
          paramMenuItem.putExtra("img_gallery_talker", parambo.field_talker);
          paramMenuItem.putExtra("img_gallery_chatroom_name", parambo.field_talker);
          paramMenuItem.putExtra("img_gallery_enter_video_opcode", com.tencent.mm.modelvideo.u.f(parambo.field_msgId, 2));
          j.a(this.cLy, parambo, paramMenuItem);
          parambo = this.cLy.HZF;
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parambo, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickSaveVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parambo.startActivity((Intent)paramMenuItem.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(parambo, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickSaveVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.cLy.HZF.overridePendingTransition(0, 0);
          continue;
          ac.e("MicroMsg.ChattingUI.VideoComponent", "save video but videoInfo is null!");
        }
        paramMenuItem = bk.C(parambo);
        if ((bs.isNullOrNil(paramMenuItem)) || (parambo.field_isSend == 1))
        {
          bO(parambo);
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
          com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35750);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
              paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
              paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
              d.b(az.this.cLy.HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
              com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
              AppMethodBeat.o(35750);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35751);
              az.a(az.this, parambo);
              com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
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
      ac.e("MicroMsg.ChattingUI.VideoComponent", "[LONGCLICK_MENU_MUTE_PLAY] intent is null!");
    }
    for (;;)
    {
      ac.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] LONGCLICK_MENU_MUTE_PLAY");
      localIntent = new Intent(this.cLy.HZF.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", parambo.field_msgId);
      localIntent.putExtra("img_gallery_msg_svr_id", parambo.field_msgSvrId);
      localIntent.putExtra("img_gallery_talker", parambo.field_talker);
      localIntent.putExtra("img_gallery_chatroom_name", parambo.field_talker);
      localIntent.putExtra("img_gallery_left", paramMenuItem[0]);
      localIntent.putExtra("img_gallery_top", paramMenuItem[1]);
      localIntent.putExtra("img_gallery_width", j);
      localIntent.putExtra("img_gallery_height", i);
      localIntent.putExtra("img_gallery_enter_video_opcode", com.tencent.mm.modelvideo.u.f(parambo.field_msgId, 3));
      j.a(this.cLy, parambo, localIntent);
      paramMenuItem = this.cLy.HZF;
      parambo = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, parambo.aeD(), "com/tencent/mm/ui/chatting/component/VideoComponent", "dealWithLongClick", "(Landroid/view/MenuItem;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramMenuItem.startActivity((Intent)parambo.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, "com/tencent/mm/ui/chatting/component/VideoComponent", "dealWithLongClick", "(Landroid/view/MenuItem;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.cLy.HZF.overridePendingTransition(0, 0);
      AppMethodBeat.o(35758);
      return true;
      j = localIntent.getIntExtra("img_gallery_width", 0);
      i = localIntent.getIntExtra("img_gallery_height", 0);
      paramMenuItem[0] = localIntent.getIntExtra("img_gallery_left", 0);
      paramMenuItem[1] = localIntent.getIntExtra("img_gallery_top", 0);
    }
  }
  
  public final void ax(final Intent paramIntent)
  {
    AppMethodBeat.i(35763);
    ac.d("MicroMsg.ChattingUI.VideoComponent", "sendVideo");
    if (!com.tencent.mm.network.ae.cS(this.cLy.HZF.getContext()))
    {
      com.tencent.mm.ui.base.h.a(this.cLy.HZF.getContext(), 2131764676, 2131755906, new DialogInterface.OnClickListener()
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
    ay(paramIntent);
    AppMethodBeat.o(35763);
  }
  
  public final void bo(Intent paramIntent)
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
      if (!com.tencent.mm.network.ae.cS(this.cLy.HZF.getContext()))
      {
        ba(paramIntent);
        AppMethodBeat.o(35761);
        return;
      }
      ba(paramIntent);
      AppMethodBeat.o(35761);
      return;
    }
    ac.e("MicroMsg.ChattingUI.VideoComponent", "send video list is null or nil");
    AppMethodBeat.o(35761);
  }
  
  public final boolean f(bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(35760);
    boolean bool;
    if (parambo.crt())
    {
      o.aJy();
      bool = paramBoolean;
      if (!com.tencent.mm.vfs.i.eA(com.tencent.mm.modelvideo.t.DV(parambo.field_imgPath))) {
        bool = false;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35760);
      return bool;
      bool = paramBoolean;
      if (parambo.crv())
      {
        o.aJy();
        bool = paramBoolean;
        if (!com.tencent.mm.vfs.i.eA(com.tencent.mm.modelvideo.t.DV(parambo.field_imgPath))) {
          bool = false;
        }
      }
    }
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(35767);
    ac.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingResume]");
    com.tencent.mm.ui.chatting.c.b.i locali = (com.tencent.mm.ui.chatting.c.b.i)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class);
    o.aJy().a(locali.flZ(), com.tencent.mm.model.az.agU().GrZ.getLooper());
    AppMethodBeat.o(35767);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35768);
    ac.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingPause]");
    com.tencent.mm.ui.chatting.c.b.i locali = (com.tencent.mm.ui.chatting.c.b.i)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class);
    o.aJy().a(locali.flZ());
    AppMethodBeat.o(35768);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35769);
    com.tencent.mm.plugin.sight.decode.a.b.avJ();
    this.HZi.clear();
    AppMethodBeat.o(35769);
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
      ax(paramIntent);
      AppMethodBeat.o(35766);
      return;
      ax(paramIntent);
      AppMethodBeat.o(35766);
      return;
      bp(paramIntent);
      AppMethodBeat.o(35766);
      return;
      if (paramIntent != null)
      {
        if (paramIntent.getBooleanExtra("from_record", false))
        {
          bp(paramIntent);
          AppMethodBeat.o(35766);
          return;
        }
        ax(paramIntent);
      }
      AppMethodBeat.o(35766);
      return;
      if (paramIntent == null)
      {
        ac.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == data");
        AppMethodBeat.o(35766);
        return;
      }
      paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
      if (paramIntent == null)
      {
        ac.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == captureResult");
        AppMethodBeat.o(35766);
        return;
      }
      if (!paramIntent.uJm)
      {
        ac.i("MicroMsg.ChattingUI.VideoComponent", "video path %s thumb path %s", new Object[] { paramIntent.uJo, paramIntent.uJp });
        o.aJy();
        String str = com.tencent.mm.modelvideo.t.DV(paramIntent.uJq);
        if (!paramIntent.uJo.equals(str))
        {
          ac.i("MicroMsg.ChattingUI.VideoComponent", "filepath not videopath and move it %s %s", new Object[] { paramIntent.uJo, str });
          com.tencent.mm.vfs.i.ma(paramIntent.uJo, str);
        }
        str = paramIntent.uJq;
        paramInt1 = paramIntent.uJs;
        Object localObject = this.cLy.getTalkerUserName();
        bsz localbsz = paramIntent.uJt;
        s locals = new s();
        locals.fileName = str;
        locals.hpy = paramInt1;
        locals.drG = ((String)localObject);
        locals.iaC = ((String)g.agR().agA().get(2, ""));
        locals.createTime = bs.aNx();
        locals.iaH = bs.aNx();
        locals.iaS = localbsz;
        locals.iaM = 0;
        locals.iaP = 1;
        o.aJy();
        paramInt1 = com.tencent.mm.modelvideo.t.DX(com.tencent.mm.modelvideo.t.DV(str));
        boolean bool;
        if (paramInt1 <= 0)
        {
          ac.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
          bool = false;
        }
        while (bool)
        {
          com.tencent.mm.modelvideo.u.Ec(paramIntent.uJq);
          AppMethodBeat.o(35766);
          return;
          locals.hux = paramInt1;
          o.aJy();
          localObject = com.tencent.mm.modelvideo.t.DW(str);
          paramInt1 = com.tencent.mm.modelvideo.t.DX((String)localObject);
          if (paramInt1 <= 0)
          {
            ac.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + paramInt1);
            bool = false;
          }
          else
          {
            locals.iaG = paramInt1;
            ac.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str + " thumbsize:" + locals.iaG + " videosize:" + locals.hux);
            locals.status = 102;
            localObject = new bo();
            ((bo)localObject).re(locals.getUser());
            ((bo)localObject).setType(43);
            ((bo)localObject).jT(1);
            ((bo)localObject).rf(str);
            ((bo)localObject).setStatus(1);
            ((bo)localObject).oA(bi.yp(locals.getUser()));
            locals.iaJ = ((int)bi.u((bo)localObject));
            bool = o.aJy().b(locals);
          }
        }
        ac.e("MicroMsg.ChattingUI.VideoComponent", "prepareMMSightRecord failed");
        AppMethodBeat.o(35766);
        return;
      }
      ((af)this.cLy.bf(af.class)).a(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.az
 * JD-Core Version:    0.7.0.1
 */