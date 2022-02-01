package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class daw
  extends com.tencent.mm.bx.a
{
  public int rid;
  public int rie;
  public double sgn;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82426);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.uuid != null) {
        paramVarArgs.g(1, this.uuid);
      }
      paramVarArgs.bS(2, this.rid);
      paramVarArgs.bS(3, this.rie);
      paramVarArgs.d(4, this.sgn);
      AppMethodBeat.o(82426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuid == null) {
        break label349;
      }
    }
    label349:
    for (paramInt = i.a.a.b.b.a.h(1, this.uuid) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.rid);
      int j = i.a.a.b.b.a.cJ(3, this.rie);
      int k = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(82426);
      return paramInt + i + j + (k + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82426);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        daw localdaw = (daw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82426);
          return -1;
        case 1: 
          localdaw.uuid = locala.ajGk.readString();
          AppMethodBeat.o(82426);
          return 0;
        case 2: 
          localdaw.rid = locala.ajGk.aar();
          AppMethodBeat.o(82426);
          return 0;
        case 3: 
          localdaw.rie = locala.ajGk.aar();
          AppMethodBeat.o(82426);
          return 0;
        }
        localdaw.sgn = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(82426);
        return 0;
      }
      AppMethodBeat.o(82426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daw
 * JD-Core Version:    0.7.0.1
 */