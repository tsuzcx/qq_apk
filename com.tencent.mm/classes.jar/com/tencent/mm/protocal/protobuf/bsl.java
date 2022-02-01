package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsl
  extends com.tencent.mm.bx.a
{
  public LinkedList<bux> aaam;
  public long lastUpdateTime;
  
  public bsl()
  {
    AppMethodBeat.i(259822);
    this.aaam = new LinkedList();
    AppMethodBeat.o(259822);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259826);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.lastUpdateTime);
      paramVarArgs.e(2, 8, this.aaam);
      AppMethodBeat.o(259826);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.lastUpdateTime);
      i = i.a.a.a.c(2, 8, this.aaam);
      AppMethodBeat.o(259826);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaam.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259826);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bsl localbsl = (bsl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259826);
        return -1;
      case 1: 
        localbsl.lastUpdateTime = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(259826);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        bux localbux = new bux();
        if ((localObject != null) && (localObject.length > 0)) {
          localbux.parseFrom((byte[])localObject);
        }
        localbsl.aaam.add(localbux);
        paramInt += 1;
      }
      AppMethodBeat.o(259826);
      return 0;
    }
    AppMethodBeat.o(259826);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsl
 * JD-Core Version:    0.7.0.1
 */