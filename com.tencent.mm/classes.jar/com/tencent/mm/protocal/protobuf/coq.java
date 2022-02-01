package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class coq
  extends com.tencent.mm.bw.a
{
  public int KWb;
  public String LPS;
  public int MuO;
  public int MuP;
  public String ThumbUrl;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89663);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
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
      paramVarArgs.aM(1, this.MuO);
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.e(3, this.ThumbUrl);
      }
      paramVarArgs.aM(4, this.KWb);
      if (this.LPS != null) {
        paramVarArgs.e(5, this.LPS);
      }
      paramVarArgs.aM(6, this.MuP);
      AppMethodBeat.o(89663);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.MuO) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.ThumbUrl);
      }
      i += g.a.a.b.b.a.bu(4, this.KWb);
      paramInt = i;
      if (this.LPS != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LPS);
      }
      i = g.a.a.b.b.a.bu(6, this.MuP);
      AppMethodBeat.o(89663);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.Title == null)
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
      coq localcoq = (coq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(89663);
        return -1;
      case 1: 
        localcoq.MuO = locala.UbS.zi();
        AppMethodBeat.o(89663);
        return 0;
      case 2: 
        localcoq.Title = locala.UbS.readString();
        AppMethodBeat.o(89663);
        return 0;
      case 3: 
        localcoq.ThumbUrl = locala.UbS.readString();
        AppMethodBeat.o(89663);
        return 0;
      case 4: 
        localcoq.KWb = locala.UbS.zi();
        AppMethodBeat.o(89663);
        return 0;
      case 5: 
        localcoq.LPS = locala.UbS.readString();
        AppMethodBeat.o(89663);
        return 0;
      }
      localcoq.MuP = locala.UbS.zi();
      AppMethodBeat.o(89663);
      return 0;
    }
    AppMethodBeat.o(89663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coq
 * JD-Core Version:    0.7.0.1
 */