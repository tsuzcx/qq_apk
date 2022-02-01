package com.tencent.mm.plugin.sns.model;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.yt;
import com.tencent.mm.k.i;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class at
{
  long QwR;
  private boolean QwS;
  private int QwT;
  private int QwU;
  LinkedList<Pair<Integer, Integer>> QwV;
  IListener<yt> QwW;
  IListener QwX;
  IListener QwY;
  boolean oZR;
  boolean oZS;
  
  at()
  {
    AppMethodBeat.i(95927);
    this.QwR = 0L;
    this.oZR = false;
    this.oZS = false;
    this.QwS = false;
    this.QwT = 0;
    this.QwU = 1440;
    this.QwV = new LinkedList();
    this.QwW = new SnsPreTimelineService.1(this, com.tencent.mm.app.f.hfK);
    this.QwX = new SnsPreTimelineService.2(this, com.tencent.mm.app.f.hfK);
    this.QwY = new SnsPreTimelineService.3(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(95927);
  }
  
  final boolean hhk()
  {
    AppMethodBeat.i(95928);
    this.QwV.clear();
    Object localObject2 = i.aRC().getValue("SnsImgPreLoadingTimeLimit");
    Object localObject1;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    for (;;)
    {
      Log.i("MicroMsg.SnsPreTimelineService", "preloadLimit:%s", new Object[] { localObject1 });
      if (!Util.isNullOrNil((String)localObject2)) {
        try
        {
          Log.i("MicroMsg.SnsPreTimelineService", "preloadLimit:%s", new Object[] { localObject2 });
          localObject1 = ((String)localObject2).split(";");
          int i = 0;
          while (i < localObject1.length)
          {
            localObject2 = localObject1[i].split("-");
            String[] arrayOfString = localObject2[0].split(":");
            int j = Util.safeParseInt(arrayOfString[0]);
            int k = Util.safeParseInt(arrayOfString[1]);
            localObject2 = localObject2[1].split(":");
            int m = Util.safeParseInt(localObject2[0]);
            int n = Util.safeParseInt(localObject2[1]);
            this.QwV.add(new Pair(Integer.valueOf(k + j * 60), Integer.valueOf(n + m * 60)));
            i += 1;
            continue;
            localObject1 = localObject2;
          }
        }
        catch (Exception localException) {}
      }
    }
    if (Util.isNullOrNil(this.QwV))
    {
      this.QwV.add(new Pair(Integer.valueOf(0), Integer.valueOf(1440)));
      AppMethodBeat.o(95928);
      return false;
    }
    AppMethodBeat.o(95928);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.at
 * JD-Core Version:    0.7.0.1
 */