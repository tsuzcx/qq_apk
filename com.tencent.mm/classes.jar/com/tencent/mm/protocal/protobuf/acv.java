package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acv
  extends com.tencent.mm.cd.a
{
  public int BXA;
  public int BXB;
  public duz SoD;
  public float SoE;
  public LinkedList<Integer> SoF;
  public boolean SoG;
  public int SoH;
  public duz SoI;
  public dhd SoJ;
  public dhd SoK;
  public int audioBitrate;
  public int audioChannelCount;
  public int audioSampleRate;
  public int fps;
  public int kXt;
  public int lJz;
  public boolean mfh;
  public int targetHeight;
  public int targetWidth;
  public String uVk;
  public int videoBitrate;
  
  public acv()
  {
    AppMethodBeat.i(255054);
    this.SoF = new LinkedList();
    AppMethodBeat.o(255054);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255055);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.uVk != null) {
        paramVarArgs.f(1, this.uVk);
      }
      paramVarArgs.aY(4, this.BXA);
      paramVarArgs.aY(5, this.BXB);
      if (this.SoD != null)
      {
        paramVarArgs.oE(6, this.SoD.computeSize());
        this.SoD.writeFields(paramVarArgs);
      }
      paramVarArgs.i(7, this.SoE);
      paramVarArgs.aY(8, this.targetWidth);
      paramVarArgs.aY(9, this.targetHeight);
      paramVarArgs.aY(10, this.videoBitrate);
      paramVarArgs.aY(11, this.fps);
      paramVarArgs.aY(12, this.kXt);
      paramVarArgs.aY(13, this.audioBitrate);
      paramVarArgs.aY(14, this.audioSampleRate);
      paramVarArgs.aY(15, this.audioChannelCount);
      paramVarArgs.e(16, 2, this.SoF);
      paramVarArgs.aY(17, this.lJz);
      paramVarArgs.co(18, this.SoG);
      paramVarArgs.aY(19, this.SoH);
      paramVarArgs.co(20, this.mfh);
      if (this.SoI != null)
      {
        paramVarArgs.oE(21, this.SoI.computeSize());
        this.SoI.writeFields(paramVarArgs);
      }
      if (this.SoJ != null)
      {
        paramVarArgs.oE(22, this.SoJ.computeSize());
        this.SoJ.writeFields(paramVarArgs);
      }
      if (this.SoK != null)
      {
        paramVarArgs.oE(23, this.SoK.computeSize());
        this.SoK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(255055);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uVk == null) {
        break label1480;
      }
    }
    label1480:
    for (paramInt = g.a.a.b.b.a.g(1, this.uVk) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(4, this.BXA) + g.a.a.b.b.a.bM(5, this.BXB);
      paramInt = i;
      if (this.SoD != null) {
        paramInt = i + g.a.a.a.oD(6, this.SoD.computeSize());
      }
      i = paramInt + (g.a.a.b.b.a.gL(7) + 4) + g.a.a.b.b.a.bM(8, this.targetWidth) + g.a.a.b.b.a.bM(9, this.targetHeight) + g.a.a.b.b.a.bM(10, this.videoBitrate) + g.a.a.b.b.a.bM(11, this.fps) + g.a.a.b.b.a.bM(12, this.kXt) + g.a.a.b.b.a.bM(13, this.audioBitrate) + g.a.a.b.b.a.bM(14, this.audioSampleRate) + g.a.a.b.b.a.bM(15, this.audioChannelCount) + g.a.a.a.c(16, 2, this.SoF) + g.a.a.b.b.a.bM(17, this.lJz) + (g.a.a.b.b.a.gL(18) + 1) + g.a.a.b.b.a.bM(19, this.SoH) + (g.a.a.b.b.a.gL(20) + 1);
      paramInt = i;
      if (this.SoI != null) {
        paramInt = i + g.a.a.a.oD(21, this.SoI.computeSize());
      }
      i = paramInt;
      if (this.SoJ != null) {
        i = paramInt + g.a.a.a.oD(22, this.SoJ.computeSize());
      }
      paramInt = i;
      if (this.SoK != null) {
        paramInt = i + g.a.a.a.oD(23, this.SoK.computeSize());
      }
      AppMethodBeat.o(255055);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SoF.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(255055);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        acv localacv = (acv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 2: 
        case 3: 
        default: 
          AppMethodBeat.o(255055);
          return -1;
        case 1: 
          localacv.uVk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(255055);
          return 0;
        case 4: 
          localacv.BXA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255055);
          return 0;
        case 5: 
          localacv.BXB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255055);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new duz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((duz)localObject2).parseFrom((byte[])localObject1);
            }
            localacv.SoD = ((duz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(255055);
          return 0;
        case 7: 
          localacv.SoE = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(255055);
          return 0;
        case 8: 
          localacv.targetWidth = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255055);
          return 0;
        case 9: 
          localacv.targetHeight = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255055);
          return 0;
        case 10: 
          localacv.videoBitrate = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255055);
          return 0;
        case 11: 
          localacv.fps = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255055);
          return 0;
        case 12: 
          localacv.kXt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255055);
          return 0;
        case 13: 
          localacv.audioBitrate = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255055);
          return 0;
        case 14: 
          localacv.audioSampleRate = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255055);
          return 0;
        case 15: 
          localacv.audioChannelCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255055);
          return 0;
        case 16: 
          localacv.SoF.add(Integer.valueOf(((g.a.a.a.a)localObject1).abFh.AK()));
          AppMethodBeat.o(255055);
          return 0;
        case 17: 
          localacv.lJz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255055);
          return 0;
        case 18: 
          localacv.SoG = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(255055);
          return 0;
        case 19: 
          localacv.SoH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255055);
          return 0;
        case 20: 
          localacv.mfh = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(255055);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new duz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((duz)localObject2).parseFrom((byte[])localObject1);
            }
            localacv.SoI = ((duz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(255055);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhd)localObject2).parseFrom((byte[])localObject1);
            }
            localacv.SoJ = ((dhd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(255055);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dhd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dhd)localObject2).parseFrom((byte[])localObject1);
          }
          localacv.SoK = ((dhd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(255055);
        return 0;
      }
      AppMethodBeat.o(255055);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acv
 * JD-Core Version:    0.7.0.1
 */