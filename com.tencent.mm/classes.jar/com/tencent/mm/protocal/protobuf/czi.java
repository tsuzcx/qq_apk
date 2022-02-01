package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czi
  extends dyl
{
  public String SqY;
  public long SqZ;
  public String TfK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72517);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.SqZ);
      if (this.SqY != null) {
        paramVarArgs.f(3, this.SqY);
      }
      if (this.TfK != null) {
        paramVarArgs.f(4, this.TfK);
      }
      AppMethodBeat.o(72517);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.SqZ);
      paramInt = i;
      if (this.SqY != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SqY);
      }
      i = paramInt;
      if (this.TfK != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TfK);
      }
      AppMethodBeat.o(72517);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72517);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        czi localczi = (czi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72517);
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
            localczi.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72517);
          return 0;
        case 2: 
          localczi.SqZ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(72517);
          return 0;
        case 3: 
          localczi.SqY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72517);
          return 0;
        }
        localczi.TfK = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72517);
        return 0;
      }
      AppMethodBeat.o(72517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czi
 * JD-Core Version:    0.7.0.1
 */