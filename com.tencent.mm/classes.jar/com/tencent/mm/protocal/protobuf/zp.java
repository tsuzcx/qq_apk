package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zp
  extends com.tencent.mm.bv.a
{
  public String IconUrl;
  public String Name;
  public String wQB;
  public int wQC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62531);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.e(1, this.Name);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(2, this.IconUrl);
      }
      if (this.wQB != null) {
        paramVarArgs.e(3, this.wQB);
      }
      paramVarArgs.aO(4, this.wQC);
      AppMethodBeat.o(62531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label378;
      }
    }
    label378:
    for (int i = e.a.a.b.b.a.f(1, this.Name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.IconUrl);
      }
      i = paramInt;
      if (this.wQB != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wQB);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.wQC);
      AppMethodBeat.o(62531);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(62531);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        zp localzp = (zp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(62531);
          return -1;
        case 1: 
          localzp.Name = locala.CLY.readString();
          AppMethodBeat.o(62531);
          return 0;
        case 2: 
          localzp.IconUrl = locala.CLY.readString();
          AppMethodBeat.o(62531);
          return 0;
        case 3: 
          localzp.wQB = locala.CLY.readString();
          AppMethodBeat.o(62531);
          return 0;
        }
        localzp.wQC = locala.CLY.sl();
        AppMethodBeat.o(62531);
        return 0;
      }
      AppMethodBeat.o(62531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zp
 * JD-Core Version:    0.7.0.1
 */