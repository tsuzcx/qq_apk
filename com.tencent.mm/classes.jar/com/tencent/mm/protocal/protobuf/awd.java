package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class awd
  extends com.tencent.mm.bv.a
{
  public String pqC;
  public String puw;
  public String wYP;
  public String xlA;
  public String xlx;
  public String xly;
  public String xlz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48873);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.puw == null)
      {
        paramVarArgs = new b("Not all required fields were included: product_id");
        AppMethodBeat.o(48873);
        throw paramVarArgs;
      }
      if (this.pqC == null)
      {
        paramVarArgs = new b("Not all required fields were included: price");
        AppMethodBeat.o(48873);
        throw paramVarArgs;
      }
      if (this.wYP == null)
      {
        paramVarArgs = new b("Not all required fields were included: currency_type");
        AppMethodBeat.o(48873);
        throw paramVarArgs;
      }
      if (this.xlx == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(48873);
        throw paramVarArgs;
      }
      if (this.puw != null) {
        paramVarArgs.e(1, this.puw);
      }
      if (this.pqC != null) {
        paramVarArgs.e(2, this.pqC);
      }
      if (this.wYP != null) {
        paramVarArgs.e(3, this.wYP);
      }
      if (this.xlx != null) {
        paramVarArgs.e(4, this.xlx);
      }
      if (this.xly != null) {
        paramVarArgs.e(5, this.xly);
      }
      if (this.xlz != null) {
        paramVarArgs.e(6, this.xlz);
      }
      if (this.xlA != null) {
        paramVarArgs.e(7, this.xlA);
      }
      AppMethodBeat.o(48873);
      return 0;
    }
    if (paramInt == 1) {
      if (this.puw == null) {
        break label770;
      }
    }
    label770:
    for (int i = e.a.a.b.b.a.f(1, this.puw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pqC != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.pqC);
      }
      i = paramInt;
      if (this.wYP != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wYP);
      }
      paramInt = i;
      if (this.xlx != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xlx);
      }
      i = paramInt;
      if (this.xly != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xly);
      }
      paramInt = i;
      if (this.xlz != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xlz);
      }
      i = paramInt;
      if (this.xlA != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xlA);
      }
      AppMethodBeat.o(48873);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.puw == null)
        {
          paramVarArgs = new b("Not all required fields were included: product_id");
          AppMethodBeat.o(48873);
          throw paramVarArgs;
        }
        if (this.pqC == null)
        {
          paramVarArgs = new b("Not all required fields were included: price");
          AppMethodBeat.o(48873);
          throw paramVarArgs;
        }
        if (this.wYP == null)
        {
          paramVarArgs = new b("Not all required fields were included: currency_type");
          AppMethodBeat.o(48873);
          throw paramVarArgs;
        }
        if (this.xlx == null)
        {
          paramVarArgs = new b("Not all required fields were included: session_data");
          AppMethodBeat.o(48873);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48873);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        awd localawd = (awd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48873);
          return -1;
        case 1: 
          localawd.puw = locala.CLY.readString();
          AppMethodBeat.o(48873);
          return 0;
        case 2: 
          localawd.pqC = locala.CLY.readString();
          AppMethodBeat.o(48873);
          return 0;
        case 3: 
          localawd.wYP = locala.CLY.readString();
          AppMethodBeat.o(48873);
          return 0;
        case 4: 
          localawd.xlx = locala.CLY.readString();
          AppMethodBeat.o(48873);
          return 0;
        case 5: 
          localawd.xly = locala.CLY.readString();
          AppMethodBeat.o(48873);
          return 0;
        case 6: 
          localawd.xlz = locala.CLY.readString();
          AppMethodBeat.o(48873);
          return 0;
        }
        localawd.xlA = locala.CLY.readString();
        AppMethodBeat.o(48873);
        return 0;
      }
      AppMethodBeat.o(48873);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awd
 * JD-Core Version:    0.7.0.1
 */