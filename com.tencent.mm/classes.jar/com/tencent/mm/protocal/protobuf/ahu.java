package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahu
  extends com.tencent.mm.cd.a
{
  public fdc SsA;
  public int SsB;
  public LinkedList<feq> SsC;
  public int SsD;
  public int SsE;
  public int Ssu;
  public String Ssv;
  public String Ssw;
  public int Ssx;
  public int Ssy;
  public int Ssz;
  
  public ahu()
  {
    AppMethodBeat.i(115835);
    this.SsC = new LinkedList();
    AppMethodBeat.o(115835);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115836);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Ssu);
      if (this.Ssv != null) {
        paramVarArgs.f(2, this.Ssv);
      }
      if (this.Ssw != null) {
        paramVarArgs.f(3, this.Ssw);
      }
      paramVarArgs.aY(4, this.Ssx);
      paramVarArgs.aY(5, this.Ssy);
      paramVarArgs.aY(6, this.Ssz);
      if (this.SsA != null)
      {
        paramVarArgs.oE(7, this.SsA.computeSize());
        this.SsA.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.SsB);
      paramVarArgs.e(9, 8, this.SsC);
      paramVarArgs.aY(10, this.SsD);
      paramVarArgs.aY(11, this.SsE);
      AppMethodBeat.o(115836);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.Ssu) + 0;
      paramInt = i;
      if (this.Ssv != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Ssv);
      }
      i = paramInt;
      if (this.Ssw != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Ssw);
      }
      i = i + g.a.a.b.b.a.bM(4, this.Ssx) + g.a.a.b.b.a.bM(5, this.Ssy) + g.a.a.b.b.a.bM(6, this.Ssz);
      paramInt = i;
      if (this.SsA != null) {
        paramInt = i + g.a.a.a.oD(7, this.SsA.computeSize());
      }
      i = g.a.a.b.b.a.bM(8, this.SsB);
      int j = g.a.a.a.c(9, 8, this.SsC);
      int k = g.a.a.b.b.a.bM(10, this.SsD);
      int m = g.a.a.b.b.a.bM(11, this.SsE);
      AppMethodBeat.o(115836);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SsC.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(115836);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ahu localahu = (ahu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115836);
        return -1;
      case 1: 
        localahu.Ssu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(115836);
        return 0;
      case 2: 
        localahu.Ssv = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(115836);
        return 0;
      case 3: 
        localahu.Ssw = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(115836);
        return 0;
      case 4: 
        localahu.Ssx = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(115836);
        return 0;
      case 5: 
        localahu.Ssy = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(115836);
        return 0;
      case 6: 
        localahu.Ssz = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(115836);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fdc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fdc)localObject2).parseFrom((byte[])localObject1);
          }
          localahu.SsA = ((fdc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115836);
        return 0;
      case 8: 
        localahu.SsB = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(115836);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new feq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((feq)localObject2).parseFrom((byte[])localObject1);
          }
          localahu.SsC.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115836);
        return 0;
      case 10: 
        localahu.SsD = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(115836);
        return 0;
      }
      localahu.SsE = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(115836);
      return 0;
    }
    AppMethodBeat.o(115836);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahu
 * JD-Core Version:    0.7.0.1
 */