package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byi
  extends com.tencent.mm.bx.a
{
  public String DUZ;
  public String DVa;
  public String Desc;
  public String IconUrl;
  public String Title;
  public int rNX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117888);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DUZ != null) {
        paramVarArgs.d(1, this.DUZ);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(4, this.IconUrl);
      }
      if (this.DVa != null) {
        paramVarArgs.d(5, this.DVa);
      }
      paramVarArgs.aR(6, this.rNX);
      AppMethodBeat.o(117888);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DUZ == null) {
        break label502;
      }
    }
    label502:
    for (int i = f.a.a.b.b.a.e(1, this.DUZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Desc);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.IconUrl);
      }
      i = paramInt;
      if (this.DVa != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DVa);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.rNX);
      AppMethodBeat.o(117888);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117888);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        byi localbyi = (byi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117888);
          return -1;
        case 1: 
          localbyi.DUZ = locala.KhF.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 2: 
          localbyi.Title = locala.KhF.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 3: 
          localbyi.Desc = locala.KhF.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 4: 
          localbyi.IconUrl = locala.KhF.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 5: 
          localbyi.DVa = locala.KhF.readString();
          AppMethodBeat.o(117888);
          return 0;
        }
        localbyi.rNX = locala.KhF.xS();
        AppMethodBeat.o(117888);
        return 0;
      }
      AppMethodBeat.o(117888);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byi
 * JD-Core Version:    0.7.0.1
 */