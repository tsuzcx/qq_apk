package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ag
  extends com.tencent.mm.bx.a
{
  public String Fre;
  public int Frf;
  public int Frg;
  public int Frh;
  public int Fri;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143961);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fre != null) {
        paramVarArgs.d(1, this.Fre);
      }
      paramVarArgs.aS(2, this.Frf);
      paramVarArgs.aS(3, this.Frg);
      paramVarArgs.aS(4, this.Frh);
      paramVarArgs.aS(5, this.Fri);
      AppMethodBeat.o(143961);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fre == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fre) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Frf);
      int j = f.a.a.b.b.a.bz(3, this.Frg);
      int k = f.a.a.b.b.a.bz(4, this.Frh);
      int m = f.a.a.b.b.a.bz(5, this.Fri);
      AppMethodBeat.o(143961);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(143961);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ag localag = (ag)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(143961);
          return -1;
        case 1: 
          localag.Fre = locala.NPN.readString();
          AppMethodBeat.o(143961);
          return 0;
        case 2: 
          localag.Frf = locala.NPN.zc();
          AppMethodBeat.o(143961);
          return 0;
        case 3: 
          localag.Frg = locala.NPN.zc();
          AppMethodBeat.o(143961);
          return 0;
        case 4: 
          localag.Frh = locala.NPN.zc();
          AppMethodBeat.o(143961);
          return 0;
        }
        localag.Fri = locala.NPN.zc();
        AppMethodBeat.o(143961);
        return 0;
      }
      AppMethodBeat.o(143961);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ag
 * JD-Core Version:    0.7.0.1
 */