package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aol
  extends com.tencent.mm.bx.a
{
  public int Dqm;
  public LinkedList<ady> Dqn;
  public int Dqo;
  public int dtM;
  
  public aol()
  {
    AppMethodBeat.i(153145);
    this.Dqn = new LinkedList();
    AppMethodBeat.o(153145);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153146);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Dqm);
      paramVarArgs.e(2, 8, this.Dqn);
      paramVarArgs.aR(3, this.Dqo);
      paramVarArgs.aR(4, this.dtM);
      AppMethodBeat.o(153146);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.Dqm);
      i = f.a.a.a.c(2, 8, this.Dqn);
      int j = f.a.a.b.b.a.bA(3, this.Dqo);
      int k = f.a.a.b.b.a.bA(4, this.dtM);
      AppMethodBeat.o(153146);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Dqn.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(153146);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aol localaol = (aol)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153146);
        return -1;
      case 1: 
        localaol.Dqm = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(153146);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ady();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ady)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaol.Dqn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153146);
        return 0;
      case 3: 
        localaol.Dqo = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(153146);
        return 0;
      }
      localaol.dtM = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(153146);
      return 0;
    }
    AppMethodBeat.o(153146);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aol
 * JD-Core Version:    0.7.0.1
 */