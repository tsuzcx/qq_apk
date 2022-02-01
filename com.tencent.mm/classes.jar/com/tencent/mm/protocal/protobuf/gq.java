package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gq
  extends com.tencent.mm.bw.a
{
  public int KKn;
  public int KKo;
  public int KKv;
  public gr KKw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32120);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KKn);
      paramVarArgs.aM(2, this.KKo);
      paramVarArgs.aM(3, this.KKv);
      if (this.KKw != null)
      {
        paramVarArgs.ni(4, this.KKw.computeSize());
        this.KKw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32120);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.KKn) + 0 + g.a.a.b.b.a.bu(2, this.KKo) + g.a.a.b.b.a.bu(3, this.KKv);
      paramInt = i;
      if (this.KKw != null) {
        paramInt = i + g.a.a.a.nh(4, this.KKw.computeSize());
      }
      AppMethodBeat.o(32120);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32120);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      gq localgq = (gq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32120);
        return -1;
      case 1: 
        localgq.KKn = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32120);
        return 0;
      case 2: 
        localgq.KKo = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32120);
        return 0;
      case 3: 
        localgq.KKv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32120);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new gr();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((gr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localgq.KKw = ((gr)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32120);
      return 0;
    }
    AppMethodBeat.o(32120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gq
 * JD-Core Version:    0.7.0.1
 */