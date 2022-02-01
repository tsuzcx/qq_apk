package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cky
  extends com.tencent.mm.cd.a
{
  public String GTv;
  public String TaW;
  public String TsA;
  public String Tsx;
  public String Tsy;
  public String Tsz;
  public String price;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72507);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.GTv == null)
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
      if (this.TaW == null)
      {
        paramVarArgs = new b("Not all required fields were included: currency_type");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.Tsx == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.GTv != null) {
        paramVarArgs.f(1, this.GTv);
      }
      if (this.price != null) {
        paramVarArgs.f(2, this.price);
      }
      if (this.TaW != null) {
        paramVarArgs.f(3, this.TaW);
      }
      if (this.Tsx != null) {
        paramVarArgs.f(4, this.Tsx);
      }
      if (this.Tsy != null) {
        paramVarArgs.f(5, this.Tsy);
      }
      if (this.Tsz != null) {
        paramVarArgs.f(6, this.Tsz);
      }
      if (this.TsA != null) {
        paramVarArgs.f(7, this.TsA);
      }
      AppMethodBeat.o(72507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GTv == null) {
        break label770;
      }
    }
    label770:
    for (int i = g.a.a.b.b.a.g(1, this.GTv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.price != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.price);
      }
      i = paramInt;
      if (this.TaW != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TaW);
      }
      paramInt = i;
      if (this.Tsx != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tsx);
      }
      i = paramInt;
      if (this.Tsy != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Tsy);
      }
      paramInt = i;
      if (this.Tsz != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Tsz);
      }
      i = paramInt;
      if (this.TsA != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TsA);
      }
      AppMethodBeat.o(72507);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.GTv == null)
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
        if (this.TaW == null)
        {
          paramVarArgs = new b("Not all required fields were included: currency_type");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.Tsx == null)
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
        cky localcky = (cky)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72507);
          return -1;
        case 1: 
          localcky.GTv = locala.abFh.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 2: 
          localcky.price = locala.abFh.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 3: 
          localcky.TaW = locala.abFh.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 4: 
          localcky.Tsx = locala.abFh.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 5: 
          localcky.Tsy = locala.abFh.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 6: 
          localcky.Tsz = locala.abFh.readString();
          AppMethodBeat.o(72507);
          return 0;
        }
        localcky.TsA = locala.abFh.readString();
        AppMethodBeat.o(72507);
        return 0;
      }
      AppMethodBeat.o(72507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cky
 * JD-Core Version:    0.7.0.1
 */