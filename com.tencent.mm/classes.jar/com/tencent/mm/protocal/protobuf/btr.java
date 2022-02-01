package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class btr
  extends dpc
{
  public boolean HPI;
  public String HSu;
  public String HSv;
  public LinkedList<djv> MaA;
  public boolean MaB;
  public ebx MaC;
  public String Maf;
  public String Mag;
  public String Mah;
  public String Mai;
  public String Maj;
  public boolean Mak;
  public String Mal;
  public long Mam;
  public boolean Man;
  public boolean Mao;
  public boolean Map;
  public String Maq;
  public String Mar;
  public String Mas;
  public String Mat;
  public boolean Mau;
  public LinkedList<String> Mav;
  public cfm Maw;
  public boolean Max;
  public boolean May;
  public boolean Maz;
  public int dDN;
  public String qwn;
  
  public btr()
  {
    AppMethodBeat.i(91509);
    this.Mav = new LinkedList();
    this.MaA = new LinkedList();
    AppMethodBeat.o(91509);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91510);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91510);
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
      if (this.Maf != null) {
        paramVarArgs.e(4, this.Maf);
      }
      if (this.Mag != null) {
        paramVarArgs.e(5, this.Mag);
      }
      if (this.Mah != null) {
        paramVarArgs.e(6, this.Mah);
      }
      if (this.Mai != null) {
        paramVarArgs.e(7, this.Mai);
      }
      if (this.Maj != null) {
        paramVarArgs.e(8, this.Maj);
      }
      paramVarArgs.cc(9, this.Mak);
      if (this.Mal != null) {
        paramVarArgs.e(10, this.Mal);
      }
      paramVarArgs.bb(11, this.Mam);
      paramVarArgs.cc(12, this.Man);
      paramVarArgs.cc(13, this.Mao);
      paramVarArgs.cc(14, this.Map);
      if (this.Maq != null) {
        paramVarArgs.e(15, this.Maq);
      }
      if (this.Mar != null) {
        paramVarArgs.e(16, this.Mar);
      }
      if (this.Mas != null) {
        paramVarArgs.e(17, this.Mas);
      }
      if (this.Mat != null) {
        paramVarArgs.e(18, this.Mat);
      }
      paramVarArgs.cc(19, this.Mau);
      paramVarArgs.e(20, 1, this.Mav);
      paramVarArgs.cc(21, this.HPI);
      if (this.Maw != null)
      {
        paramVarArgs.ni(22, this.Maw.computeSize());
        this.Maw.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(23, this.Max);
      paramVarArgs.cc(26, this.May);
      paramVarArgs.cc(27, this.Maz);
      paramVarArgs.e(28, 8, this.MaA);
      if (this.HSu != null) {
        paramVarArgs.e(29, this.HSu);
      }
      if (this.HSv != null) {
        paramVarArgs.e(30, this.HSv);
      }
      paramVarArgs.cc(31, this.MaB);
      if (this.MaC != null)
      {
        paramVarArgs.ni(32, this.MaC.computeSize());
        this.MaC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2194;
      }
    }
    label2194:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt;
      if (this.Maf != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Maf);
      }
      paramInt = i;
      if (this.Mag != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Mag);
      }
      i = paramInt;
      if (this.Mah != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Mah);
      }
      paramInt = i;
      if (this.Mai != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Mai);
      }
      i = paramInt;
      if (this.Maj != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Maj);
      }
      i += g.a.a.b.b.a.fS(9) + 1;
      paramInt = i;
      if (this.Mal != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.Mal);
      }
      i = paramInt + g.a.a.b.b.a.r(11, this.Mam) + (g.a.a.b.b.a.fS(12) + 1) + (g.a.a.b.b.a.fS(13) + 1) + (g.a.a.b.b.a.fS(14) + 1);
      paramInt = i;
      if (this.Maq != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.Maq);
      }
      i = paramInt;
      if (this.Mar != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.Mar);
      }
      paramInt = i;
      if (this.Mas != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.Mas);
      }
      i = paramInt;
      if (this.Mat != null) {
        i = paramInt + g.a.a.b.b.a.f(18, this.Mat);
      }
      i = i + (g.a.a.b.b.a.fS(19) + 1) + g.a.a.a.c(20, 1, this.Mav) + (g.a.a.b.b.a.fS(21) + 1);
      paramInt = i;
      if (this.Maw != null) {
        paramInt = i + g.a.a.a.nh(22, this.Maw.computeSize());
      }
      i = paramInt + (g.a.a.b.b.a.fS(23) + 1) + (g.a.a.b.b.a.fS(26) + 1) + (g.a.a.b.b.a.fS(27) + 1) + g.a.a.a.c(28, 8, this.MaA);
      paramInt = i;
      if (this.HSu != null) {
        paramInt = i + g.a.a.b.b.a.f(29, this.HSu);
      }
      i = paramInt;
      if (this.HSv != null) {
        i = paramInt + g.a.a.b.b.a.f(30, this.HSv);
      }
      i += g.a.a.b.b.a.fS(31) + 1;
      paramInt = i;
      if (this.MaC != null) {
        paramInt = i + g.a.a.a.nh(32, this.MaC.computeSize());
      }
      AppMethodBeat.o(91510);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mav.clear();
        this.MaA.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91510);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        btr localbtr = (btr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 24: 
        case 25: 
        default: 
          AppMethodBeat.o(91510);
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
            localbtr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 2: 
          localbtr.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91510);
          return 0;
        case 3: 
          localbtr.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 4: 
          localbtr.Maf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 5: 
          localbtr.Mag = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 6: 
          localbtr.Mah = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 7: 
          localbtr.Mai = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 8: 
          localbtr.Maj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 9: 
          localbtr.Mak = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91510);
          return 0;
        case 10: 
          localbtr.Mal = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 11: 
          localbtr.Mam = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91510);
          return 0;
        case 12: 
          localbtr.Man = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91510);
          return 0;
        case 13: 
          localbtr.Mao = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91510);
          return 0;
        case 14: 
          localbtr.Map = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91510);
          return 0;
        case 15: 
          localbtr.Maq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 16: 
          localbtr.Mar = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 17: 
          localbtr.Mas = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 18: 
          localbtr.Mat = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 19: 
          localbtr.Mau = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91510);
          return 0;
        case 20: 
          localbtr.Mav.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(91510);
          return 0;
        case 21: 
          localbtr.HPI = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91510);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbtr.Maw = ((cfm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 23: 
          localbtr.Max = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91510);
          return 0;
        case 26: 
          localbtr.May = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91510);
          return 0;
        case 27: 
          localbtr.Maz = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91510);
          return 0;
        case 28: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbtr.MaA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 29: 
          localbtr.HSu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 30: 
          localbtr.HSv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 31: 
          localbtr.MaB = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91510);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbtr.MaC = ((ebx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91510);
        return 0;
      }
      AppMethodBeat.o(91510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btr
 * JD-Core Version:    0.7.0.1
 */