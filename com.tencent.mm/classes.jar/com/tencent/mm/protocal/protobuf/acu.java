package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acu
  extends com.tencent.mm.cd.a
{
  public acv NkX;
  public act NkY;
  public boolean NmU;
  public boolean NmV;
  public LinkedList<acw> SoA;
  public boolean SoB;
  public LinkedList<emz> SoC;
  public LinkedList<eth> Sou;
  public long Sov;
  public long Sow;
  public boolean Sox;
  public LinkedList<cuw> Soy;
  public fbj Soz;
  public String editId;
  public String kXi;
  
  public acu()
  {
    AppMethodBeat.i(255088);
    this.Sou = new LinkedList();
    this.Soy = new LinkedList();
    this.SoA = new LinkedList();
    this.SoC = new LinkedList();
    AppMethodBeat.o(255088);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255092);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Sou);
      paramVarArgs.bm(2, this.Sov);
      paramVarArgs.bm(3, this.Sow);
      paramVarArgs.co(4, this.NmU);
      if (this.kXi != null) {
        paramVarArgs.f(5, this.kXi);
      }
      if (this.NkX != null)
      {
        paramVarArgs.oE(6, this.NkX.computeSize());
        this.NkX.writeFields(paramVarArgs);
      }
      paramVarArgs.co(7, this.Sox);
      if (this.NkY != null)
      {
        paramVarArgs.oE(8, this.NkY.computeSize());
        this.NkY.writeFields(paramVarArgs);
      }
      paramVarArgs.e(9, 8, this.Soy);
      if (this.Soz != null)
      {
        paramVarArgs.oE(10, this.Soz.computeSize());
        this.Soz.writeFields(paramVarArgs);
      }
      paramVarArgs.co(11, this.NmV);
      paramVarArgs.e(12, 8, this.SoA);
      if (this.editId != null) {
        paramVarArgs.f(13, this.editId);
      }
      paramVarArgs.co(14, this.SoB);
      paramVarArgs.e(15, 8, this.SoC);
      AppMethodBeat.o(255092);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Sou) + 0 + g.a.a.b.b.a.p(2, this.Sov) + g.a.a.b.b.a.p(3, this.Sow) + (g.a.a.b.b.a.gL(4) + 1);
      paramInt = i;
      if (this.kXi != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.kXi);
      }
      i = paramInt;
      if (this.NkX != null) {
        i = paramInt + g.a.a.a.oD(6, this.NkX.computeSize());
      }
      i += g.a.a.b.b.a.gL(7) + 1;
      paramInt = i;
      if (this.NkY != null) {
        paramInt = i + g.a.a.a.oD(8, this.NkY.computeSize());
      }
      i = paramInt + g.a.a.a.c(9, 8, this.Soy);
      paramInt = i;
      if (this.Soz != null) {
        paramInt = i + g.a.a.a.oD(10, this.Soz.computeSize());
      }
      i = paramInt + (g.a.a.b.b.a.gL(11) + 1) + g.a.a.a.c(12, 8, this.SoA);
      paramInt = i;
      if (this.editId != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.editId);
      }
      i = g.a.a.b.b.a.gL(14);
      int j = g.a.a.a.c(15, 8, this.SoC);
      AppMethodBeat.o(255092);
      return paramInt + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Sou.clear();
      this.Soy.clear();
      this.SoA.clear();
      this.SoC.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(255092);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      acu localacu = (acu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(255092);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eth();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eth)localObject2).parseFrom((byte[])localObject1);
          }
          localacu.Sou.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(255092);
        return 0;
      case 2: 
        localacu.Sov = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(255092);
        return 0;
      case 3: 
        localacu.Sow = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(255092);
        return 0;
      case 4: 
        localacu.NmU = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(255092);
        return 0;
      case 5: 
        localacu.kXi = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(255092);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new acv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((acv)localObject2).parseFrom((byte[])localObject1);
          }
          localacu.NkX = ((acv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(255092);
        return 0;
      case 7: 
        localacu.Sox = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(255092);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new act();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((act)localObject2).parseFrom((byte[])localObject1);
          }
          localacu.NkY = ((act)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(255092);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cuw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cuw)localObject2).parseFrom((byte[])localObject1);
          }
          localacu.Soy.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(255092);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fbj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fbj)localObject2).parseFrom((byte[])localObject1);
          }
          localacu.Soz = ((fbj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(255092);
        return 0;
      case 11: 
        localacu.NmV = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(255092);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new acw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((acw)localObject2).parseFrom((byte[])localObject1);
          }
          localacu.SoA.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(255092);
        return 0;
      case 13: 
        localacu.editId = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(255092);
        return 0;
      case 14: 
        localacu.SoB = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(255092);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new emz();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((emz)localObject2).parseFrom((byte[])localObject1);
        }
        localacu.SoC.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(255092);
      return 0;
    }
    AppMethodBeat.o(255092);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acu
 * JD-Core Version:    0.7.0.1
 */