package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eia
  extends esc
{
  public int JGZ;
  public String JHa;
  public int JHe;
  public int JHk;
  public int JHl;
  public int JHm;
  public com.tencent.mm.bx.b JHn;
  public int JHp;
  public int JHs;
  public LinkedList<ehs> YKL;
  public long ZvA;
  public int Zvz;
  public long abmR;
  public int abna;
  public int abnb;
  public LinkedList<ehs> abnc;
  public String abnd;
  public com.tencent.mm.bx.b abne;
  public int abnf;
  
  public eia()
  {
    AppMethodBeat.i(32379);
    this.YKL = new LinkedList();
    this.abnc = new LinkedList();
    AppMethodBeat.o(32379);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32380);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32380);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zvz);
      paramVarArgs.bv(3, this.ZvA);
      paramVarArgs.bS(4, this.abna);
      paramVarArgs.e(5, 8, this.YKL);
      paramVarArgs.bS(6, this.abnb);
      paramVarArgs.bS(7, this.JHk);
      paramVarArgs.bS(8, this.JHl);
      paramVarArgs.bv(9, this.abmR);
      paramVarArgs.bS(10, this.JHm);
      if (this.JHn != null) {
        paramVarArgs.d(11, this.JHn);
      }
      paramVarArgs.bS(12, this.JHe);
      paramVarArgs.bS(13, this.JGZ);
      if (this.JHa != null) {
        paramVarArgs.g(14, this.JHa);
      }
      paramVarArgs.bS(15, this.JHp);
      paramVarArgs.e(16, 8, this.abnc);
      paramVarArgs.bS(17, this.JHs);
      if (this.abnd != null) {
        paramVarArgs.g(18, this.abnd);
      }
      if (this.abne != null) {
        paramVarArgs.d(19, this.abne);
      }
      paramVarArgs.bS(20, this.abnf);
      AppMethodBeat.o(32380);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1418;
      }
    }
    label1418:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Zvz) + i.a.a.b.b.a.q(3, this.ZvA) + i.a.a.b.b.a.cJ(4, this.abna) + i.a.a.a.c(5, 8, this.YKL) + i.a.a.b.b.a.cJ(6, this.abnb) + i.a.a.b.b.a.cJ(7, this.JHk) + i.a.a.b.b.a.cJ(8, this.JHl) + i.a.a.b.b.a.q(9, this.abmR) + i.a.a.b.b.a.cJ(10, this.JHm);
      paramInt = i;
      if (this.JHn != null) {
        paramInt = i + i.a.a.b.b.a.c(11, this.JHn);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.JHe) + i.a.a.b.b.a.cJ(13, this.JGZ);
      paramInt = i;
      if (this.JHa != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.JHa);
      }
      i = paramInt + i.a.a.b.b.a.cJ(15, this.JHp) + i.a.a.a.c(16, 8, this.abnc) + i.a.a.b.b.a.cJ(17, this.JHs);
      paramInt = i;
      if (this.abnd != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.abnd);
      }
      i = paramInt;
      if (this.abne != null) {
        i = paramInt + i.a.a.b.b.a.c(19, this.abne);
      }
      paramInt = i.a.a.b.b.a.cJ(20, this.abnf);
      AppMethodBeat.o(32380);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YKL.clear();
        this.abnc.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32380);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32380);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eia localeia = (eia)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32380);
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
            localeia.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 2: 
          localeia.Zvz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32380);
          return 0;
        case 3: 
          localeia.ZvA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(32380);
          return 0;
        case 4: 
          localeia.abna = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32380);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ehs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ehs)localObject2).parseFrom((byte[])localObject1);
            }
            localeia.YKL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 6: 
          localeia.abnb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32380);
          return 0;
        case 7: 
          localeia.JHk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32380);
          return 0;
        case 8: 
          localeia.JHl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32380);
          return 0;
        case 9: 
          localeia.abmR = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(32380);
          return 0;
        case 10: 
          localeia.JHm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32380);
          return 0;
        case 11: 
          localeia.JHn = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(32380);
          return 0;
        case 12: 
          localeia.JHe = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32380);
          return 0;
        case 13: 
          localeia.JGZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32380);
          return 0;
        case 14: 
          localeia.JHa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32380);
          return 0;
        case 15: 
          localeia.JHp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32380);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ehs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ehs)localObject2).parseFrom((byte[])localObject1);
            }
            localeia.abnc.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 17: 
          localeia.JHs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32380);
          return 0;
        case 18: 
          localeia.abnd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32380);
          return 0;
        case 19: 
          localeia.abne = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(32380);
          return 0;
        }
        localeia.abnf = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32380);
        return 0;
      }
      AppMethodBeat.o(32380);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eia
 * JD-Core Version:    0.7.0.1
 */