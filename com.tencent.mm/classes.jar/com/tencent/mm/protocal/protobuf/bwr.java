package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwr
  extends com.tencent.mm.bw.a
{
  public int Hjz;
  public String devicename;
  public String devicetype;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155438);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uuid != null) {
        paramVarArgs.d(1, this.uuid);
      }
      if (this.devicename != null) {
        paramVarArgs.d(2, this.devicename);
      }
      if (this.devicetype != null) {
        paramVarArgs.d(3, this.devicetype);
      }
      paramVarArgs.aS(4, this.Hjz);
      AppMethodBeat.o(155438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuid == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.uuid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.devicename != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.devicename);
      }
      i = paramInt;
      if (this.devicetype != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.devicetype);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.Hjz);
      AppMethodBeat.o(155438);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(155438);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bwr localbwr = (bwr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155438);
          return -1;
        case 1: 
          localbwr.uuid = locala.OmT.readString();
          AppMethodBeat.o(155438);
          return 0;
        case 2: 
          localbwr.devicename = locala.OmT.readString();
          AppMethodBeat.o(155438);
          return 0;
        case 3: 
          localbwr.devicetype = locala.OmT.readString();
          AppMethodBeat.o(155438);
          return 0;
        }
        localbwr.Hjz = locala.OmT.zc();
        AppMethodBeat.o(155438);
        return 0;
      }
      AppMethodBeat.o(155438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwr
 * JD-Core Version:    0.7.0.1
 */