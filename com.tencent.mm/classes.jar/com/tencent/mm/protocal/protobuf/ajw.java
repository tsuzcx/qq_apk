package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajw
  extends com.tencent.mm.bw.a
{
  public String FYD;
  public String Ghg;
  public int Ghh;
  public String Goj;
  public String Gok;
  public String Gol;
  public int Gom;
  public String Gzr;
  public int Gzs;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127456);
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
      if (this.Gzr != null) {
        paramVarArgs.d(5, this.Gzr);
      }
      if (this.Ghg != null) {
        paramVarArgs.d(6, this.Ghg);
      }
      paramVarArgs.aS(7, this.Ghh);
      if (this.FYD != null) {
        paramVarArgs.d(8, this.FYD);
      }
      paramVarArgs.aS(9, this.nJb);
      paramVarArgs.aS(10, this.Gzs);
      AppMethodBeat.o(127456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Goj == null) {
        break label702;
      }
    }
    label702:
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
      i += f.a.a.b.b.a.bz(4, this.Gom);
      paramInt = i;
      if (this.Gzr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gzr);
      }
      i = paramInt;
      if (this.Ghg != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Ghg);
      }
      i += f.a.a.b.b.a.bz(7, this.Ghh);
      paramInt = i;
      if (this.FYD != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FYD);
      }
      i = f.a.a.b.b.a.bz(9, this.nJb);
      int j = f.a.a.b.b.a.bz(10, this.Gzs);
      AppMethodBeat.o(127456);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127456);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ajw localajw = (ajw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127456);
          return -1;
        case 1: 
          localajw.Goj = locala.OmT.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 2: 
          localajw.Gok = locala.OmT.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 3: 
          localajw.Gol = locala.OmT.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 4: 
          localajw.Gom = locala.OmT.zc();
          AppMethodBeat.o(127456);
          return 0;
        case 5: 
          localajw.Gzr = locala.OmT.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 6: 
          localajw.Ghg = locala.OmT.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 7: 
          localajw.Ghh = locala.OmT.zc();
          AppMethodBeat.o(127456);
          return 0;
        case 8: 
          localajw.FYD = locala.OmT.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 9: 
          localajw.nJb = locala.OmT.zc();
          AppMethodBeat.o(127456);
          return 0;
        }
        localajw.Gzs = locala.OmT.zc();
        AppMethodBeat.o(127456);
        return 0;
      }
      AppMethodBeat.o(127456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajw
 * JD-Core Version:    0.7.0.1
 */