package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qw
  extends com.tencent.mm.bw.a
{
  public int nWg;
  public String text;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113947);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.nWg);
      if (this.text != null) {
        paramVarArgs.d(2, this.text);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      AppMethodBeat.o(113947);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.nWg) + 0;
      paramInt = i;
      if (this.text != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.text);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      AppMethodBeat.o(113947);
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
      AppMethodBeat.o(113947);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      qw localqw = (qw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113947);
        return -1;
      case 1: 
        localqw.nWg = locala.LVo.xF();
        AppMethodBeat.o(113947);
        return 0;
      case 2: 
        localqw.text = locala.LVo.readString();
        AppMethodBeat.o(113947);
        return 0;
      }
      localqw.url = locala.LVo.readString();
      AppMethodBeat.o(113947);
      return 0;
    }
    AppMethodBeat.o(113947);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qw
 * JD-Core Version:    0.7.0.1
 */