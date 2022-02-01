package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmw
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> YVU;
  public int ZVB;
  public String ZVC;
  
  public bmw()
  {
    AppMethodBeat.i(258876);
    this.YVU = new LinkedList();
    AppMethodBeat.o(258876);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258879);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.YVU);
      paramVarArgs.bS(2, this.ZVB);
      if (this.ZVC != null) {
        paramVarArgs.g(3, this.ZVC);
      }
      AppMethodBeat.o(258879);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.a.c(1, 1, this.YVU) + 0 + i.a.a.b.b.a.cJ(2, this.ZVB);
      paramInt = i;
      if (this.ZVC != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZVC);
      }
      AppMethodBeat.o(258879);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YVU.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258879);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bmw localbmw = (bmw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258879);
        return -1;
      case 1: 
        localbmw.YVU.add(locala.ajGk.readString());
        AppMethodBeat.o(258879);
        return 0;
      case 2: 
        localbmw.ZVB = locala.ajGk.aar();
        AppMethodBeat.o(258879);
        return 0;
      }
      localbmw.ZVC = locala.ajGk.readString();
      AppMethodBeat.o(258879);
      return 0;
    }
    AppMethodBeat.o(258879);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmw
 * JD-Core Version:    0.7.0.1
 */