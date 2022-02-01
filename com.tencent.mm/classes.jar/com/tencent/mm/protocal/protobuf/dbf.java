package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class dbf
  extends com.tencent.mm.bx.a
{
  public String MQZ;
  public String aaGH;
  public String aaGI;
  public String aaGJ;
  public String aaGK;
  public String aaoi;
  public String price;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72507);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.MQZ == null)
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
      if (this.aaoi == null)
      {
        paramVarArgs = new b("Not all required fields were included: currency_type");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.aaGH == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.MQZ != null) {
        paramVarArgs.g(1, this.MQZ);
      }
      if (this.price != null) {
        paramVarArgs.g(2, this.price);
      }
      if (this.aaoi != null) {
        paramVarArgs.g(3, this.aaoi);
      }
      if (this.aaGH != null) {
        paramVarArgs.g(4, this.aaGH);
      }
      if (this.aaGI != null) {
        paramVarArgs.g(5, this.aaGI);
      }
      if (this.aaGJ != null) {
        paramVarArgs.g(6, this.aaGJ);
      }
      if (this.aaGK != null) {
        paramVarArgs.g(7, this.aaGK);
      }
      AppMethodBeat.o(72507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MQZ == null) {
        break label766;
      }
    }
    label766:
    for (int i = i.a.a.b.b.a.h(1, this.MQZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.price != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.price);
      }
      i = paramInt;
      if (this.aaoi != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaoi);
      }
      paramInt = i;
      if (this.aaGH != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaGH);
      }
      i = paramInt;
      if (this.aaGI != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaGI);
      }
      paramInt = i;
      if (this.aaGJ != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaGJ);
      }
      i = paramInt;
      if (this.aaGK != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaGK);
      }
      AppMethodBeat.o(72507);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.MQZ == null)
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
        if (this.aaoi == null)
        {
          paramVarArgs = new b("Not all required fields were included: currency_type");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.aaGH == null)
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dbf localdbf = (dbf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72507);
          return -1;
        case 1: 
          localdbf.MQZ = locala.ajGk.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 2: 
          localdbf.price = locala.ajGk.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 3: 
          localdbf.aaoi = locala.ajGk.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 4: 
          localdbf.aaGH = locala.ajGk.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 5: 
          localdbf.aaGI = locala.ajGk.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 6: 
          localdbf.aaGJ = locala.ajGk.readString();
          AppMethodBeat.o(72507);
          return 0;
        }
        localdbf.aaGK = locala.ajGk.readString();
        AppMethodBeat.o(72507);
        return 0;
      }
      AppMethodBeat.o(72507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbf
 * JD-Core Version:    0.7.0.1
 */