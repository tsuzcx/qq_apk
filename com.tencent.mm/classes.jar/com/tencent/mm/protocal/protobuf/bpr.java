package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpr
  extends com.tencent.mm.bw.a
{
  public String Md5;
  public String Name;
  public String Type;
  public String Url;
  public int nJv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32329);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Type != null) {
        paramVarArgs.d(1, this.Type);
      }
      paramVarArgs.aS(2, this.nJv);
      if (this.Md5 != null) {
        paramVarArgs.d(3, this.Md5);
      }
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      if (this.Name != null) {
        paramVarArgs.d(5, this.Name);
      }
      AppMethodBeat.o(32329);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Type == null) {
        break label449;
      }
    }
    label449:
    for (paramInt = f.a.a.b.b.a.e(1, this.Type) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nJv);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Md5);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Url);
      }
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Name);
      }
      AppMethodBeat.o(32329);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32329);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bpr localbpr = (bpr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32329);
          return -1;
        case 1: 
          localbpr.Type = locala.OmT.readString();
          AppMethodBeat.o(32329);
          return 0;
        case 2: 
          localbpr.nJv = locala.OmT.zc();
          AppMethodBeat.o(32329);
          return 0;
        case 3: 
          localbpr.Md5 = locala.OmT.readString();
          AppMethodBeat.o(32329);
          return 0;
        case 4: 
          localbpr.Url = locala.OmT.readString();
          AppMethodBeat.o(32329);
          return 0;
        }
        localbpr.Name = locala.OmT.readString();
        AppMethodBeat.o(32329);
        return 0;
      }
      AppMethodBeat.o(32329);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpr
 * JD-Core Version:    0.7.0.1
 */