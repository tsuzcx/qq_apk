package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aag
  extends esc
{
  public LinkedList<aah> ZiE;
  public String hFb;
  public String nag;
  public int qfX;
  
  public aag()
  {
    AppMethodBeat.i(258707);
    this.ZiE = new LinkedList();
    AppMethodBeat.o(258707);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258711);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZiE);
      if (this.hFb != null) {
        paramVarArgs.g(3, this.hFb);
      }
      paramVarArgs.bS(4, this.qfX);
      if (this.nag != null) {
        paramVarArgs.g(5, this.nag);
      }
      AppMethodBeat.o(258711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZiE);
      paramInt = i;
      if (this.hFb != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.hFb);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.qfX);
      paramInt = i;
      if (this.nag != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.nag);
      }
      AppMethodBeat.o(258711);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZiE.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258711);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aag localaag = (aag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258711);
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
            localaag.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258711);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aah();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aah)localObject2).parseFrom((byte[])localObject1);
            }
            localaag.ZiE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258711);
          return 0;
        case 3: 
          localaag.hFb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258711);
          return 0;
        case 4: 
          localaag.qfX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258711);
          return 0;
        }
        localaag.nag = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258711);
        return 0;
      }
      AppMethodBeat.o(258711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aag
 * JD-Core Version:    0.7.0.1
 */