package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aau
  extends com.tencent.mm.cd.a
{
  public int Sne;
  public int Snf;
  public String appid;
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
    AppMethodBeat.i(50083);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.qJp != null) {
        paramVarArgs.f(2, this.qJp);
      }
      paramVarArgs.aY(3, this.Sne);
      paramVarArgs.aY(4, this.Snf);
      if (this.qJq != null) {
        paramVarArgs.f(5, this.qJq);
      }
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
      AppMethodBeat.o(50083);
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
      int i = paramInt;
      if (this.qJp != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.qJp);
      }
      i = i + g.a.a.b.b.a.bM(3, this.Sne) + g.a.a.b.b.a.bM(4, this.Snf);
      paramInt = i;
      if (this.qJq != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.qJq);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.appid);
      }
      paramInt = i;
      if (this.qJr != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.qJr);
      }
      i = paramInt;
      if (this.qJs != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.qJs);
      }
      i += g.a.a.b.b.a.bM(9, this.qJt);
      paramInt = i;
      if (this.qJu != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.qJu);
      }
      i = g.a.a.b.b.a.bM(11, this.position);
      AppMethodBeat.o(50083);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(50083);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aau localaau = (aau)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50083);
          return -1;
        case 1: 
          localaau.username = locala.abFh.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 2: 
          localaau.qJp = locala.abFh.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 3: 
          localaau.Sne = locala.abFh.AK();
          AppMethodBeat.o(50083);
          return 0;
        case 4: 
          localaau.Snf = locala.abFh.AK();
          AppMethodBeat.o(50083);
          return 0;
        case 5: 
          localaau.qJq = locala.abFh.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 6: 
          localaau.appid = locala.abFh.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 7: 
          localaau.qJr = locala.abFh.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 8: 
          localaau.qJs = locala.abFh.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 9: 
          localaau.qJt = locala.abFh.AK();
          AppMethodBeat.o(50083);
          return 0;
        case 10: 
          localaau.qJu = locala.abFh.readString();
          AppMethodBeat.o(50083);
          return 0;
        }
        localaau.position = locala.abFh.AK();
        AppMethodBeat.o(50083);
        return 0;
      }
      AppMethodBeat.o(50083);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aau
 * JD-Core Version:    0.7.0.1
 */