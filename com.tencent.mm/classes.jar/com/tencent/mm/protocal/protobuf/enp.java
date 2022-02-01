package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class enp
  extends com.tencent.mm.cd.a
{
  public String Uqq;
  public String Uqr;
  public String Uqs;
  public String Uqt;
  public String Uqu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101531);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uqq == null)
      {
        paramVarArgs = new b("Not all required fields were included: videoFileMD5");
        AppMethodBeat.o(101531);
        throw paramVarArgs;
      }
      if (this.Uqq != null) {
        paramVarArgs.f(1, this.Uqq);
      }
      if (this.Uqr != null) {
        paramVarArgs.f(2, this.Uqr);
      }
      if (this.Uqs != null) {
        paramVarArgs.f(3, this.Uqs);
      }
      if (this.Uqt != null) {
        paramVarArgs.f(4, this.Uqt);
      }
      if (this.Uqu != null) {
        paramVarArgs.f(5, this.Uqu);
      }
      AppMethodBeat.o(101531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Uqq == null) {
        break label502;
      }
    }
    label502:
    for (int i = g.a.a.b.b.a.g(1, this.Uqq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Uqr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Uqr);
      }
      i = paramInt;
      if (this.Uqs != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Uqs);
      }
      paramInt = i;
      if (this.Uqt != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Uqt);
      }
      i = paramInt;
      if (this.Uqu != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Uqu);
      }
      AppMethodBeat.o(101531);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Uqq == null)
        {
          paramVarArgs = new b("Not all required fields were included: videoFileMD5");
          AppMethodBeat.o(101531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101531);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        enp localenp = (enp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101531);
          return -1;
        case 1: 
          localenp.Uqq = locala.abFh.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 2: 
          localenp.Uqr = locala.abFh.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 3: 
          localenp.Uqs = locala.abFh.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 4: 
          localenp.Uqt = locala.abFh.readString();
          AppMethodBeat.o(101531);
          return 0;
        }
        localenp.Uqu = locala.abFh.readString();
        AppMethodBeat.o(101531);
        return 0;
      }
      AppMethodBeat.o(101531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enp
 * JD-Core Version:    0.7.0.1
 */