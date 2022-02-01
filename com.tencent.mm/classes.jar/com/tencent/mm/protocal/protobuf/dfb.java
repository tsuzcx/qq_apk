package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfb
  extends com.tencent.mm.bw.a
{
  public String LGp;
  public int MKc;
  public String dQx;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104374);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dQx != null) {
        paramVarArgs.e(1, this.dQx);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.LGp != null) {
        paramVarArgs.e(3, this.LGp);
      }
      paramVarArgs.aM(4, this.MKc);
      AppMethodBeat.o(104374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dQx == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.f(1, this.dQx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.LGp != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LGp);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.MKc);
      AppMethodBeat.o(104374);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(104374);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dfb localdfb = (dfb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104374);
          return -1;
        case 1: 
          localdfb.dQx = locala.UbS.readString();
          AppMethodBeat.o(104374);
          return 0;
        case 2: 
          localdfb.url = locala.UbS.readString();
          AppMethodBeat.o(104374);
          return 0;
        case 3: 
          localdfb.LGp = locala.UbS.readString();
          AppMethodBeat.o(104374);
          return 0;
        }
        localdfb.MKc = locala.UbS.zi();
        AppMethodBeat.o(104374);
        return 0;
      }
      AppMethodBeat.o(104374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfb
 * JD-Core Version:    0.7.0.1
 */