package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.protocal.protobuf.fdk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.LinkedList;

public final class m
{
  public static void a(ef paramef, final boolean paramBoolean)
  {
    AppMethodBeat.i(306776);
    if ((paramef == null) || (paramef.YGn == null) || (paramef.YGn.abCT == null))
    {
      AppMethodBeat.o(306776);
      return;
    }
    final String str = com.tencent.mm.platformtools.w.a(paramef.YGn.abCT);
    if (!Util.isNullOrNil(str)) {
      h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(306731);
          String str2;
          try
          {
            str1 = t.uA(m.this.YGn.abCS.Id);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              try
              {
                if ((new ADXml(str).isLandingPagesAd()) && (l.aZJ(str)))
                {
                  i = 0;
                  if (paramBoolean) {
                    i = 6;
                  }
                  Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPages, scene=" + i + ", snsId=" + str1);
                  j.hkB().ay(str, "adxml", i);
                }
              }
              finally
              {
                String str1;
                int i;
                String str3;
                Log.e("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPages, exp=" + localObject1.toString() + ", snsId=" + str2);
                continue;
              }
              try
              {
                str3 = ADXml.getGestureCanvasInfo(str);
                if (l.aZJ(str3))
                {
                  i = 1;
                  if (paramBoolean) {
                    i = 7;
                  }
                  Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPages for gestureAdXml, scene=" + i + ", snsId=" + str1);
                  j.hkB().ay(str3, "adxml", i);
                }
                AppMethodBeat.o(306731);
                return;
              }
              finally
              {
                Log.e("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPages for gestureAdXml, exp=" + localObject2.toString() + ", snsId=" + str2);
                AppMethodBeat.o(306731);
              }
              localException = localException;
              str2 = "";
            }
          }
        }
      });
    }
    AppMethodBeat.o(306776);
  }
  
  public static void bV(LinkedList<SnsObject> paramLinkedList)
  {
    AppMethodBeat.i(306781);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(306781);
      return;
    }
    com.tencent.mm.plugin.sns.storage.w localw = al.hgB();
    int i = 0;
    if (i < paramLinkedList.size())
    {
      Object localObject1 = (SnsObject)paramLinkedList.get(i);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localw.vj(((SnsObject)localObject1).Id);
        if (localObject2 != null)
        {
          localObject1 = ((SnsInfo)localObject2).getTimeLine();
          if (localObject1 != null) {
            break label110;
          }
        }
      }
      label110:
      for (localObject1 = "";; localObject1 = ((TimeLineObject)localObject1).canvasInfo)
      {
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject2 = ((SnsInfo)localObject2).getSnsId();
          h.ahAA.bm(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(306730);
              if (l.aZJ(m.this))
              {
                Log.i("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForSnsObject, snsId=" + this.paw);
                j.hkB().ay(m.this, "adxml", 4);
                AppMethodBeat.o(306730);
                return;
              }
              Log.w("AdLandingPagesPreDownloadResHelper", "preDownloadAdLandingPagesForSnsObject, invalid canvas, snsId=" + this.paw);
              AppMethodBeat.o(306730);
            }
          });
        }
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(306781);
  }
  
  public static void g(LinkedList<ef> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(306772);
    if (paramLinkedList == null)
    {
      AppMethodBeat.o(306772);
      return;
    }
    int i = 0;
    while (i < paramLinkedList.size())
    {
      a((ef)paramLinkedList.get(i), paramBoolean);
      i += 1;
    }
    AppMethodBeat.o(306772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m
 * JD-Core Version:    0.7.0.1
 */