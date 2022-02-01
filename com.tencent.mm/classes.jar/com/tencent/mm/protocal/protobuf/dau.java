package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dau
  extends com.tencent.mm.bw.a
{
  public int FJP;
  public dby FJQ;
  public ckv FJR;
  public abt FJS;
  public cha FJT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125802);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FJP);
      if (this.FJQ != null)
      {
        paramVarArgs.ln(2, this.FJQ.computeSize());
        this.FJQ.writeFields(paramVarArgs);
      }
      if (this.FJR != null)
      {
        paramVarArgs.ln(3, this.FJR.computeSize());
        this.FJR.writeFields(paramVarArgs);
      }
      if (this.FJS != null)
      {
        paramVarArgs.ln(4, this.FJS.computeSize());
        this.FJS.writeFields(paramVarArgs);
      }
      if (this.FJT != null)
      {
        paramVarArgs.ln(5, this.FJT.computeSize());
        this.FJT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125802);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FJP) + 0;
      paramInt = i;
      if (this.FJQ != null) {
        paramInt = i + f.a.a.a.lm(2, this.FJQ.computeSize());
      }
      i = paramInt;
      if (this.FJR != null) {
        i = paramInt + f.a.a.a.lm(3, this.FJR.computeSize());
      }
      paramInt = i;
      if (this.FJS != null) {
        paramInt = i + f.a.a.a.lm(4, this.FJS.computeSize());
      }
      i = paramInt;
      if (this.FJT != null) {
        i = paramInt + f.a.a.a.lm(5, this.FJT.computeSize());
      }
      AppMethodBeat.o(125802);
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
      AppMethodBeat.o(125802);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dau localdau = (dau)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125802);
        return -1;
      case 1: 
        localdau.FJP = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125802);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dby();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dby)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdau.FJQ = ((dby)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ckv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ckv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdau.FJR = ((ckv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdau.FJS = ((abt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cha();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cha)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdau.FJT = ((cha)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125802);
      return 0;
    }
    AppMethodBeat.o(125802);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dau
 * JD-Core Version:    0.7.0.1
 */