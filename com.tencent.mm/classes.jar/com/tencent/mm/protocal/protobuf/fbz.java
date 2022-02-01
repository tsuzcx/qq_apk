package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbz
  extends com.tencent.mm.bw.a
{
  public String MiN;
  public String Nyc;
  public String dNI;
  public String dmc;
  public String qcK;
  public String qcM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214330);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      if (this.Nyc != null) {
        paramVarArgs.e(2, this.Nyc);
      }
      if (this.qcK != null) {
        paramVarArgs.e(3, this.qcK);
      }
      if (this.dmc != null) {
        paramVarArgs.e(4, this.dmc);
      }
      if (this.MiN != null) {
        paramVarArgs.e(5, this.MiN);
      }
      if (this.qcM != null) {
        paramVarArgs.e(6, this.qcM);
      }
      AppMethodBeat.o(214330);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.f(1, this.dNI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nyc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Nyc);
      }
      i = paramInt;
      if (this.qcK != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.qcK);
      }
      paramInt = i;
      if (this.dmc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.dmc);
      }
      i = paramInt;
      if (this.MiN != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MiN);
      }
      paramInt = i;
      if (this.qcM != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.qcM);
      }
      AppMethodBeat.o(214330);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(214330);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fbz localfbz = (fbz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(214330);
          return -1;
        case 1: 
          localfbz.dNI = locala.UbS.readString();
          AppMethodBeat.o(214330);
          return 0;
        case 2: 
          localfbz.Nyc = locala.UbS.readString();
          AppMethodBeat.o(214330);
          return 0;
        case 3: 
          localfbz.qcK = locala.UbS.readString();
          AppMethodBeat.o(214330);
          return 0;
        case 4: 
          localfbz.dmc = locala.UbS.readString();
          AppMethodBeat.o(214330);
          return 0;
        case 5: 
          localfbz.MiN = locala.UbS.readString();
          AppMethodBeat.o(214330);
          return 0;
        }
        localfbz.qcM = locala.UbS.readString();
        AppMethodBeat.o(214330);
        return 0;
      }
      AppMethodBeat.o(214330);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbz
 * JD-Core Version:    0.7.0.1
 */