package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bj
  extends com.tencent.mm.bx.a
{
  public String VcU;
  public String VcV;
  public String text;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113932);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.text != null) {
        paramVarArgs.g(1, this.text);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.VcU != null) {
        paramVarArgs.g(3, this.VcU);
      }
      if (this.VcV != null) {
        paramVarArgs.g(4, this.VcV);
      }
      AppMethodBeat.o(113932);
      return 0;
    }
    if (paramInt == 1) {
      if (this.text == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.text) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.VcU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.VcU);
      }
      paramInt = i;
      if (this.VcV != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.VcV);
      }
      AppMethodBeat.o(113932);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113932);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bj localbj = (bj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113932);
          return -1;
        case 1: 
          localbj.text = locala.ajGk.readString();
          AppMethodBeat.o(113932);
          return 0;
        case 2: 
          localbj.url = locala.ajGk.readString();
          AppMethodBeat.o(113932);
          return 0;
        case 3: 
          localbj.VcU = locala.ajGk.readString();
          AppMethodBeat.o(113932);
          return 0;
        }
        localbj.VcV = locala.ajGk.readString();
        AppMethodBeat.o(113932);
        return 0;
      }
      AppMethodBeat.o(113932);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bj
 * JD-Core Version:    0.7.0.1
 */