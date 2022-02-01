package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkd
  extends com.tencent.mm.bw.a
{
  public String cZz;
  public String tGS;
  public String wES;
  public String wET;
  public String wEU;
  public String wEV;
  public String wEw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72612);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wES != null) {
        paramVarArgs.d(1, this.wES);
      }
      if (this.wET != null) {
        paramVarArgs.d(2, this.wET);
      }
      if (this.wEw != null) {
        paramVarArgs.d(3, this.wEw);
      }
      if (this.tGS != null) {
        paramVarArgs.d(4, this.tGS);
      }
      if (this.cZz != null) {
        paramVarArgs.d(5, this.cZz);
      }
      if (this.wEU != null) {
        paramVarArgs.d(6, this.wEU);
      }
      if (this.wEV != null) {
        paramVarArgs.d(7, this.wEV);
      }
      AppMethodBeat.o(72612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wES == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.wES) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wET != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.wET);
      }
      i = paramInt;
      if (this.wEw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.wEw);
      }
      paramInt = i;
      if (this.tGS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tGS);
      }
      i = paramInt;
      if (this.cZz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.cZz);
      }
      paramInt = i;
      if (this.wEU != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.wEU);
      }
      i = paramInt;
      if (this.wEV != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.wEV);
      }
      AppMethodBeat.o(72612);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72612);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dkd localdkd = (dkd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72612);
          return -1;
        case 1: 
          localdkd.wES = locala.LVo.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 2: 
          localdkd.wET = locala.LVo.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 3: 
          localdkd.wEw = locala.LVo.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 4: 
          localdkd.tGS = locala.LVo.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 5: 
          localdkd.cZz = locala.LVo.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 6: 
          localdkd.wEU = locala.LVo.readString();
          AppMethodBeat.o(72612);
          return 0;
        }
        localdkd.wEV = locala.LVo.readString();
        AppMethodBeat.o(72612);
        return 0;
      }
      AppMethodBeat.o(72612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkd
 * JD-Core Version:    0.7.0.1
 */