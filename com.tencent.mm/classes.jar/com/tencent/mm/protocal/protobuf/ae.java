package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ae
  extends com.tencent.mm.cd.a
{
  public String REe;
  public String REf;
  public String REg;
  public String REh;
  public LinkedList<String> REi;
  public String rVH;
  public String rWh;
  
  public ae()
  {
    AppMethodBeat.i(145665);
    this.REi = new LinkedList();
    AppMethodBeat.o(145665);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145666);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rWh != null) {
        paramVarArgs.f(1, this.rWh);
      }
      if (this.rVH != null) {
        paramVarArgs.f(2, this.rVH);
      }
      if (this.REe != null) {
        paramVarArgs.f(3, this.REe);
      }
      if (this.REf != null) {
        paramVarArgs.f(4, this.REf);
      }
      if (this.REg != null) {
        paramVarArgs.f(5, this.REg);
      }
      if (this.REh != null) {
        paramVarArgs.f(6, this.REh);
      }
      paramVarArgs.e(7, 1, this.REi);
      AppMethodBeat.o(145666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rWh == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.b.b.a.g(1, this.rWh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rVH != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.rVH);
      }
      i = paramInt;
      if (this.REe != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.REe);
      }
      paramInt = i;
      if (this.REf != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.REf);
      }
      i = paramInt;
      if (this.REg != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.REg);
      }
      paramInt = i;
      if (this.REh != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.REh);
      }
      i = g.a.a.a.c(7, 1, this.REi);
      AppMethodBeat.o(145666);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.REi.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(145666);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(145666);
          return -1;
        case 1: 
          localae.rWh = locala.abFh.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 2: 
          localae.rVH = locala.abFh.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 3: 
          localae.REe = locala.abFh.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 4: 
          localae.REf = locala.abFh.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 5: 
          localae.REg = locala.abFh.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 6: 
          localae.REh = locala.abFh.readString();
          AppMethodBeat.o(145666);
          return 0;
        }
        localae.REi.add(locala.abFh.readString());
        AppMethodBeat.o(145666);
        return 0;
      }
      AppMethodBeat.o(145666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ae
 * JD-Core Version:    0.7.0.1
 */