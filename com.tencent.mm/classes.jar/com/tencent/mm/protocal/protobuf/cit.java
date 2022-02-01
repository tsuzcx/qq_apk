package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class cit
  extends com.tencent.mm.bx.a
{
  public String Md5;
  public String Ztx;
  public String aaro;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104789);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaro == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActivityId");
        AppMethodBeat.o(104789);
        throw paramVarArgs;
      }
      if (this.aaro != null) {
        paramVarArgs.g(1, this.aaro);
      }
      if (this.Md5 != null) {
        paramVarArgs.g(2, this.Md5);
      }
      if (this.Ztx != null) {
        paramVarArgs.g(3, this.Ztx);
      }
      AppMethodBeat.o(104789);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaro == null) {
        break label378;
      }
    }
    label378:
    for (int i = i.a.a.b.b.a.h(1, this.aaro) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Md5);
      }
      i = paramInt;
      if (this.Ztx != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Ztx);
      }
      AppMethodBeat.o(104789);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aaro == null)
        {
          paramVarArgs = new b("Not all required fields were included: ActivityId");
          AppMethodBeat.o(104789);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104789);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cit localcit = (cit)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104789);
          return -1;
        case 1: 
          localcit.aaro = locala.ajGk.readString();
          AppMethodBeat.o(104789);
          return 0;
        case 2: 
          localcit.Md5 = locala.ajGk.readString();
          AppMethodBeat.o(104789);
          return 0;
        }
        localcit.Ztx = locala.ajGk.readString();
        AppMethodBeat.o(104789);
        return 0;
      }
      AppMethodBeat.o(104789);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cit
 * JD-Core Version:    0.7.0.1
 */