package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agw
  extends com.tencent.mm.bw.a
{
  public String Eay;
  public String EhA;
  public int EhB;
  public String EoA;
  public int EoB;
  public String Eoy;
  public String Eoz;
  public String EyW;
  public int EyX;
  public int ndj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127456);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eoy != null) {
        paramVarArgs.d(1, this.Eoy);
      }
      if (this.Eoz != null) {
        paramVarArgs.d(2, this.Eoz);
      }
      if (this.EoA != null) {
        paramVarArgs.d(3, this.EoA);
      }
      paramVarArgs.aR(4, this.EoB);
      if (this.EyW != null) {
        paramVarArgs.d(5, this.EyW);
      }
      if (this.EhA != null) {
        paramVarArgs.d(6, this.EhA);
      }
      paramVarArgs.aR(7, this.EhB);
      if (this.Eay != null) {
        paramVarArgs.d(8, this.Eay);
      }
      paramVarArgs.aR(9, this.ndj);
      paramVarArgs.aR(10, this.EyX);
      AppMethodBeat.o(127456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eoy == null) {
        break label702;
      }
    }
    label702:
    for (int i = f.a.a.b.b.a.e(1, this.Eoy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Eoz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Eoz);
      }
      i = paramInt;
      if (this.EoA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EoA);
      }
      i += f.a.a.b.b.a.bx(4, this.EoB);
      paramInt = i;
      if (this.EyW != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EyW);
      }
      i = paramInt;
      if (this.EhA != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.EhA);
      }
      i += f.a.a.b.b.a.bx(7, this.EhB);
      paramInt = i;
      if (this.Eay != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Eay);
      }
      i = f.a.a.b.b.a.bx(9, this.ndj);
      int j = f.a.a.b.b.a.bx(10, this.EyX);
      AppMethodBeat.o(127456);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127456);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        agw localagw = (agw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127456);
          return -1;
        case 1: 
          localagw.Eoy = locala.LVo.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 2: 
          localagw.Eoz = locala.LVo.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 3: 
          localagw.EoA = locala.LVo.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 4: 
          localagw.EoB = locala.LVo.xF();
          AppMethodBeat.o(127456);
          return 0;
        case 5: 
          localagw.EyW = locala.LVo.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 6: 
          localagw.EhA = locala.LVo.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 7: 
          localagw.EhB = locala.LVo.xF();
          AppMethodBeat.o(127456);
          return 0;
        case 8: 
          localagw.Eay = locala.LVo.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 9: 
          localagw.ndj = locala.LVo.xF();
          AppMethodBeat.o(127456);
          return 0;
        }
        localagw.EyX = locala.LVo.xF();
        AppMethodBeat.o(127456);
        return 0;
      }
      AppMethodBeat.o(127456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agw
 * JD-Core Version:    0.7.0.1
 */