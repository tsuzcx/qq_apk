package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czx
  extends cld
{
  public com.tencent.mm.bx.b Buffer;
  public daa ErG;
  public String ErH;
  public String ErI;
  public int ErJ;
  public int ErK;
  public int ErL;
  public boolean ErM;
  public String ErN;
  public int ErO;
  public int ErP;
  public int ErQ;
  public String ErR;
  public boolean ErS;
  public String ErT;
  public String ErU;
  public int ErV;
  public czy ErW;
  public int Ery;
  public LinkedList<czv> rZM;
  
  public czx()
  {
    AppMethodBeat.i(152706);
    this.rZM = new LinkedList();
    AppMethodBeat.o(152706);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152707);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152707);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.rZM);
      if (this.ErG != null)
      {
        paramVarArgs.kX(3, this.ErG.computeSize());
        this.ErG.writeFields(paramVarArgs);
      }
      if (this.ErH != null) {
        paramVarArgs.d(4, this.ErH);
      }
      if (this.ErI != null) {
        paramVarArgs.d(5, this.ErI);
      }
      paramVarArgs.aR(6, this.ErJ);
      paramVarArgs.aR(9, this.ErK);
      paramVarArgs.aR(10, this.ErL);
      paramVarArgs.aR(11, this.Ery);
      paramVarArgs.bg(12, this.ErM);
      if (this.ErN != null) {
        paramVarArgs.d(13, this.ErN);
      }
      paramVarArgs.aR(14, this.ErO);
      paramVarArgs.aR(15, this.ErP);
      if (this.Buffer != null) {
        paramVarArgs.c(16, this.Buffer);
      }
      paramVarArgs.aR(17, this.ErQ);
      if (this.ErR != null) {
        paramVarArgs.d(18, this.ErR);
      }
      paramVarArgs.bg(19, this.ErS);
      if (this.ErT != null) {
        paramVarArgs.d(20, this.ErT);
      }
      if (this.ErU != null) {
        paramVarArgs.d(21, this.ErU);
      }
      paramVarArgs.aR(22, this.ErV);
      if (this.ErW != null)
      {
        paramVarArgs.kX(23, this.ErW.computeSize());
        this.ErW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1694;
      }
    }
    label1694:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.rZM);
      paramInt = i;
      if (this.ErG != null) {
        paramInt = i + f.a.a.a.kW(3, this.ErG.computeSize());
      }
      i = paramInt;
      if (this.ErH != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ErH);
      }
      paramInt = i;
      if (this.ErI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ErI);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.ErJ) + f.a.a.b.b.a.bA(9, this.ErK) + f.a.a.b.b.a.bA(10, this.ErL) + f.a.a.b.b.a.bA(11, this.Ery) + (f.a.a.b.b.a.fY(12) + 1);
      paramInt = i;
      if (this.ErN != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.ErN);
      }
      i = paramInt + f.a.a.b.b.a.bA(14, this.ErO) + f.a.a.b.b.a.bA(15, this.ErP);
      paramInt = i;
      if (this.Buffer != null) {
        paramInt = i + f.a.a.b.b.a.b(16, this.Buffer);
      }
      i = paramInt + f.a.a.b.b.a.bA(17, this.ErQ);
      paramInt = i;
      if (this.ErR != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.ErR);
      }
      i = paramInt + (f.a.a.b.b.a.fY(19) + 1);
      paramInt = i;
      if (this.ErT != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.ErT);
      }
      i = paramInt;
      if (this.ErU != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.ErU);
      }
      i += f.a.a.b.b.a.bA(22, this.ErV);
      paramInt = i;
      if (this.ErW != null) {
        paramInt = i + f.a.a.a.kW(23, this.ErW.computeSize());
      }
      AppMethodBeat.o(152707);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rZM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152707);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152707);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czx localczx = (czx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(152707);
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
            localczx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczx.rZM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new daa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((daa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczx.ErG = ((daa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 4: 
          localczx.ErH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 5: 
          localczx.ErI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 6: 
          localczx.ErJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152707);
          return 0;
        case 9: 
          localczx.ErK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152707);
          return 0;
        case 10: 
          localczx.ErL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152707);
          return 0;
        case 11: 
          localczx.Ery = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152707);
          return 0;
        case 12: 
          localczx.ErM = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(152707);
          return 0;
        case 13: 
          localczx.ErN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 14: 
          localczx.ErO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152707);
          return 0;
        case 15: 
          localczx.ErP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152707);
          return 0;
        case 16: 
          localczx.Buffer = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(152707);
          return 0;
        case 17: 
          localczx.ErQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152707);
          return 0;
        case 18: 
          localczx.ErR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 19: 
          localczx.ErS = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(152707);
          return 0;
        case 20: 
          localczx.ErT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 21: 
          localczx.ErU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 22: 
          localczx.ErV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152707);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localczx.ErW = ((czy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152707);
        return 0;
      }
      AppMethodBeat.o(152707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czx
 * JD-Core Version:    0.7.0.1
 */