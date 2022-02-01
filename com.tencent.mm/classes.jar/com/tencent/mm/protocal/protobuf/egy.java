package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egy
  extends com.tencent.mm.bx.a
{
  public String LZD;
  public LinkedList<egx> mew;
  
  public egy()
  {
    AppMethodBeat.i(259120);
    this.mew = new LinkedList();
    AppMethodBeat.o(259120);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259122);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.mew);
      if (this.LZD != null) {
        paramVarArgs.g(2, this.LZD);
      }
      AppMethodBeat.o(259122);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.mew) + 0;
      paramInt = i;
      if (this.LZD != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.LZD);
      }
      AppMethodBeat.o(259122);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.mew.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259122);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      egy localegy = (egy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259122);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          egx localegx = new egx();
          if ((localObject != null) && (localObject.length > 0)) {
            localegx.parseFrom((byte[])localObject);
          }
          localegy.mew.add(localegx);
          paramInt += 1;
        }
        AppMethodBeat.o(259122);
        return 0;
      }
      localegy.LZD = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(259122);
      return 0;
    }
    AppMethodBeat.o(259122);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egy
 * JD-Core Version:    0.7.0.1
 */