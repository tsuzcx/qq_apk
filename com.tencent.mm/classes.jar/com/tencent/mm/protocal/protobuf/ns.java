package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ns
  extends esc
{
  public String DUR;
  public int YPI;
  public int YPJ;
  public long YPK;
  public int YPT;
  public String YPU;
  public String YPV;
  public GoodsObject YPW;
  public boolean YPX = false;
  public int YPY;
  public boolean YPZ;
  public int YQa;
  public String hMy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124395);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124395);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YPT);
      if (this.YPU != null) {
        paramVarArgs.g(3, this.YPU);
      }
      if (this.YPV != null) {
        paramVarArgs.g(4, this.YPV);
      }
      if (this.hMy != null) {
        paramVarArgs.g(7, this.hMy);
      }
      if (this.DUR != null) {
        paramVarArgs.g(8, this.DUR);
      }
      if (this.YPW != null)
      {
        paramVarArgs.qD(9, this.YPW.computeSize());
        this.YPW.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(10, this.YPI);
      paramVarArgs.bv(11, this.YPK);
      paramVarArgs.bS(12, this.YPJ);
      paramVarArgs.di(13, this.YPX);
      paramVarArgs.bS(16, this.YPY);
      paramVarArgs.di(17, this.YPZ);
      paramVarArgs.bS(50, this.YQa);
      AppMethodBeat.o(124395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1138;
      }
    }
    label1138:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YPT);
      paramInt = i;
      if (this.YPU != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YPU);
      }
      i = paramInt;
      if (this.YPV != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YPV);
      }
      paramInt = i;
      if (this.hMy != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.hMy);
      }
      i = paramInt;
      if (this.DUR != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.DUR);
      }
      paramInt = i;
      if (this.YPW != null) {
        paramInt = i + i.a.a.a.qC(9, this.YPW.computeSize());
      }
      i = i.a.a.b.b.a.cJ(10, this.YPI);
      int j = i.a.a.b.b.a.q(11, this.YPK);
      int k = i.a.a.b.b.a.cJ(12, this.YPJ);
      int m = i.a.a.b.b.a.ko(13);
      int n = i.a.a.b.b.a.cJ(16, this.YPY);
      int i1 = i.a.a.b.b.a.ko(17);
      int i2 = i.a.a.b.b.a.cJ(50, this.YQa);
      AppMethodBeat.o(124395);
      return paramInt + i + j + k + (m + 1) + n + (i1 + 1) + i2;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124395);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ns localns = (ns)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124395);
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
            localns.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124395);
          return 0;
        case 2: 
          localns.YPT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124395);
          return 0;
        case 3: 
          localns.YPU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 4: 
          localns.YPV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 7: 
          localns.hMy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 8: 
          localns.DUR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124395);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new GoodsObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((GoodsObject)localObject2).parseFrom((byte[])localObject1);
            }
            localns.YPW = ((GoodsObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124395);
          return 0;
        case 10: 
          localns.YPI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124395);
          return 0;
        case 11: 
          localns.YPK = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(124395);
          return 0;
        case 12: 
          localns.YPJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124395);
          return 0;
        case 13: 
          localns.YPX = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(124395);
          return 0;
        case 16: 
          localns.YPY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124395);
          return 0;
        case 17: 
          localns.YPZ = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(124395);
          return 0;
        }
        localns.YQa = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(124395);
        return 0;
      }
      AppMethodBeat.o(124395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ns
 * JD-Core Version:    0.7.0.1
 */