package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bpk
  extends com.tencent.mm.bx.a
{
  public String GKd;
  public String GKe;
  public String GKf;
  public String GKg;
  public String GuI;
  public String wDS;
  public String wMh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72507);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wMh == null)
      {
        paramVarArgs = new b("Not all required fields were included: product_id");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.wDS == null)
      {
        paramVarArgs = new b("Not all required fields were included: price");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.GuI == null)
      {
        paramVarArgs = new b("Not all required fields were included: currency_type");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.GKd == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.wMh != null) {
        paramVarArgs.d(1, this.wMh);
      }
      if (this.wDS != null) {
        paramVarArgs.d(2, this.wDS);
      }
      if (this.GuI != null) {
        paramVarArgs.d(3, this.GuI);
      }
      if (this.GKd != null) {
        paramVarArgs.d(4, this.GKd);
      }
      if (this.GKe != null) {
        paramVarArgs.d(5, this.GKe);
      }
      if (this.GKf != null) {
        paramVarArgs.d(6, this.GKf);
      }
      if (this.GKg != null) {
        paramVarArgs.d(7, this.GKg);
      }
      AppMethodBeat.o(72507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wMh == null) {
        break label770;
      }
    }
    label770:
    for (int i = f.a.a.b.b.a.e(1, this.wMh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wDS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.wDS);
      }
      i = paramInt;
      if (this.GuI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GuI);
      }
      paramInt = i;
      if (this.GKd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GKd);
      }
      i = paramInt;
      if (this.GKe != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GKe);
      }
      paramInt = i;
      if (this.GKf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GKf);
      }
      i = paramInt;
      if (this.GKg != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GKg);
      }
      AppMethodBeat.o(72507);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.wMh == null)
        {
          paramVarArgs = new b("Not all required fields were included: product_id");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.wDS == null)
        {
          paramVarArgs = new b("Not all required fields were included: price");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.GuI == null)
        {
          paramVarArgs = new b("Not all required fields were included: currency_type");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.GKd == null)
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
        bpk localbpk = (bpk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72507);
          return -1;
        case 1: 
          localbpk.wMh = locala.NPN.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 2: 
          localbpk.wDS = locala.NPN.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 3: 
          localbpk.GuI = locala.NPN.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 4: 
          localbpk.GKd = locala.NPN.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 5: 
          localbpk.GKe = locala.NPN.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 6: 
          localbpk.GKf = locala.NPN.readString();
          AppMethodBeat.o(72507);
          return 0;
        }
        localbpk.GKg = locala.NPN.readString();
        AppMethodBeat.o(72507);
        return 0;
      }
      AppMethodBeat.o(72507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpk
 * JD-Core Version:    0.7.0.1
 */