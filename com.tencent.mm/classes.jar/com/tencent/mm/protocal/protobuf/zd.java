package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zd
  extends com.tencent.mm.bw.a
{
  public String AOv;
  public String Crt;
  public int Lko;
  public String dQx;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72459);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.dQx != null) {
        paramVarArgs.e(2, this.dQx);
      }
      if (this.AOv != null) {
        paramVarArgs.e(3, this.AOv);
      }
      if (this.Crt != null) {
        paramVarArgs.e(4, this.Crt);
      }
      paramVarArgs.aM(5, this.Lko);
      AppMethodBeat.o(72459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label438;
      }
    }
    label438:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dQx);
      }
      i = paramInt;
      if (this.AOv != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.AOv);
      }
      paramInt = i;
      if (this.Crt != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Crt);
      }
      i = g.a.a.b.b.a.bu(5, this.Lko);
      AppMethodBeat.o(72459);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72459);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        zd localzd = (zd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72459);
          return -1;
        case 1: 
          localzd.title = locala.UbS.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 2: 
          localzd.dQx = locala.UbS.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 3: 
          localzd.AOv = locala.UbS.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 4: 
          localzd.Crt = locala.UbS.readString();
          AppMethodBeat.o(72459);
          return 0;
        }
        localzd.Lko = locala.UbS.zi();
        AppMethodBeat.o(72459);
        return 0;
      }
      AppMethodBeat.o(72459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zd
 * JD-Core Version:    0.7.0.1
 */