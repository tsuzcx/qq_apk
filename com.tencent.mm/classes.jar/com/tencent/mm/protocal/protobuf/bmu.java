package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmu
  extends com.tencent.mm.bx.a
{
  public int DKh;
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
      paramVarArgs.aR(4, this.DKh);
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
      paramInt = f.a.a.b.b.a.bA(4, this.DKh);
      AppMethodBeat.o(155438);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(155438);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bmu localbmu = (bmu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155438);
          return -1;
        case 1: 
          localbmu.uuid = locala.KhF.readString();
          AppMethodBeat.o(155438);
          return 0;
        case 2: 
          localbmu.devicename = locala.KhF.readString();
          AppMethodBeat.o(155438);
          return 0;
        case 3: 
          localbmu.devicetype = locala.KhF.readString();
          AppMethodBeat.o(155438);
          return 0;
        }
        localbmu.DKh = locala.KhF.xS();
        AppMethodBeat.o(155438);
        return 0;
      }
      AppMethodBeat.o(155438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmu
 * JD-Core Version:    0.7.0.1
 */