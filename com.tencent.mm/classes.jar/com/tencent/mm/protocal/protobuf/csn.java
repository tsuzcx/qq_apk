package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csn
  extends com.tencent.mm.bx.a
{
  public String CwG;
  public String HkU;
  public String duW;
  public String path;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91668);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.duW != null) {
        paramVarArgs.d(2, this.duW);
      }
      if (this.HkU != null) {
        paramVarArgs.d(3, this.HkU);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      if (this.CwG != null) {
        paramVarArgs.d(5, this.CwG);
      }
      AppMethodBeat.o(91668);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.duW);
      }
      i = paramInt;
      if (this.HkU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HkU);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.path);
      }
      i = paramInt;
      if (this.CwG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CwG);
      }
      AppMethodBeat.o(91668);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91668);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      csn localcsn = (csn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91668);
        return -1;
      case 1: 
        localcsn.type = locala.NPN.zc();
        AppMethodBeat.o(91668);
        return 0;
      case 2: 
        localcsn.duW = locala.NPN.readString();
        AppMethodBeat.o(91668);
        return 0;
      case 3: 
        localcsn.HkU = locala.NPN.readString();
        AppMethodBeat.o(91668);
        return 0;
      case 4: 
        localcsn.path = locala.NPN.readString();
        AppMethodBeat.o(91668);
        return 0;
      }
      localcsn.CwG = locala.NPN.readString();
      AppMethodBeat.o(91668);
      return 0;
    }
    AppMethodBeat.o(91668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csn
 * JD-Core Version:    0.7.0.1
 */