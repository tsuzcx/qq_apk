package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class afg
  extends com.tencent.mm.bw.a
{
  public int GvE;
  public afh GvF;
  public int GvG;
  public afh GvH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43094);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GvF == null)
      {
        paramVarArgs = new b("Not all required fields were included: NightTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      if (this.GvH == null)
      {
        paramVarArgs = new b("Not all required fields were included: AllDayTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.GvE);
      if (this.GvF != null)
      {
        paramVarArgs.lJ(2, this.GvF.computeSize());
        this.GvF.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GvG);
      if (this.GvH != null)
      {
        paramVarArgs.lJ(4, this.GvH.computeSize());
        this.GvH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GvE) + 0;
      paramInt = i;
      if (this.GvF != null) {
        paramInt = i + f.a.a.a.lI(2, this.GvF.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.GvG);
      paramInt = i;
      if (this.GvH != null) {
        paramInt = i + f.a.a.a.lI(4, this.GvH.computeSize());
      }
      AppMethodBeat.o(43094);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.GvF == null)
      {
        paramVarArgs = new b("Not all required fields were included: NightTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      if (this.GvH == null)
      {
        paramVarArgs = new b("Not all required fields were included: AllDayTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      afg localafg = (afg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43094);
        return -1;
      case 1: 
        localafg.GvE = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43094);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localafg.GvF = ((afh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43094);
        return 0;
      case 3: 
        localafg.GvG = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(43094);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new afh();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((afh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localafg.GvH = ((afh)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    AppMethodBeat.o(43094);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afg
 * JD-Core Version:    0.7.0.1
 */