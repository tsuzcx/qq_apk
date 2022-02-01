package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dqw
  extends com.tencent.mm.bx.a
{
  public String Title;
  public String gKr;
  public int sdO;
  
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
      if (this.gKr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32523);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.sdO);
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.gKr != null) {
        paramVarArgs.d(3, this.gKr);
      }
      AppMethodBeat.o(32523);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.sdO) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.gKr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gKr);
      }
      AppMethodBeat.o(32523);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(32523);
        throw paramVarArgs;
      }
      if (this.gKr == null)
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
      dqw localdqw = (dqw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32523);
        return -1;
      case 1: 
        localdqw.sdO = locala.KhF.xS();
        AppMethodBeat.o(32523);
        return 0;
      case 2: 
        localdqw.Title = locala.KhF.readString();
        AppMethodBeat.o(32523);
        return 0;
      }
      localdqw.gKr = locala.KhF.readString();
      AppMethodBeat.o(32523);
      return 0;
    }
    AppMethodBeat.o(32523);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqw
 * JD-Core Version:    0.7.0.1
 */