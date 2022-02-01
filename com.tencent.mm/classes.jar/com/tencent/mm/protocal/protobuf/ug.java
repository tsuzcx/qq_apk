package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class ug
  extends com.tencent.mm.bx.a
{
  public long Oll;
  public String Olm;
  public String Oln;
  public String Olo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259195);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Olm == null)
      {
        paramVarArgs = new b("Not all required fields were included: personalpay_order_id");
        AppMethodBeat.o(259195);
        throw paramVarArgs;
      }
      if (this.Olm != null) {
        paramVarArgs.g(1, this.Olm);
      }
      if (this.Oln != null) {
        paramVarArgs.g(2, this.Oln);
      }
      paramVarArgs.bv(3, this.Oll);
      if (this.Olo != null) {
        paramVarArgs.g(4, this.Olo);
      }
      AppMethodBeat.o(259195);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Olm == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = i.a.a.b.b.a.h(1, this.Olm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Oln != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Oln);
      }
      i += i.a.a.b.b.a.q(3, this.Oll);
      paramInt = i;
      if (this.Olo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Olo);
      }
      AppMethodBeat.o(259195);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.Olm == null)
        {
          paramVarArgs = new b("Not all required fields were included: personalpay_order_id");
          AppMethodBeat.o(259195);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259195);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ug localug = (ug)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259195);
          return -1;
        case 1: 
          localug.Olm = locala.ajGk.readString();
          AppMethodBeat.o(259195);
          return 0;
        case 2: 
          localug.Oln = locala.ajGk.readString();
          AppMethodBeat.o(259195);
          return 0;
        case 3: 
          localug.Oll = locala.ajGk.aaw();
          AppMethodBeat.o(259195);
          return 0;
        }
        localug.Olo = locala.ajGk.readString();
        AppMethodBeat.o(259195);
        return 0;
      }
      AppMethodBeat.o(259195);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ug
 * JD-Core Version:    0.7.0.1
 */