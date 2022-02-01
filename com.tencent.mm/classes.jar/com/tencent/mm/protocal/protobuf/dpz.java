package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dpz
  extends com.tencent.mm.bw.a
{
  public int FXf;
  public String FXg;
  public String FXh;
  public int FXi;
  public String FXj;
  public int FXk;
  public int FXl;
  public String FXm;
  public String FXn;
  public String djj;
  public int gbd;
  public String hhs;
  public String title;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176157);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.djj != null) {
        paramVarArgs.d(2, this.djj);
      }
      paramVarArgs.aR(3, this.version);
      if (this.hhs != null) {
        paramVarArgs.d(4, this.hhs);
      }
      paramVarArgs.aR(5, this.FXf);
      if (this.FXg != null) {
        paramVarArgs.d(6, this.FXg);
      }
      if (this.FXh != null) {
        paramVarArgs.d(7, this.FXh);
      }
      paramVarArgs.aR(8, this.FXi);
      if (this.FXj != null) {
        paramVarArgs.d(9, this.FXj);
      }
      paramVarArgs.aR(10, this.gbd);
      paramVarArgs.aR(11, this.FXk);
      paramVarArgs.aR(12, this.FXl);
      if (this.FXm != null) {
        paramVarArgs.d(13, this.FXm);
      }
      if (this.FXn != null) {
        paramVarArgs.d(14, this.FXn);
      }
      AppMethodBeat.o(176157);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label914;
      }
    }
    label914:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.djj);
      }
      i += f.a.a.b.b.a.bx(3, this.version);
      paramInt = i;
      if (this.hhs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hhs);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.FXf);
      paramInt = i;
      if (this.FXg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FXg);
      }
      i = paramInt;
      if (this.FXh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FXh);
      }
      i += f.a.a.b.b.a.bx(8, this.FXi);
      paramInt = i;
      if (this.FXj != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FXj);
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.gbd) + f.a.a.b.b.a.bx(11, this.FXk) + f.a.a.b.b.a.bx(12, this.FXl);
      paramInt = i;
      if (this.FXm != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FXm);
      }
      i = paramInt;
      if (this.FXn != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.FXn);
      }
      AppMethodBeat.o(176157);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(176157);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dpz localdpz = (dpz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(176157);
          return -1;
        case 1: 
          localdpz.title = locala.LVo.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 2: 
          localdpz.djj = locala.LVo.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 3: 
          localdpz.version = locala.LVo.xF();
          AppMethodBeat.o(176157);
          return 0;
        case 4: 
          localdpz.hhs = locala.LVo.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 5: 
          localdpz.FXf = locala.LVo.xF();
          AppMethodBeat.o(176157);
          return 0;
        case 6: 
          localdpz.FXg = locala.LVo.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 7: 
          localdpz.FXh = locala.LVo.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 8: 
          localdpz.FXi = locala.LVo.xF();
          AppMethodBeat.o(176157);
          return 0;
        case 9: 
          localdpz.FXj = locala.LVo.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 10: 
          localdpz.gbd = locala.LVo.xF();
          AppMethodBeat.o(176157);
          return 0;
        case 11: 
          localdpz.FXk = locala.LVo.xF();
          AppMethodBeat.o(176157);
          return 0;
        case 12: 
          localdpz.FXl = locala.LVo.xF();
          AppMethodBeat.o(176157);
          return 0;
        case 13: 
          localdpz.FXm = locala.LVo.readString();
          AppMethodBeat.o(176157);
          return 0;
        }
        localdpz.FXn = locala.LVo.readString();
        AppMethodBeat.o(176157);
        return 0;
      }
      AppMethodBeat.o(176157);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpz
 * JD-Core Version:    0.7.0.1
 */