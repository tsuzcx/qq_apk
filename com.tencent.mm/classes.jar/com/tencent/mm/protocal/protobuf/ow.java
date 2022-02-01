package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ow
  extends dyy
{
  public int ROx;
  public String RSB;
  public long RSk;
  public boolean RXi;
  public String fHb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205716);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(205716);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.RSB != null) {
        paramVarArgs.f(2, this.RSB);
      }
      if (this.fHb != null) {
        paramVarArgs.f(3, this.fHb);
      }
      paramVarArgs.co(4, this.RXi);
      paramVarArgs.bm(11, this.RSk);
      paramVarArgs.aY(15, this.ROx);
      AppMethodBeat.o(205716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label616;
      }
    }
    label616:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RSB != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RSB);
      }
      i = paramInt;
      if (this.fHb != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fHb);
      }
      paramInt = g.a.a.b.b.a.gL(4);
      int j = g.a.a.b.b.a.p(11, this.RSk);
      int k = g.a.a.b.b.a.bM(15, this.ROx);
      AppMethodBeat.o(205716);
      return i + (paramInt + 1) + j + k;
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
          AppMethodBeat.o(205716);
          throw paramVarArgs;
        }
        AppMethodBeat.o(205716);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ow localow = (ow)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(205716);
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
            localow.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(205716);
          return 0;
        case 2: 
          localow.RSB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205716);
          return 0;
        case 3: 
          localow.fHb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205716);
          return 0;
        case 4: 
          localow.RXi = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(205716);
          return 0;
        case 11: 
          localow.RSk = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(205716);
          return 0;
        }
        localow.ROx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(205716);
        return 0;
      }
      AppMethodBeat.o(205716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ow
 * JD-Core Version:    0.7.0.1
 */