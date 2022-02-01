package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwp
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> TDA;
  public int Ucq;
  public LinkedList<dwp> Ucr;
  public String key;
  public String name;
  public int type;
  
  public dwp()
  {
    AppMethodBeat.i(263393);
    this.TDA = new LinkedList();
    this.Ucr = new LinkedList();
    AppMethodBeat.o(263393);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(263395);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.f(1, this.key);
      }
      if (this.name != null) {
        paramVarArgs.f(2, this.name);
      }
      paramVarArgs.aY(3, this.type);
      paramVarArgs.e(4, 1, this.TDA);
      paramVarArgs.aY(5, this.Ucq);
      paramVarArgs.e(6, 8, this.Ucr);
      AppMethodBeat.o(263395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label548;
      }
    }
    label548:
    for (paramInt = g.a.a.b.b.a.g(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.name != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.name);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.type);
      int j = g.a.a.a.c(4, 1, this.TDA);
      int k = g.a.a.b.b.a.bM(5, this.Ucq);
      int m = g.a.a.a.c(6, 8, this.Ucr);
      AppMethodBeat.o(263395);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TDA.clear();
        this.Ucr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(263395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dwp localdwp1 = (dwp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(263395);
          return -1;
        case 1: 
          localdwp1.key = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(263395);
          return 0;
        case 2: 
          localdwp1.name = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(263395);
          return 0;
        case 3: 
          localdwp1.type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(263395);
          return 0;
        case 4: 
          localdwp1.TDA.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(263395);
          return 0;
        case 5: 
          localdwp1.Ucq = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(263395);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dwp localdwp2 = new dwp();
          if ((localObject != null) && (localObject.length > 0)) {
            localdwp2.parseFrom((byte[])localObject);
          }
          localdwp1.Ucr.add(localdwp2);
          paramInt += 1;
        }
        AppMethodBeat.o(263395);
        return 0;
      }
      AppMethodBeat.o(263395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwp
 * JD-Core Version:    0.7.0.1
 */