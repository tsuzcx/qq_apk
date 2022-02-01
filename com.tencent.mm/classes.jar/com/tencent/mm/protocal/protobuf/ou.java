package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ou
  extends dyy
{
  public int Dml;
  public int RVn;
  public long RWY;
  public int RWZ;
  public String RWj;
  public long RXa;
  public LinkedList<oq> RXb;
  public int RXc;
  public LinkedList<duc> RXd;
  public dub RXe;
  public int RXf;
  public int RXg;
  public int cUP;
  public String fZY;
  public int video_count;
  
  public ou()
  {
    AppMethodBeat.i(124440);
    this.RXb = new LinkedList();
    this.RXd = new LinkedList();
    AppMethodBeat.o(124440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124441);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.RWY);
      paramVarArgs.aY(3, this.Dml);
      paramVarArgs.aY(4, this.RWZ);
      paramVarArgs.bm(5, this.RXa);
      paramVarArgs.aY(6, this.RVn);
      paramVarArgs.e(7, 8, this.RXb);
      paramVarArgs.aY(8, this.RXc);
      if (this.RWj != null) {
        paramVarArgs.f(9, this.RWj);
      }
      paramVarArgs.aY(10, this.video_count);
      paramVarArgs.aY(11, this.cUP);
      paramVarArgs.e(12, 8, this.RXd);
      if (this.fZY != null) {
        paramVarArgs.f(14, this.fZY);
      }
      if (this.RXe != null)
      {
        paramVarArgs.oE(16, this.RXe.computeSize());
        this.RXe.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(17, this.RXf);
      paramVarArgs.aY(18, this.RXg);
      AppMethodBeat.o(124441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1282;
      }
    }
    label1282:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.RWY) + g.a.a.b.b.a.bM(3, this.Dml) + g.a.a.b.b.a.bM(4, this.RWZ) + g.a.a.b.b.a.p(5, this.RXa) + g.a.a.b.b.a.bM(6, this.RVn) + g.a.a.a.c(7, 8, this.RXb) + g.a.a.b.b.a.bM(8, this.RXc);
      paramInt = i;
      if (this.RWj != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.RWj);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.video_count) + g.a.a.b.b.a.bM(11, this.cUP) + g.a.a.a.c(12, 8, this.RXd);
      paramInt = i;
      if (this.fZY != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.fZY);
      }
      i = paramInt;
      if (this.RXe != null) {
        i = paramInt + g.a.a.a.oD(16, this.RXe.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(17, this.RXf);
      int j = g.a.a.b.b.a.bM(18, this.RXg);
      AppMethodBeat.o(124441);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RXb.clear();
        this.RXd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ou localou = (ou)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 13: 
        case 15: 
        default: 
          AppMethodBeat.o(124441);
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
            localou.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 2: 
          localou.RWY = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(124441);
          return 0;
        case 3: 
          localou.Dml = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124441);
          return 0;
        case 4: 
          localou.RWZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124441);
          return 0;
        case 5: 
          localou.RXa = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(124441);
          return 0;
        case 6: 
          localou.RVn = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124441);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new oq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((oq)localObject2).parseFrom((byte[])localObject1);
            }
            localou.RXb.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 8: 
          localou.RXc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124441);
          return 0;
        case 9: 
          localou.RWj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124441);
          return 0;
        case 10: 
          localou.video_count = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124441);
          return 0;
        case 11: 
          localou.cUP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124441);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new duc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((duc)localObject2).parseFrom((byte[])localObject1);
            }
            localou.RXd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 14: 
          localou.fZY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124441);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dub();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dub)localObject2).parseFrom((byte[])localObject1);
            }
            localou.RXe = ((dub)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 17: 
          localou.RXf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124441);
          return 0;
        }
        localou.RXg = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(124441);
        return 0;
      }
      AppMethodBeat.o(124441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ou
 * JD-Core Version:    0.7.0.1
 */