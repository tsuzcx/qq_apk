package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mr
  extends com.tencent.mm.bw.a
{
  public String KQY;
  public String UserName;
  public String keb;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212224);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      if (this.KQY != null) {
        paramVarArgs.e(3, this.KQY);
      }
      if (this.keb != null) {
        paramVarArgs.e(4, this.keb);
      }
      AppMethodBeat.o(212224);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oUJ);
      }
      i = paramInt;
      if (this.KQY != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KQY);
      }
      paramInt = i;
      if (this.keb != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.keb);
      }
      AppMethodBeat.o(212224);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212224);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        mr localmr = (mr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212224);
          return -1;
        case 1: 
          localmr.UserName = locala.UbS.readString();
          AppMethodBeat.o(212224);
          return 0;
        case 2: 
          localmr.oUJ = locala.UbS.readString();
          AppMethodBeat.o(212224);
          return 0;
        case 3: 
          localmr.KQY = locala.UbS.readString();
          AppMethodBeat.o(212224);
          return 0;
        }
        localmr.keb = locala.UbS.readString();
        AppMethodBeat.o(212224);
        return 0;
      }
      AppMethodBeat.o(212224);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mr
 * JD-Core Version:    0.7.0.1
 */