package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class te
  extends com.tencent.mm.cd.a
{
  public eae ScA;
  public int ScB;
  public int ScC;
  public LinkedList<eaf> ScD;
  public LinkedList<tf> ScE;
  public LinkedList<tf> ScF;
  public int ScG;
  public int ScH;
  public int Scu;
  public int Scv;
  public int Scw;
  public int Scx;
  public LinkedList<eaf> Scy;
  public String Scz;
  public int vhf;
  
  public te()
  {
    AppMethodBeat.i(133162);
    this.Scy = new LinkedList();
    this.ScD = new LinkedList();
    this.ScE = new LinkedList();
    this.ScF = new LinkedList();
    AppMethodBeat.o(133162);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133163);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ScA == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthKey");
        AppMethodBeat.o(133163);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.Scu);
      paramVarArgs.aY(2, this.vhf);
      paramVarArgs.aY(3, this.Scv);
      paramVarArgs.aY(4, this.Scw);
      paramVarArgs.aY(5, this.Scx);
      paramVarArgs.e(6, 8, this.Scy);
      if (this.Scz != null) {
        paramVarArgs.f(7, this.Scz);
      }
      if (this.ScA != null)
      {
        paramVarArgs.oE(8, this.ScA.computeSize());
        this.ScA.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.ScB);
      paramVarArgs.aY(10, this.ScC);
      paramVarArgs.e(11, 8, this.ScD);
      paramVarArgs.e(12, 8, this.ScE);
      paramVarArgs.e(13, 8, this.ScF);
      paramVarArgs.aY(14, this.ScG);
      paramVarArgs.aY(15, this.ScH);
      AppMethodBeat.o(133163);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.Scu) + 0 + g.a.a.b.b.a.bM(2, this.vhf) + g.a.a.b.b.a.bM(3, this.Scv) + g.a.a.b.b.a.bM(4, this.Scw) + g.a.a.b.b.a.bM(5, this.Scx) + g.a.a.a.c(6, 8, this.Scy);
      paramInt = i;
      if (this.Scz != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Scz);
      }
      i = paramInt;
      if (this.ScA != null) {
        i = paramInt + g.a.a.a.oD(8, this.ScA.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(9, this.ScB);
      int j = g.a.a.b.b.a.bM(10, this.ScC);
      int k = g.a.a.a.c(11, 8, this.ScD);
      int m = g.a.a.a.c(12, 8, this.ScE);
      int n = g.a.a.a.c(13, 8, this.ScF);
      int i1 = g.a.a.b.b.a.bM(14, this.ScG);
      int i2 = g.a.a.b.b.a.bM(15, this.ScH);
      AppMethodBeat.o(133163);
      return i + paramInt + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Scy.clear();
      this.ScD.clear();
      this.ScE.clear();
      this.ScF.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.ScA == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthKey");
        AppMethodBeat.o(133163);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133163);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      te localte = (te)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133163);
        return -1;
      case 1: 
        localte.Scu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133163);
        return 0;
      case 2: 
        localte.vhf = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133163);
        return 0;
      case 3: 
        localte.Scv = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133163);
        return 0;
      case 4: 
        localte.Scw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133163);
        return 0;
      case 5: 
        localte.Scx = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133163);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaf)localObject2).de((byte[])localObject1);
          }
          localte.Scy.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 7: 
        localte.Scz = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(133163);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localte.ScA = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 9: 
        localte.ScB = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133163);
        return 0;
      case 10: 
        localte.ScC = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133163);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaf)localObject2).de((byte[])localObject1);
          }
          localte.ScD.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new tf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((tf)localObject2).parseFrom((byte[])localObject1);
          }
          localte.ScE.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 13: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new tf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((tf)localObject2).parseFrom((byte[])localObject1);
          }
          localte.ScF.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 14: 
        localte.ScG = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133163);
        return 0;
      }
      localte.ScH = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(133163);
      return 0;
    }
    AppMethodBeat.o(133163);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.te
 * JD-Core Version:    0.7.0.1
 */