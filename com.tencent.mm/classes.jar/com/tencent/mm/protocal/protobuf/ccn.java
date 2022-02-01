package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccn
  extends com.tencent.mm.bw.a
{
  public String Hpf;
  public String Hpg;
  public String Hph;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63277);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hpf != null) {
        paramVarArgs.d(1, this.Hpf);
      }
      if (this.Hpg != null) {
        paramVarArgs.d(2, this.Hpg);
      }
      if (this.Hph != null) {
        paramVarArgs.d(3, this.Hph);
      }
      AppMethodBeat.o(63277);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hpf == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.Hpf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hpg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hpg);
      }
      i = paramInt;
      if (this.Hph != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hph);
      }
      AppMethodBeat.o(63277);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(63277);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ccn localccn = (ccn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(63277);
          return -1;
        case 1: 
          localccn.Hpf = locala.OmT.readString();
          AppMethodBeat.o(63277);
          return 0;
        case 2: 
          localccn.Hpg = locala.OmT.readString();
          AppMethodBeat.o(63277);
          return 0;
        }
        localccn.Hph = locala.OmT.readString();
        AppMethodBeat.o(63277);
        return 0;
      }
      AppMethodBeat.o(63277);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccn
 * JD-Core Version:    0.7.0.1
 */