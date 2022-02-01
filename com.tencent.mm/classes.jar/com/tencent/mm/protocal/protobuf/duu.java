package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class duu
  extends com.tencent.mm.cd.a
{
  public String Uba;
  public String Ubb;
  public String Ubc;
  public String background_color;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207772);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.f(1, this.wording);
      }
      if (this.Uba != null) {
        paramVarArgs.f(2, this.Uba);
      }
      if (this.background_color != null) {
        paramVarArgs.f(3, this.background_color);
      }
      if (this.Ubb != null) {
        paramVarArgs.f(4, this.Ubb);
      }
      if (this.Ubc != null) {
        paramVarArgs.f(5, this.Ubc);
      }
      AppMethodBeat.o(207772);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.g(1, this.wording) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Uba != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Uba);
      }
      i = paramInt;
      if (this.background_color != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.background_color);
      }
      paramInt = i;
      if (this.Ubb != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Ubb);
      }
      i = paramInt;
      if (this.Ubc != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Ubc);
      }
      AppMethodBeat.o(207772);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(207772);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        duu localduu = (duu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207772);
          return -1;
        case 1: 
          localduu.wording = locala.abFh.readString();
          AppMethodBeat.o(207772);
          return 0;
        case 2: 
          localduu.Uba = locala.abFh.readString();
          AppMethodBeat.o(207772);
          return 0;
        case 3: 
          localduu.background_color = locala.abFh.readString();
          AppMethodBeat.o(207772);
          return 0;
        case 4: 
          localduu.Ubb = locala.abFh.readString();
          AppMethodBeat.o(207772);
          return 0;
        }
        localduu.Ubc = locala.abFh.readString();
        AppMethodBeat.o(207772);
        return 0;
      }
      AppMethodBeat.o(207772);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duu
 * JD-Core Version:    0.7.0.1
 */