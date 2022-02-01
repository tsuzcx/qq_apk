package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccx
  extends com.tencent.mm.bx.a
{
  public String FIk;
  public String FNa;
  public String FSj;
  public String GXb;
  public int GXc;
  public String GXd;
  public int GXe;
  public int duration;
  public String hDo;
  public int height;
  public String hzm;
  public String title;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176147);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GXb != null) {
        paramVarArgs.d(1, this.GXb);
      }
      paramVarArgs.aS(2, this.duration);
      if (this.FIk != null) {
        paramVarArgs.d(3, this.FIk);
      }
      if (this.FSj != null) {
        paramVarArgs.d(4, this.FSj);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.hDo != null) {
        paramVarArgs.d(6, this.hDo);
      }
      paramVarArgs.aS(7, this.GXc);
      paramVarArgs.aS(8, this.width);
      paramVarArgs.aS(9, this.height);
      if (this.FNa != null) {
        paramVarArgs.d(10, this.FNa);
      }
      if (this.hzm != null) {
        paramVarArgs.d(11, this.hzm);
      }
      if (this.GXd != null) {
        paramVarArgs.d(12, this.GXd);
      }
      paramVarArgs.aS(13, this.GXe);
      AppMethodBeat.o(176147);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GXb == null) {
        break label866;
      }
    }
    label866:
    for (paramInt = f.a.a.b.b.a.e(1, this.GXb) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.duration);
      paramInt = i;
      if (this.FIk != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FIk);
      }
      i = paramInt;
      if (this.FSj != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FSj);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.title);
      }
      i = paramInt;
      if (this.hDo != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hDo);
      }
      i = i + f.a.a.b.b.a.bz(7, this.GXc) + f.a.a.b.b.a.bz(8, this.width) + f.a.a.b.b.a.bz(9, this.height);
      paramInt = i;
      if (this.FNa != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FNa);
      }
      i = paramInt;
      if (this.hzm != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.hzm);
      }
      paramInt = i;
      if (this.GXd != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GXd);
      }
      i = f.a.a.b.b.a.bz(13, this.GXe);
      AppMethodBeat.o(176147);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(176147);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ccx localccx = (ccx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(176147);
          return -1;
        case 1: 
          localccx.GXb = locala.NPN.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 2: 
          localccx.duration = locala.NPN.zc();
          AppMethodBeat.o(176147);
          return 0;
        case 3: 
          localccx.FIk = locala.NPN.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 4: 
          localccx.FSj = locala.NPN.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 5: 
          localccx.title = locala.NPN.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 6: 
          localccx.hDo = locala.NPN.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 7: 
          localccx.GXc = locala.NPN.zc();
          AppMethodBeat.o(176147);
          return 0;
        case 8: 
          localccx.width = locala.NPN.zc();
          AppMethodBeat.o(176147);
          return 0;
        case 9: 
          localccx.height = locala.NPN.zc();
          AppMethodBeat.o(176147);
          return 0;
        case 10: 
          localccx.FNa = locala.NPN.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 11: 
          localccx.hzm = locala.NPN.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 12: 
          localccx.GXd = locala.NPN.readString();
          AppMethodBeat.o(176147);
          return 0;
        }
        localccx.GXe = locala.NPN.zc();
        AppMethodBeat.o(176147);
        return 0;
      }
      AppMethodBeat.o(176147);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccx
 * JD-Core Version:    0.7.0.1
 */