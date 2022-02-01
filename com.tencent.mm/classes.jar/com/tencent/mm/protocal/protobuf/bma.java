package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bma
  extends com.tencent.mm.bx.a
{
  public String ZUK;
  public long ZUL;
  public long ZUM;
  public String ZUN;
  public String ZUO;
  public long ZUP;
  public String ZUQ;
  public long ZUR;
  public String ZUS;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259018);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZUK != null) {
        paramVarArgs.g(1, this.ZUK);
      }
      if (this.session_id != null) {
        paramVarArgs.g(2, this.session_id);
      }
      paramVarArgs.bv(3, this.ZUL);
      paramVarArgs.bv(4, this.ZUM);
      if (this.ZUN != null) {
        paramVarArgs.g(5, this.ZUN);
      }
      if (this.ZUO != null) {
        paramVarArgs.g(7, this.ZUO);
      }
      paramVarArgs.bv(8, this.ZUP);
      if (this.ZUQ != null) {
        paramVarArgs.g(9, this.ZUQ);
      }
      paramVarArgs.bv(10, this.ZUR);
      if (this.ZUS != null) {
        paramVarArgs.g(1001, this.ZUS);
      }
      AppMethodBeat.o(259018);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZUK == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZUK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.session_id != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.session_id);
      }
      i = i + i.a.a.b.b.a.q(3, this.ZUL) + i.a.a.b.b.a.q(4, this.ZUM);
      paramInt = i;
      if (this.ZUN != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZUN);
      }
      i = paramInt;
      if (this.ZUO != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZUO);
      }
      i += i.a.a.b.b.a.q(8, this.ZUP);
      paramInt = i;
      if (this.ZUQ != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.ZUQ);
      }
      i = paramInt + i.a.a.b.b.a.q(10, this.ZUR);
      paramInt = i;
      if (this.ZUS != null) {
        paramInt = i + i.a.a.b.b.a.h(1001, this.ZUS);
      }
      AppMethodBeat.o(259018);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259018);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bma localbma = (bma)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259018);
          return -1;
        case 1: 
          localbma.ZUK = locala.ajGk.readString();
          AppMethodBeat.o(259018);
          return 0;
        case 2: 
          localbma.session_id = locala.ajGk.readString();
          AppMethodBeat.o(259018);
          return 0;
        case 3: 
          localbma.ZUL = locala.ajGk.aaw();
          AppMethodBeat.o(259018);
          return 0;
        case 4: 
          localbma.ZUM = locala.ajGk.aaw();
          AppMethodBeat.o(259018);
          return 0;
        case 5: 
          localbma.ZUN = locala.ajGk.readString();
          AppMethodBeat.o(259018);
          return 0;
        case 7: 
          localbma.ZUO = locala.ajGk.readString();
          AppMethodBeat.o(259018);
          return 0;
        case 8: 
          localbma.ZUP = locala.ajGk.aaw();
          AppMethodBeat.o(259018);
          return 0;
        case 9: 
          localbma.ZUQ = locala.ajGk.readString();
          AppMethodBeat.o(259018);
          return 0;
        case 10: 
          localbma.ZUR = locala.ajGk.aaw();
          AppMethodBeat.o(259018);
          return 0;
        }
        localbma.ZUS = locala.ajGk.readString();
        AppMethodBeat.o(259018);
        return 0;
      }
      AppMethodBeat.o(259018);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bma
 * JD-Core Version:    0.7.0.1
 */