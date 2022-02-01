package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cql
  extends com.tencent.mm.bw.a
{
  public String Lir;
  public String Lis;
  public int Mwb;
  public int Mwc;
  public b Mwd;
  public String Mwe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32353);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Mwb);
      paramVarArgs.aM(2, this.Mwc);
      if (this.Mwd != null) {
        paramVarArgs.c(3, this.Mwd);
      }
      if (this.Mwe != null) {
        paramVarArgs.e(4, this.Mwe);
      }
      if (this.Lir != null) {
        paramVarArgs.e(5, this.Lir);
      }
      if (this.Lis != null) {
        paramVarArgs.e(6, this.Lis);
      }
      AppMethodBeat.o(32353);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Mwb) + 0 + g.a.a.b.b.a.bu(2, this.Mwc);
      paramInt = i;
      if (this.Mwd != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.Mwd);
      }
      i = paramInt;
      if (this.Mwe != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Mwe);
      }
      paramInt = i;
      if (this.Lir != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Lir);
      }
      i = paramInt;
      if (this.Lis != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Lis);
      }
      AppMethodBeat.o(32353);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32353);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cql localcql = (cql)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32353);
        return -1;
      case 1: 
        localcql.Mwb = locala.UbS.zi();
        AppMethodBeat.o(32353);
        return 0;
      case 2: 
        localcql.Mwc = locala.UbS.zi();
        AppMethodBeat.o(32353);
        return 0;
      case 3: 
        localcql.Mwd = locala.UbS.hPo();
        AppMethodBeat.o(32353);
        return 0;
      case 4: 
        localcql.Mwe = locala.UbS.readString();
        AppMethodBeat.o(32353);
        return 0;
      case 5: 
        localcql.Lir = locala.UbS.readString();
        AppMethodBeat.o(32353);
        return 0;
      }
      localcql.Lis = locala.UbS.readString();
      AppMethodBeat.o(32353);
      return 0;
    }
    AppMethodBeat.o(32353);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cql
 * JD-Core Version:    0.7.0.1
 */