package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class y
  extends dpc
{
  public String KBA;
  public String KBB;
  public a KBE;
  public String KBM;
  public String KBQ;
  public long KBR;
  public int KBS;
  public long KBT;
  public int KBU;
  public int KBV;
  public int KBW;
  public int KBX;
  public long KBY;
  public long KBZ;
  public String KBs;
  public LinkedList<w> KBx;
  public long KCa;
  public int KCb;
  public String KCc;
  public int KCd;
  public long KCe;
  public String KCf;
  public int dDN;
  public String qwn;
  public int role;
  public int state;
  public String title;
  public int type;
  
  public y()
  {
    AppMethodBeat.i(91334);
    this.dDN = 268513600;
    this.qwn = "请求不成功，请稍候再试";
    this.KBx = new LinkedList();
    AppMethodBeat.o(91334);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91335);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91335);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dDN);
      if (this.qwn != null) {
        paramVarArgs.e(3, this.qwn);
      }
      if (this.KBs != null) {
        paramVarArgs.e(4, this.KBs);
      }
      if (this.title != null) {
        paramVarArgs.e(5, this.title);
      }
      paramVarArgs.aM(6, this.type);
      if (this.KBQ != null) {
        paramVarArgs.e(7, this.KBQ);
      }
      paramVarArgs.bb(8, this.KBR);
      paramVarArgs.aM(9, this.KBS);
      paramVarArgs.bb(10, this.KBT);
      paramVarArgs.aM(11, this.KBU);
      paramVarArgs.aM(12, this.state);
      paramVarArgs.aM(13, this.KBV);
      paramVarArgs.aM(14, this.KBW);
      paramVarArgs.aM(15, this.role);
      paramVarArgs.aM(16, this.KBX);
      paramVarArgs.bb(17, this.KBY);
      paramVarArgs.bb(18, this.KBZ);
      paramVarArgs.bb(19, this.KCa);
      paramVarArgs.aM(20, this.KCb);
      if (this.KBM != null) {
        paramVarArgs.e(21, this.KBM);
      }
      paramVarArgs.e(22, 8, this.KBx);
      if (this.KCc != null) {
        paramVarArgs.e(23, this.KCc);
      }
      paramVarArgs.aM(24, this.KCd);
      paramVarArgs.bb(25, this.KCe);
      if (this.KBA != null) {
        paramVarArgs.e(26, this.KBA);
      }
      if (this.KBB != null) {
        paramVarArgs.e(27, this.KBB);
      }
      if (this.KBE != null)
      {
        paramVarArgs.ni(28, this.KBE.computeSize());
        this.KBE.writeFields(paramVarArgs);
      }
      if (this.KCf != null) {
        paramVarArgs.e(29, this.KCf);
      }
      AppMethodBeat.o(91335);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1962;
      }
    }
    label1962:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt;
      if (this.KBs != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.KBs);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.title);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.type);
      paramInt = i;
      if (this.KBQ != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KBQ);
      }
      i = paramInt + g.a.a.b.b.a.r(8, this.KBR) + g.a.a.b.b.a.bu(9, this.KBS) + g.a.a.b.b.a.r(10, this.KBT) + g.a.a.b.b.a.bu(11, this.KBU) + g.a.a.b.b.a.bu(12, this.state) + g.a.a.b.b.a.bu(13, this.KBV) + g.a.a.b.b.a.bu(14, this.KBW) + g.a.a.b.b.a.bu(15, this.role) + g.a.a.b.b.a.bu(16, this.KBX) + g.a.a.b.b.a.r(17, this.KBY) + g.a.a.b.b.a.r(18, this.KBZ) + g.a.a.b.b.a.r(19, this.KCa) + g.a.a.b.b.a.bu(20, this.KCb);
      paramInt = i;
      if (this.KBM != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.KBM);
      }
      i = paramInt + g.a.a.a.c(22, 8, this.KBx);
      paramInt = i;
      if (this.KCc != null) {
        paramInt = i + g.a.a.b.b.a.f(23, this.KCc);
      }
      i = paramInt + g.a.a.b.b.a.bu(24, this.KCd) + g.a.a.b.b.a.r(25, this.KCe);
      paramInt = i;
      if (this.KBA != null) {
        paramInt = i + g.a.a.b.b.a.f(26, this.KBA);
      }
      i = paramInt;
      if (this.KBB != null) {
        i = paramInt + g.a.a.b.b.a.f(27, this.KBB);
      }
      paramInt = i;
      if (this.KBE != null) {
        paramInt = i + g.a.a.a.nh(28, this.KBE.computeSize());
      }
      i = paramInt;
      if (this.KCf != null) {
        i = paramInt + g.a.a.b.b.a.f(29, this.KCf);
      }
      AppMethodBeat.o(91335);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KBx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91335);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91335);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91335);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        case 2: 
          localy.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91335);
          return 0;
        case 3: 
          localy.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 4: 
          localy.KBs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 5: 
          localy.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 6: 
          localy.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91335);
          return 0;
        case 7: 
          localy.KBQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 8: 
          localy.KBR = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91335);
          return 0;
        case 9: 
          localy.KBS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91335);
          return 0;
        case 10: 
          localy.KBT = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91335);
          return 0;
        case 11: 
          localy.KBU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91335);
          return 0;
        case 12: 
          localy.state = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91335);
          return 0;
        case 13: 
          localy.KBV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91335);
          return 0;
        case 14: 
          localy.KBW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91335);
          return 0;
        case 15: 
          localy.role = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91335);
          return 0;
        case 16: 
          localy.KBX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91335);
          return 0;
        case 17: 
          localy.KBY = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91335);
          return 0;
        case 18: 
          localy.KBZ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91335);
          return 0;
        case 19: 
          localy.KCa = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91335);
          return 0;
        case 20: 
          localy.KCb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91335);
          return 0;
        case 21: 
          localy.KBM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new w();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((w)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localy.KBx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        case 23: 
          localy.KCc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 24: 
          localy.KCd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91335);
          return 0;
        case 25: 
          localy.KCe = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91335);
          return 0;
        case 26: 
          localy.KBA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 27: 
          localy.KBB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 28: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localy.KBE = ((a)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        }
        localy.KCf = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91335);
        return 0;
      }
      AppMethodBeat.o(91335);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.y
 * JD-Core Version:    0.7.0.1
 */