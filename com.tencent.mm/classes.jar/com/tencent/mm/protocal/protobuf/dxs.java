package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxs
  extends dyl
{
  public int SRZ;
  public long Tkj;
  public aaz Tkk;
  public LinkedList<ali> Uda;
  public int Udb;
  public int Udc;
  public LinkedList<aau> Udd;
  
  public dxs()
  {
    AppMethodBeat.i(50105);
    this.Uda = new LinkedList();
    this.Udd = new LinkedList();
    AppMethodBeat.o(50105);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50106);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.Tkj);
      paramVarArgs.e(3, 8, this.Uda);
      paramVarArgs.aY(5, this.Udb);
      paramVarArgs.aY(6, this.Udc);
      if (this.Tkk != null)
      {
        paramVarArgs.oE(7, this.Tkk.computeSize());
        this.Tkk.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.Udd);
      paramVarArgs.aY(9, this.SRZ);
      AppMethodBeat.o(50106);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.Tkj) + g.a.a.a.c(3, 8, this.Uda) + g.a.a.b.b.a.bM(5, this.Udb) + g.a.a.b.b.a.bM(6, this.Udc);
      paramInt = i;
      if (this.Tkk != null) {
        paramInt = i + g.a.a.a.oD(7, this.Tkk.computeSize());
      }
      i = g.a.a.a.c(8, 8, this.Udd);
      int j = g.a.a.b.b.a.bM(9, this.SRZ);
      AppMethodBeat.o(50106);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Uda.clear();
        this.Udd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(50106);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dxs localdxs = (dxs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 4: 
        default: 
          AppMethodBeat.o(50106);
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
            localdxs.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 2: 
          localdxs.Tkj = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(50106);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ali();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ali)localObject2).parseFrom((byte[])localObject1);
            }
            localdxs.Uda.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 5: 
          localdxs.Udb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(50106);
          return 0;
        case 6: 
          localdxs.Udc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(50106);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aaz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aaz)localObject2).parseFrom((byte[])localObject1);
            }
            localdxs.Tkk = ((aaz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aau();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aau)localObject2).parseFrom((byte[])localObject1);
            }
            localdxs.Udd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        }
        localdxs.SRZ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(50106);
        return 0;
      }
      AppMethodBeat.o(50106);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxs
 * JD-Core Version:    0.7.0.1
 */