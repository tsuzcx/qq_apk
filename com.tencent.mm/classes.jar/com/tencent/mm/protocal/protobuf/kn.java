package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class kn
  extends esc
{
  public LinkedList<String> YKG;
  public LinkedList<Boolean> YMA;
  public com.tencent.mm.bx.b YMy;
  public LinkedList<amn> YMz;
  public int crs;
  public int oOu;
  
  public kn()
  {
    AppMethodBeat.i(104757);
    this.YKG = new LinkedList();
    this.YMz = new LinkedList();
    this.YMA = new LinkedList();
    AppMethodBeat.o(104757);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104758);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104758);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.crs);
      paramVarArgs.e(3, 1, this.YKG);
      paramVarArgs.bS(4, this.oOu);
      paramVarArgs.e(5, 8, this.YMz);
      if (this.YMy != null) {
        paramVarArgs.d(6, this.YMy);
      }
      paramVarArgs.e(7, 7, this.YMA);
      AppMethodBeat.o(104758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label717;
      }
    }
    label717:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.crs) + i.a.a.a.c(3, 1, this.YKG) + i.a.a.b.b.a.cJ(4, this.oOu) + i.a.a.a.c(5, 8, this.YMz);
      paramInt = i;
      if (this.YMy != null) {
        paramInt = i + i.a.a.b.b.a.c(6, this.YMy);
      }
      i = i.a.a.a.c(7, 7, this.YMA);
      AppMethodBeat.o(104758);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YKG.clear();
        this.YMz.clear();
        this.YMA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104758);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        kn localkn = (kn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104758);
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
            localkn.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104758);
          return 0;
        case 2: 
          localkn.crs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104758);
          return 0;
        case 3: 
          localkn.YKG.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(104758);
          return 0;
        case 4: 
          localkn.oOu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104758);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new amn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((amn)localObject2).parseFrom((byte[])localObject1);
            }
            localkn.YMz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104758);
          return 0;
        case 6: 
          localkn.YMy = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(104758);
          return 0;
        }
        localkn.YMA.add(Boolean.valueOf(((i.a.a.a.a)localObject1).ajGk.aai()));
        AppMethodBeat.o(104758);
        return 0;
      }
      AppMethodBeat.o(104758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kn
 * JD-Core Version:    0.7.0.1
 */