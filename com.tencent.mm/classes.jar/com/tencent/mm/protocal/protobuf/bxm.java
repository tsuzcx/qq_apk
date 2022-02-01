package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxm
  extends com.tencent.mm.bw.a
{
  public bkh DYG;
  public oq DYH;
  public bxl DYI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133180);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DYG != null)
      {
        paramVarArgs.ln(1, this.DYG.computeSize());
        this.DYG.writeFields(paramVarArgs);
      }
      if (this.DYI != null)
      {
        paramVarArgs.ln(2, this.DYI.computeSize());
        this.DYI.writeFields(paramVarArgs);
      }
      if (this.DYH != null)
      {
        paramVarArgs.ln(3, this.DYH.computeSize());
        this.DYH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133180);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DYG == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lm(1, this.DYG.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DYI != null) {
        paramInt = i + f.a.a.a.lm(2, this.DYI.computeSize());
      }
      i = paramInt;
      if (this.DYH != null) {
        i = paramInt + f.a.a.a.lm(3, this.DYH.computeSize());
      }
      AppMethodBeat.o(133180);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(133180);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxm localbxm = (bxm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133180);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxm.DYG = ((bkh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133180);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxm.DYI = ((bxl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133180);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new oq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((oq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbxm.DYH = ((oq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133180);
        return 0;
      }
      AppMethodBeat.o(133180);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxm
 * JD-Core Version:    0.7.0.1
 */