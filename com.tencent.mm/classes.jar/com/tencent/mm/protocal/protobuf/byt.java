package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byt
  extends com.tencent.mm.bx.a
{
  public long DVB;
  public String url;
  public String wdN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72541);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wdN != null) {
        paramVarArgs.d(1, this.wdN);
      }
      paramVarArgs.aG(2, this.DVB);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      AppMethodBeat.o(72541);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wdN == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.wdN) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.DVB);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      AppMethodBeat.o(72541);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72541);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        byt localbyt = (byt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72541);
          return -1;
        case 1: 
          localbyt.wdN = locala.KhF.readString();
          AppMethodBeat.o(72541);
          return 0;
        case 2: 
          localbyt.DVB = locala.KhF.xT();
          AppMethodBeat.o(72541);
          return 0;
        }
        localbyt.url = locala.KhF.readString();
        AppMethodBeat.o(72541);
        return 0;
      }
      AppMethodBeat.o(72541);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byt
 * JD-Core Version:    0.7.0.1
 */