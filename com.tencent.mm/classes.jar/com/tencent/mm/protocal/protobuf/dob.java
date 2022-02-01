package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dob
  extends com.tencent.mm.bw.a
{
  public int dmr;
  public String path;
  public String pqW;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127285);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dmr);
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.pqW != null) {
        paramVarArgs.d(3, this.pqW);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      AppMethodBeat.o(127285);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.dmr) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.pqW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pqW);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.path);
      }
      AppMethodBeat.o(127285);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(127285);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dob localdob = (dob)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127285);
        return -1;
      case 1: 
        localdob.dmr = locala.OmT.zc();
        AppMethodBeat.o(127285);
        return 0;
      case 2: 
        localdob.title = locala.OmT.readString();
        AppMethodBeat.o(127285);
        return 0;
      case 3: 
        localdob.pqW = locala.OmT.readString();
        AppMethodBeat.o(127285);
        return 0;
      }
      localdob.path = locala.OmT.readString();
      AppMethodBeat.o(127285);
      return 0;
    }
    AppMethodBeat.o(127285);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dob
 * JD-Core Version:    0.7.0.1
 */