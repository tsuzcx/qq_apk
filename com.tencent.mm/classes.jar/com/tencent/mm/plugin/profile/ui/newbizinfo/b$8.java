package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.aj.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.protocal.protobuf.ka;
import com.tencent.mm.protocal.protobuf.kl;
import com.tencent.mm.protocal.protobuf.lg;
import com.tencent.mm.protocal.protobuf.lh;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

final class b$8
  implements w.a
{
  b$8(b paramb, com.tencent.mm.bv.b paramb1) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, m paramm)
  {
    AppMethodBeat.i(153586);
    ab.i("MicroMsg.ContactWidgetNewBizInfo", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (lj)paramb.fsW.fta;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null))
    {
      if (this.pDq == null) {
        break label378;
      }
      if (!this.pDq.equals(this.pDl.pDf.wzJ.wzB.wzC)) {
        break label368;
      }
      this.pDl.pDf.wzJ.wzA.addAll(paramString.wzJ.wzA);
      this.pDl.pDf.wzJ.wzB = paramString.wzJ.wzB;
      if (this.pDq == null) {
        break label414;
      }
      this.pDl.a(this.pDl.pDf.wzJ);
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cZ(this.pDl.contact.field_username, 106);
      label174:
      if ((paramString.wxV & 0x4) == 0) {
        break label441;
      }
      paramb = b.c(4, paramString.wzN);
      if (paramb == null) {
        break label441;
      }
      paramm = (NewBizInfoErrMsgPreference)this.pDl.screen.atx("contact_info_biz_err_msg");
      this.pDl.screen.cl("contact_info_biz_err_msg", false);
      paramm.setErrMsg(paramb);
    }
    for (;;)
    {
      for (;;)
      {
        if ((paramString.wxV & 0x2) != 0)
        {
          paramString = (NewBizInfoHeaderPreference)this.pDl.screen.atx("contact_info_header_newbizinfo");
          paramString.pDD = true;
          if (paramString.ehv != null)
          {
            com.tencent.mm.plugin.brandservice.b.a.a(paramString.ehv, paramString.contact, "", true);
            paramString.ehv.setClickable(false);
          }
        }
        paramString = this.pDl;
        if ((paramString.contact != null) && (paramString.pyd != null) && (paramString.pDf != null) && (paramString.pDf.wzI != null) && (paramString.pDf.wzH != null)) {
          break label529;
        }
        ab.w("MicroMsg.ContactWidgetNewBizInfo", "reportUpdate fail, err");
        this.pDl.isLoading = false;
        AppMethodBeat.o(153586);
        return 0;
        label368:
        ab.e("MicroMsg.ContactWidgetNewBizInfo", "drop err resp");
        break;
        try
        {
          label378:
          this.pDl.pDf.parseFrom(paramString.toByteArray());
        }
        catch (IOException paramb)
        {
          ab.printErrStackTrace("MicroMsg.ContactWidgetNewBizInfo", paramb, "profileInfo.parseFrom", new Object[0]);
        }
      }
      break;
      label414:
      c.b(this.pDl.pDf);
      this.pDl.initActionBar();
      this.pDl.ccd();
      break label174;
      label441:
      if ((paramString.wxV & 0x8) != 0)
      {
        paramb = b.c(8, paramString.wzN);
        if (paramb != null)
        {
          paramm = (NewBizInfoErrMsgPreference)this.pDl.screen.atx("contact_info_biz_err_msg");
          this.pDl.screen.cl("contact_info_biz_err_msg", false);
          paramm.setErrMsg(paramb);
          continue;
        }
      }
      this.pDl.screen.cl("contact_info_biz_err_msg", true);
    }
    label529:
    paramb = paramString.contact.field_username;
    int i = paramString.gyR;
    int j = paramString.pyd.field_type;
    long l = paramString.eaj;
    label574:
    int k;
    int m;
    if (com.tencent.mm.n.a.je(paramString.contact.field_type))
    {
      paramInt1 = 1;
      k = paramString.pDf.wzI.wxQ;
      m = paramString.pDf.wzI.wxR;
      if (paramString.pzH == null) {
        break label763;
      }
    }
    label763:
    for (paramInt2 = paramString.pzH.size();; paramInt2 = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(paramb, i, j, l, paramInt1, k, m, paramInt2, com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.b(paramString.pDf.wzJ), com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(paramString.pDf.wzM), paramString.pDf.wzH.jJA);
      if ((paramString.pDf != null) && (paramString.pDf.wzM != null)) {
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cZ(paramString.contact.field_username, 104);
      }
      if (paramString.pDf != null) {
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cZ(paramString.contact.field_username, 101);
      }
      if ((paramString.pDf == null) || (!paramString.isNormal()) || (paramString.pzH == null) || (paramString.pzH.size() <= 0)) {
        break;
      }
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cZ(paramString.contact.field_username, 105);
      break;
      paramInt1 = 0;
      break label574;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.8
 * JD-Core Version:    0.7.0.1
 */