package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ggm
  extends com.tencent.mm.bx.a
{
  public int abIu;
  public String acbp;
  public com.tencent.mm.bx.b acdb;
  public com.tencent.mm.bx.b acdc;
  public String acdd;
  public String acde;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32550);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acbp == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Msg");
        AppMethodBeat.o(32550);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.abIu);
      if (this.acbp != null) {
        paramVarArgs.g(2, this.acbp);
      }
      if (this.acdb != null) {
        paramVarArgs.d(3, this.acdb);
      }
      if (this.acdc != null) {
        paramVarArgs.d(4, this.acdc);
      }
      if (this.acdd != null) {
        paramVarArgs.g(5, this.acdd);
      }
      if (this.acde != null) {
        paramVarArgs.g(6, this.acde);
      }
      AppMethodBeat.o(32550);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abIu) + 0;
      paramInt = i;
      if (this.acbp != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.acbp);
      }
      i = paramInt;
      if (this.acdb != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.acdb);
      }
      paramInt = i;
      if (this.acdc != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.acdc);
      }
      i = paramInt;
      if (this.acdd != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.acdd);
      }
      paramInt = i;
      if (this.acde != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.acde);
      }
      AppMethodBeat.o(32550);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.acbp == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Msg");
        AppMethodBeat.o(32550);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32550);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ggm localggm = (ggm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32550);
        return -1;
      case 1: 
        localggm.abIu = locala.ajGk.aar();
        AppMethodBeat.o(32550);
        return 0;
      case 2: 
        localggm.acbp = locala.ajGk.readString();
        AppMethodBeat.o(32550);
        return 0;
      case 3: 
        localggm.acdb = locala.ajGk.kFX();
        AppMethodBeat.o(32550);
        return 0;
      case 4: 
        localggm.acdc = locala.ajGk.kFX();
        AppMethodBeat.o(32550);
        return 0;
      case 5: 
        localggm.acdd = locala.ajGk.readString();
        AppMethodBeat.o(32550);
        return 0;
      }
      localggm.acde = locala.ajGk.readString();
      AppMethodBeat.o(32550);
      return 0;
    }
    AppMethodBeat.o(32550);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ggm
 * JD-Core Version:    0.7.0.1
 */