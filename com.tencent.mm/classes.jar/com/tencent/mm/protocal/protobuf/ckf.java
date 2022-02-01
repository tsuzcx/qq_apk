package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckf
  extends com.tencent.mm.bw.a
{
  public int MpC;
  public String devicename;
  public String devicetype;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155438);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.uuid != null) {
        paramVarArgs.e(1, this.uuid);
      }
      if (this.devicename != null) {
        paramVarArgs.e(2, this.devicename);
      }
      if (this.devicetype != null) {
        paramVarArgs.e(3, this.devicetype);
      }
      paramVarArgs.aM(4, this.MpC);
      AppMethodBeat.o(155438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuid == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.f(1, this.uuid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.devicename != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.devicename);
      }
      i = paramInt;
      if (this.devicetype != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.devicetype);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.MpC);
      AppMethodBeat.o(155438);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(155438);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ckf localckf = (ckf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155438);
          return -1;
        case 1: 
          localckf.uuid = locala.UbS.readString();
          AppMethodBeat.o(155438);
          return 0;
        case 2: 
          localckf.devicename = locala.UbS.readString();
          AppMethodBeat.o(155438);
          return 0;
        case 3: 
          localckf.devicetype = locala.UbS.readString();
          AppMethodBeat.o(155438);
          return 0;
        }
        localckf.MpC = locala.UbS.zi();
        AppMethodBeat.o(155438);
        return 0;
      }
      AppMethodBeat.o(155438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckf
 * JD-Core Version:    0.7.0.1
 */