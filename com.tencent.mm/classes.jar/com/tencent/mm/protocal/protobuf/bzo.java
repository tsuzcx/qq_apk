package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzo
  extends com.tencent.mm.bw.a
{
  public String CellTitle;
  public String Mfh;
  public String Mfi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152609);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CellTitle != null) {
        paramVarArgs.e(1, this.CellTitle);
      }
      if (this.Mfh != null) {
        paramVarArgs.e(2, this.Mfh);
      }
      if (this.Mfi != null) {
        paramVarArgs.e(3, this.Mfi);
      }
      AppMethodBeat.o(152609);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CellTitle == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.CellTitle) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mfh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Mfh);
      }
      i = paramInt;
      if (this.Mfi != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mfi);
      }
      AppMethodBeat.o(152609);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152609);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bzo localbzo = (bzo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152609);
          return -1;
        case 1: 
          localbzo.CellTitle = locala.UbS.readString();
          AppMethodBeat.o(152609);
          return 0;
        case 2: 
          localbzo.Mfh = locala.UbS.readString();
          AppMethodBeat.o(152609);
          return 0;
        }
        localbzo.Mfi = locala.UbS.readString();
        AppMethodBeat.o(152609);
        return 0;
      }
      AppMethodBeat.o(152609);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzo
 * JD-Core Version:    0.7.0.1
 */