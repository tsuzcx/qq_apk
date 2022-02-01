package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eyo
  extends com.tencent.mm.bw.a
{
  public int KZk;
  public LinkedList<eyh> LUC;
  public boolean LYI;
  
  public eyo()
  {
    AppMethodBeat.i(32525);
    this.LUC = new LinkedList();
    AppMethodBeat.o(32525);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32526);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.LUC);
      paramVarArgs.aM(2, this.KZk);
      paramVarArgs.cc(3, this.LYI);
      AppMethodBeat.o(32526);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.LUC);
      i = g.a.a.b.b.a.bu(2, this.KZk);
      int j = g.a.a.b.b.a.fS(3);
      AppMethodBeat.o(32526);
      return paramInt + 0 + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LUC.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32526);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eyo localeyo = (eyo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32526);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eyh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eyh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeyo.LUC.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32526);
        return 0;
      case 2: 
        localeyo.KZk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32526);
        return 0;
      }
      localeyo.LYI = ((g.a.a.a.a)localObject1).UbS.yZ();
      AppMethodBeat.o(32526);
      return 0;
    }
    AppMethodBeat.o(32526);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyo
 * JD-Core Version:    0.7.0.1
 */