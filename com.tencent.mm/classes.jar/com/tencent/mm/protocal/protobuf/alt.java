package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alt
  extends esc
{
  public boolean Kmt;
  public LinkedList<alr> ZsK;
  public LinkedList<String> ZsL;
  public int offset;
  
  public alt()
  {
    AppMethodBeat.i(257926);
    this.ZsK = new LinkedList();
    this.ZsL = new LinkedList();
    AppMethodBeat.o(257926);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257941);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZsK);
      paramVarArgs.e(3, 1, this.ZsL);
      paramVarArgs.di(4, this.Kmt);
      paramVarArgs.bS(5, this.offset);
      AppMethodBeat.o(257941);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.ZsK);
      int j = i.a.a.a.c(3, 1, this.ZsL);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.cJ(5, this.offset);
      AppMethodBeat.o(257941);
      return paramInt + i + j + (k + 1) + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZsK.clear();
        this.ZsL.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257941);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        alt localalt = (alt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257941);
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
            localalt.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257941);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new alr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((alr)localObject2).parseFrom((byte[])localObject1);
            }
            localalt.ZsK.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257941);
          return 0;
        case 3: 
          localalt.ZsL.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(257941);
          return 0;
        case 4: 
          localalt.Kmt = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(257941);
          return 0;
        }
        localalt.offset = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257941);
        return 0;
      }
      AppMethodBeat.o(257941);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alt
 * JD-Core Version:    0.7.0.1
 */