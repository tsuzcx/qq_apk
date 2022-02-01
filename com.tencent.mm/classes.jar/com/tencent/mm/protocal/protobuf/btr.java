package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btr
  extends com.tencent.mm.bw.a
{
  public String GjV;
  public boolean HgN;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91530);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.GjV != null) {
        paramVarArgs.d(3, this.GjV);
      }
      paramVarArgs.bC(4, this.HgN);
      AppMethodBeat.o(91530);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.GjV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GjV);
      }
      paramInt = f.a.a.b.b.a.amF(4);
      AppMethodBeat.o(91530);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91530);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      btr localbtr = (btr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91530);
        return -1;
      case 1: 
        localbtr.type = locala.OmT.zc();
        AppMethodBeat.o(91530);
        return 0;
      case 2: 
        localbtr.url = locala.OmT.readString();
        AppMethodBeat.o(91530);
        return 0;
      case 3: 
        localbtr.GjV = locala.OmT.readString();
        AppMethodBeat.o(91530);
        return 0;
      }
      localbtr.HgN = locala.OmT.gvY();
      AppMethodBeat.o(91530);
      return 0;
    }
    AppMethodBeat.o(91530);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btr
 * JD-Core Version:    0.7.0.1
 */