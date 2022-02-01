package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqw
  extends com.tencent.mm.bx.a
{
  public bvj DOX;
  public String hNI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152628);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hNI != null) {
        paramVarArgs.d(1, this.hNI);
      }
      if (this.DOX != null)
      {
        paramVarArgs.kX(2, this.DOX.computeSize());
        this.DOX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152628);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hNI == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.hNI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DOX != null) {
        i = paramInt + f.a.a.a.kW(2, this.DOX.computeSize());
      }
      AppMethodBeat.o(152628);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152628);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bqw localbqw = (bqw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152628);
          return -1;
        case 1: 
          localbqw.hNI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152628);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bvj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbqw.DOX = ((bvj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152628);
        return 0;
      }
      AppMethodBeat.o(152628);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqw
 * JD-Core Version:    0.7.0.1
 */