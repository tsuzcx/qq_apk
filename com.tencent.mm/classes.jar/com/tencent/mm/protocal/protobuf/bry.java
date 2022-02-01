package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bry
  extends com.tencent.mm.bx.a
{
  public String DAV;
  public String DAW;
  public String DyR;
  public String dnK;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123628);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DyR != null) {
        paramVarArgs.d(1, this.DyR);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.dnK != null) {
        paramVarArgs.d(3, this.dnK);
      }
      if (this.DAV != null) {
        paramVarArgs.d(4, this.DAV);
      }
      if (this.DAW != null) {
        paramVarArgs.d(5, this.DAW);
      }
      AppMethodBeat.o(123628);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DyR == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.DyR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.dnK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dnK);
      }
      paramInt = i;
      if (this.DAV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DAV);
      }
      i = paramInt;
      if (this.DAW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DAW);
      }
      AppMethodBeat.o(123628);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123628);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bry localbry = (bry)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123628);
          return -1;
        case 1: 
          localbry.DyR = locala.KhF.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 2: 
          localbry.url = locala.KhF.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 3: 
          localbry.dnK = locala.KhF.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 4: 
          localbry.DAV = locala.KhF.readString();
          AppMethodBeat.o(123628);
          return 0;
        }
        localbry.DAW = locala.KhF.readString();
        AppMethodBeat.o(123628);
        return 0;
      }
      AppMethodBeat.o(123628);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bry
 * JD-Core Version:    0.7.0.1
 */