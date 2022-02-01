package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fqh
  extends com.tencent.mm.cd.a
{
  public int SsN;
  public LinkedList<cpu> UOd;
  public int rVx;
  
  public fqh()
  {
    AppMethodBeat.i(196979);
    this.UOd = new LinkedList();
    AppMethodBeat.o(196979);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196998);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SsN);
      paramVarArgs.aY(2, this.rVx);
      paramVarArgs.e(3, 8, this.UOd);
      AppMethodBeat.o(196998);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.SsN);
      i = g.a.a.b.b.a.bM(2, this.rVx);
      int j = g.a.a.a.c(3, 8, this.UOd);
      AppMethodBeat.o(196998);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UOd.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(196998);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fqh localfqh = (fqh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(196998);
        return -1;
      case 1: 
        localfqh.SsN = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(196998);
        return 0;
      case 2: 
        localfqh.rVx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(196998);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        cpu localcpu = new cpu();
        if ((localObject != null) && (localObject.length > 0)) {
          localcpu.parseFrom((byte[])localObject);
        }
        localfqh.UOd.add(localcpu);
        paramInt += 1;
      }
      AppMethodBeat.o(196998);
      return 0;
    }
    AppMethodBeat.o(196998);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqh
 * JD-Core Version:    0.7.0.1
 */