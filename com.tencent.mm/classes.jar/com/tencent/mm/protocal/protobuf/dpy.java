package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dpy
  extends dyy
{
  public int SXb;
  public int Thh;
  public eae Thi;
  public String Thj;
  public eae Thk;
  public String UUID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(279263);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(279263);
        throw paramVarArgs;
      }
      if (this.Thi == null)
      {
        paramVarArgs = new b("Not all required fields were included: NotifyKey");
        AppMethodBeat.o(279263);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.UUID != null) {
        paramVarArgs.f(2, this.UUID);
      }
      if (this.Thi != null)
      {
        paramVarArgs.oE(3, this.Thi.computeSize());
        this.Thi.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.Thh);
      paramVarArgs.aY(5, this.SXb);
      if (this.Thj != null) {
        paramVarArgs.f(6, this.Thj);
      }
      if (this.Thk != null)
      {
        paramVarArgs.oE(7, this.Thk.computeSize());
        this.Thk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(279263);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label860;
      }
    }
    label860:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UUID != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UUID);
      }
      i = paramInt;
      if (this.Thi != null) {
        i = paramInt + g.a.a.a.oD(3, this.Thi.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(4, this.Thh) + g.a.a.b.b.a.bM(5, this.SXb);
      paramInt = i;
      if (this.Thj != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Thj);
      }
      i = paramInt;
      if (this.Thk != null) {
        i = paramInt + g.a.a.a.oD(7, this.Thk.computeSize());
      }
      AppMethodBeat.o(279263);
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
          AppMethodBeat.o(279263);
          throw paramVarArgs;
        }
        if (this.Thi == null)
        {
          paramVarArgs = new b("Not all required fields were included: NotifyKey");
          AppMethodBeat.o(279263);
          throw paramVarArgs;
        }
        AppMethodBeat.o(279263);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dpy localdpy = (dpy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(279263);
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
            localdpy.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(279263);
          return 0;
        case 2: 
          localdpy.UUID = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(279263);
          return 0;
        case 3: 
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
            localdpy.Thi = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(279263);
          return 0;
        case 4: 
          localdpy.Thh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(279263);
          return 0;
        case 5: 
          localdpy.SXb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(279263);
          return 0;
        case 6: 
          localdpy.Thj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(279263);
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
          localdpy.Thk = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(279263);
        return 0;
      }
      AppMethodBeat.o(279263);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpy
 * JD-Core Version:    0.7.0.1
 */