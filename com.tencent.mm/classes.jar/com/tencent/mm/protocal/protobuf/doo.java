package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doo
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public int CPw;
  public String SuH;
  public int TVH;
  public LinkedList<cos> TVI;
  public int TVJ;
  public String TVK;
  public String TVL;
  public int TVM;
  public String TVN;
  public int TVO;
  public LinkedList<ahw> TVP;
  public String ThumbUrl;
  public String TiR;
  public int rVx;
  public int rWu;
  
  public doo()
  {
    AppMethodBeat.i(91633);
    this.TVI = new LinkedList();
    this.TVP = new LinkedList();
    AppMethodBeat.o(91633);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91634);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TVH);
      paramVarArgs.e(2, 8, this.TVI);
      paramVarArgs.aY(3, this.rVx);
      paramVarArgs.aY(4, this.TVJ);
      if (this.SuH != null) {
        paramVarArgs.f(5, this.SuH);
      }
      if (this.TiR != null) {
        paramVarArgs.f(6, this.TiR);
      }
      if (this.TVK != null) {
        paramVarArgs.f(7, this.TVK);
      }
      if (this.TVL != null) {
        paramVarArgs.f(8, this.TVL);
      }
      paramVarArgs.aY(9, this.rWu);
      if (this.CMP != null) {
        paramVarArgs.f(10, this.CMP);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.f(11, this.ThumbUrl);
      }
      paramVarArgs.aY(12, this.TVM);
      paramVarArgs.aY(13, this.CPw);
      if (this.TVN != null) {
        paramVarArgs.f(14, this.TVN);
      }
      paramVarArgs.aY(15, this.TVO);
      paramVarArgs.e(16, 8, this.TVP);
      AppMethodBeat.o(91634);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.TVH) + 0 + g.a.a.a.c(2, 8, this.TVI) + g.a.a.b.b.a.bM(3, this.rVx) + g.a.a.b.b.a.bM(4, this.TVJ);
      paramInt = i;
      if (this.SuH != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SuH);
      }
      i = paramInt;
      if (this.TiR != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TiR);
      }
      paramInt = i;
      if (this.TVK != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TVK);
      }
      i = paramInt;
      if (this.TVL != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.TVL);
      }
      i += g.a.a.b.b.a.bM(9, this.rWu);
      paramInt = i;
      if (this.CMP != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.CMP);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.ThumbUrl);
      }
      i = i + g.a.a.b.b.a.bM(12, this.TVM) + g.a.a.b.b.a.bM(13, this.CPw);
      paramInt = i;
      if (this.TVN != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.TVN);
      }
      i = g.a.a.b.b.a.bM(15, this.TVO);
      int j = g.a.a.a.c(16, 8, this.TVP);
      AppMethodBeat.o(91634);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TVI.clear();
      this.TVP.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91634);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      doo localdoo = (doo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91634);
        return -1;
      case 1: 
        localdoo.TVH = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91634);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cos();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cos)localObject2).parseFrom((byte[])localObject1);
          }
          localdoo.TVI.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91634);
        return 0;
      case 3: 
        localdoo.rVx = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91634);
        return 0;
      case 4: 
        localdoo.TVJ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91634);
        return 0;
      case 5: 
        localdoo.SuH = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 6: 
        localdoo.TiR = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 7: 
        localdoo.TVK = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 8: 
        localdoo.TVL = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 9: 
        localdoo.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91634);
        return 0;
      case 10: 
        localdoo.CMP = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 11: 
        localdoo.ThumbUrl = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 12: 
        localdoo.TVM = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91634);
        return 0;
      case 13: 
        localdoo.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91634);
        return 0;
      case 14: 
        localdoo.TVN = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 15: 
        localdoo.TVO = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91634);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ahw();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ahw)localObject2).parseFrom((byte[])localObject1);
        }
        localdoo.TVP.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(91634);
      return 0;
    }
    AppMethodBeat.o(91634);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doo
 * JD-Core Version:    0.7.0.1
 */