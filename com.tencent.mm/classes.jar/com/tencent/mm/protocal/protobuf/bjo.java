package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjo
  extends com.tencent.mm.bw.a
{
  public String Bkz;
  public String desc;
  public String hgt;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72498);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.hgt != null) {
        paramVarArgs.d(3, this.hgt);
      }
      if (this.Bkz != null) {
        paramVarArgs.d(4, this.Bkz);
      }
      AppMethodBeat.o(72498);
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
      if (this.hgt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hgt);
      }
      paramInt = i;
      if (this.Bkz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Bkz);
      }
      AppMethodBeat.o(72498);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72498);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bjo localbjo = (bjo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72498);
          return -1;
        case 1: 
          localbjo.title = locala.LVo.readString();
          AppMethodBeat.o(72498);
          return 0;
        case 2: 
          localbjo.desc = locala.LVo.readString();
          AppMethodBeat.o(72498);
          return 0;
        case 3: 
          localbjo.hgt = locala.LVo.readString();
          AppMethodBeat.o(72498);
          return 0;
        }
        localbjo.Bkz = locala.LVo.readString();
        AppMethodBeat.o(72498);
        return 0;
      }
      AppMethodBeat.o(72498);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjo
 * JD-Core Version:    0.7.0.1
 */