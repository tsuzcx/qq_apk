package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxs
  extends com.tencent.mm.bw.a
{
  public String GVf;
  public String Hzf;
  public String Hzg;
  public int nID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91678);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GVf != null) {
        paramVarArgs.d(1, this.GVf);
      }
      if (this.Hzg != null) {
        paramVarArgs.d(2, this.Hzg);
      }
      paramVarArgs.aS(3, this.nID);
      if (this.Hzf != null) {
        paramVarArgs.d(4, this.Hzf);
      }
      AppMethodBeat.o(91678);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GVf == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.GVf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hzg != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hzg);
      }
      i += f.a.a.b.b.a.bz(3, this.nID);
      paramInt = i;
      if (this.Hzf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hzf);
      }
      AppMethodBeat.o(91678);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91678);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cxs localcxs = (cxs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91678);
          return -1;
        case 1: 
          localcxs.GVf = locala.OmT.readString();
          AppMethodBeat.o(91678);
          return 0;
        case 2: 
          localcxs.Hzg = locala.OmT.readString();
          AppMethodBeat.o(91678);
          return 0;
        case 3: 
          localcxs.nID = locala.OmT.zc();
          AppMethodBeat.o(91678);
          return 0;
        }
        localcxs.Hzf = locala.OmT.readString();
        AppMethodBeat.o(91678);
        return 0;
      }
      AppMethodBeat.o(91678);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxs
 * JD-Core Version:    0.7.0.1
 */