package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dne
  extends com.tencent.mm.bx.a
{
  public int dlp;
  public String path;
  public String pkr;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127285);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dlp);
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.pkr != null) {
        paramVarArgs.d(3, this.pkr);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      AppMethodBeat.o(127285);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.dlp) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.pkr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pkr);
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
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(127285);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dne localdne = (dne)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127285);
        return -1;
      case 1: 
        localdne.dlp = locala.NPN.zc();
        AppMethodBeat.o(127285);
        return 0;
      case 2: 
        localdne.title = locala.NPN.readString();
        AppMethodBeat.o(127285);
        return 0;
      case 3: 
        localdne.pkr = locala.NPN.readString();
        AppMethodBeat.o(127285);
        return 0;
      }
      localdne.path = locala.NPN.readString();
      AppMethodBeat.o(127285);
      return 0;
    }
    AppMethodBeat.o(127285);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dne
 * JD-Core Version:    0.7.0.1
 */