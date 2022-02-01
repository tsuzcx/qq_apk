package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class flf
  extends dyy
{
  public int Sat;
  public String Tkw;
  public int UKc;
  public dtw UKd;
  public dtu UKe;
  public int UKf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117949);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.UKc);
      paramVarArgs.aY(3, this.Sat);
      if (this.Tkw != null) {
        paramVarArgs.f(4, this.Tkw);
      }
      if (this.UKd != null)
      {
        paramVarArgs.oE(5, this.UKd.computeSize());
        this.UKd.writeFields(paramVarArgs);
      }
      if (this.UKe != null)
      {
        paramVarArgs.oE(6, this.UKe.computeSize());
        this.UKe.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.UKf);
      AppMethodBeat.o(117949);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label748;
      }
    }
    label748:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.UKc) + g.a.a.b.b.a.bM(3, this.Sat);
      paramInt = i;
      if (this.Tkw != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tkw);
      }
      i = paramInt;
      if (this.UKd != null) {
        i = paramInt + g.a.a.a.oD(5, this.UKd.computeSize());
      }
      paramInt = i;
      if (this.UKe != null) {
        paramInt = i + g.a.a.a.oD(6, this.UKe.computeSize());
      }
      i = g.a.a.b.b.a.bM(7, this.UKf);
      AppMethodBeat.o(117949);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117949);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        flf localflf = (flf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117949);
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
            localflf.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        case 2: 
          localflf.UKc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117949);
          return 0;
        case 3: 
          localflf.Sat = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117949);
          return 0;
        case 4: 
          localflf.Tkw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117949);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtw)localObject2).parseFrom((byte[])localObject1);
            }
            localflf.UKd = ((dtw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtu)localObject2).parseFrom((byte[])localObject1);
            }
            localflf.UKe = ((dtu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        }
        localflf.UKf = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117949);
        return 0;
      }
      AppMethodBeat.o(117949);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flf
 * JD-Core Version:    0.7.0.1
 */