package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bus
  extends com.tencent.mm.bx.a
{
  public int FIy;
  public String GOM;
  public int GON;
  public String content;
  public String fSp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211966);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GOM != null) {
        paramVarArgs.d(1, this.GOM);
      }
      if (this.fSp != null) {
        paramVarArgs.d(2, this.fSp);
      }
      paramVarArgs.aS(3, this.FIy);
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.aS(5, this.GON);
      AppMethodBeat.o(211966);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GOM == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.GOM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fSp != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.fSp);
      }
      i += f.a.a.b.b.a.bz(3, this.FIy);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.content);
      }
      i = f.a.a.b.b.a.bz(5, this.GON);
      AppMethodBeat.o(211966);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(211966);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bus localbus = (bus)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(211966);
          return -1;
        case 1: 
          localbus.GOM = locala.NPN.readString();
          AppMethodBeat.o(211966);
          return 0;
        case 2: 
          localbus.fSp = locala.NPN.readString();
          AppMethodBeat.o(211966);
          return 0;
        case 3: 
          localbus.FIy = locala.NPN.zc();
          AppMethodBeat.o(211966);
          return 0;
        case 4: 
          localbus.content = locala.NPN.readString();
          AppMethodBeat.o(211966);
          return 0;
        }
        localbus.GON = locala.NPN.zc();
        AppMethodBeat.o(211966);
        return 0;
      }
      AppMethodBeat.o(211966);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bus
 * JD-Core Version:    0.7.0.1
 */