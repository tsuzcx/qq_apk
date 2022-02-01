package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cxj
  extends dyy
{
  public int CqV;
  public int CreateTime;
  public int HlE;
  public long HlH;
  public eaf RIE;
  public int RMl;
  public int TFR;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43105);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RIE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43105);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.CqV);
      if (this.RIE != null)
      {
        paramVarArgs.oE(2, this.RIE.computeSize());
        this.RIE.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.HlE);
      paramVarArgs.aY(4, this.TFR);
      paramVarArgs.aY(5, this.CreateTime);
      paramVarArgs.aY(6, this.RMl);
      paramVarArgs.aY(7, this.rWu);
      paramVarArgs.bm(8, this.HlH);
      AppMethodBeat.o(43105);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.CqV) + 0;
      paramInt = i;
      if (this.RIE != null) {
        paramInt = i + g.a.a.a.oD(2, this.RIE.computeSize());
      }
      i = g.a.a.b.b.a.bM(3, this.HlE);
      int j = g.a.a.b.b.a.bM(4, this.TFR);
      int k = g.a.a.b.b.a.bM(5, this.CreateTime);
      int m = g.a.a.b.b.a.bM(6, this.RMl);
      int n = g.a.a.b.b.a.bM(7, this.rWu);
      int i1 = g.a.a.b.b.a.p(8, this.HlH);
      AppMethodBeat.o(43105);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.RIE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(43105);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43105);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      cxj localcxj = (cxj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43105);
        return -1;
      case 1: 
        localcxj.CqV = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(43105);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eaf localeaf = new eaf();
          if ((localObject != null) && (localObject.length > 0)) {
            localeaf.de((byte[])localObject);
          }
          localcxj.RIE = localeaf;
          paramInt += 1;
        }
        AppMethodBeat.o(43105);
        return 0;
      case 3: 
        localcxj.HlE = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(43105);
        return 0;
      case 4: 
        localcxj.TFR = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(43105);
        return 0;
      case 5: 
        localcxj.CreateTime = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(43105);
        return 0;
      case 6: 
        localcxj.RMl = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(43105);
        return 0;
      case 7: 
        localcxj.rWu = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(43105);
        return 0;
      }
      localcxj.HlH = ((g.a.a.a.a)localObject).abFh.AN();
      AppMethodBeat.o(43105);
      return 0;
    }
    AppMethodBeat.o(43105);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxj
 * JD-Core Version:    0.7.0.1
 */