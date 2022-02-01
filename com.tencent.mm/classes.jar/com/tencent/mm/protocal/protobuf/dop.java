package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dop
  extends com.tencent.mm.bx.a
{
  public String aaVA;
  public String aaVB;
  public String aaVC;
  public String aaVy;
  public String aaVz;
  public String pf;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258204);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaVy != null) {
        paramVarArgs.g(1, this.aaVy);
      }
      if (this.aaVz != null) {
        paramVarArgs.g(2, this.aaVz);
      }
      if (this.aaVA != null) {
        paramVarArgs.g(3, this.aaVA);
      }
      if (this.session_id != null) {
        paramVarArgs.g(4, this.session_id);
      }
      if (this.aaVB != null) {
        paramVarArgs.g(5, this.aaVB);
      }
      if (this.pf != null) {
        paramVarArgs.g(6, this.pf);
      }
      if (this.aaVC != null) {
        paramVarArgs.g(7, this.aaVC);
      }
      AppMethodBeat.o(258204);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaVy == null) {
        break label574;
      }
    }
    label574:
    for (int i = i.a.a.b.b.a.h(1, this.aaVy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaVz != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaVz);
      }
      i = paramInt;
      if (this.aaVA != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaVA);
      }
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.session_id);
      }
      i = paramInt;
      if (this.aaVB != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaVB);
      }
      paramInt = i;
      if (this.pf != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.pf);
      }
      i = paramInt;
      if (this.aaVC != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaVC);
      }
      AppMethodBeat.o(258204);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258204);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dop localdop = (dop)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258204);
          return -1;
        case 1: 
          localdop.aaVy = locala.ajGk.readString();
          AppMethodBeat.o(258204);
          return 0;
        case 2: 
          localdop.aaVz = locala.ajGk.readString();
          AppMethodBeat.o(258204);
          return 0;
        case 3: 
          localdop.aaVA = locala.ajGk.readString();
          AppMethodBeat.o(258204);
          return 0;
        case 4: 
          localdop.session_id = locala.ajGk.readString();
          AppMethodBeat.o(258204);
          return 0;
        case 5: 
          localdop.aaVB = locala.ajGk.readString();
          AppMethodBeat.o(258204);
          return 0;
        case 6: 
          localdop.pf = locala.ajGk.readString();
          AppMethodBeat.o(258204);
          return 0;
        }
        localdop.aaVC = locala.ajGk.readString();
        AppMethodBeat.o(258204);
        return 0;
      }
      AppMethodBeat.o(258204);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dop
 * JD-Core Version:    0.7.0.1
 */