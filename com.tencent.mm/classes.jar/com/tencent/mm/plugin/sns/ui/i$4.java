package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

final class i$4
  implements SnsCommentFooter.b
{
  i$4(i parami) {}
  
  public final void abT(String paramString)
  {
    AppMethodBeat.i(38181);
    n localn = (n)this.rFD.rFo.getTag();
    ab.d("MicroMsg.BaseTimeLine", "onCommentSend click");
    if ((paramString == null) || (paramString.trim().equals("")))
    {
      ab.e("MicroMsg.BaseTimeLine", "onCommentSend tosendText is null or empty");
      AppMethodBeat.o(38181);
      return;
    }
    Object localObject = this.rFD.rFo.getCommentInfo();
    SnsObject localSnsObject = ak.q(localn);
    if ((((cds)localObject).xNY == 0) && (((cds)localObject).xOa == 0L)) {}
    com.tencent.mm.modelsns.b localb1;
    int j;
    for (int i = 708;; i = 709)
    {
      localb1 = com.tencent.mm.modelsns.b.lV(i);
      if (localb1.opType != 708) {
        break;
      }
      localb1.uv(com.tencent.mm.plugin.sns.data.i.j(localn)).lY(localn.field_type).de(localn.Ex(32)).uv(localn.csP()).uv(localn.field_userName).lY(localSnsObject.LikeCount).lY(localSnsObject.CommentCount);
      localb1.ake();
      if (this.rFD.rFl != null) {
        this.rFD.rFl.rhS.w(localn);
      }
      j = this.rFD.rFo.getCommentFlag();
      ab.i("MicroMsg.BaseTimeLine", "onCommentSend click %s", new Object[] { Integer.valueOf(j) });
      if (!d.fS(j, 8)) {
        break label533;
      }
      paramString = paramString.substring(this.rFD.rFo.getCommentAtPrefix().length());
      ab.i("MicroMsg.BaseTimeLine", "send atFriend ad timeline comment");
      an.a.a(localn, 16, paramString, this.rFD.rFo.getCommentInfo(), j, 0);
      this.rFD.rkX.W(this.rFD.rFp.scV);
      this.rFD.ctr();
      if (bo.isNullOrNil(i.b(this.rFD))) {
        break label582;
      }
      paramString = i.rFu.iterator();
      do
      {
        if (!paramString.hasNext()) {
          break;
        }
        localObject = (k)paramString.next();
      } while (!i.b(this.rFD).equals(((k)localObject).key));
      ab.d("MicroMsg.BaseTimeLine", "remove ct");
      i.rFu.remove(localObject);
      AppMethodBeat.o(38181);
      return;
    }
    com.tencent.mm.modelsns.b localb2 = localb1.uv(com.tencent.mm.plugin.sns.data.i.j(localn)).lY(localn.field_type).de(localn.Ex(32)).uv(localn.csP()).uv(((cds)localObject).Username);
    if (((cds)localObject).xNY == 0) {}
    for (localObject = ((cds)localObject).xOa;; localObject = ((cds)localObject).xNY)
    {
      localb2.uv((String)localObject).lY(localSnsObject.LikeCount).lY(localSnsObject.CommentCount);
      break;
    }
    label533:
    ab.i("MicroMsg.BaseTimeLine", "send timeline comment");
    if (localn.Ex(32)) {}
    for (i = 8;; i = 2)
    {
      an.a.a(localn, i, paramString, this.rFD.rFo.getCommentInfo(), j, 0);
      break;
    }
    label582:
    AppMethodBeat.o(38181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.4
 * JD-Core Version:    0.7.0.1
 */