package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwa
  extends com.tencent.mm.cd.a
{
  public long TEU;
  public String content;
  public int createTime;
  public int extFlag;
  public long id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209940);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.id);
      if (this.content != null) {
        paramVarArgs.f(2, this.content);
      }
      paramVarArgs.bm(3, this.TEU);
      paramVarArgs.aY(4, this.createTime);
      paramVarArgs.aY(5, this.extFlag);
      AppMethodBeat.o(209940);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.id) + 0;
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.content);
      }
      i = g.a.a.b.b.a.p(3, this.TEU);
      int j = g.a.a.b.b.a.bM(4, this.createTime);
      int k = g.a.a.b.b.a.bM(5, this.extFlag);
      AppMethodBeat.o(209940);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(209940);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cwa localcwa = (cwa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209940);
        return -1;
      case 1: 
        localcwa.id = locala.abFh.AN();
        AppMethodBeat.o(209940);
        return 0;
      case 2: 
        localcwa.content = locala.abFh.readString();
        AppMethodBeat.o(209940);
        return 0;
      case 3: 
        localcwa.TEU = locala.abFh.AN();
        AppMethodBeat.o(209940);
        return 0;
      case 4: 
        localcwa.createTime = locala.abFh.AK();
        AppMethodBeat.o(209940);
        return 0;
      }
      localcwa.extFlag = locala.abFh.AK();
      AppMethodBeat.o(209940);
      return 0;
    }
    AppMethodBeat.o(209940);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwa
 * JD-Core Version:    0.7.0.1
 */