package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gm
  extends com.tencent.mm.bx.a
{
  public String YIf;
  public int YIg;
  public int YIh;
  public long YIi;
  public int YIj;
  public int idx;
  public long nVr;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124388);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YIf != null) {
        paramVarArgs.g(1, this.YIf);
      }
      paramVarArgs.bv(2, this.nVr);
      paramVarArgs.bS(3, this.idx);
      paramVarArgs.bS(4, this.YIg);
      paramVarArgs.bS(5, this.YIh);
      paramVarArgs.bv(6, this.YIi);
      paramVarArgs.bS(7, this.YIj);
      if (this.url != null) {
        paramVarArgs.g(8, this.url);
      }
      AppMethodBeat.o(124388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YIf == null) {
        break label530;
      }
    }
    label530:
    for (paramInt = i.a.a.b.b.a.h(1, this.YIf) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.nVr) + i.a.a.b.b.a.cJ(3, this.idx) + i.a.a.b.b.a.cJ(4, this.YIg) + i.a.a.b.b.a.cJ(5, this.YIh) + i.a.a.b.b.a.q(6, this.YIi) + i.a.a.b.b.a.cJ(7, this.YIj);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.url);
      }
      AppMethodBeat.o(124388);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124388);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gm localgm = (gm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124388);
          return -1;
        case 1: 
          localgm.YIf = locala.ajGk.readString();
          AppMethodBeat.o(124388);
          return 0;
        case 2: 
          localgm.nVr = locala.ajGk.aaw();
          AppMethodBeat.o(124388);
          return 0;
        case 3: 
          localgm.idx = locala.ajGk.aar();
          AppMethodBeat.o(124388);
          return 0;
        case 4: 
          localgm.YIg = locala.ajGk.aar();
          AppMethodBeat.o(124388);
          return 0;
        case 5: 
          localgm.YIh = locala.ajGk.aar();
          AppMethodBeat.o(124388);
          return 0;
        case 6: 
          localgm.YIi = locala.ajGk.aaw();
          AppMethodBeat.o(124388);
          return 0;
        case 7: 
          localgm.YIj = locala.ajGk.aar();
          AppMethodBeat.o(124388);
          return 0;
        }
        localgm.url = locala.ajGk.readString();
        AppMethodBeat.o(124388);
        return 0;
      }
      AppMethodBeat.o(124388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gm
 * JD-Core Version:    0.7.0.1
 */