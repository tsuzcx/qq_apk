package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddx
  extends com.tencent.mm.bw.a
{
  public String Bof;
  public int Ewn;
  public long FNB;
  public boolean FNC;
  public LinkedList<String> FND;
  public LinkedList<String> FNE;
  public int wri;
  
  public ddx()
  {
    AppMethodBeat.i(118452);
    this.FND = new LinkedList();
    this.FNE = new LinkedList();
    AppMethodBeat.o(118452);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118453);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.FNB);
      paramVarArgs.aR(2, this.wri);
      paramVarArgs.aR(3, this.Ewn);
      paramVarArgs.bl(4, this.FNC);
      paramVarArgs.e(5, 1, this.FND);
      paramVarArgs.e(6, 1, this.FNE);
      if (this.Bof != null) {
        paramVarArgs.d(7, this.Bof);
      }
      AppMethodBeat.o(118453);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.FNB) + 0 + f.a.a.b.b.a.bx(2, this.wri) + f.a.a.b.b.a.bx(3, this.Ewn) + (f.a.a.b.b.a.fK(4) + 1) + f.a.a.a.c(5, 1, this.FND) + f.a.a.a.c(6, 1, this.FNE);
      paramInt = i;
      if (this.Bof != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Bof);
      }
      AppMethodBeat.o(118453);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FND.clear();
      this.FNE.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(118453);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ddx localddx = (ddx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118453);
        return -1;
      case 1: 
        localddx.FNB = locala.LVo.xG();
        AppMethodBeat.o(118453);
        return 0;
      case 2: 
        localddx.wri = locala.LVo.xF();
        AppMethodBeat.o(118453);
        return 0;
      case 3: 
        localddx.Ewn = locala.LVo.xF();
        AppMethodBeat.o(118453);
        return 0;
      case 4: 
        localddx.FNC = locala.LVo.fZX();
        AppMethodBeat.o(118453);
        return 0;
      case 5: 
        localddx.FND.add(locala.LVo.readString());
        AppMethodBeat.o(118453);
        return 0;
      case 6: 
        localddx.FNE.add(locala.LVo.readString());
        AppMethodBeat.o(118453);
        return 0;
      }
      localddx.Bof = locala.LVo.readString();
      AppMethodBeat.o(118453);
      return 0;
    }
    AppMethodBeat.o(118453);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddx
 * JD-Core Version:    0.7.0.1
 */