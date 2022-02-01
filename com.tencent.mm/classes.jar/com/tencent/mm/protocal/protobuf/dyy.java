package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyy
  extends com.tencent.mm.bw.a
{
  public int APg;
  public dr LWZ;
  public String Lca;
  public akg MYA;
  public LinkedList<dki> MYB;
  public int MYC;
  public LinkedList<dev> MYz;
  
  public dyy()
  {
    AppMethodBeat.i(91694);
    this.MYz = new LinkedList();
    this.MYB = new LinkedList();
    AppMethodBeat.o(91694);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91695);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.APg);
      paramVarArgs.e(2, 8, this.MYz);
      if (this.MYA != null)
      {
        paramVarArgs.ni(3, this.MYA.computeSize());
        this.MYA.writeFields(paramVarArgs);
      }
      if (this.LWZ != null)
      {
        paramVarArgs.ni(4, this.LWZ.computeSize());
        this.LWZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.MYB);
      paramVarArgs.aM(6, this.MYC);
      if (this.Lca != null) {
        paramVarArgs.e(7, this.Lca);
      }
      AppMethodBeat.o(91695);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.APg) + 0 + g.a.a.a.c(2, 8, this.MYz);
      paramInt = i;
      if (this.MYA != null) {
        paramInt = i + g.a.a.a.nh(3, this.MYA.computeSize());
      }
      i = paramInt;
      if (this.LWZ != null) {
        i = paramInt + g.a.a.a.nh(4, this.LWZ.computeSize());
      }
      i = i + g.a.a.a.c(5, 8, this.MYB) + g.a.a.b.b.a.bu(6, this.MYC);
      paramInt = i;
      if (this.Lca != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Lca);
      }
      AppMethodBeat.o(91695);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MYz.clear();
      this.MYB.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91695);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dyy localdyy = (dyy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91695);
        return -1;
      case 1: 
        localdyy.APg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91695);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dev();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dev)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdyy.MYz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new akg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((akg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdyy.MYA = ((akg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdyy.LWZ = ((dr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dki();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dki)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdyy.MYB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 6: 
        localdyy.MYC = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91695);
        return 0;
      }
      localdyy.Lca = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(91695);
      return 0;
    }
    AppMethodBeat.o(91695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyy
 * JD-Core Version:    0.7.0.1
 */