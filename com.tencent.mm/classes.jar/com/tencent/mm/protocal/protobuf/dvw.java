package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvw
  extends erp
{
  public int YPI;
  public int abbG;
  public LinkedList<dvy> abbH;
  public LinkedList<dvv> abbI;
  public int source;
  
  public dvw()
  {
    AppMethodBeat.i(6413);
    this.abbH = new LinkedList();
    this.abbI = new LinkedList();
    AppMethodBeat.o(6413);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6414);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abbG);
      paramVarArgs.bS(3, this.YPI);
      paramVarArgs.e(4, 8, this.abbH);
      paramVarArgs.e(5, 8, this.abbI);
      paramVarArgs.bS(6, this.source);
      AppMethodBeat.o(6414);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label676;
      }
    }
    label676:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.abbG);
      int j = i.a.a.b.b.a.cJ(3, this.YPI);
      int k = i.a.a.a.c(4, 8, this.abbH);
      int m = i.a.a.a.c(5, 8, this.abbI);
      int n = i.a.a.b.b.a.cJ(6, this.source);
      AppMethodBeat.o(6414);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abbH.clear();
        this.abbI.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(6414);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dvw localdvw = (dvw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6414);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localdvw.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6414);
          return 0;
        case 2: 
          localdvw.abbG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(6414);
          return 0;
        case 3: 
          localdvw.YPI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(6414);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dvy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dvy)localObject2).parseFrom((byte[])localObject1);
            }
            localdvw.abbH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6414);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dvv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dvv)localObject2).parseFrom((byte[])localObject1);
            }
            localdvw.abbI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6414);
          return 0;
        }
        localdvw.source = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(6414);
        return 0;
      }
      AppMethodBeat.o(6414);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvw
 * JD-Core Version:    0.7.0.1
 */