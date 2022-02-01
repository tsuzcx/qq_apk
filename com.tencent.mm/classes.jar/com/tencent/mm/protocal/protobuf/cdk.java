package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdk
  extends esc
{
  public int Zvi;
  public LinkedList<com.tencent.mm.bx.b> aanM;
  public int aanN;
  public LinkedList<Integer> aanO;
  
  public cdk()
  {
    AppMethodBeat.i(153147);
    this.aanM = new LinkedList();
    this.aanO = new LinkedList();
    AppMethodBeat.o(153147);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153148);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153148);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 6, this.aanM);
      paramVarArgs.bS(3, this.aanN);
      paramVarArgs.bS(4, this.Zvi);
      paramVarArgs.e(5, 2, this.aanO);
      AppMethodBeat.o(153148);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label547;
      }
    }
    label547:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 6, this.aanM);
      int j = i.a.a.b.b.a.cJ(3, this.aanN);
      int k = i.a.a.b.b.a.cJ(4, this.Zvi);
      int m = i.a.a.a.c(5, 2, this.aanO);
      AppMethodBeat.o(153148);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aanM.clear();
        this.aanO.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(153148);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153148);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cdk localcdk = (cdk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153148);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localcdk.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(153148);
          return 0;
        case 2: 
          localcdk.aanM.add(((i.a.a.a.a)localObject).ajGk.kFX());
          AppMethodBeat.o(153148);
          return 0;
        case 3: 
          localcdk.aanN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(153148);
          return 0;
        case 4: 
          localcdk.Zvi = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(153148);
          return 0;
        }
        localcdk.aanO.add(Integer.valueOf(((i.a.a.a.a)localObject).ajGk.aar()));
        AppMethodBeat.o(153148);
        return 0;
      }
      AppMethodBeat.o(153148);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdk
 * JD-Core Version:    0.7.0.1
 */