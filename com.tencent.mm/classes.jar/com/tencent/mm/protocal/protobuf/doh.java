package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class doh
  extends com.tencent.mm.bx.a
{
  public String ThumbUrl;
  public int YVh;
  public int aaVm;
  public int aaVn;
  public String aako;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89663);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(89663);
        throw paramVarArgs;
      }
      if (this.ThumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbUrl");
        AppMethodBeat.o(89663);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.aaVm);
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.g(3, this.ThumbUrl);
      }
      paramVarArgs.bS(4, this.YVh);
      if (this.aako != null) {
        paramVarArgs.g(5, this.aako);
      }
      paramVarArgs.bS(6, this.aaVn);
      AppMethodBeat.o(89663);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aaVm) + 0;
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAP);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ThumbUrl);
      }
      i += i.a.a.b.b.a.cJ(4, this.YVh);
      paramInt = i;
      if (this.aako != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aako);
      }
      i = i.a.a.b.b.a.cJ(6, this.aaVn);
      AppMethodBeat.o(89663);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.hAP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(89663);
        throw paramVarArgs;
      }
      if (this.ThumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbUrl");
        AppMethodBeat.o(89663);
        throw paramVarArgs;
      }
      AppMethodBeat.o(89663);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      doh localdoh = (doh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(89663);
        return -1;
      case 1: 
        localdoh.aaVm = locala.ajGk.aar();
        AppMethodBeat.o(89663);
        return 0;
      case 2: 
        localdoh.hAP = locala.ajGk.readString();
        AppMethodBeat.o(89663);
        return 0;
      case 3: 
        localdoh.ThumbUrl = locala.ajGk.readString();
        AppMethodBeat.o(89663);
        return 0;
      case 4: 
        localdoh.YVh = locala.ajGk.aar();
        AppMethodBeat.o(89663);
        return 0;
      case 5: 
        localdoh.aako = locala.ajGk.readString();
        AppMethodBeat.o(89663);
        return 0;
      }
      localdoh.aaVn = locala.ajGk.aar();
      AppMethodBeat.o(89663);
      return 0;
    }
    AppMethodBeat.o(89663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doh
 * JD-Core Version:    0.7.0.1
 */