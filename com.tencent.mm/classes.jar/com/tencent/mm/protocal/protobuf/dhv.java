package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhv
  extends com.tencent.mm.cd.a
{
  public int RJC;
  public int TOR;
  public String appid;
  public int position;
  public String qJp;
  public String qJq;
  public String qJu;
  public String request_id;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50096);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.qJp != null) {
        paramVarArgs.f(2, this.qJp);
      }
      if (this.request_id != null) {
        paramVarArgs.f(3, this.request_id);
      }
      if (this.qJq != null) {
        paramVarArgs.f(4, this.qJq);
      }
      if (this.appid != null) {
        paramVarArgs.f(5, this.appid);
      }
      if (this.qJu != null) {
        paramVarArgs.f(6, this.qJu);
      }
      paramVarArgs.aY(7, this.position);
      paramVarArgs.aY(8, this.TOR);
      paramVarArgs.aY(9, this.RJC);
      AppMethodBeat.o(50096);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label658;
      }
    }
    label658:
    for (int i = g.a.a.b.b.a.g(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qJp != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.qJp);
      }
      i = paramInt;
      if (this.request_id != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.request_id);
      }
      paramInt = i;
      if (this.qJq != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.qJq);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.appid);
      }
      paramInt = i;
      if (this.qJu != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.qJu);
      }
      i = g.a.a.b.b.a.bM(7, this.position);
      int j = g.a.a.b.b.a.bM(8, this.TOR);
      int k = g.a.a.b.b.a.bM(9, this.RJC);
      AppMethodBeat.o(50096);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(50096);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dhv localdhv = (dhv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50096);
          return -1;
        case 1: 
          localdhv.username = locala.abFh.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 2: 
          localdhv.qJp = locala.abFh.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 3: 
          localdhv.request_id = locala.abFh.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 4: 
          localdhv.qJq = locala.abFh.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 5: 
          localdhv.appid = locala.abFh.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 6: 
          localdhv.qJu = locala.abFh.readString();
          AppMethodBeat.o(50096);
          return 0;
        case 7: 
          localdhv.position = locala.abFh.AK();
          AppMethodBeat.o(50096);
          return 0;
        case 8: 
          localdhv.TOR = locala.abFh.AK();
          AppMethodBeat.o(50096);
          return 0;
        }
        localdhv.RJC = locala.abFh.AK();
        AppMethodBeat.o(50096);
        return 0;
      }
      AppMethodBeat.o(50096);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhv
 * JD-Core Version:    0.7.0.1
 */