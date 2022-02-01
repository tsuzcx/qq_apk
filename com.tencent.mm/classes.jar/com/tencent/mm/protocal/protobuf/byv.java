package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class byv
  extends com.tencent.mm.bx.a
{
  public int FJz;
  public int GTY;
  public int GTZ;
  public String Gsq;
  public String ThumbUrl;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89663);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(89663);
        throw paramVarArgs;
      }
      if (this.ThumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbUrl");
        AppMethodBeat.o(89663);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.GTY);
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.d(3, this.ThumbUrl);
      }
      paramVarArgs.aS(4, this.FJz);
      if (this.Gsq != null) {
        paramVarArgs.d(5, this.Gsq);
      }
      paramVarArgs.aS(6, this.GTZ);
      AppMethodBeat.o(89663);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GTY) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ThumbUrl);
      }
      i += f.a.a.b.b.a.bz(4, this.FJz);
      paramInt = i;
      if (this.Gsq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gsq);
      }
      i = f.a.a.b.b.a.bz(6, this.GTZ);
      AppMethodBeat.o(89663);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(89663);
        throw paramVarArgs;
      }
      if (this.ThumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbUrl");
        AppMethodBeat.o(89663);
        throw paramVarArgs;
      }
      AppMethodBeat.o(89663);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      byv localbyv = (byv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(89663);
        return -1;
      case 1: 
        localbyv.GTY = locala.NPN.zc();
        AppMethodBeat.o(89663);
        return 0;
      case 2: 
        localbyv.Title = locala.NPN.readString();
        AppMethodBeat.o(89663);
        return 0;
      case 3: 
        localbyv.ThumbUrl = locala.NPN.readString();
        AppMethodBeat.o(89663);
        return 0;
      case 4: 
        localbyv.FJz = locala.NPN.zc();
        AppMethodBeat.o(89663);
        return 0;
      case 5: 
        localbyv.Gsq = locala.NPN.readString();
        AppMethodBeat.o(89663);
        return 0;
      }
      localbyv.GTZ = locala.NPN.zc();
      AppMethodBeat.o(89663);
      return 0;
    }
    AppMethodBeat.o(89663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byv
 * JD-Core Version:    0.7.0.1
 */