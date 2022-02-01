package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awl
  extends com.tencent.mm.bw.a
{
  public LinkedList<avj> LHg;
  public cjd LHh;
  public int LHi;
  public String LHj;
  
  public awl()
  {
    AppMethodBeat.i(209534);
    this.LHg = new LinkedList();
    AppMethodBeat.o(209534);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209535);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.LHg);
      if (this.LHh != null)
      {
        paramVarArgs.ni(2, this.LHh.computeSize());
        this.LHh.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.LHi);
      if (this.LHj != null) {
        paramVarArgs.e(4, this.LHj);
      }
      AppMethodBeat.o(209535);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.LHg) + 0;
      paramInt = i;
      if (this.LHh != null) {
        paramInt = i + g.a.a.a.nh(2, this.LHh.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.LHi);
      paramInt = i;
      if (this.LHj != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LHj);
      }
      AppMethodBeat.o(209535);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LHg.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209535);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      awl localawl = (awl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209535);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localawl.LHg.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209535);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjd();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localawl.LHh = ((cjd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209535);
        return 0;
      case 3: 
        localawl.LHi = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209535);
        return 0;
      }
      localawl.LHj = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(209535);
      return 0;
    }
    AppMethodBeat.o(209535);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awl
 * JD-Core Version:    0.7.0.1
 */