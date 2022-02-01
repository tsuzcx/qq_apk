package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class rz
  extends com.tencent.mm.bw.a
{
  public String APy;
  public String KZu;
  public String KZv;
  public String KZw;
  public int KZx;
  public String KZy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117847);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KZu == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.APy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.KZv == null)
      {
        paramVarArgs = new b("Not all required fields were included: SellerName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.KZw == null)
      {
        paramVarArgs = new b("Not all required fields were included: SellerUserName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.KZu != null) {
        paramVarArgs.e(1, this.KZu);
      }
      if (this.APy != null) {
        paramVarArgs.e(2, this.APy);
      }
      if (this.KZv != null) {
        paramVarArgs.e(3, this.KZv);
      }
      if (this.KZw != null) {
        paramVarArgs.e(4, this.KZw);
      }
      paramVarArgs.aM(5, this.KZx);
      if (this.KZy != null) {
        paramVarArgs.e(6, this.KZy);
      }
      AppMethodBeat.o(117847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KZu == null) {
        break label694;
      }
    }
    label694:
    for (int i = g.a.a.b.b.a.f(1, this.KZu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.APy != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.APy);
      }
      i = paramInt;
      if (this.KZv != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KZv);
      }
      paramInt = i;
      if (this.KZw != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KZw);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KZx);
      paramInt = i;
      if (this.KZy != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KZy);
      }
      AppMethodBeat.o(117847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KZu == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.APy == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.KZv == null)
        {
          paramVarArgs = new b("Not all required fields were included: SellerName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.KZw == null)
        {
          paramVarArgs = new b("Not all required fields were included: SellerUserName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117847);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        rz localrz = (rz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117847);
          return -1;
        case 1: 
          localrz.KZu = locala.UbS.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 2: 
          localrz.APy = locala.UbS.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 3: 
          localrz.KZv = locala.UbS.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 4: 
          localrz.KZw = locala.UbS.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 5: 
          localrz.KZx = locala.UbS.zi();
          AppMethodBeat.o(117847);
          return 0;
        }
        localrz.KZy = locala.UbS.readString();
        AppMethodBeat.o(117847);
        return 0;
      }
      AppMethodBeat.o(117847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rz
 * JD-Core Version:    0.7.0.1
 */