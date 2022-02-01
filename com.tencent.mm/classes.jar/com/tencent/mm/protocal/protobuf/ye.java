package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ye
  extends com.tencent.mm.bw.a
{
  public boolean Lje;
  public String desc;
  public String result;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186344);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.result != null) {
        paramVarArgs.e(3, this.result);
      }
      paramVarArgs.cc(4, this.Lje);
      AppMethodBeat.o(186344);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.result != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.result);
      }
      paramInt = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(186344);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(186344);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ye localye = (ye)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(186344);
          return -1;
        case 1: 
          localye.title = locala.UbS.readString();
          AppMethodBeat.o(186344);
          return 0;
        case 2: 
          localye.desc = locala.UbS.readString();
          AppMethodBeat.o(186344);
          return 0;
        case 3: 
          localye.result = locala.UbS.readString();
          AppMethodBeat.o(186344);
          return 0;
        }
        localye.Lje = locala.UbS.yZ();
        AppMethodBeat.o(186344);
        return 0;
      }
      AppMethodBeat.o(186344);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ye
 * JD-Core Version:    0.7.0.1
 */