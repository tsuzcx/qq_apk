package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class cap
  extends com.tencent.mm.bx.a
{
  public long Njv;
  public String ZYN;
  public b ZwY;
  public String report_ext_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258584);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZYN != null) {
        paramVarArgs.g(1, this.ZYN);
      }
      paramVarArgs.bv(2, this.Njv);
      if (this.ZwY != null) {
        paramVarArgs.d(3, this.ZwY);
      }
      if (this.report_ext_info != null) {
        paramVarArgs.g(4, this.report_ext_info);
      }
      AppMethodBeat.o(258584);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZYN == null) {
        break label374;
      }
    }
    label374:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZYN) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.Njv);
      paramInt = i;
      if (this.ZwY != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZwY);
      }
      i = paramInt;
      if (this.report_ext_info != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.report_ext_info);
      }
      AppMethodBeat.o(258584);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258584);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cap localcap = (cap)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258584);
          return -1;
        case 1: 
          localcap.ZYN = locala.ajGk.readString();
          AppMethodBeat.o(258584);
          return 0;
        case 2: 
          localcap.Njv = locala.ajGk.aaw();
          AppMethodBeat.o(258584);
          return 0;
        case 3: 
          localcap.ZwY = locala.ajGk.kFX();
          AppMethodBeat.o(258584);
          return 0;
        }
        localcap.report_ext_info = locala.ajGk.readString();
        AppMethodBeat.o(258584);
        return 0;
      }
      AppMethodBeat.o(258584);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cap
 * JD-Core Version:    0.7.0.1
 */