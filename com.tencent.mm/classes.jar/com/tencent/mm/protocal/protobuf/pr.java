package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class pr
  extends com.tencent.mm.bw.a
{
  public String Egf;
  public String Egg;
  public String Egh;
  public int Egi;
  public String Egj;
  public String vyA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Egf == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.vyA == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.Egg == null)
      {
        paramVarArgs = new b("Not all required fields were included: SellerName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.Egh == null)
      {
        paramVarArgs = new b("Not all required fields were included: SellerUserName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.Egf != null) {
        paramVarArgs.d(1, this.Egf);
      }
      if (this.vyA != null) {
        paramVarArgs.d(2, this.vyA);
      }
      if (this.Egg != null) {
        paramVarArgs.d(3, this.Egg);
      }
      if (this.Egh != null) {
        paramVarArgs.d(4, this.Egh);
      }
      paramVarArgs.aR(5, this.Egi);
      if (this.Egj != null) {
        paramVarArgs.d(6, this.Egj);
      }
      AppMethodBeat.o(117847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Egf == null) {
        break label694;
      }
    }
    label694:
    for (int i = f.a.a.b.b.a.e(1, this.Egf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vyA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vyA);
      }
      i = paramInt;
      if (this.Egg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Egg);
      }
      paramInt = i;
      if (this.Egh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Egh);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.Egi);
      paramInt = i;
      if (this.Egj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Egj);
      }
      AppMethodBeat.o(117847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Egf == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.vyA == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.Egg == null)
        {
          paramVarArgs = new b("Not all required fields were included: SellerName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.Egh == null)
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        pr localpr = (pr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117847);
          return -1;
        case 1: 
          localpr.Egf = locala.LVo.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 2: 
          localpr.vyA = locala.LVo.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 3: 
          localpr.Egg = locala.LVo.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 4: 
          localpr.Egh = locala.LVo.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 5: 
          localpr.Egi = locala.LVo.xF();
          AppMethodBeat.o(117847);
          return 0;
        }
        localpr.Egj = locala.LVo.readString();
        AppMethodBeat.o(117847);
        return 0;
      }
      AppMethodBeat.o(117847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pr
 * JD-Core Version:    0.7.0.1
 */