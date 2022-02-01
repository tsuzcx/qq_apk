package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class az
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String Name;
  public String hFS;
  public int nJA;
  public String xcg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91340);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.d(1, this.Name);
      }
      if (this.xcg != null) {
        paramVarArgs.d(2, this.xcg);
      }
      paramVarArgs.aS(3, this.nJA);
      if (this.hFS != null) {
        paramVarArgs.d(4, this.hFS);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(5, this.IconUrl);
      }
      AppMethodBeat.o(91340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xcg != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.xcg);
      }
      i += f.a.a.b.b.a.bz(3, this.nJA);
      paramInt = i;
      if (this.hFS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hFS);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.IconUrl);
      }
      AppMethodBeat.o(91340);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91340);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        az localaz = (az)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91340);
          return -1;
        case 1: 
          localaz.Name = locala.OmT.readString();
          AppMethodBeat.o(91340);
          return 0;
        case 2: 
          localaz.xcg = locala.OmT.readString();
          AppMethodBeat.o(91340);
          return 0;
        case 3: 
          localaz.nJA = locala.OmT.zc();
          AppMethodBeat.o(91340);
          return 0;
        case 4: 
          localaz.hFS = locala.OmT.readString();
          AppMethodBeat.o(91340);
          return 0;
        }
        localaz.IconUrl = locala.OmT.readString();
        AppMethodBeat.o(91340);
        return 0;
      }
      AppMethodBeat.o(91340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.az
 * JD-Core Version:    0.7.0.1
 */