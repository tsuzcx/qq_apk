package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cee
  extends com.tencent.mm.bw.a
{
  public int CYo;
  public String CYq;
  public String CYr;
  public String CYs;
  public String CYt;
  public String CYu;
  public String CYv;
  public int Dae;
  public cef HqY;
  public String HqZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72526);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Dae);
      if (this.HqY != null)
      {
        paramVarArgs.lJ(2, this.HqY.computeSize());
        this.HqY.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.CYo);
      if (this.CYq != null) {
        paramVarArgs.d(4, this.CYq);
      }
      if (this.CYr != null) {
        paramVarArgs.d(5, this.CYr);
      }
      if (this.CYs != null) {
        paramVarArgs.d(6, this.CYs);
      }
      if (this.CYt != null) {
        paramVarArgs.d(7, this.CYt);
      }
      if (this.CYu != null) {
        paramVarArgs.d(8, this.CYu);
      }
      if (this.CYv != null) {
        paramVarArgs.d(9, this.CYv);
      }
      if (this.HqZ != null) {
        paramVarArgs.d(10, this.HqZ);
      }
      AppMethodBeat.o(72526);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Dae) + 0;
      paramInt = i;
      if (this.HqY != null) {
        paramInt = i + f.a.a.a.lI(2, this.HqY.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.CYo);
      paramInt = i;
      if (this.CYq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CYq);
      }
      i = paramInt;
      if (this.CYr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CYr);
      }
      paramInt = i;
      if (this.CYs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CYs);
      }
      i = paramInt;
      if (this.CYt != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CYt);
      }
      paramInt = i;
      if (this.CYu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CYu);
      }
      i = paramInt;
      if (this.CYv != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CYv);
      }
      paramInt = i;
      if (this.HqZ != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.HqZ);
      }
      AppMethodBeat.o(72526);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(72526);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cee localcee = (cee)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72526);
        return -1;
      case 1: 
        localcee.Dae = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(72526);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cef();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cef)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcee.HqY = ((cef)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72526);
        return 0;
      case 3: 
        localcee.CYo = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(72526);
        return 0;
      case 4: 
        localcee.CYq = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 5: 
        localcee.CYr = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 6: 
        localcee.CYs = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 7: 
        localcee.CYt = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 8: 
        localcee.CYu = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72526);
        return 0;
      case 9: 
        localcee.CYv = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72526);
        return 0;
      }
      localcee.HqZ = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(72526);
      return 0;
    }
    AppMethodBeat.o(72526);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cee
 * JD-Core Version:    0.7.0.1
 */