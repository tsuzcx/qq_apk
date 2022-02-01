package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eez
  extends com.tencent.mm.bw.a
{
  public String HJs;
  public int HQX;
  public com.tencent.mm.bw.b Ije;
  public com.tencent.mm.bw.b Ijf;
  public String Ijg;
  public String Ijh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32550);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HJs == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Msg");
        AppMethodBeat.o(32550);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.HQX);
      if (this.HJs != null) {
        paramVarArgs.d(2, this.HJs);
      }
      if (this.Ije != null) {
        paramVarArgs.c(3, this.Ije);
      }
      if (this.Ijf != null) {
        paramVarArgs.c(4, this.Ijf);
      }
      if (this.Ijg != null) {
        paramVarArgs.d(5, this.Ijg);
      }
      if (this.Ijh != null) {
        paramVarArgs.d(6, this.Ijh);
      }
      AppMethodBeat.o(32550);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HQX) + 0;
      paramInt = i;
      if (this.HJs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HJs);
      }
      i = paramInt;
      if (this.Ije != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.Ije);
      }
      paramInt = i;
      if (this.Ijf != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.Ijf);
      }
      i = paramInt;
      if (this.Ijg != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ijg);
      }
      paramInt = i;
      if (this.Ijh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ijh);
      }
      AppMethodBeat.o(32550);
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
      if (this.HJs == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Msg");
        AppMethodBeat.o(32550);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32550);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eez localeez = (eez)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32550);
        return -1;
      case 1: 
        localeez.HQX = locala.OmT.zc();
        AppMethodBeat.o(32550);
        return 0;
      case 2: 
        localeez.HJs = locala.OmT.readString();
        AppMethodBeat.o(32550);
        return 0;
      case 3: 
        localeez.Ije = locala.OmT.gCk();
        AppMethodBeat.o(32550);
        return 0;
      case 4: 
        localeez.Ijf = locala.OmT.gCk();
        AppMethodBeat.o(32550);
        return 0;
      case 5: 
        localeez.Ijg = locala.OmT.readString();
        AppMethodBeat.o(32550);
        return 0;
      }
      localeez.Ijh = locala.OmT.readString();
      AppMethodBeat.o(32550);
      return 0;
    }
    AppMethodBeat.o(32550);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eez
 * JD-Core Version:    0.7.0.1
 */