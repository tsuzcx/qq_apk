package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.storage.an;
import f.a.a.b;

public class pv
  extends com.tencent.mm.bw.a
{
  public an contact;
  public String userName;
  public c xfE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6400);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.userName == null)
      {
        paramVarArgs = new b("Not all required fields were included: userName");
        AppMethodBeat.o(6400);
        throw paramVarArgs;
      }
      if (this.userName != null) {
        paramVarArgs.d(1, this.userName);
      }
      AppMethodBeat.o(6400);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = f.a.a.b.b.a.e(1, this.userName) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(6400);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.userName == null)
        {
          paramVarArgs = new b("Not all required fields were included: userName");
          AppMethodBeat.o(6400);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6400);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        pv localpv = (pv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6400);
          return -1;
        }
        localpv.userName = locala.OmT.readString();
        AppMethodBeat.o(6400);
        return 0;
      }
      AppMethodBeat.o(6400);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pv
 * JD-Core Version:    0.7.0.1
 */