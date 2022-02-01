package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bct
  extends dyl
{
  public aqe SDi;
  public int SNY;
  public b lastBuffer;
  public float latitude;
  public float longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230943);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SDi != null)
      {
        paramVarArgs.oE(2, this.SDi.computeSize());
        this.SDi.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aY(4, this.SNY);
      paramVarArgs.i(5, this.longitude);
      paramVarArgs.i(6, this.latitude);
      AppMethodBeat.o(230943);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label620;
      }
    }
    label620:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SDi != null) {
        paramInt = i + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.SNY);
      int j = g.a.a.b.b.a.gL(5);
      int k = g.a.a.b.b.a.gL(6);
      AppMethodBeat.o(230943);
      return i + paramInt + (j + 4) + (k + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230943);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bct localbct = (bct)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230943);
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
            localbct.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230943);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localbct.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230943);
          return 0;
        case 3: 
          localbct.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(230943);
          return 0;
        case 4: 
          localbct.SNY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230943);
          return 0;
        case 5: 
          localbct.longitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(230943);
          return 0;
        }
        localbct.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
        AppMethodBeat.o(230943);
        return 0;
      }
      AppMethodBeat.o(230943);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bct
 * JD-Core Version:    0.7.0.1
 */