package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aio
  extends com.tencent.mm.bv.a
{
  public String xad;
  public qf xaj;
  public String xak;
  public boolean xal;
  public int xam;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89091);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xaj != null)
      {
        paramVarArgs.iQ(1, this.xaj.computeSize());
        this.xaj.writeFields(paramVarArgs);
      }
      if (this.xad != null) {
        paramVarArgs.e(2, this.xad);
      }
      if (this.xak != null) {
        paramVarArgs.e(3, this.xak);
      }
      paramVarArgs.aS(4, this.xal);
      paramVarArgs.aO(5, this.xam);
      AppMethodBeat.o(89091);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xaj == null) {
        break label518;
      }
    }
    label518:
    for (int i = e.a.a.a.iP(1, this.xaj.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xad != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xad);
      }
      i = paramInt;
      if (this.xak != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xak);
      }
      paramInt = e.a.a.b.b.a.eW(4);
      int j = e.a.a.b.b.a.bl(5, this.xam);
      AppMethodBeat.o(89091);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89091);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aio localaio = (aio)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89091);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((qf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaio.xaj = ((qf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89091);
          return 0;
        case 2: 
          localaio.xad = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89091);
          return 0;
        case 3: 
          localaio.xak = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89091);
          return 0;
        case 4: 
          localaio.xal = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(89091);
          return 0;
        }
        localaio.xam = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89091);
        return 0;
      }
      AppMethodBeat.o(89091);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aio
 * JD-Core Version:    0.7.0.1
 */