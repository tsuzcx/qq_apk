package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sf
  extends com.tencent.mm.bw.a
{
  public String KZR;
  public int action;
  public String dQx;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200189);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.action);
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.KZR != null) {
        paramVarArgs.e(3, this.KZR);
      }
      if (this.dQx != null) {
        paramVarArgs.e(4, this.dQx);
      }
      AppMethodBeat.o(200189);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.action) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.KZR != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KZR);
      }
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.dQx);
      }
      AppMethodBeat.o(200189);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(200189);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      sf localsf = (sf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(200189);
        return -1;
      case 1: 
        localsf.action = locala.UbS.zi();
        AppMethodBeat.o(200189);
        return 0;
      case 2: 
        localsf.url = locala.UbS.readString();
        AppMethodBeat.o(200189);
        return 0;
      case 3: 
        localsf.KZR = locala.UbS.readString();
        AppMethodBeat.o(200189);
        return 0;
      }
      localsf.dQx = locala.UbS.readString();
      AppMethodBeat.o(200189);
      return 0;
    }
    AppMethodBeat.o(200189);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sf
 * JD-Core Version:    0.7.0.1
 */