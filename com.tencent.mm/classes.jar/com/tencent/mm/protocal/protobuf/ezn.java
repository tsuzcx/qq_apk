package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ezn
  extends com.tencent.mm.bw.a
{
  public String KTg;
  public String KZu;
  public String MD5;
  public String MRZ;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32557);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MRZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32557);
        throw paramVarArgs;
      }
      if (this.KTg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(32557);
        throw paramVarArgs;
      }
      if (this.MD5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: MD5");
        AppMethodBeat.o(32557);
        throw paramVarArgs;
      }
      if (this.KZu == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(32557);
        throw paramVarArgs;
      }
      if (this.MRZ != null) {
        paramVarArgs.e(1, this.MRZ);
      }
      if (this.KTg != null) {
        paramVarArgs.e(2, this.KTg);
      }
      if (this.MD5 != null) {
        paramVarArgs.e(3, this.MD5);
      }
      if (this.KZu != null) {
        paramVarArgs.e(4, this.KZu);
      }
      paramVarArgs.aM(5, this.Scene);
      AppMethodBeat.o(32557);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MRZ == null) {
        break label649;
      }
    }
    label649:
    for (int i = g.a.a.b.b.a.f(1, this.MRZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KTg != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KTg);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MD5);
      }
      paramInt = i;
      if (this.KZu != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KZu);
      }
      i = g.a.a.b.b.a.bu(5, this.Scene);
      AppMethodBeat.o(32557);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MRZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32557);
          throw paramVarArgs;
        }
        if (this.KTg == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(32557);
          throw paramVarArgs;
        }
        if (this.MD5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: MD5");
          AppMethodBeat.o(32557);
          throw paramVarArgs;
        }
        if (this.KZu == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(32557);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32557);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezn localezn = (ezn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32557);
          return -1;
        case 1: 
          localezn.MRZ = locala.UbS.readString();
          AppMethodBeat.o(32557);
          return 0;
        case 2: 
          localezn.KTg = locala.UbS.readString();
          AppMethodBeat.o(32557);
          return 0;
        case 3: 
          localezn.MD5 = locala.UbS.readString();
          AppMethodBeat.o(32557);
          return 0;
        case 4: 
          localezn.KZu = locala.UbS.readString();
          AppMethodBeat.o(32557);
          return 0;
        }
        localezn.Scene = locala.UbS.zi();
        AppMethodBeat.o(32557);
        return 0;
      }
      AppMethodBeat.o(32557);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezn
 * JD-Core Version:    0.7.0.1
 */