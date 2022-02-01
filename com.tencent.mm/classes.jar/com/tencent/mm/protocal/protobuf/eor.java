package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eor
  extends esc
{
  public String YMF;
  public int aaLi;
  public LinkedList<fvj> absS;
  public fot absT;
  public int vgN;
  
  public eor()
  {
    AppMethodBeat.i(56260);
    this.absS = new LinkedList();
    AppMethodBeat.o(56260);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56261);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56261);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vgN);
      paramVarArgs.e(3, 8, this.absS);
      if (this.YMF != null) {
        paramVarArgs.g(4, this.YMF);
      }
      paramVarArgs.bS(5, this.aaLi);
      if (this.absT != null)
      {
        paramVarArgs.qD(6, this.absT.computeSize());
        this.absT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56261);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label732;
      }
    }
    label732:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vgN) + i.a.a.a.c(3, 8, this.absS);
      paramInt = i;
      if (this.YMF != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YMF);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.aaLi);
      paramInt = i;
      if (this.absT != null) {
        paramInt = i + i.a.a.a.qC(6, this.absT.computeSize());
      }
      AppMethodBeat.o(56261);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.absS.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56261);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56261);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eor localeor = (eor)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56261);
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
            localeor.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56261);
          return 0;
        case 2: 
          localeor.vgN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(56261);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fvj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fvj)localObject2).parseFrom((byte[])localObject1);
            }
            localeor.absS.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56261);
          return 0;
        case 4: 
          localeor.YMF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(56261);
          return 0;
        case 5: 
          localeor.aaLi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(56261);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fot();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fot)localObject2).parseFrom((byte[])localObject1);
          }
          localeor.absT = ((fot)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(56261);
        return 0;
      }
      AppMethodBeat.o(56261);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eor
 * JD-Core Version:    0.7.0.1
 */