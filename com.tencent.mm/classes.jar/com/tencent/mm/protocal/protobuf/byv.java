package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byv
  extends erp
{
  public int ODC;
  public atz ZEc;
  public int aahS;
  public int type;
  public String url;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257751);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZEc != null)
      {
        paramVarArgs.qD(2, this.ZEc.computeSize());
        this.ZEc.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.g(3, this.username);
      }
      paramVarArgs.bS(4, this.type);
      if (this.url != null) {
        paramVarArgs.g(5, this.url);
      }
      paramVarArgs.bS(6, this.ODC);
      paramVarArgs.bS(7, this.aahS);
      AppMethodBeat.o(257751);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZEc != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.username);
      }
      i += i.a.a.b.b.a.cJ(4, this.type);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.url);
      }
      i = i.a.a.b.b.a.cJ(6, this.ODC);
      int j = i.a.a.b.b.a.cJ(7, this.aahS);
      AppMethodBeat.o(257751);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257751);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        byv localbyv = (byv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257751);
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
            localbyv.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257751);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbyv.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257751);
          return 0;
        case 3: 
          localbyv.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257751);
          return 0;
        case 4: 
          localbyv.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257751);
          return 0;
        case 5: 
          localbyv.url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257751);
          return 0;
        case 6: 
          localbyv.ODC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257751);
          return 0;
        }
        localbyv.aahS = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257751);
        return 0;
      }
      AppMethodBeat.o(257751);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byv
 * JD-Core Version:    0.7.0.1
 */