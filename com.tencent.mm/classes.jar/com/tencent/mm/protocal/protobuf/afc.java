package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afc
  extends com.tencent.mm.bx.a
{
  public int HJN;
  public int HJO;
  public enx Znp;
  public float Znq;
  public LinkedList<Integer> Znr;
  public boolean Zns;
  public int Znt;
  public enx Znu;
  public dzm Znv;
  public dzm Znw;
  public int audioBitrate;
  public int audioChannelCount;
  public int audioSampleRate;
  public int fps;
  public int nCd;
  public int nxO;
  public int nxP;
  public int oCb;
  public boolean oYa;
  public String outputPath;
  public int videoBitrate;
  
  public afc()
  {
    AppMethodBeat.i(259945);
    this.Znr = new LinkedList();
    AppMethodBeat.o(259945);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259954);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.outputPath != null) {
        paramVarArgs.g(1, this.outputPath);
      }
      paramVarArgs.bS(4, this.HJN);
      paramVarArgs.bS(5, this.HJO);
      if (this.Znp != null)
      {
        paramVarArgs.qD(6, this.Znp.computeSize());
        this.Znp.writeFields(paramVarArgs);
      }
      paramVarArgs.l(7, this.Znq);
      paramVarArgs.bS(8, this.nxO);
      paramVarArgs.bS(9, this.nxP);
      paramVarArgs.bS(10, this.videoBitrate);
      paramVarArgs.bS(11, this.fps);
      paramVarArgs.bS(12, this.nCd);
      paramVarArgs.bS(13, this.audioBitrate);
      paramVarArgs.bS(14, this.audioSampleRate);
      paramVarArgs.bS(15, this.audioChannelCount);
      paramVarArgs.e(16, 2, this.Znr);
      paramVarArgs.bS(17, this.oCb);
      paramVarArgs.di(18, this.Zns);
      paramVarArgs.bS(19, this.Znt);
      paramVarArgs.di(20, this.oYa);
      if (this.Znu != null)
      {
        paramVarArgs.qD(21, this.Znu.computeSize());
        this.Znu.writeFields(paramVarArgs);
      }
      if (this.Znv != null)
      {
        paramVarArgs.qD(22, this.Znv.computeSize());
        this.Znv.writeFields(paramVarArgs);
      }
      if (this.Znw != null)
      {
        paramVarArgs.qD(23, this.Znw.computeSize());
        this.Znw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259954);
      return 0;
    }
    if (paramInt == 1) {
      if (this.outputPath == null) {
        break label1476;
      }
    }
    label1476:
    for (paramInt = i.a.a.b.b.a.h(1, this.outputPath) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(4, this.HJN) + i.a.a.b.b.a.cJ(5, this.HJO);
      paramInt = i;
      if (this.Znp != null) {
        paramInt = i + i.a.a.a.qC(6, this.Znp.computeSize());
      }
      i = paramInt + (i.a.a.b.b.a.ko(7) + 4) + i.a.a.b.b.a.cJ(8, this.nxO) + i.a.a.b.b.a.cJ(9, this.nxP) + i.a.a.b.b.a.cJ(10, this.videoBitrate) + i.a.a.b.b.a.cJ(11, this.fps) + i.a.a.b.b.a.cJ(12, this.nCd) + i.a.a.b.b.a.cJ(13, this.audioBitrate) + i.a.a.b.b.a.cJ(14, this.audioSampleRate) + i.a.a.b.b.a.cJ(15, this.audioChannelCount) + i.a.a.a.c(16, 2, this.Znr) + i.a.a.b.b.a.cJ(17, this.oCb) + (i.a.a.b.b.a.ko(18) + 1) + i.a.a.b.b.a.cJ(19, this.Znt) + (i.a.a.b.b.a.ko(20) + 1);
      paramInt = i;
      if (this.Znu != null) {
        paramInt = i + i.a.a.a.qC(21, this.Znu.computeSize());
      }
      i = paramInt;
      if (this.Znv != null) {
        i = paramInt + i.a.a.a.qC(22, this.Znv.computeSize());
      }
      paramInt = i;
      if (this.Znw != null) {
        paramInt = i + i.a.a.a.qC(23, this.Znw.computeSize());
      }
      AppMethodBeat.o(259954);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Znr.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259954);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        afc localafc = (afc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 2: 
        case 3: 
        default: 
          AppMethodBeat.o(259954);
          return -1;
        case 1: 
          localafc.outputPath = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259954);
          return 0;
        case 4: 
          localafc.HJN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259954);
          return 0;
        case 5: 
          localafc.HJO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259954);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enx)localObject2).parseFrom((byte[])localObject1);
            }
            localafc.Znp = ((enx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259954);
          return 0;
        case 7: 
          localafc.Znq = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(259954);
          return 0;
        case 8: 
          localafc.nxO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259954);
          return 0;
        case 9: 
          localafc.nxP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259954);
          return 0;
        case 10: 
          localafc.videoBitrate = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259954);
          return 0;
        case 11: 
          localafc.fps = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259954);
          return 0;
        case 12: 
          localafc.nCd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259954);
          return 0;
        case 13: 
          localafc.audioBitrate = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259954);
          return 0;
        case 14: 
          localafc.audioSampleRate = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259954);
          return 0;
        case 15: 
          localafc.audioChannelCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259954);
          return 0;
        case 16: 
          localafc.Znr.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
          AppMethodBeat.o(259954);
          return 0;
        case 17: 
          localafc.oCb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259954);
          return 0;
        case 18: 
          localafc.Zns = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(259954);
          return 0;
        case 19: 
          localafc.Znt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259954);
          return 0;
        case 20: 
          localafc.oYa = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(259954);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enx)localObject2).parseFrom((byte[])localObject1);
            }
            localafc.Znu = ((enx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259954);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzm)localObject2).parseFrom((byte[])localObject1);
            }
            localafc.Znv = ((dzm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259954);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dzm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dzm)localObject2).parseFrom((byte[])localObject1);
          }
          localafc.Znw = ((dzm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259954);
        return 0;
      }
      AppMethodBeat.o(259954);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afc
 * JD-Core Version:    0.7.0.1
 */