package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtv
  extends com.tencent.mm.bx.a
{
  public int EIw;
  public String EIx;
  public String EIy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124575);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EIw);
      if (this.EIx != null) {
        paramVarArgs.d(2, this.EIx);
      }
      if (this.EIy != null) {
        paramVarArgs.d(3, this.EIy);
      }
      AppMethodBeat.o(124575);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.EIw) + 0;
      paramInt = i;
      if (this.EIx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EIx);
      }
      i = paramInt;
      if (this.EIy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EIy);
      }
      AppMethodBeat.o(124575);
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
      AppMethodBeat.o(124575);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dtv localdtv = (dtv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124575);
        return -1;
      case 1: 
        localdtv.EIw = locala.KhF.xS();
        AppMethodBeat.o(124575);
        return 0;
      case 2: 
        localdtv.EIx = locala.KhF.readString();
        AppMethodBeat.o(124575);
        return 0;
      }
      localdtv.EIy = locala.KhF.readString();
      AppMethodBeat.o(124575);
      return 0;
    }
    AppMethodBeat.o(124575);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtv
 * JD-Core Version:    0.7.0.1
 */