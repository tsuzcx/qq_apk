package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dio
  extends com.tencent.mm.bw.a
{
  public int HPL;
  public int HPM;
  public int HPN;
  public dyj HPO;
  public int HPP;
  public int HPQ;
  public int HPR;
  public int HPS;
  public LinkedList<Integer> HPT;
  public int HPU;
  public LinkedList<Integer> HPV;
  public int HPW;
  public LinkedList<Integer> HPX;
  public String HPY;
  
  public dio()
  {
    AppMethodBeat.i(115851);
    this.HPT = new LinkedList();
    this.HPV = new LinkedList();
    this.HPX = new LinkedList();
    AppMethodBeat.o(115851);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115852);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HPO == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Addr");
        AppMethodBeat.o(115852);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.HPL);
      paramVarArgs.aS(2, this.HPM);
      paramVarArgs.aS(3, this.HPN);
      if (this.HPO != null)
      {
        paramVarArgs.lJ(4, this.HPO.computeSize());
        this.HPO.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.HPP);
      paramVarArgs.aS(6, this.HPQ);
      paramVarArgs.aS(7, this.HPR);
      paramVarArgs.aS(8, this.HPS);
      paramVarArgs.f(9, 2, this.HPT);
      paramVarArgs.aS(10, this.HPU);
      paramVarArgs.f(11, 2, this.HPV);
      paramVarArgs.aS(12, this.HPW);
      paramVarArgs.f(13, 2, this.HPX);
      if (this.HPY != null) {
        paramVarArgs.d(14, this.HPY);
      }
      AppMethodBeat.o(115852);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HPL) + 0 + f.a.a.b.b.a.bz(2, this.HPM) + f.a.a.b.b.a.bz(3, this.HPN);
      paramInt = i;
      if (this.HPO != null) {
        paramInt = i + f.a.a.a.lI(4, this.HPO.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HPP) + f.a.a.b.b.a.bz(6, this.HPQ) + f.a.a.b.b.a.bz(7, this.HPR) + f.a.a.b.b.a.bz(8, this.HPS) + f.a.a.a.d(9, 2, this.HPT) + f.a.a.b.b.a.bz(10, this.HPU) + f.a.a.a.d(11, 2, this.HPV) + f.a.a.b.b.a.bz(12, this.HPW) + f.a.a.a.d(13, 2, this.HPX);
      paramInt = i;
      if (this.HPY != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.HPY);
      }
      AppMethodBeat.o(115852);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HPT.clear();
      this.HPV.clear();
      this.HPX.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.HPO == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Addr");
        AppMethodBeat.o(115852);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115852);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dio localdio = (dio)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115852);
        return -1;
      case 1: 
        localdio.HPL = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 2: 
        localdio.HPM = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 3: 
        localdio.HPN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dyj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dyj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdio.HPO = ((dyj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115852);
        return 0;
      case 5: 
        localdio.HPP = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 6: 
        localdio.HPQ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 7: 
        localdio.HPR = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 8: 
        localdio.HPS = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 9: 
        localdio.HPT = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCi();
        AppMethodBeat.o(115852);
        return 0;
      case 10: 
        localdio.HPU = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 11: 
        localdio.HPV = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCi();
        AppMethodBeat.o(115852);
        return 0;
      case 12: 
        localdio.HPW = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115852);
        return 0;
      case 13: 
        localdio.HPX = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCi();
        AppMethodBeat.o(115852);
        return 0;
      }
      localdio.HPY = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(115852);
      return 0;
    }
    AppMethodBeat.o(115852);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dio
 * JD-Core Version:    0.7.0.1
 */