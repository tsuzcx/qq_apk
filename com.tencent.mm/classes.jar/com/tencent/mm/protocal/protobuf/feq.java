package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class feq
  extends com.tencent.mm.cd.a
{
  public LinkedList<fdb> UCV;
  public int UFf;
  public int UFg;
  
  public feq()
  {
    AppMethodBeat.i(115901);
    this.UCV = new LinkedList();
    AppMethodBeat.o(115901);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115902);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UFf);
      paramVarArgs.aY(2, this.UFg);
      paramVarArgs.e(3, 8, this.UCV);
      AppMethodBeat.o(115902);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.UFf);
      i = g.a.a.b.b.a.bM(2, this.UFg);
      int j = g.a.a.a.c(3, 8, this.UCV);
      AppMethodBeat.o(115902);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UCV.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(115902);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      feq localfeq = (feq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115902);
        return -1;
      case 1: 
        localfeq.UFf = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115902);
        return 0;
      case 2: 
        localfeq.UFg = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115902);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        fdb localfdb = new fdb();
        if ((localObject != null) && (localObject.length > 0)) {
          localfdb.parseFrom((byte[])localObject);
        }
        localfeq.UCV.add(localfdb);
        paramInt += 1;
      }
      AppMethodBeat.o(115902);
      return 0;
    }
    AppMethodBeat.o(115902);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.feq
 * JD-Core Version:    0.7.0.1
 */