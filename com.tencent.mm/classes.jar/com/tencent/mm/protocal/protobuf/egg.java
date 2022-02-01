package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egg
  extends erp
{
  public int JaC;
  public String Vbl;
  public int ablD;
  public int ablE;
  public jl ablF;
  public int ablG;
  public String ablH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91624);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ablD);
      paramVarArgs.bS(3, this.ablE);
      if (this.ablF != null)
      {
        paramVarArgs.qD(4, this.ablF.computeSize());
        this.ablF.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.JaC);
      paramVarArgs.bS(6, this.ablG);
      if (this.ablH != null) {
        paramVarArgs.g(7, this.ablH);
      }
      if (this.Vbl != null) {
        paramVarArgs.g(100, this.Vbl);
      }
      AppMethodBeat.o(91624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label742;
      }
    }
    label742:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ablD) + i.a.a.b.b.a.cJ(3, this.ablE);
      paramInt = i;
      if (this.ablF != null) {
        paramInt = i + i.a.a.a.qC(4, this.ablF.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.JaC) + i.a.a.b.b.a.cJ(6, this.ablG);
      paramInt = i;
      if (this.ablH != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ablH);
      }
      i = paramInt;
      if (this.Vbl != null) {
        i = paramInt + i.a.a.b.b.a.h(100, this.Vbl);
      }
      AppMethodBeat.o(91624);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        egg localegg = (egg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91624);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localegg.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91624);
          return 0;
        case 2: 
          localegg.ablD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91624);
          return 0;
        case 3: 
          localegg.ablE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91624);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jl)localObject2).parseFrom((byte[])localObject1);
            }
            localegg.ablF = ((jl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91624);
          return 0;
        case 5: 
          localegg.JaC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91624);
          return 0;
        case 6: 
          localegg.ablG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91624);
          return 0;
        case 7: 
          localegg.ablH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91624);
          return 0;
        }
        localegg.Vbl = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91624);
        return 0;
      }
      AppMethodBeat.o(91624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egg
 * JD-Core Version:    0.7.0.1
 */