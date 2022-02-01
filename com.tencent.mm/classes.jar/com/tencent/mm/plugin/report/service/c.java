package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class c
  extends com.tencent.mm.bw.a
{
  public int fZv;
  public int ndI;
  public boolean wTF;
  public String wTM;
  public boolean wTN;
  public boolean wTO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143831);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wTM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Value");
        AppMethodBeat.o(143831);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.fZv);
      if (this.wTM != null) {
        paramVarArgs.d(2, this.wTM);
      }
      paramVarArgs.bl(3, this.wTN);
      paramVarArgs.bl(4, this.wTF);
      paramVarArgs.aR(5, this.ndI);
      paramVarArgs.bl(6, this.wTO);
      AppMethodBeat.o(143831);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.fZv) + 0;
      paramInt = i;
      if (this.wTM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.wTM);
      }
      i = f.a.a.b.b.a.fK(3);
      int j = f.a.a.b.b.a.fK(4);
      int k = f.a.a.b.b.a.bx(5, this.ndI);
      int m = f.a.a.b.b.a.fK(6);
      AppMethodBeat.o(143831);
      return paramInt + (i + 1) + (j + 1) + k + (m + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.wTM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Value");
        AppMethodBeat.o(143831);
        throw paramVarArgs;
      }
      AppMethodBeat.o(143831);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143831);
        return -1;
      case 1: 
        localc.fZv = locala.LVo.xF();
        AppMethodBeat.o(143831);
        return 0;
      case 2: 
        localc.wTM = locala.LVo.readString();
        AppMethodBeat.o(143831);
        return 0;
      case 3: 
        localc.wTN = locala.LVo.fZX();
        AppMethodBeat.o(143831);
        return 0;
      case 4: 
        localc.wTF = locala.LVo.fZX();
        AppMethodBeat.o(143831);
        return 0;
      case 5: 
        localc.ndI = locala.LVo.xF();
        AppMethodBeat.o(143831);
        return 0;
      }
      localc.wTO = locala.LVo.fZX();
      AppMethodBeat.o(143831);
      return 0;
    }
    AppMethodBeat.o(143831);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.c
 * JD-Core Version:    0.7.0.1
 */