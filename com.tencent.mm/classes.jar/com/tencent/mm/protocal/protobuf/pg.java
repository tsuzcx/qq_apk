package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class pg
  extends com.tencent.mm.bx.a
{
  public String CNu;
  public String CNv;
  public String IconUrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117844);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IconUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(117844);
        throw paramVarArgs;
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(1, this.IconUrl);
      }
      if (this.CNu != null) {
        paramVarArgs.d(2, this.CNu);
      }
      if (this.CNv != null) {
        paramVarArgs.d(3, this.CNv);
      }
      AppMethodBeat.o(117844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IconUrl == null) {
        break label382;
      }
    }
    label382:
    for (int i = f.a.a.b.b.a.e(1, this.IconUrl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CNu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CNu);
      }
      i = paramInt;
      if (this.CNv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CNv);
      }
      AppMethodBeat.o(117844);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.IconUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(117844);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117844);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        pg localpg = (pg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117844);
          return -1;
        case 1: 
          localpg.IconUrl = locala.KhF.readString();
          AppMethodBeat.o(117844);
          return 0;
        case 2: 
          localpg.CNu = locala.KhF.readString();
          AppMethodBeat.o(117844);
          return 0;
        }
        localpg.CNv = locala.KhF.readString();
        AppMethodBeat.o(117844);
        return 0;
      }
      AppMethodBeat.o(117844);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pg
 * JD-Core Version:    0.7.0.1
 */