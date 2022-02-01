package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ghn
  extends com.tencent.mm.bx.a
{
  public int acdV;
  public String appId;
  public int hBm;
  public int opType;
  public int scene;
  public String url;
  public String xIc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258769);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.hBm);
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.appId != null) {
        paramVarArgs.g(3, this.appId);
      }
      paramVarArgs.bS(4, this.scene);
      if (this.xIc != null) {
        paramVarArgs.g(5, this.xIc);
      }
      paramVarArgs.bS(6, this.opType);
      paramVarArgs.bS(7, this.acdV);
      AppMethodBeat.o(258769);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.hBm) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.appId);
      }
      i += i.a.a.b.b.a.cJ(4, this.scene);
      paramInt = i;
      if (this.xIc != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.xIc);
      }
      i = i.a.a.b.b.a.cJ(6, this.opType);
      int j = i.a.a.b.b.a.cJ(7, this.acdV);
      AppMethodBeat.o(258769);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258769);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ghn localghn = (ghn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258769);
        return -1;
      case 1: 
        localghn.hBm = locala.ajGk.aar();
        AppMethodBeat.o(258769);
        return 0;
      case 2: 
        localghn.url = locala.ajGk.readString();
        AppMethodBeat.o(258769);
        return 0;
      case 3: 
        localghn.appId = locala.ajGk.readString();
        AppMethodBeat.o(258769);
        return 0;
      case 4: 
        localghn.scene = locala.ajGk.aar();
        AppMethodBeat.o(258769);
        return 0;
      case 5: 
        localghn.xIc = locala.ajGk.readString();
        AppMethodBeat.o(258769);
        return 0;
      case 6: 
        localghn.opType = locala.ajGk.aar();
        AppMethodBeat.o(258769);
        return 0;
      }
      localghn.acdV = locala.ajGk.aar();
      AppMethodBeat.o(258769);
      return 0;
    }
    AppMethodBeat.o(258769);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ghn
 * JD-Core Version:    0.7.0.1
 */