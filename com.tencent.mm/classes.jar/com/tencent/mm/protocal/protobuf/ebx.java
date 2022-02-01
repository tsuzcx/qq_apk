package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebx
  extends com.tencent.mm.bw.a
{
  public String NbA;
  public String NbB;
  public String NbC;
  public String Nbx;
  public String Nby;
  public String Nbz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200227);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nbx != null) {
        paramVarArgs.e(1, this.Nbx);
      }
      if (this.Nby != null) {
        paramVarArgs.e(2, this.Nby);
      }
      if (this.Nbz != null) {
        paramVarArgs.e(3, this.Nbz);
      }
      if (this.NbA != null) {
        paramVarArgs.e(4, this.NbA);
      }
      if (this.NbB != null) {
        paramVarArgs.e(5, this.NbB);
      }
      if (this.NbC != null) {
        paramVarArgs.e(6, this.NbC);
      }
      AppMethodBeat.o(200227);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nbx == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.f(1, this.Nbx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nby != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Nby);
      }
      i = paramInt;
      if (this.Nbz != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Nbz);
      }
      paramInt = i;
      if (this.NbA != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NbA);
      }
      i = paramInt;
      if (this.NbB != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.NbB);
      }
      paramInt = i;
      if (this.NbC != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.NbC);
      }
      AppMethodBeat.o(200227);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200227);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ebx localebx = (ebx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200227);
          return -1;
        case 1: 
          localebx.Nbx = locala.UbS.readString();
          AppMethodBeat.o(200227);
          return 0;
        case 2: 
          localebx.Nby = locala.UbS.readString();
          AppMethodBeat.o(200227);
          return 0;
        case 3: 
          localebx.Nbz = locala.UbS.readString();
          AppMethodBeat.o(200227);
          return 0;
        case 4: 
          localebx.NbA = locala.UbS.readString();
          AppMethodBeat.o(200227);
          return 0;
        case 5: 
          localebx.NbB = locala.UbS.readString();
          AppMethodBeat.o(200227);
          return 0;
        }
        localebx.NbC = locala.UbS.readString();
        AppMethodBeat.o(200227);
        return 0;
      }
      AppMethodBeat.o(200227);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebx
 * JD-Core Version:    0.7.0.1
 */