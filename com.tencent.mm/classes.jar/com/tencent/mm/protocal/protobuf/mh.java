package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mh
  extends com.tencent.mm.bx.a
{
  public mk CIT;
  public String CIU;
  public String CIV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CIT != null)
      {
        paramVarArgs.kX(1, this.CIT.computeSize());
        this.CIT.writeFields(paramVarArgs);
      }
      if (this.CIU != null) {
        paramVarArgs.d(2, this.CIU);
      }
      if (this.CIV != null) {
        paramVarArgs.d(3, this.CIV);
      }
      AppMethodBeat.o(124421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CIT == null) {
        break label430;
      }
    }
    label430:
    for (int i = f.a.a.a.kW(1, this.CIT.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CIU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CIU);
      }
      i = paramInt;
      if (this.CIV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CIV);
      }
      AppMethodBeat.o(124421);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mh localmh = (mh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124421);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((mk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmh.CIT = ((mk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124421);
          return 0;
        case 2: 
          localmh.CIU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124421);
          return 0;
        }
        localmh.CIV = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(124421);
        return 0;
      }
      AppMethodBeat.o(124421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mh
 * JD-Core Version:    0.7.0.1
 */