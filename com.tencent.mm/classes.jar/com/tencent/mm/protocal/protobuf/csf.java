package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csf
  extends com.tencent.mm.bw.a
{
  public String HDp;
  public String HDq;
  public int HDr;
  public int HDs = 0;
  public String HDt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117895);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HDp != null) {
        paramVarArgs.d(1, this.HDp);
      }
      if (this.HDq != null) {
        paramVarArgs.d(2, this.HDq);
      }
      paramVarArgs.aS(3, this.HDr);
      paramVarArgs.aS(4, this.HDs);
      if (this.HDt != null) {
        paramVarArgs.d(5, this.HDt);
      }
      AppMethodBeat.o(117895);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HDp == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.HDp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HDq != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HDq);
      }
      i = i + f.a.a.b.b.a.bz(3, this.HDr) + f.a.a.b.b.a.bz(4, this.HDs);
      paramInt = i;
      if (this.HDt != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HDt);
      }
      AppMethodBeat.o(117895);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117895);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        csf localcsf = (csf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117895);
          return -1;
        case 1: 
          localcsf.HDp = locala.OmT.readString();
          AppMethodBeat.o(117895);
          return 0;
        case 2: 
          localcsf.HDq = locala.OmT.readString();
          AppMethodBeat.o(117895);
          return 0;
        case 3: 
          localcsf.HDr = locala.OmT.zc();
          AppMethodBeat.o(117895);
          return 0;
        case 4: 
          localcsf.HDs = locala.OmT.zc();
          AppMethodBeat.o(117895);
          return 0;
        }
        localcsf.HDt = locala.OmT.readString();
        AppMethodBeat.o(117895);
        return 0;
      }
      AppMethodBeat.o(117895);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csf
 * JD-Core Version:    0.7.0.1
 */