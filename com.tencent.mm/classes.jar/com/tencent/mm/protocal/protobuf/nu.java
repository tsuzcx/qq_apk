package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nu
  extends com.tencent.mm.bw.a
{
  public String KTl;
  public String KTt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124417);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KTt != null) {
        paramVarArgs.e(2, this.KTt);
      }
      if (this.KTl != null) {
        paramVarArgs.e(3, this.KTl);
      }
      AppMethodBeat.o(124417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KTt == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(2, this.KTt) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KTl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KTl);
      }
      AppMethodBeat.o(124417);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124417);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        nu localnu = (nu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124417);
          return -1;
        case 2: 
          localnu.KTt = locala.UbS.readString();
          AppMethodBeat.o(124417);
          return 0;
        }
        localnu.KTl = locala.UbS.readString();
        AppMethodBeat.o(124417);
        return 0;
      }
      AppMethodBeat.o(124417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nu
 * JD-Core Version:    0.7.0.1
 */