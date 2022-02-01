package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csi
  extends com.tencent.mm.bw.a
{
  public csl Mxp;
  public csj Mxq;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256723);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.Mxp != null)
      {
        paramVarArgs.ni(2, this.Mxp.computeSize());
        this.Mxp.writeFields(paramVarArgs);
      }
      if (this.Mxq != null)
      {
        paramVarArgs.ni(101, this.Mxq.computeSize());
        this.Mxq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(256723);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.Mxp != null) {
        paramInt = i + g.a.a.a.nh(2, this.Mxp.computeSize());
      }
      i = paramInt;
      if (this.Mxq != null) {
        i = paramInt + g.a.a.a.nh(101, this.Mxq.computeSize());
      }
      AppMethodBeat.o(256723);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(256723);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      csi localcsi = (csi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(256723);
        return -1;
      case 1: 
        localcsi.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(256723);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new csl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((csl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcsi.Mxp = ((csl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(256723);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new csj();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((csj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localcsi.Mxq = ((csj)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(256723);
      return 0;
    }
    AppMethodBeat.o(256723);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csi
 * JD-Core Version:    0.7.0.1
 */