package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
  extends com.tencent.mm.bv.a
{
  public long wkf;
  public String wks;
  public long wkt;
  public int wku;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56688);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wks != null) {
        paramVarArgs.e(1, this.wks);
      }
      paramVarArgs.am(2, this.wkf);
      paramVarArgs.am(3, this.wkt);
      paramVarArgs.aO(4, this.wku);
      AppMethodBeat.o(56688);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wks == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = e.a.a.b.b.a.f(1, this.wks) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.p(2, this.wkf);
      int j = e.a.a.b.b.a.p(3, this.wkt);
      int k = e.a.a.b.b.a.bl(4, this.wku);
      AppMethodBeat.o(56688);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56688);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        t localt = (t)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56688);
          return -1;
        case 1: 
          localt.wks = locala.CLY.readString();
          AppMethodBeat.o(56688);
          return 0;
        case 2: 
          localt.wkf = locala.CLY.sm();
          AppMethodBeat.o(56688);
          return 0;
        case 3: 
          localt.wkt = locala.CLY.sm();
          AppMethodBeat.o(56688);
          return 0;
        }
        localt.wku = locala.CLY.sl();
        AppMethodBeat.o(56688);
        return 0;
      }
      AppMethodBeat.o(56688);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.t
 * JD-Core Version:    0.7.0.1
 */