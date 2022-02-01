package com.tencent.mm.ui.chatting.component;

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
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.ol;
import com.tencent.mm.cb.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.g;
import com.tencent.mm.modelvideo.g.a;
import com.tencent.mm.network.ah;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.model.q.a;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.av;
import com.tencent.mm.ui.chatting.component.api.be;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=be.class)
public class bs
  extends a
  implements be
{
  private long aeyU;
  private SparseBooleanArray aeyV;
  
  public bs()
  {
    AppMethodBeat.i(35756);
    this.aeyU = -1L;
    this.aeyV = new SparseBooleanArray();
    AppMethodBeat.o(35756);
  }
  
  private void be(Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(35764);
    final g localg = new g();
    Activity localActivity = this.hlc.aezO.getContext();
    String str = this.hlc.getTalkerUserName();
    if ((!paramIntent.getBooleanExtra("CropImage_Compress_Img", true)) && (ab.bOG())) {}
    for (;;)
    {
      localg.a(localActivity, paramIntent, str, bool, new g.a()
      {
        public final void a(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2)
        {
          AppMethodBeat.i(256298);
          if (paramAnonymousInt1 == -50002) {
            Toast.makeText(bs.this.hlc.aezO.getContext(), bs.this.hlc.aezO.getContext().getString(R.l.video_export_file_too_big), 0).show();
          }
          for (;;)
          {
            bs.this.hlc.aDM();
            AppMethodBeat.o(256298);
            return;
            if (paramAnonymousInt1 < 0)
            {
              Toast.makeText(bs.this.hlc.aezO.getContext(), bs.this.hlc.aezO.getContext().getString(R.l.video_export_file_error), 0).show();
            }
            else
            {
              if (!Util.isNullOrNil(paramAnonymousString2)) {
                ab.a(paramAnonymousString2, null, paramAnonymousInt2, bs.this.hlc.getTalkerUserName(), paramAnonymousString3, 0, "", 43, null, "", 0, null, null, true);
              }
              ab.a(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt2, bs.this.hlc.getTalkerUserName(), paramAnonymousString3, 0, "", 43, null, "", 0, null, null);
              ab.Qh(paramAnonymousString1);
            }
          }
        }
      });
      this.hlc.b(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.app_tip), this.hlc.aezO.getMMResources().getString(R.l.app_waiting), new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          localg.oYi = null;
        }
      });
      AppMethodBeat.o(35764);
      return;
      bool = false;
    }
  }
  
  private void cj(Intent paramIntent)
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
    if ((((String)localObject).equals("medianote")) && ((com.tencent.mm.model.z.bAQ() & 0x4000) == 0))
    {
      paramIntent = new com.tencent.mm.modelvideo.z();
      paramIntent.fileName = str;
      paramIntent.omT = i;
      paramIntent.hVQ = ((String)localObject);
      paramIntent.paV = ((String)com.tencent.mm.kernel.h.baE().ban().d(2, ""));
      paramIntent.createTime = Util.nowSecond();
      paramIntent.pba = Util.nowSecond();
      paramIntent.paX = i;
      paramIntent.oZm = i;
      com.tencent.mm.modelvideo.v.bOh();
      i = com.tencent.mm.modelvideo.aa.PZ(com.tencent.mm.modelvideo.aa.PX(str));
      if (i <= 0)
      {
        Log.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
        AppMethodBeat.o(35765);
        return;
      }
      paramIntent.osy = i;
      com.tencent.mm.modelvideo.v.bOh();
      localObject = com.tencent.mm.modelvideo.aa.PY(str);
      i = com.tencent.mm.modelvideo.aa.PZ((String)localObject);
      if (i <= 0)
      {
        Log.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + i);
        AppMethodBeat.o(35765);
        return;
      }
      paramIntent.paZ = i;
      Log.d("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + paramIntent.paZ + " videosize:" + paramIntent.osy);
      paramIntent.status = 199;
      localObject = new cc();
      ((cc)localObject).BS(paramIntent.bOs());
      ((cc)localObject).setType(43);
      ((cc)localObject).pI(1);
      ((cc)localObject).BT(str);
      ((cc)localObject).setStatus(2);
      ((cc)localObject).setCreateTime(br.JN(paramIntent.bOs()));
      paramIntent.pbc = ((int)br.B((cc)localObject));
      com.tencent.mm.modelvideo.v.bOh().b(paramIntent);
      AppMethodBeat.o(35765);
      return;
    }
    ab.a(str, i, (String)localObject, 0, "", 43, 0, null);
    ab.Qh(str);
    this.hlc.jpK();
    AppMethodBeat.o(35765);
  }
  
  private void da(cc paramcc)
  {
    AppMethodBeat.i(35759);
    bh.bCz();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.aa.j(this.hlc.aezO.getContext(), this.hlc.aezO.getContentView());
      AppMethodBeat.o(35759);
      return;
    }
    Object localObject1;
    if (paramcc.dSI())
    {
      localObject1 = new Intent(this.hlc.aezO.getContext(), MsgRetransmitUI.class);
      ((Intent)localObject1).putExtra("Retr_Msg_Id", paramcc.field_msgId);
      ((Intent)localObject1).putExtra("Retr_Msg_content", paramcc.field_content);
      ((Intent)localObject1).putExtra("Retr_From", "chattingui");
      Log.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + paramcc.getType());
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 1);
      paramcc = this.hlc.aezO;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(paramcc, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramcc.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramcc, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35759);
      return;
    }
    com.tencent.mm.modelvideo.z localz = ab.Qo(paramcc.field_imgPath);
    if (localz != null)
    {
      Object localObject2 = localz.bOt();
      localObject1 = localObject2;
      if (!y.ZC((String)localObject2))
      {
        com.tencent.mm.modelvideo.v.bOh();
        localObject1 = com.tencent.mm.modelvideo.aa.PX(paramcc.field_imgPath);
      }
      if (paramcc.isClean())
      {
        Log.i("MicroMsg.ChattingUI.VideoComponent", "video is clean!!!");
        k.d(this.hlc.aezO.getContext(), this.hlc.aezO.getContext().getString(R.l.gXD), this.hlc.aezO.getContext().getString(R.l.app_tip), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(35759);
        return;
      }
      if (n.j(paramcc, (String)localObject1))
      {
        Log.i("MicroMsg.ChattingUI.VideoComponent", "video is expired");
        iU(localz.getFileName(), 3);
        Log.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
        localObject2 = new Intent(this.hlc.aezO.getContext(), ImageGalleryUI.class);
        ((Intent)localObject2).putExtra("img_gallery_msg_id", paramcc.field_msgId);
        ((Intent)localObject2).putExtra("img_gallery_msg_svr_id", paramcc.field_msgSvrId);
        ((Intent)localObject2).putExtra("img_gallery_talker", paramcc.field_talker);
        ((Intent)localObject2).putExtra("img_gallery_chatroom_name", paramcc.field_talker);
        ((Intent)localObject2).putExtra("img_gallery_enter_video_opcode", ab.o(paramcc.field_msgId, 1));
        n.a(this.hlc, paramcc, (Intent)localObject2);
        localObject1 = this.hlc.aezO;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.hlc.aezO.overridePendingTransition(0, 0);
        if (localz.bOw())
        {
          Log.i("MicroMsg.ChattingUI.VideoComponent", "start complete online video");
          ab.Qu(paramcc.field_imgPath);
          AppMethodBeat.o(35759);
          return;
        }
        Log.i("MicroMsg.ChattingUI.VideoComponent", "start complete offline video");
        ab.Qj(paramcc.field_imgPath);
        AppMethodBeat.o(35759);
        return;
      }
      if ((paramcc.dSH()) || (paramcc.dSJ()))
      {
        localObject1 = new Intent(this.hlc.aezO.getContext(), MsgRetransmitUI.class);
        ((Intent)localObject1).putExtra("Retr_length", localz.omT);
        ((Intent)localObject1).putExtra("Retr_File_Name", paramcc.field_imgPath);
        ((Intent)localObject1).putExtra("Retr_video_isexport", localz.pbf);
        ((Intent)localObject1).putExtra("Retr_Msg_Id", paramcc.field_msgId);
        ((Intent)localObject1).putExtra("Retr_From", "chattingui");
        Log.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + paramcc.getType());
        if (paramcc.dSJ()) {
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 11);
        }
        for (;;)
        {
          paramcc = this.hlc.aezO;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(paramcc, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramcc.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramcc, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
  
  private void iU(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(35757);
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35749);
        ab.bh(paramString, paramInt);
        AppMethodBeat.o(35749);
      }
    });
    AppMethodBeat.o(35757);
  }
  
  private void n(final ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(256351);
    Log.v("MicroMsg.ChattingUI.VideoComponent", "send video path: %s", new Object[] { paramArrayList.toString() });
    paramArrayList = new q(this.hlc.aezO.getContext(), paramArrayList, null, this.hlc.getTalkerUserName(), 2, new q.a()
    {
      public final void iHX()
      {
        AppMethodBeat.i(255763);
        bs.this.hlc.aDM();
        AppMethodBeat.o(255763);
      }
    }, paramBoolean);
    this.hlc.b(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.app_tip), this.hlc.aezO.getMMResources().getString(R.l.app_waiting), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(255867);
        paramArrayList.iHR();
        AppMethodBeat.o(255867);
      }
    });
    ThreadPool.post(paramArrayList, "ChattingUI_importMultiVideo");
    AppMethodBeat.o(256351);
  }
  
  public final boolean a(MenuItem paramMenuItem, cc paramcc)
  {
    AppMethodBeat.i(35758);
    Object localObject;
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(35758);
      return false;
    case 106: 
      localObject = com.tencent.mm.modelvideo.v.bOh().PR(paramcc.field_imgPath);
      if (localObject != null) {
        if (((com.tencent.mm.modelvideo.z)localObject).status == 199)
        {
          com.tencent.mm.modelvideo.v.bOh();
          paramMenuItem = com.tencent.mm.modelvideo.aa.PX(paramcc.field_imgPath);
          if (localObject != null)
          {
            i = 0;
            if (au.bwE(((com.tencent.mm.modelvideo.z)localObject).bOs())) {
              i = com.tencent.mm.model.v.getMembersCountByChatRoomName(((com.tencent.mm.modelvideo.z)localObject).bOs());
            }
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 215L, 1L, false);
            com.tencent.mm.plugin.report.service.h.OAn.b(12084, new Object[] { Integer.valueOf(((com.tencent.mm.modelvideo.z)localObject).osy), Integer.valueOf(((com.tencent.mm.modelvideo.z)localObject).omT * 1000), Integer.valueOf(0), Integer.valueOf(2), ((com.tencent.mm.modelvideo.z)localObject).bOs(), Integer.valueOf(i), com.tencent.mm.modelvideo.z.PM(((com.tencent.mm.modelvideo.z)localObject).bOu()), Long.valueOf(((com.tencent.mm.modelvideo.z)localObject).createTime) });
          }
          paramcc = ((com.tencent.mm.modelvideo.z)localObject).oYk;
          localObject = ab.Qo(paramcc);
          if ((localObject == null) || (((com.tencent.mm.modelvideo.z)localObject).status != 199)) {
            break label1003;
          }
          com.tencent.mm.modelvideo.v.bOh();
          paramMenuItem = com.tencent.mm.modelvideo.aa.PX(paramcc);
        }
      }
      break;
    }
    label1003:
    for (;;)
    {
      ExportFileUtil.b(this.hlc.aezO.getContext(), paramMenuItem, new bs.5(this));
      for (;;)
      {
        AppMethodBeat.o(35758);
        return true;
        iU(((com.tencent.mm.modelvideo.z)localObject).getFileName(), 6);
        Log.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
        paramMenuItem = new Intent(this.hlc.aezO.getContext(), ImageGalleryUI.class);
        paramMenuItem.putExtra("img_gallery_msg_id", paramcc.field_msgId);
        paramMenuItem.putExtra("img_gallery_msg_svr_id", paramcc.field_msgSvrId);
        paramMenuItem.putExtra("img_gallery_talker", paramcc.field_talker);
        paramMenuItem.putExtra("img_gallery_chatroom_name", paramcc.field_talker);
        paramMenuItem.putExtra("img_gallery_enter_video_opcode", ab.o(paramcc.field_msgId, 2));
        n.a(this.hlc, paramcc, paramMenuItem);
        paramcc = this.hlc.aezO;
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.b(paramcc, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickSaveVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramcc.startActivity((Intent)paramMenuItem.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramcc, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickSaveVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.hlc.aezO.overridePendingTransition(0, 0);
        continue;
        Log.e("MicroMsg.ChattingUI.VideoComponent", "save video but videoInfo is null!");
      }
      paramMenuItem = bt.X(paramcc);
      if ((Util.isNullOrNil(paramMenuItem)) || (paramcc.field_isSend == 1)) {
        da(paramcc);
      }
      while (bt.H(paramcc))
      {
        paramMenuItem = new ol();
        paramMenuItem.inO = paramcc.field_msgSvrId;
        paramMenuItem.iUM = paramcc.getType();
        paramMenuItem.jjm = bt.G(paramcc);
        paramMenuItem.ikE = 4L;
        paramMenuItem.bMH();
        break;
        com.tencent.mm.plugin.report.service.h.OAn.b(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        k.a(this.hlc.aezO.getContext(), R.l.gUu, R.l.gUv, R.l.app_view_detail, R.l.gzo, true, new bs.3(this, paramMenuItem), new bs.4(this, paramcc, paramMenuItem));
      }
      localObject = paramMenuItem.getIntent();
      int j = 0;
      i = 0;
      paramMenuItem = new int[2];
      if (localObject == null) {
        Log.e("MicroMsg.ChattingUI.VideoComponent", "[LONGCLICK_MENU_MUTE_PLAY] intent is null!");
      }
      for (;;)
      {
        Log.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] LONGCLICK_MENU_MUTE_PLAY");
        localObject = new Intent(this.hlc.aezO.getContext(), ImageGalleryUI.class);
        ((Intent)localObject).putExtra("img_gallery_msg_id", paramcc.field_msgId);
        ((Intent)localObject).putExtra("img_gallery_msg_svr_id", paramcc.field_msgSvrId);
        ((Intent)localObject).putExtra("img_gallery_talker", paramcc.field_talker);
        ((Intent)localObject).putExtra("img_gallery_chatroom_name", paramcc.field_talker);
        ((Intent)localObject).putExtra("img_gallery_left", paramMenuItem[0]);
        ((Intent)localObject).putExtra("img_gallery_top", paramMenuItem[1]);
        ((Intent)localObject).putExtra("img_gallery_width", j);
        ((Intent)localObject).putExtra("img_gallery_height", i);
        ((Intent)localObject).putExtra("img_gallery_enter_video_opcode", ab.o(paramcc.field_msgId, 3));
        n.a(this.hlc, paramcc, (Intent)localObject);
        paramMenuItem = this.hlc.aezO;
        paramcc = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramMenuItem, paramcc.aYi(), "com/tencent/mm/ui/chatting/component/VideoComponent", "dealWithLongClick", "(Landroid/view/MenuItem;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramMenuItem.startActivity((Intent)paramcc.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramMenuItem, "com/tencent/mm/ui/chatting/component/VideoComponent", "dealWithLongClick", "(Landroid/view/MenuItem;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.hlc.aezO.overridePendingTransition(0, 0);
        AppMethodBeat.o(35758);
        return true;
        j = ((Intent)localObject).getIntExtra("img_gallery_width", 0);
        i = ((Intent)localObject).getIntExtra("img_gallery_height", 0);
        paramMenuItem[0] = ((Intent)localObject).getIntExtra("img_gallery_left", 0);
        paramMenuItem[1] = ((Intent)localObject).getIntExtra("img_gallery_top", 0);
      }
    }
  }
  
  public final void bd(final Intent paramIntent)
  {
    AppMethodBeat.i(35763);
    Log.d("MicroMsg.ChattingUI.VideoComponent", "sendVideo");
    if (!ah.eb(this.hlc.aezO.getContext()))
    {
      k.a(this.hlc.aezO.getContext(), R.l.video_export_file_warning, R.l.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(255866);
          bs.a(bs.this, paramIntent);
          AppMethodBeat.o(255866);
        }
      }, null);
      AppMethodBeat.o(35763);
      return;
    }
    be(paramIntent);
    AppMethodBeat.o(35763);
  }
  
  public final void ci(Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(35761);
    if (paramIntent == null)
    {
      AppMethodBeat.o(35761);
      return;
    }
    if ((!paramIntent.getBooleanExtra("CropImage_Compress_Img", true)) && (ab.bOG())) {}
    for (;;)
    {
      paramIntent = paramIntent.getStringArrayListExtra("key_select_video_list");
      if ((paramIntent == null) || (paramIntent.size() <= 0)) {
        break label101;
      }
      if (ah.eb(this.hlc.aezO.getContext())) {
        break;
      }
      n(paramIntent, bool);
      AppMethodBeat.o(35761);
      return;
      bool = false;
    }
    n(paramIntent, bool);
    AppMethodBeat.o(35761);
    return;
    label101:
    Log.e("MicroMsg.ChattingUI.VideoComponent", "send video list is null or nil");
    AppMethodBeat.o(35761);
  }
  
  public final boolean i(cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(35760);
    boolean bool;
    if (paramcc.dSH())
    {
      com.tencent.mm.modelvideo.v.bOh();
      bool = paramBoolean;
      if (!y.ZC(com.tencent.mm.modelvideo.aa.PX(paramcc.field_imgPath))) {
        bool = false;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35760);
      return bool;
      bool = paramBoolean;
      if (paramcc.dSJ())
      {
        com.tencent.mm.modelvideo.v.bOh();
        bool = paramBoolean;
        if (!y.ZC(com.tencent.mm.modelvideo.aa.PX(paramcc.field_imgPath))) {
          bool = false;
        }
      }
    }
  }
  
  public final void jji()
  {
    AppMethodBeat.i(35767);
    Log.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingResume]");
    m localm = (m)this.hlc.cm(m.class);
    com.tencent.mm.modelvideo.v.bOh().a(localm.jqt(), bh.baH().getLooper());
    AppMethodBeat.o(35767);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35768);
    Log.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingPause]");
    m localm = (m)this.hlc.cm(m.class);
    com.tencent.mm.modelvideo.v.bOh().a(localm.jqt());
    AppMethodBeat.o(35768);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35769);
    SightPlayController.bvG();
    this.aeyV.clear();
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
      bd(paramIntent);
      AppMethodBeat.o(35766);
      return;
      bd(paramIntent);
      AppMethodBeat.o(35766);
      return;
      cj(paramIntent);
      AppMethodBeat.o(35766);
      return;
      if (paramIntent != null)
      {
        if (paramIntent.getBooleanExtra("from_record", false))
        {
          cj(paramIntent);
          AppMethodBeat.o(35766);
          return;
        }
        bd(paramIntent);
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
      if (!paramIntent.KTL)
      {
        Log.i("MicroMsg.ChattingUI.VideoComponent", "video path %s thumb path %s", new Object[] { paramIntent.KTN, paramIntent.KTO });
        com.tencent.mm.modelvideo.v.bOh();
        Object localObject1 = com.tencent.mm.modelvideo.aa.PX(paramIntent.KTP);
        if (!paramIntent.KTN.equals(localObject1))
        {
          Log.i("MicroMsg.ChattingUI.VideoComponent", "filepath not videopath and move it %s %s", new Object[] { paramIntent.KTN, localObject1 });
          y.qn(paramIntent.KTN, (String)localObject1);
        }
        localObject1 = paramIntent.KTP;
        paramInt1 = paramIntent.KTR;
        Object localObject2 = this.hlc.getTalkerUserName();
        dmb localdmb = paramIntent.KTS;
        com.tencent.mm.modelvideo.z localz = new com.tencent.mm.modelvideo.z();
        localz.fileName = ((String)localObject1);
        localz.omT = paramInt1;
        localz.hVQ = ((String)localObject2);
        localz.paV = ((String)com.tencent.mm.kernel.h.baE().ban().d(2, ""));
        localz.createTime = Util.nowSecond();
        localz.pba = Util.nowSecond();
        localz.pbl = localdmb;
        localz.pbf = 0;
        localz.pbi = 1;
        com.tencent.mm.modelvideo.v.bOh();
        paramInt1 = com.tencent.mm.modelvideo.aa.PZ(com.tencent.mm.modelvideo.aa.PX((String)localObject1));
        boolean bool;
        if (paramInt1 <= 0)
        {
          Log.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(localObject1)));
          bool = false;
        }
        while (bool)
        {
          long l = y.bEl(paramIntent.KTN);
          localObject1 = d.acls;
          d.a(this.hlc.getTalkerUserName(), paramIntent.KTP, paramIntent.KTR, l, l, 1L, false);
          ab.Qh(paramIntent.KTP);
          AppMethodBeat.o(35766);
          return;
          localz.osy = paramInt1;
          com.tencent.mm.modelvideo.v.bOh();
          localObject2 = com.tencent.mm.modelvideo.aa.PY((String)localObject1);
          paramInt1 = com.tencent.mm.modelvideo.aa.PZ((String)localObject2);
          if (paramInt1 <= 0)
          {
            Log.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject2 + " size:" + paramInt1);
            bool = false;
          }
          else
          {
            localz.paZ = paramInt1;
            Log.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + (String)localObject1 + " thumbsize:" + localz.paZ + " videosize:" + localz.osy);
            localz.status = 102;
            localObject2 = new cc();
            ((cc)localObject2).BS(localz.bOs());
            ((cc)localObject2).setType(43);
            ((cc)localObject2).pI(1);
            ((cc)localObject2).BT((String)localObject1);
            ((cc)localObject2).setStatus(1);
            ((cc)localObject2).setCreateTime(br.JN(localz.bOs()));
            localz.pbc = ((int)br.B((cc)localObject2));
            bool = com.tencent.mm.modelvideo.v.bOh().b(localz);
          }
        }
        Log.e("MicroMsg.ChattingUI.VideoComponent", "prepareMMSightRecord failed");
        AppMethodBeat.o(35766);
        return;
      }
      ((av)this.hlc.cm(av.class)).c(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bs
 * JD-Core Version:    0.7.0.1
 */