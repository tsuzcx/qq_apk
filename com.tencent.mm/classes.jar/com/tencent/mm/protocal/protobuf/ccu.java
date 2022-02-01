package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ccu
  extends com.tencent.mm.bw.a
{
  public String AZx;
  public String LSm;
  public String MiH;
  public String MiI;
  public String MiJ;
  public String MiK;
  public String price;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72507);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.AZx == null)
      {
        paramVarArgs = new b("Not all required fields were included: product_id");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.price == null)
      {
        paramVarArgs = new b("Not all required fields were included: price");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.LSm == null)
      {
        paramVarArgs = new b("Not all required fields were included: currency_type");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.MiH == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.AZx != null) {
        paramVarArgs.e(1, this.AZx);
      }
      if (this.price != null) {
        paramVarArgs.e(2, this.price);
      }
      if (this.LSm != null) {
        paramVarArgs.e(3, this.LSm);
      }
      if (this.MiH != null) {
        paramVarArgs.e(4, this.MiH);
      }
      if (this.MiI != null) {
        paramVarArgs.e(5, this.MiI);
      }
      if (this.MiJ != null) {
        paramVarArgs.e(6, this.MiJ);
      }
      if (this.MiK != null) {
        paramVarArgs.e(7, this.MiK);
      }
      AppMethodBeat.o(72507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.AZx == null) {
        break label770;
      }
    }
    label770:
    for (int i = g.a.a.b.b.a.f(1, this.AZx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.price != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.price);
      }
      i = paramInt;
      if (this.LSm != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LSm);
      }
      paramInt = i;
      if (this.MiH != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MiH);
      }
      i = paramInt;
      if (this.MiI != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MiI);
      }
      paramInt = i;
      if (this.MiJ != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MiJ);
      }
      i = paramInt;
      if (this.MiK != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MiK);
      }
      AppMethodBeat.o(72507);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.AZx == null)
        {
          paramVarArgs = new b("Not all required fields were included: product_id");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.price == null)
        {
          paramVarArgs = new b("Not all required fields were included: price");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.LSm == null)
        {
          paramVarArgs = new b("Not all required fields were included: currency_type");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.MiH == null)
        {
          paramVarArgs = new b("Not all required fields were included: session_data");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72507);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ccu localccu = (ccu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72507);
          return -1;
        case 1: 
          localccu.AZx = locala.UbS.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 2: 
          localccu.price = locala.UbS.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 3: 
          localccu.LSm = locala.UbS.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 4: 
          localccu.MiH = locala.UbS.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 5: 
          localccu.MiI = locala.UbS.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 6: 
          localccu.MiJ = locala.UbS.readString();
          AppMethodBeat.o(72507);
          return 0;
        }
        localccu.MiK = locala.UbS.readString();
        AppMethodBeat.o(72507);
        return 0;
      }
      AppMethodBeat.o(72507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccu
 * JD-Core Version:    0.7.0.1
 */