package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afv
  extends com.tencent.mm.bx.a
{
  public String dbName;
  public String owc;
  public String qQf;
  public int qQi;
  public String qQm;
  public String sql;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210587);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qQf != null) {
        paramVarArgs.d(1, this.qQf);
      }
      paramVarArgs.aS(2, this.qQi);
      if (this.sql != null) {
        paramVarArgs.d(3, this.sql);
      }
      if (this.dbName != null) {
        paramVarArgs.d(4, this.dbName);
      }
      if (this.owc != null) {
        paramVarArgs.d(5, this.owc);
      }
      if (this.qQm != null) {
        paramVarArgs.d(6, this.qQm);
      }
      AppMethodBeat.o(210587);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qQf == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.qQf) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.qQi);
      paramInt = i;
      if (this.sql != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.sql);
      }
      i = paramInt;
      if (this.dbName != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dbName);
      }
      paramInt = i;
      if (this.owc != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.owc);
      }
      i = paramInt;
      if (this.qQm != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.qQm);
      }
      AppMethodBeat.o(210587);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(210587);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        afv localafv = (afv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(210587);
          return -1;
        case 1: 
          localafv.qQf = locala.NPN.readString();
          AppMethodBeat.o(210587);
          return 0;
        case 2: 
          localafv.qQi = locala.NPN.zc();
          AppMethodBeat.o(210587);
          return 0;
        case 3: 
          localafv.sql = locala.NPN.readString();
          AppMethodBeat.o(210587);
          return 0;
        case 4: 
          localafv.dbName = locala.NPN.readString();
          AppMethodBeat.o(210587);
          return 0;
        case 5: 
          localafv.owc = locala.NPN.readString();
          AppMethodBeat.o(210587);
          return 0;
        }
        localafv.qQm = locala.NPN.readString();
        AppMethodBeat.o(210587);
        return 0;
      }
      AppMethodBeat.o(210587);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afv
 * JD-Core Version:    0.7.0.1
 */