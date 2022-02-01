package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tj
  extends com.tencent.mm.bx.a
{
  public String YYZ;
  public int action;
  public String url;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259419);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.action);
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.YYZ != null) {
        paramVarArgs.g(3, this.YYZ);
      }
      if (this.wording != null) {
        paramVarArgs.g(4, this.wording);
      }
      AppMethodBeat.o(259419);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.action) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.YYZ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YYZ);
      }
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.wording);
      }
      AppMethodBeat.o(259419);
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
      AppMethodBeat.o(259419);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      tj localtj = (tj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259419);
        return -1;
      case 1: 
        localtj.action = locala.ajGk.aar();
        AppMethodBeat.o(259419);
        return 0;
      case 2: 
        localtj.url = locala.ajGk.readString();
        AppMethodBeat.o(259419);
        return 0;
      case 3: 
        localtj.YYZ = locala.ajGk.readString();
        AppMethodBeat.o(259419);
        return 0;
      }
      localtj.wording = locala.ajGk.readString();
      AppMethodBeat.o(259419);
      return 0;
    }
    AppMethodBeat.o(259419);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tj
 * JD-Core Version:    0.7.0.1
 */