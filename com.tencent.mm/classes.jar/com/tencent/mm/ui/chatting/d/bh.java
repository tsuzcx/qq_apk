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
import com.tencent.mm.g.b.a.jc;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.c.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.ag;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.model.m.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.av;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.ArrayList;

@com.tencent.mm.ui.chatting.d.a.a(gRF=av.class)
public class bh
  extends a
  implements av
{
  private long Pvi;
  private SparseBooleanArray Pvj;
  
  public bh()
  {
    AppMethodBeat.i(35756);
    this.Pvi = -1L;
    this.Pvj = new SparseBooleanArray();
    AppMethodBeat.o(35756);
  }
  
  private void aL(Intent paramIntent)
  {
    AppMethodBeat.i(35764);
    final com.tencent.mm.modelvideo.c localc = new com.tencent.mm.modelvideo.c();
    localc.a(this.dom.Pwc.getContext(), paramIntent, this.dom.getTalkerUserName(), new c.a()
    {
      public final void c(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(233228);
        if (paramAnonymousInt1 == -50002) {
          Toast.makeText(bh.this.dom.Pwc.getContext(), bh.this.dom.Pwc.getContext().getString(2131767068), 0).show();
        }
        for (;;)
        {
          bh.this.dom.dismissDialog();
          AppMethodBeat.o(233228);
          return;
          if (paramAnonymousInt1 < 0)
          {
            Toast.makeText(bh.this.dom.Pwc.getContext(), bh.this.dom.Pwc.getContext().getString(2131767067), 0).show();
          }
          else
          {
            com.tencent.mm.modelvideo.u.c(paramAnonymousString1, paramAnonymousInt2, bh.this.dom.getTalkerUserName(), paramAnonymousString2);
            com.tencent.mm.modelvideo.u.QG(paramAnonymousString1);
          }
        }
      }
    });
    this.dom.b(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131755998), this.dom.Pwc.getMMResources().getString(2131756029), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        localc.jpO = null;
      }
    });
    AppMethodBeat.o(35764);
  }
  
  private void bF(Intent paramIntent)
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
    if ((((String)localObject).equals("medianote")) && ((z.aUc() & 0x4000) == 0))
    {
      paramIntent = new com.tencent.mm.modelvideo.s();
      paramIntent.fileName = str;
      paramIntent.iFw = i;
      paramIntent.dWq = ((String)localObject);
      paramIntent.jsh = ((String)g.aAh().azQ().get(2, ""));
      paramIntent.createTime = Util.nowSecond();
      paramIntent.jsm = Util.nowSecond();
      paramIntent.jsj = i;
      paramIntent.jqP = i;
      o.bhj();
      i = t.Qy(t.Qw(str));
      if (i <= 0)
      {
        Log.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
        AppMethodBeat.o(35765);
        return;
      }
      paramIntent.iKP = i;
      o.bhj();
      localObject = t.Qx(str);
      i = t.Qy((String)localObject);
      if (i <= 0)
      {
        Log.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + i);
        AppMethodBeat.o(35765);
        return;
      }
      paramIntent.jsl = i;
      Log.d("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + paramIntent.jsl + " videosize:" + paramIntent.iKP);
      paramIntent.status = 199;
      localObject = new ca();
      ((ca)localObject).Cy(paramIntent.getUser());
      ((ca)localObject).setType(43);
      ((ca)localObject).nv(1);
      ((ca)localObject).Cz(str);
      ((ca)localObject).setStatus(2);
      ((ca)localObject).setCreateTime(bp.Kw(paramIntent.getUser()));
      paramIntent.jso = ((int)bp.x((ca)localObject));
      o.bhj().b(paramIntent);
      AppMethodBeat.o(35765);
      return;
    }
    com.tencent.mm.modelvideo.u.c(str, i, (String)localObject, null);
    com.tencent.mm.modelvideo.u.QG(str);
    this.dom.BN(true);
    AppMethodBeat.o(35765);
  }
  
  private void bq(final ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(35762);
    Log.v("MicroMsg.ChattingUI.VideoComponent", "send video path: %s", new Object[] { paramArrayList.toString() });
    paramArrayList = new m(this.dom.Pwc.getContext(), paramArrayList, null, this.dom.getTalkerUserName(), 2, new m.a()
    {
      public final void gmA()
      {
        AppMethodBeat.i(233225);
        bh.this.dom.dismissDialog();
        AppMethodBeat.o(233225);
      }
    });
    this.dom.b(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131755998), this.dom.Pwc.getMMResources().getString(2131756029), new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(233226);
        paramArrayList.gmu();
        AppMethodBeat.o(233226);
      }
    });
    ThreadPool.post(paramArrayList, "ChattingUI_importMultiVideo");
    AppMethodBeat.o(35762);
  }
  
  private void ck(ca paramca)
  {
    AppMethodBeat.i(35759);
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.u.g(this.dom.Pwc.getContext(), this.dom.Pwc.getContentView());
      AppMethodBeat.o(35759);
      return;
    }
    Object localObject1;
    if (paramca.cWK())
    {
      localObject1 = new Intent(this.dom.Pwc.getContext(), MsgRetransmitUI.class);
      ((Intent)localObject1).putExtra("Retr_Msg_Id", paramca.field_msgId);
      ((Intent)localObject1).putExtra("Retr_Msg_content", paramca.field_content);
      ((Intent)localObject1).putExtra("Retr_From", "chattingui");
      Log.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + paramca.getType());
      ((Intent)localObject1).putExtra("Retr_Msg_Type", 1);
      paramca = this.dom.Pwc;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(paramca, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramca.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramca, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35759);
      return;
    }
    com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.QN(paramca.field_imgPath);
    if (locals != null)
    {
      Object localObject2 = locals.bhu();
      localObject1 = localObject2;
      if (!com.tencent.mm.vfs.s.YS((String)localObject2))
      {
        o.bhj();
        localObject1 = t.Qw(paramca.field_imgPath);
      }
      if (paramca.gDB())
      {
        Log.i("MicroMsg.ChattingUI.VideoComponent", "video is clean!!!");
        com.tencent.mm.ui.base.h.d(this.dom.Pwc.getContext(), this.dom.Pwc.getContext().getString(2131767049), this.dom.Pwc.getContext().getString(2131755998), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(35759);
        return;
      }
      if (l.h(paramca, (String)localObject1))
      {
        Log.i("MicroMsg.ChattingUI.VideoComponent", "video is expired");
        he(locals.getFileName(), 3);
        Log.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
        localObject2 = new Intent(this.dom.Pwc.getContext(), ImageGalleryUI.class);
        ((Intent)localObject2).putExtra("img_gallery_msg_id", paramca.field_msgId);
        ((Intent)localObject2).putExtra("img_gallery_msg_svr_id", paramca.field_msgSvrId);
        ((Intent)localObject2).putExtra("img_gallery_talker", paramca.field_talker);
        ((Intent)localObject2).putExtra("img_gallery_chatroom_name", paramca.field_talker);
        ((Intent)localObject2).putExtra("img_gallery_enter_video_opcode", com.tencent.mm.modelvideo.u.f(paramca.field_msgId, 1));
        l.a(this.dom, paramca, (Intent)localObject2);
        localObject1 = this.dom.Pwc;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMFragment)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.dom.Pwc.overridePendingTransition(0, 0);
        if (locals.bhx())
        {
          Log.i("MicroMsg.ChattingUI.VideoComponent", "start complete online video");
          com.tencent.mm.modelvideo.u.QT(paramca.field_imgPath);
          AppMethodBeat.o(35759);
          return;
        }
        Log.i("MicroMsg.ChattingUI.VideoComponent", "start complete offline video");
        com.tencent.mm.modelvideo.u.QI(paramca.field_imgPath);
        AppMethodBeat.o(35759);
        return;
      }
      if ((paramca.cWJ()) || (paramca.cWL()))
      {
        localObject1 = new Intent(this.dom.Pwc.getContext(), MsgRetransmitUI.class);
        ((Intent)localObject1).putExtra("Retr_length", locals.iFw);
        ((Intent)localObject1).putExtra("Retr_File_Name", paramca.field_imgPath);
        ((Intent)localObject1).putExtra("Retr_video_isexport", locals.jsr);
        ((Intent)localObject1).putExtra("Retr_Msg_Id", paramca.field_msgId);
        ((Intent)localObject1).putExtra("Retr_From", "chattingui");
        Log.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + paramca.getType());
        if (paramca.cWL()) {
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 11);
        }
        for (;;)
        {
          paramca = this.dom.Pwc;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramca, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramca.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramca, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickRetransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
  
  private void he(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(35757);
    bg.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35749);
        com.tencent.mm.modelvideo.u.aA(paramString, paramInt);
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
      paramMenuItem = o.bhj().Qq(paramca.field_imgPath);
      if (paramMenuItem != null) {
        if (paramMenuItem.status == 199)
        {
          o.bhj();
          paramca = t.Qw(paramca.field_imgPath);
          if (paramMenuItem != null)
          {
            i = 0;
            if (ab.Eq(paramMenuItem.getUser())) {
              i = v.Ie(paramMenuItem.getUser());
            }
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(106L, 215L, 1L, false);
            com.tencent.mm.plugin.report.service.h.CyF.a(12084, new Object[] { Integer.valueOf(paramMenuItem.iKP), Integer.valueOf(paramMenuItem.iFw * 1000), Integer.valueOf(0), Integer.valueOf(2), paramMenuItem.getUser(), Integer.valueOf(i), com.tencent.mm.modelvideo.s.Qn(paramMenuItem.bhv()), Long.valueOf(paramMenuItem.createTime) });
          }
          p.b(this.dom.Pwc.getContext(), paramca, new p.a()
          {
            public final void bP(String paramAnonymousString1, String paramAnonymousString2)
            {
              AppMethodBeat.i(233223);
              Toast.makeText(bh.this.dom.Pwc.getContext(), bh.this.dom.Pwc.getMMResources().getString(2131767076, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramAnonymousString2) }), 1).show();
              com.tencent.mm.pluginsdk.ui.tools.s.refreshMediaScanner(paramAnonymousString2, bh.this.dom.Pwc.getContext());
              AppMethodBeat.o(233223);
            }
            
            public final void bQ(String paramAnonymousString1, String paramAnonymousString2)
            {
              AppMethodBeat.i(233224);
              Toast.makeText(bh.this.dom.Pwc.getContext(), bh.this.dom.Pwc.getMMResources().getString(2131767075), 1).show();
              AppMethodBeat.o(233224);
            }
          });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(35758);
        return true;
        he(paramMenuItem.getFileName(), 6);
        Log.i("MicroMsg.ChattingUI.VideoComponent", "[ImageGalleryUI] enter");
        paramMenuItem = new Intent(this.dom.Pwc.getContext(), ImageGalleryUI.class);
        paramMenuItem.putExtra("img_gallery_msg_id", paramca.field_msgId);
        paramMenuItem.putExtra("img_gallery_msg_svr_id", paramca.field_msgSvrId);
        paramMenuItem.putExtra("img_gallery_talker", paramca.field_talker);
        paramMenuItem.putExtra("img_gallery_chatroom_name", paramca.field_talker);
        paramMenuItem.putExtra("img_gallery_enter_video_opcode", com.tencent.mm.modelvideo.u.f(paramca.field_msgId, 2));
        l.a(this.dom, paramca, paramMenuItem);
        paramca = this.dom.Pwc;
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
        com.tencent.mm.hellhoundlib.a.a.a(paramca, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickSaveVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramca.startActivity((Intent)paramMenuItem.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramca, "com/tencent/mm/ui/chatting/component/VideoComponent", "longClickSaveVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        this.dom.Pwc.overridePendingTransition(0, 0);
        continue;
        Log.e("MicroMsg.ChattingUI.VideoComponent", "save video but videoInfo is null!");
      }
    case 107: 
      paramMenuItem = br.N(paramca);
      if ((Util.isNullOrNil(paramMenuItem)) || (paramca.field_isSend == 1)) {
        ck(paramca);
      }
      while (br.D(paramca))
      {
        paramMenuItem = new jc();
        paramMenuItem.emN = paramca.field_msgSvrId;
        paramMenuItem.eLn = paramca.getType();
        paramMenuItem.eQu = br.C(paramca);
        paramMenuItem.ejA = 4L;
        paramMenuItem.bfK();
        break;
        com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), 2131765108, 2131765109, 2131756020, 2131757502, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35750);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
            paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
            paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
            com.tencent.mm.br.c.b(bh.this.dom.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
            com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
            AppMethodBeat.o(35750);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35751);
            bh.a(bh.this, paramca);
            com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
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
      localIntent = new Intent(this.dom.Pwc.getContext(), ImageGalleryUI.class);
      localIntent.putExtra("img_gallery_msg_id", paramca.field_msgId);
      localIntent.putExtra("img_gallery_msg_svr_id", paramca.field_msgSvrId);
      localIntent.putExtra("img_gallery_talker", paramca.field_talker);
      localIntent.putExtra("img_gallery_chatroom_name", paramca.field_talker);
      localIntent.putExtra("img_gallery_left", paramMenuItem[0]);
      localIntent.putExtra("img_gallery_top", paramMenuItem[1]);
      localIntent.putExtra("img_gallery_width", j);
      localIntent.putExtra("img_gallery_height", i);
      localIntent.putExtra("img_gallery_enter_video_opcode", com.tencent.mm.modelvideo.u.f(paramca.field_msgId, 3));
      l.a(this.dom, paramca, localIntent);
      paramMenuItem = this.dom.Pwc;
      paramca = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, paramca.axQ(), "com/tencent/mm/ui/chatting/component/VideoComponent", "dealWithLongClick", "(Landroid/view/MenuItem;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramMenuItem.startActivity((Intent)paramca.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, "com/tencent/mm/ui/chatting/component/VideoComponent", "dealWithLongClick", "(Landroid/view/MenuItem;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.dom.Pwc.overridePendingTransition(0, 0);
      AppMethodBeat.o(35758);
      return true;
      j = localIntent.getIntExtra("img_gallery_width", 0);
      i = localIntent.getIntExtra("img_gallery_height", 0);
      paramMenuItem[0] = localIntent.getIntExtra("img_gallery_left", 0);
      paramMenuItem[1] = localIntent.getIntExtra("img_gallery_top", 0);
    }
  }
  
  public final void aK(final Intent paramIntent)
  {
    AppMethodBeat.i(35763);
    Log.d("MicroMsg.ChattingUI.VideoComponent", "sendVideo");
    if (!ag.dm(this.dom.Pwc.getContext()))
    {
      com.tencent.mm.ui.base.h.a(this.dom.Pwc.getContext(), 2131767069, 2131755998, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(233227);
          bh.a(bh.this, paramIntent);
          AppMethodBeat.o(233227);
        }
      }, null);
      AppMethodBeat.o(35763);
      return;
    }
    aL(paramIntent);
    AppMethodBeat.o(35763);
  }
  
  public final void bE(Intent paramIntent)
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
      if (!ag.dm(this.dom.Pwc.getContext()))
      {
        bq(paramIntent);
        AppMethodBeat.o(35761);
        return;
      }
      bq(paramIntent);
      AppMethodBeat.o(35761);
      return;
    }
    Log.e("MicroMsg.ChattingUI.VideoComponent", "send video list is null or nil");
    AppMethodBeat.o(35761);
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(35767);
    Log.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingResume]");
    k localk = (k)this.dom.bh(k.class);
    o.bhj().a(localk.gOA(), bg.aAk().getLooper());
    AppMethodBeat.o(35767);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35768);
    Log.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingPause]");
    k localk = (k)this.dom.bh(k.class);
    o.bhj().a(localk.gOA());
    AppMethodBeat.o(35768);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35769);
    b.aRR();
    this.Pvj.clear();
    AppMethodBeat.o(35769);
  }
  
  public final boolean h(ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(35760);
    boolean bool;
    if (paramca.cWJ())
    {
      o.bhj();
      bool = paramBoolean;
      if (!com.tencent.mm.vfs.s.YS(t.Qw(paramca.field_imgPath))) {
        bool = false;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35760);
      return bool;
      bool = paramBoolean;
      if (paramca.cWL())
      {
        o.bhj();
        bool = paramBoolean;
        if (!com.tencent.mm.vfs.s.YS(t.Qw(paramca.field_imgPath))) {
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
      aK(paramIntent);
      AppMethodBeat.o(35766);
      return;
      aK(paramIntent);
      AppMethodBeat.o(35766);
      return;
      bF(paramIntent);
      AppMethodBeat.o(35766);
      return;
      if (paramIntent != null)
      {
        if (paramIntent.getBooleanExtra("from_record", false))
        {
          bF(paramIntent);
          AppMethodBeat.o(35766);
          return;
        }
        aK(paramIntent);
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
      if (!paramIntent.zsy)
      {
        Log.i("MicroMsg.ChattingUI.VideoComponent", "video path %s thumb path %s", new Object[] { paramIntent.zsA, paramIntent.zsB });
        o.bhj();
        String str = t.Qw(paramIntent.zsC);
        if (!paramIntent.zsA.equals(str))
        {
          Log.i("MicroMsg.ChattingUI.VideoComponent", "filepath not videopath and move it %s %s", new Object[] { paramIntent.zsA, str });
          com.tencent.mm.vfs.s.nx(paramIntent.zsA, str);
        }
        str = paramIntent.zsC;
        paramInt1 = paramIntent.zsE;
        Object localObject = this.dom.getTalkerUserName();
        cly localcly = paramIntent.zsF;
        com.tencent.mm.modelvideo.s locals = new com.tencent.mm.modelvideo.s();
        locals.fileName = str;
        locals.iFw = paramInt1;
        locals.dWq = ((String)localObject);
        locals.jsh = ((String)g.aAh().azQ().get(2, ""));
        locals.createTime = Util.nowSecond();
        locals.jsm = Util.nowSecond();
        locals.jsx = localcly;
        locals.jsr = 0;
        locals.jsu = 1;
        o.bhj();
        paramInt1 = t.Qy(t.Qw(str));
        boolean bool;
        if (paramInt1 <= 0)
        {
          Log.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
          bool = false;
        }
        while (bool)
        {
          com.tencent.mm.modelvideo.u.QG(paramIntent.zsC);
          AppMethodBeat.o(35766);
          return;
          locals.iKP = paramInt1;
          o.bhj();
          localObject = t.Qx(str);
          paramInt1 = t.Qy((String)localObject);
          if (paramInt1 <= 0)
          {
            Log.e("MicroMsg.VideoLogic", "get Thumb size failed :" + (String)localObject + " size:" + paramInt1);
            bool = false;
          }
          else
          {
            locals.jsl = paramInt1;
            Log.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str + " thumbsize:" + locals.jsl + " videosize:" + locals.iKP);
            locals.status = 102;
            localObject = new ca();
            ((ca)localObject).Cy(locals.getUser());
            ((ca)localObject).setType(43);
            ((ca)localObject).nv(1);
            ((ca)localObject).Cz(str);
            ((ca)localObject).setStatus(1);
            ((ca)localObject).setCreateTime(bp.Kw(locals.getUser()));
            locals.jso = ((int)bp.x((ca)localObject));
            bool = o.bhj().b(locals);
          }
        }
        Log.e("MicroMsg.ChattingUI.VideoComponent", "prepareMMSightRecord failed");
        AppMethodBeat.o(35766);
        return;
      }
      ((an)this.dom.bh(an.class)).a(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bh
 * JD-Core Version:    0.7.0.1
 */