package com.tencent.mm.ui.chatting.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.g;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;

public final class b$c
{
  public bi cEE;
  public String imagePath;
  boolean mCu;
  public long timeStamp;
  public int type;
  public b.c.a zDI;
  
  public b$c(long paramLong)
  {
    AppMethodBeat.i(31134);
    this.type = 0;
    this.zDI = new b.c.a(this);
    this.timeStamp = paramLong;
    this.type = 2147483647;
    AppMethodBeat.o(31134);
  }
  
  public b$c(bi parambi)
  {
    AppMethodBeat.i(31133);
    this.type = 0;
    this.zDI = new b.c.a(this);
    this.cEE = parambi;
    Object localObject1;
    Object localObject2;
    if ((parambi.byj()) || (parambi.byk()))
    {
      this.mCu = true;
      com.tencent.mm.modelvideo.o.alE();
      localObject1 = t.vg(parambi.field_imgPath);
      localObject2 = u.vr(parambi.field_imgPath);
      if (localObject2 != null) {
        this.zDI.mCw = bo.mH(((s)localObject2).fXx);
      }
      this.zDI.cEn = j.b.ab(parambi.field_content, parambi.field_reserved);
    }
    for (;;)
    {
      Object localObject3 = localObject1;
      if (parambi.dxV())
      {
        Object localObject4 = j.b.mY(parambi.field_content);
        localObject3 = null;
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject2 = localObject3;
          if (((j.b)localObject4).cmN != null)
          {
            localObject2 = localObject3;
            if (((j.b)localObject4).cmN.length() > 0)
            {
              localObject4 = al.aUJ().alo(((j.b)localObject4).cmN);
              localObject2 = localObject3;
              if (localObject4 != null) {
                localObject2 = ((b)localObject4).field_fileFullPath;
              }
            }
          }
        }
        localObject3 = localObject1;
        if (localObject2 != null) {
          localObject3 = localObject2;
        }
      }
      this.imagePath = localObject3;
      this.timeStamp = parambi.field_createTime;
      AppMethodBeat.o(31133);
      return;
      localObject2 = com.tencent.mm.at.o.ahC().c(parambi.field_imgPath, false, false);
      localObject1 = localObject2;
      if (!bo.isNullOrNil((String)localObject2))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).endsWith("hd"))
        {
          localObject1 = localObject2;
          if (e.cN((String)localObject2 + "hd")) {
            localObject1 = (String)localObject2 + "hd";
          }
        }
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(31132);
    if ((this.cEE != null) && ((paramObject instanceof bi)) && (paramObject != null))
    {
      if (this.cEE.field_msgId == ((bi)paramObject).field_msgId)
      {
        AppMethodBeat.o(31132);
        return true;
      }
      AppMethodBeat.o(31132);
      return false;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(31132);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b.c
 * JD-Core Version:    0.7.0.1
 */