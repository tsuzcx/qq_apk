package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arr
  extends com.tencent.mm.bw.a
{
  public String query;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169046);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.timestamp);
      if (this.query != null) {
        paramVarArgs.d(2, this.query);
      }
      AppMethodBeat.o(169046);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.timestamp) + 0;
      paramInt = i;
      if (this.query != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.query);
      }
      AppMethodBeat.o(169046);
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
      AppMethodBeat.o(169046);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      arr localarr = (arr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169046);
        return -1;
      case 1: 
        localarr.timestamp = locala.OmT.zd();
        AppMethodBeat.o(169046);
        return 0;
      }
      localarr.query = locala.OmT.readString();
      AppMethodBeat.o(169046);
      return 0;
    }
    AppMethodBeat.o(169046);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arr
 * JD-Core Version:    0.7.0.1
 */