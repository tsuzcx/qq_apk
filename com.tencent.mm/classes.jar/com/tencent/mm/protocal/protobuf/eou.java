package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class eou
  extends com.tencent.mm.bw.a
{
  public String KHk;
  public String LoI;
  public String NmU;
  public String UserName;
  public String ked;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117939);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(117939);
        throw paramVarArgs;
      }
      if (this.NmU == null)
      {
        paramVarArgs = new b("Not all required fields were included: MatchWord");
        AppMethodBeat.o(117939);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.NmU != null) {
        paramVarArgs.e(2, this.NmU);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(3, this.oUJ);
      }
      if (this.LoI != null) {
        paramVarArgs.e(4, this.LoI);
      }
      if (this.ked != null) {
        paramVarArgs.e(5, this.ked);
      }
      if (this.KHk != null) {
        paramVarArgs.e(6, this.KHk);
      }
      AppMethodBeat.o(117939);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label614;
      }
    }
    label614:
    for (int i = g.a.a.b.b.a.f(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NmU != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.NmU);
      }
      i = paramInt;
      if (this.oUJ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.oUJ);
      }
      paramInt = i;
      if (this.LoI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LoI);
      }
      i = paramInt;
      if (this.ked != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.ked);
      }
      paramInt = i;
      if (this.KHk != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KHk);
      }
      AppMethodBeat.o(117939);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.UserName == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(117939);
          throw paramVarArgs;
        }
        if (this.NmU == null)
        {
          paramVarArgs = new b("Not all required fields were included: MatchWord");
          AppMethodBeat.o(117939);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117939);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eou localeou = (eou)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117939);
          return -1;
        case 1: 
          localeou.UserName = locala.UbS.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 2: 
          localeou.NmU = locala.UbS.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 3: 
          localeou.oUJ = locala.UbS.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 4: 
          localeou.LoI = locala.UbS.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 5: 
          localeou.ked = locala.UbS.readString();
          AppMethodBeat.o(117939);
          return 0;
        }
        localeou.KHk = locala.UbS.readString();
        AppMethodBeat.o(117939);
        return 0;
      }
      AppMethodBeat.o(117939);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eou
 * JD-Core Version:    0.7.0.1
 */