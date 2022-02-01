package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdv
  extends com.tencent.mm.bw.a
{
  public String Ekn;
  public int FsA;
  public String FsB;
  public String FsC;
  public String djj;
  public String hhs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91579);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djj != null) {
        paramVarArgs.d(1, this.djj);
      }
      paramVarArgs.aR(2, this.FsA);
      if (this.FsB != null) {
        paramVarArgs.d(3, this.FsB);
      }
      if (this.FsC != null) {
        paramVarArgs.d(4, this.FsC);
      }
      if (this.Ekn != null) {
        paramVarArgs.d(5, this.Ekn);
      }
      if (this.hhs != null) {
        paramVarArgs.d(6, this.hhs);
      }
      AppMethodBeat.o(91579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.djj == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.djj) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FsA);
      paramInt = i;
      if (this.FsB != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FsB);
      }
      i = paramInt;
      if (this.FsC != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FsC);
      }
      paramInt = i;
      if (this.Ekn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Ekn);
      }
      i = paramInt;
      if (this.hhs != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hhs);
      }
      AppMethodBeat.o(91579);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91579);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cdv localcdv = (cdv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91579);
          return -1;
        case 1: 
          localcdv.djj = locala.LVo.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 2: 
          localcdv.FsA = locala.LVo.xF();
          AppMethodBeat.o(91579);
          return 0;
        case 3: 
          localcdv.FsB = locala.LVo.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 4: 
          localcdv.FsC = locala.LVo.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 5: 
          localcdv.Ekn = locala.LVo.readString();
          AppMethodBeat.o(91579);
          return 0;
        }
        localcdv.hhs = locala.LVo.readString();
        AppMethodBeat.o(91579);
        return 0;
      }
      AppMethodBeat.o(91579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdv
 * JD-Core Version:    0.7.0.1
 */