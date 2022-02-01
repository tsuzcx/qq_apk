package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bok
  extends com.tencent.mm.bw.a
{
  public String Ekn;
  public boolean FdJ;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91530);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.Ekn != null) {
        paramVarArgs.d(3, this.Ekn);
      }
      paramVarArgs.bl(4, this.FdJ);
      AppMethodBeat.o(91530);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.Ekn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ekn);
      }
      paramInt = f.a.a.b.b.a.fK(4);
      AppMethodBeat.o(91530);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91530);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bok localbok = (bok)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91530);
        return -1;
      case 1: 
        localbok.type = locala.LVo.xF();
        AppMethodBeat.o(91530);
        return 0;
      case 2: 
        localbok.url = locala.LVo.readString();
        AppMethodBeat.o(91530);
        return 0;
      case 3: 
        localbok.Ekn = locala.LVo.readString();
        AppMethodBeat.o(91530);
        return 0;
      }
      localbok.FdJ = locala.LVo.fZX();
      AppMethodBeat.o(91530);
      return 0;
    }
    AppMethodBeat.o(91530);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bok
 * JD-Core Version:    0.7.0.1
 */