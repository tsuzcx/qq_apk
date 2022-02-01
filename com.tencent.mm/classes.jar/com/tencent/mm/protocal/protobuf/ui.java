package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ui
  extends com.tencent.mm.bx.a
{
  public boolean CVZ;
  public String desc;
  public String result;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190185);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.result != null) {
        paramVarArgs.d(3, this.result);
      }
      paramVarArgs.bg(4, this.CVZ);
      AppMethodBeat.o(190185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.result != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.result);
      }
      paramInt = f.a.a.b.b.a.fY(4);
      AppMethodBeat.o(190185);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(190185);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ui localui = (ui)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(190185);
          return -1;
        case 1: 
          localui.title = locala.KhF.readString();
          AppMethodBeat.o(190185);
          return 0;
        case 2: 
          localui.desc = locala.KhF.readString();
          AppMethodBeat.o(190185);
          return 0;
        case 3: 
          localui.result = locala.KhF.readString();
          AppMethodBeat.o(190185);
          return 0;
        }
        localui.CVZ = locala.KhF.fHu();
        AppMethodBeat.o(190185);
        return 0;
      }
      AppMethodBeat.o(190185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ui
 * JD-Core Version:    0.7.0.1
 */