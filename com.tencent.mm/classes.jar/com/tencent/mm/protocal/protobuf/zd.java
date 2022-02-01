package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zd
  extends com.tencent.mm.bw.a
{
  public String Gre;
  public String rfA;
  public String rfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195194);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rfA != null) {
        paramVarArgs.d(1, this.rfA);
      }
      if (this.rfo != null) {
        paramVarArgs.d(2, this.rfo);
      }
      if (this.Gre != null) {
        paramVarArgs.d(3, this.Gre);
      }
      AppMethodBeat.o(195194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rfA == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.rfA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rfo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.rfo);
      }
      i = paramInt;
      if (this.Gre != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gre);
      }
      AppMethodBeat.o(195194);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(195194);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        zd localzd = (zd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195194);
          return -1;
        case 1: 
          localzd.rfA = locala.OmT.readString();
          AppMethodBeat.o(195194);
          return 0;
        case 2: 
          localzd.rfo = locala.OmT.readString();
          AppMethodBeat.o(195194);
          return 0;
        }
        localzd.Gre = locala.OmT.readString();
        AppMethodBeat.o(195194);
        return 0;
      }
      AppMethodBeat.o(195194);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zd
 * JD-Core Version:    0.7.0.1
 */