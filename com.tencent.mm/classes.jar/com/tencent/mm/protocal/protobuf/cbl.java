package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cbl
  extends cld
{
  public String DKi;
  public boolean DKj;
  public bhn DXD;
  public ccm DXE;
  public String DXF;
  public int DXG;
  public long DXH;
  public String DXI;
  public String DXJ;
  public String DXK;
  public String DXL;
  public LinkedList<chw> DXM;
  public LinkedList<rx> Drc;
  public int ntx;
  public String nty;
  public int zEA;
  public String zEu;
  
  public cbl()
  {
    AppMethodBeat.i(91622);
    this.Drc = new LinkedList();
    this.DKj = true;
    this.DXM = new LinkedList();
    AppMethodBeat.o(91622);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91623);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91623);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      if (this.DXD != null)
      {
        paramVarArgs.kX(4, this.DXD.computeSize());
        this.DXD.writeFields(paramVarArgs);
      }
      if (this.DXE != null)
      {
        paramVarArgs.kX(5, this.DXE.computeSize());
        this.DXE.writeFields(paramVarArgs);
      }
      if (this.DKi != null) {
        paramVarArgs.d(6, this.DKi);
      }
      paramVarArgs.e(7, 8, this.Drc);
      paramVarArgs.bg(8, this.DKj);
      paramVarArgs.aR(9, this.zEA);
      if (this.DXF != null) {
        paramVarArgs.d(10, this.DXF);
      }
      paramVarArgs.aR(11, this.DXG);
      paramVarArgs.aG(12, this.DXH);
      if (this.zEu != null) {
        paramVarArgs.d(13, this.zEu);
      }
      if (this.DXI != null) {
        paramVarArgs.d(14, this.DXI);
      }
      if (this.DXJ != null) {
        paramVarArgs.d(15, this.DXJ);
      }
      if (this.DXK != null) {
        paramVarArgs.d(16, this.DXK);
      }
      if (this.DXL != null) {
        paramVarArgs.d(17, this.DXL);
      }
      paramVarArgs.e(18, 8, this.DXM);
      AppMethodBeat.o(91623);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1666;
      }
    }
    label1666:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt;
      if (this.DXD != null) {
        i = paramInt + f.a.a.a.kW(4, this.DXD.computeSize());
      }
      paramInt = i;
      if (this.DXE != null) {
        paramInt = i + f.a.a.a.kW(5, this.DXE.computeSize());
      }
      i = paramInt;
      if (this.DKi != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DKi);
      }
      i = i + f.a.a.a.c(7, 8, this.Drc) + (f.a.a.b.b.a.fY(8) + 1) + f.a.a.b.b.a.bA(9, this.zEA);
      paramInt = i;
      if (this.DXF != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DXF);
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.DXG) + f.a.a.b.b.a.q(12, this.DXH);
      paramInt = i;
      if (this.zEu != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.zEu);
      }
      i = paramInt;
      if (this.DXI != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.DXI);
      }
      paramInt = i;
      if (this.DXJ != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.DXJ);
      }
      i = paramInt;
      if (this.DXK != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.DXK);
      }
      paramInt = i;
      if (this.DXL != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.DXL);
      }
      i = f.a.a.a.c(18, 8, this.DXM);
      AppMethodBeat.o(91623);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Drc.clear();
        this.DXM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91623);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91623);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cbl localcbl = (cbl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91623);
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
            localcbl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 2: 
          localcbl.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91623);
          return 0;
        case 3: 
          localcbl.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbl.DXD = ((bhn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbl.DXE = ((ccm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 6: 
          localcbl.DKi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbl.Drc.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 8: 
          localcbl.DKj = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91623);
          return 0;
        case 9: 
          localcbl.zEA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91623);
          return 0;
        case 10: 
          localcbl.DXF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 11: 
          localcbl.DXG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91623);
          return 0;
        case 12: 
          localcbl.DXH = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91623);
          return 0;
        case 13: 
          localcbl.zEu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 14: 
          localcbl.DXI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 15: 
          localcbl.DXJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 16: 
          localcbl.DXK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 17: 
          localcbl.DXL = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91623);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((chw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcbl.DXM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91623);
        return 0;
      }
      AppMethodBeat.o(91623);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbl
 * JD-Core Version:    0.7.0.1
 */