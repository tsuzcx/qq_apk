package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpg
  extends dyy
{
  public int DPO;
  public String DPP;
  public int DPT;
  public int DPZ;
  public int DQa;
  public int DQb;
  public com.tencent.mm.cd.b DQc;
  public int DQe;
  public int DQh;
  public LinkedList<doy> RNx;
  public int Svu;
  public long Svv;
  public long TWc;
  public int TWl;
  public int TWm;
  public LinkedList<doy> TWn;
  public String TWo;
  public com.tencent.mm.cd.b TWp;
  public int TWq;
  
  public dpg()
  {
    AppMethodBeat.i(32379);
    this.RNx = new LinkedList();
    this.TWn = new LinkedList();
    AppMethodBeat.o(32379);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32380);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32380);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Svu);
      paramVarArgs.bm(3, this.Svv);
      paramVarArgs.aY(4, this.TWl);
      paramVarArgs.e(5, 8, this.RNx);
      paramVarArgs.aY(6, this.TWm);
      paramVarArgs.aY(7, this.DPZ);
      paramVarArgs.aY(8, this.DQa);
      paramVarArgs.bm(9, this.TWc);
      paramVarArgs.aY(10, this.DQb);
      if (this.DQc != null) {
        paramVarArgs.c(11, this.DQc);
      }
      paramVarArgs.aY(12, this.DPT);
      paramVarArgs.aY(13, this.DPO);
      if (this.DPP != null) {
        paramVarArgs.f(14, this.DPP);
      }
      paramVarArgs.aY(15, this.DQe);
      paramVarArgs.e(16, 8, this.TWn);
      paramVarArgs.aY(17, this.DQh);
      if (this.TWo != null) {
        paramVarArgs.f(18, this.TWo);
      }
      if (this.TWp != null) {
        paramVarArgs.c(19, this.TWp);
      }
      paramVarArgs.aY(20, this.TWq);
      AppMethodBeat.o(32380);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1422;
      }
    }
    label1422:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Svu) + g.a.a.b.b.a.p(3, this.Svv) + g.a.a.b.b.a.bM(4, this.TWl) + g.a.a.a.c(5, 8, this.RNx) + g.a.a.b.b.a.bM(6, this.TWm) + g.a.a.b.b.a.bM(7, this.DPZ) + g.a.a.b.b.a.bM(8, this.DQa) + g.a.a.b.b.a.p(9, this.TWc) + g.a.a.b.b.a.bM(10, this.DQb);
      paramInt = i;
      if (this.DQc != null) {
        paramInt = i + g.a.a.b.b.a.b(11, this.DQc);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.DPT) + g.a.a.b.b.a.bM(13, this.DPO);
      paramInt = i;
      if (this.DPP != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.DPP);
      }
      i = paramInt + g.a.a.b.b.a.bM(15, this.DQe) + g.a.a.a.c(16, 8, this.TWn) + g.a.a.b.b.a.bM(17, this.DQh);
      paramInt = i;
      if (this.TWo != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.TWo);
      }
      i = paramInt;
      if (this.TWp != null) {
        i = paramInt + g.a.a.b.b.a.b(19, this.TWp);
      }
      paramInt = g.a.a.b.b.a.bM(20, this.TWq);
      AppMethodBeat.o(32380);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RNx.clear();
        this.TWn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32380);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32380);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dpg localdpg = (dpg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32380);
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
            localdpg.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 2: 
          localdpg.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32380);
          return 0;
        case 3: 
          localdpg.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(32380);
          return 0;
        case 4: 
          localdpg.TWl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32380);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new doy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((doy)localObject2).parseFrom((byte[])localObject1);
            }
            localdpg.RNx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 6: 
          localdpg.TWm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32380);
          return 0;
        case 7: 
          localdpg.DPZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32380);
          return 0;
        case 8: 
          localdpg.DQa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32380);
          return 0;
        case 9: 
          localdpg.TWc = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(32380);
          return 0;
        case 10: 
          localdpg.DQb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32380);
          return 0;
        case 11: 
          localdpg.DQc = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(32380);
          return 0;
        case 12: 
          localdpg.DPT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32380);
          return 0;
        case 13: 
          localdpg.DPO = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32380);
          return 0;
        case 14: 
          localdpg.DPP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32380);
          return 0;
        case 15: 
          localdpg.DQe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32380);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new doy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((doy)localObject2).parseFrom((byte[])localObject1);
            }
            localdpg.TWn.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32380);
          return 0;
        case 17: 
          localdpg.DQh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32380);
          return 0;
        case 18: 
          localdpg.TWo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32380);
          return 0;
        case 19: 
          localdpg.TWp = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(32380);
          return 0;
        }
        localdpg.TWq = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32380);
        return 0;
      }
      AppMethodBeat.o(32380);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpg
 * JD-Core Version:    0.7.0.1
 */