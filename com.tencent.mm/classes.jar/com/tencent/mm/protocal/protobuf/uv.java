package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uv
  extends dyl
{
  public String fUL;
  public float latitude;
  public float longitude;
  public String tnX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113970);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.tnX != null) {
        paramVarArgs.f(2, this.tnX);
      }
      paramVarArgs.i(3, this.longitude);
      paramVarArgs.i(4, this.latitude);
      if (this.fUL != null) {
        paramVarArgs.f(5, this.fUL);
      }
      AppMethodBeat.o(113970);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tnX != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.tnX);
      }
      i = i + (g.a.a.b.b.a.gL(3) + 4) + (g.a.a.b.b.a.gL(4) + 4);
      paramInt = i;
      if (this.fUL != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.fUL);
      }
      AppMethodBeat.o(113970);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113970);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        uv localuv = (uv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113970);
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
            localuv.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(113970);
          return 0;
        case 2: 
          localuv.tnX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113970);
          return 0;
        case 3: 
          localuv.longitude = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(113970);
          return 0;
        case 4: 
          localuv.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(113970);
          return 0;
        }
        localuv.fUL = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(113970);
        return 0;
      }
      AppMethodBeat.o(113970);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uv
 * JD-Core Version:    0.7.0.1
 */