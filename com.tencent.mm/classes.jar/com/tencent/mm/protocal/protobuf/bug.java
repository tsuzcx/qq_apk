package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bug
  extends com.tencent.mm.bw.a
{
  public String EJo;
  public int Edq;
  public int Fkq;
  public int Fkr;
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
      paramVarArgs.aR(1, this.Fkq);
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.d(3, this.ThumbUrl);
      }
      paramVarArgs.aR(4, this.Edq);
      if (this.EJo != null) {
        paramVarArgs.d(5, this.EJo);
      }
      paramVarArgs.aR(6, this.Fkr);
      AppMethodBeat.o(89663);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Fkq) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ThumbUrl);
      }
      i += f.a.a.b.b.a.bx(4, this.Edq);
      paramInt = i;
      if (this.EJo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EJo);
      }
      i = f.a.a.b.b.a.bx(6, this.Fkr);
      AppMethodBeat.o(89663);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
      bug localbug = (bug)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(89663);
        return -1;
      case 1: 
        localbug.Fkq = locala.LVo.xF();
        AppMethodBeat.o(89663);
        return 0;
      case 2: 
        localbug.Title = locala.LVo.readString();
        AppMethodBeat.o(89663);
        return 0;
      case 3: 
        localbug.ThumbUrl = locala.LVo.readString();
        AppMethodBeat.o(89663);
        return 0;
      case 4: 
        localbug.Edq = locala.LVo.xF();
        AppMethodBeat.o(89663);
        return 0;
      case 5: 
        localbug.EJo = locala.LVo.readString();
        AppMethodBeat.o(89663);
        return 0;
      }
      localbug.Fkr = locala.LVo.xF();
      AppMethodBeat.o(89663);
      return 0;
    }
    AppMethodBeat.o(89663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bug
 * JD-Core Version:    0.7.0.1
 */