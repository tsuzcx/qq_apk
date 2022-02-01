package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbz
  extends com.tencent.mm.bx.a
{
  public int YQB;
  public int aalm;
  public String aaln;
  public String aalo;
  public String oOI;
  public com.tencent.mm.bx.b vgA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50086);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.oOI == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: AppId");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.vgA == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.aalo == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: EventInfo");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.oOI != null) {
        paramVarArgs.g(1, this.oOI);
      }
      paramVarArgs.bS(2, this.YQB);
      paramVarArgs.bS(3, this.aalm);
      if (this.vgA != null) {
        paramVarArgs.d(4, this.vgA);
      }
      if (this.aaln != null) {
        paramVarArgs.g(5, this.aaln);
      }
      if (this.aalo != null) {
        paramVarArgs.g(6, this.aalo);
      }
      AppMethodBeat.o(50086);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oOI == null) {
        break label622;
      }
    }
    label622:
    for (paramInt = i.a.a.b.b.a.h(1, this.oOI) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YQB) + i.a.a.b.b.a.cJ(3, this.aalm);
      paramInt = i;
      if (this.vgA != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.vgA);
      }
      i = paramInt;
      if (this.aaln != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaln);
      }
      paramInt = i;
      if (this.aalo != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aalo);
      }
      AppMethodBeat.o(50086);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.oOI == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: AppId");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        if (this.vgA == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: Data");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        if (this.aalo == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: EventInfo");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        AppMethodBeat.o(50086);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cbz localcbz = (cbz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50086);
          return -1;
        case 1: 
          localcbz.oOI = locala.ajGk.readString();
          AppMethodBeat.o(50086);
          return 0;
        case 2: 
          localcbz.YQB = locala.ajGk.aar();
          AppMethodBeat.o(50086);
          return 0;
        case 3: 
          localcbz.aalm = locala.ajGk.aar();
          AppMethodBeat.o(50086);
          return 0;
        case 4: 
          localcbz.vgA = locala.ajGk.kFX();
          AppMethodBeat.o(50086);
          return 0;
        case 5: 
          localcbz.aaln = locala.ajGk.readString();
          AppMethodBeat.o(50086);
          return 0;
        }
        localcbz.aalo = locala.ajGk.readString();
        AppMethodBeat.o(50086);
        return 0;
      }
      AppMethodBeat.o(50086);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbz
 * JD-Core Version:    0.7.0.1
 */