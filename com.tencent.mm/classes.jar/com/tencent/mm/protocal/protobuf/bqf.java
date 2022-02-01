package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqf
  extends com.tencent.mm.bx.a
{
  public String CVu;
  public String Cxb;
  public String mAQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101825);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Cxb != null) {
        paramVarArgs.d(1, this.Cxb);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      if (this.CVu != null) {
        paramVarArgs.d(3, this.CVu);
      }
      AppMethodBeat.o(101825);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cxb == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.Cxb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mAQ);
      }
      i = paramInt;
      if (this.CVu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CVu);
      }
      AppMethodBeat.o(101825);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(101825);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bqf localbqf = (bqf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101825);
          return -1;
        case 1: 
          localbqf.Cxb = locala.KhF.readString();
          AppMethodBeat.o(101825);
          return 0;
        case 2: 
          localbqf.mAQ = locala.KhF.readString();
          AppMethodBeat.o(101825);
          return 0;
        }
        localbqf.CVu = locala.KhF.readString();
        AppMethodBeat.o(101825);
        return 0;
      }
      AppMethodBeat.o(101825);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqf
 * JD-Core Version:    0.7.0.1
 */