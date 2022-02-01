package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bfm
  extends com.tencent.mm.cd.a
{
  public String SQe;
  public String SQf;
  public String SQg;
  public String SQh;
  public int SQi;
  public String SQj;
  public String SQk;
  public String appName;
  public String nfY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169017);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SQe != null) {
        paramVarArgs.f(1, this.SQe);
      }
      if (this.SQf != null) {
        paramVarArgs.f(2, this.SQf);
      }
      if (this.SQg != null) {
        paramVarArgs.f(3, this.SQg);
      }
      if (this.appName != null) {
        paramVarArgs.f(4, this.appName);
      }
      if (this.SQh != null) {
        paramVarArgs.f(5, this.SQh);
      }
      if (this.nfY != null) {
        paramVarArgs.f(6, this.nfY);
      }
      paramVarArgs.aY(7, this.SQi);
      if (this.SQj != null) {
        paramVarArgs.f(8, this.SQj);
      }
      if (this.SQk != null) {
        paramVarArgs.f(9, this.SQk);
      }
      AppMethodBeat.o(169017);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SQe == null) {
        break label686;
      }
    }
    label686:
    for (int i = g.a.a.b.b.a.g(1, this.SQe) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SQf != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SQf);
      }
      i = paramInt;
      if (this.SQg != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SQg);
      }
      paramInt = i;
      if (this.appName != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.appName);
      }
      i = paramInt;
      if (this.SQh != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SQh);
      }
      paramInt = i;
      if (this.nfY != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.nfY);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.SQi);
      paramInt = i;
      if (this.SQj != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.SQj);
      }
      i = paramInt;
      if (this.SQk != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SQk);
      }
      AppMethodBeat.o(169017);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169017);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bfm localbfm = (bfm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169017);
          return -1;
        case 1: 
          localbfm.SQe = locala.abFh.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 2: 
          localbfm.SQf = locala.abFh.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 3: 
          localbfm.SQg = locala.abFh.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 4: 
          localbfm.appName = locala.abFh.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 5: 
          localbfm.SQh = locala.abFh.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 6: 
          localbfm.nfY = locala.abFh.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 7: 
          localbfm.SQi = locala.abFh.AK();
          AppMethodBeat.o(169017);
          return 0;
        case 8: 
          localbfm.SQj = locala.abFh.readString();
          AppMethodBeat.o(169017);
          return 0;
        }
        localbfm.SQk = locala.abFh.readString();
        AppMethodBeat.o(169017);
        return 0;
      }
      AppMethodBeat.o(169017);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfm
 * JD-Core Version:    0.7.0.1
 */