package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bxe
  extends dpc
{
  public LinkedList<bes> KHh;
  public LinkedList<String> McO;
  public String McP;
  public String McQ;
  public boolean McS;
  public LinkedList<ffl> McX;
  public LinkedList<ffm> McY;
  public String McZ;
  public String Mda;
  public String Mdb;
  public String Mdc;
  public boolean Mdd;
  public int Mde;
  public String Mdf;
  public String ixr;
  public boolean rCK;
  
  public bxe()
  {
    AppMethodBeat.i(32282);
    this.McX = new LinkedList();
    this.McY = new LinkedList();
    this.McO = new LinkedList();
    this.KHh = new LinkedList();
    AppMethodBeat.o(32282);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32283);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.McZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: championcoverurl");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.Mda == null)
      {
        paramVarArgs = new b("Not all required fields were included: championmotto");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.ixr == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankid");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.McX);
      paramVarArgs.e(3, 8, this.McY);
      paramVarArgs.e(4, 1, this.McO);
      if (this.McZ != null) {
        paramVarArgs.e(5, this.McZ);
      }
      if (this.Mda != null) {
        paramVarArgs.e(6, this.Mda);
      }
      if (this.ixr != null) {
        paramVarArgs.e(7, this.ixr);
      }
      if (this.Mdb != null) {
        paramVarArgs.e(8, this.Mdb);
      }
      if (this.McP != null) {
        paramVarArgs.e(9, this.McP);
      }
      paramVarArgs.cc(10, this.rCK);
      if (this.McQ != null) {
        paramVarArgs.e(11, this.McQ);
      }
      paramVarArgs.e(12, 8, this.KHh);
      paramVarArgs.cc(13, this.McS);
      if (this.Mdc != null) {
        paramVarArgs.e(14, this.Mdc);
      }
      paramVarArgs.cc(15, this.Mdd);
      paramVarArgs.aM(16, this.Mde);
      if (this.Mdf != null) {
        paramVarArgs.e(17, this.Mdf);
      }
      AppMethodBeat.o(32283);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1677;
      }
    }
    label1677:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.McX) + g.a.a.a.c(3, 8, this.McY) + g.a.a.a.c(4, 1, this.McO);
      paramInt = i;
      if (this.McZ != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.McZ);
      }
      i = paramInt;
      if (this.Mda != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Mda);
      }
      paramInt = i;
      if (this.ixr != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.ixr);
      }
      i = paramInt;
      if (this.Mdb != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Mdb);
      }
      paramInt = i;
      if (this.McP != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.McP);
      }
      i = paramInt + (g.a.a.b.b.a.fS(10) + 1);
      paramInt = i;
      if (this.McQ != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.McQ);
      }
      i = paramInt + g.a.a.a.c(12, 8, this.KHh) + (g.a.a.b.b.a.fS(13) + 1);
      paramInt = i;
      if (this.Mdc != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.Mdc);
      }
      i = paramInt + (g.a.a.b.b.a.fS(15) + 1) + g.a.a.b.b.a.bu(16, this.Mde);
      paramInt = i;
      if (this.Mdf != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.Mdf);
      }
      AppMethodBeat.o(32283);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.McX.clear();
        this.McY.clear();
        this.McO.clear();
        this.KHh.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.McZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: championcoverurl");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.Mda == null)
        {
          paramVarArgs = new b("Not all required fields were included: championmotto");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.ixr == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankid");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32283);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bxe localbxe = (bxe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32283);
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
            localbxe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ffl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ffl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxe.McX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ffm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ffm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxe.McY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 4: 
          localbxe.McO.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(32283);
          return 0;
        case 5: 
          localbxe.McZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 6: 
          localbxe.Mda = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 7: 
          localbxe.ixr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 8: 
          localbxe.Mdb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 9: 
          localbxe.McP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 10: 
          localbxe.rCK = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(32283);
          return 0;
        case 11: 
          localbxe.McQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bes();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bes)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxe.KHh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 13: 
          localbxe.McS = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(32283);
          return 0;
        case 14: 
          localbxe.Mdc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 15: 
          localbxe.Mdd = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(32283);
          return 0;
        case 16: 
          localbxe.Mde = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32283);
          return 0;
        }
        localbxe.Mdf = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32283);
        return 0;
      }
      AppMethodBeat.o(32283);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxe
 * JD-Core Version:    0.7.0.1
 */