package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acl
  extends com.tencent.mm.cd.a
{
  public int ChC;
  public int RKD;
  public int Soa;
  public String Sob;
  public int Soc;
  public int Sod;
  public int Soe;
  public int Sof;
  public String content;
  public String openid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103206);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.f(1, this.content);
      }
      if (this.openid != null) {
        paramVarArgs.f(3, this.openid);
      }
      paramVarArgs.aY(4, this.ChC);
      paramVarArgs.aY(5, this.RKD);
      paramVarArgs.aY(6, this.Soa);
      if (this.Sob != null) {
        paramVarArgs.f(7, this.Sob);
      }
      paramVarArgs.aY(8, this.Soc);
      paramVarArgs.aY(9, this.Sod);
      paramVarArgs.aY(10, this.Soe);
      paramVarArgs.aY(11, this.Sof);
      AppMethodBeat.o(103206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = g.a.a.b.b.a.g(1, this.content) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.openid != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.openid);
      }
      i = i + g.a.a.b.b.a.bM(4, this.ChC) + g.a.a.b.b.a.bM(5, this.RKD) + g.a.a.b.b.a.bM(6, this.Soa);
      paramInt = i;
      if (this.Sob != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Sob);
      }
      i = g.a.a.b.b.a.bM(8, this.Soc);
      int j = g.a.a.b.b.a.bM(9, this.Sod);
      int k = g.a.a.b.b.a.bM(10, this.Soe);
      int m = g.a.a.b.b.a.bM(11, this.Sof);
      AppMethodBeat.o(103206);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(103206);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        acl localacl = (acl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 2: 
        default: 
          AppMethodBeat.o(103206);
          return -1;
        case 1: 
          localacl.content = locala.abFh.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 3: 
          localacl.openid = locala.abFh.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 4: 
          localacl.ChC = locala.abFh.AK();
          AppMethodBeat.o(103206);
          return 0;
        case 5: 
          localacl.RKD = locala.abFh.AK();
          AppMethodBeat.o(103206);
          return 0;
        case 6: 
          localacl.Soa = locala.abFh.AK();
          AppMethodBeat.o(103206);
          return 0;
        case 7: 
          localacl.Sob = locala.abFh.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 8: 
          localacl.Soc = locala.abFh.AK();
          AppMethodBeat.o(103206);
          return 0;
        case 9: 
          localacl.Sod = locala.abFh.AK();
          AppMethodBeat.o(103206);
          return 0;
        case 10: 
          localacl.Soe = locala.abFh.AK();
          AppMethodBeat.o(103206);
          return 0;
        }
        localacl.Sof = locala.abFh.AK();
        AppMethodBeat.o(103206);
        return 0;
      }
      AppMethodBeat.o(103206);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acl
 * JD-Core Version:    0.7.0.1
 */