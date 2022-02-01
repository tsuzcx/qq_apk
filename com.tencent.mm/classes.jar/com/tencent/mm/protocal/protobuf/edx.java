package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edx
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b HOD;
  public String Hnp;
  public String nEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32566);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hnp == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32566);
        throw paramVarArgs;
      }
      if (this.nEt == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32566);
        throw paramVarArgs;
      }
      if (this.Hnp != null) {
        paramVarArgs.d(1, this.Hnp);
      }
      if (this.nEt != null) {
        paramVarArgs.d(2, this.nEt);
      }
      if (this.HOD != null) {
        paramVarArgs.c(3, this.HOD);
      }
      AppMethodBeat.o(32566);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hnp == null) {
        break label443;
      }
    }
    label443:
    for (int i = f.a.a.b.b.a.e(1, this.Hnp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nEt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nEt);
      }
      i = paramInt;
      if (this.HOD != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.HOD);
      }
      AppMethodBeat.o(32566);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Hnp == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32566);
          throw paramVarArgs;
        }
        if (this.nEt == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
          AppMethodBeat.o(32566);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32566);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        edx localedx = (edx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32566);
          return -1;
        case 1: 
          localedx.Hnp = locala.NPN.readString();
          AppMethodBeat.o(32566);
          return 0;
        case 2: 
          localedx.nEt = locala.NPN.readString();
          AppMethodBeat.o(32566);
          return 0;
        }
        localedx.HOD = locala.NPN.gxI();
        AppMethodBeat.o(32566);
        return 0;
      }
      AppMethodBeat.o(32566);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edx
 * JD-Core Version:    0.7.0.1
 */