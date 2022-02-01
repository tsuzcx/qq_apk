package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmy
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Haj;
  public String Hak;
  public String IconUrl;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152610);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Haj != null) {
        paramVarArgs.d(1, this.Haj);
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
      if (this.Hak != null) {
        paramVarArgs.d(5, this.Hak);
      }
      AppMethodBeat.o(152610);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Haj == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.Haj) + 0;; i = 0)
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
      if (this.Hak != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hak);
      }
      AppMethodBeat.o(152610);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152610);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bmy localbmy = (bmy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152610);
          return -1;
        case 1: 
          localbmy.Haj = locala.OmT.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 2: 
          localbmy.IconUrl = locala.OmT.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 3: 
          localbmy.Title = locala.OmT.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 4: 
          localbmy.Desc = locala.OmT.readString();
          AppMethodBeat.o(152610);
          return 0;
        }
        localbmy.Hak = locala.OmT.readString();
        AppMethodBeat.o(152610);
        return 0;
      }
      AppMethodBeat.o(152610);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmy
 * JD-Core Version:    0.7.0.1
 */