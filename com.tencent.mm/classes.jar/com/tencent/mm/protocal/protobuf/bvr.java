package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvr
  extends com.tencent.mm.bw.a
{
  public bvs HiG;
  public bvo HiH;
  public bvp HiI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215589);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HiG != null)
      {
        paramVarArgs.lJ(1, this.HiG.computeSize());
        this.HiG.writeFields(paramVarArgs);
      }
      if (this.HiH != null)
      {
        paramVarArgs.lJ(2, this.HiH.computeSize());
        this.HiH.writeFields(paramVarArgs);
      }
      if (this.HiI != null)
      {
        paramVarArgs.lJ(3, this.HiI.computeSize());
        this.HiI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(215589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HiG == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lI(1, this.HiG.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HiH != null) {
        paramInt = i + f.a.a.a.lI(2, this.HiH.computeSize());
      }
      i = paramInt;
      if (this.HiI != null) {
        i = paramInt + f.a.a.a.lI(3, this.HiI.computeSize());
      }
      AppMethodBeat.o(215589);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(215589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvr localbvr = (bvr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(215589);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvr.HiG = ((bvs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215589);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvr.HiH = ((bvo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215589);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbvr.HiI = ((bvp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215589);
        return 0;
      }
      AppMethodBeat.o(215589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvr
 * JD-Core Version:    0.7.0.1
 */