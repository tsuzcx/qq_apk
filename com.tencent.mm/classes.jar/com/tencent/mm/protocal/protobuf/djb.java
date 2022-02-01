package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class djb
  extends dyy
{
  public String SYW;
  public String SYX;
  public fhv SZc;
  public String TQD;
  public int vht;
  public String vhu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91572);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91572);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SYX != null) {
        paramVarArgs.f(2, this.SYX);
      }
      paramVarArgs.aY(3, this.vht);
      if (this.vhu != null) {
        paramVarArgs.f(4, this.vhu);
      }
      if (this.SYW != null) {
        paramVarArgs.f(5, this.SYW);
      }
      if (this.TQD != null) {
        paramVarArgs.f(6, this.TQD);
      }
      if (this.SZc != null)
      {
        paramVarArgs.oE(7, this.SZc.computeSize());
        this.SZc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SYX != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SYX);
      }
      i += g.a.a.b.b.a.bM(3, this.vht);
      paramInt = i;
      if (this.vhu != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.vhu);
      }
      i = paramInt;
      if (this.SYW != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SYW);
      }
      paramInt = i;
      if (this.TQD != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TQD);
      }
      i = paramInt;
      if (this.SZc != null) {
        i = paramInt + g.a.a.a.oD(7, this.SZc.computeSize());
      }
      AppMethodBeat.o(91572);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91572);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91572);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        djb localdjb = (djb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91572);
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
            localdjb.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91572);
          return 0;
        case 2: 
          localdjb.SYX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91572);
          return 0;
        case 3: 
          localdjb.vht = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91572);
          return 0;
        case 4: 
          localdjb.vhu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91572);
          return 0;
        case 5: 
          localdjb.SYW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91572);
          return 0;
        case 6: 
          localdjb.TQD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91572);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fhv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fhv)localObject2).parseFrom((byte[])localObject1);
          }
          localdjb.SZc = ((fhv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91572);
        return 0;
      }
      AppMethodBeat.o(91572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djb
 * JD-Core Version:    0.7.0.1
 */