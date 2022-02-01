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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.c.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.pluginsdk.model.l.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aj;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.d.a.a(fFo=ar.class)
public class bd
  extends a
  implements ar
{
  private long JOm;
  private SparseBooleanArray JOn;
  
  public bd()
  {
    AppMethodBeat.i(35756);
    this.JOm = -1L;
    this.JOn = new SparseBooleanArray();
    AppMethodBeat.o(35756);
  }
  
  private void aD(Intent paramIntent)
  {
    AppMethodBeat.i(35764);
    final com.tencent.mm.modelvideo.c localc = new com.tencent.mm.modelvideo.c();
    localc.a(this.cWM.JOR.getContext(), paramIntent, this.cWM.getTalkerUserName(), new c.a()
    {
      public final void c(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(35755);
        if (paramAnonymousInt1 == -50002) {
          Toast.makeText(bd.this.cWM.JOR.getContext(), bd.this.cWM.JOR.getContext().getString(2131764675), 0).show();
        }
        for (;;)
        {
          bd.this.cWM.dismissDialog();
          AppMethodBeat.o(35755);
          return;
          if (paramAnonymousInt1 < 0)
          {
            Toast.makeText(bd.this.cWM.JOR.getContext(), bd.this.cWM.JOR.getContext().getString(2131764674), 0).show();
          }
          else
          {
            com.tencent.mm.modelvideo.u.c(paramAnonymousString1, paramAnonymousInt2, bd.this.cWM.getTalkerUserName(), paramAnonymousString2);
            com.tencent.mm.modelvideo.u.Hr(paramAnonymousString1);
          }
        }
      }
    });
    paramIntent = this.cWM;
    Activity localActivity = this.cWM.JOR.getContext();
    this.cWM.JOR.getMMResources().getString(2131755906);
    paramIntent.b(localActivity, this.cWM.JOR.getMMResources().getString(2131755936), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        localc.irH = null;
      }
    });
    AppMethodBeat.o(35764);
  }
  
  private void aX(final ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(35762);
    ad.v("MicroMsg.ChattingUI.VideoComponent", "send video path: %s", new Object[] { paramArrayList.toString() });
    paramArrayList = new com.tencent.mm.pluginsdk.model.l(this.cWM.JOR.getContext(), paramArrayList, null, this.cWM.getTalkerUserName(), 2, new l.a()
    {
      public final void eZC()
      {
        AppMethodBeat.i(35752);
        bd.this.cWM.dismissDialog();
        AppMethodBeat.o(35752);
      }
    });
    com.tencent.mm.ui.chatting.e.a locala = this.cWM;
    Activity localActivity = this.cWM.JOR.getContext();
    this.cWM.JOR.getMMResources().getString(2131755906);
    locala.b(localActivity, this.cWM.JOR.getMMResources().getString(2131755936), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(35753);
        paramArrayList.eZw();
        AppMethodBeat.o(35753);
      }
    });
    com.tencent.mm.sdk.g.b.c(paramArrayList, "ChattingUI_importMultiVideo");
    AppMethodBeat.o(35762);
  }
  
  private void bU(bu parambu)
  {
    AppMethodBeat.i(35759);
    ba.aBQ();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.cWM.JOR.getContext(), this.cWM.JOR.getContentView());
      AppMethodBeat.o(35759);
      return;
    }
    Object localObject1;
    if (parambu.cxg())
    {
      localObject1 = new Intent(this.cWM.JOR.getContext(), MsgRetransmitUI.class);
      ((Intent)localObject1).putExtra("Retr_Msg_Id", parambu.field_msgId);
      ((Intent)localObject1).putExtra("Retr_Msg_content", parambu.field_content);
      ((Intent)localObject1).putExtra("Retr_From", "chattingui");
      ad.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + parambu.getType());
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 1);
      parambu = this.cWM.JOR;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(parambu, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parambu.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(parambu, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35759);
      return;
    }
    s locals = com.tencent.mm.modelvideo.u.Hy(parambu.field_imgPath);
    if (locals != null)
    {
      Object localObject2 = locals.aMU();
      localObject1 = localObject2;
      if (!i.fv((String)localObject2))
      {
        o.aMJ();
        localObject1 = com.tencent.mm.modelvideo.t.Hh(parambu.field_imgPath);
      }
      if (parambu.frT())
      {
        ad.i("MicroMsg.ChattingUI.VideoComponent", "video is clean!!!");
        h.d(this.cWM.JOR.getContext(), this.cWM.JOR.getContext().getString(2131764667), this.cWM.JOR.getContext().getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(35759);
        return;
      }
      if (l.e(parambu, (String)localObject1))
      {
        ad.i("MicroMsg.ChattingUI.VideoComponent", "video is expired");
        gC(locals.getFileName(), 3);
        ad.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
        localObject2 = new Intent(this.cWM.JOR.getContext(), ImageGalleryUI.class);
        ((Intent)localObject2).putExtra("img_gallery_msg_id", parambu.field_msgId);
        ((Intent)localObject2).putExtra("img_gallery_msg_svr_id", parambu.field_msgSvrId);
        ((Intent)localObject2).putExtra("img_gallery_talker", parambu.field_talker);
        ((Intent)localObject2).putExtra("img_gallery_chatroom_name", parambu.field_talker);
        ((Intent)localObject2).putExtra("img_gallery_enter_video_opcode", com.tencent.mm.modelvideo.u.f(parambu.field_msgId, 1));
        l.a(this.cWM, parambu, (Intent)localObject2);
        localObject1 = this.cWM.JOR;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.cWM.JOR.overridePendingTransition(0, 0);
        if (locals.aMX())
        {
          ad.i("MicroMsg.ChattingUI.VideoComponent", "start complete online video");
          com.tencent.mm.modelvideo.u.HF(parambu.field_imgPath);
          AppMethodBeat.o(35759);
          return;
        }
        ad.i("MicroMsg.ChattingUI.VideoComponent", "start complete offline video");
        com.tencent.mm.modelvideo.u.Ht(parambu.field_imgPath);
        AppMethodBeat.o(35759);
        return;
      }
      if ((parambu.cxf()) || (parambu.cxh()))
      {
        localObject1 = new Intent(this.cWM.JOR.getContext(), MsgRetransmitUI.class);
        ((Intent)localObject1).putExtra("Retr_length", locals.hHQ);
        ((Intent)localObject1).putExtra("Retr_File_Name", parambu.field_imgPath);
        ((Intent)localObject1).putExtra("Retr_video_isexport", locals.iui);
        ((Intent)localObject1).putExtra("Retr_Msg_Id", parambu.field_msgId);
        ((Intent)localObject1).putExtra("Retr_From", "chattingui");
        ad.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + parambu.getType());
        if (parambu.cxh()) {
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 11);
        }
        for (;;)
        {
          parambu = this.cWM.JOR;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(parambu, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parambu.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(parambu, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
  
  private void bu(Intent paramIntent)
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
    if ((((String)localObject).equals("medianote")) && ((com.tencent.mm.model.u.aAq() & 0x4000) == 0))
    {
      paramIntent = new s();
      paramIntent.fileName = str;
      paramIntent.hHQ = i;
      paramIntent.dDy = ((String)localObject);
      paramIntent.itY = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(2, ""));
      paramIntent.createTime = bt.aQJ();
      paramIntent.iud = bt.aQJ();
      paramIntent.iua = i;
      paramIntent.isJ = i;
      o.aMJ();
      i = com.tencent.mm.modelvideo.t.Hj(com.tencent.mm.modelvideo.t.Hh(str));
      if (i <= 0)
      {
        ad.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
        AppMethodBeat.o(35765);
        return;
      }
      paramIntent.hMP = i;
      o.aMJ();
      localObject = com.tencent.mm.modelvideo.t.Hi(str);
      i = com.tencent.mm.modelvideo.t.Hj((String)localObject);
      if (i <= 0)
      {
        ad.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + i);
        AppMethodBeat.o(35765);
        return;
      }
      paramIntent.iuc = i;
      ad.d("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + paramIntent.iuc + " videosize:" + paramIntent.hMP);
      paramIntent.status = 199;
      localObject = new bu();
      ((bu)localObject).tN(paramIntent.getUser());
      ((bu)localObject).setType(43);
      ((bu)localObject).kr(1);
      ((bu)localObject).tO(str);
      ((bu)localObject).setStatus(2);
      ((bu)localObject).qA(bj.Bo(paramIntent.getUser()));
      paramIntent.iuf = ((int)bj.v((bu)localObject));
      o.aMJ().b(paramIntent);
      AppMethodBeat.o(35765);
      return;
    }
    com.tencent.mm.modelvideo.u.c(str, i, (String)localObject, null);
    com.tencent.mm.modelvideo.u.Hr(str);
    this.cWM.xR(true);
    AppMethodBeat.o(35765);
  }
  
  private void gC(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(35757);
    ba.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35749);
        com.tencent.mm.modelvideo.u.av(paramString, paramInt);
        AppMethodBeat.o(35749);
      }
    });
    AppMethodBeat.o(35757);
  }
  
  public final boolean a(final MenuItem paramMenuItem, final bu parambu)
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
        paramMenuItem = o.aMJ().Hb(parambu.field_imgPath);
        if (paramMenuItem != null) {
          if (paramMenuItem.status == 199)
          {
            o.aMJ();
            parambu = com.tencent.mm.modelvideo.t.Hh(parambu.field_imgPath);
            if (paramMenuItem != null)
            {
              i = 0;
              if (w.vF(paramMenuItem.getUser())) {
                i = com.tencent.mm.model.q.yS(paramMenuItem.getUser());
              }
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(106L, 215L, 1L, false);
              com.tencent.mm.plugin.report.service.g.yhR.f(12084, new Object[] { Integer.valueOf(paramMenuItem.hMP), Integer.valueOf(paramMenuItem.hHQ * 1000), Integer.valueOf(0), Integer.valueOf(2), paramMenuItem.getUser(), Integer.valueOf(i), s.GY(paramMenuItem.aMV()), Long.valueOf(paramMenuItem.createTime) });
            }
            paramMenuItem = com.tencent.mm.modelvideo.u.Hz(parambu);
            if (bt.isNullOrNil(paramMenuItem)) {
              Toast.makeText(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131764682), 1).show();
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(35758);
          return true;
          Toast.makeText(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131764683, new Object[] { com.tencent.mm.sdk.f.b.aRB(paramMenuItem) }), 1).show();
          com.tencent.mm.pluginsdk.ui.tools.q.k(paramMenuItem, this.cWM.JOR.getContext());
          continue;
          gC(paramMenuItem.getFileName(), 6);
          ad.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
          paramMenuItem = new Intent(this.cWM.JOR.getContext(), ImageGalleryUI.class);
          paramMenuItem.putExtra("img_gallery_msg_id", parambu.field_msgId);
          paramMenuItem.putExtra("img_gallery_msg_svr_id", parambu.field_msgSvrId);
          paramMenuItem.putExtra("img_gallery_talker", parambu.field_talker);
          paramMenuItem.putExtra("img_gallery_chatroom_name", parambu.field_talker);
          paramMenuItem.putExtra("img_gallery_enter_video_opcode", com.tencent.mm.modelvideo.u.f(parambu.field_msgId, 2));
          l.a(this.cWM, parambu, paramMenuItem);
          parambu = this.cWM.JOR;
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parambu, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickSaveVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parambu.startActivity((Intent)paramMenuItem.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(parambu, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickSaveVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.cWM.JOR.overridePendingTransition(0, 0);
          continue;
          ad.e("MicroMsg.ChattingUI.VideoComponent", "save video but videoInfo is null!");
        }
        paramMenuItem = bl.E(parambu);
        if ((bt.isNullOrNil(paramMenuItem)) || (parambu.field_isSend == 1))
        {
          bU(parambu);
        }
        else
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
          h.a(this.cWM.JOR.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35750);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
              paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
              paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
              d.b(bd.this.cWM.JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
              com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
              AppMethodBeat.o(35750);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35751);
              bd.a(bd.this, parambu);
              com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
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
      localIntent = new Intent(this.cWM.JOR.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", parambu.field_msgId);
      localIntent.putExtra("img_gallery_msg_svr_id", parambu.field_msgSvrId);
      localIntent.putExtra("img_gallery_talker", parambu.field_talker);
      localIntent.putExtra("img_gallery_chatroom_name", parambu.field_talker);
      localIntent.putExtra("img_gallery_left", paramMenuItem[0]);
      localIntent.putExtra("img_gallery_top", paramMenuItem[1]);
      localIntent.putExtra("img_gallery_width", j);
      localIntent.putExtra("img_gallery_height", i);
      localIntent.putExtra("img_gallery_enter_video_opcode", com.tencent.mm.modelvideo.u.f(parambu.field_msgId, 3));
      l.a(this.cWM, parambu, localIntent);
      paramMenuItem = this.cWM.JOR;
      parambu = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, parambu.ahp(), "com/tencent/mm/ui/chatting/component/VideoComponent", "dealWithLongClick", "(Landroid/view/MenuItem;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramMenuItem.startActivity((Intent)parambu.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, "com/tencent/mm/ui/chatting/component/VideoComponent", "dealWithLongClick", "(Landroid/view/MenuItem;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.cWM.JOR.overridePendingTransition(0, 0);
      AppMethodBeat.o(35758);
      return true;
      j = localIntent.getIntExtra("img_gallery_width", 0);
      i = localIntent.getIntExtra("img_gallery_height", 0);
      paramMenuItem[0] = localIntent.getIntExtra("img_gallery_left", 0);
      paramMenuItem[1] = localIntent.getIntExtra("img_gallery_top", 0);
    }
  }
  
  public final void aC(final Intent paramIntent)
  {
    AppMethodBeat.i(35763);
    ad.d("MicroMsg.ChattingUI.VideoComponent", "sendVideo");
    if (!ae.cP(this.cWM.JOR.getContext()))
    {
      h.a(this.cWM.JOR.getContext(), 2131764676, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35754);
          bd.a(bd.this, paramIntent);
          AppMethodBeat.o(35754);
        }
      }, null);
      AppMethodBeat.o(35763);
      return;
    }
    aD(paramIntent);
    AppMethodBeat.o(35763);
  }
  
  public final void bt(Intent paramIntent)
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
      if (!ae.cP(this.cWM.JOR.getContext()))
      {
        aX(paramIntent);
        AppMethodBeat.o(35761);
        return;
      }
      aX(paramIntent);
      AppMethodBeat.o(35761);
      return;
    }
    ad.e("MicroMsg.ChattingUI.VideoComponent", "send video list is null or nil");
    AppMethodBeat.o(35761);
  }
  
  public final boolean f(bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(35760);
    boolean bool;
    if (parambu.cxf())
    {
      o.aMJ();
      bool = paramBoolean;
      if (!i.fv(com.tencent.mm.modelvideo.t.Hh(parambu.field_imgPath))) {
        bool = false;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35760);
      return bool;
      bool = paramBoolean;
      if (parambu.cxh())
      {
        o.aMJ();
        bool = paramBoolean;
        if (!i.fv(com.tencent.mm.modelvideo.t.Hh(parambu.field_imgPath))) {
          bool = false;
        }
      }
    }
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(35767);
    ad.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingResume]");
    k localk = (k)this.cWM.bh(k.class);
    o.aMJ().a(localk.fCs(), ba.ajF().IdO.getLooper());
    AppMethodBeat.o(35767);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35768);
    ad.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingPause]");
    k localk = (k)this.cWM.bh(k.class);
    o.aMJ().a(localk.fCs());
    AppMethodBeat.o(35768);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35769);
    com.tencent.mm.plugin.sight.decode.a.b.ayw();
    this.JOn.clear();
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
      aC(paramIntent);
      AppMethodBeat.o(35766);
      return;
      aC(paramIntent);
      AppMethodBeat.o(35766);
      return;
      bu(paramIntent);
      AppMethodBeat.o(35766);
      return;
      if (paramIntent != null)
      {
        if (paramIntent.getBooleanExtra("from_record", false))
        {
          bu(paramIntent);
          AppMethodBeat.o(35766);
          return;
        }
        aC(paramIntent);
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
      if (!paramIntent.vMs)
      {
        ad.i("MicroMsg.ChattingUI.VideoComponent", "video path %s thumb path %s", new Object[] { paramIntent.vMu, paramIntent.vMv });
        o.aMJ();
        String str = com.tencent.mm.modelvideo.t.Hh(paramIntent.vMw);
        if (!paramIntent.vMu.equals(str))
        {
          ad.i("MicroMsg.ChattingUI.VideoComponent", "filepath not videopath and move it %s %s", new Object[] { paramIntent.vMu, str });
          i.mA(paramIntent.vMu, str);
        }
        str = paramIntent.vMw;
        paramInt1 = paramIntent.vMy;
        Object localObject = this.cWM.getTalkerUserName();
        bxm localbxm = paramIntent.vMz;
        s locals = new s();
        locals.fileName = str;
        locals.hHQ = paramInt1;
        locals.dDy = ((String)localObject);
        locals.itY = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(2, ""));
        locals.createTime = bt.aQJ();
        locals.iud = bt.aQJ();
        locals.iuo = localbxm;
        locals.iui = 0;
        locals.iul = 1;
        o.aMJ();
        paramInt1 = com.tencent.mm.modelvideo.t.Hj(com.tencent.mm.modelvideo.t.Hh(str));
        boolean bool;
        if (paramInt1 <= 0)
        {
          ad.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
          bool = false;
        }
        while (bool)
        {
          com.tencent.mm.modelvideo.u.Hr(paramIntent.vMw);
          AppMethodBeat.o(35766);
          return;
          locals.hMP = paramInt1;
          o.aMJ();
          localObject = com.tencent.mm.modelvideo.t.Hi(str);
          paramInt1 = com.tencent.mm.modelvideo.t.Hj((String)localObject);
          if (paramInt1 <= 0)
          {
            ad.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + paramInt1);
            bool = false;
          }
          else
          {
            locals.iuc = paramInt1;
            ad.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str + " thumbsize:" + locals.iuc + " videosize:" + locals.hMP);
            locals.status = 102;
            localObject = new bu();
            ((bu)localObject).tN(locals.getUser());
            ((bu)localObject).setType(43);
            ((bu)localObject).kr(1);
            ((bu)localObject).tO(str);
            ((bu)localObject).setStatus(1);
            ((bu)localObject).qA(bj.Bo(locals.getUser()));
            locals.iuf = ((int)bj.v((bu)localObject));
            bool = o.aMJ().b(locals);
          }
        }
        ad.e("MicroMsg.ChattingUI.VideoComponent", "prepareMMSightRecord failed");
        AppMethodBeat.o(35766);
        return;
      }
      ((aj)this.cWM.bh(aj.class)).a(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bd
 * JD-Core Version:    0.7.0.1
 */