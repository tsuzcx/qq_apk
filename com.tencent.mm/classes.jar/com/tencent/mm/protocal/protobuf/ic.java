package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ic
  extends com.tencent.mm.bw.a
{
  public String AZE;
  public String AZF;
  public String BnF;
  public String title;
  public int vjP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91354);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      paramVarArgs.aR(2, this.vjP);
      if (this.BnF != null) {
        paramVarArgs.d(3, this.BnF);
      }
      if (this.AZE != null) {
        paramVarArgs.d(4, this.AZE);
      }
      if (this.AZF != null) {
        paramVarArgs.d(5, this.AZF);
      }
      AppMethodBeat.o(91354);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.vjP);
      paramInt = i;
      if (this.BnF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.BnF);
      }
      i = paramInt;
      if (this.AZE != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.AZE);
      }
      paramInt = i;
      if (this.AZF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.AZF);
      }
      AppMethodBeat.o(91354);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91354);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ic localic = (ic)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91354);
          return -1;
        case 1: 
          localic.title = locala.LVo.readString();
          AppMethodBeat.o(91354);
          return 0;
        case 2: 
          localic.vjP = locala.LVo.xF();
          AppMethodBeat.o(91354);
          return 0;
        case 3: 
          localic.BnF = locala.LVo.readString();
          AppMethodBeat.o(91354);
          return 0;
        case 4: 
          localic.AZE = locala.LVo.readString();
          AppMethodBeat.o(91354);
          return 0;
        }
        localic.AZF = locala.LVo.readString();
        AppMethodBeat.o(91354);
        return 0;
      }
      AppMethodBeat.o(91354);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ic
 * JD-Core Version:    0.7.0.1
 */