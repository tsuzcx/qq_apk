package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class drm
  extends com.tencent.mm.bw.a
{
  public String FTJ;
  public String FTK;
  public String dlT;
  public String hCp;
  public String uVs;
  public String wRt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72615);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlT != null) {
        paramVarArgs.d(1, this.dlT);
      }
      if (this.hCp != null) {
        paramVarArgs.d(2, this.hCp);
      }
      if (this.uVs != null) {
        paramVarArgs.d(3, this.uVs);
      }
      if (this.wRt != null) {
        paramVarArgs.d(4, this.wRt);
      }
      if (this.FTJ != null) {
        paramVarArgs.d(5, this.FTJ);
      }
      if (this.FTK != null) {
        paramVarArgs.d(6, this.FTK);
      }
      AppMethodBeat.o(72615);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlT == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.dlT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hCp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hCp);
      }
      i = paramInt;
      if (this.uVs != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uVs);
      }
      paramInt = i;
      if (this.wRt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wRt);
      }
      i = paramInt;
      if (this.FTJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FTJ);
      }
      paramInt = i;
      if (this.FTK != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FTK);
      }
      AppMethodBeat.o(72615);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72615);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        drm localdrm = (drm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72615);
          return -1;
        case 1: 
          localdrm.dlT = locala.OmT.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 2: 
          localdrm.hCp = locala.OmT.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 3: 
          localdrm.uVs = locala.OmT.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 4: 
          localdrm.wRt = locala.OmT.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 5: 
          localdrm.FTJ = locala.OmT.readString();
          AppMethodBeat.o(72615);
          return 0;
        }
        localdrm.FTK = locala.OmT.readString();
        AppMethodBeat.o(72615);
        return 0;
      }
      AppMethodBeat.o(72615);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drm
 * JD-Core Version:    0.7.0.1
 */