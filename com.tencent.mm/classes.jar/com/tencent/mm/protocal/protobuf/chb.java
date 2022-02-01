package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class chb
  extends esc
{
  public String aapN;
  public int aapO;
  public esw aapP;
  public String aapQ;
  public esu aapR;
  public long kax;
  public int lyq;
  public String lyr;
  public int lys;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101808);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101808);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aapN != null) {
        paramVarArgs.g(2, this.aapN);
      }
      paramVarArgs.bS(3, this.lyq);
      if (this.lyr != null) {
        paramVarArgs.g(4, this.lyr);
      }
      paramVarArgs.bS(5, this.lys);
      paramVarArgs.bS(6, this.aapO);
      paramVarArgs.bv(7, this.kax);
      if (this.aapP != null)
      {
        paramVarArgs.qD(8, this.aapP.computeSize());
        this.aapP.writeFields(paramVarArgs);
      }
      if (this.aapQ != null) {
        paramVarArgs.g(9, this.aapQ);
      }
      if (this.aapR != null)
      {
        paramVarArgs.qD(10, this.aapR.computeSize());
        this.aapR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label960;
      }
    }
    label960:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aapN != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aapN);
      }
      i += i.a.a.b.b.a.cJ(3, this.lyq);
      paramInt = i;
      if (this.lyr != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.lyr);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.lys) + i.a.a.b.b.a.cJ(6, this.aapO) + i.a.a.b.b.a.q(7, this.kax);
      paramInt = i;
      if (this.aapP != null) {
        paramInt = i + i.a.a.a.qC(8, this.aapP.computeSize());
      }
      i = paramInt;
      if (this.aapQ != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.aapQ);
      }
      paramInt = i;
      if (this.aapR != null) {
        paramInt = i + i.a.a.a.qC(10, this.aapR.computeSize());
      }
      AppMethodBeat.o(101808);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(101808);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101808);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        chb localchb = (chb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101808);
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
            localchb.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101808);
          return 0;
        case 2: 
          localchb.aapN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101808);
          return 0;
        case 3: 
          localchb.lyq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101808);
          return 0;
        case 4: 
          localchb.lyr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101808);
          return 0;
        case 5: 
          localchb.lys = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101808);
          return 0;
        case 6: 
          localchb.aapO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101808);
          return 0;
        case 7: 
          localchb.kax = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(101808);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esw)localObject2).parseFrom((byte[])localObject1);
            }
            localchb.aapP = ((esw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101808);
          return 0;
        case 9: 
          localchb.aapQ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101808);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new esu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((esu)localObject2).parseFrom((byte[])localObject1);
          }
          localchb.aapR = ((esu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(101808);
        return 0;
      }
      AppMethodBeat.o(101808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chb
 * JD-Core Version:    0.7.0.1
 */