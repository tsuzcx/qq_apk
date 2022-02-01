package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class drx
  extends com.tencent.mm.bx.a
{
  public String CIE;
  public String CND;
  public String Egc;
  public String MD5;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32557);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Egc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32557);
        throw paramVarArgs;
      }
      if (this.CIE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(32557);
        throw paramVarArgs;
      }
      if (this.MD5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: MD5");
        AppMethodBeat.o(32557);
        throw paramVarArgs;
      }
      if (this.CND == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(32557);
        throw paramVarArgs;
      }
      if (this.Egc != null) {
        paramVarArgs.d(1, this.Egc);
      }
      if (this.CIE != null) {
        paramVarArgs.d(2, this.CIE);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      if (this.CND != null) {
        paramVarArgs.d(4, this.CND);
      }
      paramVarArgs.aR(5, this.Scene);
      AppMethodBeat.o(32557);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Egc == null) {
        break label649;
      }
    }
    label649:
    for (int i = f.a.a.b.b.a.e(1, this.Egc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CIE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CIE);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.MD5);
      }
      paramInt = i;
      if (this.CND != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CND);
      }
      i = f.a.a.b.b.a.bA(5, this.Scene);
      AppMethodBeat.o(32557);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Egc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32557);
          throw paramVarArgs;
        }
        if (this.CIE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(32557);
          throw paramVarArgs;
        }
        if (this.MD5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: MD5");
          AppMethodBeat.o(32557);
          throw paramVarArgs;
        }
        if (this.CND == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(32557);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32557);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        drx localdrx = (drx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32557);
          return -1;
        case 1: 
          localdrx.Egc = locala.KhF.readString();
          AppMethodBeat.o(32557);
          return 0;
        case 2: 
          localdrx.CIE = locala.KhF.readString();
          AppMethodBeat.o(32557);
          return 0;
        case 3: 
          localdrx.MD5 = locala.KhF.readString();
          AppMethodBeat.o(32557);
          return 0;
        case 4: 
          localdrx.CND = locala.KhF.readString();
          AppMethodBeat.o(32557);
          return 0;
        }
        localdrx.Scene = locala.KhF.xS();
        AppMethodBeat.o(32557);
        return 0;
      }
      AppMethodBeat.o(32557);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drx
 * JD-Core Version:    0.7.0.1
 */