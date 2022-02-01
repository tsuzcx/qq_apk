package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dli
  extends com.tencent.mm.cd.a
{
  public String DNV;
  public String GHy;
  public String IfQ;
  public String OkX;
  public String OkY;
  public int Olc;
  public String Old;
  public etn TSs;
  public czv TSt;
  public cxq TSu;
  public int day;
  public String fvP;
  public long gbJ;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91618);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.day);
      paramVarArgs.bm(2, this.gbJ);
      if (this.fvP != null) {
        paramVarArgs.f(3, this.fvP);
      }
      if (this.GHy != null) {
        paramVarArgs.f(4, this.GHy);
      }
      if (this.OkX != null) {
        paramVarArgs.f(5, this.OkX);
      }
      if (this.OkY != null) {
        paramVarArgs.f(6, this.OkY);
      }
      if (this.TSs != null)
      {
        paramVarArgs.oE(7, this.TSs.computeSize());
        this.TSs.writeFields(paramVarArgs);
      }
      if (this.TSt != null)
      {
        paramVarArgs.oE(8, this.TSt.computeSize());
        this.TSt.writeFields(paramVarArgs);
      }
      if (this.TSu != null)
      {
        paramVarArgs.oE(9, this.TSu.computeSize());
        this.TSu.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(10, this.Olc);
      paramVarArgs.aY(11, this.state);
      if (this.DNV != null) {
        paramVarArgs.f(12, this.DNV);
      }
      if (this.IfQ != null) {
        paramVarArgs.f(13, this.IfQ);
      }
      if (this.Old != null) {
        paramVarArgs.f(14, this.Old);
      }
      AppMethodBeat.o(91618);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.day) + 0 + g.a.a.b.b.a.p(2, this.gbJ);
      paramInt = i;
      if (this.fvP != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.fvP);
      }
      i = paramInt;
      if (this.GHy != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.GHy);
      }
      paramInt = i;
      if (this.OkX != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.OkX);
      }
      i = paramInt;
      if (this.OkY != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.OkY);
      }
      paramInt = i;
      if (this.TSs != null) {
        paramInt = i + g.a.a.a.oD(7, this.TSs.computeSize());
      }
      i = paramInt;
      if (this.TSt != null) {
        i = paramInt + g.a.a.a.oD(8, this.TSt.computeSize());
      }
      paramInt = i;
      if (this.TSu != null) {
        paramInt = i + g.a.a.a.oD(9, this.TSu.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.Olc) + g.a.a.b.b.a.bM(11, this.state);
      paramInt = i;
      if (this.DNV != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.DNV);
      }
      i = paramInt;
      if (this.IfQ != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.IfQ);
      }
      paramInt = i;
      if (this.Old != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.Old);
      }
      AppMethodBeat.o(91618);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91618);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dli localdli = (dli)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91618);
        return -1;
      case 1: 
        localdli.day = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91618);
        return 0;
      case 2: 
        localdli.gbJ = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(91618);
        return 0;
      case 3: 
        localdli.fvP = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 4: 
        localdli.GHy = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 5: 
        localdli.OkX = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 6: 
        localdli.OkY = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etn)localObject2).parseFrom((byte[])localObject1);
          }
          localdli.TSs = ((etn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new czv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((czv)localObject2).parseFrom((byte[])localObject1);
          }
          localdli.TSt = ((czv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cxq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cxq)localObject2).parseFrom((byte[])localObject1);
          }
          localdli.TSu = ((cxq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 10: 
        localdli.Olc = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91618);
        return 0;
      case 11: 
        localdli.state = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91618);
        return 0;
      case 12: 
        localdli.DNV = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 13: 
        localdli.IfQ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91618);
        return 0;
      }
      localdli.Old = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(91618);
      return 0;
    }
    AppMethodBeat.o(91618);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dli
 * JD-Core Version:    0.7.0.1
 */