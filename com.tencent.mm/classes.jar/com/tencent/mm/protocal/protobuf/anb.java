package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class anb
  extends com.tencent.mm.bv.a
{
  public String crs;
  public String gfK;
  public String gfL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80083);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.gfL == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(80083);
        throw paramVarArgs;
      }
      if (this.gfL != null) {
        paramVarArgs.e(1, this.gfL);
      }
      if (this.gfK != null) {
        paramVarArgs.e(2, this.gfK);
      }
      if (this.crs != null) {
        paramVarArgs.e(3, this.crs);
      }
      AppMethodBeat.o(80083);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gfL == null) {
        break label382;
      }
    }
    label382:
    for (int i = e.a.a.b.b.a.f(1, this.gfL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gfK != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.gfK);
      }
      i = paramInt;
      if (this.crs != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.crs);
      }
      AppMethodBeat.o(80083);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.gfL == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(80083);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80083);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        anb localanb = (anb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80083);
          return -1;
        case 1: 
          localanb.gfL = locala.CLY.readString();
          AppMethodBeat.o(80083);
          return 0;
        case 2: 
          localanb.gfK = locala.CLY.readString();
          AppMethodBeat.o(80083);
          return 0;
        }
        localanb.crs = locala.CLY.readString();
        AppMethodBeat.o(80083);
        return 0;
      }
      AppMethodBeat.o(80083);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anb
 * JD-Core Version:    0.7.0.1
 */