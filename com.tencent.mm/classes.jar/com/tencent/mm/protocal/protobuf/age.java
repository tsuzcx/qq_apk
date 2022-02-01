package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class age
  extends com.tencent.mm.bw.a
{
  public String dbPath;
  public String qXW;
  public int qYb;
  public String qYh;
  public String sql;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196254);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qXW != null) {
        paramVarArgs.d(1, this.qXW);
      }
      paramVarArgs.aS(2, this.qYb);
      if (this.sql != null) {
        paramVarArgs.d(3, this.sql);
      }
      if (this.dbPath != null) {
        paramVarArgs.d(4, this.dbPath);
      }
      if (this.qYh != null) {
        paramVarArgs.d(5, this.qYh);
      }
      AppMethodBeat.o(196254);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qXW == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.qXW) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.qYb);
      paramInt = i;
      if (this.sql != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.sql);
      }
      i = paramInt;
      if (this.dbPath != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dbPath);
      }
      paramInt = i;
      if (this.qYh != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.qYh);
      }
      AppMethodBeat.o(196254);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(196254);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        age localage = (age)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(196254);
          return -1;
        case 1: 
          localage.qXW = locala.OmT.readString();
          AppMethodBeat.o(196254);
          return 0;
        case 2: 
          localage.qYb = locala.OmT.zc();
          AppMethodBeat.o(196254);
          return 0;
        case 3: 
          localage.sql = locala.OmT.readString();
          AppMethodBeat.o(196254);
          return 0;
        case 4: 
          localage.dbPath = locala.OmT.readString();
          AppMethodBeat.o(196254);
          return 0;
        }
        localage.qYh = locala.OmT.readString();
        AppMethodBeat.o(196254);
        return 0;
      }
      AppMethodBeat.o(196254);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.age
 * JD-Core Version:    0.7.0.1
 */