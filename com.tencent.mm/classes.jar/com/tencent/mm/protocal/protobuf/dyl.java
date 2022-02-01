package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyl
  extends com.tencent.mm.bw.a
{
  public long GeE;
  public om GeF;
  public int GeG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117950);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.GeE);
      if (this.GeF != null)
      {
        paramVarArgs.ln(2, this.GeF.computeSize());
        this.GeF.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.GeG);
      AppMethodBeat.o(117950);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.GeE) + 0;
      paramInt = i;
      if (this.GeF != null) {
        paramInt = i + f.a.a.a.lm(2, this.GeF.computeSize());
      }
      i = f.a.a.b.b.a.bx(3, this.GeG);
      AppMethodBeat.o(117950);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117950);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dyl localdyl = (dyl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117950);
        return -1;
      case 1: 
        localdyl.GeE = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(117950);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new om();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((om)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyl.GeF = ((om)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117950);
        return 0;
      }
      localdyl.GeG = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(117950);
      return 0;
    }
    AppMethodBeat.o(117950);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyl
 * JD-Core Version:    0.7.0.1
 */