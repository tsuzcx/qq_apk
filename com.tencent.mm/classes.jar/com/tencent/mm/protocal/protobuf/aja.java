package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aja
  extends com.tencent.mm.cd.a
{
  public String dbPath;
  public String sql;
  public String wdY;
  public int wed;
  public int wej;
  public String wel;
  public String wen;
  public String weo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255926);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wdY != null) {
        paramVarArgs.f(1, this.wdY);
      }
      paramVarArgs.aY(2, this.wed);
      if (this.sql != null) {
        paramVarArgs.f(3, this.sql);
      }
      if (this.dbPath != null) {
        paramVarArgs.f(4, this.dbPath);
      }
      if (this.wel != null) {
        paramVarArgs.f(5, this.wel);
      }
      if (this.weo != null) {
        paramVarArgs.f(6, this.weo);
      }
      paramVarArgs.aY(7, this.wej);
      if (this.wen != null) {
        paramVarArgs.f(8, this.wen);
      }
      AppMethodBeat.o(255926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wdY == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = g.a.a.b.b.a.g(1, this.wdY) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.wed);
      paramInt = i;
      if (this.sql != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.sql);
      }
      i = paramInt;
      if (this.dbPath != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.dbPath);
      }
      paramInt = i;
      if (this.wel != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.wel);
      }
      i = paramInt;
      if (this.weo != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.weo);
      }
      i += g.a.a.b.b.a.bM(7, this.wej);
      paramInt = i;
      if (this.wen != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.wen);
      }
      AppMethodBeat.o(255926);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(255926);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aja localaja = (aja)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(255926);
          return -1;
        case 1: 
          localaja.wdY = locala.abFh.readString();
          AppMethodBeat.o(255926);
          return 0;
        case 2: 
          localaja.wed = locala.abFh.AK();
          AppMethodBeat.o(255926);
          return 0;
        case 3: 
          localaja.sql = locala.abFh.readString();
          AppMethodBeat.o(255926);
          return 0;
        case 4: 
          localaja.dbPath = locala.abFh.readString();
          AppMethodBeat.o(255926);
          return 0;
        case 5: 
          localaja.wel = locala.abFh.readString();
          AppMethodBeat.o(255926);
          return 0;
        case 6: 
          localaja.weo = locala.abFh.readString();
          AppMethodBeat.o(255926);
          return 0;
        case 7: 
          localaja.wej = locala.abFh.AK();
          AppMethodBeat.o(255926);
          return 0;
        }
        localaja.wen = locala.abFh.readString();
        AppMethodBeat.o(255926);
        return 0;
      }
      AppMethodBeat.o(255926);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aja
 * JD-Core Version:    0.7.0.1
 */