package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cth
  extends com.tencent.mm.bw.a
{
  public String COl;
  public String HEu;
  public String dwb;
  public String path;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91668);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.dwb != null) {
        paramVarArgs.d(2, this.dwb);
      }
      if (this.HEu != null) {
        paramVarArgs.d(3, this.HEu);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      if (this.COl != null) {
        paramVarArgs.d(5, this.COl);
      }
      AppMethodBeat.o(91668);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dwb);
      }
      i = paramInt;
      if (this.HEu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HEu);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.path);
      }
      i = paramInt;
      if (this.COl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.COl);
      }
      AppMethodBeat.o(91668);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91668);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cth localcth = (cth)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91668);
        return -1;
      case 1: 
        localcth.type = locala.OmT.zc();
        AppMethodBeat.o(91668);
        return 0;
      case 2: 
        localcth.dwb = locala.OmT.readString();
        AppMethodBeat.o(91668);
        return 0;
      case 3: 
        localcth.HEu = locala.OmT.readString();
        AppMethodBeat.o(91668);
        return 0;
      case 4: 
        localcth.path = locala.OmT.readString();
        AppMethodBeat.o(91668);
        return 0;
      }
      localcth.COl = locala.OmT.readString();
      AppMethodBeat.o(91668);
      return 0;
    }
    AppMethodBeat.o(91668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cth
 * JD-Core Version:    0.7.0.1
 */