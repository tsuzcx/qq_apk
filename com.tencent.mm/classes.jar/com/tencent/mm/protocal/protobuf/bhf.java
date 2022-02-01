package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bhf
  extends com.tencent.mm.bx.a
{
  public String DFa;
  public String DFb;
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
      if (this.DFa != null) {
        paramVarArgs.d(3, this.DFa);
      }
      if (this.DFb != null) {
        paramVarArgs.d(4, this.DFb);
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
      if (this.DFa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DFa);
      }
      paramInt = i;
      if (this.DFb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DFb);
      }
      AppMethodBeat.o(82431);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82431);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bhf localbhf = (bhf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82431);
          return -1;
        case 1: 
          localbhf.title = locala.KhF.readString();
          AppMethodBeat.o(82431);
          return 0;
        case 2: 
          localbhf.desc = locala.KhF.readString();
          AppMethodBeat.o(82431);
          return 0;
        case 3: 
          localbhf.DFa = locala.KhF.readString();
          AppMethodBeat.o(82431);
          return 0;
        }
        localbhf.DFb = locala.KhF.readString();
        AppMethodBeat.o(82431);
        return 0;
      }
      AppMethodBeat.o(82431);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhf
 * JD-Core Version:    0.7.0.1
 */