package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpz
  extends com.tencent.mm.bw.a
{
  public String Hdu;
  public String Hdv;
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
      if (this.Hdu != null) {
        paramVarArgs.d(3, this.Hdu);
      }
      if (this.Hdv != null) {
        paramVarArgs.d(4, this.Hdv);
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
      if (this.Hdu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hdu);
      }
      paramInt = i;
      if (this.Hdv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hdv);
      }
      AppMethodBeat.o(82431);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82431);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bpz localbpz = (bpz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82431);
          return -1;
        case 1: 
          localbpz.title = locala.OmT.readString();
          AppMethodBeat.o(82431);
          return 0;
        case 2: 
          localbpz.desc = locala.OmT.readString();
          AppMethodBeat.o(82431);
          return 0;
        case 3: 
          localbpz.Hdu = locala.OmT.readString();
          AppMethodBeat.o(82431);
          return 0;
        }
        localbpz.Hdv = locala.OmT.readString();
        AppMethodBeat.o(82431);
        return 0;
      }
      AppMethodBeat.o(82431);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpz
 * JD-Core Version:    0.7.0.1
 */