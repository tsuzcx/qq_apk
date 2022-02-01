package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eyv
  extends com.tencent.mm.bw.a
{
  public long KMm;
  public long Nvw;
  public String Nvx;
  public LinkedList<eyw> Nvy;
  
  public eyv()
  {
    AppMethodBeat.i(32534);
    this.Nvy = new LinkedList();
    AppMethodBeat.o(32534);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32535);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nvx == null)
      {
        paramVarArgs = new b("Not all required fields were included: TotalMsg");
        AppMethodBeat.o(32535);
        throw paramVarArgs;
      }
      paramVarArgs.bb(1, this.Nvw);
      paramVarArgs.bb(2, this.KMm);
      if (this.Nvx != null) {
        paramVarArgs.e(3, this.Nvx);
      }
      paramVarArgs.e(4, 8, this.Nvy);
      AppMethodBeat.o(32535);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.Nvw) + 0 + g.a.a.b.b.a.r(2, this.KMm);
      paramInt = i;
      if (this.Nvx != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Nvx);
      }
      i = g.a.a.a.c(4, 8, this.Nvy);
      AppMethodBeat.o(32535);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Nvy.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.Nvx == null)
      {
        paramVarArgs = new b("Not all required fields were included: TotalMsg");
        AppMethodBeat.o(32535);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32535);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eyv localeyv = (eyv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32535);
        return -1;
      case 1: 
        localeyv.Nvw = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(32535);
        return 0;
      case 2: 
        localeyv.KMm = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(32535);
        return 0;
      case 3: 
        localeyv.Nvx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32535);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new eyw();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((eyw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localeyv.Nvy.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32535);
      return 0;
    }
    AppMethodBeat.o(32535);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyv
 * JD-Core Version:    0.7.0.1
 */