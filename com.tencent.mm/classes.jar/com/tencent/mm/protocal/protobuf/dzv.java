package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzv
  extends com.tencent.mm.bx.a
{
  public String YRs;
  public String Zrd;
  public int ZuN;
  public String ZuO;
  public String aars;
  public String abfc;
  public String abfd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257347);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZuN);
      if (this.Zrd != null) {
        paramVarArgs.g(2, this.Zrd);
      }
      if (this.YRs != null) {
        paramVarArgs.g(3, this.YRs);
      }
      if (this.abfc != null) {
        paramVarArgs.g(4, this.abfc);
      }
      if (this.abfd != null) {
        paramVarArgs.g(5, this.abfd);
      }
      if (this.ZuO != null) {
        paramVarArgs.g(6, this.ZuO);
      }
      if (this.aars != null) {
        paramVarArgs.g(7, this.aars);
      }
      AppMethodBeat.o(257347);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZuN) + 0;
      paramInt = i;
      if (this.Zrd != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zrd);
      }
      i = paramInt;
      if (this.YRs != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YRs);
      }
      paramInt = i;
      if (this.abfc != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abfc);
      }
      i = paramInt;
      if (this.abfd != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abfd);
      }
      paramInt = i;
      if (this.ZuO != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZuO);
      }
      i = paramInt;
      if (this.aars != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aars);
      }
      AppMethodBeat.o(257347);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257347);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dzv localdzv = (dzv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257347);
        return -1;
      case 1: 
        localdzv.ZuN = locala.ajGk.aar();
        AppMethodBeat.o(257347);
        return 0;
      case 2: 
        localdzv.Zrd = locala.ajGk.readString();
        AppMethodBeat.o(257347);
        return 0;
      case 3: 
        localdzv.YRs = locala.ajGk.readString();
        AppMethodBeat.o(257347);
        return 0;
      case 4: 
        localdzv.abfc = locala.ajGk.readString();
        AppMethodBeat.o(257347);
        return 0;
      case 5: 
        localdzv.abfd = locala.ajGk.readString();
        AppMethodBeat.o(257347);
        return 0;
      case 6: 
        localdzv.ZuO = locala.ajGk.readString();
        AppMethodBeat.o(257347);
        return 0;
      }
      localdzv.aars = locala.ajGk.readString();
      AppMethodBeat.o(257347);
      return 0;
    }
    AppMethodBeat.o(257347);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzv
 * JD-Core Version:    0.7.0.1
 */