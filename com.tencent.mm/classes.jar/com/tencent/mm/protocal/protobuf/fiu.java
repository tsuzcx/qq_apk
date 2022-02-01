package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class fiu
  extends com.tencent.mm.cd.a
{
  public int UIv;
  public String UIw;
  public String fXg;
  public String fvj;
  public String path;
  public int qbu;
  public int subType;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125852);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      if (this.path != null) {
        paramVarArgs.f(2, this.path);
      }
      paramVarArgs.aY(3, this.version);
      paramVarArgs.aY(4, this.qbu);
      if (this.fvj != null) {
        paramVarArgs.f(5, this.fvj);
      }
      paramVarArgs.aY(6, this.UIv);
      if (this.fXg != null) {
        paramVarArgs.f(7, this.fXg);
      }
      paramVarArgs.aY(8, this.subType);
      if (this.UIw != null) {
        paramVarArgs.f(9, this.UIw);
      }
      AppMethodBeat.o(125852);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = g.a.a.b.b.a.g(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.path);
      }
      i = i + g.a.a.b.b.a.bM(3, this.version) + g.a.a.b.b.a.bM(4, this.qbu);
      paramInt = i;
      if (this.fvj != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.fvj);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.UIv);
      paramInt = i;
      if (this.fXg != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.fXg);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.subType);
      paramInt = i;
      if (this.UIw != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.UIw);
      }
      AppMethodBeat.o(125852);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125852);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fiu localfiu = (fiu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125852);
          return -1;
        case 1: 
          localfiu.username = locala.abFh.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 2: 
          localfiu.path = locala.abFh.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 3: 
          localfiu.version = locala.abFh.AK();
          AppMethodBeat.o(125852);
          return 0;
        case 4: 
          localfiu.qbu = locala.abFh.AK();
          AppMethodBeat.o(125852);
          return 0;
        case 5: 
          localfiu.fvj = locala.abFh.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 6: 
          localfiu.UIv = locala.abFh.AK();
          AppMethodBeat.o(125852);
          return 0;
        case 7: 
          localfiu.fXg = locala.abFh.readString();
          AppMethodBeat.o(125852);
          return 0;
        case 8: 
          localfiu.subType = locala.abFh.AK();
          AppMethodBeat.o(125852);
          return 0;
        }
        localfiu.UIw = locala.abFh.readString();
        AppMethodBeat.o(125852);
        return 0;
      }
      AppMethodBeat.o(125852);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fiu
 * JD-Core Version:    0.7.0.1
 */