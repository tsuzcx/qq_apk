package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsh
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String Title;
  public String mAQ;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138184);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(3, this.mAQ);
      }
      paramVarArgs.aG(4, this.uKZ);
      AppMethodBeat.o(138184);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Desc);
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mAQ);
      }
      paramInt = f.a.a.b.b.a.q(4, this.uKZ);
      AppMethodBeat.o(138184);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(138184);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bsh localbsh = (bsh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138184);
          return -1;
        case 1: 
          localbsh.Title = locala.KhF.readString();
          AppMethodBeat.o(138184);
          return 0;
        case 2: 
          localbsh.Desc = locala.KhF.readString();
          AppMethodBeat.o(138184);
          return 0;
        case 3: 
          localbsh.mAQ = locala.KhF.readString();
          AppMethodBeat.o(138184);
          return 0;
        }
        localbsh.uKZ = locala.KhF.xT();
        AppMethodBeat.o(138184);
        return 0;
      }
      AppMethodBeat.o(138184);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsh
 * JD-Core Version:    0.7.0.1
 */