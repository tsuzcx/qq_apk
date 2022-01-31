package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class avr
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String Url;
  public String ntp;
  public String xlc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28528);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.e(1, this.Url);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.xlc != null) {
        paramVarArgs.e(3, this.xlc);
      }
      if (this.ntp != null) {
        paramVarArgs.e(4, this.ntp);
      }
      AppMethodBeat.o(28528);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label404;
      }
    }
    label404:
    for (int i = e.a.a.b.b.a.f(1, this.Url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.xlc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xlc);
      }
      paramInt = i;
      if (this.ntp != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ntp);
      }
      AppMethodBeat.o(28528);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28528);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        avr localavr = (avr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28528);
          return -1;
        case 1: 
          localavr.Url = locala.CLY.readString();
          AppMethodBeat.o(28528);
          return 0;
        case 2: 
          localavr.Title = locala.CLY.readString();
          AppMethodBeat.o(28528);
          return 0;
        case 3: 
          localavr.xlc = locala.CLY.readString();
          AppMethodBeat.o(28528);
          return 0;
        }
        localavr.ntp = locala.CLY.readString();
        AppMethodBeat.o(28528);
        return 0;
      }
      AppMethodBeat.o(28528);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avr
 * JD-Core Version:    0.7.0.1
 */