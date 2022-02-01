package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ty
  extends com.tencent.mm.cd.a
{
  public String text;
  public int tpK;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113947);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.tpK);
      if (this.text != null) {
        paramVarArgs.f(2, this.text);
      }
      if (this.url != null) {
        paramVarArgs.f(3, this.url);
      }
      AppMethodBeat.o(113947);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.tpK) + 0;
      paramInt = i;
      if (this.text != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.text);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.url);
      }
      AppMethodBeat.o(113947);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(113947);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ty localty = (ty)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113947);
        return -1;
      case 1: 
        localty.tpK = locala.abFh.AK();
        AppMethodBeat.o(113947);
        return 0;
      case 2: 
        localty.text = locala.abFh.readString();
        AppMethodBeat.o(113947);
        return 0;
      }
      localty.url = locala.abFh.readString();
      AppMethodBeat.o(113947);
      return 0;
    }
    AppMethodBeat.o(113947);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ty
 * JD-Core Version:    0.7.0.1
 */