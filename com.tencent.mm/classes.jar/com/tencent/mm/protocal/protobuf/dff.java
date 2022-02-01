package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dff
  extends com.tencent.mm.cd.a
{
  public String Srd;
  public String Sre;
  public int TMV;
  public String TMW;
  public String TMX;
  public String appId;
  public String jmB;
  public String nickName;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152637);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.f(1, this.userName);
      }
      if (this.nickName != null) {
        paramVarArgs.f(2, this.nickName);
      }
      if (this.jmB != null) {
        paramVarArgs.f(3, this.jmB);
      }
      if (this.Srd != null) {
        paramVarArgs.f(4, this.Srd);
      }
      if (this.Sre != null) {
        paramVarArgs.f(5, this.Sre);
      }
      paramVarArgs.aY(6, this.TMV);
      if (this.appId != null) {
        paramVarArgs.f(7, this.appId);
      }
      if (this.TMW != null) {
        paramVarArgs.f(8, this.TMW);
      }
      if (this.TMX != null) {
        paramVarArgs.f(9, this.TMX);
      }
      AppMethodBeat.o(152637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label686;
      }
    }
    label686:
    for (int i = g.a.a.b.b.a.g(1, this.userName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.nickName);
      }
      i = paramInt;
      if (this.jmB != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jmB);
      }
      paramInt = i;
      if (this.Srd != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Srd);
      }
      i = paramInt;
      if (this.Sre != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Sre);
      }
      i += g.a.a.b.b.a.bM(6, this.TMV);
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.appId);
      }
      i = paramInt;
      if (this.TMW != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.TMW);
      }
      paramInt = i;
      if (this.TMX != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TMX);
      }
      AppMethodBeat.o(152637);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152637);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dff localdff = (dff)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152637);
          return -1;
        case 1: 
          localdff.userName = locala.abFh.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 2: 
          localdff.nickName = locala.abFh.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 3: 
          localdff.jmB = locala.abFh.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 4: 
          localdff.Srd = locala.abFh.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 5: 
          localdff.Sre = locala.abFh.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 6: 
          localdff.TMV = locala.abFh.AK();
          AppMethodBeat.o(152637);
          return 0;
        case 7: 
          localdff.appId = locala.abFh.readString();
          AppMethodBeat.o(152637);
          return 0;
        case 8: 
          localdff.TMW = locala.abFh.readString();
          AppMethodBeat.o(152637);
          return 0;
        }
        localdff.TMX = locala.abFh.readString();
        AppMethodBeat.o(152637);
        return 0;
      }
      AppMethodBeat.o(152637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dff
 * JD-Core Version:    0.7.0.1
 */