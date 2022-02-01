package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecs
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String CqK;
  public String ThumbUrl;
  public String Uhi;
  public String UserName;
  public String fwr;
  public String jUi;
  public int rWt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211558);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.CMB != null) {
        paramVarArgs.f(2, this.CMB);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.f(3, this.ThumbUrl);
      }
      if (this.jUi != null) {
        paramVarArgs.f(4, this.jUi);
      }
      if (this.UserName != null) {
        paramVarArgs.f(5, this.UserName);
      }
      if (this.CqK != null) {
        paramVarArgs.f(6, this.CqK);
      }
      if (this.Uhi != null) {
        paramVarArgs.f(7, this.Uhi);
      }
      paramVarArgs.aY(8, this.rWt);
      AppMethodBeat.o(211558);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label626;
      }
    }
    label626:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMB);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.jUi != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.jUi);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UserName);
      }
      paramInt = i;
      if (this.CqK != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.CqK);
      }
      i = paramInt;
      if (this.Uhi != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Uhi);
      }
      paramInt = g.a.a.b.b.a.bM(8, this.rWt);
      AppMethodBeat.o(211558);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(211558);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ecs localecs = (ecs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(211558);
          return -1;
        case 1: 
          localecs.fwr = locala.abFh.readString();
          AppMethodBeat.o(211558);
          return 0;
        case 2: 
          localecs.CMB = locala.abFh.readString();
          AppMethodBeat.o(211558);
          return 0;
        case 3: 
          localecs.ThumbUrl = locala.abFh.readString();
          AppMethodBeat.o(211558);
          return 0;
        case 4: 
          localecs.jUi = locala.abFh.readString();
          AppMethodBeat.o(211558);
          return 0;
        case 5: 
          localecs.UserName = locala.abFh.readString();
          AppMethodBeat.o(211558);
          return 0;
        case 6: 
          localecs.CqK = locala.abFh.readString();
          AppMethodBeat.o(211558);
          return 0;
        case 7: 
          localecs.Uhi = locala.abFh.readString();
          AppMethodBeat.o(211558);
          return 0;
        }
        localecs.rWt = locala.abFh.AK();
        AppMethodBeat.o(211558);
        return 0;
      }
      AppMethodBeat.o(211558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecs
 * JD-Core Version:    0.7.0.1
 */