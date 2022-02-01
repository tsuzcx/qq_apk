package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class rh
  extends dop
{
  public int Coi;
  public String CpD;
  public String CpE;
  public String CpG;
  public int CpI;
  public String CpJ;
  public String CpK;
  public String Cpg;
  public String FhU;
  public anr KHP;
  public int KHQ;
  public String KHW;
  public String KYa;
  public String KYg;
  public String KYh;
  public String KYi;
  public int KYj;
  public boolean KYk;
  public boolean KYl;
  public String KYm;
  public int KYn;
  public String KYo;
  public int KYp;
  public int KYq;
  public String KYr;
  public String KYs;
  public int channel;
  public String hFF;
  public String jTz;
  public String nickname;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91374);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KYg == null)
      {
        paramVarArgs = new b("Not all required fields were included: qrcode_id");
        AppMethodBeat.o(91374);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CpJ != null) {
        paramVarArgs.e(2, this.CpJ);
      }
      if (this.KYg != null) {
        paramVarArgs.e(3, this.KYg);
      }
      paramVarArgs.aM(4, this.scene);
      if (this.KYh != null) {
        paramVarArgs.e(5, this.KYh);
      }
      if (this.CpD != null) {
        paramVarArgs.e(6, this.CpD);
      }
      paramVarArgs.aM(7, this.KHQ);
      paramVarArgs.aM(8, this.channel);
      if (this.CpK != null) {
        paramVarArgs.e(9, this.CpK);
      }
      if (this.CpE != null) {
        paramVarArgs.e(10, this.CpE);
      }
      if (this.KYi != null) {
        paramVarArgs.e(11, this.KYi);
      }
      paramVarArgs.aM(12, this.KYj);
      paramVarArgs.aM(13, this.CpI);
      if (this.jTz != null) {
        paramVarArgs.e(14, this.jTz);
      }
      if (this.KHP != null)
      {
        paramVarArgs.ni(15, this.KHP.computeSize());
        this.KHP.writeFields(paramVarArgs);
      }
      if (this.KYa != null) {
        paramVarArgs.e(16, this.KYa);
      }
      paramVarArgs.aM(17, this.Coi);
      paramVarArgs.cc(18, this.KYk);
      paramVarArgs.cc(19, this.KYl);
      if (this.FhU != null) {
        paramVarArgs.e(20, this.FhU);
      }
      if (this.hFF != null) {
        paramVarArgs.e(21, this.hFF);
      }
      if (this.KYm != null) {
        paramVarArgs.e(22, this.KYm);
      }
      if (this.CpG != null) {
        paramVarArgs.e(23, this.CpG);
      }
      if (this.nickname != null) {
        paramVarArgs.e(24, this.nickname);
      }
      if (this.Cpg != null) {
        paramVarArgs.e(25, this.Cpg);
      }
      paramVarArgs.aM(26, this.KYn);
      if (this.KYo != null) {
        paramVarArgs.e(27, this.KYo);
      }
      paramVarArgs.aM(28, this.KYp);
      paramVarArgs.aM(29, this.KYq);
      if (this.KHW != null) {
        paramVarArgs.e(30, this.KHW);
      }
      if (this.KYr != null) {
        paramVarArgs.e(31, this.KYr);
      }
      if (this.KYs != null) {
        paramVarArgs.e(32, this.KYs);
      }
      AppMethodBeat.o(91374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2178;
      }
    }
    label2178:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CpJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.CpJ);
      }
      i = paramInt;
      if (this.KYg != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KYg);
      }
      i += g.a.a.b.b.a.bu(4, this.scene);
      paramInt = i;
      if (this.KYh != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KYh);
      }
      i = paramInt;
      if (this.CpD != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.CpD);
      }
      i = i + g.a.a.b.b.a.bu(7, this.KHQ) + g.a.a.b.b.a.bu(8, this.channel);
      paramInt = i;
      if (this.CpK != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.CpK);
      }
      i = paramInt;
      if (this.CpE != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.CpE);
      }
      paramInt = i;
      if (this.KYi != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.KYi);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.KYj) + g.a.a.b.b.a.bu(13, this.CpI);
      paramInt = i;
      if (this.jTz != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.jTz);
      }
      i = paramInt;
      if (this.KHP != null) {
        i = paramInt + g.a.a.a.nh(15, this.KHP.computeSize());
      }
      paramInt = i;
      if (this.KYa != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.KYa);
      }
      i = paramInt + g.a.a.b.b.a.bu(17, this.Coi) + (g.a.a.b.b.a.fS(18) + 1) + (g.a.a.b.b.a.fS(19) + 1);
      paramInt = i;
      if (this.FhU != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.FhU);
      }
      i = paramInt;
      if (this.hFF != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.hFF);
      }
      paramInt = i;
      if (this.KYm != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.KYm);
      }
      i = paramInt;
      if (this.CpG != null) {
        i = paramInt + g.a.a.b.b.a.f(23, this.CpG);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(24, this.nickname);
      }
      i = paramInt;
      if (this.Cpg != null) {
        i = paramInt + g.a.a.b.b.a.f(25, this.Cpg);
      }
      i += g.a.a.b.b.a.bu(26, this.KYn);
      paramInt = i;
      if (this.KYo != null) {
        paramInt = i + g.a.a.b.b.a.f(27, this.KYo);
      }
      i = paramInt + g.a.a.b.b.a.bu(28, this.KYp) + g.a.a.b.b.a.bu(29, this.KYq);
      paramInt = i;
      if (this.KHW != null) {
        paramInt = i + g.a.a.b.b.a.f(30, this.KHW);
      }
      i = paramInt;
      if (this.KYr != null) {
        i = paramInt + g.a.a.b.b.a.f(31, this.KYr);
      }
      paramInt = i;
      if (this.KYs != null) {
        paramInt = i + g.a.a.b.b.a.f(32, this.KYs);
      }
      AppMethodBeat.o(91374);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KYg == null)
        {
          paramVarArgs = new b("Not all required fields were included: qrcode_id");
          AppMethodBeat.o(91374);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91374);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        rh localrh = (rh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91374);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localrh.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91374);
          return 0;
        case 2: 
          localrh.CpJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 3: 
          localrh.KYg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 4: 
          localrh.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91374);
          return 0;
        case 5: 
          localrh.KYh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 6: 
          localrh.CpD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 7: 
          localrh.KHQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91374);
          return 0;
        case 8: 
          localrh.channel = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91374);
          return 0;
        case 9: 
          localrh.CpK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 10: 
          localrh.CpE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 11: 
          localrh.KYi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 12: 
          localrh.KYj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91374);
          return 0;
        case 13: 
          localrh.CpI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91374);
          return 0;
        case 14: 
          localrh.jTz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((anr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localrh.KHP = ((anr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91374);
          return 0;
        case 16: 
          localrh.KYa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 17: 
          localrh.Coi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91374);
          return 0;
        case 18: 
          localrh.KYk = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91374);
          return 0;
        case 19: 
          localrh.KYl = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91374);
          return 0;
        case 20: 
          localrh.FhU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 21: 
          localrh.hFF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 22: 
          localrh.KYm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 23: 
          localrh.CpG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 24: 
          localrh.nickname = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 25: 
          localrh.Cpg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 26: 
          localrh.KYn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91374);
          return 0;
        case 27: 
          localrh.KYo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 28: 
          localrh.KYp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91374);
          return 0;
        case 29: 
          localrh.KYq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91374);
          return 0;
        case 30: 
          localrh.KHW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 31: 
          localrh.KYr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91374);
          return 0;
        }
        localrh.KYs = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91374);
        return 0;
      }
      AppMethodBeat.o(91374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rh
 * JD-Core Version:    0.7.0.1
 */