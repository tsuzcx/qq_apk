package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dxn
  extends com.tencent.mm.bw.a
{
  public String Egf;
  public String FDc;
  public String MD5;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32556);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.MD5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: MD5");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.Egf == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.FDc != null) {
        paramVarArgs.d(1, this.FDc);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(2, this.MD5);
      }
      if (this.Egf != null) {
        paramVarArgs.d(3, this.Egf);
      }
      paramVarArgs.aR(4, this.Scene);
      AppMethodBeat.o(32556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FDc == null) {
        break label540;
      }
    }
    label540:
    for (int i = f.a.a.b.b.a.e(1, this.FDc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.MD5);
      }
      i = paramInt;
      if (this.Egf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Egf);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.Scene);
      AppMethodBeat.o(32556);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FDc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        if (this.MD5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: MD5");
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        if (this.Egf == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32556);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dxn localdxn = (dxn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32556);
          return -1;
        case 1: 
          localdxn.FDc = locala.LVo.readString();
          AppMethodBeat.o(32556);
          return 0;
        case 2: 
          localdxn.MD5 = locala.LVo.readString();
          AppMethodBeat.o(32556);
          return 0;
        case 3: 
          localdxn.Egf = locala.LVo.readString();
          AppMethodBeat.o(32556);
          return 0;
        }
        localdxn.Scene = locala.LVo.xF();
        AppMethodBeat.o(32556);
        return 0;
      }
      AppMethodBeat.o(32556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxn
 * JD-Core Version:    0.7.0.1
 */