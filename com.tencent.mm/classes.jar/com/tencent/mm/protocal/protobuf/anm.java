package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class anm
  extends com.tencent.mm.bx.a
{
  public int CJd;
  public String Desc;
  public int DoI;
  public int DoJ;
  public String Doo;
  public String ThumbUrl;
  public String Title;
  public String hnC;
  public String scR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42646);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(42646);
        throw paramVarArgs;
      }
      if (this.Desc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(42646);
        throw paramVarArgs;
      }
      if (this.ThumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbUrl");
        AppMethodBeat.o(42646);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.d(3, this.ThumbUrl);
      }
      if (this.Doo != null) {
        paramVarArgs.d(4, this.Doo);
      }
      paramVarArgs.aR(5, this.DoI);
      paramVarArgs.aR(6, this.DoJ);
      if (this.hnC != null) {
        paramVarArgs.d(7, this.hnC);
      }
      paramVarArgs.aR(8, this.CJd);
      if (this.scR != null) {
        paramVarArgs.d(9, this.scR);
      }
      AppMethodBeat.o(42646);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label798;
      }
    }
    label798:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Desc);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.Doo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Doo);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.DoI) + f.a.a.b.b.a.bA(6, this.DoJ);
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hnC);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.CJd);
      paramInt = i;
      if (this.scR != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.scR);
      }
      AppMethodBeat.o(42646);
      return paramInt;
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
          AppMethodBeat.o(42646);
          throw paramVarArgs;
        }
        if (this.Desc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(42646);
          throw paramVarArgs;
        }
        if (this.ThumbUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbUrl");
          AppMethodBeat.o(42646);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42646);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        anm localanm = (anm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42646);
          return -1;
        case 1: 
          localanm.Title = locala.KhF.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 2: 
          localanm.Desc = locala.KhF.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 3: 
          localanm.ThumbUrl = locala.KhF.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 4: 
          localanm.Doo = locala.KhF.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 5: 
          localanm.DoI = locala.KhF.xS();
          AppMethodBeat.o(42646);
          return 0;
        case 6: 
          localanm.DoJ = locala.KhF.xS();
          AppMethodBeat.o(42646);
          return 0;
        case 7: 
          localanm.hnC = locala.KhF.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 8: 
          localanm.CJd = locala.KhF.xS();
          AppMethodBeat.o(42646);
          return 0;
        }
        localanm.scR = locala.KhF.readString();
        AppMethodBeat.o(42646);
        return 0;
      }
      AppMethodBeat.o(42646);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anm
 * JD-Core Version:    0.7.0.1
 */