package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjl
  extends com.tencent.mm.bw.a
{
  public int FUK;
  public String HvX;
  public String HvY;
  public String HvZ;
  public String Hwa;
  public String Hwb;
  public String Hwc;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91577);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HvX != null) {
        paramVarArgs.d(1, this.HvX);
      }
      paramVarArgs.aS(2, this.nJb);
      if (this.HvY != null) {
        paramVarArgs.d(3, this.HvY);
      }
      if (this.HvZ != null) {
        paramVarArgs.d(4, this.HvZ);
      }
      if (this.Hwa != null) {
        paramVarArgs.d(5, this.Hwa);
      }
      paramVarArgs.aS(6, this.FUK);
      if (this.Hwb != null) {
        paramVarArgs.d(7, this.Hwb);
      }
      if (this.Hwc != null) {
        paramVarArgs.d(8, this.Hwc);
      }
      AppMethodBeat.o(91577);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HvX == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = f.a.a.b.b.a.e(1, this.HvX) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nJb);
      paramInt = i;
      if (this.HvY != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HvY);
      }
      i = paramInt;
      if (this.HvZ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HvZ);
      }
      paramInt = i;
      if (this.Hwa != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hwa);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.FUK);
      paramInt = i;
      if (this.Hwb != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Hwb);
      }
      i = paramInt;
      if (this.Hwc != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Hwc);
      }
      AppMethodBeat.o(91577);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91577);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cjl localcjl = (cjl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91577);
          return -1;
        case 1: 
          localcjl.HvX = locala.OmT.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 2: 
          localcjl.nJb = locala.OmT.zc();
          AppMethodBeat.o(91577);
          return 0;
        case 3: 
          localcjl.HvY = locala.OmT.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 4: 
          localcjl.HvZ = locala.OmT.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 5: 
          localcjl.Hwa = locala.OmT.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 6: 
          localcjl.FUK = locala.OmT.zc();
          AppMethodBeat.o(91577);
          return 0;
        case 7: 
          localcjl.Hwb = locala.OmT.readString();
          AppMethodBeat.o(91577);
          return 0;
        }
        localcjl.Hwc = locala.OmT.readString();
        AppMethodBeat.o(91577);
        return 0;
      }
      AppMethodBeat.o(91577);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjl
 * JD-Core Version:    0.7.0.1
 */