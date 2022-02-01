package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dic
  extends erp
{
  public String Njp;
  public int aaMY;
  public LinkedList<etl> aaMZ;
  public int aaNa;
  public LinkedList<etl> aaNb;
  
  public dic()
  {
    AppMethodBeat.i(155434);
    this.aaMZ = new LinkedList();
    this.aaNb = new LinkedList();
    AppMethodBeat.o(155434);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155435);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Njp != null) {
        paramVarArgs.g(2, this.Njp);
      }
      paramVarArgs.bS(3, this.aaMY);
      paramVarArgs.e(4, 8, this.aaMZ);
      paramVarArgs.bS(5, this.aaNa);
      paramVarArgs.e(6, 8, this.aaNb);
      AppMethodBeat.o(155435);
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
      int i = paramInt;
      if (this.Njp != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Njp);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.aaMY);
      int j = i.a.a.a.c(4, 8, this.aaMZ);
      int k = i.a.a.b.b.a.cJ(5, this.aaNa);
      int m = i.a.a.a.c(6, 8, this.aaNb);
      AppMethodBeat.o(155435);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaMZ.clear();
        this.aaNb.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(155435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dic localdic = (dic)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155435);
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
            localdic.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155435);
          return 0;
        case 2: 
          localdic.Njp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155435);
          return 0;
        case 3: 
          localdic.aaMY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155435);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localdic.aaMZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155435);
          return 0;
        case 5: 
          localdic.aaNa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155435);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localdic.aaNb.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155435);
        return 0;
      }
      AppMethodBeat.o(155435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dic
 * JD-Core Version:    0.7.0.1
 */