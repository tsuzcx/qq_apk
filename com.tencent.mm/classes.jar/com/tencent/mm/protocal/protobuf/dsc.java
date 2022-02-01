package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dsc
  extends com.tencent.mm.bx.a
{
  public String EGM;
  public String EGN;
  public String EGO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32562);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EGM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Plugin");
        AppMethodBeat.o(32562);
        throw paramVarArgs;
      }
      if (this.EGN == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActivityPath");
        AppMethodBeat.o(32562);
        throw paramVarArgs;
      }
      if (this.EGM != null) {
        paramVarArgs.d(1, this.EGM);
      }
      if (this.EGN != null) {
        paramVarArgs.d(2, this.EGN);
      }
      if (this.EGO != null) {
        paramVarArgs.d(3, this.EGO);
      }
      AppMethodBeat.o(32562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EGM == null) {
        break label443;
      }
    }
    label443:
    for (int i = f.a.a.b.b.a.e(1, this.EGM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EGN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EGN);
      }
      i = paramInt;
      if (this.EGO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EGO);
      }
      AppMethodBeat.o(32562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EGM == null)
        {
          paramVarArgs = new b("Not all required fields were included: Plugin");
          AppMethodBeat.o(32562);
          throw paramVarArgs;
        }
        if (this.EGN == null)
        {
          paramVarArgs = new b("Not all required fields were included: ActivityPath");
          AppMethodBeat.o(32562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32562);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dsc localdsc = (dsc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32562);
          return -1;
        case 1: 
          localdsc.EGM = locala.KhF.readString();
          AppMethodBeat.o(32562);
          return 0;
        case 2: 
          localdsc.EGN = locala.KhF.readString();
          AppMethodBeat.o(32562);
          return 0;
        }
        localdsc.EGO = locala.KhF.readString();
        AppMethodBeat.o(32562);
        return 0;
      }
      AppMethodBeat.o(32562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsc
 * JD-Core Version:    0.7.0.1
 */