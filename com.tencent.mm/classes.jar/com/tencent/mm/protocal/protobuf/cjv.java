package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjv
  extends com.tencent.mm.bw.a
{
  public LinkedList<cjw> Mpl;
  public LinkedList<cjw> Mpm;
  public cjw Mpn;
  public int Mpo;
  public long dTS;
  public String key;
  public int yfC;
  
  public cjv()
  {
    AppMethodBeat.i(225972);
    this.Mpl = new LinkedList();
    this.Mpm = new LinkedList();
    AppMethodBeat.o(225972);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225973);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Mpl);
      paramVarArgs.e(2, 8, this.Mpm);
      if (this.Mpn != null)
      {
        paramVarArgs.ni(3, this.Mpn.computeSize());
        this.Mpn.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.yfC);
      paramVarArgs.aM(5, this.Mpo);
      paramVarArgs.bb(6, this.dTS);
      if (this.key != null) {
        paramVarArgs.e(7, this.key);
      }
      AppMethodBeat.o(225973);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Mpl) + 0 + g.a.a.a.c(2, 8, this.Mpm);
      paramInt = i;
      if (this.Mpn != null) {
        paramInt = i + g.a.a.a.nh(3, this.Mpn.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.yfC) + g.a.a.b.b.a.bu(5, this.Mpo) + g.a.a.b.b.a.r(6, this.dTS);
      paramInt = i;
      if (this.key != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.key);
      }
      AppMethodBeat.o(225973);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Mpl.clear();
      this.Mpm.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(225973);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cjv localcjv = (cjv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(225973);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcjv.Mpl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(225973);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcjv.Mpm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(225973);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcjv.Mpn = ((cjw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(225973);
        return 0;
      case 4: 
        localcjv.yfC = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(225973);
        return 0;
      case 5: 
        localcjv.Mpo = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(225973);
        return 0;
      case 6: 
        localcjv.dTS = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(225973);
        return 0;
      }
      localcjv.key = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(225973);
      return 0;
    }
    AppMethodBeat.o(225973);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjv
 * JD-Core Version:    0.7.0.1
 */