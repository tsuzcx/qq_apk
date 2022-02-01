package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbf
  extends com.tencent.mm.bw.a
{
  public String MGh;
  public String MGi;
  public String MGj;
  public String MGk;
  public boolean MGl;
  public String MGm;
  public String dDj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72547);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MGh != null) {
        paramVarArgs.e(1, this.MGh);
      }
      if (this.MGi != null) {
        paramVarArgs.e(2, this.MGi);
      }
      if (this.dDj != null) {
        paramVarArgs.e(3, this.dDj);
      }
      if (this.MGj != null) {
        paramVarArgs.e(4, this.MGj);
      }
      if (this.MGk != null) {
        paramVarArgs.e(5, this.MGk);
      }
      paramVarArgs.cc(6, this.MGl);
      if (this.MGm != null) {
        paramVarArgs.e(7, this.MGm);
      }
      AppMethodBeat.o(72547);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MGh == null) {
        break label562;
      }
    }
    label562:
    for (int i = g.a.a.b.b.a.f(1, this.MGh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MGi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MGi);
      }
      i = paramInt;
      if (this.dDj != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dDj);
      }
      paramInt = i;
      if (this.MGj != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MGj);
      }
      i = paramInt;
      if (this.MGk != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MGk);
      }
      i += g.a.a.b.b.a.fS(6) + 1;
      paramInt = i;
      if (this.MGm != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MGm);
      }
      AppMethodBeat.o(72547);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72547);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dbf localdbf = (dbf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72547);
          return -1;
        case 1: 
          localdbf.MGh = locala.UbS.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 2: 
          localdbf.MGi = locala.UbS.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 3: 
          localdbf.dDj = locala.UbS.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 4: 
          localdbf.MGj = locala.UbS.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 5: 
          localdbf.MGk = locala.UbS.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 6: 
          localdbf.MGl = locala.UbS.yZ();
          AppMethodBeat.o(72547);
          return 0;
        }
        localdbf.MGm = locala.UbS.readString();
        AppMethodBeat.o(72547);
        return 0;
      }
      AppMethodBeat.o(72547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbf
 * JD-Core Version:    0.7.0.1
 */