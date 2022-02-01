package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fdm
  extends dyy
{
  public int DPT;
  public int DPZ;
  public int DQa;
  public int DQe;
  public LinkedList<fdg> RNx;
  public long Svv;
  public com.tencent.mm.cd.b TWp;
  public int UDu;
  public int UDv;
  public int UDw;
  public LinkedList<fdg> UDx;
  public int UpV;
  public long Urf;
  
  public fdm()
  {
    AppMethodBeat.i(125499);
    this.RNx = new LinkedList();
    this.UDx = new LinkedList();
    AppMethodBeat.o(125499);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125500);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125500);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.Urf);
      paramVarArgs.bm(3, this.Svv);
      paramVarArgs.e(4, 8, this.RNx);
      paramVarArgs.aY(5, this.UpV);
      paramVarArgs.aY(6, this.DPZ);
      paramVarArgs.aY(7, this.DQa);
      paramVarArgs.aY(8, this.DPT);
      paramVarArgs.aY(9, this.DQe);
      paramVarArgs.aY(10, this.UDu);
      paramVarArgs.aY(11, this.UDv);
      if (this.TWp != null) {
        paramVarArgs.c(12, this.TWp);
      }
      paramVarArgs.aY(13, this.UDw);
      paramVarArgs.e(14, 8, this.UDx);
      AppMethodBeat.o(125500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1076;
      }
    }
    label1076:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.Urf) + g.a.a.b.b.a.p(3, this.Svv) + g.a.a.a.c(4, 8, this.RNx) + g.a.a.b.b.a.bM(5, this.UpV) + g.a.a.b.b.a.bM(6, this.DPZ) + g.a.a.b.b.a.bM(7, this.DQa) + g.a.a.b.b.a.bM(8, this.DPT) + g.a.a.b.b.a.bM(9, this.DQe) + g.a.a.b.b.a.bM(10, this.UDu) + g.a.a.b.b.a.bM(11, this.UDv);
      paramInt = i;
      if (this.TWp != null) {
        paramInt = i + g.a.a.b.b.a.b(12, this.TWp);
      }
      i = g.a.a.b.b.a.bM(13, this.UDw);
      int j = g.a.a.a.c(14, 8, this.UDx);
      AppMethodBeat.o(125500);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RNx.clear();
        this.UDx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125500);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125500);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fdm localfdm = (fdm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125500);
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
            localfdm.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125500);
          return 0;
        case 2: 
          localfdm.Urf = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125500);
          return 0;
        case 3: 
          localfdm.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(125500);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fdg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fdg)localObject2).parseFrom((byte[])localObject1);
            }
            localfdm.RNx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125500);
          return 0;
        case 5: 
          localfdm.UpV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125500);
          return 0;
        case 6: 
          localfdm.DPZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125500);
          return 0;
        case 7: 
          localfdm.DQa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125500);
          return 0;
        case 8: 
          localfdm.DPT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125500);
          return 0;
        case 9: 
          localfdm.DQe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125500);
          return 0;
        case 10: 
          localfdm.UDu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125500);
          return 0;
        case 11: 
          localfdm.UDv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125500);
          return 0;
        case 12: 
          localfdm.TWp = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(125500);
          return 0;
        case 13: 
          localfdm.UDw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125500);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fdg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fdg)localObject2).parseFrom((byte[])localObject1);
          }
          localfdm.UDx.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125500);
        return 0;
      }
      AppMethodBeat.o(125500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdm
 * JD-Core Version:    0.7.0.1
 */