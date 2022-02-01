package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class eeg
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> GqN;
  public String key;
  
  public eeg()
  {
    AppMethodBeat.i(209608);
    this.GqN = new LinkedList();
    AppMethodBeat.o(209608);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209609);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(209609);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      paramVarArgs.e(2, 1, this.GqN);
      AppMethodBeat.o(209609);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(1, this.key) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.GqN);
      AppMethodBeat.o(209609);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GqN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(209609);
          throw paramVarArgs;
        }
        AppMethodBeat.o(209609);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eeg localeeg = (eeg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209609);
          return -1;
        case 1: 
          localeeg.key = locala.NPN.readString();
          AppMethodBeat.o(209609);
          return 0;
        }
        localeeg.GqN.add(locala.NPN.readString());
        AppMethodBeat.o(209609);
        return 0;
      }
      AppMethodBeat.o(209609);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eeg
 * JD-Core Version:    0.7.0.1
 */