package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqq
  extends dyy
{
  public String SCJ;
  public long SCK;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231264);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SCJ != null) {
        paramVarArgs.f(2, this.SCJ);
      }
      paramVarArgs.bm(3, this.SCK);
      if (this.session_id != null) {
        paramVarArgs.f(4, this.session_id);
      }
      AppMethodBeat.o(231264);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SCJ != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SCJ);
      }
      i += g.a.a.b.b.a.p(3, this.SCK);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.session_id);
      }
      AppMethodBeat.o(231264);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231264);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        aqq localaqq = (aqq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231264);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localaqq.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(231264);
          return 0;
        case 2: 
          localaqq.SCJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231264);
          return 0;
        case 3: 
          localaqq.SCK = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(231264);
          return 0;
        }
        localaqq.session_id = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(231264);
        return 0;
      }
      AppMethodBeat.o(231264);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqq
 * JD-Core Version:    0.7.0.1
 */