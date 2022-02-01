package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afd
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
  public dyk Gvx;
  public int Gvy;
  public LinkedList<dzy> Gvz;
  
  public afd()
  {
    AppMethodBeat.i(115835);
    this.Gvz = new LinkedList();
    AppMethodBeat.o(115835);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115836);
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
      if (this.Gvx != null)
      {
        paramVarArgs.lJ(7, this.Gvx.computeSize());
        this.Gvx.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.Gvy);
      paramVarArgs.e(9, 8, this.Gvz);
      paramVarArgs.aS(10, this.GvA);
      paramVarArgs.aS(11, this.GvB);
      AppMethodBeat.o(115836);
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
      if (this.Gvx != null) {
        paramInt = i + f.a.a.a.lI(7, this.Gvx.computeSize());
      }
      i = f.a.a.b.b.a.bz(8, this.Gvy);
      int j = f.a.a.a.c(9, 8, this.Gvz);
      int k = f.a.a.b.b.a.bz(10, this.GvA);
      int m = f.a.a.b.b.a.bz(11, this.GvB);
      AppMethodBeat.o(115836);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gvz.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(115836);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      afd localafd = (afd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115836);
        return -1;
      case 1: 
        localafd.Gvr = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115836);
        return 0;
      case 2: 
        localafd.Gvs = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(115836);
        return 0;
      case 3: 
        localafd.Gvt = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(115836);
        return 0;
      case 4: 
        localafd.Gvu = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115836);
        return 0;
      case 5: 
        localafd.Gvv = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115836);
        return 0;
      case 6: 
        localafd.Gvw = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115836);
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
          localafd.Gvx = ((dyk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115836);
        return 0;
      case 8: 
        localafd.Gvy = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115836);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localafd.Gvz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115836);
        return 0;
      case 10: 
        localafd.GvA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115836);
        return 0;
      }
      localafd.GvB = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(115836);
      return 0;
    }
    AppMethodBeat.o(115836);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afd
 * JD-Core Version:    0.7.0.1
 */