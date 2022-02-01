package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cnh
  extends cvp
{
  public int GeI;
  public long GeJ;
  public int Hgu;
  public int Hgw;
  public int Hgx;
  public int qel;
  public String qem;
  public int uLN;
  public int uLy;
  public String uLz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32391);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32391);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GeI);
      paramVarArgs.aY(4, this.GeJ);
      paramVarArgs.aS(5, this.Hgw);
      paramVarArgs.aS(6, this.Hgu);
      paramVarArgs.aS(7, this.uLN);
      paramVarArgs.aS(8, this.Hgx);
      paramVarArgs.aS(9, this.qel);
      if (this.qem != null) {
        paramVarArgs.d(10, this.qem);
      }
      paramVarArgs.aS(11, this.uLy);
      if (this.uLz != null) {
        paramVarArgs.d(12, this.uLz);
      }
      AppMethodBeat.o(32391);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label855;
      }
    }
    label855:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(3, this.GeI) + f.a.a.b.b.a.p(4, this.GeJ) + f.a.a.b.b.a.bz(5, this.Hgw) + f.a.a.b.b.a.bz(6, this.Hgu) + f.a.a.b.b.a.bz(7, this.uLN) + f.a.a.b.b.a.bz(8, this.Hgx) + f.a.a.b.b.a.bz(9, this.qel);
      paramInt = i;
      if (this.qem != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.qem);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.uLy);
      paramInt = i;
      if (this.uLz != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.uLz);
      }
      AppMethodBeat.o(32391);
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32391);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32391);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnh localcnh = (cnh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(32391);
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
            localcnh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32391);
          return 0;
        case 3: 
          localcnh.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32391);
          return 0;
        case 4: 
          localcnh.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32391);
          return 0;
        case 5: 
          localcnh.Hgw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32391);
          return 0;
        case 6: 
          localcnh.Hgu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32391);
          return 0;
        case 7: 
          localcnh.uLN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32391);
          return 0;
        case 8: 
          localcnh.Hgx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32391);
          return 0;
        case 9: 
          localcnh.qel = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32391);
          return 0;
        case 10: 
          localcnh.qem = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32391);
          return 0;
        case 11: 
          localcnh.uLy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32391);
          return 0;
        }
        localcnh.uLz = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32391);
        return 0;
      }
      AppMethodBeat.o(32391);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnh
 * JD-Core Version:    0.7.0.1
 */