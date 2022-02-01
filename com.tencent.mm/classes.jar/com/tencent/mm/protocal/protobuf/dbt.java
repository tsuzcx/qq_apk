package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbt
  extends com.tencent.mm.bx.a
{
  public String aaHk;
  public String path;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259488);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.aaHk != null) {
        paramVarArgs.g(2, this.aaHk);
      }
      if (this.path != null) {
        paramVarArgs.g(3, this.path);
      }
      AppMethodBeat.o(259488);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.aaHk != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaHk);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.path);
      }
      AppMethodBeat.o(259488);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259488);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dbt localdbt = (dbt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259488);
        return -1;
      case 1: 
        localdbt.type = locala.ajGk.aar();
        AppMethodBeat.o(259488);
        return 0;
      case 2: 
        localdbt.aaHk = locala.ajGk.readString();
        AppMethodBeat.o(259488);
        return 0;
      }
      localdbt.path = locala.ajGk.readString();
      AppMethodBeat.o(259488);
      return 0;
    }
    AppMethodBeat.o(259488);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbt
 * JD-Core Version:    0.7.0.1
 */