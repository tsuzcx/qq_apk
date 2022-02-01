package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class evm
  extends dyl
{
  public ja Slc;
  public String Sld;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91720);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Slc != null)
      {
        paramVarArgs.oE(2, this.Slc.computeSize());
        this.Slc.writeFields(paramVarArgs);
      }
      if (this.Sld != null) {
        paramVarArgs.f(3, this.Sld);
      }
      paramVarArgs.bm(4, this.timestamp);
      AppMethodBeat.o(91720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label526;
      }
    }
    label526:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Slc != null) {
        paramInt = i + g.a.a.a.oD(2, this.Slc.computeSize());
      }
      i = paramInt;
      if (this.Sld != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sld);
      }
      paramInt = g.a.a.b.b.a.p(4, this.timestamp);
      AppMethodBeat.o(91720);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91720);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        evm localevm = (evm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91720);
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
            localevm.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91720);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ja();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ja)localObject2).parseFrom((byte[])localObject1);
            }
            localevm.Slc = ((ja)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91720);
          return 0;
        case 3: 
          localevm.Sld = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91720);
          return 0;
        }
        localevm.timestamp = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(91720);
        return 0;
      }
      AppMethodBeat.o(91720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evm
 * JD-Core Version:    0.7.0.1
 */