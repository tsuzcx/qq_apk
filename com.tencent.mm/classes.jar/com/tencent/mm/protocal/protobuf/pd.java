package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class pd
  extends dyy
{
  public int RUc;
  public dor RXA;
  public String RXB;
  public qc RXC;
  public qf RXD;
  public mg RXs;
  public nf RXt;
  public op RXu;
  public nh RXv;
  public op RXw;
  public pu RXx;
  public LinkedList<bmu> RXy;
  public int RXz;
  
  public pd()
  {
    AppMethodBeat.i(124444);
    this.RXy = new LinkedList();
    AppMethodBeat.o(124444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124445);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124445);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.RXs != null)
      {
        paramVarArgs.oE(2, this.RXs.computeSize());
        this.RXs.writeFields(paramVarArgs);
      }
      if (this.RXt != null)
      {
        paramVarArgs.oE(3, this.RXt.computeSize());
        this.RXt.writeFields(paramVarArgs);
      }
      if (this.RXu != null)
      {
        paramVarArgs.oE(4, this.RXu.computeSize());
        this.RXu.writeFields(paramVarArgs);
      }
      if (this.RXv != null)
      {
        paramVarArgs.oE(5, this.RXv.computeSize());
        this.RXv.writeFields(paramVarArgs);
      }
      if (this.RXw != null)
      {
        paramVarArgs.oE(6, this.RXw.computeSize());
        this.RXw.writeFields(paramVarArgs);
      }
      if (this.RXx != null)
      {
        paramVarArgs.oE(7, this.RXx.computeSize());
        this.RXx.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.RUc);
      paramVarArgs.e(9, 8, this.RXy);
      paramVarArgs.aY(10, this.RXz);
      if (this.RXA != null)
      {
        paramVarArgs.oE(11, this.RXA.computeSize());
        this.RXA.writeFields(paramVarArgs);
      }
      if (this.RXB != null) {
        paramVarArgs.f(12, this.RXB);
      }
      if (this.RXC != null)
      {
        paramVarArgs.oE(13, this.RXC.computeSize());
        this.RXC.writeFields(paramVarArgs);
      }
      if (this.RXD != null)
      {
        paramVarArgs.oE(14, this.RXD.computeSize());
        this.RXD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1804;
      }
    }
    label1804:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RXs != null) {
        paramInt = i + g.a.a.a.oD(2, this.RXs.computeSize());
      }
      i = paramInt;
      if (this.RXt != null) {
        i = paramInt + g.a.a.a.oD(3, this.RXt.computeSize());
      }
      paramInt = i;
      if (this.RXu != null) {
        paramInt = i + g.a.a.a.oD(4, this.RXu.computeSize());
      }
      i = paramInt;
      if (this.RXv != null) {
        i = paramInt + g.a.a.a.oD(5, this.RXv.computeSize());
      }
      paramInt = i;
      if (this.RXw != null) {
        paramInt = i + g.a.a.a.oD(6, this.RXw.computeSize());
      }
      i = paramInt;
      if (this.RXx != null) {
        i = paramInt + g.a.a.a.oD(7, this.RXx.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(8, this.RUc) + g.a.a.a.c(9, 8, this.RXy) + g.a.a.b.b.a.bM(10, this.RXz);
      paramInt = i;
      if (this.RXA != null) {
        paramInt = i + g.a.a.a.oD(11, this.RXA.computeSize());
      }
      i = paramInt;
      if (this.RXB != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.RXB);
      }
      paramInt = i;
      if (this.RXC != null) {
        paramInt = i + g.a.a.a.oD(13, this.RXC.computeSize());
      }
      i = paramInt;
      if (this.RXD != null) {
        i = paramInt + g.a.a.a.oD(14, this.RXD.computeSize());
      }
      AppMethodBeat.o(124445);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RXy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124445);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        pd localpd = (pd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124445);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localpd.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new mg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((mg)localObject2).parseFrom((byte[])localObject1);
            }
            localpd.RXs = ((mg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new nf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((nf)localObject2).parseFrom((byte[])localObject1);
            }
            localpd.RXt = ((nf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new op();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((op)localObject2).parseFrom((byte[])localObject1);
            }
            localpd.RXu = ((op)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new nh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((nh)localObject2).parseFrom((byte[])localObject1);
            }
            localpd.RXv = ((nh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new op();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((op)localObject2).parseFrom((byte[])localObject1);
            }
            localpd.RXw = ((op)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new pu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((pu)localObject2).parseFrom((byte[])localObject1);
            }
            localpd.RXx = ((pu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 8: 
          localpd.RUc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124445);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bmu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bmu)localObject2).parseFrom((byte[])localObject1);
            }
            localpd.RXy.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 10: 
          localpd.RXz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124445);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dor();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dor)localObject2).parseFrom((byte[])localObject1);
            }
            localpd.RXA = ((dor)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 12: 
          localpd.RXB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124445);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new qc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((qc)localObject2).parseFrom((byte[])localObject1);
            }
            localpd.RXC = ((qc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new qf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((qf)localObject2).parseFrom((byte[])localObject1);
          }
          localpd.RXD = ((qf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124445);
        return 0;
      }
      AppMethodBeat.o(124445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pd
 * JD-Core Version:    0.7.0.1
 */