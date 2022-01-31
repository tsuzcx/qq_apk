package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class aeu
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String ThumbUrl;
  public String Title;
  public String fKw;
  public String ntp;
  public int wXM;
  public int wXN;
  public String wXs;
  public int wyt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(112434);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(112434);
        throw paramVarArgs;
      }
      if (this.Desc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(112434);
        throw paramVarArgs;
      }
      if (this.ThumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbUrl");
        AppMethodBeat.o(112434);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.e(3, this.ThumbUrl);
      }
      if (this.wXs != null) {
        paramVarArgs.e(4, this.wXs);
      }
      paramVarArgs.aO(5, this.wXM);
      paramVarArgs.aO(6, this.wXN);
      if (this.fKw != null) {
        paramVarArgs.e(7, this.fKw);
      }
      paramVarArgs.aO(8, this.wyt);
      if (this.ntp != null) {
        paramVarArgs.e(9, this.ntp);
      }
      AppMethodBeat.o(112434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label798;
      }
    }
    label798:
    for (int i = e.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Desc);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.wXs != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wXs);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wXM) + e.a.a.b.b.a.bl(6, this.wXN);
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.fKw);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.wyt);
      paramInt = i;
      if (this.ntp != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.ntp);
      }
      AppMethodBeat.o(112434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(112434);
          throw paramVarArgs;
        }
        if (this.Desc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(112434);
          throw paramVarArgs;
        }
        if (this.ThumbUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbUrl");
          AppMethodBeat.o(112434);
          throw paramVarArgs;
        }
        AppMethodBeat.o(112434);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aeu localaeu = (aeu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(112434);
          return -1;
        case 1: 
          localaeu.Title = locala.CLY.readString();
          AppMethodBeat.o(112434);
          return 0;
        case 2: 
          localaeu.Desc = locala.CLY.readString();
          AppMethodBeat.o(112434);
          return 0;
        case 3: 
          localaeu.ThumbUrl = locala.CLY.readString();
          AppMethodBeat.o(112434);
          return 0;
        case 4: 
          localaeu.wXs = locala.CLY.readString();
          AppMethodBeat.o(112434);
          return 0;
        case 5: 
          localaeu.wXM = locala.CLY.sl();
          AppMethodBeat.o(112434);
          return 0;
        case 6: 
          localaeu.wXN = locala.CLY.sl();
          AppMethodBeat.o(112434);
          return 0;
        case 7: 
          localaeu.fKw = locala.CLY.readString();
          AppMethodBeat.o(112434);
          return 0;
        case 8: 
          localaeu.wyt = locala.CLY.sl();
          AppMethodBeat.o(112434);
          return 0;
        }
        localaeu.ntp = locala.CLY.readString();
        AppMethodBeat.o(112434);
        return 0;
      }
      AppMethodBeat.o(112434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeu
 * JD-Core Version:    0.7.0.1
 */