package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czw
  extends com.tencent.mm.bw.a
{
  public String KZR;
  public int MFg;
  public String MFh;
  public String MFi;
  public String dNI;
  public String iwv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91579);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      paramVarArgs.aM(2, this.MFg);
      if (this.MFh != null) {
        paramVarArgs.e(3, this.MFh);
      }
      if (this.MFi != null) {
        paramVarArgs.e(4, this.MFi);
      }
      if (this.KZR != null) {
        paramVarArgs.e(5, this.KZR);
      }
      if (this.iwv != null) {
        paramVarArgs.e(6, this.iwv);
      }
      AppMethodBeat.o(91579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = g.a.a.b.b.a.f(1, this.dNI) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MFg);
      paramInt = i;
      if (this.MFh != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.MFh);
      }
      i = paramInt;
      if (this.MFi != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MFi);
      }
      paramInt = i;
      if (this.KZR != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KZR);
      }
      i = paramInt;
      if (this.iwv != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.iwv);
      }
      AppMethodBeat.o(91579);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91579);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        czw localczw = (czw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91579);
          return -1;
        case 1: 
          localczw.dNI = locala.UbS.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 2: 
          localczw.MFg = locala.UbS.zi();
          AppMethodBeat.o(91579);
          return 0;
        case 3: 
          localczw.MFh = locala.UbS.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 4: 
          localczw.MFi = locala.UbS.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 5: 
          localczw.KZR = locala.UbS.readString();
          AppMethodBeat.o(91579);
          return 0;
        }
        localczw.iwv = locala.UbS.readString();
        AppMethodBeat.o(91579);
        return 0;
      }
      AppMethodBeat.o(91579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czw
 * JD-Core Version:    0.7.0.1
 */