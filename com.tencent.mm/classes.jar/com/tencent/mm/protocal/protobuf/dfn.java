package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfn
  extends com.tencent.mm.bw.a
{
  public int LsZ;
  public long Lta;
  public LinkedList<dfw> MKx;
  public int yqb;
  
  public dfn()
  {
    AppMethodBeat.i(32381);
    this.MKx = new LinkedList();
    AppMethodBeat.o(32381);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32382);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LsZ);
      paramVarArgs.bb(2, this.Lta);
      paramVarArgs.e(3, 8, this.MKx);
      paramVarArgs.aM(4, this.yqb);
      AppMethodBeat.o(32382);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.LsZ);
      i = g.a.a.b.b.a.r(2, this.Lta);
      int j = g.a.a.a.c(3, 8, this.MKx);
      int k = g.a.a.b.b.a.bu(4, this.yqb);
      AppMethodBeat.o(32382);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MKx.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32382);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dfn localdfn = (dfn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32382);
        return -1;
      case 1: 
        localdfn.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32382);
        return 0;
      case 2: 
        localdfn.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(32382);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dfw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdfn.MKx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32382);
        return 0;
      }
      localdfn.yqb = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(32382);
      return 0;
    }
    AppMethodBeat.o(32382);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfn
 * JD-Core Version:    0.7.0.1
 */