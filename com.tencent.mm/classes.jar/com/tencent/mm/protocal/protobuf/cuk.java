package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cuk
  extends com.tencent.mm.bx.a
{
  public int DJf;
  public String Dqk;
  public String Emk;
  public int Eml;
  public int Emm;
  public String mAQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125773);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Emk != null) {
        paramVarArgs.d(1, this.Emk);
      }
      paramVarArgs.aR(2, this.Eml);
      if (this.mAQ != null) {
        paramVarArgs.d(3, this.mAQ);
      }
      if (this.Dqk != null) {
        paramVarArgs.d(4, this.Dqk);
      }
      paramVarArgs.aR(5, this.DJf);
      paramVarArgs.aR(6, this.Emm);
      AppMethodBeat.o(125773);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Emk == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = f.a.a.b.b.a.e(1, this.Emk) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Eml);
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.mAQ);
      }
      i = paramInt;
      if (this.Dqk != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Dqk);
      }
      paramInt = f.a.a.b.b.a.bA(5, this.DJf);
      int j = f.a.a.b.b.a.bA(6, this.Emm);
      AppMethodBeat.o(125773);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125773);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cuk localcuk = (cuk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125773);
          return -1;
        case 1: 
          localcuk.Emk = locala.KhF.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 2: 
          localcuk.Eml = locala.KhF.xS();
          AppMethodBeat.o(125773);
          return 0;
        case 3: 
          localcuk.mAQ = locala.KhF.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 4: 
          localcuk.Dqk = locala.KhF.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 5: 
          localcuk.DJf = locala.KhF.xS();
          AppMethodBeat.o(125773);
          return 0;
        }
        localcuk.Emm = locala.KhF.xS();
        AppMethodBeat.o(125773);
        return 0;
      }
      AppMethodBeat.o(125773);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuk
 * JD-Core Version:    0.7.0.1
 */