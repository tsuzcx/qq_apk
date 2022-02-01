package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bwe
  extends dyy
{
  public LinkedList<cld> TfY;
  public clf TfZ;
  public LinkedList<Integer> Tga;
  public int status;
  
  public bwe()
  {
    AppMethodBeat.i(214060);
    this.TfY = new LinkedList();
    this.Tga = new LinkedList();
    AppMethodBeat.o(214060);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214061);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.TfY);
      paramVarArgs.aY(3, this.status);
      if (this.TfZ != null)
      {
        paramVarArgs.oE(4, this.TfZ.computeSize());
        this.TfZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 2, this.Tga);
      AppMethodBeat.o(214061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label643;
      }
    }
    label643:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.TfY) + g.a.a.b.b.a.bM(3, this.status);
      paramInt = i;
      if (this.TfZ != null) {
        paramInt = i + g.a.a.a.oD(4, this.TfZ.computeSize());
      }
      i = g.a.a.a.c(5, 2, this.Tga);
      AppMethodBeat.o(214061);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TfY.clear();
        this.Tga.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(214061);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwe localbwe = (bwe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(214061);
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
            localbwe.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(214061);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cld();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cld)localObject2).parseFrom((byte[])localObject1);
            }
            localbwe.TfY.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(214061);
          return 0;
        case 3: 
          localbwe.status = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(214061);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new clf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((clf)localObject2).parseFrom((byte[])localObject1);
            }
            localbwe.TfZ = ((clf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(214061);
          return 0;
        }
        localbwe.Tga.add(Integer.valueOf(((g.a.a.a.a)localObject1).abFh.AK()));
        AppMethodBeat.o(214061);
        return 0;
      }
      AppMethodBeat.o(214061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwe
 * JD-Core Version:    0.7.0.1
 */