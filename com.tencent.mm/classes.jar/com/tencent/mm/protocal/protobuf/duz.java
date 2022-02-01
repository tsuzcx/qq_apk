package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class duz
  extends com.tencent.mm.bw.a
{
  public LinkedList<dvb> MWd;
  public LinkedList<duy> MWe;
  public dva MWf;
  public LinkedList<dvd> MWg;
  public boolean gyp;
  public boolean thE;
  
  public duz()
  {
    AppMethodBeat.i(122527);
    this.gyp = true;
    this.thE = false;
    this.MWd = new LinkedList();
    this.MWe = new LinkedList();
    this.MWg = new LinkedList();
    AppMethodBeat.o(122527);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122528);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.gyp);
      paramVarArgs.cc(2, this.thE);
      paramVarArgs.e(3, 8, this.MWd);
      paramVarArgs.e(4, 8, this.MWe);
      if (this.MWf != null)
      {
        paramVarArgs.ni(5, this.MWf.computeSize());
        this.MWf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.MWg);
      AppMethodBeat.o(122528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.fS(1) + 1 + 0 + (g.a.a.b.b.a.fS(2) + 1) + g.a.a.a.c(3, 8, this.MWd) + g.a.a.a.c(4, 8, this.MWe);
      paramInt = i;
      if (this.MWf != null) {
        paramInt = i + g.a.a.a.nh(5, this.MWf.computeSize());
      }
      i = g.a.a.a.c(6, 8, this.MWg);
      AppMethodBeat.o(122528);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MWd.clear();
      this.MWe.clear();
      this.MWg.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(122528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      duz localduz = (duz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122528);
        return -1;
      case 1: 
        localduz.gyp = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(122528);
        return 0;
      case 2: 
        localduz.thE = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(122528);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dvb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dvb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localduz.MWd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new duy();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((duy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localduz.MWe.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dva();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dva)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localduz.MWf = ((dva)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dvd();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dvd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localduz.MWg.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(122528);
      return 0;
    }
    AppMethodBeat.o(122528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duz
 * JD-Core Version:    0.7.0.1
 */