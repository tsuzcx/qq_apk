package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fh
  extends com.tencent.mm.bx.a
{
  public long CzW;
  public int CzX;
  public String CzY;
  public int CzZ;
  public int Scene;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6390);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.d(1, this.Url);
      }
      paramVarArgs.aG(2, this.CzW);
      paramVarArgs.aR(3, this.CzX);
      if (this.CzY != null) {
        paramVarArgs.d(4, this.CzY);
      }
      paramVarArgs.aR(5, this.Scene);
      paramVarArgs.aR(6, this.CzZ);
      AppMethodBeat.o(6390);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.CzW) + f.a.a.b.b.a.bA(3, this.CzX);
      paramInt = i;
      if (this.CzY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CzY);
      }
      i = f.a.a.b.b.a.bA(5, this.Scene);
      int j = f.a.a.b.b.a.bA(6, this.CzZ);
      AppMethodBeat.o(6390);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(6390);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        fh localfh = (fh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6390);
          return -1;
        case 1: 
          localfh.Url = locala.KhF.readString();
          AppMethodBeat.o(6390);
          return 0;
        case 2: 
          localfh.CzW = locala.KhF.xT();
          AppMethodBeat.o(6390);
          return 0;
        case 3: 
          localfh.CzX = locala.KhF.xS();
          AppMethodBeat.o(6390);
          return 0;
        case 4: 
          localfh.CzY = locala.KhF.readString();
          AppMethodBeat.o(6390);
          return 0;
        case 5: 
          localfh.Scene = locala.KhF.xS();
          AppMethodBeat.o(6390);
          return 0;
        }
        localfh.CzZ = locala.KhF.xS();
        AppMethodBeat.o(6390);
        return 0;
      }
      AppMethodBeat.o(6390);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fh
 * JD-Core Version:    0.7.0.1
 */