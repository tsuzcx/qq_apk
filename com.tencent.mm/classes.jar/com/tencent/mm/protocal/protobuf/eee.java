package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class eee
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String hFS;
  public int uvE;
  
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
      if (this.hFS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32523);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.uvE);
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.hFS != null) {
        paramVarArgs.d(3, this.hFS);
      }
      AppMethodBeat.o(32523);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.uvE) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.hFS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hFS);
      }
      AppMethodBeat.o(32523);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(32523);
        throw paramVarArgs;
      }
      if (this.hFS == null)
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
      eee localeee = (eee)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32523);
        return -1;
      case 1: 
        localeee.uvE = locala.OmT.zc();
        AppMethodBeat.o(32523);
        return 0;
      case 2: 
        localeee.Title = locala.OmT.readString();
        AppMethodBeat.o(32523);
        return 0;
      }
      localeee.hFS = locala.OmT.readString();
      AppMethodBeat.o(32523);
      return 0;
    }
    AppMethodBeat.o(32523);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eee
 * JD-Core Version:    0.7.0.1
 */