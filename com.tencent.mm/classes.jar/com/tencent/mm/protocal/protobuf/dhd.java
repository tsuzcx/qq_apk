package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dhd
  extends esc
{
  public int Qtb;
  public int aaMA;
  public int aaMB;
  public int aaMC;
  public int aaqy;
  public LinkedList<dgy> aaqz;
  
  public dhd()
  {
    AppMethodBeat.i(89927);
    this.aaqz = new LinkedList();
    AppMethodBeat.o(89927);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89928);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(89928);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aaqy);
      paramVarArgs.e(3, 8, this.aaqz);
      paramVarArgs.bS(4, this.Qtb);
      paramVarArgs.bS(5, this.aaMA);
      paramVarArgs.bS(6, this.aaMB);
      paramVarArgs.bS(7, this.aaMC);
      AppMethodBeat.o(89928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aaqy);
      int j = i.a.a.a.c(3, 8, this.aaqz);
      int k = i.a.a.b.b.a.cJ(4, this.Qtb);
      int m = i.a.a.b.b.a.cJ(5, this.aaMA);
      int n = i.a.a.b.b.a.cJ(6, this.aaMB);
      int i1 = i.a.a.b.b.a.cJ(7, this.aaMC);
      AppMethodBeat.o(89928);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaqz.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(89928);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89928);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dhd localdhd = (dhd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89928);
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
            localdhd.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(89928);
          return 0;
        case 2: 
          localdhd.aaqy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(89928);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dgy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dgy)localObject2).parseFrom((byte[])localObject1);
            }
            localdhd.aaqz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(89928);
          return 0;
        case 4: 
          localdhd.Qtb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(89928);
          return 0;
        case 5: 
          localdhd.aaMA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(89928);
          return 0;
        case 6: 
          localdhd.aaMB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(89928);
          return 0;
        }
        localdhd.aaMC = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(89928);
        return 0;
      }
      AppMethodBeat.o(89928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhd
 * JD-Core Version:    0.7.0.1
 */