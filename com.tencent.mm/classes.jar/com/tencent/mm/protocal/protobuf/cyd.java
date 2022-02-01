package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyd
  extends com.tencent.mm.cd.a
{
  public int CqV;
  public cyc TGC;
  public int TGD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(240698);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CqV);
      if (this.TGC != null)
      {
        paramVarArgs.oE(2, this.TGC.computeSize());
        this.TGC.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.TGD);
      AppMethodBeat.o(240698);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.CqV) + 0;
      paramInt = i;
      if (this.TGC != null) {
        paramInt = i + g.a.a.a.oD(2, this.TGC.computeSize());
      }
      i = g.a.a.b.b.a.bM(3, this.TGD);
      AppMethodBeat.o(240698);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(240698);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      cyd localcyd = (cyd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(240698);
        return -1;
      case 1: 
        localcyd.CqV = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(240698);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cyc localcyc = new cyc();
          if ((localObject != null) && (localObject.length > 0)) {
            localcyc.parseFrom((byte[])localObject);
          }
          localcyd.TGC = localcyc;
          paramInt += 1;
        }
        AppMethodBeat.o(240698);
        return 0;
      }
      localcyd.TGD = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(240698);
      return 0;
    }
    AppMethodBeat.o(240698);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyd
 * JD-Core Version:    0.7.0.1
 */