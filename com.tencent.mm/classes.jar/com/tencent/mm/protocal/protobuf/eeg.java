package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eeg
  extends com.tencent.mm.bx.a
{
  public String abjn;
  public LinkedList<String> abjo;
  
  public eeg()
  {
    AppMethodBeat.i(260141);
    this.abjo = new LinkedList();
    AppMethodBeat.o(260141);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260146);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abjn != null) {
        paramVarArgs.g(1, this.abjn);
      }
      paramVarArgs.e(2, 1, this.abjo);
      AppMethodBeat.o(260146);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abjn == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.abjn) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 1, this.abjo);
      AppMethodBeat.o(260146);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abjo.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260146);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eeg localeeg = (eeg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260146);
          return -1;
        case 1: 
          localeeg.abjn = locala.ajGk.readString();
          AppMethodBeat.o(260146);
          return 0;
        }
        localeeg.abjo.add(locala.ajGk.readString());
        AppMethodBeat.o(260146);
        return 0;
      }
      AppMethodBeat.o(260146);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eeg
 * JD-Core Version:    0.7.0.1
 */