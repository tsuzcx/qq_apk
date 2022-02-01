package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gy
  extends com.tencent.mm.bx.a
{
  public String doh;
  public String omO;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123552);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.doh != null) {
        paramVarArgs.d(1, this.doh);
      }
      if (this.omO != null) {
        paramVarArgs.d(2, this.omO);
      }
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      AppMethodBeat.o(123552);
      return 0;
    }
    if (paramInt == 1) {
      if (this.doh == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.doh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.omO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.omO);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.title);
      }
      AppMethodBeat.o(123552);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123552);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        gy localgy = (gy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123552);
          return -1;
        case 1: 
          localgy.doh = locala.KhF.readString();
          AppMethodBeat.o(123552);
          return 0;
        case 2: 
          localgy.omO = locala.KhF.readString();
          AppMethodBeat.o(123552);
          return 0;
        }
        localgy.title = locala.KhF.readString();
        AppMethodBeat.o(123552);
        return 0;
      }
      AppMethodBeat.o(123552);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gy
 * JD-Core Version:    0.7.0.1
 */