package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ee
  extends com.tencent.mm.bw.a
{
  public int FHk;
  public String value;
  public boolean yxc;
  public boolean yxu;
  public boolean yxv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50078);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FHk);
      if (this.value != null) {
        paramVarArgs.d(2, this.value);
      }
      paramVarArgs.bC(3, this.yxu);
      paramVarArgs.bC(4, this.yxc);
      paramVarArgs.bC(5, this.yxv);
      AppMethodBeat.o(50078);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FHk) + 0;
      paramInt = i;
      if (this.value != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.value);
      }
      i = f.a.a.b.b.a.amF(3);
      int j = f.a.a.b.b.a.amF(4);
      int k = f.a.a.b.b.a.amF(5);
      AppMethodBeat.o(50078);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(50078);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ee localee = (ee)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50078);
        return -1;
      case 1: 
        localee.FHk = locala.OmT.zc();
        AppMethodBeat.o(50078);
        return 0;
      case 2: 
        localee.value = locala.OmT.readString();
        AppMethodBeat.o(50078);
        return 0;
      case 3: 
        localee.yxu = locala.OmT.gvY();
        AppMethodBeat.o(50078);
        return 0;
      case 4: 
        localee.yxc = locala.OmT.gvY();
        AppMethodBeat.o(50078);
        return 0;
      }
      localee.yxv = locala.OmT.gvY();
      AppMethodBeat.o(50078);
      return 0;
    }
    AppMethodBeat.o(50078);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ee
 * JD-Core Version:    0.7.0.1
 */