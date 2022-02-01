package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class boe
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> ZWy;
  public LinkedList<String> ZWz;
  public LinkedList<String> username_list;
  
  public boe()
  {
    AppMethodBeat.i(258500);
    this.ZWy = new LinkedList();
    this.username_list = new LinkedList();
    this.ZWz = new LinkedList();
    AppMethodBeat.o(258500);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258504);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.ZWy);
      paramVarArgs.e(2, 1, this.username_list);
      paramVarArgs.e(3, 1, this.ZWz);
      AppMethodBeat.o(258504);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 1, this.ZWy);
      int i = i.a.a.a.c(2, 1, this.username_list);
      int j = i.a.a.a.c(3, 1, this.ZWz);
      AppMethodBeat.o(258504);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZWy.clear();
      this.username_list.clear();
      this.ZWz.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258504);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      boe localboe = (boe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258504);
        return -1;
      case 1: 
        localboe.ZWy.add(locala.ajGk.readString());
        AppMethodBeat.o(258504);
        return 0;
      case 2: 
        localboe.username_list.add(locala.ajGk.readString());
        AppMethodBeat.o(258504);
        return 0;
      }
      localboe.ZWz.add(locala.ajGk.readString());
      AppMethodBeat.o(258504);
      return 0;
    }
    AppMethodBeat.o(258504);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boe
 * JD-Core Version:    0.7.0.1
 */