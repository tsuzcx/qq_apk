package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class agr
  extends esc
{
  public String Vyo;
  public LinkedList<vq> ZpP;
  public int ZpQ;
  public int ZpR;
  public int version;
  
  public agr()
  {
    AppMethodBeat.i(32177);
    this.ZpP = new LinkedList();
    AppMethodBeat.o(32177);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32178);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32178);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZpP);
      paramVarArgs.bS(3, this.version);
      paramVarArgs.bS(4, this.ZpQ);
      paramVarArgs.bS(5, this.ZpR);
      if (this.Vyo != null) {
        paramVarArgs.g(6, this.Vyo);
      }
      AppMethodBeat.o(32178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZpP) + i.a.a.b.b.a.cJ(3, this.version) + i.a.a.b.b.a.cJ(4, this.ZpQ) + i.a.a.b.b.a.cJ(5, this.ZpR);
      paramInt = i;
      if (this.Vyo != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Vyo);
      }
      AppMethodBeat.o(32178);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZpP.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32178);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32178);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        agr localagr = (agr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32178);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localagr.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32178);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vq)localObject2).parseFrom((byte[])localObject1);
            }
            localagr.ZpP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32178);
          return 0;
        case 3: 
          localagr.version = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32178);
          return 0;
        case 4: 
          localagr.ZpQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32178);
          return 0;
        case 5: 
          localagr.ZpR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32178);
          return 0;
        }
        localagr.Vyo = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32178);
        return 0;
      }
      AppMethodBeat.o(32178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agr
 * JD-Core Version:    0.7.0.1
 */