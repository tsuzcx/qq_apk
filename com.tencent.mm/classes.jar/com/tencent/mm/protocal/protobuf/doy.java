package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class doy
  extends com.tencent.mm.bw.a
{
  public String iod;
  public String iom;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152721);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iod == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152721);
        throw paramVarArgs;
      }
      if (this.iom == null)
      {
        paramVarArgs = new b("Not all required fields were included: verify_ticket");
        AppMethodBeat.o(152721);
        throw paramVarArgs;
      }
      if (this.iod != null) {
        paramVarArgs.d(1, this.iod);
      }
      if (this.iom != null) {
        paramVarArgs.d(2, this.iom);
      }
      AppMethodBeat.o(152721);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iod == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.iod) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iom != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.iom);
      }
      AppMethodBeat.o(152721);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.iod == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152721);
          throw paramVarArgs;
        }
        if (this.iom == null)
        {
          paramVarArgs = new b("Not all required fields were included: verify_ticket");
          AppMethodBeat.o(152721);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152721);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        doy localdoy = (doy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152721);
          return -1;
        case 1: 
          localdoy.iod = locala.LVo.readString();
          AppMethodBeat.o(152721);
          return 0;
        }
        localdoy.iom = locala.LVo.readString();
        AppMethodBeat.o(152721);
        return 0;
      }
      AppMethodBeat.o(152721);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doy
 * JD-Core Version:    0.7.0.1
 */