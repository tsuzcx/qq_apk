package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbw
  extends cvc
{
  public int GyH;
  public int GyI;
  public String GyJ;
  public int GyK;
  public String nDo;
  public int xcK;
  public int xcL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152570);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      paramVarArgs.aS(3, this.GyH);
      paramVarArgs.aS(4, this.GyI);
      if (this.GyJ != null) {
        paramVarArgs.d(5, this.GyJ);
      }
      paramVarArgs.aS(6, this.xcK);
      paramVarArgs.aS(7, this.xcL);
      paramVarArgs.aS(8, this.GyK);
      AppMethodBeat.o(152570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nDo);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GyH) + f.a.a.b.b.a.bz(4, this.GyI);
      paramInt = i;
      if (this.GyJ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GyJ);
      }
      i = f.a.a.b.b.a.bz(6, this.xcK);
      int j = f.a.a.b.b.a.bz(7, this.xcL);
      int k = f.a.a.b.b.a.bz(8, this.GyK);
      AppMethodBeat.o(152570);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152570);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbw localbbw = (bbw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152570);
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
            localbbw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152570);
          return 0;
        case 2: 
          localbbw.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152570);
          return 0;
        case 3: 
          localbbw.GyH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152570);
          return 0;
        case 4: 
          localbbw.GyI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152570);
          return 0;
        case 5: 
          localbbw.GyJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152570);
          return 0;
        case 6: 
          localbbw.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152570);
          return 0;
        case 7: 
          localbbw.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152570);
          return 0;
        }
        localbbw.GyK = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152570);
        return 0;
      }
      AppMethodBeat.o(152570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbw
 * JD-Core Version:    0.7.0.1
 */