package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahs
  extends com.tencent.mm.bx.a
{
  public int Gfh;
  public int defaultValue;
  public String key;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.aS(3, this.defaultValue);
      paramVarArgs.aS(4, this.Gfh);
      AppMethodBeat.o(195470);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.title);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.defaultValue);
      int j = f.a.a.b.b.a.bz(4, this.Gfh);
      AppMethodBeat.o(195470);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(195470);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ahs localahs = (ahs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195470);
          return -1;
        case 1: 
          localahs.key = locala.NPN.readString();
          AppMethodBeat.o(195470);
          return 0;
        case 2: 
          localahs.title = locala.NPN.readString();
          AppMethodBeat.o(195470);
          return 0;
        case 3: 
          localahs.defaultValue = locala.NPN.zc();
          AppMethodBeat.o(195470);
          return 0;
        }
        localahs.Gfh = locala.NPN.zc();
        AppMethodBeat.o(195470);
        return 0;
      }
      AppMethodBeat.o(195470);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahs
 * JD-Core Version:    0.7.0.1
 */