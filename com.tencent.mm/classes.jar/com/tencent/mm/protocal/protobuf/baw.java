package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class baw
  extends com.tencent.mm.bv.a
{
  public String devicename;
  public String devicetype;
  public String eAx;
  public int xpY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73737);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.eAx != null) {
        paramVarArgs.e(1, this.eAx);
      }
      if (this.devicename != null) {
        paramVarArgs.e(2, this.devicename);
      }
      if (this.devicetype != null) {
        paramVarArgs.e(3, this.devicetype);
      }
      paramVarArgs.aO(4, this.xpY);
      AppMethodBeat.o(73737);
      return 0;
    }
    if (paramInt == 1) {
      if (this.eAx == null) {
        break label378;
      }
    }
    label378:
    for (int i = e.a.a.b.b.a.f(1, this.eAx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.devicename != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.devicename);
      }
      i = paramInt;
      if (this.devicetype != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.devicetype);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.xpY);
      AppMethodBeat.o(73737);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(73737);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        baw localbaw = (baw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(73737);
          return -1;
        case 1: 
          localbaw.eAx = locala.CLY.readString();
          AppMethodBeat.o(73737);
          return 0;
        case 2: 
          localbaw.devicename = locala.CLY.readString();
          AppMethodBeat.o(73737);
          return 0;
        case 3: 
          localbaw.devicetype = locala.CLY.readString();
          AppMethodBeat.o(73737);
          return 0;
        }
        localbaw.xpY = locala.CLY.sl();
        AppMethodBeat.o(73737);
        return 0;
      }
      AppMethodBeat.o(73737);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baw
 * JD-Core Version:    0.7.0.1
 */