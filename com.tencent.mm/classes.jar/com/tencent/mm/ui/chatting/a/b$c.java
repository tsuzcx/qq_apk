package com.tencent.mm.ui.chatting.a;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.g;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;

public final class b$c
{
  public bi bWO;
  public String imagePath;
  boolean khM;
  public long timeStamp;
  public int type = 0;
  public b.c.a vom = new b.c.a(this);
  
  public b$c(long paramLong)
  {
    this.timeStamp = paramLong;
    this.type = 2147483647;
  }
  
  public b$c(bi parambi)
  {
    this.bWO = parambi;
    Object localObject1;
    Object localObject2;
    if ((parambi.aRQ()) || (parambi.aRR()))
    {
      this.khM = true;
      com.tencent.mm.modelvideo.o.Sr();
      localObject1 = t.nT(parambi.field_imgPath);
      localObject2 = u.oe(parambi.field_imgPath);
      if (localObject2 != null) {
        this.vom.khO = bk.jL(((s)localObject2).eHH);
      }
      this.vom.bWy = g.a.M(parambi.field_content, parambi.field_reserved);
    }
    for (;;)
    {
      Object localObject3 = localObject1;
      if (parambi.cvr())
      {
        Object localObject4 = g.a.gp(parambi.field_content);
        localObject3 = null;
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject2 = localObject3;
          if (((g.a)localObject4).bFE != null)
          {
            localObject2 = localObject3;
            if (((g.a)localObject4).bFE.length() > 0)
            {
              localObject4 = ap.avh().VQ(((g.a)localObject4).bFE);
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
      return;
      localObject2 = com.tencent.mm.as.o.OJ().b(parambi.field_imgPath, false, false);
      localObject1 = localObject2;
      if (!bk.bl((String)localObject2))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).endsWith("hd"))
        {
          localObject1 = localObject2;
          if (e.bK((String)localObject2 + "hd")) {
            localObject1 = (String)localObject2 + "hd";
          }
        }
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((this.bWO != null) && ((paramObject instanceof bi)) && (paramObject != null)) {
      return this.bWO.field_msgId == ((bi)paramObject).field_msgId;
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b.c
 * JD-Core Version:    0.7.0.1
 */