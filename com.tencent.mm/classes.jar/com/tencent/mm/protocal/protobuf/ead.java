package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ead
  extends com.tencent.mm.bx.a
{
  public boolean GDi;
  public boolean abfk = false;
  public String abfl;
  public int cHb = 0;
  public long endTime = 0L;
  public String hJW = "";
  public String hQR = "";
  public int hQm = -1;
  public String qkQ = "";
  public long seq = 0L;
  public long startTime = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122521);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hQR != null) {
        paramVarArgs.g(1, this.hQR);
      }
      paramVarArgs.di(2, this.abfk);
      paramVarArgs.bv(3, this.seq);
      paramVarArgs.bv(4, this.startTime);
      paramVarArgs.bv(5, this.endTime);
      paramVarArgs.bS(6, this.hQm);
      if (this.hJW != null) {
        paramVarArgs.g(7, this.hJW);
      }
      paramVarArgs.bS(8, this.cHb);
      if (this.abfl != null) {
        paramVarArgs.g(9, this.abfl);
      }
      paramVarArgs.di(10, this.GDi);
      if (this.qkQ != null) {
        paramVarArgs.g(11, this.qkQ);
      }
      AppMethodBeat.o(122521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hQR == null) {
        break label698;
      }
    }
    label698:
    for (paramInt = i.a.a.b.b.a.h(1, this.hQR) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1) + i.a.a.b.b.a.q(3, this.seq) + i.a.a.b.b.a.q(4, this.startTime) + i.a.a.b.b.a.q(5, this.endTime) + i.a.a.b.b.a.cJ(6, this.hQm);
      paramInt = i;
      if (this.hJW != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.hJW);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.cHb);
      paramInt = i;
      if (this.abfl != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abfl);
      }
      i = paramInt + (i.a.a.b.b.a.ko(10) + 1);
      paramInt = i;
      if (this.qkQ != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.qkQ);
      }
      AppMethodBeat.o(122521);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122521);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ead localead = (ead)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122521);
          return -1;
        case 1: 
          localead.hQR = locala.ajGk.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 2: 
          localead.abfk = locala.ajGk.aai();
          AppMethodBeat.o(122521);
          return 0;
        case 3: 
          localead.seq = locala.ajGk.aaw();
          AppMethodBeat.o(122521);
          return 0;
        case 4: 
          localead.startTime = locala.ajGk.aaw();
          AppMethodBeat.o(122521);
          return 0;
        case 5: 
          localead.endTime = locala.ajGk.aaw();
          AppMethodBeat.o(122521);
          return 0;
        case 6: 
          localead.hQm = locala.ajGk.aar();
          AppMethodBeat.o(122521);
          return 0;
        case 7: 
          localead.hJW = locala.ajGk.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 8: 
          localead.cHb = locala.ajGk.aar();
          AppMethodBeat.o(122521);
          return 0;
        case 9: 
          localead.abfl = locala.ajGk.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 10: 
          localead.GDi = locala.ajGk.aai();
          AppMethodBeat.o(122521);
          return 0;
        }
        localead.qkQ = locala.ajGk.readString();
        AppMethodBeat.o(122521);
        return 0;
      }
      AppMethodBeat.o(122521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ead
 * JD-Core Version:    0.7.0.1
 */