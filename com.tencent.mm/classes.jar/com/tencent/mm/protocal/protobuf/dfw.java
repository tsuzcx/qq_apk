package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfw
  extends com.tencent.mm.bw.a
{
  public String DWw;
  public int FPh;
  public acs FPi;
  public acs FPj;
  public int Fyw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91706);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Fyw);
      paramVarArgs.aR(2, this.FPh);
      if (this.DWw != null) {
        paramVarArgs.d(3, this.DWw);
      }
      if (this.FPi != null)
      {
        paramVarArgs.ln(4, this.FPi.computeSize());
        this.FPi.writeFields(paramVarArgs);
      }
      if (this.FPj != null)
      {
        paramVarArgs.ln(5, this.FPj.computeSize());
        this.FPj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91706);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Fyw) + 0 + f.a.a.b.b.a.bx(2, this.FPh);
      paramInt = i;
      if (this.DWw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DWw);
      }
      i = paramInt;
      if (this.FPi != null) {
        i = paramInt + f.a.a.a.lm(4, this.FPi.computeSize());
      }
      paramInt = i;
      if (this.FPj != null) {
        paramInt = i + f.a.a.a.lm(5, this.FPj.computeSize());
      }
      AppMethodBeat.o(91706);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91706);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dfw localdfw = (dfw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91706);
        return -1;
      case 1: 
        localdfw.Fyw = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91706);
        return 0;
      case 2: 
        localdfw.FPh = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91706);
        return 0;
      case 3: 
        localdfw.DWw = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91706);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdfw.FPi = ((acs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91706);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new acs();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((acs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdfw.FPj = ((acs)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91706);
      return 0;
    }
    AppMethodBeat.o(91706);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfw
 * JD-Core Version:    0.7.0.1
 */