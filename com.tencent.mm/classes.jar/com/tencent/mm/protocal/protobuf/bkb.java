package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkb
  extends com.tencent.mm.bv.a
{
  public String app_id;
  public String kwH;
  public String kwJ;
  public String uho;
  public String xyA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48915);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.e(1, this.app_id);
      }
      if (this.uho != null) {
        paramVarArgs.e(2, this.uho);
      }
      if (this.kwJ != null) {
        paramVarArgs.e(3, this.kwJ);
      }
      if (this.kwH != null) {
        paramVarArgs.e(4, this.kwH);
      }
      if (this.xyA != null) {
        paramVarArgs.e(5, this.xyA);
      }
      AppMethodBeat.o(48915);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label454;
      }
    }
    label454:
    for (int i = e.a.a.b.b.a.f(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uho != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.uho);
      }
      i = paramInt;
      if (this.kwJ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.kwJ);
      }
      paramInt = i;
      if (this.kwH != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.kwH);
      }
      i = paramInt;
      if (this.xyA != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xyA);
      }
      AppMethodBeat.o(48915);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48915);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bkb localbkb = (bkb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48915);
          return -1;
        case 1: 
          localbkb.app_id = locala.CLY.readString();
          AppMethodBeat.o(48915);
          return 0;
        case 2: 
          localbkb.uho = locala.CLY.readString();
          AppMethodBeat.o(48915);
          return 0;
        case 3: 
          localbkb.kwJ = locala.CLY.readString();
          AppMethodBeat.o(48915);
          return 0;
        case 4: 
          localbkb.kwH = locala.CLY.readString();
          AppMethodBeat.o(48915);
          return 0;
        }
        localbkb.xyA = locala.CLY.readString();
        AppMethodBeat.o(48915);
        return 0;
      }
      AppMethodBeat.o(48915);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkb
 * JD-Core Version:    0.7.0.1
 */