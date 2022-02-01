package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eny
  extends com.tencent.mm.bx.a
{
  public String DVu;
  public long YUq;
  public String YUu;
  public String absq;
  public int eQp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259764);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.DVu != null) {
        paramVarArgs.g(1, this.DVu);
      }
      paramVarArgs.bv(2, this.YUq);
      paramVarArgs.bS(3, this.eQp);
      if (this.YUu != null) {
        paramVarArgs.g(4, this.YUu);
      }
      if (this.absq != null) {
        paramVarArgs.g(5, this.absq);
      }
      AppMethodBeat.o(259764);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DVu == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.b.b.a.h(1, this.DVu) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.YUq) + i.a.a.b.b.a.cJ(3, this.eQp);
      paramInt = i;
      if (this.YUu != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YUu);
      }
      i = paramInt;
      if (this.absq != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.absq);
      }
      AppMethodBeat.o(259764);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259764);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eny localeny = (eny)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259764);
          return -1;
        case 1: 
          localeny.DVu = locala.ajGk.readString();
          AppMethodBeat.o(259764);
          return 0;
        case 2: 
          localeny.YUq = locala.ajGk.aaw();
          AppMethodBeat.o(259764);
          return 0;
        case 3: 
          localeny.eQp = locala.ajGk.aar();
          AppMethodBeat.o(259764);
          return 0;
        case 4: 
          localeny.YUu = locala.ajGk.readString();
          AppMethodBeat.o(259764);
          return 0;
        }
        localeny.absq = locala.ajGk.readString();
        AppMethodBeat.o(259764);
        return 0;
      }
      AppMethodBeat.o(259764);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eny
 * JD-Core Version:    0.7.0.1
 */