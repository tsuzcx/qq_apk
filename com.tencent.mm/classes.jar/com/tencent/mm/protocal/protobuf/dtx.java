package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dtx
  extends cwj
{
  public int CreateTime;
  public cxn FNG;
  public cxn FNH;
  public String FNL;
  public String FSC;
  public String Ghg;
  public int Ghl;
  public cxn HZu;
  public int xri;
  public long xrk;
  public int xsB;
  public int xsC;
  public int xsD;
  
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
      if (this.HZu == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientImgId");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.FNG == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.FNH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152720);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xri);
      if (this.HZu != null)
      {
        paramVarArgs.lJ(3, this.HZu.computeSize());
        this.HZu.writeFields(paramVarArgs);
      }
      if (this.FNG != null)
      {
        paramVarArgs.lJ(4, this.FNG.computeSize());
        this.FNG.writeFields(paramVarArgs);
      }
      if (this.FNH != null)
      {
        paramVarArgs.lJ(5, this.FNH.computeSize());
        this.FNH.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.xsB);
      paramVarArgs.aS(7, this.xsC);
      paramVarArgs.aS(8, this.xsD);
      paramVarArgs.aS(9, this.CreateTime);
      paramVarArgs.aZ(10, this.xrk);
      if (this.Ghg != null) {
        paramVarArgs.d(11, this.Ghg);
      }
      if (this.FSC != null) {
        paramVarArgs.d(12, this.FSC);
      }
      if (this.FNL != null) {
        paramVarArgs.d(13, this.FNL);
      }
      paramVarArgs.aS(14, this.Ghl);
      AppMethodBeat.o(152720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1462;
      }
    }
    label1462:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xri);
      paramInt = i;
      if (this.HZu != null) {
        paramInt = i + f.a.a.a.lI(3, this.HZu.computeSize());
      }
      i = paramInt;
      if (this.FNG != null) {
        i = paramInt + f.a.a.a.lI(4, this.FNG.computeSize());
      }
      paramInt = i;
      if (this.FNH != null) {
        paramInt = i + f.a.a.a.lI(5, this.FNH.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.xsB) + f.a.a.b.b.a.bz(7, this.xsC) + f.a.a.b.b.a.bz(8, this.xsD) + f.a.a.b.b.a.bz(9, this.CreateTime) + f.a.a.b.b.a.p(10, this.xrk);
      paramInt = i;
      if (this.Ghg != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Ghg);
      }
      i = paramInt;
      if (this.FSC != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FSC);
      }
      paramInt = i;
      if (this.FNL != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FNL);
      }
      i = f.a.a.b.b.a.bz(14, this.Ghl);
      AppMethodBeat.o(152720);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.HZu == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientImgId");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.FNG == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152720);
          throw paramVarArgs;
        }
        if (this.FNH == null)
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
        dtx localdtx = (dtx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152720);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 2: 
          localdtx.xri = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152720);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtx.HZu = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtx.FNG = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtx.FNH = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152720);
          return 0;
        case 6: 
          localdtx.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152720);
          return 0;
        case 7: 
          localdtx.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152720);
          return 0;
        case 8: 
          localdtx.xsD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152720);
          return 0;
        case 9: 
          localdtx.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152720);
          return 0;
        case 10: 
          localdtx.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(152720);
          return 0;
        case 11: 
          localdtx.Ghg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152720);
          return 0;
        case 12: 
          localdtx.FSC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152720);
          return 0;
        case 13: 
          localdtx.FNL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152720);
          return 0;
        }
        localdtx.Ghl = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152720);
        return 0;
      }
      AppMethodBeat.o(152720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtx
 * JD-Core Version:    0.7.0.1
 */