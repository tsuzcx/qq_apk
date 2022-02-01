package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddy
  extends dyl
{
  public int RSi;
  public int TLF;
  public LinkedList<dea> TLG;
  public LinkedList<ddx> TLH;
  public int source;
  
  public ddy()
  {
    AppMethodBeat.i(6413);
    this.TLG = new LinkedList();
    this.TLH = new LinkedList();
    AppMethodBeat.o(6413);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6414);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TLF);
      paramVarArgs.aY(3, this.RSi);
      paramVarArgs.e(4, 8, this.TLG);
      paramVarArgs.e(5, 8, this.TLH);
      paramVarArgs.aY(6, this.source);
      AppMethodBeat.o(6414);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label680;
      }
    }
    label680:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.TLF);
      int j = g.a.a.b.b.a.bM(3, this.RSi);
      int k = g.a.a.a.c(4, 8, this.TLG);
      int m = g.a.a.a.c(5, 8, this.TLH);
      int n = g.a.a.b.b.a.bM(6, this.source);
      AppMethodBeat.o(6414);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TLG.clear();
        this.TLH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(6414);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ddy localddy = (ddy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6414);
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
            localddy.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6414);
          return 0;
        case 2: 
          localddy.TLF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(6414);
          return 0;
        case 3: 
          localddy.RSi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(6414);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dea();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dea)localObject2).parseFrom((byte[])localObject1);
            }
            localddy.TLG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6414);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ddx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ddx)localObject2).parseFrom((byte[])localObject1);
            }
            localddy.TLH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6414);
          return 0;
        }
        localddy.source = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(6414);
        return 0;
      }
      AppMethodBeat.o(6414);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddy
 * JD-Core Version:    0.7.0.1
 */