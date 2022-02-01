package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class zq
  extends dyy
{
  public int RYL;
  public com.tencent.mm.cd.b SlV;
  public com.tencent.mm.cd.b SlW;
  public com.tencent.mm.cd.b SlX;
  public com.tencent.mm.cd.b SlY;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188129);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(188129);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SlV != null) {
        paramVarArgs.c(2, this.SlV);
      }
      if (this.SlW != null) {
        paramVarArgs.c(3, this.SlW);
      }
      if (this.SlX != null) {
        paramVarArgs.c(4, this.SlX);
      }
      paramVarArgs.aY(5, this.version);
      paramVarArgs.aY(6, this.RYL);
      if (this.SlY != null) {
        paramVarArgs.c(7, this.SlY);
      }
      AppMethodBeat.o(188129);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label668;
      }
    }
    label668:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SlV != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.SlV);
      }
      i = paramInt;
      if (this.SlW != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.SlW);
      }
      paramInt = i;
      if (this.SlX != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.SlX);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.version) + g.a.a.b.b.a.bM(6, this.RYL);
      paramInt = i;
      if (this.SlY != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.SlY);
      }
      AppMethodBeat.o(188129);
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(188129);
          throw paramVarArgs;
        }
        AppMethodBeat.o(188129);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        zq localzq = (zq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(188129);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localzq.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(188129);
          return 0;
        case 2: 
          localzq.SlV = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(188129);
          return 0;
        case 3: 
          localzq.SlW = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(188129);
          return 0;
        case 4: 
          localzq.SlX = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(188129);
          return 0;
        case 5: 
          localzq.version = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(188129);
          return 0;
        case 6: 
          localzq.RYL = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(188129);
          return 0;
        }
        localzq.SlY = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(188129);
        return 0;
      }
      AppMethodBeat.o(188129);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zq
 * JD-Core Version:    0.7.0.1
 */