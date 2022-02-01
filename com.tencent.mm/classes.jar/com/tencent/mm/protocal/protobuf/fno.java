package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class fno
  extends com.tencent.mm.cd.a
{
  public int RYL;
  public long ULV;
  public boolean ULW;
  public String ULX;
  public int update_time;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123692);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      paramVarArgs.aY(2, this.update_time);
      paramVarArgs.aY(3, this.RYL);
      paramVarArgs.bm(4, this.ULV);
      paramVarArgs.co(5, this.ULW);
      if (this.ULX != null) {
        paramVarArgs.f(6, this.ULX);
      }
      AppMethodBeat.o(123692);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = g.a.a.b.b.a.g(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.update_time) + g.a.a.b.b.a.bM(3, this.RYL) + g.a.a.b.b.a.p(4, this.ULV) + (g.a.a.b.b.a.gL(5) + 1);
      paramInt = i;
      if (this.ULX != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.ULX);
      }
      AppMethodBeat.o(123692);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123692);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fno localfno = (fno)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123692);
          return -1;
        case 1: 
          localfno.username = locala.abFh.readString();
          AppMethodBeat.o(123692);
          return 0;
        case 2: 
          localfno.update_time = locala.abFh.AK();
          AppMethodBeat.o(123692);
          return 0;
        case 3: 
          localfno.RYL = locala.abFh.AK();
          AppMethodBeat.o(123692);
          return 0;
        case 4: 
          localfno.ULV = locala.abFh.AN();
          AppMethodBeat.o(123692);
          return 0;
        case 5: 
          localfno.ULW = locala.abFh.AB();
          AppMethodBeat.o(123692);
          return 0;
        }
        localfno.ULX = locala.abFh.readString();
        AppMethodBeat.o(123692);
        return 0;
      }
      AppMethodBeat.o(123692);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fno
 * JD-Core Version:    0.7.0.1
 */