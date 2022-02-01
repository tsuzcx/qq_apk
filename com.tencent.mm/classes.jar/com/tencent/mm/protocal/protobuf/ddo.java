package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddo
  extends com.tencent.mm.bx.a
{
  public int Height;
  public String HnT;
  public String Hsc;
  public String MD5;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32452);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.MD5 != null) {
        paramVarArgs.d(1, this.MD5);
      }
      paramVarArgs.aS(2, this.Width);
      paramVarArgs.aS(3, this.Height);
      if (this.HnT != null) {
        paramVarArgs.d(4, this.HnT);
      }
      if (this.Hsc != null) {
        paramVarArgs.d(5, this.Hsc);
      }
      AppMethodBeat.o(32452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label433;
      }
    }
    label433:
    for (paramInt = f.a.a.b.b.a.e(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Width) + f.a.a.b.b.a.bz(3, this.Height);
      paramInt = i;
      if (this.HnT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HnT);
      }
      i = paramInt;
      if (this.Hsc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hsc);
      }
      AppMethodBeat.o(32452);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32452);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ddo localddo = (ddo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32452);
          return -1;
        case 1: 
          localddo.MD5 = locala.NPN.readString();
          AppMethodBeat.o(32452);
          return 0;
        case 2: 
          localddo.Width = locala.NPN.zc();
          AppMethodBeat.o(32452);
          return 0;
        case 3: 
          localddo.Height = locala.NPN.zc();
          AppMethodBeat.o(32452);
          return 0;
        case 4: 
          localddo.HnT = locala.NPN.readString();
          AppMethodBeat.o(32452);
          return 0;
        }
        localddo.Hsc = locala.NPN.readString();
        AppMethodBeat.o(32452);
        return 0;
      }
      AppMethodBeat.o(32452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddo
 * JD-Core Version:    0.7.0.1
 */