package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byd
  extends dyl
{
  public int SfD;
  public int SfE;
  public double latitude;
  public double longitude;
  public int offset;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(244635);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.offset);
      paramVarArgs.aY(3, this.SfE);
      paramVarArgs.e(4, this.latitude);
      paramVarArgs.e(5, this.longitude);
      paramVarArgs.aY(6, this.SfD);
      AppMethodBeat.o(244635);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.offset);
      int j = g.a.a.b.b.a.bM(3, this.SfE);
      int k = g.a.a.b.b.a.gL(4);
      int m = g.a.a.b.b.a.gL(5);
      int n = g.a.a.b.b.a.bM(6, this.SfD);
      AppMethodBeat.o(244635);
      return paramInt + i + j + (k + 8) + (m + 8) + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(244635);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        byd localbyd = (byd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(244635);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localbyd.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(244635);
          return 0;
        case 2: 
          localbyd.offset = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(244635);
          return 0;
        case 3: 
          localbyd.SfE = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(244635);
          return 0;
        case 4: 
          localbyd.latitude = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(244635);
          return 0;
        case 5: 
          localbyd.longitude = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(244635);
          return 0;
        }
        localbyd.SfD = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(244635);
        return 0;
      }
      AppMethodBeat.o(244635);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byd
 * JD-Core Version:    0.7.0.1
 */