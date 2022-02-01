package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ecn
  extends com.tencent.mm.bx.a
{
  public String Title;
  public String hDa;
  public int ukh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32523);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(32523);
        throw paramVarArgs;
      }
      if (this.hDa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32523);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.ukh);
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.hDa != null) {
        paramVarArgs.d(3, this.hDa);
      }
      AppMethodBeat.o(32523);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.ukh) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.hDa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hDa);
      }
      AppMethodBeat.o(32523);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(32523);
        throw paramVarArgs;
      }
      if (this.hDa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32523);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32523);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ecn localecn = (ecn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32523);
        return -1;
      case 1: 
        localecn.ukh = locala.NPN.zc();
        AppMethodBeat.o(32523);
        return 0;
      case 2: 
        localecn.Title = locala.NPN.readString();
        AppMethodBeat.o(32523);
        return 0;
      }
      localecn.hDa = locala.NPN.readString();
      AppMethodBeat.o(32523);
      return 0;
    }
    AppMethodBeat.o(32523);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecn
 * JD-Core Version:    0.7.0.1
 */