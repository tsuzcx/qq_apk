package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bvz
  extends com.tencent.mm.bw.a
{
  public String Eof;
  public String Eog;
  public int Flw;
  public int Flx;
  public b Fly;
  public String Flz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32353);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Flw);
      paramVarArgs.aR(2, this.Flx);
      if (this.Fly != null) {
        paramVarArgs.c(3, this.Fly);
      }
      if (this.Flz != null) {
        paramVarArgs.d(4, this.Flz);
      }
      if (this.Eof != null) {
        paramVarArgs.d(5, this.Eof);
      }
      if (this.Eog != null) {
        paramVarArgs.d(6, this.Eog);
      }
      AppMethodBeat.o(32353);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Flw) + 0 + f.a.a.b.b.a.bx(2, this.Flx);
      paramInt = i;
      if (this.Fly != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.Fly);
      }
      i = paramInt;
      if (this.Flz != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Flz);
      }
      paramInt = i;
      if (this.Eof != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Eof);
      }
      i = paramInt;
      if (this.Eog != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Eog);
      }
      AppMethodBeat.o(32353);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32353);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bvz localbvz = (bvz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32353);
        return -1;
      case 1: 
        localbvz.Flw = locala.LVo.xF();
        AppMethodBeat.o(32353);
        return 0;
      case 2: 
        localbvz.Flx = locala.LVo.xF();
        AppMethodBeat.o(32353);
        return 0;
      case 3: 
        localbvz.Fly = locala.LVo.gfk();
        AppMethodBeat.o(32353);
        return 0;
      case 4: 
        localbvz.Flz = locala.LVo.readString();
        AppMethodBeat.o(32353);
        return 0;
      case 5: 
        localbvz.Eof = locala.LVo.readString();
        AppMethodBeat.o(32353);
        return 0;
      }
      localbvz.Eog = locala.LVo.readString();
      AppMethodBeat.o(32353);
      return 0;
    }
    AppMethodBeat.o(32353);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvz
 * JD-Core Version:    0.7.0.1
 */