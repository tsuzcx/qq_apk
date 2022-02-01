package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvp
  extends com.tencent.mm.bx.a
{
  public int Egp;
  public int Enj;
  public LinkedList<cux> Enk;
  public int Enl;
  public int Enm;
  
  public cvp()
  {
    AppMethodBeat.i(125810);
    this.Enk = new LinkedList();
    AppMethodBeat.o(125810);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125811);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Enj);
      paramVarArgs.e(2, 8, this.Enk);
      paramVarArgs.aR(3, this.Enl);
      paramVarArgs.aR(4, this.Egp);
      paramVarArgs.aR(5, this.Enm);
      AppMethodBeat.o(125811);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.Enj);
      i = f.a.a.a.c(2, 8, this.Enk);
      int j = f.a.a.b.b.a.bA(3, this.Enl);
      int k = f.a.a.b.b.a.bA(4, this.Egp);
      int m = f.a.a.b.b.a.bA(5, this.Enm);
      AppMethodBeat.o(125811);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Enk.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125811);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cvp localcvp = (cvp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125811);
        return -1;
      case 1: 
        localcvp.Enj = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125811);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cux();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cux)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcvp.Enk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125811);
        return 0;
      case 3: 
        localcvp.Enl = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125811);
        return 0;
      case 4: 
        localcvp.Egp = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125811);
        return 0;
      }
      localcvp.Enm = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(125811);
      return 0;
    }
    AppMethodBeat.o(125811);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvp
 * JD-Core Version:    0.7.0.1
 */