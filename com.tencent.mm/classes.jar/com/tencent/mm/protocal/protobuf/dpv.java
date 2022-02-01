package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpv
  extends com.tencent.mm.bw.a
{
  public int FXb;
  public dpz FXc;
  public dpx FXd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176153);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FXb);
      if (this.FXc != null)
      {
        paramVarArgs.ln(2, this.FXc.computeSize());
        this.FXc.writeFields(paramVarArgs);
      }
      if (this.FXd != null)
      {
        paramVarArgs.ln(3, this.FXd.computeSize());
        this.FXd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(176153);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FXb) + 0;
      paramInt = i;
      if (this.FXc != null) {
        paramInt = i + f.a.a.a.lm(2, this.FXc.computeSize());
      }
      i = paramInt;
      if (this.FXd != null) {
        i = paramInt + f.a.a.a.lm(3, this.FXd.computeSize());
      }
      AppMethodBeat.o(176153);
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
      AppMethodBeat.o(176153);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dpv localdpv = (dpv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176153);
        return -1;
      case 1: 
        localdpv.FXb = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(176153);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dpz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdpv.FXc = ((dpz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176153);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dpx();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dpx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdpv.FXd = ((dpx)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(176153);
      return 0;
    }
    AppMethodBeat.o(176153);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpv
 * JD-Core Version:    0.7.0.1
 */