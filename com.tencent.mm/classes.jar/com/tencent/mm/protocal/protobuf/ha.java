package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ha
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> KKJ;
  public long KKK;
  public String dHx;
  public String dOe;
  public String jfS;
  
  public ha()
  {
    AppMethodBeat.i(138168);
    this.KKJ = new LinkedList();
    AppMethodBeat.o(138168);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138169);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dOe == null)
      {
        paramVarArgs = new b("Not all required fields were included: roomname");
        AppMethodBeat.o(138169);
        throw paramVarArgs;
      }
      if (this.dOe != null) {
        paramVarArgs.e(1, this.dOe);
      }
      if (this.dHx != null) {
        paramVarArgs.e(2, this.dHx);
      }
      if (this.jfS != null) {
        paramVarArgs.e(3, this.jfS);
      }
      paramVarArgs.e(4, 1, this.KKJ);
      paramVarArgs.bb(5, this.KKK);
      AppMethodBeat.o(138169);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dOe == null) {
        break label486;
      }
    }
    label486:
    for (int i = g.a.a.b.b.a.f(1, this.dOe) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dHx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dHx);
      }
      i = paramInt;
      if (this.jfS != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.jfS);
      }
      paramInt = g.a.a.a.c(4, 1, this.KKJ);
      int j = g.a.a.b.b.a.r(5, this.KKK);
      AppMethodBeat.o(138169);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KKJ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.dOe == null)
        {
          paramVarArgs = new b("Not all required fields were included: roomname");
          AppMethodBeat.o(138169);
          throw paramVarArgs;
        }
        AppMethodBeat.o(138169);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ha localha = (ha)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138169);
          return -1;
        case 1: 
          localha.dOe = locala.UbS.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 2: 
          localha.dHx = locala.UbS.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 3: 
          localha.jfS = locala.UbS.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 4: 
          localha.KKJ.add(locala.UbS.readString());
          AppMethodBeat.o(138169);
          return 0;
        }
        localha.KKK = locala.UbS.zl();
        AppMethodBeat.o(138169);
        return 0;
      }
      AppMethodBeat.o(138169);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ha
 * JD-Core Version:    0.7.0.1
 */