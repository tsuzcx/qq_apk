package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csz
  extends com.tencent.mm.cd.a
{
  public int TAE;
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
        paramVarArgs.f(1, this.uuid);
      }
      if (this.devicename != null) {
        paramVarArgs.f(2, this.devicename);
      }
      if (this.devicetype != null) {
        paramVarArgs.f(3, this.devicetype);
      }
      paramVarArgs.aY(4, this.TAE);
      AppMethodBeat.o(155438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuid == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.uuid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.devicename != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.devicename);
      }
      i = paramInt;
      if (this.devicetype != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.devicetype);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.TAE);
      AppMethodBeat.o(155438);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(155438);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        csz localcsz = (csz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155438);
          return -1;
        case 1: 
          localcsz.uuid = locala.abFh.readString();
          AppMethodBeat.o(155438);
          return 0;
        case 2: 
          localcsz.devicename = locala.abFh.readString();
          AppMethodBeat.o(155438);
          return 0;
        case 3: 
          localcsz.devicetype = locala.abFh.readString();
          AppMethodBeat.o(155438);
          return 0;
        }
        localcsz.TAE = locala.abFh.AK();
        AppMethodBeat.o(155438);
        return 0;
      }
      AppMethodBeat.o(155438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csz
 * JD-Core Version:    0.7.0.1
 */