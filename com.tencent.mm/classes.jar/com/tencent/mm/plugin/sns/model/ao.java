package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.h.a.qn;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class ao
{
  boolean eGA = false;
  boolean eGB = false;
  c otA = new ao.3(this);
  long otu = 0L;
  private boolean otv = false;
  int otw = 0;
  int otx = 1440;
  c<qn> oty = new ao.1(this);
  c otz = new ao.2(this);
  
  final boolean bEg()
  {
    Object localObject = g.AA().getValue("SnsImgPreLoadingTimeLimit");
    y.i("MicroMsg.SnsPreTimelineService", "preloadLimit:%s", new Object[] { localObject });
    if (bk.bl((String)localObject)) {
      return false;
    }
    try
    {
      localObject = ((String)localObject).split("-");
      String[] arrayOfString = localObject[0].split(":");
      int i = bk.ZR(arrayOfString[0]);
      this.otw = (bk.ZR(arrayOfString[1]) + i * 60);
      localObject = localObject[1].split(":");
      i = bk.ZR(localObject[0]);
      this.otx = (bk.ZR(localObject[1]) + i * 60);
      y.d("MicroMsg.SnsPreTimelineService", "preloadLimit:%d-%d", new Object[] { Integer.valueOf(this.otw), Integer.valueOf(this.otx) });
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ao
 * JD-Core Version:    0.7.0.1
 */