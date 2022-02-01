package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class an
  extends com.tencent.mm.bx.a
{
  public String Nlj;
  public String md5;
  public String name;
  public int size;
  public long uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267043);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.uin);
      if (this.name != null) {
        paramVarArgs.g(2, this.name);
      }
      paramVarArgs.bS(3, this.size);
      if (this.Nlj != null) {
        paramVarArgs.g(4, this.Nlj);
      }
      if (this.md5 != null) {
        paramVarArgs.g(5, this.md5);
      }
      AppMethodBeat.o(267043);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.uin) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.name);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.size);
      paramInt = i;
      if (this.Nlj != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Nlj);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.md5);
      }
      AppMethodBeat.o(267043);
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
      AppMethodBeat.o(267043);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      an localan = (an)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(267043);
        return -1;
      case 1: 
        localan.uin = locala.ajGk.aaw();
        AppMethodBeat.o(267043);
        return 0;
      case 2: 
        localan.name = locala.ajGk.readString();
        AppMethodBeat.o(267043);
        return 0;
      case 3: 
        localan.size = locala.ajGk.aar();
        AppMethodBeat.o(267043);
        return 0;
      case 4: 
        localan.Nlj = locala.ajGk.readString();
        AppMethodBeat.o(267043);
        return 0;
      }
      localan.md5 = locala.ajGk.readString();
      AppMethodBeat.o(267043);
      return 0;
    }
    AppMethodBeat.o(267043);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.an
 * JD-Core Version:    0.7.0.1
 */