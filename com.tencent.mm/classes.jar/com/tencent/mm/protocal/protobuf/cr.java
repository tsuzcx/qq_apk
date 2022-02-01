package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cr
  extends com.tencent.mm.bx.a
{
  public int YEX;
  public String YEY;
  public String app_id;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259178);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YEX);
      if (this.app_id != null) {
        paramVarArgs.g(2, this.app_id);
      }
      if (this.path != null) {
        paramVarArgs.g(3, this.path);
      }
      if (this.YEY != null) {
        paramVarArgs.g(4, this.YEY);
      }
      AppMethodBeat.o(259178);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YEX) + 0;
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.app_id);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.path);
      }
      paramInt = i;
      if (this.YEY != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YEY);
      }
      AppMethodBeat.o(259178);
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
      AppMethodBeat.o(259178);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      cr localcr = (cr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259178);
        return -1;
      case 1: 
        localcr.YEX = locala.ajGk.aar();
        AppMethodBeat.o(259178);
        return 0;
      case 2: 
        localcr.app_id = locala.ajGk.readString();
        AppMethodBeat.o(259178);
        return 0;
      case 3: 
        localcr.path = locala.ajGk.readString();
        AppMethodBeat.o(259178);
        return 0;
      }
      localcr.YEY = locala.ajGk.readString();
      AppMethodBeat.o(259178);
      return 0;
    }
    AppMethodBeat.o(259178);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cr
 * JD-Core Version:    0.7.0.1
 */