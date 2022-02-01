package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class did
  extends esc
{
  public String Njp;
  public int aaMY;
  public int aaNa;
  public LinkedList<dib> aaNc;
  public LinkedList<dib> aaNd;
  
  public did()
  {
    AppMethodBeat.i(155436);
    this.aaNc = new LinkedList();
    this.aaNd = new LinkedList();
    AppMethodBeat.o(155436);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155437);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155437);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Njp != null) {
        paramVarArgs.g(2, this.Njp);
      }
      paramVarArgs.bS(3, this.aaMY);
      paramVarArgs.e(4, 8, this.aaNc);
      paramVarArgs.bS(5, this.aaNa);
      paramVarArgs.e(6, 8, this.aaNd);
      AppMethodBeat.o(155437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label724;
      }
    }
    label724:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Njp != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Njp);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.aaMY);
      int j = i.a.a.a.c(4, 8, this.aaNc);
      int k = i.a.a.b.b.a.cJ(5, this.aaNa);
      int m = i.a.a.a.c(6, 8, this.aaNd);
      AppMethodBeat.o(155437);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaNc.clear();
        this.aaNd.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(155437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        did localdid = (did)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155437);
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
            localdid.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155437);
          return 0;
        case 2: 
          localdid.Njp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155437);
          return 0;
        case 3: 
          localdid.aaMY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155437);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dib();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dib)localObject2).parseFrom((byte[])localObject1);
            }
            localdid.aaNc.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155437);
          return 0;
        case 5: 
          localdid.aaNa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155437);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dib();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dib)localObject2).parseFrom((byte[])localObject1);
          }
          localdid.aaNd.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155437);
        return 0;
      }
      AppMethodBeat.o(155437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.did
 * JD-Core Version:    0.7.0.1
 */