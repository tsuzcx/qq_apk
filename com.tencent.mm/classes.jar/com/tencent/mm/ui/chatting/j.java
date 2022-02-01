package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.modelimage.h;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.record.model.q;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/ChattingCheckUtil;", "", "()V", "TAG", "", "checkIfExceedSingleFileLimit", "", "selectItems", "", "Lcom/tencent/mm/storage/MsgInfo;", "maxSingleFileSize", "", "checkIfOverRecordMsgLimit", "maxGroupSize", "sumSelectedMsgFileSize", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  private static final String TAG;
  public static final j aegW;
  
  static
  {
    AppMethodBeat.i(253910);
    aegW = new j();
    TAG = "MicroMsg.ChattingEditModeRetransmitMsg";
    AppMethodBeat.o(253910);
  }
  
  public static boolean i(List<? extends cc> paramList, long paramLong)
  {
    AppMethodBeat.i(253903);
    s.u(paramList, "selectItems");
    Iterator localIterator = paramList.iterator();
    long l1 = 0L;
    int i;
    if (localIterator.hasNext())
    {
      paramList = (cc)localIterator.next();
      if ((paramList.dSH()) || (paramList.dSJ()))
      {
        paramList = ab.Qo(paramList.field_imgPath);
        if (paramList == null) {
          break label547;
        }
        i = paramList.osy;
        if (!ab.bOG()) {
          break label542;
        }
        paramList = ab.Qo(paramList.oYk);
      }
    }
    for (;;)
    {
      l1 = i + l1;
      Log.d(TAG, "sumSelectedMsgFileSize, videoSize:%s", new Object[] { Integer.valueOf(i) });
      if (paramList != null)
      {
        l1 += paramList.osy;
        Log.d(TAG, "sumSelectedMsgFileSize, after add origin videoSize:%s", new Object[] { Long.valueOf(l1) });
        break;
        long l2;
        if (paramList.iYk())
        {
          paramList = r.bKa().G(paramList.field_talker, paramList.field_msgSvrId);
          l2 = paramList.osy;
          Log.d(TAG, "sumSelectedMsgFileSize, imgSize:%s", new Object[] { Integer.valueOf(paramList.osy) });
          l1 = l2 + l1;
          break;
        }
        if (paramList.fxR())
        {
          paramList = k.b.Hf(paramList.field_content);
          if ((paramList != null) && (paramList.type == 6))
          {
            l2 = paramList.nRd;
            Log.d(TAG, "sumSelectedMsgFileSize, fileSize:%s", new Object[] { Integer.valueOf(paramList.nRd) });
            l1 = l2 + l1;
            break;
          }
          if ((paramList == null) || ((paramList.type != 24) && (paramList.type != 19))) {
            break;
          }
          paramList = q.aSH(paramList.nRF);
          if (paramList != null)
          {
            paramList = paramList.nUC.iterator();
            i = 0;
            for (;;)
            {
              j = i;
              if (!paramList.hasNext()) {
                break;
              }
              Object localObject = (arf)paramList.next();
              if (((arf)localObject).dataType == 17)
              {
                localObject = q.aSH(((arf)localObject).ZzO);
                if (localObject != null)
                {
                  localObject = ((c)localObject).nUC.iterator();
                  for (j = 0;; j = (int)((arf)((Iterator)localObject).next()).Zza + j)
                  {
                    k = j;
                    if (!((Iterator)localObject).hasNext()) {
                      break;
                    }
                  }
                }
                int k = 0;
                i += k;
              }
              else
              {
                i = (int)((arf)localObject).Zza + i;
              }
            }
          }
          int j = 0;
          l2 = j;
          Log.d(TAG, "sumSelectedMsgFileSize, noteSize:%s", new Object[] { Integer.valueOf(j) });
          l1 = l2 + l1;
          break;
        }
        if ((paramList.fxT()) || (!paramList.jbB())) {
          break;
        }
        break;
        Log.i(TAG, "sumSelectedMsgFileSize, totalSize:%s", new Object[] { Long.valueOf(l1) });
        if (l1 > paramLong)
        {
          AppMethodBeat.o(253903);
          return true;
        }
        AppMethodBeat.o(253903);
        return false;
      }
      break;
      label542:
      paramList = null;
      continue;
      label547:
      paramList = null;
      i = 0;
    }
  }
  
  public static boolean j(List<? extends cc> paramList, long paramLong)
  {
    AppMethodBeat.i(253907);
    s.u(paramList, "selectItems");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (cc)paramList.next();
      if (((cc)localObject).fxR())
      {
        localObject = k.b.Hf(((fi)localObject).field_content);
        if ((localObject != null) && (((k.b)localObject).type == 6) && (((k.b)localObject).nRd > paramLong))
        {
          Log.w(TAG, "file is too large, %s", new Object[] { Util.getSizeKB(((k.b)localObject).nRd) });
          AppMethodBeat.o(253907);
          return true;
        }
      }
    }
    AppMethodBeat.o(253907);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j
 * JD-Core Version:    0.7.0.1
 */