package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahj
  extends com.tencent.mm.bw.a
{
  public int LqX;
  public String LqY;
  public String LqZ;
  public int Lra;
  public int Lrb;
  public int Lrc;
  public esr Lrd;
  public int Lre;
  public LinkedList<euf> Lrf;
  public int Lrg;
  public int Lrh;
  
  public ahj()
  {
    AppMethodBeat.i(115835);
    this.Lrf = new LinkedList();
    AppMethodBeat.o(115835);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115836);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LqX);
      if (this.LqY != null) {
        paramVarArgs.e(2, this.LqY);
      }
      if (this.LqZ != null) {
        paramVarArgs.e(3, this.LqZ);
      }
      paramVarArgs.aM(4, this.Lra);
      paramVarArgs.aM(5, this.Lrb);
      paramVarArgs.aM(6, this.Lrc);
      if (this.Lrd != null)
      {
        paramVarArgs.ni(7, this.Lrd.computeSize());
        this.Lrd.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.Lre);
      paramVarArgs.e(9, 8, this.Lrf);
      paramVarArgs.aM(10, this.Lrg);
      paramVarArgs.aM(11, this.Lrh);
      AppMethodBeat.o(115836);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.LqX) + 0;
      paramInt = i;
      if (this.LqY != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LqY);
      }
      i = paramInt;
      if (this.LqZ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LqZ);
      }
      i = i + g.a.a.b.b.a.bu(4, this.Lra) + g.a.a.b.b.a.bu(5, this.Lrb) + g.a.a.b.b.a.bu(6, this.Lrc);
      paramInt = i;
      if (this.Lrd != null) {
        paramInt = i + g.a.a.a.nh(7, this.Lrd.computeSize());
      }
      i = g.a.a.b.b.a.bu(8, this.Lre);
      int j = g.a.a.a.c(9, 8, this.Lrf);
      int k = g.a.a.b.b.a.bu(10, this.Lrg);
      int m = g.a.a.b.b.a.bu(11, this.Lrh);
      AppMethodBeat.o(115836);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lrf.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(115836);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ahj localahj = (ahj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115836);
        return -1;
      case 1: 
        localahj.LqX = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115836);
        return 0;
      case 2: 
        localahj.LqY = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(115836);
        return 0;
      case 3: 
        localahj.LqZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(115836);
        return 0;
      case 4: 
        localahj.Lra = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115836);
        return 0;
      case 5: 
        localahj.Lrb = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115836);
        return 0;
      case 6: 
        localahj.Lrc = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115836);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new esr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((esr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localahj.Lrd = ((esr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115836);
        return 0;
      case 8: 
        localahj.Lre = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115836);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new euf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((euf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localahj.Lrf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115836);
        return 0;
      case 10: 
        localahj.Lrg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115836);
        return 0;
      }
      localahj.Lrh = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(115836);
      return 0;
    }
    AppMethodBeat.o(115836);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahj
 * JD-Core Version:    0.7.0.1
 */