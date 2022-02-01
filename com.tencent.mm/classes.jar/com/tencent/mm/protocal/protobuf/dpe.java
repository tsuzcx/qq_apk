package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dpe
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String IconUrl;
  public String MEq;
  public String MEr;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117904);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MEq != null) {
        paramVarArgs.e(1, this.MEq);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(3, this.Desc);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(4, this.IconUrl);
      }
      if (this.MEr != null) {
        paramVarArgs.e(5, this.MEr);
      }
      AppMethodBeat.o(117904);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MEq == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.f(1, this.MEq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Desc);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.IconUrl);
      }
      i = paramInt;
      if (this.MEr != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MEr);
      }
      AppMethodBeat.o(117904);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117904);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dpe localdpe = (dpe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117904);
          return -1;
        case 1: 
          localdpe.MEq = locala.UbS.readString();
          AppMethodBeat.o(117904);
          return 0;
        case 2: 
          localdpe.Title = locala.UbS.readString();
          AppMethodBeat.o(117904);
          return 0;
        case 3: 
          localdpe.Desc = locala.UbS.readString();
          AppMethodBeat.o(117904);
          return 0;
        case 4: 
          localdpe.IconUrl = locala.UbS.readString();
          AppMethodBeat.o(117904);
          return 0;
        }
        localdpe.MEr = locala.UbS.readString();
        AppMethodBeat.o(117904);
        return 0;
      }
      AppMethodBeat.o(117904);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpe
 * JD-Core Version:    0.7.0.1
 */