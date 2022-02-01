package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class egx
  extends com.tencent.mm.bw.a
{
  public int Gdl;
  public int IkJ;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123680);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.IkJ);
      paramVarArgs.aS(2, this.Gdl);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(4, this.md5);
      }
      AppMethodBeat.o(123680);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.IkJ) + 0 + f.a.a.b.b.a.bz(2, this.Gdl);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.md5);
      }
      AppMethodBeat.o(123680);
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
      AppMethodBeat.o(123680);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      egx localegx = (egx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123680);
        return -1;
      case 1: 
        localegx.IkJ = locala.OmT.zc();
        AppMethodBeat.o(123680);
        return 0;
      case 2: 
        localegx.Gdl = locala.OmT.zc();
        AppMethodBeat.o(123680);
        return 0;
      case 3: 
        localegx.url = locala.OmT.readString();
        AppMethodBeat.o(123680);
        return 0;
      }
      localegx.md5 = locala.OmT.readString();
      AppMethodBeat.o(123680);
      return 0;
    }
    AppMethodBeat.o(123680);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egx
 * JD-Core Version:    0.7.0.1
 */