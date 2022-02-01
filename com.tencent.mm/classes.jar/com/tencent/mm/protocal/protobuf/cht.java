package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class cht
  extends com.tencent.mm.bx.a
{
  public String CLI;
  public String CzY;
  public b Dvp;
  public b Dvq;
  public String Edl;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104831);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CLI != null) {
        paramVarArgs.d(1, this.CLI);
      }
      if (this.Edl != null) {
        paramVarArgs.d(2, this.Edl);
      }
      if (this.CzY != null) {
        paramVarArgs.d(3, this.CzY);
      }
      if (this.Dvq != null) {
        paramVarArgs.c(4, this.Dvq);
      }
      if (this.Dvp != null) {
        paramVarArgs.c(5, this.Dvp);
      }
      paramVarArgs.aR(6, this.Scene);
      AppMethodBeat.o(104831);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CLI == null) {
        break label502;
      }
    }
    label502:
    for (int i = f.a.a.b.b.a.e(1, this.CLI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Edl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Edl);
      }
      i = paramInt;
      if (this.CzY != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CzY);
      }
      paramInt = i;
      if (this.Dvq != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.Dvq);
      }
      i = paramInt;
      if (this.Dvp != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.Dvp);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.Scene);
      AppMethodBeat.o(104831);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(104831);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cht localcht = (cht)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104831);
          return -1;
        case 1: 
          localcht.CLI = locala.KhF.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 2: 
          localcht.Edl = locala.KhF.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 3: 
          localcht.CzY = locala.KhF.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 4: 
          localcht.Dvq = locala.KhF.fMu();
          AppMethodBeat.o(104831);
          return 0;
        case 5: 
          localcht.Dvp = locala.KhF.fMu();
          AppMethodBeat.o(104831);
          return 0;
        }
        localcht.Scene = locala.KhF.xS();
        AppMethodBeat.o(104831);
        return 0;
      }
      AppMethodBeat.o(104831);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cht
 * JD-Core Version:    0.7.0.1
 */