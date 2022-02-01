package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clx
  extends com.tencent.mm.bw.a
{
  public float GgZ;
  public float Gha;
  public int Gzf;
  public String Gzg;
  public String Gzh;
  public int Gzi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152663);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.y(1, this.GgZ);
      paramVarArgs.y(2, this.Gha);
      paramVarArgs.aS(3, this.Gzf);
      if (this.Gzg != null) {
        paramVarArgs.d(4, this.Gzg);
      }
      if (this.Gzh != null) {
        paramVarArgs.d(5, this.Gzh);
      }
      paramVarArgs.aS(6, this.Gzi);
      AppMethodBeat.o(152663);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amE(1) + 0 + f.a.a.b.b.a.amE(2) + f.a.a.b.b.a.bz(3, this.Gzf);
      paramInt = i;
      if (this.Gzg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gzg);
      }
      i = paramInt;
      if (this.Gzh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gzh);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.Gzi);
      AppMethodBeat.o(152663);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(152663);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      clx localclx = (clx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152663);
        return -1;
      case 1: 
        localclx.GgZ = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(152663);
        return 0;
      case 2: 
        localclx.Gha = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(152663);
        return 0;
      case 3: 
        localclx.Gzf = locala.OmT.zc();
        AppMethodBeat.o(152663);
        return 0;
      case 4: 
        localclx.Gzg = locala.OmT.readString();
        AppMethodBeat.o(152663);
        return 0;
      case 5: 
        localclx.Gzh = locala.OmT.readString();
        AppMethodBeat.o(152663);
        return 0;
      }
      localclx.Gzi = locala.OmT.zc();
      AppMethodBeat.o(152663);
      return 0;
    }
    AppMethodBeat.o(152663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clx
 * JD-Core Version:    0.7.0.1
 */