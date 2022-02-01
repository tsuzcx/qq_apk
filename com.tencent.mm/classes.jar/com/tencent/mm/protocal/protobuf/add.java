package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class add
  extends com.tencent.mm.bx.a
{
  public String DdL;
  public int DdM;
  public String IconUrl;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104767);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.d(1, this.Name);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(2, this.IconUrl);
      }
      if (this.DdL != null) {
        paramVarArgs.d(3, this.DdL);
      }
      paramVarArgs.aR(4, this.DdM);
      AppMethodBeat.o(104767);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.Name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IconUrl);
      }
      i = paramInt;
      if (this.DdL != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DdL);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.DdM);
      AppMethodBeat.o(104767);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(104767);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        add localadd = (add)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104767);
          return -1;
        case 1: 
          localadd.Name = locala.KhF.readString();
          AppMethodBeat.o(104767);
          return 0;
        case 2: 
          localadd.IconUrl = locala.KhF.readString();
          AppMethodBeat.o(104767);
          return 0;
        case 3: 
          localadd.DdL = locala.KhF.readString();
          AppMethodBeat.o(104767);
          return 0;
        }
        localadd.DdM = locala.KhF.xS();
        AppMethodBeat.o(104767);
        return 0;
      }
      AppMethodBeat.o(104767);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.add
 * JD-Core Version:    0.7.0.1
 */