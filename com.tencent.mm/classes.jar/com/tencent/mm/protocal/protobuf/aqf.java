package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqf
  extends esc
{
  public String CAf;
  public int Kos;
  public String Kot;
  public String Kou;
  public String Kov;
  public int Kow;
  public String Kox;
  public String Koy;
  public String Ksi;
  public eme Zgn;
  public dcm ZxA;
  public com.tencent.mm.bx.b Zxz;
  public int amount;
  public int hAV;
  public int hDx;
  public int ihA;
  public int ihz;
  public String wYI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91453);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91453);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      paramVarArgs.bS(4, this.hDx);
      if (this.CAf != null) {
        paramVarArgs.g(5, this.CAf);
      }
      paramVarArgs.bS(6, this.ihz);
      paramVarArgs.bS(7, this.ihA);
      if (this.Ksi != null) {
        paramVarArgs.g(8, this.Ksi);
      }
      paramVarArgs.bS(9, this.amount);
      if (this.Zgn != null)
      {
        paramVarArgs.qD(10, this.Zgn.computeSize());
        this.Zgn.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.Kos);
      if (this.Kot != null) {
        paramVarArgs.g(12, this.Kot);
      }
      if (this.Kou != null) {
        paramVarArgs.g(13, this.Kou);
      }
      if (this.Kov != null) {
        paramVarArgs.g(14, this.Kov);
      }
      paramVarArgs.bS(15, this.Kow);
      if (this.Kox != null) {
        paramVarArgs.g(16, this.Kox);
      }
      if (this.Koy != null) {
        paramVarArgs.g(17, this.Koy);
      }
      if (this.ZxA != null)
      {
        paramVarArgs.qD(18, this.ZxA.computeSize());
        this.ZxA.writeFields(paramVarArgs);
      }
      if (this.Zxz != null) {
        paramVarArgs.d(19, this.Zxz);
      }
      AppMethodBeat.o(91453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1472;
      }
    }
    label1472:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.hDx);
      paramInt = i;
      if (this.CAf != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.CAf);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.ihz) + i.a.a.b.b.a.cJ(7, this.ihA);
      paramInt = i;
      if (this.Ksi != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.Ksi);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.amount);
      paramInt = i;
      if (this.Zgn != null) {
        paramInt = i + i.a.a.a.qC(10, this.Zgn.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.Kos);
      paramInt = i;
      if (this.Kot != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.Kot);
      }
      i = paramInt;
      if (this.Kou != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.Kou);
      }
      paramInt = i;
      if (this.Kov != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.Kov);
      }
      i = paramInt + i.a.a.b.b.a.cJ(15, this.Kow);
      paramInt = i;
      if (this.Kox != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.Kox);
      }
      i = paramInt;
      if (this.Koy != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.Koy);
      }
      paramInt = i;
      if (this.ZxA != null) {
        paramInt = i + i.a.a.a.qC(18, this.ZxA.computeSize());
      }
      i = paramInt;
      if (this.Zxz != null) {
        i = paramInt + i.a.a.b.b.a.c(19, this.Zxz);
      }
      AppMethodBeat.o(91453);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91453);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91453);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aqf localaqf = (aqf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91453);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localaqf.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91453);
          return 0;
        case 2: 
          localaqf.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91453);
          return 0;
        case 3: 
          localaqf.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 4: 
          localaqf.hDx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91453);
          return 0;
        case 5: 
          localaqf.CAf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 6: 
          localaqf.ihz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91453);
          return 0;
        case 7: 
          localaqf.ihA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91453);
          return 0;
        case 8: 
          localaqf.Ksi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 9: 
          localaqf.amount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91453);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eme();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eme)localObject2).parseFrom((byte[])localObject1);
            }
            localaqf.Zgn = ((eme)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91453);
          return 0;
        case 11: 
          localaqf.Kos = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91453);
          return 0;
        case 12: 
          localaqf.Kot = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 13: 
          localaqf.Kou = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 14: 
          localaqf.Kov = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 15: 
          localaqf.Kow = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91453);
          return 0;
        case 16: 
          localaqf.Kox = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 17: 
          localaqf.Koy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dcm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dcm)localObject2).parseFrom((byte[])localObject1);
            }
            localaqf.ZxA = ((dcm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91453);
          return 0;
        }
        localaqf.Zxz = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(91453);
        return 0;
      }
      AppMethodBeat.o(91453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqf
 * JD-Core Version:    0.7.0.1
 */