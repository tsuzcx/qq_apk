package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnu
  extends dyy
{
  public int RPr;
  public String RPs;
  public String Sdn;
  public LinkedList<alj> TUZ;
  public LinkedList<bb> TVa;
  public int TVb;
  public int Tgz;
  
  public dnu()
  {
    AppMethodBeat.i(91628);
    this.TUZ = new LinkedList();
    this.TVa = new LinkedList();
    AppMethodBeat.o(91628);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91629);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Tgz);
      paramVarArgs.e(3, 8, this.TUZ);
      if (this.Sdn != null) {
        paramVarArgs.f(4, this.Sdn);
      }
      paramVarArgs.aY(5, this.RPr);
      if (this.RPs != null) {
        paramVarArgs.f(6, this.RPs);
      }
      paramVarArgs.e(7, 8, this.TVa);
      paramVarArgs.aY(8, this.TVb);
      AppMethodBeat.o(91629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label784;
      }
    }
    label784:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Tgz) + g.a.a.a.c(3, 8, this.TUZ);
      paramInt = i;
      if (this.Sdn != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Sdn);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.RPr);
      paramInt = i;
      if (this.RPs != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RPs);
      }
      i = g.a.a.a.c(7, 8, this.TVa);
      int j = g.a.a.b.b.a.bM(8, this.TVb);
      AppMethodBeat.o(91629);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TUZ.clear();
        this.TVa.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91629);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dnu localdnu = (dnu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91629);
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
            localdnu.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        case 2: 
          localdnu.Tgz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91629);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new alj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((alj)localObject2).parseFrom((byte[])localObject1);
            }
            localdnu.TUZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        case 4: 
          localdnu.Sdn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91629);
          return 0;
        case 5: 
          localdnu.RPr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91629);
          return 0;
        case 6: 
          localdnu.RPs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91629);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bb)localObject2).parseFrom((byte[])localObject1);
            }
            localdnu.TVa.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        }
        localdnu.TVb = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91629);
        return 0;
      }
      AppMethodBeat.o(91629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnu
 * JD-Core Version:    0.7.0.1
 */