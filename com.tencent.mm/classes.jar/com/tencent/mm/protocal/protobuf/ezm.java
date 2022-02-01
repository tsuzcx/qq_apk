package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ezm
  extends com.tencent.mm.bw.a
{
  public String KZu;
  public String MD5;
  public String MRZ;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32556);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MRZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.MD5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: MD5");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.KZu == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.MRZ != null) {
        paramVarArgs.e(1, this.MRZ);
      }
      if (this.MD5 != null) {
        paramVarArgs.e(2, this.MD5);
      }
      if (this.KZu != null) {
        paramVarArgs.e(3, this.KZu);
      }
      paramVarArgs.aM(4, this.Scene);
      AppMethodBeat.o(32556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MRZ == null) {
        break label540;
      }
    }
    label540:
    for (int i = g.a.a.b.b.a.f(1, this.MRZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MD5);
      }
      i = paramInt;
      if (this.KZu != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KZu);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.Scene);
      AppMethodBeat.o(32556);
      return i + paramInt;
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
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        if (this.MD5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: MD5");
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        if (this.KZu == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32556);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezm localezm = (ezm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32556);
          return -1;
        case 1: 
          localezm.MRZ = locala.UbS.readString();
          AppMethodBeat.o(32556);
          return 0;
        case 2: 
          localezm.MD5 = locala.UbS.readString();
          AppMethodBeat.o(32556);
          return 0;
        case 3: 
          localezm.KZu = locala.UbS.readString();
          AppMethodBeat.o(32556);
          return 0;
        }
        localezm.Scene = locala.UbS.zi();
        AppMethodBeat.o(32556);
        return 0;
      }
      AppMethodBeat.o(32556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezm
 * JD-Core Version:    0.7.0.1
 */