package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bio
  extends dpc
{
  public int LSF;
  public String LSG;
  public String LSH;
  public int pTZ;
  public String pUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91476);
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
      paramVarArgs.aM(4, this.LSF);
      if (this.LSG != null) {
        paramVarArgs.e(5, this.LSG);
      }
      if (this.LSH != null) {
        paramVarArgs.e(6, this.LSH);
      }
      AppMethodBeat.o(91476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.LSF);
      paramInt = i;
      if (this.LSG != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LSG);
      }
      i = paramInt;
      if (this.LSH != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.LSH);
      }
      AppMethodBeat.o(91476);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bio localbio = (bio)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91476);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbio.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91476);
          return 0;
        case 2: 
          localbio.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91476);
          return 0;
        case 3: 
          localbio.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91476);
          return 0;
        case 4: 
          localbio.LSF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91476);
          return 0;
        case 5: 
          localbio.LSG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91476);
          return 0;
        }
        localbio.LSH = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91476);
        return 0;
      }
      AppMethodBeat.o(91476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bio
 * JD-Core Version:    0.7.0.1
 */