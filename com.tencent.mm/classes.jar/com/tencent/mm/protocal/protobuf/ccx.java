package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccx
  extends com.tencent.mm.bw.a
{
  public bpj FWx;
  public px FWy;
  public ccw FWz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133180);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FWx != null)
      {
        paramVarArgs.lJ(1, this.FWx.computeSize());
        this.FWx.writeFields(paramVarArgs);
      }
      if (this.FWz != null)
      {
        paramVarArgs.lJ(2, this.FWz.computeSize());
        this.FWz.writeFields(paramVarArgs);
      }
      if (this.FWy != null)
      {
        paramVarArgs.lJ(3, this.FWy.computeSize());
        this.FWy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133180);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FWx == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lI(1, this.FWx.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FWz != null) {
        paramInt = i + f.a.a.a.lI(2, this.FWz.computeSize());
      }
      i = paramInt;
      if (this.FWy != null) {
        i = paramInt + f.a.a.a.lI(3, this.FWy.computeSize());
      }
      AppMethodBeat.o(133180);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(133180);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ccx localccx = (ccx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133180);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccx.FWx = ((bpj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133180);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccx.FWz = ((ccw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133180);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new px();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((px)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localccx.FWy = ((px)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccx
 * JD-Core Version:    0.7.0.1
 */