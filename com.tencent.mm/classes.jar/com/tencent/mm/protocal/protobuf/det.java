package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class det
  extends cvp
{
  public String GRx;
  public String HsU;
  public String HsV;
  public String HsW;
  public int Htg;
  public int Hth;
  public int Hti;
  public b Htj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117928);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HsU != null) {
        paramVarArgs.d(2, this.HsU);
      }
      paramVarArgs.aS(3, this.Htg);
      paramVarArgs.aS(4, this.Hth);
      if (this.HsV != null) {
        paramVarArgs.d(5, this.HsV);
      }
      if (this.HsW != null) {
        paramVarArgs.d(6, this.HsW);
      }
      paramVarArgs.aS(7, this.Hti);
      if (this.GRx != null) {
        paramVarArgs.d(8, this.GRx);
      }
      if (this.Htj != null) {
        paramVarArgs.c(9, this.Htj);
      }
      AppMethodBeat.o(117928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HsU != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HsU);
      }
      i = i + f.a.a.b.b.a.bz(3, this.Htg) + f.a.a.b.b.a.bz(4, this.Hth);
      paramInt = i;
      if (this.HsV != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HsV);
      }
      i = paramInt;
      if (this.HsW != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HsW);
      }
      i += f.a.a.b.b.a.bz(7, this.Hti);
      paramInt = i;
      if (this.GRx != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GRx);
      }
      i = paramInt;
      if (this.Htj != null) {
        i = paramInt + f.a.a.b.b.a.b(9, this.Htj);
      }
      AppMethodBeat.o(117928);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117928);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        det localdet = (det)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117928);
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
            localdet.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117928);
          return 0;
        case 2: 
          localdet.HsU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 3: 
          localdet.Htg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117928);
          return 0;
        case 4: 
          localdet.Hth = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117928);
          return 0;
        case 5: 
          localdet.HsV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 6: 
          localdet.HsW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 7: 
          localdet.Hti = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117928);
          return 0;
        case 8: 
          localdet.GRx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117928);
          return 0;
        }
        localdet.Htj = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(117928);
        return 0;
      }
      AppMethodBeat.o(117928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.det
 * JD-Core Version:    0.7.0.1
 */