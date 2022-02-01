package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqz
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b EGl;
  public String gKr;
  public String mAQ;
  public String mBV;
  public int sdO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32527);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.mBV == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.gKr == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.sdO);
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      if (this.mBV != null) {
        paramVarArgs.d(3, this.mBV);
      }
      if (this.gKr != null) {
        paramVarArgs.d(4, this.gKr);
      }
      if (this.EGl != null) {
        paramVarArgs.c(5, this.EGl);
      }
      AppMethodBeat.o(32527);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.sdO) + 0;
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mAQ);
      }
      i = paramInt;
      if (this.mBV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mBV);
      }
      paramInt = i;
      if (this.gKr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gKr);
      }
      i = paramInt;
      if (this.EGl != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.EGl);
      }
      AppMethodBeat.o(32527);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.mAQ == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.mBV == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      if (this.gKr == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Content");
        AppMethodBeat.o(32527);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32527);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dqz localdqz = (dqz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32527);
        return -1;
      case 1: 
        localdqz.sdO = locala.KhF.xS();
        AppMethodBeat.o(32527);
        return 0;
      case 2: 
        localdqz.mAQ = locala.KhF.readString();
        AppMethodBeat.o(32527);
        return 0;
      case 3: 
        localdqz.mBV = locala.KhF.readString();
        AppMethodBeat.o(32527);
        return 0;
      case 4: 
        localdqz.gKr = locala.KhF.readString();
        AppMethodBeat.o(32527);
        return 0;
      }
      localdqz.EGl = locala.KhF.fMu();
      AppMethodBeat.o(32527);
      return 0;
    }
    AppMethodBeat.o(32527);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqz
 * JD-Core Version:    0.7.0.1
 */