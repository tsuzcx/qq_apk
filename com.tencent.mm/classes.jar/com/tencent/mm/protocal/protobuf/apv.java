package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class apv
  extends com.tencent.mm.bx.a
{
  public int GnZ;
  public int Goa;
  public b Gob;
  public String dHz;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194942);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dHz != null) {
        paramVarArgs.d(1, this.dHz);
      }
      if (this.sessionId != null) {
        paramVarArgs.d(2, this.sessionId);
      }
      paramVarArgs.aS(3, this.GnZ);
      paramVarArgs.aS(4, this.Goa);
      if (this.Gob != null) {
        paramVarArgs.c(5, this.Gob);
      }
      AppMethodBeat.o(194942);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dHz == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.dHz) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sessionId != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.sessionId);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GnZ) + f.a.a.b.b.a.bz(4, this.Goa);
      paramInt = i;
      if (this.Gob != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.Gob);
      }
      AppMethodBeat.o(194942);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(194942);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        apv localapv = (apv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194942);
          return -1;
        case 1: 
          localapv.dHz = locala.NPN.readString();
          AppMethodBeat.o(194942);
          return 0;
        case 2: 
          localapv.sessionId = locala.NPN.readString();
          AppMethodBeat.o(194942);
          return 0;
        case 3: 
          localapv.GnZ = locala.NPN.zc();
          AppMethodBeat.o(194942);
          return 0;
        case 4: 
          localapv.Goa = locala.NPN.zc();
          AppMethodBeat.o(194942);
          return 0;
        }
        localapv.Gob = locala.NPN.gxI();
        AppMethodBeat.o(194942);
        return 0;
      }
      AppMethodBeat.o(194942);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apv
 * JD-Core Version:    0.7.0.1
 */