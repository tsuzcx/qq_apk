package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.b.a.ll;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.g;
import com.tencent.mm.modelvideo.g.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.network.ag;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.model.o.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.d.a.a(hRc=aw.class)
public class bk
  extends a
  implements aw
{
  private long WPB;
  private SparseBooleanArray WPC;
  
  public bk()
  {
    AppMethodBeat.i(35756);
    this.WPB = -1L;
    this.WPC = new SparseBooleanArray();
    AppMethodBeat.o(35756);
  }
  
  private void aJ(Intent paramIntent)
  {
    AppMethodBeat.i(35764);
    final g localg = new g();
    localg.a(this.fgR.WQv.getContext(), paramIntent, this.fgR.getTalkerUserName(), new g.a()
    {
      public final void c(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(282665);
        if (paramAnonymousInt1 == -50002) {
          Toast.makeText(bk.this.fgR.WQv.getContext(), bk.this.fgR.WQv.getContext().getString(R.l.video_export_file_too_big), 0).show();
        }
        for (;;)
        {
          bk.this.fgR.dismissDialog();
          AppMethodBeat.o(282665);
          return;
          if (paramAnonymousInt1 < 0)
          {
            Toast.makeText(bk.this.fgR.WQv.getContext(), bk.this.fgR.WQv.getContext().getString(R.l.video_export_file_error), 0).show();
          }
          else
          {
            y.c(paramAnonymousString1, paramAnonymousInt2, bk.this.fgR.getTalkerUserName(), paramAnonymousString2);
            y.Yd(paramAnonymousString1);
          }
        }
      }
    });
    this.fgR.b(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.app_tip), this.fgR.WQv.getMMResources().getString(R.l.app_waiting), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        localg.mfp = null;
      }
    });
    AppMethodBeat.o(35764);
  }
  
  private void bE(final ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(35762);
    Log.v("MicroMsg.ChattingUI.VideoComponent", "send video path: %s", new Object[] { paramArrayList.toString() });
    paramArrayList = new o(this.fgR.WQv.getContext(), paramArrayList, null, this.fgR.getTalkerUserName(), 2, new o.a()
    {
      public final void hgY()
      {
        AppMethodBeat.i(224724);
        bk.this.fgR.dismissDialog();
        AppMethodBeat.o(224724);
      }
    });
    this.fgR.b(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.app_tip), this.fgR.WQv.getMMResources().getString(R.l.app_waiting), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(289632);
        paramArrayList.hgS();
        AppMethodBeat.o(289632);
      }
    });
    ThreadPool.post(paramArrayList, "ChattingUI_importMultiVideo");
    AppMethodBeat.o(35762);
  }
  
  private void bG(Intent paramIntent)
  {
    AppMethodBeat.i(35765);
    Log.i("MicroMsg.ChattingUI.VideoComponent", "sendVideoFromCustomRecord");
    if (paramIntent == null)
    {
      Log.e("MicroMsg.ChattingUI.VideoComponent", "data == null");
      AppMethodBeat.o(35765);
      return;
    }
    Object localObject = paramIntent.getStringExtra("VideoRecorder_ToUser");
    String str = paramIntent.getStringExtra("VideoRecorder_FileName");
    int i = paramIntent.getIntExtra("VideoRecorder_VideoLength", 0);
    Log.e("MicroMsg.ChattingUI.VideoComponent", "fileName " + str + " length " + i + " user " + (String)localObject);
    if ((Util.isNullOrNil((String)localObject)) || (Util.isNullOrNil(str)) || (i < 0))
    {
      AppMethodBeat.o(35765);
      return;
    }
    if ((((String)localObject).equals("medianote")) && ((z.bdd() & 0x4000) == 0))
    {
      paramIntent = new com.tencent.mm.modelvideo.w();
      paramIntent.fileName = str;
      paramIntent.lvw = i;
      paramIntent.fPV = ((String)localObject);
      paramIntent.mhK = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, ""));
      paramIntent.createTime = Util.nowSecond();
      paramIntent.mhP = Util.nowSecond();
      paramIntent.mhM = i;
      paramIntent.mgq = i;
      s.bqB();
      i = x.XV(x.XT(str));
      if (i <= 0)
      {
        Log.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
        AppMethodBeat.o(35765);
        return;
      }
      paramIntent.lAW = i;
      s.bqB();
      localObject = x.XU(str);
      i = x.XV((String)localObject);
      if (i <= 0)
      {
        Log.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + i);
        AppMethodBeat.o(35765);
        return;
      }
      paramIntent.mhO = i;
      Log.d("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + paramIntent.mhO + " videosize:" + paramIntent.lAW);
      paramIntent.status = 199;
      localObject = new ca();
      ((ca)localObject).Jm(paramIntent.bqM());
      ((ca)localObject).setType(43);
      ((ca)localObject).pJ(1);
      ((ca)localObject).Jn(str);
      ((ca)localObject).setStatus(2);
      ((ca)localObject).setCreateTime(bq.RP(paramIntent.bqM()));
      paramIntent.mhR = ((int)bq.z((ca)localObject));
      s.bqB().b(paramIntent);
      AppMethodBeat.o(35765);
      return;
    }
    y.c(str, i, (String)localObject, null);
    y.Yd(str);
    this.fgR.Gi(true);
    AppMethodBeat.o(35765);
  }
  
  private void cD(ca paramca)
  {
    AppMethodBeat.i(35759);
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.w.g(this.fgR.WQv.getContext(), this.fgR.WQv.getContentView());
      AppMethodBeat.o(35759);
      return;
    }
    Object localObject1;
    if (paramca.dlS())
    {
      localObject1 = new Intent(this.fgR.WQv.getContext(), MsgRetransmitUI.class);
      ((Intent)localObject1).putExtra("Retr_Msg_Id", paramca.field_msgId);
      ((Intent)localObject1).putExtra("Retr_Msg_content", paramca.field_content);
      ((Intent)localObject1).putExtra("Retr_From", "chattingui");
      Log.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + paramca.getType());
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 1);
      paramca = this.fgR.WQv;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(paramca, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramca.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramca, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35759);
      return;
    }
    com.tencent.mm.modelvideo.w localw = y.Yk(paramca.field_imgPath);
    if (localw != null)
    {
      Object localObject2 = localw.bqN();
      localObject1 = localObject2;
      if (!com.tencent.mm.vfs.u.agG((String)localObject2))
      {
        s.bqB();
        localObject1 = x.XT(paramca.field_imgPath);
      }
      if (paramca.Ic())
      {
        Log.i("MicroMsg.ChattingUI.VideoComponent", "video is clean!!!");
        com.tencent.mm.ui.base.h.d(this.fgR.WQv.getContext(), this.fgR.WQv.getContext().getString(R.l.eUE), this.fgR.WQv.getContext().getString(R.l.app_tip), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(35759);
        return;
      }
      if (m.j(paramca, (String)localObject1))
      {
        Log.i("MicroMsg.ChattingUI.VideoComponent", "video is expired");
        hN(localw.getFileName(), 3);
        Log.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
        localObject2 = new Intent(this.fgR.WQv.getContext(), ImageGalleryUI.class);
        ((Intent)localObject2).putExtra("img_gallery_msg_id", paramca.field_msgId);
        ((Intent)localObject2).putExtra("img_gallery_msg_svr_id", paramca.field_msgSvrId);
        ((Intent)localObject2).putExtra("img_gallery_talker", paramca.field_talker);
        ((Intent)localObject2).putExtra("img_gallery_chatroom_name", paramca.field_talker);
        ((Intent)localObject2).putExtra("img_gallery_enter_video_opcode", y.g(paramca.field_msgId, 1));
        m.a(this.fgR, paramca, (Intent)localObject2);
        localObject1 = this.fgR.WQv;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.fgR.WQv.overridePendingTransition(0, 0);
        if (localw.bqR())
        {
          Log.i("MicroMsg.ChattingUI.VideoComponent", "start complete online video");
          y.Yq(paramca.field_imgPath);
          AppMethodBeat.o(35759);
          return;
        }
        Log.i("MicroMsg.ChattingUI.VideoComponent", "start complete offline video");
        y.Yf(paramca.field_imgPath);
        AppMethodBeat.o(35759);
        return;
      }
      if ((paramca.dlR()) || (paramca.dlT()))
      {
        localObject1 = new Intent(this.fgR.WQv.getContext(), MsgRetransmitUI.class);
        ((Intent)localObject1).putExtra("Retr_length", localw.lvw);
        ((Intent)localObject1).putExtra("Retr_File_Name", paramca.field_imgPath);
        ((Intent)localObject1).putExtra("Retr_video_isexport", localw.mhU);
        ((Intent)localObject1).putExtra("Retr_Msg_Id", paramca.field_msgId);
        ((Intent)localObject1).putExtra("Retr_From", "chattingui");
        Log.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + paramca.getType());
        if (paramca.dlT()) {
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 11);
        }
        for (;;)
        {
          paramca = this.fgR.WQv;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(paramca, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramca.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramca, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(35759);
          return;
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 1);
        }
      }
      Log.w("MicroMsg.ChattingUI.VideoComponent", "retranmist video unknow status.");
      AppMethodBeat.o(35759);
      return;
    }
    Log.e("MicroMsg.ChattingUI.VideoComponent", "retransmit video but videoInfo is null!");
    AppMethodBeat.o(35759);
  }
  
  private void hN(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(35757);
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35749);
        y.aT(paramString, paramInt);
        AppMethodBeat.o(35749);
      }
    });
    AppMethodBeat.o(35757);
  }
  
  public final boolean a(final MenuItem paramMenuItem, final ca paramca)
  {
    AppMethodBeat.i(35758);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35758);
      return false;
    case 106: 
      paramMenuItem = s.bqB().XN(paramca.field_imgPath);
      if (paramMenuItem != null) {
        if (paramMenuItem.status == 199)
        {
          s.bqB();
          paramca = x.XT(paramca.field_imgPath);
          if (paramMenuItem != null)
          {
            i = 0;
            if (ab.Lj(paramMenuItem.bqM())) {
              i = v.Pu(paramMenuItem.bqM());
            }
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, 215L, 1L, false);
            com.tencent.mm.plugin.report.service.h.IzE.a(12084, new Object[] { Integer.valueOf(paramMenuItem.lAW), Integer.valueOf(paramMenuItem.lvw * 1000), Integer.valueOf(0), Integer.valueOf(2), paramMenuItem.bqM(), Integer.valueOf(i), com.tencent.mm.modelvideo.w.XK(paramMenuItem.bqO()), Long.valueOf(paramMenuItem.createTime) });
          }
          p.b(this.fgR.WQv.getContext(), paramca, new p.a()
          {
            public final void bT(String paramAnonymousString1, String paramAnonymousString2)
            {
              AppMethodBeat.i(225677);
              Toast.makeText(bk.this.fgR.WQv.getContext(), bk.this.fgR.WQv.getMMResources().getString(R.l.video_file_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymousString2) }), 1).show();
              com.tencent.mm.pluginsdk.ui.tools.u.refreshMediaScanner(paramAnonymousString2, bk.this.fgR.WQv.getContext());
              AppMethodBeat.o(225677);
            }
            
            public final void bU(String paramAnonymousString1, String paramAnonymousString2)
            {
              AppMethodBeat.i(225678);
              Toast.makeText(bk.this.fgR.WQv.getContext(), bk.this.fgR.WQv.getMMResources().getString(R.l.video_file_save_failed), 1).show();
              AppMethodBeat.o(225678);
            }
          });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(35758);
        return true;
        hN(paramMenuItem.getFileName(), 6);
        Log.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
        paramMenuItem = new Intent(this.fgR.WQv.getContext(), ImageGalleryUI.class);
        paramMenuItem.putExtra("img_gallery_msg_id", paramca.field_msgId);
        paramMenuItem.putExtra("img_gallery_msg_svr_id", paramca.field_msgSvrId);
        paramMenuItem.putExtra("img_gallery_talker", paramca.field_talker);
        paramMenuItem.putExtra("img_gallery_chatroom_name", paramca.field_talker);
        paramMenuItem.putExtra("img_gallery_enter_video_opcode", y.g(paramca.field_msgId, 2));
        m.a(this.fgR, paramca, paramMenuItem);
        paramca = this.fgR.WQv;
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.b(paramca, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickSaveVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramca.startActivity((Intent)paramMenuItem.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramca, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickSaveVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.fgR.WQv.overridePendingTransition(0, 0);
        continue;
        Log.e("MicroMsg.ChattingUI.VideoComponent", "save video but videoInfo is null!");
      }
    case 107: 
      paramMenuItem = bs.T(paramca);
      if ((Util.isNullOrNil(paramMenuItem)) || (paramca.field_isSend == 1)) {
        cD(paramca);
      }
      while (bs.F(paramca))
      {
        paramMenuItem = new ll();
        paramMenuItem.ghT = paramca.field_msgSvrId;
        paramMenuItem.gKR = paramca.getType();
        paramMenuItem.gQQ = bs.E(paramca);
        paramMenuItem.gef = 4L;
        paramMenuItem.bpa();
        break;
        com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), R.l.eRO, R.l.eRP, R.l.app_view_detail, R.l.ewL, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35750);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
            paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
            paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
            com.tencent.mm.by.c.b(bk.this.fgR.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
            com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
            AppMethodBeat.o(35750);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35751);
            bk.a(bk.this, paramca);
            com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
            AppMethodBeat.o(35751);
          }
        });
      }
    }
    Intent localIntent = paramMenuItem.getIntent();
    int j = 0;
    int i = 0;
    paramMenuItem = new int[2];
    if (localIntent == null) {
      Log.e("MicroMsg.ChattingUI.VideoComponent", "[LONGCLICK_MENU_MUTE_PLAY] intent is null!");
    }
    for (;;)
    {
      Log.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] LONGCLICK_MENU_MUTE_PLAY");
      localIntent = new Intent(this.fgR.WQv.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramca.field_msgId);
      localIntent.putExtra("img_gallery_msg_svr_id", paramca.field_msgSvrId);
      localIntent.putExtra("img_gallery_talker", paramca.field_talker);
      localIntent.putExtra("img_gallery_chatroom_name", paramca.field_talker);
      localIntent.putExtra("img_gallery_left", paramMenuItem[0]);
      localIntent.putExtra("img_gallery_top", paramMenuItem[1]);
      localIntent.putExtra("img_gallery_width", j);
      localIntent.putExtra("img_gallery_height", i);
      localIntent.putExtra("img_gallery_enter_video_opcode", y.g(paramca.field_msgId, 3));
      m.a(this.fgR, paramca, localIntent);
      paramMenuItem = this.fgR.WQv;
      paramca = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramMenuItem, paramca.aFh(), "com/tencent/mm/ui/chatting/component/VideoComponent", "dealWithLongClick", "(Landroid/view/MenuItem;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramMenuItem.startActivity((Intent)paramca.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramMenuItem, "com/tencent/mm/ui/chatting/component/VideoComponent", "dealWithLongClick", "(Landroid/view/MenuItem;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.fgR.WQv.overridePendingTransition(0, 0);
      AppMethodBeat.o(35758);
      return true;
      j = localIntent.getIntExtra("img_gallery_width", 0);
      i = localIntent.getIntExtra("img_gallery_height", 0);
      paramMenuItem[0] = localIntent.getIntExtra("img_gallery_left", 0);
      paramMenuItem[1] = localIntent.getIntExtra("img_gallery_top", 0);
    }
  }
  
  public final void aI(final Intent paramIntent)
  {
    AppMethodBeat.i(35763);
    Log.d("MicroMsg.ChattingUI.VideoComponent", "sendVideo");
    if (!ag.dj(this.fgR.WQv.getContext()))
    {
      com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), R.l.video_export_file_warning, R.l.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(273537);
          bk.a(bk.this, paramIntent);
          AppMethodBeat.o(273537);
        }
      }, null);
      AppMethodBeat.o(35763);
      return;
    }
    aJ(paramIntent);
    AppMethodBeat.o(35763);
  }
  
  public final void bF(Intent paramIntent)
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
      if (!ag.dj(this.fgR.WQv.getContext()))
      {
        bE(paramIntent);
        AppMethodBeat.o(35761);
        return;
      }
      bE(paramIntent);
      AppMethodBeat.o(35761);
      return;
    }
    Log.e("MicroMsg.ChattingUI.VideoComponent", "send video list is null or nil");
    AppMethodBeat.o(35761);
  }
  
  public final boolean h(ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(35760);
    boolean bool;
    if (paramca.dlR())
    {
      s.bqB();
      bool = paramBoolean;
      if (!com.tencent.mm.vfs.u.agG(x.XT(paramca.field_imgPath))) {
        bool = false;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35760);
      return bool;
      bool = paramBoolean;
      if (paramca.dlT())
      {
        s.bqB();
        bool = paramBoolean;
        if (!com.tencent.mm.vfs.u.agG(x.XT(paramca.field_imgPath))) {
          bool = false;
        }
      }
    }
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(35767);
    Log.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingResume]");
    k localk = (k)this.fgR.bC(k.class);
    s.bqB().a(localk.hNM(), bh.aHJ().getLooper());
    AppMethodBeat.o(35767);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35768);
    Log.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingPause]");
    k localk = (k)this.fgR.bC(k.class);
    s.bqB().a(localk.hNM());
    AppMethodBeat.o(35768);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35769);
    b.baL();
    this.WPC.clear();
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
      aI(paramIntent);
      AppMethodBeat.o(35766);
      return;
      aI(paramIntent);
      AppMethodBeat.o(35766);
      return;
      bG(paramIntent);
      AppMethodBeat.o(35766);
      return;
      if (paramIntent != null)
      {
        if (paramIntent.getBooleanExtra("from_record", false))
        {
          bG(paramIntent);
          AppMethodBeat.o(35766);
          return;
        }
        aI(paramIntent);
      }
      AppMethodBeat.o(35766);
      return;
      if (paramIntent == null)
      {
        Log.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == data");
        AppMethodBeat.o(35766);
        return;
      }
      paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
      if (paramIntent == null)
      {
        Log.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == captureResult");
        AppMethodBeat.o(35766);
        return;
      }
      if (!paramIntent.EXZ)
      {
        Log.i("MicroMsg.ChattingUI.VideoComponent", "video path %s thumb path %s", new Object[] { paramIntent.EYb, paramIntent.EYc });
        s.bqB();
        String str = x.XT(paramIntent.EYd);
        if (!paramIntent.EYb.equals(str))
        {
          Log.i("MicroMsg.ChattingUI.VideoComponent", "filepath not videopath and move it %s %s", new Object[] { paramIntent.EYb, str });
          com.tencent.mm.vfs.u.oo(paramIntent.EYb, str);
        }
        str = paramIntent.EYd;
        paramInt1 = paramIntent.EYf;
        Object localObject = this.fgR.getTalkerUserName();
        cuv localcuv = paramIntent.EYg;
        com.tencent.mm.modelvideo.w localw = new com.tencent.mm.modelvideo.w();
        localw.fileName = str;
        localw.lvw = paramInt1;
        localw.fPV = ((String)localObject);
        localw.mhK = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, ""));
        localw.createTime = Util.nowSecond();
        localw.mhP = Util.nowSecond();
        localw.mia = localcuv;
        localw.mhU = 0;
        localw.mhX = 1;
        s.bqB();
        paramInt1 = x.XV(x.XT(str));
        boolean bool;
        if (paramInt1 <= 0)
        {
          Log.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
          bool = false;
        }
        while (bool)
        {
          y.Yd(paramIntent.EYd);
          AppMethodBeat.o(35766);
          return;
          localw.lAW = paramInt1;
          s.bqB();
          localObject = x.XU(str);
          paramInt1 = x.XV((String)localObject);
          if (paramInt1 <= 0)
          {
            Log.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + paramInt1);
            bool = false;
          }
          else
          {
            localw.mhO = paramInt1;
            Log.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str + " thumbsize:" + localw.mhO + " videosize:" + localw.lAW);
            localw.status = 102;
            localObject = new ca();
            ((ca)localObject).Jm(localw.bqM());
            ((ca)localObject).setType(43);
            ((ca)localObject).pJ(1);
            ((ca)localObject).Jn(str);
            ((ca)localObject).setStatus(1);
            ((ca)localObject).setCreateTime(bq.RP(localw.bqM()));
            localw.mhR = ((int)bq.z((ca)localObject));
            bool = s.bqB().b(localw);
          }
        }
        Log.e("MicroMsg.ChattingUI.VideoComponent", "prepareMMSightRecord failed");
        AppMethodBeat.o(35766);
        return;
      }
      ((com.tencent.mm.ui.chatting.d.b.ao)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.ao.class)).a(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bk
 * JD-Core Version:    0.7.0.1
 */