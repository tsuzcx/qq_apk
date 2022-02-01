package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byg
  extends com.tencent.mm.bw.a
{
  public String Ecn;
  public String EgB;
  public String Ela;
  public String Fns;
  public int Fnt;
  public String Fnu;
  public int Fnv;
  public int duration;
  public int height;
  public String hhd;
  public String hlf;
  public String title;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176147);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fns != null) {
        paramVarArgs.d(1, this.Fns);
      }
      paramVarArgs.aR(2, this.duration);
      if (this.Ecn != null) {
        paramVarArgs.d(3, this.Ecn);
      }
      if (this.Ela != null) {
        paramVarArgs.d(4, this.Ela);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.hlf != null) {
        paramVarArgs.d(6, this.hlf);
      }
      paramVarArgs.aR(7, this.Fnt);
      paramVarArgs.aR(8, this.width);
      paramVarArgs.aR(9, this.height);
      if (this.EgB != null) {
        paramVarArgs.d(10, this.EgB);
      }
      if (this.hhd != null) {
        paramVarArgs.d(11, this.hhd);
      }
      if (this.Fnu != null) {
        paramVarArgs.d(12, this.Fnu);
      }
      paramVarArgs.aR(13, this.Fnv);
      AppMethodBeat.o(176147);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fns == null) {
        break label866;
      }
    }
    label866:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fns) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.duration);
      paramInt = i;
      if (this.Ecn != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Ecn);
      }
      i = paramInt;
      if (this.Ela != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Ela);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.title);
      }
      i = paramInt;
      if (this.hlf != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hlf);
      }
      i = i + f.a.a.b.b.a.bx(7, this.Fnt) + f.a.a.b.b.a.bx(8, this.width) + f.a.a.b.b.a.bx(9, this.height);
      paramInt = i;
      if (this.EgB != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.EgB);
      }
      i = paramInt;
      if (this.hhd != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.hhd);
      }
      paramInt = i;
      if (this.Fnu != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Fnu);
      }
      i = f.a.a.b.b.a.bx(13, this.Fnv);
      AppMethodBeat.o(176147);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(176147);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        byg localbyg = (byg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(176147);
          return -1;
        case 1: 
          localbyg.Fns = locala.LVo.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 2: 
          localbyg.duration = locala.LVo.xF();
          AppMethodBeat.o(176147);
          return 0;
        case 3: 
          localbyg.Ecn = locala.LVo.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 4: 
          localbyg.Ela = locala.LVo.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 5: 
          localbyg.title = locala.LVo.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 6: 
          localbyg.hlf = locala.LVo.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 7: 
          localbyg.Fnt = locala.LVo.xF();
          AppMethodBeat.o(176147);
          return 0;
        case 8: 
          localbyg.width = locala.LVo.xF();
          AppMethodBeat.o(176147);
          return 0;
        case 9: 
          localbyg.height = locala.LVo.xF();
          AppMethodBeat.o(176147);
          return 0;
        case 10: 
          localbyg.EgB = locala.LVo.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 11: 
          localbyg.hhd = locala.LVo.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 12: 
          localbyg.Fnu = locala.LVo.readString();
          AppMethodBeat.o(176147);
          return 0;
        }
        localbyg.Fnv = locala.LVo.xF();
        AppMethodBeat.o(176147);
        return 0;
      }
      AppMethodBeat.o(176147);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byg
 * JD-Core Version:    0.7.0.1
 */