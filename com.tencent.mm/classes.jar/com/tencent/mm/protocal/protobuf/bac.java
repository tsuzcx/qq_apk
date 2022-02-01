package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bac
  extends com.tencent.mm.cd.a
{
  public int BpL;
  public String CqZ;
  public bau SEJ;
  public long SEj;
  public int SEl;
  public int SFG;
  public long SHj;
  public long SHt;
  public long SHu;
  public crw SJL;
  public azf SLL;
  public bar SLM;
  public bch SLN;
  public int SLO;
  public bcz SLP;
  public int SLQ;
  public int SLR;
  public String SLS;
  public long SLT;
  public int SLU;
  public int SLV;
  public bag SLW;
  public int SLX;
  public bde SLY;
  public bbo SLZ;
  public String SMa;
  public int SMb;
  public int endTime;
  public int fod;
  public String kih;
  public long liveId;
  public int liveStatus;
  public int yYz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199457);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.liveId);
      paramVarArgs.aY(2, this.yYz);
      paramVarArgs.aY(3, this.liveStatus);
      if (this.kih != null) {
        paramVarArgs.f(4, this.kih);
      }
      paramVarArgs.aY(5, this.fod);
      paramVarArgs.aY(6, this.BpL);
      paramVarArgs.aY(7, this.endTime);
      if (this.SLL != null)
      {
        paramVarArgs.oE(8, this.SLL.computeSize());
        this.SLL.writeFields(paramVarArgs);
      }
      if (this.SLM != null)
      {
        paramVarArgs.oE(9, this.SLM.computeSize());
        this.SLM.writeFields(paramVarArgs);
      }
      if (this.SLN != null)
      {
        paramVarArgs.oE(10, this.SLN.computeSize());
        this.SLN.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.SFG);
      paramVarArgs.bm(12, this.SHt);
      paramVarArgs.aY(13, this.SEl);
      paramVarArgs.aY(14, this.SLO);
      paramVarArgs.bm(15, this.SHj);
      if (this.SLP != null)
      {
        paramVarArgs.oE(16, this.SLP.computeSize());
        this.SLP.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(17, this.SLQ);
      paramVarArgs.aY(18, this.SLR);
      if (this.SLS != null) {
        paramVarArgs.f(19, this.SLS);
      }
      paramVarArgs.bm(20, this.SLT);
      paramVarArgs.bm(21, this.SHu);
      paramVarArgs.aY(22, this.SLU);
      if (this.CqZ != null) {
        paramVarArgs.f(23, this.CqZ);
      }
      if (this.SJL != null)
      {
        paramVarArgs.oE(24, this.SJL.computeSize());
        this.SJL.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(25, this.SLV);
      if (this.SLW != null)
      {
        paramVarArgs.oE(26, this.SLW.computeSize());
        this.SLW.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(27, this.SLX);
      if (this.SLY != null)
      {
        paramVarArgs.oE(28, this.SLY.computeSize());
        this.SLY.writeFields(paramVarArgs);
      }
      if (this.SLZ != null)
      {
        paramVarArgs.oE(29, this.SLZ.computeSize());
        this.SLZ.writeFields(paramVarArgs);
      }
      if (this.SMa != null) {
        paramVarArgs.f(30, this.SMa);
      }
      if (this.SEJ != null)
      {
        paramVarArgs.oE(31, this.SEJ.computeSize());
        this.SEJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(32, this.SMb);
      paramVarArgs.bm(33, this.SEj);
      AppMethodBeat.o(199457);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.liveId) + 0 + g.a.a.b.b.a.bM(2, this.yYz) + g.a.a.b.b.a.bM(3, this.liveStatus);
      paramInt = i;
      if (this.kih != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.kih);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.fod) + g.a.a.b.b.a.bM(6, this.BpL) + g.a.a.b.b.a.bM(7, this.endTime);
      paramInt = i;
      if (this.SLL != null) {
        paramInt = i + g.a.a.a.oD(8, this.SLL.computeSize());
      }
      i = paramInt;
      if (this.SLM != null) {
        i = paramInt + g.a.a.a.oD(9, this.SLM.computeSize());
      }
      paramInt = i;
      if (this.SLN != null) {
        paramInt = i + g.a.a.a.oD(10, this.SLN.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.SFG) + g.a.a.b.b.a.p(12, this.SHt) + g.a.a.b.b.a.bM(13, this.SEl) + g.a.a.b.b.a.bM(14, this.SLO) + g.a.a.b.b.a.p(15, this.SHj);
      paramInt = i;
      if (this.SLP != null) {
        paramInt = i + g.a.a.a.oD(16, this.SLP.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(17, this.SLQ) + g.a.a.b.b.a.bM(18, this.SLR);
      paramInt = i;
      if (this.SLS != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.SLS);
      }
      i = paramInt + g.a.a.b.b.a.p(20, this.SLT) + g.a.a.b.b.a.p(21, this.SHu) + g.a.a.b.b.a.bM(22, this.SLU);
      paramInt = i;
      if (this.CqZ != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.CqZ);
      }
      i = paramInt;
      if (this.SJL != null) {
        i = paramInt + g.a.a.a.oD(24, this.SJL.computeSize());
      }
      i += g.a.a.b.b.a.bM(25, this.SLV);
      paramInt = i;
      if (this.SLW != null) {
        paramInt = i + g.a.a.a.oD(26, this.SLW.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(27, this.SLX);
      paramInt = i;
      if (this.SLY != null) {
        paramInt = i + g.a.a.a.oD(28, this.SLY.computeSize());
      }
      i = paramInt;
      if (this.SLZ != null) {
        i = paramInt + g.a.a.a.oD(29, this.SLZ.computeSize());
      }
      paramInt = i;
      if (this.SMa != null) {
        paramInt = i + g.a.a.b.b.a.g(30, this.SMa);
      }
      i = paramInt;
      if (this.SEJ != null) {
        i = paramInt + g.a.a.a.oD(31, this.SEJ.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(32, this.SMb);
      int j = g.a.a.b.b.a.p(33, this.SEj);
      AppMethodBeat.o(199457);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(199457);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bac localbac = (bac)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(199457);
        return -1;
      case 1: 
        localbac.liveId = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(199457);
        return 0;
      case 2: 
        localbac.yYz = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(199457);
        return 0;
      case 3: 
        localbac.liveStatus = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(199457);
        return 0;
      case 4: 
        localbac.kih = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(199457);
        return 0;
      case 5: 
        localbac.fod = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(199457);
        return 0;
      case 6: 
        localbac.BpL = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(199457);
        return 0;
      case 7: 
        localbac.endTime = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(199457);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new azf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((azf)localObject2).parseFrom((byte[])localObject1);
          }
          localbac.SLL = ((azf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(199457);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bar();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bar)localObject2).parseFrom((byte[])localObject1);
          }
          localbac.SLM = ((bar)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(199457);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bch();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bch)localObject2).parseFrom((byte[])localObject1);
          }
          localbac.SLN = ((bch)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(199457);
        return 0;
      case 11: 
        localbac.SFG = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(199457);
        return 0;
      case 12: 
        localbac.SHt = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(199457);
        return 0;
      case 13: 
        localbac.SEl = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(199457);
        return 0;
      case 14: 
        localbac.SLO = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(199457);
        return 0;
      case 15: 
        localbac.SHj = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(199457);
        return 0;
      case 16: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bcz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bcz)localObject2).parseFrom((byte[])localObject1);
          }
          localbac.SLP = ((bcz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(199457);
        return 0;
      case 17: 
        localbac.SLQ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(199457);
        return 0;
      case 18: 
        localbac.SLR = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(199457);
        return 0;
      case 19: 
        localbac.SLS = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(199457);
        return 0;
      case 20: 
        localbac.SLT = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(199457);
        return 0;
      case 21: 
        localbac.SHu = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(199457);
        return 0;
      case 22: 
        localbac.SLU = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(199457);
        return 0;
      case 23: 
        localbac.CqZ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(199457);
        return 0;
      case 24: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new crw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((crw)localObject2).parseFrom((byte[])localObject1);
          }
          localbac.SJL = ((crw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(199457);
        return 0;
      case 25: 
        localbac.SLV = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(199457);
        return 0;
      case 26: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bag();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bag)localObject2).parseFrom((byte[])localObject1);
          }
          localbac.SLW = ((bag)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(199457);
        return 0;
      case 27: 
        localbac.SLX = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(199457);
        return 0;
      case 28: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bde();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bde)localObject2).parseFrom((byte[])localObject1);
          }
          localbac.SLY = ((bde)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(199457);
        return 0;
      case 29: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bbo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bbo)localObject2).parseFrom((byte[])localObject1);
          }
          localbac.SLZ = ((bbo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(199457);
        return 0;
      case 30: 
        localbac.SMa = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(199457);
        return 0;
      case 31: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bau();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bau)localObject2).parseFrom((byte[])localObject1);
          }
          localbac.SEJ = ((bau)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(199457);
        return 0;
      case 32: 
        localbac.SMb = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(199457);
        return 0;
      }
      localbac.SEj = ((g.a.a.a.a)localObject1).abFh.AN();
      AppMethodBeat.o(199457);
      return 0;
    }
    AppMethodBeat.o(199457);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bac
 * JD-Core Version:    0.7.0.1
 */