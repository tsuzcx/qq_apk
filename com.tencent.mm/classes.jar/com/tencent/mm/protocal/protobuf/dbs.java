package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbs
  extends com.tencent.mm.bw.a
{
  public boolean Dcx;
  public String kDl;
  public String nickname;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153296);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.bC(2, this.Dcx);
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.kDl != null) {
        paramVarArgs.d(4, this.kDl);
      }
      AppMethodBeat.o(153296);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label374;
      }
    }
    label374:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.amF(2);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nickname);
      }
      i = paramInt;
      if (this.kDl != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.kDl);
      }
      AppMethodBeat.o(153296);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153296);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dbs localdbs = (dbs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153296);
          return -1;
        case 1: 
          localdbs.username = locala.OmT.readString();
          AppMethodBeat.o(153296);
          return 0;
        case 2: 
          localdbs.Dcx = locala.OmT.gvY();
          AppMethodBeat.o(153296);
          return 0;
        case 3: 
          localdbs.nickname = locala.OmT.readString();
          AppMethodBeat.o(153296);
          return 0;
        }
        localdbs.kDl = locala.OmT.readString();
        AppMethodBeat.o(153296);
        return 0;
      }
      AppMethodBeat.o(153296);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbs
 * JD-Core Version:    0.7.0.1
 */