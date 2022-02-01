package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class rv
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String KZl;
  public String KZm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117844);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.IconUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(117844);
        throw paramVarArgs;
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(1, this.IconUrl);
      }
      if (this.KZl != null) {
        paramVarArgs.e(2, this.KZl);
      }
      if (this.KZm != null) {
        paramVarArgs.e(3, this.KZm);
      }
      AppMethodBeat.o(117844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IconUrl == null) {
        break label382;
      }
    }
    label382:
    for (int i = g.a.a.b.b.a.f(1, this.IconUrl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KZl != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KZl);
      }
      i = paramInt;
      if (this.KZm != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KZm);
      }
      AppMethodBeat.o(117844);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.IconUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(117844);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117844);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        rv localrv = (rv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117844);
          return -1;
        case 1: 
          localrv.IconUrl = locala.UbS.readString();
          AppMethodBeat.o(117844);
          return 0;
        case 2: 
          localrv.KZl = locala.UbS.readString();
          AppMethodBeat.o(117844);
          return 0;
        }
        localrv.KZm = locala.UbS.readString();
        AppMethodBeat.o(117844);
        return 0;
      }
      AppMethodBeat.o(117844);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rv
 * JD-Core Version:    0.7.0.1
 */