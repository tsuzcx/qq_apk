package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efo
  extends com.tencent.mm.bw.a
{
  public String HGP;
  public com.tencent.mm.bw.b IiK;
  public String nJO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32566);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HGP == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32566);
        throw paramVarArgs;
      }
      if (this.nJO == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32566);
        throw paramVarArgs;
      }
      if (this.HGP != null) {
        paramVarArgs.d(1, this.HGP);
      }
      if (this.nJO != null) {
        paramVarArgs.d(2, this.nJO);
      }
      if (this.IiK != null) {
        paramVarArgs.c(3, this.IiK);
      }
      AppMethodBeat.o(32566);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HGP == null) {
        break label443;
      }
    }
    label443:
    for (int i = f.a.a.b.b.a.e(1, this.HGP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nJO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nJO);
      }
      i = paramInt;
      if (this.IiK != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.IiK);
      }
      AppMethodBeat.o(32566);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HGP == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32566);
          throw paramVarArgs;
        }
        if (this.nJO == null)
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
        efo localefo = (efo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32566);
          return -1;
        case 1: 
          localefo.HGP = locala.OmT.readString();
          AppMethodBeat.o(32566);
          return 0;
        case 2: 
          localefo.nJO = locala.OmT.readString();
          AppMethodBeat.o(32566);
          return 0;
        }
        localefo.IiK = locala.OmT.gCk();
        AppMethodBeat.o(32566);
        return 0;
      }
      AppMethodBeat.o(32566);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efo
 * JD-Core Version:    0.7.0.1
 */