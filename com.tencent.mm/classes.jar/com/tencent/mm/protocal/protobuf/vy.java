package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vy
  extends com.tencent.mm.bw.a
{
  public LinkedList<vz> GnJ;
  public int GnK;
  public cxn GnL;
  public int fNf;
  
  public vy()
  {
    AppMethodBeat.i(43085);
    this.GnJ = new LinkedList();
    AppMethodBeat.o(43085);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43086);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.fNf);
      paramVarArgs.e(2, 8, this.GnJ);
      paramVarArgs.aS(3, this.GnK);
      if (this.GnL != null)
      {
        paramVarArgs.lJ(4, this.GnL.computeSize());
        this.GnL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.fNf) + 0 + f.a.a.a.c(2, 8, this.GnJ) + f.a.a.b.b.a.bz(3, this.GnK);
      paramInt = i;
      if (this.GnL != null) {
        paramInt = i + f.a.a.a.lI(4, this.GnL.computeSize());
      }
      AppMethodBeat.o(43086);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GnJ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      vy localvy = (vy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43086);
        return -1;
      case 1: 
        localvy.fNf = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43086);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new vz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((vz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localvy.GnJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43086);
        return 0;
      case 3: 
        localvy.GnK = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43086);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cxn();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localvy.GnL = ((cxn)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    AppMethodBeat.o(43086);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vy
 * JD-Core Version:    0.7.0.1
 */