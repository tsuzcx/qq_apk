package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayr
  extends com.tencent.mm.cd.a
{
  public long SJY;
  public String SKH;
  public int SKI;
  public LinkedList<dlk> SKJ;
  public int result;
  public int status;
  
  public ayr()
  {
    AppMethodBeat.i(204672);
    this.SKJ = new LinkedList();
    AppMethodBeat.o(204672);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204676);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SKH != null) {
        paramVarArgs.f(1, this.SKH);
      }
      paramVarArgs.bm(2, this.SJY);
      paramVarArgs.aY(3, this.status);
      paramVarArgs.aY(4, this.SKI);
      paramVarArgs.e(6, 8, this.SKJ);
      paramVarArgs.aY(7, this.result);
      AppMethodBeat.o(204676);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SKH == null) {
        break label528;
      }
    }
    label528:
    for (paramInt = g.a.a.b.b.a.g(1, this.SKH) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.SJY);
      int j = g.a.a.b.b.a.bM(3, this.status);
      int k = g.a.a.b.b.a.bM(4, this.SKI);
      int m = g.a.a.a.c(6, 8, this.SKJ);
      int n = g.a.a.b.b.a.bM(7, this.result);
      AppMethodBeat.o(204676);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SKJ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(204676);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ayr localayr = (ayr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(204676);
          return -1;
        case 1: 
          localayr.SKH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(204676);
          return 0;
        case 2: 
          localayr.SJY = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(204676);
          return 0;
        case 3: 
          localayr.status = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(204676);
          return 0;
        case 4: 
          localayr.SKI = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(204676);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dlk localdlk = new dlk();
            if ((localObject != null) && (localObject.length > 0)) {
              localdlk.parseFrom((byte[])localObject);
            }
            localayr.SKJ.add(localdlk);
            paramInt += 1;
          }
          AppMethodBeat.o(204676);
          return 0;
        }
        localayr.result = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(204676);
        return 0;
      }
      AppMethodBeat.o(204676);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayr
 * JD-Core Version:    0.7.0.1
 */