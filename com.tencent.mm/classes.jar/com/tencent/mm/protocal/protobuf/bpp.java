package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bpp
  extends com.tencent.mm.bx.a
{
  public int CKO;
  public int DNZ;
  public int DOa;
  public String Doo;
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
      paramVarArgs.aR(1, this.DNZ);
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.d(3, this.ThumbUrl);
      }
      paramVarArgs.aR(4, this.CKO);
      if (this.Doo != null) {
        paramVarArgs.d(5, this.Doo);
      }
      paramVarArgs.aR(6, this.DOa);
      AppMethodBeat.o(89663);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DNZ) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ThumbUrl);
      }
      i += f.a.a.b.b.a.bA(4, this.CKO);
      paramInt = i;
      if (this.Doo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Doo);
      }
      i = f.a.a.b.b.a.bA(6, this.DOa);
      AppMethodBeat.o(89663);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
      bpp localbpp = (bpp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(89663);
        return -1;
      case 1: 
        localbpp.DNZ = locala.KhF.xS();
        AppMethodBeat.o(89663);
        return 0;
      case 2: 
        localbpp.Title = locala.KhF.readString();
        AppMethodBeat.o(89663);
        return 0;
      case 3: 
        localbpp.ThumbUrl = locala.KhF.readString();
        AppMethodBeat.o(89663);
        return 0;
      case 4: 
        localbpp.CKO = locala.KhF.xS();
        AppMethodBeat.o(89663);
        return 0;
      case 5: 
        localbpp.Doo = locala.KhF.readString();
        AppMethodBeat.o(89663);
        return 0;
      }
      localbpp.DOa = locala.KhF.xS();
      AppMethodBeat.o(89663);
      return 0;
    }
    AppMethodBeat.o(89663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpp
 * JD-Core Version:    0.7.0.1
 */