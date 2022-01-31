package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.ac;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.ai;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.c.a.a(dJy=ai.class)
public class ar
  extends a
  implements ai
{
  private long zJd;
  private SparseBooleanArray zJe;
  
  public ar()
  {
    AppMethodBeat.i(31851);
    this.zJd = -1L;
    this.zJe = new SparseBooleanArray();
    AppMethodBeat.o(31851);
  }
  
  private void aV(Intent paramIntent)
  {
    AppMethodBeat.i(31859);
    ab.i("MicroMsg.ChattingUI.VideoComponent", "sendVideoFromCustomRecord");
    if (paramIntent == null)
    {
      ab.e("MicroMsg.ChattingUI.VideoComponent", "data == null");
      AppMethodBeat.o(31859);
      return;
    }
    Object localObject = paramIntent.getStringExtra("VideoRecorder_ToUser");
    String str = paramIntent.getStringExtra("VideoRecorder_FileName");
    int i = paramIntent.getIntExtra("VideoRecorder_VideoLength", 0);
    ab.e("MicroMsg.ChattingUI.VideoComponent", "fileName " + str + " length " + i + " user " + (String)localObject);
    if ((bo.isNullOrNil((String)localObject)) || (bo.isNullOrNil(str)) || (i < 0))
    {
      AppMethodBeat.o(31859);
      return;
    }
    if ((((String)localObject).equals("medianote")) && ((r.Zr() & 0x4000) == 0))
    {
      paramIntent = new s();
      paramIntent.fileName = str;
      paramIntent.fXx = i;
      paramIntent.cDt = ((String)localObject);
      paramIntent.fXq = ((String)g.RL().Ru().get(2, ""));
      paramIntent.createTime = bo.aox();
      paramIntent.fXv = bo.aox();
      paramIntent.fXs = i;
      paramIntent.fWa = i;
      o.alE();
      i = com.tencent.mm.modelvideo.t.vh(com.tencent.mm.modelvideo.t.vf(str));
      if (i <= 0)
      {
        ab.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
        AppMethodBeat.o(31859);
        return;
      }
      paramIntent.fsd = i;
      o.alE();
      localObject = com.tencent.mm.modelvideo.t.vg(str);
      i = com.tencent.mm.modelvideo.t.vh((String)localObject);
      if (i <= 0)
      {
        ab.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + i);
        AppMethodBeat.o(31859);
        return;
      }
      paramIntent.fXu = i;
      ab.d("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + paramIntent.fXu + " videosize:" + paramIntent.fsd);
      paramIntent.status = 199;
      localObject = new bi();
      ((bi)localObject).kj(paramIntent.getUser());
      ((bi)localObject).setType(43);
      ((bi)localObject).hL(1);
      ((bi)localObject).kk(str);
      ((bi)localObject).setStatus(2);
      ((bi)localObject).fQ(bf.py(paramIntent.getUser()));
      paramIntent.fXy = ((int)bf.l((bi)localObject));
      o.alE().b(paramIntent);
      AppMethodBeat.o(31859);
      return;
    }
    u.c(str, i, (String)localObject, null);
    u.vm(str);
    this.caz.qT(true);
    AppMethodBeat.o(31859);
  }
  
  private void ai(Intent paramIntent)
  {
    AppMethodBeat.i(31858);
    com.tencent.mm.modelvideo.c localc = new com.tencent.mm.modelvideo.c();
    localc.a(this.caz.zJz.getContext(), paramIntent, new ar.6(this));
    paramIntent = this.caz;
    Activity localActivity = this.caz.zJz.getContext();
    this.caz.zJz.getMMResources().getString(2131297087);
    paramIntent.c(localActivity, this.caz.zJz.getMMResources().getString(2131297112), new ar.7(this, localc));
    AppMethodBeat.o(31858);
  }
  
  private void ar(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(31856);
    ab.v("MicroMsg.ChattingUI.VideoComponent", "send video path: %s", new Object[] { paramArrayList.toString() });
    paramArrayList = new j(this.caz.zJz.getContext(), paramArrayList, null, this.caz.getTalkerUserName(), 2, new ar.3(this));
    com.tencent.mm.ui.chatting.d.a locala = this.caz;
    Activity localActivity = this.caz.zJz.getContext();
    this.caz.zJz.getMMResources().getString(2131297087);
    locala.c(localActivity, this.caz.zJz.getMMResources().getString(2131297112), new ar.4(this, paramArrayList));
    d.post(paramArrayList, "ChattingUI_importMultiVideo");
    AppMethodBeat.o(31856);
  }
  
  private void eR(String paramString, int paramInt)
  {
    AppMethodBeat.i(31852);
    aw.RO().ac(new ar.1(this, paramString, paramInt));
    AppMethodBeat.o(31852);
  }
  
  public final boolean a(MenuItem paramMenuItem, bi parambi)
  {
    AppMethodBeat.i(31853);
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 106: 
    case 107: 
      for (;;)
      {
        AppMethodBeat.o(31853);
        return false;
        paramMenuItem = o.alE().vd(parambi.field_imgPath);
        if (paramMenuItem != null) {
          if (paramMenuItem.status == 199)
          {
            o.alE();
            parambi = com.tencent.mm.modelvideo.t.vf(parambi.field_imgPath);
            if (paramMenuItem != null)
            {
              i = 0;
              if (com.tencent.mm.model.t.lA(paramMenuItem.getUser())) {
                i = com.tencent.mm.model.n.nv(paramMenuItem.getUser());
              }
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(106L, 215L, 1L, false);
              com.tencent.mm.plugin.report.service.h.qsU.e(12084, new Object[] { Integer.valueOf(paramMenuItem.fsd), Integer.valueOf(paramMenuItem.fXx * 1000), Integer.valueOf(0), Integer.valueOf(2), paramMenuItem.getUser(), Integer.valueOf(i), s.vc(paramMenuItem.alP()), Long.valueOf(paramMenuItem.createTime) });
            }
            paramMenuItem = u.vs(parambi);
            if (bo.isNullOrNil(paramMenuItem)) {
              Toast.makeText(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131304521), 1).show();
            }
          }
        }
        for (;;)
        {
          AppMethodBeat.o(31853);
          return true;
          Toast.makeText(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131304522, new Object[] { paramMenuItem }), 1).show();
          com.tencent.mm.pluginsdk.ui.tools.n.a(paramMenuItem, this.caz.zJz.getContext());
          continue;
          eR(paramMenuItem.getFileName(), 6);
          ab.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
          paramMenuItem = new Intent(this.caz.zJz.getContext(), ImageGalleryUI.class);
          paramMenuItem.putExtra("img_gallery_msg_id", parambi.field_msgId);
          paramMenuItem.putExtra("img_gallery_msg_svr_id", parambi.field_msgSvrId);
          paramMenuItem.putExtra("img_gallery_talker", parambi.field_talker);
          paramMenuItem.putExtra("img_gallery_chatroom_name", parambi.field_talker);
          paramMenuItem.putExtra("img_gallery_enter_video_opcode", u.e(parambi.field_msgId, 2));
          i.a(this.caz, parambi, paramMenuItem);
          this.caz.zJz.startActivity(paramMenuItem);
          this.caz.zJz.overridePendingTransition(0, 0);
          continue;
          ab.e("MicroMsg.ChattingUI.VideoComponent", "save video but videoInfo is null!");
        }
        aw.aaz();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.t.ii(this.caz.zJz.getContext());
        }
        else
        {
          s locals = u.vr(parambi.field_imgPath);
          if (locals != null)
          {
            localObject = locals.alO();
            paramMenuItem = (MenuItem)localObject;
            if (!com.tencent.mm.vfs.e.cN((String)localObject))
            {
              o.alE();
              paramMenuItem = com.tencent.mm.modelvideo.t.vf(parambi.field_imgPath);
            }
            if (parambi.dyc())
            {
              ab.i("MicroMsg.ChattingUI.VideoComponent", "video is clean!!!");
              com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getContext().getString(2131304506), this.caz.zJz.getContext().getString(2131297087), new ar.2(this));
            }
            else if (i.e(parambi, paramMenuItem))
            {
              ab.i("MicroMsg.ChattingUI.VideoComponent", "video is expired");
              eR(locals.getFileName(), 3);
              ab.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
              paramMenuItem = new Intent(this.caz.zJz.getContext(), ImageGalleryUI.class);
              paramMenuItem.putExtra("img_gallery_msg_id", parambi.field_msgId);
              paramMenuItem.putExtra("img_gallery_msg_svr_id", parambi.field_msgSvrId);
              paramMenuItem.putExtra("img_gallery_talker", parambi.field_talker);
              paramMenuItem.putExtra("img_gallery_chatroom_name", parambi.field_talker);
              paramMenuItem.putExtra("img_gallery_enter_video_opcode", u.e(parambi.field_msgId, 1));
              i.a(this.caz, parambi, paramMenuItem);
              this.caz.zJz.startActivity(paramMenuItem);
              this.caz.zJz.overridePendingTransition(0, 0);
              if (locals.alR())
              {
                ab.i("MicroMsg.ChattingUI.VideoComponent", "start complete online video");
                u.vy(parambi.field_imgPath);
              }
              else
              {
                ab.i("MicroMsg.ChattingUI.VideoComponent", "start complete offline video");
                u.vn(parambi.field_imgPath);
              }
            }
            else
            {
              if ((parambi.byj()) || (parambi.byk()))
              {
                paramMenuItem = new Intent(this.caz.zJz.getContext(), MsgRetransmitUI.class);
                paramMenuItem.putExtra("Retr_length", locals.fXx);
                paramMenuItem.putExtra("Retr_File_Name", parambi.field_imgPath);
                paramMenuItem.putExtra("Retr_video_isexport", locals.fXB);
                paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
                paramMenuItem.putExtra("Retr_From", "chattingui");
                ab.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + parambi.getType());
                if (parambi.byk()) {
                  paramMenuItem.putExtra("Retr_Msg_Type", 11);
                }
                for (;;)
                {
                  this.caz.zJz.startActivity(paramMenuItem);
                  break;
                  paramMenuItem.putExtra("Retr_Msg_Type", 1);
                }
              }
              ab.w("MicroMsg.ChattingUI.VideoComponent", "retranmist video unknow status.");
            }
          }
          else
          {
            ab.e("MicroMsg.ChattingUI.VideoComponent", "retransmit video but videoInfo is null!");
          }
        }
      }
    }
    Object localObject = paramMenuItem.getIntent();
    int j = 0;
    int i = 0;
    paramMenuItem = new int[2];
    if (localObject == null) {
      ab.e("MicroMsg.ChattingUI.VideoComponent", "[LONGCLICK_MENU_MUTE_PLAY] intent is null!");
    }
    for (;;)
    {
      ab.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] LONGCLICK_MENU_MUTE_PLAY");
      localObject = new Intent(this.caz.zJz.getContext(), ImageGalleryUI.class);
      ((Intent)localObject).putExtra("img_gallery_msg_id", parambi.field_msgId);
      ((Intent)localObject).putExtra("img_gallery_msg_svr_id", parambi.field_msgSvrId);
      ((Intent)localObject).putExtra("img_gallery_talker", parambi.field_talker);
      ((Intent)localObject).putExtra("img_gallery_chatroom_name", parambi.field_talker);
      ((Intent)localObject).putExtra("img_gallery_left", paramMenuItem[0]);
      ((Intent)localObject).putExtra("img_gallery_top", paramMenuItem[1]);
      ((Intent)localObject).putExtra("img_gallery_width", j);
      ((Intent)localObject).putExtra("img_gallery_height", i);
      ((Intent)localObject).putExtra("img_gallery_enter_video_opcode", u.e(parambi.field_msgId, 3));
      i.a(this.caz, parambi, (Intent)localObject);
      this.caz.zJz.startActivity((Intent)localObject);
      this.caz.zJz.overridePendingTransition(0, 0);
      AppMethodBeat.o(31853);
      return true;
      j = ((Intent)localObject).getIntExtra("img_gallery_width", 0);
      i = ((Intent)localObject).getIntExtra("img_gallery_height", 0);
      paramMenuItem[0] = ((Intent)localObject).getIntExtra("img_gallery_left", 0);
      paramMenuItem[1] = ((Intent)localObject).getIntExtra("img_gallery_top", 0);
    }
  }
  
  public final void aU(Intent paramIntent)
  {
    AppMethodBeat.i(31855);
    if (paramIntent == null)
    {
      AppMethodBeat.o(31855);
      return;
    }
    paramIntent = paramIntent.getStringArrayListExtra("key_select_video_list");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      if (!ac.cm(this.caz.zJz.getContext()))
      {
        ar(paramIntent);
        AppMethodBeat.o(31855);
        return;
      }
      ar(paramIntent);
      AppMethodBeat.o(31855);
      return;
    }
    ab.e("MicroMsg.ChattingUI.VideoComponent", "send video list is null or nil");
    AppMethodBeat.o(31855);
  }
  
  public final void ah(Intent paramIntent)
  {
    AppMethodBeat.i(31857);
    ab.d("MicroMsg.ChattingUI.VideoComponent", "sendVideo");
    if (!ac.cm(this.caz.zJz.getContext()))
    {
      com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), 2131304515, 2131297087, new ar.5(this, paramIntent), null);
      AppMethodBeat.o(31857);
      return;
    }
    ai(paramIntent);
    AppMethodBeat.o(31857);
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(31861);
    ab.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingResume]");
    com.tencent.mm.ui.chatting.c.b.h localh = (com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class);
    o.alE().a(localh.dHg(), aw.RO().oNc.getLooper());
    AppMethodBeat.o(31861);
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31862);
    ab.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingPause]");
    com.tencent.mm.ui.chatting.c.b.h localh = (com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class);
    o.alE().a(localh.dHg());
    AppMethodBeat.o(31862);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31863);
    b.XJ();
    this.zJe.clear();
    AppMethodBeat.o(31863);
  }
  
  public final boolean e(bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(31854);
    boolean bool;
    if (parambi.byj())
    {
      o.alE();
      bool = paramBoolean;
      if (!com.tencent.mm.vfs.e.cN(com.tencent.mm.modelvideo.t.vf(parambi.field_imgPath))) {
        bool = false;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(31854);
      return bool;
      bool = paramBoolean;
      if (parambi.byk())
      {
        o.alE();
        bool = paramBoolean;
        if (!com.tencent.mm.vfs.e.cN(com.tencent.mm.modelvideo.t.vf(parambi.field_imgPath))) {
          bool = false;
        }
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(31860);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31860);
      return;
      ah(paramIntent);
      AppMethodBeat.o(31860);
      return;
      ah(paramIntent);
      AppMethodBeat.o(31860);
      return;
      aV(paramIntent);
      AppMethodBeat.o(31860);
      return;
      if (paramIntent != null)
      {
        if (paramIntent.getBooleanExtra("from_record", false))
        {
          aV(paramIntent);
          AppMethodBeat.o(31860);
          return;
        }
        ah(paramIntent);
      }
      AppMethodBeat.o(31860);
      return;
      if (paramIntent == null)
      {
        ab.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == data");
        AppMethodBeat.o(31860);
        return;
      }
      paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
      if (paramIntent == null)
      {
        ab.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == captureResult");
        AppMethodBeat.o(31860);
        return;
      }
      if (!paramIntent.oFG)
      {
        ab.i("MicroMsg.ChattingUI.VideoComponent", "video path %s thumb path %s", new Object[] { paramIntent.oFI, paramIntent.oFJ });
        o.alE();
        String str = com.tencent.mm.modelvideo.t.vf(paramIntent.oFK);
        if (!paramIntent.oFI.equals(str))
        {
          ab.i("MicroMsg.ChattingUI.VideoComponent", "filepath not videopath and move it %s %s", new Object[] { paramIntent.oFI, str });
          com.tencent.mm.vfs.e.aT(paramIntent.oFI, str);
        }
        str = paramIntent.oFK;
        paramInt1 = paramIntent.oFM;
        Object localObject = this.caz.getTalkerUserName();
        bby localbby = paramIntent.oFN;
        s locals = new s();
        locals.fileName = str;
        locals.fXx = paramInt1;
        locals.cDt = ((String)localObject);
        locals.fXq = ((String)g.RL().Ru().get(2, ""));
        locals.createTime = bo.aox();
        locals.fXv = bo.aox();
        locals.fXH = localbby;
        locals.fXB = 0;
        locals.fXE = 1;
        o.alE();
        paramInt1 = com.tencent.mm.modelvideo.t.vh(com.tencent.mm.modelvideo.t.vf(str));
        boolean bool;
        if (paramInt1 <= 0)
        {
          ab.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
          bool = false;
        }
        while (bool)
        {
          u.vm(paramIntent.oFK);
          AppMethodBeat.o(31860);
          return;
          locals.fsd = paramInt1;
          o.alE();
          localObject = com.tencent.mm.modelvideo.t.vg(str);
          paramInt1 = com.tencent.mm.modelvideo.t.vh((String)localObject);
          if (paramInt1 <= 0)
          {
            ab.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + paramInt1);
            bool = false;
          }
          else
          {
            locals.fXu = paramInt1;
            ab.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str + " thumbsize:" + locals.fXu + " videosize:" + locals.fsd);
            locals.status = 102;
            localObject = new bi();
            ((bi)localObject).kj(locals.getUser());
            ((bi)localObject).setType(43);
            ((bi)localObject).hL(1);
            ((bi)localObject).kk(str);
            ((bi)localObject).setStatus(1);
            ((bi)localObject).fQ(bf.py(locals.getUser()));
            locals.fXy = ((int)bf.l((bi)localObject));
            bool = o.alE().b(locals);
          }
        }
        ab.e("MicroMsg.ChattingUI.VideoComponent", "prepareMMSightRecord failed");
        AppMethodBeat.o(31860);
        return;
      }
      ((aa)this.caz.ay(aa.class)).a(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ar
 * JD-Core Version:    0.7.0.1
 */