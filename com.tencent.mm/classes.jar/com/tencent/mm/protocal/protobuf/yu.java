package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yu
  extends com.tencent.mm.bw.a
{
  public int FUA;
  public int GqB;
  public String gvo;
  public String gvp;
  public String gvq;
  public String gvr;
  public String gvs;
  public int nJF;
  public int qkC;
  public LinkedList<btb> usl;
  
  public yu()
  {
    AppMethodBeat.i(143965);
    this.usl = new LinkedList();
    AppMethodBeat.o(143965);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143966);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.qkC);
      if (this.gvq != null) {
        paramVarArgs.d(7, this.gvq);
      }
      paramVarArgs.aS(2, this.FUA);
      paramVarArgs.aS(3, this.GqB);
      paramVarArgs.e(4, 8, this.usl);
      if (this.gvo != null) {
        paramVarArgs.d(5, this.gvo);
      }
      if (this.gvp != null) {
        paramVarArgs.d(6, this.gvp);
      }
      if (this.gvr != null) {
        paramVarArgs.d(8, this.gvr);
      }
      if (this.gvs != null) {
        paramVarArgs.d(9, this.gvs);
      }
      paramVarArgs.aS(10, this.nJF);
      AppMethodBeat.o(143966);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.qkC) + 0;
      paramInt = i;
      if (this.gvq != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.gvq);
      }
      i = paramInt + f.a.a.b.b.a.bz(2, this.FUA) + f.a.a.b.b.a.bz(3, this.GqB) + f.a.a.a.c(4, 8, this.usl);
      paramInt = i;
      if (this.gvo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gvo);
      }
      i = paramInt;
      if (this.gvp != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.gvp);
      }
      paramInt = i;
      if (this.gvr != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.gvr);
      }
      i = paramInt;
      if (this.gvs != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.gvs);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.nJF);
      AppMethodBeat.o(143966);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.usl.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(143966);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      yu localyu = (yu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143966);
        return -1;
      case 1: 
        localyu.qkC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143966);
        return 0;
      case 7: 
        localyu.gvq = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 2: 
        localyu.FUA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143966);
        return 0;
      case 3: 
        localyu.GqB = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143966);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((btb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyu.usl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143966);
        return 0;
      case 5: 
        localyu.gvo = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 6: 
        localyu.gvp = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 8: 
        localyu.gvr = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 9: 
        localyu.gvs = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(143966);
        return 0;
      }
      localyu.nJF = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(143966);
      return 0;
    }
    AppMethodBeat.o(143966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yu
 * JD-Core Version:    0.7.0.1
 */