package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class din
  extends dpc
{
  public int KBv;
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
  
  public din()
  {
    AppMethodBeat.i(91656);
    this.MBI = new LinkedList();
    AppMethodBeat.o(91656);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91657);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91657);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.eht);
      paramVarArgs.aM(3, this.MBF);
      paramVarArgs.bb(4, this.MBG);
      paramVarArgs.aM(5, this.KBv);
      paramVarArgs.bb(6, this.MBH);
      paramVarArgs.aM(9, this.yPJ);
      paramVarArgs.e(10, 8, this.MBI);
      if (this.yPK != null) {
        paramVarArgs.e(11, this.yPK);
      }
      if (this.MBJ != null) {
        paramVarArgs.e(12, this.MBJ);
      }
      if (this.MBK != null) {
        paramVarArgs.e(13, this.MBK);
      }
      if (this.MBL != null) {
        paramVarArgs.e(14, this.MBL);
      }
      paramVarArgs.aM(15, this.MBM);
      if (this.yPM != null) {
        paramVarArgs.e(16, this.yPM);
      }
      paramVarArgs.aM(17, this.MBN);
      if (this.yPL != null) {
        paramVarArgs.e(18, this.yPL);
      }
      paramVarArgs.aM(19, this.MBE);
      paramVarArgs.aM(20, this.yPI);
      paramVarArgs.aM(21, this.MBD);
      if (this.MBO != null) {
        paramVarArgs.e(22, this.MBO);
      }
      AppMethodBeat.o(91657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1426;
      }
    }
    label1426:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.eht) + g.a.a.b.b.a.bu(3, this.MBF) + g.a.a.b.b.a.r(4, this.MBG) + g.a.a.b.b.a.bu(5, this.KBv) + g.a.a.b.b.a.r(6, this.MBH) + g.a.a.b.b.a.bu(9, this.yPJ) + g.a.a.a.c(10, 8, this.MBI);
      paramInt = i;
      if (this.yPK != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.yPK);
      }
      i = paramInt;
      if (this.MBJ != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.MBJ);
      }
      paramInt = i;
      if (this.MBK != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.MBK);
      }
      i = paramInt;
      if (this.MBL != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.MBL);
      }
      i += g.a.a.b.b.a.bu(15, this.MBM);
      paramInt = i;
      if (this.yPM != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.yPM);
      }
      i = paramInt + g.a.a.b.b.a.bu(17, this.MBN);
      paramInt = i;
      if (this.yPL != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.yPL);
      }
      i = paramInt + g.a.a.b.b.a.bu(19, this.MBE) + g.a.a.b.b.a.bu(20, this.yPI) + g.a.a.b.b.a.bu(21, this.MBD);
      paramInt = i;
      if (this.MBO != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.MBO);
      }
      AppMethodBeat.o(91657);
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
          AppMethodBeat.o(91657);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91657);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        din localdin = (din)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(91657);
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
            localdin.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91657);
          return 0;
        case 2: 
          localdin.eht = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91657);
          return 0;
        case 3: 
          localdin.MBF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91657);
          return 0;
        case 4: 
          localdin.MBG = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91657);
          return 0;
        case 5: 
          localdin.KBv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91657);
          return 0;
        case 6: 
          localdin.MBH = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91657);
          return 0;
        case 9: 
          localdin.yPJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91657);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cai();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cai)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdin.MBI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91657);
          return 0;
        case 11: 
          localdin.yPK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 12: 
          localdin.MBJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 13: 
          localdin.MBK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 14: 
          localdin.MBL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 15: 
          localdin.MBM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91657);
          return 0;
        case 16: 
          localdin.yPM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 17: 
          localdin.MBN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91657);
          return 0;
        case 18: 
          localdin.yPL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 19: 
          localdin.MBE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91657);
          return 0;
        case 20: 
          localdin.yPI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91657);
          return 0;
        case 21: 
          localdin.MBD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91657);
          return 0;
        }
        localdin.MBO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91657);
        return 0;
      }
      AppMethodBeat.o(91657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.din
 * JD-Core Version:    0.7.0.1
 */