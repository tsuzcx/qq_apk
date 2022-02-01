package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eph
  extends com.tencent.mm.bx.a
{
  public int YZM;
  public String desc;
  public String icon;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259318);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YZM);
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(3, this.desc);
      }
      if (this.icon != null) {
        paramVarArgs.g(4, this.icon);
      }
      AppMethodBeat.o(259318);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YZM) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.desc);
      }
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.icon);
      }
      AppMethodBeat.o(259318);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259318);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eph localeph = (eph)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259318);
        return -1;
      case 1: 
        localeph.YZM = locala.ajGk.aar();
        AppMethodBeat.o(259318);
        return 0;
      case 2: 
        localeph.title = locala.ajGk.readString();
        AppMethodBeat.o(259318);
        return 0;
      case 3: 
        localeph.desc = locala.ajGk.readString();
        AppMethodBeat.o(259318);
        return 0;
      }
      localeph.icon = locala.ajGk.readString();
      AppMethodBeat.o(259318);
      return 0;
    }
    AppMethodBeat.o(259318);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eph
 * JD-Core Version:    0.7.0.1
 */