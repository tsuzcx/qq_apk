package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class qw
  extends com.tencent.mm.bx.a
{
  public String FME;
  public String FMF;
  public String FMG;
  public int FMH;
  public String FMI;
  public String wDU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FME == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.wDU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.FMF == null)
      {
        paramVarArgs = new b("Not all required fields were included: SellerName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.FMG == null)
      {
        paramVarArgs = new b("Not all required fields were included: SellerUserName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.FME != null) {
        paramVarArgs.d(1, this.FME);
      }
      if (this.wDU != null) {
        paramVarArgs.d(2, this.wDU);
      }
      if (this.FMF != null) {
        paramVarArgs.d(3, this.FMF);
      }
      if (this.FMG != null) {
        paramVarArgs.d(4, this.FMG);
      }
      paramVarArgs.aS(5, this.FMH);
      if (this.FMI != null) {
        paramVarArgs.d(6, this.FMI);
      }
      AppMethodBeat.o(117847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FME == null) {
        break label694;
      }
    }
    label694:
    for (int i = f.a.a.b.b.a.e(1, this.FME) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wDU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.wDU);
      }
      i = paramInt;
      if (this.FMF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FMF);
      }
      paramInt = i;
      if (this.FMG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FMG);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FMH);
      paramInt = i;
      if (this.FMI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FMI);
      }
      AppMethodBeat.o(117847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FME == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.wDU == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.FMF == null)
        {
          paramVarArgs = new b("Not all required fields were included: SellerName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.FMG == null)
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
        qw localqw = (qw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117847);
          return -1;
        case 1: 
          localqw.FME = locala.NPN.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 2: 
          localqw.wDU = locala.NPN.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 3: 
          localqw.FMF = locala.NPN.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 4: 
          localqw.FMG = locala.NPN.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 5: 
          localqw.FMH = locala.NPN.zc();
          AppMethodBeat.o(117847);
          return 0;
        }
        localqw.FMI = locala.NPN.readString();
        AppMethodBeat.o(117847);
        return 0;
      }
      AppMethodBeat.o(117847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qw
 * JD-Core Version:    0.7.0.1
 */