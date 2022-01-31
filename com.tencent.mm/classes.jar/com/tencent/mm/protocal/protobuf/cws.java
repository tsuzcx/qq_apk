package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cws
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String ntu;
  public int nuk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28724);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(28724);
        throw paramVarArgs;
      }
      if (this.ntu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(28724);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.nuk);
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.ntu != null) {
        paramVarArgs.e(3, this.ntu);
      }
      AppMethodBeat.o(28724);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.nuk) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.ntu != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ntu);
      }
      AppMethodBeat.o(28724);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(28724);
        throw paramVarArgs;
      }
      if (this.ntu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(28724);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28724);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cws localcws = (cws)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28724);
        return -1;
      case 1: 
        localcws.nuk = locala.CLY.sl();
        AppMethodBeat.o(28724);
        return 0;
      case 2: 
        localcws.Title = locala.CLY.readString();
        AppMethodBeat.o(28724);
        return 0;
      }
      localcws.ntu = locala.CLY.readString();
      AppMethodBeat.o(28724);
      return 0;
    }
    AppMethodBeat.o(28724);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cws
 * JD-Core Version:    0.7.0.1
 */