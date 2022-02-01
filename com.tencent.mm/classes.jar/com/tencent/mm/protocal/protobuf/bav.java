package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bav
  extends cvp
{
  public String CXN;
  public int FtO;
  public String GxL;
  public String GxM;
  public String GxN;
  public String GxO;
  public brx GxP;
  public com.tencent.mm.bx.b GxQ;
  public String GxR;
  public int GxS;
  public String GxT;
  public int GxU;
  public String duW;
  public String msg;
  public int pzg;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108144);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(108144);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ret);
      if (this.msg != null) {
        paramVarArgs.d(3, this.msg);
      }
      paramVarArgs.aS(4, this.FtO);
      if (this.duW != null) {
        paramVarArgs.d(5, this.duW);
      }
      if (this.GxM != null) {
        paramVarArgs.d(6, this.GxM);
      }
      if (this.CXN != null) {
        paramVarArgs.d(7, this.CXN);
      }
      if (this.GxN != null) {
        paramVarArgs.d(8, this.GxN);
      }
      if (this.GxO != null) {
        paramVarArgs.d(9, this.GxO);
      }
      if (this.GxP != null)
      {
        paramVarArgs.lC(10, this.GxP.computeSize());
        this.GxP.writeFields(paramVarArgs);
      }
      if (this.GxQ != null) {
        paramVarArgs.c(11, this.GxQ);
      }
      paramVarArgs.aS(12, this.pzg);
      if (this.GxL != null) {
        paramVarArgs.d(13, this.GxL);
      }
      if (this.GxR != null) {
        paramVarArgs.d(14, this.GxR);
      }
      paramVarArgs.aS(15, this.GxS);
      if (this.GxT != null) {
        paramVarArgs.d(17, this.GxT);
      }
      paramVarArgs.aS(18, this.GxU);
      AppMethodBeat.o(108144);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1362;
      }
    }
    label1362:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ret);
      paramInt = i;
      if (this.msg != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.msg);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.FtO);
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.duW);
      }
      i = paramInt;
      if (this.GxM != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GxM);
      }
      paramInt = i;
      if (this.CXN != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CXN);
      }
      i = paramInt;
      if (this.GxN != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GxN);
      }
      paramInt = i;
      if (this.GxO != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GxO);
      }
      i = paramInt;
      if (this.GxP != null) {
        i = paramInt + f.a.a.a.lB(10, this.GxP.computeSize());
      }
      paramInt = i;
      if (this.GxQ != null) {
        paramInt = i + f.a.a.b.b.a.b(11, this.GxQ);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.pzg);
      paramInt = i;
      if (this.GxL != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.GxL);
      }
      i = paramInt;
      if (this.GxR != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.GxR);
      }
      i += f.a.a.b.b.a.bz(15, this.GxS);
      paramInt = i;
      if (this.GxT != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.GxT);
      }
      i = f.a.a.b.b.a.bz(18, this.GxU);
      AppMethodBeat.o(108144);
      return paramInt + i;
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
          AppMethodBeat.o(108144);
          throw paramVarArgs;
        }
        AppMethodBeat.o(108144);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bav localbav = (bav)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 16: 
        default: 
          AppMethodBeat.o(108144);
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
            localbav.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(108144);
          return 0;
        case 2: 
          localbav.ret = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(108144);
          return 0;
        case 3: 
          localbav.msg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 4: 
          localbav.FtO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(108144);
          return 0;
        case 5: 
          localbav.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 6: 
          localbav.GxM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 7: 
          localbav.CXN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 8: 
          localbav.GxN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 9: 
          localbav.GxO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbav.GxP = ((brx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(108144);
          return 0;
        case 11: 
          localbav.GxQ = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(108144);
          return 0;
        case 12: 
          localbav.pzg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(108144);
          return 0;
        case 13: 
          localbav.GxL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 14: 
          localbav.GxR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(108144);
          return 0;
        case 15: 
          localbav.GxS = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(108144);
          return 0;
        case 17: 
          localbav.GxT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(108144);
          return 0;
        }
        localbav.GxU = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(108144);
        return 0;
      }
      AppMethodBeat.o(108144);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bav
 * JD-Core Version:    0.7.0.1
 */