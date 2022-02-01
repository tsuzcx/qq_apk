package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.g;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/ChattingCheckUtil;", "", "()V", "TAG", "", "checkIfExceedSingleFileLimit", "", "selectItems", "", "Lcom/tencent/mm/storage/MsgInfo;", "maxSingleFileSize", "", "checkIfOverRecordMsgLimit", "maxGroupSize", "sumSelectedMsgFileSize", "app_release"})
public final class h
{
  private static final String TAG = "MicroMsg.ChattingEditModeRetransmitMsg";
  public static final h Wzz;
  
  static
  {
    AppMethodBeat.i(282629);
    Wzz = new h();
    TAG = "MicroMsg.ChattingEditModeRetransmitMsg";
    AppMethodBeat.o(282629);
  }
  
  public static boolean g(List<? extends ca> paramList, long paramLong)
  {
    AppMethodBeat.i(282627);
    kotlin.g.b.p.k(paramList, "selectItems");
    long l = 0L;
    paramList = paramList.iterator();
    Object localObject1;
    if (paramList.hasNext())
    {
      localObject1 = (ca)paramList.next();
      if ((((ca)localObject1).dlR()) || (((ca)localObject1).dlT()))
      {
        localObject1 = y.Yk(((ca)localObject1).apK());
        if (localObject1 == null) {
          break label531;
        }
      }
    }
    label531:
    for (int i = ((w)localObject1).blF();; i = 0)
    {
      l += i;
      Log.d(TAG, "sumSelectedMsgFileSize, videoSize:%s", new Object[] { Integer.valueOf(i) });
      break;
      if (((ca)localObject1).hwG())
      {
        localObject1 = q.bmh().C(((ca)localObject1).apJ(), ((ca)localObject1).apH());
        kotlin.g.b.p.j(localObject1, "img");
        l += ((g)localObject1).blF();
        Log.d(TAG, "sumSelectedMsgFileSize, imgSize:%s", new Object[] { Integer.valueOf(((g)localObject1).blF()) });
        break;
      }
      if (((ca)localObject1).erk())
      {
        localObject1 = k.b.OQ(((ca)localObject1).getContent());
        if ((localObject1 != null) && (((k.b)localObject1).type == 6))
        {
          l += ((k.b)localObject1).llX;
          Log.d(TAG, "sumSelectedMsgFileSize, fileSize:%s", new Object[] { Integer.valueOf(((k.b)localObject1).llX) });
          break;
        }
        if ((localObject1 == null) || ((((k.b)localObject1).type != 24) && (((k.b)localObject1).type != 19))) {
          break;
        }
        localObject1 = com.tencent.mm.plugin.record.b.p.aVz(((k.b)localObject1).lmA);
        if (localObject1 != null)
        {
          localObject1 = ((c)localObject1).lpz.iterator();
          i = 0;
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            Object localObject2 = (anm)((Iterator)localObject1).next();
            kotlin.g.b.p.j(localObject2, "dataItem");
            if (((anm)localObject2).getDataType() == 17)
            {
              localObject2 = com.tencent.mm.plugin.record.b.p.aVz(((anm)localObject2).hpv());
              if (localObject2 != null)
              {
                localObject2 = ((c)localObject2).lpz.iterator();
                anm localanm;
                for (j = 0;; j = (int)localanm.hps() + j)
                {
                  k = j;
                  if (!((Iterator)localObject2).hasNext()) {
                    break;
                  }
                  localanm = (anm)((Iterator)localObject2).next();
                  kotlin.g.b.p.j(localanm, "innerDataItem");
                }
              }
              int k = 0;
              i += k;
            }
            else
            {
              i = (int)((anm)localObject2).hps() + i;
            }
          }
        }
        int j = 0;
        l += j;
        Log.d(TAG, "sumSelectedMsgFileSize, noteSize:%s", new Object[] { Integer.valueOf(j) });
        break;
      }
      if (((ca)localObject1).erm()) {
        break;
      }
      ((ca)localObject1).hzy();
      break;
      Log.i(TAG, "sumSelectedMsgFileSize, totalSize:%s", new Object[] { Long.valueOf(l) });
      if (l > paramLong)
      {
        AppMethodBeat.o(282627);
        return true;
      }
      AppMethodBeat.o(282627);
      return false;
    }
  }
  
  public static boolean h(List<? extends ca> paramList, long paramLong)
  {
    AppMethodBeat.i(282628);
    kotlin.g.b.p.k(paramList, "selectItems");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ca)paramList.next();
      if (((ca)localObject).erk())
      {
        localObject = k.b.OQ(((ca)localObject).getContent());
        if ((localObject != null) && (((k.b)localObject).type == 6) && (((k.b)localObject).llX > paramLong))
        {
          Log.w(TAG, "file is too large, %s", new Object[] { Util.getSizeKB(((k.b)localObject).llX) });
          AppMethodBeat.o(282628);
          return true;
        }
      }
    }
    AppMethodBeat.o(282628);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h
 * JD-Core Version:    0.7.0.1
 */