package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fbd
  extends erp
{
  public gol NkQ;
  public int YHj;
  public float ZaH;
  public int ZkT;
  public int abAV;
  public float abAW;
  public float abAX;
  public int oOu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32448);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.NkQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32448);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.NkQ != null)
      {
        paramVarArgs.qD(2, this.NkQ.computeSize());
        this.NkQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.abAV);
      paramVarArgs.bS(4, this.oOu);
      paramVarArgs.l(5, this.abAW);
      paramVarArgs.bS(6, this.ZkT);
      paramVarArgs.bS(7, this.YHj);
      paramVarArgs.l(8, this.abAX);
      paramVarArgs.l(9, this.ZaH);
      AppMethodBeat.o(32448);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NkQ != null) {
        i = paramInt + i.a.a.a.qC(2, this.NkQ.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.abAV);
      int j = i.a.a.b.b.a.cJ(4, this.oOu);
      int k = i.a.a.b.b.a.ko(5);
      int m = i.a.a.b.b.a.cJ(6, this.ZkT);
      int n = i.a.a.b.b.a.cJ(7, this.YHj);
      int i1 = i.a.a.b.b.a.ko(8);
      int i2 = i.a.a.b.b.a.ko(9);
      AppMethodBeat.o(32448);
      return i + paramInt + j + (k + 4) + m + n + (i1 + 4) + (i2 + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.NkQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(32448);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32448);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fbd localfbd = (fbd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32448);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localfbd.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32448);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfbd.NkQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32448);
          return 0;
        case 3: 
          localfbd.abAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32448);
          return 0;
        case 4: 
          localfbd.oOu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32448);
          return 0;
        case 5: 
          localfbd.abAW = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(32448);
          return 0;
        case 6: 
          localfbd.ZkT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32448);
          return 0;
        case 7: 
          localfbd.YHj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32448);
          return 0;
        case 8: 
          localfbd.abAX = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(32448);
          return 0;
        }
        localfbd.ZaH = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
        AppMethodBeat.o(32448);
        return 0;
      }
      AppMethodBeat.o(32448);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbd
 * JD-Core Version:    0.7.0.1
 */