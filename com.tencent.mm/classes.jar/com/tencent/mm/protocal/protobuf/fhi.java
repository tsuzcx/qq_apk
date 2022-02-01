package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class fhi
  extends com.tencent.mm.bx.a
{
  public long GvM;
  public String Hsw;
  public b abHV;
  public String id;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257559);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.g(1, this.id);
      }
      if (this.Hsw != null) {
        paramVarArgs.g(2, this.Hsw);
      }
      paramVarArgs.bv(3, this.GvM);
      paramVarArgs.bS(4, this.type);
      if (this.abHV != null) {
        paramVarArgs.d(5, this.abHV);
      }
      AppMethodBeat.o(257559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.b.b.a.h(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hsw != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Hsw);
      }
      i = i + i.a.a.b.b.a.q(3, this.GvM) + i.a.a.b.b.a.cJ(4, this.type);
      paramInt = i;
      if (this.abHV != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.abHV);
      }
      AppMethodBeat.o(257559);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257559);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fhi localfhi = (fhi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257559);
          return -1;
        case 1: 
          localfhi.id = locala.ajGk.readString();
          AppMethodBeat.o(257559);
          return 0;
        case 2: 
          localfhi.Hsw = locala.ajGk.readString();
          AppMethodBeat.o(257559);
          return 0;
        case 3: 
          localfhi.GvM = locala.ajGk.aaw();
          AppMethodBeat.o(257559);
          return 0;
        case 4: 
          localfhi.type = locala.ajGk.aar();
          AppMethodBeat.o(257559);
          return 0;
        }
        localfhi.abHV = locala.ajGk.kFX();
        AppMethodBeat.o(257559);
        return 0;
      }
      AppMethodBeat.o(257559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhi
 * JD-Core Version:    0.7.0.1
 */