package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cxc
  extends com.tencent.mm.cd.a
{
  public int RXp;
  public String SYm;
  public int TFF;
  public int TFG;
  public String ThumbUrl;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89663);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr == null)
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
      paramVarArgs.aY(1, this.TFF);
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.f(3, this.ThumbUrl);
      }
      paramVarArgs.aY(4, this.RXp);
      if (this.SYm != null) {
        paramVarArgs.f(5, this.SYm);
      }
      paramVarArgs.aY(6, this.TFG);
      AppMethodBeat.o(89663);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.TFF) + 0;
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fwr);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ThumbUrl);
      }
      i += g.a.a.b.b.a.bM(4, this.RXp);
      paramInt = i;
      if (this.SYm != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SYm);
      }
      i = g.a.a.b.b.a.bM(6, this.TFG);
      AppMethodBeat.o(89663);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.fwr == null)
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
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cxc localcxc = (cxc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(89663);
        return -1;
      case 1: 
        localcxc.TFF = locala.abFh.AK();
        AppMethodBeat.o(89663);
        return 0;
      case 2: 
        localcxc.fwr = locala.abFh.readString();
        AppMethodBeat.o(89663);
        return 0;
      case 3: 
        localcxc.ThumbUrl = locala.abFh.readString();
        AppMethodBeat.o(89663);
        return 0;
      case 4: 
        localcxc.RXp = locala.abFh.AK();
        AppMethodBeat.o(89663);
        return 0;
      case 5: 
        localcxc.SYm = locala.abFh.readString();
        AppMethodBeat.o(89663);
        return 0;
      }
      localcxc.TFG = locala.abFh.AK();
      AppMethodBeat.o(89663);
      return 0;
    }
    AppMethodBeat.o(89663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxc
 * JD-Core Version:    0.7.0.1
 */