package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class w
  extends com.tencent.mm.bx.a
{
  public LinkedList<x> Tpv;
  public long key;
  
  public w()
  {
    AppMethodBeat.i(290049);
    this.Tpv = new LinkedList();
    AppMethodBeat.o(290049);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290060);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.key);
      paramVarArgs.e(2, 8, this.Tpv);
      AppMethodBeat.o(290060);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.key);
      i = i.a.a.a.c(2, 8, this.Tpv);
      AppMethodBeat.o(290060);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Tpv.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(290060);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      w localw = (w)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(290060);
        return -1;
      case 1: 
        localw.key = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(290060);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        x localx = new x();
        if ((localObject != null) && (localObject.length > 0)) {
          localx.parseFrom((byte[])localObject);
        }
        localw.Tpv.add(localx);
        paramInt += 1;
      }
      AppMethodBeat.o(290060);
      return 0;
    }
    AppMethodBeat.o(290060);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.w
 * JD-Core Version:    0.7.0.1
 */