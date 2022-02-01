package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsa
  extends dyl
{
  public String Tcm;
  public String Tcn;
  public double latitude;
  public double longitude;
  public String trU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114020);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.latitude);
      paramVarArgs.e(3, this.longitude);
      if (this.trU != null) {
        paramVarArgs.f(4, this.trU);
      }
      if (this.Tcm != null) {
        paramVarArgs.f(5, this.Tcm);
      }
      if (this.Tcn != null) {
        paramVarArgs.f(6, this.Tcn);
      }
      AppMethodBeat.o(114020);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 8) + (g.a.a.b.b.a.gL(3) + 8);
      paramInt = i;
      if (this.trU != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.trU);
      }
      i = paramInt;
      if (this.Tcm != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Tcm);
      }
      paramInt = i;
      if (this.Tcn != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Tcn);
      }
      AppMethodBeat.o(114020);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(114020);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bsa localbsa = (bsa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114020);
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
            localbsa.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(114020);
          return 0;
        case 2: 
          localbsa.latitude = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(114020);
          return 0;
        case 3: 
          localbsa.longitude = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(114020);
          return 0;
        case 4: 
          localbsa.trU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114020);
          return 0;
        case 5: 
          localbsa.Tcm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114020);
          return 0;
        }
        localbsa.Tcn = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(114020);
        return 0;
      }
      AppMethodBeat.o(114020);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsa
 * JD-Core Version:    0.7.0.1
 */