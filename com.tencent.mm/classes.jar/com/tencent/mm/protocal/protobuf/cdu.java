package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cdu
  extends cvp
{
  public String Cxi;
  public String Cxj;
  public String Cxk;
  public int Cxl;
  public String Cxm;
  public String Cyu;
  public bvy GXL;
  public String GXM;
  public ajj GXN;
  public int ozR;
  public String ozS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91559);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91559);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      if (this.GXL != null)
      {
        paramVarArgs.lC(4, this.GXL.computeSize());
        this.GXL.writeFields(paramVarArgs);
      }
      if (this.Cxi != null) {
        paramVarArgs.d(5, this.Cxi);
      }
      if (this.Cxj != null) {
        paramVarArgs.d(6, this.Cxj);
      }
      if (this.Cxk != null) {
        paramVarArgs.d(7, this.Cxk);
      }
      paramVarArgs.aS(8, this.Cxl);
      if (this.Cxm != null) {
        paramVarArgs.d(9, this.Cxm);
      }
      if (this.GXM != null) {
        paramVarArgs.d(10, this.GXM);
      }
      if (this.GXN != null)
      {
        paramVarArgs.lC(11, this.GXN.computeSize());
        this.GXN.writeFields(paramVarArgs);
      }
      if (this.Cyu != null) {
        paramVarArgs.d(100, this.Cyu);
      }
      AppMethodBeat.o(91559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1234;
      }
    }
    label1234:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.GXL != null) {
        i = paramInt + f.a.a.a.lB(4, this.GXL.computeSize());
      }
      paramInt = i;
      if (this.Cxi != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Cxi);
      }
      i = paramInt;
      if (this.Cxj != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Cxj);
      }
      paramInt = i;
      if (this.Cxk != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Cxk);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.Cxl);
      paramInt = i;
      if (this.Cxm != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Cxm);
      }
      i = paramInt;
      if (this.GXM != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GXM);
      }
      paramInt = i;
      if (this.GXN != null) {
        paramInt = i + f.a.a.a.lB(11, this.GXN.computeSize());
      }
      i = paramInt;
      if (this.Cyu != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.Cyu);
      }
      AppMethodBeat.o(91559);
      return i;
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
          AppMethodBeat.o(91559);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91559);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdu localcdu = (cdu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91559);
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
            localcdu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 2: 
          localcdu.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91559);
          return 0;
        case 3: 
          localcdu.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdu.GXL = ((bvy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 5: 
          localcdu.Cxi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 6: 
          localcdu.Cxj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 7: 
          localcdu.Cxk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 8: 
          localcdu.Cxl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91559);
          return 0;
        case 9: 
          localcdu.Cxm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 10: 
          localcdu.GXM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdu.GXN = ((ajj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        }
        localcdu.Cyu = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91559);
        return 0;
      }
      AppMethodBeat.o(91559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdu
 * JD-Core Version:    0.7.0.1
 */