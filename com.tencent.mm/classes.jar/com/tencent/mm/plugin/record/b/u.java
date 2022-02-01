package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class u
  extends com.tencent.mm.bw.a
{
  public int dzh;
  public String hym;
  public int id;
  public int status;
  public String wjF;
  public b wjG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(27828);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.id);
      paramVarArgs.aR(2, this.status);
      if (this.wjF != null) {
        paramVarArgs.d(3, this.wjF);
      }
      if (this.hym != null) {
        paramVarArgs.d(4, this.hym);
      }
      if (this.wjG != null) {
        paramVarArgs.c(5, this.wjG);
      }
      paramVarArgs.aR(6, this.dzh);
      AppMethodBeat.o(27828);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.id) + 0 + f.a.a.b.b.a.bx(2, this.status);
      paramInt = i;
      if (this.wjF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.wjF);
      }
      i = paramInt;
      if (this.hym != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.hym);
      }
      paramInt = i;
      if (this.wjG != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.wjG);
      }
      i = f.a.a.b.b.a.bx(6, this.dzh);
      AppMethodBeat.o(27828);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(27828);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      u localu = (u)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(27828);
        return -1;
      case 1: 
        localu.id = locala.LVo.xF();
        AppMethodBeat.o(27828);
        return 0;
      case 2: 
        localu.status = locala.LVo.xF();
        AppMethodBeat.o(27828);
        return 0;
      case 3: 
        localu.wjF = locala.LVo.readString();
        AppMethodBeat.o(27828);
        return 0;
      case 4: 
        localu.hym = locala.LVo.readString();
        AppMethodBeat.o(27828);
        return 0;
      case 5: 
        localu.wjG = locala.LVo.gfk();
        AppMethodBeat.o(27828);
        return 0;
      }
      localu.dzh = locala.LVo.xF();
      AppMethodBeat.o(27828);
      return 0;
    }
    AppMethodBeat.o(27828);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.u
 * JD-Core Version:    0.7.0.1
 */