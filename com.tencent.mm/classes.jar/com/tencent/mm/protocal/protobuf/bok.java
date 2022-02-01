package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bok
  extends com.tencent.mm.bx.a
{
  public String doh;
  public String tfH;
  public String tfI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72513);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.doh != null) {
        paramVarArgs.d(1, this.doh);
      }
      if (this.tfH != null) {
        paramVarArgs.d(2, this.tfH);
      }
      if (this.tfI != null) {
        paramVarArgs.d(4, this.tfI);
      }
      AppMethodBeat.o(72513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.doh == null) {
        break label338;
      }
    }
    label338:
    for (int i = f.a.a.b.b.a.e(1, this.doh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tfH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tfH);
      }
      i = paramInt;
      if (this.tfI != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.tfI);
      }
      AppMethodBeat.o(72513);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72513);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bok localbok = (bok)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          AppMethodBeat.o(72513);
          return -1;
        case 1: 
          localbok.doh = locala.KhF.readString();
          AppMethodBeat.o(72513);
          return 0;
        case 2: 
          localbok.tfH = locala.KhF.readString();
          AppMethodBeat.o(72513);
          return 0;
        }
        localbok.tfI = locala.KhF.readString();
        AppMethodBeat.o(72513);
        return 0;
      }
      AppMethodBeat.o(72513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bok
 * JD-Core Version:    0.7.0.1
 */