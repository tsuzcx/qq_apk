package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dta
  extends cvp
{
  public int CreateTime;
  public String FAe;
  public String FOH;
  public int FOM;
  public cwt Fvi;
  public cwt Fvj;
  public String Fvn;
  public cwt HFH;
  public int xbr;
  public long xbt;
  public int xcK;
  public int xcL;
  public int xcM;
  
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
      if (this.HFH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientImgId");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.Fvi == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.Fvj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xbr);
      if (this.HFH != null)
      {
        paramVarArgs.lC(3, this.HFH.computeSize());
        this.HFH.writeFields(paramVarArgs);
      }
      if (this.Fvi != null)
      {
        paramVarArgs.lC(4, this.Fvi.computeSize());
        this.Fvi.writeFields(paramVarArgs);
      }
      if (this.Fvj != null)
      {
        paramVarArgs.lC(5, this.Fvj.computeSize());
        this.Fvj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.xcK);
      paramVarArgs.aS(7, this.xcL);
      paramVarArgs.aS(8, this.xcM);
      paramVarArgs.aS(9, this.CreateTime);
      paramVarArgs.aY(10, this.xbt);
      if (this.FOH != null) {
        paramVarArgs.d(11, this.FOH);
      }
      if (this.FAe != null) {
        paramVarArgs.d(12, this.FAe);
      }
      if (this.Fvn != null) {
        paramVarArgs.d(13, this.Fvn);
      }
      paramVarArgs.aS(14, this.FOM);
      AppMethodBeat.o(152720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1462;
      }
    }
    label1462:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xbr);
      paramInt = i;
      if (this.HFH != null) {
        paramInt = i + f.a.a.a.lB(3, this.HFH.computeSize());
      }
      i = paramInt;
      if (this.Fvi != null) {
        i = paramInt + f.a.a.a.lB(4, this.Fvi.computeSize());
      }
      paramInt = i;
      if (this.Fvj != null) {
        paramInt = i + f.a.a.a.lB(5, this.Fvj.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.xcK) + f.a.a.b.b.a.bz(7, this.xcL) + f.a.a.b.b.a.bz(8, this.xcM) + f.a.a.b.b.a.bz(9, this.CreateTime) + f.a.a.b.b.a.p(10, this.xbt);
      paramInt = i;
      if (this.FOH != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FOH);
      }
      i = paramInt;
      if (this.FAe != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FAe);
      }
      paramInt = i;
      if (this.Fvn != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Fvn);
      }
      i = f.a.a.b.b.a.bz(14, this.FOM);
      AppMethodBeat.o(152720);
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.HFH == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientImgId");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.Fvi == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.Fvj == null)
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
        dta localdta = (dta)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152720);
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
            localdta.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 2: 
          localdta.xbr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152720);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdta.HFH = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdta.Fvi = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdta.Fvj = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 6: 
          localdta.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152720);
          return 0;
        case 7: 
          localdta.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152720);
          return 0;
        case 8: 
          localdta.xcM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152720);
          return 0;
        case 9: 
          localdta.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152720);
          return 0;
        case 10: 
          localdta.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(152720);
          return 0;
        case 11: 
          localdta.FOH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152720);
          return 0;
        case 12: 
          localdta.FAe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152720);
          return 0;
        case 13: 
          localdta.Fvn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152720);
          return 0;
        }
        localdta.FOM = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152720);
        return 0;
      }
      AppMethodBeat.o(152720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dta
 * JD-Core Version:    0.7.0.1
 */