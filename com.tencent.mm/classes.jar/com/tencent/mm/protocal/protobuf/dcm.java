package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcm
  extends dyy
{
  public float TJW;
  public String TJX;
  public String TJY;
  public String TJZ;
  public LinkedList<euy> TfA;
  public com.tencent.mm.cd.b TgT;
  public int lVs;
  
  public dcm()
  {
    AppMethodBeat.i(120958);
    this.TfA = new LinkedList();
    AppMethodBeat.o(120958);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120959);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(120959);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.lVs);
      paramVarArgs.e(3, 8, this.TfA);
      if (this.TgT != null) {
        paramVarArgs.c(4, this.TgT);
      }
      paramVarArgs.i(5, this.TJW);
      if (this.TJX != null) {
        paramVarArgs.f(6, this.TJX);
      }
      if (this.TJY != null) {
        paramVarArgs.f(7, this.TJY);
      }
      if (this.TJZ != null) {
        paramVarArgs.f(8, this.TJZ);
      }
      AppMethodBeat.o(120959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label789;
      }
    }
    label789:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.lVs) + g.a.a.a.c(3, 8, this.TfA);
      paramInt = i;
      if (this.TgT != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.TgT);
      }
      i = paramInt + (g.a.a.b.b.a.gL(5) + 4);
      paramInt = i;
      if (this.TJX != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TJX);
      }
      i = paramInt;
      if (this.TJY != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TJY);
      }
      paramInt = i;
      if (this.TJZ != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TJZ);
      }
      AppMethodBeat.o(120959);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TfA.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(120959);
          throw paramVarArgs;
        }
        AppMethodBeat.o(120959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dcm localdcm = (dcm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(120959);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localdcm.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(120959);
          return 0;
        case 2: 
          localdcm.lVs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(120959);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new euy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((euy)localObject2).parseFrom((byte[])localObject1);
            }
            localdcm.TfA.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(120959);
          return 0;
        case 4: 
          localdcm.TgT = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(120959);
          return 0;
        case 5: 
          localdcm.TJW = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(120959);
          return 0;
        case 6: 
          localdcm.TJX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(120959);
          return 0;
        case 7: 
          localdcm.TJY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(120959);
          return 0;
        }
        localdcm.TJZ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(120959);
        return 0;
      }
      AppMethodBeat.o(120959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcm
 * JD-Core Version:    0.7.0.1
 */