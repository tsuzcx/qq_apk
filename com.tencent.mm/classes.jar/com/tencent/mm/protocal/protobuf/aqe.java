package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class aqe
  extends com.tencent.mm.cd.a
{
  public int SDr;
  public b SDs;
  public int SDt;
  public aax SDu;
  public int SDv;
  public LinkedList<bft> SDw;
  public int scene;
  public long yjR;
  
  public aqe()
  {
    AppMethodBeat.i(204654);
    this.SDw = new LinkedList();
    AppMethodBeat.o(204654);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168937);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SDr);
      paramVarArgs.aY(2, this.scene);
      if (this.SDs != null) {
        paramVarArgs.c(3, this.SDs);
      }
      paramVarArgs.aY(4, this.SDt);
      if (this.SDu != null)
      {
        paramVarArgs.oE(5, this.SDu.computeSize());
        this.SDu.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.yjR);
      paramVarArgs.aY(7, this.SDv);
      paramVarArgs.e(8, 8, this.SDw);
      AppMethodBeat.o(168937);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.SDr) + 0 + g.a.a.b.b.a.bM(2, this.scene);
      paramInt = i;
      if (this.SDs != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.SDs);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.SDt);
      paramInt = i;
      if (this.SDu != null) {
        paramInt = i + g.a.a.a.oD(5, this.SDu.computeSize());
      }
      i = g.a.a.b.b.a.p(6, this.yjR);
      int j = g.a.a.b.b.a.bM(7, this.SDv);
      int k = g.a.a.a.c(8, 8, this.SDw);
      AppMethodBeat.o(168937);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SDw.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(168937);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      aqe localaqe = (aqe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168937);
        return -1;
      case 1: 
        localaqe.SDr = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168937);
        return 0;
      case 2: 
        localaqe.scene = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168937);
        return 0;
      case 3: 
        localaqe.SDs = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(168937);
        return 0;
      case 4: 
        localaqe.SDt = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168937);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aax();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aax)localObject2).parseFrom((byte[])localObject1);
          }
          localaqe.SDu = ((aax)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168937);
        return 0;
      case 6: 
        localaqe.yjR = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(168937);
        return 0;
      case 7: 
        localaqe.SDv = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168937);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bft();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bft)localObject2).parseFrom((byte[])localObject1);
        }
        localaqe.SDw.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(168937);
      return 0;
    }
    AppMethodBeat.o(168937);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqe
 * JD-Core Version:    0.7.0.1
 */