package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bhy
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String EXl;
  public String EXm;
  public String IconUrl;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152610);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EXl != null) {
        paramVarArgs.d(1, this.EXl);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(2, this.IconUrl);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.EXm != null) {
        paramVarArgs.d(5, this.EXm);
      }
      AppMethodBeat.o(152610);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EXl == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.EXl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IconUrl);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Title);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Desc);
      }
      i = paramInt;
      if (this.EXm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EXm);
      }
      AppMethodBeat.o(152610);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152610);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bhy localbhy = (bhy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152610);
          return -1;
        case 1: 
          localbhy.EXl = locala.LVo.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 2: 
          localbhy.IconUrl = locala.LVo.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 3: 
          localbhy.Title = locala.LVo.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 4: 
          localbhy.Desc = locala.LVo.readString();
          AppMethodBeat.o(152610);
          return 0;
        }
        localbhy.EXm = locala.LVo.readString();
        AppMethodBeat.o(152610);
        return 0;
      }
      AppMethodBeat.o(152610);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhy
 * JD-Core Version:    0.7.0.1
 */