package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class nh
  extends com.tencent.mm.bv.a
{
  public String pqE;
  public String wCj;
  public String wCk;
  public String wCl;
  public int wCm;
  public String wCn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124299);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wCj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(124299);
        throw paramVarArgs;
      }
      if (this.pqE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductName");
        AppMethodBeat.o(124299);
        throw paramVarArgs;
      }
      if (this.wCk == null)
      {
        paramVarArgs = new b("Not all required fields were included: SellerName");
        AppMethodBeat.o(124299);
        throw paramVarArgs;
      }
      if (this.wCl == null)
      {
        paramVarArgs = new b("Not all required fields were included: SellerUserName");
        AppMethodBeat.o(124299);
        throw paramVarArgs;
      }
      if (this.wCj != null) {
        paramVarArgs.e(1, this.wCj);
      }
      if (this.pqE != null) {
        paramVarArgs.e(2, this.pqE);
      }
      if (this.wCk != null) {
        paramVarArgs.e(3, this.wCk);
      }
      if (this.wCl != null) {
        paramVarArgs.e(4, this.wCl);
      }
      paramVarArgs.aO(5, this.wCm);
      if (this.wCn != null) {
        paramVarArgs.e(6, this.wCn);
      }
      AppMethodBeat.o(124299);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wCj == null) {
        break label694;
      }
    }
    label694:
    for (int i = e.a.a.b.b.a.f(1, this.wCj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pqE != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.pqE);
      }
      i = paramInt;
      if (this.wCk != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wCk);
      }
      paramInt = i;
      if (this.wCl != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wCl);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wCm);
      paramInt = i;
      if (this.wCn != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wCn);
      }
      AppMethodBeat.o(124299);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wCj == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(124299);
          throw paramVarArgs;
        }
        if (this.pqE == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductName");
          AppMethodBeat.o(124299);
          throw paramVarArgs;
        }
        if (this.wCk == null)
        {
          paramVarArgs = new b("Not all required fields were included: SellerName");
          AppMethodBeat.o(124299);
          throw paramVarArgs;
        }
        if (this.wCl == null)
        {
          paramVarArgs = new b("Not all required fields were included: SellerUserName");
          AppMethodBeat.o(124299);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124299);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        nh localnh = (nh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124299);
          return -1;
        case 1: 
          localnh.wCj = locala.CLY.readString();
          AppMethodBeat.o(124299);
          return 0;
        case 2: 
          localnh.pqE = locala.CLY.readString();
          AppMethodBeat.o(124299);
          return 0;
        case 3: 
          localnh.wCk = locala.CLY.readString();
          AppMethodBeat.o(124299);
          return 0;
        case 4: 
          localnh.wCl = locala.CLY.readString();
          AppMethodBeat.o(124299);
          return 0;
        case 5: 
          localnh.wCm = locala.CLY.sl();
          AppMethodBeat.o(124299);
          return 0;
        }
        localnh.wCn = locala.CLY.readString();
        AppMethodBeat.o(124299);
        return 0;
      }
      AppMethodBeat.o(124299);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nh
 * JD-Core Version:    0.7.0.1
 */