package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjy
  extends com.tencent.mm.bw.a
{
  public String EZv;
  public long EZw;
  public String EZx;
  public String EZy;
  public String EZz;
  public String EfL;
  public int state;
  public String title;
  public String wEw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72500);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EfL != null) {
        paramVarArgs.d(1, this.EfL);
      }
      paramVarArgs.aR(2, this.state);
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.EZv != null) {
        paramVarArgs.d(4, this.EZv);
      }
      paramVarArgs.aO(5, this.EZw);
      if (this.EZx != null) {
        paramVarArgs.d(6, this.EZx);
      }
      if (this.wEw != null) {
        paramVarArgs.d(7, this.wEw);
      }
      if (this.EZy != null) {
        paramVarArgs.d(8, this.EZy);
      }
      if (this.EZz != null) {
        paramVarArgs.d(9, this.EZz);
      }
      AppMethodBeat.o(72500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EfL == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.b.b.a.e(1, this.EfL) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.state);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.title);
      }
      i = paramInt;
      if (this.EZv != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EZv);
      }
      i += f.a.a.b.b.a.p(5, this.EZw);
      paramInt = i;
      if (this.EZx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EZx);
      }
      i = paramInt;
      if (this.wEw != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.wEw);
      }
      paramInt = i;
      if (this.EZy != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EZy);
      }
      i = paramInt;
      if (this.EZz != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EZz);
      }
      AppMethodBeat.o(72500);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72500);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bjy localbjy = (bjy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72500);
          return -1;
        case 1: 
          localbjy.EfL = locala.LVo.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 2: 
          localbjy.state = locala.LVo.xF();
          AppMethodBeat.o(72500);
          return 0;
        case 3: 
          localbjy.title = locala.LVo.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 4: 
          localbjy.EZv = locala.LVo.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 5: 
          localbjy.EZw = locala.LVo.xG();
          AppMethodBeat.o(72500);
          return 0;
        case 6: 
          localbjy.EZx = locala.LVo.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 7: 
          localbjy.wEw = locala.LVo.readString();
          AppMethodBeat.o(72500);
          return 0;
        case 8: 
          localbjy.EZy = locala.LVo.readString();
          AppMethodBeat.o(72500);
          return 0;
        }
        localbjy.EZz = locala.LVo.readString();
        AppMethodBeat.o(72500);
        return 0;
      }
      AppMethodBeat.o(72500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjy
 * JD-Core Version:    0.7.0.1
 */