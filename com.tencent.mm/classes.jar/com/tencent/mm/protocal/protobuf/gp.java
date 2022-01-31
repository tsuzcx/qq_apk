package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gp
  extends com.tencent.mm.bv.a
{
  public LinkedList<String> wsV;
  public int wsW;
  public int wsX;
  
  public gp()
  {
    AppMethodBeat.i(62511);
    this.wsV = new LinkedList();
    AppMethodBeat.o(62511);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62512);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.wsV);
      paramVarArgs.aO(2, this.wsW);
      paramVarArgs.aO(3, this.wsX);
      AppMethodBeat.o(62512);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 1, this.wsV);
      int i = e.a.a.b.b.a.bl(2, this.wsW);
      int j = e.a.a.b.b.a.bl(3, this.wsX);
      AppMethodBeat.o(62512);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wsV.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(62512);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      gp localgp = (gp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(62512);
        return -1;
      case 1: 
        localgp.wsV.add(locala.CLY.readString());
        AppMethodBeat.o(62512);
        return 0;
      case 2: 
        localgp.wsW = locala.CLY.sl();
        AppMethodBeat.o(62512);
        return 0;
      }
      localgp.wsX = locala.CLY.sl();
      AppMethodBeat.o(62512);
      return 0;
    }
    AppMethodBeat.o(62512);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gp
 * JD-Core Version:    0.7.0.1
 */