package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.dbo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"partList", "", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "partNum", "", "plugin-mv_release"})
public final class n
{
  public static final String c(dbo paramdbo)
  {
    AppMethodBeat.i(228849);
    if (paramdbo != null)
    {
      paramdbo = paramdbo.TIV;
      if (paramdbo != null)
      {
        paramdbo = paramdbo.objectDesc;
        if (paramdbo != null)
        {
          paramdbo = paramdbo.mvInfo;
          if (paramdbo != null)
          {
            paramdbo = paramdbo.SOB;
            if (paramdbo != null)
            {
              Object localObject = (Iterable)paramdbo;
              paramdbo = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
              localObject = ((Iterable)localObject).iterator();
              if (((Iterator)localObject).hasNext())
              {
                CharSequence localCharSequence = (CharSequence)((bdt)((Iterator)localObject).next()).SOS;
                if ((localCharSequence == null) || (localCharSequence.length() == 0))
                {
                  i = 1;
                  label114:
                  if (i == 0) {
                    break label139;
                  }
                }
                label139:
                for (int i = 0;; i = 1)
                {
                  paramdbo.add(Integer.valueOf(i));
                  break;
                  i = 0;
                  break label114;
                }
              }
              localObject = j.a((Iterable)paramdbo, (CharSequence)"", null, null, 0, null, null, 62);
              paramdbo = (dbo)localObject;
              if (localObject != null) {
                break label176;
              }
            }
          }
        }
      }
    }
    paramdbo = "";
    label176:
    AppMethodBeat.o(228849);
    return paramdbo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.n
 * JD-Core Version:    0.7.0.1
 */