package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.ah;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.x;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.b.a.a(cFA=ah.class)
public class ap
  extends a
  implements ah
{
  private long vtk = -1L;
  private SparseBooleanArray vtl = new SparseBooleanArray();
  
  private void P(Intent paramIntent)
  {
    final com.tencent.mm.modelvideo.c localc = new com.tencent.mm.modelvideo.c();
    localc.a(this.byx.vtz.getContext(), paramIntent, new ap.7(this));
    paramIntent = this.byx;
    Activity localActivity = this.byx.vtz.getContext();
    this.byx.vtz.getMMResources().getString(R.l.app_tip);
    paramIntent.d(localActivity, this.byx.vtz.getMMResources().getString(R.l.app_waiting), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        localc.eFi = null;
      }
    });
  }
  
  private void ai(final ArrayList<String> paramArrayList)
  {
    y.v("MicroMsg.ChattingUI.VideoComponent", "send video path: %s", new Object[] { paramArrayList.toString() });
    paramArrayList = new j(this.byx.vtz.getContext(), paramArrayList, null, this.byx.getTalkerUserName(), 2, new ap.4(this));
    com.tencent.mm.ui.chatting.c.a locala = this.byx;
    Activity localActivity = this.byx.vtz.getContext();
    this.byx.vtz.getMMResources().getString(R.l.app_tip);
    locala.d(localActivity, this.byx.vtz.getMMResources().getString(R.l.app_waiting), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        paramArrayList.ckw();
      }
    });
    com.tencent.mm.sdk.f.e.post(paramArrayList, "ChattingUI_importMultiVideo");
  }
  
  private void at(Intent paramIntent)
  {
    y.d("MicroMsg.ChattingUI.VideoComponent", "sendVideoFromCustomRecord");
    if (paramIntent == null) {
      y.e("MicroMsg.ChattingUI.VideoComponent", "data == null");
    }
    Object localObject;
    String str;
    int i;
    do
    {
      return;
      localObject = paramIntent.getStringExtra("VideoRecorder_ToUser");
      str = paramIntent.getStringExtra("VideoRecorder_FileName");
      i = paramIntent.getIntExtra("VideoRecorder_VideoLength", 0);
      y.e("MicroMsg.ChattingUI.VideoComponent", "fileName " + str + " length " + i + " user " + (String)localObject);
    } while ((bk.bl((String)localObject)) || (bk.bl(str)) || (i < 0));
    if ((((String)localObject).equals("medianote")) && ((q.Gn() & 0x4000) == 0))
    {
      paramIntent = new com.tencent.mm.modelvideo.s();
      paramIntent.fileName = str;
      paramIntent.eHH = i;
      paramIntent.bVI = ((String)localObject);
      paramIntent.eHA = ((String)com.tencent.mm.kernel.g.DP().Dz().get(2, ""));
      paramIntent.createTime = bk.UX();
      paramIntent.eHF = bk.UX();
      paramIntent.eHC = i;
      paramIntent.eGk = i;
      o.Sr();
      i = t.nU(t.nS(str));
      if (i <= 0)
      {
        y.e("MicroMsg.VideoLogic", "get Video size failed :" + str);
        return;
      }
      paramIntent.ebK = i;
      o.Sr();
      localObject = t.nT(str);
      i = t.nU((String)localObject);
      if (i <= 0)
      {
        y.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + i);
        return;
      }
      paramIntent.eHE = i;
      y.d("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + paramIntent.eHE + " videosize:" + paramIntent.ebK);
      paramIntent.status = 199;
      localObject = new bi();
      ((bi)localObject).ec(paramIntent.SA());
      ((bi)localObject).setType(43);
      ((bi)localObject).fA(1);
      ((bi)localObject).ed(str);
      ((bi)localObject).setStatus(2);
      ((bi)localObject).bg(bd.iK(paramIntent.SA()));
      paramIntent.eHI = ((int)bd.h((bi)localObject));
      o.Sr().b(paramIntent);
      return;
    }
    u.c(str, i, (String)localObject, null);
    u.nZ(str);
    this.byx.cCW();
  }
  
  private void dH(String paramString, int paramInt)
  {
    au.DS().O(new ap.1(this, paramString, paramInt));
  }
  
  public final void O(Intent paramIntent)
  {
    y.d("MicroMsg.ChattingUI.VideoComponent", "sendVideo");
    if (!ab.bG(this.byx.vtz.getContext()))
    {
      com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), R.l.video_export_file_warning, R.l.app_tip, new ap.6(this, paramIntent), null);
      return;
    }
    P(paramIntent);
  }
  
  public final boolean a(MenuItem paramMenuItem, bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 106: 
    case 107: 
      for (;;)
      {
        return false;
        paramMenuItem = o.Sr().nQ(parambi.field_imgPath);
        if (paramMenuItem != null) {
          if (paramMenuItem.status == 199)
          {
            o.Sr();
            parambi = t.nS(parambi.field_imgPath);
            if (paramMenuItem != null)
            {
              i = 0;
              if (com.tencent.mm.model.s.fn(paramMenuItem.SA())) {
                i = m.gM(paramMenuItem.SA());
              }
              com.tencent.mm.plugin.report.service.h.nFQ.a(106L, 215L, 1L, false);
              com.tencent.mm.plugin.report.service.h.nFQ.f(12084, new Object[] { Integer.valueOf(paramMenuItem.ebK), Integer.valueOf(paramMenuItem.eHH * 1000), Integer.valueOf(0), Integer.valueOf(2), paramMenuItem.SA(), Integer.valueOf(i), com.tencent.mm.modelvideo.s.nP(paramMenuItem.SD()), Long.valueOf(paramMenuItem.createTime) });
            }
            paramMenuItem = u.of(parambi);
            if (bk.bl(paramMenuItem)) {
              Toast.makeText(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.video_file_save_failed), 1).show();
            }
          }
        }
        for (;;)
        {
          return true;
          Toast.makeText(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.video_file_saved, new Object[] { paramMenuItem }), 1).show();
          l.a(paramMenuItem, this.byx.vtz.getContext());
          continue;
          dH(paramMenuItem.getFileName(), 6);
          paramMenuItem = new Intent(this.byx.vtz.getContext(), ImageGalleryUI.class);
          paramMenuItem.putExtra("img_gallery_msg_id", parambi.field_msgId);
          paramMenuItem.putExtra("img_gallery_msg_svr_id", parambi.field_msgSvrId);
          paramMenuItem.putExtra("img_gallery_talker", parambi.field_talker);
          paramMenuItem.putExtra("img_gallery_chatroom_name", parambi.field_talker);
          paramMenuItem.putExtra("img_gallery_enter_video_opcode", u.d(parambi.field_msgId, 2));
          i.a(this.byx, parambi, paramMenuItem);
          this.byx.vtz.startActivity(paramMenuItem);
          this.byx.vtz.overridePendingTransition(0, 0);
          continue;
          y.e("MicroMsg.ChattingUI.VideoComponent", "save video but videoInfo is null!");
        }
        au.Hx();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.s.gM(this.byx.vtz.getContext());
        }
        else
        {
          com.tencent.mm.modelvideo.s locals = u.oe(parambi.field_imgPath);
          if (locals != null)
          {
            localObject = locals.SC();
            paramMenuItem = (MenuItem)localObject;
            if (!com.tencent.mm.vfs.e.bK((String)localObject))
            {
              o.Sr();
              paramMenuItem = t.nS(parambi.field_imgPath);
            }
            if (parambi.cvx())
            {
              y.i("MicroMsg.ChattingUI.VideoComponent", "video is clean!!!");
              com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getContext().getString(R.l.video_clean), this.byx.vtz.getContext().getString(R.l.app_tip), new ap.2(this));
            }
            else if (i.e(parambi, paramMenuItem))
            {
              y.i("MicroMsg.ChattingUI.VideoComponent", "video is expired");
              dH(locals.getFileName(), 3);
              paramMenuItem = new Intent(this.byx.vtz.getContext(), ImageGalleryUI.class);
              paramMenuItem.putExtra("img_gallery_msg_id", parambi.field_msgId);
              paramMenuItem.putExtra("img_gallery_msg_svr_id", parambi.field_msgSvrId);
              paramMenuItem.putExtra("img_gallery_talker", parambi.field_talker);
              paramMenuItem.putExtra("img_gallery_chatroom_name", parambi.field_talker);
              paramMenuItem.putExtra("img_gallery_enter_video_opcode", u.d(parambi.field_msgId, 1));
              i.a(this.byx, parambi, paramMenuItem);
              this.byx.vtz.startActivity(paramMenuItem);
              this.byx.vtz.overridePendingTransition(0, 0);
              if (locals.SF())
              {
                y.i("MicroMsg.ChattingUI.VideoComponent", "start complete online video");
                u.oj(parambi.field_imgPath);
              }
              else
              {
                y.i("MicroMsg.ChattingUI.VideoComponent", "start complete offline video");
                u.oa(parambi.field_imgPath);
              }
            }
            else
            {
              if ((parambi.aRQ()) || (parambi.aRR()))
              {
                paramMenuItem = new Intent(this.byx.vtz.getContext(), MsgRetransmitUI.class);
                paramMenuItem.putExtra("Retr_length", locals.eHH);
                paramMenuItem.putExtra("Retr_File_Name", parambi.field_imgPath);
                paramMenuItem.putExtra("Retr_video_isexport", locals.eHL);
                paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
                paramMenuItem.putExtra("Retr_From", "chattingui");
                y.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + parambi.getType());
                if (parambi.aRR()) {
                  paramMenuItem.putExtra("Retr_Msg_Type", 11);
                }
                for (;;)
                {
                  this.byx.vtz.startActivity(paramMenuItem);
                  break;
                  paramMenuItem.putExtra("Retr_Msg_Type", 1);
                }
              }
              y.w("MicroMsg.ChattingUI.VideoComponent", "retranmist video unknow status.");
            }
          }
          else
          {
            y.e("MicroMsg.ChattingUI.VideoComponent", "retransmit video but videoInfo is null!");
          }
        }
      }
    }
    Object localObject = paramMenuItem.getIntent();
    int j = 0;
    int i = 0;
    paramMenuItem = new int[2];
    if (localObject == null) {
      y.e("MicroMsg.ChattingUI.VideoComponent", "[LONGCLICK_MENU_MUTE_PLAY] intent is null!");
    }
    for (;;)
    {
      localObject = new Intent(this.byx.vtz.getContext(), ImageGalleryUI.class);
      ((Intent)localObject).putExtra("img_gallery_msg_id", parambi.field_msgId);
      ((Intent)localObject).putExtra("img_gallery_msg_svr_id", parambi.field_msgSvrId);
      ((Intent)localObject).putExtra("img_gallery_talker", parambi.field_talker);
      ((Intent)localObject).putExtra("img_gallery_chatroom_name", parambi.field_talker);
      ((Intent)localObject).putExtra("img_gallery_left", paramMenuItem[0]);
      ((Intent)localObject).putExtra("img_gallery_top", paramMenuItem[1]);
      ((Intent)localObject).putExtra("img_gallery_width", j);
      ((Intent)localObject).putExtra("img_gallery_height", i);
      ((Intent)localObject).putExtra("img_gallery_enter_video_opcode", u.d(parambi.field_msgId, 3));
      i.a(this.byx, parambi, (Intent)localObject);
      this.byx.vtz.startActivity((Intent)localObject);
      this.byx.vtz.overridePendingTransition(0, 0);
      return true;
      j = ((Intent)localObject).getIntExtra("img_gallery_width", 0);
      i = ((Intent)localObject).getIntExtra("img_gallery_height", 0);
      paramMenuItem[0] = ((Intent)localObject).getIntExtra("img_gallery_left", 0);
      paramMenuItem[1] = ((Intent)localObject).getIntExtra("img_gallery_top", 0);
    }
  }
  
  public final void as(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent = paramIntent.getStringArrayListExtra("key_select_video_list");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      if (!ab.bG(this.byx.vtz.getContext()))
      {
        com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), R.l.video_export_file_warning, R.l.app_tip, new ap.3(this, paramIntent), null);
        return;
      }
      ai(paramIntent);
      return;
    }
    y.e("MicroMsg.ChattingUI.VideoComponent", "send video list is null or nil");
  }
  
  public final void cyP()
  {
    y.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingResume]");
    com.tencent.mm.ui.chatting.b.b.g localg = (com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class);
    o.Sr().a(localg.cDs(), au.DS().mnU.getLooper());
  }
  
  public final void cyQ()
  {
    y.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingPause]");
    com.tencent.mm.ui.chatting.b.b.g localg = (com.tencent.mm.ui.chatting.b.b.g)this.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class);
    o.Sr().a(localg.cDs());
  }
  
  public final void cyR()
  {
    b.ET();
    this.vtl.clear();
  }
  
  public final boolean g(bi parambi, boolean paramBoolean)
  {
    boolean bool;
    if (parambi.aRQ())
    {
      o.Sr();
      bool = paramBoolean;
      if (!com.tencent.mm.vfs.e.bK(t.nS(parambi.field_imgPath))) {
        bool = false;
      }
    }
    do
    {
      do
      {
        return bool;
        bool = paramBoolean;
      } while (!parambi.aRR());
      o.Sr();
      bool = paramBoolean;
    } while (com.tencent.mm.vfs.e.bK(t.nS(parambi.field_imgPath)));
    return false;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
    case 208: 
    case 215: 
    case 216: 
    case 218: 
      do
      {
        return;
        O(paramIntent);
        return;
        O(paramIntent);
        return;
        at(paramIntent);
        return;
      } while (paramIntent == null);
      if (paramIntent.getBooleanExtra("from_record", false))
      {
        at(paramIntent);
        return;
      }
      O(paramIntent);
      return;
    }
    if (paramIntent == null)
    {
      y.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == data");
      return;
    }
    paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
    if (paramIntent == null)
    {
      y.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == captureResult");
      return;
    }
    if (!paramIntent.mfh)
    {
      y.i("MicroMsg.ChattingUI.VideoComponent", "video path %s thumb path ", new Object[] { paramIntent.mfj, paramIntent.mfk });
      o.Sr();
      String str = t.nS(paramIntent.mfl);
      if (!paramIntent.mfj.equals(str))
      {
        y.i("MicroMsg.ChattingUI.VideoComponent", "filepath not videopath and move it %s %s", new Object[] { paramIntent.mfj, str });
        com.tencent.mm.vfs.e.aA(paramIntent.mfj, str);
      }
      str = paramIntent.mfl;
      paramInt1 = paramIntent.mfn;
      Object localObject = this.byx.getTalkerUserName();
      avn localavn = paramIntent.mfo;
      com.tencent.mm.modelvideo.s locals = new com.tencent.mm.modelvideo.s();
      locals.fileName = str;
      locals.eHH = paramInt1;
      locals.bVI = ((String)localObject);
      locals.eHA = ((String)com.tencent.mm.kernel.g.DP().Dz().get(2, ""));
      locals.createTime = bk.UX();
      locals.eHF = bk.UX();
      locals.eHR = localavn;
      locals.eHL = 0;
      locals.eHO = 1;
      o.Sr();
      paramInt1 = t.nU(t.nS(str));
      boolean bool;
      if (paramInt1 <= 0)
      {
        y.e("MicroMsg.VideoLogic", "get Video size failed :" + str);
        bool = false;
      }
      while (bool)
      {
        u.nZ(paramIntent.mfl);
        return;
        locals.ebK = paramInt1;
        o.Sr();
        localObject = t.nT(str);
        paramInt1 = t.nU((String)localObject);
        if (paramInt1 <= 0)
        {
          y.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + paramInt1);
          bool = false;
        }
        else
        {
          locals.eHE = paramInt1;
          y.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str + " thumbsize:" + locals.eHE + " videosize:" + locals.ebK);
          locals.status = 102;
          localObject = new bi();
          ((bi)localObject).ec(locals.SA());
          ((bi)localObject).setType(43);
          ((bi)localObject).fA(1);
          ((bi)localObject).ed(str);
          ((bi)localObject).setStatus(1);
          ((bi)localObject).bg(bd.iK(locals.SA()));
          locals.eHI = ((int)bd.h((bi)localObject));
          bool = o.Sr().b(locals);
        }
      }
      y.e("MicroMsg.ChattingUI.VideoComponent", "prepareMMSightRecord failed");
      return;
    }
    ((com.tencent.mm.ui.chatting.b.b.z)this.byx.ac(com.tencent.mm.ui.chatting.b.b.z.class)).a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ap
 * JD-Core Version:    0.7.0.1
 */