package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fdu
  extends dyy
{
  public long Svv;
  public int UDA;
  public int UDB;
  public com.tencent.mm.cd.b UDC;
  public int UDy;
  public int UDz;
  public long Urf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125510);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125510);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.Urf);
      paramVarArgs.bm(3, this.Svv);
      paramVarArgs.aY(4, this.UDy);
      paramVarArgs.aY(5, this.UDz);
      paramVarArgs.aY(6, this.UDA);
      paramVarArgs.aY(7, this.UDB);
      if (this.UDC != null) {
        paramVarArgs.c(8, this.UDC);
      }
      AppMethodBeat.o(125510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label656;
      }
    }
    label656:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.Urf) + g.a.a.b.b.a.p(3, this.Svv) + g.a.a.b.b.a.bM(4, this.UDy) + g.a.a.b.b.a.bM(5, this.UDz) + g.a.a.b.b.a.bM(6, this.UDA) + g.a.a.b.b.a.bM(7, this.UDB);
      paramInt = i;
      if (this.UDC != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.UDC);
      }
      AppMethodBeat.o(125510);
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
          AppMethodBeat.o(125510);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fdu localfdu = (fdu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125510);
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
            localfdu.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(125510);
          return 0;
        case 2: 
          localfdu.Urf = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(125510);
          return 0;
        case 3: 
          localfdu.Svv = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(125510);
          return 0;
        case 4: 
          localfdu.UDy = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125510);
          return 0;
        case 5: 
          localfdu.UDz = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125510);
          return 0;
        case 6: 
          localfdu.UDA = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125510);
          return 0;
        case 7: 
          localfdu.UDB = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125510);
          return 0;
        }
        localfdu.UDC = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(125510);
        return 0;
      }
      AppMethodBeat.o(125510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdu
 * JD-Core Version:    0.7.0.1
 */