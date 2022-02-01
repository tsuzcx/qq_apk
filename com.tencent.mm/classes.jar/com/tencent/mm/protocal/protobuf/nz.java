package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nz
  extends dyl
{
  public LinkedList<om> RVd;
  public int RVe;
  public int RVf;
  public String RVg;
  public long RVh;
  public String RVi;
  public ue RVj;
  public ny RVk;
  public fj RVl;
  public String RVm;
  public LinkedList<dva> jmy;
  public String zaX;
  
  public nz()
  {
    AppMethodBeat.i(210639);
    this.RVd = new LinkedList();
    this.jmy = new LinkedList();
    AppMethodBeat.o(210639);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210641);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.RVd);
      paramVarArgs.aY(3, this.RVe);
      paramVarArgs.aY(4, this.RVf);
      if (this.RVg != null) {
        paramVarArgs.f(5, this.RVg);
      }
      paramVarArgs.bm(6, this.RVh);
      if (this.RVi != null) {
        paramVarArgs.f(7, this.RVi);
      }
      if (this.RVj != null)
      {
        paramVarArgs.oE(8, this.RVj.computeSize());
        this.RVj.writeFields(paramVarArgs);
      }
      if (this.RVk != null)
      {
        paramVarArgs.oE(9, this.RVk.computeSize());
        this.RVk.writeFields(paramVarArgs);
      }
      if (this.RVl != null)
      {
        paramVarArgs.oE(10, this.RVl.computeSize());
        this.RVl.writeFields(paramVarArgs);
      }
      if (this.RVm != null) {
        paramVarArgs.f(11, this.RVm);
      }
      if (this.zaX != null) {
        paramVarArgs.f(12, this.zaX);
      }
      paramVarArgs.e(13, 8, this.jmy);
      AppMethodBeat.o(210641);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1306;
      }
    }
    label1306:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.RVd) + g.a.a.b.b.a.bM(3, this.RVe) + g.a.a.b.b.a.bM(4, this.RVf);
      paramInt = i;
      if (this.RVg != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RVg);
      }
      i = paramInt + g.a.a.b.b.a.p(6, this.RVh);
      paramInt = i;
      if (this.RVi != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RVi);
      }
      i = paramInt;
      if (this.RVj != null) {
        i = paramInt + g.a.a.a.oD(8, this.RVj.computeSize());
      }
      paramInt = i;
      if (this.RVk != null) {
        paramInt = i + g.a.a.a.oD(9, this.RVk.computeSize());
      }
      i = paramInt;
      if (this.RVl != null) {
        i = paramInt + g.a.a.a.oD(10, this.RVl.computeSize());
      }
      paramInt = i;
      if (this.RVm != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.RVm);
      }
      i = paramInt;
      if (this.zaX != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.zaX);
      }
      paramInt = g.a.a.a.c(13, 8, this.jmy);
      AppMethodBeat.o(210641);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RVd.clear();
        this.jmy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(210641);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        nz localnz = (nz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(210641);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localnz.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(210641);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new om();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((om)localObject2).parseFrom((byte[])localObject1);
            }
            localnz.RVd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(210641);
          return 0;
        case 3: 
          localnz.RVe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(210641);
          return 0;
        case 4: 
          localnz.RVf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(210641);
          return 0;
        case 5: 
          localnz.RVg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(210641);
          return 0;
        case 6: 
          localnz.RVh = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(210641);
          return 0;
        case 7: 
          localnz.RVi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(210641);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ue();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ue)localObject2).parseFrom((byte[])localObject1);
            }
            localnz.RVj = ((ue)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(210641);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ny();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ny)localObject2).parseFrom((byte[])localObject1);
            }
            localnz.RVk = ((ny)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(210641);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fj)localObject2).parseFrom((byte[])localObject1);
            }
            localnz.RVl = ((fj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(210641);
          return 0;
        case 11: 
          localnz.RVm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(210641);
          return 0;
        case 12: 
          localnz.zaX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(210641);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dva();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dva)localObject2).parseFrom((byte[])localObject1);
          }
          localnz.jmy.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(210641);
        return 0;
      }
      AppMethodBeat.o(210641);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nz
 * JD-Core Version:    0.7.0.1
 */