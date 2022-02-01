package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class csa
  extends esc
{
  public String IHZ;
  public LinkedList<fcj> aayo;
  public int aayp;
  public int aayq;
  
  public csa()
  {
    AppMethodBeat.i(153277);
    this.aayo = new LinkedList();
    AppMethodBeat.o(153277);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153278);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153278);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aayo);
      if (this.IHZ != null) {
        paramVarArgs.g(3, this.IHZ);
      }
      paramVarArgs.bS(4, this.aayp);
      paramVarArgs.bS(5, this.aayq);
      AppMethodBeat.o(153278);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aayo);
      paramInt = i;
      if (this.IHZ != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.IHZ);
      }
      i = i.a.a.b.b.a.cJ(4, this.aayp);
      int j = i.a.a.b.b.a.cJ(5, this.aayq);
      AppMethodBeat.o(153278);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aayo.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(153278);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153278);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        csa localcsa = (csa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153278);
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
            localcsa.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153278);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fcj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fcj)localObject2).parseFrom((byte[])localObject1);
            }
            localcsa.aayo.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153278);
          return 0;
        case 3: 
          localcsa.IHZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153278);
          return 0;
        case 4: 
          localcsa.aayp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153278);
          return 0;
        }
        localcsa.aayq = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(153278);
        return 0;
      }
      AppMethodBeat.o(153278);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csa
 * JD-Core Version:    0.7.0.1
 */