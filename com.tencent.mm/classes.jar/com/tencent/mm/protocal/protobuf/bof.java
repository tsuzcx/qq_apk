package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bof
  extends com.tencent.mm.bx.a
{
  public String id;
  public String oyb;
  public long timestamp;
  public String xVb;
  public String xVc;
  public int xVd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72499);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      if (this.xVb != null) {
        paramVarArgs.d(2, this.xVb);
      }
      if (this.xVc != null) {
        paramVarArgs.d(3, this.xVc);
      }
      if (this.oyb != null) {
        paramVarArgs.d(4, this.oyb);
      }
      paramVarArgs.aY(6, this.timestamp);
      paramVarArgs.aS(5, this.xVd);
      AppMethodBeat.o(72499);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label486;
      }
    }
    label486:
    for (int i = f.a.a.b.b.a.e(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xVb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xVb);
      }
      i = paramInt;
      if (this.xVc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.xVc);
      }
      paramInt = i;
      if (this.oyb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oyb);
      }
      i = f.a.a.b.b.a.p(6, this.timestamp);
      int j = f.a.a.b.b.a.bz(5, this.xVd);
      AppMethodBeat.o(72499);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72499);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bof localbof = (bof)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72499);
          return -1;
        case 1: 
          localbof.id = locala.NPN.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 2: 
          localbof.xVb = locala.NPN.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 3: 
          localbof.xVc = locala.NPN.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 4: 
          localbof.oyb = locala.NPN.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 6: 
          localbof.timestamp = locala.NPN.zd();
          AppMethodBeat.o(72499);
          return 0;
        }
        localbof.xVd = locala.NPN.zc();
        AppMethodBeat.o(72499);
        return 0;
      }
      AppMethodBeat.o(72499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bof
 * JD-Core Version:    0.7.0.1
 */