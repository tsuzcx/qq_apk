package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cxt
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public String wCj;
  public String wQr;
  public String wxW;
  public String xlH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28758);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xlH == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(28758);
        throw paramVarArgs;
      }
      if (this.wxW == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(28758);
        throw paramVarArgs;
      }
      if (this.wQr == null)
      {
        paramVarArgs = new b("Not all required fields were included: MD5");
        AppMethodBeat.o(28758);
        throw paramVarArgs;
      }
      if (this.wCj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(28758);
        throw paramVarArgs;
      }
      if (this.xlH != null) {
        paramVarArgs.e(1, this.xlH);
      }
      if (this.wxW != null) {
        paramVarArgs.e(2, this.wxW);
      }
      if (this.wQr != null) {
        paramVarArgs.e(3, this.wQr);
      }
      if (this.wCj != null) {
        paramVarArgs.e(4, this.wCj);
      }
      paramVarArgs.aO(5, this.Scene);
      AppMethodBeat.o(28758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xlH == null) {
        break label649;
      }
    }
    label649:
    for (int i = e.a.a.b.b.a.f(1, this.xlH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wxW != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wxW);
      }
      i = paramInt;
      if (this.wQr != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wQr);
      }
      paramInt = i;
      if (this.wCj != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wCj);
      }
      i = e.a.a.b.b.a.bl(5, this.Scene);
      AppMethodBeat.o(28758);
      return paramInt + i;
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
          AppMethodBeat.o(28758);
          throw paramVarArgs;
        }
        if (this.wxW == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(28758);
          throw paramVarArgs;
        }
        if (this.wQr == null)
        {
          paramVarArgs = new b("Not all required fields were included: MD5");
          AppMethodBeat.o(28758);
          throw paramVarArgs;
        }
        if (this.wCj == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(28758);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28758);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cxt localcxt = (cxt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28758);
          return -1;
        case 1: 
          localcxt.xlH = locala.CLY.readString();
          AppMethodBeat.o(28758);
          return 0;
        case 2: 
          localcxt.wxW = locala.CLY.readString();
          AppMethodBeat.o(28758);
          return 0;
        case 3: 
          localcxt.wQr = locala.CLY.readString();
          AppMethodBeat.o(28758);
          return 0;
        case 4: 
          localcxt.wCj = locala.CLY.readString();
          AppMethodBeat.o(28758);
          return 0;
        }
        localcxt.Scene = locala.CLY.sl();
        AppMethodBeat.o(28758);
        return 0;
      }
      AppMethodBeat.o(28758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxt
 * JD-Core Version:    0.7.0.1
 */