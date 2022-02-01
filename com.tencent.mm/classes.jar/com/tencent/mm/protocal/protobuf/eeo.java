package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class eeo
  extends com.tencent.mm.bw.a
{
  public String HGP;
  public long IiS;
  public String nJO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32536);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HGP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32536);
        throw paramVarArgs;
      }
      if (this.nJO == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(32536);
        throw paramVarArgs;
      }
      if (this.HGP != null) {
        paramVarArgs.d(1, this.HGP);
      }
      if (this.nJO != null) {
        paramVarArgs.d(2, this.nJO);
      }
      paramVarArgs.aZ(3, this.IiS);
      AppMethodBeat.o(32536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HGP == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = f.a.a.b.b.a.e(1, this.HGP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nJO != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nJO);
      }
      paramInt = f.a.a.b.b.a.p(3, this.IiS);
      AppMethodBeat.o(32536);
      return i + paramInt;
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
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32536);
          throw paramVarArgs;
        }
        if (this.nJO == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(32536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32536);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eeo localeeo = (eeo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32536);
          return -1;
        case 1: 
          localeeo.HGP = locala.OmT.readString();
          AppMethodBeat.o(32536);
          return 0;
        case 2: 
          localeeo.nJO = locala.OmT.readString();
          AppMethodBeat.o(32536);
          return 0;
        }
        localeeo.IiS = locala.OmT.zd();
        AppMethodBeat.o(32536);
        return 0;
      }
      AppMethodBeat.o(32536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eeo
 * JD-Core Version:    0.7.0.1
 */