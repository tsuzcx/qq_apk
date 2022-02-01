package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkx
  extends com.tencent.mm.bw.a
{
  public String Fau;
  public String Fav;
  public String desc;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82431);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.Fau != null) {
        paramVarArgs.d(3, this.Fau);
      }
      if (this.Fav != null) {
        paramVarArgs.d(4, this.Fav);
      }
      AppMethodBeat.o(82431);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.Fau != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fau);
      }
      paramInt = i;
      if (this.Fav != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fav);
      }
      AppMethodBeat.o(82431);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82431);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bkx localbkx = (bkx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82431);
          return -1;
        case 1: 
          localbkx.title = locala.LVo.readString();
          AppMethodBeat.o(82431);
          return 0;
        case 2: 
          localbkx.desc = locala.LVo.readString();
          AppMethodBeat.o(82431);
          return 0;
        case 3: 
          localbkx.Fau = locala.LVo.readString();
          AppMethodBeat.o(82431);
          return 0;
        }
        localbkx.Fav = locala.LVo.readString();
        AppMethodBeat.o(82431);
        return 0;
      }
      AppMethodBeat.o(82431);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkx
 * JD-Core Version:    0.7.0.1
 */