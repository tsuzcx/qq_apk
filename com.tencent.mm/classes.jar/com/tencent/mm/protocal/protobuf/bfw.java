package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfw
  extends com.tencent.mm.bx.a
{
  public String desc;
  public String gFS;
  public String title;
  public String zSf;
  
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
      if (this.gFS != null) {
        paramVarArgs.d(3, this.gFS);
      }
      if (this.zSf != null) {
        paramVarArgs.d(4, this.zSf);
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
      if (this.gFS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gFS);
      }
      paramInt = i;
      if (this.zSf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.zSf);
      }
      AppMethodBeat.o(72498);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72498);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bfw localbfw = (bfw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72498);
          return -1;
        case 1: 
          localbfw.title = locala.KhF.readString();
          AppMethodBeat.o(72498);
          return 0;
        case 2: 
          localbfw.desc = locala.KhF.readString();
          AppMethodBeat.o(72498);
          return 0;
        case 3: 
          localbfw.gFS = locala.KhF.readString();
          AppMethodBeat.o(72498);
          return 0;
        }
        localbfw.zSf = locala.KhF.readString();
        AppMethodBeat.o(72498);
        return 0;
      }
      AppMethodBeat.o(72498);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfw
 * JD-Core Version:    0.7.0.1
 */