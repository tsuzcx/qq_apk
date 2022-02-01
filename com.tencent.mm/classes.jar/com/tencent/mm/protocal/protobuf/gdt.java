package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gdt
  extends com.tencent.mm.bx.a
{
  public String MEz;
  public String icon_url;
  public String jump_url;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260045);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.MEz != null) {
        paramVarArgs.g(2, this.MEz);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(3, this.icon_url);
      }
      if (this.jump_url != null) {
        paramVarArgs.g(4, this.jump_url);
      }
      AppMethodBeat.o(260045);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.MEz != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.MEz);
      }
      i = paramInt;
      if (this.icon_url != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.icon_url);
      }
      paramInt = i;
      if (this.jump_url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.jump_url);
      }
      AppMethodBeat.o(260045);
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
      AppMethodBeat.o(260045);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gdt localgdt = (gdt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260045);
        return -1;
      case 1: 
        localgdt.type = locala.ajGk.aar();
        AppMethodBeat.o(260045);
        return 0;
      case 2: 
        localgdt.MEz = locala.ajGk.readString();
        AppMethodBeat.o(260045);
        return 0;
      case 3: 
        localgdt.icon_url = locala.ajGk.readString();
        AppMethodBeat.o(260045);
        return 0;
      }
      localgdt.jump_url = locala.ajGk.readString();
      AppMethodBeat.o(260045);
      return 0;
    }
    AppMethodBeat.o(260045);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gdt
 * JD-Core Version:    0.7.0.1
 */