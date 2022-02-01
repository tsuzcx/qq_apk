package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dhu
  extends cld
{
  public String CCm;
  public String COP;
  public int COU;
  public int CreateTime;
  public String CxC;
  public cmf Cxx;
  public cmf Cxy;
  public cmf ExR;
  public int uKQ;
  public int uKR;
  public int uKS;
  public int uKX;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152720);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.ExR == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientImgId");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.Cxx == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.Cxy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.uKX);
      if (this.ExR != null)
      {
        paramVarArgs.kX(3, this.ExR.computeSize());
        this.ExR.writeFields(paramVarArgs);
      }
      if (this.Cxx != null)
      {
        paramVarArgs.kX(4, this.Cxx.computeSize());
        this.Cxx.writeFields(paramVarArgs);
      }
      if (this.Cxy != null)
      {
        paramVarArgs.kX(5, this.Cxy.computeSize());
        this.Cxy.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.uKQ);
      paramVarArgs.aR(7, this.uKR);
      paramVarArgs.aR(8, this.uKS);
      paramVarArgs.aR(9, this.CreateTime);
      paramVarArgs.aG(10, this.uKZ);
      if (this.COP != null) {
        paramVarArgs.d(11, this.COP);
      }
      if (this.CCm != null) {
        paramVarArgs.d(12, this.CCm);
      }
      if (this.CxC != null) {
        paramVarArgs.d(13, this.CxC);
      }
      paramVarArgs.aR(14, this.COU);
      AppMethodBeat.o(152720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1462;
      }
    }
    label1462:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.uKX);
      paramInt = i;
      if (this.ExR != null) {
        paramInt = i + f.a.a.a.kW(3, this.ExR.computeSize());
      }
      i = paramInt;
      if (this.Cxx != null) {
        i = paramInt + f.a.a.a.kW(4, this.Cxx.computeSize());
      }
      paramInt = i;
      if (this.Cxy != null) {
        paramInt = i + f.a.a.a.kW(5, this.Cxy.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.uKQ) + f.a.a.b.b.a.bA(7, this.uKR) + f.a.a.b.b.a.bA(8, this.uKS) + f.a.a.b.b.a.bA(9, this.CreateTime) + f.a.a.b.b.a.q(10, this.uKZ);
      paramInt = i;
      if (this.COP != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.COP);
      }
      i = paramInt;
      if (this.CCm != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.CCm);
      }
      paramInt = i;
      if (this.CxC != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.CxC);
      }
      i = f.a.a.b.b.a.bA(14, this.COU);
      AppMethodBeat.o(152720);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.ExR == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientImgId");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.Cxx == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.Cxy == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152720);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhu localdhu = (dhu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152720);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 2: 
          localdhu.uKX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152720);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhu.ExR = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhu.Cxx = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhu.Cxy = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 6: 
          localdhu.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152720);
          return 0;
        case 7: 
          localdhu.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152720);
          return 0;
        case 8: 
          localdhu.uKS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152720);
          return 0;
        case 9: 
          localdhu.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152720);
          return 0;
        case 10: 
          localdhu.uKZ = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(152720);
          return 0;
        case 11: 
          localdhu.COP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152720);
          return 0;
        case 12: 
          localdhu.CCm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152720);
          return 0;
        case 13: 
          localdhu.CxC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152720);
          return 0;
        }
        localdhu.COU = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152720);
        return 0;
      }
      AppMethodBeat.o(152720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhu
 * JD-Core Version:    0.7.0.1
 */