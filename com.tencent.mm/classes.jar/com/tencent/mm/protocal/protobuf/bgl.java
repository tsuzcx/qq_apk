package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class bgl
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int Gaz;
  public String LPS;
  public int LQm;
  public int LQn;
  public String ThumbUrl;
  public String Title;
  public String jfi;
  public String xMq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42646);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
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
        paramVarArgs.e(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.e(3, this.ThumbUrl);
      }
      if (this.LPS != null) {
        paramVarArgs.e(4, this.LPS);
      }
      paramVarArgs.aM(5, this.LQm);
      paramVarArgs.aM(6, this.LQn);
      if (this.jfi != null) {
        paramVarArgs.e(7, this.jfi);
      }
      paramVarArgs.aM(8, this.Gaz);
      if (this.xMq != null) {
        paramVarArgs.e(9, this.xMq);
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
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Desc);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.LPS != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LPS);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.LQm) + g.a.a.b.b.a.bu(6, this.LQn);
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.jfi);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.Gaz);
      paramInt = i;
      if (this.xMq != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.xMq);
      }
      AppMethodBeat.o(42646);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bgl localbgl = (bgl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42646);
          return -1;
        case 1: 
          localbgl.Title = locala.UbS.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 2: 
          localbgl.Desc = locala.UbS.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 3: 
          localbgl.ThumbUrl = locala.UbS.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 4: 
          localbgl.LPS = locala.UbS.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 5: 
          localbgl.LQm = locala.UbS.zi();
          AppMethodBeat.o(42646);
          return 0;
        case 6: 
          localbgl.LQn = locala.UbS.zi();
          AppMethodBeat.o(42646);
          return 0;
        case 7: 
          localbgl.jfi = locala.UbS.readString();
          AppMethodBeat.o(42646);
          return 0;
        case 8: 
          localbgl.Gaz = locala.UbS.zi();
          AppMethodBeat.o(42646);
          return 0;
        }
        localbgl.xMq = locala.UbS.readString();
        AppMethodBeat.o(42646);
        return 0;
      }
      AppMethodBeat.o(42646);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgl
 * JD-Core Version:    0.7.0.1
 */