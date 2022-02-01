package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmn
  extends com.tencent.mm.bw.a
{
  public String Hyv;
  public String Hyw;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153294);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.Hyv != null) {
        paramVarArgs.d(2, this.Hyv);
      }
      if (this.Hyw != null) {
        paramVarArgs.d(3, this.Hyw);
      }
      AppMethodBeat.o(153294);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.Hyv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hyv);
      }
      i = paramInt;
      if (this.Hyw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hyw);
      }
      AppMethodBeat.o(153294);
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
      AppMethodBeat.o(153294);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cmn localcmn = (cmn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153294);
        return -1;
      case 1: 
        localcmn.type = locala.OmT.zc();
        AppMethodBeat.o(153294);
        return 0;
      case 2: 
        localcmn.Hyv = locala.OmT.readString();
        AppMethodBeat.o(153294);
        return 0;
      }
      localcmn.Hyw = locala.OmT.readString();
      AppMethodBeat.o(153294);
      return 0;
    }
    AppMethodBeat.o(153294);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmn
 * JD-Core Version:    0.7.0.1
 */