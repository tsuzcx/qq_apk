package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.b;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.ui.g;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;

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
    AppMethodBeat.i(27029);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(27029);
      return;
      if (NoteEditorUI.f(this.vCE.vCx) != null) {
        NoteEditorUI.f(this.vCE.vCx).a(null);
      }
      NoteEditorUI.a(this.vCE.vCx, com.tencent.mm.ui.base.h.b(this.vCE.vCx.getContext(), this.vCE.vCx.getString(2131296335), true, new NoteEditorUI.23.2.1(this)));
      com.tencent.mm.sdk.g.d.post(new NoteEditorUI.23.2.2(this), "AddFavNoteSync");
      AppMethodBeat.o(27029);
      return;
      if (NoteEditorUI.f(this.vCE.vCx) != null) {
        NoteEditorUI.f(this.vCE.vCx).a(null);
      }
      NoteEditorUI.j(this.vCE.vCx).diW();
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_scene", 2);
      paramMenuItem.putExtra("key_fav_item_id", NoteEditorUI.h(this.vCE.vCx));
      com.tencent.mm.plugin.fav.a.b.b(this.vCE.vCx.getContext(), ".ui.FavTagEditUI", paramMenuItem);
      paramMenuItem = NoteEditorUI.k(this.vCE.vCx);
      paramMenuItem.mti += 1;
      AppMethodBeat.o(27029);
      return;
      com.tencent.mm.ui.base.h.a(this.vCE.vCx.getContext(), this.vCE.vCx.getString(2131296902), "", new NoteEditorUI.23.2.3(this), null);
      AppMethodBeat.o(27029);
      return;
      paramMenuItem = new cm();
      e.a(paramMenuItem, NoteEditorUI.m(this.vCE.vCx));
      a.ymk.l(paramMenuItem);
      com.tencent.mm.plugin.fav.ui.c.a(paramMenuItem.cpS.ret, this.vCE.vCx, this.vCE.vCx.nkf);
      AppMethodBeat.o(27029);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      paramMenuItem.putExtra("select_is_ret", true);
      paramMenuItem.putExtra("mutil_select_is_ret", true);
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", NoteEditorUI.m(this.vCE.vCx));
      com.tencent.mm.bq.d.b(this.vCE.vCx, ".ui.transmit.SelectConversationUI", paramMenuItem, 4096);
      paramMenuItem = NoteEditorUI.n(this.vCE.vCx);
      paramMenuItem.mtf += 1;
      AppMethodBeat.o(27029);
      return;
      NoteEditorUI.j(this.vCE.vCx).diW();
      paramMenuItem = new q();
      if (NoteEditorUI.d(this.vCE.vCx) == 1)
      {
        bool = true;
        paramMenuItem.vxu = bool;
        paramMenuItem.vxy = NoteEditorUI.o(this.vCE.vCx);
        paramMenuItem.vxx = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().ajO(this.vCE.vCx.getString(2131305965));
        paramMenuItem.vxz = NoteEditorUI.p(this.vCE.vCx);
        paramMenuItem.vxA = NoteEditorUI.q(this.vCE.vCx);
        if (NoteEditorUI.d(this.vCE.vCx) != 1) {
          break label767;
        }
        paramMenuItem.vxw = NoteEditorUI.m(this.vCE.vCx);
        if (!NoteEditorUI.r(this.vCE.vCx)) {
          break label739;
        }
        paramMenuItem.muU = true;
        com.tencent.mm.plugin.report.service.h.qsU.e(14790, new Object[] { Integer.valueOf(3) });
      }
      for (;;)
      {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.h.diI().a(paramMenuItem);
        com.tencent.mm.ui.widget.snackbar.b.l(this.vCE.vCx, this.vCE.vCx.getString(2131305966));
        AppMethodBeat.o(27029);
        return;
        bool = false;
        break;
        label739:
        paramMenuItem.muU = false;
        com.tencent.mm.plugin.report.service.h.qsU.e(14790, new Object[] { Integer.valueOf(2) });
        continue;
        label767:
        com.tencent.mm.plugin.report.service.h.qsU.e(14790, new Object[] { Integer.valueOf(1) });
        paramMenuItem.vxv = NoteEditorUI.h(this.vCE.vCx);
      }
      com.tencent.mm.plugin.wenote.model.nativenote.manager.h.diI().a(null);
      com.tencent.mm.ui.widget.snackbar.b.l(this.vCE.vCx, this.vCE.vCx.getString(2131305960));
      AppMethodBeat.o(27029);
      return;
      com.tencent.mm.plugin.fav.a.h.i(NoteEditorUI.h(this.vCE.vCx), 0, 0);
      if ((NoteEditorUI.s(this.vCE.vCx)) || (NoteEditorUI.t(this.vCE.vCx))) {
        paramInt = 1;
      }
      String str;
      for (;;)
      {
        if (paramInt != 0)
        {
          NoteEditorUI.j(this.vCE.vCx).diW();
          this.vCE.vCx.djM();
          NoteEditorUI.w(this.vCE.vCx);
        }
        if ((NoteEditorUI.s(this.vCE.vCx)) || (NoteEditorUI.t(this.vCE.vCx)))
        {
          NoteEditorUI.x(this.vCE.vCx);
          NoteEditorUI.y(this.vCE.vCx);
          NoteEditorUI.z(this.vCE.vCx);
        }
        paramMenuItem = new gi();
        paramMenuItem.cuX.type = 30;
        paramMenuItem.cuX.cve = 1;
        paramMenuItem.cuX.cpM = NoteEditorUI.h(this.vCE.vCx);
        a.ymk.l(paramMenuItem);
        str = paramMenuItem.cuY.path;
        NoteEditorUI.a(this.vCE.vCx, paramMenuItem.cuY.thumbPath);
        if (!bo.isNullOrNil(str)) {
          break;
        }
        NoteEditorUI.A(this.vCE.vCx).post(new NoteEditorUI.23.2.4(this));
        AppMethodBeat.o(27029);
        return;
        paramInt = i;
        if (NoteEditorUI.u(this.vCE.vCx))
        {
          paramInt = i;
          if (!com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().div().equals(NoteEditorUI.v(this.vCE.vCx))) {
            paramInt = 1;
          }
        }
      }
      NoteEditorUI.b(this.vCE.vCx, str);
      paramMenuItem = NoteEditorUI.B(this.vCE.vCx);
      paramMenuItem.mtg += 1;
      AppMethodBeat.o(27029);
      return;
      NoteEditorUI.a(this.vCE.vCx, com.tencent.mm.ui.base.h.b(this.vCE.vCx.getContext(), this.vCE.vCx.getString(2131306027), true, new NoteEditorUI.23.2.5(this)));
      paramMenuItem = new gi();
      paramMenuItem.cuX.type = 32;
      paramMenuItem.cuX.cpM = NoteEditorUI.h(this.vCE.vCx);
      paramMenuItem.cuX.cpT = com.tencent.mm.plugin.wenote.model.c.dhH().vvQ.vwc;
      a.ymk.l(paramMenuItem);
      boolean bool = paramMenuItem.cuY.cvo;
      if (paramMenuItem.cuY.path == null)
      {
        NoteEditorUI.g(this.vCE.vCx);
        Toast.makeText(this.vCE.vCx.getContext(), this.vCE.vCx.getContext().getString(2131301884), 1).show();
        paramMenuItem = com.tencent.mm.plugin.report.service.h.qsU;
        if (NoteEditorUI.e(this.vCE.vCx)) {}
        for (;;)
        {
          paramMenuItem.e(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramInt) });
          AppMethodBeat.o(27029);
          return;
          paramInt = 0;
        }
      }
      if (bool)
      {
        NoteEditorUI.g(this.vCE.vCx);
        Toast.makeText(this.vCE.vCx.getContext(), this.vCE.vCx.getContext().getString(2131301884), 1).show();
        paramMenuItem = com.tencent.mm.plugin.report.service.h.qsU;
        if (NoteEditorUI.e(this.vCE.vCx)) {}
        for (paramInt = k;; paramInt = 0)
        {
          paramMenuItem.e(14811, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(paramInt) });
          AppMethodBeat.o(27029);
          return;
        }
      }
      NoteEditorUI.A(this.vCE.vCx).post(new NoteEditorUI.23.2.6(this));
      AppMethodBeat.o(27029);
      return;
      paramMenuItem = new gi();
      paramMenuItem.cuX.type = 32;
      paramMenuItem.cuX.cpM = NoteEditorUI.h(this.vCE.vCx);
      paramMenuItem.cuX.cpT = com.tencent.mm.plugin.wenote.model.c.dhH().vvQ.vwc;
      a.ymk.l(paramMenuItem);
      bool = paramMenuItem.cuY.cvo;
      paramInt = j;
      if (paramMenuItem.cuY.ret != 0) {
        paramInt = 1;
      }
      if (paramMenuItem.cuY.path == null)
      {
        com.tencent.mm.ui.base.h.bO(this.vCE.vCx.getContext(), this.vCE.vCx.getString(2131299813));
        AppMethodBeat.o(27029);
        return;
      }
      if (bool)
      {
        com.tencent.mm.ui.base.h.bO(this.vCE.vCx.getContext(), this.vCE.vCx.getString(2131296333));
        AppMethodBeat.o(27029);
        return;
      }
      if (paramInt != 0)
      {
        com.tencent.mm.ui.base.h.bO(this.vCE.vCx.getContext(), this.vCE.vCx.getString(2131296334));
        AppMethodBeat.o(27029);
        return;
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      paramMenuItem.putExtra("scene_from", 1);
      paramMenuItem.putExtra("mutil_select_is_ret", true);
      paramMenuItem.putExtra("select_fav_local_id", NoteEditorUI.h(this.vCE.vCx));
      paramMenuItem.putExtra("Retr_fav_xml_str", com.tencent.mm.plugin.wenote.model.c.dhH().vvQ.dhI());
      com.tencent.mm.bq.d.b(this.vCE.vCx, ".ui.transmit.SelectConversationUI", paramMenuItem, 4355);
      paramMenuItem = NoteEditorUI.C(this.vCE.vCx);
      paramMenuItem.mtf += 1;
      AppMethodBeat.o(27029);
      return;
      com.tencent.mm.plugin.wenote.model.h.bp(this.vCE.vCx.getContext(), NoteEditorUI.D(this.vCE.vCx));
      AppMethodBeat.o(27029);
      return;
      AppMethodBeat.o(27029);
      return;
      if (bo.isNullOrNil(NoteEditorUI.E(this.vCE.vCx)))
      {
        NoteEditorUI.A(this.vCE.vCx).post(new NoteEditorUI.23.2.7(this));
        AppMethodBeat.o(27029);
        return;
      }
      paramMenuItem = NoteEditorUI.F(this.vCE.vCx);
      paramMenuItem.mtg += 1;
      NoteEditorUI.b(this.vCE.vCx, NoteEditorUI.E(this.vCE.vCx));
      AppMethodBeat.o(27029);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("k_expose_msg_id", NoteEditorUI.D(this.vCE.vCx));
      if ((NoteEditorUI.G(this.vCE.vCx) != null) && (NoteEditorUI.G(this.vCE.vCx).length > 1)) {
        paramMenuItem.putExtra("k_username", NoteEditorUI.G(this.vCE.vCx)[1]);
      }
      paramMenuItem.putExtra("showShare", NoteEditorUI.H(this.vCE.vCx));
      paramMenuItem.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
      com.tencent.mm.bq.d.b(this.vCE.vCx.getContext(), "webview", ".ui.tools.WebViewUI", paramMenuItem);
      AppMethodBeat.o(27029);
      return;
      g.a(this.vCE.vCx, NoteEditorUI.h(this.vCE.vCx), NoteEditorUI.I(this.vCE.vCx));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2
 * JD-Core Version:    0.7.0.1
 */