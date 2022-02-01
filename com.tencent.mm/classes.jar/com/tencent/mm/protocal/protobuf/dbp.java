package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbp
  extends com.tencent.mm.cd.a
{
  public long RUQ;
  public String SMU;
  public long SZm;
  public long SZn;
  public String TCi;
  public LinkedList<String> TCk;
  public LinkedList<cun> TCl;
  public String TIY;
  
  public dbp()
  {
    AppMethodBeat.i(110907);
    this.TCk = new LinkedList();
    this.TCl = new LinkedList();
    AppMethodBeat.o(110907);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110908);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SZn);
      paramVarArgs.bm(2, this.SZm);
      if (this.TCi != null) {
        paramVarArgs.f(3, this.TCi);
      }
      paramVarArgs.bm(4, this.RUQ);
      if (this.SMU != null) {
        paramVarArgs.f(5, this.SMU);
      }
      paramVarArgs.e(6, 1, this.TCk);
      paramVarArgs.e(7, 8, this.TCl);
      if (this.TIY != null) {
        paramVarArgs.f(8, this.TIY);
      }
      AppMethodBeat.o(110908);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.SZn) + 0 + g.a.a.b.b.a.p(2, this.SZm);
      paramInt = i;
      if (this.TCi != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.TCi);
      }
      i = paramInt + g.a.a.b.b.a.p(4, this.RUQ);
      paramInt = i;
      if (this.SMU != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SMU);
      }
      i = paramInt + g.a.a.a.c(6, 1, this.TCk) + g.a.a.a.c(7, 8, this.TCl);
      paramInt = i;
      if (this.TIY != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TIY);
      }
      AppMethodBeat.o(110908);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TCk.clear();
      this.TCl.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(110908);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dbp localdbp = (dbp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110908);
        return -1;
      case 1: 
        localdbp.SZn = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(110908);
        return 0;
      case 2: 
        localdbp.SZm = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(110908);
        return 0;
      case 3: 
        localdbp.TCi = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(110908);
        return 0;
      case 4: 
        localdbp.RUQ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(110908);
        return 0;
      case 5: 
        localdbp.SMU = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(110908);
        return 0;
      case 6: 
        localdbp.TCk.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(110908);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cun localcun = new cun();
          if ((localObject != null) && (localObject.length > 0)) {
            localcun.parseFrom((byte[])localObject);
          }
          localdbp.TCl.add(localcun);
          paramInt += 1;
        }
        AppMethodBeat.o(110908);
        return 0;
      }
      localdbp.TIY = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(110908);
      return 0;
    }
    AppMethodBeat.o(110908);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbp
 * JD-Core Version:    0.7.0.1
 */