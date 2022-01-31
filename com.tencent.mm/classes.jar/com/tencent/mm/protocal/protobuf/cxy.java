package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cxy
  extends com.tencent.mm.bv.a
{
  public String yfc;
  public String yfd;
  public String yfe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28763);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yfc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Plugin");
        AppMethodBeat.o(28763);
        throw paramVarArgs;
      }
      if (this.yfd == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActivityPath");
        AppMethodBeat.o(28763);
        throw paramVarArgs;
      }
      if (this.yfc != null) {
        paramVarArgs.e(1, this.yfc);
      }
      if (this.yfd != null) {
        paramVarArgs.e(2, this.yfd);
      }
      if (this.yfe != null) {
        paramVarArgs.e(3, this.yfe);
      }
      AppMethodBeat.o(28763);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yfc == null) {
        break label443;
      }
    }
    label443:
    for (int i = e.a.a.b.b.a.f(1, this.yfc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.yfd != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.yfd);
      }
      i = paramInt;
      if (this.yfe != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.yfe);
      }
      AppMethodBeat.o(28763);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.yfc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Plugin");
          AppMethodBeat.o(28763);
          throw paramVarArgs;
        }
        if (this.yfd == null)
        {
          paramVarArgs = new b("Not all required fields were included: ActivityPath");
          AppMethodBeat.o(28763);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28763);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cxy localcxy = (cxy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28763);
          return -1;
        case 1: 
          localcxy.yfc = locala.CLY.readString();
          AppMethodBeat.o(28763);
          return 0;
        case 2: 
          localcxy.yfd = locala.CLY.readString();
          AppMethodBeat.o(28763);
          return 0;
        }
        localcxy.yfe = locala.CLY.readString();
        AppMethodBeat.o(28763);
        return 0;
      }
      AppMethodBeat.o(28763);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxy
 * JD-Core Version:    0.7.0.1
 */