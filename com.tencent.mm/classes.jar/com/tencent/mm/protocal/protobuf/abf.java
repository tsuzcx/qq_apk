package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class abf
  extends com.tencent.mm.bw.a
{
  public String id;
  public boolean sDg = true;
  public long timestamp;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196244);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id == null)
      {
        paramVarArgs = new b("Not all required fields were included: id");
        AppMethodBeat.o(196244);
        throw paramVarArgs;
      }
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      paramVarArgs.aZ(2, this.timestamp);
      paramVarArgs.aS(3, this.type);
      paramVarArgs.bC(4, this.sDg);
      AppMethodBeat.o(196244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label394;
      }
    }
    label394:
    for (paramInt = f.a.a.b.b.a.e(1, this.id) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.timestamp);
      int j = f.a.a.b.b.a.bz(3, this.type);
      int k = f.a.a.b.b.a.amF(4);
      AppMethodBeat.o(196244);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.id == null)
        {
          paramVarArgs = new b("Not all required fields were included: id");
          AppMethodBeat.o(196244);
          throw paramVarArgs;
        }
        AppMethodBeat.o(196244);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        abf localabf = (abf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(196244);
          return -1;
        case 1: 
          localabf.id = locala.OmT.readString();
          AppMethodBeat.o(196244);
          return 0;
        case 2: 
          localabf.timestamp = locala.OmT.zd();
          AppMethodBeat.o(196244);
          return 0;
        case 3: 
          localabf.type = locala.OmT.zc();
          AppMethodBeat.o(196244);
          return 0;
        }
        localabf.sDg = locala.OmT.gvY();
        AppMethodBeat.o(196244);
        return 0;
      }
      AppMethodBeat.o(196244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abf
 * JD-Core Version:    0.7.0.1
 */