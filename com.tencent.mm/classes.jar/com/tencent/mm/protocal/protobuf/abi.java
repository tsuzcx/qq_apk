package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abi
  extends com.tencent.mm.bx.a
{
  public LinkedList<esb> ZjU;
  
  public abi()
  {
    AppMethodBeat.i(152514);
    this.ZjU = new LinkedList();
    AppMethodBeat.o(152514);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152515);
    if (paramInt == 0)
    {
      ((i.a.a.c.a)paramVarArgs[0]).e(1, 8, this.ZjU);
      AppMethodBeat.o(152515);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.ZjU);
      AppMethodBeat.o(152515);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZjU.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(152515);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      abi localabi = (abi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152515);
        return -1;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        esb localesb = new esb();
        if ((localObject != null) && (localObject.length > 0)) {
          localesb.parseFrom((byte[])localObject);
        }
        localabi.ZjU.add(localesb);
        paramInt += 1;
      }
      AppMethodBeat.o(152515);
      return 0;
    }
    AppMethodBeat.o(152515);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abi
 * JD-Core Version:    0.7.0.1
 */