package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfn
  extends com.tencent.mm.bx.a
{
  public String EkA;
  public int EkE;
  public String EkG;
  public String content;
  public int dcG;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153308);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EkG != null) {
        paramVarArgs.d(1, this.EkG);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.content != null) {
        paramVarArgs.d(3, this.content);
      }
      if (this.EkA != null) {
        paramVarArgs.d(4, this.EkA);
      }
      paramVarArgs.aR(5, this.EkE);
      paramVarArgs.aR(6, this.state);
      AppMethodBeat.o(153308);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EkG == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = f.a.a.b.b.a.e(1, this.EkG) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.content);
      }
      i = paramInt;
      if (this.EkA != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EkA);
      }
      paramInt = f.a.a.b.b.a.bA(5, this.EkE);
      int j = f.a.a.b.b.a.bA(6, this.state);
      AppMethodBeat.o(153308);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153308);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dfn localdfn = (dfn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153308);
          return -1;
        case 1: 
          localdfn.EkG = locala.KhF.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 2: 
          localdfn.dcG = locala.KhF.xS();
          AppMethodBeat.o(153308);
          return 0;
        case 3: 
          localdfn.content = locala.KhF.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 4: 
          localdfn.EkA = locala.KhF.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 5: 
          localdfn.EkE = locala.KhF.xS();
          AppMethodBeat.o(153308);
          return 0;
        }
        localdfn.state = locala.KhF.xS();
        AppMethodBeat.o(153308);
        return 0;
      }
      AppMethodBeat.o(153308);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfn
 * JD-Core Version:    0.7.0.1
 */