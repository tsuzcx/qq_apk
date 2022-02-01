package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ekk
  extends com.tencent.mm.cd.a
{
  public dma Umg;
  public int Umh;
  public int Umi;
  public int Umj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198001);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Umg != null)
      {
        paramVarArgs.oE(1, this.Umg.computeSize());
        this.Umg.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Umh);
      paramVarArgs.aY(3, this.Umi);
      paramVarArgs.aY(4, this.Umj);
      AppMethodBeat.o(198001);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Umg == null) {
        break label424;
      }
    }
    label424:
    for (paramInt = g.a.a.a.oD(1, this.Umg.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.Umh);
      int j = g.a.a.b.b.a.bM(3, this.Umi);
      int k = g.a.a.b.b.a.bM(4, this.Umj);
      AppMethodBeat.o(198001);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(198001);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ekk localekk = (ekk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(198001);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dma localdma = new dma();
            if ((localObject != null) && (localObject.length > 0)) {
              localdma.parseFrom((byte[])localObject);
            }
            localekk.Umg = localdma;
            paramInt += 1;
          }
          AppMethodBeat.o(198001);
          return 0;
        case 2: 
          localekk.Umh = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(198001);
          return 0;
        case 3: 
          localekk.Umi = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(198001);
          return 0;
        }
        localekk.Umj = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(198001);
        return 0;
      }
      AppMethodBeat.o(198001);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekk
 * JD-Core Version:    0.7.0.1
 */