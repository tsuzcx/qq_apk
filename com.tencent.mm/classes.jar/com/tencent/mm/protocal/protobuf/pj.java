package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pj
  extends com.tencent.mm.bw.a
{
  public int KHa;
  public String KQY;
  public LinkedList<String> KWr;
  public int KWs;
  public String KWx;
  public LinkedList<pi> KWy;
  public String UserName;
  public String keb;
  public String oUJ;
  public String xLi;
  
  public pj()
  {
    AppMethodBeat.i(212252);
    this.KWy = new LinkedList();
    this.KWr = new LinkedList();
    AppMethodBeat.o(212252);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212253);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KHa);
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(3, this.oUJ);
      }
      if (this.xLi != null) {
        paramVarArgs.e(4, this.xLi);
      }
      if (this.keb != null) {
        paramVarArgs.e(5, this.keb);
      }
      if (this.KQY != null) {
        paramVarArgs.e(6, this.KQY);
      }
      if (this.KWx != null) {
        paramVarArgs.e(7, this.KWx);
      }
      paramVarArgs.e(8, 8, this.KWy);
      paramVarArgs.e(9, 1, this.KWr);
      paramVarArgs.aM(10, this.KWs);
      AppMethodBeat.o(212253);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.KHa) + 0;
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UserName);
      }
      i = paramInt;
      if (this.oUJ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.oUJ);
      }
      paramInt = i;
      if (this.xLi != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xLi);
      }
      i = paramInt;
      if (this.keb != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.keb);
      }
      paramInt = i;
      if (this.KQY != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KQY);
      }
      i = paramInt;
      if (this.KWx != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KWx);
      }
      paramInt = g.a.a.a.c(8, 8, this.KWy);
      int j = g.a.a.a.c(9, 1, this.KWr);
      int k = g.a.a.b.b.a.bu(10, this.KWs);
      AppMethodBeat.o(212253);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KWy.clear();
      this.KWr.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(212253);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      pj localpj = (pj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(212253);
        return -1;
      case 1: 
        localpj.KHa = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(212253);
        return 0;
      case 2: 
        localpj.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(212253);
        return 0;
      case 3: 
        localpj.oUJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(212253);
        return 0;
      case 4: 
        localpj.xLi = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(212253);
        return 0;
      case 5: 
        localpj.keb = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(212253);
        return 0;
      case 6: 
        localpj.KQY = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(212253);
        return 0;
      case 7: 
        localpj.KWx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(212253);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((pi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localpj.KWy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212253);
        return 0;
      case 9: 
        localpj.KWr.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(212253);
        return 0;
      }
      localpj.KWs = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(212253);
      return 0;
    }
    AppMethodBeat.o(212253);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pj
 * JD-Core Version:    0.7.0.1
 */