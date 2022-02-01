package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cvw
  extends esc
{
  public String aaBb;
  public String aaBd;
  public int aaBe;
  public String aaBf;
  public String aaBg;
  public String aaBh;
  public int aarD;
  public LinkedList<gde> aarE;
  
  public cvw()
  {
    AppMethodBeat.i(32305);
    this.aarE = new LinkedList();
    AppMethodBeat.o(32305);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32306);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32306);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aarD);
      paramVarArgs.e(3, 8, this.aarE);
      if (this.aaBd != null) {
        paramVarArgs.g(4, this.aaBd);
      }
      if (this.aaBb != null) {
        paramVarArgs.g(5, this.aaBb);
      }
      paramVarArgs.bS(6, this.aaBe);
      if (this.aaBf != null) {
        paramVarArgs.g(7, this.aaBf);
      }
      if (this.aaBg != null) {
        paramVarArgs.g(8, this.aaBg);
      }
      if (this.aaBh != null) {
        paramVarArgs.g(9, this.aaBh);
      }
      AppMethodBeat.o(32306);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label865;
      }
    }
    label865:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aarD) + i.a.a.a.c(3, 8, this.aarE);
      paramInt = i;
      if (this.aaBd != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaBd);
      }
      i = paramInt;
      if (this.aaBb != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaBb);
      }
      i += i.a.a.b.b.a.cJ(6, this.aaBe);
      paramInt = i;
      if (this.aaBf != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aaBf);
      }
      i = paramInt;
      if (this.aaBg != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aaBg);
      }
      paramInt = i;
      if (this.aaBh != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aaBh);
      }
      AppMethodBeat.o(32306);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aarE.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32306);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32306);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cvw localcvw = (cvw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32306);
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
            localcvw.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32306);
          return 0;
        case 2: 
          localcvw.aarD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32306);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gde();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gde)localObject2).parseFrom((byte[])localObject1);
            }
            localcvw.aarE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32306);
          return 0;
        case 4: 
          localcvw.aaBd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 5: 
          localcvw.aaBb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 6: 
          localcvw.aaBe = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32306);
          return 0;
        case 7: 
          localcvw.aaBf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32306);
          return 0;
        case 8: 
          localcvw.aaBg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32306);
          return 0;
        }
        localcvw.aaBh = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32306);
        return 0;
      }
      AppMethodBeat.o(32306);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvw
 * JD-Core Version:    0.7.0.1
 */