package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eyy
  extends com.tencent.mm.cd.a
{
  public LinkedList<eyz> TLd;
  public boolean oDO;
  public int oDP;
  public int oDQ;
  public String oDR;
  public String oDS;
  public String oDT;
  public String oDU;
  
  public eyy()
  {
    AppMethodBeat.i(123670);
    this.TLd = new LinkedList();
    AppMethodBeat.o(123670);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123671);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.TLd);
      paramVarArgs.co(2, this.oDO);
      paramVarArgs.aY(3, this.oDP);
      paramVarArgs.aY(4, this.oDQ);
      if (this.oDR != null) {
        paramVarArgs.f(5, this.oDR);
      }
      if (this.oDS != null) {
        paramVarArgs.f(6, this.oDS);
      }
      if (this.oDT != null) {
        paramVarArgs.f(7, this.oDT);
      }
      if (this.oDU != null) {
        paramVarArgs.f(8, this.oDU);
      }
      AppMethodBeat.o(123671);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.TLd) + 0 + (g.a.a.b.b.a.gL(2) + 1) + g.a.a.b.b.a.bM(3, this.oDP) + g.a.a.b.b.a.bM(4, this.oDQ);
      paramInt = i;
      if (this.oDR != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.oDR);
      }
      i = paramInt;
      if (this.oDS != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.oDS);
      }
      paramInt = i;
      if (this.oDT != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.oDT);
      }
      i = paramInt;
      if (this.oDU != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.oDU);
      }
      AppMethodBeat.o(123671);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TLd.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(123671);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      eyy localeyy = (eyy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123671);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eyz localeyz = new eyz();
          if ((localObject != null) && (localObject.length > 0)) {
            localeyz.parseFrom((byte[])localObject);
          }
          localeyy.TLd.add(localeyz);
          paramInt += 1;
        }
        AppMethodBeat.o(123671);
        return 0;
      case 2: 
        localeyy.oDO = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(123671);
        return 0;
      case 3: 
        localeyy.oDP = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(123671);
        return 0;
      case 4: 
        localeyy.oDQ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(123671);
        return 0;
      case 5: 
        localeyy.oDR = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(123671);
        return 0;
      case 6: 
        localeyy.oDS = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(123671);
        return 0;
      case 7: 
        localeyy.oDT = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(123671);
        return 0;
      }
      localeyy.oDU = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(123671);
      return 0;
    }
    AppMethodBeat.o(123671);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyy
 * JD-Core Version:    0.7.0.1
 */