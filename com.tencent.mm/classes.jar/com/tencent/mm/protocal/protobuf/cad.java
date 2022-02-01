package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cad
  extends com.tencent.mm.bw.a
{
  public String Euf;
  public String Eug;
  public int Fpf;
  public String Fpg;
  public String Fph;
  public String appId;
  public String bLs;
  public String fBV;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152637);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.d(1, this.userName);
      }
      if (this.bLs != null) {
        paramVarArgs.d(2, this.bLs);
      }
      if (this.fBV != null) {
        paramVarArgs.d(3, this.fBV);
      }
      if (this.Euf != null) {
        paramVarArgs.d(4, this.Euf);
      }
      if (this.Eug != null) {
        paramVarArgs.d(5, this.Eug);
      }
      paramVarArgs.aR(6, this.Fpf);
      if (this.appId != null) {
        paramVarArgs.d(7, this.appId);
      }
      if (this.Fpg != null) {
        paramVarArgs.d(8, this.Fpg);
      }
      if (this.Fph != null) {
        paramVarArgs.d(9, this.Fph);
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
    for (int i = f.a.a.b.b.a.e(1, this.userName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bLs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.bLs);
      }
      i = paramInt;
      if (this.fBV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.fBV);
      }
      paramInt = i;
      if (this.Euf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Euf);
      }
      i = paramInt;
      if (this.Eug != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Eug);
      }
      i += f.a.a.b.b.a.bx(6, this.Fpf);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.appId);
      }
      i = paramInt;
      if (this.Fpg != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Fpg);
      }
      paramInt = i;
      if (this.Fph != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Fph);
      }
      AppMethodBeat.o(152637);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152637);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cad localcad = (cad)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152637);
          return -1;
        case 1: 
          localcad.userName = locala.LVo.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 2: 
          localcad.bLs = locala.LVo.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 3: 
          localcad.fBV = locala.LVo.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 4: 
          localcad.Euf = locala.LVo.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 5: 
          localcad.Eug = locala.LVo.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 6: 
          localcad.Fpf = locala.LVo.xF();
          AppMethodBeat.o(152637);
          return 0;
        case 7: 
          localcad.appId = locala.LVo.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 8: 
          localcad.Fpg = locala.LVo.readString();
          AppMethodBeat.o(152637);
          return 0;
        }
        localcad.Fph = locala.LVo.readString();
        AppMethodBeat.o(152637);
        return 0;
      }
      AppMethodBeat.o(152637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cad
 * JD-Core Version:    0.7.0.1
 */