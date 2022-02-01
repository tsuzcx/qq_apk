package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anf
  extends com.tencent.mm.bw.a
{
  public String KTg;
  public LinkedList<amz> Lyf;
  public amz Lyg;
  public int him;
  
  public anf()
  {
    AppMethodBeat.i(127478);
    this.Lyf = new LinkedList();
    AppMethodBeat.o(127478);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127479);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.him);
      if (this.KTg != null) {
        paramVarArgs.e(2, this.KTg);
      }
      paramVarArgs.e(3, 8, this.Lyf);
      if (this.Lyg != null)
      {
        paramVarArgs.ni(4, this.Lyg.computeSize());
        this.Lyg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.him) + 0;
      paramInt = i;
      if (this.KTg != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KTg);
      }
      i = paramInt + g.a.a.a.c(3, 8, this.Lyf);
      paramInt = i;
      if (this.Lyg != null) {
        paramInt = i + g.a.a.a.nh(4, this.Lyg.computeSize());
      }
      AppMethodBeat.o(127479);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lyf.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      anf localanf = (anf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127479);
        return -1;
      case 1: 
        localanf.him = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127479);
        return 0;
      case 2: 
        localanf.KTg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(127479);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new amz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((amz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localanf.Lyf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127479);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new amz();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((amz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localanf.Lyg = ((amz)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    AppMethodBeat.o(127479);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anf
 * JD-Core Version:    0.7.0.1
 */