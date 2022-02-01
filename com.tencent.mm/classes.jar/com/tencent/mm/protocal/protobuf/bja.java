package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bja
  extends com.tencent.mm.bw.a
{
  public dhr EXW;
  public ciw EXX;
  public ciw EXY;
  public String dlQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194015);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EXW != null)
      {
        paramVarArgs.ln(1, this.EXW.computeSize());
        this.EXW.writeFields(paramVarArgs);
      }
      if (this.dlQ != null) {
        paramVarArgs.d(2, this.dlQ);
      }
      if (this.EXX != null)
      {
        paramVarArgs.ln(3, this.EXX.computeSize());
        this.EXX.writeFields(paramVarArgs);
      }
      if (this.EXY != null)
      {
        paramVarArgs.ln(4, this.EXY.computeSize());
        this.EXY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(194015);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EXW == null) {
        break label678;
      }
    }
    label678:
    for (int i = f.a.a.a.lm(1, this.EXW.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlQ);
      }
      i = paramInt;
      if (this.EXX != null) {
        i = paramInt + f.a.a.a.lm(3, this.EXX.computeSize());
      }
      paramInt = i;
      if (this.EXY != null) {
        paramInt = i + f.a.a.a.lm(4, this.EXY.computeSize());
      }
      AppMethodBeat.o(194015);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(194015);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bja localbja = (bja)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194015);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbja.EXW = ((dhr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194015);
          return 0;
        case 2: 
          localbja.dlQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194015);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ciw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ciw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbja.EXX = ((ciw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194015);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ciw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ciw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbja.EXY = ((ciw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194015);
        return 0;
      }
      AppMethodBeat.o(194015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bja
 * JD-Core Version:    0.7.0.1
 */