package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfw
  extends com.tencent.mm.bx.a
{
  public boolean ZPG;
  public String image;
  public long seq;
  public String text;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258255);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.text != null) {
        paramVarArgs.g(1, this.text);
      }
      if (this.image != null) {
        paramVarArgs.g(2, this.image);
      }
      paramVarArgs.di(3, this.ZPG);
      paramVarArgs.bv(4, this.seq);
      AppMethodBeat.o(258255);
      return 0;
    }
    if (paramInt == 1) {
      if (this.text == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = i.a.a.b.b.a.h(1, this.text) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.image != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.image);
      }
      paramInt = i.a.a.b.b.a.ko(3);
      int j = i.a.a.b.b.a.q(4, this.seq);
      AppMethodBeat.o(258255);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258255);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bfw localbfw = (bfw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258255);
          return -1;
        case 1: 
          localbfw.text = locala.ajGk.readString();
          AppMethodBeat.o(258255);
          return 0;
        case 2: 
          localbfw.image = locala.ajGk.readString();
          AppMethodBeat.o(258255);
          return 0;
        case 3: 
          localbfw.ZPG = locala.ajGk.aai();
          AppMethodBeat.o(258255);
          return 0;
        }
        localbfw.seq = locala.ajGk.aaw();
        AppMethodBeat.o(258255);
        return 0;
      }
      AppMethodBeat.o(258255);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfw
 * JD-Core Version:    0.7.0.1
 */