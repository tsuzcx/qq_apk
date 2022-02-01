package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvh
  extends com.tencent.mm.bw.a
{
  public long FKy;
  public int FZN;
  public String Gud;
  public String HhZ;
  public String Hia;
  public int rotation;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215577);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.FKy);
      if (this.HhZ != null) {
        paramVarArgs.d(2, this.HhZ);
      }
      paramVarArgs.aS(3, this.rotation);
      if (this.Gud != null) {
        paramVarArgs.d(4, this.Gud);
      }
      paramVarArgs.aS(5, this.FZN);
      if (this.Hia != null) {
        paramVarArgs.d(6, this.Hia);
      }
      AppMethodBeat.o(215577);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.FKy) + 0;
      paramInt = i;
      if (this.HhZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HhZ);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.rotation);
      paramInt = i;
      if (this.Gud != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gud);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FZN);
      paramInt = i;
      if (this.Hia != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hia);
      }
      AppMethodBeat.o(215577);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(215577);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bvh localbvh = (bvh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(215577);
        return -1;
      case 1: 
        localbvh.FKy = locala.OmT.zd();
        AppMethodBeat.o(215577);
        return 0;
      case 2: 
        localbvh.HhZ = locala.OmT.readString();
        AppMethodBeat.o(215577);
        return 0;
      case 3: 
        localbvh.rotation = locala.OmT.zc();
        AppMethodBeat.o(215577);
        return 0;
      case 4: 
        localbvh.Gud = locala.OmT.readString();
        AppMethodBeat.o(215577);
        return 0;
      case 5: 
        localbvh.FZN = locala.OmT.zc();
        AppMethodBeat.o(215577);
        return 0;
      }
      localbvh.Hia = locala.OmT.readString();
      AppMethodBeat.o(215577);
      return 0;
    }
    AppMethodBeat.o(215577);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvh
 * JD-Core Version:    0.7.0.1
 */