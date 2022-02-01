package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfe
  extends com.tencent.mm.bw.a
{
  public String FtB;
  public String FtC;
  public String FtD;
  public String FtE;
  public boolean FtF;
  public String FtG;
  public String cZz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72547);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FtB != null) {
        paramVarArgs.d(1, this.FtB);
      }
      if (this.FtC != null) {
        paramVarArgs.d(2, this.FtC);
      }
      if (this.cZz != null) {
        paramVarArgs.d(3, this.cZz);
      }
      if (this.FtD != null) {
        paramVarArgs.d(4, this.FtD);
      }
      if (this.FtE != null) {
        paramVarArgs.d(5, this.FtE);
      }
      paramVarArgs.bl(6, this.FtF);
      if (this.FtG != null) {
        paramVarArgs.d(7, this.FtG);
      }
      AppMethodBeat.o(72547);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FtB == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.FtB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FtC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FtC);
      }
      i = paramInt;
      if (this.cZz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.cZz);
      }
      paramInt = i;
      if (this.FtD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FtD);
      }
      i = paramInt;
      if (this.FtE != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FtE);
      }
      i += f.a.a.b.b.a.fK(6) + 1;
      paramInt = i;
      if (this.FtG != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FtG);
      }
      AppMethodBeat.o(72547);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72547);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cfe localcfe = (cfe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72547);
          return -1;
        case 1: 
          localcfe.FtB = locala.LVo.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 2: 
          localcfe.FtC = locala.LVo.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 3: 
          localcfe.cZz = locala.LVo.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 4: 
          localcfe.FtD = locala.LVo.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 5: 
          localcfe.FtE = locala.LVo.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 6: 
          localcfe.FtF = locala.LVo.fZX();
          AppMethodBeat.o(72547);
          return 0;
        }
        localcfe.FtG = locala.LVo.readString();
        AppMethodBeat.o(72547);
        return 0;
      }
      AppMethodBeat.o(72547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfe
 * JD-Core Version:    0.7.0.1
 */