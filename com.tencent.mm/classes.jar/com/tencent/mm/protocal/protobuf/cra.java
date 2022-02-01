package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class cra
  extends esc
{
  public com.tencent.mm.bx.b aaxD;
  public LinkedList<ene> aaxG;
  public enh aaxH;
  public String aaxI;
  
  public cra()
  {
    AppMethodBeat.i(258891);
    this.aaxG = new LinkedList();
    AppMethodBeat.o(258891);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258899);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258899);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aaxG);
      if (this.aaxH != null)
      {
        paramVarArgs.qD(3, this.aaxH.computeSize());
        this.aaxH.writeFields(paramVarArgs);
      }
      if (this.aaxI != null) {
        paramVarArgs.g(4, this.aaxI);
      }
      if (this.aaxD != null) {
        paramVarArgs.d(5, this.aaxD);
      }
      AppMethodBeat.o(258899);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label704;
      }
    }
    label704:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aaxG);
      paramInt = i;
      if (this.aaxH != null) {
        paramInt = i + i.a.a.a.qC(3, this.aaxH.computeSize());
      }
      i = paramInt;
      if (this.aaxI != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aaxI);
      }
      paramInt = i;
      if (this.aaxD != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.aaxD);
      }
      AppMethodBeat.o(258899);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaxG.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(258899);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258899);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cra localcra = (cra)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258899);
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
            localcra.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258899);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ene();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ene)localObject2).parseFrom((byte[])localObject1);
            }
            localcra.aaxG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258899);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enh)localObject2).parseFrom((byte[])localObject1);
            }
            localcra.aaxH = ((enh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258899);
          return 0;
        case 4: 
          localcra.aaxI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258899);
          return 0;
        }
        localcra.aaxD = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(258899);
        return 0;
      }
      AppMethodBeat.o(258899);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cra
 * JD-Core Version:    0.7.0.1
 */