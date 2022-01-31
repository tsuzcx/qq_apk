package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cdb
  extends com.tencent.mm.bv.a
{
  public String ProductID;
  public int wux;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62583);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ProductID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductID");
        AppMethodBeat.o(62583);
        throw paramVarArgs;
      }
      if (this.ProductID != null) {
        paramVarArgs.e(1, this.ProductID);
      }
      paramVarArgs.aO(2, this.wux);
      AppMethodBeat.o(62583);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = e.a.a.b.b.a.f(1, this.ProductID) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.wux);
      AppMethodBeat.o(62583);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.ProductID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductID");
          AppMethodBeat.o(62583);
          throw paramVarArgs;
        }
        AppMethodBeat.o(62583);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cdb localcdb = (cdb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(62583);
          return -1;
        case 1: 
          localcdb.ProductID = locala.CLY.readString();
          AppMethodBeat.o(62583);
          return 0;
        }
        localcdb.wux = locala.CLY.sl();
        AppMethodBeat.o(62583);
        return 0;
      }
      AppMethodBeat.o(62583);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdb
 * JD-Core Version:    0.7.0.1
 */