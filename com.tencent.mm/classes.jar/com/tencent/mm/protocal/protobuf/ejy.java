package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ejy
  extends dpc
{
  public String Nji;
  public LinkedList<cbp> Njk;
  public boolean chA;
  public int pTZ;
  public String pUa;
  
  public ejy()
  {
    AppMethodBeat.i(72595);
    this.Njk = new LinkedList();
    AppMethodBeat.o(72595);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72596);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      paramVarArgs.e(4, 8, this.Njk);
      paramVarArgs.cc(5, this.chA);
      if (this.Nji != null) {
        paramVarArgs.e(6, this.Nji);
      }
      AppMethodBeat.o(72596);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + g.a.a.a.c(4, 8, this.Njk) + (g.a.a.b.b.a.fS(5) + 1);
      paramInt = i;
      if (this.Nji != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Nji);
      }
      AppMethodBeat.o(72596);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Njk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72596);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ejy localejy = (ejy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72596);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localejy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72596);
          return 0;
        case 2: 
          localejy.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72596);
          return 0;
        case 3: 
          localejy.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72596);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localejy.Njk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72596);
          return 0;
        case 5: 
          localejy.chA = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(72596);
          return 0;
        }
        localejy.Nji = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72596);
        return 0;
      }
      AppMethodBeat.o(72596);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejy
 * JD-Core Version:    0.7.0.1
 */