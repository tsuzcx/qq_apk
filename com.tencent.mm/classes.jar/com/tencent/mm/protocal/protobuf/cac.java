package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cac
  extends dyl
{
  public int RPp;
  public int RPq;
  public int TiH;
  public int TiI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91499);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RPp);
      paramVarArgs.aY(3, this.RPq);
      paramVarArgs.aY(4, this.TiH);
      paramVarArgs.aY(5, this.TiI);
      AppMethodBeat.o(91499);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.RPp);
      int j = g.a.a.b.b.a.bM(3, this.RPq);
      int k = g.a.a.b.b.a.bM(4, this.TiH);
      int m = g.a.a.b.b.a.bM(5, this.TiI);
      AppMethodBeat.o(91499);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91499);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cac localcac = (cac)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91499);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localcac.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91499);
          return 0;
        case 2: 
          localcac.RPp = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91499);
          return 0;
        case 3: 
          localcac.RPq = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91499);
          return 0;
        case 4: 
          localcac.TiH = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91499);
          return 0;
        }
        localcac.TiI = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91499);
        return 0;
      }
      AppMethodBeat.o(91499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cac
 * JD-Core Version:    0.7.0.1
 */