package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dr
  extends com.tencent.mm.bw.a
{
  public String KHE;
  public String KHF;
  public String UserName;
  public String kdZ;
  public String kea;
  public String keh;
  public String xKd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91348);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.keh != null) {
        paramVarArgs.e(1, this.keh);
      }
      if (this.kdZ != null) {
        paramVarArgs.e(2, this.kdZ);
      }
      if (this.kea != null) {
        paramVarArgs.e(3, this.kea);
      }
      if (this.xKd != null) {
        paramVarArgs.e(4, this.xKd);
      }
      if (this.UserName != null) {
        paramVarArgs.e(5, this.UserName);
      }
      if (this.KHE != null) {
        paramVarArgs.e(6, this.KHE);
      }
      if (this.KHF != null) {
        paramVarArgs.e(7, this.KHF);
      }
      AppMethodBeat.o(91348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.keh == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.b.b.a.f(1, this.keh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kdZ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.kdZ);
      }
      i = paramInt;
      if (this.kea != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.kea);
      }
      paramInt = i;
      if (this.xKd != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xKd);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.UserName);
      }
      paramInt = i;
      if (this.KHE != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KHE);
      }
      i = paramInt;
      if (this.KHF != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KHF);
      }
      AppMethodBeat.o(91348);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91348);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dr localdr = (dr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91348);
          return -1;
        case 1: 
          localdr.keh = locala.UbS.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 2: 
          localdr.kdZ = locala.UbS.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 3: 
          localdr.kea = locala.UbS.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 4: 
          localdr.xKd = locala.UbS.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 5: 
          localdr.UserName = locala.UbS.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 6: 
          localdr.KHE = locala.UbS.readString();
          AppMethodBeat.o(91348);
          return 0;
        }
        localdr.KHF = locala.UbS.readString();
        AppMethodBeat.o(91348);
        return 0;
      }
      AppMethodBeat.o(91348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dr
 * JD-Core Version:    0.7.0.1
 */