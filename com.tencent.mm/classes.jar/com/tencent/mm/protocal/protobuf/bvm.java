package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvm
  extends com.tencent.mm.bx.a
{
  public String AXm;
  public String XOv;
  public String ZWG;
  public String aacZ;
  public String aada;
  public String aadb;
  public String oDI;
  public String poiName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258836);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aacZ != null) {
        paramVarArgs.g(1, this.aacZ);
      }
      if (this.aada != null) {
        paramVarArgs.g(2, this.aada);
      }
      if (this.poiName != null) {
        paramVarArgs.g(3, this.poiName);
      }
      if (this.aadb != null) {
        paramVarArgs.g(4, this.aadb);
      }
      if (this.oDI != null) {
        paramVarArgs.g(5, this.oDI);
      }
      if (this.XOv != null) {
        paramVarArgs.g(6, this.XOv);
      }
      if (this.ZWG != null) {
        paramVarArgs.g(7, this.ZWG);
      }
      if (this.AXm != null) {
        paramVarArgs.g(8, this.AXm);
      }
      AppMethodBeat.o(258836);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aacZ == null) {
        break label638;
      }
    }
    label638:
    for (int i = i.a.a.b.b.a.h(1, this.aacZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aada != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aada);
      }
      i = paramInt;
      if (this.poiName != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.poiName);
      }
      paramInt = i;
      if (this.aadb != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aadb);
      }
      i = paramInt;
      if (this.oDI != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.oDI);
      }
      paramInt = i;
      if (this.XOv != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.XOv);
      }
      i = paramInt;
      if (this.ZWG != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZWG);
      }
      paramInt = i;
      if (this.AXm != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.AXm);
      }
      AppMethodBeat.o(258836);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258836);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bvm localbvm = (bvm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258836);
          return -1;
        case 1: 
          localbvm.aacZ = locala.ajGk.readString();
          AppMethodBeat.o(258836);
          return 0;
        case 2: 
          localbvm.aada = locala.ajGk.readString();
          AppMethodBeat.o(258836);
          return 0;
        case 3: 
          localbvm.poiName = locala.ajGk.readString();
          AppMethodBeat.o(258836);
          return 0;
        case 4: 
          localbvm.aadb = locala.ajGk.readString();
          AppMethodBeat.o(258836);
          return 0;
        case 5: 
          localbvm.oDI = locala.ajGk.readString();
          AppMethodBeat.o(258836);
          return 0;
        case 6: 
          localbvm.XOv = locala.ajGk.readString();
          AppMethodBeat.o(258836);
          return 0;
        case 7: 
          localbvm.ZWG = locala.ajGk.readString();
          AppMethodBeat.o(258836);
          return 0;
        }
        localbvm.AXm = locala.ajGk.readString();
        AppMethodBeat.o(258836);
        return 0;
      }
      AppMethodBeat.o(258836);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvm
 * JD-Core Version:    0.7.0.1
 */