package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class dcd
  extends com.tencent.mm.bv.a
{
  public String fhi;
  public String title;
  public int yih;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28775);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.fhi == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankid");
        AppMethodBeat.o(28775);
        throw paramVarArgs;
      }
      if (this.title == null)
      {
        paramVarArgs = new b("Not all required fields were included: title");
        AppMethodBeat.o(28775);
        throw paramVarArgs;
      }
      if (this.fhi != null) {
        paramVarArgs.e(1, this.fhi);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      paramVarArgs.aO(3, this.yih);
      AppMethodBeat.o(28775);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fhi == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = e.a.a.b.b.a.f(1, this.fhi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.title);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.yih);
      AppMethodBeat.o(28775);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.fhi == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankid");
          AppMethodBeat.o(28775);
          throw paramVarArgs;
        }
        if (this.title == null)
        {
          paramVarArgs = new b("Not all required fields were included: title");
          AppMethodBeat.o(28775);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28775);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dcd localdcd = (dcd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28775);
          return -1;
        case 1: 
          localdcd.fhi = locala.CLY.readString();
          AppMethodBeat.o(28775);
          return 0;
        case 2: 
          localdcd.title = locala.CLY.readString();
          AppMethodBeat.o(28775);
          return 0;
        }
        localdcd.yih = locala.CLY.sl();
        AppMethodBeat.o(28775);
        return 0;
      }
      AppMethodBeat.o(28775);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcd
 * JD-Core Version:    0.7.0.1
 */