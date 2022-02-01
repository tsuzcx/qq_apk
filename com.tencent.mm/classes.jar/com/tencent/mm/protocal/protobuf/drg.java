package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class drg
  extends com.tencent.mm.bx.a
{
  public long EGt;
  public String Egc;
  public String mBV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32536);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Egc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32536);
        throw paramVarArgs;
      }
      if (this.mBV == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(32536);
        throw paramVarArgs;
      }
      if (this.Egc != null) {
        paramVarArgs.d(1, this.Egc);
      }
      if (this.mBV != null) {
        paramVarArgs.d(2, this.mBV);
      }
      paramVarArgs.aG(3, this.EGt);
      AppMethodBeat.o(32536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Egc == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = f.a.a.b.b.a.e(1, this.Egc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mBV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.mBV);
      }
      paramInt = f.a.a.b.b.a.q(3, this.EGt);
      AppMethodBeat.o(32536);
      return i + paramInt;
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
          AppMethodBeat.o(32536);
          throw paramVarArgs;
        }
        if (this.mBV == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(32536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32536);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        drg localdrg = (drg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32536);
          return -1;
        case 1: 
          localdrg.Egc = locala.KhF.readString();
          AppMethodBeat.o(32536);
          return 0;
        case 2: 
          localdrg.mBV = locala.KhF.readString();
          AppMethodBeat.o(32536);
          return 0;
        }
        localdrg.EGt = locala.KhF.xT();
        AppMethodBeat.o(32536);
        return 0;
      }
      AppMethodBeat.o(32536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drg
 * JD-Core Version:    0.7.0.1
 */