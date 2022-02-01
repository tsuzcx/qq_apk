package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class rb
  extends com.tencent.mm.bx.a
{
  public String dyd;
  public String nrr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113964);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nrr != null) {
        paramVarArgs.d(1, this.nrr);
      }
      if (this.dyd != null) {
        paramVarArgs.d(2, this.dyd);
      }
      AppMethodBeat.o(113964);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nrr == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.nrr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dyd != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dyd);
      }
      AppMethodBeat.o(113964);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113964);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rb localrb = (rb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113964);
          return -1;
        case 1: 
          localrb.nrr = locala.KhF.readString();
          AppMethodBeat.o(113964);
          return 0;
        }
        localrb.dyd = locala.KhF.readString();
        AppMethodBeat.o(113964);
        return 0;
      }
      AppMethodBeat.o(113964);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rb
 * JD-Core Version:    0.7.0.1
 */