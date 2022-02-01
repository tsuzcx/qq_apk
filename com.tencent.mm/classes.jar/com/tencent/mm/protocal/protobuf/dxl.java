package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxl
  extends cvp
{
  public long GeJ;
  public int HJW;
  public int HJX;
  public int HJY;
  public int HJZ;
  public com.tencent.mm.bx.b HKa;
  public long HyS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125510);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.HyS);
      paramVarArgs.aY(3, this.GeJ);
      paramVarArgs.aS(4, this.HJW);
      paramVarArgs.aS(5, this.HJX);
      paramVarArgs.aS(6, this.HJY);
      paramVarArgs.aS(7, this.HJZ);
      if (this.HKa != null) {
        paramVarArgs.c(8, this.HKa);
      }
      AppMethodBeat.o(125510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.HyS) + f.a.a.b.b.a.p(3, this.GeJ) + f.a.a.b.b.a.bz(4, this.HJW) + f.a.a.b.b.a.bz(5, this.HJX) + f.a.a.b.b.a.bz(6, this.HJY) + f.a.a.b.b.a.bz(7, this.HJZ);
      paramInt = i;
      if (this.HKa != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.HKa);
      }
      AppMethodBeat.o(125510);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125510);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxl localdxl = (dxl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125510);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125510);
          return 0;
        case 2: 
          localdxl.HyS = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125510);
          return 0;
        case 3: 
          localdxl.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125510);
          return 0;
        case 4: 
          localdxl.HJW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125510);
          return 0;
        case 5: 
          localdxl.HJX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125510);
          return 0;
        case 6: 
          localdxl.HJY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125510);
          return 0;
        case 7: 
          localdxl.HJZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125510);
          return 0;
        }
        localdxl.HKa = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(125510);
        return 0;
      }
      AppMethodBeat.o(125510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxl
 * JD-Core Version:    0.7.0.1
 */