package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bw.a
{
  public String desc;
  public int dsR;
  public String qNY;
  public String thumbPath;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94810);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.thumbPath != null) {
        paramVarArgs.d(3, this.thumbPath);
      }
      paramVarArgs.aR(4, this.dsR);
      if (this.qNY != null) {
        paramVarArgs.d(5, this.qNY);
      }
      AppMethodBeat.o(94810);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.thumbPath != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.thumbPath);
      }
      i += f.a.a.b.b.a.bx(4, this.dsR);
      paramInt = i;
      if (this.qNY != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.qNY);
      }
      AppMethodBeat.o(94810);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(94810);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94810);
          return -1;
        case 1: 
          locald.title = locala.LVo.readString();
          AppMethodBeat.o(94810);
          return 0;
        case 2: 
          locald.desc = locala.LVo.readString();
          AppMethodBeat.o(94810);
          return 0;
        case 3: 
          locald.thumbPath = locala.LVo.readString();
          AppMethodBeat.o(94810);
          return 0;
        case 4: 
          locald.dsR = locala.LVo.xF();
          AppMethodBeat.o(94810);
          return 0;
        }
        locald.qNY = locala.LVo.readString();
        AppMethodBeat.o(94810);
        return 0;
      }
      AppMethodBeat.o(94810);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.d
 * JD-Core Version:    0.7.0.1
 */