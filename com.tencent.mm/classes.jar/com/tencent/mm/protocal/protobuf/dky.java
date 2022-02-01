package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dky
  extends com.tencent.mm.bw.a
{
  public String DVS;
  public String DVT;
  public String cZz;
  public String hhs;
  public String tGS;
  public String vwo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72615);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.cZz != null) {
        paramVarArgs.d(1, this.cZz);
      }
      if (this.hhs != null) {
        paramVarArgs.d(2, this.hhs);
      }
      if (this.tGS != null) {
        paramVarArgs.d(3, this.tGS);
      }
      if (this.vwo != null) {
        paramVarArgs.d(4, this.vwo);
      }
      if (this.DVS != null) {
        paramVarArgs.d(5, this.DVS);
      }
      if (this.DVT != null) {
        paramVarArgs.d(6, this.DVT);
      }
      AppMethodBeat.o(72615);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cZz == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.cZz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hhs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hhs);
      }
      i = paramInt;
      if (this.tGS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tGS);
      }
      paramInt = i;
      if (this.vwo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.vwo);
      }
      i = paramInt;
      if (this.DVS != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DVS);
      }
      paramInt = i;
      if (this.DVT != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DVT);
      }
      AppMethodBeat.o(72615);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72615);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dky localdky = (dky)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72615);
          return -1;
        case 1: 
          localdky.cZz = locala.LVo.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 2: 
          localdky.hhs = locala.LVo.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 3: 
          localdky.tGS = locala.LVo.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 4: 
          localdky.vwo = locala.LVo.readString();
          AppMethodBeat.o(72615);
          return 0;
        case 5: 
          localdky.DVS = locala.LVo.readString();
          AppMethodBeat.o(72615);
          return 0;
        }
        localdky.DVT = locala.LVo.readString();
        AppMethodBeat.o(72615);
        return 0;
      }
      AppMethodBeat.o(72615);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dky
 * JD-Core Version:    0.7.0.1
 */