package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aak
  extends com.tencent.mm.bw.a
{
  public int LlA;
  public LinkedList<aaj> LlB;
  public b LlC;
  public cbh LlD;
  public int Lly;
  public int Llz;
  
  public aak()
  {
    AppMethodBeat.i(143967);
    this.LlB = new LinkedList();
    AppMethodBeat.o(143967);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143968);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Lly);
      paramVarArgs.aM(2, this.Llz);
      paramVarArgs.aM(3, this.LlA);
      paramVarArgs.e(4, 8, this.LlB);
      if (this.LlC != null) {
        paramVarArgs.c(5, this.LlC);
      }
      if (this.LlD != null)
      {
        paramVarArgs.ni(6, this.LlD.computeSize());
        this.LlD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Lly) + 0 + g.a.a.b.b.a.bu(2, this.Llz) + g.a.a.b.b.a.bu(3, this.LlA) + g.a.a.a.c(4, 8, this.LlB);
      paramInt = i;
      if (this.LlC != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.LlC);
      }
      i = paramInt;
      if (this.LlD != null) {
        i = paramInt + g.a.a.a.nh(6, this.LlD.computeSize());
      }
      AppMethodBeat.o(143968);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LlB.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      aak localaak = (aak)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143968);
        return -1;
      case 1: 
        localaak.Lly = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143968);
        return 0;
      case 2: 
        localaak.Llz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143968);
        return 0;
      case 3: 
        localaak.LlA = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143968);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aaj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaak.LlB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143968);
        return 0;
      case 5: 
        localaak.LlC = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(143968);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cbh();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cbh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localaak.LlD = ((cbh)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    AppMethodBeat.o(143968);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aak
 * JD-Core Version:    0.7.0.1
 */