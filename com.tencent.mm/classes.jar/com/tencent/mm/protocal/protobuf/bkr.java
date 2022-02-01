package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkr
  extends com.tencent.mm.cd.a
{
  public bfg SPW;
  public int SVD;
  public int SVE;
  public int SVF;
  public bkq SVG;
  public int SVH;
  public int SVI;
  public asg SVJ;
  public String coverUrl;
  public int feedCount;
  public int followFlag;
  public int friendFollowCount;
  public bkj tmpl_info;
  public String topic;
  public int wXA;
  public long xee;
  public String xef;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210644);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.topic != null) {
        paramVarArgs.f(1, this.topic);
      }
      paramVarArgs.bm(2, this.xee);
      paramVarArgs.aY(3, this.feedCount);
      if (this.xef != null) {
        paramVarArgs.f(4, this.xef);
      }
      paramVarArgs.aY(5, this.wXA);
      paramVarArgs.aY(6, this.followFlag);
      if (this.coverUrl != null) {
        paramVarArgs.f(7, this.coverUrl);
      }
      paramVarArgs.aY(8, this.friendFollowCount);
      paramVarArgs.aY(9, this.SVD);
      paramVarArgs.aY(10, this.SVE);
      if (this.SPW != null)
      {
        paramVarArgs.oE(11, this.SPW.computeSize());
        this.SPW.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(12, this.SVF);
      if (this.SVG != null)
      {
        paramVarArgs.oE(13, this.SVG.computeSize());
        this.SVG.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(14, this.SVH);
      if (this.tmpl_info != null)
      {
        paramVarArgs.oE(15, this.tmpl_info.computeSize());
        this.tmpl_info.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(16, this.SVI);
      if (this.SVJ != null)
      {
        paramVarArgs.oE(17, this.SVJ.computeSize());
        this.SVJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(210644);
      return 0;
    }
    if (paramInt == 1) {
      if (this.topic == null) {
        break label1322;
      }
    }
    label1322:
    for (paramInt = g.a.a.b.b.a.g(1, this.topic) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.xee) + g.a.a.b.b.a.bM(3, this.feedCount);
      paramInt = i;
      if (this.xef != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.xef);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.wXA) + g.a.a.b.b.a.bM(6, this.followFlag);
      paramInt = i;
      if (this.coverUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.coverUrl);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.friendFollowCount) + g.a.a.b.b.a.bM(9, this.SVD) + g.a.a.b.b.a.bM(10, this.SVE);
      paramInt = i;
      if (this.SPW != null) {
        paramInt = i + g.a.a.a.oD(11, this.SPW.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.SVF);
      paramInt = i;
      if (this.SVG != null) {
        paramInt = i + g.a.a.a.oD(13, this.SVG.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(14, this.SVH);
      paramInt = i;
      if (this.tmpl_info != null) {
        paramInt = i + g.a.a.a.oD(15, this.tmpl_info.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(16, this.SVI);
      paramInt = i;
      if (this.SVJ != null) {
        paramInt = i + g.a.a.a.oD(17, this.SVJ.computeSize());
      }
      AppMethodBeat.o(210644);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(210644);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bkr localbkr = (bkr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(210644);
          return -1;
        case 1: 
          localbkr.topic = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(210644);
          return 0;
        case 2: 
          localbkr.xee = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(210644);
          return 0;
        case 3: 
          localbkr.feedCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(210644);
          return 0;
        case 4: 
          localbkr.xef = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(210644);
          return 0;
        case 5: 
          localbkr.wXA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(210644);
          return 0;
        case 6: 
          localbkr.followFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(210644);
          return 0;
        case 7: 
          localbkr.coverUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(210644);
          return 0;
        case 8: 
          localbkr.friendFollowCount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(210644);
          return 0;
        case 9: 
          localbkr.SVD = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(210644);
          return 0;
        case 10: 
          localbkr.SVE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(210644);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfg)localObject2).parseFrom((byte[])localObject1);
            }
            localbkr.SPW = ((bfg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(210644);
          return 0;
        case 12: 
          localbkr.SVF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(210644);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkq)localObject2).parseFrom((byte[])localObject1);
            }
            localbkr.SVG = ((bkq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(210644);
          return 0;
        case 14: 
          localbkr.SVH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(210644);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkj)localObject2).parseFrom((byte[])localObject1);
            }
            localbkr.tmpl_info = ((bkj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(210644);
          return 0;
        case 16: 
          localbkr.SVI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(210644);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new asg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((asg)localObject2).parseFrom((byte[])localObject1);
          }
          localbkr.SVJ = ((asg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(210644);
        return 0;
      }
      AppMethodBeat.o(210644);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkr
 * JD-Core Version:    0.7.0.1
 */