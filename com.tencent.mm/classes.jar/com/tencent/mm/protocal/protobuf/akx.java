package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class akx
  extends com.tencent.mm.bw.a
{
  public String AUt;
  public String GCo;
  public int cao;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.AUt == null)
      {
        paramVarArgs = new b("Not all required fields were included: tagName");
        AppMethodBeat.o(127485);
        throw paramVarArgs;
      }
      if (this.GCo == null)
      {
        paramVarArgs = new b("Not all required fields were included: tagPinYin");
        AppMethodBeat.o(127485);
        throw paramVarArgs;
      }
      if (this.AUt != null) {
        paramVarArgs.d(1, this.AUt);
      }
      if (this.GCo != null) {
        paramVarArgs.d(2, this.GCo);
      }
      paramVarArgs.aS(3, this.cao);
      AppMethodBeat.o(127485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.AUt == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = f.a.a.b.b.a.e(1, this.AUt) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GCo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GCo);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.cao);
      AppMethodBeat.o(127485);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.AUt == null)
        {
          paramVarArgs = new b("Not all required fields were included: tagName");
          AppMethodBeat.o(127485);
          throw paramVarArgs;
        }
        if (this.GCo == null)
        {
          paramVarArgs = new b("Not all required fields were included: tagPinYin");
          AppMethodBeat.o(127485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127485);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        akx localakx = (akx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127485);
          return -1;
        case 1: 
          localakx.AUt = locala.OmT.readString();
          AppMethodBeat.o(127485);
          return 0;
        case 2: 
          localakx.GCo = locala.OmT.readString();
          AppMethodBeat.o(127485);
          return 0;
        }
        localakx.cao = locala.OmT.zc();
        AppMethodBeat.o(127485);
        return 0;
      }
      AppMethodBeat.o(127485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akx
 * JD-Core Version:    0.7.0.1
 */