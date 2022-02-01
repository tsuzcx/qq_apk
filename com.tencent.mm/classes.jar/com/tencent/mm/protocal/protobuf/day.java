package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class day
  extends com.tencent.mm.bx.a
{
  public boolean CKR;
  public String kzW;
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
      paramVarArgs.bt(2, this.CKR);
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.kzW != null) {
        paramVarArgs.d(4, this.kzW);
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
      int i = paramInt + f.a.a.b.b.a.alV(2);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nickname);
      }
      i = paramInt;
      if (this.kzW != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.kzW);
      }
      AppMethodBeat.o(153296);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153296);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        day localday = (day)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153296);
          return -1;
        case 1: 
          localday.username = locala.NPN.readString();
          AppMethodBeat.o(153296);
          return 0;
        case 2: 
          localday.CKR = locala.NPN.grw();
          AppMethodBeat.o(153296);
          return 0;
        case 3: 
          localday.nickname = locala.NPN.readString();
          AppMethodBeat.o(153296);
          return 0;
        }
        localday.kzW = locala.NPN.readString();
        AppMethodBeat.o(153296);
        return 0;
      }
      AppMethodBeat.o(153296);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.day
 * JD-Core Version:    0.7.0.1
 */