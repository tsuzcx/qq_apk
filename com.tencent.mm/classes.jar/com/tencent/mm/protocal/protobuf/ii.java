package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ii
  extends com.tencent.mm.bw.a
{
  public String DVS;
  public String DVU;
  public boolean DWe;
  public String DWf;
  public String cZz;
  public String tGS;
  public String wEw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19405);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tGS != null) {
        paramVarArgs.d(1, this.tGS);
      }
      if (this.wEw != null) {
        paramVarArgs.d(2, this.wEw);
      }
      if (this.cZz != null) {
        paramVarArgs.d(3, this.cZz);
      }
      paramVarArgs.bl(4, this.DWe);
      if (this.DVU != null) {
        paramVarArgs.d(5, this.DVU);
      }
      if (this.DVS != null) {
        paramVarArgs.d(6, this.DVS);
      }
      if (this.DWf != null) {
        paramVarArgs.d(7, this.DWf);
      }
      AppMethodBeat.o(19405);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tGS == null) {
        break label575;
      }
    }
    label575:
    for (int i = f.a.a.b.b.a.e(1, this.tGS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wEw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.wEw);
      }
      i = paramInt;
      if (this.cZz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.cZz);
      }
      i += f.a.a.b.b.a.fK(4) + 1;
      paramInt = i;
      if (this.DVU != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DVU);
      }
      i = paramInt;
      if (this.DVS != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DVS);
      }
      paramInt = i;
      if (this.DWf != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DWf);
      }
      AppMethodBeat.o(19405);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(19405);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ii localii = (ii)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(19405);
          return -1;
        case 1: 
          localii.tGS = locala.LVo.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 2: 
          localii.wEw = locala.LVo.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 3: 
          localii.cZz = locala.LVo.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 4: 
          localii.DWe = locala.LVo.fZX();
          AppMethodBeat.o(19405);
          return 0;
        case 5: 
          localii.DVU = locala.LVo.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 6: 
          localii.DVS = locala.LVo.readString();
          AppMethodBeat.o(19405);
          return 0;
        }
        localii.DWf = locala.LVo.readString();
        AppMethodBeat.o(19405);
        return 0;
      }
      AppMethodBeat.o(19405);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ii
 * JD-Core Version:    0.7.0.1
 */