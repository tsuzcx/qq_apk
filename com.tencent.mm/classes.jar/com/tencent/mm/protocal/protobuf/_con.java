package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class con
  extends com.tencent.mm.bw.a
{
  public String GLc;
  public int GLu;
  public int Gxt;
  public int HAt;
  public String MD5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155451);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GLu);
      if (this.GLc != null) {
        paramVarArgs.d(2, this.GLc);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      paramVarArgs.aS(4, this.Gxt);
      paramVarArgs.aS(5, this.HAt);
      AppMethodBeat.o(155451);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GLu) + 0;
      paramInt = i;
      if (this.GLc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GLc);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.MD5);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.Gxt);
      int j = f.a.a.b.b.a.bz(5, this.HAt);
      AppMethodBeat.o(155451);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(155451);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      con localcon = (con)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155451);
        return -1;
      case 1: 
        localcon.GLu = locala.OmT.zc();
        AppMethodBeat.o(155451);
        return 0;
      case 2: 
        localcon.GLc = locala.OmT.readString();
        AppMethodBeat.o(155451);
        return 0;
      case 3: 
        localcon.MD5 = locala.OmT.readString();
        AppMethodBeat.o(155451);
        return 0;
      case 4: 
        localcon.Gxt = locala.OmT.zc();
        AppMethodBeat.o(155451);
        return 0;
      }
      localcon.HAt = locala.OmT.zc();
      AppMethodBeat.o(155451);
      return 0;
    }
    AppMethodBeat.o(155451);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.con
 * JD-Core Version:    0.7.0.1
 */