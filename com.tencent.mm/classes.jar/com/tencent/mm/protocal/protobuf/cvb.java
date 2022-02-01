package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cvb
  extends esc
{
  public LinkedList<bzo> YFB;
  public boolean aaAA;
  public LinkedList<gnv> aaAF;
  public LinkedList<gnw> aaAG;
  public String aaAH;
  public String aaAI;
  public String aaAJ;
  public String aaAK;
  public boolean aaAL;
  public int aaAM;
  public String aaAN;
  public LinkedList<String> aaAw;
  public String aaAx;
  public String aaAy;
  public String nRL;
  public boolean yut;
  
  public cvb()
  {
    AppMethodBeat.i(32282);
    this.aaAF = new LinkedList();
    this.aaAG = new LinkedList();
    this.aaAw = new LinkedList();
    this.YFB = new LinkedList();
    AppMethodBeat.o(32282);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32283);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.aaAH == null)
      {
        paramVarArgs = new b("Not all required fields were included: championcoverurl");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.aaAI == null)
      {
        paramVarArgs = new b("Not all required fields were included: championmotto");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.nRL == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankid");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aaAF);
      paramVarArgs.e(3, 8, this.aaAG);
      paramVarArgs.e(4, 1, this.aaAw);
      if (this.aaAH != null) {
        paramVarArgs.g(5, this.aaAH);
      }
      if (this.aaAI != null) {
        paramVarArgs.g(6, this.aaAI);
      }
      if (this.nRL != null) {
        paramVarArgs.g(7, this.nRL);
      }
      if (this.aaAJ != null) {
        paramVarArgs.g(8, this.aaAJ);
      }
      if (this.aaAx != null) {
        paramVarArgs.g(9, this.aaAx);
      }
      paramVarArgs.di(10, this.yut);
      if (this.aaAy != null) {
        paramVarArgs.g(11, this.aaAy);
      }
      paramVarArgs.e(12, 8, this.YFB);
      paramVarArgs.di(13, this.aaAA);
      if (this.aaAK != null) {
        paramVarArgs.g(14, this.aaAK);
      }
      paramVarArgs.di(15, this.aaAL);
      paramVarArgs.bS(16, this.aaAM);
      if (this.aaAN != null) {
        paramVarArgs.g(17, this.aaAN);
      }
      AppMethodBeat.o(32283);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1585;
      }
    }
    label1585:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aaAF) + i.a.a.a.c(3, 8, this.aaAG) + i.a.a.a.c(4, 1, this.aaAw);
      paramInt = i;
      if (this.aaAH != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaAH);
      }
      i = paramInt;
      if (this.aaAI != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aaAI);
      }
      paramInt = i;
      if (this.nRL != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.nRL);
      }
      i = paramInt;
      if (this.aaAJ != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aaAJ);
      }
      paramInt = i;
      if (this.aaAx != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aaAx);
      }
      i = paramInt + (i.a.a.b.b.a.ko(10) + 1);
      paramInt = i;
      if (this.aaAy != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.aaAy);
      }
      i = paramInt + i.a.a.a.c(12, 8, this.YFB) + (i.a.a.b.b.a.ko(13) + 1);
      paramInt = i;
      if (this.aaAK != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.aaAK);
      }
      i = paramInt + (i.a.a.b.b.a.ko(15) + 1) + i.a.a.b.b.a.cJ(16, this.aaAM);
      paramInt = i;
      if (this.aaAN != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.aaAN);
      }
      AppMethodBeat.o(32283);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaAF.clear();
        this.aaAG.clear();
        this.aaAw.clear();
        this.YFB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.aaAH == null)
        {
          paramVarArgs = new b("Not all required fields were included: championcoverurl");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.aaAI == null)
        {
          paramVarArgs = new b("Not all required fields were included: championmotto");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.nRL == null)
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
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cvb localcvb = (cvb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32283);
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
            localcvb.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gnv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gnv)localObject2).parseFrom((byte[])localObject1);
            }
            localcvb.aaAF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gnw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gnw)localObject2).parseFrom((byte[])localObject1);
            }
            localcvb.aaAG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 4: 
          localcvb.aaAw.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(32283);
          return 0;
        case 5: 
          localcvb.aaAH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 6: 
          localcvb.aaAI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 7: 
          localcvb.nRL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 8: 
          localcvb.aaAJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 9: 
          localcvb.aaAx = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 10: 
          localcvb.yut = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(32283);
          return 0;
        case 11: 
          localcvb.aaAy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bzo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bzo)localObject2).parseFrom((byte[])localObject1);
            }
            localcvb.YFB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 13: 
          localcvb.aaAA = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(32283);
          return 0;
        case 14: 
          localcvb.aaAK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 15: 
          localcvb.aaAL = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(32283);
          return 0;
        case 16: 
          localcvb.aaAM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32283);
          return 0;
        }
        localcvb.aaAN = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32283);
        return 0;
      }
      AppMethodBeat.o(32283);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvb
 * JD-Core Version:    0.7.0.1
 */