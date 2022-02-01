package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfd
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public String FtA;
  public int Ftl;
  public String Ftz;
  public String tkL;
  public String vxU;
  public String vxW;
  public String vxX;
  public int vxY;
  public String vxZ;
  public int vya;
  public int vyb;
  public String vyd;
  public String vye;
  public String vyf;
  public String vyg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91612);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vxU != null) {
        paramVarArgs.d(1, this.vxU);
      }
      paramVarArgs.aR(2, this.Ftl);
      if (this.vxW != null) {
        paramVarArgs.d(3, this.vxW);
      }
      paramVarArgs.aR(4, this.CreateTime);
      if (this.vxX != null) {
        paramVarArgs.d(5, this.vxX);
      }
      paramVarArgs.aR(6, this.vxY);
      if (this.vxZ != null) {
        paramVarArgs.d(7, this.vxZ);
      }
      paramVarArgs.aR(8, this.vya);
      paramVarArgs.aR(9, this.vyb);
      if (this.tkL != null) {
        paramVarArgs.d(11, this.tkL);
      }
      if (this.vyd != null) {
        paramVarArgs.d(12, this.vyd);
      }
      if (this.vye != null) {
        paramVarArgs.d(13, this.vye);
      }
      if (this.vyf != null) {
        paramVarArgs.d(14, this.vyf);
      }
      if (this.vyg != null) {
        paramVarArgs.d(15, this.vyg);
      }
      if (this.Ftz != null) {
        paramVarArgs.d(18, this.Ftz);
      }
      if (this.FtA != null) {
        paramVarArgs.d(19, this.FtA);
      }
      AppMethodBeat.o(91612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vxU == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = f.a.a.b.b.a.e(1, this.vxU) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Ftl);
      paramInt = i;
      if (this.vxW != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.vxW);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.CreateTime);
      paramInt = i;
      if (this.vxX != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vxX);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.vxY);
      paramInt = i;
      if (this.vxZ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vxZ);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.vya) + f.a.a.b.b.a.bx(9, this.vyb);
      paramInt = i;
      if (this.tkL != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.tkL);
      }
      i = paramInt;
      if (this.vyd != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.vyd);
      }
      paramInt = i;
      if (this.vye != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.vye);
      }
      i = paramInt;
      if (this.vyf != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.vyf);
      }
      paramInt = i;
      if (this.vyg != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.vyg);
      }
      i = paramInt;
      if (this.Ftz != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.Ftz);
      }
      paramInt = i;
      if (this.FtA != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.FtA);
      }
      AppMethodBeat.o(91612);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91612);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cfd localcfd = (cfd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 16: 
        case 17: 
        default: 
          AppMethodBeat.o(91612);
          return -1;
        case 1: 
          localcfd.vxU = locala.LVo.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 2: 
          localcfd.Ftl = locala.LVo.xF();
          AppMethodBeat.o(91612);
          return 0;
        case 3: 
          localcfd.vxW = locala.LVo.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 4: 
          localcfd.CreateTime = locala.LVo.xF();
          AppMethodBeat.o(91612);
          return 0;
        case 5: 
          localcfd.vxX = locala.LVo.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 6: 
          localcfd.vxY = locala.LVo.xF();
          AppMethodBeat.o(91612);
          return 0;
        case 7: 
          localcfd.vxZ = locala.LVo.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 8: 
          localcfd.vya = locala.LVo.xF();
          AppMethodBeat.o(91612);
          return 0;
        case 9: 
          localcfd.vyb = locala.LVo.xF();
          AppMethodBeat.o(91612);
          return 0;
        case 11: 
          localcfd.tkL = locala.LVo.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 12: 
          localcfd.vyd = locala.LVo.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 13: 
          localcfd.vye = locala.LVo.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 14: 
          localcfd.vyf = locala.LVo.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 15: 
          localcfd.vyg = locala.LVo.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 18: 
          localcfd.Ftz = locala.LVo.readString();
          AppMethodBeat.o(91612);
          return 0;
        }
        localcfd.FtA = locala.LVo.readString();
        AppMethodBeat.o(91612);
        return 0;
      }
      AppMethodBeat.o(91612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfd
 * JD-Core Version:    0.7.0.1
 */