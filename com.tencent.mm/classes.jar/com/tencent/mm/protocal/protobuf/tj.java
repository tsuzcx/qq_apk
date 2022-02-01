package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tj
  extends com.tencent.mm.bw.a
{
  public int FZN;
  public String GfZ;
  public String text;
  public int type;
  public String url;
  public int zcL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113966);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.text != null) {
        paramVarArgs.d(2, this.text);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      paramVarArgs.aS(4, this.zcL);
      paramVarArgs.aS(5, this.FZN);
      if (this.GfZ != null) {
        paramVarArgs.d(6, this.GfZ);
      }
      AppMethodBeat.o(113966);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.text != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.text);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      i = i + f.a.a.b.b.a.bz(4, this.zcL) + f.a.a.b.b.a.bz(5, this.FZN);
      paramInt = i;
      if (this.GfZ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GfZ);
      }
      AppMethodBeat.o(113966);
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
      AppMethodBeat.o(113966);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      tj localtj = (tj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113966);
        return -1;
      case 1: 
        localtj.type = locala.OmT.zc();
        AppMethodBeat.o(113966);
        return 0;
      case 2: 
        localtj.text = locala.OmT.readString();
        AppMethodBeat.o(113966);
        return 0;
      case 3: 
        localtj.url = locala.OmT.readString();
        AppMethodBeat.o(113966);
        return 0;
      case 4: 
        localtj.zcL = locala.OmT.zc();
        AppMethodBeat.o(113966);
        return 0;
      case 5: 
        localtj.FZN = locala.OmT.zc();
        AppMethodBeat.o(113966);
        return 0;
      }
      localtj.GfZ = locala.OmT.readString();
      AppMethodBeat.o(113966);
      return 0;
    }
    AppMethodBeat.o(113966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tj
 * JD-Core Version:    0.7.0.1
 */