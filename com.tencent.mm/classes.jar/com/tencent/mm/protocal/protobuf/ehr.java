package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehr
  extends com.tencent.mm.bx.a
{
  public boolean abmL;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91635);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      paramVarArgs.di(3, this.abmL);
      AppMethodBeat.o(91635);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.url);
      }
      paramInt = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(91635);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91635);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ehr localehr = (ehr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91635);
          return -1;
        case 1: 
          localehr.title = locala.ajGk.readString();
          AppMethodBeat.o(91635);
          return 0;
        case 2: 
          localehr.url = locala.ajGk.readString();
          AppMethodBeat.o(91635);
          return 0;
        }
        localehr.abmL = locala.ajGk.aai();
        AppMethodBeat.o(91635);
        return 0;
      }
      AppMethodBeat.o(91635);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehr
 * JD-Core Version:    0.7.0.1
 */