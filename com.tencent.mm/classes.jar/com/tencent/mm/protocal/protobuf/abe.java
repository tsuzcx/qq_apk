package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class abe
  extends com.tencent.mm.bx.a
{
  public String MEz;
  public String Omk;
  public int ZjH;
  public String title;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72459);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      if (this.MEz != null) {
        paramVarArgs.g(3, this.MEz);
      }
      if (this.Omk != null) {
        paramVarArgs.g(4, this.Omk);
      }
      paramVarArgs.bS(5, this.ZjH);
      AppMethodBeat.o(72459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label434;
      }
    }
    label434:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = paramInt;
      if (this.MEz != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.MEz);
      }
      paramInt = i;
      if (this.Omk != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Omk);
      }
      i = i.a.a.b.b.a.cJ(5, this.ZjH);
      AppMethodBeat.o(72459);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72459);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        abe localabe = (abe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72459);
          return -1;
        case 1: 
          localabe.title = locala.ajGk.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 2: 
          localabe.wording = locala.ajGk.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 3: 
          localabe.MEz = locala.ajGk.readString();
          AppMethodBeat.o(72459);
          return 0;
        case 4: 
          localabe.Omk = locala.ajGk.readString();
          AppMethodBeat.o(72459);
          return 0;
        }
        localabe.ZjH = locala.ajGk.aar();
        AppMethodBeat.o(72459);
        return 0;
      }
      AppMethodBeat.o(72459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abe
 * JD-Core Version:    0.7.0.1
 */