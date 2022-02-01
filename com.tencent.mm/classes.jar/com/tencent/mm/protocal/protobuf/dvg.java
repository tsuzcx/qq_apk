package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvg
  extends com.tencent.mm.bw.a
{
  public String FTK;
  public String GcK;
  public String GcL;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91726);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.GcK != null) {
        paramVarArgs.d(2, this.GcK);
      }
      if (this.FTK != null) {
        paramVarArgs.d(3, this.FTK);
      }
      if (this.GcL != null) {
        paramVarArgs.d(4, this.GcL);
      }
      AppMethodBeat.o(91726);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GcK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GcK);
      }
      i = paramInt;
      if (this.FTK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FTK);
      }
      paramInt = i;
      if (this.GcL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GcL);
      }
      AppMethodBeat.o(91726);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91726);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvg localdvg = (dvg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91726);
          return -1;
        case 1: 
          localdvg.title = locala.LVo.readString();
          AppMethodBeat.o(91726);
          return 0;
        case 2: 
          localdvg.GcK = locala.LVo.readString();
          AppMethodBeat.o(91726);
          return 0;
        case 3: 
          localdvg.FTK = locala.LVo.readString();
          AppMethodBeat.o(91726);
          return 0;
        }
        localdvg.GcL = locala.LVo.readString();
        AppMethodBeat.o(91726);
        return 0;
      }
      AppMethodBeat.o(91726);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvg
 * JD-Core Version:    0.7.0.1
 */