package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bvh
  extends dyy
{
  public LinkedList<db> RIP;
  public int RLe;
  public long TaE;
  public String Tfm;
  public rq Tfn;
  public db Tfo;
  public int Tfp;
  
  public bvh()
  {
    AppMethodBeat.i(225679);
    this.RIP = new LinkedList();
    AppMethodBeat.o(225679);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114788);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114788);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RLe);
      paramVarArgs.bm(3, this.TaE);
      if (this.Tfo != null)
      {
        paramVarArgs.oE(4, this.Tfo.computeSize());
        this.Tfo.writeFields(paramVarArgs);
      }
      if (this.Tfm != null) {
        paramVarArgs.f(5, this.Tfm);
      }
      paramVarArgs.aY(6, this.Tfp);
      if (this.Tfn != null)
      {
        paramVarArgs.oE(7, this.Tfn.computeSize());
        this.Tfn.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.RIP);
      AppMethodBeat.o(114788);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label914;
      }
    }
    label914:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RLe) + g.a.a.b.b.a.p(3, this.TaE);
      paramInt = i;
      if (this.Tfo != null) {
        paramInt = i + g.a.a.a.oD(4, this.Tfo.computeSize());
      }
      i = paramInt;
      if (this.Tfm != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Tfm);
      }
      i += g.a.a.b.b.a.bM(6, this.Tfp);
      paramInt = i;
      if (this.Tfn != null) {
        paramInt = i + g.a.a.a.oD(7, this.Tfn.computeSize());
      }
      i = g.a.a.a.c(8, 8, this.RIP);
      AppMethodBeat.o(114788);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RIP.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114788);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114788);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bvh localbvh = (bvh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114788);
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
            localbvh.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114788);
          return 0;
        case 2: 
          localbvh.RLe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114788);
          return 0;
        case 3: 
          localbvh.TaE = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(114788);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new db();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((db)localObject2).parseFrom((byte[])localObject1);
            }
            localbvh.Tfo = ((db)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114788);
          return 0;
        case 5: 
          localbvh.Tfm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114788);
          return 0;
        case 6: 
          localbvh.Tfp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114788);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new rq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((rq)localObject2).parseFrom((byte[])localObject1);
            }
            localbvh.Tfn = ((rq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114788);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new db();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((db)localObject2).parseFrom((byte[])localObject1);
          }
          localbvh.RIP.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(114788);
        return 0;
      }
      AppMethodBeat.o(114788);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvh
 * JD-Core Version:    0.7.0.1
 */