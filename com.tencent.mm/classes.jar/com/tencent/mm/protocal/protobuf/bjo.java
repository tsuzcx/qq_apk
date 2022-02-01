package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjo
  extends cvc
{
  public int FqH;
  public int GDS;
  public int xcK;
  public int xcL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74659);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GDS);
      paramVarArgs.aS(3, this.xcK);
      paramVarArgs.aS(4, this.xcL);
      paramVarArgs.aS(5, this.FqH);
      AppMethodBeat.o(74659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GDS);
      int j = f.a.a.b.b.a.bz(3, this.xcK);
      int k = f.a.a.b.b.a.bz(4, this.xcL);
      int m = f.a.a.b.b.a.bz(5, this.FqH);
      AppMethodBeat.o(74659);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(74659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bjo localbjo = (bjo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74659);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjo.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74659);
          return 0;
        case 2: 
          localbjo.GDS = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(74659);
          return 0;
        case 3: 
          localbjo.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(74659);
          return 0;
        case 4: 
          localbjo.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(74659);
          return 0;
        }
        localbjo.FqH = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(74659);
        return 0;
      }
      AppMethodBeat.o(74659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjo
 * JD-Core Version:    0.7.0.1
 */