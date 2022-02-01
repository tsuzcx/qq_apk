package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bhi
  extends com.tencent.mm.bx.a
{
  public String DFk;
  public String DFl;
  public String DFm;
  public String DFn;
  public String DqC;
  public String upC;
  public String uwi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72507);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uwi == null)
      {
        paramVarArgs = new b("Not all required fields were included: product_id");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.upC == null)
      {
        paramVarArgs = new b("Not all required fields were included: price");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.DqC == null)
      {
        paramVarArgs = new b("Not all required fields were included: currency_type");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.DFk == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.uwi != null) {
        paramVarArgs.d(1, this.uwi);
      }
      if (this.upC != null) {
        paramVarArgs.d(2, this.upC);
      }
      if (this.DqC != null) {
        paramVarArgs.d(3, this.DqC);
      }
      if (this.DFk != null) {
        paramVarArgs.d(4, this.DFk);
      }
      if (this.DFl != null) {
        paramVarArgs.d(5, this.DFl);
      }
      if (this.DFm != null) {
        paramVarArgs.d(6, this.DFm);
      }
      if (this.DFn != null) {
        paramVarArgs.d(7, this.DFn);
      }
      AppMethodBeat.o(72507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uwi == null) {
        break label770;
      }
    }
    label770:
    for (int i = f.a.a.b.b.a.e(1, this.uwi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.upC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.upC);
      }
      i = paramInt;
      if (this.DqC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DqC);
      }
      paramInt = i;
      if (this.DFk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DFk);
      }
      i = paramInt;
      if (this.DFl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DFl);
      }
      paramInt = i;
      if (this.DFm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DFm);
      }
      i = paramInt;
      if (this.DFn != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DFn);
      }
      AppMethodBeat.o(72507);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.uwi == null)
        {
          paramVarArgs = new b("Not all required fields were included: product_id");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.upC == null)
        {
          paramVarArgs = new b("Not all required fields were included: price");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.DqC == null)
        {
          paramVarArgs = new b("Not all required fields were included: currency_type");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.DFk == null)
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bhi localbhi = (bhi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72507);
          return -1;
        case 1: 
          localbhi.uwi = locala.KhF.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 2: 
          localbhi.upC = locala.KhF.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 3: 
          localbhi.DqC = locala.KhF.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 4: 
          localbhi.DFk = locala.KhF.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 5: 
          localbhi.DFl = locala.KhF.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 6: 
          localbhi.DFm = locala.KhF.readString();
          AppMethodBeat.o(72507);
          return 0;
        }
        localbhi.DFn = locala.KhF.readString();
        AppMethodBeat.o(72507);
        return 0;
      }
      AppMethodBeat.o(72507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhi
 * JD-Core Version:    0.7.0.1
 */