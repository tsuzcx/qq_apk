package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aau
  extends com.tencent.mm.bw.a
{
  public long Gsg;
  public aew Gsh;
  public afa Gsi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90958);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.Gsg);
      if (this.Gsh != null)
      {
        paramVarArgs.lJ(2, this.Gsh.computeSize());
        this.Gsh.writeFields(paramVarArgs);
      }
      if (this.Gsi != null)
      {
        paramVarArgs.lJ(3, this.Gsi.computeSize());
        this.Gsi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Gsg) + 0;
      paramInt = i;
      if (this.Gsh != null) {
        paramInt = i + f.a.a.a.lI(2, this.Gsh.computeSize());
      }
      i = paramInt;
      if (this.Gsi != null) {
        i = paramInt + f.a.a.a.lI(3, this.Gsi.computeSize());
      }
      AppMethodBeat.o(90958);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aau localaau = (aau)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90958);
        return -1;
      case 1: 
        localaau.Gsg = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(90958);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aew();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aew)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaau.Gsh = ((aew)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90958);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new afa();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((afa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localaau.Gsi = ((afa)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(90958);
      return 0;
    }
    AppMethodBeat.o(90958);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aau
 * JD-Core Version:    0.7.0.1
 */