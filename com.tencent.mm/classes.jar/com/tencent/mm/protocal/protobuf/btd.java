package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btd
  extends com.tencent.mm.bx.a
{
  public String CFx;
  public int DFK;
  public String DQg;
  public String Dap;
  public int Der;
  public String mAQ;
  public String mBV;
  public int oXh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155445);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.oXh);
      if (this.mBV != null) {
        paramVarArgs.d(2, this.mBV);
      }
      if (this.CFx != null) {
        paramVarArgs.d(3, this.CFx);
      }
      if (this.Dap != null) {
        paramVarArgs.d(4, this.Dap);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(5, this.mAQ);
      }
      paramVarArgs.aR(6, this.DFK);
      paramVarArgs.aR(7, this.Der);
      if (this.DQg != null) {
        paramVarArgs.d(8, this.DQg);
      }
      AppMethodBeat.o(155445);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.oXh) + 0;
      paramInt = i;
      if (this.mBV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mBV);
      }
      i = paramInt;
      if (this.CFx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CFx);
      }
      paramInt = i;
      if (this.Dap != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dap);
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.mAQ);
      }
      i = i + f.a.a.b.b.a.bA(6, this.DFK) + f.a.a.b.b.a.bA(7, this.Der);
      paramInt = i;
      if (this.DQg != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DQg);
      }
      AppMethodBeat.o(155445);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(155445);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      btd localbtd = (btd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155445);
        return -1;
      case 1: 
        localbtd.oXh = locala.KhF.xS();
        AppMethodBeat.o(155445);
        return 0;
      case 2: 
        localbtd.mBV = locala.KhF.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 3: 
        localbtd.CFx = locala.KhF.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 4: 
        localbtd.Dap = locala.KhF.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 5: 
        localbtd.mAQ = locala.KhF.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 6: 
        localbtd.DFK = locala.KhF.xS();
        AppMethodBeat.o(155445);
        return 0;
      case 7: 
        localbtd.Der = locala.KhF.xS();
        AppMethodBeat.o(155445);
        return 0;
      }
      localbtd.DQg = locala.KhF.readString();
      AppMethodBeat.o(155445);
      return 0;
    }
    AppMethodBeat.o(155445);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btd
 * JD-Core Version:    0.7.0.1
 */