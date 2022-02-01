package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cxg
  extends dpc
{
  public int KBv;
  public dju LgT;
  public int MBD;
  public int MBE;
  public int MBF;
  public long MBG;
  public long MBH;
  public LinkedList<cai> MBI;
  public String MBJ;
  public String MBK;
  public String MBL;
  public int MBM;
  public int MBN;
  public String MBO;
  public long eht;
  public int yPI;
  public int yPJ;
  public String yPK;
  public String yPL;
  public String yPM;
  
  public cxg()
  {
    AppMethodBeat.i(91566);
    this.MBI = new LinkedList();
    AppMethodBeat.o(91566);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91567);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91567);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MBD);
      paramVarArgs.aM(3, this.MBE);
      paramVarArgs.aM(4, this.yPI);
      paramVarArgs.bb(5, this.eht);
      paramVarArgs.aM(6, this.MBF);
      paramVarArgs.bb(7, this.MBG);
      paramVarArgs.aM(8, this.KBv);
      paramVarArgs.bb(9, this.MBH);
      paramVarArgs.aM(10, this.yPJ);
      paramVarArgs.e(11, 8, this.MBI);
      if (this.yPK != null) {
        paramVarArgs.e(12, this.yPK);
      }
      if (this.MBJ != null) {
        paramVarArgs.e(13, this.MBJ);
      }
      if (this.MBK != null) {
        paramVarArgs.e(14, this.MBK);
      }
      if (this.MBL != null) {
        paramVarArgs.e(15, this.MBL);
      }
      paramVarArgs.aM(16, this.MBM);
      if (this.yPM != null) {
        paramVarArgs.e(17, this.yPM);
      }
      paramVarArgs.aM(18, this.MBN);
      if (this.yPL != null) {
        paramVarArgs.e(19, this.yPL);
      }
      if (this.LgT != null)
      {
        paramVarArgs.ni(20, this.LgT.computeSize());
        this.LgT.writeFields(paramVarArgs);
      }
      if (this.MBO != null) {
        paramVarArgs.e(21, this.MBO);
      }
      AppMethodBeat.o(91567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1570;
      }
    }
    label1570:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MBD) + g.a.a.b.b.a.bu(3, this.MBE) + g.a.a.b.b.a.bu(4, this.yPI) + g.a.a.b.b.a.r(5, this.eht) + g.a.a.b.b.a.bu(6, this.MBF) + g.a.a.b.b.a.r(7, this.MBG) + g.a.a.b.b.a.bu(8, this.KBv) + g.a.a.b.b.a.r(9, this.MBH) + g.a.a.b.b.a.bu(10, this.yPJ) + g.a.a.a.c(11, 8, this.MBI);
      paramInt = i;
      if (this.yPK != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.yPK);
      }
      i = paramInt;
      if (this.MBJ != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.MBJ);
      }
      paramInt = i;
      if (this.MBK != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.MBK);
      }
      i = paramInt;
      if (this.MBL != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.MBL);
      }
      i += g.a.a.b.b.a.bu(16, this.MBM);
      paramInt = i;
      if (this.yPM != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.yPM);
      }
      i = paramInt + g.a.a.b.b.a.bu(18, this.MBN);
      paramInt = i;
      if (this.yPL != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.yPL);
      }
      i = paramInt;
      if (this.LgT != null) {
        i = paramInt + g.a.a.a.nh(20, this.LgT.computeSize());
      }
      paramInt = i;
      if (this.MBO != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.MBO);
      }
      AppMethodBeat.o(91567);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MBI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cxg localcxg = (cxg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91567);
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
            localcxg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        case 2: 
          localcxg.MBD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91567);
          return 0;
        case 3: 
          localcxg.MBE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91567);
          return 0;
        case 4: 
          localcxg.yPI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91567);
          return 0;
        case 5: 
          localcxg.eht = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91567);
          return 0;
        case 6: 
          localcxg.MBF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91567);
          return 0;
        case 7: 
          localcxg.MBG = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91567);
          return 0;
        case 8: 
          localcxg.KBv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91567);
          return 0;
        case 9: 
          localcxg.MBH = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91567);
          return 0;
        case 10: 
          localcxg.yPJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91567);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cai();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cai)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcxg.MBI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        case 12: 
          localcxg.yPK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 13: 
          localcxg.MBJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 14: 
          localcxg.MBK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 15: 
          localcxg.MBL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 16: 
          localcxg.MBM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91567);
          return 0;
        case 17: 
          localcxg.yPM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 18: 
          localcxg.MBN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91567);
          return 0;
        case 19: 
          localcxg.yPL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dju();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dju)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcxg.LgT = ((dju)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        }
        localcxg.MBO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91567);
        return 0;
      }
      AppMethodBeat.o(91567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxg
 * JD-Core Version:    0.7.0.1
 */