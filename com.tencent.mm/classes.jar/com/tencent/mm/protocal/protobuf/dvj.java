package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dvj
  extends com.tencent.mm.bx.a
{
  public int EJA;
  public boolean EJo;
  public String EJw;
  public b EJx;
  public int EJy;
  public int EJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50123);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.EJo);
      if (this.EJw != null) {
        paramVarArgs.d(2, this.EJw);
      }
      if (this.EJx != null) {
        paramVarArgs.c(3, this.EJx);
      }
      paramVarArgs.aR(4, this.EJy);
      paramVarArgs.aR(5, this.EJz);
      paramVarArgs.aR(6, this.EJA);
      AppMethodBeat.o(50123);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 1 + 0;
      paramInt = i;
      if (this.EJw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EJw);
      }
      i = paramInt;
      if (this.EJx != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.EJx);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.EJy);
      int j = f.a.a.b.b.a.bA(5, this.EJz);
      int k = f.a.a.b.b.a.bA(6, this.EJA);
      AppMethodBeat.o(50123);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(50123);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dvj localdvj = (dvj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50123);
        return -1;
      case 1: 
        localdvj.EJo = locala.KhF.fHu();
        AppMethodBeat.o(50123);
        return 0;
      case 2: 
        localdvj.EJw = locala.KhF.readString();
        AppMethodBeat.o(50123);
        return 0;
      case 3: 
        localdvj.EJx = locala.KhF.fMu();
        AppMethodBeat.o(50123);
        return 0;
      case 4: 
        localdvj.EJy = locala.KhF.xS();
        AppMethodBeat.o(50123);
        return 0;
      case 5: 
        localdvj.EJz = locala.KhF.xS();
        AppMethodBeat.o(50123);
        return 0;
      }
      localdvj.EJA = locala.KhF.xS();
      AppMethodBeat.o(50123);
      return 0;
    }
    AppMethodBeat.o(50123);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvj
 * JD-Core Version:    0.7.0.1
 */