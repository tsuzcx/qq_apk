package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ave
  extends com.tencent.mm.bw.a
{
  public int FYj;
  public int GMl;
  public String GMm;
  public String GMn;
  public String ikm;
  public com.tencent.mm.bw.b nIq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50086);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ikm == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: AppId");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.nIq == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Data");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.GMn == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: EventInfo");
        AppMethodBeat.o(50086);
        throw paramVarArgs;
      }
      if (this.ikm != null) {
        paramVarArgs.d(1, this.ikm);
      }
      paramVarArgs.aS(2, this.FYj);
      paramVarArgs.aS(3, this.GMl);
      if (this.nIq != null) {
        paramVarArgs.c(4, this.nIq);
      }
      if (this.GMm != null) {
        paramVarArgs.d(5, this.GMm);
      }
      if (this.GMn != null) {
        paramVarArgs.d(6, this.GMn);
      }
      AppMethodBeat.o(50086);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ikm == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.b.b.a.e(1, this.ikm) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FYj) + f.a.a.b.b.a.bz(3, this.GMl);
      paramInt = i;
      if (this.nIq != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.nIq);
      }
      i = paramInt;
      if (this.GMm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GMm);
      }
      paramInt = i;
      if (this.GMn != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GMn);
      }
      AppMethodBeat.o(50086);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.ikm == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: AppId");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        if (this.nIq == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Data");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        if (this.GMn == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: EventInfo");
          AppMethodBeat.o(50086);
          throw paramVarArgs;
        }
        AppMethodBeat.o(50086);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ave localave = (ave)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50086);
          return -1;
        case 1: 
          localave.ikm = locala.OmT.readString();
          AppMethodBeat.o(50086);
          return 0;
        case 2: 
          localave.FYj = locala.OmT.zc();
          AppMethodBeat.o(50086);
          return 0;
        case 3: 
          localave.GMl = locala.OmT.zc();
          AppMethodBeat.o(50086);
          return 0;
        case 4: 
          localave.nIq = locala.OmT.gCk();
          AppMethodBeat.o(50086);
          return 0;
        case 5: 
          localave.GMm = locala.OmT.readString();
          AppMethodBeat.o(50086);
          return 0;
        }
        localave.GMn = locala.OmT.readString();
        AppMethodBeat.o(50086);
        return 0;
      }
      AppMethodBeat.o(50086);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ave
 * JD-Core Version:    0.7.0.1
 */