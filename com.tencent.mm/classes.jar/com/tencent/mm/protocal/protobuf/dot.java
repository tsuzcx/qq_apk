package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dot
  extends com.tencent.mm.bw.a
{
  public int HVB;
  public int HVC;
  public String HVD;
  public dos HVE;
  public boolean dnq;
  public int hwE;
  public String id;
  public String kTz;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153001);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HVB);
      paramVarArgs.aS(2, this.hwE);
      paramVarArgs.aS(3, this.HVC);
      paramVarArgs.aS(4, this.type);
      if (this.id != null) {
        paramVarArgs.d(5, this.id);
      }
      if (this.kTz != null) {
        paramVarArgs.d(6, this.kTz);
      }
      if (this.HVD != null) {
        paramVarArgs.d(7, this.HVD);
      }
      if (this.HVE != null)
      {
        paramVarArgs.lJ(8, this.HVE.computeSize());
        this.HVE.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(9, this.dnq);
      AppMethodBeat.o(153001);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HVB) + 0 + f.a.a.b.b.a.bz(2, this.hwE) + f.a.a.b.b.a.bz(3, this.HVC) + f.a.a.b.b.a.bz(4, this.type);
      paramInt = i;
      if (this.id != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.id);
      }
      i = paramInt;
      if (this.kTz != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.kTz);
      }
      paramInt = i;
      if (this.HVD != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HVD);
      }
      i = paramInt;
      if (this.HVE != null) {
        i = paramInt + f.a.a.a.lI(8, this.HVE.computeSize());
      }
      paramInt = f.a.a.b.b.a.amF(9);
      AppMethodBeat.o(153001);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(153001);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dot localdot = (dot)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153001);
        return -1;
      case 1: 
        localdot.HVB = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(153001);
        return 0;
      case 2: 
        localdot.hwE = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(153001);
        return 0;
      case 3: 
        localdot.HVC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(153001);
        return 0;
      case 4: 
        localdot.type = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(153001);
        return 0;
      case 5: 
        localdot.id = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 6: 
        localdot.kTz = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 7: 
        localdot.HVD = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dos();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dos)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdot.HVE = ((dos)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153001);
        return 0;
      }
      localdot.dnq = ((f.a.a.a.a)localObject1).OmT.gvY();
      AppMethodBeat.o(153001);
      return 0;
    }
    AppMethodBeat.o(153001);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dot
 * JD-Core Version:    0.7.0.1
 */