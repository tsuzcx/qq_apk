package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dsa
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String CxC;
  public int DOf;
  public int EGL;
  public int mAK;
  public int mBH;
  public String sdP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32560);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sdP != null) {
        paramVarArgs.d(1, this.sdP);
      }
      paramVarArgs.aR(2, this.mBH);
      paramVarArgs.aR(3, this.mAK);
      paramVarArgs.aR(4, this.CreateTime);
      paramVarArgs.aR(5, this.DOf);
      if (this.CxC != null) {
        paramVarArgs.d(6, this.CxC);
      }
      paramVarArgs.aR(7, this.EGL);
      AppMethodBeat.o(32560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sdP == null) {
        break label507;
      }
    }
    label507:
    for (paramInt = f.a.a.b.b.a.e(1, this.sdP) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mBH) + f.a.a.b.b.a.bA(3, this.mAK) + f.a.a.b.b.a.bA(4, this.CreateTime) + f.a.a.b.b.a.bA(5, this.DOf);
      paramInt = i;
      if (this.CxC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CxC);
      }
      i = f.a.a.b.b.a.bA(7, this.EGL);
      AppMethodBeat.o(32560);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32560);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dsa localdsa = (dsa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32560);
          return -1;
        case 1: 
          localdsa.sdP = locala.KhF.readString();
          AppMethodBeat.o(32560);
          return 0;
        case 2: 
          localdsa.mBH = locala.KhF.xS();
          AppMethodBeat.o(32560);
          return 0;
        case 3: 
          localdsa.mAK = locala.KhF.xS();
          AppMethodBeat.o(32560);
          return 0;
        case 4: 
          localdsa.CreateTime = locala.KhF.xS();
          AppMethodBeat.o(32560);
          return 0;
        case 5: 
          localdsa.DOf = locala.KhF.xS();
          AppMethodBeat.o(32560);
          return 0;
        case 6: 
          localdsa.CxC = locala.KhF.readString();
          AppMethodBeat.o(32560);
          return 0;
        }
        localdsa.EGL = locala.KhF.xS();
        AppMethodBeat.o(32560);
        return 0;
      }
      AppMethodBeat.o(32560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsa
 * JD-Core Version:    0.7.0.1
 */