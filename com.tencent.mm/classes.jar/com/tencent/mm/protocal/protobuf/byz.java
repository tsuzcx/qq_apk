package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byz
  extends com.tencent.mm.bx.a
{
  public String CRC;
  public int DVM;
  public String DVN;
  public String DVO;
  public String dlB;
  public String gGR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91579);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlB != null) {
        paramVarArgs.d(1, this.dlB);
      }
      paramVarArgs.aR(2, this.DVM);
      if (this.DVN != null) {
        paramVarArgs.d(3, this.DVN);
      }
      if (this.DVO != null) {
        paramVarArgs.d(4, this.DVO);
      }
      if (this.CRC != null) {
        paramVarArgs.d(5, this.CRC);
      }
      if (this.gGR != null) {
        paramVarArgs.d(6, this.gGR);
      }
      AppMethodBeat.o(91579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlB == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.dlB) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DVM);
      paramInt = i;
      if (this.DVN != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DVN);
      }
      i = paramInt;
      if (this.DVO != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DVO);
      }
      paramInt = i;
      if (this.CRC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CRC);
      }
      i = paramInt;
      if (this.gGR != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.gGR);
      }
      AppMethodBeat.o(91579);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91579);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        byz localbyz = (byz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91579);
          return -1;
        case 1: 
          localbyz.dlB = locala.KhF.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 2: 
          localbyz.DVM = locala.KhF.xS();
          AppMethodBeat.o(91579);
          return 0;
        case 3: 
          localbyz.DVN = locala.KhF.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 4: 
          localbyz.DVO = locala.KhF.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 5: 
          localbyz.CRC = locala.KhF.readString();
          AppMethodBeat.o(91579);
          return 0;
        }
        localbyz.gGR = locala.KhF.readString();
        AppMethodBeat.o(91579);
        return 0;
      }
      AppMethodBeat.o(91579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byz
 * JD-Core Version:    0.7.0.1
 */