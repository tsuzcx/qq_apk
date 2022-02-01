package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xy
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> FXA;
  public String FXB;
  
  public xy()
  {
    AppMethodBeat.i(152518);
    this.FXA = new LinkedList();
    AppMethodBeat.o(152518);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152519);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.FXA);
      if (this.FXB != null) {
        paramVarArgs.d(2, this.FXB);
      }
      AppMethodBeat.o(152519);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.a.c(1, 1, this.FXA) + 0;
      paramInt = i;
      if (this.FXB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FXB);
      }
      AppMethodBeat.o(152519);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FXA.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(152519);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      xy localxy = (xy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152519);
        return -1;
      case 1: 
        localxy.FXA.add(locala.NPN.readString());
        AppMethodBeat.o(152519);
        return 0;
      }
      localxy.FXB = locala.NPN.readString();
      AppMethodBeat.o(152519);
      return 0;
    }
    AppMethodBeat.o(152519);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xy
 * JD-Core Version:    0.7.0.1
 */