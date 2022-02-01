package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxe
  extends com.tencent.mm.bw.a
{
  public long EKf;
  public long EKg;
  public long EbQ;
  public String FhD;
  public String FhF;
  public LinkedList<String> FhG;
  public LinkedList<bsr> FhH;
  public String FlY;
  
  public bxe()
  {
    AppMethodBeat.i(110907);
    this.FhG = new LinkedList();
    this.FhH = new LinkedList();
    AppMethodBeat.o(110907);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110908);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.EKg);
      paramVarArgs.aO(2, this.EKf);
      if (this.FhD != null) {
        paramVarArgs.d(3, this.FhD);
      }
      paramVarArgs.aO(4, this.EbQ);
      if (this.FhF != null) {
        paramVarArgs.d(5, this.FhF);
      }
      paramVarArgs.e(6, 1, this.FhG);
      paramVarArgs.e(7, 8, this.FhH);
      if (this.FlY != null) {
        paramVarArgs.d(8, this.FlY);
      }
      AppMethodBeat.o(110908);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.EKg) + 0 + f.a.a.b.b.a.p(2, this.EKf);
      paramInt = i;
      if (this.FhD != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FhD);
      }
      i = paramInt + f.a.a.b.b.a.p(4, this.EbQ);
      paramInt = i;
      if (this.FhF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FhF);
      }
      i = paramInt + f.a.a.a.c(6, 1, this.FhG) + f.a.a.a.c(7, 8, this.FhH);
      paramInt = i;
      if (this.FlY != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FlY);
      }
      AppMethodBeat.o(110908);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FhG.clear();
      this.FhH.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(110908);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bxe localbxe = (bxe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110908);
        return -1;
      case 1: 
        localbxe.EKg = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110908);
        return 0;
      case 2: 
        localbxe.EKf = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110908);
        return 0;
      case 3: 
        localbxe.FhD = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(110908);
        return 0;
      case 4: 
        localbxe.EbQ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110908);
        return 0;
      case 5: 
        localbxe.FhF = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(110908);
        return 0;
      case 6: 
        localbxe.FhG.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(110908);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bsr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbxe.FhH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110908);
        return 0;
      }
      localbxe.FlY = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(110908);
      return 0;
    }
    AppMethodBeat.o(110908);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxe
 * JD-Core Version:    0.7.0.1
 */