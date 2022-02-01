package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bme
  extends erp
{
  public atz YIY;
  public String YIZ;
  public b YJa;
  public String ZJK;
  public int ZKO;
  public String ZOC;
  public String ZOF;
  public int ZOS;
  public int ZOT;
  public b ZRb;
  public boolean ZUV;
  public String ZUW;
  public long mMJ;
  public long object_id;
  public String request_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259069);
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
      if (this.YIZ != null) {
        paramVarArgs.g(3, this.YIZ);
      }
      paramVarArgs.bv(4, this.object_id);
      paramVarArgs.bv(5, this.mMJ);
      if (this.ZOC != null) {
        paramVarArgs.g(6, this.ZOC);
      }
      paramVarArgs.bS(7, this.ZOS);
      paramVarArgs.bS(8, this.ZOT);
      if (this.request_id != null) {
        paramVarArgs.g(9, this.request_id);
      }
      if (this.ZOF != null) {
        paramVarArgs.g(10, this.ZOF);
      }
      if (this.YJa != null) {
        paramVarArgs.d(11, this.YJa);
      }
      paramVarArgs.di(12, this.ZUV);
      if (this.ZUW != null) {
        paramVarArgs.g(13, this.ZUW);
      }
      if (this.ZJK != null) {
        paramVarArgs.g(14, this.ZJK);
      }
      paramVarArgs.bS(15, this.ZKO);
      if (this.ZRb != null) {
        paramVarArgs.d(16, this.ZRb);
      }
      AppMethodBeat.o(259069);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1178;
      }
    }
    label1178:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YIZ);
      }
      i = i + i.a.a.b.b.a.q(4, this.object_id) + i.a.a.b.b.a.q(5, this.mMJ);
      paramInt = i;
      if (this.ZOC != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZOC);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.ZOS) + i.a.a.b.b.a.cJ(8, this.ZOT);
      paramInt = i;
      if (this.request_id != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.request_id);
      }
      i = paramInt;
      if (this.ZOF != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.ZOF);
      }
      paramInt = i;
      if (this.YJa != null) {
        paramInt = i + i.a.a.b.b.a.c(11, this.YJa);
      }
      i = paramInt + (i.a.a.b.b.a.ko(12) + 1);
      paramInt = i;
      if (this.ZUW != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.ZUW);
      }
      i = paramInt;
      if (this.ZJK != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.ZJK);
      }
      i += i.a.a.b.b.a.cJ(15, this.ZKO);
      paramInt = i;
      if (this.ZRb != null) {
        paramInt = i + i.a.a.b.b.a.c(16, this.ZRb);
      }
      AppMethodBeat.o(259069);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259069);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bme localbme = (bme)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259069);
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
            localbme.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259069);
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
            localbme.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259069);
          return 0;
        case 3: 
          localbme.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259069);
          return 0;
        case 4: 
          localbme.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259069);
          return 0;
        case 5: 
          localbme.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259069);
          return 0;
        case 6: 
          localbme.ZOC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259069);
          return 0;
        case 7: 
          localbme.ZOS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259069);
          return 0;
        case 8: 
          localbme.ZOT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259069);
          return 0;
        case 9: 
          localbme.request_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259069);
          return 0;
        case 10: 
          localbme.ZOF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259069);
          return 0;
        case 11: 
          localbme.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259069);
          return 0;
        case 12: 
          localbme.ZUV = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(259069);
          return 0;
        case 13: 
          localbme.ZUW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259069);
          return 0;
        case 14: 
          localbme.ZJK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259069);
          return 0;
        case 15: 
          localbme.ZKO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259069);
          return 0;
        }
        localbme.ZRb = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(259069);
        return 0;
      }
      AppMethodBeat.o(259069);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bme
 * JD-Core Version:    0.7.0.1
 */