package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bth
  extends cld
{
  public String CBj;
  public ctj CBm;
  public int CBr;
  public pw CGH;
  public pw CGI;
  public pw CGJ;
  public bgp CGg;
  public oj CGh;
  public bsu CGi;
  public String Ctm;
  public String CuG;
  public int CuJ;
  public String CuM;
  public String CuN;
  public int CuO;
  public String CuP;
  public String DQD;
  public int DQE;
  public String DQF;
  public int DQG;
  public caw DQH;
  public int DQI;
  public String DQJ;
  public String DQK;
  public col DQL;
  public String DyD;
  public SKBuiltinBuffer_t DyG;
  public String mAQ;
  public int mBi;
  public int oXh;
  public String oXj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133185);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133185);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.oXh);
      if (this.Ctm != null) {
        paramVarArgs.d(3, this.Ctm);
      }
      if (this.CuM != null) {
        paramVarArgs.d(4, this.CuM);
      }
      if (this.CuN != null) {
        paramVarArgs.d(5, this.CuN);
      }
      if (this.DQD != null) {
        paramVarArgs.d(6, this.DQD);
      }
      if (this.CuG != null) {
        paramVarArgs.d(7, this.CuG);
      }
      paramVarArgs.aR(8, this.CuO);
      paramVarArgs.aR(9, this.DQE);
      if (this.DQF != null) {
        paramVarArgs.d(10, this.DQF);
      }
      if (this.CGh != null)
      {
        paramVarArgs.kX(14, this.CGh.computeSize());
        this.CGh.writeFields(paramVarArgs);
      }
      if (this.CuP != null) {
        paramVarArgs.d(15, this.CuP);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(16, this.mAQ);
      }
      paramVarArgs.aR(17, this.mBi);
      if (this.CGi != null)
      {
        paramVarArgs.kX(18, this.CGi.computeSize());
        this.CGi.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(19, this.DQG);
      paramVarArgs.aR(20, this.CuJ);
      if (this.CBj != null) {
        paramVarArgs.d(21, this.CBj);
      }
      if (this.DQH != null)
      {
        paramVarArgs.kX(22, this.DQH.computeSize());
        this.DQH.writeFields(paramVarArgs);
      }
      if (this.oXj != null) {
        paramVarArgs.d(23, this.oXj);
      }
      paramVarArgs.aR(24, this.DQI);
      if (this.CGg != null)
      {
        paramVarArgs.kX(25, this.CGg.computeSize());
        this.CGg.writeFields(paramVarArgs);
      }
      if (this.DQJ != null) {
        paramVarArgs.d(26, this.DQJ);
      }
      if (this.CGH != null)
      {
        paramVarArgs.kX(27, this.CGH.computeSize());
        this.CGH.writeFields(paramVarArgs);
      }
      if (this.DQK != null) {
        paramVarArgs.d(28, this.DQK);
      }
      if (this.DyD != null) {
        paramVarArgs.d(29, this.DyD);
      }
      if (this.DyG != null)
      {
        paramVarArgs.kX(30, this.DyG.computeSize());
        this.DyG.writeFields(paramVarArgs);
      }
      if (this.CBm != null)
      {
        paramVarArgs.kX(31, this.CBm.computeSize());
        this.CBm.writeFields(paramVarArgs);
      }
      if (this.CGI != null)
      {
        paramVarArgs.kX(32, this.CGI.computeSize());
        this.CGI.writeFields(paramVarArgs);
      }
      if (this.CGJ != null)
      {
        paramVarArgs.kX(33, this.CGJ.computeSize());
        this.CGJ.writeFields(paramVarArgs);
      }
      if (this.DQL != null)
      {
        paramVarArgs.kX(34, this.DQL.computeSize());
        this.DQL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(35, this.CBr);
      AppMethodBeat.o(133185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3094;
      }
    }
    label3094:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.oXh);
      paramInt = i;
      if (this.Ctm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Ctm);
      }
      i = paramInt;
      if (this.CuM != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CuM);
      }
      paramInt = i;
      if (this.CuN != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CuN);
      }
      i = paramInt;
      if (this.DQD != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DQD);
      }
      paramInt = i;
      if (this.CuG != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CuG);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.CuO) + f.a.a.b.b.a.bA(9, this.DQE);
      paramInt = i;
      if (this.DQF != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DQF);
      }
      i = paramInt;
      if (this.CGh != null) {
        i = paramInt + f.a.a.a.kW(14, this.CGh.computeSize());
      }
      paramInt = i;
      if (this.CuP != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.CuP);
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.mAQ);
      }
      i += f.a.a.b.b.a.bA(17, this.mBi);
      paramInt = i;
      if (this.CGi != null) {
        paramInt = i + f.a.a.a.kW(18, this.CGi.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(19, this.DQG) + f.a.a.b.b.a.bA(20, this.CuJ);
      paramInt = i;
      if (this.CBj != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.CBj);
      }
      i = paramInt;
      if (this.DQH != null) {
        i = paramInt + f.a.a.a.kW(22, this.DQH.computeSize());
      }
      paramInt = i;
      if (this.oXj != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.oXj);
      }
      i = paramInt + f.a.a.b.b.a.bA(24, this.DQI);
      paramInt = i;
      if (this.CGg != null) {
        paramInt = i + f.a.a.a.kW(25, this.CGg.computeSize());
      }
      i = paramInt;
      if (this.DQJ != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.DQJ);
      }
      paramInt = i;
      if (this.CGH != null) {
        paramInt = i + f.a.a.a.kW(27, this.CGH.computeSize());
      }
      i = paramInt;
      if (this.DQK != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.DQK);
      }
      paramInt = i;
      if (this.DyD != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.DyD);
      }
      i = paramInt;
      if (this.DyG != null) {
        i = paramInt + f.a.a.a.kW(30, this.DyG.computeSize());
      }
      paramInt = i;
      if (this.CBm != null) {
        paramInt = i + f.a.a.a.kW(31, this.CBm.computeSize());
      }
      i = paramInt;
      if (this.CGI != null) {
        i = paramInt + f.a.a.a.kW(32, this.CGI.computeSize());
      }
      paramInt = i;
      if (this.CGJ != null) {
        paramInt = i + f.a.a.a.kW(33, this.CGJ.computeSize());
      }
      i = paramInt;
      if (this.DQL != null) {
        i = paramInt + f.a.a.a.kW(34, this.DQL.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(35, this.CBr);
      AppMethodBeat.o(133185);
      return i + paramInt;
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
          AppMethodBeat.o(133185);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133185);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bth localbth = (bth)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(133185);
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
            localbth.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 2: 
          localbth.oXh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133185);
          return 0;
        case 3: 
          localbth.Ctm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 4: 
          localbth.CuM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 5: 
          localbth.CuN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 6: 
          localbth.DQD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 7: 
          localbth.CuG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 8: 
          localbth.CuO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133185);
          return 0;
        case 9: 
          localbth.DQE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133185);
          return 0;
        case 10: 
          localbth.DQF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbth.CGh = ((oj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 15: 
          localbth.CuP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 16: 
          localbth.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 17: 
          localbth.mBi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133185);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbth.CGi = ((bsu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 19: 
          localbth.DQG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133185);
          return 0;
        case 20: 
          localbth.CuJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133185);
          return 0;
        case 21: 
          localbth.CBj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new caw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((caw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbth.DQH = ((caw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 23: 
          localbth.oXj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 24: 
          localbth.DQI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133185);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbth.CGg = ((bgp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 26: 
          localbth.DQJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 27: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbth.CGH = ((pw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 28: 
          localbth.DQK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 29: 
          localbth.DyD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 30: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbth.DyG = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 31: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbth.CBm = ((ctj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 32: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbth.CGI = ((pw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbth.CGJ = ((pw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new col();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((col)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbth.DQL = ((col)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        }
        localbth.CBr = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133185);
        return 0;
      }
      AppMethodBeat.o(133185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bth
 * JD-Core Version:    0.7.0.1
 */