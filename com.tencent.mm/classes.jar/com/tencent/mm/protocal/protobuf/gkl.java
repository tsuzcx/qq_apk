package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class gkl
  extends com.tencent.mm.bx.a
{
  public long OCY;
  public int Tqb;
  public boolean acgp;
  public String acgq;
  public int update_time;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123692);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      paramVarArgs.bS(2, this.update_time);
      paramVarArgs.bS(3, this.Tqb);
      paramVarArgs.bv(4, this.OCY);
      paramVarArgs.di(5, this.acgp);
      if (this.acgq != null) {
        paramVarArgs.g(6, this.acgq);
      }
      AppMethodBeat.o(123692);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label442;
      }
    }
    label442:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.update_time) + i.a.a.b.b.a.cJ(3, this.Tqb) + i.a.a.b.b.a.q(4, this.OCY) + (i.a.a.b.b.a.ko(5) + 1);
      paramInt = i;
      if (this.acgq != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.acgq);
      }
      AppMethodBeat.o(123692);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123692);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gkl localgkl = (gkl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123692);
          return -1;
        case 1: 
          localgkl.username = locala.ajGk.readString();
          AppMethodBeat.o(123692);
          return 0;
        case 2: 
          localgkl.update_time = locala.ajGk.aar();
          AppMethodBeat.o(123692);
          return 0;
        case 3: 
          localgkl.Tqb = locala.ajGk.aar();
          AppMethodBeat.o(123692);
          return 0;
        case 4: 
          localgkl.OCY = locala.ajGk.aaw();
          AppMethodBeat.o(123692);
          return 0;
        case 5: 
          localgkl.acgp = locala.ajGk.aai();
          AppMethodBeat.o(123692);
          return 0;
        }
        localgkl.acgq = locala.ajGk.readString();
        AppMethodBeat.o(123692);
        return 0;
      }
      AppMethodBeat.o(123692);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gkl
 * JD-Core Version:    0.7.0.1
 */