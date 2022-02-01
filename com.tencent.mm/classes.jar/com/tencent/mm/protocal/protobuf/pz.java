package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class pz
  extends dyy
{
  public dkf RYj;
  public fi RYk;
  public px RYl;
  public dos RYm;
  public fba RYn;
  public dr RYo;
  public dum RYp;
  public cxe RYq;
  public ob RYr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124461);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124461);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.RYj != null)
      {
        paramVarArgs.oE(2, this.RYj.computeSize());
        this.RYj.writeFields(paramVarArgs);
      }
      if (this.RYk != null)
      {
        paramVarArgs.oE(3, this.RYk.computeSize());
        this.RYk.writeFields(paramVarArgs);
      }
      if (this.RYl != null)
      {
        paramVarArgs.oE(4, this.RYl.computeSize());
        this.RYl.writeFields(paramVarArgs);
      }
      if (this.RYm != null)
      {
        paramVarArgs.oE(5, this.RYm.computeSize());
        this.RYm.writeFields(paramVarArgs);
      }
      if (this.RYn != null)
      {
        paramVarArgs.oE(6, this.RYn.computeSize());
        this.RYn.writeFields(paramVarArgs);
      }
      if (this.RYo != null)
      {
        paramVarArgs.oE(7, this.RYo.computeSize());
        this.RYo.writeFields(paramVarArgs);
      }
      if (this.RYp != null)
      {
        paramVarArgs.oE(8, this.RYp.computeSize());
        this.RYp.writeFields(paramVarArgs);
      }
      if (this.RYq != null)
      {
        paramVarArgs.oE(9, this.RYq.computeSize());
        this.RYq.writeFields(paramVarArgs);
      }
      if (this.RYr != null)
      {
        paramVarArgs.oE(10, this.RYr.computeSize());
        this.RYr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124461);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1534;
      }
    }
    label1534:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RYj != null) {
        paramInt = i + g.a.a.a.oD(2, this.RYj.computeSize());
      }
      i = paramInt;
      if (this.RYk != null) {
        i = paramInt + g.a.a.a.oD(3, this.RYk.computeSize());
      }
      paramInt = i;
      if (this.RYl != null) {
        paramInt = i + g.a.a.a.oD(4, this.RYl.computeSize());
      }
      i = paramInt;
      if (this.RYm != null) {
        i = paramInt + g.a.a.a.oD(5, this.RYm.computeSize());
      }
      paramInt = i;
      if (this.RYn != null) {
        paramInt = i + g.a.a.a.oD(6, this.RYn.computeSize());
      }
      i = paramInt;
      if (this.RYo != null) {
        i = paramInt + g.a.a.a.oD(7, this.RYo.computeSize());
      }
      paramInt = i;
      if (this.RYp != null) {
        paramInt = i + g.a.a.a.oD(8, this.RYp.computeSize());
      }
      i = paramInt;
      if (this.RYq != null) {
        i = paramInt + g.a.a.a.oD(9, this.RYq.computeSize());
      }
      paramInt = i;
      if (this.RYr != null) {
        paramInt = i + g.a.a.a.oD(10, this.RYr.computeSize());
      }
      AppMethodBeat.o(124461);
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
          AppMethodBeat.o(124461);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124461);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        pz localpz = (pz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124461);
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
            localpz.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dkf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dkf)localObject2).parseFrom((byte[])localObject1);
            }
            localpz.RYj = ((dkf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fi)localObject2).parseFrom((byte[])localObject1);
            }
            localpz.RYk = ((fi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new px();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((px)localObject2).parseFrom((byte[])localObject1);
            }
            localpz.RYl = ((px)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dos();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dos)localObject2).parseFrom((byte[])localObject1);
            }
            localpz.RYm = ((dos)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fba();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fba)localObject2).parseFrom((byte[])localObject1);
            }
            localpz.RYn = ((fba)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dr)localObject2).parseFrom((byte[])localObject1);
            }
            localpz.RYo = ((dr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dum();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dum)localObject2).parseFrom((byte[])localObject1);
            }
            localpz.RYp = ((dum)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cxe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cxe)localObject2).parseFrom((byte[])localObject1);
            }
            localpz.RYq = ((cxe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ob();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ob)localObject2).parseFrom((byte[])localObject1);
          }
          localpz.RYr = ((ob)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124461);
        return 0;
      }
      AppMethodBeat.o(124461);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pz
 * JD-Core Version:    0.7.0.1
 */