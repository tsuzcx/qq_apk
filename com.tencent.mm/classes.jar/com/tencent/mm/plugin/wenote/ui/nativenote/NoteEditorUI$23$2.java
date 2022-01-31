package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.b;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.ui.g;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class NoteEditorUI$23$2
  implements n.d
{
  NoteEditorUI$23$2(NoteEditorUI.23 param23) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    int j = 0;
    int i = 0;
    int k = 1;
    paramInt = 1;
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    case 11: 
    default: 
      return;
    case 0: 
      if (NoteEditorUI.f(this.rMa.rLT) != null) {
        NoteEditorUI.f(this.rMa.rLT).a(null);
      }
      NoteEditorUI.a(this.rMa.rLT, com.tencent.mm.ui.base.h.b(this.rMa.rLT.mController.uMN, this.rMa.rLT.getString(R.l.Note_SyncData_CannotForward), true, new NoteEditorUI.23.2.1(this)));
      com.tencent.mm.sdk.f.e.post(new NoteEditorUI.23.2.2(this), "AddFavNoteSync");
      return;
    case 1: 
      if (NoteEditorUI.f(this.rMa.rLT) != null) {
        NoteEditorUI.f(this.rMa.rLT).a(null);
      }
      NoteEditorUI.j(this.rMa.rLT).ciF();
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_scene", 2);
      paramMenuItem.putExtra("key_fav_item_id", NoteEditorUI.h(this.rMa.rLT));
      com.tencent.mm.plugin.fav.a.b.a(this.rMa.rLT.mController.uMN, ".ui.FavTagEditUI", paramMenuItem);
      paramMenuItem = NoteEditorUI.k(this.rMa.rLT);
      paramMenuItem.jYP += 1;
      return;
    case 2: 
      com.tencent.mm.ui.base.h.a(this.rMa.rLT.mController.uMN, this.rMa.rLT.getString(R.l.app_delete_tips), "", new NoteEditorUI.23.2.3(this), null);
      return;
    case 3: 
      paramMenuItem = new cj();
      com.tencent.mm.pluginsdk.model.e.a(paramMenuItem, NoteEditorUI.m(this.rMa.rLT));
      a.udP.m(paramMenuItem);
      com.tencent.mm.plugin.fav.ui.c.a(paramMenuItem.bIx.ret, this.rMa.rLT, this.rMa.rLT.kNz);
      return;
    case 4: 
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      paramMenuItem.putExtra("select_is_ret", true);
      paramMenuItem.putExtra("mutil_select_is_ret", true);
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", NoteEditorUI.m(this.rMa.rLT));
      com.tencent.mm.br.d.c(this.rMa.rLT, ".ui.transmit.SelectConversationUI", paramMenuItem, 4096);
      paramMenuItem = NoteEditorUI.n(this.rMa.rLT);
      paramMenuItem.jYM += 1;
      return;
    case 5: 
      NoteEditorUI.j(this.rMa.rLT).ciF();
      paramMenuItem = new q();
      if (NoteEditorUI.d(this.rMa.rLT) == 1)
      {
        bool = true;
        paramMenuItem.rGL = bool;
        paramMenuItem.rGP = NoteEditorUI.o(this.rMa.rLT);
        paramMenuItem.rGO = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Uz(this.rMa.rLT.getString(R.l.wenote_keep_top_default_title));
        paramMenuItem.rGQ = NoteEditorUI.p(this.rMa.rLT);
        paramMenuItem.rGR = NoteEditorUI.q(this.rMa.rLT);
        if (NoteEditorUI.d(this.rMa.rLT) != 1) {
          break label733;
        }
        paramMenuItem.rGN = NoteEditorUI.m(this.rMa.rLT);
        if (!NoteEditorUI.r(this.rMa.rLT)) {
          break label705;
        }
        paramMenuItem.kay = true;
        com.tencent.mm.plugin.report.service.h.nFQ.f(14790, new Object[] { Integer.valueOf(3) });
      }
      for (;;)
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.h.cir().a(paramMenuItem);
        com.tencent.mm.ui.widget.snackbar.b.h(this.rMa.rLT, this.rMa.rLT.getString(R.l.wenote_keep_top_done));
        return;
        bool = false;
        break;
        paramMenuItem.kay = false;
        com.tencent.mm.plugin.report.service.h.nFQ.f(14790, new Object[] { Integer.valueOf(2) });
        continue;
        com.tencent.mm.plugin.report.service.h.nFQ.f(14790, new Object[] { Integer.valueOf(1) });
        paramMenuItem.rGM = NoteEditorUI.h(this.rMa.rLT);
      }
    case 6: 
      com.tencent.mm.plugin.wenote.model.nativenote.manager.h.cir().a(null);
      com.tencent.mm.ui.widget.snackbar.b.h(this.rMa.rLT, this.rMa.rLT.getString(R.l.wenote_cancel_top_done));
      return;
    case 7: 
      com.tencent.mm.plugin.fav.a.h.f(NoteEditorUI.h(this.rMa.rLT), 0, 0);
      if ((NoteEditorUI.s(this.rMa.rLT)) || (NoteEditorUI.t(this.rMa.rLT))) {
        paramInt = 1;
      }
      String str;
      for (;;)
      {
        if (paramInt != 0)
        {
          NoteEditorUI.j(this.rMa.rLT).ciF();
          this.rMa.rLT.cjl();
          NoteEditorUI.w(this.rMa.rLT);
        }
        if ((NoteEditorUI.s(this.rMa.rLT)) || (NoteEditorUI.t(this.rMa.rLT)))
        {
          NoteEditorUI.x(this.rMa.rLT);
          NoteEditorUI.y(this.rMa.rLT);
          NoteEditorUI.z(this.rMa.rLT);
        }
        paramMenuItem = new gf();
        paramMenuItem.bNF.type = 30;
        paramMenuItem.bNF.bNM = 1;
        paramMenuItem.bNF.bIr = NoteEditorUI.h(this.rMa.rLT);
        a.udP.m(paramMenuItem);
        str = paramMenuItem.bNG.path;
        NoteEditorUI.a(this.rMa.rLT, paramMenuItem.bNG.thumbPath);
        if (!bk.bl(str)) {
          break;
        }
        NoteEditorUI.A(this.rMa.rLT).post(new NoteEditorUI.23.2.4(this));
        return;
        paramInt = i;
        if (NoteEditorUI.u(this.rMa.rLT))
        {
          paramInt = i;
          if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().cie().equals(NoteEditorUI.v(this.rMa.rLT))) {
            paramInt = 1;
          }
        }
      }
      NoteEditorUI.b(this.rMa.rLT, str);
      paramMenuItem = NoteEditorUI.B(this.rMa.rLT);
      paramMenuItem.jYN += 1;
      return;
    case 8: 
      NoteEditorUI.a(this.rMa.rLT, com.tencent.mm.ui.base.h.b(this.rMa.rLT.mController.uMN, this.rMa.rLT.getString(R.l.wv_loading), true, new NoteEditorUI.23.2.5(this)));
      paramMenuItem = new gf();
      paramMenuItem.bNF.type = 32;
      paramMenuItem.bNF.bIr = NoteEditorUI.h(this.rMa.rLT);
      paramMenuItem.bNF.bIy = com.tencent.mm.plugin.wenote.model.c.chu().rFh.rFt;
      a.udP.m(paramMenuItem);
      bool = paramMenuItem.bNG.bNW;
      if (paramMenuItem.bNG.path == null)
      {
        NoteEditorUI.g(this.rMa.rLT);
        Toast.makeText(this.rMa.rLT.mController.uMN, this.rMa.rLT.mController.uMN.getString(R.l.note_pic_save_fail), 1).show();
        paramMenuItem = com.tencent.mm.plugin.report.service.h.nFQ;
        if (NoteEditorUI.e(this.rMa.rLT)) {}
        for (;;)
        {
          paramMenuItem.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramInt) });
          return;
          paramInt = 0;
        }
      }
      if (bool)
      {
        NoteEditorUI.g(this.rMa.rLT);
        Toast.makeText(this.rMa.rLT.mController.uMN, this.rMa.rLT.mController.uMN.getString(R.l.note_pic_save_fail), 1).show();
        paramMenuItem = com.tencent.mm.plugin.report.service.h.nFQ;
        if (NoteEditorUI.e(this.rMa.rLT)) {}
        for (paramInt = k;; paramInt = 0)
        {
          paramMenuItem.f(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramInt) });
          return;
        }
      }
      NoteEditorUI.A(this.rMa.rLT).post(new NoteEditorUI.23.2.6(this));
      return;
    case 9: 
      paramMenuItem = new gf();
      paramMenuItem.bNF.type = 32;
      paramMenuItem.bNF.bIr = NoteEditorUI.h(this.rMa.rLT);
      paramMenuItem.bNF.bIy = com.tencent.mm.plugin.wenote.model.c.chu().rFh.rFt;
      a.udP.m(paramMenuItem);
      bool = paramMenuItem.bNG.bNW;
      paramInt = j;
      if (paramMenuItem.bNG.ret != 0) {
        paramInt = 1;
      }
      if (paramMenuItem.bNG.path == null)
      {
        com.tencent.mm.ui.base.h.bC(this.rMa.rLT.mController.uMN, this.rMa.rLT.getString(R.l.favorite_retransmit_tip));
        return;
      }
      if (bool)
      {
        com.tencent.mm.ui.base.h.bC(this.rMa.rLT.mController.uMN, this.rMa.rLT.getString(R.l.Note_NotDownload_CannotForward));
        return;
      }
      if (paramInt != 0)
      {
        com.tencent.mm.ui.base.h.bC(this.rMa.rLT.mController.uMN, this.rMa.rLT.getString(R.l.Note_NotUpload_CannotForward));
        return;
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      paramMenuItem.putExtra("scene_from", 1);
      paramMenuItem.putExtra("mutil_select_is_ret", true);
      paramMenuItem.putExtra("select_fav_local_id", NoteEditorUI.h(this.rMa.rLT));
      paramMenuItem.putExtra("Retr_fav_xml_str", com.tencent.mm.plugin.wenote.model.c.chu().rFh.chv());
      com.tencent.mm.br.d.c(this.rMa.rLT, ".ui.transmit.SelectConversationUI", paramMenuItem, 4355);
      paramMenuItem = NoteEditorUI.C(this.rMa.rLT);
      paramMenuItem.jYM += 1;
      return;
    case 10: 
      com.tencent.mm.plugin.wenote.model.h.bd(this.rMa.rLT.mController.uMN, NoteEditorUI.D(this.rMa.rLT));
      return;
    case 12: 
      if (bk.bl(NoteEditorUI.E(this.rMa.rLT)))
      {
        NoteEditorUI.A(this.rMa.rLT).post(new NoteEditorUI.23.2.7(this));
        return;
      }
      paramMenuItem = NoteEditorUI.F(this.rMa.rLT);
      paramMenuItem.jYN += 1;
      NoteEditorUI.b(this.rMa.rLT, NoteEditorUI.E(this.rMa.rLT));
      return;
    case 13: 
      label705:
      label733:
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("k_expose_msg_id", NoteEditorUI.D(this.rMa.rLT));
      if ((NoteEditorUI.G(this.rMa.rLT) != null) && (NoteEditorUI.G(this.rMa.rLT).length > 1)) {
        paramMenuItem.putExtra("k_username", NoteEditorUI.G(this.rMa.rLT)[1]);
      }
      paramMenuItem.putExtra("showShare", NoteEditorUI.H(this.rMa.rLT));
      paramMenuItem.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
      com.tencent.mm.br.d.b(this.rMa.rLT.mController.uMN, "webview", ".ui.tools.WebViewUI", paramMenuItem);
      return;
    }
    g.a(this.rMa.rLT, NoteEditorUI.h(this.rMa.rLT), NoteEditorUI.I(this.rMa.rLT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2
 * JD-Core Version:    0.7.0.1
 */