package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eaw
  extends com.tencent.mm.bx.a
{
  public String ozD;
  public String pkr;
  public int type;
  public String wCQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207261);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.wCQ != null) {
        paramVarArgs.d(2, this.wCQ);
      }
      if (this.pkr != null) {
        paramVarArgs.d(3, this.pkr);
      }
      if (this.ozD != null) {
        paramVarArgs.d(4, this.ozD);
      }
      AppMethodBeat.o(207261);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.wCQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.wCQ);
      }
      i = paramInt;
      if (this.pkr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pkr);
      }
      paramInt = i;
      if (this.ozD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ozD);
      }
      AppMethodBeat.o(207261);
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
      AppMethodBeat.o(207261);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eaw localeaw = (eaw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207261);
        return -1;
      case 1: 
        localeaw.type = locala.NPN.zc();
        AppMethodBeat.o(207261);
        return 0;
      case 2: 
        localeaw.wCQ = locala.NPN.readString();
        AppMethodBeat.o(207261);
        return 0;
      case 3: 
        localeaw.pkr = locala.NPN.readString();
        AppMethodBeat.o(207261);
        return 0;
      }
      localeaw.ozD = locala.NPN.readString();
      AppMethodBeat.o(207261);
      return 0;
    }
    AppMethodBeat.o(207261);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaw
 * JD-Core Version:    0.7.0.1
 */