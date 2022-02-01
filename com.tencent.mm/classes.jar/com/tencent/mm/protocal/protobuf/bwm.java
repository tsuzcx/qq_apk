package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bwm
  extends dyy
{
  public long Tgi;
  public String Tgj;
  public String Tgk;
  public abx Tgl;
  public dti Tgm;
  public String Tgn;
  public boolean Tgo = true;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(274451);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(274451);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.Tgi);
      if (this.Tgj != null) {
        paramVarArgs.f(3, this.Tgj);
      }
      if (this.Tgk != null) {
        paramVarArgs.f(4, this.Tgk);
      }
      if (this.Tgl != null)
      {
        paramVarArgs.oE(5, this.Tgl.computeSize());
        this.Tgl.writeFields(paramVarArgs);
      }
      if (this.Tgm != null)
      {
        paramVarArgs.oE(6, this.Tgm.computeSize());
        this.Tgm.writeFields(paramVarArgs);
      }
      if (this.Tgn != null) {
        paramVarArgs.f(7, this.Tgn);
      }
      paramVarArgs.co(8, this.Tgo);
      AppMethodBeat.o(274451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label872;
      }
    }
    label872:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.Tgi);
      paramInt = i;
      if (this.Tgj != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Tgj);
      }
      i = paramInt;
      if (this.Tgk != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Tgk);
      }
      paramInt = i;
      if (this.Tgl != null) {
        paramInt = i + g.a.a.a.oD(5, this.Tgl.computeSize());
      }
      i = paramInt;
      if (this.Tgm != null) {
        i = paramInt + g.a.a.a.oD(6, this.Tgm.computeSize());
      }
      paramInt = i;
      if (this.Tgn != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Tgn);
      }
      i = g.a.a.b.b.a.gL(8);
      AppMethodBeat.o(274451);
      return paramInt + (i + 1);
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
          AppMethodBeat.o(274451);
          throw paramVarArgs;
        }
        AppMethodBeat.o(274451);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwm localbwm = (bwm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(274451);
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
            localbwm.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(274451);
          return 0;
        case 2: 
          localbwm.Tgi = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(274451);
          return 0;
        case 3: 
          localbwm.Tgj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(274451);
          return 0;
        case 4: 
          localbwm.Tgk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(274451);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new abx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((abx)localObject2).parseFrom((byte[])localObject1);
            }
            localbwm.Tgl = ((abx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(274451);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dti();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dti)localObject2).parseFrom((byte[])localObject1);
            }
            localbwm.Tgm = ((dti)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(274451);
          return 0;
        case 7: 
          localbwm.Tgn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(274451);
          return 0;
        }
        localbwm.Tgo = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(274451);
        return 0;
      }
      AppMethodBeat.o(274451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwm
 * JD-Core Version:    0.7.0.1
 */