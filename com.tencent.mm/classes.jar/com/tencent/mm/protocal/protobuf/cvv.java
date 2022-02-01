package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvv
  extends com.tencent.mm.bw.a
{
  public String LpH;
  public String LpI;
  public int MBo;
  public String MBp;
  public String MBq;
  public String appId;
  public String gCv;
  public String nickName;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152637);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.e(1, this.userName);
      }
      if (this.nickName != null) {
        paramVarArgs.e(2, this.nickName);
      }
      if (this.gCv != null) {
        paramVarArgs.e(3, this.gCv);
      }
      if (this.LpH != null) {
        paramVarArgs.e(4, this.LpH);
      }
      if (this.LpI != null) {
        paramVarArgs.e(5, this.LpI);
      }
      paramVarArgs.aM(6, this.MBo);
      if (this.appId != null) {
        paramVarArgs.e(7, this.appId);
      }
      if (this.MBp != null) {
        paramVarArgs.e(8, this.MBp);
      }
      if (this.MBq != null) {
        paramVarArgs.e(9, this.MBq);
      }
      AppMethodBeat.o(152637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label686;
      }
    }
    label686:
    for (int i = g.a.a.b.b.a.f(1, this.userName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.nickName);
      }
      i = paramInt;
      if (this.gCv != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.gCv);
      }
      paramInt = i;
      if (this.LpH != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LpH);
      }
      i = paramInt;
      if (this.LpI != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LpI);
      }
      i += g.a.a.b.b.a.bu(6, this.MBo);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.appId);
      }
      i = paramInt;
      if (this.MBp != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.MBp);
      }
      paramInt = i;
      if (this.MBq != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MBq);
      }
      AppMethodBeat.o(152637);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152637);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cvv localcvv = (cvv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152637);
          return -1;
        case 1: 
          localcvv.userName = locala.UbS.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 2: 
          localcvv.nickName = locala.UbS.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 3: 
          localcvv.gCv = locala.UbS.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 4: 
          localcvv.LpH = locala.UbS.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 5: 
          localcvv.LpI = locala.UbS.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 6: 
          localcvv.MBo = locala.UbS.zi();
          AppMethodBeat.o(152637);
          return 0;
        case 7: 
          localcvv.appId = locala.UbS.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 8: 
          localcvv.MBp = locala.UbS.readString();
          AppMethodBeat.o(152637);
          return 0;
        }
        localcvv.MBq = locala.UbS.readString();
        AppMethodBeat.o(152637);
        return 0;
      }
      AppMethodBeat.o(152637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvv
 * JD-Core Version:    0.7.0.1
 */