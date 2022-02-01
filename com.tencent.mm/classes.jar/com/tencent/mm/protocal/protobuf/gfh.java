package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class gfh
  extends com.tencent.mm.bx.a
{
  public int accE;
  public String accF;
  public String hzD;
  public String idf;
  public String path;
  public int subType;
  public int tgv;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125852);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.path != null) {
        paramVarArgs.g(2, this.path);
      }
      paramVarArgs.bS(3, this.version);
      paramVarArgs.bS(4, this.tgv);
      if (this.hzD != null) {
        paramVarArgs.g(5, this.hzD);
      }
      paramVarArgs.bS(6, this.accE);
      if (this.idf != null) {
        paramVarArgs.g(7, this.idf);
      }
      paramVarArgs.bS(8, this.subType);
      if (this.accF != null) {
        paramVarArgs.g(9, this.accF);
      }
      AppMethodBeat.o(125852);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label634;
      }
    }
    label634:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.path);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.version) + i.a.a.b.b.a.cJ(4, this.tgv);
      paramInt = i;
      if (this.hzD != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.hzD);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.accE);
      paramInt = i;
      if (this.idf != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.idf);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.subType);
      paramInt = i;
      if (this.accF != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.accF);
      }
      AppMethodBeat.o(125852);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125852);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gfh localgfh = (gfh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125852);
          return -1;
        case 1: 
          localgfh.username = locala.ajGk.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 2: 
          localgfh.path = locala.ajGk.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 3: 
          localgfh.version = locala.ajGk.aar();
          AppMethodBeat.o(125852);
          return 0;
        case 4: 
          localgfh.tgv = locala.ajGk.aar();
          AppMethodBeat.o(125852);
          return 0;
        case 5: 
          localgfh.hzD = locala.ajGk.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 6: 
          localgfh.accE = locala.ajGk.aar();
          AppMethodBeat.o(125852);
          return 0;
        case 7: 
          localgfh.idf = locala.ajGk.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 8: 
          localgfh.subType = locala.ajGk.aar();
          AppMethodBeat.o(125852);
          return 0;
        }
        localgfh.accF = locala.ajGk.readString();
        AppMethodBeat.o(125852);
        return 0;
      }
      AppMethodBeat.o(125852);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gfh
 * JD-Core Version:    0.7.0.1
 */