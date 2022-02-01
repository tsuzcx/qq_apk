package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnf
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> SAn;
  public int TuK;
  public int TuL;
  public String TuM;
  public String md5;
  public String name;
  public String url;
  
  public cnf()
  {
    AppMethodBeat.i(82447);
    this.SAn = new LinkedList();
    AppMethodBeat.o(82447);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82448);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.f(1, this.name);
      }
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.f(3, this.md5);
      }
      paramVarArgs.e(4, 1, this.SAn);
      paramVarArgs.aY(5, this.TuK);
      paramVarArgs.aY(6, this.TuL);
      if (this.TuM != null) {
        paramVarArgs.f(7, this.TuM);
      }
      AppMethodBeat.o(82448);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label542;
      }
    }
    label542:
    for (int i = g.a.a.b.b.a.g(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.md5);
      }
      i = i + g.a.a.a.c(4, 1, this.SAn) + g.a.a.b.b.a.bM(5, this.TuK) + g.a.a.b.b.a.bM(6, this.TuL);
      paramInt = i;
      if (this.TuM != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TuM);
      }
      AppMethodBeat.o(82448);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SAn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82448);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cnf localcnf = (cnf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82448);
          return -1;
        case 1: 
          localcnf.name = locala.abFh.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 2: 
          localcnf.url = locala.abFh.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 3: 
          localcnf.md5 = locala.abFh.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 4: 
          localcnf.SAn.add(locala.abFh.readString());
          AppMethodBeat.o(82448);
          return 0;
        case 5: 
          localcnf.TuK = locala.abFh.AK();
          AppMethodBeat.o(82448);
          return 0;
        case 6: 
          localcnf.TuL = locala.abFh.AK();
          AppMethodBeat.o(82448);
          return 0;
        }
        localcnf.TuM = locala.abFh.readString();
        AppMethodBeat.o(82448);
        return 0;
      }
      AppMethodBeat.o(82448);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnf
 * JD-Core Version:    0.7.0.1
 */