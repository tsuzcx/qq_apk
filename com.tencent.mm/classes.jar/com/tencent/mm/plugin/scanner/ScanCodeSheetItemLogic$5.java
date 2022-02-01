package com.tencent.mm.plugin.scanner;

import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.plugin.comm.c.g;
import com.tencent.mm.protocal.protobuf.cuk;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.bb;

final class ScanCodeSheetItemLogic$5
  implements u.b
{
  ScanCodeSheetItemLogic$5(ScanCodeSheetItemLogic paramScanCodeSheetItemLogic, int paramInt) {}
  
  public final void onAttach(ImageView paramImageView1, ImageView paramImageView2, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(313287);
    if (paramMenuItem.getItemId() == 7)
    {
      paramImageView1.setImageDrawable(bb.m(ScanCodeSheetItemLogic.g(this.OMf), c.g.icons_outlined_translate, ScanCodeSheetItemLogic.g(this.OMf).getResources().getColor(c.b.FG_0)));
      AppMethodBeat.o(313287);
      return;
    }
    if (paramMenuItem.getItemId() != this.OMh)
    {
      AppMethodBeat.o(313287);
      return;
    }
    if (ScanCodeSheetItemLogic.a(this.OMf) == null)
    {
      AppMethodBeat.o(313287);
      return;
    }
    paramImageView2 = new c.a();
    paramImageView2.oKo = true;
    paramImageView1.setBackground(null);
    paramImageView1.setImageDrawable(null);
    if (ScanCodeSheetItemLogic.a(this.OMf).aazR == 4)
    {
      paramImageView2.oKB = c.g.actionsheet_default_appbrand_icon;
      paramImageView2.nrc = true;
      com.tencent.mm.modelimage.loader.a.bKl().a(ScanCodeSheetItemLogic.a(this.OMf).aazV, paramImageView1, paramImageView2.bKx());
      AppMethodBeat.o(313287);
      return;
    }
    if (ScanCodeSheetItemLogic.a(this.OMf).aazR == 3)
    {
      paramImageView2.oKB = c.g.default_avatar_round;
      paramImageView2.nrc = true;
      com.tencent.mm.modelimage.loader.a.bKl().a(ScanCodeSheetItemLogic.a(this.OMf).aazV, paramImageView1, paramImageView2.bKx());
      AppMethodBeat.o(313287);
      return;
    }
    if (ScanCodeSheetItemLogic.a(this.OMf).aazR == 1)
    {
      paramImageView2.nrc = true;
      paramImageView2.oKI = com.tencent.mm.cd.a.fromDPToPix(ScanCodeSheetItemLogic.g(this.OMf), 4);
      paramImageView2.oKB = c.g.default_avatar;
      com.tencent.mm.modelimage.loader.a.bKl().a(ScanCodeSheetItemLogic.a(this.OMf).aazV, paramImageView1, paramImageView2.bKx());
      AppMethodBeat.o(313287);
      return;
    }
    if (ScanCodeSheetItemLogic.a(this.OMf).aazR == 2)
    {
      paramImageView1.setImageDrawable(bb.m(ScanCodeSheetItemLogic.g(this.OMf), c.g.icons_outlined_group_detail, ScanCodeSheetItemLogic.g(this.OMf).getResources().getColor(c.b.FG_0)));
      AppMethodBeat.o(313287);
      return;
    }
    if (ScanCodeSheetItemLogic.a(this.OMf).aazR == 7)
    {
      paramImageView2.nrc = true;
      paramImageView2.oKI = com.tencent.mm.cd.a.fromDPToPix(ScanCodeSheetItemLogic.g(this.OMf), 4);
      paramImageView2.oKB = c.g.default_avatar;
      com.tencent.mm.modelimage.loader.a.bKl().a(ScanCodeSheetItemLogic.a(this.OMf).aazV, paramImageView1, paramImageView2.bKx());
      AppMethodBeat.o(313287);
      return;
    }
    if (ScanCodeSheetItemLogic.a(this.OMf).aazR == 6)
    {
      paramImageView1.setImageDrawable(bb.m(ScanCodeSheetItemLogic.g(this.OMf), c.g.icons_outlined_wechatpay, ScanCodeSheetItemLogic.g(this.OMf).getResources().getColor(c.b.FG_0)));
      AppMethodBeat.o(313287);
      return;
    }
    if (ScanCodeSheetItemLogic.a(this.OMf).aazR == 5)
    {
      paramImageView1.setImageDrawable(bb.m(ScanCodeSheetItemLogic.g(this.OMf), c.g.icons_outlined_pay_reward_code, ScanCodeSheetItemLogic.g(this.OMf).getResources().getColor(c.b.FG_0)));
      AppMethodBeat.o(313287);
      return;
    }
    if (ScanCodeSheetItemLogic.a(this.OMf).aazR == 9)
    {
      paramImageView2.oKB = c.g.default_avatar_round;
      paramImageView2.nrc = true;
      com.tencent.mm.modelimage.loader.a.bKl().a(ScanCodeSheetItemLogic.a(this.OMf).aazV, paramImageView1, paramImageView2.bKx());
    }
    AppMethodBeat.o(313287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.5
 * JD-Core Version:    0.7.0.1
 */