package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bop
  extends com.tencent.mm.bx.a
{
  public boq DLX;
  public boo DLY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133177);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DLX == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaReqData");
        AppMethodBeat.o(133177);
        throw paramVarArgs;
      }
      if (this.DLY == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesReqData");
        AppMethodBeat.o(133177);
        throw paramVarArgs;
      }
      if (this.DLX != null)
      {
        paramVarArgs.kX(1, this.DLX.computeSize());
        this.DLX.writeFields(paramVarArgs);
      }
      if (this.DLY != null)
      {
        paramVarArgs.kX(2, this.DLY.computeSize());
        this.DLY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133177);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DLX == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.kW(1, this.DLX.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DLY != null) {
        i = paramInt + f.a.a.a.kW(2, this.DLY.computeSize());
      }
      AppMethodBeat.o(133177);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DLX == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaReqData");
          AppMethodBeat.o(133177);
          throw paramVarArgs;
        }
        if (this.DLY == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesReqData");
          AppMethodBeat.o(133177);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133177);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bop localbop = (bop)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133177);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new boq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((boq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbop.DLX = ((boq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133177);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new boo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((boo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbop.DLY = ((boo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133177);
        return 0;
      }
      AppMethodBeat.o(133177);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bop
 * JD-Core Version:    0.7.0.1
 */