package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class efk
  extends com.tencent.mm.bw.a
{
  public String Ijl;
  public String Ijm;
  public String Ijn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32562);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ijl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Plugin");
        AppMethodBeat.o(32562);
        throw paramVarArgs;
      }
      if (this.Ijm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActivityPath");
        AppMethodBeat.o(32562);
        throw paramVarArgs;
      }
      if (this.Ijl != null) {
        paramVarArgs.d(1, this.Ijl);
      }
      if (this.Ijm != null) {
        paramVarArgs.d(2, this.Ijm);
      }
      if (this.Ijn != null) {
        paramVarArgs.d(3, this.Ijn);
      }
      AppMethodBeat.o(32562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ijl == null) {
        break label443;
      }
    }
    label443:
    for (int i = f.a.a.b.b.a.e(1, this.Ijl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ijm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ijm);
      }
      i = paramInt;
      if (this.Ijn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ijn);
      }
      AppMethodBeat.o(32562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Ijl == null)
        {
          paramVarArgs = new b("Not all required fields were included: Plugin");
          AppMethodBeat.o(32562);
          throw paramVarArgs;
        }
        if (this.Ijm == null)
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
        efk localefk = (efk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32562);
          return -1;
        case 1: 
          localefk.Ijl = locala.OmT.readString();
          AppMethodBeat.o(32562);
          return 0;
        case 2: 
          localefk.Ijm = locala.OmT.readString();
          AppMethodBeat.o(32562);
          return 0;
        }
        localefk.Ijn = locala.OmT.readString();
        AppMethodBeat.o(32562);
        return 0;
      }
      AppMethodBeat.o(32562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efk
 * JD-Core Version:    0.7.0.1
 */