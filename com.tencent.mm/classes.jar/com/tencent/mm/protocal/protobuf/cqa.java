package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class cqa
  extends dyy
{
  public cpv Txu;
  public yw Txv;
  public fnl Txw;
  public dps Txx;
  public bf Txy;
  public dgs Txz;
  public String appid;
  public String cxQ;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123625);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123625);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Txu != null)
      {
        paramVarArgs.oE(2, this.Txu.computeSize());
        this.Txu.writeFields(paramVarArgs);
      }
      if (this.Txv != null)
      {
        paramVarArgs.oE(3, this.Txv.computeSize());
        this.Txv.writeFields(paramVarArgs);
      }
      if (this.Txw != null)
      {
        paramVarArgs.oE(4, this.Txw.computeSize());
        this.Txw.writeFields(paramVarArgs);
      }
      if (this.Txx != null)
      {
        paramVarArgs.oE(5, this.Txx.computeSize());
        this.Txx.writeFields(paramVarArgs);
      }
      if (this.Txy != null)
      {
        paramVarArgs.oE(6, this.Txy.computeSize());
        this.Txy.writeFields(paramVarArgs);
      }
      if (this.Txz != null)
      {
        paramVarArgs.oE(7, this.Txz.computeSize());
        this.Txz.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.f(8, this.appid);
      }
      if (this.username != null) {
        paramVarArgs.f(9, this.username);
      }
      if (this.cxQ != null) {
        paramVarArgs.f(10, this.cxQ);
      }
      AppMethodBeat.o(123625);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1320;
      }
    }
    label1320:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Txu != null) {
        paramInt = i + g.a.a.a.oD(2, this.Txu.computeSize());
      }
      i = paramInt;
      if (this.Txv != null) {
        i = paramInt + g.a.a.a.oD(3, this.Txv.computeSize());
      }
      paramInt = i;
      if (this.Txw != null) {
        paramInt = i + g.a.a.a.oD(4, this.Txw.computeSize());
      }
      i = paramInt;
      if (this.Txx != null) {
        i = paramInt + g.a.a.a.oD(5, this.Txx.computeSize());
      }
      paramInt = i;
      if (this.Txy != null) {
        paramInt = i + g.a.a.a.oD(6, this.Txy.computeSize());
      }
      i = paramInt;
      if (this.Txz != null) {
        i = paramInt + g.a.a.a.oD(7, this.Txz.computeSize());
      }
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.appid);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.username);
      }
      paramInt = i;
      if (this.cxQ != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.cxQ);
      }
      AppMethodBeat.o(123625);
      return paramInt;
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
          AppMethodBeat.o(123625);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123625);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cqa localcqa = (cqa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123625);
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
            localcqa.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cpv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cpv)localObject2).parseFrom((byte[])localObject1);
            }
            localcqa.Txu = ((cpv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new yw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((yw)localObject2).parseFrom((byte[])localObject1);
            }
            localcqa.Txv = ((yw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fnl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fnl)localObject2).parseFrom((byte[])localObject1);
            }
            localcqa.Txw = ((fnl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dps();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dps)localObject2).parseFrom((byte[])localObject1);
            }
            localcqa.Txx = ((dps)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bf)localObject2).parseFrom((byte[])localObject1);
            }
            localcqa.Txy = ((bf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dgs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dgs)localObject2).parseFrom((byte[])localObject1);
            }
            localcqa.Txz = ((dgs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 8: 
          localcqa.appid = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123625);
          return 0;
        case 9: 
          localcqa.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123625);
          return 0;
        }
        localcqa.cxQ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(123625);
        return 0;
      }
      AppMethodBeat.o(123625);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqa
 * JD-Core Version:    0.7.0.1
 */