package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvd
  extends com.tencent.mm.bw.a
{
  public dve GcH;
  public dvf GcI;
  public int yAv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209577);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.yAv);
      if (this.GcH != null)
      {
        paramVarArgs.ln(2, this.GcH.computeSize());
        this.GcH.writeFields(paramVarArgs);
      }
      if (this.GcI != null)
      {
        paramVarArgs.ln(3, this.GcI.computeSize());
        this.GcI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209577);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.yAv) + 0;
      paramInt = i;
      if (this.GcH != null) {
        paramInt = i + f.a.a.a.lm(2, this.GcH.computeSize());
      }
      i = paramInt;
      if (this.GcI != null) {
        i = paramInt + f.a.a.a.lm(3, this.GcI.computeSize());
      }
      AppMethodBeat.o(209577);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(209577);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dvd localdvd = (dvd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209577);
        return -1;
      case 1: 
        localdvd.yAv = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(209577);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dve();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dve)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdvd.GcH = ((dve)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209577);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dvf();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dvf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdvd.GcI = ((dvf)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(209577);
      return 0;
    }
    AppMethodBeat.o(209577);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvd
 * JD-Core Version:    0.7.0.1
 */