package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bcl
  extends com.tencent.mm.bw.a
{
  public String mdj;
  public String path;
  public String pqW;
  public String title;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123579);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pqW != null) {
        paramVarArgs.d(1, this.pqW);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.aS(3, this.type);
      if (this.mdj != null) {
        paramVarArgs.d(4, this.mdj);
      }
      if (this.username != null) {
        paramVarArgs.d(5, this.username);
      }
      if (this.path != null) {
        paramVarArgs.d(6, this.path);
      }
      AppMethodBeat.o(123579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pqW == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.pqW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.title);
      }
      i += f.a.a.b.b.a.bz(3, this.type);
      paramInt = i;
      if (this.mdj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mdj);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.username);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.path);
      }
      AppMethodBeat.o(123579);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123579);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bcl localbcl = (bcl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123579);
          return -1;
        case 1: 
          localbcl.pqW = locala.OmT.readString();
          AppMethodBeat.o(123579);
          return 0;
        case 2: 
          localbcl.title = locala.OmT.readString();
          AppMethodBeat.o(123579);
          return 0;
        case 3: 
          localbcl.type = locala.OmT.zc();
          AppMethodBeat.o(123579);
          return 0;
        case 4: 
          localbcl.mdj = locala.OmT.readString();
          AppMethodBeat.o(123579);
          return 0;
        case 5: 
          localbcl.username = locala.OmT.readString();
          AppMethodBeat.o(123579);
          return 0;
        }
        localbcl.path = locala.OmT.readString();
        AppMethodBeat.o(123579);
        return 0;
      }
      AppMethodBeat.o(123579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcl
 * JD-Core Version:    0.7.0.1
 */