package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctb
  extends com.tencent.mm.bw.a
{
  public String MxY;
  public String MxZ;
  public int Mya;
  public int Myb;
  public int Myc;
  public int Myd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133179);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MxY != null) {
        paramVarArgs.e(1, this.MxY);
      }
      if (this.MxZ != null) {
        paramVarArgs.e(2, this.MxZ);
      }
      paramVarArgs.aM(3, this.Mya);
      paramVarArgs.aM(4, this.Myb);
      paramVarArgs.aM(5, this.Myc);
      paramVarArgs.aM(7, this.Myd);
      AppMethodBeat.o(133179);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MxY == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = g.a.a.b.b.a.f(1, this.MxY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MxZ != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MxZ);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.Mya);
      int j = g.a.a.b.b.a.bu(4, this.Myb);
      int k = g.a.a.b.b.a.bu(5, this.Myc);
      int m = g.a.a.b.b.a.bu(7, this.Myd);
      AppMethodBeat.o(133179);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(133179);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ctb localctb = (ctb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 6: 
        default: 
          AppMethodBeat.o(133179);
          return -1;
        case 1: 
          localctb.MxY = locala.UbS.readString();
          AppMethodBeat.o(133179);
          return 0;
        case 2: 
          localctb.MxZ = locala.UbS.readString();
          AppMethodBeat.o(133179);
          return 0;
        case 3: 
          localctb.Mya = locala.UbS.zi();
          AppMethodBeat.o(133179);
          return 0;
        case 4: 
          localctb.Myb = locala.UbS.zi();
          AppMethodBeat.o(133179);
          return 0;
        case 5: 
          localctb.Myc = locala.UbS.zi();
          AppMethodBeat.o(133179);
          return 0;
        }
        localctb.Myd = locala.UbS.zi();
        AppMethodBeat.o(133179);
        return 0;
      }
      AppMethodBeat.o(133179);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctb
 * JD-Core Version:    0.7.0.1
 */