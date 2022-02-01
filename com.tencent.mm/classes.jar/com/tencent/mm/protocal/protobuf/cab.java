package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cab
  extends com.tencent.mm.bw.a
{
  public String Lqy;
  public int Lqz;
  public String ynY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147769);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lqy != null) {
        paramVarArgs.e(1, this.Lqy);
      }
      paramVarArgs.aM(2, this.Lqz);
      if (this.ynY != null) {
        paramVarArgs.e(3, this.ynY);
      }
      AppMethodBeat.o(147769);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lqy == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.Lqy) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.Lqz);
      paramInt = i;
      if (this.ynY != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.ynY);
      }
      AppMethodBeat.o(147769);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(147769);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cab localcab = (cab)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147769);
          return -1;
        case 1: 
          localcab.Lqy = locala.UbS.readString();
          AppMethodBeat.o(147769);
          return 0;
        case 2: 
          localcab.Lqz = locala.UbS.zi();
          AppMethodBeat.o(147769);
          return 0;
        }
        localcab.ynY = locala.UbS.readString();
        AppMethodBeat.o(147769);
        return 0;
      }
      AppMethodBeat.o(147769);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cab
 * JD-Core Version:    0.7.0.1
 */