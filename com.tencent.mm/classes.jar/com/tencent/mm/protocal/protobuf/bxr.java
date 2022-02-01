package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxr
  extends com.tencent.mm.bx.a
{
  public int DAQ;
  public boolean Dtn;
  public boolean Dto;
  public String DyR;
  public int DyU;
  public String dlB;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123633);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlB != null) {
        paramVarArgs.d(1, this.dlB);
      }
      if (this.DyR != null) {
        paramVarArgs.d(2, this.DyR);
      }
      paramVarArgs.aR(3, this.DyU);
      paramVarArgs.aR(4, this.version);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(6, this.md5);
      }
      paramVarArgs.bg(20, this.Dtn);
      paramVarArgs.bg(21, this.Dto);
      paramVarArgs.aR(22, this.DAQ);
      AppMethodBeat.o(123633);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlB == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = f.a.a.b.b.a.e(1, this.dlB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DyR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DyR);
      }
      i = i + f.a.a.b.b.a.bA(3, this.DyU) + f.a.a.b.b.a.bA(4, this.version);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.md5);
      }
      paramInt = f.a.a.b.b.a.fY(20);
      int j = f.a.a.b.b.a.fY(21);
      int k = f.a.a.b.b.a.bA(22, this.DAQ);
      AppMethodBeat.o(123633);
      return i + (paramInt + 1) + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123633);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxr localbxr = (bxr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123633);
          return -1;
        case 1: 
          localbxr.dlB = locala.KhF.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 2: 
          localbxr.DyR = locala.KhF.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 3: 
          localbxr.DyU = locala.KhF.xS();
          AppMethodBeat.o(123633);
          return 0;
        case 4: 
          localbxr.version = locala.KhF.xS();
          AppMethodBeat.o(123633);
          return 0;
        case 5: 
          localbxr.url = locala.KhF.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 6: 
          localbxr.md5 = locala.KhF.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 20: 
          localbxr.Dtn = locala.KhF.fHu();
          AppMethodBeat.o(123633);
          return 0;
        case 21: 
          localbxr.Dto = locala.KhF.fHu();
          AppMethodBeat.o(123633);
          return 0;
        }
        localbxr.DAQ = locala.KhF.xS();
        AppMethodBeat.o(123633);
        return 0;
      }
      AppMethodBeat.o(123633);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxr
 * JD-Core Version:    0.7.0.1
 */