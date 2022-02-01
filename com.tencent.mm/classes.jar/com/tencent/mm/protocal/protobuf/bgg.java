package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class bgg
  extends com.tencent.mm.bw.a
{
  public String KHk;
  public int KWb;
  public String LPS;
  public String LPZ;
  public String hik;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42637);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.hik == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(42637);
        throw paramVarArgs;
      }
      if (this.LPZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: RecommendKey");
        AppMethodBeat.o(42637);
        throw paramVarArgs;
      }
      if (this.hik != null) {
        paramVarArgs.e(1, this.hik);
      }
      if (this.LPZ != null) {
        paramVarArgs.e(2, this.LPZ);
      }
      if (this.KHk != null) {
        paramVarArgs.e(3, this.KHk);
      }
      paramVarArgs.aM(4, this.KWb);
      if (this.LPS != null) {
        paramVarArgs.e(5, this.LPS);
      }
      AppMethodBeat.o(42637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hik == null) {
        break label534;
      }
    }
    label534:
    for (int i = g.a.a.b.b.a.f(1, this.hik) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LPZ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LPZ);
      }
      i = paramInt;
      if (this.KHk != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KHk);
      }
      i += g.a.a.b.b.a.bu(4, this.KWb);
      paramInt = i;
      if (this.LPS != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LPS);
      }
      AppMethodBeat.o(42637);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.hik == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(42637);
          throw paramVarArgs;
        }
        if (this.LPZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: RecommendKey");
          AppMethodBeat.o(42637);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42637);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bgg localbgg = (bgg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42637);
          return -1;
        case 1: 
          localbgg.hik = locala.UbS.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 2: 
          localbgg.LPZ = locala.UbS.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 3: 
          localbgg.KHk = locala.UbS.readString();
          AppMethodBeat.o(42637);
          return 0;
        case 4: 
          localbgg.KWb = locala.UbS.zi();
          AppMethodBeat.o(42637);
          return 0;
        }
        localbgg.LPS = locala.UbS.readString();
        AppMethodBeat.o(42637);
        return 0;
      }
      AppMethodBeat.o(42637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgg
 * JD-Core Version:    0.7.0.1
 */