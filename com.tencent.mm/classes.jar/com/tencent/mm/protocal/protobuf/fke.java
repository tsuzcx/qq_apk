package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fke
  extends esc
{
  public LinkedList<fkc> IHs;
  public com.tencent.mm.bx.b aaxD;
  public String abKO;
  public fkh abKP;
  public String abKQ;
  public String abKR;
  public int abKS;
  public int abKT;
  public int abKU;
  public boolean abKV;
  public String abKW;
  public int abKX;
  public int abKY;
  public int abKZ;
  public int abKz;
  public String abLa;
  public boolean abLb;
  public String abLc;
  public String abLd;
  public int abLe;
  public fkf abLf;
  public int abLg;
  
  public fke()
  {
    AppMethodBeat.i(152706);
    this.IHs = new LinkedList();
    AppMethodBeat.o(152706);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152707);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152707);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.IHs);
      if (this.abKP != null)
      {
        paramVarArgs.qD(3, this.abKP.computeSize());
        this.abKP.writeFields(paramVarArgs);
      }
      if (this.abKQ != null) {
        paramVarArgs.g(4, this.abKQ);
      }
      if (this.abKR != null) {
        paramVarArgs.g(5, this.abKR);
      }
      paramVarArgs.bS(6, this.abKS);
      paramVarArgs.bS(9, this.abKT);
      paramVarArgs.bS(10, this.abKU);
      paramVarArgs.bS(11, this.abKz);
      paramVarArgs.di(12, this.abKV);
      if (this.abKW != null) {
        paramVarArgs.g(13, this.abKW);
      }
      paramVarArgs.bS(14, this.abKX);
      paramVarArgs.bS(15, this.abKY);
      if (this.aaxD != null) {
        paramVarArgs.d(16, this.aaxD);
      }
      paramVarArgs.bS(17, this.abKZ);
      if (this.abLa != null) {
        paramVarArgs.g(18, this.abLa);
      }
      paramVarArgs.di(19, this.abLb);
      if (this.abLc != null) {
        paramVarArgs.g(20, this.abLc);
      }
      if (this.abLd != null) {
        paramVarArgs.g(21, this.abLd);
      }
      paramVarArgs.bS(22, this.abLe);
      if (this.abLf != null)
      {
        paramVarArgs.qD(23, this.abLf.computeSize());
        this.abLf.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(24, this.abLg);
      if (this.abKO != null) {
        paramVarArgs.g(25, this.abKO);
      }
      AppMethodBeat.o(152707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1710;
      }
    }
    label1710:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.IHs);
      paramInt = i;
      if (this.abKP != null) {
        paramInt = i + i.a.a.a.qC(3, this.abKP.computeSize());
      }
      i = paramInt;
      if (this.abKQ != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abKQ);
      }
      paramInt = i;
      if (this.abKR != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abKR);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.abKS) + i.a.a.b.b.a.cJ(9, this.abKT) + i.a.a.b.b.a.cJ(10, this.abKU) + i.a.a.b.b.a.cJ(11, this.abKz) + (i.a.a.b.b.a.ko(12) + 1);
      paramInt = i;
      if (this.abKW != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.abKW);
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.abKX) + i.a.a.b.b.a.cJ(15, this.abKY);
      paramInt = i;
      if (this.aaxD != null) {
        paramInt = i + i.a.a.b.b.a.c(16, this.aaxD);
      }
      i = paramInt + i.a.a.b.b.a.cJ(17, this.abKZ);
      paramInt = i;
      if (this.abLa != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.abLa);
      }
      i = paramInt + (i.a.a.b.b.a.ko(19) + 1);
      paramInt = i;
      if (this.abLc != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.abLc);
      }
      i = paramInt;
      if (this.abLd != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.abLd);
      }
      i += i.a.a.b.b.a.cJ(22, this.abLe);
      paramInt = i;
      if (this.abLf != null) {
        paramInt = i + i.a.a.a.qC(23, this.abLf.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(24, this.abLg);
      paramInt = i;
      if (this.abKO != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.abKO);
      }
      AppMethodBeat.o(152707);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IHs.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152707);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152707);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fke localfke = (fke)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(152707);
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
            localfke.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fkc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fkc)localObject2).parseFrom((byte[])localObject1);
            }
            localfke.IHs.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fkh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fkh)localObject2).parseFrom((byte[])localObject1);
            }
            localfke.abKP = ((fkh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 4: 
          localfke.abKQ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 5: 
          localfke.abKR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 6: 
          localfke.abKS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152707);
          return 0;
        case 9: 
          localfke.abKT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152707);
          return 0;
        case 10: 
          localfke.abKU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152707);
          return 0;
        case 11: 
          localfke.abKz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152707);
          return 0;
        case 12: 
          localfke.abKV = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(152707);
          return 0;
        case 13: 
          localfke.abKW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 14: 
          localfke.abKX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152707);
          return 0;
        case 15: 
          localfke.abKY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152707);
          return 0;
        case 16: 
          localfke.aaxD = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(152707);
          return 0;
        case 17: 
          localfke.abKZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152707);
          return 0;
        case 18: 
          localfke.abLa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 19: 
          localfke.abLb = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(152707);
          return 0;
        case 20: 
          localfke.abLc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 21: 
          localfke.abLd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 22: 
          localfke.abLe = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152707);
          return 0;
        case 23: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fkf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fkf)localObject2).parseFrom((byte[])localObject1);
            }
            localfke.abLf = ((fkf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 24: 
          localfke.abLg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152707);
          return 0;
        }
        localfke.abKO = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(152707);
        return 0;
      }
      AppMethodBeat.o(152707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fke
 * JD-Core Version:    0.7.0.1
 */