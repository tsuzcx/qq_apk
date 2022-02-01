package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Html5Info
  extends com.tencent.mm.bx.a
{
  public int height_percent;
  public int style;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258660);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      paramVarArgs.bS(2, this.style);
      paramVarArgs.bS(3, this.height_percent);
      AppMethodBeat.o(258660);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.url) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.style);
      int j = i.a.a.b.b.a.cJ(3, this.height_percent);
      AppMethodBeat.o(258660);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258660);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        Html5Info localHtml5Info = (Html5Info)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258660);
          return -1;
        case 1: 
          localHtml5Info.url = locala.ajGk.readString();
          AppMethodBeat.o(258660);
          return 0;
        case 2: 
          localHtml5Info.style = locala.ajGk.aar();
          AppMethodBeat.o(258660);
          return 0;
        }
        localHtml5Info.height_percent = locala.ajGk.aar();
        AppMethodBeat.o(258660);
        return 0;
      }
      AppMethodBeat.o(258660);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.Html5Info
 * JD-Core Version:    0.7.0.1
 */