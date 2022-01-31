package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class i$3
  implements SnsCommentFooter.c
{
  i$3(i parami) {}
  
  public final void OZ(String paramString)
  {
    n localn = (n)this.oNT.oNF.getTag();
    y.d("MicroMsg.BaseTimeLine", "onCommentSend click");
    label45:
    Object localObject;
    bto localbto;
    label87:
    com.tencent.mm.modelsns.b localb1;
    if ((paramString == null) || (paramString.trim().equals("")))
    {
      y.e("MicroMsg.BaseTimeLine", "onCommentSend tosendText is null or empty");
      return;
    }
    else
    {
      localObject = this.oNT.oNF.getCommentInfo();
      localbto = aj.q(localn);
      if ((((btd)localObject).tJu != 0) || (((btd)localObject).tJx != 0L)) {
        break label366;
      }
      i = 708;
      localb1 = com.tencent.mm.modelsns.b.jd(i);
      if (localb1.opType != 708) {
        break label373;
      }
      localb1.ni(com.tencent.mm.plugin.sns.data.i.j(localn)).jg(localn.field_type).cb(localn.yr(32)).ni(localn.bGM()).ni(localn.field_userName).jg(localbto.tJW).jg(localbto.tJZ);
      localb1.QX();
      if (this.oNT.oNC != null) {
        this.oNT.oNC.ota.x(localn);
      }
      if (!localn.yr(32)) {
        break label497;
      }
    }
    label366:
    label497:
    for (int i = this.oNT.oNF.getCommentFlag();; i = 0)
    {
      if (i != 8) {
        break label502;
      }
      am.a.a(localn, 16, paramString.substring(this.oNT.oNF.getCommentAtPrefix().length()), this.oNT.oNF.getCommentInfo(), i, 0);
      this.oNT.owd.N(this.oNT.oNG.pks);
      this.oNT.bHn();
      if (bk.bl(i.b(this.oNT))) {
        break label45;
      }
      paramString = i.oNL.iterator();
      if (!paramString.hasNext()) {
        break label45;
      }
      localObject = (k)paramString.next();
      if (!i.b(this.oNT).equals(((k)localObject).key)) {
        break;
      }
      y.d("MicroMsg.BaseTimeLine", "remove ct");
      i.oNL.remove(localObject);
      return;
      i = 709;
      break label87;
      label373:
      com.tencent.mm.modelsns.b localb2 = localb1.ni(com.tencent.mm.plugin.sns.data.i.j(localn)).jg(localn.field_type).cb(localn.yr(32)).ni(localn.bGM()).ni(((btd)localObject).sxM);
      if (((btd)localObject).tJu == 0) {}
      for (localObject = ((btd)localObject).tJx;; localObject = ((btd)localObject).tJu)
      {
        localb2.ni((String)localObject).jg(localbto.tJW).jg(localbto.tJZ);
        break;
      }
    }
    label502:
    if (localn.yr(32)) {}
    for (int j = 8;; j = 2)
    {
      am.a.a(localn, j, paramString, this.oNT.oNF.getCommentInfo(), i, 0);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.3
 * JD-Core Version:    0.7.0.1
 */