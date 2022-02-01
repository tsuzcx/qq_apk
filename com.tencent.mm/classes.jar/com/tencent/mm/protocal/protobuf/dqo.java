package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dqo
  extends dyy
{
  public LinkedList<ddj> TKY;
  public String TKZ;
  public LinkedList<ddg> TLd;
  public boolean TXf;
  public String appid;
  public String lnp;
  public boolean oDO;
  public int oDP;
  public int oDQ;
  public String oDR;
  public String oDS;
  
  public dqo()
  {
    AppMethodBeat.i(82468);
    this.TKY = new LinkedList();
    this.TLd = new LinkedList();
    AppMethodBeat.o(82468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82469);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82469);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.co(2, this.TXf);
      paramVarArgs.e(3, 8, this.TKY);
      if (this.appid != null) {
        paramVarArgs.f(4, this.appid);
      }
      if (this.lnp != null) {
        paramVarArgs.f(5, this.lnp);
      }
      if (this.TKZ != null) {
        paramVarArgs.f(6, this.TKZ);
      }
      paramVarArgs.e(7, 8, this.TLd);
      paramVarArgs.co(8, this.oDO);
      paramVarArgs.aY(9, this.oDP);
      paramVarArgs.aY(10, this.oDQ);
      if (this.oDR != null) {
        paramVarArgs.f(11, this.oDR);
      }
      if (this.oDS != null) {
        paramVarArgs.f(12, this.oDS);
      }
      AppMethodBeat.o(82469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1052;
      }
    }
    label1052:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 1) + g.a.a.a.c(3, 8, this.TKY);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.appid);
      }
      i = paramInt;
      if (this.lnp != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.lnp);
      }
      paramInt = i;
      if (this.TKZ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TKZ);
      }
      i = paramInt + g.a.a.a.c(7, 8, this.TLd) + (g.a.a.b.b.a.gL(8) + 1) + g.a.a.b.b.a.bM(9, this.oDP) + g.a.a.b.b.a.bM(10, this.oDQ);
      paramInt = i;
      if (this.oDR != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.oDR);
      }
      i = paramInt;
      if (this.oDS != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.oDS);
      }
      AppMethodBeat.o(82469);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TKY.clear();
        this.TLd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82469);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dqo localdqo = (dqo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82469);
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
            localdqo.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 2: 
          localdqo.TXf = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(82469);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ddj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ddj)localObject2).parseFrom((byte[])localObject1);
            }
            localdqo.TKY.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 4: 
          localdqo.appid = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 5: 
          localdqo.lnp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 6: 
          localdqo.TKZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ddg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ddg)localObject2).parseFrom((byte[])localObject1);
            }
            localdqo.TLd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 8: 
          localdqo.oDO = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(82469);
          return 0;
        case 9: 
          localdqo.oDP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(82469);
          return 0;
        case 10: 
          localdqo.oDQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(82469);
          return 0;
        case 11: 
          localdqo.oDR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82469);
          return 0;
        }
        localdqo.oDS = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(82469);
        return 0;
      }
      AppMethodBeat.o(82469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqo
 * JD-Core Version:    0.7.0.1
 */