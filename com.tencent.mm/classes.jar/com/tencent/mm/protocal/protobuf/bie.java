package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bie
  extends com.tencent.mm.bw.a
{
  public String DXY;
  public String ELg;
  public String EXv;
  public String EXw;
  public int Ret;
  public String ncR;
  public String ndW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DXY != null) {
        paramVarArgs.d(1, this.DXY);
      }
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      if (this.EXv != null) {
        paramVarArgs.d(3, this.EXv);
      }
      if (this.EXw != null) {
        paramVarArgs.d(4, this.EXw);
      }
      paramVarArgs.aR(5, this.Ret);
      if (this.ndW != null) {
        paramVarArgs.d(6, this.ndW);
      }
      if (this.ELg != null) {
        paramVarArgs.d(7, this.ELg);
      }
      AppMethodBeat.o(155421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DXY == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.DXY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ncR);
      }
      i = paramInt;
      if (this.EXv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EXv);
      }
      paramInt = i;
      if (this.EXw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EXw);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.Ret);
      paramInt = i;
      if (this.ndW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ndW);
      }
      i = paramInt;
      if (this.ELg != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ELg);
      }
      AppMethodBeat.o(155421);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(155421);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bie localbie = (bie)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155421);
          return -1;
        case 1: 
          localbie.DXY = locala.LVo.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 2: 
          localbie.ncR = locala.LVo.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 3: 
          localbie.EXv = locala.LVo.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 4: 
          localbie.EXw = locala.LVo.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 5: 
          localbie.Ret = locala.LVo.xF();
          AppMethodBeat.o(155421);
          return 0;
        case 6: 
          localbie.ndW = locala.LVo.readString();
          AppMethodBeat.o(155421);
          return 0;
        }
        localbie.ELg = locala.LVo.readString();
        AppMethodBeat.o(155421);
        return 0;
      }
      AppMethodBeat.o(155421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bie
 * JD-Core Version:    0.7.0.1
 */