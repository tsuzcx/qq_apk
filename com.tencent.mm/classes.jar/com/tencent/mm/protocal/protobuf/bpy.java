package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpy
  extends com.tencent.mm.bw.a
{
  public int Gpf;
  public String urg;
  public String xcg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gpf);
      if (this.xcg != null) {
        paramVarArgs.d(2, this.xcg);
      }
      if (this.urg != null) {
        paramVarArgs.d(3, this.urg);
      }
      AppMethodBeat.o(32332);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Gpf) + 0;
      paramInt = i;
      if (this.xcg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xcg);
      }
      i = paramInt;
      if (this.urg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.urg);
      }
      AppMethodBeat.o(32332);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32332);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bpy localbpy = (bpy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32332);
        return -1;
      case 1: 
        localbpy.Gpf = locala.OmT.zc();
        AppMethodBeat.o(32332);
        return 0;
      case 2: 
        localbpy.xcg = locala.OmT.readString();
        AppMethodBeat.o(32332);
        return 0;
      }
      localbpy.urg = locala.OmT.readString();
      AppMethodBeat.o(32332);
      return 0;
    }
    AppMethodBeat.o(32332);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpy
 * JD-Core Version:    0.7.0.1
 */