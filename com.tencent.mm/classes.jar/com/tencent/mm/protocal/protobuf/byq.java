package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byq
  extends com.tencent.mm.bw.a
{
  public cgd FnL;
  public double FnM;
  public String text;
  public LinkedList<Double> vFt;
  
  public byq()
  {
    AppMethodBeat.i(118410);
    this.vFt = new LinkedList();
    AppMethodBeat.o(118410);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118411);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.text != null) {
        paramVarArgs.d(1, this.text);
      }
      if (this.FnL != null)
      {
        paramVarArgs.ln(2, this.FnL.computeSize());
        this.FnL.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, this.FnM);
      paramVarArgs.e(4, 4, this.vFt);
      AppMethodBeat.o(118411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.text == null) {
        break label483;
      }
    }
    label483:
    for (paramInt = f.a.a.b.b.a.e(1, this.text) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FnL != null) {
        i = paramInt + f.a.a.a.lm(2, this.FnL.computeSize());
      }
      paramInt = f.a.a.b.b.a.fK(3);
      int j = f.a.a.a.c(4, 4, this.vFt);
      AppMethodBeat.o(118411);
      return i + (paramInt + 8) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vFt.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(118411);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byq localbyq = (byq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118411);
          return -1;
        case 1: 
          localbyq.text = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(118411);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cgd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyq.FnL = ((cgd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118411);
          return 0;
        case 3: 
          localbyq.FnM = Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab());
          AppMethodBeat.o(118411);
          return 0;
        }
        localbyq.vFt.add(Double.valueOf(Double.longBitsToDouble(((f.a.a.a.a)localObject1).LVo.gab())));
        AppMethodBeat.o(118411);
        return 0;
      }
      AppMethodBeat.o(118411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byq
 * JD-Core Version:    0.7.0.1
 */