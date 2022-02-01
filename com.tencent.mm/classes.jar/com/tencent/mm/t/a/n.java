package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.cd.a
{
  public String desc;
  public int jDT;
  public String jDU;
  public String jDV;
  public int jDW;
  public p jDX;
  public String jDY;
  public int jDZ;
  public p jEa;
  public int jEb;
  public String jEc;
  public String jEd;
  public long jEe;
  public o jEf;
  public String jEg;
  public String jEh;
  public String jEi;
  public String jEj;
  public String jEk = "fa5151";
  public String jEl = "ffffff";
  public String jEm = "f2f2f2";
  public String jEn = "fa5151";
  public String jEo = "C84040";
  public String nickname;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249676);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.jDT);
      if (this.jDU != null) {
        paramVarArgs.f(2, this.jDU);
      }
      if (this.nickname != null) {
        paramVarArgs.f(3, this.nickname);
      }
      if (this.title != null) {
        paramVarArgs.f(4, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(5, this.desc);
      }
      if (this.jDV != null) {
        paramVarArgs.f(7, this.jDV);
      }
      paramVarArgs.aY(8, this.jDW);
      if (this.jDX != null)
      {
        paramVarArgs.oE(9, this.jDX.computeSize());
        this.jDX.writeFields(paramVarArgs);
      }
      if (this.jDY != null) {
        paramVarArgs.f(10, this.jDY);
      }
      paramVarArgs.aY(11, this.jDZ);
      if (this.jEa != null)
      {
        paramVarArgs.oE(12, this.jEa.computeSize());
        this.jEa.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(14, this.jEb);
      if (this.jEc != null) {
        paramVarArgs.f(15, this.jEc);
      }
      if (this.jEd != null) {
        paramVarArgs.f(16, this.jEd);
      }
      paramVarArgs.bm(19, this.jEe);
      if (this.jEf != null)
      {
        paramVarArgs.oE(25, this.jEf.computeSize());
        this.jEf.writeFields(paramVarArgs);
      }
      if (this.jEg != null) {
        paramVarArgs.f(6, this.jEg);
      }
      if (this.jEh != null) {
        paramVarArgs.f(13, this.jEh);
      }
      if (this.jEi != null) {
        paramVarArgs.f(17, this.jEi);
      }
      if (this.jEj != null) {
        paramVarArgs.f(18, this.jEj);
      }
      if (this.jEk != null) {
        paramVarArgs.f(20, this.jEk);
      }
      if (this.jEl != null) {
        paramVarArgs.f(21, this.jEl);
      }
      if (this.jEm != null) {
        paramVarArgs.f(22, this.jEm);
      }
      if (this.jEn != null) {
        paramVarArgs.f(23, this.jEn);
      }
      if (this.jEo != null) {
        paramVarArgs.f(24, this.jEo);
      }
      AppMethodBeat.o(249676);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.jDT) + 0;
      paramInt = i;
      if (this.jDU != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.jDU);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.nickname);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.desc);
      }
      paramInt = i;
      if (this.jDV != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.jDV);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.jDW);
      paramInt = i;
      if (this.jDX != null) {
        paramInt = i + g.a.a.a.oD(9, this.jDX.computeSize());
      }
      i = paramInt;
      if (this.jDY != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.jDY);
      }
      i += g.a.a.b.b.a.bM(11, this.jDZ);
      paramInt = i;
      if (this.jEa != null) {
        paramInt = i + g.a.a.a.oD(12, this.jEa.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(14, this.jEb);
      paramInt = i;
      if (this.jEc != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.jEc);
      }
      i = paramInt;
      if (this.jEd != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.jEd);
      }
      i += g.a.a.b.b.a.p(19, this.jEe);
      paramInt = i;
      if (this.jEf != null) {
        paramInt = i + g.a.a.a.oD(25, this.jEf.computeSize());
      }
      i = paramInt;
      if (this.jEg != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.jEg);
      }
      paramInt = i;
      if (this.jEh != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.jEh);
      }
      i = paramInt;
      if (this.jEi != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.jEi);
      }
      paramInt = i;
      if (this.jEj != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.jEj);
      }
      i = paramInt;
      if (this.jEk != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.jEk);
      }
      paramInt = i;
      if (this.jEl != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.jEl);
      }
      i = paramInt;
      if (this.jEm != null) {
        i = paramInt + g.a.a.b.b.a.g(22, this.jEm);
      }
      paramInt = i;
      if (this.jEn != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.jEn);
      }
      i = paramInt;
      if (this.jEo != null) {
        i = paramInt + g.a.a.b.b.a.g(24, this.jEo);
      }
      AppMethodBeat.o(249676);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(249676);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(249676);
        return -1;
      case 1: 
        localn.jDT = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(249676);
        return 0;
      case 2: 
        localn.jDU = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249676);
        return 0;
      case 3: 
        localn.nickname = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249676);
        return 0;
      case 4: 
        localn.title = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249676);
        return 0;
      case 5: 
        localn.desc = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249676);
        return 0;
      case 7: 
        localn.jDV = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249676);
        return 0;
      case 8: 
        localn.jDW = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(249676);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new p();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((p)localObject2).parseFrom((byte[])localObject1);
          }
          localn.jDX = ((p)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(249676);
        return 0;
      case 10: 
        localn.jDY = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249676);
        return 0;
      case 11: 
        localn.jDZ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(249676);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new p();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((p)localObject2).parseFrom((byte[])localObject1);
          }
          localn.jEa = ((p)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(249676);
        return 0;
      case 14: 
        localn.jEb = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(249676);
        return 0;
      case 15: 
        localn.jEc = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249676);
        return 0;
      case 16: 
        localn.jEd = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249676);
        return 0;
      case 19: 
        localn.jEe = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(249676);
        return 0;
      case 25: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new o();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((o)localObject2).parseFrom((byte[])localObject1);
          }
          localn.jEf = ((o)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(249676);
        return 0;
      case 6: 
        localn.jEg = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249676);
        return 0;
      case 13: 
        localn.jEh = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249676);
        return 0;
      case 17: 
        localn.jEi = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249676);
        return 0;
      case 18: 
        localn.jEj = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249676);
        return 0;
      case 20: 
        localn.jEk = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249676);
        return 0;
      case 21: 
        localn.jEl = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249676);
        return 0;
      case 22: 
        localn.jEm = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249676);
        return 0;
      case 23: 
        localn.jEn = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(249676);
        return 0;
      }
      localn.jEo = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(249676);
      return 0;
    }
    AppMethodBeat.o(249676);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.t.a.n
 * JD-Core Version:    0.7.0.1
 */