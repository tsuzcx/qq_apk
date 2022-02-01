package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkb
  extends com.tencent.mm.bx.a
{
  public int aaPU;
  public String devicename;
  public String devicetype;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155438);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.uuid != null) {
        paramVarArgs.g(1, this.uuid);
      }
      if (this.devicename != null) {
        paramVarArgs.g(2, this.devicename);
      }
      if (this.devicetype != null) {
        paramVarArgs.g(3, this.devicetype);
      }
      paramVarArgs.bS(4, this.aaPU);
      AppMethodBeat.o(155438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuid == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.uuid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.devicename != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.devicename);
      }
      i = paramInt;
      if (this.devicetype != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.devicetype);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.aaPU);
      AppMethodBeat.o(155438);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(155438);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dkb localdkb = (dkb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155438);
          return -1;
        case 1: 
          localdkb.uuid = locala.ajGk.readString();
          AppMethodBeat.o(155438);
          return 0;
        case 2: 
          localdkb.devicename = locala.ajGk.readString();
          AppMethodBeat.o(155438);
          return 0;
        case 3: 
          localdkb.devicetype = locala.ajGk.readString();
          AppMethodBeat.o(155438);
          return 0;
        }
        localdkb.aaPU = locala.ajGk.aar();
        AppMethodBeat.o(155438);
        return 0;
      }
      AppMethodBeat.o(155438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkb
 * JD-Core Version:    0.7.0.1
 */