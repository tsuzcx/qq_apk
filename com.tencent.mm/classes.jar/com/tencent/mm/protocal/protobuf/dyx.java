package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dyx
  extends esc
{
  public int Kmo;
  public int Kmp;
  public String Kmq;
  public String Kmr;
  public String Kms;
  public long Oll;
  public int YzO;
  public eme Zgn;
  public int abdD;
  public int abdE;
  public int abdF;
  public long abdG;
  public LinkedList<cyk> abdH;
  public String abdI;
  public String abdJ;
  public String abdK;
  public int abdL;
  public int abdM;
  public String abdN;
  public long ihV;
  
  public dyx()
  {
    AppMethodBeat.i(91566);
    this.abdH = new LinkedList();
    AppMethodBeat.o(91566);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91567);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91567);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abdD);
      paramVarArgs.bS(3, this.abdE);
      paramVarArgs.bS(4, this.Kmo);
      paramVarArgs.bv(5, this.ihV);
      paramVarArgs.bS(6, this.abdF);
      paramVarArgs.bv(7, this.abdG);
      paramVarArgs.bS(8, this.YzO);
      paramVarArgs.bv(9, this.Oll);
      paramVarArgs.bS(10, this.Kmp);
      paramVarArgs.e(11, 8, this.abdH);
      if (this.Kmq != null) {
        paramVarArgs.g(12, this.Kmq);
      }
      if (this.abdI != null) {
        paramVarArgs.g(13, this.abdI);
      }
      if (this.abdJ != null) {
        paramVarArgs.g(14, this.abdJ);
      }
      if (this.abdK != null) {
        paramVarArgs.g(15, this.abdK);
      }
      paramVarArgs.bS(16, this.abdL);
      if (this.Kms != null) {
        paramVarArgs.g(17, this.Kms);
      }
      paramVarArgs.bS(18, this.abdM);
      if (this.Kmr != null) {
        paramVarArgs.g(19, this.Kmr);
      }
      if (this.Zgn != null)
      {
        paramVarArgs.qD(20, this.Zgn.computeSize());
        this.Zgn.writeFields(paramVarArgs);
      }
      if (this.abdN != null) {
        paramVarArgs.g(21, this.abdN);
      }
      AppMethodBeat.o(91567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1504;
      }
    }
    label1504:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abdD) + i.a.a.b.b.a.cJ(3, this.abdE) + i.a.a.b.b.a.cJ(4, this.Kmo) + i.a.a.b.b.a.q(5, this.ihV) + i.a.a.b.b.a.cJ(6, this.abdF) + i.a.a.b.b.a.q(7, this.abdG) + i.a.a.b.b.a.cJ(8, this.YzO) + i.a.a.b.b.a.q(9, this.Oll) + i.a.a.b.b.a.cJ(10, this.Kmp) + i.a.a.a.c(11, 8, this.abdH);
      paramInt = i;
      if (this.Kmq != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.Kmq);
      }
      i = paramInt;
      if (this.abdI != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.abdI);
      }
      paramInt = i;
      if (this.abdJ != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.abdJ);
      }
      i = paramInt;
      if (this.abdK != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.abdK);
      }
      i += i.a.a.b.b.a.cJ(16, this.abdL);
      paramInt = i;
      if (this.Kms != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.Kms);
      }
      i = paramInt + i.a.a.b.b.a.cJ(18, this.abdM);
      paramInt = i;
      if (this.Kmr != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.Kmr);
      }
      i = paramInt;
      if (this.Zgn != null) {
        i = paramInt + i.a.a.a.qC(20, this.Zgn.computeSize());
      }
      paramInt = i;
      if (this.abdN != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.abdN);
      }
      AppMethodBeat.o(91567);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abdH.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dyx localdyx = (dyx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91567);
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
            localdyx.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        case 2: 
          localdyx.abdD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91567);
          return 0;
        case 3: 
          localdyx.abdE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91567);
          return 0;
        case 4: 
          localdyx.Kmo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91567);
          return 0;
        case 5: 
          localdyx.ihV = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91567);
          return 0;
        case 6: 
          localdyx.abdF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91567);
          return 0;
        case 7: 
          localdyx.abdG = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91567);
          return 0;
        case 8: 
          localdyx.YzO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91567);
          return 0;
        case 9: 
          localdyx.Oll = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91567);
          return 0;
        case 10: 
          localdyx.Kmp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91567);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cyk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cyk)localObject2).parseFrom((byte[])localObject1);
            }
            localdyx.abdH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        case 12: 
          localdyx.Kmq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 13: 
          localdyx.abdI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 14: 
          localdyx.abdJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 15: 
          localdyx.abdK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 16: 
          localdyx.abdL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91567);
          return 0;
        case 17: 
          localdyx.Kms = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 18: 
          localdyx.abdM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91567);
          return 0;
        case 19: 
          localdyx.Kmr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 20: 
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
            localdyx.Zgn = ((eme)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        }
        localdyx.abdN = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91567);
        return 0;
      }
      AppMethodBeat.o(91567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyx
 * JD-Core Version:    0.7.0.1
 */