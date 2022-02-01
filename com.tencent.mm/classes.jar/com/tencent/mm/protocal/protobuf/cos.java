package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cos
  extends com.tencent.mm.bw.a
{
  public String ixw;
  public String pqv;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72514);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.pqv != null) {
        paramVarArgs.e(1, this.pqv);
      }
      if (this.ixw != null) {
        paramVarArgs.e(2, this.ixw);
      }
      if (this.url != null) {
        paramVarArgs.e(4, this.url);
      }
      AppMethodBeat.o(72514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pqv == null) {
        break label338;
      }
    }
    label338:
    for (int i = g.a.a.b.b.a.f(1, this.pqv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ixw != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.ixw);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.url);
      }
      AppMethodBeat.o(72514);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72514);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cos localcos = (cos)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          AppMethodBeat.o(72514);
          return -1;
        case 1: 
          localcos.pqv = locala.UbS.readString();
          AppMethodBeat.o(72514);
          return 0;
        case 2: 
          localcos.ixw = locala.UbS.readString();
          AppMethodBeat.o(72514);
          return 0;
        }
        localcos.url = locala.UbS.readString();
        AppMethodBeat.o(72514);
        return 0;
      }
      AppMethodBeat.o(72514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cos
 * JD-Core Version:    0.7.0.1
 */