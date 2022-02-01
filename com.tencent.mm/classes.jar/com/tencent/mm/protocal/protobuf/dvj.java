package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvj
  extends com.tencent.mm.bx.a
{
  public String iconUrl;
  public String recommendReason;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258786);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.g(1, this.wording);
      }
      if (this.iconUrl != null) {
        paramVarArgs.g(2, this.iconUrl);
      }
      if (this.recommendReason != null) {
        paramVarArgs.g(3, this.recommendReason);
      }
      AppMethodBeat.o(258786);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.wording) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.iconUrl);
      }
      i = paramInt;
      if (this.recommendReason != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.recommendReason);
      }
      AppMethodBeat.o(258786);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258786);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dvj localdvj = (dvj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258786);
          return -1;
        case 1: 
          localdvj.wording = locala.ajGk.readString();
          AppMethodBeat.o(258786);
          return 0;
        case 2: 
          localdvj.iconUrl = locala.ajGk.readString();
          AppMethodBeat.o(258786);
          return 0;
        }
        localdvj.recommendReason = locala.ajGk.readString();
        AppMethodBeat.o(258786);
        return 0;
      }
      AppMethodBeat.o(258786);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvj
 * JD-Core Version:    0.7.0.1
 */