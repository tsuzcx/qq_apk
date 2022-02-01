package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class pq
  extends com.tencent.mm.bw.a
{
  public String Ega;
  public String Egb;
  public int Egc;
  public String Egd;
  public int Ege;
  public String Title;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117846);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.Url == null)
      {
        paramVarArgs = new b("Not all required fields were included: Url");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.Ega == null)
      {
        paramVarArgs = new b("Not all required fields were included: Position");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.Egb == null)
      {
        paramVarArgs = new b("Not all required fields were included: DetailInfo");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Url != null) {
        paramVarArgs.d(2, this.Url);
      }
      if (this.Ega != null) {
        paramVarArgs.d(3, this.Ega);
      }
      if (this.Egb != null) {
        paramVarArgs.d(4, this.Egb);
      }
      paramVarArgs.aR(5, this.Egc);
      if (this.Egd != null) {
        paramVarArgs.d(6, this.Egd);
      }
      paramVarArgs.aR(7, this.Ege);
      AppMethodBeat.o(117846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Url);
      }
      i = paramInt;
      if (this.Ega != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ega);
      }
      paramInt = i;
      if (this.Egb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Egb);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.Egc);
      paramInt = i;
      if (this.Egd != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Egd);
      }
      i = f.a.a.b.b.a.bx(7, this.Ege);
      AppMethodBeat.o(117846);
      return paramInt + i;
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
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.Url == null)
        {
          paramVarArgs = new b("Not all required fields were included: Url");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.Ega == null)
        {
          paramVarArgs = new b("Not all required fields were included: Position");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.Egb == null)
        {
          paramVarArgs = new b("Not all required fields were included: DetailInfo");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117846);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        pq localpq = (pq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117846);
          return -1;
        case 1: 
          localpq.Title = locala.LVo.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 2: 
          localpq.Url = locala.LVo.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 3: 
          localpq.Ega = locala.LVo.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 4: 
          localpq.Egb = locala.LVo.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 5: 
          localpq.Egc = locala.LVo.xF();
          AppMethodBeat.o(117846);
          return 0;
        case 6: 
          localpq.Egd = locala.LVo.readString();
          AppMethodBeat.o(117846);
          return 0;
        }
        localpq.Ege = locala.LVo.xF();
        AppMethodBeat.o(117846);
        return 0;
      }
      AppMethodBeat.o(117846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pq
 * JD-Core Version:    0.7.0.1
 */