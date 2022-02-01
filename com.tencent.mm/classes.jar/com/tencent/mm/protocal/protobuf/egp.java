package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class egp
  extends com.tencent.mm.bw.a
{
  public String Ikv;
  public boolean Ikw;
  public int Ikx;
  public int Iky;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110856);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ikv != null) {
        paramVarArgs.d(1, this.Ikv);
      }
      paramVarArgs.bC(2, this.Ikw);
      paramVarArgs.aS(3, this.Ikx);
      paramVarArgs.aS(4, this.Iky);
      AppMethodBeat.o(110856);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ikv == null) {
        break label346;
      }
    }
    label346:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ikv) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.amF(2);
      int j = f.a.a.b.b.a.bz(3, this.Ikx);
      int k = f.a.a.b.b.a.bz(4, this.Iky);
      AppMethodBeat.o(110856);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(110856);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        egp localegp = (egp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110856);
          return -1;
        case 1: 
          localegp.Ikv = locala.OmT.readString();
          AppMethodBeat.o(110856);
          return 0;
        case 2: 
          localegp.Ikw = locala.OmT.gvY();
          AppMethodBeat.o(110856);
          return 0;
        case 3: 
          localegp.Ikx = locala.OmT.zc();
          AppMethodBeat.o(110856);
          return 0;
        }
        localegp.Iky = locala.OmT.zc();
        AppMethodBeat.o(110856);
        return 0;
      }
      AppMethodBeat.o(110856);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egp
 * JD-Core Version:    0.7.0.1
 */