package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bku
  extends com.tencent.mm.cd.a
{
  public int fEH;
  public String objectNonceId;
  public String sessionBuffer;
  public long xbk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203140);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.xbk);
      if (this.objectNonceId != null) {
        paramVarArgs.f(2, this.objectNonceId);
      }
      paramVarArgs.aY(3, this.fEH);
      if (this.sessionBuffer != null) {
        paramVarArgs.f(4, this.sessionBuffer);
      }
      AppMethodBeat.o(203140);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.xbk) + 0;
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.objectNonceId);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.fEH);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.sessionBuffer);
      }
      AppMethodBeat.o(203140);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(203140);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bku localbku = (bku)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203140);
        return -1;
      case 1: 
        localbku.xbk = locala.abFh.AN();
        AppMethodBeat.o(203140);
        return 0;
      case 2: 
        localbku.objectNonceId = locala.abFh.readString();
        AppMethodBeat.o(203140);
        return 0;
      case 3: 
        localbku.fEH = locala.abFh.AK();
        AppMethodBeat.o(203140);
        return 0;
      }
      localbku.sessionBuffer = locala.abFh.readString();
      AppMethodBeat.o(203140);
      return 0;
    }
    AppMethodBeat.o(203140);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bku
 * JD-Core Version:    0.7.0.1
 */