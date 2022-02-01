package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bik
  extends dpc
{
  public LinkedList<String> LSA;
  public String LSB;
  public String qGG;
  public String title;
  
  public bik()
  {
    AppMethodBeat.i(181502);
    this.LSA = new LinkedList();
    AppMethodBeat.o(181502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181503);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.qGG != null) {
        paramVarArgs.e(2, this.qGG);
      }
      paramVarArgs.e(3, 1, this.LSA);
      if (this.LSB != null) {
        paramVarArgs.e(4, this.LSB);
      }
      if (this.title != null) {
        paramVarArgs.e(5, this.title);
      }
      AppMethodBeat.o(181503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.qGG != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.qGG);
      }
      i += g.a.a.a.c(3, 1, this.LSA);
      paramInt = i;
      if (this.LSB != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LSB);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.title);
      }
      AppMethodBeat.o(181503);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LSA.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(181503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bik localbik = (bik)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(181503);
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
            localbik.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(181503);
          return 0;
        case 2: 
          localbik.qGG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(181503);
          return 0;
        case 3: 
          localbik.LSA.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(181503);
          return 0;
        case 4: 
          localbik.LSB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(181503);
          return 0;
        }
        localbik.title = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(181503);
        return 0;
      }
      AppMethodBeat.o(181503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bik
 * JD-Core Version:    0.7.0.1
 */