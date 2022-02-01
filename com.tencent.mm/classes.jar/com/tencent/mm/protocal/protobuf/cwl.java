package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwl
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Hvr;
  public String Hvs;
  public String IconUrl;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117904);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hvr != null) {
        paramVarArgs.d(1, this.Hvr);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(4, this.IconUrl);
      }
      if (this.Hvs != null) {
        paramVarArgs.d(5, this.Hvs);
      }
      AppMethodBeat.o(117904);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hvr == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.Hvr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Desc);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.IconUrl);
      }
      i = paramInt;
      if (this.Hvs != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hvs);
      }
      AppMethodBeat.o(117904);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117904);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cwl localcwl = (cwl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117904);
          return -1;
        case 1: 
          localcwl.Hvr = locala.OmT.readString();
          AppMethodBeat.o(117904);
          return 0;
        case 2: 
          localcwl.Title = locala.OmT.readString();
          AppMethodBeat.o(117904);
          return 0;
        case 3: 
          localcwl.Desc = locala.OmT.readString();
          AppMethodBeat.o(117904);
          return 0;
        case 4: 
          localcwl.IconUrl = locala.OmT.readString();
          AppMethodBeat.o(117904);
          return 0;
        }
        localcwl.Hvs = locala.OmT.readString();
        AppMethodBeat.o(117904);
        return 0;
      }
      AppMethodBeat.o(117904);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwl
 * JD-Core Version:    0.7.0.1
 */