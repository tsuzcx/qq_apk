package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public class uq
  extends com.tencent.mm.bx.a
{
  public b YZW;
  public long YZX;
  public long YZY;
  public boolean YZZ;
  public long id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259111);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YZW != null) {
        paramVarArgs.d(1, this.YZW);
      }
      paramVarArgs.bv(2, this.YZX);
      paramVarArgs.bv(3, this.YZY);
      paramVarArgs.di(4, this.YZZ);
      paramVarArgs.bv(5, this.id);
      AppMethodBeat.o(259111);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YZW == null) {
        break label390;
      }
    }
    label390:
    for (paramInt = i.a.a.b.b.a.c(1, this.YZW) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.YZX);
      int j = i.a.a.b.b.a.q(3, this.YZY);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.q(5, this.id);
      AppMethodBeat.o(259111);
      return paramInt + i + j + (k + 1) + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259111);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        uq localuq = (uq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259111);
          return -1;
        case 1: 
          localuq.YZW = locala.ajGk.kFX();
          AppMethodBeat.o(259111);
          return 0;
        case 2: 
          localuq.YZX = locala.ajGk.aaw();
          AppMethodBeat.o(259111);
          return 0;
        case 3: 
          localuq.YZY = locala.ajGk.aaw();
          AppMethodBeat.o(259111);
          return 0;
        case 4: 
          localuq.YZZ = locala.ajGk.aai();
          AppMethodBeat.o(259111);
          return 0;
        }
        localuq.id = locala.ajGk.aaw();
        AppMethodBeat.o(259111);
        return 0;
      }
      AppMethodBeat.o(259111);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uq
 * JD-Core Version:    0.7.0.1
 */