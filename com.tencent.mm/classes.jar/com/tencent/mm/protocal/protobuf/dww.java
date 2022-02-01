package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dww
  extends com.tencent.mm.bw.a
{
  public long DUK;
  public long GdF;
  public String GdG;
  public LinkedList<dwx> GdH;
  
  public dww()
  {
    AppMethodBeat.i(32534);
    this.GdH = new LinkedList();
    AppMethodBeat.o(32534);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32535);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GdG == null)
      {
        paramVarArgs = new b("Not all required fields were included: TotalMsg");
        AppMethodBeat.o(32535);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.GdF);
      paramVarArgs.aO(2, this.DUK);
      if (this.GdG != null) {
        paramVarArgs.d(3, this.GdG);
      }
      paramVarArgs.e(4, 8, this.GdH);
      AppMethodBeat.o(32535);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.GdF) + 0 + f.a.a.b.b.a.p(2, this.DUK);
      paramInt = i;
      if (this.GdG != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GdG);
      }
      i = f.a.a.a.c(4, 8, this.GdH);
      AppMethodBeat.o(32535);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GdH.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.GdG == null)
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
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dww localdww = (dww)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32535);
        return -1;
      case 1: 
        localdww.GdF = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(32535);
        return 0;
      case 2: 
        localdww.DUK = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(32535);
        return 0;
      case 3: 
        localdww.GdG = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32535);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dwx();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dwx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdww.GdH.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dww
 * JD-Core Version:    0.7.0.1
 */