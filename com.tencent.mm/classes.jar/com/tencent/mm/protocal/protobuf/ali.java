package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ali
  extends com.tencent.mm.cd.a
{
  public int SvN;
  public String appid;
  public int count;
  public int position;
  public String qJp;
  public String qJq;
  public String qJr;
  public String qJs;
  public int qJt;
  public String qJu;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50085);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      paramVarArgs.aY(2, this.count);
      if (this.qJp != null) {
        paramVarArgs.f(3, this.qJp);
      }
      if (this.qJq != null) {
        paramVarArgs.f(4, this.qJq);
      }
      paramVarArgs.aY(5, this.SvN);
      if (this.appid != null) {
        paramVarArgs.f(6, this.appid);
      }
      if (this.qJr != null) {
        paramVarArgs.f(7, this.qJr);
      }
      if (this.qJs != null) {
        paramVarArgs.f(8, this.qJs);
      }
      paramVarArgs.aY(9, this.qJt);
      if (this.qJu != null) {
        paramVarArgs.f(10, this.qJu);
      }
      paramVarArgs.aY(11, this.position);
      AppMethodBeat.o(50085);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label762;
      }
    }
    label762:
    for (paramInt = g.a.a.b.b.a.g(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.count);
      paramInt = i;
      if (this.qJp != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.qJp);
      }
      i = paramInt;
      if (this.qJq != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.qJq);
      }
      i += g.a.a.b.b.a.bM(5, this.SvN);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.appid);
      }
      i = paramInt;
      if (this.qJr != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.qJr);
      }
      paramInt = i;
      if (this.qJs != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.qJs);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.qJt);
      paramInt = i;
      if (this.qJu != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.qJu);
      }
      i = g.a.a.b.b.a.bM(11, this.position);
      AppMethodBeat.o(50085);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(50085);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ali localali = (ali)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50085);
          return -1;
        case 1: 
          localali.username = locala.abFh.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 2: 
          localali.count = locala.abFh.AK();
          AppMethodBeat.o(50085);
          return 0;
        case 3: 
          localali.qJp = locala.abFh.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 4: 
          localali.qJq = locala.abFh.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 5: 
          localali.SvN = locala.abFh.AK();
          AppMethodBeat.o(50085);
          return 0;
        case 6: 
          localali.appid = locala.abFh.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 7: 
          localali.qJr = locala.abFh.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 8: 
          localali.qJs = locala.abFh.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 9: 
          localali.qJt = locala.abFh.AK();
          AppMethodBeat.o(50085);
          return 0;
        case 10: 
          localali.qJu = locala.abFh.readString();
          AppMethodBeat.o(50085);
          return 0;
        }
        localali.position = locala.abFh.AK();
        AppMethodBeat.o(50085);
        return 0;
      }
      AppMethodBeat.o(50085);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ali
 * JD-Core Version:    0.7.0.1
 */