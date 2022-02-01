package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bxs
  extends dyy
{
  public int SXb;
  public eae Thg;
  public int Thh;
  public eae Thi;
  public String Thj;
  public eae Thk;
  public String UUID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(286430);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(286430);
        throw paramVarArgs;
      }
      if (this.Thg == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCode");
        AppMethodBeat.o(286430);
        throw paramVarArgs;
      }
      if (this.Thi == null)
      {
        paramVarArgs = new b("Not all required fields were included: NotifyKey");
        AppMethodBeat.o(286430);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Thg != null)
      {
        paramVarArgs.oE(2, this.Thg.computeSize());
        this.Thg.writeFields(paramVarArgs);
      }
      if (this.UUID != null) {
        paramVarArgs.f(3, this.UUID);
      }
      paramVarArgs.aY(4, this.Thh);
      if (this.Thi != null)
      {
        paramVarArgs.oE(5, this.Thi.computeSize());
        this.Thi.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.SXb);
      if (this.Thj != null) {
        paramVarArgs.f(7, this.Thj);
      }
      if (this.Thk != null)
      {
        paramVarArgs.oE(8, this.Thk.computeSize());
        this.Thk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(286430);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1042;
      }
    }
    label1042:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Thg != null) {
        paramInt = i + g.a.a.a.oD(2, this.Thg.computeSize());
      }
      i = paramInt;
      if (this.UUID != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UUID);
      }
      i += g.a.a.b.b.a.bM(4, this.Thh);
      paramInt = i;
      if (this.Thi != null) {
        paramInt = i + g.a.a.a.oD(5, this.Thi.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.SXb);
      paramInt = i;
      if (this.Thj != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Thj);
      }
      i = paramInt;
      if (this.Thk != null) {
        i = paramInt + g.a.a.a.oD(8, this.Thk.computeSize());
      }
      AppMethodBeat.o(286430);
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
          AppMethodBeat.o(286430);
          throw paramVarArgs;
        }
        if (this.Thg == null)
        {
          paramVarArgs = new b("Not all required fields were included: QRCode");
          AppMethodBeat.o(286430);
          throw paramVarArgs;
        }
        if (this.Thi == null)
        {
          paramVarArgs = new b("Not all required fields were included: NotifyKey");
          AppMethodBeat.o(286430);
          throw paramVarArgs;
        }
        AppMethodBeat.o(286430);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bxs localbxs = (bxs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(286430);
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
            localbxs.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(286430);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localbxs.Thg = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(286430);
          return 0;
        case 3: 
          localbxs.UUID = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(286430);
          return 0;
        case 4: 
          localbxs.Thh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(286430);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localbxs.Thi = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(286430);
          return 0;
        case 6: 
          localbxs.SXb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(286430);
          return 0;
        case 7: 
          localbxs.Thj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(286430);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localbxs.Thk = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(286430);
        return 0;
      }
      AppMethodBeat.o(286430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxs
 * JD-Core Version:    0.7.0.1
 */