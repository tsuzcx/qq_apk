package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cld
  extends com.tencent.mm.bx.a
{
  public float FOA;
  public float FOB;
  public int Ggw;
  public String Ggx;
  public String Ggy;
  public int Ggz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152663);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.z(1, this.FOA);
      paramVarArgs.z(2, this.FOB);
      paramVarArgs.aS(3, this.Ggw);
      if (this.Ggx != null) {
        paramVarArgs.d(4, this.Ggx);
      }
      if (this.Ggy != null) {
        paramVarArgs.d(5, this.Ggy);
      }
      paramVarArgs.aS(6, this.Ggz);
      AppMethodBeat.o(152663);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alU(1) + 0 + f.a.a.b.b.a.alU(2) + f.a.a.b.b.a.bz(3, this.Ggw);
      paramInt = i;
      if (this.Ggx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ggx);
      }
      i = paramInt;
      if (this.Ggy != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ggy);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.Ggz);
      AppMethodBeat.o(152663);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(152663);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cld localcld = (cld)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152663);
        return -1;
      case 1: 
        localcld.FOA = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(152663);
        return 0;
      case 2: 
        localcld.FOB = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(152663);
        return 0;
      case 3: 
        localcld.Ggw = locala.NPN.zc();
        AppMethodBeat.o(152663);
        return 0;
      case 4: 
        localcld.Ggx = locala.NPN.readString();
        AppMethodBeat.o(152663);
        return 0;
      case 5: 
        localcld.Ggy = locala.NPN.readString();
        AppMethodBeat.o(152663);
        return 0;
      }
      localcld.Ggz = locala.NPN.zc();
      AppMethodBeat.o(152663);
      return 0;
    }
    AppMethodBeat.o(152663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cld
 * JD-Core Version:    0.7.0.1
 */