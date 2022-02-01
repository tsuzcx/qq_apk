package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctv
  extends com.tencent.mm.bw.a
{
  public int GvA;
  public int GvB;
  public int Gvr;
  public String Gvs;
  public String Gvt;
  public int Gvu;
  public int Gvv;
  public int Gvw;
  public dyk HEP;
  public dyk HEQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115848);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gvr);
      if (this.Gvs != null) {
        paramVarArgs.d(2, this.Gvs);
      }
      if (this.Gvt != null) {
        paramVarArgs.d(3, this.Gvt);
      }
      paramVarArgs.aS(4, this.Gvu);
      paramVarArgs.aS(5, this.Gvv);
      paramVarArgs.aS(6, this.Gvw);
      if (this.HEP != null)
      {
        paramVarArgs.lJ(7, this.HEP.computeSize());
        this.HEP.writeFields(paramVarArgs);
      }
      if (this.HEQ != null)
      {
        paramVarArgs.lJ(8, this.HEQ.computeSize());
        this.HEQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.GvA);
      paramVarArgs.aS(10, this.GvB);
      AppMethodBeat.o(115848);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Gvr) + 0;
      paramInt = i;
      if (this.Gvs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gvs);
      }
      i = paramInt;
      if (this.Gvt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gvt);
      }
      i = i + f.a.a.b.b.a.bz(4, this.Gvu) + f.a.a.b.b.a.bz(5, this.Gvv) + f.a.a.b.b.a.bz(6, this.Gvw);
      paramInt = i;
      if (this.HEP != null) {
        paramInt = i + f.a.a.a.lI(7, this.HEP.computeSize());
      }
      i = paramInt;
      if (this.HEQ != null) {
        i = paramInt + f.a.a.a.lI(8, this.HEQ.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(9, this.GvA);
      int j = f.a.a.b.b.a.bz(10, this.GvB);
      AppMethodBeat.o(115848);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(115848);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ctv localctv = (ctv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115848);
        return -1;
      case 1: 
        localctv.Gvr = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115848);
        return 0;
      case 2: 
        localctv.Gvs = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(115848);
        return 0;
      case 3: 
        localctv.Gvt = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(115848);
        return 0;
      case 4: 
        localctv.Gvu = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115848);
        return 0;
      case 5: 
        localctv.Gvv = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115848);
        return 0;
      case 6: 
        localctv.Gvw = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115848);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dyk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dyk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localctv.HEP = ((dyk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115848);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dyk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dyk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localctv.HEQ = ((dyk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115848);
        return 0;
      case 9: 
        localctv.GvA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115848);
        return 0;
      }
      localctv.GvB = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(115848);
      return 0;
    }
    AppMethodBeat.o(115848);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctv
 * JD-Core Version:    0.7.0.1
 */