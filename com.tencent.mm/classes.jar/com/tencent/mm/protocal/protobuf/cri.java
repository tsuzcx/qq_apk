package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cri
  extends dyy
{
  public String HlB;
  public int Tyq;
  public int Tys;
  public LinkedList<crg> Tyu;
  public LinkedList<crg> Tyv;
  
  public cri()
  {
    AppMethodBeat.i(155436);
    this.Tyu = new LinkedList();
    this.Tyv = new LinkedList();
    AppMethodBeat.o(155436);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155437);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155437);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HlB != null) {
        paramVarArgs.f(2, this.HlB);
      }
      paramVarArgs.aY(3, this.Tyq);
      paramVarArgs.e(4, 8, this.Tyu);
      paramVarArgs.aY(5, this.Tys);
      paramVarArgs.e(6, 8, this.Tyv);
      AppMethodBeat.o(155437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label728;
      }
    }
    label728:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HlB != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.HlB);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.Tyq);
      int j = g.a.a.a.c(4, 8, this.Tyu);
      int k = g.a.a.b.b.a.bM(5, this.Tys);
      int m = g.a.a.a.c(6, 8, this.Tyv);
      AppMethodBeat.o(155437);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tyu.clear();
        this.Tyv.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(155437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cri localcri = (cri)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155437);
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
            localcri.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155437);
          return 0;
        case 2: 
          localcri.HlB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155437);
          return 0;
        case 3: 
          localcri.Tyq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155437);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new crg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((crg)localObject2).parseFrom((byte[])localObject1);
            }
            localcri.Tyu.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155437);
          return 0;
        case 5: 
          localcri.Tys = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155437);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new crg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((crg)localObject2).parseFrom((byte[])localObject1);
          }
          localcri.Tyv.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155437);
        return 0;
      }
      AppMethodBeat.o(155437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cri
 * JD-Core Version:    0.7.0.1
 */