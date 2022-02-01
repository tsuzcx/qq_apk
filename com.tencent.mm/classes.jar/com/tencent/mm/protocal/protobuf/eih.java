package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eih
  extends com.tencent.mm.bx.a
{
  public eic HSF;
  public String HSV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153343);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HSF != null)
      {
        paramVarArgs.lC(1, this.HSF.computeSize());
        this.HSF.writeFields(paramVarArgs);
      }
      if (this.HSV != null) {
        paramVarArgs.d(2, this.HSV);
      }
      AppMethodBeat.o(153343);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HSF == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.a.lB(1, this.HSF.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HSV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HSV);
      }
      AppMethodBeat.o(153343);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153343);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eih localeih = (eih)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153343);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eic();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((eic)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeih.HSF = ((eic)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153343);
          return 0;
        }
        localeih.HSV = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(153343);
        return 0;
      }
      AppMethodBeat.o(153343);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eih
 * JD-Core Version:    0.7.0.1
 */