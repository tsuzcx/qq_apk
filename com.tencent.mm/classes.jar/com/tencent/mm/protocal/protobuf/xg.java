package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xg
  extends com.tencent.mm.bw.a
{
  public LinkedList<xh> Lin;
  public int Lio;
  public dqi Lip;
  public int gsq;
  
  public xg()
  {
    AppMethodBeat.i(43085);
    this.Lin = new LinkedList();
    AppMethodBeat.o(43085);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43086);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.gsq);
      paramVarArgs.e(2, 8, this.Lin);
      paramVarArgs.aM(3, this.Lio);
      if (this.Lip != null)
      {
        paramVarArgs.ni(4, this.Lip.computeSize());
        this.Lip.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.gsq) + 0 + g.a.a.a.c(2, 8, this.Lin) + g.a.a.b.b.a.bu(3, this.Lio);
      paramInt = i;
      if (this.Lip != null) {
        paramInt = i + g.a.a.a.nh(4, this.Lip.computeSize());
      }
      AppMethodBeat.o(43086);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lin.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      xg localxg = (xg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43086);
        return -1;
      case 1: 
        localxg.gsq = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43086);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localxg.Lin.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43086);
        return 0;
      case 3: 
        localxg.Lio = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43086);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dqi();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localxg.Lip = ((dqi)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    AppMethodBeat.o(43086);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xg
 * JD-Core Version:    0.7.0.1
 */