package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dsg
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b EGl;
  public String Egc;
  public String mBV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32566);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Egc == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32566);
        throw paramVarArgs;
      }
      if (this.mBV == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32566);
        throw paramVarArgs;
      }
      if (this.Egc != null) {
        paramVarArgs.d(1, this.Egc);
      }
      if (this.mBV != null) {
        paramVarArgs.d(2, this.mBV);
      }
      if (this.EGl != null) {
        paramVarArgs.c(3, this.EGl);
      }
      AppMethodBeat.o(32566);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Egc == null) {
        break label443;
      }
    }
    label443:
    for (int i = f.a.a.b.b.a.e(1, this.Egc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mBV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mBV);
      }
      i = paramInt;
      if (this.EGl != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.EGl);
      }
      AppMethodBeat.o(32566);
      return i;
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32566);
          throw paramVarArgs;
        }
        if (this.mBV == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
          AppMethodBeat.o(32566);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32566);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dsg localdsg = (dsg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32566);
          return -1;
        case 1: 
          localdsg.Egc = locala.KhF.readString();
          AppMethodBeat.o(32566);
          return 0;
        case 2: 
          localdsg.mBV = locala.KhF.readString();
          AppMethodBeat.o(32566);
          return 0;
        }
        localdsg.EGl = locala.KhF.fMu();
        AppMethodBeat.o(32566);
        return 0;
      }
      AppMethodBeat.o(32566);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsg
 * JD-Core Version:    0.7.0.1
 */