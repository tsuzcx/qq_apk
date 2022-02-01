package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dkf
  extends cvp
{
  public int FqM;
  public String HtU;
  public int Hvp;
  public long HxY;
  public int HyT;
  public LinkedList<djs> HyU;
  public int HyV;
  public int HyW;
  
  public dkf()
  {
    AppMethodBeat.i(118477);
    this.HyU = new LinkedList();
    AppMethodBeat.o(118477);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118478);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118478);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HtU != null) {
        paramVarArgs.d(2, this.HtU);
      }
      paramVarArgs.aS(3, this.HyT);
      paramVarArgs.e(4, 8, this.HyU);
      paramVarArgs.aS(5, this.HyV);
      paramVarArgs.aS(6, this.HyW);
      paramVarArgs.aS(7, this.Hvp);
      paramVarArgs.aY(8, this.HxY);
      paramVarArgs.aS(9, this.FqM);
      AppMethodBeat.o(118478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HtU != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HtU);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HyT);
      int j = f.a.a.a.c(4, 8, this.HyU);
      int k = f.a.a.b.b.a.bz(5, this.HyV);
      int m = f.a.a.b.b.a.bz(6, this.HyW);
      int n = f.a.a.b.b.a.bz(7, this.Hvp);
      int i1 = f.a.a.b.b.a.p(8, this.HxY);
      int i2 = f.a.a.b.b.a.bz(9, this.FqM);
      AppMethodBeat.o(118478);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HyU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118478);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dkf localdkf = (dkf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118478);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118478);
          return 0;
        case 2: 
          localdkf.HtU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(118478);
          return 0;
        case 3: 
          localdkf.HyT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118478);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkf.HyU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118478);
          return 0;
        case 5: 
          localdkf.HyV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118478);
          return 0;
        case 6: 
          localdkf.HyW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118478);
          return 0;
        case 7: 
          localdkf.Hvp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118478);
          return 0;
        case 8: 
          localdkf.HxY = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(118478);
          return 0;
        }
        localdkf.FqM = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118478);
        return 0;
      }
      AppMethodBeat.o(118478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkf
 * JD-Core Version:    0.7.0.1
 */