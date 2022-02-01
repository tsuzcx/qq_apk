package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bti
  extends dyl
{
  public int SfD;
  public int SfE;
  public double latitude;
  public double longitude;
  public int offset;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(248560);
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
      paramVarArgs.aY(6, this.scene);
      paramVarArgs.aY(7, this.SfD);
      AppMethodBeat.o(248560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.offset);
      int j = g.a.a.b.b.a.bM(3, this.SfE);
      int k = g.a.a.b.b.a.gL(4);
      int m = g.a.a.b.b.a.gL(5);
      int n = g.a.a.b.b.a.bM(6, this.scene);
      int i1 = g.a.a.b.b.a.bM(7, this.SfD);
      AppMethodBeat.o(248560);
      return paramInt + i + j + (k + 8) + (m + 8) + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(248560);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bti localbti = (bti)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(248560);
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
            localbti.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(248560);
          return 0;
        case 2: 
          localbti.offset = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(248560);
          return 0;
        case 3: 
          localbti.SfE = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(248560);
          return 0;
        case 4: 
          localbti.latitude = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(248560);
          return 0;
        case 5: 
          localbti.longitude = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(248560);
          return 0;
        case 6: 
          localbti.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(248560);
          return 0;
        }
        localbti.SfD = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(248560);
        return 0;
      }
      AppMethodBeat.o(248560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bti
 * JD-Core Version:    0.7.0.1
 */