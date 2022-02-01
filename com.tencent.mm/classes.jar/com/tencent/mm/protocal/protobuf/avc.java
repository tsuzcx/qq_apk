package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class avc
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int FZN;
  public String GLO;
  public int GMi;
  public int GMj;
  public String ThumbUrl;
  public String Title;
  public String ikm;
  public String uuo;
  
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
      if (this.GLO != null) {
        paramVarArgs.d(4, this.GLO);
      }
      paramVarArgs.aS(5, this.GMi);
      paramVarArgs.aS(6, this.GMj);
      if (this.ikm != null) {
        paramVarArgs.d(7, this.ikm);
      }
      paramVarArgs.aS(8, this.FZN);
      if (this.uuo != null) {
        paramVarArgs.d(9, this.uuo);
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
      if (this.GLO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GLO);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.GMi) + f.a.a.b.b.a.bz(6, this.GMj);
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ikm);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.FZN);
      paramInt = i;
      if (this.uuo != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.uuo);
      }
      AppMethodBeat.o(42646);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        avc localavc = (avc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42646);
          return -1;
        case 1: 
          localavc.Title = locala.OmT.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 2: 
          localavc.Desc = locala.OmT.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 3: 
          localavc.ThumbUrl = locala.OmT.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 4: 
          localavc.GLO = locala.OmT.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 5: 
          localavc.GMi = locala.OmT.zc();
          AppMethodBeat.o(42646);
          return 0;
        case 6: 
          localavc.GMj = locala.OmT.zc();
          AppMethodBeat.o(42646);
          return 0;
        case 7: 
          localavc.ikm = locala.OmT.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 8: 
          localavc.FZN = locala.OmT.zc();
          AppMethodBeat.o(42646);
          return 0;
        }
        localavc.uuo = locala.OmT.readString();
        AppMethodBeat.o(42646);
        return 0;
      }
      AppMethodBeat.o(42646);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avc
 * JD-Core Version:    0.7.0.1
 */