package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpu
  extends com.tencent.mm.cd.a
{
  public String CPt;
  public LinkedList<fmq> RLp;
  public int rVx;
  
  public cpu()
  {
    AppMethodBeat.i(213785);
    this.RLp = new LinkedList();
    AppMethodBeat.o(213785);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(213792);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CPt != null) {
        paramVarArgs.f(1, this.CPt);
      }
      paramVarArgs.aY(2, this.rVx);
      paramVarArgs.e(3, 8, this.RLp);
      AppMethodBeat.o(213792);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CPt == null) {
        break label380;
      }
    }
    label380:
    for (paramInt = g.a.a.b.b.a.g(1, this.CPt) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.rVx);
      int j = g.a.a.a.c(3, 8, this.RLp);
      AppMethodBeat.o(213792);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RLp.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(213792);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cpu localcpu = (cpu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(213792);
          return -1;
        case 1: 
          localcpu.CPt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(213792);
          return 0;
        case 2: 
          localcpu.rVx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(213792);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fmq localfmq = new fmq();
          if ((localObject != null) && (localObject.length > 0)) {
            localfmq.parseFrom((byte[])localObject);
          }
          localcpu.RLp.add(localfmq);
          paramInt += 1;
        }
        AppMethodBeat.o(213792);
        return 0;
      }
      AppMethodBeat.o(213792);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpu
 * JD-Core Version:    0.7.0.1
 */