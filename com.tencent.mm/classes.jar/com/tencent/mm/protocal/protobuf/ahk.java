package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahk
  extends com.tencent.mm.bw.a
{
  public int Lri;
  public LinkedList<ahj> Lrj;
  
  public ahk()
  {
    AppMethodBeat.i(115837);
    this.Lrj = new LinkedList();
    AppMethodBeat.o(115837);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115838);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Lri);
      paramVarArgs.e(2, 8, this.Lrj);
      AppMethodBeat.o(115838);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Lri);
      i = g.a.a.a.c(2, 8, this.Lrj);
      AppMethodBeat.o(115838);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lrj.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(115838);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ahk localahk = (ahk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115838);
        return -1;
      case 1: 
        localahk.Lri = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115838);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ahj();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ahj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localahk.Lrj.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(115838);
      return 0;
    }
    AppMethodBeat.o(115838);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahk
 * JD-Core Version:    0.7.0.1
 */