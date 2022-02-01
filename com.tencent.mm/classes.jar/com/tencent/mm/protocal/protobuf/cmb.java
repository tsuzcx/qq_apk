package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmb
  extends com.tencent.mm.bw.a
{
  public String Mrt;
  public String Mru;
  public String Mrv;
  public String iAo;
  public String iAq;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103209);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.iAq != null) {
        paramVarArgs.e(2, this.iAq);
      }
      if (this.iAo != null) {
        paramVarArgs.e(3, this.iAo);
      }
      if (this.Mrt != null) {
        paramVarArgs.e(4, this.Mrt);
      }
      if (this.Mru != null) {
        paramVarArgs.e(5, this.Mru);
      }
      if (this.Mrv != null) {
        paramVarArgs.e(6, this.Mrv);
      }
      AppMethodBeat.o(103209);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iAq != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.iAq);
      }
      i = paramInt;
      if (this.iAo != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.iAo);
      }
      paramInt = i;
      if (this.Mrt != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Mrt);
      }
      i = paramInt;
      if (this.Mru != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Mru);
      }
      paramInt = i;
      if (this.Mrv != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Mrv);
      }
      AppMethodBeat.o(103209);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(103209);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cmb localcmb = (cmb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(103209);
          return -1;
        case 1: 
          localcmb.title = locala.UbS.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 2: 
          localcmb.iAq = locala.UbS.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 3: 
          localcmb.iAo = locala.UbS.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 4: 
          localcmb.Mrt = locala.UbS.readString();
          AppMethodBeat.o(103209);
          return 0;
        case 5: 
          localcmb.Mru = locala.UbS.readString();
          AppMethodBeat.o(103209);
          return 0;
        }
        localcmb.Mrv = locala.UbS.readString();
        AppMethodBeat.o(103209);
        return 0;
      }
      AppMethodBeat.o(103209);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmb
 * JD-Core Version:    0.7.0.1
 */