package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuu
  extends erp
{
  public int IJG;
  public LinkedList<etl> YFl;
  public int aaqr;
  public String muA;
  
  public cuu()
  {
    AppMethodBeat.i(32274);
    this.YFl = new LinkedList();
    AppMethodBeat.o(32274);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32275);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.muA != null) {
        paramVarArgs.g(2, this.muA);
      }
      paramVarArgs.bS(3, this.aaqr);
      paramVarArgs.e(4, 8, this.YFl);
      paramVarArgs.bS(5, this.IJG);
      AppMethodBeat.o(32275);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label569;
      }
    }
    label569:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.muA != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.muA);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.aaqr);
      int j = i.a.a.a.c(4, 8, this.YFl);
      int k = i.a.a.b.b.a.cJ(5, this.IJG);
      AppMethodBeat.o(32275);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YFl.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32275);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cuu localcuu = (cuu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32275);
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
            localcuu.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32275);
          return 0;
        case 2: 
          localcuu.muA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32275);
          return 0;
        case 3: 
          localcuu.aaqr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32275);
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
            localcuu.YFl.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32275);
          return 0;
        }
        localcuu.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32275);
        return 0;
      }
      AppMethodBeat.o(32275);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuu
 * JD-Core Version:    0.7.0.1
 */