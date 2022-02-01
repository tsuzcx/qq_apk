package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rn
  extends com.tencent.mm.bw.a
{
  public int EbF;
  public String EjH;
  public String text;
  public int type;
  public String url;
  public int xxQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113966);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.text != null) {
        paramVarArgs.d(2, this.text);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      paramVarArgs.aR(4, this.xxQ);
      paramVarArgs.aR(5, this.EbF);
      if (this.EjH != null) {
        paramVarArgs.d(6, this.EjH);
      }
      AppMethodBeat.o(113966);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.text != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.text);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      i = i + f.a.a.b.b.a.bx(4, this.xxQ) + f.a.a.b.b.a.bx(5, this.EbF);
      paramInt = i;
      if (this.EjH != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EjH);
      }
      AppMethodBeat.o(113966);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(113966);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      rn localrn = (rn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113966);
        return -1;
      case 1: 
        localrn.type = locala.LVo.xF();
        AppMethodBeat.o(113966);
        return 0;
      case 2: 
        localrn.text = locala.LVo.readString();
        AppMethodBeat.o(113966);
        return 0;
      case 3: 
        localrn.url = locala.LVo.readString();
        AppMethodBeat.o(113966);
        return 0;
      case 4: 
        localrn.xxQ = locala.LVo.xF();
        AppMethodBeat.o(113966);
        return 0;
      case 5: 
        localrn.EbF = locala.LVo.xF();
        AppMethodBeat.o(113966);
        return 0;
      }
      localrn.EjH = locala.LVo.readString();
      AppMethodBeat.o(113966);
      return 0;
    }
    AppMethodBeat.o(113966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rn
 * JD-Core Version:    0.7.0.1
 */