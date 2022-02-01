package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ela
  extends esc
{
  public int Kmo;
  public int Kmp;
  public String Kmq;
  public String Kmr;
  public String Kms;
  public long Oll;
  public int YzO;
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
  
  public ela()
  {
    AppMethodBeat.i(91656);
    this.abdH = new LinkedList();
    AppMethodBeat.o(91656);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91657);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91657);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.ihV);
      paramVarArgs.bS(3, this.abdF);
      paramVarArgs.bv(4, this.abdG);
      paramVarArgs.bS(5, this.YzO);
      paramVarArgs.bv(6, this.Oll);
      paramVarArgs.bS(9, this.Kmp);
      paramVarArgs.e(10, 8, this.abdH);
      if (this.Kmq != null) {
        paramVarArgs.g(11, this.Kmq);
      }
      if (this.abdI != null) {
        paramVarArgs.g(12, this.abdI);
      }
      if (this.abdJ != null) {
        paramVarArgs.g(13, this.abdJ);
      }
      if (this.abdK != null) {
        paramVarArgs.g(14, this.abdK);
      }
      paramVarArgs.bS(15, this.abdL);
      if (this.Kms != null) {
        paramVarArgs.g(16, this.Kms);
      }
      paramVarArgs.bS(17, this.abdM);
      if (this.Kmr != null) {
        paramVarArgs.g(18, this.Kmr);
      }
      paramVarArgs.bS(19, this.abdE);
      paramVarArgs.bS(20, this.Kmo);
      paramVarArgs.bS(21, this.abdD);
      if (this.abdN != null) {
        paramVarArgs.g(22, this.abdN);
      }
      AppMethodBeat.o(91657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1378;
      }
    }
    label1378:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.ihV) + i.a.a.b.b.a.cJ(3, this.abdF) + i.a.a.b.b.a.q(4, this.abdG) + i.a.a.b.b.a.cJ(5, this.YzO) + i.a.a.b.b.a.q(6, this.Oll) + i.a.a.b.b.a.cJ(9, this.Kmp) + i.a.a.a.c(10, 8, this.abdH);
      paramInt = i;
      if (this.Kmq != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.Kmq);
      }
      i = paramInt;
      if (this.abdI != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.abdI);
      }
      paramInt = i;
      if (this.abdJ != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.abdJ);
      }
      i = paramInt;
      if (this.abdK != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.abdK);
      }
      i += i.a.a.b.b.a.cJ(15, this.abdL);
      paramInt = i;
      if (this.Kms != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.Kms);
      }
      i = paramInt + i.a.a.b.b.a.cJ(17, this.abdM);
      paramInt = i;
      if (this.Kmr != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.Kmr);
      }
      i = paramInt + i.a.a.b.b.a.cJ(19, this.abdE) + i.a.a.b.b.a.cJ(20, this.Kmo) + i.a.a.b.b.a.cJ(21, this.abdD);
      paramInt = i;
      if (this.abdN != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.abdN);
      }
      AppMethodBeat.o(91657);
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
          AppMethodBeat.o(91657);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91657);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ela localela = (ela)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(91657);
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
            localela.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91657);
          return 0;
        case 2: 
          localela.ihV = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91657);
          return 0;
        case 3: 
          localela.abdF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91657);
          return 0;
        case 4: 
          localela.abdG = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91657);
          return 0;
        case 5: 
          localela.YzO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91657);
          return 0;
        case 6: 
          localela.Oll = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91657);
          return 0;
        case 9: 
          localela.Kmp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91657);
          return 0;
        case 10: 
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
            localela.abdH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91657);
          return 0;
        case 11: 
          localela.Kmq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 12: 
          localela.abdI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 13: 
          localela.abdJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 14: 
          localela.abdK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 15: 
          localela.abdL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91657);
          return 0;
        case 16: 
          localela.Kms = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 17: 
          localela.abdM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91657);
          return 0;
        case 18: 
          localela.Kmr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 19: 
          localela.abdE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91657);
          return 0;
        case 20: 
          localela.Kmo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91657);
          return 0;
        case 21: 
          localela.abdD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91657);
          return 0;
        }
        localela.abdN = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91657);
        return 0;
      }
      AppMethodBeat.o(91657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ela
 * JD-Core Version:    0.7.0.1
 */