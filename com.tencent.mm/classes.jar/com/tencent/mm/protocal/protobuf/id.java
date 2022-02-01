package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class id
  extends com.tencent.mm.bw.a
{
  public String BoQ;
  public String DVR;
  public String DVS;
  public String DVT;
  public String DVU;
  public String cZz;
  public String tGS;
  public String vwo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91355);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DVR != null) {
        paramVarArgs.d(1, this.DVR);
      }
      if (this.BoQ != null) {
        paramVarArgs.d(2, this.BoQ);
      }
      if (this.cZz != null) {
        paramVarArgs.d(3, this.cZz);
      }
      if (this.vwo != null) {
        paramVarArgs.d(4, this.vwo);
      }
      if (this.tGS != null) {
        paramVarArgs.d(5, this.tGS);
      }
      if (this.DVS != null) {
        paramVarArgs.d(6, this.DVS);
      }
      if (this.DVT != null) {
        paramVarArgs.d(7, this.DVT);
      }
      if (this.DVU != null) {
        paramVarArgs.d(8, this.DVU);
      }
      AppMethodBeat.o(91355);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DVR == null) {
        break label642;
      }
    }
    label642:
    for (int i = f.a.a.b.b.a.e(1, this.DVR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.BoQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.BoQ);
      }
      i = paramInt;
      if (this.cZz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.cZz);
      }
      paramInt = i;
      if (this.vwo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.vwo);
      }
      i = paramInt;
      if (this.tGS != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tGS);
      }
      paramInt = i;
      if (this.DVS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DVS);
      }
      i = paramInt;
      if (this.DVT != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DVT);
      }
      paramInt = i;
      if (this.DVU != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DVU);
      }
      AppMethodBeat.o(91355);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91355);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        id localid = (id)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91355);
          return -1;
        case 1: 
          localid.DVR = locala.LVo.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 2: 
          localid.BoQ = locala.LVo.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 3: 
          localid.cZz = locala.LVo.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 4: 
          localid.vwo = locala.LVo.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 5: 
          localid.tGS = locala.LVo.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 6: 
          localid.DVS = locala.LVo.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 7: 
          localid.DVT = locala.LVo.readString();
          AppMethodBeat.o(91355);
          return 0;
        }
        localid.DVU = locala.LVo.readString();
        AppMethodBeat.o(91355);
        return 0;
      }
      AppMethodBeat.o(91355);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.id
 * JD-Core Version:    0.7.0.1
 */