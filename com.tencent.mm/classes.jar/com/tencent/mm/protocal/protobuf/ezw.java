package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezw
  extends com.tencent.mm.bw.a
{
  public String MRZ;
  public com.tencent.mm.bw.b Nvo;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32566);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MRZ == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32566);
        throw paramVarArgs;
      }
      if (this.oUJ == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32566);
        throw paramVarArgs;
      }
      if (this.MRZ != null) {
        paramVarArgs.e(1, this.MRZ);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      if (this.Nvo != null) {
        paramVarArgs.c(3, this.Nvo);
      }
      AppMethodBeat.o(32566);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MRZ == null) {
        break label443;
      }
    }
    label443:
    for (int i = g.a.a.b.b.a.f(1, this.MRZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oUJ);
      }
      i = paramInt;
      if (this.Nvo != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.Nvo);
      }
      AppMethodBeat.o(32566);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MRZ == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32566);
          throw paramVarArgs;
        }
        if (this.oUJ == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: NickName");
          AppMethodBeat.o(32566);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32566);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezw localezw = (ezw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32566);
          return -1;
        case 1: 
          localezw.MRZ = locala.UbS.readString();
          AppMethodBeat.o(32566);
          return 0;
        case 2: 
          localezw.oUJ = locala.UbS.readString();
          AppMethodBeat.o(32566);
          return 0;
        }
        localezw.Nvo = locala.UbS.hPo();
        AppMethodBeat.o(32566);
        return 0;
      }
      AppMethodBeat.o(32566);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezw
 * JD-Core Version:    0.7.0.1
 */