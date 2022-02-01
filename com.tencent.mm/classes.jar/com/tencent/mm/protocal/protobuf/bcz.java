package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcz
  extends com.tencent.mm.cd.a
{
  public int SOa;
  public String SOb;
  public boolean SOc;
  public boolean SOd;
  public boolean SOe;
  public boolean SOf;
  public LinkedList<bcz> SOg;
  public int SOh;
  public long object_id;
  
  public bcz()
  {
    AppMethodBeat.i(197187);
    this.SOg = new LinkedList();
    AppMethodBeat.o(197187);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197205);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SOa);
      if (this.SOb != null) {
        paramVarArgs.f(2, this.SOb);
      }
      paramVarArgs.co(3, this.SOc);
      paramVarArgs.co(4, this.SOd);
      paramVarArgs.co(5, this.SOe);
      paramVarArgs.co(6, this.SOf);
      paramVarArgs.e(7, 8, this.SOg);
      paramVarArgs.aY(8, this.SOh);
      paramVarArgs.bm(9, this.object_id);
      AppMethodBeat.o(197205);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.SOa) + 0;
      paramInt = i;
      if (this.SOb != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SOb);
      }
      i = g.a.a.b.b.a.gL(3);
      int j = g.a.a.b.b.a.gL(4);
      int k = g.a.a.b.b.a.gL(5);
      int m = g.a.a.b.b.a.gL(6);
      int n = g.a.a.a.c(7, 8, this.SOg);
      int i1 = g.a.a.b.b.a.bM(8, this.SOh);
      int i2 = g.a.a.b.b.a.p(9, this.object_id);
      AppMethodBeat.o(197205);
      return paramInt + (i + 1) + (j + 1) + (k + 1) + (m + 1) + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SOg.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(197205);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bcz localbcz1 = (bcz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(197205);
        return -1;
      case 1: 
        localbcz1.SOa = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197205);
        return 0;
      case 2: 
        localbcz1.SOb = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(197205);
        return 0;
      case 3: 
        localbcz1.SOc = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(197205);
        return 0;
      case 4: 
        localbcz1.SOd = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(197205);
        return 0;
      case 5: 
        localbcz1.SOe = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(197205);
        return 0;
      case 6: 
        localbcz1.SOf = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(197205);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bcz localbcz2 = new bcz();
          if ((localObject != null) && (localObject.length > 0)) {
            localbcz2.parseFrom((byte[])localObject);
          }
          localbcz1.SOg.add(localbcz2);
          paramInt += 1;
        }
        AppMethodBeat.o(197205);
        return 0;
      case 8: 
        localbcz1.SOh = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(197205);
        return 0;
      }
      localbcz1.object_id = ((g.a.a.a.a)localObject).abFh.AN();
      AppMethodBeat.o(197205);
      return 0;
    }
    AppMethodBeat.o(197205);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcz
 * JD-Core Version:    0.7.0.1
 */