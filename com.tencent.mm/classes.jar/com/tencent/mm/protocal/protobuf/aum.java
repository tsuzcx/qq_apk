package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class aum
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public int FHr;
  public int GsK;
  public int GsL;
  public String Gsq;
  public String ThumbUrl;
  public String Title;
  public String iht;
  public String uiR;
  
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
      if (this.Gsq != null) {
        paramVarArgs.d(4, this.Gsq);
      }
      paramVarArgs.aS(5, this.GsK);
      paramVarArgs.aS(6, this.GsL);
      if (this.iht != null) {
        paramVarArgs.d(7, this.iht);
      }
      paramVarArgs.aS(8, this.FHr);
      if (this.uiR != null) {
        paramVarArgs.d(9, this.uiR);
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
      if (this.Gsq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gsq);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.GsK) + f.a.a.b.b.a.bz(6, this.GsL);
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.iht);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.FHr);
      paramInt = i;
      if (this.uiR != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.uiR);
      }
      AppMethodBeat.o(42646);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        aum localaum = (aum)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42646);
          return -1;
        case 1: 
          localaum.Title = locala.NPN.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 2: 
          localaum.Desc = locala.NPN.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 3: 
          localaum.ThumbUrl = locala.NPN.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 4: 
          localaum.Gsq = locala.NPN.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 5: 
          localaum.GsK = locala.NPN.zc();
          AppMethodBeat.o(42646);
          return 0;
        case 6: 
          localaum.GsL = locala.NPN.zc();
          AppMethodBeat.o(42646);
          return 0;
        case 7: 
          localaum.iht = locala.NPN.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 8: 
          localaum.FHr = locala.NPN.zc();
          AppMethodBeat.o(42646);
          return 0;
        }
        localaum.uiR = locala.NPN.readString();
        AppMethodBeat.o(42646);
        return 0;
      }
      AppMethodBeat.o(42646);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aum
 * JD-Core Version:    0.7.0.1
 */