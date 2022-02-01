package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ddt
  extends dpc
{
  public String Htl;
  public int Htr;
  public LinkedList<vk> LSL;
  public cda MII;
  public dfd MIJ;
  public String MIK;
  public int MIL;
  public long MIM;
  public String MIN;
  public String MIO;
  public String MIP;
  public String MIQ;
  public LinkedList<dlf> MIR;
  public String MpG;
  public boolean MpH;
  public int pTZ;
  public String pUa;
  
  public ddt()
  {
    AppMethodBeat.i(91622);
    this.LSL = new LinkedList();
    this.MpH = true;
    this.MIR = new LinkedList();
    AppMethodBeat.o(91622);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91623);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91623);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      if (this.MII != null)
      {
        paramVarArgs.ni(4, this.MII.computeSize());
        this.MII.writeFields(paramVarArgs);
      }
      if (this.MIJ != null)
      {
        paramVarArgs.ni(5, this.MIJ.computeSize());
        this.MIJ.writeFields(paramVarArgs);
      }
      if (this.MpG != null) {
        paramVarArgs.e(6, this.MpG);
      }
      paramVarArgs.e(7, 8, this.LSL);
      paramVarArgs.cc(8, this.MpH);
      paramVarArgs.aM(9, this.Htr);
      if (this.MIK != null) {
        paramVarArgs.e(10, this.MIK);
      }
      paramVarArgs.aM(11, this.MIL);
      paramVarArgs.bb(12, this.MIM);
      if (this.Htl != null) {
        paramVarArgs.e(13, this.Htl);
      }
      if (this.MIN != null) {
        paramVarArgs.e(14, this.MIN);
      }
      if (this.MIO != null) {
        paramVarArgs.e(15, this.MIO);
      }
      if (this.MIP != null) {
        paramVarArgs.e(16, this.MIP);
      }
      if (this.MIQ != null) {
        paramVarArgs.e(17, this.MIQ);
      }
      paramVarArgs.e(18, 8, this.MIR);
      AppMethodBeat.o(91623);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1666;
      }
    }
    label1666:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt;
      if (this.MII != null) {
        i = paramInt + g.a.a.a.nh(4, this.MII.computeSize());
      }
      paramInt = i;
      if (this.MIJ != null) {
        paramInt = i + g.a.a.a.nh(5, this.MIJ.computeSize());
      }
      i = paramInt;
      if (this.MpG != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MpG);
      }
      i = i + g.a.a.a.c(7, 8, this.LSL) + (g.a.a.b.b.a.fS(8) + 1) + g.a.a.b.b.a.bu(9, this.Htr);
      paramInt = i;
      if (this.MIK != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.MIK);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.MIL) + g.a.a.b.b.a.r(12, this.MIM);
      paramInt = i;
      if (this.Htl != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.Htl);
      }
      i = paramInt;
      if (this.MIN != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.MIN);
      }
      paramInt = i;
      if (this.MIO != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.MIO);
      }
      i = paramInt;
      if (this.MIP != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.MIP);
      }
      paramInt = i;
      if (this.MIQ != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.MIQ);
      }
      i = g.a.a.a.c(18, 8, this.MIR);
      AppMethodBeat.o(91623);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LSL.clear();
        this.MIR.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ddt localddt = (ddt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91623);
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
            localddt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 2: 
          localddt.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91623);
          return 0;
        case 3: 
          localddt.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cda();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cda)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localddt.MII = ((cda)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localddt.MIJ = ((dfd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 6: 
          localddt.MpG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localddt.LSL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 8: 
          localddt.MpH = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91623);
          return 0;
        case 9: 
          localddt.Htr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91623);
          return 0;
        case 10: 
          localddt.MIK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 11: 
          localddt.MIL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91623);
          return 0;
        case 12: 
          localddt.MIM = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91623);
          return 0;
        case 13: 
          localddt.Htl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 14: 
          localddt.MIN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 15: 
          localddt.MIO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 16: 
          localddt.MIP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 17: 
          localddt.MIQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91623);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dlf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localddt.MIR.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddt
 * JD-Core Version:    0.7.0.1
 */