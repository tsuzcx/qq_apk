package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.g;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/ChattingCheckUtil;", "", "()V", "TAG", "", "checkIfExceedSingleFileLimit", "", "selectItems", "", "Lcom/tencent/mm/storage/MsgInfo;", "maxSingleFileSize", "", "checkIfOverRecordMsgLimit", "maxGroupSize", "sumSelectedMsgFileSize", "app_release"})
public final class h
{
  public static final h Pgg;
  private static final String TAG = "MicroMsg.ChattingEditModeRetransmitMsg";
  
  static
  {
    AppMethodBeat.i(231175);
    Pgg = new h();
    TAG = "MicroMsg.ChattingEditModeRetransmitMsg";
    AppMethodBeat.o(231175);
  }
  
  public static boolean h(List<? extends ca> paramList, long paramLong)
  {
    AppMethodBeat.i(231173);
    kotlin.g.b.p.h(paramList, "selectItems");
    long l = 0L;
    paramList = paramList.iterator();
    Object localObject1;
    if (paramList.hasNext())
    {
      localObject1 = (ca)paramList.next();
      if ((((ca)localObject1).cWJ()) || (((ca)localObject1).cWL()))
      {
        localObject1 = u.QN(((ca)localObject1).ajP());
        if (localObject1 == null) {
          break label514;
        }
      }
    }
    label514:
    for (int i = ((s)localObject1).bcq();; i = 0)
    {
      l += i;
      Log.d(TAG, "sumSelectedMsgFileSize, videoSize:%s", new Object[] { Integer.valueOf(i) });
      break;
      if (((ca)localObject1).gAz())
      {
        localObject1 = q.bcR().G(((ca)localObject1).ajO(), ((ca)localObject1).ajM());
        kotlin.g.b.p.g(localObject1, "img");
        l += ((g)localObject1).bcq();
        Log.d(TAG, "sumSelectedMsgFileSize, imgSize:%s", new Object[] { Integer.valueOf(((g)localObject1).bcq()) });
        break;
      }
      if (!((ca)localObject1).dOQ()) {
        break;
      }
      localObject1 = k.b.HD(((ca)localObject1).getContent());
      if ((localObject1 != null) && (((k.b)localObject1).type == 6))
      {
        l += ((k.b)localObject1).iwI;
        Log.d(TAG, "sumSelectedMsgFileSize, fileSize:%s", new Object[] { Integer.valueOf(((k.b)localObject1).iwI) });
        break;
      }
      if ((localObject1 == null) || ((((k.b)localObject1).type != 24) && (((k.b)localObject1).type != 19))) {
        break;
      }
      localObject1 = com.tencent.mm.plugin.record.b.p.aKY(((k.b)localObject1).ixl);
      if (localObject1 != null)
      {
        localObject1 = ((c)localObject1).iAd.iterator();
        i = 0;
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          Object localObject2 = (aml)((Iterator)localObject1).next();
          kotlin.g.b.p.g(localObject2, "dataItem");
          if (((aml)localObject2).getDataType() == 17)
          {
            localObject2 = com.tencent.mm.plugin.record.b.p.aKY(((aml)localObject2).gue());
            if (localObject2 != null)
            {
              localObject2 = ((c)localObject2).iAd.iterator();
              aml localaml;
              for (j = 0;; j = (int)localaml.gub() + j)
              {
                k = j;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                localaml = (aml)((Iterator)localObject2).next();
                kotlin.g.b.p.g(localaml, "innerDataItem");
              }
            }
            int k = 0;
            i += k;
          }
          else
          {
            i = (int)((aml)localObject2).gub() + i;
          }
        }
      }
      int j = 0;
      l += j;
      Log.d(TAG, "sumSelectedMsgFileSize, noteSize:%s", new Object[] { Integer.valueOf(j) });
      break;
      Log.i(TAG, "sumSelectedMsgFileSize, totalSize:%s", new Object[] { Long.valueOf(l) });
      if (l > paramLong)
      {
        AppMethodBeat.o(231173);
        return true;
      }
      AppMethodBeat.o(231173);
      return false;
    }
  }
  
  public static boolean i(List<? extends ca> paramList, long paramLong)
  {
    AppMethodBeat.i(231174);
    kotlin.g.b.p.h(paramList, "selectItems");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ca)paramList.next();
      if (((ca)localObject).dOQ())
      {
        localObject = k.b.HD(((ca)localObject).getContent());
        if ((localObject != null) && (((k.b)localObject).type == 6) && (((k.b)localObject).iwI > paramLong))
        {
          Log.w(TAG, "file is too large, %s", new Object[] { Util.getSizeKB(((k.b)localObject).iwI) });
          AppMethodBeat.o(231174);
          return true;
        }
      }
    }
    AppMethodBeat.o(231174);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h
 * JD-Core Version:    0.7.0.1
 */