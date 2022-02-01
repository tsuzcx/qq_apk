package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gna
  extends com.tencent.mm.bx.a
{
  public String acij;
  public String acik;
  public String appid;
  public int tQx;
  public int tSh;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123710);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.appid != null) {
        paramVarArgs.g(2, this.appid);
      }
      if (this.acij != null) {
        paramVarArgs.g(3, this.acij);
      }
      if (this.acik != null) {
        paramVarArgs.g(4, this.acik);
      }
      paramVarArgs.bS(5, this.tQx);
      paramVarArgs.bS(6, this.tSh);
      AppMethodBeat.o(123710);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appid);
      }
      i = paramInt;
      if (this.acij != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.acij);
      }
      paramInt = i;
      if (this.acik != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.acik);
      }
      i = i.a.a.b.b.a.cJ(5, this.tQx);
      int j = i.a.a.b.b.a.cJ(6, this.tSh);
      AppMethodBeat.o(123710);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(123710);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gna localgna = (gna)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123710);
        return -1;
      case 1: 
        localgna.type = locala.ajGk.aar();
        AppMethodBeat.o(123710);
        return 0;
      case 2: 
        localgna.appid = locala.ajGk.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 3: 
        localgna.acij = locala.ajGk.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 4: 
        localgna.acik = locala.ajGk.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 5: 
        localgna.tQx = locala.ajGk.aar();
        AppMethodBeat.o(123710);
        return 0;
      }
      localgna.tSh = locala.ajGk.aar();
      AppMethodBeat.o(123710);
      return 0;
    }
    AppMethodBeat.o(123710);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gna
 * JD-Core Version:    0.7.0.1
 */