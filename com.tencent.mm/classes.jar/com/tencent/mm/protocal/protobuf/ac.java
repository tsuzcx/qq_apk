package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ac
  extends com.tencent.mm.bw.a
{
  public String KCm;
  public String KCn;
  public String KCo;
  public String KCp;
  public LinkedList<String> KCq;
  public String oTJ;
  public String oUj;
  
  public ac()
  {
    AppMethodBeat.i(145665);
    this.KCq = new LinkedList();
    AppMethodBeat.o(145665);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145666);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.oUj != null) {
        paramVarArgs.e(1, this.oUj);
      }
      if (this.oTJ != null) {
        paramVarArgs.e(2, this.oTJ);
      }
      if (this.KCm != null) {
        paramVarArgs.e(3, this.KCm);
      }
      if (this.KCn != null) {
        paramVarArgs.e(4, this.KCn);
      }
      if (this.KCo != null) {
        paramVarArgs.e(5, this.KCo);
      }
      if (this.KCp != null) {
        paramVarArgs.e(6, this.KCp);
      }
      paramVarArgs.e(7, 1, this.KCq);
      AppMethodBeat.o(145666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oUj == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.b.b.a.f(1, this.oUj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oTJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oTJ);
      }
      i = paramInt;
      if (this.KCm != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KCm);
      }
      paramInt = i;
      if (this.KCn != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KCn);
      }
      i = paramInt;
      if (this.KCo != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KCo);
      }
      paramInt = i;
      if (this.KCp != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KCp);
      }
      i = g.a.a.a.c(7, 1, this.KCq);
      AppMethodBeat.o(145666);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KCq.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(145666);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ac localac = (ac)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(145666);
          return -1;
        case 1: 
          localac.oUj = locala.UbS.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 2: 
          localac.oTJ = locala.UbS.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 3: 
          localac.KCm = locala.UbS.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 4: 
          localac.KCn = locala.UbS.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 5: 
          localac.KCo = locala.UbS.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 6: 
          localac.KCp = locala.UbS.readString();
          AppMethodBeat.o(145666);
          return 0;
        }
        localac.KCq.add(locala.UbS.readString());
        AppMethodBeat.o(145666);
        return 0;
      }
      AppMethodBeat.o(145666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ac
 * JD-Core Version:    0.7.0.1
 */