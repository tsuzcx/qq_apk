package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ehh
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public int IJG;
  public String ThumbUrl;
  public String Zuw;
  public String aawr;
  public int abmA;
  public String abmB;
  public int abmC;
  public LinkedList<akn> abmD;
  public int abmv;
  public LinkedList<dfm> abmw;
  public int abmx;
  public String abmy;
  public String abmz;
  public int vgN;
  public int vhJ;
  
  public ehh()
  {
    AppMethodBeat.i(91633);
    this.abmw = new LinkedList();
    this.abmD = new LinkedList();
    AppMethodBeat.o(91633);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91634);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abmv);
      paramVarArgs.e(2, 8, this.abmw);
      paramVarArgs.bS(3, this.vgN);
      paramVarArgs.bS(4, this.abmx);
      if (this.Zuw != null) {
        paramVarArgs.g(5, this.Zuw);
      }
      if (this.aawr != null) {
        paramVarArgs.g(6, this.aawr);
      }
      if (this.abmy != null) {
        paramVarArgs.g(7, this.abmy);
      }
      if (this.abmz != null) {
        paramVarArgs.g(8, this.abmz);
      }
      paramVarArgs.bS(9, this.vhJ);
      if (this.IGU != null) {
        paramVarArgs.g(10, this.IGU);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.g(11, this.ThumbUrl);
      }
      paramVarArgs.bS(12, this.abmA);
      paramVarArgs.bS(13, this.IJG);
      if (this.abmB != null) {
        paramVarArgs.g(14, this.abmB);
      }
      paramVarArgs.bS(15, this.abmC);
      paramVarArgs.e(16, 8, this.abmD);
      AppMethodBeat.o(91634);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abmv) + 0 + i.a.a.a.c(2, 8, this.abmw) + i.a.a.b.b.a.cJ(3, this.vgN) + i.a.a.b.b.a.cJ(4, this.abmx);
      paramInt = i;
      if (this.Zuw != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Zuw);
      }
      i = paramInt;
      if (this.aawr != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aawr);
      }
      paramInt = i;
      if (this.abmy != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abmy);
      }
      i = paramInt;
      if (this.abmz != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abmz);
      }
      i += i.a.a.b.b.a.cJ(9, this.vhJ);
      paramInt = i;
      if (this.IGU != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.IGU);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.ThumbUrl);
      }
      i = i + i.a.a.b.b.a.cJ(12, this.abmA) + i.a.a.b.b.a.cJ(13, this.IJG);
      paramInt = i;
      if (this.abmB != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.abmB);
      }
      i = i.a.a.b.b.a.cJ(15, this.abmC);
      int j = i.a.a.a.c(16, 8, this.abmD);
      AppMethodBeat.o(91634);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abmw.clear();
      this.abmD.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91634);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      ehh localehh = (ehh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91634);
        return -1;
      case 1: 
        localehh.abmv = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91634);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dfm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dfm)localObject2).parseFrom((byte[])localObject1);
          }
          localehh.abmw.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91634);
        return 0;
      case 3: 
        localehh.vgN = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91634);
        return 0;
      case 4: 
        localehh.abmx = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91634);
        return 0;
      case 5: 
        localehh.Zuw = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 6: 
        localehh.aawr = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 7: 
        localehh.abmy = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 8: 
        localehh.abmz = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 9: 
        localehh.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91634);
        return 0;
      case 10: 
        localehh.IGU = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 11: 
        localehh.ThumbUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 12: 
        localehh.abmA = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91634);
        return 0;
      case 13: 
        localehh.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91634);
        return 0;
      case 14: 
        localehh.abmB = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 15: 
        localehh.abmC = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91634);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new akn();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((akn)localObject2).parseFrom((byte[])localObject1);
        }
        localehh.abmD.add(localObject2);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehh
 * JD-Core Version:    0.7.0.1
 */