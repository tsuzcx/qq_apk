package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkp
  extends com.tencent.mm.bw.a
{
  public String Md5;
  public String Name;
  public String Type;
  public String Url;
  public int ndD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32329);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Type != null) {
        paramVarArgs.d(1, this.Type);
      }
      paramVarArgs.aR(2, this.ndD);
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
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndD);
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
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32329);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bkp localbkp = (bkp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32329);
          return -1;
        case 1: 
          localbkp.Type = locala.LVo.readString();
          AppMethodBeat.o(32329);
          return 0;
        case 2: 
          localbkp.ndD = locala.LVo.xF();
          AppMethodBeat.o(32329);
          return 0;
        case 3: 
          localbkp.Md5 = locala.LVo.readString();
          AppMethodBeat.o(32329);
          return 0;
        case 4: 
          localbkp.Url = locala.LVo.readString();
          AppMethodBeat.o(32329);
          return 0;
        }
        localbkp.Name = locala.LVo.readString();
        AppMethodBeat.o(32329);
        return 0;
      }
      AppMethodBeat.o(32329);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkp
 * JD-Core Version:    0.7.0.1
 */