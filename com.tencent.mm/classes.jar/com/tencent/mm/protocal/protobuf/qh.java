package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qh
  extends cwj
{
  public String FOf;
  public String FOg;
  public String FOh;
  public String GdO;
  public String Gec;
  public dez Ged;
  public String Gee;
  public String Gef;
  public int Geg;
  public int Geh;
  public int Gei;
  public dok Gej;
  public String Gek;
  public int Gel;
  public int Gem;
  public int Gen;
  public com.tencent.mm.bw.b Geo;
  public int Gep;
  public int Geq;
  public int Ger;
  public qa Ges;
  public dq Get;
  public dp Geu;
  public xu Gev;
  public String dwj;
  public int oGt;
  public String oGu;
  public int yoA = 0;
  public String yoB;
  public String yoC;
  public String yoD;
  public String yoE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91375);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91375);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      if (this.dwj != null) {
        paramVarArgs.d(4, this.dwj);
      }
      if (this.Gec != null) {
        paramVarArgs.d(5, this.Gec);
      }
      if (this.Ged != null)
      {
        paramVarArgs.lJ(6, this.Ged.computeSize());
        this.Ged.writeFields(paramVarArgs);
      }
      if (this.FOf != null) {
        paramVarArgs.d(7, this.FOf);
      }
      if (this.FOh != null) {
        paramVarArgs.d(8, this.FOh);
      }
      if (this.Gee != null) {
        paramVarArgs.d(9, this.Gee);
      }
      if (this.Gef != null) {
        paramVarArgs.d(10, this.Gef);
      }
      paramVarArgs.aS(11, this.Geg);
      if (this.FOg != null) {
        paramVarArgs.d(12, this.FOg);
      }
      if (this.GdO != null) {
        paramVarArgs.d(13, this.GdO);
      }
      paramVarArgs.aS(14, this.Geh);
      paramVarArgs.aS(15, this.Gei);
      if (this.Gej != null)
      {
        paramVarArgs.lJ(16, this.Gej.computeSize());
        this.Gej.writeFields(paramVarArgs);
      }
      if (this.Gek != null) {
        paramVarArgs.d(17, this.Gek);
      }
      paramVarArgs.aS(18, this.Gel);
      paramVarArgs.aS(19, this.Gem);
      paramVarArgs.aS(20, this.Gen);
      if (this.Geo != null) {
        paramVarArgs.c(21, this.Geo);
      }
      paramVarArgs.aS(22, this.Gep);
      paramVarArgs.aS(23, this.yoA);
      if (this.yoB != null) {
        paramVarArgs.d(24, this.yoB);
      }
      if (this.yoC != null) {
        paramVarArgs.d(25, this.yoC);
      }
      paramVarArgs.aS(26, this.Geq);
      if (this.yoD != null) {
        paramVarArgs.d(27, this.yoD);
      }
      if (this.yoE != null) {
        paramVarArgs.d(28, this.yoE);
      }
      paramVarArgs.aS(29, this.Ger);
      if (this.Ges != null)
      {
        paramVarArgs.lJ(30, this.Ges.computeSize());
        this.Ges.writeFields(paramVarArgs);
      }
      if (this.Get != null)
      {
        paramVarArgs.lJ(31, this.Get.computeSize());
        this.Get.writeFields(paramVarArgs);
      }
      if (this.Geu != null)
      {
        paramVarArgs.lJ(32, this.Geu.computeSize());
        this.Geu.writeFields(paramVarArgs);
      }
      if (this.Gev != null)
      {
        paramVarArgs.lJ(33, this.Gev.computeSize());
        this.Gev.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91375);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2714;
      }
    }
    label2714:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt;
      if (this.dwj != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dwj);
      }
      paramInt = i;
      if (this.Gec != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gec);
      }
      i = paramInt;
      if (this.Ged != null) {
        i = paramInt + f.a.a.a.lI(6, this.Ged.computeSize());
      }
      paramInt = i;
      if (this.FOf != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FOf);
      }
      i = paramInt;
      if (this.FOh != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FOh);
      }
      paramInt = i;
      if (this.Gee != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Gee);
      }
      i = paramInt;
      if (this.Gef != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Gef);
      }
      i += f.a.a.b.b.a.bz(11, this.Geg);
      paramInt = i;
      if (this.FOg != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FOg);
      }
      i = paramInt;
      if (this.GdO != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.GdO);
      }
      i = i + f.a.a.b.b.a.bz(14, this.Geh) + f.a.a.b.b.a.bz(15, this.Gei);
      paramInt = i;
      if (this.Gej != null) {
        paramInt = i + f.a.a.a.lI(16, this.Gej.computeSize());
      }
      i = paramInt;
      if (this.Gek != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.Gek);
      }
      i = i + f.a.a.b.b.a.bz(18, this.Gel) + f.a.a.b.b.a.bz(19, this.Gem) + f.a.a.b.b.a.bz(20, this.Gen);
      paramInt = i;
      if (this.Geo != null) {
        paramInt = i + f.a.a.b.b.a.b(21, this.Geo);
      }
      i = paramInt + f.a.a.b.b.a.bz(22, this.Gep) + f.a.a.b.b.a.bz(23, this.yoA);
      paramInt = i;
      if (this.yoB != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.yoB);
      }
      i = paramInt;
      if (this.yoC != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.yoC);
      }
      i += f.a.a.b.b.a.bz(26, this.Geq);
      paramInt = i;
      if (this.yoD != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.yoD);
      }
      i = paramInt;
      if (this.yoE != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.yoE);
      }
      i += f.a.a.b.b.a.bz(29, this.Ger);
      paramInt = i;
      if (this.Ges != null) {
        paramInt = i + f.a.a.a.lI(30, this.Ges.computeSize());
      }
      i = paramInt;
      if (this.Get != null) {
        i = paramInt + f.a.a.a.lI(31, this.Get.computeSize());
      }
      paramInt = i;
      if (this.Geu != null) {
        paramInt = i + f.a.a.a.lI(32, this.Geu.computeSize());
      }
      i = paramInt;
      if (this.Gev != null) {
        i = paramInt + f.a.a.a.lI(33, this.Gev.computeSize());
      }
      AppMethodBeat.o(91375);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91375);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91375);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qh localqh = (qh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91375);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 2: 
          localqh.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 3: 
          localqh.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 4: 
          localqh.dwj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 5: 
          localqh.Gec = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dez();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dez)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqh.Ged = ((dez)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 7: 
          localqh.FOf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 8: 
          localqh.FOh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 9: 
          localqh.Gee = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 10: 
          localqh.Gef = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 11: 
          localqh.Geg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 12: 
          localqh.FOg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 13: 
          localqh.GdO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 14: 
          localqh.Geh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 15: 
          localqh.Gei = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dok();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dok)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqh.Gej = ((dok)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 17: 
          localqh.Gek = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 18: 
          localqh.Gel = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 19: 
          localqh.Gem = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 20: 
          localqh.Gen = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 21: 
          localqh.Geo = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(91375);
          return 0;
        case 22: 
          localqh.Gep = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 23: 
          localqh.yoA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 24: 
          localqh.yoB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 25: 
          localqh.yoC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 26: 
          localqh.Geq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 27: 
          localqh.yoD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 28: 
          localqh.yoE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 29: 
          localqh.Ger = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91375);
          return 0;
        case 30: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqh.Ges = ((qa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 31: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqh.Get = ((dq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 32: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqh.Geu = ((dp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqh.Gev = ((xu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91375);
        return 0;
      }
      AppMethodBeat.o(91375);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qh
 * JD-Core Version:    0.7.0.1
 */