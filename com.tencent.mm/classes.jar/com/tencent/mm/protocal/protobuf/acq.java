package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acq
  extends com.tencent.mm.bw.a
{
  public int Gux;
  public String Guy;
  public String Guz;
  public boolean enable;
  public String kzz;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189298);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.enable);
      paramVarArgs.aS(2, this.Gux);
      if (this.kzz != null) {
        paramVarArgs.d(3, this.kzz);
      }
      if (this.Guy != null) {
        paramVarArgs.d(4, this.Guy);
      }
      if (this.Guz != null) {
        paramVarArgs.d(5, this.Guz);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      AppMethodBeat.o(189298);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amF(1) + 0 + f.a.a.b.b.a.bz(2, this.Gux);
      paramInt = i;
      if (this.kzz != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.kzz);
      }
      i = paramInt;
      if (this.Guy != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Guy);
      }
      paramInt = i;
      if (this.Guz != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Guz);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.title);
      }
      AppMethodBeat.o(189298);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(189298);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      acq localacq = (acq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189298);
        return -1;
      case 1: 
        localacq.enable = locala.OmT.gvY();
        AppMethodBeat.o(189298);
        return 0;
      case 2: 
        localacq.Gux = locala.OmT.zc();
        AppMethodBeat.o(189298);
        return 0;
      case 3: 
        localacq.kzz = locala.OmT.readString();
        AppMethodBeat.o(189298);
        return 0;
      case 4: 
        localacq.Guy = locala.OmT.readString();
        AppMethodBeat.o(189298);
        return 0;
      case 5: 
        localacq.Guz = locala.OmT.readString();
        AppMethodBeat.o(189298);
        return 0;
      }
      localacq.title = locala.OmT.readString();
      AppMethodBeat.o(189298);
      return 0;
    }
    AppMethodBeat.o(189298);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acq
 * JD-Core Version:    0.7.0.1
 */