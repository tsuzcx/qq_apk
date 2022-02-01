package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class pk
  extends com.tencent.mm.bx.a
{
  public String CND;
  public String CNE;
  public String CNF;
  public int CNG;
  public String CNH;
  public String upE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CND == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.upE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.CNE == null)
      {
        paramVarArgs = new b("Not all required fields were included: SellerName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.CNF == null)
      {
        paramVarArgs = new b("Not all required fields were included: SellerUserName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.CND != null) {
        paramVarArgs.d(1, this.CND);
      }
      if (this.upE != null) {
        paramVarArgs.d(2, this.upE);
      }
      if (this.CNE != null) {
        paramVarArgs.d(3, this.CNE);
      }
      if (this.CNF != null) {
        paramVarArgs.d(4, this.CNF);
      }
      paramVarArgs.aR(5, this.CNG);
      if (this.CNH != null) {
        paramVarArgs.d(6, this.CNH);
      }
      AppMethodBeat.o(117847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CND == null) {
        break label694;
      }
    }
    label694:
    for (int i = f.a.a.b.b.a.e(1, this.CND) + 0;; i = 0)
    {
      paramInt = i;
      if (this.upE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.upE);
      }
      i = paramInt;
      if (this.CNE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CNE);
      }
      paramInt = i;
      if (this.CNF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CNF);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CNG);
      paramInt = i;
      if (this.CNH != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CNH);
      }
      AppMethodBeat.o(117847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CND == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.upE == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.CNE == null)
        {
          paramVarArgs = new b("Not all required fields were included: SellerName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.CNF == null)
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
        pk localpk = (pk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117847);
          return -1;
        case 1: 
          localpk.CND = locala.KhF.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 2: 
          localpk.upE = locala.KhF.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 3: 
          localpk.CNE = locala.KhF.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 4: 
          localpk.CNF = locala.KhF.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 5: 
          localpk.CNG = locala.KhF.xS();
          AppMethodBeat.o(117847);
          return 0;
        }
        localpk.CNH = locala.KhF.readString();
        AppMethodBeat.o(117847);
        return 0;
      }
      AppMethodBeat.o(117847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pk
 * JD-Core Version:    0.7.0.1
 */