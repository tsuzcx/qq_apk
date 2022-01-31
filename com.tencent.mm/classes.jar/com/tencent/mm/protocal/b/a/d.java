package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bv.a
{
  public int cED;
  public String desc;
  public String mxW;
  public String thumbPath;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111122);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.thumbPath != null) {
        paramVarArgs.e(3, this.thumbPath);
      }
      paramVarArgs.aO(4, this.cED);
      if (this.mxW != null) {
        paramVarArgs.e(5, this.mxW);
      }
      AppMethodBeat.o(111122);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label438;
      }
    }
    label438:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.thumbPath != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.thumbPath);
      }
      i += e.a.a.b.b.a.bl(4, this.cED);
      paramInt = i;
      if (this.mxW != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.mxW);
      }
      AppMethodBeat.o(111122);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111122);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111122);
          return -1;
        case 1: 
          locald.title = locala.CLY.readString();
          AppMethodBeat.o(111122);
          return 0;
        case 2: 
          locald.desc = locala.CLY.readString();
          AppMethodBeat.o(111122);
          return 0;
        case 3: 
          locald.thumbPath = locala.CLY.readString();
          AppMethodBeat.o(111122);
          return 0;
        case 4: 
          locald.cED = locala.CLY.sl();
          AppMethodBeat.o(111122);
          return 0;
        }
        locald.mxW = locala.CLY.readString();
        AppMethodBeat.o(111122);
        return 0;
      }
      AppMethodBeat.o(111122);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.d
 * JD-Core Version:    0.7.0.1
 */