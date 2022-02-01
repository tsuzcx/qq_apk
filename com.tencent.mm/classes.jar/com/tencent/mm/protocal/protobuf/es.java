package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class es
  extends com.tencent.mm.cd.a
{
  public int RJC;
  public String appid;
  public int position;
  public String qJq;
  public String qJu;
  public String request_id;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50080);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.request_id != null) {
        paramVarArgs.f(2, this.request_id);
      }
      if (this.qJq != null) {
        paramVarArgs.f(3, this.qJq);
      }
      if (this.appid != null) {
        paramVarArgs.f(4, this.appid);
      }
      if (this.qJu != null) {
        paramVarArgs.f(5, this.qJu);
      }
      paramVarArgs.aY(6, this.position);
      paramVarArgs.aY(7, this.RJC);
      AppMethodBeat.o(50080);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label550;
      }
    }
    label550:
    for (int i = g.a.a.b.b.a.g(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.request_id != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.request_id);
      }
      i = paramInt;
      if (this.qJq != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.qJq);
      }
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.appid);
      }
      i = paramInt;
      if (this.qJu != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.qJu);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.position);
      int j = g.a.a.b.b.a.bM(7, this.RJC);
      AppMethodBeat.o(50080);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(50080);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        es locales = (es)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50080);
          return -1;
        case 1: 
          locales.username = locala.abFh.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 2: 
          locales.request_id = locala.abFh.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 3: 
          locales.qJq = locala.abFh.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 4: 
          locales.appid = locala.abFh.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 5: 
          locales.qJu = locala.abFh.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 6: 
          locales.position = locala.abFh.AK();
          AppMethodBeat.o(50080);
          return 0;
        }
        locales.RJC = locala.abFh.AK();
        AppMethodBeat.o(50080);
        return 0;
      }
      AppMethodBeat.o(50080);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.es
 * JD-Core Version:    0.7.0.1
 */