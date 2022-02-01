package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bsj
  extends erp
{
  public atz YIY;
  public aur ZDQ;
  public b ZEQ;
  public long ZHH;
  public int aaah;
  public String hQv;
  public int iaK;
  public float latitude;
  public float longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260019);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YIY != null)
      {
        paramVarArgs.qD(2, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(3, this.ZEQ);
      }
      paramVarArgs.l(4, this.longitude);
      paramVarArgs.l(5, this.latitude);
      if (this.ZDQ != null)
      {
        paramVarArgs.qD(6, this.ZDQ.computeSize());
        this.ZDQ.writeFields(paramVarArgs);
      }
      if (this.hQv != null) {
        paramVarArgs.g(7, this.hQv);
      }
      paramVarArgs.bv(8, this.ZHH);
      paramVarArgs.bS(9, this.aaah);
      paramVarArgs.bS(10, this.iaK);
      AppMethodBeat.o(260019);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label902;
      }
    }
    label902:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.ZEQ);
      }
      i = i + (i.a.a.b.b.a.ko(4) + 4) + (i.a.a.b.b.a.ko(5) + 4);
      paramInt = i;
      if (this.ZDQ != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZDQ.computeSize());
      }
      i = paramInt;
      if (this.hQv != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.hQv);
      }
      paramInt = i.a.a.b.b.a.q(8, this.ZHH);
      int j = i.a.a.b.b.a.cJ(9, this.aaah);
      int k = i.a.a.b.b.a.cJ(10, this.iaK);
      AppMethodBeat.o(260019);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260019);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bsj localbsj = (bsj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260019);
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
            localbsj.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260019);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbsj.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260019);
          return 0;
        case 3: 
          localbsj.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(260019);
          return 0;
        case 4: 
          localbsj.longitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(260019);
          return 0;
        case 5: 
          localbsj.latitude = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(260019);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aur();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aur)localObject2).parseFrom((byte[])localObject1);
            }
            localbsj.ZDQ = ((aur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260019);
          return 0;
        case 7: 
          localbsj.hQv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260019);
          return 0;
        case 8: 
          localbsj.ZHH = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260019);
          return 0;
        case 9: 
          localbsj.aaah = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260019);
          return 0;
        }
        localbsj.iaK = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260019);
        return 0;
      }
      AppMethodBeat.o(260019);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsj
 * JD-Core Version:    0.7.0.1
 */