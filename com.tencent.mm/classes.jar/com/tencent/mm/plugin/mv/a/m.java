package com.tencent.mm.plugin.mv.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.csp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"partList", "", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "partNum", "", "plugin-mv_release"})
public final class m
{
  public static final String e(csp paramcsp)
  {
    AppMethodBeat.i(258843);
    if (paramcsp != null)
    {
      paramcsp = paramcsp.MxE;
      if (paramcsp != null)
      {
        paramcsp = paramcsp.objectDesc;
        if (paramcsp != null)
        {
          paramcsp = paramcsp.mvInfo;
          if (paramcsp != null)
          {
            paramcsp = paramcsp.LId;
            if (paramcsp != null)
            {
              Object localObject = (Iterable)paramcsp;
              paramcsp = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
              localObject = ((Iterable)localObject).iterator();
              if (((Iterator)localObject).hasNext())
              {
                CharSequence localCharSequence = (CharSequence)((axz)((Iterator)localObject).next()).LIm;
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
                  paramcsp.add(Integer.valueOf(i));
                  break;
                  i = 0;
                  break label114;
                }
              }
              localObject = j.a((Iterable)paramcsp, (CharSequence)"", null, null, 0, null, null, 62);
              paramcsp = (csp)localObject;
              if (localObject != null) {
                break label176;
              }
            }
          }
        }
      }
    }
    paramcsp = "";
    label176:
    AppMethodBeat.o(258843);
    return paramcsp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.m
 * JD-Core Version:    0.7.0.1
 */