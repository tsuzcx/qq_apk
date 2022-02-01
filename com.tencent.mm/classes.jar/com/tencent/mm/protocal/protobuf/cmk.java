package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmk
  extends com.tencent.mm.bw.a
{
  public String path;
  public String query;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153293);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.path != null) {
        paramVarArgs.d(1, this.path);
      }
      if (this.query != null) {
        paramVarArgs.d(2, this.query);
      }
      paramVarArgs.aS(3, this.scene);
      AppMethodBeat.o(153293);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.query != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.query);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.scene);
      AppMethodBeat.o(153293);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153293);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cmk localcmk = (cmk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153293);
          return -1;
        case 1: 
          localcmk.path = locala.OmT.readString();
          AppMethodBeat.o(153293);
          return 0;
        case 2: 
          localcmk.query = locala.OmT.readString();
          AppMethodBeat.o(153293);
          return 0;
        }
        localcmk.scene = locala.OmT.zc();
        AppMethodBeat.o(153293);
        return 0;
      }
      AppMethodBeat.o(153293);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmk
 * JD-Core Version:    0.7.0.1
 */