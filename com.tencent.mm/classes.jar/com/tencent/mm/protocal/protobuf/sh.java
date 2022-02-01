package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sh
  extends cld
{
  public String Aar;
  public int CTI;
  public LinkedList<bpq> CTP;
  public bpq CTQ;
  public String CTR;
  public boolean CTS;
  public String CTT;
  public int CTU;
  public bpx CTV;
  public cgx CTW;
  public String CTX;
  public String CTY;
  public String CTZ;
  public cds CUa;
  public cds CUb;
  public cds CUc;
  public com.tencent.mm.bx.b CUd;
  public int dcG;
  public String iau;
  public String iav;
  public String url;
  public int vBl;
  public String vBm;
  public String vBn;
  
  public sh()
  {
    AppMethodBeat.i(91406);
    this.CTP = new LinkedList();
    AppMethodBeat.o(91406);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91407);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91407);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.e(3, 8, this.CTP);
      if (this.CTQ != null)
      {
        paramVarArgs.kX(4, this.CTQ.computeSize());
        this.CTQ.writeFields(paramVarArgs);
      }
      if (this.Aar != null) {
        paramVarArgs.d(5, this.Aar);
      }
      if (this.CTR != null) {
        paramVarArgs.d(6, this.CTR);
      }
      paramVarArgs.bg(7, this.CTS);
      paramVarArgs.aR(8, this.vBl);
      if (this.CTT != null) {
        paramVarArgs.d(9, this.CTT);
      }
      if (this.vBm != null) {
        paramVarArgs.d(10, this.vBm);
      }
      if (this.vBn != null) {
        paramVarArgs.d(11, this.vBn);
      }
      paramVarArgs.aR(12, this.CTU);
      if (this.CTV != null)
      {
        paramVarArgs.kX(13, this.CTV.computeSize());
        this.CTV.writeFields(paramVarArgs);
      }
      if (this.CTW != null)
      {
        paramVarArgs.kX(14, this.CTW.computeSize());
        this.CTW.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(15, this.dcG);
      paramVarArgs.aR(16, this.CTI);
      if (this.iau != null) {
        paramVarArgs.d(17, this.iau);
      }
      if (this.iav != null) {
        paramVarArgs.d(18, this.iav);
      }
      if (this.CTX != null) {
        paramVarArgs.d(19, this.CTX);
      }
      if (this.CTY != null) {
        paramVarArgs.d(20, this.CTY);
      }
      if (this.CTZ != null) {
        paramVarArgs.d(21, this.CTZ);
      }
      if (this.CUa != null)
      {
        paramVarArgs.kX(22, this.CUa.computeSize());
        this.CUa.writeFields(paramVarArgs);
      }
      if (this.CUb != null)
      {
        paramVarArgs.kX(23, this.CUb.computeSize());
        this.CUb.writeFields(paramVarArgs);
      }
      if (this.CUc != null)
      {
        paramVarArgs.kX(24, this.CUc.computeSize());
        this.CUc.writeFields(paramVarArgs);
      }
      if (this.CUd != null) {
        paramVarArgs.c(25, this.CUd);
      }
      AppMethodBeat.o(91407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2398;
      }
    }
    label2398:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i += f.a.a.a.c(3, 8, this.CTP);
      paramInt = i;
      if (this.CTQ != null) {
        paramInt = i + f.a.a.a.kW(4, this.CTQ.computeSize());
      }
      i = paramInt;
      if (this.Aar != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Aar);
      }
      paramInt = i;
      if (this.CTR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CTR);
      }
      i = paramInt + (f.a.a.b.b.a.fY(7) + 1) + f.a.a.b.b.a.bA(8, this.vBl);
      paramInt = i;
      if (this.CTT != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CTT);
      }
      i = paramInt;
      if (this.vBm != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.vBm);
      }
      paramInt = i;
      if (this.vBn != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.vBn);
      }
      i = paramInt + f.a.a.b.b.a.bA(12, this.CTU);
      paramInt = i;
      if (this.CTV != null) {
        paramInt = i + f.a.a.a.kW(13, this.CTV.computeSize());
      }
      i = paramInt;
      if (this.CTW != null) {
        i = paramInt + f.a.a.a.kW(14, this.CTW.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(15, this.dcG) + f.a.a.b.b.a.bA(16, this.CTI);
      paramInt = i;
      if (this.iau != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.iau);
      }
      i = paramInt;
      if (this.iav != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.iav);
      }
      paramInt = i;
      if (this.CTX != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.CTX);
      }
      i = paramInt;
      if (this.CTY != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.CTY);
      }
      paramInt = i;
      if (this.CTZ != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.CTZ);
      }
      i = paramInt;
      if (this.CUa != null) {
        i = paramInt + f.a.a.a.kW(22, this.CUa.computeSize());
      }
      paramInt = i;
      if (this.CUb != null) {
        paramInt = i + f.a.a.a.kW(23, this.CUb.computeSize());
      }
      i = paramInt;
      if (this.CUc != null) {
        i = paramInt + f.a.a.a.kW(24, this.CUc.computeSize());
      }
      paramInt = i;
      if (this.CUd != null) {
        paramInt = i + f.a.a.b.b.a.b(25, this.CUd);
      }
      AppMethodBeat.o(91407);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CTP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91407);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sh localsh = (sh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91407);
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
            localsh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 2: 
          localsh.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsh.CTP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsh.CTQ = ((bpq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 5: 
          localsh.Aar = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 6: 
          localsh.CTR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 7: 
          localsh.CTS = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91407);
          return 0;
        case 8: 
          localsh.vBl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91407);
          return 0;
        case 9: 
          localsh.CTT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 10: 
          localsh.vBm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 11: 
          localsh.vBn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 12: 
          localsh.CTU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91407);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsh.CTV = ((bpx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsh.CTW = ((cgx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 15: 
          localsh.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91407);
          return 0;
        case 16: 
          localsh.CTI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91407);
          return 0;
        case 17: 
          localsh.iau = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 18: 
          localsh.iav = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 19: 
          localsh.CTX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 20: 
          localsh.CTY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 21: 
          localsh.CTZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cds();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cds)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsh.CUa = ((cds)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cds();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cds)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsh.CUb = ((cds)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cds();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cds)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsh.CUc = ((cds)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        }
        localsh.CUd = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(91407);
        return 0;
      }
      AppMethodBeat.o(91407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sh
 * JD-Core Version:    0.7.0.1
 */