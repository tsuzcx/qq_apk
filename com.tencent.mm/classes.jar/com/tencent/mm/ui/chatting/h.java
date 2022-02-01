package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.g;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/ChattingCheckUtil;", "", "()V", "TAG", "", "checkIfExceedSingleFileLimit", "", "selectItems", "", "Lcom/tencent/mm/storage/MsgInfo;", "maxSingleFileSize", "", "checkIfOverRecordMsgLimit", "maxGroupSize", "sumSelectedMsgFileSize", "app_release"})
public final class h
{
  public static final h JUT;
  private static final String TAG = "MicroMsg.ChattingEditModeRetransmitMsg";
  
  static
  {
    AppMethodBeat.i(188269);
    JUT = new h();
    TAG = "MicroMsg.ChattingEditModeRetransmitMsg";
    AppMethodBeat.o(188269);
  }
  
  public static boolean g(List<? extends bv> paramList, long paramLong)
  {
    AppMethodBeat.i(188267);
    d.g.b.p.h(paramList, "selectItems");
    long l = 0L;
    paramList = paramList.iterator();
    Object localObject1;
    if (paramList.hasNext())
    {
      localObject1 = (bv)paramList.next();
      if ((((bv)localObject1).cyG()) || (((bv)localObject1).cyI()))
      {
        localObject1 = u.Ia(((bv)localObject1).Wb());
        if (localObject1 == null) {
          break label514;
        }
      }
    }
    label514:
    for (int i = ((s)localObject1).aIw();; i = 0)
    {
      l += i;
      ae.d(TAG, "sumSelectedMsgFileSize, videoSize:%s", new Object[] { Integer.valueOf(i) });
      break;
      if (((bv)localObject1).ftg())
      {
        localObject1 = q.aIX().F(((bv)localObject1).Wa(), ((bv)localObject1).VY());
        d.g.b.p.g(localObject1, "img");
        l += ((g)localObject1).aIw();
        ae.d(TAG, "sumSelectedMsgFileSize, imgSize:%s", new Object[] { Integer.valueOf(((g)localObject1).aIw()) });
        break;
      }
      if (!((bv)localObject1).cVH()) {
        break;
      }
      localObject1 = k.b.zb(((bv)localObject1).getContent());
      if ((localObject1 != null) && (((k.b)localObject1).type == 6))
      {
        l += ((k.b)localObject1).hCC;
        ae.d(TAG, "sumSelectedMsgFileSize, fileSize:%s", new Object[] { Integer.valueOf(((k.b)localObject1).hCC) });
        break;
      }
      if ((localObject1 == null) || ((((k.b)localObject1).type != 24) && (((k.b)localObject1).type != 19))) {
        break;
      }
      localObject1 = com.tencent.mm.plugin.record.b.p.awG(((k.b)localObject1).hDg);
      if (localObject1 != null)
      {
        localObject1 = ((c)localObject1).hFT.iterator();
        i = 0;
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          Object localObject2 = (ajx)((Iterator)localObject1).next();
          d.g.b.p.g(localObject2, "dataItem");
          if (((ajx)localObject2).getDataType() == 17)
          {
            localObject2 = com.tencent.mm.plugin.record.b.p.awG(((ajx)localObject2).fkz());
            if (localObject2 != null)
            {
              localObject2 = ((c)localObject2).hFT.iterator();
              ajx localajx;
              for (j = 0;; j = (int)localajx.fkw() + j)
              {
                k = j;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                localajx = (ajx)((Iterator)localObject2).next();
                d.g.b.p.g(localajx, "innerDataItem");
              }
            }
            int k = 0;
            i += k;
          }
          else
          {
            i = (int)((ajx)localObject2).fkw() + i;
          }
        }
      }
      int j = 0;
      l += j;
      ae.d(TAG, "sumSelectedMsgFileSize, noteSize:%s", new Object[] { Integer.valueOf(j) });
      break;
      ae.i(TAG, "sumSelectedMsgFileSize, totalSize:%s", new Object[] { Long.valueOf(l) });
      if (l > paramLong)
      {
        AppMethodBeat.o(188267);
        return true;
      }
      AppMethodBeat.o(188267);
      return false;
    }
  }
  
  public static boolean h(List<? extends bv> paramList, long paramLong)
  {
    AppMethodBeat.i(188268);
    d.g.b.p.h(paramList, "selectItems");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (bv)paramList.next();
      if (((bv)localObject).cVH())
      {
        localObject = k.b.zb(((bv)localObject).getContent());
        if ((localObject != null) && (((k.b)localObject).type == 6) && (((k.b)localObject).hCC > paramLong))
        {
          ae.w(TAG, "file is too large, %s", new Object[] { bu.sL(((k.b)localObject).hCC) });
          AppMethodBeat.o(188268);
          return true;
        }
      }
    }
    AppMethodBeat.o(188268);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h
 * JD-Core Version:    0.7.0.1
 */