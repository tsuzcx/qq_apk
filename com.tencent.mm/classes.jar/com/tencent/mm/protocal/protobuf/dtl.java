package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtl
  extends com.tencent.mm.bx.a
{
  public int Zoz;
  public int aaZf;
  public String aaZg;
  public String aaZh;
  public String aavb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115847);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aavb != null) {
        paramVarArgs.g(1, this.aavb);
      }
      paramVarArgs.bS(2, this.aaZf);
      if (this.aaZg != null) {
        paramVarArgs.g(3, this.aaZg);
      }
      paramVarArgs.bS(4, this.Zoz);
      if (this.aaZh != null) {
        paramVarArgs.g(5, this.aaZh);
      }
      AppMethodBeat.o(115847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aavb == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.b.b.a.h(1, this.aavb) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aaZf);
      paramInt = i;
      if (this.aaZg != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aaZg);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.Zoz);
      paramInt = i;
      if (this.aaZh != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaZh);
      }
      AppMethodBeat.o(115847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(115847);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dtl localdtl = (dtl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115847);
          return -1;
        case 1: 
          localdtl.aavb = locala.ajGk.readString();
          AppMethodBeat.o(115847);
          return 0;
        case 2: 
          localdtl.aaZf = locala.ajGk.aar();
          AppMethodBeat.o(115847);
          return 0;
        case 3: 
          localdtl.aaZg = locala.ajGk.readString();
          AppMethodBeat.o(115847);
          return 0;
        case 4: 
          localdtl.Zoz = locala.ajGk.aar();
          AppMethodBeat.o(115847);
          return 0;
        }
        localdtl.aaZh = locala.ajGk.readString();
        AppMethodBeat.o(115847);
        return 0;
      }
      AppMethodBeat.o(115847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtl
 * JD-Core Version:    0.7.0.1
 */