package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class azz
  extends esc
{
  public int BeA;
  public int YzO;
  public LinkedList<bmd> ZDA;
  public b ZEQ;
  public float ZKP;
  public long ZKQ;
  public long ZKR;
  public long ZKy;
  
  public azz()
  {
    AppMethodBeat.i(258983);
    this.ZDA = new LinkedList();
    AppMethodBeat.o(258983);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258985);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YzO);
      paramVarArgs.l(3, this.ZKP);
      if (this.ZEQ != null) {
        paramVarArgs.d(4, this.ZEQ);
      }
      paramVarArgs.bS(5, this.BeA);
      paramVarArgs.e(6, 8, this.ZDA);
      paramVarArgs.bv(7, this.ZKQ);
      paramVarArgs.bv(8, this.ZKy);
      paramVarArgs.bv(9, this.ZKR);
      AppMethodBeat.o(258985);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label745;
      }
    }
    label745:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YzO) + (i.a.a.b.b.a.ko(3) + 4);
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.ZEQ);
      }
      i = i.a.a.b.b.a.cJ(5, this.BeA);
      int j = i.a.a.a.c(6, 8, this.ZDA);
      int k = i.a.a.b.b.a.q(7, this.ZKQ);
      int m = i.a.a.b.b.a.q(8, this.ZKy);
      int n = i.a.a.b.b.a.q(9, this.ZKR);
      AppMethodBeat.o(258985);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZDA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258985);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        azz localazz = (azz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258985);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localazz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258985);
          return 0;
        case 2: 
          localazz.YzO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258985);
          return 0;
        case 3: 
          localazz.ZKP = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(258985);
          return 0;
        case 4: 
          localazz.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258985);
          return 0;
        case 5: 
          localazz.BeA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258985);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bmd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bmd)localObject2).parseFrom((byte[])localObject1);
            }
            localazz.ZDA.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258985);
          return 0;
        case 7: 
          localazz.ZKQ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258985);
          return 0;
        case 8: 
          localazz.ZKy = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258985);
          return 0;
        }
        localazz.ZKR = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(258985);
        return 0;
      }
      AppMethodBeat.o(258985);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azz
 * JD-Core Version:    0.7.0.1
 */