package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eaw
  extends com.tencent.mm.bw.a
{
  public long Nar;
  public LinkedList<dqi> oTA;
  public int oTz;
  public String xMo;
  
  public eaw()
  {
    AppMethodBeat.i(125816);
    this.oTA = new LinkedList();
    AppMethodBeat.o(125816);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125817);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Nar);
      if (this.xMo != null) {
        paramVarArgs.e(2, this.xMo);
      }
      paramVarArgs.aM(3, this.oTz);
      paramVarArgs.e(4, 8, this.oTA);
      AppMethodBeat.o(125817);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.Nar) + 0;
      paramInt = i;
      if (this.xMo != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xMo);
      }
      i = g.a.a.b.b.a.bu(3, this.oTz);
      int j = g.a.a.a.c(4, 8, this.oTA);
      AppMethodBeat.o(125817);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.oTA.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125817);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eaw localeaw = (eaw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125817);
        return -1;
      case 1: 
        localeaw.Nar = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(125817);
        return 0;
      case 2: 
        localeaw.xMo = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125817);
        return 0;
      case 3: 
        localeaw.oTz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125817);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dqi();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localeaw.oTA.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125817);
      return 0;
    }
    AppMethodBeat.o(125817);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaw
 * JD-Core Version:    0.7.0.1
 */