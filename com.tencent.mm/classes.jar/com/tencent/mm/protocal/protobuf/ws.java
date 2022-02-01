package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ws
  extends com.tencent.mm.bw.a
{
  public int DWJ;
  public int EqS;
  public String fZq;
  public String fZr;
  public String fZs;
  public String fZt;
  public String fZu;
  public int ndN;
  public int pAs;
  public LinkedList<bnv> tiT;
  
  public ws()
  {
    AppMethodBeat.i(143965);
    this.tiT = new LinkedList();
    AppMethodBeat.o(143965);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143966);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.pAs);
      if (this.fZs != null) {
        paramVarArgs.d(7, this.fZs);
      }
      paramVarArgs.aR(2, this.DWJ);
      paramVarArgs.aR(3, this.EqS);
      paramVarArgs.e(4, 8, this.tiT);
      if (this.fZq != null) {
        paramVarArgs.d(5, this.fZq);
      }
      if (this.fZr != null) {
        paramVarArgs.d(6, this.fZr);
      }
      if (this.fZt != null) {
        paramVarArgs.d(8, this.fZt);
      }
      if (this.fZu != null) {
        paramVarArgs.d(9, this.fZu);
      }
      paramVarArgs.aR(10, this.ndN);
      AppMethodBeat.o(143966);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.pAs) + 0;
      paramInt = i;
      if (this.fZs != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.fZs);
      }
      i = paramInt + f.a.a.b.b.a.bx(2, this.DWJ) + f.a.a.b.b.a.bx(3, this.EqS) + f.a.a.a.c(4, 8, this.tiT);
      paramInt = i;
      if (this.fZq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.fZq);
      }
      i = paramInt;
      if (this.fZr != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.fZr);
      }
      paramInt = i;
      if (this.fZt != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.fZt);
      }
      i = paramInt;
      if (this.fZu != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.fZu);
      }
      paramInt = f.a.a.b.b.a.bx(10, this.ndN);
      AppMethodBeat.o(143966);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tiT.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(143966);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ws localws = (ws)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143966);
        return -1;
      case 1: 
        localws.pAs = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143966);
        return 0;
      case 7: 
        localws.fZs = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 2: 
        localws.DWJ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143966);
        return 0;
      case 3: 
        localws.EqS = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143966);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bnv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bnv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localws.tiT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143966);
        return 0;
      case 5: 
        localws.fZq = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 6: 
        localws.fZr = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 8: 
        localws.fZt = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 9: 
        localws.fZu = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(143966);
        return 0;
      }
      localws.ndN = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(143966);
      return 0;
    }
    AppMethodBeat.o(143966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ws
 * JD-Core Version:    0.7.0.1
 */