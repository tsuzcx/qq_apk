package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class elf
  extends com.tencent.mm.cd.a
{
  public long Unm;
  public long Unn;
  public long Uno;
  public LinkedList<ejv> Unp;
  public String Unq;
  public String fJc;
  public String fLj;
  public String lwD;
  
  public elf()
  {
    AppMethodBeat.i(122548);
    this.Unm = 0L;
    this.Unn = 0L;
    this.Uno = 0L;
    this.Unp = new LinkedList();
    AppMethodBeat.o(122548);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122549);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fLj != null) {
        paramVarArgs.f(1, this.fLj);
      }
      paramVarArgs.bm(2, this.Unm);
      paramVarArgs.bm(3, this.Unn);
      paramVarArgs.bm(4, this.Uno);
      paramVarArgs.e(5, 8, this.Unp);
      if (this.fJc != null) {
        paramVarArgs.f(6, this.fJc);
      }
      if (this.lwD != null) {
        paramVarArgs.f(7, this.lwD);
      }
      if (this.Unq != null) {
        paramVarArgs.f(8, this.Unq);
      }
      AppMethodBeat.o(122549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fLj == null) {
        break label648;
      }
    }
    label648:
    for (paramInt = g.a.a.b.b.a.g(1, this.fLj) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.Unm) + g.a.a.b.b.a.p(3, this.Unn) + g.a.a.b.b.a.p(4, this.Uno) + g.a.a.a.c(5, 8, this.Unp);
      paramInt = i;
      if (this.fJc != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.fJc);
      }
      i = paramInt;
      if (this.lwD != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.lwD);
      }
      paramInt = i;
      if (this.Unq != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Unq);
      }
      AppMethodBeat.o(122549);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Unp.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122549);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        elf localelf = (elf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122549);
          return -1;
        case 1: 
          localelf.fLj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122549);
          return 0;
        case 2: 
          localelf.Unm = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(122549);
          return 0;
        case 3: 
          localelf.Unn = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(122549);
          return 0;
        case 4: 
          localelf.Uno = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(122549);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ejv localejv = new ejv();
            if ((localObject != null) && (localObject.length > 0)) {
              localejv.parseFrom((byte[])localObject);
            }
            localelf.Unp.add(localejv);
            paramInt += 1;
          }
          AppMethodBeat.o(122549);
          return 0;
        case 6: 
          localelf.fJc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122549);
          return 0;
        case 7: 
          localelf.lwD = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122549);
          return 0;
        }
        localelf.Unq = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(122549);
        return 0;
      }
      AppMethodBeat.o(122549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elf
 * JD-Core Version:    0.7.0.1
 */