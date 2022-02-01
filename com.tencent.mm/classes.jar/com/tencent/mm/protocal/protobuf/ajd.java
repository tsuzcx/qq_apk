package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajd
  extends com.tencent.mm.cd.a
{
  public int HLC;
  public boolean HLF;
  public duy HMI;
  public LinkedList<jc> Sor;
  public int StA;
  public enp StB;
  public int StC;
  public long StD;
  public LinkedList<String> StE;
  public com.tencent.mm.cd.b StF;
  public int StG;
  public int StH;
  public int StI;
  public int StJ;
  public String Stv;
  public int Stw;
  public int Stx;
  public int Sty;
  public int Stz;
  public boolean aGs;
  public long endTime;
  public int kRX;
  public String kXi;
  public boolean lfl;
  public String musicUrl;
  public long startTime;
  public String thumbPath;
  public long timeStamp;
  public String videoPath;
  
  public ajd()
  {
    AppMethodBeat.i(101528);
    this.Sor = new LinkedList();
    this.StE = new LinkedList();
    AppMethodBeat.o(101528);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101529);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.videoPath == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: videoPath");
        AppMethodBeat.o(101529);
        throw paramVarArgs;
      }
      if (this.thumbPath == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: thumbPath");
        AppMethodBeat.o(101529);
        throw paramVarArgs;
      }
      if (this.videoPath != null) {
        paramVarArgs.f(1, this.videoPath);
      }
      paramVarArgs.bm(2, this.startTime);
      paramVarArgs.bm(3, this.endTime);
      if (this.Stv != null) {
        paramVarArgs.f(4, this.Stv);
      }
      paramVarArgs.aY(5, this.kRX);
      if (this.thumbPath != null) {
        paramVarArgs.f(6, this.thumbPath);
      }
      if (this.kXi != null) {
        paramVarArgs.f(7, this.kXi);
      }
      paramVarArgs.aY(8, this.HLC);
      if (this.musicUrl != null) {
        paramVarArgs.f(9, this.musicUrl);
      }
      paramVarArgs.co(10, this.aGs);
      paramVarArgs.co(11, this.HLF);
      paramVarArgs.aY(12, this.Stw);
      paramVarArgs.aY(13, this.Stx);
      paramVarArgs.aY(14, this.Sty);
      paramVarArgs.aY(15, this.Stz);
      paramVarArgs.e(16, 8, this.Sor);
      paramVarArgs.bm(17, this.timeStamp);
      paramVarArgs.aY(18, this.StA);
      paramVarArgs.co(19, this.lfl);
      if (this.HMI != null)
      {
        paramVarArgs.oE(20, this.HMI.computeSize());
        this.HMI.writeFields(paramVarArgs);
      }
      if (this.StB != null)
      {
        paramVarArgs.oE(21, this.StB.computeSize());
        this.StB.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(22, this.StC);
      paramVarArgs.bm(23, this.StD);
      paramVarArgs.e(24, 1, this.StE);
      if (this.StF != null) {
        paramVarArgs.c(25, this.StF);
      }
      paramVarArgs.aY(26, this.StG);
      paramVarArgs.aY(27, this.StH);
      paramVarArgs.aY(28, this.StI);
      paramVarArgs.aY(29, this.StJ);
      AppMethodBeat.o(101529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.videoPath == null) {
        break label1912;
      }
    }
    label1912:
    for (paramInt = g.a.a.b.b.a.g(1, this.videoPath) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.startTime) + g.a.a.b.b.a.p(3, this.endTime);
      paramInt = i;
      if (this.Stv != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Stv);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.kRX);
      paramInt = i;
      if (this.thumbPath != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.thumbPath);
      }
      i = paramInt;
      if (this.kXi != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.kXi);
      }
      i += g.a.a.b.b.a.bM(8, this.HLC);
      paramInt = i;
      if (this.musicUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.musicUrl);
      }
      i = paramInt + (g.a.a.b.b.a.gL(10) + 1) + (g.a.a.b.b.a.gL(11) + 1) + g.a.a.b.b.a.bM(12, this.Stw) + g.a.a.b.b.a.bM(13, this.Stx) + g.a.a.b.b.a.bM(14, this.Sty) + g.a.a.b.b.a.bM(15, this.Stz) + g.a.a.a.c(16, 8, this.Sor) + g.a.a.b.b.a.p(17, this.timeStamp) + g.a.a.b.b.a.bM(18, this.StA) + (g.a.a.b.b.a.gL(19) + 1);
      paramInt = i;
      if (this.HMI != null) {
        paramInt = i + g.a.a.a.oD(20, this.HMI.computeSize());
      }
      i = paramInt;
      if (this.StB != null) {
        i = paramInt + g.a.a.a.oD(21, this.StB.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(22, this.StC) + g.a.a.b.b.a.p(23, this.StD) + g.a.a.a.c(24, 1, this.StE);
      paramInt = i;
      if (this.StF != null) {
        paramInt = i + g.a.a.b.b.a.b(25, this.StF);
      }
      i = g.a.a.b.b.a.bM(26, this.StG);
      int j = g.a.a.b.b.a.bM(27, this.StH);
      int k = g.a.a.b.b.a.bM(28, this.StI);
      int m = g.a.a.b.b.a.bM(29, this.StJ);
      AppMethodBeat.o(101529);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Sor.clear();
        this.StE.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.videoPath == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: videoPath");
          AppMethodBeat.o(101529);
          throw paramVarArgs;
        }
        if (this.thumbPath == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: thumbPath");
          AppMethodBeat.o(101529);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ajd localajd = (ajd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101529);
          return -1;
        case 1: 
          localajd.videoPath = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 2: 
          localajd.startTime = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(101529);
          return 0;
        case 3: 
          localajd.endTime = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(101529);
          return 0;
        case 4: 
          localajd.Stv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 5: 
          localajd.kRX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101529);
          return 0;
        case 6: 
          localajd.thumbPath = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 7: 
          localajd.kXi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 8: 
          localajd.HLC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101529);
          return 0;
        case 9: 
          localajd.musicUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 10: 
          localajd.aGs = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(101529);
          return 0;
        case 11: 
          localajd.HLF = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(101529);
          return 0;
        case 12: 
          localajd.Stw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101529);
          return 0;
        case 13: 
          localajd.Stx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101529);
          return 0;
        case 14: 
          localajd.Sty = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101529);
          return 0;
        case 15: 
          localajd.Stz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101529);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jc)localObject2).parseFrom((byte[])localObject1);
            }
            localajd.Sor.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 17: 
          localajd.timeStamp = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(101529);
          return 0;
        case 18: 
          localajd.StA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101529);
          return 0;
        case 19: 
          localajd.lfl = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(101529);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new duy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((duy)localObject2).parseFrom((byte[])localObject1);
            }
            localajd.HMI = ((duy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enp)localObject2).parseFrom((byte[])localObject1);
            }
            localajd.StB = ((enp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 22: 
          localajd.StC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101529);
          return 0;
        case 23: 
          localajd.StD = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(101529);
          return 0;
        case 24: 
          localajd.StE.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(101529);
          return 0;
        case 25: 
          localajd.StF = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(101529);
          return 0;
        case 26: 
          localajd.StG = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101529);
          return 0;
        case 27: 
          localajd.StH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101529);
          return 0;
        case 28: 
          localajd.StI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(101529);
          return 0;
        }
        localajd.StJ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(101529);
        return 0;
      }
      AppMethodBeat.o(101529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajd
 * JD-Core Version:    0.7.0.1
 */