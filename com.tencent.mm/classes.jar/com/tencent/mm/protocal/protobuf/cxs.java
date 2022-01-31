package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cxs
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public String wCj;
  public String wQr;
  public String xlH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28757);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xlH == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(28757);
        throw paramVarArgs;
      }
      if (this.wQr == null)
      {
        paramVarArgs = new b("Not all required fields were included: MD5");
        AppMethodBeat.o(28757);
        throw paramVarArgs;
      }
      if (this.wCj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(28757);
        throw paramVarArgs;
      }
      if (this.xlH != null) {
        paramVarArgs.e(1, this.xlH);
      }
      if (this.wQr != null) {
        paramVarArgs.e(2, this.wQr);
      }
      if (this.wCj != null) {
        paramVarArgs.e(3, this.wCj);
      }
      paramVarArgs.aO(4, this.Scene);
      AppMethodBeat.o(28757);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xlH == null) {
        break label540;
      }
    }
    label540:
    for (int i = e.a.a.b.b.a.f(1, this.xlH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wQr != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wQr);
      }
      i = paramInt;
      if (this.wCj != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wCj);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.Scene);
      AppMethodBeat.o(28757);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xlH == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(28757);
          throw paramVarArgs;
        }
        if (this.wQr == null)
        {
          paramVarArgs = new b("Not all required fields were included: MD5");
          AppMethodBeat.o(28757);
          throw paramVarArgs;
        }
        if (this.wCj == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(28757);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28757);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cxs localcxs = (cxs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28757);
          return -1;
        case 1: 
          localcxs.xlH = locala.CLY.readString();
          AppMethodBeat.o(28757);
          return 0;
        case 2: 
          localcxs.wQr = locala.CLY.readString();
          AppMethodBeat.o(28757);
          return 0;
        case 3: 
          localcxs.wCj = locala.CLY.readString();
          AppMethodBeat.o(28757);
          return 0;
        }
        localcxs.Scene = locala.CLY.sl();
        AppMethodBeat.o(28757);
        return 0;
      }
      AppMethodBeat.o(28757);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxs
 * JD-Core Version:    0.7.0.1
 */