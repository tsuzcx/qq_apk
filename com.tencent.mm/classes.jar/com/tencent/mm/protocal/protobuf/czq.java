package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czq
  extends dyl
{
  public String OmF;
  public String SnA;
  public erp THr;
  public int time_stamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72523);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.time_stamp);
      if (this.SnA != null) {
        paramVarArgs.f(3, this.SnA);
      }
      if (this.THr != null)
      {
        paramVarArgs.oE(4, this.THr.computeSize());
        this.THr.writeFields(paramVarArgs);
      }
      if (this.OmF != null) {
        paramVarArgs.f(100, this.OmF);
      }
      AppMethodBeat.o(72523);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.time_stamp);
      paramInt = i;
      if (this.SnA != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SnA);
      }
      i = paramInt;
      if (this.THr != null) {
        i = paramInt + g.a.a.a.oD(4, this.THr.computeSize());
      }
      paramInt = i;
      if (this.OmF != null) {
        paramInt = i + g.a.a.b.b.a.g(100, this.OmF);
      }
      AppMethodBeat.o(72523);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72523);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        czq localczq = (czq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72523);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localczq.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72523);
          return 0;
        case 2: 
          localczq.time_stamp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72523);
          return 0;
        case 3: 
          localczq.SnA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72523);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new erp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((erp)localObject2).parseFrom((byte[])localObject1);
            }
            localczq.THr = ((erp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72523);
          return 0;
        }
        localczq.OmF = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(72523);
        return 0;
      }
      AppMethodBeat.o(72523);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czq
 * JD-Core Version:    0.7.0.1
 */