package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class gbn
  extends erp
{
  public int ZkT;
  public int Zvz;
  public int abGP;
  public int abGQ;
  public int abGR;
  public int abGS;
  public int abGT;
  public LinkedList<Integer> abGU;
  public int abGV;
  public int abGW;
  public LinkedList<Integer> abGX;
  public int abGY;
  public int abGZ;
  
  public gbn()
  {
    AppMethodBeat.i(115916);
    this.abGU = new LinkedList();
    this.abGX = new LinkedList();
    AppMethodBeat.o(115916);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115917);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zvz);
      paramVarArgs.bS(3, this.abGP);
      paramVarArgs.bS(4, this.ZkT);
      paramVarArgs.bS(5, this.abGQ);
      paramVarArgs.bS(6, this.abGR);
      paramVarArgs.bS(7, this.abGS);
      paramVarArgs.bS(8, this.abGT);
      paramVarArgs.f(9, 2, this.abGU);
      paramVarArgs.bS(10, this.abGV);
      paramVarArgs.bS(11, this.abGW);
      paramVarArgs.f(12, 2, this.abGX);
      paramVarArgs.bS(13, this.abGY);
      paramVarArgs.bS(14, this.abGZ);
      AppMethodBeat.o(115917);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label958;
      }
    }
    label958:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.Zvz);
      int j = i.a.a.b.b.a.cJ(3, this.abGP);
      int k = i.a.a.b.b.a.cJ(4, this.ZkT);
      int m = i.a.a.b.b.a.cJ(5, this.abGQ);
      int n = i.a.a.b.b.a.cJ(6, this.abGR);
      int i1 = i.a.a.b.b.a.cJ(7, this.abGS);
      int i2 = i.a.a.b.b.a.cJ(8, this.abGT);
      int i3 = i.a.a.a.d(9, 2, this.abGU);
      int i4 = i.a.a.b.b.a.cJ(10, this.abGV);
      int i5 = i.a.a.b.b.a.cJ(11, this.abGW);
      int i6 = i.a.a.a.d(12, 2, this.abGX);
      int i7 = i.a.a.b.b.a.cJ(13, this.abGY);
      int i8 = i.a.a.b.b.a.cJ(14, this.abGZ);
      AppMethodBeat.o(115917);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abGU.clear();
        this.abGX.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(115917);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gbn localgbn = (gbn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115917);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localgbn.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(115917);
          return 0;
        case 2: 
          localgbn.Zvz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115917);
          return 0;
        case 3: 
          localgbn.abGP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115917);
          return 0;
        case 4: 
          localgbn.ZkT = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115917);
          return 0;
        case 5: 
          localgbn.abGQ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115917);
          return 0;
        case 6: 
          localgbn.abGR = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115917);
          return 0;
        case 7: 
          localgbn.abGS = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115917);
          return 0;
        case 8: 
          localgbn.abGT = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115917);
          return 0;
        case 9: 
          localgbn.abGU = new i.a.a.a.a(((i.a.a.a.a)localObject).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
          AppMethodBeat.o(115917);
          return 0;
        case 10: 
          localgbn.abGV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115917);
          return 0;
        case 11: 
          localgbn.abGW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115917);
          return 0;
        case 12: 
          localgbn.abGX = new i.a.a.a.a(((i.a.a.a.a)localObject).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
          AppMethodBeat.o(115917);
          return 0;
        case 13: 
          localgbn.abGY = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115917);
          return 0;
        }
        localgbn.abGZ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115917);
        return 0;
      }
      AppMethodBeat.o(115917);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gbn
 * JD-Core Version:    0.7.0.1
 */