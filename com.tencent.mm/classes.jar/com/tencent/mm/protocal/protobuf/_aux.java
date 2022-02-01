package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class aux
  extends dyy
{
  public b SHf;
  public LinkedList<aza> SHh;
  public LinkedList<aza> SHi;
  public long SHj;
  public int SHk;
  public int SHl;
  public aza SHm;
  public LinkedList<bbv> SHn;
  public long klE;
  public int zgd;
  public int zge;
  
  public aux()
  {
    AppMethodBeat.i(229600);
    this.SHh = new LinkedList();
    this.SHi = new LinkedList();
    this.SHn = new LinkedList();
    AppMethodBeat.o(229600);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229602);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.SHh);
      paramVarArgs.bm(3, this.klE);
      paramVarArgs.e(4, 8, this.SHi);
      paramVarArgs.bm(5, this.SHj);
      paramVarArgs.aY(6, this.SHk);
      paramVarArgs.aY(7, this.SHl);
      if (this.SHm != null)
      {
        paramVarArgs.oE(8, this.SHm.computeSize());
        this.SHm.writeFields(paramVarArgs);
      }
      if (this.SHf != null) {
        paramVarArgs.c(9, this.SHf);
      }
      paramVarArgs.aY(10, this.zgd);
      paramVarArgs.aY(11, this.zge);
      paramVarArgs.e(12, 8, this.SHn);
      AppMethodBeat.o(229602);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1104;
      }
    }
    label1104:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.SHh) + g.a.a.b.b.a.p(3, this.klE) + g.a.a.a.c(4, 8, this.SHi) + g.a.a.b.b.a.p(5, this.SHj) + g.a.a.b.b.a.bM(6, this.SHk) + g.a.a.b.b.a.bM(7, this.SHl);
      paramInt = i;
      if (this.SHm != null) {
        paramInt = i + g.a.a.a.oD(8, this.SHm.computeSize());
      }
      i = paramInt;
      if (this.SHf != null) {
        i = paramInt + g.a.a.b.b.a.b(9, this.SHf);
      }
      paramInt = g.a.a.b.b.a.bM(10, this.zgd);
      int j = g.a.a.b.b.a.bM(11, this.zge);
      int k = g.a.a.a.c(12, 8, this.SHn);
      AppMethodBeat.o(229602);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SHh.clear();
        this.SHi.clear();
        this.SHn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229602);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aux localaux = (aux)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229602);
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
            localaux.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229602);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aza();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aza)localObject2).parseFrom((byte[])localObject1);
            }
            localaux.SHh.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229602);
          return 0;
        case 3: 
          localaux.klE = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(229602);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aza();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aza)localObject2).parseFrom((byte[])localObject1);
            }
            localaux.SHi.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229602);
          return 0;
        case 5: 
          localaux.SHj = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(229602);
          return 0;
        case 6: 
          localaux.SHk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229602);
          return 0;
        case 7: 
          localaux.SHl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229602);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aza();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aza)localObject2).parseFrom((byte[])localObject1);
            }
            localaux.SHm = ((aza)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229602);
          return 0;
        case 9: 
          localaux.SHf = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(229602);
          return 0;
        case 10: 
          localaux.zgd = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229602);
          return 0;
        case 11: 
          localaux.zge = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229602);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bbv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bbv)localObject2).parseFrom((byte[])localObject1);
          }
          localaux.SHn.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(229602);
        return 0;
      }
      AppMethodBeat.o(229602);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aux
 * JD-Core Version:    0.7.0.1
 */