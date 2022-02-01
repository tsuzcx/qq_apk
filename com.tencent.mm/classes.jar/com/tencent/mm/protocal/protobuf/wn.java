package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wn
  extends com.tencent.mm.bw.a
{
  public String Goj;
  public String Gok;
  public String Gol;
  public int Gom;
  public int Gon;
  public String Goo;
  public int Gop;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127444);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Goj != null) {
        paramVarArgs.d(1, this.Goj);
      }
      if (this.Gok != null) {
        paramVarArgs.d(2, this.Gok);
      }
      if (this.Gol != null) {
        paramVarArgs.d(3, this.Gol);
      }
      paramVarArgs.aS(4, this.Gom);
      paramVarArgs.aS(5, this.Gon);
      if (this.Goo != null) {
        paramVarArgs.d(6, this.Goo);
      }
      paramVarArgs.aS(7, this.Gop);
      AppMethodBeat.o(127444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Goj == null) {
        break label530;
      }
    }
    label530:
    for (int i = f.a.a.b.b.a.e(1, this.Goj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gok != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gok);
      }
      i = paramInt;
      if (this.Gol != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gol);
      }
      i = i + f.a.a.b.b.a.bz(4, this.Gom) + f.a.a.b.b.a.bz(5, this.Gon);
      paramInt = i;
      if (this.Goo != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Goo);
      }
      i = f.a.a.b.b.a.bz(7, this.Gop);
      AppMethodBeat.o(127444);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127444);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        wn localwn = (wn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127444);
          return -1;
        case 1: 
          localwn.Goj = locala.OmT.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 2: 
          localwn.Gok = locala.OmT.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 3: 
          localwn.Gol = locala.OmT.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 4: 
          localwn.Gom = locala.OmT.zc();
          AppMethodBeat.o(127444);
          return 0;
        case 5: 
          localwn.Gon = locala.OmT.zc();
          AppMethodBeat.o(127444);
          return 0;
        case 6: 
          localwn.Goo = locala.OmT.readString();
          AppMethodBeat.o(127444);
          return 0;
        }
        localwn.Gop = locala.OmT.zc();
        AppMethodBeat.o(127444);
        return 0;
      }
      AppMethodBeat.o(127444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wn
 * JD-Core Version:    0.7.0.1
 */