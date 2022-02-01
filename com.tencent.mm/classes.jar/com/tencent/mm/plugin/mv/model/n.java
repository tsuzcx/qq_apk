package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.dtf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"partList", "", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "partNum", "", "plugin-mv_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final String c(dtf paramdtf)
  {
    AppMethodBeat.i(286097);
    if (paramdtf == null)
    {
      AppMethodBeat.o(286097);
      return "";
    }
    paramdtf = paramdtf.aaYK;
    if (paramdtf == null)
    {
      AppMethodBeat.o(286097);
      return "";
    }
    paramdtf = paramdtf.objectDesc;
    if (paramdtf == null)
    {
      AppMethodBeat.o(286097);
      return "";
    }
    paramdtf = paramdtf.mvInfo;
    if (paramdtf == null)
    {
      AppMethodBeat.o(286097);
      return "";
    }
    paramdtf = paramdtf.ZWI;
    if (paramdtf == null)
    {
      AppMethodBeat.o(286097);
      return "";
    }
    Object localObject = (Iterable)paramdtf;
    paramdtf = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    if (((Iterator)localObject).hasNext())
    {
      CharSequence localCharSequence = (CharSequence)((boq)((Iterator)localObject).next()).ZWZ;
      if ((localCharSequence == null) || (localCharSequence.length() == 0))
      {
        i = 1;
        label154:
        if (i == 0) {
          break label179;
        }
      }
      label179:
      for (int i = 0;; i = 1)
      {
        paramdtf.add(Integer.valueOf(i));
        break;
        i = 0;
        break label154;
      }
    }
    paramdtf = p.a((Iterable)paramdtf, (CharSequence)"", null, null, 0, null, null, 62);
    if (paramdtf == null)
    {
      AppMethodBeat.o(286097);
      return "";
    }
    AppMethodBeat.o(286097);
    return paramdtf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.n
 * JD-Core Version:    0.7.0.1
 */