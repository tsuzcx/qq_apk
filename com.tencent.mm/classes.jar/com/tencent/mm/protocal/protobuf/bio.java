package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class bio
  extends com.tencent.mm.cd.a
{
  public String SSO;
  public b SSP;
  public String SSQ;
  public int actionType;
  public String appId;
  public String link;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198230);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SSO != null) {
        paramVarArgs.f(1, this.SSO);
      }
      paramVarArgs.aY(2, this.actionType);
      if (this.link != null) {
        paramVarArgs.f(3, this.link);
      }
      if (this.appId != null) {
        paramVarArgs.f(4, this.appId);
      }
      if (this.SSP != null) {
        paramVarArgs.c(5, this.SSP);
      }
      if (this.SSQ != null) {
        paramVarArgs.f(6, this.SSQ);
      }
      AppMethodBeat.o(198230);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SSO == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = g.a.a.b.b.a.g(1, this.SSO) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.actionType);
      paramInt = i;
      if (this.link != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.link);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.appId);
      }
      paramInt = i;
      if (this.SSP != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.SSP);
      }
      i = paramInt;
      if (this.SSQ != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.SSQ);
      }
      AppMethodBeat.o(198230);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(198230);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bio localbio = (bio)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(198230);
          return -1;
        case 1: 
          localbio.SSO = locala.abFh.readString();
          AppMethodBeat.o(198230);
          return 0;
        case 2: 
          localbio.actionType = locala.abFh.AK();
          AppMethodBeat.o(198230);
          return 0;
        case 3: 
          localbio.link = locala.abFh.readString();
          AppMethodBeat.o(198230);
          return 0;
        case 4: 
          localbio.appId = locala.abFh.readString();
          AppMethodBeat.o(198230);
          return 0;
        case 5: 
          localbio.SSP = locala.abFh.iUw();
          AppMethodBeat.o(198230);
          return 0;
        }
        localbio.SSQ = locala.abFh.readString();
        AppMethodBeat.o(198230);
        return 0;
      }
      AppMethodBeat.o(198230);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bio
 * JD-Core Version:    0.7.0.1
 */