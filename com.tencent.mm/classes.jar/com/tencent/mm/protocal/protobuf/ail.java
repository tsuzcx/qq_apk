package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ail
  extends com.tencent.mm.bw.a
{
  public String dbPath;
  public String sql;
  public String syg;
  public int syl;
  public String syr;
  public String syt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220695);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.syg != null) {
        paramVarArgs.e(1, this.syg);
      }
      paramVarArgs.aM(2, this.syl);
      if (this.sql != null) {
        paramVarArgs.e(3, this.sql);
      }
      if (this.dbPath != null) {
        paramVarArgs.e(4, this.dbPath);
      }
      if (this.syr != null) {
        paramVarArgs.e(5, this.syr);
      }
      if (this.syt != null) {
        paramVarArgs.e(6, this.syt);
      }
      AppMethodBeat.o(220695);
      return 0;
    }
    if (paramInt == 1) {
      if (this.syg == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = g.a.a.b.b.a.f(1, this.syg) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.syl);
      paramInt = i;
      if (this.sql != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.sql);
      }
      i = paramInt;
      if (this.dbPath != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.dbPath);
      }
      paramInt = i;
      if (this.syr != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.syr);
      }
      i = paramInt;
      if (this.syt != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.syt);
      }
      AppMethodBeat.o(220695);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(220695);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ail localail = (ail)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(220695);
          return -1;
        case 1: 
          localail.syg = locala.UbS.readString();
          AppMethodBeat.o(220695);
          return 0;
        case 2: 
          localail.syl = locala.UbS.zi();
          AppMethodBeat.o(220695);
          return 0;
        case 3: 
          localail.sql = locala.UbS.readString();
          AppMethodBeat.o(220695);
          return 0;
        case 4: 
          localail.dbPath = locala.UbS.readString();
          AppMethodBeat.o(220695);
          return 0;
        case 5: 
          localail.syr = locala.UbS.readString();
          AppMethodBeat.o(220695);
          return 0;
        }
        localail.syt = locala.UbS.readString();
        AppMethodBeat.o(220695);
        return 0;
      }
      AppMethodBeat.o(220695);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ail
 * JD-Core Version:    0.7.0.1
 */