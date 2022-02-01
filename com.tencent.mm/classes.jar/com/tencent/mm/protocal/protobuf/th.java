package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class th
  extends com.tencent.mm.bx.a
{
  public int FHr;
  public String FNA;
  public String text;
  public int type;
  public String url;
  public int yMB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113966);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.text != null) {
        paramVarArgs.d(2, this.text);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      paramVarArgs.aS(4, this.yMB);
      paramVarArgs.aS(5, this.FHr);
      if (this.FNA != null) {
        paramVarArgs.d(6, this.FNA);
      }
      AppMethodBeat.o(113966);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.text != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.text);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      i = i + f.a.a.b.b.a.bz(4, this.yMB) + f.a.a.b.b.a.bz(5, this.FHr);
      paramInt = i;
      if (this.FNA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FNA);
      }
      AppMethodBeat.o(113966);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(113966);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      th localth = (th)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113966);
        return -1;
      case 1: 
        localth.type = locala.NPN.zc();
        AppMethodBeat.o(113966);
        return 0;
      case 2: 
        localth.text = locala.NPN.readString();
        AppMethodBeat.o(113966);
        return 0;
      case 3: 
        localth.url = locala.NPN.readString();
        AppMethodBeat.o(113966);
        return 0;
      case 4: 
        localth.yMB = locala.NPN.zc();
        AppMethodBeat.o(113966);
        return 0;
      case 5: 
        localth.FHr = locala.NPN.zc();
        AppMethodBeat.o(113966);
        return 0;
      }
      localth.FNA = locala.NPN.readString();
      AppMethodBeat.o(113966);
      return 0;
    }
    AppMethodBeat.o(113966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.th
 * JD-Core Version:    0.7.0.1
 */