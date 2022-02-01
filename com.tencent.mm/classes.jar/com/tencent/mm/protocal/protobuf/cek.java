package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cek
  extends dyy
{
  public eyw SrP;
  public com.tencent.mm.cd.b TlY;
  public LinkedList<eyu> TlZ;
  public int Tma;
  
  public cek()
  {
    AppMethodBeat.i(74662);
    this.TlZ = new LinkedList();
    AppMethodBeat.o(74662);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74663);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(74663);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SrP != null)
      {
        paramVarArgs.oE(2, this.SrP.computeSize());
        this.SrP.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.TlZ);
      if (this.TlY != null) {
        paramVarArgs.c(4, this.TlY);
      }
      paramVarArgs.aY(5, this.Tma);
      AppMethodBeat.o(74663);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label692;
      }
    }
    label692:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SrP != null) {
        i = paramInt + g.a.a.a.oD(2, this.SrP.computeSize());
      }
      i += g.a.a.a.c(3, 8, this.TlZ);
      paramInt = i;
      if (this.TlY != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.TlY);
      }
      i = g.a.a.b.b.a.bM(5, this.Tma);
      AppMethodBeat.o(74663);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TlZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(74663);
          throw paramVarArgs;
        }
        AppMethodBeat.o(74663);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cek localcek = (cek)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74663);
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
            localcek.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(74663);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eyw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eyw)localObject2).parseFrom((byte[])localObject1);
            }
            localcek.SrP = ((eyw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(74663);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eyu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eyu)localObject2).parseFrom((byte[])localObject1);
            }
            localcek.TlZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(74663);
          return 0;
        case 4: 
          localcek.TlY = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(74663);
          return 0;
        }
        localcek.Tma = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(74663);
        return 0;
      }
      AppMethodBeat.o(74663);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cek
 * JD-Core Version:    0.7.0.1
 */