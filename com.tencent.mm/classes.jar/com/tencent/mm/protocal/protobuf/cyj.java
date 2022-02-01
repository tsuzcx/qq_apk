package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyj
  extends dyl
{
  public int CPw;
  public int RIr;
  public LinkedList<cyl> RPF;
  public int TGI;
  public LinkedList<cyi> TGJ;
  public int TGK;
  public String TGL;
  
  public cyj()
  {
    AppMethodBeat.i(127498);
    this.TGJ = new LinkedList();
    this.RPF = new LinkedList();
    AppMethodBeat.o(127498);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127499);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RIr);
      paramVarArgs.aY(3, this.TGI);
      paramVarArgs.e(4, 8, this.TGJ);
      paramVarArgs.aY(5, this.TGK);
      paramVarArgs.e(6, 8, this.RPF);
      if (this.TGL != null) {
        paramVarArgs.f(7, this.TGL);
      }
      paramVarArgs.aY(8, this.CPw);
      AppMethodBeat.o(127499);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label760;
      }
    }
    label760:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RIr) + g.a.a.b.b.a.bM(3, this.TGI) + g.a.a.a.c(4, 8, this.TGJ) + g.a.a.b.b.a.bM(5, this.TGK) + g.a.a.a.c(6, 8, this.RPF);
      paramInt = i;
      if (this.TGL != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TGL);
      }
      i = g.a.a.b.b.a.bM(8, this.CPw);
      AppMethodBeat.o(127499);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TGJ.clear();
        this.RPF.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127499);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cyj localcyj = (cyj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127499);
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
            localcyj.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 2: 
          localcyj.RIr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127499);
          return 0;
        case 3: 
          localcyj.TGI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127499);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cyi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cyi)localObject2).parseFrom((byte[])localObject1);
            }
            localcyj.TGJ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 5: 
          localcyj.TGK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127499);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cyl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cyl)localObject2).parseFrom((byte[])localObject1);
            }
            localcyj.RPF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 7: 
          localcyj.TGL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127499);
          return 0;
        }
        localcyj.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(127499);
        return 0;
      }
      AppMethodBeat.o(127499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyj
 * JD-Core Version:    0.7.0.1
 */